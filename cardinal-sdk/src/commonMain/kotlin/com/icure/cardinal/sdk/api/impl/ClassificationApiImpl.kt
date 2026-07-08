package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ClassificationApi
import com.icure.cardinal.sdk.api.ClassificationBasicApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavouredApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ClassificationFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapClassificationFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private abstract class AbstractClassificationBasicFlavouredApi<E : Classification>(protected val rawApi: RawClassificationApi) :
	ClassificationBasicFlavouredApi<E>, FlavouredApi<EncryptedClassification, E> {

	override suspend fun createClassification(entity: E): E {
		require(entity.securityMetadata != null) { "Entity must have security metadata initialized. Make sure to use the `withEncryptionMetadata` method." }
		return rawApi.createClassification(
			c = validateAndMaybeEncrypt(null, entity),
		).successBody().let {
			maybeDecrypt(null, it)
		}
	}

	override suspend fun modifyClassification(entity: E): E =
		rawApi.modifyClassification(classificationDto = validateAndMaybeEncrypt(null, entity))
			.successBodyOrThrowRevisionConflict()
			.let { maybeDecrypt(null, it) }

	override suspend fun getClassification(entityId: String): E? =
		rawApi.getClassification(classificationId = entityId).successBodyOrNull404()
			?.let { maybeDecrypt(null, it) }

	override suspend fun getClassifications(entityIds: List<String>): List<E> =
		maybeDecrypt(rawApi.getClassifications(ListOfIds(entityIds)).successBody())
}

