package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.MaintenanceTaskApi
import com.icure.cardinal.sdk.api.MaintenanceTaskBasicApi
import com.icure.cardinal.sdk.api.MaintenanceTaskBasicFlavouredApi
import com.icure.cardinal.sdk.api.MaintenanceTaskBasicFlavourlessApi
import com.icure.cardinal.sdk.api.MaintenanceTaskFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapMaintenanceTaskFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement


@InternalIcureApi
private abstract class AbstractMaintenanceTaskBasicFlavouredApi<E : MaintenanceTask>(
	protected val rawApi: RawMaintenanceTaskApi,
	private val config: BasicApiConfiguration
) : MaintenanceTaskBasicFlavouredApi<E>, FlavouredApi<EncryptedMaintenanceTask, E> {

	override suspend fun createMaintenanceTask(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createMaintenanceTask(
			maintenanceTaskDto = validateAndMaybeEncrypt(null, entity)
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun undeleteMaintenanceTaskById(id: String, rev: String): E =
		rawApi.undeleteMaintenanceTask(maintenanceTaskId = id, rev = rev)
			.successBodyOrThrowRevisionConflict()
			.let { maybeDecrypt(null, it) }

	override suspend fun modifyMaintenanceTask(entity: E): E =
		rawApi.modifyMaintenanceTask(maintenanceTaskDto = validateAndMaybeEncrypt(null, entity))
			.successBodyOrThrowRevisionConflict()
			.let { maybeDecrypt(null, it) }


	override suspend fun getMaintenanceTask(entityId: String): E? =
		rawApi.getMaintenanceTask(maintenanceTaskId = entityId).successBodyOrNull404()?.let {
			maybeDecrypt(null, it)
		}

	override suspend fun getMaintenanceTasks(entityIds: List<String>): List<E> =
		rawApi.getMaintenanceTasks(ids = ListOfIds(entityIds)).successBody().let { maybeDecrypt(it) }
}

@InternalIcureApi
private abstract class AbstractMaintenanceTaskFlavouredApi<E : MaintenanceTask>(
	rawApi: RawMaintenanceTaskApi,
	protected val config: ApiConfiguration
) : AbstractMaintenanceTaskBasicFlavouredApi<E>(rawApi, config), MaintenanceTaskFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		maintenanceTask: E,
		options: MaintenanceTaskShareOptions?,
	): E =
		shareWithMany(maintenanceTask, mapOf(delegateId to (options ?: MaintenanceTaskShareOptions())))

	override suspend fun shareWithMany(maintenanceTask: E, delegates: Map<String, MaintenanceTaskShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			maintenanceTask,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getMaintenanceTask(it) ?: throw NotFoundException("MaintenanceTask $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(request = it).successBody()) }
		).updatedEntityOrThrow()

	override suspend fun filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): PaginatedListIterator<E> =
		filterMaintenanceTasksBy(filter)

	override suspend fun filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchMaintenanceTasksBy(
				filter = mapMaintenanceTaskFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			this::getMaintenanceTasks
		)
}

