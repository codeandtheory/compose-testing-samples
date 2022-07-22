package com.yml.design.card

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yml.design.elements.Tag
import com.yml.design.theme.HotPink
import com.yml.design.theme.JetBlack

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: List<String>? = null
) {
    Card(
        modifier = modifier.padding(10.dp),
        shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp),
        elevation = 5.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = title,
                modifier = Modifier,
                style = TextStyle(color = HotPink, fontSize = 16.sp)
            )

            Text(
                text = description,
                modifier = Modifier.padding(top = 10.dp),
                style = TextStyle(color = JetBlack, fontSize = 14.sp),
                maxLines = 4
            )

            /*  if (!tag.isNullOrBlank()) {
                  Tag(
                      text = tag,
                      modifier = Modifier.padding(top = 10.dp),
                      textColor = Rosewater,
                      bgColor = Cream
                  )
              }*/

            tags?.let { list ->
                if (list.isNotEmpty()) {
                    Row {
                        list.subList(0, minOf(list.size, 2)).forEach {
                            Tag(text = it)
                        }
                    }
                }
            }
        }
    }
}

