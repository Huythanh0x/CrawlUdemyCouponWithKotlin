package org.example.data.subJson

import com.google.gson.annotations.SerializedName


data class CuratedForUfbNoticeContext (

  @SerializedName("noticeContext" ) var noticeContext : NoticeContext? = NoticeContext()

)