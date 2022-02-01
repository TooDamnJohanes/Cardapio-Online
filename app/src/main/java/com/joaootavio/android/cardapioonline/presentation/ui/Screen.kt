package com.joaootavio.android.cardapioonline.presentation.ui

sealed class Screen(val route: String) {
    object RecipesListScreen: Screen("recipe_list_screen")
}
