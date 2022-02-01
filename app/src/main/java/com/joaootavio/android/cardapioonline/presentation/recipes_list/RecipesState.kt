package com.joaootavio.android.cardapioonline.presentation.recipes_list

import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe

data class RecipesState(
    val isLoading: Boolean = false,
    val recipes: FoodRecipe = FoodRecipe(results = emptyList()),
    val error: String = ""
)
