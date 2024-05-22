// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model

import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.CryptoActorJs
import com.icure.sdk.js.model.base.DataOwnerJs
import com.icure.sdk.js.model.base.HasCodesJs
import com.icure.sdk.js.model.base.HasTagsJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.NamedJs
import com.icure.sdk.js.model.base.PersonJs
import com.icure.sdk.js.model.base.StoredDocumentJs
import com.icure.sdk.js.model.embed.DecryptedAddressJs
import com.icure.sdk.js.model.embed.DecryptedFinancialInstitutionInformationJs
import com.icure.sdk.js.model.embed.DecryptedFlatRateTarificationJs
import com.icure.sdk.js.model.embed.HealthcarePartyHistoryStatusJs
import com.icure.sdk.js.model.embed.PersonNameJs
import kotlin.Array
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("HealthcareParty")
public external class HealthcarePartyJs(
	partial: dynamic,
) : StoredDocumentJs, NamedJs, PersonJs, CryptoActorJs, DataOwnerJs, HasCodesJs, HasTagsJs {
	override val id: String

	override val rev: String?

	public val created: Double?

	public val modified: Double?

	override val deletionDate: Double?

	public val identifier: Array<IdentifierJs>

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val name: String?

	override val lastName: String?

	override val firstName: String?

	override val names: Array<PersonNameJs>

	override val gender: String?

	override val civility: String?

	override val companyName: String?

	public val speciality: String?

	public val bankAccount: String?

	public val bic: String?

	public val proxyBankAccount: String?

	public val proxyBic: String?

	public val invoiceHeader: String?

	public val cbe: String?

	public val ehp: String?

	public val userId: String?

	public val parentId: String?

	public val convention: Double?

	public val nihii: String?

	public val nihiiSpecCode: String?

	public val ssin: String?

	override val addresses: Array<DecryptedAddressJs>

	override val languages: Array<String>

	public val picture: ByteArray?

	public val statuses: Array<String>

	public val statusHistory: Array<HealthcarePartyHistoryStatusJs>

	public val specialityCodes: Array<CodeStubJs>

	public val sendFormats: dynamic

	public val notes: String?

	public val financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformationJs>

	public val descr: dynamic

	public val billingType: String?

	public val type: String?

	public val contactPerson: String?

	public val contactPersonHcpId: String?

	public val supervisorId: String?

	public val flatRateTarifications: Array<DecryptedFlatRateTarificationJs>

	public val importedData: dynamic

	public val options: dynamic

	override val properties: Array<DecryptedPropertyStubJs>

	override val hcPartyKeys: dynamic

	override val aesExchangeKeys: dynamic

	override val transferKeys: dynamic

	override val privateKeyShamirPartitions: dynamic

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>
}
