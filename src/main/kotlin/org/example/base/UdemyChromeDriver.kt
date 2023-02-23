package org.example.base

import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

open class UdemyChromeDriver() : ChromeDriver() {
    init {
        val options = ChromeOptions()
        System.getProperty("webdriver.chrome.driver", "/usr/bin/chromedriver")
        options.setCapability("webdriver.chrome.redirect_to_login", false)
    }

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