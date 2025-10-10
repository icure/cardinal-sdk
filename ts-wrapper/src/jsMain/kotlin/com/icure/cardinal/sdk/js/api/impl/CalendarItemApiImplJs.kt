// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CalendarItemApi
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.CalendarItemApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemFlavouredApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.CalendarItemInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.CalendarItemShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.calendarItemShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.calendarItem_fromJs
import com.icure.cardinal.sdk.js.model.calendarItem_toJs
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
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
internal class CalendarItemApiImplJs(
	private val calendarItemApi: CalendarItemApi,
) : CalendarItemApiJs {
	override val encrypted: CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> = object :
			CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: EncryptedCalendarItemJs,
			options: dynamic,
		): Promise<EncryptedCalendarItemJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val calendarItemConverted: EncryptedCalendarItem = calendarItem_fromJs(calendarItem)
				val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CalendarItemShareOptionsJs? ->
					options?.let { nonNull1 ->
						calendarItemShareOptions_fromJs(nonNull1)
					}
				}
				val result = calendarItemApi.encrypted.shareWith(
					delegateIdConverted,
					calendarItemConverted,
					optionsConverted,
				)
				calendarItem_toJs(result)
			}
		}

		override fun shareWithMany(calendarItem: EncryptedCalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>): Promise<EncryptedCalendarItemJs> =
				GlobalScope.promise {
			val calendarItemConverted: EncryptedCalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.encrypted.shareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> {
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
				val result = calendarItemApi.encrypted.findCalendarItemsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun linkToPatient(
			calendarItem: CalendarItemJs,
			patient: PatientJs,
			shareLinkWithDelegates: Array<String>,
		): Promise<EncryptedCalendarItemJs> = GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val patientConverted: Patient = patient_fromJs(patient)
			val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
				shareLinkWithDelegates,
				"shareLinkWithDelegates",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.encrypted.linkToPatient(
				calendarItemConverted,
				patientConverted,
				shareLinkWithDelegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun filterCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val result = calendarItemApi.encrypted.filterCalendarItemsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun filterCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
			val result = calendarItemApi.encrypted.filterCalendarItemsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun createCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
				= GlobalScope.promise {
			val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.encrypted.createCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItemJs):
				Promise<EncryptedCalendarItemJs> = GlobalScope.promise {
			val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.encrypted.bookCalendarItemCheckingAvailability(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun undeleteCalendarItemById(id: String, rev: String): Promise<EncryptedCalendarItemJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = calendarItemApi.encrypted.undeleteCalendarItemById(
				idConverted,
				revConverted,
			)
			calendarItem_toJs(result)
		}

		override fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<EncryptedCalendarItemJs>
				= GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val result = calendarItemApi.encrypted.undeleteCalendarItem(
				calendarItemConverted,
			)
			calendarItem_toJs(result)
		}

		override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
				= GlobalScope.promise {
			val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.encrypted.modifyCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = calendarItemApi.encrypted.getCalendarItem(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					calendarItem_toJs(nonNull1)
				}
			)
		}

		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.encrypted.getCalendarItems(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsByPeriodAndHcPartyId(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
		): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
			val result = calendarItemApi.encrypted.getCalendarItemsByPeriodAndHcPartyId(
				startDateConverted,
				endDateConverted,
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarsByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = calendarItemApi.encrypted.getCalendarsByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun findCalendarItemsByRecurrenceId(
			recurrenceId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double,
		): Promise<PaginatedListJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val recurrenceIdConverted: String = recurrenceId
			val startKeyConverted: String? = undefinedToNull(startKey)
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int = numberToInt(limit, "limit")
			val result = calendarItemApi.encrypted.findCalendarItemsByRecurrenceId(
				recurrenceIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: CalendarItemFlavouredApiJs<CalendarItemJs> = object :
			CalendarItemFlavouredApiJs<CalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: CalendarItemJs,
			options: dynamic,
		): Promise<CalendarItemJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
				val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CalendarItemShareOptionsJs? ->
					options?.let { nonNull1 ->
						calendarItemShareOptions_fromJs(nonNull1)
					}
				}
				val result = calendarItemApi.tryAndRecover.shareWith(
					delegateIdConverted,
					calendarItemConverted,
					optionsConverted,
				)
				calendarItem_toJs(result)
			}
		}

		override fun shareWithMany(calendarItem: CalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.tryAndRecover.shareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<CalendarItemJs>> {
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
				val result = calendarItemApi.tryAndRecover.findCalendarItemsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun linkToPatient(
			calendarItem: CalendarItemJs,
			patient: PatientJs,
			shareLinkWithDelegates: Array<String>,
		): Promise<CalendarItemJs> = GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val patientConverted: Patient = patient_fromJs(patient)
			val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
				shareLinkWithDelegates,
				"shareLinkWithDelegates",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.tryAndRecover.linkToPatient(
				calendarItemConverted,
				patientConverted,
				shareLinkWithDelegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun filterCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<CalendarItemJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val result = calendarItemApi.tryAndRecover.filterCalendarItemsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun filterCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<CalendarItemJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
			val result = calendarItemApi.tryAndRecover.filterCalendarItemsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun createCalendarItem(entity: CalendarItemJs): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val entityConverted: CalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.tryAndRecover.createCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun bookCalendarItemCheckingAvailability(entity: CalendarItemJs): Promise<CalendarItemJs>
				= GlobalScope.promise {
			val entityConverted: CalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.tryAndRecover.bookCalendarItemCheckingAvailability(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun undeleteCalendarItemById(id: String, rev: String): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = calendarItemApi.tryAndRecover.undeleteCalendarItemById(
				idConverted,
				revConverted,
			)
			calendarItem_toJs(result)
		}

		override fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val result = calendarItemApi.tryAndRecover.undeleteCalendarItem(
				calendarItemConverted,
			)
			calendarItem_toJs(result)
		}

		override fun modifyCalendarItem(entity: CalendarItemJs): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val entityConverted: CalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.tryAndRecover.modifyCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItem(entityId: String): Promise<CalendarItemJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = calendarItemApi.tryAndRecover.getCalendarItem(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					calendarItem_toJs(nonNull1)
				}
			)
		}

		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<CalendarItemJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.tryAndRecover.getCalendarItems(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsByPeriodAndHcPartyId(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
			val result = calendarItemApi.tryAndRecover.getCalendarItemsByPeriodAndHcPartyId(
				startDateConverted,
				endDateConverted,
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarsByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = calendarItemApi.tryAndRecover.getCalendarsByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun findCalendarItemsByRecurrenceId(
			recurrenceId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double,
		): Promise<PaginatedListJs<CalendarItemJs>> = GlobalScope.promise {
			val recurrenceIdConverted: String = recurrenceId
			val startKeyConverted: String? = undefinedToNull(startKey)
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int = numberToInt(limit, "limit")
			val result = calendarItemApi.tryAndRecover.findCalendarItemsByRecurrenceId(
				recurrenceIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override val inGroup: CalendarItemInGroupApiJs = object : CalendarItemInGroupApiJs {
		override val encrypted: CalendarItemFlavouredInGroupApiJs<EncryptedCalendarItemJs> = object :
				CalendarItemFlavouredInGroupApiJs<EncryptedCalendarItemJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				calendarItem: GroupScopedJs<EncryptedCalendarItemJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedCalendarItemJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val calendarItemConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
						calendarItem,
						{ x1: EncryptedCalendarItemJs ->
							calendarItem_fromJs(x1)
						},
					)
					val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: CalendarItemShareOptionsJs? ->
						options?.let { nonNull1 ->
							calendarItemShareOptions_fromJs(nonNull1)
						}
					}
					val result = calendarItemApi.inGroup.encrypted.shareWith(
						delegateConverted,
						calendarItemConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedCalendarItem ->
							calendarItem_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(calendarItem: GroupScopedJs<EncryptedCalendarItemJs>,
					delegates: Array<EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
				val calendarItemConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
					calendarItem,
					{ x1: EncryptedCalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, CalendarItemShareOptions> =
						EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = calendarItemApi.inGroup.encrypted.shareWithMany(
					calendarItemConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun filterCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
				val result = calendarItemApi.inGroup.encrypted.filterCalendarItemsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedCalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedCalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterCalendarItemsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<CalendarItemJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
				val result = calendarItemApi.inGroup.encrypted.filterCalendarItemsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedCalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedCalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}

			override fun createCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
					Promise<GroupScopedJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedCalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val result = calendarItemApi.inGroup.encrypted.createCalendarItem(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun modifyCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
					Promise<GroupScopedJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedCalendarItem> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedCalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val result = calendarItemApi.inGroup.encrypted.modifyCalendarItem(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun getCalendarItem(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedCalendarItemJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = calendarItemApi.inGroup.encrypted.getCalendarItem(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedCalendarItem ->
								calendarItem_toJs(x1)
							},
						)
					}
				)
			}

			override fun getCalendarItems(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedCalendarItemJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = calendarItemApi.inGroup.encrypted.getCalendarItems(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedCalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedCalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: CalendarItemFlavouredInGroupApiJs<CalendarItemJs> = object :
				CalendarItemFlavouredInGroupApiJs<CalendarItemJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				calendarItem: GroupScopedJs<CalendarItemJs>,
				options: dynamic,
			): Promise<GroupScopedJs<CalendarItemJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
						calendarItem,
						{ x1: CalendarItemJs ->
							calendarItem_fromJs(x1)
						},
					)
					val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: CalendarItemShareOptionsJs? ->
						options?.let { nonNull1 ->
							calendarItemShareOptions_fromJs(nonNull1)
						}
					}
					val result = calendarItemApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						calendarItemConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: CalendarItem ->
							calendarItem_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(calendarItem: GroupScopedJs<CalendarItemJs>,
					delegates: Array<EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<CalendarItemJs>> = GlobalScope.promise {
				val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
					calendarItem,
					{ x1: CalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, CalendarItemShareOptions> =
						EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = calendarItemApi.inGroup.tryAndRecover.shareWithMany(
					calendarItemConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun filterCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<CalendarItemJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
				val result = calendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<CalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: CalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterCalendarItemsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<CalendarItemJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<CalendarItemJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
				val result = calendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<CalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: CalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}

			override fun createCalendarItem(entity: GroupScopedJs<CalendarItemJs>):
					Promise<GroupScopedJs<CalendarItemJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
					entity,
					{ x1: CalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val result = calendarItemApi.inGroup.tryAndRecover.createCalendarItem(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun modifyCalendarItem(entity: GroupScopedJs<CalendarItemJs>):
					Promise<GroupScopedJs<CalendarItemJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
					entity,
					{ x1: CalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val result = calendarItemApi.inGroup.tryAndRecover.modifyCalendarItem(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}

			override fun getCalendarItem(groupId: String, entityId: String):
					Promise<GroupScopedJs<CalendarItemJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = calendarItemApi.inGroup.tryAndRecover.getCalendarItem(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: CalendarItem ->
								calendarItem_toJs(x1)
							},
						)
					}
				)
			}

			override fun getCalendarItems(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<CalendarItemJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = calendarItemApi.inGroup.tryAndRecover.getCalendarItems(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CalendarItem> ->
						groupScoped_toJs(
							x1,
							{ x2: CalendarItem ->
								calendarItem_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedCalendarItemJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedCalendarItemJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedCalendarItem? = base?.let { nonNull1 ->
					calendarItem_fromJs(nonNull1)
				}
				val patientConverted: GroupScoped<Patient>? = patient?.let { nonNull1 ->
					groupScoped_fromJs(
						nonNull1,
						{ x1: PatientJs ->
							patient_fromJs(x1)
						},
					)
				}
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
				val result = calendarItemApi.inGroup.withEncryptionMetadata(
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
					{ x1: DecryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(calendarItem: GroupScopedJs<CalendarItemJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.getEncryptionKeysOf(
				calendarItemConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(calendarItem: GroupScopedJs<CalendarItemJs>): Promise<Boolean> =
				GlobalScope.promise {
			val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.hasWriteAccess(
				calendarItemConverted,
			)
			result
		}

		override fun decryptPatientIdOf(calendarItem: GroupScopedJs<CalendarItemJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.decryptPatientIdOf(
				calendarItemConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<CalendarItemJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				entity,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			calendarItemApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(calendarItems: Array<GroupScopedJs<EncryptedCalendarItemJs>>):
				Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>> = GlobalScope.promise {
			val calendarItemsConverted: List<GroupScoped<EncryptedCalendarItem>> = arrayToList(
				calendarItems,
				"calendarItems",
				{ x1: GroupScopedJs<EncryptedCalendarItemJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedCalendarItemJs ->
							calendarItem_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemApi.inGroup.decrypt(
				calendarItemsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(calendarItems: Array<GroupScopedJs<EncryptedCalendarItemJs>>):
				Promise<Array<GroupScopedJs<CalendarItemJs>>> = GlobalScope.promise {
			val calendarItemsConverted: List<GroupScoped<EncryptedCalendarItem>> = arrayToList(
				calendarItems,
				"calendarItems",
				{ x1: GroupScopedJs<EncryptedCalendarItemJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedCalendarItemJs ->
							calendarItem_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemApi.inGroup.tryDecrypt(
				calendarItemsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: CalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun encryptOrValidate(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
				Promise<Array<GroupScopedJs<EncryptedCalendarItemJs>>> = GlobalScope.promise {
			val calendarItemsConverted: List<GroupScoped<CalendarItem>> = arrayToList(
				calendarItems,
				"calendarItems",
				{ x1: GroupScopedJs<CalendarItemJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemJs ->
							calendarItem_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemApi.inGroup.encryptOrValidate(
				calendarItemsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val result = calendarItemApi.inGroup.matchCalendarItemsBy(
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

		override fun matchCalendarItemsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<CalendarItemJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
			val result = calendarItemApi.inGroup.matchCalendarItemsBySorted(
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

		override fun deleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.deleteCalendarItemById(
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
				fun deleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = calendarItemApi.inGroup.deleteCalendarItemsByIds(
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

		override fun deleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val calendarItemConverted: GroupScoped<CalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: CalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.deleteCalendarItem(
				calendarItemConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteCalendarItems(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val calendarItemsConverted: List<GroupScoped<CalendarItem>> = arrayToList(
				calendarItems,
				"calendarItems",
				{ x1: GroupScopedJs<CalendarItemJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CalendarItemJs ->
							calendarItem_fromJs(x2)
						},
					)
				},
			)
			val result = calendarItemApi.inGroup.deleteCalendarItems(
				calendarItemsConverted,
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			calendarItem: GroupScopedJs<DecryptedCalendarItemJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedCalendarItemJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val calendarItemConverted: GroupScoped<DecryptedCalendarItem> = groupScoped_fromJs(
					calendarItem,
					{ x1: DecryptedCalendarItemJs ->
						calendarItem_fromJs(x1)
					},
				)
				val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CalendarItemShareOptionsJs? ->
					options?.let { nonNull1 ->
						calendarItemShareOptions_fromJs(nonNull1)
					}
				}
				val result = calendarItemApi.inGroup.shareWith(
					delegateConverted,
					calendarItemConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(calendarItem: GroupScopedJs<DecryptedCalendarItemJs>,
				delegates: Array<EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
			val calendarItemConverted: GroupScoped<DecryptedCalendarItem> = groupScoped_fromJs(
				calendarItem,
				{ x1: DecryptedCalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, CalendarItemShareOptions> =
					EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = calendarItemApi.inGroup.shareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun filterCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val result = calendarItemApi.inGroup.filterCalendarItemsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterCalendarItemsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<CalendarItemJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
			val result = calendarItemApi.inGroup.filterCalendarItemsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}

		override fun createCalendarItem(entity: GroupScopedJs<DecryptedCalendarItemJs>):
				Promise<GroupScopedJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedCalendarItem> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedCalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.createCalendarItem(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun modifyCalendarItem(entity: GroupScopedJs<DecryptedCalendarItemJs>):
				Promise<GroupScopedJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedCalendarItem> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedCalendarItemJs ->
					calendarItem_fromJs(x1)
				},
			)
			val result = calendarItemApi.inGroup.modifyCalendarItem(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItem(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedCalendarItemJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = calendarItemApi.inGroup.getCalendarItem(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedCalendarItem ->
							calendarItem_toJs(x1)
						},
					)
				}
			)
		}

		override fun getCalendarItems(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.inGroup.getCalendarItems(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCalendarItem> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCalendarItem ->
							calendarItem_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedCalendarItemJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedCalendarItemJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedCalendarItem? = base?.let { nonNull1 ->
				calendarItem_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
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
			val result = calendarItemApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			calendarItem_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(calendarItem: CalendarItemJs): Promise<Array<String>> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.getEncryptionKeysOf(
			calendarItemConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(calendarItem: CalendarItemJs): Promise<Boolean> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.hasWriteAccess(
			calendarItemConverted,
		)
		result
	}

	override fun decryptPatientIdOf(calendarItem: CalendarItemJs):
			Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.decryptPatientIdOf(
			calendarItemConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: CalendarItemJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: CalendarItem = calendarItem_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		calendarItemApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(calendarItems: Array<EncryptedCalendarItemJs>):
			Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<EncryptedCalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: EncryptedCalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemApi.decrypt(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun tryDecrypt(calendarItems: Array<EncryptedCalendarItemJs>):
			Promise<Array<CalendarItemJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<EncryptedCalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: EncryptedCalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemApi.tryDecrypt(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: CalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun encryptOrValidate(calendarItems: Array<CalendarItemJs>):
			Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<CalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: CalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemApi.encryptOrValidate(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun matchCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>): Promise<Array<String>>
			= GlobalScope.promise {
		val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
		val result = calendarItemApi.matchCalendarItemsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
		val result = calendarItemApi.matchCalendarItemsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteCalendarItemUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemApi.deleteCalendarItemUnsafe(
			entityIdConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.deleteCalendarItemsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteCalendarItemById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = calendarItemApi.deleteCalendarItemById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = calendarItemApi.deleteCalendarItemsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItemById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		calendarItemApi.purgeCalendarItemById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.deleteCalendarItem(
			calendarItemConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val calendarItemsConverted: List<CalendarItem> = arrayToList(
			calendarItems,
			"calendarItems",
			{ x1: CalendarItemJs ->
				calendarItem_fromJs(x1)
			},
		)
		val result = calendarItemApi.deleteCalendarItems(
			calendarItemsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		calendarItemApi.purgeCalendarItem(
			calendarItemConverted,
		)

	}

	override fun shareWith(
		delegateId: String,
		calendarItem: DecryptedCalendarItemJs,
		options: dynamic,
	): Promise<DecryptedCalendarItemJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val calendarItemConverted: DecryptedCalendarItem = calendarItem_fromJs(calendarItem)
			val optionsConverted: CalendarItemShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: CalendarItemShareOptionsJs? ->
				options?.let { nonNull1 ->
					calendarItemShareOptions_fromJs(nonNull1)
				}
			}
			val result = calendarItemApi.shareWith(
				delegateIdConverted,
				calendarItemConverted,
				optionsConverted,
			)
			calendarItem_toJs(result)
		}
	}

	override fun shareWithMany(calendarItem: DecryptedCalendarItemJs,
			delegates: Record<String, CalendarItemShareOptionsJs>): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		val calendarItemConverted: DecryptedCalendarItem = calendarItem_fromJs(calendarItem)
		val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: CalendarItemShareOptionsJs ->
				calendarItemShareOptions_fromJs(x1)
			},
		)
		val result = calendarItemApi.shareWithMany(
			calendarItemConverted,
			delegatesConverted,
		)
		calendarItem_toJs(result)
	}

	override fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>> {
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
			val result = calendarItemApi.findCalendarItemsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override fun linkToPatient(
		calendarItem: CalendarItemJs,
		patient: PatientJs,
		shareLinkWithDelegates: Array<String>,
	): Promise<DecryptedCalendarItemJs> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val patientConverted: Patient = patient_fromJs(patient)
		val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
			shareLinkWithDelegates,
			"shareLinkWithDelegates",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.linkToPatient(
			calendarItemConverted,
			patientConverted,
			shareLinkWithDelegatesConverted,
		)
		calendarItem_toJs(result)
	}

	override fun filterCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
		val result = calendarItemApi.filterCalendarItemsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun filterCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<CalendarItem> = sortableFilterOptions_fromJs(filter)
		val result = calendarItemApi.filterCalendarItemsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun createCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: DecryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemApi.createCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun bookCalendarItemCheckingAvailability(entity: DecryptedCalendarItemJs):
			Promise<DecryptedCalendarItemJs> = GlobalScope.promise {
		val entityConverted: DecryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemApi.bookCalendarItemCheckingAvailability(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun undeleteCalendarItemById(id: String, rev: String): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = calendarItemApi.undeleteCalendarItemById(
			idConverted,
			revConverted,
		)
		calendarItem_toJs(result)
	}

	override fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.undeleteCalendarItem(
			calendarItemConverted,
		)
		calendarItem_toJs(result)
	}

	override fun modifyCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: DecryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemApi.modifyCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItem(entityId: String): Promise<DecryptedCalendarItemJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemApi.getCalendarItem(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				calendarItem_toJs(nonNull1)
			}
		)
	}

	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<DecryptedCalendarItemJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.getCalendarItems(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val hcPartyIdConverted: String = hcPartyId
		val result = calendarItemApi.getCalendarItemsByPeriodAndHcPartyId(
			startDateConverted,
			endDateConverted,
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = calendarItemApi.getCalendarsByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val recurrenceIdConverted: String = recurrenceId
		val startKeyConverted: String? = undefinedToNull(startKey)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int = numberToInt(limit, "limit")
		val result = calendarItemApi.findCalendarItemsByRecurrenceId(
			recurrenceIdConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<CalendarItemJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedCalendarItemJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<CalendarItem> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = calendarItemApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}
}
