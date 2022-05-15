package com.atul.apps10xsampleproject.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


 data class ModelForecastData  (

  @SerializedName("cod"     ) var cod     : String?         = null,
  @SerializedName("message" ) var message : Int?            = null,
  @SerializedName("cnt"     ) var cnt     : Int?            = null,
  @SerializedName("list"    ) var list    : ArrayList<ModelForecastList> = arrayListOf(),
  @SerializedName("city"    ) var city    : ModelForecastCity?           = ModelForecastCity()

)