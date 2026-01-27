package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.api.InvoiceBasicApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavouredApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavourlessApi
import com.icure.cardinal.sdk.api.InvoiceBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.InvoiceBasicInGroupApi
import com.icure.cardinal.sdk.api.InvoiceFlavouredApi
import com.icure.cardinal.sdk.api.InvoiceFlavouredInGroupApi
import com.icure.cardinal.sdk.api.InvoiceInGroupApi
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.currentFuzzyDateTime
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedInvoice, EncryptedInvoice> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedInvoice.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Invoice,
	manifest = EntitiesEncryptedFieldsManifests::invoice
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedInvoice, DecryptedInvoice> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedInvoice.serializer(),
	decryptedSerializer = DecryptedInvoice.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Invoice,
	manifest = EntitiesEncryptedFieldsManifests::invoice,
	patchJson = JsonPatcher::patchInvoice
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedInvoice, Invoice> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedInvoice.serializer(),
	decryptedSerializer = DecryptedInvoice.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Invoice,
	manifest = EntitiesEncryptedFieldsManifests::invoice,
	patchJson = JsonPatcher::patchInvoice
)

@InternalIcureApi
private open class AbstractInvoiceBasicFlavouredApi<E : Invoice>(
	protected val rawApi: RawInvoiceApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedInvoice, E>,
) : InvoiceBasicFlavouredApi<E>,
	InvoiceBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedInvoice, E> by flavour {

	override suspend fun createInvoice(entity: E): E = doCreateInvoice(groupId = null, entity = entity)

	override suspend fun createInvoice(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateInvoice(groupId = groupId, entity = it)
	}

	private suspend fun doCreateInvoice(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createInvoice(encrypted)
		} else {
			rawApi.createInvoiceInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createInvoices(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateInvoices(groupId = null, entities = entities)
	}

	override suspend fun createInvoices(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreation(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateInvoices(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doCreateInvoices(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { invoices ->
		val encrypted = validateAndMaybeEncrypt(groupId, invoices)
		return if (groupId == null) {
			rawApi.createInvoices(encrypted)
		} else {
			rawApi.createInvoicesInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun undeleteInvoiceById(id: String, rev: String): E = doUndeleteInvoice(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteInvoice(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	private suspend fun doUndeleteInvoice(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteInvoice(entityId, rev)
		} else {
			rawApi.undeleteInvoiceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteInvoicesByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteInvoices(groupId = null, entityIds = entityIds)

	override suspend fun undeleteInvoicesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteInvoices(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeleteInvoices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteInvoices(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteInvoicesInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyInvoice(entity: E): E = doModifyInvoice(groupId = null, entity = entity)

	override suspend fun modifyInvoice(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyInvoice(groupId = groupId, entity = it)
	}

	private suspend fun doModifyInvoice(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyInvoice(encrypted)
		} else {
			rawApi.modifyInvoiceInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyInvoices(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyInvoices(groupId = null, entities = entities)
	}

	override suspend fun modifyInvoices(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModification(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyInvoices(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doModifyInvoices(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { invoices ->
		val encrypted = validateAndMaybeEncrypt(groupId, invoices)
		return if (groupId == null) {
			rawApi.modifyInvoices(encrypted)
		} else {
			rawApi.modifyInvoicesInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getInvoice(entityId: String): E? = doGetInvoice(groupId = null, entityId = entityId)

	override suspend fun getInvoice(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetInvoice(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetInvoice(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getInvoice(entityId)
		} else {
			rawApi.getInvoiceInGroup(groupId = groupId, invoiceId = entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	override suspend fun getInvoices(entityIds: List<String>): List<E> = doGetInvoices(groupId = null, entityIds)

	override suspend fun getInvoices(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetInvoices(groupId = groupId, entityIds = entityIds)
	}

	suspend fun doGetInvoices(groupId: String?, entityIds: List<String>) = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getInvoices(ListOfIds(ids))
		} else {
			rawApi.getInvoicesInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun reassignInvoice(invoice: E): E =
		rawApi.reassignInvoice(validateAndMaybeEncrypt(null, invoice)).successBody().let { maybeDecrypt(null, it) }

	override suspend fun mergeTo(
		invoiceId: String,
		ids: List<String>,
		) = rawApi.mergeTo(invoiceId, ListOfIds(ids)).successBody().let { maybeDecrypt(null, it) }

	override suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
		): E = rawApi.validate(invoiceId, scheme, forcedValue).successBody().let { maybeDecrypt(null, it) }

	//TODO: Maybe manage a separate manifest for InvoicingCode and encrypt automatically
	override suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Int?,
		invoicingCodes: List<EncryptedInvoicingCode>,
		): List<E> =
		rawApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId, gracePeriod, invoicingCodes).successBody().let { maybeDecrypt(it) }

	override suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
		): List<E> =
		rawApi.removeCodes(userId, serviceId, secretFKeys, tarificationIds).successBody().let { maybeDecrypt(it) }

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterInvoicesBy()"))
	override suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long?,
		toDate: Long?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		) = rawApi.findInvoicesByAuthor(hcPartyId, fromDate, toDate, startKey.encodeStartKey(), startDocumentId, limit).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): List<E> =
		rawApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long?,
		to: Long?,
	) = rawApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId, sentMediumType, invoiceType, sent, from, to).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByContactIds(contactIds: List<String>): List<E> =
		rawApi.listInvoicesByContactIds(ListOfIds(contactIds)).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByRecipientsIds(recipientsIds: List<String>): List<E> =
		rawApi.listInvoicesByRecipientsIds(recipientsIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToInsurances(userIds: List<String>): List<E> =
		rawApi.listToInsurances(userIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToInsurancesUnsent(userIds: List<String>): List<E> =
		rawApi.listToInsurancesUnsent(userIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToPatients(hcPartyId: String): List<E> =
		rawApi.listToPatients(hcPartyId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listToPatientsUnsent(hcPartyId: String?): List<E> =
		rawApi.listToPatientsUnsent(hcPartyId).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByIds(ids: List<String>): List<E> =
		rawApi.listInvoicesByIds(ids.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Long,
		to: Long,
	): List<E> = rawApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status, from, to).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listInvoicesByServiceIds(serviceIds: List<String>): List<E> =
		rawApi.listInvoicesByServiceIds(serviceIds.joinToString(",")).successBody().let { maybeDecrypt(it) }

	@Deprecated("Use filter instead")
	override suspend fun listAllHcpsByStatus(
		status: String,
		from: Long?,
		to: Long?,
		hcpIds: List<String>,
		): List<E> =
		rawApi.listAllHcpsByStatus(status, from, to, ListOfIds(hcpIds)).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private class AbstractInvoiceFlavouredApi<E : Invoice>(
	rawApi: RawInvoiceApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedInvoice, E>,
) : AbstractInvoiceBasicFlavouredApi<E>(rawApi, config, flavour),
	InvoiceFlavouredApi<E>,
	InvoiceFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		invoice: E,
		options: InvoiceShareOptions?,
	): E = shareWithMany(invoice, mapOf(delegateId to (options ?: InvoiceShareOptions())))

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		invoice: GroupScoped<E>,
		options: InvoiceShareOptions?,
	): GroupScoped<E> = shareWithMany(invoice, mapOf(delegate to (options ?: InvoiceShareOptions())))

	override suspend fun shareWithMany(
		invoice: E,
		delegates: Map<String, InvoiceShareOptions>
	): E = doShareWithMany(entityGroupId = null, invoice = invoice, delegates = delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWithMany(
		invoice: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(
			keyEntryName = "delegate",
			valueEntryName = "shareOptions"
		) Map<EntityReferenceInGroup, InvoiceShareOptions>
	): GroupScoped<E> = GroupScoped(
		entity = doShareWithMany(
			entityGroupId = invoice.groupId,
			invoice = invoice.entity,
			delegates = delegates
		),
		groupId = invoice.groupId,
	)

	private suspend fun doShareWithMany(
		entityGroupId: String?,
		invoice: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, InvoiceShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			invoice,
			EntityWithEncryptionMetadataTypeName.Invoice,
			delegates,
			true,
			{ doGetInvoice(entityGroupId, it) ?: throw NotFoundException("Invoice $it not found") },
			{
				maybeDecrypt(
					entityGroupId,
					if (entityGroupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, entityGroupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listInvoiceIdsByDataOwnerPatientInvoiceDate(
			dataOwnerId = hcPartyId,
			startDate = startDate,
			endDate = endDate,
			descending = descending,
			secretPatientKeys = ListOfIds(
				config.crypto.entity.secretIdsOf(
					null,
					patient,
					EntityWithEncryptionMetadataTypeName.Patient,
					null
				).toList())
		).successBody()
	) { ids ->
		rawApi.getInvoices(ListOfIds(ids)).successBody().let { maybeDecrypt(it) }
	}
}

@InternalIcureApi
private abstract class AbstractInvoiceBasicFlavourless(
	protected val rawApi: RawInvoiceApi
) {

	protected suspend fun doDeleteInvoice(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteInvoice(entityId, rev)
		} else {
			rawApi.deleteInvoiceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteInvoices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteInvoicesWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteInvoicesInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeInvoice(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeInvoice(entityId, rev)
		} else {
			rawApi.purgeInvoiceInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeInvoices(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeInvoices(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeInvoicesInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

}

@InternalIcureApi
private class InvoiceBasicFlavourlessApiImpl(rawApi: RawInvoiceApi) : AbstractInvoiceBasicFlavourless(rawApi), InvoiceBasicFlavourlessApi {

	override suspend fun deleteInvoiceById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteInvoice(groupId = null, entityId, rev)

	override suspend fun deleteInvoicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteInvoices(groupId = null, entityIds)

	override suspend fun purgeInvoiceById(id: String, rev: String) {
		doPurgeInvoice(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeInvoicesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeInvoices(groupId = null, entityIds = entityIds)

	@Deprecated("Use filter instead")
	override suspend fun getTarificationsCodesOccurrences(
		minOccurrence: Int,
	) = rawApi.getTarificationsCodesOccurrences(minOccurrence.toLong()).successBody()
}

@InternalIcureApi
private class InvoiceBasicFlavourlessInGroupApiImpl(
	rawApi: RawInvoiceApi
) : AbstractInvoiceBasicFlavourless(rawApi), InvoiceBasicFlavourlessInGroupApi {
	override suspend fun deleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteInvoice(groupId, it.id, it.rev)
		}

	override suspend fun deleteInvoicesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteInvoices(groupId, entities)
		}

	override suspend fun purgeInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeInvoice(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeInvoicesByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeInvoices(groupId, batch)
		}
}

@InternalIcureApi
internal fun initInvoiceApi(
	rawApi: RawInvoiceApi,
	config: ApiConfiguration
): InvoiceApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractInvoiceFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractInvoiceFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractInvoiceFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return InvoiceApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class InvoiceApiImpl(
	private val rawApi: RawInvoiceApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractInvoiceFlavouredApi<EncryptedInvoice>,
	private val decryptedFlavour: AbstractInvoiceFlavouredApi<DecryptedInvoice>,
	private val tryAndRecoverFlavour: AbstractInvoiceFlavouredApi<Invoice>,
) : InvoiceApi,
	InvoiceFlavouredApi<DecryptedInvoice> by decryptedFlavour,
	InvoiceBasicFlavourlessApi by InvoiceBasicFlavourlessApiImpl(rawApi) {

	override val encrypted: InvoiceFlavouredApi<EncryptedInvoice> = encryptedFlavour
	override val tryAndRecover: InvoiceFlavouredApi<Invoice> = tryAndRecoverFlavour

	override val inGroup: InvoiceInGroupApi = object : InvoiceInGroupApi,
		InvoiceFlavouredInGroupApi<DecryptedInvoice> by decryptedFlavour,
		InvoiceBasicFlavourlessInGroupApi by InvoiceBasicFlavourlessInGroupApiImpl(rawApi) {

		override val encrypted: InvoiceFlavouredInGroupApi<EncryptedInvoice> = encryptedFlavour
		override val tryAndRecover: InvoiceFlavouredInGroupApi<Invoice> = tryAndRecoverFlavour

		override suspend fun decrypt(invoices: List<GroupScoped<EncryptedInvoice>>): List<GroupScoped<DecryptedInvoice>> =
			invoices.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(invoices: List<GroupScoped<EncryptedInvoice>>): List<GroupScoped<Invoice>> =
			invoices.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedInvoice?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedInvoice> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient?.let { it.entity to it.groupId },
					user,
					delegates,
					secretId,
					alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun getEncryptionKeysOf(invoice: GroupScoped<Invoice>): Set<HexString> =
			doGetEncryptionKeysOf(invoice.groupId, invoice.entity)

		override suspend fun hasWriteAccess(invoice: GroupScoped<Invoice>): Boolean =
			doHasWriteAccess(invoice.groupId, invoice.entity)

		override suspend fun decryptPatientIdOf(invoice: GroupScoped<Invoice>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(invoice.groupId, invoice.entity).mapNullGroupTo(invoice.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Invoice>,
			delegates: Set<EntityReferenceInGroup>
		) = doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun getEncryptionKeysOf(invoice: Invoice): Set<HexString> =
		doGetEncryptionKeysOf(groupId = null, invoice = invoice)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, invoice: Invoice): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			entityGroupId = groupId,
			entity = invoice,
			entityType = EntityWithEncryptionMetadataTypeName.Invoice,
			dataOwnerId = null
		)

	override suspend fun hasWriteAccess(invoice: Invoice): Boolean = doHasWriteAccess(groupId = null, invoice = invoice)

	private suspend fun doHasWriteAccess(groupId: String?, invoice: Invoice): Boolean =
		config.crypto.entity.hasWriteAccess(entityGroupId = groupId, entity = invoice, entityType = EntityWithEncryptionMetadataTypeName.Invoice)

	override suspend fun decryptPatientIdOf(invoice: Invoice): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(groupId = null, invoice = invoice)

	private suspend fun doDecryptPatientIdOf(groupId: String?, invoice: Invoice): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			entityGroupId = groupId,
			entity = invoice,
			entityType = EntityWithEncryptionMetadataTypeName.Invoice,
			dataOwnerId = null
		).mapTo(mutableSetOf()) { config.crypto.entity.parseReference(groupId, it) }

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.Invoice,
			delegates.asLocalDataOwnerReferences()
		)
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Invoice, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			entityGroupId = groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Invoice,
			delegates
		)
	}


	override suspend fun withEncryptionMetadata(
		base: DecryptedInvoice?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedInvoice = doWithEncryptionMetadata(
		entityGroupId = null,
		base = base,
		patient = patient?.let { it to null },
		user = user,
		delegates = delegates.keyAsLocalDataOwnerReferences(),
		secretId = secretId,
		alternateRootDelegateReference = alternateRootDelegateId?.let {
			EntityReferenceInGroup(groupId = null, entityId = it)
		}
	)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedInvoice?,
		patient: Pair<Patient, String?>?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateReference: EntityReferenceInGroup?,
	): DecryptedInvoice =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedInvoice(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				groupId = base?.groupId ?: base?.id,
				invoiceDate = base?.invoiceDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
			),
			entityType = EntityWithEncryptionMetadataTypeName.Invoice,
			owningEntityDetails = patient?.let { (patient, patientGroup) ->
				OwningEntityDetails(
					groupId = patientGroup,
					id = patient.id,
					secretIds = config.crypto.entity.resolveSecretIdOption(
						entityGroupId,
						patient,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateReference,
		).updatedEntity

	override suspend fun decrypt(invoice: EncryptedInvoice): DecryptedInvoice =
		config.crypto.entity.decryptEntities(
			null,
			listOf(invoice),
			EntityWithEncryptionMetadataTypeName.Invoice,
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }.single()

	override suspend fun tryDecrypt(invoice: EncryptedInvoice): Invoice =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(invoice),
			EntityWithEncryptionMetadataTypeName.Invoice,
			EncryptedInvoice.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedInvoice>(config.jsonPatcher.patchInvoice(it)) }.single()
}

@InternalIcureApi
internal fun initInvoiceBasicApi(
	rawApi: RawInvoiceApi,
	config: BasicApiConfiguration
): InvoiceBasicApi = InvoiceBasicApiImpl(
	rawApi,
	config,
	AbstractInvoiceBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class InvoiceBasicApiImpl(
	rawApi: RawInvoiceApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractInvoiceBasicFlavouredApi<EncryptedInvoice>,
) : InvoiceBasicApi,
	InvoiceBasicFlavouredApi<EncryptedInvoice> by encryptedFlavour,
	InvoiceBasicFlavourlessApi by InvoiceBasicFlavourlessApiImpl(rawApi) {

	override val inGroup: InvoiceBasicInGroupApi = object : InvoiceBasicInGroupApi,
		InvoiceBasicFlavouredInGroupApi<EncryptedInvoice> by encryptedFlavour,
		InvoiceBasicFlavourlessInGroupApi by InvoiceBasicFlavourlessInGroupApiImpl(rawApi) {}
}
