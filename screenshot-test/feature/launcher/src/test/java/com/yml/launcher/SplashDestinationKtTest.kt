package com.yml.launcher

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

/**
 * Note paparazi is not available in android test
 */
class SplashDestinationKtTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_XL
    )


    @Test
    fun `record splash screen and verify`() {
        paparazzi.snapshot("splash") {
            SplashDestination {

            }
        }
    }
}