package org.example.crawler

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import org.example.base.CouponUrlCrawlerBase
import org.example.helper.RequestHtmlHelper

class OnlineCoursesOOOCrawler(private val numberOfPage: Int = 30) : CouponUrlCrawlerBase() {
    override val baseAPIUrl: String
        get() = "https://www.onlinecourses.ooo"

    override fun getAllCouponUrl(): List<String> = runBlocking {
        val allCouponUrls = mutableListOf<String>()
        val jobs = mutableListOf<Job>()
        val semaphore = Semaphore(5)
        for (pageIndex in 1..numberOfPage) {
            semaphore.acquire()
            jobs += launch(Dispatchers.IO) {
                allCouponUrls.addAll(extractUrlFromHTMLPage(pageIndex))
                semaphore.release()
            }
        }
        jobs.joinAll()
        return@runBlocking allCouponUrls
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
        return RequestHtmlHelper.getHtmlDocument(urlToDetailPage).select(".link-holder").first()?.select("a")?.first()
            ?.attr("href")
    }
}