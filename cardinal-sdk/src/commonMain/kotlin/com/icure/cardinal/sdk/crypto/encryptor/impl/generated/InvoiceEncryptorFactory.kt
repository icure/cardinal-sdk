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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object InvoiceEncryptorFactory : EntityEncryptorFactory<EncryptedInvoice, DecryptedInvoice> {
	override val empty: EntityEncryptor<EncryptedInvoice, DecryptedInvoice> =
		InvoiceEncryptor(
			identifier = false,
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			invoiceDate = false,
			sentDate = false,
			printedDate = false,
			invoicingCodes = EncryptableFieldConfig.None(InvoicingCodeEncryptorFactory),
			receipts = false,
			recipientId = false,
			invoiceReference = false,
			decisionReference = false,
			thirdPartyReference = false,
			thirdPartyPaymentJustification = false,
			thirdPartyPaymentReason = false,
			reason = false,
			groupId = false,
			paymentType = false,
			paid = false,
			payments = false,
			gnotionSsin = false,
			gnotionLastName = false,
			gnotionFirstName = false,
			gnotionCdHcParty = false,
			invoicePeriod = false,
			careProviderType = false,
			internshipSsin = false,
			internshipLastName = false,
			internshipFirstName = false,
			internshipCdHcParty = false,
			internshipCbe = false,
			supervisorSsin = false,
			supervisorLastName = false,
			supervisorFirstName = false,
			supervisorCdHcParty = false,
			supervisorCbe = false,
			error = false,
			encounterLocationName = false,
			encounterLocationNorm = false,
			longDelayJustification = false,
			correctiveInvoiceId = false,
			correctedInvoiceId = false,
			creditNote = false,
			creditNoteRelatedInvoiceId = false,
			idDocument = false,
			admissionDate = false,
			locationService = false,
			cancelReason = false,
			cancelDate = false,
			options = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedInvoice, DecryptedInvoice> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InvoiceEncryptor(
			identifier = "identifier" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			invoiceDate = "invoiceDate" in manifest.fieldsToEncrypt,
			sentDate = "sentDate" in manifest.fieldsToEncrypt,
			printedDate = "printedDate" in manifest.fieldsToEncrypt,
			invoicingCodes =
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
			receipts = "receipts" in manifest.fieldsToEncrypt,
			recipientId = "recipientId" in manifest.fieldsToEncrypt,
			invoiceReference = "invoiceReference" in manifest.fieldsToEncrypt,
			decisionReference = "decisionReference" in manifest.fieldsToEncrypt,
			thirdPartyReference = "thirdPartyReference" in manifest.fieldsToEncrypt,
			thirdPartyPaymentJustification = "thirdPartyPaymentJustification" in manifest.fieldsToEncrypt,
			thirdPartyPaymentReason = "thirdPartyPaymentReason" in manifest.fieldsToEncrypt,
			reason = "reason" in manifest.fieldsToEncrypt,
			groupId = "groupId" in manifest.fieldsToEncrypt,
			paymentType = "paymentType" in manifest.fieldsToEncrypt,
			paid = "paid" in manifest.fieldsToEncrypt,
			payments = "payments" in manifest.fieldsToEncrypt,
			gnotionSsin = "gnotionSsin" in manifest.fieldsToEncrypt,
			gnotionLastName = "gnotionLastName" in manifest.fieldsToEncrypt,
			gnotionFirstName = "gnotionFirstName" in manifest.fieldsToEncrypt,
			gnotionCdHcParty = "gnotionCdHcParty" in manifest.fieldsToEncrypt,
			invoicePeriod = "invoicePeriod" in manifest.fieldsToEncrypt,
			careProviderType = "careProviderType" in manifest.fieldsToEncrypt,
			internshipSsin = "internshipSsin" in manifest.fieldsToEncrypt,
			internshipLastName = "internshipLastName" in manifest.fieldsToEncrypt,
			internshipFirstName = "internshipFirstName" in manifest.fieldsToEncrypt,
			internshipCdHcParty = "internshipCdHcParty" in manifest.fieldsToEncrypt,
			internshipCbe = "internshipCbe" in manifest.fieldsToEncrypt,
			supervisorSsin = "supervisorSsin" in manifest.fieldsToEncrypt,
			supervisorLastName = "supervisorLastName" in manifest.fieldsToEncrypt,
			supervisorFirstName = "supervisorFirstName" in manifest.fieldsToEncrypt,
			supervisorCdHcParty = "supervisorCdHcParty" in manifest.fieldsToEncrypt,
			supervisorCbe = "supervisorCbe" in manifest.fieldsToEncrypt,
			error = "error" in manifest.fieldsToEncrypt,
			encounterLocationName = "encounterLocationName" in manifest.fieldsToEncrypt,
			encounterLocationNorm = "encounterLocationNorm" in manifest.fieldsToEncrypt,
			longDelayJustification = "longDelayJustification" in manifest.fieldsToEncrypt,
			correctiveInvoiceId = "correctiveInvoiceId" in manifest.fieldsToEncrypt,
			correctedInvoiceId = "correctedInvoiceId" in manifest.fieldsToEncrypt,
			creditNote = "creditNote" in manifest.fieldsToEncrypt,
			creditNoteRelatedInvoiceId = "creditNoteRelatedInvoiceId" in manifest.fieldsToEncrypt,
			idDocument = "idDocument" in manifest.fieldsToEncrypt,
			admissionDate = "admissionDate" in manifest.fieldsToEncrypt,
			locationService = "locationService" in manifest.fieldsToEncrypt,
			cancelReason = "cancelReason" in manifest.fieldsToEncrypt,
			cancelDate = "cancelDate" in manifest.fieldsToEncrypt,
			options = "options" in manifest.fieldsToEncrypt,
		)
	}
}

