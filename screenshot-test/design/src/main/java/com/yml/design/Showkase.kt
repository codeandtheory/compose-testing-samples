package com.yml.design

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule
import com.airbnb.android.showkase.models.Showkase
import com.yml.design.theme.HealthCareTheme

@ShowkaseRoot
class DesignModule : ShowkaseRootModule

fun browserIntent(context: Context): Intent {
    return Showkase.getBrowserIntent(context)
}