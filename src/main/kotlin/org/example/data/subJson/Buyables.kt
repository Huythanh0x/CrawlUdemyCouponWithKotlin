package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class Buyables (

  @SerializedName("buyable_object_type" ) var buyableObjectType : String? = null,
  @SerializedName("id"                  ) var id                : Int?    = null

)