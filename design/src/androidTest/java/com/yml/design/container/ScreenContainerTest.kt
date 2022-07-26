package com.yml.design.container

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.yml.design.theme.Spearmint
import org.junit.Rule
import org.junit.Test

class ScreenContainerTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun verifyScreenContainer() {
        val mockToolBarTitle = "Title"
        with(composeRule) {
            setContent {
                HCToolBarScreen(title = mockToolBarTitle) { x, y ->

                }
            }
            onRoot().printToLog("ScreenContainer")

/*            onNodeWithContentDescription(CDConstants.toolBar)
                .assertIsDisplayed()

            onNodeWithContentDescription(CDConstants.toolBarTitle)
                .assertIsDisplayed()
                .assertTextEquals(mockToolBarTitle)*/

            compareScreenshot(this, "container_with_toolbar")
        }

    }

    @Test
    fun verifySnackBar() {
        with(composeRule) {
            val mockDesc = "Snackbar description"
            setContent {
                SnackMessage(description = mockDesc, bgColor = Spearmint)
            }
            compareScreenshot(this, "successSnackMessage")
        }
    }

}