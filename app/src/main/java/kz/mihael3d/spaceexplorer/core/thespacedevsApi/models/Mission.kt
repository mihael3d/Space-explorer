package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the purpose and profile of the launch mission.
 */
@Serializable
data class Mission(
    /** Unique mission ID */
    @SerialName("id")
    val id: Int,

    /** Name of the mission (e.g., "Starlink Group 6-58") */
    @SerialName("name")
    val name: String,

    /** Mission description and objectives */
    @SerialName("description")
    val description: String? = null,

    /** Type of mission (e.g., "Communications", "Earth Observation") */
    @SerialName("type")
    val type: String? = null,

    /** Orbital destination or trajectory type */
    @SerialName("orbit")
    val orbit: Orbit? = null
)