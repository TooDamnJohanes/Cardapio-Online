package com.joaootavio.android.cardapioonline.presentation.recipes_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaootavio.android.cardapioonline.common.Constants.LIST_OF_DIETS
import com.joaootavio.android.cardapioonline.common.Constants.LIST_OF_TYPES
import com.joaootavio.android.cardapioonline.data.remote.dto.FoodRecipe
import com.joaootavio.android.cardapioonline.presentation.recipes_list.components.RadioGroup
import com.joaootavio.android.cardapioonline.presentation.recipes_list.components.RecipeItem
import com.joaootavio.android.cardapioonline.presentation.recipes_list.components.SearchButton

@ExperimentalMaterialApi
@Composable
fun RecipesScreen(
    viewModel: RecipesViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RadioGroup(
                    radioButtons = LIST_OF_TYPES,
                    onItemSelected = { newType ->
                        viewModel.changeTypeState(newType = newType)
                    }
                )
                RadioGroup(
                    radioButtons = LIST_OF_DIETS,
                    onItemSelected = { newDiet ->
                        viewModel.changeDietState(newDiet = newDiet)
                    }
                )
            }
            Divider(
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            SearchButton(
                onClickAction = {
                    viewModel.getRecipes()
                }
            )
            Divider(
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(state.value.recipes.results) { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }
        }
    }

}

@ExperimentalMaterialApi
@Composable
@Preview
fun RecipesScreenPreview() {
    RecipesScreen()
}