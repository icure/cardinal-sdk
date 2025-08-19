// auto-generated file
package com.icure.cardinal.sdk.py.filters.DocumentFilters

import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.DocumentFilters
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.DocumentType
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
private class ByPatientsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCreatedForDataOwnerParams>(params)
	DocumentFilters.byPatientsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByMessagesCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val messages: List<Message>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byMessagesCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByMessagesCreatedForDataOwnerParams>(params)
	DocumentFilters.byMessagesCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.messages,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByPatientsCreatedForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCreatedForSelfParams>(params)
	DocumentFilters.byPatientsCreatedForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByMessagesCreatedForSelfParams(
	public val messages: List<Message>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byMessagesCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByMessagesCreatedForSelfParams>(params)
	DocumentFilters.byMessagesCreatedForSelf(
		decodedParams.messages,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByOwningEntitySecretIdsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byOwningEntitySecretIdsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOwningEntitySecretIdsCreatedForDataOwnerParams>(params)
	DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByOwningEntitySecretIdsCreatedForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byOwningEntitySecretIdsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOwningEntitySecretIdsCreatedForSelfParams>(params)
	DocumentFilters.byOwningEntitySecretIdsCreatedForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByPatientsAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsAndTypeForDataOwnerParams>(params)
	DocumentFilters.byPatientsAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.patients,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByMessagesAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val messages: List<Message>,
)

@OptIn(InternalIcureApi::class)
public fun byMessagesAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByMessagesAndTypeForDataOwnerParams>(params)
	DocumentFilters.byMessagesAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.messages,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByPatientsAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsAndTypeForSelfParams>(params)
	DocumentFilters.byPatientsAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.patients,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByMessagesAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val messages: List<Message>,
)

@OptIn(InternalIcureApi::class)
public fun byMessagesAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByMessagesAndTypeForSelfParams>(params)
	DocumentFilters.byMessagesAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.messages,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByOwningEntitySecretIdsAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byOwningEntitySecretIdsAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOwningEntitySecretIdsAndTypeForDataOwnerParams>(params)
	DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByOwningEntitySecretIdsAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byOwningEntitySecretIdsAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByOwningEntitySecretIdsAndTypeForSelfParams>(params)
	DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))
