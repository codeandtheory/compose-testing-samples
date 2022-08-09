package com.yml.design.bottomNavigation

interface BottomNavDestination {
    fun title(): String = ""
    fun icon(): Int = -1
}