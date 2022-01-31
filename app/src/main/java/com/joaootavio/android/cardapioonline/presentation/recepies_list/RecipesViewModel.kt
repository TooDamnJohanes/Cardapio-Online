package com.joaootavio.android.cardapioonline.presentation.recepies_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.joaootavio.android.cardapioonline.common.Constants.API_KEY
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_ADD_RECIPE_INFORMATION
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_API_KEY
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_DIET
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_FILL_INGREDIENTS
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_NUMBER
import com.joaootavio.android.cardapioonline.common.Constants.QUERY_TYPE
import com.joaootavio.android.cardapioonline.domain.use_case.get_recipes.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    private val _typeState = mutableStateOf<String>("")
    val typeState: State<String> = _typeState

    private val _dietState = mutableStateOf<String>("")
    val dietState: State<String> = _dietState

    private val queries: HashMap<String, String> = HashMap()

    fun applyQueries() {
        queries[QUERY_NUMBER] = "50"
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = _typeState.value
        queries[QUERY_DIET] = _dietState.value
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"
    }

    fun changeTypeState(newType: String) {
        _typeState.value = newType
    }

    fun changeDietState(newDiet: String) {
        _dietState.value = newDiet
    }
}
