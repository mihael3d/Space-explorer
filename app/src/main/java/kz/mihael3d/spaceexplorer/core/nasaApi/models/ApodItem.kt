package kz.mihael3d.spaceexplorer.core.nasaApi.models

import kotlinx.serialization.Serializable

@Serializable
data class ApodItem(
    val title: String? = null,
    val url: String? = null,
    val hdurl: String? = null,
    val date: String? = null,
    val explanation: String? = null,
    val media_type: String? = null,

)


