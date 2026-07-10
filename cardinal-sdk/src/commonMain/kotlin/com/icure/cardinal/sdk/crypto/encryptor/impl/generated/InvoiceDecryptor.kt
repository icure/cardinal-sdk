// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object InvoiceDecryptor : AbstractEntityDecryptor<EncryptedInvoice, DecryptedInvoice>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoice,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						decryptedJsonStrictness,
					),
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						decryptedJsonStrictness,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						decryptedJsonStrictness,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						decryptedJsonStrictness,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				deletionDate = encryptedEntity.deletionDate,
				invoiceDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceDate"]?.also { usedEncryptedContent += "invoiceDate" },
						encryptedEntity.invoiceDate,
						decryptedJsonStrictness,
					),
				sentDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sentDate"]?.also { usedEncryptedContent += "sentDate" },
						encryptedEntity.sentDate,
						decryptedJsonStrictness,
					),
				printedDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["printedDate"]?.also { usedEncryptedContent += "printedDate" },
						encryptedEntity.printedDate,
						decryptedJsonStrictness,
					),
				invoicingCodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicingCodes"]?.also { usedEncryptedContent += "invoicingCodes" },
						encryptedEntity.invoicingCodes.map { x0 ->
							InvoicingCodeDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				receipts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["receipts"]?.also { usedEncryptedContent += "receipts" },
						encryptedEntity.receipts,
						decryptedJsonStrictness,
					),
				recipientId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recipientId"]?.also { usedEncryptedContent += "recipientId" },
						encryptedEntity.recipientId,
						decryptedJsonStrictness,
					),
				invoiceReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceReference"]?.also { usedEncryptedContent += "invoiceReference" },
						encryptedEntity.invoiceReference,
						decryptedJsonStrictness,
					),
				decisionReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["decisionReference"]?.also { usedEncryptedContent += "decisionReference" },
						encryptedEntity.decisionReference,
						decryptedJsonStrictness,
					),
				thirdPartyReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyReference"]?.also { usedEncryptedContent += "thirdPartyReference" },
						encryptedEntity.thirdPartyReference,
						decryptedJsonStrictness,
					),
				thirdPartyPaymentJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyPaymentJustification"]?.also { usedEncryptedContent += "thirdPartyPaymentJustification" },
						encryptedEntity.thirdPartyPaymentJustification,
						decryptedJsonStrictness,
					),
				thirdPartyPaymentReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyPaymentReason"]?.also { usedEncryptedContent += "thirdPartyPaymentReason" },
						encryptedEntity.thirdPartyPaymentReason,
						decryptedJsonStrictness,
					),
				reason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reason"]?.also { usedEncryptedContent += "reason" },
						encryptedEntity.reason,
						decryptedJsonStrictness,
					),
				groupId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["groupId"]?.also { usedEncryptedContent += "groupId" },
						encryptedEntity.groupId,
						decryptedJsonStrictness,
					),
				paymentType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paymentType"]?.also { usedEncryptedContent += "paymentType" },
						encryptedEntity.paymentType,
						decryptedJsonStrictness,
					),
				paid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paid"]?.also { usedEncryptedContent += "paid" },
						encryptedEntity.paid,
						decryptedJsonStrictness,
					),
				payments =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["payments"]?.also { usedEncryptedContent += "payments" },
						encryptedEntity.payments,
						decryptedJsonStrictness,
					),
				gnotionSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionSsin"]?.also { usedEncryptedContent += "gnotionSsin" },
						encryptedEntity.gnotionSsin,
						decryptedJsonStrictness,
					),
				gnotionLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionLastName"]?.also { usedEncryptedContent += "gnotionLastName" },
						encryptedEntity.gnotionLastName,
						decryptedJsonStrictness,
					),
				gnotionFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionFirstName"]?.also { usedEncryptedContent += "gnotionFirstName" },
						encryptedEntity.gnotionFirstName,
						decryptedJsonStrictness,
					),
				gnotionCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionCdHcParty"]?.also { usedEncryptedContent += "gnotionCdHcParty" },
						encryptedEntity.gnotionCdHcParty,
						decryptedJsonStrictness,
					),
				invoicePeriod =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicePeriod"]?.also { usedEncryptedContent += "invoicePeriod" },
						encryptedEntity.invoicePeriod,
						decryptedJsonStrictness,
					),
				careProviderType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careProviderType"]?.also { usedEncryptedContent += "careProviderType" },
						encryptedEntity.careProviderType,
						decryptedJsonStrictness,
					),
				internshipSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipSsin"]?.also { usedEncryptedContent += "internshipSsin" },
						encryptedEntity.internshipSsin,
						decryptedJsonStrictness,
					),
				internshipLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipLastName"]?.also { usedEncryptedContent += "internshipLastName" },
						encryptedEntity.internshipLastName,
						decryptedJsonStrictness,
					),
				internshipFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipFirstName"]?.also { usedEncryptedContent += "internshipFirstName" },
						encryptedEntity.internshipFirstName,
						decryptedJsonStrictness,
					),
				internshipCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipCdHcParty"]?.also { usedEncryptedContent += "internshipCdHcParty" },
						encryptedEntity.internshipCdHcParty,
						decryptedJsonStrictness,
					),
				internshipCbe =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipCbe"]?.also { usedEncryptedContent += "internshipCbe" },
						encryptedEntity.internshipCbe,
						decryptedJsonStrictness,
					),
				supervisorSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorSsin"]?.also { usedEncryptedContent += "supervisorSsin" },
						encryptedEntity.supervisorSsin,
						decryptedJsonStrictness,
					),
				supervisorLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorLastName"]?.also { usedEncryptedContent += "supervisorLastName" },
						encryptedEntity.supervisorLastName,
						decryptedJsonStrictness,
					),
				supervisorFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorFirstName"]?.also { usedEncryptedContent += "supervisorFirstName" },
						encryptedEntity.supervisorFirstName,
						decryptedJsonStrictness,
					),
				supervisorCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorCdHcParty"]?.also { usedEncryptedContent += "supervisorCdHcParty" },
						encryptedEntity.supervisorCdHcParty,
						decryptedJsonStrictness,
					),
				supervisorCbe =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorCbe"]?.also { usedEncryptedContent += "supervisorCbe" },
						encryptedEntity.supervisorCbe,
						decryptedJsonStrictness,
					),
				error =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["error"]?.also { usedEncryptedContent += "error" },
						encryptedEntity.error,
						decryptedJsonStrictness,
					),
				encounterLocationName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["encounterLocationName"]?.also { usedEncryptedContent += "encounterLocationName" },
						encryptedEntity.encounterLocationName,
						decryptedJsonStrictness,
					),
				encounterLocationNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["encounterLocationNorm"]?.also { usedEncryptedContent += "encounterLocationNorm" },
						encryptedEntity.encounterLocationNorm,
						decryptedJsonStrictness,
					),
				longDelayJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["longDelayJustification"]?.also { usedEncryptedContent += "longDelayJustification" },
						encryptedEntity.longDelayJustification,
						decryptedJsonStrictness,
					),
				correctiveInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["correctiveInvoiceId"]?.also { usedEncryptedContent += "correctiveInvoiceId" },
						encryptedEntity.correctiveInvoiceId,
						decryptedJsonStrictness,
					),
				correctedInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["correctedInvoiceId"]?.also { usedEncryptedContent += "correctedInvoiceId" },
						encryptedEntity.correctedInvoiceId,
						decryptedJsonStrictness,
					),
				creditNote =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["creditNote"]?.also { usedEncryptedContent += "creditNote" },
						encryptedEntity.creditNote,
						decryptedJsonStrictness,
					),
				creditNoteRelatedInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["creditNoteRelatedInvoiceId"]?.also { usedEncryptedContent += "creditNoteRelatedInvoiceId" },
						encryptedEntity.creditNoteRelatedInvoiceId,
						decryptedJsonStrictness,
					),
				idDocument =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idDocument"]?.also { usedEncryptedContent += "idDocument" },
						encryptedEntity.idDocument,
						decryptedJsonStrictness,
					),
				admissionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["admissionDate"]?.also { usedEncryptedContent += "admissionDate" },
						encryptedEntity.admissionDate,
						decryptedJsonStrictness,
					),
				locationService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationService"]?.also { usedEncryptedContent += "locationService" },
						encryptedEntity.locationService,
						decryptedJsonStrictness,
					),
				cancelReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelReason"]?.also { usedEncryptedContent += "cancelReason" },
						encryptedEntity.cancelReason,
						decryptedJsonStrictness,
					),
				cancelDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelDate"]?.also { usedEncryptedContent += "cancelDate" },
						encryptedEntity.cancelDate,
						decryptedJsonStrictness,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Invoice encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
