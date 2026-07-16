// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MaintenanceTaskApi
import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MaintenanceTaskApiJs
import com.icure.cardinal.sdk.js.api.MaintenanceTaskFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs
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
import com.icure.cardinal.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.MaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.maintenanceTask_fromJs
import com.icure.cardinal.sdk.js.model.maintenanceTask_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
internal class MaintenanceTaskApiImplJs(
	private val maintenanceTaskApi: MaintenanceTaskApi,
) : MaintenanceTaskApiJs {
	override val encrypted: MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs> = object :
			MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs> {
		override fun shareWith(
			delegateId: String,
			maintenanceTask: EncryptedMaintenanceTaskJs,
			options: dynamic,
		): Promise<EncryptedMaintenanceTaskJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
				val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MaintenanceTaskShareOptionsJs? ->
					options?.let { nonNull1 ->
						maintenanceTaskShareOptions_fromJs(nonNull1)
					}
				}
				val result = maintenanceTaskApi.encrypted.shareWith(
					delegateIdConverted,
					maintenanceTaskConverted,
					optionsConverted,
				)
				maintenanceTask_toJs(result)
			}
		}

		override fun shareWithMany(maintenanceTask: EncryptedMaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<EncryptedMaintenanceTaskJs> =
				GlobalScope.promise {
			val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.encrypted.shareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
			val result = maintenanceTaskApi.encrypted.filterMaintenanceTasksBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<MaintenanceTask> =
					sortableFilterOptions_fromJs(filter)
			val result = maintenanceTaskApi.encrypted.filterMaintenanceTasksBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun createMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
				Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
			val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.encrypted.createMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs):
				Promise<MaintenanceTaskJs> = GlobalScope.promise {
			val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val result = maintenanceTaskApi.encrypted.undeleteMaintenanceTask(
				maintenanceTaskConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun undeleteMaintenanceTaskById(id: String, rev: String):
				Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = maintenanceTaskApi.encrypted.undeleteMaintenanceTaskById(
				idConverted,
				revConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
				Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
			val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.encrypted.modifyMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = maintenanceTaskApi.encrypted.getMaintenanceTask(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					maintenanceTask_toJs(nonNull1)
				}
			)
		}

		override fun getMaintenanceTasks(entityIds: Array<String>):
				Promise<Array<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = maintenanceTaskApi.encrypted.getMaintenanceTasks(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> = object :
			MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> {
		override fun shareWith(
			delegateId: String,
			maintenanceTask: MaintenanceTaskJs,
			options: dynamic,
		): Promise<MaintenanceTaskJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
				val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MaintenanceTaskShareOptionsJs? ->
					options?.let { nonNull1 ->
						maintenanceTaskShareOptions_fromJs(nonNull1)
					}
				}
				val result = maintenanceTaskApi.tryAndRecover.shareWith(
					delegateIdConverted,
					maintenanceTaskConverted,
					optionsConverted,
				)
				maintenanceTask_toJs(result)
			}
		}

		override fun shareWithMany(maintenanceTask: MaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.tryAndRecover.shareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<MaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
			val result = maintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<MaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<MaintenanceTask> =
					sortableFilterOptions_fromJs(filter)
			val result = maintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun createMaintenanceTask(entity: MaintenanceTaskJs): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val entityConverted: MaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.tryAndRecover.createMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs):
				Promise<MaintenanceTaskJs> = GlobalScope.promise {
			val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val result = maintenanceTaskApi.tryAndRecover.undeleteMaintenanceTask(
				maintenanceTaskConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun undeleteMaintenanceTaskById(id: String, rev: String): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = maintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskById(
				idConverted,
				revConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun modifyMaintenanceTask(entity: MaintenanceTaskJs): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val entityConverted: MaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.tryAndRecover.modifyMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTask(entityId: String): Promise<MaintenanceTaskJs?> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = maintenanceTaskApi.tryAndRecover.getMaintenanceTask(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					maintenanceTask_toJs(nonNull1)
				}
			)
		}

		override fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<MaintenanceTaskJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = maintenanceTaskApi.tryAndRecover.getMaintenanceTasks(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override fun withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTaskJs?,
			options: dynamic): Promise<DecryptedMaintenanceTaskJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val maintenanceTaskConverted: DecryptedMaintenanceTask? = maintenanceTask?.let { nonNull1 ->
				maintenanceTask_fromJs(nonNull1)
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
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = maintenanceTaskApi.withEncryptionMetadata(
				maintenanceTaskConverted,
				userConverted,
				delegatesConverted,
				alternateRootDelegateIdConverted,
			)
			maintenanceTask_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.getEncryptionKeysOf(
			maintenanceTaskConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.hasWriteAccess(
			maintenanceTaskConverted,
		)
		result
	}

	override fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.decryptPatientIdOf(
			maintenanceTaskConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: MaintenanceTask = maintenanceTask_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		maintenanceTaskApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(maintenanceTasks: Array<EncryptedMaintenanceTaskJs>):
			Promise<Array<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val maintenanceTasksConverted: List<EncryptedMaintenanceTask> = arrayToList(
			maintenanceTasks,
			"maintenanceTasks",
			{ x1: EncryptedMaintenanceTaskJs ->
				maintenanceTask_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.decrypt(
			maintenanceTasksConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun decrypt(maintenanceTask: EncryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.decrypt(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun tryDecrypt(maintenanceTasks: Array<EncryptedMaintenanceTaskJs>):
			Promise<Array<MaintenanceTaskJs>> = GlobalScope.promise {
		val maintenanceTasksConverted: List<EncryptedMaintenanceTask> = arrayToList(
			maintenanceTasks,
			"maintenanceTasks",
			{ x1: EncryptedMaintenanceTaskJs ->
				maintenanceTask_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.tryDecrypt(
			maintenanceTasksConverted,
		)
		listToArray(
			result,
			{ x1: MaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTaskJs): Promise<MaintenanceTaskJs> =
			GlobalScope.promise {
		val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.tryDecrypt(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun matchMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
		val result = maintenanceTaskApi.matchMaintenanceTasksBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<MaintenanceTask> = sortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskApi.matchMaintenanceTasksBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteMaintenanceTaskUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskApi.deleteMaintenanceTaskUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasksUnsafe(entityIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskApi.deleteMaintenanceTasksUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteMaintenanceTaskById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = maintenanceTaskApi.deleteMaintenanceTaskById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.deleteMaintenanceTasksByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMaintenanceTaskById(id: String, rev: String): Promise<Unit> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		maintenanceTaskApi.purgeMaintenanceTaskById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.deleteMaintenanceTask(
			maintenanceTaskConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTaskJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val maintenanceTasksConverted: List<MaintenanceTask> = arrayToList(
			maintenanceTasks,
			"maintenanceTasks",
			{ x1: MaintenanceTaskJs ->
				maintenanceTask_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.deleteMaintenanceTasks(
			maintenanceTasksConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMaintenanceTask(maintenanceTask: MaintenanceTaskJs): Promise<Unit> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		maintenanceTaskApi.purgeMaintenanceTask(
			maintenanceTaskConverted,
		)

	}

	override fun shareWith(
		delegateId: String,
		maintenanceTask: DecryptedMaintenanceTaskJs,
		options: dynamic,
	): Promise<DecryptedMaintenanceTaskJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val maintenanceTaskConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: MaintenanceTaskShareOptionsJs? ->
				options?.let { nonNull1 ->
					maintenanceTaskShareOptions_fromJs(nonNull1)
				}
			}
			val result = maintenanceTaskApi.shareWith(
				delegateIdConverted,
				maintenanceTaskConverted,
				optionsConverted,
			)
			maintenanceTask_toJs(result)
		}
	}

	override fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		val maintenanceTaskConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: MaintenanceTaskShareOptionsJs ->
				maintenanceTaskShareOptions_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.shareWithMany(
			maintenanceTaskConverted,
			delegatesConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
		val result = maintenanceTaskApi.filterMaintenanceTasksBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<MaintenanceTask> = sortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskApi.filterMaintenanceTasksBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskApi.createMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun undeleteMaintenanceTask(maintenanceTask: MaintenanceTaskJs):
			Promise<MaintenanceTaskJs> = GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.undeleteMaintenanceTask(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun undeleteMaintenanceTaskById(id: String, rev: String):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = maintenanceTaskApi.undeleteMaintenanceTaskById(
			idConverted,
			revConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskApi.modifyMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs?> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskApi.getMaintenanceTask(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				maintenanceTask_toJs(nonNull1)
			}
		)
	}

	override fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskApi.getMaintenanceTasks(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
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
			val result = maintenanceTaskApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}
}
