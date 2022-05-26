package com.atul.apps10xsampleproject.data.retrofit_response

import com.google.gson.annotations.SerializedName


data class ModelForecastWeather (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("main"        ) var main        : String? = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("icon"        ) var icon        : String? = null

)