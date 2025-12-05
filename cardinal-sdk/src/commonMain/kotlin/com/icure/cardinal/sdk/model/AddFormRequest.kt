package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class AddFormRequest(
	public val patientId: String? = null,
	public val formId: String? = null,
	public val formTemplateGuid: String? = null,
)
