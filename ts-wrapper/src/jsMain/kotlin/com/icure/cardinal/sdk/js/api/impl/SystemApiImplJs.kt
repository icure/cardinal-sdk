// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.SystemApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.IndexingInfoJs
import com.icure.cardinal.sdk.js.model.ReplicationInfoJs
import com.icure.cardinal.sdk.js.model.couchdb.ReplicatorDocumentJs
import com.icure.cardinal.sdk.js.model.couchdb.replicatorDocument_toJs
import com.icure.cardinal.sdk.js.model.idWithRev_toJs
import com.icure.cardinal.sdk.js.model.indexingInfo_toJs
import com.icure.cardinal.sdk.js.model.replicationInfo_toJs
import com.icure.cardinal.sdk.model.IdWithRev
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class SystemApiImplJs(
	private val systemApi: SystemApi,
) : SystemApiJs {
	override fun getVersion(): Promise<String> = GlobalScope.promise {
		val result = systemApi.getVersion(
		)
		result
	}

	override fun isReady(): Promise<String> = GlobalScope.promise {
		val result = systemApi.isReady(
		)
		result
	}

	override fun getProcessInfo(): Promise<String> = GlobalScope.promise {
		val result = systemApi.getProcessInfo(
		)
		result
	}

	override fun getIndexingInfo(): Promise<IndexingInfoJs> = GlobalScope.promise {
		val result = systemApi.getIndexingInfo(
		)
		indexingInfo_toJs(result)
	}

	override fun getReplicationInfo(): Promise<ReplicationInfoJs> = GlobalScope.promise {
		val result = systemApi.getReplicationInfo(
		)
		replicationInfo_toJs(result)
	}

	override fun updateDesignDoc(entityName: String, options: dynamic): Promise<Boolean> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val entityNameConverted: String = entityName
			val warmupConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"warmup",
				null
			) { warmup: Boolean? ->
				undefinedToNull(warmup)
			}
			val result = systemApi.updateDesignDoc(
				entityNameConverted,
				warmupConverted,
			)
			result
		}
	}

	override fun resolvePatientsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolvePatientsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveContactsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveContactsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveFormsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveFormsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveHealthElementsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveHealthElementsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveInvoicesConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveInvoicesConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveMessagesConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveMessagesConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveDocumentsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idsConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"ids",
				null
			) { ids: String? ->
				undefinedToNull(ids)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = systemApi.resolveDocumentsConflicts(
				idsConverted,
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = systemApi.getIndexingInfoByGroup(
			groupIdConverted,
		)
		indexingInfo_toJs(result)
	}

	override fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = systemApi.getReplicatorInfo(
			idConverted,
		)
		replicatorDocument_toJs(result)
	}

	override fun evictAllFromMap(mapName: String): Promise<String> = GlobalScope.promise {
		val mapNameConverted: String = mapName
		val result = systemApi.evictAllFromMap(
			mapNameConverted,
		)
		result
	}
}
