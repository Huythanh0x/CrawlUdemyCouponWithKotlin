package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class Campaign (

  @SerializedName("code"                  ) var code                : String?  = null,
  @SerializedName("end_time"              ) var endTime             : String?  = null,
  @SerializedName("is_instructor_created" ) var isInstructorCreated : Boolean? = null,
  @SerializedName("is_public"             ) var isPublic            : Boolean? = null,
  @SerializedName("start_time"            ) var startTime           : String?  = null,
  @SerializedName("campaign_type"         ) var campaignType        : String?  = null,
  @SerializedName("uses_remaining"        ) var usesRemaining       : String?  = null,
  @SerializedName("maximum_uses"          ) var maximumUses         : String?  = null,
  @SerializedName("show_code"             ) var showCode            : Boolean? = null

)