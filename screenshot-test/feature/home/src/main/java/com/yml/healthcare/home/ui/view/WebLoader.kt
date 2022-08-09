package com.yml.healthcare.home.ui.view

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.yml.core.navigation.AppNavigator
import com.yml.design.container.HCToolBarScreen
import javax.inject.Inject

@Composable
fun HCWebView(url: String, title: String, navigator: AppNavigator) {
    HCToolBarScreen(title = title,
        leftIcon = com.yml.design.R.drawable.ic_angle_left,
        modifier = Modifier.background(color = Color.White),
        onLeftIconClick = {
            navigator.navigateBack()
        }) { modifier, _ ->
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