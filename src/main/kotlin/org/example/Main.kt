package org.example

import org.example.helper.RemoteJsonHelper
import java.io.File


fun fetchFromENext() {
    val outputFile = File("output_json.txt")
    val url = "https://jobs.e-next.in/public/assets/data/udemy.json"
    val jsonArray = RemoteJsonHelper.getJsonArrayFrom(url)
    for (jsonObject in jsonArray) {
        println(jsonObject)
    }
    outputFile.writeText(jsonArray.joinToString("\n"))
}

fun main() {
//    fetchFromENext()
    println(UdemyCouponCourseExtractor("https://www.udemy.com/course/introduction-to-drinking-water-treatment/?couponCode=30EF8EDB986A1BFCFD07").getFullCouponCodeData())
}