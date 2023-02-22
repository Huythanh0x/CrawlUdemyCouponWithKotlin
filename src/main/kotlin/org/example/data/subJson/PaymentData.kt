package org.example.data.subJson

import org.example.data.subJson.PurchasePrice
import com.google.gson.annotations.SerializedName


data class PaymentData (

    @SerializedName("buyableId"     ) var buyableId     : Int?           = null,
    @SerializedName("buyableType"   ) var buyableType   : String?        = null,
    @SerializedName("discountInfo"  ) var discountInfo  : DiscountInfo?  = DiscountInfo(),
    @SerializedName("purchasePrice" ) var purchasePrice : PurchasePrice? = PurchasePrice()

)