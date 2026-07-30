package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.relatedperson.RelatedPersonByDataOwnerIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.relatedperson.RelatedPersonByDataOwnerNameFilter
import com.icure.cardinal.sdk.model.filter.relatedperson.RelatedPersonByIdsFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.requireUniqueElements
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object RelatedPersonFilters {
	/**
	 * Create options for related person filtering that will match all related persons shared directly (i.e. ignoring
	 * hierarchies) with a specific data owner.
	 *
	 * @param dataOwnerId a data owner id
	 * @return options for related person filtering
	 */
	fun allRelatedPersonsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<RelatedPerson> =
		AllForDataOwner(EntityReferenceInGroup(groupId = null, entityId = dataOwnerId))

	/**
	 * In group version of [allRelatedPersonsForDataOwner].
	 */
	fun allRelatedPersonsForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
	): BaseFilterOptions<RelatedPerson> = AllForDataOwner(dataOwner)

	/**
	 * Create options for related person filtering that will match all related persons shared directly (i.e. ignoring
	 * hierarchies) with the current data owner.
	 *
	 * @return options for related person filtering
	 */
	fun allRelatedPersonsForSelf(): FilterOptions<RelatedPerson> =
		AllForSelf

	/**
	 * Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 * hierarchies) with a specific data owner that have at least an identifier that has the same exact
	 * [Identifier.system] and [Identifier.value] as one of the provided [identifiers]. Other properties of the provided
	 * identifiers are ignored.
	 *
	 * @param dataOwnerId a data owner id
	 * @param identifiers a list of identifiers
	 * @return options for related person filtering
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>
	): BaseFilterOptions<RelatedPerson> =
		ByIdentifiersForDataOwner(identifiers, EntityReferenceInGroup(entityId = dataOwnerId, groupId = null))

	/**
	 * In group version of [byIdentifiersForDataOwner].
	 */
	fun byIdentifiersForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		identifiers: List<Identifier>
	): BaseFilterOptions<RelatedPerson> =
		ByIdentifiersForDataOwner(identifiers, dataOwner)

	/**
	 * Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 * hierarchies) with the current data owner that have at least an identifier that has the same exact
	 * [Identifier.system] and [Identifier.value] as one of the provided [identifiers]. Other properties of the provided
	 * identifiers are ignored.
	 *
	 * @param identifiers a list of identifiers
	 * @return options for related person filtering
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>
	): FilterOptions<RelatedPerson> = ByIdentifiersForSelf(identifiers)

	/**
	 * Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 * hierarchies) with a specific data owner where the concatenation of [RelatedPerson.lastName] and
	 * [RelatedPerson.firstName] contains the provided (sanitized) [name].
	 *
	 * @param dataOwnerId a data owner id
	 * @param name the name to search
	 * @return options for related person filtering
	 */
	fun byNameForDataOwner(
		dataOwnerId: String,
		name: String
	): BaseFilterOptions<RelatedPerson> =
		ByNameForDataOwner(name, EntityReferenceInGroup(entityId = dataOwnerId, groupId = null))

	/**
	 * In group version of [byNameForDataOwner].
	 */
	fun byNameForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		name: String
	): BaseFilterOptions<RelatedPerson> =
		ByNameForDataOwner(name, dataOwner)

	/**
	 * Options for related person filtering which match all the related persons shared directly (i.e. ignoring
	 * hierarchies) with the current data owner where the concatenation of [RelatedPerson.lastName] and
	 * [RelatedPerson.firstName] contains the provided (sanitized) [name].
	 *
	 * @param name the name to search
	 * @return options for related person filtering
	 */
	fun byNameForSelf(
		name: String
	): FilterOptions<RelatedPerson> = ByNameForSelf(name)

	/**
	 * Filter options that match all related persons with one of the provided ids.
	 * These options are sortable. When sorting using these options the related persons will have the same order as the
	 * input ids.
	 *
	 * @param ids a list of unique related person ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): BaseSortableFilterOptions<RelatedPerson> = ByIds(ids)

	@Serializable
	internal class AllForDataOwner(
		val dataOwnerId: EntityReferenceInGroup
	): BaseFilterOptions<RelatedPerson>

	@Serializable
	internal data object AllForSelf: FilterOptions<RelatedPerson>

	@Serializable
	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwnerId: EntityReferenceInGroup
	): BaseFilterOptions<RelatedPerson>

	@Serializable
	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>,
	): FilterOptions<RelatedPerson>

	@Serializable
	internal class ByNameForDataOwner(
		val name: String,
		val dataOwnerId: EntityReferenceInGroup
	): BaseFilterOptions<RelatedPerson>

	@Serializable
	internal class ByNameForSelf(
		val name: String,
	): FilterOptions<RelatedPerson>

	@Serializable
	internal class ByIds(
		val ids: List<String>
	): BaseSortableFilterOptions<RelatedPerson> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}
}

@InternalIcureApi
internal suspend fun mapRelatedPersonFilterOptions(
	filterOptions: FilterOptions<RelatedPerson>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<RelatedPerson> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapRelatedPersonFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapRelatedPersonFilterOptions(
	filterOptions: FilterOptions<RelatedPerson>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<RelatedPerson> = mapIfMetaFilterOptions(filterOptions) {
	mapRelatedPersonFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is RelatedPersonFilters.AllForDataOwner -> {
		RelatedPersonByDataOwnerNameFilter(
			name = null,
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is RelatedPersonFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		RelatedPersonByDataOwnerNameFilter(
			name = null,
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is RelatedPersonFilters.ByIds -> {
		RelatedPersonByIdsFilter(ids = filterOptions.ids.toSet())
	}
	is RelatedPersonFilters.ByIdentifiersForDataOwner -> {
		RelatedPersonByDataOwnerIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is RelatedPersonFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		RelatedPersonByDataOwnerIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is RelatedPersonFilters.ByNameForDataOwner -> {
		RelatedPersonByDataOwnerNameFilter(
			name = filterOptions.name,
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is RelatedPersonFilters.ByNameForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		RelatedPersonByDataOwnerNameFilter(
			name = filterOptions.name,
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	else -> {
		throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering RelatedPersons")
	}
}
