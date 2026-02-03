package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavouredApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavourlessApi
import com.icure.cardinal.sdk.api.HealthElementBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.HealthElementBasicInGroupApi
import com.icure.cardinal.sdk.api.HealthElementFlavouredApi
import com.icure.cardinal.sdk.api.HealthElementFlavouredInGroupApi
import com.icure.cardinal.sdk.api.HealthElementInGroupApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapHealthElementFilterOptions
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.serialization.HealthElementAbstractFilterSerializer
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
): FlavouredApi<EncryptedHealthElement, EncryptedHealthElement> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedHealthElement.serializer(),
	type = EntityWithEncryptionMetadataTypeName.HealthElement,
	manifest = EntitiesEncryptedFieldsManifests::healthElement
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedHealthElement, DecryptedHealthElement> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedHealthElement.serializer(),
	decryptedSerializer = DecryptedHealthElement.serializer(),
	type = EntityWithEncryptionMetadataTypeName.HealthElement,
	manifest = EntitiesEncryptedFieldsManifests::healthElement,
	patchJson = JsonPatcher::patchHealthElement
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedHealthElement, HealthElement> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedHealthElement.serializer(),
	decryptedSerializer = DecryptedHealthElement.serializer(),
	type = EntityWithEncryptionMetadataTypeName.HealthElement,
	manifest = EntitiesEncryptedFieldsManifests::healthElement,
	patchJson = JsonPatcher::patchHealthElement
)

