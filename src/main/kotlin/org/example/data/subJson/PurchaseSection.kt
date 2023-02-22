package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class PurchaseSection (

  @SerializedName("is_course_paid"             ) var isCoursePaid             : Boolean? = null,
  @SerializedName("has_subscription_offerings" ) var hasSubscriptionOfferings : Boolean? = null,
  @SerializedName("subscription"               ) var subscription             : String?  = null,
  @SerializedName("style_full_lifetime_access" ) var styleFullLifetimeAccess  : String?  = null,
  @SerializedName("style_money_back_guarantee" ) var styleMoneyBackGuarantee  : String?  = null,
  @SerializedName("showCancelAnytime"          ) var showCancelAnytime        : Boolean? = null

)