@InternalIcureApi
private class AbstractMaintenanceTaskBasicFlavourlessApi(val rawApi: RawMaintenanceTaskApi, private val config: BasicApiConfiguration) :
	MaintenanceTaskBasicFlavourlessApi {

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteMaintenanceTaskUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteMaintenanceTask(maintenanceTaskId = entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteMaintenanceTasksUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteMaintenanceTasks(maintenanceTaskIds = ListOfIds(entityIds)).successBody()

	override suspend fun deleteMaintenanceTaskById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteMaintenanceTask(maintenanceTaskId = entityId, rev = rev).successBodyOrThrowRevisionConflict()

	override suspend fun purgeMaintenanceTaskById(id: String, rev: String) {
		rawApi.purgeMaintenanceTask(maintenanceTaskId = id, rev = rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun deleteMaintenanceTasksByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteMaintenanceTasksWithRev(maintenanceTaskIds = ListOfIdsAndRev(entityIds)).successBody()
}

@InternalIcureApi
internal class MaintenanceTaskApiImpl(
	private val rawApi: RawMaintenanceTaskApi,
	private val config: ApiConfiguration
) : MaintenanceTaskApi, MaintenanceTaskFlavouredApi<DecryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskFlavouredApi<DecryptedMaintenanceTask>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedMaintenanceTask>
	): List<EncryptedMaintenanceTask> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			DecryptedMaintenanceTask.serializer(),
			this.config.encryption.maintenanceTask,
		) { Serialization.json.decodeFromJsonElement<EncryptedMaintenanceTask>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMaintenanceTask>
	): List<DecryptedMaintenanceTask> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			EncryptedMaintenanceTask.serializer(),
		) {
			Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(
				config.jsonPatcher.patchMaintenanceTask(
					it
				)
			)
		}
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi, config) {
	override val encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMaintenanceTask>
			): List<EncryptedMaintenanceTask> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.MaintenanceTask,
					EncryptedMaintenanceTask.serializer(),
					config.encryption.maintenanceTask
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMaintenanceTask>
			): List<EncryptedMaintenanceTask> =
				entities
		}

	override val tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask> =
		object : AbstractMaintenanceTaskFlavouredApi<MaintenanceTask>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<MaintenanceTask>
			): List<EncryptedMaintenanceTask> =
				config.crypto.entity.validateOrEncryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.MaintenanceTask,
					EncryptedMaintenanceTask.serializer(),
					DecryptedMaintenanceTask.serializer(),
					config.encryption.maintenanceTask,
					config.entityEncodingJson,
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedMaintenanceTask>
			): List<MaintenanceTask> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.MaintenanceTask,
					EncryptedMaintenanceTask.serializer(),
				) {
					Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(
						config.jsonPatcher.patchMaintenanceTask(
							it
						)
					)
				}
		}

	override suspend fun getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			null,
			maintenanceTask,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			null
		)

	override suspend fun hasWriteAccess(maintenanceTask: MaintenanceTask): Boolean =
		config.crypto.entity.hasWriteAccess(null, maintenanceTask, EntityWithEncryptionMetadataTypeName.MaintenanceTask)

	override suspend fun decryptPatientIdOf(maintenanceTask: MaintenanceTask): Set<String> =
		config.crypto.entity.owningEntityIdsOf(
			null,
			maintenanceTask,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			null
		)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTask, delegates: Set<String>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			null,
			entity,
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			delegates.asLocalDataOwnerReferences()
		)
	}


	override suspend fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTask?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?,
	): DecryptedMaintenanceTask =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
            entityGroupId = null,
            entity = (maintenanceTask ?: DecryptedMaintenanceTask(config.crypto.primitives.strongRandom.randomUUID())).copy(
                created = maintenanceTask?.created ?: currentEpochMs(),
                modified = maintenanceTask?.modified ?: currentEpochMs(),
                responsible = maintenanceTask?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
                author = maintenanceTask?.author ?: user?.id?.takeIf { config.autofillAuthor },
            ),
            entityType = EntityWithEncryptionMetadataTypeName.MaintenanceTask,
            owningEntityDetails = null,
            initializeEncryptionKey = true,
            autoDelegations = (delegates + (user?.autoDelegationsFor(DelegationTag.All)
                ?: emptyMap())).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		).updatedEntity


	override suspend fun decrypt(maintenanceTask: EncryptedMaintenanceTask): DecryptedMaintenanceTask =
		config.crypto.entity.decryptEntities(
			null,
			listOf(maintenanceTask),
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			EncryptedMaintenanceTask.serializer(),
		) {
			Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(
				config.jsonPatcher.patchMaintenanceTask(
					it
				)
			)
		}.single()

	override suspend fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): MaintenanceTask =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(maintenanceTask),
			EntityWithEncryptionMetadataTypeName.MaintenanceTask,
			EncryptedMaintenanceTask.serializer(),
		) {
			Serialization.json.decodeFromJsonElement<DecryptedMaintenanceTask>(
				config.jsonPatcher.patchMaintenanceTask(
					it
				)
			)
		}.single()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<MaintenanceTask>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMaintenanceTask> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = mapMaintenanceTaskFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			),
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MaintenanceTaskAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun matchMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): List<String> =
		matchMaintenanceTasksBy(filter)

	override suspend fun matchMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): List<String> =
		rawApi.matchMaintenanceTasksBy(
			filter = mapMaintenanceTaskFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()
}

@InternalIcureApi
internal class MaintenanceTaskBasicApiImpl(
	private val rawApi: RawMaintenanceTaskApi,
	private val config: BasicApiConfiguration
) : MaintenanceTaskBasicApi, MaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask> by object :
	AbstractMaintenanceTaskBasicFlavouredApi<EncryptedMaintenanceTask>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMaintenanceTask>
	): List<EncryptedMaintenanceTask> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.MaintenanceTask, EncryptedMaintenanceTask.serializer(), config.encryption.maintenanceTask)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedMaintenanceTask>
	): List<EncryptedMaintenanceTask> =
		entities
}, MaintenanceTaskBasicFlavourlessApi by AbstractMaintenanceTaskBasicFlavourlessApi(rawApi, config) {
	override suspend fun filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): PaginatedListIterator<EncryptedMaintenanceTask> =
		filterMaintenanceTasksBy(filter)

	override suspend fun filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): PaginatedListIterator<EncryptedMaintenanceTask> =
		IdsPageIterator(
			matchMaintenanceTasksBy(filter),
			this::getMaintenanceTasks
		)

	override suspend fun matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): List<String> =
		matchMaintenanceTasksBy(filter)

	override suspend fun matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): List<String> =
		rawApi.matchMaintenanceTasksBy(
			filter = mapMaintenanceTaskFilterOptions(
				filter,
				null,
				null
			)
		).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<MaintenanceTask>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedMaintenanceTask> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedMaintenanceTask.serializer(),
			events = events,
			filter = mapMaintenanceTaskFilterOptions(filter, null, null),
			qualifiedName = MaintenanceTask.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(MaintenanceTaskAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
