// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object InvoiceDecryptorFactory : EntityDecryptorFactory<EncryptedInvoice, DecryptedInvoice> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedInvoice, DecryptedInvoice> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"Invoice is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val invoicingCodesDecryptor =
			manifest?.recursiveEncryption?.get("invoicingCodes")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedInvoicingCode::class,
						decryptedClass = DecryptedInvoicingCode::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedInvoicingCode::class,
				decryptedClass = DecryptedInvoicingCode::class,
			)
		return InvoiceDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			invoicingCodesDecryptor = invoicingCodesDecryptor,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class InvoiceDecryptor(
	private val encryptedContentDecoder: Json,
	private val invoicingCodesDecryptor: Lazy<EntityDecryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedInvoice, DecryptedInvoice>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoice,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedInvoice {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInvoice(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						entityCustomisedModelVersion,
					),
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						entityCustomisedModelVersion,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						entityCustomisedModelVersion,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						entityCustomisedModelVersion,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						entityCustomisedModelVersion,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				deletionDate = encryptedEntity.deletionDate,
				invoiceDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceDate"]?.also { usedEncryptedContent += "invoiceDate" },
						encryptedEntity.invoiceDate,
						entityCustomisedModelVersion,
					),
				sentDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sentDate"]?.also { usedEncryptedContent += "sentDate" },
						encryptedEntity.sentDate,
						entityCustomisedModelVersion,
					),
				printedDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["printedDate"]?.also { usedEncryptedContent += "printedDate" },
						encryptedEntity.printedDate,
						entityCustomisedModelVersion,
					),
				invoicingCodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicingCodes"]?.also { usedEncryptedContent += "invoicingCodes" },
						encryptedEntity.invoicingCodes.map { x0 ->
							invoicingCodesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				receipts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["receipts"]?.also { usedEncryptedContent += "receipts" },
						encryptedEntity.receipts,
						entityCustomisedModelVersion,
					),
				recipientId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recipientId"]?.also { usedEncryptedContent += "recipientId" },
						encryptedEntity.recipientId,
						entityCustomisedModelVersion,
					),
				invoiceReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceReference"]?.also { usedEncryptedContent += "invoiceReference" },
						encryptedEntity.invoiceReference,
						entityCustomisedModelVersion,
					),
				decisionReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["decisionReference"]?.also { usedEncryptedContent += "decisionReference" },
						encryptedEntity.decisionReference,
						entityCustomisedModelVersion,
					),
				thirdPartyReference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyReference"]?.also { usedEncryptedContent += "thirdPartyReference" },
						encryptedEntity.thirdPartyReference,
						entityCustomisedModelVersion,
					),
				thirdPartyPaymentJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyPaymentJustification"]?.also { usedEncryptedContent += "thirdPartyPaymentJustification" },
						encryptedEntity.thirdPartyPaymentJustification,
						entityCustomisedModelVersion,
					),
				thirdPartyPaymentReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["thirdPartyPaymentReason"]?.also { usedEncryptedContent += "thirdPartyPaymentReason" },
						encryptedEntity.thirdPartyPaymentReason,
						entityCustomisedModelVersion,
					),
				reason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reason"]?.also { usedEncryptedContent += "reason" },
						encryptedEntity.reason,
						entityCustomisedModelVersion,
					),
				groupId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["groupId"]?.also { usedEncryptedContent += "groupId" },
						encryptedEntity.groupId,
						entityCustomisedModelVersion,
					),
				paymentType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paymentType"]?.also { usedEncryptedContent += "paymentType" },
						encryptedEntity.paymentType,
						entityCustomisedModelVersion,
					),
				paid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paid"]?.also { usedEncryptedContent += "paid" },
						encryptedEntity.paid,
						entityCustomisedModelVersion,
					),
				payments =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["payments"]?.also { usedEncryptedContent += "payments" },
						encryptedEntity.payments,
						entityCustomisedModelVersion,
					),
				gnotionSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionSsin"]?.also { usedEncryptedContent += "gnotionSsin" },
						encryptedEntity.gnotionSsin,
						entityCustomisedModelVersion,
					),
				gnotionLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionLastName"]?.also { usedEncryptedContent += "gnotionLastName" },
						encryptedEntity.gnotionLastName,
						entityCustomisedModelVersion,
					),
				gnotionFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionFirstName"]?.also { usedEncryptedContent += "gnotionFirstName" },
						encryptedEntity.gnotionFirstName,
						entityCustomisedModelVersion,
					),
				gnotionCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gnotionCdHcParty"]?.also { usedEncryptedContent += "gnotionCdHcParty" },
						encryptedEntity.gnotionCdHcParty,
						entityCustomisedModelVersion,
					),
				invoicePeriod =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicePeriod"]?.also { usedEncryptedContent += "invoicePeriod" },
						encryptedEntity.invoicePeriod,
						entityCustomisedModelVersion,
					),
				careProviderType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careProviderType"]?.also { usedEncryptedContent += "careProviderType" },
						encryptedEntity.careProviderType,
						entityCustomisedModelVersion,
					),
				internshipSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipSsin"]?.also { usedEncryptedContent += "internshipSsin" },
						encryptedEntity.internshipSsin,
						entityCustomisedModelVersion,
					),
				internshipLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipLastName"]?.also { usedEncryptedContent += "internshipLastName" },
						encryptedEntity.internshipLastName,
						entityCustomisedModelVersion,
					),
				internshipFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipFirstName"]?.also { usedEncryptedContent += "internshipFirstName" },
						encryptedEntity.internshipFirstName,
						entityCustomisedModelVersion,
					),
				internshipCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipCdHcParty"]?.also { usedEncryptedContent += "internshipCdHcParty" },
						encryptedEntity.internshipCdHcParty,
						entityCustomisedModelVersion,
					),
				internshipCbe =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["internshipCbe"]?.also { usedEncryptedContent += "internshipCbe" },
						encryptedEntity.internshipCbe,
						entityCustomisedModelVersion,
					),
				supervisorSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorSsin"]?.also { usedEncryptedContent += "supervisorSsin" },
						encryptedEntity.supervisorSsin,
						entityCustomisedModelVersion,
					),
				supervisorLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorLastName"]?.also { usedEncryptedContent += "supervisorLastName" },
						encryptedEntity.supervisorLastName,
						entityCustomisedModelVersion,
					),
				supervisorFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorFirstName"]?.also { usedEncryptedContent += "supervisorFirstName" },
						encryptedEntity.supervisorFirstName,
						entityCustomisedModelVersion,
					),
				supervisorCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorCdHcParty"]?.also { usedEncryptedContent += "supervisorCdHcParty" },
						encryptedEntity.supervisorCdHcParty,
						entityCustomisedModelVersion,
					),
				supervisorCbe =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["supervisorCbe"]?.also { usedEncryptedContent += "supervisorCbe" },
						encryptedEntity.supervisorCbe,
						entityCustomisedModelVersion,
					),
				error =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["error"]?.also { usedEncryptedContent += "error" },
						encryptedEntity.error,
						entityCustomisedModelVersion,
					),
				encounterLocationName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["encounterLocationName"]?.also { usedEncryptedContent += "encounterLocationName" },
						encryptedEntity.encounterLocationName,
						entityCustomisedModelVersion,
					),
				encounterLocationNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["encounterLocationNorm"]?.also { usedEncryptedContent += "encounterLocationNorm" },
						encryptedEntity.encounterLocationNorm,
						entityCustomisedModelVersion,
					),
				longDelayJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["longDelayJustification"]?.also { usedEncryptedContent += "longDelayJustification" },
						encryptedEntity.longDelayJustification,
						entityCustomisedModelVersion,
					),
				correctiveInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["correctiveInvoiceId"]?.also { usedEncryptedContent += "correctiveInvoiceId" },
						encryptedEntity.correctiveInvoiceId,
						entityCustomisedModelVersion,
					),
				correctedInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["correctedInvoiceId"]?.also { usedEncryptedContent += "correctedInvoiceId" },
						encryptedEntity.correctedInvoiceId,
						entityCustomisedModelVersion,
					),
				creditNote =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["creditNote"]?.also { usedEncryptedContent += "creditNote" },
						encryptedEntity.creditNote,
						entityCustomisedModelVersion,
					),
				creditNoteRelatedInvoiceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["creditNoteRelatedInvoiceId"]?.also { usedEncryptedContent += "creditNoteRelatedInvoiceId" },
						encryptedEntity.creditNoteRelatedInvoiceId,
						entityCustomisedModelVersion,
					),
				idDocument =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idDocument"]?.also { usedEncryptedContent += "idDocument" },
						encryptedEntity.idDocument,
						entityCustomisedModelVersion,
					),
				admissionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["admissionDate"]?.also { usedEncryptedContent += "admissionDate" },
						encryptedEntity.admissionDate,
						entityCustomisedModelVersion,
					),
				locationService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationService"]?.also { usedEncryptedContent += "locationService" },
						encryptedEntity.locationService,
						entityCustomisedModelVersion,
					),
				cancelReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelReason"]?.also { usedEncryptedContent += "cancelReason" },
						encryptedEntity.cancelReason,
						entityCustomisedModelVersion,
					),
				cancelDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelDate"]?.also { usedEncryptedContent += "cancelDate" },
						encryptedEntity.cancelDate,
						entityCustomisedModelVersion,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						entityCustomisedModelVersion,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Invoice encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
