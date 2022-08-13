package com.yml.design.error

import com.yml.core.constants.Resource

data class ErrorData(
    val title: String,
    val description: String,
    val icon: Int = Resource.NONE,
    val button: String? = null
)