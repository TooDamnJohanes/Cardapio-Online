package com.joaootavio.android.cardapioonline.presentation.recipes_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaootavio.android.cardapioonline.common.Constants.API_KEY
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_API_KEY
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_DIET
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_FILL_INGREDIENTS
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_NUMBER
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_TYPE
import com.joaootavio.android.cardapioonline.common.Resource
import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe
import com.joaootavio.android.cardapioonline.domain.repository.RecipesRepository
import com.joaootavio.android.cardapioonline.domain.use_case.get_recipes.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase,
    private val repository: RecipesRepository
) : ViewModel() {

    private val _state = mutableStateOf<RecipesState>(RecipesState())
    val state: State<RecipesState> = _state

    private val _typeState = mutableStateOf<String>("")

    private val _dietState = mutableStateOf<String>("")

    private val queries: HashMap<String, String> = HashMap()

    private fun applyQueries() {
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = _typeState.value.lowercase()
        queries[QUERY_DIET] = _dietState.value.lowercase()
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"
    }

    private suspend fun getRecipesFromRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getRecipes(queries = queries)
                _state.value = RecipesState(recipes = result)
            } catch (e: HttpException) {
                _state.value =
                    RecipesState(error = e.localizedMessage ?: "An unexpected error occurred")
            } catch (e: IOException) {
                _state.value =
                    RecipesState(error = "Could't reach server. Check your internet connection")
            }

        }.join()

    }

    fun getRecipes() {
        applyQueries()
        viewModelScope.launch(Dispatchers.IO) {
            getRecipesFromRepository()
        }
    }

    fun changeTypeState(newType: String) {
        _typeState.value = newType
        applyQueries()
    }

    fun changeDietState(newDiet: String) {
        _dietState.value = newDiet
        applyQueries()
    }
}
