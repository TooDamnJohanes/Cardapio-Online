package com.joaootavio.android.cardapioonline.domain.repository

import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe

interface RecipesRepository {

    suspend fun getRecipes(queries: Map<String, String>): FoodRecipe

}