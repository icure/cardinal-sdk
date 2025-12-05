// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.crypto.entities.AccessLogShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.AccessLogApiJs
import com.icure.cardinal.sdk.js.api.AccessLogFlavouredApiJs
import com.icure.cardinal.sdk.js.api.AccessLogFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.AccessLogInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.accessLogShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.accessLog_fromJs
import com.icure.cardinal.sdk.js.model.accessLog_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AccessLogApiImplJs(
	private val accessLogApi: AccessLogApi,
) : AccessLogApiJs {
	override val encrypted: AccessLogFlavouredApiJs<EncryptedAccessLogJs> = object :
			AccessLogFlavouredApiJs<EncryptedAccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: EncryptedAccessLogJs,
			options: dynamic,
		): Promise<EncryptedAccessLogJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
				val optionsConverted: AccessLogShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: AccessLogShareOptionsJs? ->
					options?.let { nonNull1 ->
						accessLogShareOptions_fromJs(nonNull1)
					}
				}
				val result = accessLogApi.encrypted.shareWith(
					delegateIdConverted,
					accessLogConverted,
					optionsConverted,
				)
				accessLog_toJs(result)
			}
		}

		override fun shareWithMany(accessLog: EncryptedAccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.encrypted.shareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			accessLog_toJs(result)
		}

		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = accessLogApi.encrypted.findAccessLogsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
			val result = accessLogApi.encrypted.filterAccessLogsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
			val result = accessLogApi.encrypted.filterAccessLogsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun createAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.encrypted.createAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun undeleteAccessLogById(id: String, rev: String): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = accessLogApi.encrypted.undeleteAccessLogById(
				idConverted,
				revConverted,
			)
			accessLog_toJs(result)
		}

		override fun undeleteAccessLog(accessLog: AccessLogJs): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
			val result = accessLogApi.encrypted.undeleteAccessLog(
				accessLogConverted,
			)
			accessLog_toJs(result)
		}

		override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.encrypted.modifyAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = accessLogApi.encrypted.getAccessLog(
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
			val result = accessLogApi.encrypted.getAccessLogs(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsBy(
			fromEpoch: Double?,
			toEpoch: Double?,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
			val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
			val startKeyConverted: Long? = numberToLong(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = accessLogApi.encrypted.findAccessLogsBy(
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
				Promise<PaginatedListJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val accessTypeConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"accessType",
					null
				) { accessType: String? ->
					undefinedToNull(accessType)
				}
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val startKeyConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: String? ->
					undefinedToNull(startKey)
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startDocumentId",
					null
				) { startDocumentId: String? ->
					undefinedToNull(startDocumentId)
				}
				val limitConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"limit",
					null
				) { limit: Double? ->
					numberToInt(limit, "limit")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = accessLogApi.encrypted.findAccessLogsByUserAfterDate(
					userIdConverted,
					accessTypeConverted,
					startDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					descendingConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun findAccessLogsInGroup(groupId: String, options: dynamic):
				Promise<PaginatedListJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val fromEpochConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"fromEpoch",
					null
				) { fromEpoch: Double? ->
					numberToLong(fromEpoch, "fromEpoch")
				}
				val toEpochConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"toEpoch",
					null
				) { toEpoch: Double? ->
					numberToLong(toEpoch, "toEpoch")
				}
				val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: Double? ->
					numberToLong(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startDocumentId",
					null
				) { startDocumentId: String? ->
					undefinedToNull(startDocumentId)
				}
				val limitConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"limit",
					null
				) { limit: Double? ->
					numberToInt(limit, "limit")
				}
				val result = accessLogApi.encrypted.findAccessLogsInGroup(
					groupIdConverted,
					fromEpochConverted,
					toEpochConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}
	}

	override val tryAndRecover: AccessLogFlavouredApiJs<AccessLogJs> = object :
			AccessLogFlavouredApiJs<AccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: AccessLogJs,
			options: dynamic,
		): Promise<AccessLogJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
				val optionsConverted: AccessLogShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: AccessLogShareOptionsJs? ->
					options?.let { nonNull1 ->
						accessLogShareOptions_fromJs(nonNull1)
					}
				}
				val result = accessLogApi.tryAndRecover.shareWith(
					delegateIdConverted,
					accessLogConverted,
					optionsConverted,
				)
				accessLog_toJs(result)
			}
		}

		override fun shareWithMany(accessLog: AccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>): Promise<AccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.tryAndRecover.shareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			accessLog_toJs(result)
		}

		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = accessLogApi.tryAndRecover.findAccessLogsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<AccessLogJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
			val result = accessLogApi.tryAndRecover.filterAccessLogsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
				Promise<PaginatedListIteratorJs<AccessLogJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
			val result = accessLogApi.tryAndRecover.filterAccessLogsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun createAccessLog(entity: AccessLogJs): Promise<AccessLogJs> = GlobalScope.promise {
			val entityConverted: AccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.tryAndRecover.createAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun undeleteAccessLogById(id: String, rev: String): Promise<AccessLogJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = accessLogApi.tryAndRecover.undeleteAccessLogById(
				idConverted,
				revConverted,
			)
			accessLog_toJs(result)
		}

		override fun undeleteAccessLog(accessLog: AccessLogJs): Promise<AccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
			val result = accessLogApi.tryAndRecover.undeleteAccessLog(
				accessLogConverted,
			)
			accessLog_toJs(result)
		}

		override fun modifyAccessLog(entity: AccessLogJs): Promise<AccessLogJs> = GlobalScope.promise {
			val entityConverted: AccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.tryAndRecover.modifyAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLog(entityId: String): Promise<AccessLogJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = accessLogApi.tryAndRecover.getAccessLog(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					accessLog_toJs(nonNull1)
				}
			)
		}

		override fun getAccessLogs(entityIds: Array<String>): Promise<Array<AccessLogJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = accessLogApi.tryAndRecover.getAccessLogs(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsBy(
			fromEpoch: Double?,
			toEpoch: Double?,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<AccessLogJs>> = GlobalScope.promise {
			val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
			val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
			val startKeyConverted: Long? = numberToLong(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = accessLogApi.tryAndRecover.findAccessLogsBy(
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
				Promise<PaginatedListJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val accessTypeConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"accessType",
					null
				) { accessType: String? ->
					undefinedToNull(accessType)
				}
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val startKeyConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: String? ->
					undefinedToNull(startKey)
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startDocumentId",
					null
				) { startDocumentId: String? ->
					undefinedToNull(startDocumentId)
				}
				val limitConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"limit",
					null
				) { limit: Double? ->
					numberToInt(limit, "limit")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = accessLogApi.tryAndRecover.findAccessLogsByUserAfterDate(
					userIdConverted,
					accessTypeConverted,
					startDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					descendingConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun findAccessLogsInGroup(groupId: String, options: dynamic):
				Promise<PaginatedListJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val fromEpochConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"fromEpoch",
					null
				) { fromEpoch: Double? ->
					numberToLong(fromEpoch, "fromEpoch")
				}
				val toEpochConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"toEpoch",
					null
				) { toEpoch: Double? ->
					numberToLong(toEpoch, "toEpoch")
				}
				val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startKey",
					null
				) { startKey: Double? ->
					numberToLong(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"startDocumentId",
					null
				) { startDocumentId: String? ->
					undefinedToNull(startDocumentId)
				}
				val limitConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"limit",
					null
				) { limit: Double? ->
					numberToInt(limit, "limit")
				}
				val result = accessLogApi.tryAndRecover.findAccessLogsInGroup(
					groupIdConverted,
					fromEpochConverted,
					toEpochConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}
	}

	override val inGroup: AccessLogInGroupApiJs = object : AccessLogInGroupApiJs {
		override val encrypted: AccessLogFlavouredInGroupApiJs<EncryptedAccessLogJs> = object :
				AccessLogFlavouredInGroupApiJs<EncryptedAccessLogJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				accessLog: GroupScopedJs<EncryptedAccessLogJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedAccessLogJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val accessLogConverted: GroupScoped<EncryptedAccessLog> = groupScoped_fromJs(
						accessLog,
						{ x1: EncryptedAccessLogJs ->
							accessLog_fromJs(x1)
						},
					)
					val optionsConverted: AccessLogShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: AccessLogShareOptionsJs? ->
						options?.let { nonNull1 ->
							accessLogShareOptions_fromJs(nonNull1)
						}
					}
					val result = accessLogApi.inGroup.encrypted.shareWith(
						delegateConverted,
						accessLogConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedAccessLog ->
							accessLog_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(accessLog: GroupScopedJs<EncryptedAccessLogJs>,
					delegates: Array<EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
				val accessLogConverted: GroupScoped<EncryptedAccessLog> = groupScoped_fromJs(
					accessLog,
					{ x1: EncryptedAccessLogJs ->
						accessLog_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLogShareOptions> =
						EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = accessLogApi.inGroup.encrypted.shareWithMany(
					accessLogConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}

			override fun filterAccessLogsBy(groupId: String, filter: FilterOptionsJs<AccessLogJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
				val result = accessLogApi.inGroup.encrypted.filterAccessLogsBy(
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
					filter: SortableFilterOptionsJs<AccessLogJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedAccessLogJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
				val result = accessLogApi.inGroup.encrypted.filterAccessLogsBySorted(
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

			override fun createAccessLog(entity: GroupScopedJs<EncryptedAccessLogJs>):
					Promise<GroupScopedJs<EncryptedAccessLogJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedAccessLog> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedAccessLogJs ->
						accessLog_fromJs(x1)
					},
				)
				val result = accessLogApi.inGroup.encrypted.createAccessLog(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
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
				val result = accessLogApi.inGroup.encrypted.modifyAccessLog(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}

			override fun getAccessLog(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedAccessLogJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = accessLogApi.inGroup.encrypted.getAccessLog(
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
				val result = accessLogApi.inGroup.encrypted.getAccessLogs(
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

		override val tryAndRecover: AccessLogFlavouredInGroupApiJs<AccessLogJs> = object :
				AccessLogFlavouredInGroupApiJs<AccessLogJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				accessLog: GroupScopedJs<AccessLogJs>,
				options: dynamic,
			): Promise<GroupScopedJs<AccessLogJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
						accessLog,
						{ x1: AccessLogJs ->
							accessLog_fromJs(x1)
						},
					)
					val optionsConverted: AccessLogShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: AccessLogShareOptionsJs? ->
						options?.let { nonNull1 ->
							accessLogShareOptions_fromJs(nonNull1)
						}
					}
					val result = accessLogApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						accessLogConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: AccessLog ->
							accessLog_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(accessLog: GroupScopedJs<AccessLogJs>,
					delegates: Array<EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<AccessLogJs>> = GlobalScope.promise {
				val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
					accessLog,
					{ x1: AccessLogJs ->
						accessLog_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLogShareOptions> =
						EntityReferenceInGroupToAccessLogShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = accessLogApi.inGroup.tryAndRecover.shareWithMany(
					accessLogConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}

			override fun filterAccessLogsBy(groupId: String, filter: FilterOptionsJs<AccessLogJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<AccessLogJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
				val result = accessLogApi.inGroup.tryAndRecover.filterAccessLogsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<AccessLog> ->
						groupScoped_toJs(
							x1,
							{ x2: AccessLog ->
								accessLog_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterAccessLogsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<AccessLogJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<AccessLogJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
				val result = accessLogApi.inGroup.tryAndRecover.filterAccessLogsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<AccessLog> ->
						groupScoped_toJs(
							x1,
							{ x2: AccessLog ->
								accessLog_toJs(x2)
							},
						)
					},
				)
			}

			override fun createAccessLog(entity: GroupScopedJs<AccessLogJs>):
					Promise<GroupScopedJs<AccessLogJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
					entity,
					{ x1: AccessLogJs ->
						accessLog_fromJs(x1)
					},
				)
				val result = accessLogApi.inGroup.tryAndRecover.createAccessLog(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}

			override fun modifyAccessLog(entity: GroupScopedJs<AccessLogJs>):
					Promise<GroupScopedJs<AccessLogJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
					entity,
					{ x1: AccessLogJs ->
						accessLog_fromJs(x1)
					},
				)
				val result = accessLogApi.inGroup.tryAndRecover.modifyAccessLog(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}

			override fun getAccessLog(groupId: String, entityId: String):
					Promise<GroupScopedJs<AccessLogJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = accessLogApi.inGroup.tryAndRecover.getAccessLog(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: AccessLog ->
								accessLog_toJs(x1)
							},
						)
					}
				)
			}

			override fun getAccessLogs(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<AccessLogJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = accessLogApi.inGroup.tryAndRecover.getAccessLogs(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<AccessLog> ->
						groupScoped_toJs(
							x1,
							{ x2: AccessLog ->
								accessLog_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedAccessLogJs?,
			patient: GroupScopedJs<PatientJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedAccessLog? = base?.let { nonNull1 ->
					accessLog_fromJs(nonNull1)
				}
				val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
					patient,
					{ x1: PatientJs ->
						patient_fromJs(x1)
					},
				)
				val userConverted: User? = convertingOptionOrDefaultNullable(
					_options,
					"user",
					null
				) { user: UserJs? ->
					user?.let { nonNull1 ->
						user_fromJs(nonNull1)
					}
				}
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLevel> =
						convertingOptionOrDefaultNonNull(
					_options,
					"delegates",
					emptyMap()
				) { delegates: Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel> ->
					EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(delegates)
				}
				val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
					_options,
					"secretId",
					com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
				) { secretId: SecretIdUseOptionJs ->
					secretIdUseOption_fromJs(secretId)
				}
				val alternateRootDelegateReferenceConverted: EntityReferenceInGroup? =
						convertingOptionOrDefaultNullable(
					_options,
					"alternateRootDelegateReference",
					null
				) { alternateRootDelegateReference: EntityReferenceInGroupJs? ->
					alternateRootDelegateReference?.let { nonNull1 ->
						entityReferenceInGroup_fromJs(nonNull1)
					}
				}
				val result = accessLogApi.inGroup.withEncryptionMetadata(
					entityGroupIdConverted,
					baseConverted,
					patientConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(accessLog: GroupScopedJs<AccessLogJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.getEncryptionKeysOf(
				accessLogConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(accessLog: GroupScopedJs<AccessLogJs>): Promise<Boolean> =
				GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.hasWriteAccess(
				accessLogConverted,
			)
			result
		}

		override fun decryptPatientIdOf(accessLog: GroupScopedJs<AccessLogJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val accessLogConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				accessLog,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.decryptPatientIdOf(
				accessLogConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<AccessLogJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<AccessLog> = groupScoped_fromJs(
				entity,
				{ x1: AccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			accessLogApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(accessLogs: Array<GroupScopedJs<EncryptedAccessLogJs>>):
				Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>> = GlobalScope.promise {
			val accessLogsConverted: List<GroupScoped<EncryptedAccessLog>> = arrayToList(
				accessLogs,
				"accessLogs",
				{ x1: GroupScopedJs<EncryptedAccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedAccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogApi.inGroup.decrypt(
				accessLogsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(accessLogs: Array<GroupScopedJs<EncryptedAccessLogJs>>):
				Promise<Array<GroupScopedJs<AccessLogJs>>> = GlobalScope.promise {
			val accessLogsConverted: List<GroupScoped<EncryptedAccessLog>> = arrayToList(
				accessLogs,
				"accessLogs",
				{ x1: GroupScopedJs<EncryptedAccessLogJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedAccessLogJs ->
							accessLog_fromJs(x2)
						},
					)
				},
			)
			val result = accessLogApi.inGroup.tryDecrypt(
				accessLogsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<AccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: AccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchAccessLogsBy(groupId: String, filter: FilterOptionsJs<AccessLogJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
			val result = accessLogApi.inGroup.matchAccessLogsBy(
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
				filter: SortableFilterOptionsJs<AccessLogJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
			val result = accessLogApi.inGroup.matchAccessLogsBySorted(
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

		override fun deleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.deleteAccessLogById(
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
			val result = accessLogApi.inGroup.deleteAccessLogsByIds(
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
			val result = accessLogApi.inGroup.deleteAccessLog(
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
			val result = accessLogApi.inGroup.deleteAccessLogs(
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

		override fun createAccessLog(entity: GroupScopedJs<DecryptedAccessLogJs>):
				Promise<GroupScopedJs<DecryptedAccessLogJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedAccessLog> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedAccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.createAccessLog(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun modifyAccessLog(entity: GroupScopedJs<DecryptedAccessLogJs>):
				Promise<GroupScopedJs<DecryptedAccessLogJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedAccessLog> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedAccessLogJs ->
					accessLog_fromJs(x1)
				},
			)
			val result = accessLogApi.inGroup.modifyAccessLog(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun getAccessLog(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedAccessLogJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = accessLogApi.inGroup.getAccessLog(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedAccessLog ->
							accessLog_toJs(x1)
						},
					)
				}
			)
		}

		override fun getAccessLogs(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = accessLogApi.inGroup.getAccessLogs(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedAccessLog> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedAccessLog ->
							accessLog_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedAccessLogJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedAccessLogJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedAccessLog? = base?.let { nonNull1 ->
				accessLog_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = accessLogApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			accessLog_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(accessLog: AccessLogJs): Promise<Array<String>> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.getEncryptionKeysOf(
			accessLogConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(accessLog: AccessLogJs): Promise<Boolean> = GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.hasWriteAccess(
			accessLogConverted,
		)
		result
	}

	override fun decryptPatientIdOf(accessLog: AccessLogJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.decryptPatientIdOf(
			accessLogConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: AccessLogJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: AccessLog = accessLog_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		accessLogApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(accessLog: EncryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.decrypt(
			accessLogConverted,
		)
		accessLog_toJs(result)
	}

	override fun tryDecrypt(accessLog: EncryptedAccessLogJs): Promise<AccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.tryDecrypt(
			accessLogConverted,
		)
		accessLog_toJs(result)
	}

	override fun matchAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
		val result = accessLogApi.matchAccessLogsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
		val result = accessLogApi.matchAccessLogsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteAccessLogUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogApi.deleteAccessLogUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAccessLogsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogApi.deleteAccessLogsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteAccessLogById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = accessLogApi.deleteAccessLogById(
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
		val result = accessLogApi.deleteAccessLogsByIds(
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
		accessLogApi.purgeAccessLogById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteAccessLog(accessLog: AccessLogJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.deleteAccessLog(
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
		val result = accessLogApi.deleteAccessLogs(
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
		accessLogApi.purgeAccessLog(
			accessLogConverted,
		)

	}

	override fun shareWith(
		delegateId: String,
		accessLog: DecryptedAccessLogJs,
		options: dynamic,
	): Promise<DecryptedAccessLogJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val accessLogConverted: DecryptedAccessLog = accessLog_fromJs(accessLog)
			val optionsConverted: AccessLogShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: AccessLogShareOptionsJs? ->
				options?.let { nonNull1 ->
					accessLogShareOptions_fromJs(nonNull1)
				}
			}
			val result = accessLogApi.shareWith(
				delegateIdConverted,
				accessLogConverted,
				optionsConverted,
			)
			accessLog_toJs(result)
		}
	}

	override fun shareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: DecryptedAccessLog = accessLog_fromJs(accessLog)
		val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: AccessLogShareOptionsJs ->
				accessLogShareOptions_fromJs(x1)
			},
		)
		val result = accessLogApi.shareWithMany(
			accessLogConverted,
			delegatesConverted,
		)
		accessLog_toJs(result)
	}

	override fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = accessLogApi.findAccessLogsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<AccessLog> = filterOptions_fromJs(filter)
		val result = accessLogApi.filterAccessLogsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<AccessLog> = sortableFilterOptions_fromJs(filter)
		val result = accessLogApi.filterAccessLogsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun createAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogApi.createAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun undeleteAccessLogById(id: String, rev: String): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = accessLogApi.undeleteAccessLogById(
			idConverted,
			revConverted,
		)
		accessLog_toJs(result)
	}

	override fun undeleteAccessLog(accessLog: AccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.undeleteAccessLog(
			accessLogConverted,
		)
		accessLog_toJs(result)
	}

	override fun modifyAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogApi.modifyAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun getAccessLog(entityId: String): Promise<DecryptedAccessLogJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogApi.getAccessLog(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				accessLog_toJs(nonNull1)
			}
		)
	}

	override fun getAccessLogs(entityIds: Array<String>): Promise<Array<DecryptedAccessLogJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogApi.getAccessLogs(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
		val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
		val startKeyConverted: Long? = numberToLong(startKey, "startKey")
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = accessLogApi.findAccessLogsBy(
			fromEpochConverted,
			toEpochConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsByUserAfterDate(userId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val accessTypeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"accessType",
				null
			) { accessType: String? ->
				undefinedToNull(accessType)
			}
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = accessLogApi.findAccessLogsByUserAfterDate(
				userIdConverted,
				accessTypeConverted,
				startDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descendingConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun findAccessLogsInGroup(groupId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val fromEpochConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"fromEpoch",
				null
			) { fromEpoch: Double? ->
				numberToLong(fromEpoch, "fromEpoch")
			}
			val toEpochConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"toEpoch",
				null
			) { toEpoch: Double? ->
				numberToLong(toEpoch, "toEpoch")
			}
			val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: Double? ->
				numberToLong(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = accessLogApi.findAccessLogsInGroup(
				groupIdConverted,
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}
}
