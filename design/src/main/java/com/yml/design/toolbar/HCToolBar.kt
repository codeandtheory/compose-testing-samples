package com.yml.design.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.design.elements.Header


@Composable
fun HCToolBar(
    modifier: Modifier = Modifier,
    title: String = "",
    @DrawableRes
    headerImage: Int = Resource.NONE,
    @DrawableRes
    leftIcon: Int = Resource.NONE,
    @DrawableRes
    rightIcon: Int = Resource.NONE,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {}
) {
    Surface(
        modifier
            .fillMaxWidth(),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (Resource.NONE != leftIcon) {
                Icon(
                    modifier = Modifier.clickable {
                        onLeftIconClick()
                    },
                    painter = painterResource(id = leftIcon),
                    contentDescription = "" //TODO CDS
                )
            }
            if (Resource.NONE != headerImage) {
                Image(
                    modifier = Modifier.weight(1.0f),
                    painter = painterResource(headerImage),
                    contentDescription = "" // TODO CDS
                )
            } else {
                Header(title, modifier = Modifier.weight(1.0f))
            }

            if (Resource.NONE != rightIcon) {
                Icon(
                    modifier = Modifier.clickable {
                        onRightIconClick()
                    },
                    painter = painterResource(id = leftIcon),
                    contentDescription = "" //TODO CDS
                )
            }
        }
    }
}


