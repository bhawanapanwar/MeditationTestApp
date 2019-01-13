package com.insight.meditationapp.DescriptionModule

import android.os.Bundle
import com.insight.meditationapp.BaseActivity
import com.insight.meditationapp.R
import android.webkit.WebView
import com.insight.meditationapp.Utils.Constants

class DescriptionActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val webView = WebView(this)
        webView.loadUrl(Constants.DESCRIPTION_URL)
        setContentView(webView)
    }
}