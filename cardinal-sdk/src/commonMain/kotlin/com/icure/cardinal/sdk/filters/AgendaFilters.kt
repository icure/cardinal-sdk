package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaByTypedPropertyFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaReadableByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaReadableByUserRightsFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaWithPropertyFilter
import com.icure.cardinal.sdk.model.filter.agenda.AllAgendasFilter
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object AgendaFilters {
	/**
	 * Filter options to match all agendas.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<Agenda> = All

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userId].
	 *
	 * @param userId the id of the user associated to the agenda.
	 */
	fun byUser(
		userId: String
	): BaseFilterOptions<Agenda> = ByUserId(EntityReferenceInGroup(userId, null))

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userReference].
	 *
	 * @param userReference the id of the user associated to the agenda.
	 */
	fun byUserInGroup(
		userReference: EntityReferenceInGroup,
	): BaseFilterOptions<Agenda> = ByUserId(userReference)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userId].
	 *
	 * @param userId the id of that can read the agenda.
	 */
	@Deprecated(
		message = "Use readableByUserRights instead",
		ReplaceWith(
			expression = "readableByUserRights(userId)",
		)
	)
	fun readableByUser(
		userId: String
	): BaseFilterOptions<Agenda> = ReadableByUserId(EntityReferenceInGroup(userId, null))

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userReference].
	 *
	 * @param userReference the id of that can read the agenda.
	 */
	@Deprecated(
		message = "Use readableByUserRights instead",
		ReplaceWith(
			expression = "readableByUserRights(userReference)",
		)
	)
	fun readableByUserInGroup(
		userReference: EntityReferenceInGroup
	): BaseFilterOptions<Agenda> = ReadableByUserId(userReference)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userRights] contains [userId].
	 *
	 * @param userId the id of that can read the agenda.
	 */
	fun readableByUserRights(
		userId: String
	): BaseFilterOptions<Agenda> = ReadableByUserRights(EntityReferenceInGroup(userId, null))

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userRights] contains [userReference].
	 *
	 * @param userReference the id of that can read the agenda.
	 */
	fun readableByUserRightsInGroup(
		userReference: EntityReferenceInGroup
	): BaseFilterOptions<Agenda> = ReadableByUserRights(userReference)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 * and a typed value with a string value equals to [propertyValue].
	 *
	 * @param propertyId the id of the property.
	 * @param propertyValue the string value of the property.
	 */
	fun byStringProperty(
		propertyId: String,
		propertyValue: String
	): BaseFilterOptions<Agenda> = ByPropertyFilter(
		DecryptedPropertyStub(
			id = propertyId,
			typedValue = DecryptedTypedValue(stringValue = propertyValue)
		)
	)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 * and a typed value with a boolean value equals to [propertyValue].
	 *
	 * @param propertyId the id of the property.
	 * @param propertyValue the boolean value of the property.
	 */
	fun byBooleanProperty(
		propertyId: String,
		propertyValue: Boolean
	): BaseFilterOptions<Agenda> = ByPropertyFilter(
		DecryptedPropertyStub(
			id = propertyId,
			typedValue = DecryptedTypedValue(booleanValue = propertyValue)
		)
	)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 * and a typed value with a long value equals to [propertyValue].
	 *
	 * @param propertyId the id of the property.
	 * @param propertyValue the long value of the property.
	 */
	fun byLongProperty(
		propertyId: String,
		propertyValue: Long
	): BaseFilterOptions<Agenda> = ByPropertyFilter(
		DecryptedPropertyStub(
			id = propertyId,
			typedValue = DecryptedTypedValue(integerValue = propertyValue)
		)
	)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId]
	 * and a typed value with a double value equals to [propertyValue].
	 *
	 * @param propertyId the id of the property.
	 * @param propertyValue the double value of the property.
	 */
	fun byDoubleProperty(
		propertyId: String,
		propertyValue: Double
	): BaseFilterOptions<Agenda> = ByPropertyFilter(
		DecryptedPropertyStub(
			id = propertyId,
			typedValue = DecryptedTypedValue(doubleValue = propertyValue)
		)
	)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.properties] contains a property with id equal to [propertyId].
	 *
	 * @param propertyId the id of the property.
	 */
	fun withProperty(
		propertyId: String
	): BaseFilterOptions<Agenda> = WithProperty(propertyId = propertyId)

	@Serializable
	internal data object All : BaseFilterOptions<Agenda>

	@Serializable
	internal class ByUserId(
		val userId: EntityReferenceInGroup
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class ReadableByUserId(
		val userId: EntityReferenceInGroup
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class ReadableByUserRights(
		val userId: EntityReferenceInGroup
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class ByPropertyFilter(
		val property: DecryptedPropertyStub
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class WithProperty(
		val propertyId: String
	): BaseFilterOptions<Agenda>

}

@InternalIcureApi
internal suspend fun mapAgendaFilterOptions(
	filterOptions: FilterOptions<Agenda>,
	config: BasicApiConfiguration,
	requestGroupId: String? = null,
): AbstractFilter<Agenda> = mapAgendaFilterOptions(
	filterOptions = filterOptions,
	boundGroup = config.getBoundGroup(currentCoroutineContext()),
	requestGroupId = requestGroupId,
)

@InternalIcureApi
internal suspend fun mapAgendaFilterOptions(
	filterOptions: FilterOptions<Agenda>,
	boundGroup: SdkBoundGroup?,
	requestGroupId: String? = null,
): AbstractFilter<Agenda> = mapIfMetaFilterOptions(filterOptions) {
	mapAgendaFilterOptions(it, boundGroup, requestGroupId)
} ?: when (filterOptions) {
	is AgendaFilters.All -> AllAgendasFilter()
	is AgendaFilters.ByUserId -> AgendaByUserIdFilter(
		userId = filterOptions.userId.asReferenceStringInGroup(requestGroupId, boundGroup),
		desc = null
	)
	is AgendaFilters.ReadableByUserId -> AgendaReadableByUserIdFilter(
		userId = filterOptions.userId.asReferenceStringInGroup(requestGroupId, boundGroup),
		desc = null
	)
	is AgendaFilters.ReadableByUserRights -> AgendaReadableByUserRightsFilter(
		userId = filterOptions.userId.asReferenceStringInGroup(requestGroupId, boundGroup),
		desc = null
	)
	is AgendaFilters.ByPropertyFilter -> AgendaByTypedPropertyFilter(
		property = filterOptions.property,
		desc = null
	)
	is AgendaFilters.WithProperty -> AgendaWithPropertyFilter(
		propertyId = filterOptions.propertyId,
		desc = null
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Agendas")
}
