package com.yml.healthcare

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import com.karumi.shot.ScreenshotTest
import com.yml.healthcare.navigation.bottomNav.HealthCareBottomNavWrapper
import org.junit.Rule
import org.junit.Test

class MainActivityTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun SampleTest() {
        composeRule.setContent {
            HealthCareBottomNavWrapper(navHostController = rememberNavController())
        }
        compareScreenshot(composeRule)
    }

    @Test
    fun ScreenTestTest() {
        composeRule.setContent {
//            HealthcareNavHost(rememberNavController())
        }
        compareScreenshot(composeRule)
    }
}