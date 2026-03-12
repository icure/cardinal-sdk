package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 *
 *  DTO containing the result information from a lab or diagnostic report, including patient
 *  identification, protocol data, and associated services.
 */
@Serializable
public class ResultInfo(
	/**
	 * The social security identification number of the patient.
	 */
	public val ssin: String? = null,
	/**
	 * The last name of the patient.
	 */
	public val lastName: String? = null,
	/**
	 * The first name of the patient.
	 */
	public val firstName: String? = null,
	/**
	 * The date of birth of the patient as a fuzzy date (YYYYMMDD format).
	 */
	public val dateOfBirth: Long? = null,
	/**
	 * The sex of the patient.
	 */
	public val sex: String? = null,
	/**
	 * The identifier of the document associated with this result.
	 */
	public val documentId: String? = null,
	/**
	 * The protocol identifier for this result.
	 */
	public val protocol: String? = null,
	/**
	 * Whether the result is complete.
	 */
	public val complete: Boolean? = null,
	/**
	 * The date when the analysis was requested, in epoch milliseconds.
	 */
	public val demandDate: Long? = null,
	/**
	 * The identifier or name of the laboratory that produced the result.
	 */
	public val labo: String? = null,
	/**
	 * The engine or system used to produce the result.
	 */
	public val engine: String? = null,
	/**
	 * The set of codes associated with this result.
	 */
	@param:DefaultValue("emptySet()")
	public val codes: Set<CodeStub> = emptySet(),
	/**
	 * The list of services contained in this result.
	 */
	public val services: List<DecryptedService>? = null,
)
