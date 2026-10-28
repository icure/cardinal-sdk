package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ClassificationApi
import com.icure.cardinal.sdk.api.ClassificationBasicApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavouredApi
import com.icure.cardinal.sdk.api.ClassificationBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ClassificationFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.encryptor.BuiltinRootEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.DecryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.SharedEncryptorsOptions
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.GeneratedEntitiesEncryptorInitializer
import com.icure.cardinal.sdk.crypto.encryptor.initializeSingleEntityEncryptors
import com.icure.cardinal.sdk.crypto.entities.BulkShareByIdsResult
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.asIcureStub
import com.icure.cardinal.sdk.crypto.entities.toBulkShareByIdsResult
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
import com.icure.cardinal.sdk.model.extensions.toDefaultDelegateOptions
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedClassification, EncryptedClassification> = FlavouredApi.encrypted(
	config = config,
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration,
	classificationEncryptors: EntityEncryptors<EncryptedClassification, DecryptedClassification>,
): FlavouredApi<EncryptedClassification, DecryptedClassification> = FlavouredApi.decrypted(
	config = config,
	type = EntityWithEncryptionMetadataTypeName.Builtin.Classification,
	encryptors = classificationEncryptors,
	getRootModelVersion = { null },
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration,
	classificationEncryptors: EntityEncryptors<EncryptedClassification, DecryptedClassification>,
): FlavouredApi<EncryptedClassification, Classification> = FlavouredApi.tryAndRecover(
	config = config,
	type = EntityWithEncryptionMetadataTypeName.Builtin.Classification,
	encryptors = classificationEncryptors,
	getRootModelVersion = { null },
)

