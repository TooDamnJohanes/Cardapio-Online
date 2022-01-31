package com.joaootavio.android.cardapioonline.data.repository

import com.joaootavio.android.cardapioonline.data.remote.RecipesApi
import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe
import com.joaootavio.android.cardapioonline.domain.repository.RecipesRepository
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val api: RecipesApi
): RecipesRepository {

    override suspend fun getRecipes(queries: Map<String, String>): FoodRecipe {
        return api.getRecipies(queries = queries)
    }

}