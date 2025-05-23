package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Launch pad or specific physical site used for the launch.
 */
@Serializable
data class Pad(
    /** Unique pad ID */
    @SerialName("id")
    val id: Int,

    /** Name of the launch pad (e.g., "201") */
    @SerialName("name") val name: String,

    /** Optional description */
    @SerialName("description") val description: String? = null,

    /** Google Maps URL with coordinates */
    @SerialName("map_url") val mapUrl: String? = null,

    /** Location (site/cosmodrome) that this pad belongs to */
    @SerialName("location") val location: Location,

    /** Country in which this pad is located */
    @SerialName("country") val country: Country? = null,

    /** Optional image of the pad */
    @SerialName("image") val image: Image? = null
)
