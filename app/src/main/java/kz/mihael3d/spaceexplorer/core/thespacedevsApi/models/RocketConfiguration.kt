package kz.mihael3d.spaceexplorer.core.thespacedevsApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration details for a specific rocket model.
 */
@Serializable
data class RocketConfiguration(
    /** Unique configuration ID */
    @SerialName("id")
    val id: Int,

    /** Short name of the rocket (e.g., "Falcon 9") */
    @SerialName("name")
    val name: String,

    /** Full technical name including family and version */
    @SerialName("full_name")
    val fullName: String,

    /** Variant or submodel of the configuration */
    @SerialName("variant")
    val variant: String? = null,

    /** List of associated rocket families (if any) */
    @SerialName("families")
    val families: List<RocketFamily>? = null,

    /** API response mode ("list", "normal", etc.) */
    @SerialName("response_mode")
    val responseMode: String? = null
)