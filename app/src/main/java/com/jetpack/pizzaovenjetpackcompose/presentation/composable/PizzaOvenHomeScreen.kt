package com.jetpack.pizzaovenjetpackcompose.presentation.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jetpack.pizzaovenjetpackcompose.presentation.model.Ingredient
import com.jetpack.pizzaovenjetpackcompose.presentation.model.PizzaOvenUiState
import com.jetpack.pizzaovenjetpackcompose.presentation.model.PizzaSize
import com.jetpack.pizzaovenjetpackcompose.presentation.viewModel.PizzaOvenViewModel
import com.jetpack.pizzaovenjetpackcompose.ui.theme.Black
import com.jetpack.pizzaovenjetpackcompose.ui.theme.CustomYourPizzaText
import org.koin.androidx.compose.koinViewModel

@Composable
fun PizzaOvenHomeScreen(viewModel: PizzaOvenViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PizzaOvenHomeScreenContent(
        state = state, onSizeBoxClicked = viewModel::onSizeBoxClicked,
        onIngredientBoxClicked = viewModel::onIngredientBoxClicked
    )
}

@Composable
private fun PizzaOvenHomeScreenContent(
    state: PizzaOvenUiState,
    onSizeBoxClicked: (PizzaSize) -> Unit,
    onIngredientBoxClicked: (Ingredient) -> Unit
) {
    val animatedBreadRadius = animateDpAsState(
        targetValue = when (state.selectedSize) {
            PizzaSize.SMALL -> 220.dp
            PizzaSize.MEDIUM -> 250.dp
            PizzaSize.LARGE -> 280.dp
        },
        animationSpec = tween(200),

        )
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 12.dp)
            .padding(top = 24.dp)
            .verticalScroll(scrollState)
    ) {
        TopAppBar()
        Spacer(modifier = Modifier.height(32.dp))
        PizzaSection(breadRadius = animatedBreadRadius.value)
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$17",
            color = Black,
            fontWeight = FontWeight.Black,
            fontSize = 26.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        PizzaSizesRow(
            selectedSize = state.selectedSize,
            onSizeSelected = onSizeBoxClicked
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "CUSTOMIZE YOUR PIZZA",
            color = CustomYourPizzaText,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            //textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(26.dp))

        IngredientItemsRow(
            onIngredientClick = onIngredientBoxClicked,
            selectedIngredients =state.selectedIngredients
        )
        Spacer(modifier = Modifier.height(50.dp))
         AddToCart()

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PizzaOvenHomeScreenPreview() {
    PizzaOvenHomeScreen()
}