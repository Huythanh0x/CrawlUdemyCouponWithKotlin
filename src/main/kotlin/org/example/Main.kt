package org.example

import com.google.gson.GsonBuilder
import org.example.crawler.EnextCrawler
import org.example.helper.LocalJsonHelper
import org.json.JSONArray
import java.io.FileWriter

fun main() {
    val couponJsonArray = JSONArray()
    for (couponUrl in EnextCrawler().getAllCouponUrl()) {
        println(couponUrl)
        val couponCodeData = UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData()
        couponJsonArray.put(couponCodeData)
    }
    LocalJsonHelper.dumpJsonToFile(couponJsonArray)


}
