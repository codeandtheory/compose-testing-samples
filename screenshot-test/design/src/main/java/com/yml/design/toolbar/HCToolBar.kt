package com.yml.design.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.design.R
import com.yml.design.elements.Header
import com.yml.design.theme.JetBlack
import com.yml.design.toolbar.TestTag.toolBar
import com.yml.design.toolbar.TestTag.toolBarImage
import com.yml.design.toolbar.TestTag.toolBarLeftIcon
import com.yml.design.toolbar.TestTag.toolBarRightIcon
import com.yml.design.toolbar.TestTag.toolBarTitle

internal object TestTag {
    const val toolBarLeftIcon = "toolBarLeftIcon"
    const val toolBarImage = "toolBarImage"
    const val toolBar = "toolBar"
    const val toolBarTitle = "toolBarTitle"
    const val toolBarRightIcon = "toolBarRightIcon"
}

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
        color = Color.White,
        contentColor = JetBlack,
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .testTag(toolBar),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (Resource.NONE != leftIcon) {
                Icon(
                    modifier = Modifier
                        .clickable {
                            onLeftIconClick()
                        }
                        .testTag(toolBarLeftIcon),
                    painter = painterResource(id = leftIcon),
                    contentDescription = stringResource(R.string.cd_toolbar_left_icon)
                )
            }
            if (Resource.NONE != headerImage) {
                Image(
                    modifier = Modifier
                        .weight(1.0f)
                        .testTag(toolBarImage),
                    painter = painterResource(headerImage),
                    contentDescription = stringResource(R.string.cd_toolbar_header)
                )
            } else {

                Header(
                    title,
                    modifier = Modifier
                        .testTag(toolBarTitle)
                        .weight(1.0f)
                )
            }

            if (Resource.NONE != rightIcon) {
                Icon(
                    modifier = Modifier
                        .clickable {
                            onRightIconClick()
                        }
                        .testTag(toolBarRightIcon),
                    painter = painterResource(id = rightIcon),
                    contentDescription = stringResource(R.string.cd_toolbar_right_icon)
                )
            }
        }
    }
}


@Preview(
    name = "title-left",
    group = "toolbar",
    locale = "en"
)
/*@Preview(
    name = "title-left-ar",
    group = "toolbar",
    locale = "ar"
)*/
@Composable
fun PreviewToolBarTitleAndLeftIcon() {
    HCToolBar(
        title = stringResource(id = R.string.preview_home),
        leftIcon = R.drawable.ic_menu_burger
    )
}

@Preview(
    name = "title",
    group = "toolbar",
    locale = "en"
)
/*@Preview(
    name = "title-ar",
    group = "toolbar",
    locale = "ar"
)*/
@Composable
fun PreviewToolBar() {
    HCToolBar(
        title = stringResource(id = R.string.preview_home),
        rightIcon = R.drawable.ic_search,
        leftIcon = R.drawable.ic_menu_burger
    )
}

@Preview(
    name = "image",
    group = "toolbar",
    locale = "en"
)
/*@Preview(
    name = "image-ar",
    group = "toolbar",
    locale = "ar"
)*/
@Composable
fun PreviewToolBarImage() {
    HCToolBar(
        headerImage = R.drawable.ic_profile,
        rightIcon = R.drawable.ic_search,
        leftIcon = R.drawable.ic_menu_burger
    )
}
