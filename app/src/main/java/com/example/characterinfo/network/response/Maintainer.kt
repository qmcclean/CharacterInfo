package com.example.characterinfo.network.response

import kotlinx.serialization.Serializable

@Serializable
data class Maintainer(
    val github: String? = null
)
