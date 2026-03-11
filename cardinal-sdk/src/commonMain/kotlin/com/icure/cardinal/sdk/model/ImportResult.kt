package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.MimeAttachment
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * DTO containing the results of a data import operation, including all the entities that were
 * imported and any warnings or errors encountered during the process.
 * /
 */
@Serializable
public data class ImportResult(
	/**
	 * The patient that was imported or matched during the import.
	 */
	public val patient: DecryptedPatient? = null,
	/**
	 * The list of health elements imported.
	 */
	@param:DefaultValue("emptyList()")
	public val hes: List<DecryptedHealthElement> = emptyList(),
	/**
	 * The list of contacts imported.
	 */
	@param:DefaultValue("emptyList()")
	public val ctcs: List<DecryptedContact> = emptyList(),
	/**
	 * The list of warning messages generated during import.
	 */
	@param:DefaultValue("emptyList()")
	public val warnings: List<String> = emptyList(),
	/**
	 * The list of error messages generated during import.
	 */
	@param:DefaultValue("emptyList()")
	public val errors: List<String> = emptyList(),
	/**
	 * The list of forms imported.
	 */
	@param:DefaultValue("emptyList()")
	public val forms: List<DecryptedForm> = emptyList(),
	/**
	 * The list of healthcare parties imported.
	 */
	@param:DefaultValue("emptyList()")
	public val hcps: List<HealthcareParty> = emptyList(),
	/**
	 * The list of documents imported.
	 */
	@param:DefaultValue("emptyList()")
	public val documents: List<DecryptedDocument> = emptyList(),
	/**
	 * A map of MIME attachments associated with the import, keyed by attachment identifier.
	 */
	@param:DefaultValue("emptyMap()")
	public val attachments: Map<String, MimeAttachment> = emptyMap(),
)
