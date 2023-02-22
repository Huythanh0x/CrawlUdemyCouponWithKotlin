package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class BuyForTeam (

  @SerializedName("data" ) var data : Data? = Data()

)