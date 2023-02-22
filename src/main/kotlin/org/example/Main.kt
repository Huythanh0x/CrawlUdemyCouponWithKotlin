package org.example

import com.google.gson.GsonBuilder
import org.example.retrofit.CouponApi
import retrofit2.Retrofit
import java.io.File


fun fetchFromENext() {
    val outputFile = File("output_json.txt")
    val url = "https://jobs.e-next.in/public/assets/data/udemy.json"
    val main = PureURLCoupon()
    main.openWebPage(url)
    val listCourseData = main.getListURLs()
    outputFile.writeText(listCourseData.joinToString("\n"))
//    Thread.sleep(1000)
    main.quit()
}

fun testValidateUdemyCoupon() {
    val sampleCouponUrl =
        "https://www.udemy.com/course/quantity-surveying-with-rate-analysis-and-take-off-beginners/?couponCode=QSBEGINFEB23"
    val couponData = UrlCouponToJson(sampleCouponUrl)
    try {
        couponData.getCouponStatus()
        couponData.getCourseStatus()
    } catch (e: Exception) {
        println(e)

    } finally {
        couponData.quit()
    }

}

fun main() {
    val retrofit = Retrofit.Builder().baseUrl("https://www.udemy.com").build()
    val myApi = retrofit.create(CouponApi::class.java)
    val call = myApi.getData()
    val response = call.execute()
    if (response.isSuccessful) {
        val myResponseData = response.body()
        print(myResponseData)
    } else {
        println("Error: ${response.code()} - ${response.message()}")
    }
}