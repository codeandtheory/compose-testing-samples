package com.yml.design.error

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.core.utils.isPresent
import com.yml.design.elements.Description
import com.yml.design.elements.HCButton
import com.yml.design.elements.SubHeading
import com.yml.design.toolbar.HCToolBar

@Composable
fun ErrorWidget(
    modifier: Modifier,
    data: ErrorData,
    ctaClick: () -> Unit = {} // optional click action
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (Resource.NONE != data.icon) {
            Icon(
                painter = painterResource(id = data.icon),
                contentDescription = "" //TODO CDS
            )
        }
        SubHeading(text = data.title)

        Description(text = data.description)

        if (data.button.isPresent()) {
            HCButton(title = data.button!!, onClick = ctaClick)
        }

    }

}