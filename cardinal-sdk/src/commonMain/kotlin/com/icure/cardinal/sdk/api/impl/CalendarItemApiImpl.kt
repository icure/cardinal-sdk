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
import com.icure.cardinal.sdk.model.PaginatedList
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
		doCreateCalendarItem(null, entity)

	override suspend fun createCalendarItem(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreateCalendarItem(entity.groupId, entity.entity), entity.groupId)

	private suspend fun doCreateCalendarItem(groupId: String?, entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return (
			if (groupId == null) {
				rawApi.createCalendarItem(encrypted)
			} else {
				rawApi.createCalendarItemInGroup(groupId, encrypted)
			}
			).successBody().let {
				maybeDecrypt(groupId, it)
			}
	}

	override suspend fun bookCalendarItemCheckingAvailability(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		val encrypted = validateAndMaybeEncrypt(null, entity)
		return maybeDecrypt(
			null,
			rawApi.safeBook(encrypted).successBody(MissingAvailabilityException)
		)
	}

	override suspend fun undeleteCalendarItemById(id: String, rev: String): E =
		rawApi.undeleteCalendarItem(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }

	override suspend fun modifyCalendarItem(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(
			doModifyCalendarItem(entity.groupId, entity.entity),
			entity.groupId
		)

	override suspend fun modifyCalendarItem(entity: E): E =
		doModifyCalendarItem(null, entity)

	private suspend fun doModifyCalendarItem(groupId: String?, entity: E): E =
		validateAndMaybeEncrypt(groupId, entity).let {
			if (groupId == null)
				rawApi.modifyCalendarItem(it)
			else
				rawApi.modifyCalendarItemInGroup(groupId, it)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getCalendarItem(groupId: String, entityId: String): GroupScoped<E>? =
		doGetCalendarItem(groupId, entityId)?.let { GroupScoped(it, groupId) }

	override suspend fun getCalendarItem(entityId: String): E? =
		doGetCalendarItem(null, entityId)

	protected suspend fun doGetCalendarItem(groupId: String?, entityId: String): E? =
		(
			if (groupId == null)
				rawApi.getCalendarItem(entityId)
			else
				rawApi.getCalendarItemInGroup(groupId = groupId, calendarItemId = entityId)
		).successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}

	override suspend fun getCalendarItems(groupId: String, entityIds: List<String>): List<GroupScoped<E>> =
		doGetCalendarItems(groupId, entityIds).map { GroupScoped(it, groupId) }

	override suspend fun getCalendarItems(entityIds: List<String>): List<E> =
		doGetCalendarItems(null, entityIds)

	suspend fun doGetCalendarItems(groupId: String?, entityIds: List<String>): List<E> =
		maybeDecrypt(
			groupId,
			if (groupId == null)
				rawApi.getCalendarItemsWithIds(ListOfIds(entityIds)).successBody()
			else
				rawApi.getCalendarItemsInGroup(groupId, ListOfIds(entityIds)).successBody()
		)

	@Deprecated("Use filter instead")
	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): List<E> = maybeDecrypt(rawApi.getCalendarItemsByPeriodAndHcPartyId(startDate, endDate, hcPartyId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): List<E> = maybeDecrypt(rawApi.getCalendarsByPeriodAndAgendaId(startDate, endDate, agendaId).successBody())

	@Deprecated("Use filter instead")
	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): PaginatedList<E> =
		maybeDecrypt(rawApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId, limit).successBody())
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
		doShareWithMany(null, calendarItem, delegates.keyAsLocalDataOwnerReferences())

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

	@Deprecated("Use filter instead")
	override suspend fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.findCalendarItemIdsByDataOwnerPatientStartTime(
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
		maybeDecrypt(rawApi.getCalendarItemsWithIds(ListOfIds(ids)).successBody())
	}

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
		(
			if (groupId == null)
				rawApi.deleteCalendarItem(entityId, rev)
			else
				rawApi.deleteCalendarItemInGroup(groupId, entityId, rev)
		).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteCalendarItemsByIds(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		(
			if (groupId == null)
				rawApi.deleteCalendarItemsWithRev(ListOfIdsAndRev(entityIds))
			else
				rawApi.deleteCalendarItemsInGroup(groupId, ListOfIdsAndRev(entityIds))
		).successBody().toStoredDocumentIdentifier()
}

@InternalIcureApi
private class CalendarItemBasicFlavourlessApiImpl(rawApi: RawCalendarItemApi) : AbstractCalendarItemBasicFlavourless(rawApi), CalendarItemBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteCalendarItemUnsafe(entityId: String): StoredDocumentIdentifier =
		rawApi.deleteCalendarItem(entityId).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteCalendarItemsUnsafe(entityIds: List<String>): List<StoredDocumentIdentifier> =
		rawApi.deleteCalendarItems(ListOfIds(entityIds)).successBody().toStoredDocumentIdentifier()

	override suspend fun deleteCalendarItemById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteCalendarItemById(null, entityId, rev)

	override suspend fun deleteCalendarItemsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteCalendarItemsByIds(null, entityIds)

	override suspend fun purgeCalendarItemById(id: String, rev: String) {
		rawApi.purgeCalendarItem(id, rev).successBodyOrThrowRevisionConflict()
	}
}

@InternalIcureApi
private class CalendarItemBasicFlavourlessInGroupApiImpl(rawApi: RawCalendarItemApi) : AbstractCalendarItemBasicFlavourless(rawApi), CalendarItemBasicFlavourlessInGroupApi {
	override suspend fun deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(doDeleteCalendarItemById(entityId.groupId, entityId.entity.id, entityId.entity.rev), entityId.groupId)

	override suspend fun deleteCalendarItemsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteCalendarItemsByIds(groupId, entities)
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
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedCalendarItem> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient?.let { Pair(it.entity, it.groupId) },
					user,
					delegates,
					secretId,
					alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun decryptPatientIdOf(calendarItem: GroupScoped<CalendarItem>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(calendarItem.groupId, calendarItem.entity).mapNullGroupTo(calendarItem.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<CalendarItem>,
			delegates: Set<EntityReferenceInGroup>
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
			filter: SortableFilterOptions<CalendarItem>
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
