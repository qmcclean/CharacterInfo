package com.example.characterinfo.network

import com.example.characterinfo.api.CharacterAPI
import com.example.characterinfo.network.response.CharactersData

class CharacterRepository(private val api: CharacterAPI) {

    suspend fun getCharacters(): CharactersData =
        api.getCharacterResponse()
}