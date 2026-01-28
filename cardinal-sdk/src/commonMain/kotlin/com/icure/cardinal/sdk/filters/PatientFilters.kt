package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.Telecom
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByDataOwnerTagFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyNameFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.requireUniqueElements
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object PatientFilters {
	/**
	 * Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *
	 * @param dataOwnerId a data owner id
	 * @return options for patient filtering
	 */
	fun allPatientsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Patient> =
		AllForDataOwner(EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [allPatientsForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun allPatientsForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
	): BaseFilterOptions<Patient> =
		AllForDataOwner(dataOwner)

	/**
	 * Create options for patient filtering that will match all patients shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *
	 * @return options for patient filtering
	 */
	fun allPatientsForSelf(): FilterOptions<Patient> =
		AllForSelf

	/**
	 * Filter options that match all patients with one of the provided ids.
	 * These options are sortable. When sorting using these options the patients will have the same order as the input ids.
	 *
	 * @param ids a list of unique patient ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): SortableFilterOptions<Patient> =
		ByIds(ids)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the patients will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 *
	 * @param identifiers a list of identifiers
	 * @param dataOwnerId a data owner id
	 * @return options for patient filtering
	 */
	fun byIdentifiersForDataOwner(
		dataOwnerId: String,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<Patient> =
		ByIdentifiersForDataOwner(identifiers, EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [byIdentifiersForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byIdentifiersForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		identifiers: List<Identifier>
	): BaseSortableFilterOptions<Patient> =
		ByIdentifiersForDataOwner(identifiers, dataOwner)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
	 * [Patient.ssin] matching one of the provided ssins.
	 * These options are sortable. When sorting using these options the patients will be in the same order as the
	 * provided ssins.
	 *
	 * @param ssins a list of ssins
	 * @param dataOwnerId a data owner id
	 */
	fun bySsinsForDataOwner(
		dataOwnerId: String,
		ssins: List<String>
	): BaseSortableFilterOptions<Patient> = BySsinsForDataOwner(ssins, EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [bySsinsForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun bySsinsForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		ssins: List<String>
	): BaseSortableFilterOptions<Patient> = BySsinsForDataOwner(ssins, dataOwner)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have
	 * [Patient.dateOfBirth] between the provided values (inclusive).
	 * These options are sortable. When sorting using these options the patients will be ordered by date of birth.
	 *
	 * @param fromDate the start date in YYYYMMDD format (inclusive)
	 * @param toDate the end date in YYYYMMDD format (inclusive)
	 * @param dataOwnerId a data owner id
	 */
	fun byDateOfBirthBetweenForDataOwner(
		dataOwnerId: String,
		fromDate: Int,
		toDate: Int
	): BaseSortableFilterOptions<Patient> = ByDateOfBirthBetweenForDataOwner(
		fromDate = fromDate,
		toDate = toDate,
		dataOwner = EntityReferenceInGroup(dataOwnerId, null)
	)

	/**
	 * In-group version of [byDateOfBirthBetweenForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byDateOfBirthBetweenForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		fromDate: Int,
		toDate: Int
	): BaseSortableFilterOptions<Patient> = ByDateOfBirthBetweenForDataOwner(
		fromDate = fromDate,
		toDate = toDate,
		dataOwner = dataOwner
	)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 * provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
	 * [Patient.spouseName].
	 *
	 * @param searchString part of a patient name.
	 * @param dataOwnerId a data owner id
	 */
	fun byFuzzyNameForDataOwner(
		dataOwnerId: String,
		searchString: String
	): BaseFilterOptions<Patient> =
		ByNameForDataOwner(searchString, EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [byFuzzyNameForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byFuzzyNameForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		searchString: String
	): BaseFilterOptions<Patient> =
		ByNameForDataOwner(searchString, dataOwner)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 * provided [Patient.gender], and optionally also the provided [Patient.education] and [Patient.profession].
	 * Note you can only provide profession if you have provided the education.
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered first by education
	 * then by profession.
	 *
	 * @param gender the patient gender.
	 * @param education the patient education. If not provided patient the education of the patient will be ignored by
	 * this filter.
	 * @param profession the patient profession. If not provided patient the profession of the patient will be ignored by
	 * this filter.
	 * @param dataOwnerId a data owner id
	 * @throws IllegalArgumentException if [profession] is not null and [education] is null.
	 */
	fun byGenderEducationProfessionForDataOwner(
		dataOwnerId: String,
		gender: Gender,
		@DefaultValue("null")
		education: String? = null,
		@DefaultValue("null")
		profession: String? = null
	): BaseSortableFilterOptions<Patient> =
		ByGenderEducationProfessionForDataOwner(
			gender = gender,
			education = education,
			profession = profession,
			dataOwner = EntityReferenceInGroup(dataOwnerId, null)
		)

	/**
	 * In-group version of [byGenderEducationProfessionForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byGenderEducationProfessionForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		gender: Gender,
		@DefaultValue("null")
		education: String? = null,
		@DefaultValue("null")
		profession: String? = null
	): BaseSortableFilterOptions<Patient> =
		ByGenderEducationProfessionForDataOwner(
			gender = gender,
			education = education,
			profession = profession,
			dataOwner = dataOwner
		)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 * provided [Patient.active] value.
	 *
	 * @param active true if the options should match active patients, false if it should match inactive patients.
	 * @param dataOwnerId a data owner id
	 */
	fun byActiveForDataOwner(
		dataOwnerId: String,
		active: Boolean
	) : BaseFilterOptions<Patient> = ByActiveForDataOwner(active, EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [byActiveForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byActiveForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		active: Boolean
	) : BaseFilterOptions<Patient> = ByActiveForDataOwner(active, dataOwner)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
	 * starts with the provided [searchString].
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
	 * the matching telecom number.
	 *
	 * @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
	 * @param dataOwnerId a data owner id
	 */
	fun byTelecomForDataOwner(
		dataOwnerId: String,
		searchString: String
	) : BaseSortableFilterOptions<Patient> = ByTelecomForDataOwner(searchString, EntityReferenceInGroup(dataOwnerId, null))

	/**
	 * In-group version of [byTelecomForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byTelecomForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		searchString: String
	) : BaseSortableFilterOptions<Patient> = ByTelecomForDataOwner(searchString, dataOwner)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an [Patient.addresses] where the [Address.street] or [Address.city] contain the provided [searchString] and
	 * [Address.postalCode] matches the provided [postalCode].
	 * Additionally you can limit the search to a specific house number.
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 * by the matching portion of street+city, then by postal code and finally by house number.
	 *
	 * @param searchString part of a patient address street or city
	 * @param postalCode the patient postal code
	 * @param houseNumber the patient house number
	 * @param dataOwnerId a data owner id
	 */
	fun byAddressPostalCodeHouseNumberForDataOwner(
		dataOwnerId: String,
		searchString: String,
		postalCode: String,
		@DefaultValue("null")
		houseNumber: String? = null
	) : BaseSortableFilterOptions<Patient> =
		ByAddressPostalCodeHouseNumberForDataOwner(
			searchString = searchString,
			postalCode = postalCode,
			houseNumber = houseNumber,
			dataOwner = EntityReferenceInGroup(dataOwnerId, null),
		)

	/**
	 * In-group version of [byAddressPostalCodeHouseNumberForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byAddressPostalCodeHouseNumberForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		searchString: String,
		postalCode: String,
		@DefaultValue("null")
		houseNumber: String? = null
	) : BaseSortableFilterOptions<Patient> =
		ByAddressPostalCodeHouseNumberForDataOwner(
			searchString = searchString,
			postalCode = postalCode,
			houseNumber = houseNumber,
			dataOwner = dataOwner,
		)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
	 * an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
	 * [searchString].
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 * by the matching portion of street+postalCode+city, then by postal code and finally by house number.
	 *
	 * @param searchString part of a patient address street, postal code, or city
	 * @param dataOwnerId a data owner id
	 */
	fun byAddressForDataOwner(
		dataOwnerId: String,
		searchString: String
	) : BaseSortableFilterOptions<Patient> =
		ByAddressForDataOwner(
			searchString = searchString,
			dataOwner = EntityReferenceInGroup(dataOwnerId, null)
		)

	/**
	 * In-group version of [byAddressForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byAddressForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		searchString: String
	) : BaseSortableFilterOptions<Patient> =
		ByAddressForDataOwner(
			searchString = searchString,
			dataOwner = dataOwner
		)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
	 * [identifiers]. Other properties of the provided identifiers are ignored.
	 *
	 * These options are sortable. When sorting using these options the patients will be in the same order as the input
	 * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
	 * sorting.
	 *
	 * @param identifiers a list of identifiers
	 * @return options for patient filtering
	 */
	fun byIdentifiersForSelf(
		identifiers: List<Identifier>
	): SortableFilterOptions<Patient> =
		ByIdentifiersForSelf(identifiers)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
	 * [Patient.ssin] matching one of the provided ssins.
	 * These options are sortable. When sorting using these options the patients will be in the same order as the
	 * provided ssins.
	 *
	 * @param ssins a list of ssins
	 */
	fun bySsinsForSelf(
		ssins: List<String>
	): SortableFilterOptions<Patient> = BySsinsForSelf(ssins)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have
	 * [Patient.dateOfBirth] between the provided values (inclusive).
	 * These options are sortable. When sorting using these options the patients will be ordered by date of birth.
	 *
	 * @param fromDate the start date in YYYYMMDD format (inclusive)
	 * @param toDate the end date in YYYYMMDD format (inclusive)
	 */
	fun byDateOfBirthBetweenForSelf(
		fromDate: Int,
		toDate: Int
	): SortableFilterOptions<Patient> = ByDateOfBirthBetweenForSelf(
		fromDate = fromDate,
		toDate = toDate,
	)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 * provided search string contained within [Patient.firstName], [Patient.lastName], [Patient.maidenName], or
	 * [Patient.spouseName].
	 *
	 * @param searchString part of a patient name.
	 */
	fun byNameForSelf(
		searchString: String
	): FilterOptions<Patient> = ByNameForSelf(searchString)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 * provided [Patient.gender], and optionally also the provided [Patient.education] and [Patient.profession].
	 * Note you can only provide profession if you have provided the education.
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered first by education
	 * then by profession.
	 *
	 * @param gender the patient gender.
	 * @param education the patient education. If not provided patient the education of the patient will be ignored by
	 * this filter.
	 * @param profession the patient profession. If not provided patient the profession of the patient will be ignored by
	 * this filter.
	 * @throws IllegalArgumentException if [profession] is not null and [education] is null.
	 */
	fun byGenderEducationProfessionForSelf(
		gender: Gender,
		@DefaultValue("null")
		education: String? = null,
		@DefaultValue("null")
		profession: String? = null
	): SortableFilterOptions<Patient> =
		ByGenderEducationProfessionForSelf(
			gender = gender,
			education = education,
			profession = profession,
		)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 * provided [Patient.active] value.
	 *
	 * @param active true if the options should match active patients, false if it should match inactive patients.
	 */
	fun byActiveForSelf(
		active: Boolean
	) : FilterOptions<Patient> = ByActiveForSelf(active)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an address with a [Patient.addresses] where one of the [Address.telecoms] has a [Telecom.telecomNumber] that
	 * starts with the provided [searchString].
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically by
	 * the matching telecom number.
	 *
	 * @param searchString start of a patient telecom. Non-alphanumeric characters are ignored.
	 */
	fun byTelecomForSelf(
		searchString: String
	) : SortableFilterOptions<Patient> = ByTelecomForSelf(searchString)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an [Patient.addresses] where the [Address.street] or [Address.city] contain the provided [searchString] and
	 * [Address.postalCode] matches the provided [postalCode].
	 * Additionally you can limit the search to a specific house number.
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 * by the matching portion of street+city, then by postal code and finally by house number.
	 *
	 * @param searchString part of a patient address street or city
	 * @param postalCode the patient postal code
	 * @param houseNumber the patient house number
	 */
	fun byAddressPostalCodeHouseNumberForSelf(
		searchString: String,
		postalCode: String,
		@DefaultValue("null")
		houseNumber: String? = null
	) : SortableFilterOptions<Patient> =
		ByAddressPostalCodeHouseNumberForSelf(
			searchString = searchString,
			postalCode = postalCode,
			houseNumber = houseNumber
		)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
	 * an [Patient.addresses] where the [Address.street], [Address.postalCode] or [Address.city] contain the provided
	 * [searchString].
	 *
	 * These options are sortable. When sorting using these options the patients will be ordered lexicographically first
	 * by the matching portion of street+postalCode+city, then by postal code and finally by house number.
	 *
	 * @param searchString part of a patient address street, postal code, or city
	 */
	fun byAddressForSelf(
		searchString: String
	) : SortableFilterOptions<Patient> = ByAddressForSelf(searchString = searchString)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with the current data owner
	 * where in [Patient.tags] there is at least one tag with type equal to [tagType] and code equal to [tagCode].
	 *
	 * @param tagType the tag type to search.
	 * @param tagCode the code type.
	 */
	fun byTagForSelf(
		tagType: String,
		tagCode: String? = null,
	) : FilterOptions<Patient> = ByTagForSelf(tagType = tagType, tagCode = tagCode)

	/**
	 * Options for patient filtering which match all the patients shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * where in [Patient.tags] there is at least one tag with type equal to [tagType] and code equal to [tagCode].
	 *
	 * @param dataOwnerId the id of the data owner.
	 * @param tagType the tag type to search.
	 * @param tagCode the code type.
	 */
	fun byTagForDataOwner(
		dataOwnerId: String,
		tagType: String,
		tagCode: String? = null,
	) : BaseFilterOptions<Patient> = ByTagForDataOwner(dataOwner = EntityReferenceInGroup(dataOwnerId, null), tagType = tagType, tagCode = tagCode)

	/**
	 * In-group version of [byTagForDataOwner].
	 * The data owner can be from a different group than the group of the user executing the query.
	 */
	fun byTagForDataOwnerInGroup(
		dataOwner: EntityReferenceInGroup,
		tagType: String,
		tagCode: String? = null,
	) : BaseFilterOptions<Patient> = ByTagForDataOwner(dataOwner = dataOwner, tagType = tagType, tagCode = tagCode)


	@Serializable
	internal class ByIds(
		val ids: List<String>
	) : SortableFilterOptions<Patient> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}

	@Serializable
	internal class AllForDataOwner(
		val dataOwner: EntityReferenceInGroup
	) : BaseFilterOptions<Patient>

	@Serializable
	internal data object AllForSelf : FilterOptions<Patient>

	@Serializable
	internal class ByIdentifiersForDataOwner(
		val identifiers: List<Identifier>,
		val dataOwner: EntityReferenceInGroup
	) : BaseSortableFilterOptions<Patient>

	@Serializable
	internal class BySsinsForDataOwner(
		val ssins: List<String>,
		val dataOwner: EntityReferenceInGroup
	): BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByDateOfBirthBetweenForDataOwner(
		val fromDate: Int,
		val toDate: Int,
		val dataOwner: EntityReferenceInGroup
	): BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByNameForDataOwner(
		val searchString: String,
		val dataOwner: EntityReferenceInGroup
	) : BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByGenderEducationProfessionForDataOwner(
		val gender: Gender,
		val education: String?,
		val profession: String?,
		val dataOwner: EntityReferenceInGroup
	): BaseSortableFilterOptions<Patient> {
		init {
			require (profession == null || education != null) {
				"You must provide a value for education if you want to filter by profession"
			}
		}
	}

	@Serializable
	internal class ByActiveForDataOwner(
		val active: Boolean,
		val dataOwner: EntityReferenceInGroup
	) : BaseFilterOptions<Patient>

	@Serializable
	internal class ByTelecomForDataOwner(
		val searchString: String,
		val dataOwner: EntityReferenceInGroup
	) : BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByAddressPostalCodeHouseNumberForDataOwner(
		val searchString: String,
		val postalCode: String,
		val houseNumber: String?,
		val dataOwner: EntityReferenceInGroup
	) : BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByAddressForDataOwner(
		val searchString: String,
		val dataOwner: EntityReferenceInGroup
	) : BaseSortableFilterOptions<Patient>

	@Serializable
	internal class ByIdentifiersForSelf(
		val identifiers: List<Identifier>
	) : SortableFilterOptions<Patient>

	@Serializable
	internal class BySsinsForSelf(
		val ssins: List<String>
	): SortableFilterOptions<Patient>

	@Serializable
	internal class ByDateOfBirthBetweenForSelf(
		val fromDate: Int,
		val toDate: Int
	): SortableFilterOptions<Patient>

	@Serializable
	internal class ByNameForSelf(
		val searchString: String
	) : SortableFilterOptions<Patient>

	@Serializable
	internal class ByGenderEducationProfessionForSelf(
		val gender: Gender,
		val education: String?,
		val profession: String?
	): SortableFilterOptions<Patient> {
		init {
			require (profession == null || education != null) {
				"You must provide a value for education if you want to filter by profession"
			}
		}
	}

	@Serializable
	internal class ByActiveForSelf(
		val active: Boolean
	) : FilterOptions<Patient>

	@Serializable
	internal class ByTelecomForSelf(
		val searchString: String
	) : SortableFilterOptions<Patient>

	@Serializable
	internal class ByAddressPostalCodeHouseNumberForSelf(
		val searchString: String,
		val postalCode: String,
		val houseNumber: String?
	) : SortableFilterOptions<Patient>

	@Serializable
	internal class ByAddressForSelf(
		val searchString: String
	) : SortableFilterOptions<Patient>

	@Serializable
	internal class ByTagForDataOwner(
		val dataOwner: EntityReferenceInGroup,
		val tagType: String,
		val tagCode: String?
	) : BaseFilterOptions<Patient>

	@Serializable
	internal class ByTagForSelf(
		val tagType: String,
		val tagCode: String?
	) : FilterOptions<Patient>
}

@InternalIcureApi
internal suspend fun mapPatientFilterOptions(
	filterOptions: FilterOptions<Patient>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<Patient> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapPatientFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapPatientFilterOptions(
	filterOptions: FilterOptions<Patient>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<Patient> = mapIfMetaFilterOptions(filterOptions) {
	mapPatientFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is PatientFilters.AllForDataOwner -> {
		PatientByHcPartyFilter(
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	PatientFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyFilter(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
		)
	}
	is PatientFilters.ByIds -> {
		PatientByIdsFilter(ids = filterOptions.ids.toSet())
	}
	is PatientFilters.ByActiveForDataOwner -> {
		PatientByHcPartyAndActiveFilter(
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			active = filterOptions.active
		)
	}
	is PatientFilters.ByAddressForDataOwner -> {
		PatientByHcPartyAndAddressFilter(
			searchString = filterOptions.searchString,
			postalCode = null,
			houseNumber = null,
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByAddressPostalCodeHouseNumberForDataOwner -> {
		PatientByHcPartyAndAddressFilter(
			searchString = filterOptions.searchString,
			postalCode = filterOptions.postalCode,
			houseNumber = filterOptions.houseNumber,
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByDateOfBirthBetweenForDataOwner -> {
		if (filterOptions.fromDate == filterOptions.toDate) {
			PatientByHcPartyDateOfBirthFilter(
				dateOfBirth = filterOptions.fromDate,
				healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		} else {
			PatientByHcPartyDateOfBirthBetweenFilter(
				minDateOfBirth = filterOptions.fromDate,
				maxDateOfBirth = filterOptions.toDate,
				healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		}
	}
	is PatientFilters.ByNameForDataOwner -> {
		PatientByHcPartyNameFilter(
			name = filterOptions.searchString,
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByGenderEducationProfessionForDataOwner -> {
		PatientByHcPartyGenderEducationProfession(
			gender = filterOptions.gender,
			education = filterOptions.education,
			profession = filterOptions.profession,
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByIdentifiersForDataOwner -> {
		PatientByHcPartyAndIdentifiersFilter(
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			identifiers = filterOptions.identifiers
		)
	}
	is PatientFilters.BySsinsForDataOwner -> {
		if (filterOptions.ssins.size == 1) {
			PatientByHcPartyAndSsinFilter(
				ssin = filterOptions.ssins.first(),
				healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		} else {
			PatientByHcPartyAndSsinsFilter(
				ssins = filterOptions.ssins,
				healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		}
	}
	is PatientFilters.ByTelecomForDataOwner -> {
		PatientByHcPartyAndTelecomFilter(
			searchString = filterOptions.searchString,
			healthcarePartyId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByActiveForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyAndActiveFilter(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			active = filterOptions.active
		)
	}
	is PatientFilters.ByAddressForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyAndAddressFilter(
			searchString = filterOptions.searchString,
			postalCode = null,
			houseNumber = null,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByAddressPostalCodeHouseNumberForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyAndAddressFilter(
			searchString = filterOptions.searchString,
			postalCode = filterOptions.postalCode,
			houseNumber = filterOptions.houseNumber,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByDateOfBirthBetweenForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		if (filterOptions.fromDate == filterOptions.toDate) {
			PatientByHcPartyDateOfBirthFilter(
				dateOfBirth = filterOptions.fromDate,
				healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		} else {
			PatientByHcPartyDateOfBirthBetweenFilter(
				minDateOfBirth = filterOptions.fromDate,
				maxDateOfBirth = filterOptions.toDate,
				healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		}
	}
	is PatientFilters.ByNameForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyNameFilter(
			name = filterOptions.searchString,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByGenderEducationProfessionForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyGenderEducationProfession(
			gender = filterOptions.gender,
			education = filterOptions.education,
			profession = filterOptions.profession,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByIdentifiersForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyAndIdentifiersFilter(
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			identifiers = filterOptions.identifiers
		)
	}
	is PatientFilters.BySsinsForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		if (filterOptions.ssins.size == 1) {
			PatientByHcPartyAndSsinFilter(
				ssin = filterOptions.ssins.first(),
				healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		} else {
			PatientByHcPartyAndSsinsFilter(
				ssins = filterOptions.ssins,
				healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
			)
		}
	}
	is PatientFilters.ByTelecomForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByHcPartyAndTelecomFilter(
			searchString = filterOptions.searchString,
			healthcarePartyId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup)
		)
	}
	is PatientFilters.ByTagForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		PatientByDataOwnerTagFilter(
			dataOwnerId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode
		)
	}
	is PatientFilters.ByTagForDataOwner -> {
		PatientByDataOwnerTagFilter(
			dataOwnerId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup),
			tagType = filterOptions.tagType,
			tagCode = filterOptions.tagCode
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Patients")
}
