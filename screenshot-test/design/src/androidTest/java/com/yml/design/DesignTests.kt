package com.yml.design

import android.graphics.Bitmap
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.airbnb.android.showkase.annotation.ShowkaseScreenshot
import com.airbnb.android.showkase.screenshot.testing.ShowkaseScreenshotTest
import com.airbnb.android.showkase.screenshot.testing.ShowkaseScreenshotType
import com.karumi.shot.ScreenshotTest
import org.junit.Rule

/**
 * Implement both Showkase screenshot as well as Shot interface
 * Showkase will give the bitmap of each previewable component
 * which can then be used by shot for screen shot testing.
 *
 * showkase can work with any other screenshot libraries which supports bitmap capture
 */
@ShowkaseScreenshot(rootShowkaseClass = DesignModule::class)
abstract class DesignTests : ShowkaseScreenshotTest, ScreenshotTest {
    @get:Rule
    override val composeTestRule: ComposeContentTestRule = createComposeRule()

    override fun onScreenshot(
        id: String,
        name: String,
        group: String,
        styleName: String?,
        screenshotType: ShowkaseScreenshotType,
        screenshotBitmap: Bitmap
    ) {
        compareScreenshot(screenshotBitmap, "${group}_${name}")
    }
}