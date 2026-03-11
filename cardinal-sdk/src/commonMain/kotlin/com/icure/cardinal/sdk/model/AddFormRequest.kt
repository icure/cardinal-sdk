package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Request object used to add a form for a patient.
 * /
 */
@Serializable
public data class AddFormRequest(
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
)
