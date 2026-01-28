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
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.RawClassificationApi
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.RawHealthElementApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.DelegateShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.asIcureStub
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
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
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
			mapPatientFilterOptions(
				filter,
				config,
				requestGroup = null
			)
		)
	} else {
		matchPatientsBy(
			mapPatientFilterOptions(
				filter,
				config,
				requestGroup = null
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
private open class AbstractPatientBasicFlavouredApi<E : Patient>(
	protected val rawApi: RawPatientApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedPatient, E>
) : PatientBasicFlavouredApi<E>,
	PatientBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedPatient, E> by flavour  {

	override suspend fun createPatient(patient: E): E = doCreatePatient(groupId = null, patient = patient)

	override suspend fun createPatient(patient: GroupScoped<E>): GroupScoped<E> = groupScopedWith(patient) { groupId, it ->
		doCreatePatient(groupId = groupId, patient = it)
	}

	protected suspend fun doCreatePatient(groupId: String?, patient: E): E {
		requireIsValidForCreation(patient)
		val encrypted = validateAndMaybeEncrypt(groupId, patient)
		return if (groupId == null) {
			rawApi.createPatient(encrypted)
		} else {
			rawApi.createPatientInGroup(groupId, encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun createPatients(patients: List<E>): List<E> {
		requireIsValidForCreation(patients)
		return doCreatePatients(groupId = null, patients = patients)
	}

	override suspend fun createPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreation(patients)
		return patients.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreatePatients(groupId = groupId, patients = chunk)
		}
	}

	protected suspend fun doCreatePatients(
		groupId: String?,
		patients: List<E>
	): List<E> = skipRequestOnEmptyList(patients) { entities ->
		val encrypted = validateAndMaybeEncrypt(groupId, entities)
		if (groupId == null) {
			rawApi.createPatientsFull(encrypted)
		} else {
			rawApi.createPatientsInGroupFull(groupId, encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun undeletePatientById(id: String, rev: String): E = doUndeletePatient(groupId = null, entityId = id, rev = rev)

	override suspend fun undeletePatientById(patientId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(patientId) { groupId, it ->
			doUndeletePatient(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	private suspend fun doUndeletePatient(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeletePatient(entityId, rev)
		} else {
			rawApi.undeletePatientInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeletePatientsByIds(ids: List<StoredDocumentIdentifier>): List<E> =
		doUndeletePatients(groupId = null, entityIds = ids)

	override suspend fun undeletePatientsByIds(patientIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		patientIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeletePatients(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeletePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeletePatients(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeletePatientsInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyPatient(entity: E): E = doModifyPatient(groupId = null, entity = entity)

	override suspend fun modifyPatient(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyPatient(groupId = groupId, entity = it)
	}

	private suspend fun doModifyPatient(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyPatient(encrypted)
		} else {
			rawApi.modifyPatientInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyPatients(patients: List<E>): List<E> {
		requireIsValidForModification(patients)
		return doModifyPatients(groupId = null, patients = patients)
	}

	override suspend fun modifyPatients(patients: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModification(patients)
		return patients.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyPatients(groupId = groupId, patients = chunk)
		}
	}

	protected suspend fun doModifyPatients(
		groupId: String?,
		patients: List<E>
	): List<E> = skipRequestOnEmptyList(patients) { entities ->
		val encrypted = validateAndMaybeEncrypt(groupId, entities)
		if (groupId == null) {
			rawApi.modifyPatientsFull(encrypted)
		} else {
			rawApi.modifyPatientsInGroupFull(groupId, encrypted)
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun getPatient(entityId: String): E? = doGetPatient(groupId = null, entityId = entityId)

	override suspend fun getPatient(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetPatient(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetPatient(groupId: String?, entityId: String) =
		doGetEncryptedPatient(groupId, entityId)?.let { maybeDecrypt(groupId, it) }

	protected suspend fun doGetEncryptedPatient(groupId: String?, entityId: String): EncryptedPatient? =
		if (groupId == null) {
			rawApi.getPatient(entityId)
		} else {
			rawApi.getPatientInGroup(groupId = groupId, patientId = entityId)
		}.successBodyOrNull404()

	override suspend fun getPatientResolvingMerges(groupId: String, patientId: String, maxMergeDepth: Int?): GroupScoped<E> = groupScopedIn(groupId) {
		doGetPatientResolvingMerges(groupId = groupId, patientId = patientId, maxMergeDepth = maxMergeDepth)
	} ?: throw IllegalStateException("Cannot resolve patient $patientId in group $groupId following merges")

	override suspend fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Int?): E =
		doGetPatientResolvingMerges(groupId = null, patientId = patientId, maxMergeDepth = maxMergeDepth)

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

	override suspend fun getPatients(patientIds: List<String>): List<E> = doGetPatients(groupId = null, patientIds = patientIds)

	override suspend fun getPatients(groupId: String, patientIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetPatients(groupId = groupId, patientIds = patientIds)
	}

	suspend fun doGetPatients(groupId: String?, patientIds: List<String>) =
		skipRequestOnEmptyList(patientIds) { ids ->
			if (groupId == null) {
				rawApi.getPatients(ListOfIds(ids))
			} else {
				rawApi.getPatientsInGroup(groupId, ListOfIds(ids))
			}.successBody().let {
				maybeDecrypt(groupId, it)
			}
		}

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
			updatedInto = validateAndMaybeEncrypt(null, mergedInto)
		).let {
			maybeDecrypt(null, it.successBody())
		}
	}
}

@InternalIcureApi
private open class AbstractPatientFlavouredApi<E : Patient>(
	rawApi: RawPatientApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedPatient, E>
) : AbstractPatientBasicFlavouredApi<E>(rawApi, config, flavour),
	PatientFlavouredApi<E>,
	PatientFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		patient: GroupScoped<E>,
		options: PatientShareOptions?
	): GroupScoped<E> =
		shareWithMany(patient, mapOf(delegate to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(
		patient: GroupScoped<E>,
		delegates: Map<EntityReferenceInGroup, PatientShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(patient.groupId, patient.entity, delegates), patient.groupId)

	override suspend fun shareWith(
		delegateId: String,
		patient: E,
		options: PatientShareOptions?,
	): E =
		shareWithMany(patient, mapOf(delegateId to (options ?: PatientShareOptions())))

	override suspend fun shareWithMany(patient: E, delegates: Map<String, PatientShareOptions>): E =
		doShareWithMany(null, patient, delegates.keyAsLocalDataOwnerReferences())

	protected suspend fun doShareWithMany(
		groupId: String?,
		patient: E,
		delegates: Map<EntityReferenceInGroup, PatientShareOptions>
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
						rawApi.bulkShare(it).successBody()
					else
						rawApi.bulkShare(it, groupId).successBody()
				)
			}
		).updatedEntityOrThrow()

	override suspend fun initializeConfidentialSecretId(patient: E): E =
		doInitializeConfidentialSecretId(groupId = null, patient = patient)

	override suspend fun initializeConfidentialSecretId(patient: GroupScoped<E>): GroupScoped<E> = groupScopedWith(patient) { groupId, entity ->
		doInitializeConfidentialSecretId(groupId = groupId, patient = entity)
	}

	protected suspend fun doInitializeConfidentialSecretId(groupId: String?, patient: E): E {
		requireNotNull(patient.rev) {
			"Patient must be created before confidential secret id initialisation"
		}
		return config.crypto.entity.initializeConfidentialSecretId(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			{ doGetPatient(groupId, it) ?: throw NotFoundException("Patient $it not found") },
			{ maybeDecrypt(null, rawApi.bulkShare(it).successBody()) }
		) ?: patient
	}

	override suspend fun filterPatientsBy(filter: FilterOptions<Patient>): PaginatedListIterator<E> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = null, filter = filter),
			this::getPatients
		)

	override suspend fun filterPatientsBy(groupId: String, filter: FilterOptions<Patient>): PaginatedListIterator<GroupScoped<E>> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)
		) { ids ->
			doGetPatients(groupId, ids).map { patient ->
				GroupScoped(patient, groupId)
			}
		}

	override suspend fun filterPatientsBySorted(filter: SortableFilterOptions<Patient>): PaginatedListIterator<E> =
		filterPatientsBy(filter)

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
			rawApi.deletePatient(entityId, rev)
		} else {
			rawApi.deletePatientInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeletePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deletePatientsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deletePatientsWithRevInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgePatient(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgePatient(entityId, rev)
		} else {
			rawApi.purgePatientInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgePatients(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgePatients(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgePatientsInGroup(groupId, ListOfIdsAndRev(ids))
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
	rawHealthcarePartyApi: RawHealthcarePartyApi,
	rawHealthElementApi: RawHealthElementApi,
	rawFormApi: RawFormApi,
	rawContactApi: RawContactApi,
	rawInvoiceApi: RawInvoiceApi,
	rawCalendarItemApi: RawCalendarItemApi,
	rawClassificationApi: RawClassificationApi,
	config: ApiConfiguration
): PatientApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractPatientFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractPatientFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractPatientFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return PatientApiImpl(
		rawApi,
		rawHealthcarePartyApi,
		rawHealthElementApi,
		rawFormApi,
		rawContactApi,
		rawInvoiceApi,
		rawCalendarItemApi,
		rawClassificationApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class PatientApiImpl(
	private val rawApi: RawPatientApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi,
	private val rawHealthElementApi: RawHealthElementApi,
	private val rawFormApi: RawFormApi,
	private val rawContactApi: RawContactApi,
	private val rawInvoiceApi: RawInvoiceApi,
	private val rawCalendarItemApi: RawCalendarItemApi,
	private val rawClassificationApi: RawClassificationApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractPatientFlavouredApi<EncryptedPatient>,
	private val decryptedFlavour: AbstractPatientFlavouredApi<DecryptedPatient>,
	private val tryAndRecoverFlavour: AbstractPatientFlavouredApi<Patient>,
) :	PatientApi,
	PatientFlavouredApi<DecryptedPatient> by decryptedFlavour,
	PatientBasicFlavourlessApi by PatientBasicFlavourlessApiImpl(rawApi, config) {

	override val encrypted: PatientFlavouredApi<EncryptedPatient> = encryptedFlavour

	override val tryAndRecover: PatientFlavouredApi<Patient> = tryAndRecoverFlavour

	override val inGroup: PatientInGroupApi = object : PatientInGroupApi,
		PatientFlavouredInGroupApi<DecryptedPatient> by decryptedFlavour,
		PatientBasicFlavourlessInGroupApi by PatientBasicFlavourlessInGroupApiImpl(rawApi, config) {
		override val encrypted: PatientFlavouredInGroupApi<EncryptedPatient> = encryptedFlavour
		override val tryAndRecover: PatientFlavouredInGroupApi<Patient> = tryAndRecoverFlavour

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
			delegates: Map<EntityReferenceInGroup, AccessLevel>,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedPatient> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId,
					base,
					user,
					delegates,
					alternateRootDelegateReference
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

	private suspend fun findDelegationStubsForHcPartyAndParent(
		delegationSecretKeys: List<String>,
		hcpId: String,
		parentId: String?,
		stubGetter: suspend (String, List<String>) -> List<IcureStub>
	): List<IcureStub> {
		val stubs = stubGetter(hcpId, delegationSecretKeys) +
			if(parentId != null) stubGetter(parentId, delegationSecretKeys) else emptyList()
		return stubs.distinctBy { it.id }
	}

	override suspend fun shareAllDataOfPatient(
		patientId: String,
		delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>
	): ShareAllPatientDataOptions.Result {

		val allTags = delegatesWithShareType.values.flatMap { it.toList() }.toSet()

		val hcp = rawHealthcarePartyApi.getCurrentHealthcareParty().successBody() // Shall we do it for any data owner?
		val parentId = hcp.parentId
		val patient = encrypted.getPatient(patientId)?.let { patient ->
			config.crypto.entity.ensureEncryptionKeysInitialized(
				null,
				patient,
				EntityWithEncryptionMetadataTypeName.Patient
			)?.let {
				encrypted.modifyPatient(it)
			} ?: patient
		} ?: throw NotFoundException("Patient $patientId not found")
		val selfHierarchySet = config.crypto.userEncryptionKeysManager.delegatorActorHierarchy().toSet()

		val delegationSecretKeys = getSecretIdsOf(patient).keys

		val shareStatus = if(delegationSecretKeys.isNotEmpty()) {
			suspend fun <T : HasEncryptionMetadata> doShareEntitiesAndUpdateStatus(
				entities: List<T>,
				entitiesType: EntityWithEncryptionMetadataTypeName,
				tagsCondition: (tags: Set<ShareAllPatientDataOptions.Tag>) -> Boolean,
				getEntity: suspend (id: String) -> T,
				doShareMinimal: suspend (request: BulkShareOrUpdateMetadataParams) -> List<EntityBulkShareResult<Nothing>>
			): ShareAllPatientDataOptions.EntityResult {
				val delegatesToApply = delegatesWithShareType.entries.mapNotNull { (delegateId, types) ->
					delegateId.takeIf { tagsCondition(types) }
				}
				return if (entities.isNotEmpty() && delegatesToApply.isNotEmpty()) {
					val allSecretIds = config.crypto.securityMetadataDecryptor.decryptAll(
						null,
						entities,
						entitiesType,
						selfHierarchySet,
						SecurityMetadataType.SecretId
					)
					val allEntityEncryptionKeys = config.crypto.securityMetadataDecryptor.decryptAll(
						null,
						entities,
						entitiesType,
						selfHierarchySet,
						SecurityMetadataType.EncryptionKey
					)
					val updates = mutableListOf<Pair<T, Map<String, DelegateShareOptions>>>().also { acc ->
						entities.forEach { entity ->
							acc.add(entity to delegatesToApply.associateWith {
								DelegateShareOptions(
									shareSecretIds = allSecretIds[entity.id]?.mapTo(mutableSetOf()) { it.value }.orEmpty(),
									shareEncryptionKeys = allEntityEncryptionKeys[entity.id]?.mapTo(mutableSetOf()) { it.value }.orEmpty(),
									shareOwningEntityIds = setOf(patient.id),
									requestedPermissions = RequestedPermission.MaxWrite
								)
							})
						}
					}
					try {
						val result = config.crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
							updates,
							entitiesType,
							true,
							getEntity,
							doShareMinimal
						)
						ShareAllPatientDataOptions.EntityResult(
							success = result.updateErrors.isEmpty(),
							error = BulkShareFailure(
								result.updateErrors,
								"Error while sharing (some) entities of type $entitiesType for patient ${patient.id}"
							).takeIf { result.updateErrors.isNotEmpty() },
							modified = result.successfulUpdates.map { it.entityId }.toSet().size
						)
					} catch (e: Exception) {
						ShareAllPatientDataOptions.EntityResult(
							success = false,
							error = FailedRequest("${e::class.simpleName}: ${e.message}")
						)
					}
				} else {
					ShareAllPatientDataOptions.EntityResult(success = true)
				}
			}

			val retrievedHealthElements = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val heIds = rawHealthElementApi.listHealthElementIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawHealthElementApi.listHealthElementsDelegationsStubById(ListOfIds(heIds)).successBody()
			}
			val shareHealthElementsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedHealthElements,
				entitiesType = EntityWithEncryptionMetadataTypeName.HealthElement,
				tagsCondition = {
					it.contains(ShareAllPatientDataOptions.Tag.All)
						|| it.contains(ShareAllPatientDataOptions.Tag.MedicalInformation)
				},
				getEntity = { rawHealthElementApi.getHealthElement(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawHealthElementApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedForms = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val formIds =  rawFormApi.listFormIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawFormApi.findFormsDelegationsStubsByIds(ListOfIds(formIds)).successBody()
			}
			val shareFormsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedForms,
				entitiesType = EntityWithEncryptionMetadataTypeName.Form,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawFormApi.getForm(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawFormApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedContacts = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val contactIds = rawContactApi.listContactIdsByDataOwnerPatientOpeningDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawContactApi.findContactsDelegationsStubsByIds(ListOfIds(contactIds)).successBody()
			}
			val shareContactsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedContacts,
				entitiesType = EntityWithEncryptionMetadataTypeName.Contact,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawContactApi.getContact(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawContactApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedInvoices = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val invoiceIds = rawInvoiceApi.listInvoiceIdsByDataOwnerPatientInvoiceDate(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawInvoiceApi.listInvoicesDelegationsStubsByIds(ListOfIds(invoiceIds)).successBody()
			}
			val shareInvoicesResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedInvoices,
				entitiesType = EntityWithEncryptionMetadataTypeName.Invoice,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.FinancialInformation) },
				getEntity = { rawInvoiceApi.getInvoice(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawInvoiceApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedCalendarItems = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				rawCalendarItemApi.findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(doId, delSecKeys).successBody()
			}
			val shareCalendarItemsResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedCalendarItems,
				entitiesType = EntityWithEncryptionMetadataTypeName.CalendarItem,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawCalendarItemApi.getCalendarItem(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawCalendarItemApi.bulkShareMinimal(params).successBody() }
			)

			val retrievedClassifications = findDelegationStubsForHcPartyAndParent(delegationSecretKeys.toList(), hcp.id, parentId) { doId, delSecKeys ->
				val classificationIds = rawClassificationApi.listClassificationIdsByDataOwnerPatientCreated(dataOwnerId = doId, secretPatientKeys = ListOfIds(delSecKeys)).successBody()
				rawClassificationApi.findClassificationsDelegationsStubsByIds(ListOfIds(classificationIds)).successBody()
			}
			val shareClassificationResult = doShareEntitiesAndUpdateStatus(
				entities = retrievedClassifications,
				entitiesType = EntityWithEncryptionMetadataTypeName.Classification,
				tagsCondition = { it.contains(ShareAllPatientDataOptions.Tag.All) || it.contains(
					ShareAllPatientDataOptions.Tag.MedicalInformation) },
				getEntity = { rawClassificationApi.getClassification(it).successBody().asIcureStub() },
				doShareMinimal = { params -> rawClassificationApi.bulkShareMinimal(params).successBody() }
			)

			mapOf(
				ShareAllPatientDataOptions.ShareableEntity.HealthElement to shareHealthElementsResult,
				ShareAllPatientDataOptions.ShareableEntity.Form to shareFormsResult,
				ShareAllPatientDataOptions.ShareableEntity.Contact to shareContactsResult,
				ShareAllPatientDataOptions.ShareableEntity.Invoice to shareInvoicesResult,
				ShareAllPatientDataOptions.ShareableEntity.CalendarItem to shareCalendarItemsResult,
				ShareAllPatientDataOptions.ShareableEntity.Classification to shareClassificationResult,
			)
		} else {
			ShareAllPatientDataOptions.ShareableEntity.entries.associateWith { entity ->
				ShareAllPatientDataOptions.EntityResult(
					success = false.takeIf { allTags.contains(entity.type) || allTags.contains(
						ShareAllPatientDataOptions.Tag.All) },
					error = null,
					modified = 0
				)
			}
		}

		val patientStatus = try {
			val result = config.crypto.entity.bulkShareOrUpdateEncryptedEntityMetadataNoEntities(
				listOf(
					patient to delegatesWithShareType.keys.associateWith {
						DelegateShareOptions(
							shareSecretIds = delegationSecretKeys,
							shareEncryptionKeys = getEncryptionKeysOf(patient),
							shareOwningEntityIds = setOf(),
							requestedPermissions = RequestedPermission.MaxWrite
						)
					}
				),
				EntityWithEncryptionMetadataTypeName.Patient,
				true,
				{ getPatient(it) ?: throw NotFoundException("Patient $it not found") },
				{ params -> rawApi.bulkShareMinimal(params).successBody() }
			)
			ShareAllPatientDataOptions.EntityResult(
				success = result.updateErrors.isEmpty(),
				error = BulkShareFailure(
					errors = result.updateErrors,
					"Error while sharing patient ${patient.id}"
				).takeIf { result.updateErrors.isNotEmpty() },
				modified = result.successfulUpdates.map { it.entityId }.toSet().size
			)
		} catch (e: Exception) {
			ShareAllPatientDataOptions.EntityResult(
				success = false,
				error = FailedRequest("${e::class.simpleName}: ${e.message}")
			)
		}

		return ShareAllPatientDataOptions.Result(
			patient = patient,
			statuses = shareStatus + (ShareAllPatientDataOptions.ShareableEntity.Patient to patientStatus)
		)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<String, AccessLevel>,
		alternateRootDelegateId: String?
	): DecryptedPatient =
		doWithEncryptionMetadata(
			null,
			base,
			user,
			delegates.keyAsLocalDataOwnerReferences(),
			alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
		)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedPatient?,
		user: User?,
		delegates: Map<EntityReferenceInGroup, AccessLevel>,
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

	override suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> =
		doGetConfidentialSecretIdsOf(null, patient)

	private suspend fun doGetConfidentialSecretIdsOf(groupId: String?, patient: Patient): Set<String> =
		config.crypto.entity.getConfidentialSecretIdsOf(
			groupId,
			patient,
			EntityWithEncryptionMetadataTypeName.Patient,
			null
		)

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
					autoDelegations = sharingWith.keyAsLocalDataOwnerReferences(),
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
					doRequestBulkShareOrUpdate = { rawApi.bulkShare(it).successBody() },
				)
				if (shareResult is SimpleShareResult.Failure && shareResult.errorsDetails.all { it.shouldRetry }) {
					val updatedSelf = rawApi.getPatient(self.id).successBody()
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
	AbstractPatientBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)

@InternalIcureApi
private class PatientBasicApiImpl(
	private val rawApi: RawPatientApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractPatientBasicFlavouredApi<EncryptedPatient>,
) : PatientBasicApi,
	PatientBasicFlavouredApi<EncryptedPatient> by encryptedFlavour,
	PatientBasicFlavourlessApi by PatientBasicFlavourlessApiImpl(rawApi, config) {

	override val inGroup: PatientBasicInGroupApi = object :
		PatientBasicInGroupApi,
		PatientBasicFlavouredInGroupApi<EncryptedPatient> by encryptedFlavour,
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
			doFilterPatientsBy(groupId, filter) { GroupScoped(it, groupId) }

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
		doFilterPatientsBy(null, filter) { it }

	override suspend fun filterPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): PaginatedListIterator<EncryptedPatient> =
		filterPatientsBy(filter)

	private suspend inline fun <T : Any> doFilterPatientsBy(
		groupId: String?,
		filter: BaseFilterOptions<Patient>,
		crossinline mapEntity: (EncryptedPatient) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.doMatchPatientsBy(config = config, groupId = groupId, filter = filter)
		) {
			encryptedFlavour.doGetPatients(groupId, it).map { patient -> mapEntity(patient) }
		}

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
