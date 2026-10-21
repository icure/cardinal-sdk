// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.AgendaFilters
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalAgendaFiltersObj {
	public fun all(): BaseFilterOptionsJs<AgendaJs> {
		val result = AgendaFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byUser(userId: String): BaseFilterOptionsJs<AgendaJs> {
		val userIdConverted: String = userId
		val result = AgendaFilters.byUser(
			userIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byUserInGroup(userReference: EntityReferenceInGroupJs): BaseFilterOptionsJs<AgendaJs> {
		val userReferenceConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(userReference)
		val result = AgendaFilters.byUserInGroup(
			userReferenceConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun readableByUser(userId: String): BaseFilterOptionsJs<AgendaJs> {
		val userIdConverted: String = userId
		val result = AgendaFilters.readableByUser(
			userIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun readableByUserInGroup(userReference: EntityReferenceInGroupJs): BaseFilterOptionsJs<AgendaJs> {
		val userReferenceConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(userReference)
		val result = AgendaFilters.readableByUserInGroup(
			userReferenceConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun readableByUserRights(userId: String): BaseFilterOptionsJs<AgendaJs> {
		val userIdConverted: String = userId
		val result = AgendaFilters.readableByUserRights(
			userIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun readableByUserRightsInGroup(userReference: EntityReferenceInGroupJs): BaseFilterOptionsJs<AgendaJs> {
		val userReferenceConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(userReference)
		val result = AgendaFilters.readableByUserRightsInGroup(
			userReferenceConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byStringProperty(propertyId: String, propertyValue: String): BaseFilterOptionsJs<AgendaJs> {
		val propertyIdConverted: String = propertyId
		val propertyValueConverted: String = propertyValue
		val result = AgendaFilters.byStringProperty(
			propertyIdConverted,
			propertyValueConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byBooleanProperty(propertyId: String, propertyValue: Boolean): BaseFilterOptionsJs<AgendaJs> {
		val propertyIdConverted: String = propertyId
		val propertyValueConverted: Boolean = propertyValue
		val result = AgendaFilters.byBooleanProperty(
			propertyIdConverted,
			propertyValueConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byLongProperty(propertyId: String, propertyValue: Double): BaseFilterOptionsJs<AgendaJs> {
		val propertyIdConverted: String = propertyId
		val propertyValueConverted: Long = numberToLong(propertyValue, "propertyValue")
		val result = AgendaFilters.byLongProperty(
			propertyIdConverted,
			propertyValueConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byDoubleProperty(propertyId: String, propertyValue: Double): BaseFilterOptionsJs<AgendaJs> {
		val propertyIdConverted: String = propertyId
		val propertyValueConverted: Double = propertyValue
		val result = AgendaFilters.byDoubleProperty(
			propertyIdConverted,
			propertyValueConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun withProperty(propertyId: String): BaseFilterOptionsJs<AgendaJs> {
		val propertyIdConverted: String = propertyId
		val result = AgendaFilters.withProperty(
			propertyIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
