package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface FinancialInstitutionInformation : Encryptable {
	public val name: String?

	public val key: String?

	public val bankAccount: String?

	public val bic: String?

	public val proxyBankAccount: String?

	public val proxyBic: String?

	public val preferredFiiForPartners: Set<String>

	override val encryptedSelf: Base64String?
	// region FinancialInstitutionInformation-FinancialInstitutionInformation

	// endregion
}

@Serializable
data class DecryptedFinancialInstitutionInformation(
	override val name: String? = null,
	override val key: String? = null,
	override val bankAccount: String? = null,
	override val bic: String? = null,
	override val proxyBankAccount: String? = null,
	override val proxyBic: String? = null,
	@param:DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation {
	// region FinancialInstitutionInformation-DecryptedFinancialInstitutionInformation

	// endregion
}

@Serializable
data class EncryptedFinancialInstitutionInformation(
	override val name: String? = null,
	override val key: String? = null,
	override val bankAccount: String? = null,
	override val bic: String? = null,
	override val proxyBankAccount: String? = null,
	override val proxyBic: String? = null,
	@param:DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation {
	// region FinancialInstitutionInformation-EncryptedFinancialInstitutionInformation

	// endregion
}
