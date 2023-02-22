package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class GiftThisCourse (

  @SerializedName("gift_this_course_link" ) var giftThisCourseLink : String? = null,
  @SerializedName("round"                 ) var round              : String? = null

)