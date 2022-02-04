package com.joaootavio.android.cardapioonline.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joaootavio.android.cardapioonline.presentation.recipes_list.RecipesScreen
import com.joaootavio.android.cardapioonline.presentation.splash_screen.AnimatedSplashScreen
import com.joaootavio.android.cardapioonline.presentation.splash_screen.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.name
    ) {
        composable(
            route = Screen.RecipesListScreen.name
        ) {
            RecipesScreen()
        }
        composable(
            Screen.SplashScreen.name
        ) {
            AnimatedSplashScreen(navController = navController)
        }
    }
}