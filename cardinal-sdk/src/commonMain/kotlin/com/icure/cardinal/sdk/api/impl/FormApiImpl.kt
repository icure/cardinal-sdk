package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.FormBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.FormBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.FormBasicInGroupApi
import com.icure.cardinal.sdk.api.FormBasicApi
import com.icure.cardinal.sdk.api.FormFlavouredInGroupApi
import com.icure.cardinal.sdk.api.FormInGroupApi
import com.icure.cardinal.sdk.api.FormApi
import com.icure.cardinal.sdk.api.FormBasicFlavourlessApi
import com.icure.cardinal.sdk.api.FormBasicFlavouredApi
import com.icure.cardinal.sdk.api.FormFlavouredApi
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapFormFilterOptions
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.FormTemplate
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
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.JsonPatcher
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.decodeFromJsonElement

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): FlavouredApi<EncryptedForm, EncryptedForm> = FlavouredApi.encrypted(
	config = config,
	encryptedSerializer = EncryptedForm.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Form,
	manifest = EntitiesEncryptedFieldsManifests::form
)

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedForm, DecryptedForm> = FlavouredApi.decrypted(
	config = config,
	encryptedSerializer = EncryptedForm.serializer(),
	decryptedSerializer = DecryptedForm.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Form,
	manifest = EntitiesEncryptedFieldsManifests::form,
	patchJson = JsonPatcher::patchForm
)

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): FlavouredApi<EncryptedForm, Form> = FlavouredApi.tryAndRecover(
	config = config,
	encryptedSerializer = EncryptedForm.serializer(),
	decryptedSerializer = DecryptedForm.serializer(),
	type = EntityWithEncryptionMetadataTypeName.Form,
	manifest = EntitiesEncryptedFieldsManifests::form,
	patchJson = JsonPatcher::patchForm
)

