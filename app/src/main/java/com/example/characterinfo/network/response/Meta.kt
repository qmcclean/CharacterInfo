package com.example.characterinfo.network.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @Contextual val attribution: Attribution? = null,
    @SerialName("blockgroup")
    @Contextual val blockGroup: BlockGroup? = null,
    @SerialName("created_date")
    @Contextual val createdDate: CreatedDate? = null,
    val description: String? = null,
    @Contextual val designer: Designer? = null,
    @SerialName("dev_date")
    @Contextual val devDate: DevDate? = null,
    @SerialName("dev_milestone")
    val devMilestone: String? = null,
    val developer: List<Developer>? = emptyList(),
    @SerialName("example_query")
    val exampleQuery: String? = null,
    val id: String? = null,
    @SerialName("is_stackexchange")
    @Contextual val isStackExchange: IsStackExchange? = null,
    @SerialName("js_callback_name")
    val jsCallbackName: String? = null,
    @SerialName("live_date")
    @Contextual val liveDate: LiveDate? = null,
    val maintainer: Maintainer? = null,
    val name: String? = null,
    @SerialName("perl_module")
    val perlModule: String? = null,
    @Contextual val producer: Producer? = null,
    @SerialName("production_state")
    val productionState: String? = null,
    val repo: String? = null,
    @SerialName("signal_from")
    val signalFrom: String? = null,
    @SerialName("src_domain")
    val srcDomain: String? = null,
    @SerialName("src_id")
    val srcId: Int? = null,
    @SerialName("src_name")
    val srcName: String? = null,
    @SerialName("src_options")
    val srcOptions: SrcOptions? = null,
    @SerialName("src_url")
    @Contextual val srcUrl: SrcUrl? = null,
    val status: String? = null,
    val tab: String? = null,
    val topic: List<String>? = emptyList(),
    val unsafe: Int? = 0
)

@Serializable
data class Attribution(
    val attribution: String? = null
)

@Serializable
data class BlockGroup(
    val blockGroup: String? = null
)

@Serializable
data class CreatedDate(
    val createdDate: String? = null
)

@Serializable
data class Designer(
    val designer: String? = null
)

@Serializable
data class DevDate(
    val devDate: String? = null
)

@Serializable
data class IsStackExchange(
    val isStackexchange: String? = null
)

@Serializable
data class LiveDate(
    val liveDate: String? = null,
)

@Serializable
data class Producer(
    val producer: String? = null,
)

@Serializable
data class SrcUrl(
    val srcUrl: String? = null,
)
