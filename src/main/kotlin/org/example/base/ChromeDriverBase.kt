package org.example.base

import org.json.JSONArray
import org.json.JSONObject
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

abstract class ChromeDriverBase {
    init {
        val options = ChromeOptions()
        System.getProperty("webdriver.chrome.driver", "/usr/bin/chromedriver")
        options.setCapability("webdriver.chrome.redirect_to_login", false)
    }

    protected val driver = ChromeDriver()

    fun quit() {
        driver.quit()
    }

    fun openWebPage(url: String) {
        driver.get(url)
    }

    fun getObjectJsonFromDriver(): JSONObject {
        val jsonContent = driver.findElement(By.tagName("pre")).text
        return JSONObject(jsonContent)
    }

    fun getJsonArrayFromDriver(): JSONArray {
        val jsonContent = driver.findElement(By.tagName("pre")).text
        return JSONArray(jsonContent)
    }
}