package com.yml.design.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun SubHeading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current
) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = color,
            fontWeight = FontWeight.W700,
            fontSize = 16.sp
        )
    )
}

@Composable
fun Description(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
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
            fontWeight = FontWeight.W700,
            fontSize = 16.sp
        )
    )
}

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = MaterialTheme.colors.primary,
    textColor: Color = contentColorFor(backgroundColor = bgColor)
) {
    Text(
        text = text,
        modifier
            .background(shape = RoundedCornerShape(3.dp), color = bgColor)
            .padding(3.dp),
        style = TextStyle(
            color = textColor,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp
        )
    )
}

