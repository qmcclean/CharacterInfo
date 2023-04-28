package com.example.characterinfo.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterinfo.models.CharactersData
import com.example.characterinfo.models.RelatedTopic
import com.example.characterinfo.network.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters = MutableLiveData<CharactersData>()
    val characters: LiveData<CharactersData> get() = _characters

    private val _selectedCharacter = MutableLiveData<RelatedTopic>()
    val selectedCharacter: LiveData<RelatedTopic> get() = _selectedCharacter

    fun fetchData() {
        viewModelScope.launch {
            getData()
        }
    }

    fun setSelectCharacter(item: RelatedTopic) {
        _selectedCharacter.value = item
    }

    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val response = repository.getCharacters()
            _characters.postValue(response)
        }
    }
}