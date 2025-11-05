// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthcarePartyApiInGroupJs
import com.icure.cardinal.sdk.js.api.HealthcarePartyApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.dataOwnerRegistrationSuccess_toJs
import com.icure.cardinal.sdk.js.model.healthcareParty_fromJs
import com.icure.cardinal.sdk.js.model.healthcareParty_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.publicKey_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class HealthcarePartyApiImplJs(
	private val healthcarePartyApi: HealthcarePartyApi,
) : HealthcarePartyApiJs {
	override val inGroup: HealthcarePartyApiInGroupJs = object : HealthcarePartyApiInGroupJs {
		override fun matchHealthcarePartiesBy(groupId: String,
				filter: BaseFilterOptionsJs<HealthcarePartyJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
			val result = healthcarePartyApi.inGroup.matchHealthcarePartiesBy(
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
	}

	override fun deleteHealthcarePartyUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthcarePartyApi.deleteHealthcarePartyUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcarePartiesUnsafe(entityIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcarePartyApi.deleteHealthcarePartiesUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getHealthcareParty(healthcarePartyId: String): Promise<HealthcarePartyJs?> =
			GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = healthcarePartyApi.getHealthcareParty(
			healthcarePartyIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				healthcareParty_toJs(nonNull1)
			}
		)
	}

	override fun createHealthcareParty(p: HealthcarePartyJs): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		val pConverted: HealthcareParty = healthcareParty_fromJs(p)
		val result = healthcarePartyApi.createHealthcareParty(
			pConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun modifyHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.modifyHealthcarePartyInGroup(
			groupIdConverted,
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun createHealthcarePartyInGroup(groupId: String, healthcareParty: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.createHealthcarePartyInGroup(
			groupIdConverted,
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs> = GlobalScope.promise {
		val result = healthcarePartyApi.getCurrentHealthcareParty(
		)
		healthcareParty_toJs(result)
	}

	override fun findHealthcarePartiesBy(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
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
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val result = healthcarePartyApi.findHealthcarePartiesBy(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun findHealthcarePartiesByName(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val nameConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"name",
				null
			) { name: String? ->
				undefinedToNull(name)
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
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val result = healthcarePartyApi.findHealthcarePartiesByName(
				nameConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun findHealthcarePartiesBySsinOrNihii(searchValue: String, options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val searchValueConverted: String = searchValue
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
			val descConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"desc",
				false
			) { desc: Boolean ->
				desc
			}
			val result = healthcarePartyApi.findHealthcarePartiesBySsinOrNihii(
				searchValueConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		val nameConverted: String = name
		val result = healthcarePartyApi.listHealthcarePartiesByName(
			nameConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		options: dynamic,
	): Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: String = type
			val specConverted: String = spec
			val firstCodeConverted: String = firstCode
			val lastCodeConverted: String = lastCode
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
			val result = healthcarePartyApi.findHealthcarePartiesBySpecialityAndPostCode(
				typeConverted,
				specConverted,
				firstCodeConverted,
				lastCodeConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val healthcarePartyIdsConverted: List<String> = arrayToList(
			healthcarePartyIds,
			"healthcarePartyIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcarePartyApi.getHealthcareParties(
			healthcarePartyIdsConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		val parentIdConverted: String = parentId
		val result = healthcarePartyApi.listHealthcarePartiesByParentId(
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs> = GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = healthcarePartyApi.getPublicKey(
			healthcarePartyIdConverted,
		)
		publicKey_toJs(result)
	}

	override fun modifyHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>
			= GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.modifyHealthcareParty(
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun matchHealthcarePartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.matchHealthcarePartiesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterHealthPartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.filterHealthPartiesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override
			fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.matchHealthcarePartiesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.filterHealthPartiesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun getHealthcarePartiesInGroup(groupId: String, options: dynamic):
			Promise<Array<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val healthcarePartyIdsConverted: List<String>? = convertingOptionOrDefaultNullable(
				_options,
				"healthcarePartyIds",
				null
			) { healthcarePartyIds: Array<String>? ->
				arrayToList(
					healthcarePartyIds,
					"healthcarePartyIds",
					{ x1: String ->
						x1
					},
				)
			}
			val result = healthcarePartyApi.getHealthcarePartiesInGroup(
				groupIdConverted,
				healthcarePartyIdsConverted,
			)
			listToArray(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: dynamic,
	): Promise<DataOwnerRegistrationSuccessJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val parentHcPartyIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"parentHcPartyId",
				null
			) { parentHcPartyId: String? ->
				undefinedToNull(parentHcPartyId)
			}
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
			}
			val useShortTokenConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"useShortToken",
				null
			) { useShortToken: Boolean? ->
				undefinedToNull(useShortToken)
			}
			val hcpConverted: HealthcareParty = healthcareParty_fromJs(hcp)
			val result = healthcarePartyApi.registerPatient(
				groupIdConverted,
				parentHcPartyIdConverted,
				tokenConverted,
				useShortTokenConverted,
				hcpConverted,
			)
			dataOwnerRegistrationSuccess_toJs(result)
		}
	}

	override fun deleteHealthcarePartyById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = healthcarePartyApi.deleteHealthcarePartyById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.deleteHealthcarePartiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteHealthcarePartyInGroupById(
		groupId: String,
		entityId: String,
		rev: String,
	): Promise<DocIdentifierJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = healthcarePartyApi.deleteHealthcarePartyInGroupById(
			groupIdConverted,
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcarePartiesInGroupByIds(groupId: String,
			entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.deleteHealthcarePartiesInGroupByIds(
			groupIdConverted,
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthcarePartyById(id: String, rev: String): Promise<Unit> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		healthcarePartyApi.purgeHealthcarePartyById(
			idConverted,
			revConverted,
		)

	}

	override fun undeleteHealthcarePartyById(id: String, rev: String): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = healthcarePartyApi.undeleteHealthcarePartyById(
			idConverted,
			revConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun deleteHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.deleteHealthcareParty(
			healthcarePartyConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.deleteHealthcareParties(
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<Unit> =
			GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		healthcarePartyApi.purgeHealthcareParty(
			healthcarePartyConverted,
		)

	}

	override fun undeleteHealthcareParty(healthcareParty: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.undeleteHealthcareParty(
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun deleteHealthcarePartyInGroup(groupId: String, hcp: HealthcarePartyJs):
			Promise<DocIdentifierJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val hcpConverted: HealthcareParty = healthcareParty_fromJs(hcp)
		val result = healthcarePartyApi.deleteHealthcarePartyInGroup(
			groupIdConverted,
			hcpConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcarePartiesInGroup(groupId: String,
			healthcareParties: Array<HealthcarePartyJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.deleteHealthcarePartiesInGroup(
			groupIdConverted,
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<HealthcarePartyJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<HealthcareParty> = filterOptions_fromJs(filter)
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
			val result = healthcarePartyApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}
}
