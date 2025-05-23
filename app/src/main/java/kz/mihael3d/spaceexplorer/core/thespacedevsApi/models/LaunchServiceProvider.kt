package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The organization or agency responsible for executing the launch.
 */
@Serializable
data class LaunchServiceProvider(
    /** Unique provider ID */
    @SerialName("id")
    val id: Int,

    /** Name of the organization (e.g., "SpaceX", "Roscosmos") */
    @SerialName("name")
    val name: String,

    /** Provider type, such as "Government" or "Commercial" */
    @SerialName("type")
    val type: AgencyType
)

