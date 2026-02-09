package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ContactBasicApi
import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.api.ContactBasicFlavouredInGroupApi
import com.icure.cardinal.sdk.api.ContactBasicFlavourlessApi
import com.icure.cardinal.sdk.api.ContactBasicFlavourlessInGroupApi
import com.icure.cardinal.sdk.api.ContactFlavouredInGroupApi
import com.icure.cardinal.sdk.api.ContactBasicFlavouredApi
import com.icure.cardinal.sdk.api.ContactBasicInGroupApi
import com.icure.cardinal.sdk.api.ContactFlavouredApi
import com.icure.cardinal.sdk.api.ContactInGroupApi
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.crypto.decrypt
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.OwningEntityDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.exceptions.NotFoundException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.filters.mapContactFilterOptions
import com.icure.cardinal.sdk.filters.mapServiceFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.data.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.extensions.autoDelegationsFor
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.currentFuzzyDateTime
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

private fun Service.hasOnlyCompoundContent() =
	content.values.all {
		it.isCompound()
	}

@InternalIcureApi
private suspend fun DecryptedService.encrypt(
	config: ApiConfiguration,
	contactKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
): EncryptedService =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceBase
		).let {
			Serialization.json.decodeFromJsonElement<EncryptedService>(it)
		}.copy(
			content = content.mapValues { (_, compoundContent) ->
				EncryptedContent(
					compoundValue = ensureNonNull(compoundContent.compoundValue) {
						"Compound value can't be null on a only-compound compound content"
					}.map {
						it.encrypt(config, contactKey)
					}
				)
			}
		)
	} else {
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceWithContent
		).let {
			Serialization.json.decodeFromJsonElement(it)
		}
	}


@InternalIcureApi
private fun EncryptedService.requiresEncryption(
	config: BasicApiConfiguration
): Boolean =
	if (this.hasOnlyCompoundContent()) {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceBase
		) || content.values.any { compoundContent ->
			ensureNonNull(compoundContent.compoundValue) {
				"Compound value can't be null on a only-compound compound content"
			}.any {
				it.requiresEncryption(config)
			}
		}
	} else {
		config.crypto.jsonEncryption.requiresEncryption(
			Serialization.json.encodeToJsonElement(this).jsonObject,
			config.encryption.serviceWithContent
		)
	}

@InternalIcureApi
private suspend fun encryptContacts(
	config: ApiConfiguration,
	entitiesGroupId: String?,
	contacts: List<DecryptedContact>
): List<EncryptedContact> {
	val keysById = config.crypto.entity.tryDecryptAndImportAnyEncryptionKey(
		entitiesGroupId,
		contacts,
		EntityWithEncryptionMetadataTypeName.Contact
	)
	if (!contacts.all { keysById.containsKey(it.id) }) throw EntityEncryptionException(
		"No encryption key found for Contacts ${contacts.filter { !keysById.containsKey(it.id) }.map { it.id }}"
	)
	return contacts.map { contact ->
		val contactKey = keysById.getValue(contact.id).key
		config.crypto.jsonEncryption.encrypt(
			contactKey,
			Serialization.json.encodeToJsonElement(contact).jsonObject,
			config.encryption.contact
		).let {
			Serialization.json.decodeFromJsonElement<EncryptedContact>(it)
		}.copy(
			services = contact.services.map {
				it.encrypt(config, contactKey)
			}.toSet(),
		)
	}
}

@InternalIcureApi
private suspend fun validateEncryptedContacts(
	config: BasicApiConfiguration,
	contacts: List<EncryptedContact>
) {
	config.crypto.validationService.validateEncryptedEntities(
		contacts,
		EntityWithEncryptionMetadataTypeName.Contact,
		EncryptedContact.serializer(),
		config.encryption.contact
	)
	contacts.forEach { contact ->
		contact.services.forEach {
			if (it.requiresEncryption(config)) {
				throw EntityEncryptionException("Service ${it.id} in contact ${contact.id} is not properly encrypted according to the manifest")
			}
		}
	}
}

@InternalIcureApi
internal fun Service.asIcureStub(): IcureStub {
	ensure(this.delegations.isNotEmpty() || !this.securityMetadata?.secureDelegations.isNullOrEmpty()) { "The service must be include the encryption metadata to use this method. The Service gets populated with encryption metadata when it is obtained through one of the getServices, or filterServices method." }
	return IcureStub(
		id = id,
		rev = null,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		secretForeignKeys = secretForeignKeys ?: emptySet(),
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		securityMetadata = securityMetadata,
	)
}

