package org.example.data

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.*

data class CouponResponseData(
    @SerializedName("discount_expiration") var discountExpiration: DiscountExpiration? = DiscountExpiration(),
    @SerializedName("gift_this_course") var giftThisCourse: GiftThisCourse? = GiftThisCourse(),
    @SerializedName("price_text") var priceText: PriceText? = PriceText(),
    @SerializedName("purchase") var purchase: Purchase? = Purchase(),
    @SerializedName("redeem_coupon") var redeemCoupon: RedeemCoupon? = RedeemCoupon(),
    @SerializedName("buy_button") var buyButton: BuyButton? = BuyButton(),
    @SerializedName("buy_for_team") var buyForTeam: BuyForTeam? = BuyForTeam(),
    @SerializedName("money_back_guarantee") var moneyBackGuarantee: MoneyBackGuarantee? = MoneyBackGuarantee(),
    @SerializedName("curated_for_ufb_notice_context") var curatedForUfbNoticeContext: CuratedForUfbNoticeContext? = CuratedForUfbNoticeContext(),
    @SerializedName("sidebar_container") var sidebarContainer: SidebarContainer? = SidebarContainer(),
    @SerializedName("purchase_tabs_context") var purchaseTabsContext: PurchaseTabsContext? = PurchaseTabsContext(),
    @SerializedName("lifetime_access_context") var lifetimeAccessContext: LifetimeAccessContext? = LifetimeAccessContext()
)