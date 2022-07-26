package com.yml.design.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yml.design.elements.SubHeading
import com.yml.design.elements.Tag
import com.yml.design.theme.HotPink
import com.yml.design.theme.JetBlack

/**
 * TODO move the dimens to one place
 */
@Composable
fun HCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: List<String>? = null,
    onclick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .clickable {
                onclick()
            },
        shape = RoundedCornerShape(
            topEnd = 10.dp,
            bottomEnd = 10.dp,
            bottomStart = 10.dp
        ),
        elevation = 5.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {

            SubHeading(text = title)

            Text(
                text = description,
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(color = JetBlack, fontSize = 14.sp),
                maxLines = 4
            )
            tags?.let { list ->
                if (list.isNotEmpty()) {
                    Row {
                        list.subList(0, minOf(list.size, 2)).forEach {
                            Tag(
                                text = it,
                                modifier = Modifier.padding(3.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * @Preview is equivalent to @ShowkaseComposable
 */
@Preview(
    name = "filled",
    group = "card"
)
@Composable
fun CardFilled() {
    HCard(
        title = "Here is the title",
        description = "this is description \nSecond line continued... Some text\nThird Line",
        tags = listOf("Blog", "Reports")
    )
}


@Preview(
    name = "no-tags",
    group = "card"
)
/*@Preview(
    name = "no-tags-scaled-rtl",
    group = "card",
    locale = "ar",
    fontScale = 2f
)*/
@Composable
fun CardNoTags() {
    HCard(
        title = "Here is the title",
        description = "this is description \nSecond line continued... Some text\nThird Line",
    )
}


