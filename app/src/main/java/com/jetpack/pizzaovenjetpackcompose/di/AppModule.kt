package com.jetpack.pizzaovenjetpackcompose.di

import com.jetpack.pizzaovenjetpackcompose.presentation.viewModel.PizzaOvenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModel{
        PizzaOvenViewModel()
    }
}