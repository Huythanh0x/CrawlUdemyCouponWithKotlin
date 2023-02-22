package org.example

import org.example.base.ChromeDriverBase
import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class UrlCouponToJson(private val couponUrl: String) : ChromeDriverBase() {
    private var courseId = 0
    private var couponCode = ""

    private fun findCourseId(): Int {
        driver.get(couponUrl)
        return try {
            driver.findElement(By.id("udemy")).getAttribute("data-clp-course-id").toInt()
        } catch (e: Exception) {
            driver.findElement(By.cssSelector("div[class='sidebar-container-position-manager']")).text.toInt()
        }
    }

    private fun findCouponCode(): String {
        return couponUrl.split("/?couponCode=")[1]
    }

    fun getCouponStatus() {
        courseId = findCourseId()
        couponCode = findCouponCode()
        val urlCheckStatusCoupon =
            "https://www.udemy.com/api-2.0/course-landing-components/${courseId}/me/?couponCode=${couponCode}&components=deal_badge,discount_expiration,gift_this_course,price_text,purchase,recommendation,redeem_coupon,cacheable_deal_badge,cacheable_discount_expiration,cacheable_price_text,cacheable_buy_button,buy_button,buy_for_team,cacheable_purchase_text,cacheable_add_to_cart,money_back_guarantee,instructor_links,incentives_context,top_companies_notice_context,curated_for_ufb_notice_context,sidebar_container,purchase_tabs_context,subscribe_team_modal_context,lifetime_access_context,available_coupons"
        driver.get(urlCheckStatusCoupon)
        Thread.sleep(3000)
        val couponDataResult = extractDataCouponFromJsonString(getObjectJsonFromDriver())
//        print(couponDataResult)
    }

    fun getCourseStatus(): CourseResultJsonData {
        var title = ""
        var headline = ""
        var description = ""
        var author = "Unknown"
        var category = "Unknown"
        var subCategory = ""
        var language = ""
        var level = ""
        var students = 0
        var rating = 0f
        var numberReviews = 0
        var contentLength = 0

        val urlCheckCourseStatus =
            "https://www.udemy.com/api-2.0/courses/${courseId}/?fields[course]=title,context_info,primary_category,primary_subcategory,avg_rating_recent,visible_instructors,locale,estimated_content_length,num_subscribers,num_reviews,description,headline,instructional_level"
        driver.get(urlCheckCourseStatus)
        val courseObjectJson = getObjectJsonFromDriver()
        title = courseObjectJson.getString("title")
        headline = courseObjectJson.getString("headline")
        description = courseObjectJson.getString("description")
        try {
            author = courseObjectJson.getJSONArray("visible_instructors").getJSONObject(0).getString("title")
        } catch (_: Exception) {
        }
        try {
            category = courseObjectJson.getJSONObject("primary_category").getString("title")
        } catch (e: Exception) {
        }

        try {
            subCategory = courseObjectJson.getJSONObject("primary_sub_category").getString("title")
        } catch (e: Exception) {
        }
        language = courseObjectJson.getJSONObject("locale").getString("simple_english_title")
        level = courseObjectJson.getString("instructional_level")
        students = courseObjectJson.getInt("num_subscribers")
        rating = courseObjectJson.getFloat("avg_rating_recent")
        numberReviews = courseObjectJson.getInt("num_reviews")
        contentLength = courseObjectJson.getInt("estimated_content_length")


        val resultData = CourseResultJsonData(
            category,
            subCategory,
            title,
            level,
            author,
            contentLength,
            rating,
            numberReviews,
            students,
            language,
            headline,
            description
        )
        println(resultData)
        return resultData
    }

    private fun extractDataCouponFromJsonString(jsonObject: JSONObject): CouponResultJsonData {
        var price: Float = 0f
        var expiredDate = "null"
        var previewImage = "null"
        var previewVideo = "null"
        var usesRemaining = 0

        price = jsonObject.getJSONObject("price_text").getJSONObject("data").getJSONObject("pricing_result")
            .getJSONObject("price").getFloat("amount")

        expiredDate = jsonObject.getJSONObject("price_text").getJSONObject("data").getJSONObject("pricing_result")
            .getJSONObject("campaign").getString("end_time")

        previewImage = jsonObject.getJSONObject("sidebar_container").getJSONObject("componentProps")
            .getJSONObject("introductionAsset").getJSONObject("images").getString("image_750x422")

        previewVideo = jsonObject.getJSONObject("sidebar_container").getJSONObject("componentProps")
            .getJSONObject("introductionAsset").getString("course_preview_path").toString()

        try {
            usesRemaining = jsonObject.getJSONObject("price_text").getJSONObject("data").getJSONObject("pricing_result")
                .getJSONObject("campaign").getInt("uses_remaining")
        } catch (e: Exception) {
            println("${this.javaClass.simpleName} encountered error: $e")
        }

        return CouponResultJsonData(price, expiredDate, previewImage, previewVideo, usesRemaining)
    }
}

data class CouponResultJsonData(
    val price: Float?,
    val expiredDate: String,
    val previewImage: String,
    val previewVideo: String,
    val usesRemaining: Int
)

data class CourseResultJsonData(
    val category: String,
    val subCategory: String,
    val courseTitle: String,
    val level: String,
    val author: String,
    val contentLength: Int,
    val rating: Float,
    val numberReviews: Int,
    val students: Int,
    val language: String,
    val headline: String,
    val description: String
)