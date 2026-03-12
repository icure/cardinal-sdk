// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalCalendarItemFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';


interface CalendarItemFiltersFactory {

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 *  - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForDataOwner].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	byPatientsStartTimeForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  In-group version of [byPatientsStartTimeForDataOwner].
	 *  The data owner and patients can be from a different group than the group of the user executing the query.
	 */
	byPatientsStartTimeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			patients: Array<GroupScoped<Patient>>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients.
	 *  This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 *  - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 *  When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 *  those for filtering.
	 *  If you already have the secret ids of the patient you may instead use [byPatientSecretIdsStartTimeForSelf].
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param patients a list of patients.
	 *  @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	byPatientsStartTimeForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 *  - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *
	 *  These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param dataOwnerId a data owner id
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	byPatientSecretIdsStartTimeForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  In-group version of [byPatientSecretIdsStartTimeForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byPatientSecretIdsStartTimeForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  that are linked with one of the provided patients through one of the provided secret ids.
	 *  This Options also allows to restrict the calendar items based on [CalendarItem.startTime]:
	 *  - if the [from] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is greater than or equal to [from] will be returned.
	 *  - if the [to] fuzzy date is not null, only the calendar items where [CalendarItem.startTime] is less than or equal to [to] will be returned.
	 *
	 *  If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 *  simply be ignored.
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  These options are sortable. When sorting using these options the calendar items will be sorted by [CalendarItem.startTime] in ascending or
	 *  descending order according to the value of the [descending] parameter.
	 *
	 *  @param secretIds a list of patient secret ids.
	 *  @param from the minimum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param to the maximum fuzzy date for [CalendarItem.startTime], in the YYYYMMDDHHMMSS format (default: no limit).
	 *  @param descending whether to sort the result in descending or ascending order by [CalendarItem.startTime] (default: ascending).
	 */
	byPatientSecretIdsStartTimeForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar items filtering which match all the calendar items where [CalendarItem.agendaId] is equal to [agendaId] and
	 *  the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 *  These options are sortable. When sorting using these options, the calendar items will be sorted by [CalendarItem.startTime] in
	 *  ascending or descending order according to the value of the [descending] parameter.
	 *
	 *  @param agendaId the value of [CalendarItem.agendaId] to search.
	 *  @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 *  @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 *  @param descending whether to sort the results in ascending or descending order by [CalendarItem.startTime] (default: ascending).
	 */
	byPeriodAndAgenda(agendaId: string, from: number, to: number,
			options?: { descending?: boolean }): BaseSortableFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 *  @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	byPeriodForDataOwner(dataOwnerId: string, from: number,
			to: number): BaseFilterOptions<CalendarItem>;

	/**
	 *
	 *  In-group version of [byPeriodForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	byPeriodForDataOwnerInGroup(dataOwner: EntityReferenceInGroup, from: number,
			to: number): BaseFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  and where the [CalendarItem.startTime] fuzzy date is between [from] (inclusive) and [to] (inclusive).
	 *
	 *  Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 *  @param from the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the start of the period.
	 *  @param to the fuzzy date (in the YYYYMMDDHHMMSS format) that marks the end of the period.
	 */
	byPeriodForSelf(from: number, to: number): FilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items where [CalendarItem.recurrenceId] is equal to [recurrenceId].
	 *
	 *  @param recurrenceId the recurrence id to filter.
	 */
	byRecurrenceId(recurrenceId: string): FilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with a specific data owner
	 *  and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
	 *  [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 *  @param dataOwnerId a data owner id.
	 *  @param startTimestamp the smallest lifecycle update that the filter will return.
	 *  @param endTimestamp the biggest lifecycle update that the filter will return.
	 *  @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	lifecycleBetweenForDataOwner(dataOwnerId: string, startTimestamp: number | undefined,
			endTimestamp: number | undefined, descending: boolean): BaseFilterOptions<CalendarItem>;

	/**
	 *
	 *  In-group version of [lifecycleBetweenForDataOwner].
	 *  The data owner can be from a different group than the group of the user executing the query.
	 */
	lifecycleBetweenForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): BaseFilterOptions<CalendarItem>;

	/**
	 *
	 *  Options for calendar item filtering which match all calendar items shared directly (i.e. ignoring hierarchies) with the current data owner
	 *  and where the max among [CalendarItem.created], [CalendarItem.modified], and [CalendarItem.deletionDate] is greater or equal than
	 *  [startTimestamp] (if provided) and less than or equal to [endTimestamp] (if provided).
	 *
	 *  @param startTimestamp the smallest lifecycle update that the filter will return.
	 *  @param endTimestamp the biggest lifecycle update that the filter will return.
	 *  @param descending whether to return the results sorted in ascending or descending order by last lifecycle update.
	 */
	lifecycleBetweenForSelf(startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): FilterOptions<CalendarItem>;

}

export const CalendarItemFilters: CalendarItemFiltersFactory = {
			byPatientsStartTimeForDataOwner: (dataOwnerId, patients, options) => InternalCalendarItemFiltersObj.getInstance().byPatientsStartTimeForDataOwner(dataOwnerId, patients, options),
			byPatientsStartTimeForDataOwnerInGroup: (dataOwner, patients, options) => InternalCalendarItemFiltersObj.getInstance().byPatientsStartTimeForDataOwnerInGroup(dataOwner, patients, options),
			byPatientsStartTimeForSelf: (patients, options) => InternalCalendarItemFiltersObj.getInstance().byPatientsStartTimeForSelf(patients, options),
			byPatientSecretIdsStartTimeForDataOwner: (dataOwnerId, secretIds, options) => InternalCalendarItemFiltersObj.getInstance().byPatientSecretIdsStartTimeForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsStartTimeForDataOwnerInGroup: (dataOwner, secretIds, options) => InternalCalendarItemFiltersObj.getInstance().byPatientSecretIdsStartTimeForDataOwnerInGroup(dataOwner, secretIds, options),
			byPatientSecretIdsStartTimeForSelf: (secretIds, options) => InternalCalendarItemFiltersObj.getInstance().byPatientSecretIdsStartTimeForSelf(secretIds, options),
			byPeriodAndAgenda: (agendaId, from, to, options) => InternalCalendarItemFiltersObj.getInstance().byPeriodAndAgenda(agendaId, from, to, options),
			byPeriodForDataOwner: (dataOwnerId, from, to) => InternalCalendarItemFiltersObj.getInstance().byPeriodForDataOwner(dataOwnerId, from, to),
			byPeriodForDataOwnerInGroup: (dataOwner, from, to) => InternalCalendarItemFiltersObj.getInstance().byPeriodForDataOwnerInGroup(dataOwner, from, to),
			byPeriodForSelf: (from, to) => InternalCalendarItemFiltersObj.getInstance().byPeriodForSelf(from, to),
			byRecurrenceId: (recurrenceId) => InternalCalendarItemFiltersObj.getInstance().byRecurrenceId(recurrenceId),
			lifecycleBetweenForDataOwner: (dataOwnerId, startTimestamp, endTimestamp, descending) => InternalCalendarItemFiltersObj.getInstance().lifecycleBetweenForDataOwner(dataOwnerId, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForDataOwnerInGroup: (dataOwner, startTimestamp, endTimestamp, descending) => InternalCalendarItemFiltersObj.getInstance().lifecycleBetweenForDataOwnerInGroup(dataOwner, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForSelf: (startTimestamp, endTimestamp, descending) => InternalCalendarItemFiltersObj.getInstance().lifecycleBetweenForSelf(startTimestamp, endTimestamp, descending)
		};
