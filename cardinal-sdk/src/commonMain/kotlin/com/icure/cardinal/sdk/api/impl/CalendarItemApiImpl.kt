package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CalendarItemApi
import com.icure.cardinal.sdk.api.CalendarItemBasicApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavouredApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavourlessApi
import com.icure.cardinal.sdk.api.CalendarItemBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.CalendarItemBasicInGroupApi
import com.icure.cardinal.sdk.api.CalendarItemFlavouredApi
import com.icure.cardinal.sdk.api.CalendarItemFlavouredInGroupApi
import com.icure.cardinal.sdk.api.CalendarItemInGroupApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.MissingAvailabilityException
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapCalendarItemFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.serialization.CalendarItemAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedCalendarItem, EncryptedCalendarItem> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedCalendarItem.serializer(),
	type = EntityWithEncryptionMetadataTypeName.CalendarItem,
	manifest = EntitiesEncryptedFieldsManifests::calendarItem
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedCalendarItem, DecryptedCalendarItem> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedCalendarItem.serializer(),
	decryptedSerializer = DecryptedCalendarItem.serializer(),
	type = EntityWithEncryptionMetadataTypeName.CalendarItem,
	manifest = EntitiesEncryptedFieldsManifests::calendarItem,
	patchJson = JsonPatcher::patchCalendarItem
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedCalendarItem, CalendarItem> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedCalendarItem.serializer(),
	decryptedSerializer = DecryptedCalendarItem.serializer(),
	type = EntityWithEncryptionMetadataTypeName.CalendarItem,
	manifest = EntitiesEncryptedFieldsManifests::calendarItem,
	patchJson = JsonPatcher::patchCalendarItem
)

