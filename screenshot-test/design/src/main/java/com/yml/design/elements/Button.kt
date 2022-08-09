package com.yml.design.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.design.R
import com.yml.design.theme.BahamaBlue
import com.yml.design.theme.JetBlack
import com.yml.design.theme.Yellow

@Composable
fun HCButton(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = BahamaBlue,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.padding(5.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = textColor
        )
    ) {
        SubHeading(text = title, color = textColor)
    }
}

@Preview(
    name = "default",
    group = "button"
)
/*@Preview(
    name = "default-ar",
    group = "button",
    locale = "ar"
)*/
@Composable
fun PreviewButton() {
    HCButton(title = stringResource(id = R.string.preview_retry)) {

    }
}

/**
 * TODO Rnd to make use of themes to preview variants
 */
@Preview(
    name = "custom",
    group = "button"
)
/*@Preview(
    name = "custom-ar",
    group = "button",
    locale = "ar"
)*/
@Composable
fun PreviewButtonCustom() {
    HCButton(
        title = stringResource(id = R.string.preview_retry),
        color = Yellow,
        textColor = JetBlack
    ) {

    }
}