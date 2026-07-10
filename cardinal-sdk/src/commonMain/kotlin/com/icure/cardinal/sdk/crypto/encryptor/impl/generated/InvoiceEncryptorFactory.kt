// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object InvoiceEncryptorFactory : EntityEncryptorFactory<EncryptedInvoice, DecryptedInvoice> {
	override val empty: EntityEncryptor<EncryptedInvoice, DecryptedInvoice> =
		InvoiceEncryptor(
			identifier_e = false,
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			tags_e = false,
			codes_e = false,
			invoiceDate_e = false,
			sentDate_e = false,
			printedDate_e = false,
			invoicingCodes_e = EncryptableFieldConfig.None(InvoicingCodeEncryptorFactory),
			receipts_e = false,
			recipientId_e = false,
			invoiceReference_e = false,
			decisionReference_e = false,
			thirdPartyReference_e = false,
			thirdPartyPaymentJustification_e = false,
			thirdPartyPaymentReason_e = false,
			reason_e = false,
			groupId_e = false,
			paymentType_e = false,
			paid_e = false,
			payments_e = false,
			gnotionSsin_e = false,
			gnotionLastName_e = false,
			gnotionFirstName_e = false,
			gnotionCdHcParty_e = false,
			invoicePeriod_e = false,
			careProviderType_e = false,
			internshipSsin_e = false,
			internshipLastName_e = false,
			internshipFirstName_e = false,
			internshipCdHcParty_e = false,
			internshipCbe_e = false,
			supervisorSsin_e = false,
			supervisorLastName_e = false,
			supervisorFirstName_e = false,
			supervisorCdHcParty_e = false,
			supervisorCbe_e = false,
			error_e = false,
			encounterLocationName_e = false,
			encounterLocationNorm_e = false,
			longDelayJustification_e = false,
			correctiveInvoiceId_e = false,
			correctedInvoiceId_e = false,
			creditNote_e = false,
			creditNoteRelatedInvoiceId_e = false,
			idDocument_e = false,
			admissionDate_e = false,
			locationService_e = false,
			cancelReason_e = false,
			cancelDate_e = false,
			options_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedInvoice, DecryptedInvoice> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InvoiceEncryptor(
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			invoiceDate_e = "invoiceDate" in manifest.fieldsToEncrypt,
			sentDate_e = "sentDate" in manifest.fieldsToEncrypt,
			printedDate_e = "printedDate" in manifest.fieldsToEncrypt,
			invoicingCodes_e =
				if ("invoicingCodes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["invoicingCodes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedInvoicingCode::class,
								decryptedClass = DecryptedInvoicingCode::class,
							),
						)
					} ?: EncryptableFieldConfig.None(InvoicingCodeEncryptorFactory)
				},
			receipts_e = "receipts" in manifest.fieldsToEncrypt,
			recipientId_e = "recipientId" in manifest.fieldsToEncrypt,
			invoiceReference_e = "invoiceReference" in manifest.fieldsToEncrypt,
			decisionReference_e = "decisionReference" in manifest.fieldsToEncrypt,
			thirdPartyReference_e = "thirdPartyReference" in manifest.fieldsToEncrypt,
			thirdPartyPaymentJustification_e = "thirdPartyPaymentJustification" in manifest.fieldsToEncrypt,
			thirdPartyPaymentReason_e = "thirdPartyPaymentReason" in manifest.fieldsToEncrypt,
			reason_e = "reason" in manifest.fieldsToEncrypt,
			groupId_e = "groupId" in manifest.fieldsToEncrypt,
			paymentType_e = "paymentType" in manifest.fieldsToEncrypt,
			paid_e = "paid" in manifest.fieldsToEncrypt,
			payments_e = "payments" in manifest.fieldsToEncrypt,
			gnotionSsin_e = "gnotionSsin" in manifest.fieldsToEncrypt,
			gnotionLastName_e = "gnotionLastName" in manifest.fieldsToEncrypt,
			gnotionFirstName_e = "gnotionFirstName" in manifest.fieldsToEncrypt,
			gnotionCdHcParty_e = "gnotionCdHcParty" in manifest.fieldsToEncrypt,
			invoicePeriod_e = "invoicePeriod" in manifest.fieldsToEncrypt,
			careProviderType_e = "careProviderType" in manifest.fieldsToEncrypt,
			internshipSsin_e = "internshipSsin" in manifest.fieldsToEncrypt,
			internshipLastName_e = "internshipLastName" in manifest.fieldsToEncrypt,
			internshipFirstName_e = "internshipFirstName" in manifest.fieldsToEncrypt,
			internshipCdHcParty_e = "internshipCdHcParty" in manifest.fieldsToEncrypt,
			internshipCbe_e = "internshipCbe" in manifest.fieldsToEncrypt,
			supervisorSsin_e = "supervisorSsin" in manifest.fieldsToEncrypt,
			supervisorLastName_e = "supervisorLastName" in manifest.fieldsToEncrypt,
			supervisorFirstName_e = "supervisorFirstName" in manifest.fieldsToEncrypt,
			supervisorCdHcParty_e = "supervisorCdHcParty" in manifest.fieldsToEncrypt,
			supervisorCbe_e = "supervisorCbe" in manifest.fieldsToEncrypt,
			error_e = "error" in manifest.fieldsToEncrypt,
			encounterLocationName_e = "encounterLocationName" in manifest.fieldsToEncrypt,
			encounterLocationNorm_e = "encounterLocationNorm" in manifest.fieldsToEncrypt,
			longDelayJustification_e = "longDelayJustification" in manifest.fieldsToEncrypt,
			correctiveInvoiceId_e = "correctiveInvoiceId" in manifest.fieldsToEncrypt,
			correctedInvoiceId_e = "correctedInvoiceId" in manifest.fieldsToEncrypt,
			creditNote_e = "creditNote" in manifest.fieldsToEncrypt,
			creditNoteRelatedInvoiceId_e = "creditNoteRelatedInvoiceId" in manifest.fieldsToEncrypt,
			idDocument_e = "idDocument" in manifest.fieldsToEncrypt,
			admissionDate_e = "admissionDate" in manifest.fieldsToEncrypt,
			locationService_e = "locationService" in manifest.fieldsToEncrypt,
			cancelReason_e = "cancelReason" in manifest.fieldsToEncrypt,
			cancelDate_e = "cancelDate" in manifest.fieldsToEncrypt,
			options_e = "options" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class InvoiceEncryptor(
	private val identifier_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val invoiceDate_e: Boolean,
	private val sentDate_e: Boolean,
	private val printedDate_e: Boolean,
	private val invoicingCodes_e: EncryptableFieldConfig<EncryptedInvoicingCode, DecryptedInvoicingCode>,
	private val receipts_e: Boolean,
	private val recipientId_e: Boolean,
	private val invoiceReference_e: Boolean,
	private val decisionReference_e: Boolean,
	private val thirdPartyReference_e: Boolean,
	private val thirdPartyPaymentJustification_e: Boolean,
	private val thirdPartyPaymentReason_e: Boolean,
	private val reason_e: Boolean,
	private val groupId_e: Boolean,
	private val paymentType_e: Boolean,
	private val paid_e: Boolean,
	private val payments_e: Boolean,
	private val gnotionSsin_e: Boolean,
	private val gnotionLastName_e: Boolean,
	private val gnotionFirstName_e: Boolean,
	private val gnotionCdHcParty_e: Boolean,
	private val invoicePeriod_e: Boolean,
	private val careProviderType_e: Boolean,
	private val internshipSsin_e: Boolean,
	private val internshipLastName_e: Boolean,
	private val internshipFirstName_e: Boolean,
	private val internshipCdHcParty_e: Boolean,
	private val internshipCbe_e: Boolean,
	private val supervisorSsin_e: Boolean,
	private val supervisorLastName_e: Boolean,
	private val supervisorFirstName_e: Boolean,
	private val supervisorCdHcParty_e: Boolean,
	private val supervisorCbe_e: Boolean,
	private val error_e: Boolean,
	private val encounterLocationName_e: Boolean,
	private val encounterLocationNorm_e: Boolean,
	private val longDelayJustification_e: Boolean,
	private val correctiveInvoiceId_e: Boolean,
	private val correctedInvoiceId_e: Boolean,
	private val creditNote_e: Boolean,
	private val creditNoteRelatedInvoiceId_e: Boolean,
	private val idDocument_e: Boolean,
	private val admissionDate_e: Boolean,
	private val locationService_e: Boolean,
	private val cancelReason_e: Boolean,
	private val cancelDate_e: Boolean,
	private val options_e: Boolean,
) : AbstractEntityEncryptor<EncryptedInvoice, DecryptedInvoice>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInvoice,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedInvoice {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
				)
		}
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (invoiceDate_e && clearEntity.invoiceDate != null) {
			dataToEncrypt["invoiceDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoiceDate,
				)
		}
		if (sentDate_e && clearEntity.sentDate != null) dataToEncrypt["sentDate"] = encodingJson.encodeToJsonElement(clearEntity.sentDate)
		if (printedDate_e && clearEntity.printedDate != null) {
			dataToEncrypt["printedDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.printedDate,
				)
		}
		if (invoicingCodes_e.fullEncryption && clearEntity.invoicingCodes.isNotEmpty()) {
			dataToEncrypt["invoicingCodes"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoicingCodes,
				)
		}
		if (receipts_e && clearEntity.receipts.isNotEmpty()) dataToEncrypt["receipts"] = encodingJson.encodeToJsonElement(clearEntity.receipts)
		if (recipientId_e && clearEntity.recipientId != null) {
			dataToEncrypt["recipientId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.recipientId,
				)
		}
		if (invoiceReference_e && clearEntity.invoiceReference != null) {
			dataToEncrypt["invoiceReference"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoiceReference,
				)
		}
		if (decisionReference_e && clearEntity.decisionReference != null) {
			dataToEncrypt["decisionReference"] =
				encodingJson.encodeToJsonElement(
					clearEntity.decisionReference,
				)
		}
		if (thirdPartyReference_e && clearEntity.thirdPartyReference != null) {
			dataToEncrypt["thirdPartyReference"] =
				encodingJson.encodeToJsonElement(
					clearEntity.thirdPartyReference,
				)
		}
		if (thirdPartyPaymentJustification_e && clearEntity.thirdPartyPaymentJustification != null) {
			dataToEncrypt["thirdPartyPaymentJustification"] =
				encodingJson.encodeToJsonElement(
					clearEntity.thirdPartyPaymentJustification,
				)
		}
		if (thirdPartyPaymentReason_e && clearEntity.thirdPartyPaymentReason != null) {
			dataToEncrypt["thirdPartyPaymentReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.thirdPartyPaymentReason,
				)
		}
		if (reason_e && clearEntity.reason != null) dataToEncrypt["reason"] = encodingJson.encodeToJsonElement(clearEntity.reason)
		if (groupId_e && clearEntity.groupId != null) dataToEncrypt["groupId"] = encodingJson.encodeToJsonElement(clearEntity.groupId)
		if (paymentType_e && clearEntity.paymentType != null) {
			dataToEncrypt["paymentType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.paymentType,
				)
		}
		if (paid_e && clearEntity.paid != null) dataToEncrypt["paid"] = encodingJson.encodeToJsonElement(clearEntity.paid)
		if (payments_e && clearEntity.payments != null) dataToEncrypt["payments"] = encodingJson.encodeToJsonElement(clearEntity.payments)
		if (gnotionSsin_e && clearEntity.gnotionSsin != null) {
			dataToEncrypt["gnotionSsin"] =
				encodingJson.encodeToJsonElement(
					clearEntity.gnotionSsin,
				)
		}
		if (gnotionLastName_e && clearEntity.gnotionLastName != null) {
			dataToEncrypt["gnotionLastName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.gnotionLastName,
				)
		}
		if (gnotionFirstName_e && clearEntity.gnotionFirstName != null) {
			dataToEncrypt["gnotionFirstName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.gnotionFirstName,
				)
		}
		if (gnotionCdHcParty_e && clearEntity.gnotionCdHcParty != null) {
			dataToEncrypt["gnotionCdHcParty"] =
				encodingJson.encodeToJsonElement(
					clearEntity.gnotionCdHcParty,
				)
		}
		if (invoicePeriod_e && clearEntity.invoicePeriod != null) {
			dataToEncrypt["invoicePeriod"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoicePeriod,
				)
		}
		if (careProviderType_e && clearEntity.careProviderType != null) {
			dataToEncrypt["careProviderType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careProviderType,
				)
		}
		if (internshipSsin_e && clearEntity.internshipSsin != null) {
			dataToEncrypt["internshipSsin"] =
				encodingJson.encodeToJsonElement(
					clearEntity.internshipSsin,
				)
		}
		if (internshipLastName_e && clearEntity.internshipLastName != null) {
			dataToEncrypt["internshipLastName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.internshipLastName,
				)
		}
		if (internshipFirstName_e && clearEntity.internshipFirstName != null) {
			dataToEncrypt["internshipFirstName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.internshipFirstName,
				)
		}
		if (internshipCdHcParty_e && clearEntity.internshipCdHcParty != null) {
			dataToEncrypt["internshipCdHcParty"] =
				encodingJson.encodeToJsonElement(
					clearEntity.internshipCdHcParty,
				)
		}
		if (internshipCbe_e && clearEntity.internshipCbe != null) {
			dataToEncrypt["internshipCbe"] =
				encodingJson.encodeToJsonElement(
					clearEntity.internshipCbe,
				)
		}
		if (supervisorSsin_e && clearEntity.supervisorSsin != null) {
			dataToEncrypt["supervisorSsin"] =
				encodingJson.encodeToJsonElement(
					clearEntity.supervisorSsin,
				)
		}
		if (supervisorLastName_e && clearEntity.supervisorLastName != null) {
			dataToEncrypt["supervisorLastName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.supervisorLastName,
				)
		}
		if (supervisorFirstName_e && clearEntity.supervisorFirstName != null) {
			dataToEncrypt["supervisorFirstName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.supervisorFirstName,
				)
		}
		if (supervisorCdHcParty_e && clearEntity.supervisorCdHcParty != null) {
			dataToEncrypt["supervisorCdHcParty"] =
				encodingJson.encodeToJsonElement(
					clearEntity.supervisorCdHcParty,
				)
		}
		if (supervisorCbe_e && clearEntity.supervisorCbe != null) {
			dataToEncrypt["supervisorCbe"] =
				encodingJson.encodeToJsonElement(
					clearEntity.supervisorCbe,
				)
		}
		if (error_e && clearEntity.error != null) dataToEncrypt["error"] = encodingJson.encodeToJsonElement(clearEntity.error)
		if (encounterLocationName_e && clearEntity.encounterLocationName != null) {
			dataToEncrypt["encounterLocationName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.encounterLocationName,
				)
		}
		if (encounterLocationNorm_e && clearEntity.encounterLocationNorm != null) {
			dataToEncrypt["encounterLocationNorm"] =
				encodingJson.encodeToJsonElement(
					clearEntity.encounterLocationNorm,
				)
		}
		if (longDelayJustification_e && clearEntity.longDelayJustification != null) {
			dataToEncrypt["longDelayJustification"] =
				encodingJson.encodeToJsonElement(
					clearEntity.longDelayJustification,
				)
		}
		if (correctiveInvoiceId_e && clearEntity.correctiveInvoiceId != null) {
			dataToEncrypt["correctiveInvoiceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.correctiveInvoiceId,
				)
		}
		if (correctedInvoiceId_e && clearEntity.correctedInvoiceId != null) {
			dataToEncrypt["correctedInvoiceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.correctedInvoiceId,
				)
		}
		if (creditNote_e && clearEntity.creditNote != null) dataToEncrypt["creditNote"] = encodingJson.encodeToJsonElement(clearEntity.creditNote)
		if (creditNoteRelatedInvoiceId_e && clearEntity.creditNoteRelatedInvoiceId != null) {
			dataToEncrypt["creditNoteRelatedInvoiceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.creditNoteRelatedInvoiceId,
				)
		}
		if (idDocument_e && clearEntity.idDocument != null) dataToEncrypt["idDocument"] = encodingJson.encodeToJsonElement(clearEntity.idDocument)
		if (admissionDate_e && clearEntity.admissionDate != null) {
			dataToEncrypt["admissionDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.admissionDate,
				)
		}
		if (locationService_e && clearEntity.locationService != null) {
			dataToEncrypt["locationService"] =
				encodingJson.encodeToJsonElement(
					clearEntity.locationService,
				)
		}
		if (cancelReason_e && clearEntity.cancelReason != null) {
			dataToEncrypt["cancelReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.cancelReason,
				)
		}
		if (cancelDate_e && clearEntity.cancelDate != null) dataToEncrypt["cancelDate"] = encodingJson.encodeToJsonElement(clearEntity.cancelDate)
		if (options_e && clearEntity.options.isNotEmpty()) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		return EncryptedInvoice(
			id = clearEntity.id,
			rev = clearEntity.rev,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			invoiceDate = if (invoiceDate_e) null else clearEntity.invoiceDate,
			sentDate = if (sentDate_e) null else clearEntity.sentDate,
			printedDate = if (printedDate_e) null else clearEntity.printedDate,
			invoicingCodes =
				invoicingCodes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.invoicingCodes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			receipts = if (receipts_e) emptyMap() else clearEntity.receipts,
			recipientId = if (recipientId_e) null else clearEntity.recipientId,
			invoiceReference = if (invoiceReference_e) null else clearEntity.invoiceReference,
			decisionReference = if (decisionReference_e) null else clearEntity.decisionReference,
			thirdPartyReference = if (thirdPartyReference_e) null else clearEntity.thirdPartyReference,
			thirdPartyPaymentJustification = if (thirdPartyPaymentJustification_e) null else clearEntity.thirdPartyPaymentJustification,
			thirdPartyPaymentReason = if (thirdPartyPaymentReason_e) null else clearEntity.thirdPartyPaymentReason,
			reason = if (reason_e) null else clearEntity.reason,
			groupId = if (groupId_e) null else clearEntity.groupId,
			paymentType = if (paymentType_e) null else clearEntity.paymentType,
			paid = if (paid_e) null else clearEntity.paid,
			payments = if (payments_e) null else clearEntity.payments,
			gnotionSsin = if (gnotionSsin_e) null else clearEntity.gnotionSsin,
			gnotionLastName = if (gnotionLastName_e) null else clearEntity.gnotionLastName,
			gnotionFirstName = if (gnotionFirstName_e) null else clearEntity.gnotionFirstName,
			gnotionCdHcParty = if (gnotionCdHcParty_e) null else clearEntity.gnotionCdHcParty,
			invoicePeriod = if (invoicePeriod_e) null else clearEntity.invoicePeriod,
			careProviderType = if (careProviderType_e) null else clearEntity.careProviderType,
			internshipSsin = if (internshipSsin_e) null else clearEntity.internshipSsin,
			internshipLastName = if (internshipLastName_e) null else clearEntity.internshipLastName,
			internshipFirstName = if (internshipFirstName_e) null else clearEntity.internshipFirstName,
			internshipCdHcParty = if (internshipCdHcParty_e) null else clearEntity.internshipCdHcParty,
			internshipCbe = if (internshipCbe_e) null else clearEntity.internshipCbe,
			supervisorSsin = if (supervisorSsin_e) null else clearEntity.supervisorSsin,
			supervisorLastName = if (supervisorLastName_e) null else clearEntity.supervisorLastName,
			supervisorFirstName = if (supervisorFirstName_e) null else clearEntity.supervisorFirstName,
			supervisorCdHcParty = if (supervisorCdHcParty_e) null else clearEntity.supervisorCdHcParty,
			supervisorCbe = if (supervisorCbe_e) null else clearEntity.supervisorCbe,
			error = if (error_e) null else clearEntity.error,
			encounterLocationName = if (encounterLocationName_e) null else clearEntity.encounterLocationName,
			encounterLocationNorm = if (encounterLocationNorm_e) null else clearEntity.encounterLocationNorm,
			longDelayJustification = if (longDelayJustification_e) null else clearEntity.longDelayJustification,
			correctiveInvoiceId = if (correctiveInvoiceId_e) null else clearEntity.correctiveInvoiceId,
			correctedInvoiceId = if (correctedInvoiceId_e) null else clearEntity.correctedInvoiceId,
			creditNote = if (creditNote_e) null else clearEntity.creditNote,
			creditNoteRelatedInvoiceId = if (creditNoteRelatedInvoiceId_e) null else clearEntity.creditNoteRelatedInvoiceId,
			idDocument = if (idDocument_e) null else clearEntity.idDocument,
			admissionDate = if (admissionDate_e) null else clearEntity.admissionDate,
			locationService = if (locationService_e) null else clearEntity.locationService,
			cancelReason = if (cancelReason_e) null else clearEntity.cancelReason,
			cancelDate = if (cancelDate_e) null else clearEntity.cancelDate,
			options = if (options_e) emptyMap() else clearEntity.options,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
