package com.joaootavio.android.cardapioonline.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joaootavio.android.cardapioonline.presentation.recipes_list.RecipesScreen

@ExperimentalMaterialApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RecipesListScreen.name
    ) {
        composable(
            route = Screen.RecipesListScreen.name
        ) {
            RecipesScreen()
        }
    }
}