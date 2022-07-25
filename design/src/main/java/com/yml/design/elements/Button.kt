package com.yml.design.elements

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yml.design.theme.BahamaBlue

@Composable
fun HCButton(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = BahamaBlue,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = textColor
        )
    ) {
        SubHeading(text = title, color = textColor)
    }
}