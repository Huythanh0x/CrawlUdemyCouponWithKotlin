package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class DiscountAttempts (

  @SerializedName("code"    ) var code    : String? = null,
  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("details" ) var details : String? = null,
  @SerializedName("amount"  ) var amount  : String? = null

)