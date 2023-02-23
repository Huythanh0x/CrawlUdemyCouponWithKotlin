package org.example.data

data class CouponCourseData(
    val courseId: Int,
    val category: String,
    val subCategory: String,
    val title: String,
    val contentLength: Int,
    val level: String,
    val author: String,
    val rating: Float,
    val reviews: Int,
    val students: Int,
    val couponCode: String,
    val previewImage: String,
    val couponUrl: String,
    val expiredDate: String,
    val usesRemaining: Int,
    val heading: String,
    val description: String,
    val previewVideo: String,
    val language: String
)