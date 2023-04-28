package com.example.characterinfo.network

import com.example.characterinfo.viewModels.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { CharacterViewModel(get()) }
}