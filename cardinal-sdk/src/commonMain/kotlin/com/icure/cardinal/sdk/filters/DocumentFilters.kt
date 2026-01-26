package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByTypeDataOwnerPatientFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlin.time.Instant
import kotlinx.serialization.Serializable

object DocumentFilters {

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsCreatedForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsCreatedForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientsCreatedForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		patients = patients.map { Pair(it.toEncryptionMetadataStub(), null) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In group version of [byPatientsCreatedForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsCreatedForDataOwner(
		dataOwner: EntityReferenceInGroup,
		patients: List<GroupScoped<Patient>>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientsCreatedForDataOwner(
		dataOwnerId = dataOwner,
		patients = patients.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided messages.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsCreatedForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provided messages the message will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param messages a list of messages.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesCreatedForDataOwner(
		dataOwnerId: String,
		messages: List<Message>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByMessagesCreatedForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		messages = messages.map { Pair(it.toEncryptionMetadataStub(), null) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In group version of [byMessagesCreatedForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesCreatedForDataOwner(
		dataOwner: EntityReferenceInGroup,
		messages: List<GroupScoped<Message>>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByMessagesCreatedForDataOwner(
		dataOwnerId = dataOwner,
		messages = messages.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsCreatedForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsCreatedForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientsCreatedForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided messages.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 * those for filtering.
	 * If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsCreatedForSelf].
	 * If the current data owner does not have access to any secret id of one of the provided messages the message will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param messages a list of messages.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesCreatedForSelf(
		messages: List<Message>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByMessagesCreatedForSelf(
		messages = messages.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byOwningEntitySecretIdsCreatedForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Document> = ByOwningEntitySecretIdsCreatedForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	fun byOwningEntitySecretIdsCreatedForDataOwner(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Document> = ByOwningEntitySecretIdsCreatedForDataOwner(
		dataOwnerId = dataOwner,
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided owning entities through one of the provided secret ids.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide owning entities the owning entity will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of owning entity secret ids.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byOwningEntitySecretIdsCreatedForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByOwningEntitySecretIdsCreatedForSelf(
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsAndTypeForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provided patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param documentType the document type to search.
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: DocumentType,
		patients: List<Patient>
	): FilterOptions<Document> = ByPatientsTypeForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		patients = patients.map { Pair(it.toEncryptionMetadataStub(), null) },
		type = documentType
	)

	/**
	 * In group version of [byPatientsAndTypeForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsAndTypeForDataOwner(
		dataOwner: EntityReferenceInGroup,
		documentType: DocumentType,
		patients: List<GroupScoped<Patient>>
	): FilterOptions<Document> = ByPatientsTypeForDataOwner(
		dataOwnerId = dataOwner,
		patients = patients.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		type = documentType
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with of the provided messages and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 * those for filtering.
	 * If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsAndTypeForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provided messages the message will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param documentType the document type to search.
	 * @param messages a list of messages.
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: DocumentType,
		messages: List<Message>
	): FilterOptions<Document> = ByMessagesTypeForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		messages = messages.map { Pair(it.toEncryptionMetadataStub(), null) },
		type = documentType
	)

	/**
	 * In group version of [byMessagesAndTypeForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesAndTypeForDataOwner(
		dataOwner: EntityReferenceInGroup,
		documentType: DocumentType,
		messages: List<GroupScoped<Message>>
	): FilterOptions<Document> = ByMessagesTypeForDataOwner(
		dataOwnerId = dataOwner,
		messages = messages.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		type = documentType
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byOwningEntitySecretIdsAndTypeForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param documentType the document type to search.
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsAndTypeForSelf(
		documentType: DocumentType,
		patients: List<Patient>
	): FilterOptions<Document> = ByPatientsTypeForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		type = documentType
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with of the provided messages and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided messages and use
	 * those for filtering.
	 * If you already have the secret ids of the message you may instead use [byOwningEntitySecretIdsAndTypeForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide messages the message will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param documentType the document type to search.
	 * @param messages a list of messages.
	 */
	@OptIn(InternalIcureApi::class)
	fun byMessagesAndTypeForSelf(
		documentType: DocumentType,
		messages: List<Message>
	): FilterOptions<Document> = ByMessagesTypeForSelf(
		messages = messages.map { it.toEncryptionMetadataStub() },
		type = documentType
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with of the provided owning entities through one of the provided secret ids and where [Document.documentType] is equal
	 * to [documentType].
	 *
	 * If the current data owner does not have access to any secret id of one of the provided owning entities the owning entity will
	 * simply be ignored.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param documentType the document type to search.
	 * @param secretIds a list of patient secret ids.
	 */
	fun byOwningEntitySecretIdsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: DocumentType,
		secretIds: List<String>
	): FilterOptions<Document> = ByOwningEntitySecretIdsTypeForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		secretIds = secretIds,
		type = documentType
	)

	/**
	 * In group version of [byOwningEntitySecretIdsAndTypeForDataOwner].
	 */
	fun byOwningEntitySecretIdsAndTypeForDataOwner(
		dataOwner: EntityReferenceInGroup,
		documentType: DocumentType,
		secretIds: List<String>
	): FilterOptions<Document> = ByOwningEntitySecretIdsTypeForDataOwner(
		dataOwnerId = dataOwner,
		secretIds = secretIds,
		type = documentType
	)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with of the provided owning entities through one of the provided secret ids and where [Document.documentType] is equal
	 * to [documentType].
	 *
	 * If the current data owner does not have access to any secret id of one of the provide owning entities the owning entity will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param documentType the document type to search.
	 * @param secretIds a list of patient secret ids.
	 */
	fun byOwningEntitySecretIdsAndTypeForSelf(
		documentType: DocumentType,
		secretIds: List<String>
	): FilterOptions<Document> = ByOwningEntitySecretIdsTypeForSelf(
		secretIds = secretIds,
		type = documentType,
	)


	@Serializable
	@InternalIcureApi
	internal class ByPatientsCreatedForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val patients: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByMessagesCreatedForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val messages: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsCreatedForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByMessagesCreatedForSelf(
		val messages: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	internal class ByOwningEntitySecretIdsCreatedForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<Document>

	@Serializable
	internal class ByOwningEntitySecretIdsCreatedForSelf(
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsTypeForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val patients: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByMessagesTypeForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val messages: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsTypeForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	@InternalIcureApi
	internal class ByMessagesTypeForSelf(
		val messages: List<EntityWithEncryptionMetadataStub>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	internal class ByOwningEntitySecretIdsTypeForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val secretIds: List<String>,
		val type: DocumentType
	): BaseFilterOptions<Document>

	@Serializable
	internal class ByOwningEntitySecretIdsTypeForSelf(
		val secretIds: List<String>,
		val type: DocumentType
	): FilterOptions<Document>
}

@InternalIcureApi
internal suspend fun mapDocumentFilterOptions(
	filterOptions: FilterOptions<Document>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<Document> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapDocumentFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapDocumentFilterOptions(
	filterOptions: FilterOptions<Document>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<Document> = mapIfMetaFilterOptions(filterOptions) {
	mapDocumentFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is DocumentFilters.ByPatientsCreatedForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.patients.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByMessagesCreatedForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.messages.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByPatientsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.patients.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByMessagesCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.messages.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByOwningEntitySecretIdsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByOwningEntitySecretIdsCreatedForDataOwner -> DocumentByDataOwnerPatientDateFilter(
		dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		secretPatientKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is DocumentFilters.ByPatientsTypeForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.patients.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByMessagesTypeForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.messages.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByPatientsTypeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.patients.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByMessagesTypeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.messages.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByOwningEntitySecretIdsTypeForDataOwner -> DocumentByTypeDataOwnerPatientFilter(
		dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		secretPatientKeys = filterOptions.secretIds.toSet(),
		documentType = filterOptions.type
	)
	is DocumentFilters.ByOwningEntitySecretIdsTypeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.secretIds.toSet(),
			documentType = filterOptions.type
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Documents")
}
