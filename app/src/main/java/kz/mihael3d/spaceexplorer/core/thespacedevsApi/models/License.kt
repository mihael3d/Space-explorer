package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("priority") val priority: Int,
    @SerialName("link") val link: String? = null
)