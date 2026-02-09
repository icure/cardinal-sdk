package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.MimeAttachment
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ImportResult(
	public val patient: DecryptedPatient? = null,
	@param:DefaultValue("emptyList()")
	public val hes: List<DecryptedHealthElement> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val ctcs: List<DecryptedContact> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val warnings: List<String> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val errors: List<String> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val forms: List<DecryptedForm> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val hcps: List<HealthcareParty> = emptyList(),
	@param:DefaultValue("emptyList()")
	public val documents: List<DecryptedDocument> = emptyList(),
	@param:DefaultValue("emptyMap()")
	public val attachments: Map<String, MimeAttachment> = emptyMap(),
) {
	// region ImportResult-ImportResult

	// endregion
}
