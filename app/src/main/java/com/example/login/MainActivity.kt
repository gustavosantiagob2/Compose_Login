package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.screens.MainScreen
import com.example.login.screens.SignInScreen
import com.example.login.screens.SignUpScreen
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main/{user}") {
                        composable("main/{user}") { entry ->
                            entry.arguments?.getString("user")?.let { user ->
                                MainScreen(user = user)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }
                        }
                        composable("signIn") {
                            SignInScreen(
                                onSignInClick = { user ->
                                    navController.navigate("main/${user.username}")
                                },
                                onSignUpClick = {
                                    navController.navigate("signUp")

                                }
                            )
                        }
                        composable("signUp") {
                            SignUpScreen(
                                onSignUpClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}