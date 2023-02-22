package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class UfbCopyContext (

  @SerializedName("title"   ) var title   : String? = null,
  @SerializedName("content" ) var content : String? = null

)