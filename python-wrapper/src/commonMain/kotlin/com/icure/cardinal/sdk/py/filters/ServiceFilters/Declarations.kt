// auto-generated file
package com.icure.cardinal.sdk.py.filters.ServiceFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.ServiceFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllServicesForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allServicesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllServicesForDataOwnerParams>(params)
	ServiceFilters.allServicesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class AllServicesForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun allServicesForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllServicesForDataOwnerInGroupParams>(params)
	ServiceFilters.allServicesForDataOwnerInGroup(
		decodedParams.dataOwner,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

public fun allServicesForSelf(): String = kotlin.runCatching {
	ServiceFilters.allServicesForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	ServiceFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdentifiersForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerInGroupParams>(params)
	ServiceFilters.byIdentifiersForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodeAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byCodeAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodeAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndValueDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byCodeAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byTagAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndValueDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byTagAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerParams>(params)
	ServiceFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	ServiceFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsSecretIdsForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByHealthElementIdFromSubContactForDataOwnerParams(
	public val dataOwnerId: String,
	public val healthElementIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byHealthElementIdFromSubContactForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByHealthElementIdFromSubContactForDataOwnerParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.healthElementIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByHealthElementIdFromSubContactForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val healthElementIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byHealthElementIdFromSubContactForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByHealthElementIdFromSubContactForDataOwnerInGroupParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.healthElementIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	ServiceFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodeAndValueDateForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndValueDateForSelfParams>(params)
	ServiceFilters.byCodeAndValueDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagAndValueDateForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndValueDateForSelfParams>(params)
	ServiceFilters.byTagAndValueDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForSelfParams>(params)
	ServiceFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	ServiceFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByHealthElementIdFromSubContactForSelfParams(
	public val healthElementIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byHealthElementIdFromSubContactForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByHealthElementIdFromSubContactForSelfParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForSelf(
		decodedParams.healthElementIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	ServiceFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByAssociationIdParams(
	public val associationId: String,
)

@OptIn(InternalIcureApi::class)
public fun byAssociationId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAssociationIdParams>(params)
	ServiceFilters.byAssociationId(
		decodedParams.associationId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByQualifiedLinkParams(
	public val linkValues: List<String>,
	public val linkQualification: LinkQualification? = null,
)

@OptIn(InternalIcureApi::class)
public fun byQualifiedLink(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByQualifiedLinkParams>(params)
	ServiceFilters.byQualifiedLink(
		decodedParams.linkValues,
		decodedParams.linkQualification,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsDateForSelfParams>(params)
	ServiceFilters.byPatientsDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientSecretIdsDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodesAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodesAndValueDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodesAndValueDateForSelfParams(
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodesAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byCodesAndValueDateForSelf(
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodePrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodePrefixAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodePrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byCodePrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodePrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodePrefixAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodePrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byCodePrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodePrefixAndValueDateForSelfParams(
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodePrefixAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodePrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byCodePrefixAndValueDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagCodesAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byTagCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagCodesAndValueDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byTagCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagCodesAndValueDateForSelfParams(
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagCodesAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byTagCodesAndValueDateForSelf(
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagPrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagPrefixAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagPrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byTagPrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagPrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagPrefixAndValueDateForDataOwnerInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagPrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byTagPrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagPrefixAndValueDateForSelfParams(
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagPrefixAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagPrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byTagPrefixAndValueDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodesAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodesAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodesAndValueDateForSelfParams(
	public val patients: List<Patient>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodesAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientsCodesAndValueDateForSelf(
		decodedParams.patients,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodesAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodesAndValueDateForSelfParams(
	public val secretIds: List<String>,
	public val codeCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodesAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsCodesAndValueDateForSelf(
		decodedParams.secretIds,
		decodedParams.codeCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodePrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodePrefixAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodePrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodePrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodePrefixAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodePrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsCodePrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsCodePrefixAndValueDateForSelfParams(
	public val patients: List<Patient>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsCodePrefixAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsCodePrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientsCodePrefixAndValueDateForSelf(
		decodedParams.patients,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodePrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodePrefixAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodePrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsCodePrefixAndValueDateForSelfParams(
	public val secretIds: List<String>,
	public val codeType: String,
	public val codeCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsCodePrefixAndValueDateForSelf(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsCodePrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsCodePrefixAndValueDateForSelf(
		decodedParams.secretIds,
		decodedParams.codeType,
		decodedParams.codeCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagCodesAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsTagCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagCodesAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsTagCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagCodesAndValueDateForSelfParams(
	public val patients: List<Patient>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagCodesAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientsTagCodesAndValueDateForSelf(
		decodedParams.patients,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagCodesAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagCodesAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagCodesAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagCodesAndValueDateForSelfParams(
	public val secretIds: List<String>,
	public val tagCodes: Map<String, Set<String>>,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagCodesAndValueDateForSelf(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagCodesAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsTagCodesAndValueDateForSelf(
		decodedParams.secretIds,
		decodedParams.tagCodes,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagPrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagPrefixAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagPrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagPrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val patients: List<Patient>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagPrefixAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagPrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientsTagPrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.patients,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsTagPrefixAndValueDateForSelfParams(
	public val patients: List<Patient>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsTagPrefixAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsTagPrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientsTagPrefixAndValueDateForSelf(
		decodedParams.patients,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagPrefixAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagPrefixAndValueDateForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagPrefixAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroupParams(
	public val dataOwner: EntityReferenceInGroup,
	public val secretIds: List<String>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroupParams>(params)
	ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup(
		decodedParams.dataOwner,
		decodedParams.secretIds,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsTagPrefixAndValueDateForSelfParams(
	public val secretIds: List<String>,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsTagPrefixAndValueDateForSelf(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsTagPrefixAndValueDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsTagPrefixAndValueDateForSelf(
		decodedParams.secretIds,
		decodedParams.tagType,
		decodedParams.tagCodePrefix,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))
