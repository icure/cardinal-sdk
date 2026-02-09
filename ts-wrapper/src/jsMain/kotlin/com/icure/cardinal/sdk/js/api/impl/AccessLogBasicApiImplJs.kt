// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.AccessLogBasicApiJs
import com.icure.cardinal.sdk.js.api.AccessLogBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.accessLog_fromJs
import com.icure.cardinal.sdk.js.model.accessLog_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
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
internal class AccessLogBasicApiImplJs(
	private val accessLogBasicApi: AccessLogBasicApi,
) : AccessLogBasicApiJs {
	override val inGroup: AccessLogBasicInGroupApiJs = object : AccessLogBasicInGroupApiJs {
		override fun matchAccessLogsBy(groupId: String, filter: BaseFilterOptionsJs<AccessLogJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
			val result = accessLogBasicApi.inGroup.matchAccessLogsBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun matchAccessLogsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<AccessLogJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<AccessLog> =
					baseSortableFilterOptions_fromJs(filter)
			val result = accessLogBasicApi.inGroup.matchAccessLogsBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun filterAccessLogsBy(groupId: String, filter: BaseFilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
			val result = accessLogBasicApi.inGroup.filterAccessLogsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterAccessLogsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<AccessLog> =
					baseSortableFilterOptions_fromJs(filter)
			val result = accessLogBasicApi.inGroup.filterAccessLogsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.deleteAccessLogById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = accessLogBasicApi.inGroup.deleteAccessLogsByIds(
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

		override fun purgeAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			accessLogBasicApi.inGroup.purgeAccessLogById(
				entityIdConverted,
			)

		}

		override fun purgeAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = accessLogBasicApi.inGroup.purgeAccessLogsByIds(
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

		override fun deleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.deleteAccessLog(
				accessLogConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val accessLogsConverted: List<GroupScoped<AccessLog>> = arrayToList(
				accessLogs,
				"accessLogs",
				{ x1: GroupScopedJs<AccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogBasicApi.inGroup.deleteAccessLogs(
				accessLogsConverted,
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

		override fun purgeAccessLog(accessLog: GroupScopedJs<AccessLogJs>): Promise<Unit> =
				GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			accessLogBasicApi.inGroup.purgeAccessLog(
				accessLogConverted,
			)

		}

		override fun purgeAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val accessLogsConverted: List<GroupScoped<AccessLog>> = arrayToList(
				accessLogs,
				"accessLogs",
				{ x1: GroupScopedJs<AccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogBasicApi.inGroup.purgeAccessLogs(
				accessLogsConverted,
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

		override fun createAccessLog(entity: GroupScopedJs<EncryptedAccessLogJs>):
				Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedAccessLog> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedAccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.createAccessLog(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun createAccessLogs(entities: Array<GroupScopedJs<EncryptedAccessLogJs>>):
				Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedAccessLog>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedAccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedAccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogBasicApi.inGroup.createAccessLogs(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.undeleteAccessLogById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun undeleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
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
			val result = accessLogBasicApi.inGroup.undeleteAccessLogsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
				Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.undeleteAccessLog(
				accessLogConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun undeleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
				Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val accessLogsConverted: List<GroupScoped<AccessLog>> = arrayToList(
				accessLogs,
				"accessLogs",
				{ x1: GroupScopedJs<AccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: AccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogBasicApi.inGroup.undeleteAccessLogs(
				accessLogsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyAccessLog(entity: GroupScopedJs<EncryptedAccessLogJs>):
				Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedAccessLog> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedAccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogBasicApi.inGroup.modifyAccessLog(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun modifyAccessLogs(entities: Array<GroupScopedJs<EncryptedAccessLogJs>>):
				Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedAccessLog>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedAccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedAccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogBasicApi.inGroup.modifyAccessLogs(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun getAccessLog(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedAccessLogJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = accessLogBasicApi.inGroup.getAccessLog(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedAccessLog ->
							accessLog_toJs(x1)
						},
					)
				}
			)
		}

		override fun getAccessLogs(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = accessLogBasicApi.inGroup.getAccessLogs(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.matchAccessLogsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<AccessLog> =
				baseSortableFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.matchAccessLogsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterAccessLogsBy(filter: BaseFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<AccessLog> = baseFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.filterAccessLogsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun filterAccessLogsBySorted(filter: BaseSortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<AccessLog> =
				baseSortableFilterOptions_fromJs(filter)
		val result = accessLogBasicApi.filterAccessLogsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun deleteAccessLogById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = accessLogBasicApi.deleteAccessLogById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.deleteAccessLogsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAccessLogById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		accessLogBasicApi.purgeAccessLogById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.purgeAccessLogsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteAccessLog(accessLog: AccessLogJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogBasicApi.deleteAccessLog(
			accessLogConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val accessLogsConverted: List<AccessLog> = arrayToList(
			accessLogs,
			"accessLogs",
			{ x1: AccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.deleteAccessLogs(
			accessLogsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAccessLog(accessLog: AccessLogJs): Promise<Unit> = GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		accessLogBasicApi.purgeAccessLog(
			accessLogConverted,
		)

	}

	override fun purgeAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val accessLogsConverted: List<AccessLog> = arrayToList(
			accessLogs,
			"accessLogs",
			{ x1: AccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.purgeAccessLogs(
			accessLogsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun createAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogBasicApi.createAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun createAccessLogs(entities: Array<EncryptedAccessLogJs>):
			Promise<Array<EncryptedAccessLogJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedAccessLog> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedAccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.createAccessLogs(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun undeleteAccessLogById(id: String, rev: String): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = accessLogBasicApi.undeleteAccessLogById(
			idConverted,
			revConverted,
		)
		accessLog_toJs(result)
	}

	override fun undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedAccessLogJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.undeleteAccessLogsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun undeleteAccessLog(accessLog: AccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogBasicApi.undeleteAccessLog(
			accessLogConverted,
		)
		accessLog_toJs(result)
	}

	override fun undeleteAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<EncryptedAccessLogJs>> = GlobalScope.promise {
		val accessLogsConverted: List<AccessLog> = arrayToList(
			accessLogs,
			"accessLogs",
			{ x1: AccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.undeleteAccessLogs(
			accessLogsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogBasicApi.modifyAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun modifyAccessLogs(entities: Array<EncryptedAccessLogJs>):
			Promise<Array<EncryptedAccessLogJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedAccessLog> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedAccessLogJs ->
				accessLog_fromJs(x1)
			},
		)
		val result = accessLogBasicApi.modifyAccessLogs(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogBasicApi.getAccessLog(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				accessLog_toJs(nonNull1)
			}
		)
	}

	override fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogBasicApi.getAccessLogs(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}
}
