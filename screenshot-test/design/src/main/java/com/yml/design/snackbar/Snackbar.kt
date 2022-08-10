package com.yml.design.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.yml.design.R
import com.yml.design.elements.Description
import com.yml.design.theme.HealthCareTheme
import com.yml.design.theme.Rose


@Composable
fun SnackMessage(
    description: String,
    bgColor: Color = MaterialTheme.colors.primary
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        backgroundColor = bgColor,
        elevation = 3.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Description(
            text = description,
            modifier = Modifier.padding(5.dp),
            textColor = LocalContentColor.current.copy(.85f)
        )
    }
}


@Preview
@Composable
@ShowkaseComposable("success", "snack")
fun SnackSuccessPreview() = HealthCareTheme {
    SnackMessage(description = stringResource(id = R.string.preview_snack_success))
}


/**
 * Multiple previews are supported android studio dolphin onwards
 */
@Composable
/*@Preview(
    name = "error-rtl",
    locale = "ar"
)*/
@Preview(
    name = "error",
    group = "snack",
    locale = "en"
)
fun SnackErrorPreview() = SnackMessage(
    description = stringResource(id = R.string.preview_snack_error),
)


/**
 * Todo test this Parameter provider
 */
class ParameterProvider : PreviewParameterProvider<String> {
    override val count: Int
        get() = super.count
    override val values: Sequence<String>
        get() = sequenceOf(
            "Short Description",
            "First Line \nSecond Line"
        )
}