@OptIn(InternalIcureApi::class)
private suspend fun RawHealthElementApi.doMatchHealthElementsBy(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: FilterOptions<HealthElement>
): List<String> =
	if (groupId == null) {
		matchHealthElementsBy(
			mapHealthElementFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchHealthElementsBy(
			mapHealthElementFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	}.successBody()

@OptIn(InternalIcureApi::class)
private suspend fun RawHealthElementApi.doMatchHealthElementsBySorted(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: SortableFilterOptions<HealthElement>
): List<String> = doMatchHealthElementsBy(config = config, groupId = groupId, filter = filter)

@InternalIcureApi
private open class AbstractHealthElementBasicFlavouredApi<E : HealthElement>(
	protected val rawApi: RawHealthElementApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedHealthElement, E>
) : HealthElementBasicFlavouredApi<E>,
	HealthElementBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedHealthElement, E> by flavour {

	override suspend fun createHealthElement(entity: E): E = doCreateHealthElement(groupId = null, entity = entity)

	override suspend fun createHealthElement(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateHealthElement(groupId = groupId, entity = it)
	}

	private suspend fun doCreateHealthElement(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createHealthElement(encrypted)
		} else {
			rawApi.createHealthElementInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createHealthElements(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateHealthElements(groupId = null, entities = entities)
	}

	override suspend fun createHealthElements(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateHealthElements(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doCreateHealthElements(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { healthElements ->
		val encrypted = validateAndMaybeEncrypt(groupId, healthElements)
		return if (groupId == null) {
			rawApi.createHealthElements(encrypted)
		} else {
			rawApi.createHealthElementsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun undeleteHealthElementById(id: String, rev: String): E = doUndeleteHealthElement(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteHealthElement(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	private suspend fun doUndeleteHealthElement(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteHealthElement(entityId, rev)
		} else {
			rawApi.undeleteHealthElementInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteHealthElements(groupId = null, entityIds = entityIds)

	override suspend fun undeleteHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteHealthElements(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeleteHealthElements(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteHealthElements(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteHealthElementsInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyHealthElement(entity: E): E = doModifyHealthElement(groupId = null, entity = entity)

	override suspend fun modifyHealthElement(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyHealthElement(groupId = groupId, entity = it)
	}

	private suspend fun doModifyHealthElement(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyHealthElement(encrypted)
		} else {
			rawApi.modifyHealthElementInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyHealthElements(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyHealthElements(groupId = null, entities = entities)
	}

	override suspend fun modifyHealthElements(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyHealthElements(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doModifyHealthElements(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { healthElements ->
		val encrypted = validateAndMaybeEncrypt(groupId, healthElements)
		return if (groupId == null) {
			rawApi.modifyHealthElements(encrypted)
		} else {
			rawApi.modifyHealthElementsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getHealthElement(entityId: String): E? = doGetHealthElement(groupId = null, entityId = entityId)

	override suspend fun getHealthElement(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetHealthElement(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetHealthElement(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getHealthElement(entityId)
		} else {
			rawApi.getHealthElementInGroup(groupId = groupId, healthElementId = entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	override suspend fun getHealthElements(entityIds: List<String>): List<E> = doGetHealthElements(groupId = null, entityIds)

	override suspend fun getHealthElements(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetHealthElements(groupId = groupId, entityIds = entityIds)
	}

	suspend fun doGetHealthElements(groupId: String?, entityIds: List<String>) = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getHealthElements(ListOfIds(ids))
		} else {
			rawApi.getHealthElementsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}
}

@InternalIcureApi
private class AbstractHealthElementFlavouredApi<E : HealthElement>(
	rawApi: RawHealthElementApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedHealthElement, E>
) : AbstractHealthElementBasicFlavouredApi<E>(rawApi, config, flavour), HealthElementFlavouredApi<E>, HealthElementFlavouredInGroupApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		healthElement: E,
		options: HealthElementShareOptions?,
	): E =
		shareWithMany(healthElement, mapOf(delegateId to (options ?: HealthElementShareOptions())))

	override suspend fun shareWithMany(healthElement: E, delegates: Map<String, HealthElementShareOptions>): E =
		doShareWithMany(null, healthElement, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		healthElement: GroupScoped<E>,
		options: HealthElementShareOptions?
	): GroupScoped<E> =
		shareWithMany(healthElement, mapOf(delegate to (options ?: HealthElementShareOptions())))

	override suspend fun shareWithMany(
		healthElement: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, HealthElementShareOptions>
	): GroupScoped<E> =
		GroupScoped(
			doShareWithMany(
				healthElement.groupId,
				healthElement.entity,
				delegates
			),
			healthElement.groupId
		)

	private suspend fun doShareWithMany(
		entityGroupId: String?,
		healthElement: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, HealthElementShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			entityGroupId,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			delegates,
			true,
			{ doGetHealthElement(entityGroupId, it) ?: throw NotFoundException("HealthElement $it not found") },
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

	override suspend fun filterHealthElementsBy(filter: FilterOptions<HealthElement>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchHealthElementsBy(config = config, groupId = null, filter = filter),
			this::getHealthElements
		)

	override suspend fun filterHealthElementsBy(groupId: String, filter: FilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchHealthElementsBy(config = config, groupId = groupId, filter = filter)
		) { ids ->
			doGetHealthElements(groupId, ids).map { healthElement ->
				GroupScoped(healthElement, groupId)
			}
		}

	override suspend fun filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): PaginatedListIterator<E> =
		filterHealthElementsBy(filter)

	override suspend fun filterHealthElementsBySorted(groupId: String, filter: SortableFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<E>> =
		filterHealthElementsBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractHealthElementBasicFlavourless(
	protected val rawApi: RawHealthElementApi
) {

	protected suspend fun doDeleteHealthElement(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteHealthElement(entityId, rev)
		} else {
			rawApi.deleteHealthElementInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteHealthElements(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteHealthElementsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteHealthElementsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeHealthElement(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeHealthElement(entityId, rev)
		} else {
			rawApi.purgeHealthElementInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeHealthElements(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeHealthElements(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeHealthElementsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class HealthElementBasicFlavourlessApiImpl(rawApi: RawHealthElementApi) : AbstractHealthElementBasicFlavourless(rawApi), HealthElementBasicFlavourlessApi {

	override suspend fun deleteHealthElementById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteHealthElement(groupId = null, entityId, rev)

	override suspend fun deleteHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteHealthElements(groupId = null, entityIds)

	override suspend fun purgeHealthElementById(id: String, rev: String) {
		doPurgeHealthElement(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeHealthElements(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class HealthElementBasicFlavourlessInGroupApiImpl(rawApi: RawHealthElementApi) : AbstractHealthElementBasicFlavourless(rawApi), HealthElementBasicFlavourlessInGroupApi {
	override suspend fun deleteHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeleteHealthElement(groupId, it.id, it.rev)
		}

	override suspend fun deleteHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteHealthElements(groupId, entities)
		}

	override suspend fun purgeHealthElementById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeHealthElement(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeHealthElementsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeHealthElements(groupId, batch)
		}
}

@InternalIcureApi
internal fun initHealthElementApi(
	rawApi: RawHealthElementApi,
	config: ApiConfiguration
): HealthElementApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractHealthElementFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractHealthElementFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractHealthElementFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return HealthElementApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractHealthElementFlavouredApi<EncryptedHealthElement>,
	private val decryptedFlavour: AbstractHealthElementFlavouredApi<DecryptedHealthElement>,
	private val tryAndRecoverFlavour: AbstractHealthElementFlavouredApi<HealthElement>,
) : HealthElementApi,
	HealthElementFlavouredApi<DecryptedHealthElement> by decryptedFlavour,
	HealthElementBasicFlavourlessApi by HealthElementBasicFlavourlessApiImpl(rawApi) {

	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> = encryptedFlavour
	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> = tryAndRecoverFlavour

	override val inGroup: HealthElementInGroupApi = object : HealthElementInGroupApi,
		HealthElementFlavouredInGroupApi<DecryptedHealthElement> by decryptedFlavour,
		HealthElementBasicFlavourlessInGroupApi by HealthElementBasicFlavourlessInGroupApiImpl(rawApi) {
		override val encrypted: HealthElementFlavouredInGroupApi<EncryptedHealthElement> = encryptedFlavour
		override val tryAndRecover: HealthElementFlavouredInGroupApi<HealthElement> = tryAndRecoverFlavour

		override suspend fun matchHealthElementsBy(groupId: String, filter: FilterOptions<HealthElement>): List<String> =
			rawApi.doMatchHealthElementsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchHealthElementsBySorted(groupId: String, filter: SortableFilterOptions<HealthElement>): List<String> =
			rawApi.doMatchHealthElementsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun decrypt(healthElements: List<GroupScoped<EncryptedHealthElement>>): List<GroupScoped<DecryptedHealthElement>> =
			healthElements.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(healthElements: List<GroupScoped<EncryptedHealthElement>>): List<GroupScoped<HealthElement>> =
			healthElements.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun encryptOrValidate(healthElements: List<GroupScoped<HealthElement>>): List<GroupScoped<EncryptedHealthElement>> =
			healthElements.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedHealthElement?,
			patient: GroupScoped<Patient>,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedHealthElement> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					patient.entity to patient.groupId,
					user,
					delegates,
					secretId,
					alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun getEncryptionKeysOf(healthElement: GroupScoped<HealthElement>): Set<HexString> =
			doGetEncryptionKeysOf(healthElement.groupId, healthElement.entity)

		override suspend fun hasWriteAccess(healthElement: GroupScoped<HealthElement>): Boolean =
			doHasWriteAccess(healthElement.groupId, healthElement.entity)

		override suspend fun decryptPatientIdOf(healthElement: GroupScoped<HealthElement>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(healthElement.groupId, healthElement.entity).mapNullGroupTo(healthElement.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<HealthElement>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedHealthElement?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?
	): DecryptedHealthElement =
		doWithEncryptionMetadata(
			null,
			base,
			patient to null,
			user,
			delegates.keyAsLocalDataOwnerReferences(),
			secretId,
			alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedHealthElement?,
		patient: Pair<Patient, String?>,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedHealthElement =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedHealthElement(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.HealthElement,
			owningEntityDetails = patient.let { (patient, patientGroup) ->
				OwningEntityDetails(
					patientGroup,
					patient.id,
					config.crypto.entity.resolveSecretIdOption(
						entityGroupId,
						patient,
						EntityWithEncryptionMetadataTypeName.Patient,
						secretId
					)
				)
			},
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity

	override suspend fun getEncryptionKeysOf(healthElement: HealthElement): Set<HexString> =
		doGetEncryptionKeysOf(null, healthElement)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, healthElement: HealthElement): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			groupId,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			null
		)

	override suspend fun hasWriteAccess(healthElement: HealthElement): Boolean =
		doHasWriteAccess(null, healthElement)

	private suspend fun doHasWriteAccess(groupId: String?, healthElement: HealthElement): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, healthElement, EntityWithEncryptionMetadataTypeName.HealthElement)

	override suspend fun decryptPatientIdOf(healthElement: HealthElement): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(null, healthElement)

	private suspend fun doDecryptPatientIdOf(groupId: String?, healthElement: HealthElement): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			groupId,
			healthElement,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			null
		).mapTo(mutableSetOf()) { config.crypto.entity.parseReference(groupId, it) }

	override suspend fun createDelegationDeAnonymizationMetadata(entity: HealthElement, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: HealthElement, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			delegates
		)
	}

	override suspend fun matchHealthElementsBy(filter: FilterOptions<HealthElement>) =
		rawApi.doMatchHealthElementsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): List<String> =
		rawApi.doMatchHealthElementsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<HealthElement>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = mapHealthElementFilterOptions(
				filter,
				config,
				requestGroup = null
			),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun decrypt(healthElements: List<EncryptedHealthElement>): List<DecryptedHealthElement> =
		decryptedFlavour.maybeDecrypt(null, healthElements)

	override suspend fun tryDecrypt(healthElements: List<EncryptedHealthElement>): List<HealthElement> =
		tryAndRecoverFlavour.maybeDecrypt(null, healthElements)

	override suspend fun encryptOrValidate(healthElements: List<HealthElement>): List<EncryptedHealthElement> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(null, healthElements)
}


@InternalIcureApi
internal fun initHealthElementBasicApi(
	rawApi: RawHealthElementApi,
	config: BasicApiConfiguration
): HealthElementBasicApi = HealthElementBasicApiImpl(
	rawApi,
	config,
	AbstractHealthElementBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class HealthElementBasicApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>,
) : HealthElementBasicApi,
	HealthElementBasicFlavouredApi<EncryptedHealthElement> by encryptedFlavour,
	HealthElementBasicFlavourlessApi by HealthElementBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: HealthElementBasicInGroupApi = object : HealthElementBasicInGroupApi,
		HealthElementBasicFlavouredInGroupApi<EncryptedHealthElement> by encryptedFlavour,
		HealthElementBasicFlavourlessInGroupApi by HealthElementBasicFlavourlessInGroupApiImpl(rawApi) {

		override suspend fun matchHealthElementsBy(groupId: String, filter: BaseFilterOptions<HealthElement>): List<String> =
			rawApi.doMatchHealthElementsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchHealthElementsBySorted(groupId: String, filter: BaseSortableFilterOptions<HealthElement>): List<String> =
			rawApi.doMatchHealthElementsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun filterHealthElementsBy(groupId: String, filter: BaseFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<EncryptedHealthElement>> =
			IdsPageIterator(matchHealthElementsBy(groupId, filter)) { ids ->
				encryptedFlavour.doGetHealthElements(groupId, ids).map { GroupScoped(it, groupId) }
			}

		override suspend fun filterHealthElementsBySorted(groupId: String, filter: BaseSortableFilterOptions<HealthElement>): PaginatedListIterator<GroupScoped<EncryptedHealthElement>> =
			filterHealthElementsBy(groupId, filter)
	}

	override suspend fun matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): List<String> =
		rawApi.doMatchHealthElementsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): List<String> =
		rawApi.doMatchHealthElementsBy(config = config, groupId = null, filter = filter)

	override suspend fun filterHealthElementsBy(filter: BaseFilterOptions<HealthElement>): PaginatedListIterator<EncryptedHealthElement> =
		IdsPageIterator(matchHealthElementsBy(filter), this::getHealthElements)

	override suspend fun filterHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): PaginatedListIterator<EncryptedHealthElement> =
		filterHealthElementsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<HealthElement>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedHealthElement> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedHealthElement.serializer(),
			events = events,
			filter = mapHealthElementFilterOptions(filter, config, null),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
