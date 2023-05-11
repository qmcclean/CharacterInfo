package com.example.characterinfo.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SrcOptions(
    val directory: String? = null,
    @SerialName("is_fanon")
    val isFanon: Int? = 0,
    @SerialName("is_mediawiki")
    val isMediawiki: Int? = 0,
    @SerialName("is_wikipedia")
    val isWikipedia: Int? = 0,
    val language: String? = null,
    @SerialName("min_abstract_length")
    val minAbstractLength: String? = null,
    @SerialName("skip_abstract")
    val skipAbstract: Int? = 0,
    @SerialName("skip_abstract_paren")
    val skipAbstractParen: Int? = 0,
    @SerialName("skip_end")
    val skipEnd: String? = null,
    @SerialName("skip_icon")
    val skipIcon: Int? = 0,
    @SerialName("skip_image_name")
    val skipImageName: Int? = 0,
    @SerialName("skip_qr")
    val skipQr: String? = null,
    @SerialName("source_skip")
    val sourceSkip: String? = null,
    @SerialName("src_info")
    val srcInfo: String? = null
)
