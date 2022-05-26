package com.atul.apps10xsampleproject.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.atul.apps10xsampleproject.data.ModelWeekyForecastData
import com.atul.apps10xsampleproject.data.retrofit_response.CurrentTempApiEntity
import com.atul.apps10xsampleproject.data.retrofit_response.ModelForecastList
import com.atul.apps10xsampleproject.databinding.WeatherInfoDetailsFragmentLayoutBinding
import com.atul.apps10xsampleproject.ui.adapter.ForecastInfoAdapter
import java.math.RoundingMode
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeatherInfoDetailsFragment : Fragment() {

//    private lateinit var weatherInfoDetailsFragmentLayoutBinding: WeatherInfoDetailsFragmentLayoutBinding
//
//    lateinit var forecastInfoAdapter: ForecastInfoAdapter
//
//    var currentTempApiModel = CurrentTempApiEntity()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        weatherInfoDetailsFragmentLayoutBinding =
//            WeatherInfoDetailsFragmentLayoutBinding.inflate(layoutInflater)
//        currentTempApiModel = arguments?.getSerializable("weatherInfoData") as CurrentTempApiEntity
//        return weatherInfoDetailsFragmentLayoutBinding.root
//    }
//
//    override fun onStart() {
//        super.onStart()
//        setWeatherInfoData(currentTempApiModel)
//    }
//
//
//    fun compareDatesAndToList(list : ArrayList<ModelForecastList>){
//        var forecastData : ArrayList<ModelWeekyForecastData> = ArrayList()
//        var weeklyForecastMap : HashMap<String?, ArrayList<String>> = HashMap()
//
//        for(i in 0 until list.size){
//            if(weeklyForecastMap.containsKey(getDayOfWeek(list[i].dtTxt))){
//                var tempList = weeklyForecastMap.getValue(getDayOfWeek(list[i].dtTxt))
//                tempList.add(list[i].main?.temp.toString())
//                weeklyForecastMap.put(getDayOfWeek(list[i].dtTxt),tempList)
//            }else{
//                var tempList = ArrayList<String>()
//                tempList.add(list[i].main?.temp.toString())
//                weeklyForecastMap.put(getDayOfWeek(list[i].dtTxt),tempList)
//            }
//        }
//        Log.d("forecastData:",weeklyForecastMap.toString())
//
//        setupForecastData(weeklyForecastMap)
//    }
//
//    fun getDayOfWeek(date:String?) : String{
//        val inputDate = date
//        val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//        val dt1 = format1.parse(inputDate)
//        val format2: DateFormat = SimpleDateFormat("EEEE")
//        return  format2.format(dt1)
//    }
//
//
//     fun calculateWeeklyAvgTemp(avgTempList : ArrayList<String>) : Double{
//        var temp = 0.0
//        for(i in avgTempList.indices){
//            temp+=avgTempList[i].toDouble()
//        }
//        temp = (temp.toFloat()).div(avgTempList.size).toDouble()
//        return temp
//    }
//
//     fun setupForecastData(map: HashMap<String?, ArrayList<String>>){
//        var forecastDataList = ArrayList<ModelWeekyForecastData>()
//
//        val itr = map.keys.iterator()
//        while (itr.hasNext()) {
//            val key = itr.next()
//            val avgTemp = calculateWeeklyAvgTemp(map.getValue(key))
//            var id = 0
//            when(key){
//                "Sunday"->{
//                    id = 0
//                }
//                "Monday"->{
//                    id = 1
//                }
//                "Tuesday"->{
//                    id = 2
//                }
//                "Wednesday" ->{
//                    id = 3
//                }
//                "Thursday"->{
//                    id = 4
//                }
//                "Friday" ->{
//                    id = 5
//                }
//                "Saturday"->{
//                    id = 6
//                }
//            }
//            forecastDataList.add(ModelWeekyForecastData(id,key,avgTemp.toString()))
//        }
//        forecastDataList.sortBy { it.id }
//
//         setForecastData(removeCurrentDaysForecast(forecastDataList))
//    }
//
//
//    private fun removeCurrentDaysForecast(forecastDataList: ArrayList<ModelWeekyForecastData>) : ArrayList<ModelWeekyForecastData>{
//        for (modelForecastData in forecastDataList){
//            if (getCurrentDay()==modelForecastData.dayofTheWeek){
//                forecastDataList.remove(modelForecastData)
//                break
//            }
//        }
//        return forecastDataList
//    }
//    private fun getCurrentDay() : String{
//        val calendar = Calendar.getInstance()
//        val currentDate: Date = calendar.getTime()
//        val format2: DateFormat = SimpleDateFormat("EEEE")
//        return format2.format(currentDate)
//    }
//
//     fun setForecastData(modelForecastData: ArrayList<ModelWeekyForecastData>){
//
//        weatherInfoDetailsFragmentLayoutBinding.forecastRecyclerView.layoutManager = LinearLayoutManager(activity)
//
//        forecastInfoAdapter = ForecastInfoAdapter(modelForecastData)
//        weatherInfoDetailsFragmentLayoutBinding.forecastRecyclerView.addItemDecoration(
//            DividerItemDecoration(
//                weatherInfoDetailsFragmentLayoutBinding.forecastRecyclerView.context,
//                ( weatherInfoDetailsFragmentLayoutBinding.forecastRecyclerView.layoutManager as LinearLayoutManager).orientation)
//        )
//
//        weatherInfoDetailsFragmentLayoutBinding.forecastRecyclerView.adapter = forecastInfoAdapter
//
//    }
//
//     fun setWeatherInfoData(currentTempApiModel: CurrentTempApiEntity){
//        weatherInfoDetailsFragmentLayoutBinding.tvCurrentLocal.text = currentTempApiModel.name
//        val df = DecimalFormat("#.#")
//        df.roundingMode = RoundingMode.FLOOR
//        var temp = df.format((currentTempApiModel.main?.temp?.toFloat()?.minus(273.15))).toDouble()
//        weatherInfoDetailsFragmentLayoutBinding.tvCurrentTemp.text = temp.toString()
//    }
}