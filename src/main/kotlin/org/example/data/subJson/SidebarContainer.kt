package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.ComponentProps


data class SidebarContainer (

  @SerializedName("componentProps" ) var componentProps : ComponentProps? = ComponentProps()

)