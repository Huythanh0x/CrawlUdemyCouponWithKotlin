package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.DiscountAttempts


data class RedeemCoupon (

    @SerializedName("discount_attempts"     ) var discountAttempts    : ArrayList<DiscountAttempts> = arrayListOf(),
    @SerializedName("has_already_purchased" ) var hasAlreadyPurchased : Boolean?                    = null

)