@InternalIcureApi
private suspend fun tryDecryptServices(
	config: ApiConfiguration,
	servicesGroupId: String?,
	services: List<EncryptedService>,
	requireAllSuccess: Boolean
): Map<String, DecryptedService> {
	val servicesById = services.associateBy { it.id }
	val results = config.crypto.incrementalSecurityMetadataDecryptor.doManyIncrementallyDecryptingKeys(
		servicesGroupId,
		services.map { it.asIcureStub() },
		EntityWithEncryptionMetadataTypeName.Contact,
	) { serviceStub, _, keys ->
		runCatching {
			Serialization.json.decodeFromJsonElement<DecryptedService>(
				config.jsonPatcher.patchIndividualService(
					config.crypto.jsonEncryption.decrypt(
						keys,
						Serialization.json.encodeToJsonElement(servicesById.getValue(serviceStub.id)).jsonObject
					)
				)
			)
		}
	}
	return if (requireAllSuccess) {
		if (results.size != services.size) throw EntityEncryptionException(
			"No encryption key found for Services ${services.filter { !results.containsKey(it.id) }.map { it.id }}"
		)
		results.mapValues { it.value.getOrThrow() }
	} else {
		results.mapNotNull { (k, v) -> v.getOrNull()?.let { k to it } }.toMap()
	}
}

internal interface ContactExtendedFlavouredApi<E : HasEncryptionMetadata, S : Service> : FlavouredApi<EncryptedContact, E> {
	suspend fun maybeDecryptServices(entitiesGroupId: String?, entities: List<EncryptedService>): List<S>
}

@InternalIcureApi
private fun decryptedApiFlavour(
	config: ApiConfiguration
): ContactExtendedFlavouredApi<DecryptedContact, DecryptedService> = object : ContactExtendedFlavouredApi<DecryptedContact, DecryptedService> {
	override suspend fun maybeDecryptServices(
		entitiesGroupId: String?,
		entities: List<EncryptedService>,
	): List<DecryptedService> {
		val successfullyDecrypted = tryDecryptServices(
			config,
			entitiesGroupId,
			entities,
			requireAllSuccess = true
		)
		return entities.map { successfullyDecrypted.getValue(it.id) }
	}

	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<DecryptedContact>,
	): List<EncryptedContact> = encryptContacts(config, entitiesGroupId, entities)

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>,
	): List<DecryptedContact> = config.crypto.entity.decryptEntities(
		entitiesGroupId,
		entities,
		EntityWithEncryptionMetadataTypeName.Contact,
		EncryptedContact.serializer(),
	) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }

}

@InternalIcureApi
private fun encryptedApiFlavour(
	config: BasicApiConfiguration
): ContactExtendedFlavouredApi<EncryptedContact, EncryptedService> = object : ContactExtendedFlavouredApi<EncryptedContact, EncryptedService> {
	override suspend fun maybeDecryptServices(
		entitiesGroupId: String?,
		entities: List<EncryptedService>,
	): List<EncryptedService> = entities

	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>,
	): List<EncryptedContact> = entities.also {
		validateEncryptedContacts(
			config,
			it
		)
	}

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>,
	): List<EncryptedContact> = entities

}

@InternalIcureApi
private fun tryAndRecoverApiFlavour(
	config: ApiConfiguration
): ContactExtendedFlavouredApi<Contact, Service> = object : ContactExtendedFlavouredApi<Contact, Service> {
	override suspend fun maybeDecryptServices(
		entitiesGroupId: String?,
		entities: List<EncryptedService>
	): List<Service> {
		val successfullyDecrypted = tryDecryptServices(
			config,
			entitiesGroupId,
			entities,
			requireAllSuccess = false
		)
		return entities.map { successfullyDecrypted[it.id] ?: it }
	}

	override suspend fun maybeDecrypt(
		entitiesGroupId: String?,
		entities: List<EncryptedContact>
	): List<Contact> =
		config.crypto.entity.tryDecryptEntities(
			entitiesGroupId,
			entities,
			EntityWithEncryptionMetadataTypeName.Contact,
			EncryptedContact.serializer(),
		) { Serialization.json.decodeFromJsonElement<DecryptedContact>(config.jsonPatcher.patchContact(it)) }

	override suspend fun validateAndMaybeEncrypt(
		entitiesGroupId: String?,
		entities: List<Contact>
	): List<EncryptedContact> =
		validateOrEncryptEntities<Contact, EncryptedContact, DecryptedContact>(
			entities,
			{ encryptContacts(config, entitiesGroupId, it) },
			{ validateEncryptedContacts(config, it) }
		)

}

