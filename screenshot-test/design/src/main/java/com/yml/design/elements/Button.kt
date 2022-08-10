package com.yml.design.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.design.R

@Composable
fun HCButton(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier.padding(5.dp),
        onClick = onClick
    ) {
        SubHeading(text = title)
    }
}

@Preview(
    name = "default",
    group = "button"
)
@Composable
fun PreviewButton() {
    HCButton(title = stringResource(id = R.string.preview_retry))
}

@Preview(
    name = "custom",
    group = "button"
)
@Composable
fun PreviewButtonCustom() {
    HCButton(
        title = stringResource(id = R.string.preview_retry)
    )
}