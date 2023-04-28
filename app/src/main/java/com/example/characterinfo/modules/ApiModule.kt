package com.example.characterinfo.api

import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    val okHttpClient = OkHttpClient.Builder().build()

    single {
        Retrofit.Builder()
            .baseUrl("https://api.duckduckgo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    single<CharacterAPI> { provideAPI() }

}

private inline fun <reified T> Scope.provideAPI(name: String? = null): T =
    get<Retrofit>(name?.let { named(it) }).create(T::class.java)