@InternalIcureApi
private open class AbstractCalendarItemBasicFlavouredApi<E : CalendarItem>(
	protected val rawApi: RawCalendarItemApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedCalendarItem, E>
) : CalendarItemBasicFlavouredApi<E>,
	CalendarItemBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedCalendarItem, E> by flavour {

	override suspend fun createCalendarItem(entity: E): E =
		doCreateCalendarItem(groupId = null, entity)

	override suspend fun createCalendarItem(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreateCalendarItem(entity.groupId, entity.entity), entity.groupId)

	private suspend fun doCreateCalendarItem(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createCalendarItem(encrypted)
		} else {
			rawApi.createCalendarItemInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createCalendarItems(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateCalendarItems(groupId = null, entities)
	}

	override suspend fun createCalendarItems(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doCreateCalendarItems(groupId, batch)
		}
	}

	private suspend fun doCreateCalendarItems(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { calendarItems ->
		val encrypted = validateAndMaybeEncrypt(groupId, calendarItems)
		if (groupId == null) {
			rawApi.createCalendarItems(encrypted)
		} else {
			rawApi.createCalendarItemsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun bookCalendarItemCheckingAvailability(entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(null, entity)
		return maybeDecrypt(
			null,
			rawApi.safeBook(encrypted).successBody(MissingAvailabilityException)
		)
	}

	override suspend fun undeleteCalendarItemById(id: String, rev: String): E =
		doUndeleteCalendarItemById(groupId = null, id = id, rev = rev)

	override suspend fun undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		GroupScoped(
			entity = doUndeleteCalendarItemById(groupId = entityId.groupId, id = entityId.entity.id, rev = entityId.entity.rev),
			groupId = entityId.groupId
		)

	private suspend fun doUndeleteCalendarItemById(groupId: String?, id: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteCalendarItem(id, rev)
		} else {
			rawApi.undeleteCalendarItemInGroup(groupId = groupId, calendarItemId = id, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteCalendarItemsByIds(groupId = null, entityIds = entityIds)

	override suspend fun undeleteCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doUndeleteCalendarItemsByIds(groupId = groupId, entityIds = batch)
		}

	protected suspend fun doUndeleteCalendarItemsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteCalendarItems(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteCalendarItemsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().let { maybeDecrypt(entitiesGroupId = groupId, entities = it) }
		}

	override suspend fun modifyCalendarItem(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(
			doModifyCalendarItem(entity.groupId, entity.entity),
			entity.groupId
		)

	override suspend fun modifyCalendarItem(entity: E): E =
		doModifyCalendarItem(groupId = null, entity)

	private suspend fun doModifyCalendarItem(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyCalendarItem(encrypted)
		} else {
			rawApi.modifyCalendarItemInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun modifyCalendarItems(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyCalendarItems(groupId = null, entities = entities) }

	override suspend fun modifyCalendarItems(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doModifyCalendarItems(groupId, batch)
		}
	}

	private suspend fun doModifyCalendarItems(
		groupId: String?,
		entities: List<E>
	): List<E> = skipRequestOnEmptyList(entities) { calendarItems ->
		val encrypted = validateAndMaybeEncrypt(groupId, calendarItems)
		return if (groupId == null) {
			rawApi.modifyCalendarItems(encrypted)
		} else {
			rawApi.modifyCalendarItemsInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getCalendarItem(groupId: String, entityId: String): GroupScoped<E>? =
		doGetCalendarItem(groupId, entityId)?.let { GroupScoped(it, groupId) }

	override suspend fun getCalendarItem(entityId: String): E? =
		doGetCalendarItem(groupId = null, entityId)

	protected suspend fun doGetCalendarItem(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getCalendarItem(entityId)
		} else {
			rawApi.getCalendarItemInGroup(groupId = groupId, calendarItemId = entityId)
		}.successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getCalendarItems(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetCalendarItems(groupId, entityIds).map { GroupScoped(it, groupId) }

	override suspend fun getCalendarItems(entityIds: List<String>): List<E> =
		doGetCalendarItems(groupId = null, entityIds)

	suspend fun doGetCalendarItems(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getCalendarItemsWithIds(ListOfIds(ids))
		} else {
			rawApi.getCalendarItemsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

}

@InternalIcureApi
private class AbstractCalendarItemFlavouredApi<E : CalendarItem>(
	rawApi: RawCalendarItemApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedCalendarItem, E>,
	private val dataOwnerApi: RawDataOwnerApi
) : AbstractCalendarItemBasicFlavouredApi<E>(rawApi, config, flavour),
	CalendarItemFlavouredApi<E>,
	CalendarItemFlavouredInGroupApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		calendarItem: E,
		options: CalendarItemShareOptions?,
	): E =
		shareWithMany(calendarItem, mapOf(delegateId to (options ?: CalendarItemShareOptions())))

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		calendarItem: GroupScoped<E>,
		options: CalendarItemShareOptions?
	): GroupScoped<E> =
		shareWithMany(calendarItem, mapOf(delegate to (options ?: CalendarItemShareOptions())))

	override suspend fun shareWithMany(calendarItem: E, delegates: Map<String, CalendarItemShareOptions>): E =
		doShareWithMany(groupId = null, calendarItem, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWithMany(
		calendarItem: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CalendarItemShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(calendarItem.groupId, calendarItem.entity, delegates), calendarItem.groupId)

	private suspend fun doShareWithMany(
		groupId: String?,
		calendarItem: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, CalendarItemShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			calendarItem,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			delegates,
			true,
			{ doGetCalendarItem(groupId, it) ?: throw NotFoundException("CalendarItem $it not found") },
			{
				maybeDecrypt(
					groupId,
					if (groupId == null)
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, groupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	override suspend fun linkToPatient(calendarItem: CalendarItem, patient: Patient, shareLinkWithDelegates: Set<String>): E {
		require(calendarItem.secretForeignKeys.isNotEmpty()) { "Calendar item ${calendarItem.id} is already linked to a patient" }
		val currentDataOwnerId = dataOwnerApi.getCurrentDataOwner().successBody().dataOwner.id
		val delegates = shareLinkWithDelegates + currentDataOwnerId
		val secretForeignKeys = config.crypto.entity.getConfidentialSecretIdsOf(
			null,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			currentDataOwnerId
		)
		require(secretForeignKeys.isNotEmpty()) { "Could not find any secret id for patient ${patient.id} which is shared with the topmost ancestor of the current data owner" }
		val shareResult = config.crypto.entity.bulkShareOrUpdateEncryptedEntityMetadata(
			null,
			listOf(
				Pair(
					calendarItem,
					delegates.associateWith {
						DelegateShareOptions(
							shareSecretIds = emptySet(),
							shareEncryptionKeys = emptySet(),
							shareOwningEntityIds = setOf(patient.id),
							requestedPermissions = RequestedPermission.FullRead
						)
					}.keyAsLocalDataOwnerReferences()
				)
			),
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			true,
			{ rawApi.getCalendarItem(it).successBody() },
			{ rawApi.bulkShare(it).successBody() }
		)
		if(shareResult.updatedEntities.isEmpty() || shareResult.updatedEntities.first().id != calendarItem.id) {
			val errorsForEntity = shareResult.updateErrors.filter { it.entityId == calendarItem.id }
			if (errorsForEntity.isEmpty() || errorsForEntity.none { it.code == 409 }) {
				throw IllegalStateException("Unexpected error while linking calendar item ${calendarItem.id}")
			} else {
				throw IllegalStateException("Outdated calendar item revision ${calendarItem.id}-${calendarItem.rev}")
			}
		}
		return maybeDecrypt(
			null,
			rawApi.modifyCalendarItem(
				(shareResult.updatedEntities.first() as EncryptedCalendarItem).copy(secretForeignKeys = secretForeignKeys)
			).successBody()
		)
	}

	override suspend fun filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): PaginatedListIterator<E> =
		filterCalendarItemsBy(filter)

	override suspend fun filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): PaginatedListIterator<E> =
		doFilterCalendarItemsBy(
			null,
			filter
		) { it }

	override suspend fun filterCalendarItemsBySorted(
		groupId: String,
		filter: SortableFilterOptions<CalendarItem>
	): PaginatedListIterator<GroupScoped<E>> =
		filterCalendarItemsBy(groupId, filter)

	override suspend fun filterCalendarItemsBy(
		groupId: String,
		filter: FilterOptions<CalendarItem>
	): PaginatedListIterator<GroupScoped<E>> =
		doFilterCalendarItemsBy(
			groupId,
			filter
		) { GroupScoped(it, groupId) }

	private suspend inline fun <T : Any> doFilterCalendarItemsBy(
		groupId: String?,
		filter: FilterOptions<CalendarItem>,
		crossinline mapEntity: (E) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.matchCalendarItemsBy(
				mapCalendarItemFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody(),
		) {
			doGetCalendarItems(groupId, it).map { calendarItem -> mapEntity(calendarItem) }
		}
}

@InternalIcureApi
private abstract class AbstractCalendarItemBasicFlavourless(
	protected val rawApi: RawCalendarItemApi
) {

	protected suspend fun doDeleteCalendarItemById(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteCalendarItem(entityId, rev)
		} else {
			rawApi.deleteCalendarItemInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteCalendarItemsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteCalendarItemsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteCalendarItemsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeCalendarItemById(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeCalendarItem(entityId, rev)
		} else {
			rawApi.purgeCalendarItemInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeCalendarItemsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeCalendarItems(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeCalendarItemsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class CalendarItemBasicFlavourlessApiImpl(rawApi: RawCalendarItemApi) : AbstractCalendarItemBasicFlavourless(rawApi), CalendarItemBasicFlavourlessApi {

	override suspend fun deleteCalendarItemById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteCalendarItemById(groupId = null, entityId, rev)

	override suspend fun deleteCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteCalendarItemsByIds(groupId = null, entityIds)

	override suspend fun purgeCalendarItemById(id: String, rev: String) {
		doPurgeCalendarItemById(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeCalendarItemsByIds(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class CalendarItemBasicFlavourlessInGroupApiImpl(rawApi: RawCalendarItemApi) : AbstractCalendarItemBasicFlavourless(rawApi), CalendarItemBasicFlavourlessInGroupApi {
	override suspend fun deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(doDeleteCalendarItemById(entityId.groupId, entityId.entity.id, entityId.entity.rev), entityId.groupId)

	override suspend fun deleteCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteCalendarItemsByIds(groupId, entities)
		}

	override suspend fun purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeCalendarItemById(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch -> 
			doPurgeCalendarItemsByIds(groupId, batch)
		}
}

@InternalIcureApi
internal fun initCalendarItemApi(
	rawApi: RawCalendarItemApi,
	rawDataOwnerApi: RawDataOwnerApi,
	config: ApiConfiguration
): CalendarItemApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractCalendarItemFlavouredApi(rawApi, config, decryptedFlavour, rawDataOwnerApi)
	val encryptedApi = AbstractCalendarItemFlavouredApi(rawApi, config, encryptedFlavour, rawDataOwnerApi)
	val tryAndRecoverApi = AbstractCalendarItemFlavouredApi(rawApi, config, tryAndRecoverFlavour, rawDataOwnerApi)
	return CalendarItemApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class CalendarItemApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractCalendarItemFlavouredApi<EncryptedCalendarItem>,
	private val decryptedFlavour: AbstractCalendarItemFlavouredApi<DecryptedCalendarItem>,
	private val tryAndRecoverFlavour: AbstractCalendarItemFlavouredApi<CalendarItem>
) : CalendarItemApi,
	CalendarItemBasicFlavourlessApi by CalendarItemBasicFlavourlessApiImpl(rawApi),
	CalendarItemFlavouredApi<DecryptedCalendarItem> by decryptedFlavour {
	override val encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem> =
		encryptedFlavour

	override val tryAndRecover: CalendarItemFlavouredApi<CalendarItem> =
		tryAndRecoverFlavour

	override val inGroup: CalendarItemInGroupApi = object : CalendarItemInGroupApi,
		CalendarItemBasicFlavourlessInGroupApi by CalendarItemBasicFlavourlessInGroupApiImpl(rawApi),
		CalendarItemFlavouredInGroupApi<DecryptedCalendarItem> by decryptedFlavour {
		override val encrypted: CalendarItemFlavouredInGroupApi<EncryptedCalendarItem> = encryptedFlavour
		override val tryAndRecover: CalendarItemFlavouredInGroupApi<CalendarItem> = tryAndRecoverFlavour

		override suspend fun decrypt(calendarItems: List<GroupScoped<EncryptedCalendarItem>>): List<GroupScoped<DecryptedCalendarItem>> =
			calendarItems.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(calendarItems: List<GroupScoped<EncryptedCalendarItem>>): List<GroupScoped<CalendarItem>> =
			calendarItems.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun encryptOrValidate(calendarItems: List<GroupScoped<CalendarItem>>): List<GroupScoped<EncryptedCalendarItem>> =
			calendarItems.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedCalendarItem?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel",
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedCalendarItem> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient?.let { Pair(it.entity, it.groupId) },
					user,
					delegates,
					secretId,
					alternateRootDelegateReference,
				),
				entityGroupId,
			)

		override suspend fun decryptPatientIdOf(calendarItem: GroupScoped<CalendarItem>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(calendarItem.groupId, calendarItem.entity).mapNullGroupTo(calendarItem.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<CalendarItem>,
			delegates: Set<EntityReferenceInGroup>,
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun getEncryptionKeysOf(calendarItem: GroupScoped<CalendarItem>): Set<HexString> =
			doGetEncryptionKeysOf(calendarItem.groupId, calendarItem.entity)

		override suspend fun hasWriteAccess(calendarItem: GroupScoped<CalendarItem>): Boolean =
			doHasWriteAccess(calendarItem.groupId, calendarItem.entity)

		override suspend fun matchCalendarItemsBy(groupId: String, filter: FilterOptions<CalendarItem>): List<String> =
			doMatchCalendarItemsBy(groupId, filter)

		override suspend fun matchCalendarItemsBySorted(
			groupId: String,
			filter: SortableFilterOptions<CalendarItem>,
		): List<String> = doMatchCalendarItemsBySorted(groupId, filter)
	}

	private val crypto get() = config.crypto

	override suspend fun withEncryptionMetadata(
		base: DecryptedCalendarItem?,
		patient: Patient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	) =
		doWithEncryptionMetadata(
			null,
			base,
			patient?.let { Pair(it, null) },
			user,
			delegates.keyAsLocalDataOwnerReferences(),
			secretId,
			alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedCalendarItem?,
		patientInGroup: Pair<Patient, String?>?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?
	): DecryptedCalendarItem =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedCalendarItem(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.CalendarItem,
			owningEntityDetails = patientInGroup?.let { (patient, patientGroup) ->
				OwningEntityDetails(
					patientGroup,
					patient.id,
					crypto.entity.resolveSecretIdOption(
						entityGroupId,
						patient,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun getEncryptionKeysOf(calendarItem: CalendarItem): Set<HexString> =
		doGetEncryptionKeysOf(null, calendarItem)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, calendarItem: CalendarItem): Set<HexString> =
		crypto.entity.encryptionKeysOf(groupId, calendarItem, EntityWithEncryptionMetadataTypeName.CalendarItem, null)

	override suspend fun hasWriteAccess(calendarItem: CalendarItem): Boolean =
		doHasWriteAccess(null, calendarItem)

	private suspend fun doHasWriteAccess(groupId: String?, calendarItem: CalendarItem): Boolean =
		crypto.entity.hasWriteAccess(groupId, calendarItem, EntityWithEncryptionMetadataTypeName.CalendarItem)

	override suspend fun decryptPatientIdOf(calendarItem: CalendarItem): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(null, calendarItem)

	private suspend fun doDecryptPatientIdOf(groupId: String?, calendarItem: CalendarItem): Set<EntityReferenceInGroup> =
		crypto.entity.owningEntityIdsOf(
			groupId,
			calendarItem,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
			null
		).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: CalendarItem, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(
		entityGroupId: String?,
		entity: CalendarItem,
		delegates: Set<EntityReferenceInGroup>
	) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(entityGroupId, entity, EntityWithEncryptionMetadataTypeName.CalendarItem, delegates)
	}

	override suspend fun decrypt(calendarItems: List<EncryptedCalendarItem>): List<DecryptedCalendarItem> =
		decryptedFlavour.maybeDecrypt(null, calendarItems)

	override suspend fun tryDecrypt(calendarItems: List<EncryptedCalendarItem>): List<CalendarItem> =
		tryAndRecoverFlavour.maybeDecrypt(null, calendarItems)

	override suspend fun encryptOrValidate(calendarItems: List<CalendarItem>): List<EncryptedCalendarItem> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(null, calendarItems)

	override suspend fun matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): List<String> =
		doMatchCalendarItemsBy(null, filter)

	private suspend fun doMatchCalendarItemsBy(groupId: String?, filter: FilterOptions<CalendarItem>): List<String> =
		if (groupId == null) {
			rawApi.matchCalendarItemsBy(
				mapCalendarItemFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchCalendarItemsInGroupBy(
				groupId = groupId,
				filter = mapCalendarItemFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	override suspend fun matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): List<String> =
		doMatchCalendarItemsBySorted(null, filter)

	private suspend fun doMatchCalendarItemsBySorted(
		groupId: String?,
		filter: SortableFilterOptions<CalendarItem>
	): List<String> =
		doMatchCalendarItemsBy(groupId, filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<CalendarItem>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedCalendarItem> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedCalendarItem.serializer(),
			events = events,
			filter = mapCalendarItemFilterOptions(
				filter,
				config,
				null
			),
			qualifiedName = CalendarItem.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(CalendarItemAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal fun initCalendarItemBasicApi(
	rawApi: RawCalendarItemApi,
	config: BasicApiConfiguration
): CalendarItemBasicApi = CalendarItemBasicApiImpl(
	rawApi,
	config,
	AbstractCalendarItemBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class CalendarItemBasicApiImpl(
	private val rawApi: RawCalendarItemApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractCalendarItemBasicFlavouredApi<EncryptedCalendarItem>,
) : CalendarItemBasicApi,
	CalendarItemBasicFlavouredApi<EncryptedCalendarItem> by encryptedFlavour,
	CalendarItemBasicFlavourlessApi by CalendarItemBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: CalendarItemBasicInGroupApi = object : CalendarItemBasicInGroupApi,
		CalendarItemBasicFlavourlessInGroupApi by CalendarItemBasicFlavourlessInGroupApiImpl(rawApi),
		CalendarItemBasicFlavouredInGroupApi<EncryptedCalendarItem> by encryptedFlavour {

		override suspend fun matchCalendarItemsBy(
			groupId: String,
			filter: BaseFilterOptions<CalendarItem>
		): List<String> =
			doMatchCalendarItemsBy(groupId, filter)

		override suspend fun matchCalendarItemsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<CalendarItem>
		): List<String> =
			matchCalendarItemsBy(groupId, filter)

		override suspend fun filterCalendarItemsBy(
			groupId: String,
			filter: BaseFilterOptions<CalendarItem>
		): PaginatedListIterator<GroupScoped<EncryptedCalendarItem>> =
			doFilterCalendarItemsBy(groupId, filter) { GroupScoped(it, groupId) }

		override suspend fun filterCalendarItemsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<CalendarItem>
		): PaginatedListIterator<GroupScoped<EncryptedCalendarItem>> =
			filterCalendarItemsBy(groupId, filter)
	}

	override suspend fun matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): List<String> =
		doMatchCalendarItemsBy(null, filter)

	override suspend fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): List<String> =
		matchCalendarItemsBy(filter)

	override suspend fun filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		doFilterCalendarItemsBy(null, filter) { it }

	override suspend fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): PaginatedListIterator<EncryptedCalendarItem> =
		filterCalendarItemsBy(filter)

	private suspend fun doMatchCalendarItemsBy(groupId: String?, filter: BaseFilterOptions<CalendarItem>): List<String> =
		if (groupId == null) {
			rawApi.matchCalendarItemsBy(
				mapCalendarItemFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchCalendarItemsInGroupBy(
				groupId = groupId,
				filter = mapCalendarItemFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend inline fun <T : Any> doFilterCalendarItemsBy(
		groupId: String?,
		filter: BaseFilterOptions<CalendarItem>,
		crossinline mapEntity: (EncryptedCalendarItem) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			doMatchCalendarItemsBy(groupId, filter),
		) {
			encryptedFlavour.doGetCalendarItems(groupId, it).map { calendarItem -> mapEntity(calendarItem) }
		}

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<CalendarItem>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedCalendarItem> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedCalendarItem.serializer(),
			events = events,
			filter = mapCalendarItemFilterOptions(filter, config, null),
			qualifiedName = CalendarItem.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(CalendarItemAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
