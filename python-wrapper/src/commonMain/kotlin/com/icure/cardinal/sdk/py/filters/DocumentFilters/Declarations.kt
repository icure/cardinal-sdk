// auto-generated file
package com.icure.cardinal.sdk.py.filters.DocumentFilters

import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.DocumentFilters
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Document
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
private class ByPatientSecretIdsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCreatedForDataOwnerParams>(params)
	DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByPatientSecretIdsCreatedForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCreatedForSelfParams>(params)
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
private class ByPatientSecretIdsAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsAndTypeForDataOwnerParams>(params)
	DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))

@Serializable
private class ByPatientSecretIdsAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsAndTypeForSelfParams>(params)
	DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Document::class)))
