package org.example.retrofit

import org.example.data.CouponResponseData
import retrofit2.Call
import retrofit2.http.GET

interface CouponApi {
    @GET("/api-2.0/course-landing-components/3655198/me/?couponCode=QSBEGINFEB23&components=deal_badge,discount_expiration,gift_this_course,price_text,purchase,recommendation,redeem_coupon,cacheable_deal_badge,cacheable_discount_expiration,cacheable_price_text,cacheable_buy_button,buy_button,buy_for_team,cacheable_purchase_text,cacheable_add_to_cart,money_back_guarantee,instructor_links,incentives_context,top_companies_notice_context,curated_for_ufb_notice_context,sidebar_container,purchase_tabs_context,subscribe_team_modal_context,lifetime_access_context,available_coupons")
    fun getData(): Call<CouponResponseData>
}