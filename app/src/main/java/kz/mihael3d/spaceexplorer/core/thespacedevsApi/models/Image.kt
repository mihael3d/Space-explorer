package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("image_url") val imageUrl: String,
    @SerialName("thumbnail_url") val thumbnailUrl: String,
    @SerialName("credit") val credit: String? = null,
    @SerialName("license") val license: License? = null,
    @SerialName("single_use") val singleUse: Boolean = false
)