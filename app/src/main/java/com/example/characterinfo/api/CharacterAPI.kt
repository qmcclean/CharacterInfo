package com.example.characterinfo.api

import com.example.characterinfo.BuildConfig
import com.example.characterinfo.network.response.CharactersData
import retrofit2.http.GET


interface CharacterAPI {
    @GET(BuildConfig.DATA_API)
    suspend fun getCharacterResponse(): CharactersData
}