@InternalIcureApi
private open class ClassificationBasicFlavouredApiImpl<E : Classification>(
	protected val rawApi: RawClassificationApi,
	private val config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedClassification, E>,
) : ClassificationBasicFlavouredApi<E>, FlavouredApi<EncryptedClassification, E> by flavour {

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
private class ClassificationFlavouredApiImpl<E : Classification>(
	rawApi: RawClassificationApi,
	private val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedClassification, E>,
) : ClassificationBasicFlavouredApiImpl<E>(rawApi, config, flavour), ClassificationFlavouredApi<E> {

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
			EntityWithEncryptionMetadataTypeName.Builtin.Classification,
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
					EntityWithEncryptionMetadataTypeName.Builtin.Patient,
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
private fun fixedClassificationEncryptors(
	config: ApiConfiguration,
): EntityEncryptors<EncryptedClassification, DecryptedClassification> =
	// Classification is a legacy entity type: its encryption is not configurable, and like for maintenance tasks we always use
	// the same fixed configuration.
	GeneratedEntitiesEncryptorInitializer.initializeSingleEntityEncryptors<EncryptedClassification, DecryptedClassification>(
		BuiltinRootEntityEncryptionManifest(
			fieldsToEncrypt = setOf("label"),
			recursiveEncryption = emptyMap(),
		),
		emptyMap(),
		// The classification encryptor does not depend on these options (no legacy content or renamed fields)
		EncryptorOptions(
			useLegacyServiceContentEncryption = false,
			serializeEncryptedSelfUsingLegacyNames = false
		),
		DecryptorOptions(
			unversionedEntitiesDecryptedJsonStrictness = DecryptedJsonStrictness.IgnoreBadValues
		),
		SharedEncryptorsOptions(
			json = Serialization.lenientJson,
			cryptoService = config.crypto.primitives,
		)
	)

@InternalIcureApi
internal fun initClassificationApi(
	rawApi: RawClassificationApi,
	config: ApiConfiguration,
): ClassificationApi {
	val classificationEncryptors = fixedClassificationEncryptors(config)
	val decryptedFlavour = decryptedApiFlavour(config, classificationEncryptors)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config, classificationEncryptors)
	return ClassificationApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class ClassificationApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: ApiConfiguration,
	encryptedFlavour: FlavouredApi<EncryptedClassification, EncryptedClassification>,
	private val decryptedFlavour: FlavouredApi<EncryptedClassification, DecryptedClassification>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedClassification, Classification>,
) : ClassificationApi,
	ClassificationFlavouredApi<DecryptedClassification> by ClassificationFlavouredApiImpl(rawApi, config, decryptedFlavour),
	ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
	override val encrypted: ClassificationFlavouredApi<EncryptedClassification> =
		ClassificationFlavouredApiImpl(rawApi, config, encryptedFlavour)

	override val tryAndRecover: ClassificationFlavouredApi<Classification> =
		ClassificationFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)

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
			EntityWithEncryptionMetadataTypeName.Builtin.Classification,
			OwningEntityDetails(
				null,
				patient.id,
				crypto.entity.resolveSecretIdOption(null, patient, EntityWithEncryptionMetadataTypeName.Builtin.Patient, secretId),
			),
			initializeEncryptionKey = true,
			autoDelegations = (delegates.mapValues { it.value.toDefaultDelegateOptions() } + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty()).keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
		).updatedEntity

	override suspend fun getEncryptionKeysOf(classification: Classification): Set<HexString> = crypto.entity.encryptionKeysOf(null, classification, EntityWithEncryptionMetadataTypeName.Builtin.Classification, null)

	override suspend fun getSecretIdsOf(classification: Classification): Map<String, Set<EntityReferenceInGroup>> =
		ensureNonNull(
			crypto.entity.secretIdsWithDataOwnersInfo(null, listOf(classification), EntityWithEncryptionMetadataTypeName.Builtin.Classification).values.singleOrNull()
		) {
			"Method secretIdsWithDataOwnersInfo should have returned single item for single classification"
		}

	override suspend fun hasWriteAccess(classification: Classification): Boolean = crypto.entity.hasWriteAccess(null, classification, EntityWithEncryptionMetadataTypeName.Builtin.Classification)

	override suspend fun decryptPatientIdOf(classification: Classification): Set<String> = crypto.entity.owningEntityIdsOf(null, classification, EntityWithEncryptionMetadataTypeName.Builtin.Classification, null)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Classification, delegates: Set<String>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(null, entity, EntityWithEncryptionMetadataTypeName.Builtin.Classification, delegates.asLocalDataOwnerReferences())
	}

	override suspend fun decrypt(classification: EncryptedClassification): DecryptedClassification =
		decryptedFlavour.maybeDecrypt(null, classification)

	override suspend fun tryDecrypt(classification: EncryptedClassification): Classification =
		tryAndRecoverFlavour.maybeDecrypt(null, classification)

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

	override suspend fun shareClassificationsByIds(
		classificationIds: List<String>,
		delegates: Map<String, ClassificationShareOptions>
	): BulkShareByIdsResult {
		val distinctIds = classificationIds.toSet()
		if (distinctIds.isEmpty() || delegates.isEmpty()) {
			return BulkShareByIdsResult(emptySet(), emptyMap(), emptyMap(), emptyList())
		}
		val normalizedDelegates = delegates.mapKeys { EntityReferenceInGroup(it.key) }
		val stubs = rawApi.findClassificationsDelegationsStubsByIds(classificationIds = ListOfIds(distinctIds.toList())).successBody()
		val result = config.crypto.entity.simpleBulkShareOrUpdateEncryptedEntityMetadataNoEntities(
			entities = stubs,
			entitiesType = EntityWithEncryptionMetadataTypeName.Builtin.Classification,
			delegates = normalizedDelegates,
			autoRetry = true,
			getUpdatedEntity = { rawApi.getClassification(classificationId = it).successBody().asIcureStub() },
			doRequestBulkShareOrUpdate = { params -> rawApi.bulkShareMinimal(request = params).successBody() }
		)
		return result.toBulkShareByIdsResult(distinctIds, stubs.mapTo(mutableSetOf()) { it.id }, normalizedDelegates.keys)
	}
}

@InternalIcureApi
internal fun initClassificationBasicApi(
	rawApi: RawClassificationApi,
	config: BasicApiConfiguration,
): ClassificationBasicApi {
	val encryptedFlavour = encryptedApiFlavour(config)
	return ClassificationBasicApiImpl(
		rawApi,
		config,
		encryptedFlavour,
	)
}

@InternalIcureApi
private class ClassificationBasicApiImpl(
	private val rawApi: RawClassificationApi,
	private val config: BasicApiConfiguration,
	encryptedFlavour: FlavouredApi<EncryptedClassification, EncryptedClassification>,
) : ClassificationBasicApi,
	ClassificationBasicFlavouredApi<EncryptedClassification> by ClassificationBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	ClassificationBasicFlavourlessApi by AbstractClassificationBasicFlavourlessApi(rawApi) {
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
