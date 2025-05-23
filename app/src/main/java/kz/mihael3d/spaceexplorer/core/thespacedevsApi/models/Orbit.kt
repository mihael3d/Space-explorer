package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the target orbit or trajectory for the mission.
 */
@Serializable
data class Orbit(
    /** Unique orbit ID */
    @SerialName("id")
    val id: Int,

    /** Orbit name (e.g., "Low Earth Orbit") */
    @SerialName("name")
    val name: String,

    /** Abbreviation (e.g., "LEO", "GTO") */
    @SerialName("abbrev")
    val abbrev: String
)
