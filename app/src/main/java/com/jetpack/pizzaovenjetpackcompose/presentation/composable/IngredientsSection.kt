package com.jetpack.pizzaovenjetpackcompose.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.jetpack.pizzaovenjetpackcompose.R
import com.jetpack.pizzaovenjetpackcompose.presentation.model.Ingredient
import com.jetpack.pizzaovenjetpackcompose.ui.theme.LightGreen

@Composable
fun IngredientItem(
    ingredientImage: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .size(70.dp)
            .background(color = if (isSelected) LightGreen else Color.White)
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .padding(horizontal = 8.dp)
        )

        Image(
            modifier = Modifier
                .size(52.dp),
            painter = painterResource(id = ingredientImage),
            contentDescription = "ingredient image"
        )
    }

}

@Composable
fun IngredientItemsRow(
    selectedIngredients: Set<Ingredient> ,
    onIngredientClick: (Ingredient) -> Unit
) {
    val IngredientsImagesList = listOf(
        Ingredient.BASEL to R.drawable.basil_3,
        Ingredient.ONION to R.drawable.onion_3,
        Ingredient.BROCCOLI to R.drawable.broccoli_3,
        Ingredient.MUSHROOM to R.drawable.mushroom_9,
        Ingredient.SAUSAGE to R.drawable.sausage_3
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(28.dp),
    ) {
        items(IngredientsImagesList) { (ingredient, img) ->
            IngredientItem(
                ingredientImage = img,
                onClick = { onIngredientClick(ingredient) },
                isSelected = selectedIngredients.contains(ingredient)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun IngredientsSectionPreview() {
//    IngredientItem(
//        ingredientImage = R.drawable.basil_3
//    )
//    IngredientItemsRow()
}