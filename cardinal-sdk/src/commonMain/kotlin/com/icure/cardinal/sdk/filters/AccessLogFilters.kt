package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByDateFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByUserIdUserTypeDateFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable
import kotlin.coroutines.coroutineContext
import kotlin.time.Instant

object AccessLogFilters {

	/**
	 * Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the access logs based on [AccessLog.date]:
	 * - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param to the maximum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsDateForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<AccessLog> = ByPatientsDateForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the access logs based on [AccessLog.date]:
	 * - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param to the maximum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsDateForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<AccessLog> = ByPatientsDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with a patient through one of the provided secret ids.
	 * This Options also allows to restrict the access logs based on [AccessLog.date]:
	 * - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param to the maximum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	fun byPatientSecretIdsDateForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<AccessLog> = ByPatientSecretIdsDateForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for access log filtering which match all access logs shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with a patient through one of the provided secret ids.
	 * This Options also allows to restrict the access logs based on [AccessLog.date]:
	 * - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param to the maximum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	fun byPatientSecretIdsDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<AccessLog> = ByPatientSecretIdsDateForSelf(secretIds, from, to, descending)

	/**
	 * Options for access log filtering based on [AccessLog.date]:
	 * - if [from] is not null, only the access logs where [AccessLog.date] is greater than or equal to [from] will be returned.
	 * - if [to] is not null, only the access logs where [AccessLog.date] is less than or equal to [to] will be returned.
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param to the maximum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.date] (default: ascending).
	 */
	fun byDate(
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<AccessLog> = ByDate(from, to, descending)

	/**
	 * Options for access log filtering where [AccessLog.user] is equal to [userId], [AccessLog.accessType] is equal to [accessType] (if
	 * provided), and [AccessLog.date] is greater than or equal to [from] (if provided).
	 * If [from] is not null, then also [accessType] must not be null.
	 *
	 * These options are sortable. When sorting using these options the access logs will be sorted by [AccessLog.accessType] and then by
	 * [AccessLog.date] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param userId the id of the user associated to the access log.
	 * @param accessType the [AccessLog.accessType] (default: any type).
	 * @param from the minimum value for [AccessLog.date] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [AccessLog.accessType] and [AccessLog.date  ] (default: ascending).
	 * @throws IllegalArgumentException if [from] is not null and [accessType] is null.
	 */
	fun byUserTypeDate(
		userId: String,
		@DefaultValue("null")
		accessType: String? = null,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<AccessLog> = ByUserTypeDate(userId, accessType, from, descending)

	@Serializable
	@InternalIcureApi
	internal class ByPatientsDateForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<AccessLog>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<AccessLog>

	@Serializable
	internal class ByPatientSecretIdsDateForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<AccessLog>

	@Serializable
	internal class ByPatientSecretIdsDateForSelf(
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<AccessLog>

	@Serializable
	internal class ByDate(
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<AccessLog>

	@Serializable
	internal class ByUserTypeDate(
		val userId: String,
		val accessType: String?,
		val from: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<AccessLog> {
		init {
			require(from == null || accessType != null) {
				"You cannot specify the `from` parameter without specifying the `accessType` parameter."
			}
		}
	}

}

@InternalIcureApi
internal suspend fun mapAccessLogFilterOptions(
	filterOptions: FilterOptions<AccessLog>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<AccessLog> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapAccessLogFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(coroutineContext),
		requestGroup
	)
}

@InternalIcureApi
internal suspend fun mapAccessLogFilterOptions(
	filterOptions: FilterOptions<AccessLog>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<AccessLog> = mapIfMetaFilterOptions(filterOptions) {
	mapAccessLogFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is AccessLogFilters.ByPatientsDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		AccessLogByDataOwnerPatientDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientIds = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is AccessLogFilters.ByPatientsDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		AccessLogByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientIds = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is AccessLogFilters.ByPatientSecretIdsDateForDataOwner -> AccessLogByDataOwnerPatientDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientIds = filterOptions.secretIds.toSet(),
		startDate = filterOptions.from,
		endDate = filterOptions.to,
		descending = filterOptions.descending
	)
	is AccessLogFilters.ByPatientSecretIdsDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		AccessLogByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretPatientIds = filterOptions.secretIds.toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is AccessLogFilters.ByDate -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		AccessLogByDateFilter(
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is AccessLogFilters.ByUserTypeDate -> AccessLogByUserIdUserTypeDateFilter(
		userId = filterOptions.userId,
		accessType = filterOptions.accessType,
		startDate = filterOptions.from,
		descending = filterOptions.descending
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Access Logs")
}

