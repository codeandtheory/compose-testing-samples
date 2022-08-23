package com.yml.launcher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

@Composable
fun SplashDestination(navigateToHome: () -> Unit) {
    Surface(color = with(MaterialTheme.colors) {
        if (isLight) surface else primary
    }) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            LaunchedEffect(Unit) {
                delay(4000)
                navigateToHome()
            }
            Image(
                painter = painterResource(R.drawable.health_care_gov),
                contentDescription = "" // TODO CDS
            )
        }
    }
}