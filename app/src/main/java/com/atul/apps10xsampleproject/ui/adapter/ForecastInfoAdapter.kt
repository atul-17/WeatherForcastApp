package com.atul.apps10xsampleproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atul.apps10xsampleproject.data.ModelWeekyForecastData
import com.atul.apps10xsampleproject.data.response.ModelForecastList
import com.atul.apps10xsampleproject.databinding.WeatherForecastAdapterLayoutBinding
import java.math.RoundingMode
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ForecastInfoAdapter(val forecastDataList: ArrayList<ModelWeekyForecastData>) : RecyclerView.Adapter<ForecastInfoAdapter.DataViewHolder>() {
    class DataViewHolder(val binding: WeatherForecastAdapterLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(forecastData: ModelWeekyForecastData) {
            binding.apply {

                    binding.tvWeekdayName.text = forecastData.dayofTheWeek
                    val df = DecimalFormat("#.#")
                    df.roundingMode = RoundingMode.FLOOR
                    var temp = df.format((forecastData.temp.toFloat().minus(273.15))).toDouble()
                    binding.tvWeekdayTemp.text = temp.toString()

            }
        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = WeatherForecastAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.bind(forecastDataList[position])
    }

    override fun getItemCount(): Int {
        if(forecastDataList.size>4) {
            return 4
        }
        return forecastDataList.size
    }

}