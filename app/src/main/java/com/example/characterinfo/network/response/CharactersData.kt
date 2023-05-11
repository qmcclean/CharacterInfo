package com.example.characterinfo.network.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersData(
    @SerialName("Abstract")
    val abstract: String? = null,
    @SerialName("AbstractSource")
    val abstractSource: String? = null,
    @SerialName("AbstractText")
    val abstractText: String? = null,
    @SerialName("AbstractURL")
    val abstractURL: String? = null,
    @SerialName("Answer")
    val answer: String? = null,
    @SerialName("AnswerType")
    val answerType: String? = null,
    @SerialName("Definition")
    val definition: String? = null,
    @SerialName("DefinitionSource")
    val definitionSource: String? = null,
    @SerialName("DefinitionURL")
    val definitionURL: String? = null,
    @SerialName("Entity")
    val entity: String? = null,
    @SerialName("Heading")
    val heading: String? = null,
    @SerialName("Image")
    val image: String? = null,
    @SerialName("ImageHeight")
    val imageHeight: Int? = 0,
    @SerialName("ImageIsLogo")
    val imageIsLogo: Int? = 0,
    @SerialName("ImageWidth")
    val imageWidth: Int? = 0,
    @SerialName("Infobox")
    val infobox: String? = null,
    @SerialName("Redirect")
    val redirect: String? = null,
    @SerialName("RelatedTopics")
    val relatedTopics: List<RelatedTopic>? = emptyList(),
    @SerialName("Results")
    @Contextual val results: List<Results>? = emptyList(),
    @SerialName("Type")
    val type: String? = null,
    val meta: Meta? = null
)

@Serializable
data class Results(
    val results: String? = null
)