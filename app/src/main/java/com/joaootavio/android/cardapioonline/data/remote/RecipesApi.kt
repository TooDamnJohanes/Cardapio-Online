package com.joaootavio.android.cardapioonline.data.remote

import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RecipesApi {

    @GET("/recipes/complexSearch")
    suspend fun getRecipies(
        @QueryMap queries: Map<String, String>
    ): FoodRecipe

}