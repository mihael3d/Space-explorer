package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Physical spaceport or facility location.
 */
@Serializable
data class Location(
    /** Unique location ID */
    @SerialName("id")
    val id: Int,

    /** Human-readable location name (e.g., "Wenchang Space Launch Site") */
    @SerialName("name") val name: String,

    /** Country where this launch site is located */
    @SerialName("country") val country: Country? = null,

    /** Celestial body the location is on (e.g., Earth) */
    @SerialName("celestial_body") val celestialBody: CelestialBody? = null,

    /** Optional representative image of the location */
    @SerialName("image") val image: Image? = null
)
