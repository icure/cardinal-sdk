package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

public sealed interface MedicalHouseContract : Encryptable {
	public val contractId: String?

	public val validFrom: Long?

	public val validTo: Long?

	public val mmNihii: String?

	public val hcpId: String?

	public val changeType: ContractChangeType?

	public val parentContractId: String?

	public val changedBy: String?

	public val startOfContract: Long?

	public val startOfCoverage: Long?

	public val endOfContract: Long?

	public val endOfCoverage: Long?

	public val kine: Boolean

	public val gp: Boolean

	public val ptd: Boolean

	public val nurse: Boolean

	public val noKine: Boolean

	public val noGp: Boolean

	public val noNurse: Boolean

	public val unsubscriptionReasonId: Int?

	public val ptdStart: Long?

	public val ptdEnd: Long?

	public val ptdLastInvoiced: Long?

	public val startOfSuspension: Long?

	public val endOfSuspension: Long?

	public val suspensionReason: SuspensionReason?

	public val suspensionSource: String?

	public val forcedSuspension: Boolean

	public val signatureType: MhcSignatureType?

	public val status: Int?

	public val options: Map<String, String>

	public val receipts: Map<String, String>

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedMedicalHouseContract(
	override val contractId: String? = null,
	override val validFrom: Long? = null,
	override val validTo: Long? = null,
	override val mmNihii: String? = null,
	override val hcpId: String? = null,
	override val changeType: ContractChangeType? = null,
	override val parentContractId: String? = null,
	override val changedBy: String? = null,
	override val startOfContract: Long? = null,
	override val startOfCoverage: Long? = null,
	override val endOfContract: Long? = null,
	override val endOfCoverage: Long? = null,
	@DefaultValue("false")
	override val kine: Boolean = false,
	@DefaultValue("false")
	override val gp: Boolean = false,
	@DefaultValue("false")
	override val ptd: Boolean = false,
	@DefaultValue("false")
	override val nurse: Boolean = false,
	@DefaultValue("false")
	override val noKine: Boolean = false,
	@DefaultValue("false")
	override val noGp: Boolean = false,
	@DefaultValue("false")
	override val noNurse: Boolean = false,
	override val unsubscriptionReasonId: Int? = null,
	override val ptdStart: Long? = null,
	override val ptdEnd: Long? = null,
	override val ptdLastInvoiced: Long? = null,
	override val startOfSuspension: Long? = null,
	override val endOfSuspension: Long? = null,
	override val suspensionReason: SuspensionReason? = null,
	override val suspensionSource: String? = null,
	@DefaultValue("false")
	override val forcedSuspension: Boolean = false,
	override val signatureType: MhcSignatureType? = null,
	override val status: Int? = null,
	@DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
) : MedicalHouseContract

@Serializable
public data class EncryptedMedicalHouseContract(
	override val contractId: String? = null,
	override val validFrom: Long? = null,
	override val validTo: Long? = null,
	override val mmNihii: String? = null,
	override val hcpId: String? = null,
	override val changeType: ContractChangeType? = null,
	override val parentContractId: String? = null,
	override val changedBy: String? = null,
	override val startOfContract: Long? = null,
	override val startOfCoverage: Long? = null,
	override val endOfContract: Long? = null,
	override val endOfCoverage: Long? = null,
	@DefaultValue("false")
	override val kine: Boolean = false,
	@DefaultValue("false")
	override val gp: Boolean = false,
	@DefaultValue("false")
	override val ptd: Boolean = false,
	@DefaultValue("false")
	override val nurse: Boolean = false,
	@DefaultValue("false")
	override val noKine: Boolean = false,
	@DefaultValue("false")
	override val noGp: Boolean = false,
	@DefaultValue("false")
	override val noNurse: Boolean = false,
	override val unsubscriptionReasonId: Int? = null,
	override val ptdStart: Long? = null,
	override val ptdEnd: Long? = null,
	override val ptdLastInvoiced: Long? = null,
	override val startOfSuspension: Long? = null,
	override val endOfSuspension: Long? = null,
	override val suspensionReason: SuspensionReason? = null,
	override val suspensionSource: String? = null,
	@DefaultValue("false")
	override val forcedSuspension: Boolean = false,
	override val signatureType: MhcSignatureType? = null,
	override val status: Int? = null,
	@DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
) : MedicalHouseContract
