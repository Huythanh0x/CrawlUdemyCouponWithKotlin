package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.Button


data class BuyButton (

  @SerializedName("button" ) var button : Button? = Button()

)