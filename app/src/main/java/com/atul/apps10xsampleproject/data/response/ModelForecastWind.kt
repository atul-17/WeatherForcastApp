package com.atul.apps10xsampleproject.data.response

import com.google.gson.annotations.SerializedName


data class ModelForecastWind (

  @SerializedName("speed" ) var speed : Double? = null,
  @SerializedName("deg"   ) var deg   : Int?    = null,
  @SerializedName("gust"  ) var gust  : Double? = null

)