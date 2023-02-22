package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("image_240x135" ) var image240x135 : String? = null,
  @SerializedName("image_480x270" ) var image480x270 : String? = null,
  @SerializedName("image_750x422" ) var image750x422 : String? = null

)