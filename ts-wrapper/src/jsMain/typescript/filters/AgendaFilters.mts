// auto-generated file
import {BaseFilterOptions, InternalAgendaFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


interface AgendaFiltersFactory {

	/**
	 *
	 *  Filter options to match all agendas.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userId].
	 *
	 *  @param userId the id of the user associated to the agenda.
	 */
	byUser(userId: string): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userReference].
	 *
	 *  @param userReference the id of the user associated to the agenda.
	 */
	byUserInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userId].
	 *
	 *  @param userId the id of that can read the agenda.
	 */
	readableByUser(userId: string): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userReference].
	 *
	 *  @param userReference the id of that can read the agenda.
	 */
	readableByUserInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.userRights] contains [userId].
	 *
	 *  @param userId the id of that can read the agenda.
	 */
	readableByUserRights(userId: string): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.userRights] contains [userReference].
	 *
	 *  @param userReference the id of that can read the agenda.
	 */
	readableByUserRightsInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 *  and a typed value with a string value equals to [propertyValue].
	 *
	 *  @param propertyId the id of the property.
	 *  @param propertyValue the string value of the property.
	 */
	byStringProperty(propertyId: string, propertyValue: string): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 *  and a typed value with a boolean value equals to [propertyValue].
	 *
	 *  @param propertyId the id of the property.
	 *  @param propertyValue the boolean value of the property.
	 */
	byBooleanProperty(propertyId: string, propertyValue: boolean): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 *  and a typed value with a long value equals to [propertyValue].
	 *
	 *  @param propertyId the id of the property.
	 *  @param propertyValue the long value of the property.
	 */
	byLongProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 *  and a typed value with a double value equals to [propertyValue].
	 *
	 *  @param propertyId the id of the property.
	 *  @param propertyValue the double value of the property.
	 */
	byDoubleProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	/**
	 *
	 *  Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId].
	 *
	 *  @param propertyId the id of the property.
	 */
	withProperty(propertyId: string): BaseFilterOptions<Agenda>;

}

export const AgendaFilters: AgendaFiltersFactory = {
			all: () => InternalAgendaFiltersObj.getInstance().all(),
			byUser: (userId) => InternalAgendaFiltersObj.getInstance().byUser(userId),
			byUserInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().byUserInGroup(userReference),
			readableByUser: (userId) => InternalAgendaFiltersObj.getInstance().readableByUser(userId),
			readableByUserInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUserInGroup(userReference),
			readableByUserRights: (userId) => InternalAgendaFiltersObj.getInstance().readableByUserRights(userId),
			readableByUserRightsInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUserRightsInGroup(userReference),
			byStringProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byStringProperty(propertyId, propertyValue),
			byBooleanProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byBooleanProperty(propertyId, propertyValue),
			byLongProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byLongProperty(propertyId, propertyValue),
			byDoubleProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byDoubleProperty(propertyId, propertyValue),
			withProperty: (propertyId) => InternalAgendaFiltersObj.getInstance().withProperty(propertyId)
		};
