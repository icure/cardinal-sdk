// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.js.api.CalendarItemTypeApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemTypeInGroupApiJs
import com.icure.cardinal.sdk.js.model.CalendarItemTypeJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.calendarItemType_fromJs
import com.icure.cardinal.sdk.js.model.calendarItemType_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CalendarItemTypeApiImplJs(
	private val calendarItemTypeApi: CalendarItemTypeApi,
) : CalendarItemTypeApiJs {
	override val inGroup: CalendarItemTypeInGroupApiJs = object : CalendarItemTypeInGroupApiJs {
		override fun createCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
				Promise<GroupScopedJs<CalendarItemTypeJs>> = GlobalScope.promise {
			val calendarItemTypeConverted: GroupScoped<CalendarItemType> = groupScoped_fromJs(
				calendarItemType,
				{ x1: CalendarItemTypeJs ->
					calendarItemType_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.createCalendarItemType(
				calendarItemTypeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: CalendarItemType ->
					calendarItemType_toJs(x1)
				},
			)
		}

		override fun createCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
				Promise<Array<GroupScopedJs<CalendarItemTypeJs>>> = GlobalScope.promise {
			val calendarItemTypesConverted: List<GroupScoped<CalendarItemType>> = arrayToList(
				calendarItemTypes,
				"calendarItemTypes",
				{ x1: GroupScopedJs<CalendarItemTypeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemTypeJs ->
							calendarItemType_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.createCalendarItemTypes(
				calendarItemTypesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItemType> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItemType ->
							calendarItemType_toJs(x2)
						},
					)
				},
			)
		}

		override fun getCalendarItemType(groupId: String, calendarItemTypeId: String):
				Promise<GroupScopedJs<CalendarItemTypeJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val calendarItemTypeIdConverted: String = calendarItemTypeId
			val result = calendarItemTypeApi.inGroup.getCalendarItemType(
				groupIdConverted,
				calendarItemTypeIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: CalendarItemType ->
							calendarItemType_toJs(x1)
						},
					)
				}
			)
		}

		override fun getCalendarItemTypes(groupId: String, calendarItemTypesIds: Array<String>):
				Promise<Array<GroupScopedJs<CalendarItemTypeJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val calendarItemTypesIdsConverted: List<String> = arrayToList(
				calendarItemTypesIds,
				"calendarItemTypesIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemTypeApi.inGroup.getCalendarItemTypes(
				groupIdConverted,
				calendarItemTypesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItemType> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItemType ->
							calendarItemType_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
				Promise<GroupScopedJs<CalendarItemTypeJs>> = GlobalScope.promise {
			val calendarItemTypeConverted: GroupScoped<CalendarItemType> = groupScoped_fromJs(
				calendarItemType,
				{ x1: CalendarItemTypeJs ->
					calendarItemType_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.modifyCalendarItemType(
				calendarItemTypeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: CalendarItemType ->
					calendarItemType_toJs(x1)
				},
			)
		}

		override fun modifyCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
				Promise<Array<GroupScopedJs<CalendarItemTypeJs>>> = GlobalScope.promise {
			val calendarItemTypesConverted: List<GroupScoped<CalendarItemType>> = arrayToList(
				calendarItemTypes,
				"calendarItemTypes",
				{ x1: GroupScopedJs<CalendarItemTypeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemTypeJs ->
							calendarItemType_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.modifyCalendarItemTypes(
				calendarItemTypesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItemType> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItemType ->
							calendarItemType_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.deleteCalendarItemTypeById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override
				fun deleteCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.deleteCalendarItemTypeByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val calendarItemTypeConverted: GroupScoped<CalendarItemType> = groupScoped_fromJs(
				calendarItemType,
				{ x1: CalendarItemTypeJs ->
					calendarItemType_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.deleteCalendarItemType(
				calendarItemTypeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val calendarItemTypesConverted: List<GroupScoped<CalendarItemType>> = arrayToList(
				calendarItemTypes,
				"calendarItemTypes",
				{ x1: GroupScopedJs<CalendarItemTypeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemTypeJs ->
							calendarItemType_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.deleteCalendarItemTypes(
				calendarItemTypesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<CalendarItemTypeJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.undeleteCalendarItemTypeById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: CalendarItemType ->
					calendarItemType_toJs(x1)
				},
			)
		}

		override
				fun undeleteCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<CalendarItemTypeJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.undeleteCalendarItemTypeByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItemType> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItemType ->
							calendarItemType_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
				Promise<GroupScopedJs<CalendarItemTypeJs>> = GlobalScope.promise {
			val calendarItemTypeConverted: GroupScoped<CalendarItemType> = groupScoped_fromJs(
				calendarItemType,
				{ x1: CalendarItemTypeJs ->
					calendarItemType_fromJs(x1)
				},
			)
			val result = calendarItemTypeApi.inGroup.undeleteCalendarItemType(
				calendarItemTypeConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: CalendarItemType ->
					calendarItemType_toJs(x1)
				},
			)
		}

		override
				fun undeleteCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
				Promise<Array<GroupScopedJs<CalendarItemTypeJs>>> = GlobalScope.promise {
			val calendarItemTypesConverted: List<GroupScoped<CalendarItemType>> = arrayToList(
				calendarItemTypes,
				"calendarItemTypes",
				{ x1: GroupScopedJs<CalendarItemTypeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemTypeJs ->
							calendarItemType_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.undeleteCalendarItemTypes(
				calendarItemTypesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItemType> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItemType ->
							calendarItemType_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			calendarItemTypeApi.inGroup.purgeCalendarItemTypeById(
				entityIdConverted,
			)

		}

		override
				fun purgeCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entityIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.purgeCalendarItemTypeByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
				Promise<Unit> = GlobalScope.promise {
			val calendarItemTypeConverted: GroupScoped<CalendarItemType> = groupScoped_fromJs(
				calendarItemType,
				{ x1: CalendarItemTypeJs ->
					calendarItemType_fromJs(x1)
				},
			)
			calendarItemTypeApi.inGroup.purgeCalendarItemType(
				calendarItemTypeConverted,
			)

		}

		override fun purgeCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val calendarItemTypesConverted: List<GroupScoped<CalendarItemType>> = arrayToList(
				calendarItemTypes,
				"calendarItemTypes",
				{ x1: GroupScopedJs<CalendarItemTypeJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemTypeJs ->
							calendarItemType_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemTypeApi.inGroup.purgeCalendarItemTypes(
				calendarItemTypesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun createCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val calendarItemTypeConverted: CalendarItemType = calendarItemType_fromJs(calendarItemType)
		val result = calendarItemTypeApi.createCalendarItemType(
			calendarItemTypeConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun createCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>> = GlobalScope.promise {
		val calendarItemTypesConverted: List<CalendarItemType> = arrayToList(
			calendarItemTypes,
			"calendarItemTypes",
			{ x1: CalendarItemTypeJs ->
				calendarItemType_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.createCalendarItemTypes(
			calendarItemTypesConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun getCalendarItemType(calendarItemTypeId: String): Promise<CalendarItemTypeJs?> =
			GlobalScope.promise {
		val calendarItemTypeIdConverted: String = calendarItemTypeId
		val result = calendarItemTypeApi.getCalendarItemType(
			calendarItemTypeIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				calendarItemType_toJs(nonNull1)
			}
		)
	}

	override fun getCalendarItemTypes(calendarItemTypesIds: Array<String>):
			Promise<Array<CalendarItemTypeJs>> = GlobalScope.promise {
		val calendarItemTypesIdsConverted: List<String> = arrayToList(
			calendarItemTypesIds,
			"calendarItemTypesIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemTypeApi.getCalendarItemTypes(
			calendarItemTypesIdsConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun modifyCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val calendarItemTypeConverted: CalendarItemType = calendarItemType_fromJs(calendarItemType)
		val result = calendarItemTypeApi.modifyCalendarItemType(
			calendarItemTypeConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun modifyCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>> = GlobalScope.promise {
		val calendarItemTypesConverted: List<CalendarItemType> = arrayToList(
			calendarItemTypes,
			"calendarItemTypes",
			{ x1: CalendarItemTypeJs ->
				calendarItemType_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.modifyCalendarItemTypes(
			calendarItemTypesConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemTypeById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = calendarItemTypeApi.deleteCalendarItemTypeById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.deleteCalendarItemTypeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val calendarItemTypeConverted: CalendarItemType = calendarItemType_fromJs(calendarItemType)
		val result = calendarItemTypeApi.deleteCalendarItemType(
			calendarItemTypeConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val calendarItemTypesConverted: List<CalendarItemType> = arrayToList(
			calendarItemTypes,
			"calendarItemTypes",
			{ x1: CalendarItemTypeJs ->
				calendarItemType_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.deleteCalendarItemTypes(
			calendarItemTypesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteCalendarItemTypeById(entityId: String, rev: String):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = calendarItemTypeApi.undeleteCalendarItemTypeById(
			entityIdConverted,
			revConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun undeleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<CalendarItemTypeJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.undeleteCalendarItemTypeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun undeleteCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs> = GlobalScope.promise {
		val calendarItemTypeConverted: CalendarItemType = calendarItemType_fromJs(calendarItemType)
		val result = calendarItemTypeApi.undeleteCalendarItemType(
			calendarItemTypeConverted,
		)
		calendarItemType_toJs(result)
	}

	override fun undeleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>> = GlobalScope.promise {
		val calendarItemTypesConverted: List<CalendarItemType> = arrayToList(
			calendarItemTypes,
			"calendarItemTypes",
			{ x1: CalendarItemTypeJs ->
				calendarItemType_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.undeleteCalendarItemTypes(
			calendarItemTypesConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItemTypeById(entityId: String, rev: String): Promise<Unit> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		calendarItemTypeApi.purgeCalendarItemTypeById(
			entityIdConverted,
			revConverted,
		)

	}

	override fun purgeCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.purgeCalendarItemTypeByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItemType(calendarItemType: CalendarItemTypeJs): Promise<Unit> =
			GlobalScope.promise {
		val calendarItemTypeConverted: CalendarItemType = calendarItemType_fromJs(calendarItemType)
		calendarItemTypeApi.purgeCalendarItemType(
			calendarItemTypeConverted,
		)

	}

	override fun purgeCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val calendarItemTypesConverted: List<CalendarItemType> = arrayToList(
			calendarItemTypes,
			"calendarItemTypes",
			{ x1: CalendarItemTypeJs ->
				calendarItemType_fromJs(x1)
			},
		)
		val result = calendarItemTypeApi.purgeCalendarItemTypes(
			calendarItemTypesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun listCalendarItemTypesByAgendaId(agendaId: String): Promise<Array<CalendarItemTypeJs>>
			= GlobalScope.promise {
		val agendaIdConverted: String = agendaId
		val result = calendarItemTypeApi.listCalendarItemTypesByAgendaId(
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItemType ->
				calendarItemType_toJs(x1)
			},
		)
	}
}
