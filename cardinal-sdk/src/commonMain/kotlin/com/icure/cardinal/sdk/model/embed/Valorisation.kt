package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

public sealed interface Valorisation : Encryptable {
	public val startOfValidity: Long?

	public val endOfValidity: Long?

	public val predicate: String?

	public val reference: List<Int>?

	public val totalAmount: Double?

	public val reimbursement: Double?

	public val patientIntervention: Double?

	public val doctorSupplement: Double?

	public val vat: Double?

	public val label: Map<String, String>?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedValorisation(
	override val startOfValidity: Long? = null,
	override val endOfValidity: Long? = null,
	override val predicate: String? = null,
	override val reference: List<Int>? = null,
	override val totalAmount: Double? = null,
	override val reimbursement: Double? = null,
	override val patientIntervention: Double? = null,
	override val doctorSupplement: Double? = null,
	override val vat: Double? = null,
	@DefaultValue("emptyMap()")
	override val label: Map<String, String>? = emptyMap(),
	override val encryptedSelf: Base64String? = null,
) : Valorisation

@Serializable
public data class EncryptedValorisation(
	override val startOfValidity: Long? = null,
	override val endOfValidity: Long? = null,
	override val predicate: String? = null,
	override val reference: List<Int>? = null,
	override val totalAmount: Double? = null,
	override val reimbursement: Double? = null,
	override val patientIntervention: Double? = null,
	override val doctorSupplement: Double? = null,
	override val vat: Double? = null,
	@DefaultValue("emptyMap()")
	override val label: Map<String, String>? = emptyMap(),
	override val encryptedSelf: Base64String? = null,
) : Valorisation
