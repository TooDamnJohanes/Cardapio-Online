package com.joaootavio.android.cardapioonline.presentation.recipes_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joaootavio.android.cardapioonline.R
import com.joaootavio.android.cardapioonline.common.Constants.LIST_OF_TYPES

@Composable
fun RadioGroup(
    radioButtons: List<String>,
    onItemSelected: (String) -> Unit
) {

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    }
    onItemSelected(selectedButton.value)
    Card(
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Selected: ${selectedButton.value}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(170.dp)
                    .padding(bottom = 5.dp)
            )
            radioButtons.forEach { index ->
                val isSelected = index == selectedButton.value
                val colors = RadioButtonDefaults.colors(
                    selectedColor = colorResource(id = R.color.design_default_color_primary),
                    unselectedColor = colorResource(id = R.color.design_default_color_primary_dark),
                    disabledColor = Color.LightGray
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    RadioButton(
                        colors = colors,
                        selected = isSelected,
                        onClick = {
                            selectedButton.value = index
                            onItemSelected(selectedButton.value)
                        }
                    )
                    Text(
                        text = index
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun RadioGroupPreview() {
    val radioButtons = LIST_OF_TYPES
    RadioGroup(
        radioButtons = radioButtons,
        onItemSelected = {}
    )
}