package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a single rocket launch event returned by the Launch Library API.
 *
 * Contains metadata such as launch name, time, status, provider, mission, rocket, pad and imagery.
 */

@Serializable
data class LaunchItem(
    /** Unique identifier of the launch within the API */
    @SerialName("id") val id: String,

    /** Full display name of the launch (e.g., "Falcon 9 | Starlink Group 6-54") */
    @SerialName("name") val name: String,

    /** URL-friendly human-readable identifier (used for slugs) */
    @SerialName("slug") val slug: String,

    /** Full URL to the API resource representing this launch */
    @SerialName("url") val url: String,

    /** Current launch status (e.g., success, failure, TBD, etc.) */
    @SerialName("status") val status: Status? = null,

    /** Planned launch time in ISO 8601 format (UTC); may change frequently */
    @SerialName("net") val net: String,

    /** Organization responsible for conducting the launch */
    @SerialName("launch_service_provider") val provider: LaunchServiceProvider? = null,

    /** Rocket configuration used for this launch */
    @SerialName("rocket") val rocket: Rocket? = null,

    /** Mission details, including name, description, and target orbit */
    @SerialName("mission") val mission: Mission? = null,

    /** Launch pad and geographic location from which the rocket will launch */
    @SerialName("pad") val pad: Pad? = null,

    /** Optional image URL representing this launch or vehicle */
    @SerialName("image") val image: Image? = null,


    /** URLs to additional mission information */
    @SerialName("info_urls") val infoUrls: List<String> = emptyList(),

    /** ✅ URLs to live or recorded video streams */
    @SerialName("vid_urls") val vidUrls: List<String> = emptyList()

)