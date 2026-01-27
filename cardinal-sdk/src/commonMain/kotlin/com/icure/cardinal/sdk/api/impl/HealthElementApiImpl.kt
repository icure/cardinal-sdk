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

@InternalIcureApi
private open class AbstractHealthElementBasicFlavouredApi<E : HealthElement>(
	protected val rawApi: RawHealthElementApi,
	protected open val config: BasicApiConfiguration,
	private val flavour: FlavouredApi<EncryptedHealthElement, E>
) : HealthElementBasicFlavouredApi<E>, HealthElementBasicFlavouredInGroupApi<E>, FlavouredApi<EncryptedHealthElement, E> by flavour {
	override suspend fun createHealthElement(entity: E): E =
		doCreateHealthElement(null, entity)

	override suspend fun createHealthElement(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doCreateHealthElement(entity.groupId, entity.entity), entity.groupId)

	private suspend fun doCreateHealthElement(
		groupId: String?,
		entity: E
	): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return (
			if (groupId == null)
				rawApi.createHealthElement(encrypted)
			else
				rawApi.createHealthElementInGroup(groupId, encrypted)
			).successBody().let {
				maybeDecrypt(groupId, it)
			}
	}

	override suspend fun createHealthElements(entities: List<E>): List<E> {
		require(entities.all { it.securityMetadata != null }) { "All entities must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createHealthElements(
			validateAndMaybeEncrypt(null, entities),
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun modifyHealthElement(entity: E): E =
		doModifyHealthElement(null, entity)

	override suspend fun modifyHealthElement(entity: GroupScoped<E>): GroupScoped<E> =
		GroupScoped(doModifyHealthElement(entity.groupId, entity.entity), entity.groupId)

	private suspend fun doModifyHealthElement(groupId: String?, entity: E): E =
		validateAndMaybeEncrypt(groupId, entity).let {
			if (groupId == null)
				rawApi.modifyHealthElement(it)
			else
				rawApi.modifyHealthElementInGroup(groupId, it)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun modifyHealthElements(entities: List<E>): List<E> =
		rawApi.modifyHealthElements(validateAndMaybeEncrypt(entities)).successBody().let { maybeDecrypt(it) }

	override suspend fun getHealthElement(groupId: String, entityId: String): GroupScoped<E>? = doGetHealthElement(groupId, entityId)?.let {
		GroupScoped(it, groupId)
	}

	override suspend fun getHealthElement(entityId: String): E? =
		doGetHealthElement(null, entityId)

	protected suspend fun doGetHealthElement(groupId: String?, entityId: String): E? =
		(
			if (groupId == null)
				rawApi.getHealthElement(entityId)
			else
				rawApi.getHealthElementInGroup(groupId = groupId, healthElementId = entityId)
		).successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	override suspend fun getHealthElements(entityIds: List<String>): List<E> =
		rawApi.getHealthElements(ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }

	override suspend fun undeleteHealthElementById(id: String, rev: String): E =
		rawApi.undeleteHealthElement(id, rev).successBodyOrThrowRevisionConflict().let { maybeDecrypt(null, it) }
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

	@Deprecated("Use filter instead")
	override suspend fun findHealthElementsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listHealthElementIdsByDataOwnerPatientOpeningDate(
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
		rawApi.getHealthElements(ListOfIds(ids)).successBody().let { maybeDecrypt(it) }
	}

	override suspend fun filterHealthElementsBy(filter: FilterOptions<HealthElement>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)).successBody(),
			this::getHealthElements
		)

	override suspend fun filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): PaginatedListIterator<E> =
		filterHealthElementsBy(filter)
}

@InternalIcureApi
private class AbstractHealthElementBasicFlavourlessApi(
	val rawApi: RawHealthElementApi
) : HealthElementBasicFlavourlessApi, HealthElementBasicFlavourlessInGroupApi {

	override suspend fun deleteHealthElementById(entityId: String, rev: String): StoredDocumentIdentifier =
		rawApi.deleteHealthElement(entityId, rev).successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	override suspend fun deleteHealthElementsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		rawApi.deleteHealthElementsWithRev(ListOfIdsAndRev(entityIds)).successBody().toStoredDocumentIdentifier()

	override suspend fun purgeHealthElementById(id: String, rev: String) {
		rawApi.purgeHealthElement(id, rev).successBodyOrThrowRevisionConflict()
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
	val basicFlavourless = AbstractHealthElementBasicFlavourlessApi(rawApi)
	return HealthElementApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi,
		basicFlavourless
	)
}

@InternalIcureApi
private class HealthElementApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractHealthElementFlavouredApi<EncryptedHealthElement>,
	private val decryptedFlavour: AbstractHealthElementFlavouredApi<DecryptedHealthElement>,
	private val tryAndRecoverFlavour: AbstractHealthElementFlavouredApi<HealthElement>,
	private val base: AbstractHealthElementBasicFlavourlessApi
) : HealthElementApi,
	HealthElementFlavouredApi<DecryptedHealthElement> by decryptedFlavour,
	HealthElementBasicFlavourlessApi by base {
	override val encrypted: HealthElementFlavouredApi<EncryptedHealthElement> = encryptedFlavour
	override val tryAndRecover: HealthElementFlavouredApi<HealthElement> = tryAndRecoverFlavour
	override val inGroup: HealthElementInGroupApi = object : HealthElementInGroupApi,
		HealthElementFlavouredInGroupApi<DecryptedHealthElement> by decryptedFlavour,
		HealthElementBasicFlavourlessInGroupApi by base {
		override val encrypted: HealthElementFlavouredInGroupApi<EncryptedHealthElement> = encryptedFlavour
		override val tryAndRecover: HealthElementFlavouredInGroupApi<HealthElement> = tryAndRecoverFlavour

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
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: HealthElement, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.HealthElement,
			delegates
		)
	}

	override suspend fun matchHealthElementsBy(filter: FilterOptions<HealthElement>): List<String> =
		rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(
			filter,
			config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
			config.crypto.entity
		)).successBody()

	override suspend fun matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): List<String> =
		matchHealthElementsBy(filter)

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
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
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
	AbstractHealthElementBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config)),
	AbstractHealthElementBasicFlavourlessApi(rawApi)
)

@InternalIcureApi
private class HealthElementBasicApiImpl(
	private val rawApi: RawHealthElementApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>,
	private val base: AbstractHealthElementBasicFlavourlessApi
) : HealthElementBasicApi,
	HealthElementBasicFlavouredApi<EncryptedHealthElement> by encryptedFlavour,
	HealthElementBasicFlavourlessApi by base {
	override val inGroup: HealthElementBasicInGroupApi = object : HealthElementBasicInGroupApi,
		HealthElementBasicFlavouredInGroupApi<EncryptedHealthElement> by encryptedFlavour,
		HealthElementBasicFlavourlessInGroupApi by base {}

	override suspend fun matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): List<String> =
		rawApi.matchHealthElementsBy(mapHealthElementFilterOptions(filter, null, null)).successBody()

	override suspend fun matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): List<String> =
		matchHealthElementsBy(filter)

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
			filter = mapHealthElementFilterOptions(filter, null, null),
			qualifiedName = HealthElement.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(HealthElementAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