@InternalIcureApi
private open class AbstractFormBasicFlavouredApi<E : Form>(
	protected val rawApi: RawFormApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: FlavouredApi<EncryptedForm, E>
) : FormBasicFlavouredApi<E>,
	FormBasicFlavouredInGroupApi<E>,
	FlavouredApi<EncryptedForm, E> by flavour {

	override suspend fun createForm(entity: E): E = doCreateForm(groupId = null, entity = entity)

	override suspend fun createForm(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateForm(groupId = groupId, entity = it)
	}

	private suspend fun doCreateForm(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createForm(encrypted)
		} else {
			rawApi.createFormInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun createForms(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateForms(groupId = null, entities = entities)
	}

	override suspend fun createForms(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreation(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateForms(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doCreateForms(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { forms ->
		val encrypted = validateAndMaybeEncrypt(groupId, forms)
		return if (groupId == null) {
			rawApi.createForms(encrypted)
		} else {
			rawApi.createFormsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun undeleteFormById(id: String, rev: String): E = doUndeleteForm(groupId = null, entityId = id, rev = rev)

	override suspend fun undeleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, it ->
			doUndeleteForm(groupId = groupId, entityId = it.id, rev = it.rev)
		}

	private suspend fun doUndeleteForm(groupId: String?, entityId: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteForm(entityId, rev)
		} else {
			rawApi.undeleteFormInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	override suspend fun undeleteFormsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteForms(groupId = null, entityIds = entityIds)

	override suspend fun undeleteFormsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteForms(groupId = groupId, entityIds = chunk)
		}

	private suspend fun doUndeleteForms(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.undeleteForms(ListOfIdsAndRev(ids))
		} else {
			rawApi.undeleteFormsInGroup(groupId, ListOfIdsAndRev(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyForm(entity: E): E = doModifyForm(groupId = null, entity = entity)

	override suspend fun modifyForm(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyForm(groupId = groupId, entity = it)
	}

	private suspend fun doModifyForm(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyForm(encrypted)
		} else {
			rawApi.modifyFormInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun modifyForms(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyForms(groupId = null, entities = entities)
	}

	override suspend fun modifyForms(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModification(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyForms(groupId = groupId, entities = chunk)
		}
	}

	private suspend fun doModifyForms(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { forms ->
		val encrypted = validateAndMaybeEncrypt(groupId, forms)
		return if (groupId == null) {
			rawApi.modifyForms(encrypted)
		} else {
			rawApi.modifyFormsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	override suspend fun getForm(entityId: String): E? = doGetForm(groupId = null, entityId = entityId)

	override suspend fun getForm(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetForm(groupId = groupId, entityId = entityId)
	}

	protected suspend fun doGetForm(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getForm(entityId)
		} else {
			rawApi.getFormInGroup(groupId, entityId)
		}.successBodyOrNull404()?.let { maybeDecrypt(groupId, it) }

	override suspend fun getForms(entityIds: List<String>): List<E> = doGetForms(groupId = null, entityIds)

	override suspend fun getForms(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetForms(groupId = groupId, entityIds = entityIds)
	}

	suspend fun doGetForms(groupId: String?, entityIds: List<String>) = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getForms(ListOfIds(ids))
		} else {
			rawApi.getFormsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	override suspend fun getLatestFormByUniqueId(uniqueId: String) = rawApi.getFormByUniqueId(uniqueId).successBody().let { maybeDecrypt(null, it) }
}

@InternalIcureApi
private class AbstractFormFlavouredApi<E : Form>(
	rawApi: RawFormApi,
	override val config: ApiConfiguration,
	flavour: FlavouredApi<EncryptedForm, E>,
) : AbstractFormBasicFlavouredApi<E>(rawApi, config, flavour),
	FormFlavouredApi<E>,
	FormFlavouredInGroupApi<E> {

	override suspend fun shareWith(
		delegateId: String,
		form: E,
		options: FormShareOptions?,
	): E =
		shareWithMany(form, mapOf(delegateId to (options ?: FormShareOptions())))

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		form: GroupScoped<E>,
		options: FormShareOptions?
	): GroupScoped<E> =
		shareWithMany(form, mapOf(delegate to (options ?: FormShareOptions())))

	override suspend fun shareWithMany(form: E, delegates: Map<String, FormShareOptions>): E =
		doShareWithMany(groupId = null, form, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun shareWithMany(
		form: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, FormShareOptions>
	): GroupScoped<E> =
		GroupScoped(doShareWithMany(form.groupId, form.entity, delegates), form.groupId)

	private suspend fun doShareWithMany(
		groupId: String?,
		form: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, FormShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			form,
			EntityWithEncryptionMetadataTypeName.Form,
			delegates,
			true,
			{ doGetForm(groupId, it) ?: throw NotFoundException("Form $it not found") },
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

	override suspend fun filterFormsBySorted(filter: SortableFilterOptions<Form>): PaginatedListIterator<E> =
		filterFormsBy(filter)

	override suspend fun filterFormsBy(filter: FilterOptions<Form>): PaginatedListIterator<E> =
		doFilterFormsBy(
			null,
			filter
		) { it }

	override suspend fun filterFormsBySorted(
		groupId: String,
		filter: SortableFilterOptions<Form>
	): PaginatedListIterator<GroupScoped<E>> =
		filterFormsBy(groupId, filter)

	override suspend fun filterFormsBy(
		groupId: String,
		filter: FilterOptions<Form>
	): PaginatedListIterator<GroupScoped<E>> =
		doFilterFormsBy(
			groupId,
			filter
		) { GroupScoped(it, groupId) }

	private suspend inline fun <T : Any> doFilterFormsBy(
		groupId: String?,
		filter: FilterOptions<Form>,
		crossinline mapEntity: (E) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.matchFormsBy(
				mapFormFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody(),
		) {
			doGetForms(groupId, it).map { form -> mapEntity(form) }
		}
}

@InternalIcureApi
private abstract class AbstractFormBasicFlavourless(
	protected val rawApi: RawFormApi
) {

	protected suspend fun doDeleteForm(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteForm(entityId, rev)
		} else {
			rawApi.deleteFormInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteForms(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteFormsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteFormsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeForm(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeForm(entityId, rev)
		} else {
			rawApi.purgeFormInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeForms(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeForms(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeFormsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}
}

@InternalIcureApi
private class FormBasicFlavourlessApiImpl(rawApi: RawFormApi) : AbstractFormBasicFlavourless(rawApi), FormBasicFlavourlessApi {

	override suspend fun deleteFormById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteForm(groupId = null, entityId, rev)

	override suspend fun deleteFormsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteForms(groupId = null, entityIds)

	override suspend fun purgeFormById(id: String, rev: String) {
		doPurgeForm(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeFormsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeForms(groupId = null, entityIds = entityIds)

	override suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean?,
	) = rawApi.getFormTemplate(formTemplateId, raw).successBody()

	override suspend fun createFormTemplate(
		formTemplate: FormTemplate,
	) = rawApi.createFormTemplate(formTemplate).successBody()

	override suspend fun deleteFormTemplate(
		formTemplateId: String,
	) = rawApi.deleteFormTemplate(formTemplateId).successBody()

	override suspend fun updateFormTemplate(
		formTemplate: FormTemplate,
	) = rawApi.updateFormTemplate(formTemplate.id, formTemplate).successBody()

	override suspend fun setTemplateAttachment(
		formTemplateId: String,
		payload: ByteArray,
	) = rawApi.setTemplateAttachment(formTemplateId, payload).successBody()
}

@InternalIcureApi
private class FormBasicFlavourlessInGroupApiImpl(rawApi: RawFormApi) : AbstractFormBasicFlavourless(rawApi), FormBasicFlavourlessInGroupApi {
	override suspend fun deleteFormById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		GroupScoped(doDeleteForm(entityId.groupId, entityId.entity.id, entityId.entity.rev), entityId.groupId)

	override suspend fun deleteFormsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteForms(groupId, entities)
		}

	override suspend fun purgeFormById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeForm(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeFormsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeForms(groupId, batch)
		}
}

@InternalIcureApi
internal fun initFormApi(
	rawApi: RawFormApi,
	config: ApiConfiguration
): FormApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	val decryptedApi = AbstractFormFlavouredApi(rawApi, config, decryptedFlavour)
	val encryptedApi = AbstractFormFlavouredApi(rawApi, config, encryptedFlavour)
	val tryAndRecoverApi = AbstractFormFlavouredApi(rawApi, config, tryAndRecoverFlavour)
	return FormApiImpl(
		rawApi,
		config,
		encryptedApi,
		decryptedApi,
		tryAndRecoverApi
	)
}

@InternalIcureApi
private class FormApiImpl(
	private val rawApi: RawFormApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: AbstractFormFlavouredApi<EncryptedForm>,
	private val decryptedFlavour: AbstractFormFlavouredApi<DecryptedForm>,
	private val tryAndRecoverFlavour: AbstractFormFlavouredApi<Form>
) : FormApi,
	FormBasicFlavourlessApi by FormBasicFlavourlessApiImpl(rawApi),
	FormFlavouredApi<DecryptedForm> by decryptedFlavour {

	private val crypto get() = config.crypto

	override val encrypted: FormFlavouredApi<EncryptedForm> = encryptedFlavour

	override val tryAndRecover: FormFlavouredApi<Form> = tryAndRecoverFlavour

	override val inGroup: FormInGroupApi = object : FormInGroupApi,
		FormBasicFlavourlessInGroupApi by FormBasicFlavourlessInGroupApiImpl(rawApi),
		FormFlavouredInGroupApi<DecryptedForm> by decryptedFlavour {
		override val encrypted: FormFlavouredInGroupApi<EncryptedForm> = encryptedFlavour
		override val tryAndRecover: FormFlavouredInGroupApi<Form> = tryAndRecoverFlavour

		override suspend fun decrypt(forms: List<GroupScoped<EncryptedForm>>): List<GroupScoped<DecryptedForm>> =
			forms.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(forms: List<GroupScoped<EncryptedForm>>): List<GroupScoped<Form>> =
			forms.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedForm?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel",
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?,
		): GroupScoped<DecryptedForm> =
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

		override suspend fun decryptPatientIdOf(form: GroupScoped<Form>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(form.groupId, form.entity).mapNullGroupTo(form.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Form>,
			delegates: Set<EntityReferenceInGroup>,
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun getEncryptionKeysOf(form: GroupScoped<Form>): Set<HexString> =
			doGetEncryptionKeysOf(form.groupId, form.entity)

		override suspend fun hasWriteAccess(form: GroupScoped<Form>): Boolean =
			doHasWriteAccess(form.groupId, form.entity)

		override suspend fun matchFormsBy(groupId: String, filter: FilterOptions<Form>): List<String> =
			doMatchFormsBy(groupId, filter)

		override suspend fun matchFormsBySorted(
			groupId: String,
			filter: SortableFilterOptions<Form>,
		): List<String> = doMatchFormsBySorted(groupId, filter)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedForm?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	): DecryptedForm = doWithEncryptionMetadata(
		entityGroupId = null,
		base = base,
		patientInGroup = patient to null,
		user = user,
		delegates = delegates.keyAsLocalDataOwnerReferences(),
		secretId = secretId,
		alternateRootDataOwnerReference = alternateRootDelegateId?.let { EntityReferenceInGroup(it, null) }
	)

	private suspend fun doWithEncryptionMetadata(
		entityGroupId: String?,
		base: DecryptedForm?,
		patientInGroup: Pair<Patient, String?>?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?
	): DecryptedForm =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedForm(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
			),
			entityType = EntityWithEncryptionMetadataTypeName.Form,
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

	override suspend fun getEncryptionKeysOf(form: Form): Set<HexString> = doGetEncryptionKeysOf(groupId = null, form = form)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, form: Form): Set<HexString> =
		config.crypto.entity.encryptionKeysOf(
			entityGroupId = groupId,
			entity = form,
			entityType = EntityWithEncryptionMetadataTypeName.Form,
			dataOwnerId = null
		)

	override suspend fun hasWriteAccess(form: Form): Boolean = doHasWriteAccess(groupId = null, form = form)

	private suspend fun doHasWriteAccess(groupId: String?, form: Form): Boolean =
		config.crypto.entity.hasWriteAccess(entityGroupId = groupId, entity = form, entityType =  EntityWithEncryptionMetadataTypeName.Form)

	override suspend fun decryptPatientIdOf(form: Form): Set<EntityReferenceInGroup> = doDecryptPatientIdOf(groupId = null, form = form)

	private suspend fun doDecryptPatientIdOf(groupId: String?, form: Form): Set<EntityReferenceInGroup> =
		config.crypto.entity.owningEntityIdsOf(
			entityGroupId = groupId,
			entity = form,
			entityType = EntityWithEncryptionMetadataTypeName.Form,
			dataOwnerId = null
		).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Form, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity = entity, delegates = delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Form, delegates: Set<EntityReferenceInGroup>) {
		config.crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			entityGroupId = groupId,
			entity = entity,
			entityType = EntityWithEncryptionMetadataTypeName.Form,
			shareWithDataOwners = delegates
		)
	}

	override suspend fun decrypt(form: EncryptedForm): DecryptedForm =
		config.crypto.entity.decryptEntities(
			null,
			listOf(form),
			EntityWithEncryptionMetadataTypeName.Form,
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }.single()

	override suspend fun tryDecrypt(form: EncryptedForm): Form =
		config.crypto.entity.tryDecryptEntities(
			null,
			listOf(form),
			EntityWithEncryptionMetadataTypeName.Form,
			EncryptedForm.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedForm>(config.jsonPatcher.patchForm(it)) }.single()

	override suspend fun matchFormsBy(filter: FilterOptions<Form>): List<String> = doMatchFormsBy(groupId = null, filter = filter)

	override suspend fun matchFormsBySorted(filter: SortableFilterOptions<Form>): List<String> =
		doMatchFormsBySorted(groupId = null, filter = filter)

	private suspend fun doMatchFormsBy(groupId: String?, filter: FilterOptions<Form>): List<String> =
		if (groupId == null) {
			rawApi.matchFormsBy(
				mapFormFilterOptions(
					filter,
					config,
					groupId
				)
			)
		} else {
			rawApi.matchFormsInGroupBy(
				groupId = groupId,
				filter = mapFormFilterOptions(
					filter,
					config,
					groupId
				)
			)
		}.successBody()

	private suspend fun doMatchFormsBySorted(groupId: String?, filter: FilterOptions<Form>): List<String> = doMatchFormsBy(groupId, filter)
}

@InternalIcureApi
internal fun initFormBasicApi(
	rawApi: RawFormApi,
	config: BasicApiConfiguration
): FormBasicApi = FormBasicApiImpl(
	rawApi,
	config,
	AbstractFormBasicFlavouredApi(rawApi, config, encryptedApiFlavour(config))
)


@InternalIcureApi
private class FormBasicApiImpl(
	private val rawApi: RawFormApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: AbstractFormBasicFlavouredApi<EncryptedForm>,
) : FormBasicApi,
	FormBasicFlavouredApi<EncryptedForm> by encryptedFlavour,
	FormBasicFlavourlessApi by FormBasicFlavourlessApiImpl(rawApi) {
	override val inGroup: FormBasicInGroupApi = object : FormBasicInGroupApi,
		FormBasicFlavourlessInGroupApi by FormBasicFlavourlessInGroupApiImpl(rawApi),
		FormBasicFlavouredInGroupApi<EncryptedForm> by encryptedFlavour {

		override suspend fun matchFormsBy(
			groupId: String,
			filter: BaseFilterOptions<Form>
		): List<String> =
			doMatchFormsBy(groupId, filter)

		override suspend fun matchFormsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Form>
		): List<String> =
			matchFormsBy(groupId, filter)

		override suspend fun filterFormsBy(
			groupId: String,
			filter: BaseFilterOptions<Form>
		): PaginatedListIterator<GroupScoped<EncryptedForm>> =
			doFilterFormsBy(groupId, filter) { GroupScoped(it, groupId) }

		override suspend fun filterFormsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Form>
		): PaginatedListIterator<GroupScoped<EncryptedForm>> =
			filterFormsBy(groupId, filter)
	}

	override suspend fun matchFormsBy(filter: BaseFilterOptions<Form>): List<String> =
		doMatchFormsBy(null, filter)

	override suspend fun matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): List<String> =
		matchFormsBy(filter)

	override suspend fun filterFormsBy(filter: BaseFilterOptions<Form>): PaginatedListIterator<EncryptedForm> =
		doFilterFormsBy(null, filter) { it }

	override suspend fun filterFormsBySorted(filter: BaseSortableFilterOptions<Form>): PaginatedListIterator<EncryptedForm> =
		filterFormsBy(filter)

	private suspend fun doMatchFormsBy(groupId: String?, filter: BaseFilterOptions<Form>): List<String> =
		if (groupId == null) {
			rawApi.matchFormsBy(
				mapFormFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchFormsInGroupBy(
				groupId = groupId,
				filter = mapFormFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend inline fun <T : Any> doFilterFormsBy(
		groupId: String?,
		filter: BaseFilterOptions<Form>,
		crossinline mapEntity: (EncryptedForm) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			doMatchFormsBy(groupId, filter),
		) {
			encryptedFlavour.doGetForms(groupId, it).map { calendarItem -> mapEntity(calendarItem) }
		}
}
