package com.example.simplelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplelogin.ui.home.HomeScreen
import com.example.simplelogin.ui.login.LoginScreen
import com.example.simplelogin.ui.login.LoginViewModel
import com.example.simplelogin.ui.model.Screen
import com.example.simplelogin.ui.theme.SimpleLoginTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleLoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { backStackEntry ->
            val viewModel: LoginViewModel = hiltViewModel(backStackEntry)
            LoginScreen(viewModel = viewModel, onLoginSuccess = { navController.navigate(Screen.Home.route) })
        }
        composable(Screen.Home.route) {
            HomeScreen(onLogout = { navController.popBackStack(Screen.Login.route, inclusive = false) })
        }
    }
}