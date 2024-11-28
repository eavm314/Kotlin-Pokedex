package com.enrique.pokedex.di

import com.enrique.pokedex.ui.dashboard.DashboardViewModel
import com.enrique.pokedex.ui.generation.GenerationViewModel
import com.enrique.pokedex.ui.home.HomeViewModel
import com.enrique.pokedex.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { DashboardViewModel(get()) }
    viewModel { GenerationViewModel() }
    viewModel { HomeViewModel() }
    viewModel { PokedexViewModel(get(), get()) }
}
