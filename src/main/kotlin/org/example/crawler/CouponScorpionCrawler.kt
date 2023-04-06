package org.example.crawler

import org.example.base.CouponUrlCrawlerBase
import org.example.helper.RequestHtmlHelper

class CouponScorpionCrawler : CouponUrlCrawlerBase() {
    override val baseAPIUrl: String
        get() = "https://couponscorpion.com"

    private val numberOfPage = 2
    override fun getAllCouponUrl(): List<String> {
        val allCouponUrls = mutableListOf<String>()
        for (pageIndex in 1..numberOfPage) {
            allCouponUrls.addAll(extractUrlFromHTMLPage(pageIndex))
        }
        return allCouponUrls
    }

    fun extractUrlFromHTMLPage(pageIndex: Int): MutableList<String> {
        val pageUrl = "$baseAPIUrl/page/$pageIndex"
        println(pageUrl)
        val allCouponInPage = mutableListOf<String>()
        RequestHtmlHelper.getHtmlDocument(pageUrl).select("article").forEach { article ->
            val urlToDetailPage = article.select("a").first()?.attr("href")
            urlToDetailPage?.let {
                println(it)
                extractCouponUrl(it)?.let { it1 -> allCouponInPage.add(it1) }
            }
        }
        return allCouponInPage
    }

    private fun extractCouponUrl(urlToDetailPage: String): String? {
        return RequestHtmlHelper.getHtmlDocument(urlToDetailPage).select(".right_st_postproduct").first()?.attr("href")
    }
}