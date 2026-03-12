// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Request object used to add a form for a patient.
 * /
 */
@Serializable
data class AddFormRequest(
	/**
	 * The unique identifier of the patient to associate the form with.
	 */
	public val patientId: String? = null,
	/**
	 * The unique identifier of the form to add.
	 */
	public val formId: String? = null,
	/**
	 * The GUID of the form template to use for creating the form.
	 */
	public val formTemplateGuid: String? = null,
) {
	// region AddFormRequest-AddFormRequest

	// endregion
}
