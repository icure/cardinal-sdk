package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO representing an email template with a subject and body.
 * /
 */
@Serializable
public data class EmailTemplate(
	/**
	 * The subject line of the email template.
	 */
	public val subject: String? = null,
	/**
	 * The body content of the email template.
	 */
	public val body: String? = null,
)