@InternalIcureApi
private abstract class AbstractContactBasicFlavouredApi<E : Contact, S : Service>(
	protected val rawApi: RawContactApi,
	protected open val config: BasicApiConfiguration,
	protected val flavour: ContactExtendedFlavouredApi<E, S>
) : ContactExtendedFlavouredApi<E, S> by flavour {

	protected suspend fun doCreateContact(groupId: String?, entity: E): E {
		requireIsValidForCreation(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.createContact(encrypted)
		} else {
			rawApi.createContactInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doCreateContacts(groupId: String?, entities: List<E>): List<E> = skipRequestOnEmptyList(entities) { contacts ->
		val encrypted = validateAndMaybeEncrypt(groupId, contacts)
		if (groupId == null) {
			rawApi.createContacts(encrypted)
		} else {
			rawApi.createContactsInGroup(groupId, encrypted)
		}.successBody().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doUndeleteContact(groupId: String?, id: String, rev: String): E =
		if (groupId == null) {
			rawApi.undeleteContact(id, rev)
		} else {
			rawApi.undeleteContactInGroup(groupId = groupId, contactId = id, rev = rev)
		}.successBodyOrThrowRevisionConflict().let { maybeDecrypt(groupId, it) }

	protected suspend fun doUndeleteContacts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<E> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteContacts(ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteContactsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().let { maybeDecrypt(entitiesGroupId = groupId, entities = it) }
		}

	protected suspend fun doModifyContact(groupId: String?, entity: E): E {
		requireIsValidForModification(entity)
		val encrypted = validateAndMaybeEncrypt(groupId, entity)
		return if (groupId == null) {
			rawApi.modifyContact(encrypted)
		} else {
			rawApi.modifyContactInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doModifyContacts(
		groupId: String?,
		entities: List<E>
	): List<E> = skipRequestOnEmptyList(entities) { contacts ->
		val encrypted = validateAndMaybeEncrypt(groupId, contacts)
		return if (groupId == null) {
			rawApi.modifyContacts(encrypted)
		} else {
			rawApi.modifyContactsInGroup(groupId, encrypted)
		}.successBodyOrThrowRevisionConflict().let {
			maybeDecrypt(groupId, it)
		}
	}

	protected suspend fun doGetContact(groupId: String?, entityId: String): E? =
		if (groupId == null) {
			rawApi.getContact(entityId)
		} else {
			rawApi.getContactInGroup(groupId = groupId, contactId = entityId)
		}.successBodyOrNull404()?.let {
			maybeDecrypt(groupId, it)
		}

	suspend fun doGetContacts(groupId: String?, entityIds: List<String>): List<E> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getContacts(ListOfIds(ids))
		} else {
			rawApi.getContactsInGroup(groupId, ListOfIds(ids))
		}.successBody().let { maybeDecrypt(groupId, it) }
	}

	protected suspend fun doGetService(groupId: String?, entityId: String): S? =
		if (groupId == null) {
			rawApi.getService(entityId)
		} else {
			rawApi.getServiceInGroup(groupId = groupId, serviceId = entityId)
		}.successBodyOrNull404()?.let {
			maybeDecryptServices(groupId, listOf(it)).single()
		}

	protected suspend fun doGetServices(groupId: String?, entityIds: List<String>): List<S> = skipRequestOnEmptyList(entityIds) { ids ->
		if (groupId == null) {
			rawApi.getServices(ListOfIds(ids))
		} else {
			rawApi.getServicesInGroup(groupId = groupId, ListOfIds(ids))
		}.successBody().let {
			maybeDecryptServices(groupId, it)
		}
	}
}

@InternalIcureApi
private class ContactBasicFlavouredApiImpl<E : Contact, S : Service>(
	rawApi: RawContactApi,
	config: BasicApiConfiguration,
	flavour: ContactExtendedFlavouredApi<E, S>
) : ContactBasicFlavouredApi<E, S>, AbstractContactBasicFlavouredApi<E, S>(rawApi, config, flavour) {

	override suspend fun createContact(entity: E): E = doCreateContact(groupId = null, entity = entity)

	override suspend fun createContacts(entities: List<E>): List<E> {
		requireIsValidForCreation(entities)
		return doCreateContacts(groupId = null, entities = entities)
	}

	override suspend fun undeleteContactById(id: String, rev: String): E = doUndeleteContact(groupId = null, id = id, rev = rev)

	override suspend fun undeleteContactsByIds(entityIds: List<StoredDocumentIdentifier>): List<E> =
		doUndeleteContacts(groupId = null, entityIds = entityIds)

	override suspend fun modifyContact(entity: E): E = doModifyContact(groupId = null, entity = entity)

	override suspend fun modifyContacts(entities: List<E>): List<E> {
		requireIsValidForModification(entities)
		return doModifyContacts(groupId = null, entities = entities)
	}

	override suspend fun getContact(entityId: String): E? = doGetContact(groupId = null, entityId = entityId)

	override suspend fun getContacts(entityIds: List<String>): List<E> = doGetContacts(groupId = null, entityIds = entityIds)

	override suspend fun getService(serviceId: String): S? = doGetService(groupId = null, entityId = serviceId)

	override suspend fun getServices(entityIds: List<String>): List<S> = doGetServices(groupId = null, entityIds = entityIds)
}

@InternalIcureApi
private class ContactBasicFlavouredInGroupApiImpl<E : Contact, S : Service>(
	rawApi: RawContactApi,
	config: BasicApiConfiguration,
	flavour: ContactExtendedFlavouredApi<E, S>
) : ContactBasicFlavouredInGroupApi<E, S>, AbstractContactBasicFlavouredApi<E, S>(rawApi, config, flavour) {

	override suspend fun createContact(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doCreateContact(groupId = groupId, entity = it)
	}

	override suspend fun createContacts(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForCreationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doCreateContacts(groupId = groupId, entities = entities)
		}
	}

	override suspend fun undeleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<E> =
		groupScopedWith(entityId) { groupId, entity ->
			doUndeleteContact(groupId = groupId, id = entity.id, rev = entity.rev)
		}

	override suspend fun undeleteContactsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<E>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteContacts(groupId = groupId, entityIds = chunk)
		}

	override suspend fun modifyContact(entity: GroupScoped<E>): GroupScoped<E> = groupScopedWith(entity) { groupId, it ->
		doModifyContact(groupId = groupId, entity = it)
	}

	override suspend fun modifyContacts(entities: List<GroupScoped<E>>): List<GroupScoped<E>> {
		requireIsValidForModificationInGroup(entities)
		return entities.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyContacts(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getContact(groupId: String, entityId: String): GroupScoped<E>? = groupScopedIn(groupId) {
		doGetContact(groupId = groupId, entityId = entityId)
	}

	override suspend fun getContacts(groupId: String, entityIds: List<String>): List<GroupScoped<E>> = groupScopedListIn(groupId) {
		doGetContacts(groupId = groupId, entityIds = entityIds)
	}

	override suspend fun getService(groupId: String, serviceId: String): GroupScoped<S>? = groupScopedIn(groupId) {
		doGetService(groupId = groupId, entityId = serviceId)
	}

	override suspend fun getServices(groupId: String, entityIds: List<String>): List<GroupScoped<S>> = groupScopedListIn(groupId) {
		doGetServices(groupId = groupId, entityIds = entityIds)
	}
}

@InternalIcureApi
private abstract class AbstractContactFlavouredApi<E : Contact, S : Service>(
	rawApi: RawContactApi,
	override val config: ApiConfiguration,
	flavour: ContactExtendedFlavouredApi<E, S>
) : AbstractContactBasicFlavouredApi<E, S>(rawApi, config, flavour) {

	protected suspend fun doShareWithMany(
		groupId: String?,
		contact: E,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, ContactShareOptions>
	): E =
		config.crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			groupId,
			contact,
			EntityWithEncryptionMetadataTypeName.Contact,
			delegates,
			true,
			{ doGetContact(groupId, it) ?: throw NotFoundException("Contact $it not found") },
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

	protected suspend inline fun <T : Any> doFilterContactsBy(
		groupId: String?,
		filter: FilterOptions<Contact>,
		crossinline mapEntity: (E) -> T
	): PaginatedListIterator<T> =
		IdsPageIterator(
			rawApi.matchContactsBy(
				mapContactFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody(),
		) {
			doGetContacts(groupId, it).map { contact -> mapEntity(contact) }
		}
}

@InternalIcureApi
private  class ContactFlavouredApiImpl<E : Contact, S : Service>(
	rawApi: RawContactApi,
	config: ApiConfiguration,
	flavour: ContactExtendedFlavouredApi<E, S>
) : ContactFlavouredApi<E, S>,
	ContactBasicFlavouredApi<E, S> by ContactBasicFlavouredApiImpl(rawApi, config, flavour),
	AbstractContactFlavouredApi<E, S>(rawApi, config, flavour) {

	override suspend fun shareWith(
		delegateId: String,
		contact: E,
		options: ContactShareOptions?,
	): E =
		shareWithMany(contact, mapOf(delegateId to (options ?: ContactShareOptions())))

	override suspend fun shareWithMany(contact: E, delegates: Map<String, ContactShareOptions>): E =
		doShareWithMany(groupId = null, contact, delegates.keyAsLocalDataOwnerReferences())

	override suspend fun filterContactsBy(filter: FilterOptions<Contact>): PaginatedListIterator<E> =
		doFilterContactsBy(groupId = null, filter = filter) { it }

	override suspend fun filterContactsBySorted(filter: SortableFilterOptions<Contact>): PaginatedListIterator<E> =
		filterContactsBy(filter)

	override suspend fun filterServicesBy(filter: FilterOptions<Service>): PaginatedListIterator<S> =
		IdsPageIterator(
			rawApi.matchServicesBy(
				mapServiceFilterOptions(
					filterOptions = filter,
					config = config,
					requestGroup = null
				)
			).successBody(),
			this::getServices
		)

	override suspend fun filterServicesBySorted(filter: SortableFilterOptions<Service>): PaginatedListIterator<S> =
		filterServicesBy(filter)
}

@InternalIcureApi
private  class ContactFlavouredInGroupApiImpl<E : Contact, S : Service>(
	rawApi: RawContactApi,
	config: ApiConfiguration,
	flavour: ContactExtendedFlavouredApi<E, S>
) : ContactFlavouredInGroupApi<E, S>,
	ContactBasicFlavouredInGroupApi<E, S> by ContactBasicFlavouredInGroupApiImpl(rawApi, config, flavour),
	AbstractContactFlavouredApi<E, S>(rawApi, config, flavour) {

	override suspend fun shareWith(
		delegate: EntityReferenceInGroup,
		contact: GroupScoped<E>,
		options: ContactShareOptions?
	): GroupScoped<E> =
		shareWithMany(contact, mapOf(delegate to (options ?: ContactShareOptions())))

	override suspend fun shareWithMany(
		contact: GroupScoped<E>,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "shareOptions") Map<EntityReferenceInGroup, ContactShareOptions>
	): GroupScoped<E> = groupScopedWith(contact) { groupId, entity ->
		doShareWithMany(groupId = groupId, contact = entity, delegates = delegates)
	}

	override suspend fun filterContactsBy(groupId: String, filter: FilterOptions<Contact>): PaginatedListIterator<GroupScoped<E>> =
		doFilterContactsBy(groupId = null, filter = filter) { GroupScoped(entity = it, groupId = groupId) }

	override suspend fun filterContactsBySorted(
		groupId: String,
		filter: SortableFilterOptions<Contact>
	): PaginatedListIterator<GroupScoped<E>> = filterContactsBy(groupId, filter)
}

@InternalIcureApi
private abstract class AbstractContactBasicFlavourless(
	protected val rawApi: RawContactApi,
) {

	protected suspend fun doDeleteContact(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteContact(entityId, rev)
		} else {
			rawApi.deleteContactInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteContacts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteContactsWithRev(ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteContactsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

	protected suspend fun doPurgeContact(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeContact(entityId, rev)
		} else {
			rawApi.purgeContactInGroup(groupId, entityId, rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeContacts(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeContacts(ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeContactsInGroup(groupId, ListOfIdsAndRev(ids))
			}.successBody().toStoredDocumentIdentifier()
		}

}

@InternalIcureApi
private class ContactBasicFlavourlessApiImpl(rawApi: RawContactApi) : AbstractContactBasicFlavourless(rawApi), ContactBasicFlavourlessApi {

	override suspend fun deleteContactById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteContact(groupId = null, entityId, rev)

	override suspend fun deleteContactsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteContacts(groupId = null, entityIds)

	override suspend fun purgeContactById(id: String, rev: String) {
		doPurgeContact(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeContactsByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeContacts(groupId = null, entityIds = entityIds)

	override suspend fun getServiceCodesOccurrences(codeType: String, minOccurrences: Long): List<LabelledOccurence> {
		return rawApi.getServiceCodesOccurrences(codeType, minOccurrences).successBody()
	}
}

@InternalIcureApi
private class ContactBasicFlavourlessInGroupApiImpl(
	rawApi: RawContactApi
) : AbstractContactBasicFlavourless(rawApi), ContactBasicFlavourlessInGroupApi {
	override suspend fun deleteContactById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(entityId) { groupId, entity ->
			doDeleteContact(groupId = groupId, entityId = entity.id, rev = entity.rev)
		}

	override suspend fun deleteContactsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			doDeleteContacts(groupId, entities)
		}

	override suspend fun purgeContactById(entityId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeContact(groupId = entityId.groupId, entityId = entityId.entity.id, rev = entityId.entity.rev)
	}

	override suspend fun purgeContactsByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, batch ->
			doPurgeContacts(groupId, batch)
		}
}

@InternalIcureApi
internal fun initContactApi(
	rawApi: RawContactApi,
	config: ApiConfiguration
): ContactApi {
	val decryptedFlavour = decryptedApiFlavour(config)
	val encryptedFlavour = encryptedApiFlavour(config)
	val tryAndRecoverFlavour = tryAndRecoverApiFlavour(config)
	return ContactApiImpl(
		rawApi,
		config,
		encryptedFlavour,
		decryptedFlavour,
		tryAndRecoverFlavour
	)
}

@InternalIcureApi
private class ContactApiImpl(
	private val rawApi: RawContactApi,
	private val config: ApiConfiguration,
	private val encryptedFlavour: ContactExtendedFlavouredApi<EncryptedContact, EncryptedService>,
	private val decryptedFlavour: ContactExtendedFlavouredApi<DecryptedContact, DecryptedService>,
	private val tryAndRecoverFlavour: ContactExtendedFlavouredApi<Contact, Service>
) : ContactApi,
	ContactBasicFlavourlessApi by ContactBasicFlavourlessApiImpl(rawApi),
	ContactFlavouredApi<DecryptedContact, DecryptedService> by ContactFlavouredApiImpl(rawApi, config, decryptedFlavour) {
	private val crypto get() = config.crypto

	override val encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService> = ContactFlavouredApiImpl(rawApi, config, encryptedFlavour)
	override val tryAndRecover: ContactFlavouredApi<Contact, Service> = ContactFlavouredApiImpl(rawApi, config, tryAndRecoverFlavour)

	override val inGroup: ContactInGroupApi = object: ContactInGroupApi,
		ContactBasicFlavourlessInGroupApi by ContactBasicFlavourlessInGroupApiImpl(rawApi),
		ContactFlavouredInGroupApi<DecryptedContact, DecryptedService> by ContactFlavouredInGroupApiImpl(rawApi, config, decryptedFlavour) {
		override val encrypted: ContactFlavouredInGroupApi<EncryptedContact, EncryptedService> =
			ContactFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour)
		override val tryAndRecover: ContactFlavouredInGroupApi<Contact, Service> =
			ContactFlavouredInGroupApiImpl(rawApi, config, tryAndRecoverFlavour)

		override suspend fun decrypt(contacts: List<GroupScoped<EncryptedContact>>): List<GroupScoped<DecryptedContact>> =
			contacts.mapExactlyChunkedByGroup { groupId, entities ->
				decryptedFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun tryDecrypt(contacts: List<GroupScoped<EncryptedContact>>): List<GroupScoped<Contact>> =
			contacts.mapExactlyChunkedByGroup { groupId, entities ->
				tryAndRecoverFlavour.maybeDecrypt(groupId, entities)
			}

		override suspend fun decryptService(service: GroupScoped<EncryptedService>): GroupScoped<DecryptedService> =
			groupScopedWith(service) { groupId, entity ->
				decryptedFlavour.maybeDecryptServices(groupId, listOf(entity)).single()
			}

		override suspend fun tryDecryptService(service: GroupScoped<EncryptedService>): GroupScoped<Service> =
			groupScopedWith(service) { groupId, entity ->
				tryAndRecoverFlavour.maybeDecryptServices(groupId, listOf(entity)).single()
			}

		override suspend fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedContact?,
			patient: GroupScoped<Patient>?,
			user: User?,
			delegates: @JsMapAsObjectArray(
				keyEntryName = "delegate",
				valueEntryName = "accessLevel"
			) Map<EntityReferenceInGroup, AccessLevel>,
			secretId: SecretIdUseOption,
			alternateRootDelegateReference: EntityReferenceInGroup?
		): GroupScoped<DecryptedContact> =
			GroupScoped(
				doWithEncryptionMetadata(
					entityGroupId = entityGroupId,
					base = base,
					patientInGroup = patient?.let { Pair(it.entity, it.groupId) },
					user = user,
					delegates = delegates,
					secretId = secretId,
					alternateRootDataOwnerReference = alternateRootDelegateReference
				),
				entityGroupId
			)

		override suspend fun decryptPatientIdOf(contact: GroupScoped<Contact>): Set<EntityReferenceInGroup> =
			doDecryptPatientIdOf(contact.groupId, contact.entity).mapNullGroupTo(contact.groupId)

		override suspend fun createDelegationDeAnonymizationMetadata(
			entity: GroupScoped<Contact>,
			delegates: Set<EntityReferenceInGroup>
		) =
			doCreateDelegationDeAnonymizationMetadata(entity.groupId, entity.entity, delegates)

		override suspend fun getEncryptionKeysOf(contact: GroupScoped<Contact>): Set<HexString> =
			doGetEncryptionKeysOf(contact.groupId, contact.entity)

		override suspend fun hasWriteAccess(contact: GroupScoped<Contact>): Boolean =
			doHasWriteAccess(contact.groupId, contact.entity)

		override suspend fun matchContactsBy(groupId: String, filter: FilterOptions<Contact>): List<String> =
			doMatchContactsBy(groupId, filter)

		override suspend fun matchContactsBySorted(
			groupId: String,
			filter: SortableFilterOptions<Contact>
		): List<String> = doMatchContactsBySorted(groupId, filter)

		override suspend fun matchServicesBy(
			groupId: String,
			filter: FilterOptions<Service>,
		): List<String>  = doMatchServicesBy(groupId, filter)

		override suspend fun matchServicesBySorted(
			groupId: String,
			filter: SortableFilterOptions<Service>,
		): List<String> = doMatchServicesBySorted(groupId, filter)
	}

	override suspend fun withEncryptionMetadata(
		base: DecryptedContact?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDelegateId: String?,
	): DecryptedContact = doWithEncryptionMetadata(
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
		base: DecryptedContact?,
		patientInGroup: Pair<Patient, String?>?,
		user: User?,
		delegates: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
		secretId: SecretIdUseOption,
		alternateRootDataOwnerReference: EntityReferenceInGroup?
	): DecryptedContact =
		crypto.entity.entityWithInitializedEncryptedMetadata(
			entityGroupId = entityGroupId,
			entity = (base ?: DecryptedContact(crypto.primitives.strongRandom.randomUUID())).copy(
				created = base?.created ?: currentEpochMs(),
				modified = base?.modified ?: currentEpochMs(),
				responsible = base?.responsible ?: user?.takeIf { config.autofillAuthor }?.dataOwnerId,
				author = base?.author ?: user?.id?.takeIf { config.autofillAuthor },
				openingDate = base?.openingDate ?: currentFuzzyDateTime(TimeZone.currentSystemDefault()),
				groupId = base?.groupId ?: base?.id,
			),
			entityType = EntityWithEncryptionMetadataTypeName.Contact,
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

	override suspend fun getEncryptionKeysOf(contact: Contact): Set<HexString> =
		doGetEncryptionKeysOf(groupId = null, contact = contact)

	private suspend fun doGetEncryptionKeysOf(groupId: String?, contact: Contact): Set<HexString> =
		crypto.entity.encryptionKeysOf(
			entityGroupId = groupId,
			entity = contact,
			entityType = EntityWithEncryptionMetadataTypeName.Contact,
			dataOwnerId = null
		)

	override suspend fun hasWriteAccess(contact: Contact): Boolean = doHasWriteAccess(groupId = null, contact = contact)

	private suspend fun doHasWriteAccess(groupId: String?, contact: Contact) =
		crypto.entity.hasWriteAccess(
			entityGroupId = groupId,
			entity = contact,
			entityType = EntityWithEncryptionMetadataTypeName.Contact
		)

	override suspend fun decryptPatientIdOf(contact: Contact): Set<EntityReferenceInGroup> =
		doDecryptPatientIdOf(groupId = null, contact = contact)

	private suspend fun doDecryptPatientIdOf(groupId: String?, contact: Contact): Set<EntityReferenceInGroup> =
		crypto.entity.owningEntityIdsOf(
			entityGroupId = groupId,
			entity = contact,
			entityType = EntityWithEncryptionMetadataTypeName.Contact,
			dataOwnerId = null
		).mapTo(mutableSetOf()) {
			crypto.entity.parseReference(groupId, it)
		}

	override suspend fun createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Set<String>) {
		doCreateDelegationDeAnonymizationMetadata(groupId = null, entity = entity, delegates = delegates.asLocalDataOwnerReferences())
	}

	private suspend fun doCreateDelegationDeAnonymizationMetadata(groupId: String?, entity: Contact, delegates: Set<EntityReferenceInGroup>) {
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(
			entityGroupId = groupId,
			entity = entity,
			entityType = EntityWithEncryptionMetadataTypeName.Contact,
			shareWithDataOwners = delegates
		)
	}

	override suspend fun decrypt(contact: EncryptedContact): DecryptedContact =
		decryptedFlavour.maybeDecrypt(entitiesGroupId = null, entity = contact)

	override suspend fun tryDecrypt(contact: EncryptedContact): Contact =
		tryAndRecoverFlavour.maybeDecrypt(entitiesGroupId = null, entity = contact)

	override suspend fun decryptService(service: EncryptedService): DecryptedService =
		decryptedFlavour.maybeDecryptServices(entitiesGroupId = null, listOf(service)).single()

	override suspend fun tryDecryptService(service: EncryptedService): Service =
		tryAndRecoverFlavour.maybeDecryptServices(entitiesGroupId = null, listOf(service)).single()

	private suspend fun doMatchContactsBy(groupId: String?, filter: FilterOptions<Contact>): List<String> =
		if (groupId == null) {
			rawApi.matchContactsBy(
				mapContactFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchContactsInGroupBy(
				groupId = groupId,
				filter = mapContactFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend fun doMatchContactsBySorted(groupId: String?, filter: FilterOptions<Contact>): List<String> =
		doMatchContactsBy(groupId, filter)

	override suspend fun matchContactsBy(filter: FilterOptions<Contact>): List<String> =
		doMatchContactsBy(groupId = null, filter = filter)

	override suspend fun matchContactsBySorted(filter: SortableFilterOptions<Contact>): List<String> =
		doMatchContactsBySorted(groupId = null, filter = filter)

	private suspend fun doMatchServicesBy(groupId: String?, filter: FilterOptions<Service>): List<String> =
		if (groupId == null) {
			rawApi.matchServicesBy(
				mapServiceFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchServicesInGroupBy(
				groupId = groupId,
				filter = mapServiceFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend fun doMatchServicesBySorted(groupId: String?, filter: FilterOptions<Service>): List<String> =
		doMatchServicesBy(groupId = groupId, filter = filter)

	override suspend fun matchServicesBy(filter: FilterOptions<Service>): List<String> =
		doMatchServicesBy(groupId = null, filter = filter)

	override suspend fun matchServicesBySorted(filter: SortableFilterOptions<Service>): List<String> =
		doMatchServicesBySorted(groupId = null, filter = filter)


	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: FilterOptions<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedService.serializer(),
			events = setOf(SubscriptionEventType.Create, SubscriptionEventType.Update),
			filter = mapServiceFilterOptions(
				filterOptions = filter,
				config = config,
				requestGroup = null
			),
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ServiceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<Contact>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedContact> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedContact.serializer(),
			events = events,
			filter = mapContactFilterOptions(
				filterOptions = filter,
				config = config,
				requestGroup = null
			),
			qualifiedName = Contact.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ContactAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@InternalIcureApi
internal fun initContactBasicApi(
	rawApi: RawContactApi,
	config: BasicApiConfiguration
): ContactBasicApi = ContactBasicApiImpl(
	rawApi = rawApi,
	config = config,
	encryptedFlavour = encryptedApiFlavour(config)
)

@InternalIcureApi
private class ContactBasicApiImpl(
	private val rawApi: RawContactApi,
	private val config: BasicApiConfiguration,
	private val encryptedFlavour: ContactExtendedFlavouredApi<EncryptedContact, EncryptedService>
) : ContactBasicApi,
	ContactBasicFlavouredApi<EncryptedContact, EncryptedService> by ContactBasicFlavouredApiImpl(rawApi, config, encryptedFlavour),
	ContactBasicFlavourlessApi by ContactBasicFlavourlessApiImpl(rawApi) {

	override val inGroup: ContactBasicInGroupApi = object : ContactBasicInGroupApi,
		ContactBasicFlavourlessInGroupApi by ContactBasicFlavourlessInGroupApiImpl(rawApi),
		ContactBasicFlavouredInGroupApi<EncryptedContact, EncryptedService> by ContactBasicFlavouredInGroupApiImpl(rawApi, config, encryptedFlavour) {

		override suspend fun matchContactsBy(
			groupId: String,
			filter: BaseFilterOptions<Contact>,
		): List<String> = doMatchContactsBy(groupId = groupId, filter = filter)

		override suspend fun matchContactsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Contact>,
		): List<String> = doMatchContactsBySorted(groupId = groupId, filter = filter)

		override suspend fun matchServicesBy(
			groupId: String,
			filter: BaseFilterOptions<Service>,
		): List<String> = doMatchServicesBy(groupId = groupId, filter = filter)

		override suspend fun matchServicesBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Service>,
		): List<String> = doMatchServicesBy(groupId = groupId, filter = filter)

		override suspend fun filterContactsBy(
			groupId: String,
			filter: BaseFilterOptions<Contact>,
		): PaginatedListIterator<GroupScoped<EncryptedContact>> = IdsPageIterator(
			matchContactsBy(filter)
		) { ids -> getContacts(groupId = groupId, entityIds = ids) }

		override suspend fun filterContactsBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Contact>,
		): PaginatedListIterator<GroupScoped<EncryptedContact>> = filterContactsBy(groupId = groupId, filter = filter)

		override suspend fun filterServicesBy(
			groupId: String,
			filter: BaseFilterOptions<Service>,
		): PaginatedListIterator<GroupScoped<EncryptedService>> = IdsPageIterator(
			matchServicesBy(groupId, filter)
		) { ids -> getServices(groupId = groupId, entityIds = ids) }

		override suspend fun filterServicesBySorted(
			groupId: String,
			filter: BaseSortableFilterOptions<Service>,
		): PaginatedListIterator<GroupScoped<EncryptedService>> = IdsPageIterator(
			matchServicesBySorted(groupId, filter)
		) { ids -> getServices(groupId = groupId, entityIds = ids) }

	}

	override suspend fun subscribeToServiceCreateOrUpdateEvents(
		filter: BaseFilterOptions<Service>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedService> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedService.serializer(),
			events = setOf(SubscriptionEventType.Create, SubscriptionEventType.Update),
			filter = mapServiceFilterOptions(
				filterOptions = filter,
				config = config,
				requestGroup = null
			),
			qualifiedName = Service.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ServiceAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: BaseFilterOptions<Contact>,
		subscriptionConfig: EntitySubscriptionConfiguration?
	): EntitySubscription<EncryptedContact> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = EncryptedContact.serializer(),
			events = events,
			filter = mapContactFilterOptions(
				filterOptions = filter,
				config = config,
				requestGroup = null
			),
			qualifiedName = Contact.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(ContactAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}

	private suspend fun doMatchContactsBy(groupId: String?, filter: FilterOptions<Contact>): List<String> =
		if (groupId == null) {
			rawApi.matchContactsBy(
				mapContactFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchContactsInGroupBy(
				groupId = groupId,
				filter = mapContactFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend fun doMatchContactsBySorted(groupId: String?, filter: FilterOptions<Contact>): List<String> =
		doMatchContactsBy(groupId, filter)

	private suspend fun doMatchServicesBy(groupId: String?, filter: FilterOptions<Service>): List<String> =
		if (groupId == null) {
			rawApi.matchServicesBy(
				mapServiceFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		} else {
			rawApi.matchServicesInGroupBy(
				groupId = groupId,
				filter = mapServiceFilterOptions(
					filter,
					config,
					groupId
				)
			).successBody()
		}

	private suspend fun doMatchServicesBySorted(groupId: String?, filter: FilterOptions<Service>): List<String> =
		doMatchServicesBy(groupId, filter)

	override suspend fun matchContactsBy(filter: BaseFilterOptions<Contact>): List<String> =
		doMatchContactsBy(groupId = null, filter = filter)

	override suspend fun matchServicesBy(filter: BaseFilterOptions<Service>): List<String> =
		doMatchServicesBy(groupId = null, filter = filter)

	override suspend fun matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): List<String> =
		doMatchContactsBySorted(groupId = null, filter = filter)

	override suspend fun matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): List<String> =
		doMatchServicesBySorted(groupId = null, filter = filter)

	override suspend fun filterContactsBy(filter: BaseFilterOptions<Contact>): PaginatedListIterator<EncryptedContact> =
		IdsPageIterator(
			matchContactsBy(filter),
			this::getContacts
		)

	override suspend fun filterServicesBy(filter: BaseFilterOptions<Service>): PaginatedListIterator<EncryptedService> =
		IdsPageIterator(
			matchServicesBy(filter),
			this::getServices
		)

	override suspend fun filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): PaginatedListIterator<EncryptedContact> =
		filterContactsBy(filter)

	override suspend fun filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): PaginatedListIterator<EncryptedService> =
		filterServicesBy(filter)
}
