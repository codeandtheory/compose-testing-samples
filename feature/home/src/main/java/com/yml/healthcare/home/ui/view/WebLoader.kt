package com.yml.healthcare.home.ui.view

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.yml.design.container.HCToolBarScreen
import javax.inject.Inject

@Composable
fun HCWebView(url: String, title: String) {
    HCToolBarScreen(title = title) { modifier, _ ->
        AndroidView(modifier = modifier, factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        }, update = {
            it.loadUrl(url)
        })
    }
}