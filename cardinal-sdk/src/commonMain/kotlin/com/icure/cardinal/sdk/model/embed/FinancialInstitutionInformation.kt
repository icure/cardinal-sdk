package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

public sealed interface FinancialInstitutionInformation : Encryptable {
	public val name: String?

	public val key: String?

	public val bankAccount: String?

	public val bic: String?

	public val proxyBankAccount: String?

	public val proxyBic: String?

	public val preferredFiiForPartners: Set<String>

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedFinancialInstitutionInformation(
	override val name: String? = null,
	override val key: String? = null,
	override val bankAccount: String? = null,
	override val bic: String? = null,
	override val proxyBankAccount: String? = null,
	override val proxyBic: String? = null,
	@DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation

@Serializable
public data class EncryptedFinancialInstitutionInformation(
	override val name: String? = null,
	override val key: String? = null,
	override val bankAccount: String? = null,
	override val bic: String? = null,
	override val proxyBankAccount: String? = null,
	override val proxyBic: String? = null,
	@DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation
