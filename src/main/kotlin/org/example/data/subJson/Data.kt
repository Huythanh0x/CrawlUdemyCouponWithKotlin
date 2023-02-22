package org.example.data.subJson

import org.example.data.subJson.UfbCopyContext
import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("ufb_demo_link"       ) var ufbDemoLink         : String?         = null,
  @SerializedName("ufb_copy_context"    ) var ufbCopyContext      : UfbCopyContext? = UfbCopyContext(),
  @SerializedName("ufb_button_copy"     ) var ufbButtonCopy       : String?         = null,
  @SerializedName("buy_for_team_ref"    ) var buyForTeamRef       : String?         = null,
  @SerializedName("is_enabled"          ) var isEnabled           : Boolean?        = null,
  @SerializedName("isOnsiteRequestDemo" ) var isOnsiteRequestDemo : Boolean?        = null

)