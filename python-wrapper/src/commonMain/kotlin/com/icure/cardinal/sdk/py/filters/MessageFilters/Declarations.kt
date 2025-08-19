// auto-generated file
package com.icure.cardinal.sdk.py.filters.MessageFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.MessageFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.time.Instant
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllMessagesForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allMessagesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllMessagesForDataOwnerParams>(params)
	MessageFilters.allMessagesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

public fun allMessagesForSelf(): String = kotlin.runCatching {
	MessageFilters.allMessagesForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByTransportGuidForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
)

@OptIn(InternalIcureApi::class)
public fun byTransportGuidForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTransportGuidForDataOwnerParams>(params)
	MessageFilters.byTransportGuidForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByTransportGuidForSelfParams(
	public val transportGuid: String,
)

@OptIn(InternalIcureApi::class)
public fun byTransportGuidForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTransportGuidForSelfParams>(params)
	MessageFilters.byTransportGuidForSelf(
		decodedParams.transportGuid,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class FromAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val address: String,
)

@OptIn(InternalIcureApi::class)
public fun fromAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FromAddressForDataOwnerParams>(params)
	MessageFilters.fromAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.address,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class FromAddressForSelfParams(
	public val address: String,
)

@OptIn(InternalIcureApi::class)
public fun fromAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FromAddressForSelfParams>(params)
	MessageFilters.fromAddressForSelf(
		decodedParams.address,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByPatientsSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSentDateForDataOwnerParams>(params)
	MessageFilters.byPatientsSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByPatientsSentDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSentDateForSelfParams>(params)
	MessageFilters.byPatientsSentDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByPatientSecretIdsSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsSentDateForDataOwnerParams>(params)
	MessageFilters.byPatientSecretIdsSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByPatientSecretIdsSentDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsSentDateForSelfParams>(params)
	MessageFilters.byPatientSecretIdsSentDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ToAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val address: String,
)

@OptIn(InternalIcureApi::class)
public fun toAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ToAddressForDataOwnerParams>(params)
	MessageFilters.toAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.address,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ToAddressForSelfParams(
	public val address: String,
)

@OptIn(InternalIcureApi::class)
public fun toAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ToAddressForSelfParams>(params)
	MessageFilters.toAddressForSelf(
		decodedParams.address,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByTransportGuidSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
	public val from: Instant?,
	public val to: Instant?,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byTransportGuidSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTransportGuidSentDateForDataOwnerParams>(params)
	MessageFilters.byTransportGuidSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByTransportGuidSentDateForSelfParams(
	public val transportGuid: String,
	public val from: Instant?,
	public val to: Instant?,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byTransportGuidSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTransportGuidSentDateForSelfParams>(params)
	MessageFilters.byTransportGuidSentDateForSelf(
		decodedParams.transportGuid,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class LatestByTransportGuidForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
)

@OptIn(InternalIcureApi::class)
public fun latestByTransportGuidForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LatestByTransportGuidForDataOwnerParams>(params)
	MessageFilters.latestByTransportGuidForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class LatestByTransportGuidForSelfParams(
	public val transportGuid: String,
)

@OptIn(InternalIcureApi::class)
public fun latestByTransportGuidForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LatestByTransportGuidForSelfParams>(params)
	MessageFilters.latestByTransportGuidForSelf(
		decodedParams.transportGuid,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByInvoiceIdsParams(
	public val invoiceIds: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun byInvoiceIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByInvoiceIdsParams>(params)
	MessageFilters.byInvoiceIds(
		decodedParams.invoiceIds,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class ByParentIdsParams(
	public val parentIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byParentIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByParentIdsParams>(params)
	MessageFilters.byParentIds(
		decodedParams.parentIds,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class LifecycleBetweenForDataOwnerParams(
	public val dataOwnerId: String,
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LifecycleBetweenForDataOwnerParams>(params)
	MessageFilters.lifecycleBetweenForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class LifecycleBetweenForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<LifecycleBetweenForDataOwnerInGroupParams>(params)
	MessageFilters.lifecycleBetweenForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Message::class)))

@Serializable
private class LifecycleBetweenForSelfParams(
	public val startTimestamp: Long?,
	public val endTimestamp: Long?,
	public val descending: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun lifecycleBetweenForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<LifecycleBetweenForSelfParams>(params)
	MessageFilters.lifecycleBetweenForSelf(
		decodedParams.startTimestamp,
		decodedParams.endTimestamp,
		decodedParams.descending,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Message::class)))
