package com.yml.design.progress

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.design.R
import com.yml.design.theme.HotPink
import com.yml.design.toolbar.HCToolBar

@Composable
fun HCProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White.copy(alpha = 0.5f))
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            color = HotPink,
            strokeWidth = 2.dp
        )
    }
}

@Preview(
    name = "progress",
    group = "elements",
    locale = "en"
)
/*@Preview(
    name = "progress-ar",
    group = "elements",
    locale = "ar"
)*/
@Composable
fun PreviewProgressBar() {
    HCProgressBar()
}
