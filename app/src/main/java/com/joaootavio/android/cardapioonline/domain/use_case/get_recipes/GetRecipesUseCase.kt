package com.joaootavio.android.cardapioonline.domain.use_case.get_recipes

import com.joaootavio.android.cardapioonline.common.Resource
import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe
import com.joaootavio.android.cardapioonline.domain.repository.RecipesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipesRepository
) {

    operator fun invoke(queries: HashMap<String, String>): Flow<Resource<FoodRecipe>> = flow {
        try {
            emit(Resource.Loading<FoodRecipe>())
            val recipes = repository.getRecipes(queries = queries)
            emit(Resource.Success<FoodRecipe>(recipes))
        } catch (e: HttpException) {
            emit(Resource.Error<FoodRecipe>(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<FoodRecipe>(message = "Could't reach server. Check your internet connection"))
        }
    }

}