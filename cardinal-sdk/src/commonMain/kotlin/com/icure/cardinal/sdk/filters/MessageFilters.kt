package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerFromAddressFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerLifecycleBetween
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerPatientSentDateFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerToAddressFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerTransportGuidSentDateFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByHcPartyTransportGuidReceivedFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByInvoiceIdsFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByParentIdsFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

object MessageFilters {
	/**
	 * Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id
	 * @return options for message filtering
	 */
	fun allMessagesForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Message> = AllForDataOwner(dataOwnerId)

	/**
	 * Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * @return options for message filtering
	 */
	fun allMessagesForSelf(): FilterOptions<Message> = AllForSelf

	/**
	 * Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 * provided transportGuid.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent].
	 *
	 * @param dataOwnerId a data owner id
	 * @param transportGuid a message transport guid
	 */
	fun byTransportGuidForDataOwner(
		dataOwnerId: String,
		transportGuid: String
	): BaseSortableFilterOptions<Message> = ByTransportGuidForDataOwner(transportGuid, dataOwnerId)

	/**
	 * Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 * provided transportGuid.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent].
	 *
	 * @param transportGuid a message transport guid
	 */
	fun byTransportGuidForSelf(
		transportGuid: String,
	): SortableFilterOptions<Message> = ByTransportGuidForSelf(transportGuid)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where [Message.fromAddress] is equal to [address].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param address the sender address.
	 */
	fun fromAddressForDataOwner(
		dataOwnerId: String,
		address: String
	): BaseFilterOptions<Message> = FromAddressForDataOwner(dataOwnerId, address)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where [Message.fromAddress] is equal to [address].
	 *
	 * @param address the sender address.
	 */
	fun fromAddressForSelf(
		address: String
	): FilterOptions<Message> = FromAddressForSelf(address)

	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the messages based on [Message.sent]:
	 * - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsSentDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum value for [Message.sent] (default: no limit).
	 * @param to the maximum value for [Message.sent] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsSentDateForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Message> = ByPatientsSentDateForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the messages based on [Message.sent]:
	 * - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsSentDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum value for [Message.sent] (default: no limit).
	 * @param to the maximum value for [Message.sent] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsSentDateForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Message> = ByPatientsSentDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the messages based on [Message.sent]:
	 * - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [Message.sent] (default: no limit).
	 * @param to the maximum value for [Message.sent] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	fun byPatientSecretIdsSentDateForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Message> = ByPatientSecretIdsSentDateForDataOwner(dataOwnerId, secretIds, from, to, descending)


	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the messages based on [Message.sent]:
	 * - if [from] is not null, only the messages where [Message.sent] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the messages where [Message.sent] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [Message.sent] (default: no limit).
	 * @param to the maximum value for [Message.sent] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Message.sent] (default: ascending).
	 */
	fun byPatientSecretIdsSentDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Message> = ByPatientSecretIdsSentDateForSelf(secretIds, from, to, descending)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where [Message.toAddresses] contains [address].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param address a receiver address.
	 */
	fun toAddressForDataOwner(
		dataOwnerId: String,
		address: String
	): BaseFilterOptions<Message> = ToAddressForDataOwner(dataOwnerId, address)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where [Message.toAddresses] contains [address].
	 *
	 * @param address a receiver address.
	 */
	fun toAddressForSelf(
		address: String
	): FilterOptions<Message> = ToAddressForSelf(address)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where [Message.transportGuid] is equal to [transportGuid] and [Message.sent] is between [from] (inclusive) and [to] (inclusive).
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param transportGuid the transport guid to use in the filter.
	 * @param from the minimum value for [Message.sent].
	 * @param to the maximum value for [Message.sent].
	 * @param descending whether to sort the results in descending or ascending order by [Message.sent] (default: ascending).
	 */
	fun byTransportGuidSentDateForDataOwner(
		dataOwnerId: String,
		transportGuid: String,
		from: Instant?,
		to: Instant?,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Message> = ByTransportGuidSentDateForDataOwner(dataOwnerId, transportGuid, from, to, descending)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where [Message.transportGuid] is equal to [transportGuid] and [Message.sent] is between [from] (inclusive) and [to] (inclusive).
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.sent] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param transportGuid the transport guid to use in the filter.
	 * @param from the minimum value for [Message.sent].
	 * @param to the maximum value for [Message.sent].
	 * @param descending whether to sort the results in descending or ascending order by [Message.sent] (default: ascending).
	 */
	fun byTransportGuidSentDateForSelf(
		transportGuid: String,
		from: Instant?,
		to: Instant?,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Message> = ByTransportGuidSentDateForSelf(transportGuid, from, to, descending)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where [Message.transportGuid] is equal to [transportGuid].
	 *
	 * This filter will return only the message with the greatest [Message.created].
	 *
	 * @param dataOwnerId a data owner id.
	 * @param transportGuid the transport guid to use in the filter.
	 */
	fun latestByTransportGuidForDataOwner(
		dataOwnerId: String,
		transportGuid: String
	): BaseFilterOptions<Message> = LatestByTransportGuidForDataOwner(dataOwnerId, transportGuid)

	/**
	 * Filter options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where [Message.transportGuid] is equal to [transportGuid].
	 *
	 * This filter will return only the message with the greatest [Message.created].
	 *
	 * @param transportGuid the transport guid to use in the filter.
	 */
	fun latestByTransportGuidForSelf(
		transportGuid: String
	): FilterOptions<Message> = LatestByTransportGuidForSelf(transportGuid)

	/**
	 * Filter options for message filtering that will match all messages where [Message.invoiceIds] contains at least one of the provided
	 * [invoiceIds].
	 *
	 * @param invoiceIds the invoice ids to search.
	 */
	fun byInvoiceIds(
		invoiceIds: Set<String>
	): BaseFilterOptions<Message> = ByInvoiceIds(invoiceIds)

	/**
	 * Filter options for message filtering that will match all messages where [Message.parentId] is among the provided [parentIds].
	 *
	 * @param parentIds the parent ids to search.
	 */
	fun byParentIds(
		parentIds: List<String>
	): BaseFilterOptions<Message> = ByParentIds(parentIds)

	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * and where the max among [Message.created], [Message.modified], and [Message.deletionDate] is greater or equal than
	 * [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 * @param dataOwnerId a data owner id.
	 * @param startTimestamp the smallest lifecycle update that the filter will return.
	 * @param endTimestamp the biggest lifecycle update that the filter will return.
	 * @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	fun lifecycleBetweenForDataOwner(
		dataOwnerId: String,
		startTimestamp: Long?,
		endTimestamp: Long?,
		descending: Boolean = false
	): BaseFilterOptions<Message> = LifecycleBetweenForDataOwner(
		EntityReferenceInGroup(dataOwnerId, null),
		startTimestamp,
		endTimestamp,
		descending
	)

	/**
	 * In-group version of [lifecycleBetweenForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun lifecycleBetweenForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		startTimestamp: Long?,
		endTimestamp: Long?,
		descending: Boolean = false
	): BaseFilterOptions<Message> = LifecycleBetweenForDataOwner(
		dataOwner,
		startTimestamp,
		endTimestamp,
		descending
	)

	/**
	 * Options for message filtering which match all messages shared directly (i.e. ignoring hierarchies) with the current data owner
	 * and where the max among [Message.created], [Message.modified], and [Message.deletionDate] is greater or equal than
	 * [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 * @param startTimestamp the smallest lifecycle update that the filter will return.
	 * @param endTimestamp the biggest lifecycle update that the filter will return.
	 * @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	fun lifecycleBetweenForSelf(
		startTimestamp: Long?,
		endTimestamp: Long?,
		descending: Boolean = false
	): FilterOptions<Message> = LifecycleBetweenForSelf(startTimestamp, endTimestamp, descending)

	@Serializable
	internal class AllForDataOwner(
		val dataOwnerId: String
	) : BaseFilterOptions<Message>

	@Serializable
	internal data object AllForSelf : FilterOptions<Message>

	@Serializable
	internal class ByTransportGuidForDataOwner(
		val transportGuid: String,
		val dataOwnerId: String
	) : BaseSortableFilterOptions<Message>

	@Serializable
	internal class ByTransportGuidForSelf(
		val transportGuid: String
	) : BaseSortableFilterOptions<Message>

	@Serializable
	internal class FromAddressForDataOwner(
		val dataOwnerId: String,
		val fromAddress: String,
	) : BaseFilterOptions<Message>

	@Serializable
	internal class FromAddressForSelf(
		val fromAddress: String,
	) : FilterOptions<Message>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsSentDateForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Message>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsSentDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Message>

	@Serializable
	internal class ByPatientSecretIdsSentDateForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<Message>

	@Serializable
	internal class ByPatientSecretIdsSentDateForSelf(
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Message>

	@Serializable
	internal class ToAddressForDataOwner(
		val dataOwnerId: String,
		val address: String
	): BaseFilterOptions<Message>

	@Serializable
	internal class ToAddressForSelf(
		val address: String
	): FilterOptions<Message>

	@Serializable
	internal class ByTransportGuidSentDateForDataOwner(
		val dataOwnerId: String,
		val transportGuid: String,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<Message>

	@Serializable
	internal class ByTransportGuidSentDateForSelf(
		val transportGuid: String,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Message>

	@Serializable
	internal class LatestByTransportGuidForDataOwner(
		val dataOwnerId: String,
		val transportGuid: String
	): BaseFilterOptions<Message>

	@Serializable
	internal class LatestByTransportGuidForSelf(
		val transportGuid: String
	): FilterOptions<Message>

	@Serializable
	internal class ByInvoiceIds(
		val invoiceIds: Set<String>
	): BaseFilterOptions<Message>

	@Serializable
	internal class ByParentIds(
		val parentIds: List<String>
	): BaseFilterOptions<Message>

	@Serializable
	internal class LifecycleBetweenForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val startTimestamp: Long?,
		val endTimestamp: Long?,
		val descending: Boolean
	): BaseFilterOptions<Message>

	@Serializable
	internal class LifecycleBetweenForSelf(
		val startTimestamp: Long?,
		val endTimestamp: Long?,
		val descending: Boolean
	): FilterOptions<Message>
}

@InternalIcureApi
internal suspend fun mapMessageFilterOptions(
	filterOptions: FilterOptions<Message>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<Message> = mapIfMetaFilterOptions(filterOptions) {
	mapMessageFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is MessageFilters.AllForDataOwner -> {
		MessageByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
	}
	MessageFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByHcPartyFilter(
			hcpId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is MessageFilters.ByTransportGuidForDataOwner -> {
		MessageByHcPartyTransportGuidReceivedFilter(
			transportGuid = filterOptions.transportGuid,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is MessageFilters.ByTransportGuidForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByHcPartyTransportGuidReceivedFilter(
			transportGuid = filterOptions.transportGuid,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is MessageFilters.FromAddressForDataOwner -> MessageByDataOwnerFromAddressFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		fromAddress = filterOptions.fromAddress
	)
	is MessageFilters.FromAddressForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerFromAddressFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			fromAddress = filterOptions.fromAddress
		)
	}
	is MessageFilters.ByPatientsSentDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerPatientSentDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is MessageFilters.ByPatientsSentDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerPatientSentDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is MessageFilters.ByPatientSecretIdsSentDateForDataOwner -> MessageByDataOwnerPatientSentDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.from,
		endDate = filterOptions.to,
		descending = filterOptions.descending
	)
	is MessageFilters.ByPatientSecretIdsSentDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerPatientSentDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is MessageFilters.ToAddressForDataOwner -> MessageByDataOwnerToAddressFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		toAddress = filterOptions.address
	)
	is MessageFilters.ToAddressForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerToAddressFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			toAddress = filterOptions.address
		)
	}
	is MessageFilters.ByTransportGuidSentDateForDataOwner -> MessageByDataOwnerTransportGuidSentDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		transportGuid = filterOptions.transportGuid,
		fromDate = filterOptions.from,
		toDate = filterOptions.to,
		descending = filterOptions.descending
	)
	is MessageFilters.ByTransportGuidSentDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerTransportGuidSentDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			transportGuid = filterOptions.transportGuid,
			fromDate = filterOptions.from,
			toDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is MessageFilters.LatestByTransportGuidForDataOwner -> LatestMessageByHcPartyTransportGuidFilter(
		healthcarePartyId = filterOptions.dataOwnerId,
		transportGuid = filterOptions.transportGuid
	)
	is MessageFilters.LatestByTransportGuidForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		LatestMessageByHcPartyTransportGuidFilter(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			transportGuid = filterOptions.transportGuid
		)
	}
	is MessageFilters.LifecycleBetweenForDataOwner -> MessageByDataOwnerLifecycleBetween(
		dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		startTimestamp = filterOptions.startTimestamp,
		endTimestamp = filterOptions.endTimestamp,
		descending = filterOptions.descending
	)
	is MessageFilters.LifecycleBetweenForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		MessageByDataOwnerLifecycleBetween(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			startTimestamp = filterOptions.startTimestamp,
			endTimestamp = filterOptions.endTimestamp,
			descending = filterOptions.descending
		)
	}
	is MessageFilters.ByInvoiceIds -> MessageByInvoiceIdsFilter(invoiceIds = filterOptions.invoiceIds)
	is MessageFilters.ByParentIds -> MessageByParentIdsFilter(parentIds = filterOptions.parentIds)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Messages")
}
