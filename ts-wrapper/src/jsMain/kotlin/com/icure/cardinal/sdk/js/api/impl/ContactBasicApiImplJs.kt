// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ContactBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.ContactBasicApiJs
import com.icure.cardinal.sdk.js.api.ContactBasicInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.contact_fromJs
import com.icure.cardinal.sdk.js.model.contact_toJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.embed.service_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Double
import kotlin.Long
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
internal class ContactBasicApiImplJs(
	private val contactBasicApi: ContactBasicApi,
) : ContactBasicApiJs {
	override val inGroup: ContactBasicInGroupApiJs = object : ContactBasicInGroupApiJs {
		override fun matchContactsBy(groupId: String, filter: BaseFilterOptionsJs<ContactJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.matchContactsBy(
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

		override fun matchContactsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<ContactJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Contact> =
					baseSortableFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.matchContactsBySorted(
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

		override fun matchServicesBy(groupId: String, filter: BaseFilterOptionsJs<ServiceJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.matchServicesBy(
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

		override fun matchServicesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<ServiceJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Service> =
					baseSortableFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.matchServicesBySorted(
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

		override fun filterContactsBy(groupId: String, filter: BaseFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.filterContactsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterContactsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Contact> =
					baseSortableFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.filterContactsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterServicesBy(groupId: String, filter: BaseFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedServiceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.filterServicesBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedService> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedService ->
							service_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterServicesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedServiceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Service> =
					baseSortableFilterOptions_fromJs(filter)
			val result = contactBasicApi.inGroup.filterServicesBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedService> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedService ->
							service_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.deleteContactById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = contactBasicApi.inGroup.deleteContactsByIds(
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

		override fun purgeContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			contactBasicApi.inGroup.purgeContactById(
				entityIdConverted,
			)

		}

		override fun purgeContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = contactBasicApi.inGroup.purgeContactsByIds(
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

		override fun deleteContact(contact: GroupScopedJs<ContactJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.deleteContact(
				contactConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteContacts(contacts: Array<GroupScopedJs<ContactJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val contactsConverted: List<GroupScoped<Contact>> = arrayToList(
				contacts,
				"contacts",
				{ x1: GroupScopedJs<ContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: ContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactBasicApi.inGroup.deleteContacts(
				contactsConverted,
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

		override fun purgeContact(contact: GroupScopedJs<ContactJs>): Promise<Unit> =
				GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			contactBasicApi.inGroup.purgeContact(
				contactConverted,
			)

		}

		override fun purgeContacts(contacts: Array<GroupScopedJs<ContactJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val contactsConverted: List<GroupScoped<Contact>> = arrayToList(
				contacts,
				"contacts",
				{ x1: GroupScopedJs<ContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: ContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactBasicApi.inGroup.purgeContacts(
				contactsConverted,
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

		override fun createContact(entity: GroupScopedJs<EncryptedContactJs>):
				Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedContact> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.createContact(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun createContacts(entities: Array<GroupScopedJs<EncryptedContactJs>>):
				Promise<Array<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedContact>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactBasicApi.inGroup.createContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.undeleteContactById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
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
			val result = contactBasicApi.inGroup.undeleteContactsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteContact(contact: GroupScopedJs<ContactJs>):
				Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.undeleteContact(
				contactConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContacts(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
				Promise<Array<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val contactsConverted: List<GroupScoped<EncryptedContact>> = arrayToList(
				contacts,
				"contacts",
				{ x1: GroupScopedJs<EncryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactBasicApi.inGroup.undeleteContacts(
				contactsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyContact(entity: GroupScopedJs<EncryptedContactJs>):
				Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedContact> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactBasicApi.inGroup.modifyContact(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun modifyContacts(entities: Array<GroupScopedJs<EncryptedContactJs>>):
				Promise<Array<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedContact>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactBasicApi.inGroup.modifyContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun getContact(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedContactJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = contactBasicApi.inGroup.getContact(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedContact ->
							contact_toJs(x1)
						},
					)
				}
			)
		}

		override fun getContacts(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactBasicApi.inGroup.getContacts(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun getService(groupId: String, serviceId: String):
				Promise<GroupScopedJs<EncryptedServiceJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val serviceIdConverted: String = serviceId
			val result = contactBasicApi.inGroup.getService(
				groupIdConverted,
				serviceIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedService ->
							service_toJs(x1)
						},
					)
				}
			)
		}

		override fun getServices(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedServiceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactBasicApi.inGroup.getServices(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedService> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedService ->
							service_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchContactsBy(filter: BaseFilterOptionsJs<ContactJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchContactsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBy(filter: BaseFilterOptionsJs<ServiceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchServicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Contact> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchContactsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Service> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchServicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterContactsBy(filter: BaseFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterContactsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBy(filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterServicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun filterContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Contact> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterContactsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Service> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterServicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
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
			val result = contactBasicApi.subscribeToServiceCreateOrUpdateEvents(
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}
	}

	override fun deleteContactById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = contactBasicApi.deleteContactById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = contactBasicApi.deleteContactsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeContactById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		contactBasicApi.purgeContactById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = contactBasicApi.purgeContactsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteContact(contact: ContactJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactBasicApi.deleteContact(
			contactConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteContacts(contacts: Array<ContactJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val contactsConverted: List<Contact> = arrayToList(
			contacts,
			"contacts",
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactBasicApi.deleteContacts(
			contactsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeContact(contact: ContactJs): Promise<Unit> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		contactBasicApi.purgeContact(
			contactConverted,
		)

	}

	override fun purgeContacts(contacts: Array<ContactJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val contactsConverted: List<Contact> = arrayToList(
			contacts,
			"contacts",
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactBasicApi.purgeContacts(
			contactsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		val codeTypeConverted: String = codeType
		val minOccurrencesConverted: Long = numberToLong(minOccurrences, "minOccurrences")
		val result = contactBasicApi.getServiceCodesOccurrences(
			codeTypeConverted,
			minOccurrencesConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun createContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedContact = contact_fromJs(entity)
		val result = contactBasicApi.createContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun createContacts(entities: Array<EncryptedContactJs>):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactBasicApi.createContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun undeleteContactById(id: String, rev: String): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = contactBasicApi.undeleteContactById(
			idConverted,
			revConverted,
		)
		contact_toJs(result)
	}

	override fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = contactBasicApi.undeleteContactsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun undeleteContact(contact: ContactJs): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactBasicApi.undeleteContact(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<EncryptedContactJs>> =
			GlobalScope.promise {
		val contactsConverted: List<Contact> = arrayToList(
			contacts,
			"contacts",
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactBasicApi.undeleteContacts(
			contactsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedContact = contact_fromJs(entity)
		val result = contactBasicApi.modifyContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun modifyContacts(entities: Array<EncryptedContactJs>):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactBasicApi.modifyContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getContact(entityId: String): Promise<EncryptedContactJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactBasicApi.getContact(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				contact_toJs(nonNull1)
			}
		)
	}

	override fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactBasicApi.getContacts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getService(serviceId: String): Promise<EncryptedServiceJs?> = GlobalScope.promise {
		val serviceIdConverted: String = serviceId
		val result = contactBasicApi.getService(
			serviceIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				service_toJs(nonNull1)
			}
		)
	}

	override fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactBasicApi.getServices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
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
			val result = contactBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}
}
