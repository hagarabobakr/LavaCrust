package com.jetpack.pizzaovenjetpackcompose.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.jetpack.pizzaovenjetpackcompose.presentation.model.Ingredient
import com.jetpack.pizzaovenjetpackcompose.presentation.model.PizzaOvenUiState
import com.jetpack.pizzaovenjetpackcompose.presentation.model.PizzaSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaOvenViewModel : ViewModel() {
    private val _state = MutableStateFlow(PizzaOvenUiState())
    val state = _state.asStateFlow()

    fun onSizeBoxClicked(size: PizzaSize) {
        _state.update {
            it.copy(
                selectedSize = size
            )
        }
    }

    fun onIngredientBoxClicked(ingredient: Ingredient) {
        _state.update { currentState ->
            val newSelection = currentState.selectedIngredients.toMutableSet().apply {
                if (contains(ingredient)) remove(ingredient) else add(ingredient)
            }
            currentState.copy(selectedIngredients = newSelection)
        }
    }
}