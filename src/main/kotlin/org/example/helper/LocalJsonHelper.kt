package org.example.helper

import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.FileWriter

class LocalJsonHelper {
    companion object {
        fun dumpJsonToFile(jsonObject: JSONArray, jsonFilePath: String = "udemy_coupon.json") {
            val gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
            val jsonString = gson.toJson(jsonObject)
            FileWriter(jsonFilePath).use { it.write(jsonString) }
        }
    }
}