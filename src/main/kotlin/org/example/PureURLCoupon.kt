package org.example

import org.example.base.ChromeDriverBase
import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.By

class PureURLCoupon : ChromeDriverBase() {
    fun getListURLs(): MutableList<String> {
        val jsonContent = driver.findElement(By.tagName("pre")).text
        val jsonArray = JSONArray(jsonContent)
        val listURLs = mutableListOf<String>()
        for (jsonObject in jsonArray) {
            if (jsonObject is JSONObject) {
                listURLs.add(jsonObject["site"].toString())
            }
        }
        return listURLs
    }
}
