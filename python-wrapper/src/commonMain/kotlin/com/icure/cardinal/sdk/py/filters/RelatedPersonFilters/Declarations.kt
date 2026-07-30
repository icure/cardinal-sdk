// auto-generated file
package com.icure.cardinal.sdk.py.filters.RelatedPersonFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.RelatedPersonFilters
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllRelatedPersonsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allRelatedPersonsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllRelatedPersonsForDataOwnerParams>(params)
	RelatedPersonFilters.allRelatedPersonsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class AllRelatedPersonsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun allRelatedPersonsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllRelatedPersonsForDataOwnerInGroupParams>(params)
	RelatedPersonFilters.allRelatedPersonsForDataOwnerInGroup(
		decodedParams.dataOwner,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

public fun allRelatedPersonsForSelf(): String = kotlin.runCatching {
	RelatedPersonFilters.allRelatedPersonsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	RelatedPersonFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByIdentifiersForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerInGroupParams>(params)
	RelatedPersonFilters.byIdentifiersForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.identifiers,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	RelatedPersonFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByNameForDataOwnerParams(
	public val dataOwnerId: String,
	public val name: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameForDataOwnerParams>(params)
	RelatedPersonFilters.byNameForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.name,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByNameForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val name: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByNameForDataOwnerInGroupParams>(params)
	RelatedPersonFilters.byNameForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.name,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByNameForSelfParams(
	public val name: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameForSelfParams>(params)
	RelatedPersonFilters.byNameForSelf(
		decodedParams.name,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	RelatedPersonFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(RelatedPerson::class)))
