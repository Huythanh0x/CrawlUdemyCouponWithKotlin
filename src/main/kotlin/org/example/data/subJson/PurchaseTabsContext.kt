package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class PurchaseTabsContext (

  @SerializedName("selectedTab"              ) var selectedTab              : String? = null,
  @SerializedName("purchaseInfo"             ) var purchaseInfo             : String? = null,
  @SerializedName("buttonText"               ) var buttonText               : String? = null,
  @SerializedName("primaryLink"              ) var primaryLink              : String? = null,
  @SerializedName("subscription"             ) var subscription             : String? = null,
  @SerializedName("selectedPurchaseOption"   ) var selectedPurchaseOption   : String? = null,
  @SerializedName("isAnnualPlanEnabled"      ) var isAnnualPlanEnabled      : String? = null,
  @SerializedName("subscriptionPlanPriceIds" ) var subscriptionPlanPriceIds : String? = null,
  @SerializedName("enableSubsCtaAuthModal"   ) var enableSubsCtaAuthModal   : String? = null

)