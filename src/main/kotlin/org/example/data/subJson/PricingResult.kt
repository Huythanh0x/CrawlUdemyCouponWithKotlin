package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.Buyable
import org.example.data.subJson.Campaign
import org.example.data.subJson.Price


data class PricingResult (

    @SerializedName("price_serve_tracking_id"      ) var priceServeTrackingId      : String?      = null,
    @SerializedName("price"                        ) var price                     : Price?       = Price(),
    @SerializedName("list_price"                   ) var listPrice                 : ListPrice?   = ListPrice(),
    @SerializedName("saving_price"                 ) var savingPrice               : SavingPrice? = SavingPrice(),
    @SerializedName("has_discount_saving"          ) var hasDiscountSaving         : Boolean?     = null,
    @SerializedName("discount_percent"             ) var discountPercent           : Int?         = null,
    @SerializedName("discount_percent_for_display" ) var discountPercentForDisplay : Int?         = null,
    @SerializedName("buyable"                      ) var buyable                   : Buyable?     = Buyable(),
    @SerializedName("campaign"                     ) var campaign                  : Campaign?    = Campaign(),
    @SerializedName("code"                         ) var code                      : String?      = null,
    @SerializedName("is_public"                    ) var isPublic                  : Boolean?     = null

)