package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a skeleton reference to a form template, used for defining form structure.
 * /
 */
@Serializable
public data class FormSkeleton(
	/**
	 * A description of the form skeleton.
	 */
	public val descr: String? = null,
	/**
	 * The identifier of the associated form template.
	 */
	public val formTemplateId: String? = null,
)
