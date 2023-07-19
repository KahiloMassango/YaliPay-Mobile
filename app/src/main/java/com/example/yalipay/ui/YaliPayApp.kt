package com.example.yalipay.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yalipay.ui.utils.ui.TopBar
import kotlinx.coroutines.delay

enum class YaliPayScreen{
    Start,
    Welcome,
    Login,
    Register,
    Home,
    Transfer,
    Cards,
}

@Composable
fun YaliPayApp(
    navController: NavHostController = rememberNavController(),
    windowSizeClass: WindowWidthSizeClass
){
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = YaliPayScreen.valueOf(
        backStackEntry?.destination?.route ?: YaliPayScreen.Home.name
    )

    Scaffold(
        topBar = {
            if (currentScreen !in listOf(YaliPayScreen.Start, YaliPayScreen.Welcome,
                    YaliPayScreen.Login, YaliPayScreen.Register)
            ) {
                TopBar(
                    title = currentScreen.name,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = YaliPayScreen.Start.name,
            modifier = Modifier.padding(it)
        ){
            composable(YaliPayScreen.Start.name){
                StartScreen()
                LaunchedEffect(Unit){
                    delay(2500)
                    navController.popBackStack(YaliPayScreen.Start.name, inclusive = true)
                    navController.navigate(YaliPayScreen.Welcome.name)
                }
            }
            composable(YaliPayScreen.Welcome.name){
                WelcomeScreen(
                    windowSizeClass = windowSizeClass,
                    onSignIn = { navController.navigate(YaliPayScreen.Login.name) },
                    onSignUp = { navController.navigate(YaliPayScreen.Register.name) }
                )
            }
            composable(YaliPayScreen.Login.name){
                LoginScreen(
                    windowSizeClass = windowSizeClass,
                    onLogin = {
                        navController.popBackStack(YaliPayScreen.Welcome.name, inclusive = true)
                        navController.navigate(YaliPayScreen.Home.name)
                    },
                    onSignUp = {
                        navController.popBackStack(YaliPayScreen.Login.name, inclusive = true)
                        navController.navigate(YaliPayScreen.Register.name)
                    },
                    onRecovery = { navController.navigate("start")}
                )
            }
            composable(YaliPayScreen.Register.name){
                RegisterScreen(windowSizeClass = windowSizeClass,
                    onSignIn = {
                        navController.popBackStack(YaliPayScreen.Register.name, inclusive = true)
                        navController.navigate(YaliPayScreen.Login.name)
                    },
                    onSignUp = { }
                )
            }
            composable(YaliPayScreen.Home.name) {
                HomeScreen(windowSizeClass = windowSizeClass)
            }
        }
    }
}
