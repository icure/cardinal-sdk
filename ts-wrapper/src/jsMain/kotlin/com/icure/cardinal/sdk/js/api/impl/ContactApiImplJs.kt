// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.ContactApiJs
import com.icure.cardinal.sdk.js.api.ContactFlavouredApiJs
import com.icure.cardinal.sdk.js.api.ContactFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.ContactInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.contactShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.DecryptedContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.contact_fromJs
import com.icure.cardinal.sdk.js.model.contact_toJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.embed.service_fromJs
import com.icure.cardinal.sdk.js.model.embed.service_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
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
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
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
internal class ContactApiImplJs(
	private val contactApi: ContactApi,
) : ContactApiJs {
	override val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> = object :
			ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: EncryptedContactJs,
			options: dynamic,
		): Promise<EncryptedContactJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: EncryptedContact = contact_fromJs(contact)
				val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ContactShareOptionsJs? ->
					options?.let { nonNull1 ->
						contactShareOptions_fromJs(nonNull1)
					}
				}
				val result = contactApi.encrypted.shareWith(
					delegateIdConverted,
					contactConverted,
					optionsConverted,
				)
				contact_toJs(result)
			}
		}

		override fun shareWithMany(contact: EncryptedContactJs,
				delegates: Record<String, ContactShareOptionsJs>): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val contactConverted: EncryptedContact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.encrypted.shareWithMany(
				contactConverted,
				delegatesConverted,
			)
			contact_toJs(result)
		}

		override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterContactsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterServicesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterContactsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterServicesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun createContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedContact = contact_fromJs(entity)
			val result = contactApi.encrypted.createContact(
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
			val result = contactApi.encrypted.createContacts(
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
			val result = contactApi.encrypted.undeleteContactById(
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
			val result = contactApi.encrypted.undeleteContactsByIds(
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
			val result = contactApi.encrypted.undeleteContact(
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
			val result = contactApi.encrypted.undeleteContacts(
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
			val result = contactApi.encrypted.modifyContact(
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
			val result = contactApi.encrypted.modifyContacts(
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
			val result = contactApi.encrypted.getContact(
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
			val result = contactApi.encrypted.getContacts(
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
			val result = contactApi.encrypted.getService(
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
			val result = contactApi.encrypted.getServices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs> = object :
			ContactFlavouredApiJs<ContactJs, ServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: ContactJs,
			options: dynamic,
		): Promise<ContactJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: Contact = contact_fromJs(contact)
				val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ContactShareOptionsJs? ->
					options?.let { nonNull1 ->
						contactShareOptions_fromJs(nonNull1)
					}
				}
				val result = contactApi.tryAndRecover.shareWith(
					delegateIdConverted,
					contactConverted,
					optionsConverted,
				)
				contact_toJs(result)
			}
		}

		override fun shareWithMany(contact: ContactJs, delegates: Record<String, ContactShareOptionsJs>):
				Promise<ContactJs> = GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.shareWithMany(
				contactConverted,
				delegatesConverted,
			)
			contact_toJs(result)
		}

		override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<ContactJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterContactsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<ServiceJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterServicesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<ContactJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterContactsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<ServiceJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterServicesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun createContact(entity: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val entityConverted: Contact = contact_fromJs(entity)
			val result = contactApi.tryAndRecover.createContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun createContacts(entities: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Contact> = arrayToList(
				entities,
				"entities",
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.createContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContactById(id: String, rev: String): Promise<ContactJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = contactApi.tryAndRecover.undeleteContactById(
				idConverted,
				revConverted,
			)
			contact_toJs(result)
		}

		override fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.undeleteContactsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContact(contact: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val result = contactApi.tryAndRecover.undeleteContact(
				contactConverted,
			)
			contact_toJs(result)
		}

		override fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val contactsConverted: List<Contact> = arrayToList(
				contacts,
				"contacts",
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.undeleteContacts(
				contactsConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun modifyContact(entity: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val entityConverted: Contact = contact_fromJs(entity)
			val result = contactApi.tryAndRecover.modifyContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun modifyContacts(entities: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Contact> = arrayToList(
				entities,
				"entities",
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.modifyContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getContact(entityId: String): Promise<ContactJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = contactApi.tryAndRecover.getContact(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					contact_toJs(nonNull1)
				}
			)
		}

		override fun getContacts(entityIds: Array<String>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.getContacts(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getService(serviceId: String): Promise<ServiceJs?> = GlobalScope.promise {
			val serviceIdConverted: String = serviceId
			val result = contactApi.tryAndRecover.getService(
				serviceIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					service_toJs(nonNull1)
				}
			)
		}

		override fun getServices(entityIds: Array<String>): Promise<Array<ServiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.getServices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}
	}

	override val inGroup: ContactInGroupApiJs = object : ContactInGroupApiJs {
		override val encrypted: ContactFlavouredInGroupApiJs<EncryptedContactJs, EncryptedServiceJs> =
				object : ContactFlavouredInGroupApiJs<EncryptedContactJs, EncryptedServiceJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				contact: GroupScopedJs<EncryptedContactJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedContactJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val contactConverted: GroupScoped<EncryptedContact> = groupScoped_fromJs(
						contact,
						{ x1: EncryptedContactJs ->
							contact_fromJs(x1)
						},
					)
					val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: ContactShareOptionsJs? ->
						options?.let { nonNull1 ->
							contactShareOptions_fromJs(nonNull1)
						}
					}
					val result = contactApi.inGroup.encrypted.shareWith(
						delegateConverted,
						contactConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedContact ->
							contact_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(contact: GroupScopedJs<EncryptedContactJs>,
					delegates: Array<EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
				val contactConverted: GroupScoped<EncryptedContact> = groupScoped_fromJs(
					contact,
					{ x1: EncryptedContactJs ->
						contact_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, ContactShareOptions> =
						EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = contactApi.inGroup.encrypted.shareWithMany(
					contactConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedContact ->
						contact_toJs(x1)
					},
				)
			}

			override fun filterContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
				val result = contactApi.inGroup.encrypted.filterContactsBy(
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

			override fun filterContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
				val result = contactApi.inGroup.encrypted.filterContactsBySorted(
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

			override fun createContact(entity: GroupScopedJs<EncryptedContactJs>):
					Promise<GroupScopedJs<EncryptedContactJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedContact> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedContactJs ->
						contact_fromJs(x1)
					},
				)
				val result = contactApi.inGroup.encrypted.createContact(
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
				val result = contactApi.inGroup.encrypted.createContacts(
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
				val result = contactApi.inGroup.encrypted.undeleteContactById(
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
				val result = contactApi.inGroup.encrypted.undeleteContactsByIds(
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
				val result = contactApi.inGroup.encrypted.undeleteContact(
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
				val result = contactApi.inGroup.encrypted.undeleteContacts(
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
				val result = contactApi.inGroup.encrypted.modifyContact(
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
				val result = contactApi.inGroup.encrypted.modifyContacts(
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
				val result = contactApi.inGroup.encrypted.getContact(
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
				val result = contactApi.inGroup.encrypted.getContacts(
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
				val result = contactApi.inGroup.encrypted.getService(
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
				val result = contactApi.inGroup.encrypted.getServices(
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

		override val tryAndRecover: ContactFlavouredInGroupApiJs<ContactJs, ServiceJs> = object :
				ContactFlavouredInGroupApiJs<ContactJs, ServiceJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				contact: GroupScopedJs<ContactJs>,
				options: dynamic,
			): Promise<GroupScopedJs<ContactJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
						contact,
						{ x1: ContactJs ->
							contact_fromJs(x1)
						},
					)
					val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: ContactShareOptionsJs? ->
						options?.let { nonNull1 ->
							contactShareOptions_fromJs(nonNull1)
						}
					}
					val result = contactApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						contactConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Contact ->
							contact_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(contact: GroupScopedJs<ContactJs>,
					delegates: Array<EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<ContactJs>> = GlobalScope.promise {
				val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
					contact,
					{ x1: ContactJs ->
						contact_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, ContactShareOptions> =
						EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = contactApi.inGroup.tryAndRecover.shareWithMany(
					contactConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}

			override fun filterContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
				val result = contactApi.inGroup.tryAndRecover.filterContactsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
				val result = contactApi.inGroup.tryAndRecover.filterContactsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun createContact(entity: GroupScopedJs<ContactJs>): Promise<GroupScopedJs<ContactJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Contact> = groupScoped_fromJs(
					entity,
					{ x1: ContactJs ->
						contact_fromJs(x1)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.createContact(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}

			override fun createContacts(entities: Array<GroupScopedJs<ContactJs>>):
					Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Contact>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<ContactJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: ContactJs ->
								contact_fromJs(x2)
							},
						)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.createContacts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<ContactJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.undeleteContactById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}

			override fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
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
				val result = contactApi.inGroup.tryAndRecover.undeleteContactsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteContact(contact: GroupScopedJs<ContactJs>):
					Promise<GroupScopedJs<ContactJs>> = GlobalScope.promise {
				val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
					contact,
					{ x1: ContactJs ->
						contact_fromJs(x1)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.undeleteContact(
					contactConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}

			override fun undeleteContacts(contacts: Array<GroupScopedJs<ContactJs>>):
					Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
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
				val result = contactApi.inGroup.tryAndRecover.undeleteContacts(
					contactsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyContact(entity: GroupScopedJs<ContactJs>): Promise<GroupScopedJs<ContactJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Contact> = groupScoped_fromJs(
					entity,
					{ x1: ContactJs ->
						contact_fromJs(x1)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.modifyContact(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}

			override fun modifyContacts(entities: Array<GroupScopedJs<ContactJs>>):
					Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Contact>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<ContactJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: ContactJs ->
								contact_fromJs(x2)
							},
						)
					},
				)
				val result = contactApi.inGroup.tryAndRecover.modifyContacts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun getContact(groupId: String, entityId: String): Promise<GroupScopedJs<ContactJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = contactApi.inGroup.tryAndRecover.getContact(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Contact ->
								contact_toJs(x1)
							},
						)
					}
				)
			}

			override fun getContacts(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = contactApi.inGroup.tryAndRecover.getContacts(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Contact> ->
						groupScoped_toJs(
							x1,
							{ x2: Contact ->
								contact_toJs(x2)
							},
						)
					},
				)
			}

			override fun getService(groupId: String, serviceId: String): Promise<GroupScopedJs<ServiceJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val serviceIdConverted: String = serviceId
				val result = contactApi.inGroup.tryAndRecover.getService(
					groupIdConverted,
					serviceIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Service ->
								service_toJs(x1)
							},
						)
					}
				)
			}

			override fun getServices(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<ServiceJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = contactApi.inGroup.tryAndRecover.getServices(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Service> ->
						groupScoped_toJs(
							x1,
							{ x2: Service ->
								service_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedContactJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedContact? = base?.let { nonNull1 ->
					contact_fromJs(nonNull1)
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
				val result = contactApi.inGroup.withEncryptionMetadata(
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
					{ x1: DecryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(contact: GroupScopedJs<ContactJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.getEncryptionKeysOf(
				contactConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(contact: GroupScopedJs<ContactJs>): Promise<Boolean> =
				GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.hasWriteAccess(
				contactConverted,
			)
			result
		}

		override fun decryptPatientIdOf(contact: GroupScopedJs<ContactJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.decryptPatientIdOf(
				contactConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<ContactJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Contact> = groupScoped_fromJs(
				entity,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			contactApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
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
			val result = contactApi.inGroup.decrypt(
				contactsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
				Promise<Array<GroupScopedJs<ContactJs>>> = GlobalScope.promise {
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
			val result = contactApi.inGroup.tryDecrypt(
				contactsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Contact> ->
					groupScoped_toJs(
						x1,
						{ x2: Contact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun decryptService(service: GroupScopedJs<EncryptedServiceJs>):
				Promise<GroupScopedJs<DecryptedServiceJs>> = GlobalScope.promise {
			val serviceConverted: GroupScoped<EncryptedService> = groupScoped_fromJs(
				service,
				{ x1: EncryptedServiceJs ->
					service_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.decryptService(
				serviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun tryDecryptService(service: GroupScopedJs<EncryptedServiceJs>):
				Promise<GroupScopedJs<ServiceJs>> = GlobalScope.promise {
			val serviceConverted: GroupScoped<EncryptedService> = groupScoped_fromJs(
				service,
				{ x1: EncryptedServiceJs ->
					service_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.tryDecryptService(
				serviceConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun matchContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.inGroup.matchContactsBy(
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

		override fun matchContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.inGroup.matchContactsBySorted(
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

		override fun matchServicesBy(groupId: String, filter: FilterOptionsJs<ServiceJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
			val result = contactApi.inGroup.matchServicesBy(
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

		override fun matchServicesBySorted(groupId: String, filter: SortableFilterOptionsJs<ServiceJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.inGroup.matchServicesBySorted(
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

		override fun deleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.deleteContactById(
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
			val result = contactApi.inGroup.deleteContactsByIds(
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
			contactApi.inGroup.purgeContactById(
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
			val result = contactApi.inGroup.purgeContactsByIds(
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
			val result = contactApi.inGroup.deleteContact(
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
			val result = contactApi.inGroup.deleteContacts(
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
			contactApi.inGroup.purgeContact(
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
			val result = contactApi.inGroup.purgeContacts(
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			contact: GroupScopedJs<DecryptedContactJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val contactConverted: GroupScoped<DecryptedContact> = groupScoped_fromJs(
					contact,
					{ x1: DecryptedContactJs ->
						contact_fromJs(x1)
					},
				)
				val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ContactShareOptionsJs? ->
					options?.let { nonNull1 ->
						contactShareOptions_fromJs(nonNull1)
					}
				}
				val result = contactApi.inGroup.shareWith(
					delegateConverted,
					contactConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(contact: GroupScopedJs<DecryptedContactJs>,
				delegates: Array<EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedContactJs>> = GlobalScope.promise {
			val contactConverted: GroupScoped<DecryptedContact> = groupScoped_fromJs(
				contact,
				{ x1: DecryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, ContactShareOptions> =
					EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = contactApi.inGroup.shareWithMany(
				contactConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.inGroup.filterContactsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.inGroup.filterContactsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun createContact(entity: GroupScopedJs<DecryptedContactJs>):
				Promise<GroupScopedJs<DecryptedContactJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedContact> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.createContact(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun createContacts(entities: Array<GroupScopedJs<DecryptedContactJs>>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedContact>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactApi.inGroup.createContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedContactJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.undeleteContactById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
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
			val result = contactApi.inGroup.undeleteContactsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteContact(contact: GroupScopedJs<ContactJs>):
				Promise<GroupScopedJs<DecryptedContactJs>> = GlobalScope.promise {
			val contactConverted: GroupScoped<Contact> = groupScoped_fromJs(
				contact,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.undeleteContact(
				contactConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContacts(contacts: Array<GroupScopedJs<DecryptedContactJs>>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val contactsConverted: List<GroupScoped<DecryptedContact>> = arrayToList(
				contacts,
				"contacts",
				{ x1: GroupScopedJs<DecryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactApi.inGroup.undeleteContacts(
				contactsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyContact(entity: GroupScopedJs<DecryptedContactJs>):
				Promise<GroupScopedJs<DecryptedContactJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedContact> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.inGroup.modifyContact(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun modifyContacts(entities: Array<GroupScopedJs<DecryptedContactJs>>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedContact>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedContactJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedContactJs ->
							contact_fromJs(x2)
						},
					)
				},
			)
			val result = contactApi.inGroup.modifyContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun getContact(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedContactJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = contactApi.inGroup.getContact(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedContact ->
							contact_toJs(x1)
						},
					)
				}
			)
		}

		override fun getContacts(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedContactJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.inGroup.getContacts(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedContact> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedContact ->
							contact_toJs(x2)
						},
					)
				},
			)
		}

		override fun getService(groupId: String, serviceId: String):
				Promise<GroupScopedJs<DecryptedServiceJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val serviceIdConverted: String = serviceId
			val result = contactApi.inGroup.getService(
				groupIdConverted,
				serviceIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedService ->
							service_toJs(x1)
						},
					)
				}
			)
		}

		override fun getServices(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedServiceJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.inGroup.getServices(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedService> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedService ->
							service_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchContactsBy(filter: FilterOptionsJs<ContactJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
		val result = contactApi.matchContactsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBy(filter: FilterOptionsJs<ServiceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
		val result = contactApi.matchServicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.matchContactsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.matchServicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedContactJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedContact? = base?.let { nonNull1 ->
				contact_fromJs(nonNull1)
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
			val result = contactApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			contact_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(contact: ContactJs): Promise<Array<String>> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.getEncryptionKeysOf(
			contactConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(contact: ContactJs): Promise<Boolean> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.hasWriteAccess(
			contactConverted,
		)
		result
	}

	override fun decryptPatientIdOf(contact: ContactJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.decryptPatientIdOf(
			contactConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ContactJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Contact = contact_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		contactApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(contact: EncryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: EncryptedContact = contact_fromJs(contact)
		val result = contactApi.decrypt(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun tryDecrypt(contact: EncryptedContactJs): Promise<ContactJs> = GlobalScope.promise {
		val contactConverted: EncryptedContact = contact_fromJs(contact)
		val result = contactApi.tryDecrypt(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun decryptService(service: EncryptedServiceJs): Promise<DecryptedServiceJs> =
			GlobalScope.promise {
		val serviceConverted: EncryptedService = service_fromJs(service)
		val result = contactApi.decryptService(
			serviceConverted,
		)
		service_toJs(result)
	}

	override fun tryDecryptService(service: EncryptedServiceJs): Promise<ServiceJs> =
			GlobalScope.promise {
		val serviceConverted: EncryptedService = service_fromJs(service)
		val result = contactApi.tryDecryptService(
			serviceConverted,
		)
		service_toJs(result)
	}

	override fun subscribeToServiceCreateOrUpdateEvents(filter: FilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
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
			val result = contactApi.subscribeToServiceCreateOrUpdateEvents(
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
		val result = contactApi.deleteContactById(
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
		val result = contactApi.deleteContactsByIds(
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
		contactApi.purgeContactById(
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
		val result = contactApi.purgeContactsByIds(
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
		val result = contactApi.deleteContact(
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
		val result = contactApi.deleteContacts(
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
		contactApi.purgeContact(
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
		val result = contactApi.purgeContacts(
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
		val result = contactApi.getServiceCodesOccurrences(
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

	override fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		options: dynamic,
	): Promise<DecryptedContactJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val contactConverted: DecryptedContact = contact_fromJs(contact)
			val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: ContactShareOptionsJs? ->
				options?.let { nonNull1 ->
					contactShareOptions_fromJs(nonNull1)
				}
			}
			val result = contactApi.shareWith(
				delegateIdConverted,
				contactConverted,
				optionsConverted,
			)
			contact_toJs(result)
		}
	}

	override fun shareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: DecryptedContact = contact_fromJs(contact)
		val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ContactShareOptionsJs ->
				contactShareOptions_fromJs(x1)
			},
		)
		val result = contactApi.shareWithMany(
			contactConverted,
			delegatesConverted,
		)
		contact_toJs(result)
	}

	override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
		val result = contactApi.filterContactsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
		val result = contactApi.filterServicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.filterContactsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.filterServicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedContact = contact_fromJs(entity)
		val result = contactApi.createContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun createContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.createContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun undeleteContactById(id: String, rev: String): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = contactApi.undeleteContactById(
			idConverted,
			revConverted,
		)
		contact_toJs(result)
	}

	override fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = contactApi.undeleteContactsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun undeleteContact(contact: ContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.undeleteContact(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		val contactsConverted: List<Contact> = arrayToList(
			contacts,
			"contacts",
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.undeleteContacts(
			contactsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun modifyContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedContact = contact_fromJs(entity)
		val result = contactApi.modifyContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun modifyContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.modifyContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getContact(entityId: String): Promise<DecryptedContactJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactApi.getContact(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				contact_toJs(nonNull1)
			}
		)
	}

	override fun getContacts(entityIds: Array<String>): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.getContacts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getService(serviceId: String): Promise<DecryptedServiceJs?> = GlobalScope.promise {
		val serviceIdConverted: String = serviceId
		val result = contactApi.getService(
			serviceIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				service_toJs(nonNull1)
			}
		)
	}

	override fun getServices(entityIds: Array<String>): Promise<Array<DecryptedServiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.getServices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<ContactJs>,
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
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
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
			val result = contactApi.subscribeToEvents(
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
