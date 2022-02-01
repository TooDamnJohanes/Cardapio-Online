package com.joaootavio.android.cardapioonline.common

object Constants {

    const val BASE_URL = "https://api.spoonacular.com"
    // const val API_KEY = "7a7e180d0ad641bfafb7ed814ba6f706" // Conta Principal
    const val API_KEY = "cb41915de3794cdc84f7d618d5960198" // Conta Secundária


    const val QUERY_NUMBER = "number"
    const val QUERY_API_KEY = "apiKey"
    const val QUERY_TYPE = "type"
    const val QUERY_DIET = "diet"
    const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
    const val QUERY_FILL_INGREDIENTS = "fillIngredients"
    const val UNHEALTHY_FOOD = "Unhealthy Food"
    const val HEALTHY_FOOD = "Healthy Food"
    const val MIN = "min"
    const val LIKES = "likes"
    const val LIKE = "like"
    const val CHEAP = "Cheap Recipe"
    const val EXPENSIVE = "Expensive Recipe"

    val LIST_OF_TYPES = listOf(
        "BreakFast",
        "Snack",
        "FingerFood",
        "Soup",
        "Salad",
        "Appetizer",
        "Dessert"
    )

    val LIST_OF_DIETS = listOf(
        "Vegetarian",
        "Pescetarian",
        "Paleo",
        "Primal",
    )

}