// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object InvoiceDecryptor : AbstractEntityDecryptor<EncryptedInvoice, DecryptedInvoice>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoice,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedInvoice {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInvoice(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				identifier =
					decryptedContent["identifier"].let {
						if (it != null) {
							usedEncryptedContent += "identifier"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifier
						}
					},
				created =
					decryptedContent["created"].let {
						if (it != null) {
							usedEncryptedContent += "created"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.created
						}
					},
				modified =
					decryptedContent["modified"].let {
						if (it != null) {
							usedEncryptedContent += "modified"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.modified
						}
					},
				author =
					decryptedContent["author"].let {
						if (it != null) {
							usedEncryptedContent += "author"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.author
						}
					},
				responsible =
					decryptedContent["responsible"].let {
						if (it != null) {
							usedEncryptedContent += "responsible"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.responsible
						}
					},
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				codes =
					decryptedContent["codes"].let {
						if (it != null) {
							usedEncryptedContent += "codes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codes
						}
					},
				deletionDate = encryptedEntity.deletionDate,
				invoiceDate =
					decryptedContent["invoiceDate"].let {
						if (it != null) {
							usedEncryptedContent += "invoiceDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoiceDate
						}
					},
				sentDate =
					decryptedContent["sentDate"].let {
						if (it != null) {
							usedEncryptedContent += "sentDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.sentDate
						}
					},
				printedDate =
					decryptedContent["printedDate"].let {
						if (it != null) {
							usedEncryptedContent += "printedDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.printedDate
						}
					},
				invoicingCodes =
					decryptedContent["invoicingCodes"].let {
						if (it != null) {
							usedEncryptedContent += "invoicingCodes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoicingCodes.map { x0 ->
								InvoicingCodeDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				receipts =
					decryptedContent["receipts"].let {
						if (it != null) {
							usedEncryptedContent += "receipts"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.receipts
						}
					},
				recipientId =
					decryptedContent["recipientId"].let {
						if (it != null) {
							usedEncryptedContent += "recipientId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.recipientId
						}
					},
				invoiceReference =
					decryptedContent["invoiceReference"].let {
						if (it != null) {
							usedEncryptedContent += "invoiceReference"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoiceReference
						}
					},
				decisionReference =
					decryptedContent["decisionReference"].let {
						if (it != null) {
							usedEncryptedContent += "decisionReference"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.decisionReference
						}
					},
				thirdPartyReference =
					decryptedContent["thirdPartyReference"].let {
						if (it != null) {
							usedEncryptedContent += "thirdPartyReference"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.thirdPartyReference
						}
					},
				thirdPartyPaymentJustification =
					decryptedContent["thirdPartyPaymentJustification"].let {
						if (it != null) {
							usedEncryptedContent += "thirdPartyPaymentJustification"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.thirdPartyPaymentJustification
						}
					},
				thirdPartyPaymentReason =
					decryptedContent["thirdPartyPaymentReason"].let {
						if (it != null) {
							usedEncryptedContent += "thirdPartyPaymentReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.thirdPartyPaymentReason
						}
					},
				reason =
					decryptedContent["reason"].let {
						if (it != null) {
							usedEncryptedContent += "reason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.reason
						}
					},
				groupId =
					decryptedContent["groupId"].let {
						if (it != null) {
							usedEncryptedContent += "groupId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.groupId
						}
					},
				paymentType =
					decryptedContent["paymentType"].let {
						if (it != null) {
							usedEncryptedContent += "paymentType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.paymentType
						}
					},
				paid =
					decryptedContent["paid"].let {
						if (it != null) {
							usedEncryptedContent += "paid"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.paid
						}
					},
				payments =
					decryptedContent["payments"].let {
						if (it != null) {
							usedEncryptedContent += "payments"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.payments
						}
					},
				gnotionSsin =
					decryptedContent["gnotionSsin"].let {
						if (it != null) {
							usedEncryptedContent += "gnotionSsin"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gnotionSsin
						}
					},
				gnotionLastName =
					decryptedContent["gnotionLastName"].let {
						if (it != null) {
							usedEncryptedContent += "gnotionLastName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gnotionLastName
						}
					},
				gnotionFirstName =
					decryptedContent["gnotionFirstName"].let {
						if (it != null) {
							usedEncryptedContent += "gnotionFirstName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gnotionFirstName
						}
					},
				gnotionCdHcParty =
					decryptedContent["gnotionCdHcParty"].let {
						if (it != null) {
							usedEncryptedContent += "gnotionCdHcParty"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gnotionCdHcParty
						}
					},
				invoicePeriod =
					decryptedContent["invoicePeriod"].let {
						if (it != null) {
							usedEncryptedContent += "invoicePeriod"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoicePeriod
						}
					},
				careProviderType =
					decryptedContent["careProviderType"].let {
						if (it != null) {
							usedEncryptedContent += "careProviderType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.careProviderType
						}
					},
				internshipSsin =
					decryptedContent["internshipSsin"].let {
						if (it != null) {
							usedEncryptedContent += "internshipSsin"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.internshipSsin
						}
					},
				internshipLastName =
					decryptedContent["internshipLastName"].let {
						if (it != null) {
							usedEncryptedContent += "internshipLastName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.internshipLastName
						}
					},
				internshipFirstName =
					decryptedContent["internshipFirstName"].let {
						if (it != null) {
							usedEncryptedContent += "internshipFirstName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.internshipFirstName
						}
					},
				internshipCdHcParty =
					decryptedContent["internshipCdHcParty"].let {
						if (it != null) {
							usedEncryptedContent += "internshipCdHcParty"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.internshipCdHcParty
						}
					},
				internshipCbe =
					decryptedContent["internshipCbe"].let {
						if (it != null) {
							usedEncryptedContent += "internshipCbe"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.internshipCbe
						}
					},
				supervisorSsin =
					decryptedContent["supervisorSsin"].let {
						if (it != null) {
							usedEncryptedContent += "supervisorSsin"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.supervisorSsin
						}
					},
				supervisorLastName =
					decryptedContent["supervisorLastName"].let {
						if (it != null) {
							usedEncryptedContent += "supervisorLastName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.supervisorLastName
						}
					},
				supervisorFirstName =
					decryptedContent["supervisorFirstName"].let {
						if (it != null) {
							usedEncryptedContent += "supervisorFirstName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.supervisorFirstName
						}
					},
				supervisorCdHcParty =
					decryptedContent["supervisorCdHcParty"].let {
						if (it != null) {
							usedEncryptedContent += "supervisorCdHcParty"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.supervisorCdHcParty
						}
					},
				supervisorCbe =
					decryptedContent["supervisorCbe"].let {
						if (it != null) {
							usedEncryptedContent += "supervisorCbe"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.supervisorCbe
						}
					},
				error =
					decryptedContent["error"].let {
						if (it != null) {
							usedEncryptedContent += "error"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.error
						}
					},
				encounterLocationName =
					decryptedContent["encounterLocationName"].let {
						if (it != null) {
							usedEncryptedContent += "encounterLocationName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.encounterLocationName
						}
					},
				encounterLocationNorm =
					decryptedContent["encounterLocationNorm"].let {
						if (it != null) {
							usedEncryptedContent += "encounterLocationNorm"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.encounterLocationNorm
						}
					},
				longDelayJustification =
					decryptedContent["longDelayJustification"].let {
						if (it != null) {
							usedEncryptedContent += "longDelayJustification"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.longDelayJustification
						}
					},
				correctiveInvoiceId =
					decryptedContent["correctiveInvoiceId"].let {
						if (it != null) {
							usedEncryptedContent += "correctiveInvoiceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.correctiveInvoiceId
						}
					},
				correctedInvoiceId =
					decryptedContent["correctedInvoiceId"].let {
						if (it != null) {
							usedEncryptedContent += "correctedInvoiceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.correctedInvoiceId
						}
					},
				creditNote =
					decryptedContent["creditNote"].let {
						if (it != null) {
							usedEncryptedContent += "creditNote"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.creditNote
						}
					},
				creditNoteRelatedInvoiceId =
					decryptedContent["creditNoteRelatedInvoiceId"].let {
						if (it != null) {
							usedEncryptedContent += "creditNoteRelatedInvoiceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.creditNoteRelatedInvoiceId
						}
					},
				idDocument =
					decryptedContent["idDocument"].let {
						if (it != null) {
							usedEncryptedContent += "idDocument"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.idDocument
						}
					},
				admissionDate =
					decryptedContent["admissionDate"].let {
						if (it != null) {
							usedEncryptedContent += "admissionDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.admissionDate
						}
					},
				locationService =
					decryptedContent["locationService"].let {
						if (it != null) {
							usedEncryptedContent += "locationService"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.locationService
						}
					},
				cancelReason =
					decryptedContent["cancelReason"].let {
						if (it != null) {
							usedEncryptedContent += "cancelReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.cancelReason
						}
					},
				cancelDate =
					decryptedContent["cancelDate"].let {
						if (it != null) {
							usedEncryptedContent += "cancelDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.cancelDate
						}
					},
				options =
					decryptedContent["options"].let {
						if (it != null) {
							usedEncryptedContent += "options"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.options
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Invoice encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
