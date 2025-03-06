package com.example.simplelogin.ui.model

sealed class Screen(val route: String) {
    object Login: Screen("login_screen")
    object Home: Screen("home_screen")
}