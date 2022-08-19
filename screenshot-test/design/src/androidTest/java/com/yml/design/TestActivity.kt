package com.yml.design

import android.content.Context
import androidx.activity.ComponentActivity

class TestActivity : ComponentActivity() {

    companion object {
        var darkTheme = false
        var locale = "en"
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleContextWrapper.wrap(newBase, locale))
    }
}