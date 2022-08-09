package com.yml.core.utils

import com.yml.core.constants.General

fun String?.isPresent(): Boolean {
    return this != null && this.isNotBlank()
}

fun String?.orEmpty(): String {
    return this ?: General.EMPTY_STRING
}