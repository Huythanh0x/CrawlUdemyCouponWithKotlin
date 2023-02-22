package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class PurchasePrice (

  @SerializedName("amount"          ) var amount         : Int?    = null,
  @SerializedName("currency"        ) var currency       : String? = null,
  @SerializedName("price_string"    ) var priceString    : String? = null,
  @SerializedName("currency_symbol" ) var currencySymbol : String? = null

)