package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByDataOwnerPatientOpeningDate
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByIdsFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.requireUniqueElements
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object HealthElementFilters {
	/**
	 * Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *
	 * @param dataOwnerId a data owner id
	 * @return options for health element filtering
	 */
	fun allHealthElementsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<HealthElement> =
		AllForDataOwner(EntityReferenceInGroup(groupId = null, entityId = dataOwnerId))

	/**
	 * In group version of [allHealthElementsForDataOwner].
	 */
	fun allHealthElementsForDataOwner(
		dataOwner: EntityReferenceInGroup,
	): BaseFilterOptions<HealthElement> = AllForDataOwner(dataOwner)

	/**
	 * Create options for health element filtering that will match all health element shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *
	 * @return options for health element filtering
	 */
	fun allHealthElementsForSelf(): FilterOptions<HealthElement> =
		AllForSelf

	/**
	 * Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the health elements will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 *
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @param identifiers a list of identifiers
	 * @return options for health element filtering
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<HealthElement> =
		ByIdentifiersForDataOwner(identifiers, EntityReferenceInGroup(entityId = dataOwnerId, groupId = null))

	/**
	 * In group version of [byIdentifiersForDataOwner].
	 */
	fun byIdentifiersForDataOwner(
		dataOwner: EntityReferenceInGroup,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<HealthElement> =
		ByIdentifiersForDataOwner(identifiers, dataOwner)

	/**
	 * Options for health element filtering which match all the health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the health elements will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 *
	 * @param identifiers a list of identifiers
	 * @return options for health element filtering
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>
	): SortableFilterOptions<HealthElement> =
		ByIdentifiersForSelf(identifiers)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
	 *
	 * @param dataOwnerId a data owner id
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 */
	fun byCodeForDataOwner(
		dataOwnerId: String,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null
	): BaseSortableFilterOptions<HealthElement> = ByCodeForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId)
	)

	/**
	 * In group version of [byCodeForDataOwner].
	 */
	fun byCodeForDataOwner(
		dataOwner: EntityReferenceInGroup,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null
	): BaseSortableFilterOptions<HealthElement> = ByCodeForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [codeCode].
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 */
	fun byCodeForSelf(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null
	): SortableFilterOptions<HealthElement> = ByCodeForSelf(
		codeType = codeType,
		codeCode = codeCode
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
	 *
	 * @param dataOwnerId a data owner id
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 */
	fun byTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null
	): BaseSortableFilterOptions<HealthElement> = ByTagForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId)
	)

	/**
	 * In group version of [byTagForDataOwner].
	 */
	fun byTagForDataOwner(
		dataOwner: EntityReferenceInGroup,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null
	): BaseSortableFilterOptions<HealthElement> = ByTagForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [tagCode].
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 */
	fun byTagForSelf(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null
	): SortableFilterOptions<HealthElement> = ByTagForSelf(
			tagType = tagType,
			tagCode = tagCode
		)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
	 * the same order as the input patients.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>
	): SortableFilterOptions<HealthElement> = ByPatientsForDataOwner(
		patients = patients.map { Pair(it.toEncryptionMetadataStub(), null) },
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId)
	)

	/**
	 * In group version of [byPatientsForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForDataOwner(
		dataOwner: EntityReferenceInGroup,
		patients: List<GroupScoped<Patient>>
	): SortableFilterOptions<HealthElement> = ByPatientsForDataOwner(
		patients = patients.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		dataOwnerId = dataOwner
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by the patients, using
	 * the same order as the input patients.
	 *
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForSelf(
		patients: List<Patient>
	): SortableFilterOptions<HealthElement> = ByPatientsForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() }
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 *
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>
	): BaseSortableFilterOptions<HealthElement> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId)
	)

	/**
	 * In group version of [byPatientsSecretIdsForDataOwner].
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>
	): BaseSortableFilterOptions<HealthElement> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the health elements will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForSelf(
		secretIds: List<String>
	): SortableFilterOptions<HealthElement> = ByPatientsSecretIdsForSelf(secretIds = secretIds)

	/**
	 * Filter options that match all health elements with one of the provided ids.
	 * These options are sortable. When sorting using these options the health elements will have the same order as the input ids.
	 *
	 * @param ids a list of unique health element ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): BaseSortableFilterOptions<HealthElement> = ByIds(ids)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 * - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsOpeningDateForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<HealthElement> = ByPatientsOpeningDateForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		patients = patients.map { Pair(it.toEncryptionMetadataStub(), null) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In group version of [byPatientsOpeningDateForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsOpeningDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		patients: List<GroupScoped<Patient>>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<HealthElement> = ByPatientsOpeningDateForDataOwner(
		dataOwnerId = dataOwner,
		patients = patients.map { Pair(it.entity.toEncryptionMetadataStub(), it.groupId) },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 * - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsOpeningDateForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<HealthElement> = ByPatientsOpeningDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 * - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	fun byPatientSecretIdsOpeningDateForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<HealthElement> = ByPatientSecretIdsOpeningDateForDataOwner(
		dataOwnerId = EntityReferenceInGroup(groupId = null, entityId = dataOwnerId),
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In group version of [byPatientSecretIdsOpeningDateForDataOwner].
	 */
	fun byPatientSecretIdsOpeningDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<HealthElement> = ByPatientSecretIdsOpeningDateForDataOwner(
		dataOwnerId = dataOwner,
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for health element filtering which match all health elements shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the health elements based on [HealthElement.openingDate]:
	 * - if the [from] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the health elements where [HealthElement.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the health elements will be sorted by [HealthElement.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [HealthElement.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [HealthElement.openingDate] (default: ascending).
	 */
	fun byPatientSecretIdsOpeningDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<HealthElement> = ByPatientSecretIdsOpeningDateForSelf(secretIds, from, to, descending)

	@Serializable
	internal class AllForDataOwner(
		val dataOwnerId: EntityReferenceInGroup
	): BaseFilterOptions<HealthElement>

	@Serializable
	internal data object AllForSelf: FilterOptions<HealthElement>

	@Serializable
	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<HealthElement>

	@Serializable
	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>,
	): SortableFilterOptions<HealthElement>

	@Serializable
	internal class ByCodeForDataOwner(
		val codeType: String,
		val codeCode: String?,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<HealthElement>

	@Serializable
	internal class ByCodeForSelf(
		val codeType: String,
		val codeCode: String?,
	): SortableFilterOptions<HealthElement>

	@Serializable
	internal class ByTagForDataOwner(
		val tagType: String,
		val tagCode: String?,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<HealthElement>

	@Serializable
	internal class ByTagForSelf(
		val tagType: String,
		val tagCode: String?,
	): SortableFilterOptions<HealthElement>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForDataOwner(
		val patients: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val dataOwnerId: EntityReferenceInGroup
	) : SortableFilterOptions<HealthElement>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>
	) : SortableFilterOptions<HealthElement>

	@Serializable
	internal class ByPatientsSecretIdsForDataOwner(
		val secretIds: List<String>,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<HealthElement>

	@Serializable
	internal class ByPatientsSecretIdsForSelf(
		val secretIds: List<String>
	): SortableFilterOptions<HealthElement>

	@Serializable
	internal class ByIds(
		val ids: List<String>
	): BaseSortableFilterOptions<HealthElement> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val patients: List<Pair<EntityWithEncryptionMetadataStub, String?>>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<HealthElement>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<HealthElement>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : BaseSortableFilterOptions<HealthElement>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<HealthElement>
}

@InternalIcureApi
internal suspend fun mapHealthElementFilterOptions(
	filterOptions: FilterOptions<HealthElement>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<HealthElement> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapHealthElementFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapHealthElementFilterOptions(
	filterOptions: FilterOptions<HealthElement>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<HealthElement> = mapIfMetaFilterOptions(filterOptions) {
	mapHealthElementFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is HealthElementFilters.AllForDataOwner -> {
		HealthElementByHcPartyFilter(hcpId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup))
	}
	is HealthElementFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByHcPartyFilter(hcpId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup))
	}
	is HealthElementFilters.ByIds -> {
		HealthElementByIdsFilter(ids = filterOptions.ids.toSet())
	}
	is HealthElementFilters.ByCodeForDataOwner -> {
		HealthElementByHcPartyTagCodeFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByIdentifiersForDataOwner -> {
		HealthElementByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			hcPartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByPatientsForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			patientSecretForeignKeys = filterOptions.patients.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByPatientsSecretIdsForDataOwner -> {
		HealthElementByDataOwnerPatientOpeningDate(
			patientSecretForeignKeys = filterOptions.secretIds.toSet(),
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByTagForDataOwner -> {
		HealthElementByHcPartyTagCodeFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}

	is HealthElementFilters.ByCodeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByHcPartyTagCodeFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			hcPartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByPatientsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			patientSecretForeignKeys = filterOptions.patients.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByPatientsSecretIdsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			patientSecretForeignKeys = filterOptions.secretIds.toSet(),
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByTagForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByHcPartyTagCodeFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is HealthElementFilters.ByPatientsOpeningDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			patientSecretForeignKeys = filterOptions.patients.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is HealthElementFilters.ByPatientsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			patientSecretForeignKeys = filterOptions.patients.map { Pair(it, null) }.mapToSecretIds(
				entityEncryptionService,
				EntityWithEncryptionMetadataTypeName.Patient
			),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	is HealthElementFilters.ByPatientSecretIdsOpeningDateForDataOwner -> HealthElementByDataOwnerPatientOpeningDate(
		healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		patientSecretForeignKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.from,
		endDate = filterOptions.to,
		descending = filterOptions.descending
	)
	is HealthElementFilters.ByPatientSecretIdsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		HealthElementByDataOwnerPatientOpeningDate(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			patientSecretForeignKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.from,
			endDate = filterOptions.to,
			descending = filterOptions.descending
		)
	}
	else -> {
		throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering HealthElements")
	}
}
