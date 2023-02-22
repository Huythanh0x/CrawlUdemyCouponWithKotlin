package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.Data


data class PriceText (

  @SerializedName("data" ) var data : Data? = Data()

)