package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class Button (

  @SerializedName("add_to_cart_redirect_url" ) var addToCartRedirectUrl : String?      = null,
  @SerializedName("replace_with_add_to_cart" ) var replaceWithAddToCart : Boolean?     = null,
  @SerializedName("base_express_checkout"    ) var baseExpressCheckout  : String?      = null,
  @SerializedName("enrollment_disabled"      ) var enrollmentDisabled   : Boolean?     = null,
  @SerializedName("event_type"               ) var eventType            : String?      = null,
  @SerializedName("icon"                     ) var icon                 : String?      = null,
  @SerializedName("is_free_with_discount"    ) var isFreeWithDiscount   : Boolean?     = null,
  @SerializedName("require_popup"            ) var requirePopup         : Boolean?     = null,
  @SerializedName("text"                     ) var text                 : String?      = null,
  @SerializedName("buy_url"                  ) var buyUrl               : String?      = null,
  @SerializedName("preview_url"              ) var previewUrl           : String?      = null,
  @SerializedName("payment_data"             ) var paymentData          : PaymentData? = PaymentData(),
  @SerializedName("size"                     ) var size                 : String?      = null,
  @SerializedName("style"                    ) var style                : String?      = null,
  @SerializedName("is_paid"                  ) var isPaid               : Boolean?     = null,
  @SerializedName("is_enabled"               ) var isEnabled            : Boolean?     = null

)