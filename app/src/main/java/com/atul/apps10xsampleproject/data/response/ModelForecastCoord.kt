package com.atul.apps10xsampleproject.data.response

import com.google.gson.annotations.SerializedName


data class ModelForecastCoord (

  @SerializedName("lat" ) var lat : Double? = null,
  @SerializedName("lon" ) var lon : Double? = null

)