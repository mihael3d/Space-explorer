package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Top-level response model returned by the Launch Library API when requesting upcoming launches.
 *
 * Contains pagination metadata and a list of [LaunchItem] objects.
 */
@Serializable
data class LaunchResponse(
    /** Total number of launch records matching the query */
    @SerialName("count")
    val count: Int,

    /** URL to the next page of results (if available) */
    @SerialName("next")
    val next: String? = null,

    /** URL to the previous page of results (if applicable) */
    @SerialName("previous")
    val previous: String? = null,

    /** List of upcoming launch items */
    @SerialName("results")
    val results: List<LaunchItem>
)
