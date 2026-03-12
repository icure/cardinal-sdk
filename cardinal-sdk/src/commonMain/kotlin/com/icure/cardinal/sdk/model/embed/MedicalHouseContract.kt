// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

/**
 * Represents a medical house contract (inscription period) for a patient, including coverage
 * details,
 * suspension periods, and signature information.
 * /
 */

sealed interface MedicalHouseContract : Encryptable {
	/**
	 * The identifier of the contract.
	 */
	public val contractId: String?

	/**
	 * The start of the contract period (yyyyMMdd).
	 */
	public val validFrom: Long?

	/**
	 * The end of the contract period (yyyyMMdd).
	 */
	public val validTo: Long?

	/**
	 * The NIHII number of the medical house.
	 */
	public val mmNihii: String?

	/**
	 * The identifier of the healthcare party.
	 */
	public val hcpId: String?

	/**
	 * The type of contract change (inscription, coverageChange, suspension).
	 */
	public val changeType: ContractChangeType?

	/**
	 * The identifier of the parent contract.
	 */
	public val parentContractId: String?

	/**
	 * Who changed the contract (user or mcn).
	 */
	public val changedBy: String?

	/**
	 * The contract signature date (yyyyMMdd).
	 */
	public val startOfContract: Long?

	/**
	 * The start of coverage date (yyyyMMdd).
	 */
	public val startOfCoverage: Long?

	/**
	 * The contract end signature date (yyyyMMdd).
	 */
	public val endOfContract: Long?

	/**
	 * The end of coverage date (yyyyMMdd).
	 */
	public val endOfCoverage: Long?

	/**
	 * Whether kinesitherapy is covered.
	 */
	public val kine: Boolean

	/**
	 * Whether general practitioner care is covered.
	 */
	public val gp: Boolean

	/**
	 * Whether PTD is covered.
	 */
	public val ptd: Boolean

	/**
	 * Whether nursing care is covered.
	 */
	public val nurse: Boolean

	/**
	 * Whether kinesitherapy is excluded.
	 */
	public val noKine: Boolean

	/**
	 * Whether general practitioner care is excluded.
	 */
	public val noGp: Boolean

	/**
	 * Whether nursing care is excluded.
	 */
	public val noNurse: Boolean

	/**
	 * The reason identifier for unsubscription.
	 */
	public val unsubscriptionReasonId: Int?

	/**
	 * The start date of PTD coverage.
	 */
	public val ptdStart: Long?

	/**
	 * The end date of PTD coverage.
	 */
	public val ptdEnd: Long?

	/**
	 * The date PTD was last invoiced.
	 */
	public val ptdLastInvoiced: Long?

	/**
	 * The start of suspension date (yyyyMMdd).
	 */
	public val startOfSuspension: Long?

	/**
	 * The end of suspension date (yyyyMMdd).
	 */
	public val endOfSuspension: Long?

	/**
	 * The reason for suspension.
	 */
	public val suspensionReason: SuspensionReason?

	/**
	 * The source of the suspension.
	 */
	public val suspensionSource: String?

	/**
	 * Whether the suspension is forced (no automatic unsuspension).
	 */
	public val forcedSuspension: Boolean

	/**
	 * The type of signature used for the contract.
	 */
	public val signatureType: MhcSignatureType?

	/**
	 * The contract status.
	 */
	public val status: Int?

	/**
	 * Additional options as key-value pairs.
	 */
	public val options: Map<String, String>

	/**
	 * Receipt identifiers as key-value pairs.
	 */
	public val receipts: Map<String, String>

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
	// region MedicalHouseContract-MedicalHouseContract

	// endregion
}

/**
 * Represents a medical house contract (inscription period) for a patient, including coverage
 * details,
 * suspension periods, and signature information.
 * /
 */
