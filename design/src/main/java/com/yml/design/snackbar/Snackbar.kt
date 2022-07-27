package com.yml.design.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.yml.design.theme.Green
import com.yml.design.theme.Rose
import com.yml.design.theme.Spearmint


@Composable
fun SnackMessage(
    description: String,
    bgColor: Color = Spearmint,
    contentColor: Color = Green
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
            textColor = contentColor
        )
    }
}


@Preview
@Composable
@ShowkaseComposable("success", "snack")
fun SnackSuccessPreview() =
    SnackMessage(description = stringResource(id = R.string.preview_snack_success))


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
    contentColor = Color.Red,
    bgColor = Rose
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