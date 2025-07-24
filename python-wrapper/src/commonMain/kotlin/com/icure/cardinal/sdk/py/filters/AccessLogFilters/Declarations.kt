// auto-generated file
package com.icure.cardinal.sdk.py.filters.AccessLogFilters

import com.icure.cardinal.sdk.filters.AccessLogFilters
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.time.Instant
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsDateForDataOwnerParams>(params)
	AccessLogFilters.byPatientsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))

@Serializable
private class ByPatientsDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsDateForSelfParams>(params)
	AccessLogFilters.byPatientsDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))

@Serializable
private class ByPatientSecretIdsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForDataOwnerParams>(params)
	AccessLogFilters.byPatientSecretIdsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))

@Serializable
private class ByPatientSecretIdsDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForSelfParams>(params)
	AccessLogFilters.byPatientSecretIdsDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))

@Serializable
private class ByDateParams(
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byDate(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByDateParams>(params)
	AccessLogFilters.byDate(
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))

@Serializable
private class ByUserTypeDateParams(
	public val userId: String,
	public val accessType: String? = null,
	public val from: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byUserTypeDate(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByUserTypeDateParams>(params)
	AccessLogFilters.byUserTypeDate(
		decodedParams.userId,
		decodedParams.accessType,
		decodedParams.from,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(AccessLog::class)))
