package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class AddToCart (

  @SerializedName("buyables"           ) var buyables           : ArrayList<Buyables> = arrayListOf(),
  @SerializedName("onAddRedirectUrl"   ) var onAddRedirectUrl   : String?             = null,
  @SerializedName("addedButtonBsStyle" ) var addedButtonBsStyle : String?             = null,
  @SerializedName("is_enabled"         ) var isEnabled          : Boolean?            = null

)