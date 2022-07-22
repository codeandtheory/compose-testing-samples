package com.yml.design

import androidx.compose.runtime.Composable
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

@ShowkaseComposable(name = "Card Sample")
@Preview
@Composable
fun PreviewCard() {
    HCard(
        title = "Here is the title",
        description = "this is description \nSecond line continued... Some text\nThird Line"
    )
}


@ShowkaseComposable(name = "Bottom Tab Label")
@Composable
@Preview
fun LabelPreview() {
    Label(value = "Some Value")
}