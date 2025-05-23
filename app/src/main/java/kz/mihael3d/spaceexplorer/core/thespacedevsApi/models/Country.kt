package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("alpha_2_code") val alpha2Code: String,
    @SerialName("alpha_3_code") val alpha3Code: String
)