package com.yml.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.DeviceConfig.Companion.NEXUS_5_LAND
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_4_XL
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.yml.design.theme.HealthCareTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

const val PERCENT_DIFFERENCE = 0.1

class ComponentPreview(
    private val skBrowser: ShowkaseBrowserComponent
) {
    val content: @Composable () -> Unit = skBrowser.component
    override fun toString(): String =
        skBrowser.group + "_" + skBrowser.componentName
}

/**
 * As DeviceConfig is a data class, and when doing test parameter injections,
 * the test method names for various tests would be toString() of the class, which will
 * be long in case of the above config.
 *
 * To avoid that this can be wrapped within a class and override toString
 */
class DevicePreview(
    val deviceConfig: DeviceConfig,
    // This name provides the
    private val name: String
) {

    override fun toString(): String {
        return name
    }
}

@RunWith(TestParameterInjector::class)
class SnapTest {

    object Previews : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentPreview> =
            Showkase.getMetadata().componentList.map(::ComponentPreview)
    }


    object DeviceConfigs : TestParameter.TestParameterValuesProvider {
        override fun provideValues() = listOf(
            DevicePreview(PIXEL_4_XL, "PIXEL_4_XL"),
            DevicePreview(NEXUS_5_LAND, "NEXUS_5_LAND")
        )
    }


    object LayoutDirections : TestParameter.TestParameterValuesProvider {
        override fun provideValues() = listOf(
            LayoutDirection.Ltr,
            LayoutDirection.Rtl
        )
    }

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = PERCENT_DIFFERENCE,
        deviceConfig = PIXEL_4_XL,
    )

    @Test
    fun sample(
        @TestParameter(valuesProvider = Previews::class)
        componentPreview: ComponentPreview,
        @TestParameter(valuesProvider = DeviceConfigs::class)
        devicePreview: DevicePreview,
        @TestParameter(valuesProvider = LayoutDirections::class)
        directions: LayoutDirection, // Wrapper is not necessary as it is enum
        @TestParameter(value = [BuildConfig.BUILD_TYPE])
        buildType: String
    ) {
        paparazzi.unsafeUpdateConfig(devicePreview.deviceConfig)
        paparazzi.snapshot {
            CompositionLocalProvider(
                LocalInspectionMode provides true,
                LocalLayoutDirection provides directions,
            ) {
                HealthCareTheme {
                    Box(
                        Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        componentPreview.content()
                    }
                }
            }
        }
    }
}