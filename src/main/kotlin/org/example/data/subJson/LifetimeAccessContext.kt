package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class LifetimeAccessContext (

  @SerializedName("hasLifetimeAccess" ) var hasLifetimeAccess : Boolean? = null

)