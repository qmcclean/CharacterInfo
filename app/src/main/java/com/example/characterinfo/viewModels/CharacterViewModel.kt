package com.example.characterinfo.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterinfo.models.CharactersUIData
import com.example.characterinfo.network.CharacterRepository
import com.example.characterinfo.network.response.RelatedTopic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters = MutableLiveData<CharactersUIData>()
    val characters: LiveData<CharactersUIData> get() = _characters

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
            _characters.postValue(
                response.let {
                    CharactersUIData(
                        heading = it.heading.orEmpty(),
                        relatedTopics = it.relatedTopics.orEmpty()
                    )
                }
            )
        }
    }
}