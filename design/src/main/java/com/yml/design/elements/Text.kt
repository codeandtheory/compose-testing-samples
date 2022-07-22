package com.yml.design.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yml.design.theme.BahamaBlue
import com.yml.design.theme.JetBlack
import com.yml.design.theme.Spearmint

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun SubHeading(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.DarkGray,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        )
    )
}

@Composable
fun Description(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = JetBlack
) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = textColor,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    )
}

@Composable
fun Link(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier.clickable {
            onClick()
        },
        style = TextStyle(
            color = BahamaBlue,
            fontWeight = FontWeight.W700,
            fontSize = 16.sp
        )
    )
}

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = Color.Yellow,
    textColor: Color = Color.White
) {
    Text(
        text = text,
        modifier
            .background(shape = RoundedCornerShape(3.dp), color = bgColor)
            .padding(2.dp),
        style = TextStyle(
            color = textColor,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp
        )
    )
}

