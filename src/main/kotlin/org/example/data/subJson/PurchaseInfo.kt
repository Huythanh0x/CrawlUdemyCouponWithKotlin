package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class PurchaseInfo (

  @SerializedName("isValidStudent" ) var isValidStudent : Boolean? = null,
  @SerializedName("purchaseDate"   ) var purchaseDate   : String?  = null

)