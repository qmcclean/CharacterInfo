package com.example.characterinfo.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RelatedTopic(
    @SerialName("FirstURL")
    val firstURL: String? = null,
    @SerialName("Icon")
    val icon: Icon? = null,
    @SerialName("Text")
    val text: String? = null
)