@InternalIcureApi
private abstract class AbstractClassificationFlavouredApi<E : Classification>(
	rawApi: RawClassificationApi,
	protected val config: ApiConfiguration,
) : AbstractClassificationBasicFlavouredApi<E>(rawApi), ClassificationFlavouredApi<E> {
	override suspend fun shareWith(
		delegateId: String,
		classification: E,
		options: ClassificationShareOptions?,
	): E =
		shareWithMany(classification, mapOf(delegateId to (options ?: ClassificationShareOptions())))

	override suspend fun shareWithMany(classification: E, delegates: Map<String, ClassificationShareOptions>): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			null,
			classification,
			EntityWithEncryptionMetadataTypeName.Classification,
			delegates.keyAsLocalDataOwnerReferences(),
			true,
			{ getClassification(it) ?: throw NotFoundException("Classification $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(request = it).successBody()) }
		).updatedEntityOrThrow()

	@Deprecated("Use filter instead")
	override suspend fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
	): PaginatedListIterator<E> = IdsPageIterator(
		rawApi.listClassificationIdsByDataOwnerPatientCreated(
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
		maybeDecrypt(rawApi.getClassifications(classificationIds = ListOfIds(ids)).successBody())
	}

	override suspend fun filterClassificationsBySorted(filter: SortableFilterOptions<Classification>): PaginatedListIterator<E> =
		filterClassificationsBy(filter)

	override suspend fun filterClassificationsBy(filter: FilterOptions<Classification>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.matchClassificationBy(
				filter = mapClassificationFilterOptions(
					filter,
					config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
					config.crypto.entity
				)
			).successBody(),
			::getClassifications
		)
}

@InternalIcureApi
private class AbstractClassificationBasicFlavourlessApi(val rawApi: RawClassificationApi) :
	ClassificationBasicFlavourlessApi {
	override suspend fun deleteClassification(entityId: String) =
		rawApi.deleteClassification(classificationId = entityId).successBody()
	override suspend fun deleteClassifications(entityIds: List<String>) = rawApi.deleteClassifications(
		classificationIds = ListOfIds(
			entityIds
		)
	).successBody()
}

@InternalIcureApi
internal class ClassificationApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: ApiConfiguration,
) : ClassificationApi, ClassificationFlavouredApi<DecryptedClassification> by object :
	AbstractClassificationFlavouredApi<DecryptedClassification>(rawApi, config) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedClassification>
	): List<EncryptedClassification> =
		this.config.crypto.entity.encryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Classification,
			DecryptedClassification.serializer(),
			this.config.encryption.classification,
		) { Serialization.json.decodeFromJsonElement<EncryptedClassification>(it) }

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedClassification>
	): List<DecryptedClassification> =
		this.config.crypto.entity.decryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Classification,
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override val encrypted: ClassificationFlavouredApi<EncryptedClassification> =
		object : AbstractClassificationFlavouredApi<EncryptedClassification>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedClassification>
			): List<EncryptedClassification> =
				config.crypto.entity.validateEncryptedEntities(
					entities,
					EntityWithEncryptionMetadataTypeName.Classification,
					EncryptedClassification.serializer(),
					config.encryption.classification
				)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedClassification>
			): List<EncryptedClassification> = entities
		}

	override val tryAndRecover: ClassificationFlavouredApi<Classification> =
		object : AbstractClassificationFlavouredApi<Classification>(rawApi, config) {
			override suspend fun validateAndMaybeEncrypt(
				entitiesGroupId: String?,
				entities: List<Classification>
			): List<EncryptedClassification> = config.crypto.entity.validateOrEncryptEntities(
				entitiesGroupId,
				entities,
				EntityWithEncryptionMetadataTypeName.Classification,
				EncryptedClassification.serializer(),
				DecryptedClassification.serializer(),
				config.encryption.classification,
				config.entityEncodingJson,
			)

			override suspend fun maybeDecrypt(
				entitiesGroupId: String?,
				entities: List<EncryptedClassification>
			): List<Classification> =
				config.crypto.entity.tryDecryptEntities(
					entitiesGroupId,
					entities,
					EntityWithEncryptionMetadataTypeName.Classification,
					EncryptedClassification.serializer(),
				) {
					Serialization.json.decodeFromJsonElement<DecryptedClassification>(
						config.jsonPatcher.patchClassification(
							it
						)
					)
				}
		}

	private val crypto get() = config.crypto

	override suspend fun withEncryptionMetadata(
		base: DecryptedClassification?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	): DecryptedClassification =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			null,
			(base ?: DecryptedClassification(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Classification,
			OwningEntityDetails(
				null,
				patient.id,
				crypto.entity.resolveSecretIdOption(null, patient, EntityWithEncryptionMetadataTypeName.Patient, secretId),
			),
			initializeEncryptionKey = true,
			autoDelegations = (delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty()).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		).updatedEntity

	override suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString> = crypto.entity.encryptionKeysOf(null, classification, EntityWithEncryptionMetadataTypeName.Classification, null)

	override suspend fun hasWriteAccess(classification: Classification): Boolean = crypto.entity.hasWriteAccess(null, classification, EntityWithEncryptionMetadataTypeName.Classification)

	override suspend fun decryptPatientIdOf(classification: Classification): Set<String> = crypto.entity.owningEntityIdsOf(null, classification, EntityWithEncryptionMetadataTypeName.Classification, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(null, entity, EntityWithEncryptionMetadataTypeName.Classification, delegates.asLocalDataOwnerReferences())
	}

	override suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification =
		crypto.entity.decryptEntities(
			null,
			listOf(classification),
			EntityWithEncryptionMetadataTypeName.Classification,
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }.single()

	override suspend fun tryDecrypt(classification: EncryptedClassification): Classification =
		crypto.entity.tryDecryptEntities(
			null,
			listOf(classification),
			EntityWithEncryptionMetadataTypeName.Classification,
			EncryptedClassification.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedClassification>(config.jsonPatcher.patchClassification(it)) }.single()

	override suspend fun matchClassificationsBy(filter: FilterOptions<Classification>): List<String> =
		rawApi.matchClassificationBy(
			filter = mapClassificationFilterOptions(
				filter,
				config.crypto.dataOwnerApi.getCurrentDataOwnerId(),
				config.crypto.entity
			)
		).successBody()

	override suspend fun matchClassificationsBySorted(filter: SortableFilterOptions<Classification>): List<String> =
		matchClassificationsBy(filter)
}

@InternalIcureApi
internal class ClassificationBasicApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: BasicApiConfiguration,
) : ClassificationBasicApi, ClassificationBasicFlavouredApi<EncryptedClassification> by object :
	AbstractClassificationBasicFlavouredApi<EncryptedClassification>(rawApi) {
	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedClassification>
	): List<EncryptedClassification> =
		config.crypto.validationService.validateEncryptedEntities(entities, EntityWithEncryptionMetadataTypeName.Classification, EncryptedClassification.serializer(), config.encryption.classification)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedClassification>
	): List<EncryptedClassification> = entities
}, ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override suspend fun matchClassificationsBy(filter: BaseFilterOptions<Classification>): List<String> =
		rawApi.matchClassificationBy(
			filter = mapClassificationFilterOptions(
				filter,
				null,
				null
			)
		).successBody()

	override suspend fun matchClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): List<String> =
		matchClassificationsBy(filter)

	override suspend fun filterClassificationsBy(filter: BaseFilterOptions<Classification>): PaginatedListIterator<EncryptedClassification> =
		IdsPageIterator(matchClassificationsBy(filter), ::getClassifications)

	override suspend fun filterClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): PaginatedListIterator<EncryptedClassification> =
		filterClassificationsBy(filter)
}
