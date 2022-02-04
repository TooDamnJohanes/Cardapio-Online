package com.joaootavio.android.cardapioonline.navigation

import java.lang.IllegalArgumentException

enum class Screen {

    RecipesListScreen,
    SplashScreen;

    companion object {
        fun fromRoute(route: String?): Screen
        = when (route?.substringBefore("/")) {
            RecipesListScreen.name -> RecipesListScreen
            SplashScreen.name -> SplashScreen
            null -> RecipesListScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}
