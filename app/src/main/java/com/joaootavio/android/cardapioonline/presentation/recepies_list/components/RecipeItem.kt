package com.joaootavio.android.cardapioonline.presentation.recepies_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.joaootavio.android.cardapioonline.data.remote.dto.Result

@Composable
fun RecipeItem() {
    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"),
                contentDescription = "Recipe Image",
                modifier = Modifier
                    .height(180.dp)
                    .width(180.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
                    .height(180.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Título da Receita",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Justify
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    IconInformation(
                        icon = Icons.Default.FavoriteBorder,
                        information = "100"
                    )

                    IconInformation(
                        icon = Icons.Default.FavoriteBorder,
                        information = "100"
                    )

                    IconInformation(
                        icon = Icons.Default.FavoriteBorder,
                        information = "100"
                    )

                }
            }
        }
    }
}

@Composable
fun IconInformation(
    icon: ImageVector,
    information: String
) {
    Column {
        Icon(
            imageVector = icon,
            contentDescription = "Info Icon"
        )
        Text(
            text = information,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun RecipeItemPreview() {
    RecipeItem()
}