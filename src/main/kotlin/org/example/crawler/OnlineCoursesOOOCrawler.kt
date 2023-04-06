package org.example.crawler

import org.example.base.CouponUrlCrawlerBase
import org.example.helper.RequestHtmlHelper

class OnlineCoursesOOOCrawler : CouponUrlCrawlerBase() {
    override val baseAPIUrl: String
        get() = "https://www.onlinecourses.ooo"

    private val numberOfPage = 30
    override fun getAllCouponUrl(): List<String> {
        val allCouponUrls = mutableListOf<String>()
        for (pageIndex in 1..numberOfPage) {
            allCouponUrls.addAll(extractUrlFromHTMLPage(pageIndex))
        }
        return allCouponUrls
    }

    private fun extractUrlFromHTMLPage(pageIndex: Int): MutableList<String> {
        val pageUrl = "$baseAPIUrl/page/$pageIndex"
        val allCouponInPage = mutableListOf<String>()
        RequestHtmlHelper.getHtmlDocument(pageUrl).select(".entry-title").forEach { entryDiv ->
            val urlToDetailPage = entryDiv.select("a").first()?.attr("href")
            urlToDetailPage?.let {
                extractCouponUrl(it)?.let { couponUrl -> allCouponInPage.add(couponUrl) }
            }
        }
        return allCouponInPage
    }

    private fun extractCouponUrl(urlToDetailPage: String): String? {
        return RequestHtmlHelper.getHtmlDocument(urlToDetailPage).select(".link-holder").first()?.select("a")?.first()?.attr("href")
    }
}