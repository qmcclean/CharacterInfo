package com.example.characterinfo.network.response

import kotlinx.serialization.Serializable

@Serializable
data class Developer(
    val name: String? = null,
    val type: String? = null,
    val url: String? = null
)
