package com.yml.design.container

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.design.elements.Description
import com.yml.design.theme.Green
import com.yml.design.theme.Rose
import com.yml.design.theme.Spearmint
import com.yml.design.toolbar.HCToolBar


@Composable
fun HCToolBarScreen(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes
    headerImage: Int = Resource.NONE,
    @DrawableRes
    leftIcon: Int = Resource.NONE,
    @DrawableRes
    rightIcon: Int = Resource.NONE,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {},
    content: @Composable ColumnScope.(
        modifier: Modifier,
        snackMessage: (message: String) -> Unit
    ) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HCToolBar(
            title = title,
            headerImage = headerImage,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            onLeftIconClick = onLeftIconClick,
            onRightIconClick = onRightIconClick
        )

        val state = remember { mutableStateOf("") }

        val hostState = remember { SnackbarHostState() }
        Box {
            Column {
                content(Modifier.padding(top = 6.dp)) {
                    state.value = it
                }
            }
            SnackbarHost(
                hostState = hostState,
                snackbar = { data ->
                    SnackMessage(
                        description = state,
                        bgColor = /*if (value.second) Spearmint else Rose*/ Spearmint
                    )
                }
            )
        }

        LaunchedEffect(key1 = state.value) {
            val message = state.value
            if (message.isNotEmpty()) {
                hostState.showSnackbar(message)
            }
        }
    }
}

@Composable
fun SnackMessage(
    description: MutableState<String>,
    bgColor: Color,
    contentColor: Color = Color.White
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
            text = description.value,
            modifier = Modifier.padding(5.dp),
            textColor = Green
        )
    }
}

@Composable
fun SuccessMessage(
    description: MutableState<String>,
) {
    SnackMessage(description = description, bgColor = Spearmint)
}

@Composable
fun ErrorMessage(
    description: MutableState<String>,
) {
    SnackMessage(description = description, bgColor = Rose)
}