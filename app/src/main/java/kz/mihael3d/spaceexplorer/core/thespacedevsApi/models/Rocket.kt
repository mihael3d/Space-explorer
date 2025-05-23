package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the rocket used in the launch.
 *
 * Includes general type and configuration details.
 */
@Serializable
data class Rocket(
    /** Unique rocket ID */
    @SerialName("id")
    val id: Int,

    /** Specific configuration of the rocket */
    @SerialName("configuration")
    val configuration: RocketConfiguration
)