@Serializable
data class DecryptedMedicalHouseContract(
	/**
	 * The identifier of the contract.
	 */
	override val contractId: String? = null,
	/**
	 * The start of the contract period (yyyyMMdd).
	 */
	override val validFrom: Long? = null,
	/**
	 * The end of the contract period (yyyyMMdd).
	 */
	override val validTo: Long? = null,
	/**
	 * The NIHII number of the medical house.
	 */
	override val mmNihii: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	override val hcpId: String? = null,
	/**
	 * The type of contract change (inscription, coverageChange, suspension).
	 */
	override val changeType: ContractChangeType? = null,
	/**
	 * The identifier of the parent contract.
	 */
	override val parentContractId: String? = null,
	/**
	 * Who changed the contract (user or mcn).
	 */
	override val changedBy: String? = null,
	/**
	 * The contract signature date (yyyyMMdd).
	 */
	override val startOfContract: Long? = null,
	/**
	 * The start of coverage date (yyyyMMdd).
	 */
	override val startOfCoverage: Long? = null,
	/**
	 * The contract end signature date (yyyyMMdd).
	 */
	override val endOfContract: Long? = null,
	/**
	 * The end of coverage date (yyyyMMdd).
	 */
	override val endOfCoverage: Long? = null,
	/**
	 * Whether kinesitherapy is covered.
	 */
	@param:DefaultValue("false")
	override val kine: Boolean = false,
	/**
	 * Whether general practitioner care is covered.
	 */
	@param:DefaultValue("false")
	override val gp: Boolean = false,
	/**
	 * Whether PTD is covered.
	 */
	@param:DefaultValue("false")
	override val ptd: Boolean = false,
	/**
	 * Whether nursing care is covered.
	 */
	@param:DefaultValue("false")
	override val nurse: Boolean = false,
	/**
	 * Whether kinesitherapy is excluded.
	 */
	@param:DefaultValue("false")
	override val noKine: Boolean = false,
	/**
	 * Whether general practitioner care is excluded.
	 */
	@param:DefaultValue("false")
	override val noGp: Boolean = false,
	/**
	 * Whether nursing care is excluded.
	 */
	@param:DefaultValue("false")
	override val noNurse: Boolean = false,
	/**
	 * The reason identifier for unsubscription.
	 */
	override val unsubscriptionReasonId: Int? = null,
	/**
	 * The start date of PTD coverage.
	 */
	override val ptdStart: Long? = null,
	/**
	 * The end date of PTD coverage.
	 */
	override val ptdEnd: Long? = null,
	/**
	 * The date PTD was last invoiced.
	 */
	override val ptdLastInvoiced: Long? = null,
	/**
	 * The start of suspension date (yyyyMMdd).
	 */
	override val startOfSuspension: Long? = null,
	/**
	 * The end of suspension date (yyyyMMdd).
	 */
	override val endOfSuspension: Long? = null,
	/**
	 * The reason for suspension.
	 */
	override val suspensionReason: SuspensionReason? = null,
	/**
	 * The source of the suspension.
	 */
	override val suspensionSource: String? = null,
	/**
	 * Whether the suspension is forced (no automatic unsuspension).
	 */
	@param:DefaultValue("false")
	override val forcedSuspension: Boolean = false,
	/**
	 * The type of signature used for the contract.
	 */
	override val signatureType: MhcSignatureType? = null,
	/**
	 * The contract status.
	 */
	override val status: Int? = null,
	/**
	 * Additional options as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * Receipt identifiers as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : MedicalHouseContract {
	// region MedicalHouseContract-DecryptedMedicalHouseContract

	// endregion
}

/**
 * Represents a medical house contract (inscription period) for a patient, including coverage
 * details,
 * suspension periods, and signature information.
 * /
 */
@Serializable
data class EncryptedMedicalHouseContract(
	/**
	 * The identifier of the contract.
	 */
	override val contractId: String? = null,
	/**
	 * The start of the contract period (yyyyMMdd).
	 */
	override val validFrom: Long? = null,
	/**
	 * The end of the contract period (yyyyMMdd).
	 */
	override val validTo: Long? = null,
	/**
	 * The NIHII number of the medical house.
	 */
	override val mmNihii: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	override val hcpId: String? = null,
	/**
	 * The type of contract change (inscription, coverageChange, suspension).
	 */
	override val changeType: ContractChangeType? = null,
	/**
	 * The identifier of the parent contract.
	 */
	override val parentContractId: String? = null,
	/**
	 * Who changed the contract (user or mcn).
	 */
	override val changedBy: String? = null,
	/**
	 * The contract signature date (yyyyMMdd).
	 */
	override val startOfContract: Long? = null,
	/**
	 * The start of coverage date (yyyyMMdd).
	 */
	override val startOfCoverage: Long? = null,
	/**
	 * The contract end signature date (yyyyMMdd).
	 */
	override val endOfContract: Long? = null,
	/**
	 * The end of coverage date (yyyyMMdd).
	 */
	override val endOfCoverage: Long? = null,
	/**
	 * Whether kinesitherapy is covered.
	 */
	@param:DefaultValue("false")
	override val kine: Boolean = false,
	/**
	 * Whether general practitioner care is covered.
	 */
	@param:DefaultValue("false")
	override val gp: Boolean = false,
	/**
	 * Whether PTD is covered.
	 */
	@param:DefaultValue("false")
	override val ptd: Boolean = false,
	/**
	 * Whether nursing care is covered.
	 */
	@param:DefaultValue("false")
	override val nurse: Boolean = false,
	/**
	 * Whether kinesitherapy is excluded.
	 */
	@param:DefaultValue("false")
	override val noKine: Boolean = false,
	/**
	 * Whether general practitioner care is excluded.
	 */
	@param:DefaultValue("false")
	override val noGp: Boolean = false,
	/**
	 * Whether nursing care is excluded.
	 */
	@param:DefaultValue("false")
	override val noNurse: Boolean = false,
	/**
	 * The reason identifier for unsubscription.
	 */
	override val unsubscriptionReasonId: Int? = null,
	/**
	 * The start date of PTD coverage.
	 */
	override val ptdStart: Long? = null,
	/**
	 * The end date of PTD coverage.
	 */
	override val ptdEnd: Long? = null,
	/**
	 * The date PTD was last invoiced.
	 */
	override val ptdLastInvoiced: Long? = null,
	/**
	 * The start of suspension date (yyyyMMdd).
	 */
	override val startOfSuspension: Long? = null,
	/**
	 * The end of suspension date (yyyyMMdd).
	 */
	override val endOfSuspension: Long? = null,
	/**
	 * The reason for suspension.
	 */
	override val suspensionReason: SuspensionReason? = null,
	/**
	 * The source of the suspension.
	 */
	override val suspensionSource: String? = null,
	/**
	 * Whether the suspension is forced (no automatic unsuspension).
	 */
	@param:DefaultValue("false")
	override val forcedSuspension: Boolean = false,
	/**
	 * The type of signature used for the contract.
	 */
	override val signatureType: MhcSignatureType? = null,
	/**
	 * The contract status.
	 */
	override val status: Int? = null,
	/**
	 * Additional options as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val options: Map<String, String> = emptyMap(),
	/**
	 * Receipt identifiers as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val receipts: Map<String, String> = emptyMap(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : MedicalHouseContract {
	// region MedicalHouseContract-EncryptedMedicalHouseContract

	// endregion
}
