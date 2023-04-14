package org.example

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.crawler.EnextCrawler
import org.example.crawler.RealDiscountCrawler
import org.example.data.CouponCourseData
import org.example.helper.LocalJsonHelper
import org.json.JSONArray
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

fun saveAllCouponData(allCouponUrls: Set<String>, numberOfThread: Int = 20) {
    val couponJsonArray = JSONArray()
    val executor: ThreadPoolExecutor = Executors.newFixedThreadPool(numberOfThread) as ThreadPoolExecutor

    allCouponUrls.forEach { couponUrl ->
        // submit a new thread to the executor
        executor.submit {
            val couponCodeData = UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData()
            couponCodeData?.let {
                couponJsonArray.put(couponCodeData)
            }
        }
    }
    // shutdown the executor once all threads are finished
    executor.shutdown()
    while (!executor.isTerminated) {
        // wait until all threads are finished
    }
    LocalJsonHelper.dumpJsonToFile(couponJsonArray)
    println("All threads finished")
}

fun filterValidCouponUrls(couponUrls: Set<String>): Set<String> {
    return couponUrls.filter { it.contains("?couponCode=")}.toSet()
}

fun countNumberOfUniqueCoupon() {
    val gson = Gson()
    val json = File("udemy_coupon.json").readText()
    val type = object : TypeToken<Map<String, List<CouponCourseData>>>() {}.type
    val coursesMap = gson.fromJson<Map<String, List<CouponCourseData>>>(json, type)
    val courseIdSet = mutableSetOf<Int>()
    for (courseList in coursesMap.values) {
        for (course in courseList) {
            courseIdSet.add(course.courseId)
        }
    }
    val numUniqueCourses = courseIdSet.size
    println("Number of unique courses: $numUniqueCourses")
}

fun main() {
    val start = System.currentTimeMillis()
    val allCouponUrls = mutableSetOf<String>()
    allCouponUrls.addAll(EnextCrawler().getAllCouponUrl())
    allCouponUrls.addAll(RealDiscountCrawler(2000).getAllCouponUrl())
//    allCouponUrls.addAll(OnlineCoursesOOOCrawler(50).getAllCouponUrl())
//    allCouponUrls.addAll(CouponScorpionCrawler().getAllCouponUrl())
    val allCouponUrlsSet = filterValidCouponUrls(allCouponUrls)
    File("udemy_coupon_urls.txt").writeText(allCouponUrlsSet.joinToString("\n"))
    saveAllCouponData(allCouponUrlsSet)
    println(allCouponUrlsSet.joinToString("\n"))
    countNumberOfUniqueCoupon()
    val end = System.currentTimeMillis()
    println("Total time taken: ${end - start} ms")
}