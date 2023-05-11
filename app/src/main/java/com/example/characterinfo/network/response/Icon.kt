package com.example.characterinfo.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Icon(
    @SerialName("Height")
    val height: String? = null,
    @SerialName("URL")
    val url: String? = null,
    @SerialName("Width")
    val width: String? = null
)
