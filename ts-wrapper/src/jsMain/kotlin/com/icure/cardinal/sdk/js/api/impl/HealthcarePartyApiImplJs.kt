// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthcarePartyApiJs
import com.icure.cardinal.sdk.js.api.HealthcarePartyInGroupApiJs
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
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.dataOwnerRegistrationSuccess_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.healthcareParty_fromJs
import com.icure.cardinal.sdk.js.model.healthcareParty_toJs
import com.icure.cardinal.sdk.js.model.publicKey_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
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
	override val inGroup: HealthcarePartyInGroupApiJs = object : HealthcarePartyInGroupApiJs {
		override fun createHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
				Promise<GroupScopedJs<HealthcarePartyJs>> = GlobalScope.promise {
			val healthcarePartyConverted: GroupScoped<HealthcareParty> = groupScoped_fromJs(
				healthcareParty,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.createHealthcareParty(
				healthcarePartyConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}

		override fun createHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
				Promise<Array<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val healthcarePartiesConverted: List<GroupScoped<HealthcareParty>> = arrayToList(
				healthcareParties,
				"healthcareParties",
				{ x1: GroupScopedJs<HealthcarePartyJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthcarePartyJs ->
							healthcareParty_fromJs(x2)
						},
					)
				},
			)
			val result = healthcarePartyApi.inGroup.createHealthcareParties(
				healthcarePartiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun getHealthcareParty(groupId: String, healthcarePartyId: String):
				Promise<GroupScopedJs<HealthcarePartyJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val healthcarePartyIdConverted: String = healthcarePartyId
			val result = healthcarePartyApi.inGroup.getHealthcareParty(
				groupIdConverted,
				healthcarePartyIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: HealthcareParty ->
							healthcareParty_toJs(x1)
						},
					)
				}
			)
		}

		override fun getHealthcareParties(groupId: String, healthcarePartiesIds: Array<String>):
				Promise<Array<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val healthcarePartiesIdsConverted: List<String> = arrayToList(
				healthcarePartiesIds,
				"healthcarePartiesIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthcarePartyApi.inGroup.getHealthcareParties(
				groupIdConverted,
				healthcarePartiesIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
				Promise<GroupScopedJs<HealthcarePartyJs>> = GlobalScope.promise {
			val healthcarePartyConverted: GroupScoped<HealthcareParty> = groupScoped_fromJs(
				healthcareParty,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.modifyHealthcareParty(
				healthcarePartyConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}

		override fun modifyHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
				Promise<Array<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val healthcarePartiesConverted: List<GroupScoped<HealthcareParty>> = arrayToList(
				healthcareParties,
				"healthcareParties",
				{ x1: GroupScopedJs<HealthcarePartyJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthcarePartyJs ->
							healthcareParty_fromJs(x2)
						},
					)
				},
			)
			val result = healthcarePartyApi.inGroup.modifyHealthcareParties(
				healthcarePartiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.deleteHealthcarePartyById(
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
				fun deleteHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = healthcarePartyApi.inGroup.deleteHealthcarePartyByIds(
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

		override fun deleteHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val healthcarePartyConverted: GroupScoped<HealthcareParty> = groupScoped_fromJs(
				healthcareParty,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.deleteHealthcareParty(
				healthcarePartyConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val healthcarePartiesConverted: List<GroupScoped<HealthcareParty>> = arrayToList(
				healthcareParties,
				"healthcareParties",
				{ x1: GroupScopedJs<HealthcarePartyJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthcarePartyJs ->
							healthcareParty_fromJs(x2)
						},
					)
				},
			)
			val result = healthcarePartyApi.inGroup.deleteHealthcareParties(
				healthcarePartiesConverted,
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

		override fun undeleteHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<HealthcarePartyJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.undeleteHealthcarePartyById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}

		override
				fun undeleteHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
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
			val result = healthcarePartyApi.inGroup.undeleteHealthcarePartyByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
				Promise<GroupScopedJs<HealthcarePartyJs>> = GlobalScope.promise {
			val healthcarePartyConverted: GroupScoped<HealthcareParty> = groupScoped_fromJs(
				healthcareParty,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.inGroup.undeleteHealthcareParty(
				healthcarePartyConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}

		override
				fun undeleteHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
				Promise<Array<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val healthcarePartiesConverted: List<GroupScoped<HealthcareParty>> = arrayToList(
				healthcareParties,
				"healthcareParties",
				{ x1: GroupScopedJs<HealthcarePartyJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthcarePartyJs ->
							healthcareParty_fromJs(x2)
						},
					)
				},
			)
			val result = healthcarePartyApi.inGroup.undeleteHealthcareParties(
				healthcarePartiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeHealthcarePartyById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			healthcarePartyApi.inGroup.purgeHealthcarePartyById(
				entityIdConverted,
			)

		}

		override
				fun purgeHealthcarePartyByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = healthcarePartyApi.inGroup.purgeHealthcarePartyByIds(
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

		override fun purgeHealthcareParty(healthcareParty: GroupScopedJs<HealthcarePartyJs>):
				Promise<Unit> = GlobalScope.promise {
			val healthcarePartyConverted: GroupScoped<HealthcareParty> = groupScoped_fromJs(
				healthcareParty,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			healthcarePartyApi.inGroup.purgeHealthcareParty(
				healthcarePartyConverted,
			)

		}

		override fun purgeHealthcareParties(healthcareParties: Array<GroupScopedJs<HealthcarePartyJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val healthcarePartiesConverted: List<GroupScoped<HealthcareParty>> = arrayToList(
				healthcareParties,
				"healthcareParties",
				{ x1: GroupScopedJs<HealthcarePartyJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthcarePartyJs ->
							healthcareParty_fromJs(x2)
						},
					)
				},
			)
			val result = healthcarePartyApi.inGroup.purgeHealthcareParties(
				healthcarePartiesConverted,
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

		override fun matchHealthcarePartiesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
					baseSortableFilterOptions_fromJs(filter)
			val result = healthcarePartyApi.inGroup.matchHealthcarePartiesBySorted(
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

		override fun filterHealthPartiesBy(groupId: String,
				filter: BaseFilterOptionsJs<HealthcarePartyJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
			val result = healthcarePartyApi.inGroup.filterHealthPartiesBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterHealthPartiesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<HealthcarePartyJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
					baseSortableFilterOptions_fromJs(filter)
			val result = healthcarePartyApi.inGroup.filterHealthPartiesBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<HealthcareParty> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthcareParty ->
							healthcareParty_toJs(x2)
						},
					)
				},
			)
		}
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

	override fun createHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>
			= GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.createHealthcareParty(
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun createHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.createHealthcareParties(
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun modifyHealthcareParty(healthcareParty: HealthcarePartyJs): Promise<HealthcarePartyJs>
			= GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.modifyHealthcareParty(
			healthcarePartyConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun modifyHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.modifyHealthcareParties(
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs> = GlobalScope.promise {
		val result = healthcarePartyApi.getCurrentHealthcareParty(
		)
		healthcareParty_toJs(result)
	}

	override fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs> = GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = healthcarePartyApi.getPublicKey(
			healthcarePartyIdConverted,
		)
		publicKey_toJs(result)
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

	override fun deleteHealthcarePartyById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = healthcarePartyApi.deleteHealthcarePartyById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
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
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
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

	override fun purgeHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.purgeHealthcarePartiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
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

	override fun undeleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.undeleteHealthcarePartiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun deleteHealthcareParty(healthcareParty: HealthcarePartyJs):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val healthcarePartyConverted: HealthcareParty = healthcareParty_fromJs(healthcareParty)
		val result = healthcarePartyApi.deleteHealthcareParty(
			healthcarePartyConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
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
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
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

	override fun purgeHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.purgeHealthcareParties(
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
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

	override fun undeleteHealthcareParties(healthcareParties: Array<HealthcarePartyJs>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val healthcarePartiesConverted: List<HealthcareParty> = arrayToList(
			healthcareParties,
			"healthcareParties",
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
		val result = healthcarePartyApi.undeleteHealthcareParties(
			healthcarePartiesConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
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
