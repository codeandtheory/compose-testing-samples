package com.yml.design

import android.content.Context
import android.content.Intent
import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule
import com.airbnb.android.showkase.models.Showkase

@ShowkaseRoot
class DesignModule : ShowkaseRootModule

fun browserIntent(context: Context): Intent {
    return Showkase.getBrowserIntent(context)
}