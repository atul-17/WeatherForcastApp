package com.atul.apps10xsampleproject.data.retrofit_response

import com.google.gson.annotations.SerializedName


data class ModelForecastDataEntity  (

  @SerializedName("cod"     ) var cod     : String?         = null,
  @SerializedName("message" ) var message : Int?            = null,
  @SerializedName("cnt"     ) var cnt     : Int?            = null,
  @SerializedName("list"    ) var list    : ArrayList<ModelForecastList> = arrayListOf(),
  @SerializedName("city"    ) var city    : ModelForecastCity?           = ModelForecastCity()

)