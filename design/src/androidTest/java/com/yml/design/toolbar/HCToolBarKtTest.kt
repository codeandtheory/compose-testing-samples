package com.yml.design.toolbar

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.yml.design.toolbar.TestTag.toolBarTitle
import org.junit.Rule
import org.junit.Test
import com.yml.design.toolbar.ScreenShotNames as names

object ScreenShotNames {
    const val ToolbarTitleOnly = "toolbar-title"
    const val ToolbarLeftIncTitle = "toolbar-left-title"
}

class HCToolBarKtTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    /**
     * Compose tests use structure called semantic tree
     */
    @Test
    fun verifyToolBarWithTitle() {
        val mockTitle = "Title"

        composeRule.setContent {
            HCToolBar(
                title = mockTitle
            )
        }

        /**
         * Prints the semantic tree
         */
        composeRule.onRoot().printToLog("HCToolBar")

        composeRule.onNodeWithTag(toolBarTitle)
            .assertIsDisplayed()
            .assertHasNoClickAction()
            .assertTextEquals(mockTitle)

        compareScreenshot(composeRule, names.ToolbarTitleOnly)
    }

    /**
     * Compose tests use structure called semantic tree
     */
    @Test
    fun verifyToolBarWithTitleAndLeftIcon() {

        val mockTitle = "Title"
        composeRule.setContent {
            HCToolBar(
                title = mockTitle,
                leftIcon = -1
            )
        }

        /**
         * Prints the semantic tree
         */
        composeRule.onRoot().printToLog("HCToolBar")

        composeRule.onNodeWithTag(toolBarTitle)
            .assertIsDisplayed()
            .assertHasNoClickAction()
            .assertTextEquals(mockTitle)

        /*       composeRule.onNodeWithContentDescription(CDConstants.toolBarLeftIcon)
                   .assertIsDisplayed()
                   .assertHasClickAction()*/

        compareScreenshot(composeRule, names.ToolbarLeftIncTitle)
    }
}