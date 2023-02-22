package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class Buyable (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("type" ) var type : String? = null

)