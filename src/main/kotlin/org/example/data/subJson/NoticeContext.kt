package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.UfbLinkParams


data class NoticeContext (

    @SerializedName("courseCategory" ) var courseCategory : String?        = null,
    @SerializedName("ufbLinkParams"  ) var ufbLinkParams  : UfbLinkParams? = UfbLinkParams(),
    @SerializedName("variant"        ) var variant        : String?        = null

)