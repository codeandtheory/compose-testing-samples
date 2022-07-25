package com.yml.design.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.core.utils.isPresent
import com.yml.design.CDConstants
import com.yml.design.elements.Description
import com.yml.design.elements.HCButton
import com.yml.design.elements.SubHeading

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
                contentDescription = CDConstants.ErrorScreenImage
            )
        }
        SubHeading(text = data.title,
            Modifier
                .semantics {
                    contentDescription = CDConstants.ErrorScreenTitle
                }
                .padding(top = 10.dp))

        Description(text = data.description,
            Modifier
                .semantics {
                    contentDescription = CDConstants.ErrorScreenDescription
                }
                .padding(top = 10.dp))

        if (data.button.isPresent()) {
            HCButton(title = data.button!!, onClick = ctaClick, modifier = Modifier
                .semantics {
                    contentDescription = CDConstants.ErrorScreenButton
                }
                .padding(top = 10.dp))
        }
    }
}