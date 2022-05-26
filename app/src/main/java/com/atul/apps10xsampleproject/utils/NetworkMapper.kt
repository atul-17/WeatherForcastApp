package com.atul.apps10xsampleproject.utils

import android.util.Log
import com.atul.apps10xsampleproject.data.ModelWeekyForecastData
import com.atul.apps10xsampleproject.data.retrofit_response.CurrentTempApiEntity
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastDataEntity
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastList
import java.text.DateFormat
import java.text.SimpleDateFormat

import javax.inject.Inject
import kotlin.collections.HashMap

//entity is retrofit data
//domain model is application data
class NetworkMapper
@Inject
constructor() : EntityMapper<ModelForecastDataEntity,ModelWeekyForecastData>{
    override fun mapFromEntity(entity: ModelForecastDataEntity):ModelWeekyForecastData? {
       var weekyForecastHashMap =  compareDatesAndToList(entity.list)
       var modelWeekyForecastData : ModelWeekyForecastData? = getWeekyForecastModelData(weekyForecastHashMap)
        return modelWeekyForecastData?.let { ModelWeekyForecastData(0,"No Data","0") }
    }


    override fun mapToDomainModel(domainModel: ModelWeekyForecastData): ModelForecastDataEntity {
//        var weekyForecastHashMap =  compareDatesAndToList(domainModel.)
//        var modelWeekyForecastData : ModelWeekyForecastData? = getWeekyForecastModelData(weekyForecastHashMap)
//        return modelWeekyForecastData?.let { ModelWeekyForecastData(0,"No Data","0") }
        return ModelForecastDataEntity()
    }

    fun mapFromEntityList(entiesList : List<ModelForecastDataEntity>) : List<ModelWeekyForecastData>{
        return entiesList.map { mapFromEntity(it)!! }

    }


    fun getWeekyForecastModelData(map: HashMap<String?, ArrayList<String>>) : ModelWeekyForecastData?{
       // var forecastDataList = ArrayList<ModelWeekyForecastData>()
        var modelWeekyForecastData : ModelWeekyForecastData?=null
        val itr = map.keys.iterator()
        while (itr.hasNext()) {
            val key = itr.next()
            val avgTemp = calculateWeeklyAvgTemp(map.getValue(key))
            var id = 0
            when(key){
                "Sunday"->{
                    id = 0
                }
                "Monday"->{
                    id = 1
                }
                "Tuesday"->{
                    id = 2
                }
                "Wednesday" ->{
                    id = 3
                }
                "Thursday"->{
                    id = 4
                }
                "Friday" ->{
                    id = 5
                }
                "Saturday"->{
                    id = 6
                }
            }
            modelWeekyForecastData = ModelWeekyForecastData(id,key,avgTemp.toString())
//            forecastDataList.add(ModelWeekyForecastData(id,key,avgTemp.toString()))
        }
        return modelWeekyForecastData
       // forecastDataList.sortBy { it.id }

    }


    fun calculateWeeklyAvgTemp(avgTempList : ArrayList<String>) : Double{
        var temp = 0.0
        for(i in avgTempList.indices){
            temp+=avgTempList[i].toDouble()
        }
        temp = (temp.toFloat()).div(avgTempList.size).toDouble()
        return temp
    }

    fun compareDatesAndToList(list : ArrayList<ModelForecastList>) : HashMap<String?,ArrayList<String>>{
        var forecastData : ArrayList<ModelWeekyForecastData> = ArrayList()
        var weeklyForecastMap : HashMap<String?, ArrayList<String>> = HashMap()

        for(i in 0 until list.size){
            if(weeklyForecastMap.containsKey(getDayOfWeek(list[i].dtTxt))){
                var tempList = weeklyForecastMap.getValue(getDayOfWeek(list[i].dtTxt))
                tempList.add(list[i].main?.temp.toString())
                weeklyForecastMap.put(getDayOfWeek(list[i].dtTxt),tempList)
            }else{
                var tempList = ArrayList<String>()
                tempList.add(list[i].main?.temp.toString())
                weeklyForecastMap.put(getDayOfWeek(list[i].dtTxt),tempList)
            }
        }
        Log.d("forecastData:",weeklyForecastMap.toString())

       // setupForecastData(weeklyForecastMap)

        return weeklyForecastMap
    }


    fun getDayOfWeek(date:String?) : String{
        val inputDate = date
        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dt1 = format1.parse(inputDate)
        val format2: DateFormat = SimpleDateFormat("EEEE")
        return  format2.format(dt1)
    }



}