package org.example

import org.example.crawler.EnextCrawler
import org.example.helper.LocalJsonHelper
import org.json.JSONArray
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

fun saveAllCouponData(allCouponUrls: List<String>, numberOfThread: Int = 40) {
    val couponJsonArray = JSONArray()
    val executor: ThreadPoolExecutor = Executors.newFixedThreadPool(numberOfThread) as ThreadPoolExecutor

    allCouponUrls.forEach { couponUrl ->
        // submit a new thread to the executor
        executor.submit {
            val couponCodeData = UdemyCouponCourseExtractor(couponUrl).getFullCouponCodeData()
            couponJsonArray.put(couponCodeData)
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

fun main() {
    val start = System.currentTimeMillis()
    val allCouponUrls = EnextCrawler().getAllCouponUrl()
    saveAllCouponData(allCouponUrls)
    val end = System.currentTimeMillis()
    println("Total time taken: ${end - start} ms")

}
