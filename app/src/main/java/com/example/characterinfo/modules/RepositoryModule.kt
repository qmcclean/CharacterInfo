package com.example.characterinfo.modules

import com.example.characterinfo.network.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CharacterRepository(get()) }
}