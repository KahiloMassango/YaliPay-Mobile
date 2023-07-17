package com.example.yalipay.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yalipay.ui.utils.ui.BottomAppBar
import com.example.yalipay.ui.utils.ui.TopBar
import kotlinx.coroutines.delay

@Composable
fun YaliPayApp(navController: NavHostController, windowSizeClass: WindowWidthSizeClass ){
    NavHost(navController = navController, startDestination = "start"){
        composable("start"){
            StartScreen()
            LaunchedEffect(Unit){
                delay(2500)
                navController.navigate("welcome")
            }
        }
        composable("welcome"){
            WelcomeScreen(
                windowSizeClass = windowSizeClass,
                onSignIn = { navController.navigate("login") },
                onSignUp = { navController.navigate("register") }
            )
        }
        composable("login"){
            LoginScreen(
                windowSizeClass = windowSizeClass,
                onLogin = { navController.navigate("home") },
                onSignUp = { navController.navigate("register") },
                onRecovery = { navController.navigate("start")}
            )
        }
        composable("register"){
            RegisterScreen(windowSizeClass = windowSizeClass,
                onLogin = { navController.navigate("login") },
                onSignUp = { }
            )
        }
        composable("home"){
            Scaffold(
                topBar = { 
                    TopBar(title = "Home", canNavigate = false, onClick = { })
                },
                bottomBar = {
                    BottomAppBar(onClick = { navController.navigate(it) })
                }
            ) {
                CompactScreenn(modifier = Modifier.padding(it), {})
            }
        }

    }
}
