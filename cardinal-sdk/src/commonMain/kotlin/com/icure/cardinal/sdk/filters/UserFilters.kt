package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.user.AllUsersFilter
import com.icure.cardinal.sdk.model.filter.user.UserByHealthcarePartyIdFilter
import com.icure.cardinal.sdk.model.filter.user.UserByIdsFilter
import com.icure.cardinal.sdk.model.filter.user.UserByNameEmailPhoneFilter
import com.icure.cardinal.sdk.model.filter.user.UsersByPatientIdFilter
import com.icure.cardinal.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object UserFilters {
	/**
	 * Filter options to match all users.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<User> = All

	/**
	 * Filter options that match all users with one of the provided ids.
	 * These options are sortable. When sorting using these options the users will have the same order as the input ids.
	 *
	 * @param ids a list of unique user ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): BaseSortableFilterOptions<User> = ByIds(ids)

	/**
	 * Filter options that match all users linked to the provided patient id.
	 * These options are not sortable.
	 *
	 * @param patientId a patient id
	 */
	fun byPatientId(patientId: String): BaseFilterOptions<User> = ByPatientId(patientId)

	/**
	 * Filter options that match all users linked to the provided healthcare party id.
	 * These options are not sortable.
	 *
	 * @param healthcarePartyId healthcare party id
	 */
	fun byHealthcarePartyId(healthcarePartyId: String): BaseFilterOptions<User> = ByHealthcarePartyId(healthcarePartyId)

	/**
	 * Filter options that match all users that have a word starting with [searchString] in [User.login], [User.name],
	 * [User.email] or [User.mobilePhone].
	 * These options are not sortable.
	 */
	fun byNameEmailOrPhone(searchString: String): BaseFilterOptions<User> = ByNameEmailOrPhone(searchString)

	@Serializable
	internal data object All: BaseFilterOptions<User>

	@Serializable
	internal class ByIds(val ids: List<String>): BaseSortableFilterOptions<User> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}

	@Serializable
	internal class ByPatientId(val patientId: String): BaseFilterOptions<User>

	@Serializable
	internal class ByHealthcarePartyId(val healthcarePartyId: String): BaseFilterOptions<User>

	@Serializable
	internal class ByNameEmailOrPhone(val searchString: String): BaseFilterOptions<User>
}

internal suspend fun mapUserFilterOptions(
	filterOptions: FilterOptions<User>
): AbstractFilter<User> = mapIfMetaFilterOptions(filterOptions, ::mapUserFilterOptions) ?: when (filterOptions) {
	UserFilters.All -> AllUsersFilter()
	is UserFilters.ByNameEmailOrPhone -> UserByNameEmailPhoneFilter(searchString = filterOptions.searchString)
	is UserFilters.ByPatientId -> UsersByPatientIdFilter(patientId = filterOptions.patientId)
	is UserFilters.ByHealthcarePartyId -> UserByHealthcarePartyIdFilter(healthcarePartyId = filterOptions.healthcarePartyId)
	is UserFilters.ByIds -> UserByIdsFilter(ids = filterOptions.ids.toSet())
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Devices")
}
