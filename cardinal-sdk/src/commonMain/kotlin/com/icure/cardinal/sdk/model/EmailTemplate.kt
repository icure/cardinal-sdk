// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO representing an email template with a subject and body.
 * /
 */
@Serializable
data class EmailTemplate(
	/**
	 * The subject line of the email template.
	 */
	public val subject: String? = null,
	/**
	 * The body content of the email template.
	 */
	public val body: String? = null,
) {
	// region EmailTemplate-EmailTemplate

	// endregion
}
