package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.embed.SubContact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByAssociationIdFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByIdsFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByQualifiedLinkFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceBySecretForeignKeys
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.requireUniqueElements
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object ServiceFilters {
	/**
	 * Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id
	 * @return options for service filtering
	 */
	fun allServicesForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Service> = AllForDataOwner(
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [allServicesForDataOwner].
	 */
	fun allServicesForDataOwner(
		dataOwner: EntityReferenceInGroup
	): BaseFilterOptions<Service> = AllForDataOwner(
		dataOwnerId = dataOwner
	)


	/**
	 * Create options for service filtering that will match all services shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * @return options for service filtering
	 */
	fun allServicesForSelf(): FilterOptions<Service> =
		AllForSelf

	/**
	 * Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the services will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param identifiers a list of identifiers
	 * @param dataOwnerId a data owner id
	 * @return options for service filtering
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>,
	): BaseSortableFilterOptions<Service> = ByIdentifiersForDataOwner(
		identifiers = identifiers,
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byIdentifiersForDataOwner].
	 */
	fun byIdentifiersForDataOwner(
		dataOwner: EntityReferenceInGroup,
		identifiers: List<Identifier>,
	): BaseSortableFilterOptions<Service> = ByIdentifiersForDataOwner(
		identifiers = identifiers,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 * if the first is missing), but in that case you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
	 * by [Service.valueDate].
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfServiceValueDate if provided the options will match only services with a value date
	 * that is after this value (inclusive).
	 * @param endOfServiceValueDate if provided the options will match only services with a value date
	 * that is before this value (inclusive).
	 * @param dataOwnerId a data owner id
	 * @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
	 */
	fun byCodeAndValueDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): BaseSortableFilterOptions<Service> = ByCodeAndValueDateForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byCodeAndValueDateForDataOwner].
	 */
	fun byCodeAndValueDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): BaseSortableFilterOptions<Service> = ByCodeAndValueDateForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 * if the first is missing), but in that case you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
	 * by [Service.valueDate].
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfServiceValueDate if provided the options will match only services with a value date
	 * that is after this value (inclusive).
	 * @param endOfServiceValueDate if provided the options will match only services with a value date
	 * that is before this value (inclusive).
	 * @param dataOwnerId a data owner id
	 * @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
	 */
	fun byTagAndValueDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): BaseSortableFilterOptions<Service> = ByTagAndValueDateForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byTagAndValueDateForDataOwner].
	 */
	fun byTagAndValueDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): BaseSortableFilterOptions<Service> = ByTagAndValueDateForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
		dataOwnerId = dataOwner
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by the patients, using
	 * the same order as the input patients.
	 * @param patients a list of patients.
	 * @param dataOwnerId a data owner id
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
	): SortableFilterOptions<Service> = ByPatientsForDataOwner(
		patients = patients.map { it.toEncryptionMetadataStub() },
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byPatientsForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForDataOwner(
		dataOwner: EntityReferenceInGroup,
		patients: List<Patient>,
	): SortableFilterOptions<Service> = ByPatientsForDataOwner(
		patients = patients.map { it.toEncryptionMetadataStub() },
		dataOwnerId = dataOwner
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the services will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 * @param secretIds a list of patients secret ids
	 * @param dataOwnerId a data owner id
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
	): BaseSortableFilterOptions<Service> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byPatientsSecretIdsForDataOwner].
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>,
	): BaseSortableFilterOptions<Service> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = dataOwner
	)


	/**
	 * Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with a specific data owner that exist in at
	 * least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
	 * id.
	 *
	 * These options are sortable. When sorting using these options the services will be sorted in the same order as the
	 * input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
	 * health element service is considered for the ordering.
	 * @param healthElementIds a list of health element ids
	 * @param dataOwnerId a data owner id
	 */
	fun byHealthElementIdFromSubContactForDataOwner(
		dataOwnerId: String,
		healthElementIds: List<String>,
	): BaseSortableFilterOptions<Service> = ByHealthElementIdFromSubcontactForDataOwner(
		healthElementIds = healthElementIds,
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null)
	)

	/**
	 * In group version of [byHealthElementIdFromSubContactForDataOwner].
	 */
	fun byHealthElementIdFromSubContactForDataOwner(
		dataOwner: EntityReferenceInGroup,
		healthElementIds: List<String>,
	): BaseSortableFilterOptions<Service> = ByHealthElementIdFromSubcontactForDataOwner(
		healthElementIds = healthElementIds,
		dataOwnerId = dataOwner
	)


	/**
	 * Options for service filtering which match all the services shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the services will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param identifiers a list of identifiers
	 * @return options for service filtering
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>,
	): SortableFilterOptions<Service> =
		ByIdentifiersForSelf(identifiers)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 * if the first is missing), but in that case you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted first by [codeCode] then
	 * by [Service.valueDate].
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfServiceValueDate if provided the options will match only services with a value date
	 * that is after this value (inclusive).
	 * @param endOfServiceValueDate if provided the options will match only services with a value date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the value date but no [codeCode].
	 */
	fun byCodeAndValueDateForSelf(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): SortableFilterOptions<Service> = ByCodeAndValueDateForSelf(
		codeType = codeType,
		codeCode = codeCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only services that are within a certain [Service.valueDate] timeframe (or [Service.openingDate]
	 * if the first is missing), but in that case you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted first by [tagCode] then
	 * by [Service.valueDate].
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfServiceValueDate if provided the options will match only services with a value date
	 * that is after this value (inclusive).
	 * @param endOfServiceValueDate if provided the options will match only services with a value date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the value date but no [tagCode].
	 */
	fun byTagAndValueDateForSelf(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfServiceValueDate: Long? = null,
		@DefaultValue("null")
		endOfServiceValueDate: Long? = null,
	): SortableFilterOptions<Service> = ByTagAndValueDateForSelf(
		tagType = tagType,
		tagCode = tagCode,
		startOfServiceValueDate = startOfServiceValueDate,
		endOfServiceValueDate = endOfServiceValueDate,
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by the patients, using
	 * the same order as the input patients.
	 *
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForSelf(
		patients: List<Patient>,
	): SortableFilterOptions<Service> = ByPatientsForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the services will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 *
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForSelf(
		secretIds: List<String>,
	): SortableFilterOptions<Service> = ByPatientsSecretIdsForSelf(
		secretIds = secretIds,
	)


	/**
	 * Options for service filtering which match all services from shared directly (i.e. ignoring hierarchies) with the current data owner that exist in at
	 * least a [SubContact] (from [Contact.subContacts]) where [SubContact.healthElementId] matches one of the provided
	 * id.
	 *
	 * These options are sortable. When sorting using these options the services will be sorted in the same order as the
	 * input health element ids. If a service exists in multiple subcontacts only the first subcontact with matching
	 * health element service is considered for the ordering.
	 *
	 * @param healthElementIds a list of health element ids
	 */
	fun byHealthElementIdFromSubContactForSelf(
		healthElementIds: List<String>,
	): SortableFilterOptions<Service> = ByHealthElementIdFromSubcontactForSelf(
		healthElementIds = healthElementIds,
	)

	/**
	 * Filter options that match all services with one of the provided ids.
	 * These options are sortable. When sorting using these options the services will have the same order as the input ids.
	 *
	 * @param ids a list of unique service ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): BaseSortableFilterOptions<Service> = ByIds(ids)

	/**
	 * Filter options that match all the services where in at least one of the maps in [Service.qualifiedLinks] values there is a key equal
	 * to [associationId].
	 *
	 * @param associationId the association id to search for.
	 */
	fun byAssociationId(
		associationId: String,
	): BaseFilterOptions<Service> = ByAssociationId(associationId)

	/**
	 * Filter options that match all the services where in the values of the maps that are in the values of [Service.qualifiedLinks] there
	 * is a value contained in [linkValues].
	 * If a [linkQualification] is provided, the search will be restricted to the map corresponding to the [linkQualification] key in
	 * [Service.qualifiedLinks].
	 *
	 * @param linkValues the values to search in the values of the maps that are values of [Service.qualifiedLinks].
	 * @param linkQualification a key of [Service.qualifiedLinks].
	 */
	fun byQualifiedLink(
		linkValues: List<String>,
		@DefaultValue("null")
		linkQualification: LinkQualification? = null
	): BaseFilterOptions<Service> = ByQualifiedLink(linkValues, linkQualification)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the services based on [Service.valueDate]:
	 * - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 * If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsDateForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Service> = ByPatientsDateForDataOwner(
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null),
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * In group version of [byPatientsDateForDataOwner].
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Service> = ByPatientsDateForDataOwner(
		dataOwnerId = dataOwner,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the services based on [Service.valueDate]:
	 * - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 * If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsDateForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Service> = ByPatientsDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the services based on [Service.valueDate]:
	 * - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 * If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	fun byPatientSecretIdsDateForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<Service> = ByPatientSecretIdsDateForDataOwner(
		dataOwnerId = EntityReferenceInGroup(entityId = dataOwnerId, groupId = null),
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	fun byPatientSecretIdsDateForDataOwner(
		dataOwner: EntityReferenceInGroup,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : BaseSortableFilterOptions<Service> = ByPatientSecretIdsDateForDataOwner(
		dataOwnerId = dataOwner,
		secretIds = secretIds,
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for service filtering which match all services shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the services based on [Service.valueDate]:
	 * - if the [from] fuzzy date is not null, only the services where [Service.valueDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the services where [Service.valueDate] is less than or equal to [to] will be returned.
	 * If the [Service.valueDate] is null for a specific service, [Service.openingDate] will be used instead.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by [Service.valueDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Service.valueDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Service.valueDate] (default: ascending).
	 */
	fun byPatientSecretIdsDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Service> = ByPatientSecretIdsDateForSelf(secretIds, from, to, descending)

	@Serializable
	internal class AllForDataOwner(
		val dataOwnerId: EntityReferenceInGroup
	) : BaseFilterOptions<Service>

	@Serializable
	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwnerId: EntityReferenceInGroup,
	) : BaseSortableFilterOptions<Service>

	@Serializable
	internal class ByCodeAndValueDateForDataOwner(
		val codeType: String,
		val codeCode: String?,
		val startOfServiceValueDate: Long?,
		val endOfServiceValueDate: Long?,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<Service> {
		init {
			require (codeCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
				"Code code is mandatory if you want to restrict the range of service value date"
			}
		}
	}

	@Serializable
	internal class ByTagAndValueDateForDataOwner(
		val tagType: String,
		val tagCode: String?,
		val startOfServiceValueDate: Long?,
		val endOfServiceValueDate: Long?,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<Service> {
		init {
			require (tagCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
				"Tag code is mandatory if you want to restrict the range of service value date"
			}
		}
	}

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForDataOwner(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val dataOwnerId: EntityReferenceInGroup,
	): SortableFilterOptions<Service>

	@Serializable
	internal class ByPatientsSecretIdsForDataOwner(
		val secretIds: List<String>,
		val dataOwnerId: EntityReferenceInGroup,
	): BaseSortableFilterOptions<Service>

	@Serializable
	internal class ByHealthElementIdFromSubcontactForDataOwner(
		val healthElementIds: List<String>,
		val dataOwnerId: EntityReferenceInGroup
	): BaseSortableFilterOptions<Service>

	@Serializable
	internal data object AllForSelf : FilterOptions<Service>

	@Serializable
	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>
	) : SortableFilterOptions<Service>

	@Serializable
	internal class ByCodeAndValueDateForSelf(
		val codeType: String,
		val codeCode: String?,
		val startOfServiceValueDate: Long?,
		val endOfServiceValueDate: Long?
	): SortableFilterOptions<Service> {
		init {
			require (codeCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
				"Code code is mandatory if you want to restrict the range of service value date"
			}
		}
	}

	@Serializable
	internal class ByTagAndValueDateForSelf(
		val tagType: String,
		val tagCode: String?,
		val startOfServiceValueDate: Long?,
		val endOfServiceValueDate: Long?
	): SortableFilterOptions<Service> {
		init {
			require (tagCode != null || (startOfServiceValueDate == null && endOfServiceValueDate == null)) {
				"Tag code is mandatory if you want to restrict the range of service value date"
			}
		}
	}

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>
	): SortableFilterOptions<Service>

	@Serializable
	internal class ByPatientsSecretIdsForSelf(
		val secretIds: List<String>
	): SortableFilterOptions<Service>

	@Serializable
	internal class ByHealthElementIdFromSubcontactForSelf(
		val healthElementIds: List<String>
	): SortableFilterOptions<Service>

	@Serializable
	internal class ByIds(
		val ids: List<String>
	): BaseSortableFilterOptions<Service> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}

	@Serializable
	internal class ByAssociationId(
		val associationId: String
	): BaseFilterOptions<Service>

	@Serializable
	internal class ByQualifiedLink(
		val linkValues: List<String>,
		val linkQualification: LinkQualification?
	): BaseFilterOptions<Service>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsDateForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Service>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Service>

	@Serializable
	internal class ByPatientSecretIdsDateForDataOwner(
		val dataOwnerId: EntityReferenceInGroup,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : BaseSortableFilterOptions<Service>

	@Serializable
	internal class ByPatientSecretIdsDateForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Service>
}

@InternalIcureApi
internal suspend fun mapServiceFilterOptions(
	filterOptions: FilterOptions<Service>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<Service> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapServiceFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapServiceFilterOptions(
	filterOptions: FilterOptions<Service>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<Service> = mapIfMetaFilterOptions(filterOptions) {
	mapServiceFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
}?: when (filterOptions) {
	is ServiceFilters.AllForDataOwner -> {
		ServiceByHcPartyFilter(
			hcpId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	ServiceFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByHcPartyFilter(
			hcpId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByCodeAndValueDateForDataOwner -> {
		ServiceByHcPartyTagCodeDateFilter(
			patientSecretForeignKeys = null,
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startValueDate = filterOptions.startOfServiceValueDate,
			endValueDate = filterOptions.endOfServiceValueDate,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByHealthElementIdFromSubcontactForDataOwner -> {
		ServiceByHcPartyHealthElementIdsFilter(
			healthElementIds = filterOptions.healthElementIds,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByIdentifiersForDataOwner -> {
		ServiceByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByPatientsForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceBySecretForeignKeys(
			patientSecretForeignKeys = entityEncryptionService.secretIdsOf(
				null,
				filterOptions.patients,
				EntityWithEncryptionMetadataTypeName.Patient,
				null
			).values.flatten().toSet(),
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByPatientsSecretIdsForDataOwner -> {
		ServiceBySecretForeignKeys(
			patientSecretForeignKeys = filterOptions.secretIds.toSet(),
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByTagAndValueDateForDataOwner -> {
		ServiceByHcPartyTagCodeDateFilter(
			patientSecretForeignKeys = null,
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startValueDate = filterOptions.startOfServiceValueDate,
			endValueDate = filterOptions.endOfServiceValueDate,
			healthcarePartyId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByCodeAndValueDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByHcPartyTagCodeDateFilter(
			patientSecretForeignKeys = null,
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startValueDate = filterOptions.startOfServiceValueDate,
			endValueDate = filterOptions.endOfServiceValueDate,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByHealthElementIdFromSubcontactForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByHcPartyHealthElementIdsFilter(
			healthElementIds = filterOptions.healthElementIds,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByPatientsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceBySecretForeignKeys(
			patientSecretForeignKeys = entityEncryptionService.secretIdsOf(
				null,
				filterOptions.patients,
				EntityWithEncryptionMetadataTypeName.Patient,
				null
			).values.flatten().toSet(),
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByPatientsSecretIdsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceBySecretForeignKeys(
			patientSecretForeignKeys = filterOptions.secretIds.toSet(),
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByTagAndValueDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByHcPartyTagCodeDateFilter(
			patientSecretForeignKeys = null,
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startValueDate = filterOptions.startOfServiceValueDate,
			endValueDate = filterOptions.endOfServiceValueDate,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is ServiceFilters.ByIds -> ServiceByIdsFilter(ids = filterOptions.ids.toSet())
	is ServiceFilters.ByAssociationId -> ServiceByAssociationIdFilter(associationId = filterOptions.associationId)
	is ServiceFilters.ByQualifiedLink -> ServiceByQualifiedLinkFilter(linkValues = filterOptions.linkValues, linkQualification = filterOptions.linkQualification)
	is ServiceFilters.ByPatientsDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByDataOwnerPatientDateFilter(
			dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ServiceFilters.ByPatientsDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ServiceFilters.ByPatientSecretIdsDateForDataOwner -> ServiceByDataOwnerPatientDateFilter(
		dataOwnerId = filterOptions.dataOwnerId.asReferenceStringInGroup(requestGroup, boundGroup),
		secretForeignKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is ServiceFilters.ByPatientSecretIdsDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		ServiceByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			secretForeignKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Services")
}
