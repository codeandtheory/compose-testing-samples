package com.yml.healthcare.navigation.bottomNav

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class BottomNavWrapperKtTest : ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

//    @Test
    fun bottomNavigationItems() {
        with(composeRule) {
            setContent {
                HealthCareBottomNavWrapper(navHostController = rememberNavController())
            }
            compareScreenshot(this, "BottomNavigation")
        }
    }
}