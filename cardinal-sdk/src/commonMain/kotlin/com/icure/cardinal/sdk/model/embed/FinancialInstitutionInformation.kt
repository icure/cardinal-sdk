package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Represents information about a financial institution, including bank account details and proxy
 * account configuration.
 * /
 */
public sealed interface FinancialInstitutionInformation : Encryptable {
	/**
	 * The name of the financial institution.
	 */
	public val name: String?

	/**
	 * The key identifying this financial institution information entry.
	 */
	public val key: String?

	/**
	 * The bank account number (e.g., IBAN).
	 */
	public val bankAccount: String?

	/**
	 * The BIC/SWIFT code of the bank.
	 */
	public val bic: String?

	/**
	 * The proxy bank account number.
	 */
	public val proxyBankAccount: String?

	/**
	 * The BIC/SWIFT code for the proxy bank.
	 */
	public val proxyBic: String?

	/**
	 * Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	public val preferredFiiForPartners: Set<String>

	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents information about a financial institution, including bank account details and proxy
 * account configuration.
 * /
 */
@Serializable
public data class DecryptedFinancialInstitutionInformation(
	/**
	 * The name of the financial institution.
	 */
	override val name: String? = null,
	/**
	 * The key identifying this financial institution information entry.
	 */
	override val key: String? = null,
	/**
	 * The bank account number (e.g., IBAN).
	 */
	override val bankAccount: String? = null,
	/**
	 * The BIC/SWIFT code of the bank.
	 */
	override val bic: String? = null,
	/**
	 * The proxy bank account number.
	 */
	override val proxyBankAccount: String? = null,
	/**
	 * The BIC/SWIFT code for the proxy bank.
	 */
	override val proxyBic: String? = null,
	/**
	 * Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	@param:DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation

/**
 * Represents information about a financial institution, including bank account details and proxy
 * account configuration.
 * /
 */
@Serializable
public data class EncryptedFinancialInstitutionInformation(
	/**
	 * The name of the financial institution.
	 */
	override val name: String? = null,
	/**
	 * The key identifying this financial institution information entry.
	 */
	override val key: String? = null,
	/**
	 * The bank account number (e.g., IBAN).
	 */
	override val bankAccount: String? = null,
	/**
	 * The BIC/SWIFT code of the bank.
	 */
	override val bic: String? = null,
	/**
	 * The proxy bank account number.
	 */
	override val proxyBankAccount: String? = null,
	/**
	 * The BIC/SWIFT code for the proxy bank.
	 */
	override val proxyBic: String? = null,
	/**
	 * Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	@param:DefaultValue("emptySet()")
	override val preferredFiiForPartners: Set<String> = emptySet(),
	/**
	 * The base64-encoded encrypted content.
	 */
	override val encryptedSelf: Base64String? = null,
) : FinancialInstitutionInformation