private class InvoiceEncryptor(
	private val identifier: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val invoiceDate: Boolean,
	private val sentDate: Boolean,
	private val printedDate: Boolean,
	private val invoicingCodes: EncryptableFieldConfig<EncryptedInvoicingCode, DecryptedInvoicingCode>,
	private val receipts: Boolean,
	private val recipientId: Boolean,
	private val invoiceReference: Boolean,
	private val decisionReference: Boolean,
	private val thirdPartyReference: Boolean,
	private val thirdPartyPaymentJustification: Boolean,
	private val thirdPartyPaymentReason: Boolean,
	private val reason: Boolean,
	private val groupId: Boolean,
	private val paymentType: Boolean,
	private val paid: Boolean,
	private val payments: Boolean,
	private val gnotionSsin: Boolean,
	private val gnotionLastName: Boolean,
	private val gnotionFirstName: Boolean,
	private val gnotionCdHcParty: Boolean,
	private val invoicePeriod: Boolean,
	private val careProviderType: Boolean,
	private val internshipSsin: Boolean,
	private val internshipLastName: Boolean,
	private val internshipFirstName: Boolean,
	private val internshipCdHcParty: Boolean,
	private val internshipCbe: Boolean,
	private val supervisorSsin: Boolean,
	private val supervisorLastName: Boolean,
	private val supervisorFirstName: Boolean,
	private val supervisorCdHcParty: Boolean,
	private val supervisorCbe: Boolean,
	private val error: Boolean,
	private val encounterLocationName: Boolean,
	private val encounterLocationNorm: Boolean,
	private val longDelayJustification: Boolean,
	private val correctiveInvoiceId: Boolean,
	private val correctedInvoiceId: Boolean,
	private val creditNote: Boolean,
	private val creditNoteRelatedInvoiceId: Boolean,
	private val idDocument: Boolean,
	private val admissionDate: Boolean,
	private val locationService: Boolean,
	private val cancelReason: Boolean,
	private val cancelDate: Boolean,
	private val options: Boolean,
) : AbstractEntityEncryptor<EncryptedInvoice, DecryptedInvoice>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInvoice,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedInvoice {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (invoiceDate) dataToEncrypt["invoiceDate"] = encodingJson.encodeToJsonElement(clearEntity.invoiceDate)
		if (sentDate) dataToEncrypt["sentDate"] = encodingJson.encodeToJsonElement(clearEntity.sentDate)
		if (printedDate) dataToEncrypt["printedDate"] = encodingJson.encodeToJsonElement(clearEntity.printedDate)
		if (invoicingCodes.fullEncryption) dataToEncrypt["invoicingCodes"] = encodingJson.encodeToJsonElement(clearEntity.invoicingCodes)
		if (receipts) dataToEncrypt["receipts"] = encodingJson.encodeToJsonElement(clearEntity.receipts)
		if (recipientId) dataToEncrypt["recipientId"] = encodingJson.encodeToJsonElement(clearEntity.recipientId)
		if (invoiceReference) dataToEncrypt["invoiceReference"] = encodingJson.encodeToJsonElement(clearEntity.invoiceReference)
		if (decisionReference) dataToEncrypt["decisionReference"] = encodingJson.encodeToJsonElement(clearEntity.decisionReference)
		if (thirdPartyReference) dataToEncrypt["thirdPartyReference"] = encodingJson.encodeToJsonElement(clearEntity.thirdPartyReference)
		if (thirdPartyPaymentJustification) {
			dataToEncrypt["thirdPartyPaymentJustification"] =
				encodingJson.encodeToJsonElement(
					clearEntity.thirdPartyPaymentJustification,
				)
		}
		if (thirdPartyPaymentReason) {
			dataToEncrypt["thirdPartyPaymentReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.thirdPartyPaymentReason,
				)
		}
		if (reason) dataToEncrypt["reason"] = encodingJson.encodeToJsonElement(clearEntity.reason)
		if (groupId) dataToEncrypt["groupId"] = encodingJson.encodeToJsonElement(clearEntity.groupId)
		if (paymentType) dataToEncrypt["paymentType"] = encodingJson.encodeToJsonElement(clearEntity.paymentType)
		if (paid) dataToEncrypt["paid"] = encodingJson.encodeToJsonElement(clearEntity.paid)
		if (payments) dataToEncrypt["payments"] = encodingJson.encodeToJsonElement(clearEntity.payments)
		if (gnotionSsin) dataToEncrypt["gnotionSsin"] = encodingJson.encodeToJsonElement(clearEntity.gnotionSsin)
		if (gnotionLastName) dataToEncrypt["gnotionLastName"] = encodingJson.encodeToJsonElement(clearEntity.gnotionLastName)
		if (gnotionFirstName) dataToEncrypt["gnotionFirstName"] = encodingJson.encodeToJsonElement(clearEntity.gnotionFirstName)
		if (gnotionCdHcParty) dataToEncrypt["gnotionCdHcParty"] = encodingJson.encodeToJsonElement(clearEntity.gnotionCdHcParty)
		if (invoicePeriod) dataToEncrypt["invoicePeriod"] = encodingJson.encodeToJsonElement(clearEntity.invoicePeriod)
		if (careProviderType) dataToEncrypt["careProviderType"] = encodingJson.encodeToJsonElement(clearEntity.careProviderType)
		if (internshipSsin) dataToEncrypt["internshipSsin"] = encodingJson.encodeToJsonElement(clearEntity.internshipSsin)
		if (internshipLastName) dataToEncrypt["internshipLastName"] = encodingJson.encodeToJsonElement(clearEntity.internshipLastName)
		if (internshipFirstName) dataToEncrypt["internshipFirstName"] = encodingJson.encodeToJsonElement(clearEntity.internshipFirstName)
		if (internshipCdHcParty) dataToEncrypt["internshipCdHcParty"] = encodingJson.encodeToJsonElement(clearEntity.internshipCdHcParty)
		if (internshipCbe) dataToEncrypt["internshipCbe"] = encodingJson.encodeToJsonElement(clearEntity.internshipCbe)
		if (supervisorSsin) dataToEncrypt["supervisorSsin"] = encodingJson.encodeToJsonElement(clearEntity.supervisorSsin)
		if (supervisorLastName) dataToEncrypt["supervisorLastName"] = encodingJson.encodeToJsonElement(clearEntity.supervisorLastName)
		if (supervisorFirstName) dataToEncrypt["supervisorFirstName"] = encodingJson.encodeToJsonElement(clearEntity.supervisorFirstName)
		if (supervisorCdHcParty) dataToEncrypt["supervisorCdHcParty"] = encodingJson.encodeToJsonElement(clearEntity.supervisorCdHcParty)
		if (supervisorCbe) dataToEncrypt["supervisorCbe"] = encodingJson.encodeToJsonElement(clearEntity.supervisorCbe)
		if (error) dataToEncrypt["error"] = encodingJson.encodeToJsonElement(clearEntity.error)
		if (encounterLocationName) dataToEncrypt["encounterLocationName"] = encodingJson.encodeToJsonElement(clearEntity.encounterLocationName)
		if (encounterLocationNorm) dataToEncrypt["encounterLocationNorm"] = encodingJson.encodeToJsonElement(clearEntity.encounterLocationNorm)
		if (longDelayJustification) dataToEncrypt["longDelayJustification"] = encodingJson.encodeToJsonElement(clearEntity.longDelayJustification)
		if (correctiveInvoiceId) dataToEncrypt["correctiveInvoiceId"] = encodingJson.encodeToJsonElement(clearEntity.correctiveInvoiceId)
		if (correctedInvoiceId) dataToEncrypt["correctedInvoiceId"] = encodingJson.encodeToJsonElement(clearEntity.correctedInvoiceId)
		if (creditNote) dataToEncrypt["creditNote"] = encodingJson.encodeToJsonElement(clearEntity.creditNote)
		if (creditNoteRelatedInvoiceId) {
			dataToEncrypt["creditNoteRelatedInvoiceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.creditNoteRelatedInvoiceId,
				)
		}
		if (idDocument) dataToEncrypt["idDocument"] = encodingJson.encodeToJsonElement(clearEntity.idDocument)
		if (admissionDate) dataToEncrypt["admissionDate"] = encodingJson.encodeToJsonElement(clearEntity.admissionDate)
		if (locationService) dataToEncrypt["locationService"] = encodingJson.encodeToJsonElement(clearEntity.locationService)
		if (cancelReason) dataToEncrypt["cancelReason"] = encodingJson.encodeToJsonElement(clearEntity.cancelReason)
		if (cancelDate) dataToEncrypt["cancelDate"] = encodingJson.encodeToJsonElement(clearEntity.cancelDate)
		if (options) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		return EncryptedInvoice(
			id = clearEntity.id,
			rev = clearEntity.rev,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			invoiceDate = if (invoiceDate) null else clearEntity.invoiceDate,
			sentDate = if (sentDate) null else clearEntity.sentDate,
			printedDate = if (printedDate) null else clearEntity.printedDate,
			invoicingCodes =
				invoicingCodes.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.invoicingCodes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			receipts = if (receipts) emptyMap() else clearEntity.receipts,
			recipientId = if (recipientId) null else clearEntity.recipientId,
			invoiceReference = if (invoiceReference) null else clearEntity.invoiceReference,
			decisionReference = if (decisionReference) null else clearEntity.decisionReference,
			thirdPartyReference = if (thirdPartyReference) null else clearEntity.thirdPartyReference,
			thirdPartyPaymentJustification = if (thirdPartyPaymentJustification) null else clearEntity.thirdPartyPaymentJustification,
			thirdPartyPaymentReason = if (thirdPartyPaymentReason) null else clearEntity.thirdPartyPaymentReason,
			reason = if (reason) null else clearEntity.reason,
			groupId = if (groupId) null else clearEntity.groupId,
			paymentType = if (paymentType) null else clearEntity.paymentType,
			paid = if (paid) null else clearEntity.paid,
			payments = if (payments) null else clearEntity.payments,
			gnotionSsin = if (gnotionSsin) null else clearEntity.gnotionSsin,
			gnotionLastName = if (gnotionLastName) null else clearEntity.gnotionLastName,
			gnotionFirstName = if (gnotionFirstName) null else clearEntity.gnotionFirstName,
			gnotionCdHcParty = if (gnotionCdHcParty) null else clearEntity.gnotionCdHcParty,
			invoicePeriod = if (invoicePeriod) null else clearEntity.invoicePeriod,
			careProviderType = if (careProviderType) null else clearEntity.careProviderType,
			internshipSsin = if (internshipSsin) null else clearEntity.internshipSsin,
			internshipLastName = if (internshipLastName) null else clearEntity.internshipLastName,
			internshipFirstName = if (internshipFirstName) null else clearEntity.internshipFirstName,
			internshipCdHcParty = if (internshipCdHcParty) null else clearEntity.internshipCdHcParty,
			internshipCbe = if (internshipCbe) null else clearEntity.internshipCbe,
			supervisorSsin = if (supervisorSsin) null else clearEntity.supervisorSsin,
			supervisorLastName = if (supervisorLastName) null else clearEntity.supervisorLastName,
			supervisorFirstName = if (supervisorFirstName) null else clearEntity.supervisorFirstName,
			supervisorCdHcParty = if (supervisorCdHcParty) null else clearEntity.supervisorCdHcParty,
			supervisorCbe = if (supervisorCbe) null else clearEntity.supervisorCbe,
			error = if (error) null else clearEntity.error,
			encounterLocationName = if (encounterLocationName) null else clearEntity.encounterLocationName,
			encounterLocationNorm = if (encounterLocationNorm) null else clearEntity.encounterLocationNorm,
			longDelayJustification = if (longDelayJustification) null else clearEntity.longDelayJustification,
			correctiveInvoiceId = if (correctiveInvoiceId) null else clearEntity.correctiveInvoiceId,
			correctedInvoiceId = if (correctedInvoiceId) null else clearEntity.correctedInvoiceId,
			creditNote = if (creditNote) null else clearEntity.creditNote,
			creditNoteRelatedInvoiceId = if (creditNoteRelatedInvoiceId) null else clearEntity.creditNoteRelatedInvoiceId,
			idDocument = if (idDocument) null else clearEntity.idDocument,
			admissionDate = if (admissionDate) null else clearEntity.admissionDate,
			locationService = if (locationService) null else clearEntity.locationService,
			cancelReason = if (cancelReason) null else clearEntity.cancelReason,
			cancelDate = if (cancelDate) null else clearEntity.cancelDate,
			options = if (options) emptyMap() else clearEntity.options,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
