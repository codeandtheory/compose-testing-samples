package com.yml.design

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule
import com.yml.design.bottomNavigation.Label
import com.yml.design.card.HCard

@ShowkaseRoot
class DesignModule : ShowkaseRootModule

/**
 * Show-kase previews
 */

/**
 * @Preview is equivalent to @ShowkaseComposable
 */
@Preview(
    name = "all values",
    group = "card",
    device = Devices.AUTOMOTIVE_1024p
)
@Composable
fun PreviewCard() {
    HCard(
        title = "Here is the title",
        description = "this is description \nSecond line continued... Some text\nThird Line",
        tags = listOf("Blog", "Reports")
    )
}
