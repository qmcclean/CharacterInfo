package com.example.characterinfo.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit

private const val CONTENT_TYPE_JSON = "application/json"
private const val BASE_URL = "https://api.duckduckgo.com/"

@OptIn(ExperimentalSerializationApi::class)
val apiModule = module {
    single {
        val builder = OkHttpClient.Builder()
        with(builder) {
            build()
        }
    }

    single { Json { ignoreUnknownKeys = true } }

    single<Retrofit> {
        createRetrofit(
            client = get(),
            json = get()
        )
    }

    single<CharacterAPI> { provideAPI() }
}

@OptIn(ExperimentalSerializationApi::class)
private fun createRetrofit(
    client: OkHttpClient,
    json: Json
): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(json.asConverterFactory(CONTENT_TYPE_JSON.toMediaType()))
    .client(client)
    .build()

private inline fun <reified T> Scope.provideAPI(name: String? = null): T =
    get<Retrofit>(name?.let { named(it) }).create(T::class.java)