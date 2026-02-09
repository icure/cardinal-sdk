// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthElementApiJs
import com.icure.cardinal.sdk.js.api.HealthElementFlavouredApiJs
import com.icure.cardinal.sdk.js.api.HealthElementFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.HealthElementInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.HealthElementShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.healthElementShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.healthElement_fromJs
import com.icure.cardinal.sdk.js.model.healthElement_toJs
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
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
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
internal class HealthElementApiImplJs(
	private val healthElementApi: HealthElementApi,
) : HealthElementApiJs {
	override val encrypted: HealthElementFlavouredApiJs<EncryptedHealthElementJs> = object :
			HealthElementFlavouredApiJs<EncryptedHealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthElement: EncryptedHealthElementJs,
			options: dynamic,
		): Promise<EncryptedHealthElementJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val healthElementConverted: EncryptedHealthElement = healthElement_fromJs(healthElement)
				val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: HealthElementShareOptionsJs? ->
					options?.let { nonNull1 ->
						healthElementShareOptions_fromJs(nonNull1)
					}
				}
				val result = healthElementApi.encrypted.shareWith(
					delegateIdConverted,
					healthElementConverted,
					optionsConverted,
				)
				healthElement_toJs(result)
			}
		}

		override fun shareWithMany(healthElement: EncryptedHealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>): Promise<EncryptedHealthElementJs> =
				GlobalScope.promise {
			val healthElementConverted: EncryptedHealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthElementApi.encrypted.shareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			healthElement_toJs(result)
		}

		override fun filterHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
			val result = healthElementApi.encrypted.filterHealthElementsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun filterHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
			val result = healthElementApi.encrypted.filterHealthElementsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun createHealthElement(entity: EncryptedHealthElementJs):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
			val result = healthElementApi.encrypted.createHealthElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun createHealthElements(entities: Array<EncryptedHealthElementJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.encrypted.createHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun undeleteHealthElementById(id: String, rev: String): Promise<EncryptedHealthElementJs>
				= GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = healthElementApi.encrypted.undeleteHealthElementById(
				idConverted,
				revConverted,
			)
			healthElement_toJs(result)
		}

		override fun undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthElementApi.encrypted.undeleteHealthElementsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun undeleteHealthElement(healthElement: HealthElementJs):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
			val result = healthElementApi.encrypted.undeleteHealthElement(
				healthElementConverted,
			)
			healthElement_toJs(result)
		}

		override fun undeleteHealthElements(healthElements: Array<HealthElementJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val healthElementsConverted: List<HealthElement> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.encrypted.undeleteHealthElements(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun modifyHealthElement(entity: EncryptedHealthElementJs):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
			val result = healthElementApi.encrypted.modifyHealthElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun modifyHealthElements(entities: Array<EncryptedHealthElementJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.encrypted.modifyHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun getHealthElement(entityId: String): Promise<EncryptedHealthElementJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = healthElementApi.encrypted.getHealthElement(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					healthElement_toJs(nonNull1)
				}
			)
		}

		override fun getHealthElements(entityIds: Array<String>): Promise<Array<EncryptedHealthElementJs>>
				= GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthElementApi.encrypted.getHealthElements(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: HealthElementFlavouredApiJs<HealthElementJs> = object :
			HealthElementFlavouredApiJs<HealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthElement: HealthElementJs,
			options: dynamic,
		): Promise<HealthElementJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
				val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: HealthElementShareOptionsJs? ->
					options?.let { nonNull1 ->
						healthElementShareOptions_fromJs(nonNull1)
					}
				}
				val result = healthElementApi.tryAndRecover.shareWith(
					delegateIdConverted,
					healthElementConverted,
					optionsConverted,
				)
				healthElement_toJs(result)
			}
		}

		override fun shareWithMany(healthElement: HealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>): Promise<HealthElementJs> =
				GlobalScope.promise {
			val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthElementApi.tryAndRecover.shareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			healthElement_toJs(result)
		}

		override fun filterHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<HealthElementJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
			val result = healthElementApi.tryAndRecover.filterHealthElementsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun filterHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<HealthElementJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
			val result = healthElementApi.tryAndRecover.filterHealthElementsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun createHealthElement(entity: HealthElementJs): Promise<HealthElementJs> =
				GlobalScope.promise {
			val entityConverted: HealthElement = healthElement_fromJs(entity)
			val result = healthElementApi.tryAndRecover.createHealthElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun createHealthElements(entities: Array<HealthElementJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<HealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.tryAndRecover.createHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun undeleteHealthElementById(id: String, rev: String): Promise<HealthElementJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = healthElementApi.tryAndRecover.undeleteHealthElementById(
				idConverted,
				revConverted,
			)
			healthElement_toJs(result)
		}

		override fun undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthElementApi.tryAndRecover.undeleteHealthElementsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun undeleteHealthElement(healthElement: HealthElementJs): Promise<HealthElementJs> =
				GlobalScope.promise {
			val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
			val result = healthElementApi.tryAndRecover.undeleteHealthElement(
				healthElementConverted,
			)
			healthElement_toJs(result)
		}

		override fun undeleteHealthElements(healthElements: Array<HealthElementJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val healthElementsConverted: List<HealthElement> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.tryAndRecover.undeleteHealthElements(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun modifyHealthElement(entity: HealthElementJs): Promise<HealthElementJs> =
				GlobalScope.promise {
			val entityConverted: HealthElement = healthElement_fromJs(entity)
			val result = healthElementApi.tryAndRecover.modifyHealthElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun modifyHealthElements(entities: Array<HealthElementJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<HealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.tryAndRecover.modifyHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun getHealthElement(entityId: String): Promise<HealthElementJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = healthElementApi.tryAndRecover.getHealthElement(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					healthElement_toJs(nonNull1)
				}
			)
		}

		override fun getHealthElements(entityIds: Array<String>): Promise<Array<HealthElementJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthElementApi.tryAndRecover.getHealthElements(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}

	override val inGroup: HealthElementInGroupApiJs = object : HealthElementInGroupApiJs {
		override val encrypted: HealthElementFlavouredInGroupApiJs<EncryptedHealthElementJs> = object :
				HealthElementFlavouredInGroupApiJs<EncryptedHealthElementJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				healthElement: GroupScopedJs<EncryptedHealthElementJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedHealthElementJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val healthElementConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
						healthElement,
						{ x1: EncryptedHealthElementJs ->
							healthElement_fromJs(x1)
						},
					)
					val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: HealthElementShareOptionsJs? ->
						options?.let { nonNull1 ->
							healthElementShareOptions_fromJs(nonNull1)
						}
					}
					val result = healthElementApi.inGroup.encrypted.shareWith(
						delegateConverted,
						healthElementConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedHealthElement ->
							healthElement_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(healthElement: GroupScopedJs<EncryptedHealthElementJs>,
					delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
				val healthElementConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
					healthElement,
					{ x1: EncryptedHealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, HealthElementShareOptions> =
						EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = healthElementApi.inGroup.encrypted.shareWithMany(
					healthElementConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun filterHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedHealthElementJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
				val result = healthElementApi.inGroup.encrypted.filterHealthElementsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterHealthElementsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<HealthElementJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedHealthElementJs>>> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
				val result = healthElementApi.inGroup.encrypted.filterHealthElementsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun createHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
					Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedHealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.encrypted.createHealthElement(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun createHealthElements(entities: Array<GroupScopedJs<EncryptedHealthElementJs>>):
					Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedHealthElement>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedHealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedHealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.encrypted.createHealthElements(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.encrypted.undeleteHealthElementById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override
					fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
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
				val result = healthElementApi.inGroup.encrypted.undeleteHealthElementsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
					Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
				val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
					healthElement,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.encrypted.undeleteHealthElement(
					healthElementConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override
					fun undeleteHealthElements(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
					Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
				val healthElementsConverted: List<GroupScoped<EncryptedHealthElement>> = arrayToList(
					healthElements,
					"healthElements",
					{ x1: GroupScopedJs<EncryptedHealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedHealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.encrypted.undeleteHealthElements(
					healthElementsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyHealthElement(entity: GroupScopedJs<EncryptedHealthElementJs>):
					Promise<GroupScopedJs<EncryptedHealthElementJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedHealthElement> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedHealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.encrypted.modifyHealthElement(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun modifyHealthElements(entities: Array<GroupScopedJs<EncryptedHealthElementJs>>):
					Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedHealthElement>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedHealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedHealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.encrypted.modifyHealthElements(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun getHealthElement(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedHealthElementJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = healthElementApi.inGroup.encrypted.getHealthElement(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedHealthElement ->
								healthElement_toJs(x1)
							},
						)
					}
				)
			}

			override fun getHealthElements(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = healthElementApi.inGroup.encrypted.getHealthElements(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedHealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedHealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: HealthElementFlavouredInGroupApiJs<HealthElementJs> = object :
				HealthElementFlavouredInGroupApiJs<HealthElementJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				healthElement: GroupScopedJs<HealthElementJs>,
				options: dynamic,
			): Promise<GroupScopedJs<HealthElementJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
						healthElement,
						{ x1: HealthElementJs ->
							healthElement_fromJs(x1)
						},
					)
					val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: HealthElementShareOptionsJs? ->
						options?.let { nonNull1 ->
							healthElementShareOptions_fromJs(nonNull1)
						}
					}
					val result = healthElementApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						healthElementConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: HealthElement ->
							healthElement_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(healthElement: GroupScopedJs<HealthElementJs>,
					delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<HealthElementJs>> = GlobalScope.promise {
				val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
					healthElement,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, HealthElementShareOptions> =
						EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = healthElementApi.inGroup.tryAndRecover.shareWithMany(
					healthElementConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun filterHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
				val result = healthElementApi.inGroup.tryAndRecover.filterHealthElementsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterHealthElementsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<HealthElementJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
				val result = healthElementApi.inGroup.tryAndRecover.filterHealthElementsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun createHealthElement(entity: GroupScopedJs<HealthElementJs>):
					Promise<GroupScopedJs<HealthElementJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
					entity,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.createHealthElement(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun createHealthElements(entities: Array<GroupScopedJs<HealthElementJs>>):
					Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<HealthElement>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<HealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: HealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.createHealthElements(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<HealthElementJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.undeleteHealthElementById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override
					fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
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
				val result = healthElementApi.inGroup.tryAndRecover.undeleteHealthElementsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
					Promise<GroupScopedJs<HealthElementJs>> = GlobalScope.promise {
				val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
					healthElement,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.undeleteHealthElement(
					healthElementConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun undeleteHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
					Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val healthElementsConverted: List<GroupScoped<HealthElement>> = arrayToList(
					healthElements,
					"healthElements",
					{ x1: GroupScopedJs<HealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: HealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.undeleteHealthElements(
					healthElementsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyHealthElement(entity: GroupScopedJs<HealthElementJs>):
					Promise<GroupScopedJs<HealthElementJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
					entity,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.modifyHealthElement(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}

			override fun modifyHealthElements(entities: Array<GroupScopedJs<HealthElementJs>>):
					Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<HealthElement>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<HealthElementJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: HealthElementJs ->
								healthElement_fromJs(x2)
							},
						)
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.modifyHealthElements(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}

			override fun getHealthElement(groupId: String, entityId: String):
					Promise<GroupScopedJs<HealthElementJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = healthElementApi.inGroup.tryAndRecover.getHealthElement(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: HealthElement ->
								healthElement_toJs(x1)
							},
						)
					}
				)
			}

			override fun getHealthElements(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = healthElementApi.inGroup.tryAndRecover.getHealthElements(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<HealthElement> ->
						groupScoped_toJs(
							x1,
							{ x2: HealthElement ->
								healthElement_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedHealthElementJs?,
			patient: GroupScopedJs<PatientJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedHealthElementJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedHealthElement? = base?.let { nonNull1 ->
					healthElement_fromJs(nonNull1)
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
				val result = healthElementApi.inGroup.withEncryptionMetadata(
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
					{ x1: DecryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(healthElement: GroupScopedJs<HealthElementJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.getEncryptionKeysOf(
				healthElementConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(healthElement: GroupScopedJs<HealthElementJs>): Promise<Boolean> =
				GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.hasWriteAccess(
				healthElementConverted,
			)
			result
		}

		override fun decryptPatientIdOf(healthElement: GroupScopedJs<HealthElementJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.decryptPatientIdOf(
				healthElementConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<HealthElementJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				entity,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			healthElementApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<EncryptedHealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<EncryptedHealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedHealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.decrypt(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
				Promise<Array<GroupScopedJs<HealthElementJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<EncryptedHealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<EncryptedHealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedHealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.tryDecrypt(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<HealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: HealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun encryptOrValidate(healthElements: Array<GroupScopedJs<HealthElementJs>>):
				Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<HealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<HealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.encryptOrValidate(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
			val result = healthElementApi.inGroup.matchHealthElementsBy(
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

		override fun matchHealthElementsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<HealthElementJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
			val result = healthElementApi.inGroup.matchHealthElementsBySorted(
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

		override fun deleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.deleteHealthElementById(
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
				fun deleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = healthElementApi.inGroup.deleteHealthElementsByIds(
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

		override fun purgeHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			healthElementApi.inGroup.purgeHealthElementById(
				entityIdConverted,
			)

		}

		override
				fun purgeHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = healthElementApi.inGroup.purgeHealthElementsByIds(
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

		override fun deleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.deleteHealthElement(
				healthElementConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<HealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<HealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.deleteHealthElements(
				healthElementsConverted,
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

		override fun purgeHealthElement(healthElement: GroupScopedJs<HealthElementJs>): Promise<Unit> =
				GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			healthElementApi.inGroup.purgeHealthElement(
				healthElementConverted,
			)

		}

		override fun purgeHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<HealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<HealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: HealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.purgeHealthElements(
				healthElementsConverted,
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
			healthElement: GroupScopedJs<DecryptedHealthElementJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedHealthElementJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val healthElementConverted: GroupScoped<DecryptedHealthElement> = groupScoped_fromJs(
					healthElement,
					{ x1: DecryptedHealthElementJs ->
						healthElement_fromJs(x1)
					},
				)
				val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: HealthElementShareOptionsJs? ->
					options?.let { nonNull1 ->
						healthElementShareOptions_fromJs(nonNull1)
					}
				}
				val result = healthElementApi.inGroup.shareWith(
					delegateConverted,
					healthElementConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(healthElement: GroupScopedJs<DecryptedHealthElementJs>,
				delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedHealthElementJs>> = GlobalScope.promise {
			val healthElementConverted: GroupScoped<DecryptedHealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: DecryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, HealthElementShareOptions> =
					EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = healthElementApi.inGroup.shareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun filterHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedHealthElementJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
			val result = healthElementApi.inGroup.filterHealthElementsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterHealthElementsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<HealthElementJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedHealthElementJs>>> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
			val result = healthElementApi.inGroup.filterHealthElementsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun createHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
				Promise<GroupScopedJs<DecryptedHealthElementJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedHealthElement> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.createHealthElement(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun createHealthElements(entities: Array<GroupScopedJs<DecryptedHealthElementJs>>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedHealthElement>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedHealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedHealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.createHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedHealthElementJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.undeleteHealthElementById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override
				fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
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
			val result = healthElementApi.inGroup.undeleteHealthElementsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
				Promise<GroupScopedJs<DecryptedHealthElementJs>> = GlobalScope.promise {
			val healthElementConverted: GroupScoped<HealthElement> = groupScoped_fromJs(
				healthElement,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.undeleteHealthElement(
				healthElementConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override
				fun undeleteHealthElements(healthElements: Array<GroupScopedJs<DecryptedHealthElementJs>>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
			val healthElementsConverted: List<GroupScoped<DecryptedHealthElement>> = arrayToList(
				healthElements,
				"healthElements",
				{ x1: GroupScopedJs<DecryptedHealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedHealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.undeleteHealthElements(
				healthElementsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
				Promise<GroupScopedJs<DecryptedHealthElementJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedHealthElement> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthElementApi.inGroup.modifyHealthElement(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun modifyHealthElements(entities: Array<GroupScopedJs<DecryptedHealthElementJs>>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedHealthElement>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedHealthElementJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedHealthElementJs ->
							healthElement_fromJs(x2)
						},
					)
				},
			)
			val result = healthElementApi.inGroup.modifyHealthElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}

		override fun getHealthElement(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedHealthElementJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = healthElementApi.inGroup.getHealthElement(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedHealthElement ->
							healthElement_toJs(x1)
						},
					)
				}
			)
		}

		override fun getHealthElements(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthElementApi.inGroup.getHealthElements(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedHealthElement> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedHealthElement ->
							healthElement_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedHealthElementJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedHealthElementJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedHealthElement? = base?.let { nonNull1 ->
				healthElement_fromJs(nonNull1)
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
			val result = healthElementApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			healthElement_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(healthElement: HealthElementJs): Promise<Array<String>> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementApi.getEncryptionKeysOf(
			healthElementConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(healthElement: HealthElementJs): Promise<Boolean> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementApi.hasWriteAccess(
			healthElementConverted,
		)
		result
	}

	override fun decryptPatientIdOf(healthElement: HealthElementJs):
			Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementApi.decryptPatientIdOf(
			healthElementConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: HealthElementJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: HealthElement = healthElement_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		healthElementApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(healthElements: Array<EncryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val healthElementsConverted: List<EncryptedHealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: EncryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.decrypt(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun tryDecrypt(healthElements: Array<EncryptedHealthElementJs>):
			Promise<Array<HealthElementJs>> = GlobalScope.promise {
		val healthElementsConverted: List<EncryptedHealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: EncryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.tryDecrypt(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: HealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun encryptOrValidate(healthElements: Array<HealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
		val healthElementsConverted: List<HealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.encryptOrValidate(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun matchHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
		val result = healthElementApi.matchHealthElementsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
		val result = healthElementApi.matchHealthElementsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteHealthElementById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = healthElementApi.deleteHealthElementById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthElementApi.deleteHealthElementsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthElementById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		healthElementApi.purgeHealthElementById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthElementApi.purgeHealthElementsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteHealthElement(healthElement: HealthElementJs):
			Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementApi.deleteHealthElement(
			healthElementConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val healthElementsConverted: List<HealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.deleteHealthElements(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeHealthElement(healthElement: HealthElementJs): Promise<Unit> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		healthElementApi.purgeHealthElement(
			healthElementConverted,
		)

	}

	override fun purgeHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val healthElementsConverted: List<HealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.purgeHealthElements(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		healthElement: DecryptedHealthElementJs,
		options: dynamic,
	): Promise<DecryptedHealthElementJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val healthElementConverted: DecryptedHealthElement = healthElement_fromJs(healthElement)
			val optionsConverted: HealthElementShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: HealthElementShareOptionsJs? ->
				options?.let { nonNull1 ->
					healthElementShareOptions_fromJs(nonNull1)
				}
			}
			val result = healthElementApi.shareWith(
				delegateIdConverted,
				healthElementConverted,
				optionsConverted,
			)
			healthElement_toJs(result)
		}
	}

	override fun shareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>): Promise<DecryptedHealthElementJs> =
			GlobalScope.promise {
		val healthElementConverted: DecryptedHealthElement = healthElement_fromJs(healthElement)
		val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: HealthElementShareOptionsJs ->
				healthElementShareOptions_fromJs(x1)
			},
		)
		val result = healthElementApi.shareWithMany(
			healthElementConverted,
			delegatesConverted,
		)
		healthElement_toJs(result)
	}

	override fun filterHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
		val result = healthElementApi.filterHealthElementsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun filterHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<HealthElement> = sortableFilterOptions_fromJs(filter)
		val result = healthElementApi.filterHealthElementsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun createHealthElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: DecryptedHealthElement = healthElement_fromJs(entity)
		val result = healthElementApi.createHealthElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun createHealthElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.createHealthElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun undeleteHealthElementById(id: String, rev: String): Promise<DecryptedHealthElementJs>
			= GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = healthElementApi.undeleteHealthElementById(
			idConverted,
			revConverted,
		)
		healthElement_toJs(result)
	}

	override fun undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = healthElementApi.undeleteHealthElementsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun undeleteHealthElement(healthElement: HealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthElementApi.undeleteHealthElement(
			healthElementConverted,
		)
		healthElement_toJs(result)
	}

	override fun undeleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val healthElementsConverted: List<HealthElement> = arrayToList(
			healthElements,
			"healthElements",
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.undeleteHealthElements(
			healthElementsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun modifyHealthElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: DecryptedHealthElement = healthElement_fromJs(entity)
		val result = healthElementApi.modifyHealthElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun modifyHealthElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthElementApi.modifyHealthElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun getHealthElement(entityId: String): Promise<DecryptedHealthElementJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthElementApi.getHealthElement(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				healthElement_toJs(nonNull1)
			}
		)
	}

	override fun getHealthElements(entityIds: Array<String>): Promise<Array<DecryptedHealthElementJs>>
			= GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthElementApi.getHealthElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<HealthElementJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedHealthElementJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<HealthElement> = filterOptions_fromJs(filter)
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
			val result = healthElementApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}
}
