package com.yml.design.error

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class ErrorScreenKtTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun verifyErrorScreenWithTitleAndDescription() {

        val mockErrorData = ErrorData(
            title = "Something Went Wrong!!",
            description = "Please check your Internet connection"
        )
        composeRule.setContent {
            ErrorWidget(modifier = Modifier, data = mockErrorData)
        }

        composeRule.onRoot().printToLog("ErrorScreenWithTitleAndDescription")

        composeRule.onNodeWithTag(TestTag.ErrorScreenTitle)
            .assertIsDisplayed()
            .assertTextEquals(mockErrorData.title)
            .fetchSemanticsNode()

        compareScreenshot(composeRule, "errorWidgetTD")
    }


    @Test
    fun verifyErrorWidgetWithTitleDescButton() {
        val mockErrorData = ErrorData(
            title = "Something Went Wrong!!",
            description = "Please check your Internet connection",
            button = "Retry"
        )
        composeRule.setContent {
            ErrorWidget(modifier = Modifier, data = mockErrorData)
        }

        composeRule.onRoot().printToLog("ErrorScreenWithTitleAndDescription")

        composeRule.onNodeWithTag(TestTag.ErrorScreenTitle)
            .assertIsDisplayed()
            .assertTextEquals(mockErrorData.title)
            .fetchSemanticsNode()

        compareScreenshot(composeRule, "errorWidgetTDB")
    }
}
