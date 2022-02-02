package com.joaootavio.android.cardapioonline.presentation.recipes_list.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import com.joaootavio.android.cardapioonline.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.joaootavio.android.cardapioonline.common.Constants.CHEAP
import com.joaootavio.android.cardapioonline.common.Constants.EXPENSIVE
import com.joaootavio.android.cardapioonline.common.Constants.HEALTHY_FOOD
import com.joaootavio.android.cardapioonline.common.Constants.LIKE
import com.joaootavio.android.cardapioonline.common.Constants.LIKES
import com.joaootavio.android.cardapioonline.common.Constants.MIN
import com.joaootavio.android.cardapioonline.common.Constants.UNHEALTHY_FOOD
import com.joaootavio.android.cardapioonline.data.remote.dto.Result

@ExperimentalMaterialApi
@Composable
@Preview
fun RecipeItem(
    recipe: Result = Result(
        aggregateLikes = 10,
        cheap = true,
        dairyFree = true,
        extendedIngredients = emptyList(),
        glutenFree = true,
        id = 0,
        image = "",
        readyInMinutes = 50,
        sourceName = "",
        sourceUrl = "",
        summary = "",
        title = "Title TesteTitle TesteTitle TesteTitle TesteTitle TesteTitle TesteTitle TesteTitle TesteTitle TesteTitle Teste",
        vegan = true,
        vegetarian = true,
        veryHealthy = true
    )
) {
    var expandedState by remember { mutableStateOf(false) }
    val isCheapText = if (recipe.cheap) CHEAP else EXPENSIVE
    val isCheapColor = if (recipe.cheap) Color(0xFF00C980) else Color(0xFFFF4646)
    val likesText = if (recipe.aggregateLikes > 1) LIKES else LIKE
    val likesColor = if (recipe.aggregateLikes < 20) Color(0xFFFF4646).copy(alpha = 0.4f)
    else Color(0xFFFF4646)
    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp, top = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = recipe.image),
                    contentDescription = "Recipe Image",
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = recipe.title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Divider()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 180.dp)
                        .padding(5.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    IconInformation(
                        icon = Icons.Default.Favorite,
                        information = "${recipe.aggregateLikes} $likesText",
                        color = likesColor
                    )

                    IconInformationPainter(
                        icon = painterResource(id = R.drawable.ic_watch_later),
                        information = "${recipe.readyInMinutes} $MIN",
                        color = Color(0xFFFFC114)
                    )

                    IconInformationPainter(
                        icon = painterResource(id = R.drawable.ic_baseline_money),
                        information = isCheapText,
                        color = isCheapColor
                    )

                    when (recipe.veryHealthy) {
                        true -> {
                            IconInformation(
                                icon = Icons.Default.ThumbUp,
                                information = HEALTHY_FOOD,
                                color = Color(0xFF00C980)
                            )
                        }
                        false -> {
                            IconInformationPainter(
                                icon = painterResource(id = R.drawable.ic_thumb_down),
                                information = UNHEALTHY_FOOD,
                                color = Color.Red
                            )
                        }
                    }
                }

                if (expandedState) {
                    Divider()
                    Card(
                        modifier = Modifier
                            .height(200.dp)
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        LazyColumn {
                            items(recipe.extendedIngredients) { ingredients ->
                                IngredientItem(ingredient = ingredients.name)
                            }
                        }
                    }
                    Divider()
                }
            }
        }
    }
}

@Composable
fun IconInformation(
    icon: ImageVector,
    information: String,
    color: Color
) {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Info Icon",
            tint = color
        )
        Text(
            text = information,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Composable
fun IconInformationPainter(
    icon: Painter,
    information: String,
    color: Color
) {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = icon,
            contentDescription = "Info Icon",
            tint = color
        )
        Text(
            text = information,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Composable
fun IngredientItem(
    ingredient: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            tint = Color(0xFF00C980),
            contentDescription = "Ingredients"
        )
        Text(
            text = ingredient,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 10.sp,
            modifier = Modifier
                .padding(start = 5.dp)
        )
    }
}
