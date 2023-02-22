package org.example.data.subJson

import com.google.gson.annotations.SerializedName
import org.example.data.subJson.Images


data class IntroductionAsset (

  @SerializedName("has_video_asset"     ) var hasVideoAsset     : Boolean? = null,
  @SerializedName("course_preview_path" ) var coursePreviewPath : String?  = null,
  @SerializedName("images"              ) var images            : Images?  = Images()

)