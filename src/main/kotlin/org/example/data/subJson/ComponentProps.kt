package org.example.data.subJson

import org.example.data.subJson.PurchaseInfo
import org.example.data.subJson.PurchaseSection
import com.google.gson.annotations.SerializedName


data class ComponentProps (

    @SerializedName("addToCart"          ) var addToCart          : AddToCart?          = AddToCart(),
    @SerializedName("introductionAsset"  ) var introductionAsset  : IntroductionAsset?  = IntroductionAsset(),
    @SerializedName("purchaseSection"    ) var purchaseSection    : PurchaseSection?    = PurchaseSection(),
    @SerializedName("purchaseInfo"       ) var purchaseInfo       : PurchaseInfo?       = PurchaseInfo(),
    @SerializedName("moneyBackGuarantee" ) var moneyBackGuarantee : MoneyBackGuarantee? = MoneyBackGuarantee()

)