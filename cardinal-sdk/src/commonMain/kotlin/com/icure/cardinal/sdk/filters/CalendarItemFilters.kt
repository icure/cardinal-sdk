package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerLifecycleBetween
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerPatientStartTimeFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndDataOwnerIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByRecurrenceIdFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object CalendarItemFilters {

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsStartTimeForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientsStartTimeForDataOwner(
		dataOwner = EntityReferenceInGroup(dataOwnerId, null),
		patients = patients.map { Pair(it.toEncryptionMetadataStub(), null) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In-group version of [byPatientsStartTimeForDataOwner].
	 * The data owner and patients can be from a different group than the group of the user executing the query.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsStartTimeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		patients: List<GroupScoped<Patient>>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientsStartTimeForDataOwner(
		dataOwner = dataOwner,
		patients = patients.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsStartTimeForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientsStartTimeForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPatientSecretIdsStartTimeForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<CalendarItem> = ByPatientSecretIdsStartTimeForDataOwner(
		EntityReferenceInGroup(dataOwnerId, null),
		secretIds,
		from,
		to,
		descending
	)

	/**
	 * In-group version of [byPatientSecretIdsStartTimeForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byPatientSecretIdsStartTimeForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<CalendarItem> = ByPatientSecretIdsStartTimeForDataOwner(
		dataOwner,
		secretIds,
		from,
		to,
		descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 * - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPatientSecretIdsStartTimeForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<CalendarItem> = ByPatientSecretIdsStartTimeForSelf(secretIds, from, to, descending)

	/**
	 * Options for calendar items filtering which match all the calendar items where [CalendarItem.agendaId] is equal to [agendaId] and
	 * the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * These options are sortable. When sorting using these options, the calendar items will be sorted by [CalendarItem.startTime] in
	 * ascending or descending order according to the value of the [descending] parameter.
	 *
	 * @param agendaId the value of [CalendarItem.agendaId] to search.
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 * @param descending whether to sort the results in ascending or descending order by [CalendarItem.startTime] (default: ascending).
	 */
	fun byPeriodAndAgenda(
		agendaId: String,
		from: Long,
		to: Long,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<CalendarItem> = ByPeriodAndAgenda(agendaId, from, to, descending)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * @param dataOwnerId a data owner id.
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	fun byPeriodForDataOwner(
		dataOwnerId: String,
		from: Long,
		to: Long
	): BaseFilterOptions<CalendarItem> = ByPeriodForDataOwner(EntityReferenceInGroup(dataOwnerId, null), from, to)

	/**
	 * In-group version of [byPeriodForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byPeriodForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		from: Long,
		to: Long
	): BaseFilterOptions<CalendarItem> = ByPeriodForDataOwner(dataOwner, from, to)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 * @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	fun byPeriodForSelf(
		from: Long,
		to: Long
	): FilterOptions<CalendarItem> = ByPeriodForSelf(from, to)

	/**
	 * Options for calendar item filtering which match all calendar items where [CalendarItem.recurrenceId] is equal to [recurrenceId].
	 *
	 * @param recurrenceId the recurrence id to filter.
	 */
	fun byRecurrenceId(
		recurrenceId: String,
	): FilterOptions<CalendarItem> = ByRecurrenceId(recurrenceId)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
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
	): BaseFilterOptions<CalendarItem> = LifecycleBetweenForDataOwner(
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
	): BaseFilterOptions<CalendarItem> = LifecycleBetweenForDataOwner(
		dataOwner,
		startTimestamp,
		endTimestamp,
		descending
	)

	/**
	 * Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 * and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
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
	): FilterOptions<CalendarItem> = LifecycleBetweenForSelf(startTimestamp, endTimestamp, descending)

	@Serializable
	@InternalIcureApi
	internal class ByPatientsStartTimeForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val patients: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsStartTimeForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPatientSecretIdsStartTimeForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): BaseSortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPatientSecretIdsStartTimeForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodAndAgenda(
		val agendaId: String,
		val from: Long,
		val to: Long,
		val descending: Boolean
	): BaseSortableFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val from: Long,
		val to: Long
	): BaseFilterOptions<CalendarItem>

	@Serializable
	internal class ByPeriodForSelf(
		val from: Long,
		val to: Long
	): FilterOptions<CalendarItem>

	@Serializable
	internal class LifecycleBetweenForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val startTimestamp: Long?,
		val endTimestamp: Long?,
		val descending: Boolean
	): BaseFilterOptions<CalendarItem>

	@Serializable
	internal class LifecycleBetweenForSelf(
		val startTimestamp: Long?,
		val endTimestamp: Long?,
		val descending: Boolean
	): FilterOptions<CalendarItem>

	@Serializable
	internal class ByRecurrenceId(
		val recurrenceId: String
	): FilterOptions<CalendarItem>
}

@InternalIcureApi
internal suspend fun mapCalendarItemFilterOptions(
	filterOptions: FilterOptions<CalendarItem>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<CalendarItem> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapCalendarItemFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapCalendarItemFilterOptions(
	filterOptions: FilterOptions<CalendarItem>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<CalendarItem> = mapIfMetaFilterOptions(filterOptions) {
	mapCalendarItemFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is CalendarItemFilters.ByPatientsStartTimeForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientIds = filterOptions.patients.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPatientsStartTimeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientIds = filterOptions.patients.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPatientSecretIdsStartTimeForDataOwner -> CalendarItemByDataOwnerPatientStartTimeFilter(
		dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		secretPatientIds = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is CalendarItemFilters.ByPatientSecretIdsStartTimeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		CalendarItemByDataOwnerPatientStartTimeFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientIds = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByPeriodAndAgenda -> CalendarItemByPeriodAndAgendaIdFilter(
		agendaId = filterOptions.agendaId,
		startTime = filterOptions.from,
		endTime = filterOptions.to,
		descending = filterOptions.descending
	)
	is CalendarItemFilters.ByPeriodForDataOwner -> CalendarItemByPeriodAndDataOwnerIdFilter(
		dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		startTime = filterOptions.from,
		endTime = filterOptions.to
	)
	is CalendarItemFilters.ByPeriodForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		CalendarItemByPeriodAndDataOwnerIdFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			startTime = filterOptions.from,
			endTime = filterOptions.to
		)
	}
	is CalendarItemFilters.LifecycleBetweenForDataOwner -> CalendarItemByDataOwnerLifecycleBetween(
		dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		startTimestamp = filterOptions.startTimestamp,
		endTimestamp = filterOptions.endTimestamp,
		descending = filterOptions.descending
	)
	is CalendarItemFilters.LifecycleBetweenForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		CalendarItemByDataOwnerLifecycleBetween(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			startTimestamp = filterOptions.startTimestamp,
			endTimestamp = filterOptions.endTimestamp,
			descending = filterOptions.descending
		)
	}
	is CalendarItemFilters.ByRecurrenceId -> CalendarItemByRecurrenceIdFilter(recurrenceId = filterOptions.recurrenceId)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Calendar Items")
}
