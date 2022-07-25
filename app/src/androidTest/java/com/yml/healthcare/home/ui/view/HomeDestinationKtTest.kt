package com.yml.healthcare.home.ui.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.karumi.shot.ScreenshotTest
import com.yml.healthcare.home.ui.viewmodel.home.HomeViewModel
import com.yml.healthcare.navigation.NavigationManager
import org.junit.Rule
import org.junit.Test

class HomeDestinationKtTest : ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    lateinit var homeViewModel: HomeViewModel

//    @Test
    fun verifyHomeProgressState() {
        with(composeRule) {
            setContent {
                homeViewModel = hiltViewModel()
                HomeDestination(
                    viewModel = homeViewModel, //todo inject this
                    navController = NavigationManager(rememberNavController())
                )
            }
            compareScreenshot(this, "HomeScreenProgress")
        }
    }
}