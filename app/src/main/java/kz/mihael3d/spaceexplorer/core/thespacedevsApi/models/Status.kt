package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the current status of a launch event.
 *
 * Includes a textual label, short abbreviation, and explanation.
 */
@Serializable
data class Status(
    /** Unique identifier of the status type */
    @SerialName("id")
    val id: Int,

    /** Human-readable status name (e.g., "Launch Successful") */
    @SerialName("name")
    val name: String,

    /** Short abbreviated code (e.g., "Success", "Failure") */
    @SerialName("abbrev")
    val abbrev: String,

    /** Description of what this status means operationally */
    @SerialName("description")
    val description: String
)
