package com.yml.healthcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.yml.design.theme.HealthCareTheme
import com.yml.healthcare.navigation.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthCareTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .background(
                    Color.Magenta,
                    shape = RoundedCornerShape(corner = CornerSize(5.dp))
                )
                .padding(10.dp),
            style = TextStyle(color = Color.White),
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        HealthCareTheme {
            Greeting("Android")
        }
    }

    @ShowkaseComposable(name = "Bottom Tab Label", group = "Greeting")
    @Composable
    fun ScaledGreeting() {
        HealthCareTheme {
            Greeting(
                "Android", Modifier
                    .scale(1.5f)
                    .offset(20.dp)
            )
        }
    }
}