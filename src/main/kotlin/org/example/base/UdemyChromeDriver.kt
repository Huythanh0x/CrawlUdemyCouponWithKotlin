package org.example.base

import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

open class UdemyChromeDriver(chromeOptions: ChromeOptions) : ChromeDriver(chromeOptions) {
    fun openWebPage(url: String) {
        super.get(url)
    }

    fun getObjectJsonFromDriver(): JSONObject {
        val jsonContent = super.findElement(By.tagName("pre")).text
        return JSONObject(jsonContent)
    }

    fun getJsonArrayFromDriver(): JSONArray {
        val jsonContent = super.findElement(By.tagName("pre")).text
        return JSONArray(jsonContent)
    }
}