package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.api.PatientBasicFlavouredApi
import com.icure.cardinal.sdk.api.PatientBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.PatientBasicFlavourlessApi
import com.icure.cardinal.sdk.api.PatientBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.PatientBasicInGroupApi
import com.icure.cardinal.sdk.api.PatientFlavouredApi
import com.icure.cardinal.sdk.api.PatientFlavouredInGroupApi
import com.icure.cardinal.sdk.api.PatientInGroupApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.PatientDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapPatientFilterOptions
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.SecretIdCreationResult
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.extensions.toDefaultDelegateOptions
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedPatient, EncryptedPatient> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedPatient, DecryptedPatient> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	decryptedSerializer = DecryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient,
	patchJson = JsonPatcher::patchPatient
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedPatient, Patient> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedPatient.serializer(),
	decryptedSerializer = DecryptedPatient.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Patient,
	manifest = EntitiesEncryptedFieldsManifests::patient,
	patchJson = JsonPatcher::patchPatient
)

@OptIn(InternalIcureApi::class)
private suspend fun RawPatientApi.doMatchPatientsBy(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: FilterOptions<Patient>
): List<String> =
	if (groupId == null) {
		matchPatientsBy(
			filter = mapPatientFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchPatientsInGroupBy(
			groupId = groupId,
			filter = mapPatientFilterOptions(
				filter,
				config,
				requestGroup = groupId
			)
		)
	}.successBody()

@OptIn(InternalIcureApi::class)
private suspend fun RawPatientApi.doMatchPatientsBySorted(
	config: BasicApiConfiguration,
	groupId: String?,
	filter: SortableFilterOptions<Patient>
): List<String> = doMatchPatientsBy(config = config, groupId = groupId, filter = filter)

@InternalIcureApi
private abstract class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedPatient, E>
) : FlavouredApi<EncryptedPatient, E> by flavour  {

	protected suspend fun doCreatePatient(groupId: String?, patient: E): E {
		requireIsValidForCreation(patient)
		val encrypted = validateAndMaybeEncrypt(groupId, patient)
		return if (groupId == null) {
			rawApi.createPatient(p = encrypted)
		} else {
			rawApi.createPatientInGroup(groupId = groupId, patientDto = encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doCreatePatients(
		groupId: String?,
		patients: List<E>
	): List<E> = skipRequestOnEmptyList(patients) { entities ->
		val encrypted = validateAndMaybeEncrypt(groupId, entities)
		if (groupId == null) {
			rawApi.createPatientsFull(patientDtos = encrypted)
		} else {
			rawApi.createPatientsInGroupFull(groupId = groupId, patientDtos = encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doUndeletePatient(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeletePatient(patientId = entityId, rev = rev)
		} else {
			rawApi.undeletePatientInGroup(groupId = groupId, patientId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeletePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeletePatients(ids = ListOfIdsAndRev(ids))
		} else {
			rawApi.undeletePatientsInGroup(groupId = groupId, ids = ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyPatient(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyPatient(patientDto = encrypted)
		} else {
			rawApi.modifyPatientInGroup(groupId = groupId, patientDto = encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doModifyPatients(
		groupId: String?,
		patients: List<E>
	): List<E> = skipRequestOnEmptyList(patients) { entities ->
		val encrypted = validateAndMaybeEncrypt(groupId, entities)
		if (groupId == null) {
			rawApi.modifyPatientsFull(patientDtos = encrypted)
		} else {
			rawApi.modifyPatientsInGroupFull(groupId = groupId, patientDtos = encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doGetPatient(groupId: String?, entityId: String) =
		doGetEncryptedPatient(groupId, entityId)?.let { maybeDecrypt(groupId, it) }

	protected suspend fun doGetEncryptedPatient(groupId: String?, entityId: String): EncryptedPatient? =
		if (groupId == null) {
			rawApi.getPatient(patientId = entityId)
		} else {
			rawApi.getPatientInGroup(groupId = groupId, patientId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetPatientResolvingMerges(
		groupId: String?,
		patientId: String,
		maxMergeDepth: Int?
	): E {
		tailrec suspend fun findLastMergedPatientInHierarchy(patient: EncryptedPatient, depth: Int): EncryptedPatient {
			val mergeId = patient.mergeToPatientId
			return if (mergeId != null) {
				require (maxMergeDepth == null || depth < maxMergeDepth) {
					"Merge chain for patient $patientId is longer than configured maxMergeDepth $maxMergeDepth"
				}
				findLastMergedPatientInHierarchy(
					patient = doGetEncryptedPatient(groupId, mergeId) ?: throw NotFoundException("Patient $mergeId not found"),
					depth = depth + 1
				)
			} else patient
		}

		return findLastMergedPatientInHierarchy(
			patient = doGetEncryptedPatient(groupId, patientId) ?: throw NotFoundException("Patient $patientId not found"),
			depth = 0
		).let {
			maybeDecrypt(groupId, it)
		}
	}

	suspend fun doGetPatients(groupId: String?, patientIds: List<String>) =
		skipRequestOnEmptyList(patientIds) { ids ->
			if (groupId == null) {
				rawApi.getPatients(patientIds = ListOfIds(ids))
			} else {
				rawApi.getPatientsInGroup(groupId = groupId, patientIds = ListOfIds(ids))
			}.successBody().let {
				maybeDecrypt(groupId, it)
			}
		}

}

@InternalIcureApi
private class PatientBasicFlavouredApiImpl<E : Patient>(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : PatientBasicFlavouredApi<E>, AbstractPatientBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createPatient(patient: E): E = doCreatePatient(groupId = null, patient = patient)

	override suspend fun createPatients(patients: List<E>): List<E> {
		requireIsValidForCreation(patients)
		return doCreatePatients(groupId = null, patients = patients)
	}

	override suspend fun undeletePatientById(id: String, rev: String): E = doUndeletePatient(groupId = null, entityId = id, rev = rev)

	override suspend fun undeletePatientsByIds(ids: List<StoredDocumentIdentifier>): List<E> =
		doUndeletePatients(groupId = null, entityIds = ids)

	override suspend fun modifyPatient(entity: E): E = doModifyPatient(groupId = null, entity = entity)

	override suspend fun modifyPatients(patients: List<E>): List<E> {
		requireIsValidForModification(patients)
		return doModifyPatients(groupId = null, patients = patients)
	}

	override suspend fun getPatient(entityId: String): E? = doGetPatient(groupId = null, entityId = entityId)

	override suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int?): E =
		doGetPatientResolvingMerges(groupId = null, patientId = patientId, maxMergeDepth = maxMergeDepth)

	override suspend fun getPatients(patientIds: List<String>): List<E> = doGetPatients(groupId = null, patientIds = patientIds)

	override suspend fun mergePatients(from: Patient, mergedInto: E): E {
		requireNotNull(mergedInto.rev) {
			"Into patient should have a non-null rev"
		}
		return rawApi.mergePatients(
			intoId = mergedInto.id,
			fromId = from.id,
			expectedFromRev = requireNotNull(from.rev) {
				"From patient should have a non-null rev"
			},
			updatedInto = validateAndMaybeEncrypt(null, mergedInto),
			omitEncryptionKeysOfFrom = true,
		).let {
			maybeDecrypt(null, it.successBody())
		}
	}
}

@InternalIcureApi
private class PatientBasicFlavouredInGroupApiImpl<E : Patient>(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : PatientBasicFlavouredInGroupApi<E>, AbstractPatientBasicFlavouredApi<E>(rawApi, config, flavour) {

	override suspend fun createPatient(patient: GroupScoped<E>): GroupScoped<E> = groupScopedWith(patient) { groupId, it ->
		doCreatePatient(groupId = groupId, patient = it)
	}

	override suspend fun createPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(patients)
		return patients.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreatePatients(groupId = groupId, patients = chunk)
		}
	}

	override suspend fun undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(patientId) { groupId, it ->
			doUndeletePatient(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	override suspend fun undeletePatientsByIds(patientIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		patientIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeletePatients(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyPatient(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyPatient(groupId = groupId, entity = it)
	}

	override suspend fun modifyPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(patients)
		return patients.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyPatients(groupId = groupId, patients = chunk)
		}
	}

	override suspend fun getPatient(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetPatient(groupId = groupId, entityId = entityId)
	}

	override suspend fun getPatientResolvingMerges(groupId: String, patientId: String, maxMergeDepth: Int?): GroupScoped<E> = groupScopedIn(groupId) {
		doGetPatientResolvingMerges(groupId = groupId, patientId = patientId, maxMergeDepth = maxMergeDepth)
	} ?: throw IllegalStateException("Cannot resolve patient $patientId in group $groupId following merges")

	override suspend fun getPatients(groupId: String, patientIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetPatients(groupId = groupId, patientIds = patientIds)
	}

}

@InternalIcureApi
private abstract class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : AbstractPatientBasicFlavouredApi<E>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		groupId: String?,
		patient: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, PatientShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates,
			true,
			{ doGetPatient(groupId, it) ?: throw NotFoundException("Patient $it not found") },
			{
				maybeDecrypt(
					groupId,
					if (groupId == null)
						rawApi.bulkShare(request = it).successBody()
					else
						rawApi.bulkShare(request = it, groupId = groupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	protected suspend fun doCreateNewSecretId(groupId: String?, patient: E): SecretIdCreationResult<E> {
		requireNotNull(patient.rev) {
			"Patient must be created before confidential secret id initialisation"
		}
		return config.crypto.entity.forceCreateNewSecretId(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			{ doGetPatient(groupId, it) ?: throw NotFoundException("Patient $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(request = it).successBody()) }
		)
	}

}

@InternalIcureApi
private class PatientFlavouredApiImpl<E : Patient>(
	rawApi: RawPatientApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : AbstractPatientFlavouredApi<E>(rawApi, config, flavour),
	PatientBasicFlavouredApi<E> by PatientBasicFlavouredApiImpl(rawApi, config, flavour),
	PatientFlavouredApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		options: PatientShareOptions?,
	): E =
		shareWithMany(patient, mapOf(delegateId to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): E =
		doShareWithMany(null, patient, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun createNewSecretId(patient: E): SecretIdCreationResult<E> =
		doCreateNewSecretId(groupId = null, patient = patient)

	override suspend fun filterPatientsBy(filter: FilterOptions<Patient>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = null, filter = filter),
			this::getPatients
		)

	override suspend fun filterPatientsBySorted(filter: SortableFilterOptions<Patient>): PaginatedListIterator<E> =
		filterPatientsBy(filter)
}

@InternalIcureApi
private class PatientFlavouredInGroupApiImpl<E : Patient>(
	rawApi: RawPatientApi,
	config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : AbstractPatientFlavouredApi<E>(rawApi, config, flavour),
	PatientBasicFlavouredInGroupApi<E> by PatientBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	PatientFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		patient: GroupScoped<E>,
		options: PatientShareOptions?
	): GroupScoped<E> =
		shareWithMany(patient, mapOf(delegate to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(
		patient: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, PatientShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(patient.groupId, patient.entity, delegates), patient.groupId)

	override suspend fun createNewSecretId(patient: GroupScoped<E>): GroupScoped<SecretIdCreationResult<E>> = groupScopedWith(patient) { groupId, entity ->
		doCreateNewSecretId(groupId = groupId, patient = entity)
	}

	override suspend fun filterPatientsBy(groupId: String, filter: FilterOptions<Patient>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)
		) { ids ->
			doGetPatients(groupId, ids).map { patient ->
				GroupScoped(patient, groupId)
			}
		}

	override suspend fun filterPatientsBySorted(groupId: String, filter: SortableFilterOptions<Patient>): PaginatedListIterator<GroupScoped<E>> =
		filterPatientsBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractPatientBasicFlavourless(
	protected val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration
) {

	protected suspend fun doDeletePatient(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deletePatient(patientId = entityId, rev = rev)
		} else {
			rawApi.deletePatientInGroup(groupId = groupId, patientId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeletePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deletePatientsWithRev(patientIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deletePatientsWithRevInGroup(groupId = groupId, patientIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgePatient(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgePatient(patientId = entityId, rev = rev)
		} else {
			rawApi.purgePatientInGroup(groupId = groupId, patientId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgePatients(patientIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgePatientsInGroup(groupId = groupId, patientIds = ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doGetDataOwnersWithAccessTo(groupId: String?, patient: Patient): EntityAccessInformation =
		config.crypto.entityAccessInformationProvider.getDataOwnersWithAccessTo(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient)
}

@InternalIcureApi
private class PatientBasicFlavourlessApiImpl(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration
) : AbstractPatientBasicFlavourless(rawApi, config), PatientBasicFlavourlessApi {

	override suspend fun deletePatientById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeletePatient(groupId = null, entityId, rev)

	override suspend fun deletePatientsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeletePatients(groupId = null, entityIds)

	override suspend fun purgePatientById(id: String, rev: String) {
		doPurgePatient(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgePatientsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgePatients(groupId = null, entityIds = entityIds)

	override suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(null, patient)
}

@InternalIcureApi
private class PatientBasicFlavourlessInGroupApiImpl(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration
) : AbstractPatientBasicFlavourless(rawApi, config), PatientBasicFlavourlessInGroupApi {
	override suspend fun deletePatientById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, it ->
			doDeletePatient(groupId, it.id, it.rev)
		}

	override suspend fun deletePatientsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeletePatients(groupId, entities)
		}

	override suspend fun purgePatientById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgePatient(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgePatientsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgePatients(groupId, batch)
		}

	override suspend fun getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): EntityAccessInformation =
		doGetDataOwnersWithAccessTo(groupId = patient.groupId, patient = patient.entity)
}

@InternalIcureApi
internal fun initPatientApi(
	rawApi: RawPatientApi,
	config: ApiConfiguration
): PatientApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	return PatientApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedPatient, EncryptedPatient>,
	private val decryptedFlavour: FlavouredApi<EncryptedPatient, DecryptedPatient>,
	private val tryAndRecoverFlavour: FlavouredApi<EncryptedPatient, Patient>,
) :	PatientApi,
	PatientFlavouredApi<DecryptedPatient> by PatientFlavouredApiImpl(rawApi, config, decryptedFlavour),
	PatientBasicFlavourlessApi by PatientBasicFlavourlessApiImpl(rawApi, config) {

	override val encrypted: PatientFlavouredApi<EncryptedPatient> = PatientFlavouredApiImpl(rawApi, config, encryptedFlavour)

	override val tryAndRecover: PatientFlavouredApi<Patient> = PatientFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)

	override val inGroup: PatientInGroupApi = object : PatientInGroupApi,
		PatientFlavouredInGroupApi<DecryptedPatient> by PatientFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour),
		PatientBasicFlavourlessInGroupApi by PatientBasicFlavourlessInGroupApiImpl(rawApi, config) {
		override val encrypted: PatientFlavouredInGroupApi<EncryptedPatient> = PatientFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour)
		override val tryAndRecover: PatientFlavouredInGroupApi<Patient> = PatientFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour)

		override suspend fun matchPatientsBy(groupId: String, filter: FilterOptions<Patient>): List<String> =
			rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchPatientsBySorted(
			groupId: String,
			filter: SortableFilterOptions<Patient>
		): List<String> = rawApi.doMatchPatientsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun decrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<DecryptedPatient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(patients: List<GroupScoped<EncryptedPatient>>): List<GroupScoped<Patient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun encryptOrValidate(patients: List<GroupScoped<Patient>>): List<GroupScoped<EncryptedPatient>> =
			patients.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.validateAndMaybeEncrypt(groupId, entities)
			}

		override suspend fun getSecretIdsOf(patient: GroupScoped<Patient>): Map<String, Set<EntityReferenceInGroup>> =
			doGetSecretIdsOf(patient.groupId, patient.entity)

		override suspend fun getEncryptionKeysOf(patient: GroupScoped<Patient>): Set<HexString> =
			doGetEncryptionKeysOf(patient.groupId, patient.entity)

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedPatient?,
			user: User?,
			delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, AccessLevel>,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedPatient> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId = entityGroupId,
					base = base,
					user = user,
					delegates = delegates,
					alternateRootDataOwnerReference = alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun withEncryptionMetadataAndDelegates(
			entityGroupId: String,
			base: DecryptedPatient?,
			delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "delegateOptions") Map<EntityReferenceInGroup, PatientDelegateOptions>,
			user: User?,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedPatient> =
			GroupScoped(
				doWithEncryptionMetadataAndDelegates(
					entityGroupId = entityGroupId,
					base = base,
					user = user,
					delegates = delegates,
					alternateRootDataOwnerReference = alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun hasWriteAccess(patient: GroupScoped<DecryptedPatient>): Boolean =
			doHasWriteAccess(patient.groupId, patient.entity)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<DecryptedPatient>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?
	): DecryptedPatient =
		doWithEncryptionMetadata(
			entityGroupId = null,
			base = base,
			user = user,
			delegates = delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	override suspend fun withEncryptionMetadataAndDelegates(
		base: DecryptedPatient?,
		delegates: Map<String, PatientDelegateOptions>,
		user: User?,
		alternateRootDelegateId: String?
	): DecryptedPatient =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = null,
			base = base,
			user = user,
			delegates = delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedPatient?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, AccessLevel>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedPatient =
		doWithEncryptionMetadataAndDelegates(
			entityGroupId = entityGroupId,
			base = base,
			user = user,
			delegates = delegates.mapValues { it.value.toDefaultDelegateOptions() },
			alternateRootDataOwnerReference = alternateRootDataOwnerReference
		)

	private suspend fun doWithEncryptionMetadataAndDelegates(
		entityGroupId: String?,
		base: DecryptedPatient?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "delegateOptions") Map<EntityReferenceInGroup, DelegateOptions>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?,
	): DecryptedPatient =
		config.crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId,
			(base ?: DecryptedPatient(config.crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			EntityWithEncryptionMetadataTypeName.Patient,
			null,
			initializeEncryptionKey = true,
			autoDelegations = delegates + user?.autoDelegationsFor(DelegationTag.AdministrativeData)
				.orEmpty().keyAsLocalDataOwnerReferences(),
			alternateRootDataOwnerReference = alternateRootDataOwnerReference,
		).updatedEntity


	override suspend fun hasWriteAccess(patient: Patient): Boolean =
		doHasWriteAccess(null, patient)

	private suspend fun doHasWriteAccess(groupId: String?, patient: Patient): Boolean =
		config.crypto.entity.hasWriteAccess(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient)

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Set<String>) =
		doCreateDelegationDeAnonymizationMetadata(null, entity, delegates.asLocalDataOwnerReferences())

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Patient, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			groupId,
			entity,
			EntityWithEncryptionMetadataTypeName.Patient,
			delegates
		)
	}

	override suspend fun getSecretIdsOf(patient: Patient): Map<String, Set<EntityReferenceInGroup>> =
		doGetSecretIdsOf(null, patient)

	private suspend fun doGetSecretIdsOf(groupId: String?, patient: Patient): Map<String, Set<EntityReferenceInGroup>> =
		ensureNonNull(config.crypto.entity.secretIdsWithDataOwnersInfo(groupId, listOf(patient), EntityWithEncryptionMetadataTypeName.Patient).values.singleOrNull()) {
			"Method secretIdsWithDataOwnersInfo should have returned single item for single patient"
		}


	override suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> =
		doGetEncryptionKeysOf(null, patient)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, patient: Patient): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(groupId, patient, EntityWithEncryptionMetadataTypeName.Patient, null)

	override suspend fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Boolean {
		val patient = encrypted.getPatient(patientId) ?: throw NotFoundException("Patient $patientId not found")
		if (patient.publicKeysSpki.isNotEmpty()) return false
		config.crypto.exchangeDataManager.getOrCreateEncryptionDataTo(
			null,
			EntityReferenceInGroup(patientId, null),
			allowCreationWithoutDelegateKey = true,
			allowCreationWithoutDelegatorKey = false
		)
		return true
	}

	override suspend fun decrypt(patients: List<EncryptedPatient>): List<DecryptedPatient> =
		decryptedFlavour.maybeDecrypt(patients)

	override suspend fun tryDecrypt(patients: List<EncryptedPatient>): List<Patient> =
		tryAndRecoverFlavour.maybeDecrypt(patients)

	override suspend fun encryptOrValidate(patients: List<Patient>): List<EncryptedPatient> =
		tryAndRecoverFlavour.validateAndMaybeEncrypt(patients)

	override suspend fun matchPatientsBy(filter: FilterOptions<Patient>): List<String> =
		rawApi.doMatchPatientsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchPatientsBySorted(filter: SortableFilterOptions<Patient>): List<String> =
		rawApi.doMatchPatientsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Patient>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedPatient> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedPatient.serializer(),
			events = events,
			filter = mapPatientFilterOptions(filter, config, null),
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(PatientAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun ensureEncryptionMetadataForSelfIsInitialized(
		sharingWith: Map<String, AccessLevel>,
		ignoreIfEncryptionMetadataExists: Boolean,
		alternateRootDelegateId: String?
	): EncryptedPatient {
		val self = config.crypto.dataOwnerApi.getCurrentDataOwner()
		require (self is DataOwnerWithType.PatientDataOwner) { "Current user is not a patient data owner" }
		if (config.crypto.userEncryptionKeysManager.delegatorActorId() != self.dataOwner.id) throw UnsupportedOperationException(
			"Initialization of encryption metadata for self is currently not supported when the SDK is initialized in ParentDelegator mode"
		)

		suspend fun doWith(self: EncryptedPatient): EncryptedPatient {
			val availableSecretIds = config.crypto.entity.secretIdsOf(null, self, EntityWithEncryptionMetadataTypeName.Patient, null)
			return if (availableSecretIds.isNotEmpty()) {
				self
			} else if (config.crypto.entity.hasEmptyEncryptionMetadata(self, EntityWithEncryptionMetadataTypeName.Patient)) {
				config.crypto.entity.entityWithInitializedEncryptedMetadata(
					entityGroupId = null,
					entity = self,
					entityType = EntityWithEncryptionMetadataTypeName.Patient,
					owningEntityDetails = null,
					initializeEncryptionKey = true,
					autoDelegations = sharingWith.keyAsLocalDataOwnerReferences().mapValues { it.value.toDefaultDelegateOptions() },
					alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) },
				).updatedEntity.let {
					encrypted.modifyPatient(it)
				}
			} else if (!ignoreIfEncryptionMetadataExists) {
				if (config.crypto.userEncryptionKeysManager.delegatorActorVerifiedKeys().isEmpty()) { //isKeyless
					require (alternateRootDelegateId != null) {
						"Cannot initialize encrypted metadata without an alternate root delegation when running in keyless mode."
					}
					require (alternateRootDelegateId !in sharingWith.keys) {
						"Alternate root delegation cannot be also in the sharingWith map."
					}
				} else {
					require (alternateRootDelegateId == null) {
						"Cannot specify an alternate root delegation when not running in keyless mode."
					}
				}
				if (alternateRootDelegateId != null) throw NotImplementedError(
					"Alternate root delegation in ensureEncryptionMetadataForSelfIsInitialized when the patient already has encryption metadata initialized is not yet supported."
				)
				// TODO (alternateRootDelegateId ?: self.id) in the delegates of simpleShareOrUpdateEncryptedEntityMetadata might be sufficient, but needs testing
				val secretIdShareOptions = SecretIdShareOptions.UseExactly(
					secretIds = setOf(config.crypto.primitives.strongRandom.randomUUID()),
					createUnknownSecretIds = true
				)
				val shareResult = config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
					entityGroupId = null,
					entity = self,
					entityType = EntityWithEncryptionMetadataTypeName.Patient,
					delegates = (mapOf(
						(alternateRootDelegateId ?: self.id) to SimpleDelegateShareOptionsImpl(
							shareEncryptionKey = ShareMetadataBehaviour.IfAvailable,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = secretIdShareOptions,
							requestedPermissions = RequestedPermission.Root
						)
					) + sharingWith.mapValues { (_, accessLevel) ->
						SimpleDelegateShareOptionsImpl(
							shareEncryptionKey = ShareMetadataBehaviour.Never,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = secretIdShareOptions,
							requestedPermissions = when (accessLevel) {
								AccessLevel.Read -> RequestedPermission.FullRead
								AccessLevel.Write -> RequestedPermission.FullWrite
							}
						)
					}).keyAsLocalDataOwnerReferences(),
					autoRetry = false, // Will retry with the updated entity: maybe no need to update metadata after all
					getUpdatedEntity = { throw UnsupportedOperationException("No retry") },
					doRequestBulkShareOrUpdate = { rawApi.bulkShare(request = it).successBody() },
				)
				if (shareResult is SimpleShareResult.Failure && shareResult.errorsDetails.all { it is FailedRequestDetails.RequestRejected && it.shouldRetry }) {
					val updatedSelf = rawApi.getPatient(patientId = self.id).successBody()
					if (updatedSelf.rev != self.rev) {
						ensureEncryptionMetadataForSelfIsInitialized(sharingWith)
					} else shareResult.updatedEntityOrThrow()
				} else shareResult.updatedEntityOrThrow()
			} else {
				// The current user won't have any secret id accessible.
				self
			}
		}

		return doWith(self.dataOwner)
	}
}

@InternalIcureApi
internal fun initPatientBasicApi(
	rawApi: RawPatientApi,
	config: BasicApiConfiguration
): PatientBasicApi = PatientBasicApiImpl(
	rawApi,
	config,
	encryptedApiFlavour(config)
)

@InternalIcureApi
private class PatientBasicApiImpl(
	private val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: FlavouredApi<EncryptedPatient, EncryptedPatient>,
) : PatientBasicApi,
	PatientBasicFlavouredApi<EncryptedPatient> by PatientBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	PatientBasicFlavourlessApi by PatientBasicFlavourlessApiImpl(rawApi, config) {

	override val inGroup: PatientBasicInGroupApi = object :
		PatientBasicInGroupApi,
		PatientBasicFlavouredInGroupApi<EncryptedPatient> by PatientBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour),
		PatientBasicFlavourlessInGroupApi by PatientBasicFlavourlessInGroupApiImpl(rawApi, config) {
		override suspend fun matchPatientsBy(groupId: String, filter: BaseFilterOptions<Patient>): List<String> =
			rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)

		override suspend fun matchPatientsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Patient>
		): List<String> = rawApi.doMatchPatientsBySorted(config = config, groupId = groupId, filter = filter)

		override suspend fun filterPatientsBy(
			groupId: String,
			filter: BaseFilterOptions<Patient>
		): PaginatedListIterator<GroupScoped<EncryptedPatient>> =
			IdsPageIterator(
				rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)
			) { getPatients(groupId, it) }

		override suspend fun filterPatientsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Patient>
		): PaginatedListIterator<GroupScoped<EncryptedPatient>> =
			filterPatientsBy(groupId, filter)
	}

	override suspend fun matchPatientsBy(filter: BaseFilterOptions<Patient>): List<String> =
		rawApi.doMatchPatientsBy(config = config, groupId = null, filter = filter)

	override suspend fun matchPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): List<String> =
		rawApi.doMatchPatientsBySorted(config = config, groupId = null, filter = filter)

	override suspend fun filterPatientsBy(filter: BaseFilterOptions<Patient>): PaginatedListIterator<EncryptedPatient> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = null, filter = filter)
		) { getPatients(it) }

	override suspend fun filterPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): PaginatedListIterator<EncryptedPatient> =
		filterPatientsBy(filter)

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Patient>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedPatient> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedPatient.serializer(),
			events = events,
			filter = mapPatientFilterOptions(filter, config, null),
			qualifiedName = Patient.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(PatientAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}
