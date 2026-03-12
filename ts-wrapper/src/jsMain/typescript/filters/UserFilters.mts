// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalUserFiltersObj} from '../cardinal-sdk-ts.mjs';
import {User} from '../model/User.mjs';


interface UserFiltersFactory {

	/**
	 *
	 *  Filter options to match all users.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<User>;

	/**
	 *
	 *  Filter options that match all users with one of the provided ids.
	 *  These options are sortable. When sorting using these options the users will have the same order as the input ids.
	 *
	 *  @param ids a list of unique user ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<User>;

	/**
	 *
	 *  Filter options that match all users linked to the provided patient id.
	 *  These options are not sortable.
	 *
	 *  @param patientId a patient id
	 */
	byPatientId(patientId: string): BaseFilterOptions<User>;

	/**
	 *
	 *  Filter options that match all users linked to the provided healthcare party id.
	 *  These options are not sortable.
	 *
	 *  @param healthcarePartyId healthcare party id
	 */
	byHealthcarePartyId(healthcarePartyId: string): BaseFilterOptions<User>;

	/**
	 *
	 *  Filter options that match all users that have a word starting with [searchString] in [User.login], [User.name],
	 *  [User.email] or [User.mobilePhone].
	 *  These options are not sortable.
	 */
	byNameEmailOrPhone(searchString: string): BaseFilterOptions<User>;

}

export const UserFilters: UserFiltersFactory = {
			all: () => InternalUserFiltersObj.getInstance().all(),
			byIds: (ids) => InternalUserFiltersObj.getInstance().byIds(ids),
			byPatientId: (patientId) => InternalUserFiltersObj.getInstance().byPatientId(patientId),
			byHealthcarePartyId: (healthcarePartyId) => InternalUserFiltersObj.getInstance().byHealthcarePartyId(healthcarePartyId),
			byNameEmailOrPhone: (searchString) => InternalUserFiltersObj.getInstance().byNameEmailOrPhone(searchString)
		};
