package com.joaootavio.android.cardapioonline.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>,
)