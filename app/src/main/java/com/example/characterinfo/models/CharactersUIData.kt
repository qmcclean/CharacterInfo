package com.example.characterinfo.models

import com.example.characterinfo.network.response.RelatedTopic

data class CharactersUIData(
    val heading: String,
    val relatedTopics: List<RelatedTopic>
)
