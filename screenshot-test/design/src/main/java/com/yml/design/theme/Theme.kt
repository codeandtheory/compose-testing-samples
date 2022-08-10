package com.yml.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = ReadModeWhite,
    primaryVariant = BahamaBlue,
    secondary = ReadModeWhite.copy(alpha = .9f),
    onPrimary = ReadModeDark1,
    onSecondary = Color.White,
    surface = ReadModeDark2,
    onSurface = ReadModeWhite,
    background = ReadModeDark2,
    onBackground = ReadModeWhite,
    error = Rose,
    onError = Color.Red
)

private val LightColorPalette = lightColors(
    primary = BahamaBlue,
    primaryVariant = BahamaBlue,
    secondary = DoveGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = JetBlack,
    background = Color.White,
    onBackground = JetBlack,
    error = Rose,
    onError = Color.Red
)

@Composable
fun HealthCareTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}