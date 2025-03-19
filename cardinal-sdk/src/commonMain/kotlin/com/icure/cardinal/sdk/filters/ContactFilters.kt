package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.embed.SubContact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerFormIdsFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerPatientOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerServiceCodeFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerServiceTagFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByExternalIdFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByServiceIdsFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object ContactFilters {
	/**
	 * Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id
	 */
	fun allContactsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Contact> = AllByDataOwner(dataOwnerId)

	/**
	 * Create options for contact filtering that will match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner.
	 */
	fun allContactsForSelf(): FilterOptions<Contact> = AllForSelf

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with a specific data owner where
	 * there is at least one [Contact.subContacts] or [Contact.services] with one of the provided [formIds] in [SubContact.formId] or
	 * [Service.formIds], respectively.
	 *
	 * @param dataOwnerId a data owner id.
	 * @param formIds a set of form ids.
	 */
	fun byFormIdsForDataOwner(
		dataOwnerId: String,
		formIds: Set<String>
	): BaseFilterOptions<Contact> = ByFormIdsForDataOwner(dataOwnerId, formIds)

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with the current data owner where
	 * there is at least one [Contact.subContacts] or [Contact.services] with one of the provided [formIds] in [SubContact.formId] or
	 * [Service.formIds], respectively.
	 *
	 * @param formIds a set of form ids.
	 */
	fun byFormIdsForSelf(
		formIds: Set<String>
	): FilterOptions<Contact> = ByFormIdsForSelf(formIds)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 * - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
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
	) : SortableFilterOptions<Contact> = ByPatientsOpeningDateForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 * - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsOpeningDateForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
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
	) : SortableFilterOptions<Contact> = ByPatientsOpeningDateForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 * - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
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
	) : BaseSortableFilterOptions<Contact> = ByPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the contacts based on [Contact.openingDate]:
	 * - if the [from] fuzzy date is not null, only the contacts where [Contact.openingDate] is greater than or equal to [from] will be returned.
	 * - if the [to] fuzzy date is not null, only the contacts where [Contact.openingDate] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by [Contact.openingDate] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param to the maximum fuzzy date for [Contact.openingDate], in the YYYYMMDDHHMMSS format (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Contact.openingDate] (default: ascending).
	 */
	fun byPatientSecretIdsOpeningDateForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	) : SortableFilterOptions<Contact> = ByPatientSecretIdsOpeningDateForSelf(secretIds, from, to, descending)

	/**
	 * Options for contact filtering which match all the contacts where [Contact.externalId] is equal to [externalId].
	 *
	 * @param externalId the external id to search.
	 */
	fun byExternalId(
		externalId: String
	) : BaseFilterOptions<Contact> = ByExternalId(externalId)

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with the current data owner that
	 * have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 *
	 * @param identifiers a list of identifiers
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>
	): SortableFilterOptions<Contact> = ByIdentifiersForSelf(identifiers)

	/**
	 * Options for contact filtering which match all the contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that have at least an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the contacts will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 * @param dataOwnerId a data owner id
	 * @param identifiers a list of identifiers
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<Contact> = ByIdentifiersForDataOwner(identifiers, dataOwnerId)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific
	 * data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 * by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	fun byCodeAndOpeningDateForDataOwner(
		dataOwnerId: String,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
	): BaseSortableFilterOptions<Contact> = ByCodeAndOpeningDateForDataOwner(
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain code.
	 * If you specify only the [codeType] you will get all entities that have at least a code of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [codeCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [codeCode] then
	 * by [Contact.openingDate].
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [codeCode].
	 */
	fun byCodeAndOpeningDateForSelf(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null,
	): SortableFilterOptions<Contact> = ByCodeAndOpeningDateForSelf(
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 * by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	fun byTagAndOpeningDateForDataOwner(
		dataOwnerId: String,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null
	): BaseSortableFilterOptions<Contact> = ByTagAndOpeningDateForDataOwner(
		tagType = tagType,
		tagCode = tagCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * You can also limit the timeframe of the contacts:
	 * - If the [startDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is greater than or equal to [startDate] will be returned.
	 * - If the [endDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is less than or equal to [startDate] will be returned.
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [Contact.openingDate].
	 *
	 * @param dataOwnerId a data owner id.
	 * with a tag of the provided type.
	 * @param startDate a fuzzy date. If provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endDate a fuzzy date. If provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @param descending whether to return in descending or ascending order by [Contact.openingDate]. (default: ascending).
	 */
	fun byOpeningDateForDataOwner(
		dataOwnerId: String,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Contact> = ByOpeningDateForDataOwner(
		dataOwnerId = dataOwnerId,
		startDate = startDate,
		endDate = endDate,
		descending = descending
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * You can also limit the timeframe of the contacts:
	 * - If the [startDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is greater than or equal to [startDate] will be returned.
	 * - If the [endDate] fuzzy date is specified, only the contacts where [Contact.openingDate] is less than or equal to [startDate] will be returned.
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [Contact.openingDate].
	 *
	 * with a tag of the provided type.
	 * @param startDate a fuzzy date. If provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endDate a fuzzy date. If provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @param descending whether to return in descending or ascending order by [Contact.openingDate]. (default: ascending).
	 */
	fun byOpeningDateForSelf(
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Contact> = ByOpeningDateForSelf(
		startDate = startDate,
		endDate = endDate,
		descending = descending
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where in [Contact.services] there is at least one service that in his tags has a code stub with the specified type and the specified
	 * code (if provided).
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 */
	fun byServiceTagForSelf(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
	): FilterOptions<Contact> = ByServiceTagForSelf(
		tagType = tagType,
		tagCode = tagCode,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where in [Contact.services] there is at least one service that in his tags has a code stub with the specified type and the specified
	 * code (if provided).
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 */
	fun byServiceTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
	): BaseFilterOptions<Contact> = ByServiceTagForDataOwner(
		dataOwnerId = dataOwnerId,
		tagType = tagType,
		tagCode = tagCode,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where in [Contact.services] there is at least one service that in his codes has a code stub with the specified type and the specified
	 * code (if provided).
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 */
	fun byServiceCodeForSelf(
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
	): FilterOptions<Contact> = ByServiceCodeForSelf(
		codeType = codeType,
		codeCode = codeCode,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where in [Contact.services] there is at least one service that in his codes has a code stub with the specified type and the specified
	 * code (if provided).
	 *
	 * @param codeType a code type
	 * @param codeCode a code for the provided code type, or null if you want the filter to accept any entity
	 * with a code of the provided type.
	 */
	fun byServiceCodeForDataOwner(
		dataOwnerId: String,
		codeType: String,
		@DefaultValue("null")
		codeCode: String? = null,
	): BaseFilterOptions<Contact> = ByServiceCodeForDataOwner(
		dataOwnerId = dataOwnerId,
		codeType = codeType,
		codeCode = codeCode,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that have a certain tag.
	 * If you specify only the [tagType] you will get all entities that have at least a tag of that type.
	 *
	 * You can also limit the result to only contacts that are within a certain opening date timeframe, but in that case
	 * you must specify the [tagCode].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted first by [tagCode] then
	 * by [Contact.openingDate].
	 *
	 * @param tagType a tag type
	 * @param tagCode a code for the provided tag type, or null if you want the filter to accept any entity
	 * with a tag of the provided type.
	 * @param startOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is after this value (inclusive).
	 * @param endOfContactOpeningDate if provided the options will match only contacts with an opening date
	 * that is before this value (inclusive).
	 * @throws IllegalArgumentException if you provide a range for the opening date but no [tagCode].
	 */
	fun byTagAndOpeningDateForSelf(
		tagType: String,
		@DefaultValue("null")
		tagCode: String? = null,
		@DefaultValue("null")
		startOfContactOpeningDate: Long? = null,
		@DefaultValue("null")
		endOfContactOpeningDate: Long? = null
	): SortableFilterOptions<Contact> = ByTagAndOpeningDateForSelf(
		tagType = tagType,
		tagCode = tagCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 * the same order as the input patients.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>
	): SortableFilterOptions<Contact> = ByPatientsForDataOwner(
		patients = patients.map { it.toEncryptionMetadataStub() },
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with one
	 * of the provided patients.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientsSecretIdsForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the contacts will be sorted by the patients, using
	 * the same order as the input patients.
	 *
	 * @param patients a list of patients.
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsForSelf(
		patients: List<Patient>
	): SortableFilterOptions<Contact> = ByPatientsForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() }
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with a specific data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 *
	 * @param dataOwnerId a data owner id
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>
	): BaseSortableFilterOptions<Contact> = ByPatientsSecretIdsForDataOwner(
		secretIds = secretIds,
		dataOwnerId = dataOwnerId
	)

	/**
	 * Options for contact filtering which match all contacts shared directly (i.e. ignoring hierarchies) with the current data owner that are linked with a
	 * patient through one of the provided secret ids.
	 * These options are sortable. When sorting using these options the contacts will be sorted by the linked patients
	 * secret id, using the same order as the input.
	 *
	 * @param secretIds a list of patients secret ids
	 */
	fun byPatientsSecretIdsForSelf(
		secretIds: List<String>
	): SortableFilterOptions<Contact> = ByPatientsSecretIdsForSelf(
		secretIds = secretIds,
	)


	/**
	 * Options for contact filtering which match all contacts that have at least a service with an id in [serviceIds].
	 * These options are sortable. When sorting using these options the contacts will be sorted in the same order as the
	 * input service ids. If a contact has multiple services only the first matching service is considered.
	 *
	 * @param serviceIds a list of service ids
	 */
	fun byServiceIds(
		serviceIds: List<String>,
	): BaseSortableFilterOptions<Contact> = ByServiceIds(
		serviceIds = serviceIds
	)

	@Serializable
	internal class AllByDataOwner(
		val dataOwnerId: String
	) : BaseFilterOptions<Contact>

	@Serializable
	internal data object AllForSelf : FilterOptions<Contact>

	@Serializable
	internal class ByFormIdsForDataOwner(
		val dataOwnerId: String,
		val formIds: Set<String>
	) : BaseFilterOptions<Contact>

	@Serializable
	internal class ByFormIdsForSelf(
		val formIds: Set<String>
	) : FilterOptions<Contact>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Contact>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsOpeningDateForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Contact>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : BaseSortableFilterOptions<Contact>

	@Serializable
	internal class ByPatientSecretIdsOpeningDateForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	) : SortableFilterOptions<Contact>

	@Serializable
	internal class ByExternalId(
		val externalId: String
	) : BaseFilterOptions<Contact>

	@Serializable
	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwnerId: String
	) : BaseSortableFilterOptions<Contact>

	@Serializable
	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>
	) : SortableFilterOptions<Contact>

	@Serializable
	internal class ByCodeAndOpeningDateForDataOwner(
		val codeType: String,
		val codeCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact> {
		init {
			require (codeCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Code code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	@Serializable
	internal class ByCodeAndOpeningDateForSelf(
		val codeType: String,
		val codeCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?
	): SortableFilterOptions<Contact> {
		init {
			require (codeCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Code code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	@Serializable
	internal class ByTagAndOpeningDateForDataOwner(
		val tagType: String,
		val tagCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact> {
		init {
			require (tagCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Tag code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	@Serializable
	internal class ByTagAndOpeningDateForSelf(
		val tagType: String,
		val tagCode: String?,
		val startOfContactOpeningDate: Long?,
		val endOfContactOpeningDate: Long?,
	): SortableFilterOptions<Contact> {
		init {
			require (tagCode != null || (startOfContactOpeningDate == null && endOfContactOpeningDate == null)) {
				"Tag code is mandatory if you want to restrict the range of contact opening date"
			}
		}
	}

	@Serializable
	internal class ByOpeningDateForDataOwner(
		val startDate: Long?,
		val endDate: Long?,
		val dataOwnerId: String,
		val descending: Boolean
	): BaseSortableFilterOptions<Contact>

	@Serializable
	internal class ByOpeningDateForSelf(
		val startDate: Long?,
		val endDate: Long?,
		val descending: Boolean
	): SortableFilterOptions<Contact>

	@Serializable
	internal class ByServiceTagForDataOwner(
		val tagType: String,
		val tagCode: String?,
		val dataOwnerId: String
	): BaseFilterOptions<Contact>

	@Serializable
	internal class ByServiceTagForSelf(
		val tagType: String,
		val tagCode: String?,
	): FilterOptions<Contact>

	@Serializable
	internal class ByServiceCodeForDataOwner(
		val codeType: String,
		val codeCode: String?,
		val dataOwnerId: String
	): BaseFilterOptions<Contact>

	@Serializable
	internal class ByServiceCodeForSelf(
		val codeType: String,
		val codeCode: String?,
	): FilterOptions<Contact>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForDataOwner(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
	): SortableFilterOptions<Contact>

	@Serializable
	internal class ByPatientsSecretIdsForDataOwner(
		val secretIds: List<String>,
		val dataOwnerId: String
	): BaseSortableFilterOptions<Contact>

	@Serializable
	internal class ByPatientsSecretIdsForSelf(
		val secretIds: List<String>,
	): SortableFilterOptions<Contact>

	@Serializable
	internal class ByServiceIds(
		val serviceIds: List<String>,
	): BaseSortableFilterOptions<Contact>
}

@InternalIcureApi
internal suspend fun mapContactFilterOptions(
	filterOptions: FilterOptions<Contact>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Contact> = mapIfMetaFilterOptions(filterOptions) {
	mapContactFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is ContactFilters.AllByDataOwner -> ContactByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
	is ContactFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyFilter(hcpId = selfDataOwnerId)
	}
	is ContactFilters.ByFormIdsForDataOwner -> ContactByDataOwnerFormIdsFilter(dataOwnerId = filterOptions.dataOwnerId, formIds = filterOptions.formIds)
	is ContactFilters.ByFormIdsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerFormIdsFilter(dataOwnerId = selfDataOwnerId, formIds = filterOptions.formIds)
	}
	is ContactFilters.ByPatientsOpeningDateForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ContactFilters.ByPatientsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ContactFilters.ByPatientSecretIdsOpeningDateForDataOwner -> ContactByDataOwnerPatientOpeningDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretForeignKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is ContactFilters.ByPatientSecretIdsOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerPatientOpeningDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretForeignKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ContactFilters.ByExternalId -> ContactByExternalIdFilter(filterOptions.externalId)
	is ContactFilters.ByCodeAndOpeningDateForDataOwner -> {
		ContactByHcPartyTagCodeDateFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByCodeAndOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyTagCodeDateFilter(
			tagType = null,
			tagCode = null,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByIdentifiersForDataOwner -> ContactByHcPartyIdentifiersFilter(
		identifiers = filterOptions.identifiers,
		healthcarePartyId = filterOptions.dataOwnerId
	)
	is ContactFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyIdentifiersFilter(
			identifiers = filterOptions.identifiers,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByPatientsForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().distinct(),
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByPatientsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Patient, null).values.flatten().distinct(),
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByPatientsSecretIdsForDataOwner -> {
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.secretIds,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByPatientsSecretIdsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyPatientTagCodeDateFilter(
			patientSecretForeignKeys = filterOptions.secretIds,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByServiceIds -> {
		ContactByServiceIdsFilter(
			ids = filterOptions.serviceIds
		)
	}
	is ContactFilters.ByTagAndOpeningDateForDataOwner -> {
		ContactByHcPartyTagCodeDateFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is ContactFilters.ByTagAndOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByHcPartyTagCodeDateFilter(
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
			codeType = null,
			codeCode = null,
			startOfContactOpeningDate = filterOptions.startOfContactOpeningDate,
			endOfContactOpeningDate = filterOptions.endOfContactOpeningDate,
			healthcarePartyId = selfDataOwnerId
		)
	}
	is ContactFilters.ByOpeningDateForDataOwner -> ContactByDataOwnerOpeningDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		startDate = filterOptions.startDate,
		endDate = filterOptions.endDate,
		descending = filterOptions.descending
	)
	is ContactFilters.ByOpeningDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerOpeningDateFilter(
			dataOwnerId = selfDataOwnerId,
			startDate = filterOptions.startDate,
			endDate = filterOptions.endDate,
			descending = filterOptions.descending
		)
	}
	is ContactFilters.ByServiceTagForDataOwner -> ContactByDataOwnerServiceTagFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		tagType = filterOptions.tagType,
		tagCode = filterOptions.tagCode,
	)
	is ContactFilters.ByServiceTagForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerServiceTagFilter(
			dataOwnerId = selfDataOwnerId,
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode,
		)
	}
	is ContactFilters.ByServiceCodeForDataOwner -> ContactByDataOwnerServiceCodeFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		codeType = filterOptions.codeType,
		codeCode = filterOptions.codeCode,
	)
	is ContactFilters.ByServiceCodeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ContactByDataOwnerServiceCodeFilter(
			dataOwnerId = selfDataOwnerId,
			codeType = filterOptions.codeType,
			codeCode = filterOptions.codeCode,
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Contacts")
}
