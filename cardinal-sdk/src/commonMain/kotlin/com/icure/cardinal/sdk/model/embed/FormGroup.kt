package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a group of forms, identified by a GUID and a human-readable name.
 * /
 */
@Serializable
public data class FormGroup(
	/**
	 * The globally unique identifier for this form group.
	 */
	public val guid: String? = null,
	/**
	 * The human-readable name of the form group.
	 */
	public val name: String? = null,
)
