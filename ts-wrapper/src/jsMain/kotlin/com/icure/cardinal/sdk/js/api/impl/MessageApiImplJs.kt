// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MessageApiJs
import com.icure.cardinal.sdk.js.api.MessageFlavouredApiJs
import com.icure.cardinal.sdk.js.api.MessageFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.MessageInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.messageShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedMessageJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.message_toJs
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
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Message
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
internal class MessageApiImplJs(
	private val messageApi: MessageApi,
) : MessageApiJs {
	override val encrypted: MessageFlavouredApiJs<EncryptedMessageJs> = object :
			MessageFlavouredApiJs<EncryptedMessageJs> {
		override fun shareWith(
			delegateId: String,
			message: EncryptedMessageJs,
			options: dynamic,
		): Promise<EncryptedMessageJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: EncryptedMessage = message_fromJs(message)
				val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MessageShareOptionsJs? ->
					options?.let { nonNull1 ->
						messageShareOptions_fromJs(nonNull1)
					}
				}
				val result = messageApi.encrypted.shareWith(
					delegateIdConverted,
					messageConverted,
					optionsConverted,
				)
				message_toJs(result)
			}
		}

		override fun shareWithMany(message: EncryptedMessageJs,
				delegates: Record<String, MessageShareOptionsJs>): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val messageConverted: EncryptedMessage = message_fromJs(message)
			val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MessageShareOptionsJs ->
					messageShareOptions_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.shareWithMany(
				messageConverted,
				delegatesConverted,
			)
			message_toJs(result)
		}

		override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.encrypted.filterMessagesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.encrypted.filterMessagesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.createMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun createMessages(entities: Array<EncryptedMessageJs>):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedMessage> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.createMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessageInTopic(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.createMessageInTopic(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessageById(id: String, rev: String): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = messageApi.encrypted.undeleteMessageById(
				idConverted,
				revConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.undeleteMessagesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun undeleteMessage(message: MessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val result = messageApi.encrypted.undeleteMessage(
				messageConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			val messagesConverted: List<Message> = arrayToList(
				messages,
				"messages",
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.undeleteMessages(
				messagesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun modifyMessages(entities: Array<EncryptedMessageJs>):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedMessage> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.modifyMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun getMessage(entityId: String): Promise<EncryptedMessageJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.encrypted.getMessage(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					message_toJs(nonNull1)
				}
			)
		}

		override fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.getMessages(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesReadStatus(
			entityIds: Array<String>,
			time: Double?,
			readStatus: Boolean,
			userId: String?,
		): Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val timeConverted: Long? = numberToLong(time, "time")
			val readStatusConverted: Boolean = readStatus
			val userIdConverted: String? = undefinedToNull(userId)
			val result = messageApi.encrypted.setMessagesReadStatus(
				entityIdsConverted,
				timeConverted,
				readStatusConverted,
				userIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: MessageFlavouredApiJs<MessageJs> = object :
			MessageFlavouredApiJs<MessageJs> {
		override fun shareWith(
			delegateId: String,
			message: MessageJs,
			options: dynamic,
		): Promise<MessageJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: Message = message_fromJs(message)
				val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MessageShareOptionsJs? ->
					options?.let { nonNull1 ->
						messageShareOptions_fromJs(nonNull1)
					}
				}
				val result = messageApi.tryAndRecover.shareWith(
					delegateIdConverted,
					messageConverted,
					optionsConverted,
				)
				message_toJs(result)
			}
		}

		override fun shareWithMany(message: MessageJs, delegates: Record<String, MessageShareOptionsJs>):
				Promise<MessageJs> = GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MessageShareOptionsJs ->
					messageShareOptions_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.shareWithMany(
				messageConverted,
				delegatesConverted,
			)
			message_toJs(result)
		}

		override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<MessageJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.tryAndRecover.filterMessagesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<MessageJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.tryAndRecover.filterMessagesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.createMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun createMessages(entities: Array<MessageJs>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Message> = arrayToList(
				entities,
				"entities",
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.createMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessageInTopic(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.createMessageInTopic(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessageById(id: String, rev: String): Promise<MessageJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = messageApi.tryAndRecover.undeleteMessageById(
				idConverted,
				revConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.undeleteMessagesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun undeleteMessage(message: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val result = messageApi.tryAndRecover.undeleteMessage(
				messageConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val messagesConverted: List<Message> = arrayToList(
				messages,
				"messages",
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.undeleteMessages(
				messagesConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun modifyMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun modifyMessages(entities: Array<MessageJs>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Message> = arrayToList(
				entities,
				"entities",
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.modifyMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun getMessage(entityId: String): Promise<MessageJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.tryAndRecover.getMessage(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					message_toJs(nonNull1)
				}
			)
		}

		override fun getMessages(entityIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.getMessages(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesReadStatus(
			entityIds: Array<String>,
			time: Double?,
			readStatus: Boolean,
			userId: String?,
		): Promise<Array<MessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val timeConverted: Long? = numberToLong(time, "time")
			val readStatusConverted: Boolean = readStatus
			val userIdConverted: String? = undefinedToNull(userId)
			val result = messageApi.tryAndRecover.setMessagesReadStatus(
				entityIdsConverted,
				timeConverted,
				readStatusConverted,
				userIdConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}
	}

	override val inGroup: MessageInGroupApiJs = object : MessageInGroupApiJs {
		override val encrypted: MessageFlavouredInGroupApiJs<EncryptedMessageJs> = object :
				MessageFlavouredInGroupApiJs<EncryptedMessageJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				message: GroupScopedJs<EncryptedMessageJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedMessageJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val messageConverted: GroupScoped<EncryptedMessage> = groupScoped_fromJs(
						message,
						{ x1: EncryptedMessageJs ->
							message_fromJs(x1)
						},
					)
					val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: MessageShareOptionsJs? ->
						options?.let { nonNull1 ->
							messageShareOptions_fromJs(nonNull1)
						}
					}
					val result = messageApi.inGroup.encrypted.shareWith(
						delegateConverted,
						messageConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedMessage ->
							message_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(message: GroupScopedJs<EncryptedMessageJs>,
					delegates: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
				val messageConverted: GroupScoped<EncryptedMessage> = groupScoped_fromJs(
					message,
					{ x1: EncryptedMessageJs ->
						message_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, MessageShareOptions> =
						EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = messageApi.inGroup.encrypted.shareWithMany(
					messageConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}

			override fun filterMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
				val result = messageApi.inGroup.encrypted.filterMessagesBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
				val result = messageApi.inGroup.encrypted.filterMessagesBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun createMessage(entity: GroupScopedJs<EncryptedMessageJs>):
					Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedMessage> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedMessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.encrypted.createMessage(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}

			override fun createMessages(entities: Array<GroupScopedJs<EncryptedMessageJs>>):
					Promise<Array<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedMessage>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedMessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedMessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.encrypted.createMessages(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.encrypted.undeleteMessageById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}

			override fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
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
				val result = messageApi.inGroup.encrypted.undeleteMessagesByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteMessage(message: GroupScopedJs<MessageJs>):
					Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
				val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
					message,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.encrypted.undeleteMessage(
					messageConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}

			override fun undeleteMessages(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
					Promise<Array<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val messagesConverted: List<GroupScoped<EncryptedMessage>> = arrayToList(
					messages,
					"messages",
					{ x1: GroupScopedJs<EncryptedMessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedMessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.encrypted.undeleteMessages(
					messagesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyMessage(entity: GroupScopedJs<EncryptedMessageJs>):
					Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedMessage> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedMessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.encrypted.modifyMessage(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}

			override fun modifyMessages(entities: Array<GroupScopedJs<EncryptedMessageJs>>):
					Promise<Array<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedMessage>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedMessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedMessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.encrypted.modifyMessages(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun getMessage(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedMessageJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = messageApi.inGroup.encrypted.getMessage(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedMessage ->
								message_toJs(x1)
							},
						)
					}
				)
			}

			override fun getMessages(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = messageApi.inGroup.encrypted.getMessages(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedMessage> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedMessage ->
								message_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: MessageFlavouredInGroupApiJs<MessageJs> = object :
				MessageFlavouredInGroupApiJs<MessageJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				message: GroupScopedJs<MessageJs>,
				options: dynamic,
			): Promise<GroupScopedJs<MessageJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
						message,
						{ x1: MessageJs ->
							message_fromJs(x1)
						},
					)
					val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: MessageShareOptionsJs? ->
						options?.let { nonNull1 ->
							messageShareOptions_fromJs(nonNull1)
						}
					}
					val result = messageApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						messageConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Message ->
							message_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(message: GroupScopedJs<MessageJs>,
					delegates: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<MessageJs>> = GlobalScope.promise {
				val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
					message,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, MessageShareOptions> =
						EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = messageApi.inGroup.tryAndRecover.shareWithMany(
					messageConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}

			override fun filterMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
				val result = messageApi.inGroup.tryAndRecover.filterMessagesBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
				val result = messageApi.inGroup.tryAndRecover.filterMessagesBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun createMessage(entity: GroupScopedJs<MessageJs>): Promise<GroupScopedJs<MessageJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Message> = groupScoped_fromJs(
					entity,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.createMessage(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}

			override fun createMessages(entities: Array<GroupScopedJs<MessageJs>>):
					Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Message>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<MessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: MessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.createMessages(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<MessageJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.undeleteMessageById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}

			override fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
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
				val result = messageApi.inGroup.tryAndRecover.undeleteMessagesByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteMessage(message: GroupScopedJs<MessageJs>):
					Promise<GroupScopedJs<MessageJs>> = GlobalScope.promise {
				val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
					message,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.undeleteMessage(
					messageConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}

			override fun undeleteMessages(messages: Array<GroupScopedJs<MessageJs>>):
					Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val messagesConverted: List<GroupScoped<Message>> = arrayToList(
					messages,
					"messages",
					{ x1: GroupScopedJs<MessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: MessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.undeleteMessages(
					messagesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyMessage(entity: GroupScopedJs<MessageJs>): Promise<GroupScopedJs<MessageJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Message> = groupScoped_fromJs(
					entity,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.modifyMessage(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}

			override fun modifyMessages(entities: Array<GroupScopedJs<MessageJs>>):
					Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Message>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<MessageJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: MessageJs ->
								message_fromJs(x2)
							},
						)
					},
				)
				val result = messageApi.inGroup.tryAndRecover.modifyMessages(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}

			override fun getMessage(groupId: String, entityId: String): Promise<GroupScopedJs<MessageJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = messageApi.inGroup.tryAndRecover.getMessage(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Message ->
								message_toJs(x1)
							},
						)
					}
				)
			}

			override fun getMessages(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = messageApi.inGroup.tryAndRecover.getMessages(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Message> ->
						groupScoped_toJs(
							x1,
							{ x2: Message ->
								message_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedMessageJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedMessage? = base?.let { nonNull1 ->
					message_fromJs(nonNull1)
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
				val result = messageApi.inGroup.withEncryptionMetadata(
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
					{ x1: DecryptedMessage ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(message: GroupScopedJs<MessageJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.getEncryptionKeysOf(
				messageConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(message: GroupScopedJs<MessageJs>): Promise<Boolean> =
				GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.hasWriteAccess(
				messageConverted,
			)
			result
		}

		override fun decryptPatientIdOf(message: GroupScopedJs<MessageJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.decryptPatientIdOf(
				messageConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<MessageJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Message> = groupScoped_fromJs(
				entity,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			messageApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val messagesConverted: List<GroupScoped<EncryptedMessage>> = arrayToList(
				messages,
				"messages",
				{ x1: GroupScopedJs<EncryptedMessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedMessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.decrypt(
				messagesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
				Promise<Array<GroupScopedJs<MessageJs>>> = GlobalScope.promise {
			val messagesConverted: List<GroupScoped<EncryptedMessage>> = arrayToList(
				messages,
				"messages",
				{ x1: GroupScopedJs<EncryptedMessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedMessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.tryDecrypt(
				messagesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Message> ->
					groupScoped_toJs(
						x1,
						{ x2: Message ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.inGroup.matchMessagesBy(
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

		override fun matchMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.inGroup.matchMessagesBySorted(
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

		override fun deleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.deleteMessageById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = messageApi.inGroup.deleteMessagesByIds(
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

		override fun purgeMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			messageApi.inGroup.purgeMessageById(
				entityIdConverted,
			)

		}

		override fun purgeMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = messageApi.inGroup.purgeMessagesByIds(
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

		override fun deleteMessage(message: GroupScopedJs<MessageJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.deleteMessage(
				messageConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteMessages(messages: Array<GroupScopedJs<MessageJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val messagesConverted: List<GroupScoped<Message>> = arrayToList(
				messages,
				"messages",
				{ x1: GroupScopedJs<MessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: MessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.deleteMessages(
				messagesConverted,
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

		override fun purgeMessage(message: GroupScopedJs<MessageJs>): Promise<Unit> =
				GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			messageApi.inGroup.purgeMessage(
				messageConverted,
			)

		}

		override fun purgeMessages(messages: Array<GroupScopedJs<MessageJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val messagesConverted: List<GroupScoped<Message>> = arrayToList(
				messages,
				"messages",
				{ x1: GroupScopedJs<MessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: MessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.purgeMessages(
				messagesConverted,
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
			message: GroupScopedJs<DecryptedMessageJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val messageConverted: GroupScoped<DecryptedMessage> = groupScoped_fromJs(
					message,
					{ x1: DecryptedMessageJs ->
						message_fromJs(x1)
					},
				)
				val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MessageShareOptionsJs? ->
					options?.let { nonNull1 ->
						messageShareOptions_fromJs(nonNull1)
					}
				}
				val result = messageApi.inGroup.shareWith(
					delegateConverted,
					messageConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedMessage ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(message: GroupScopedJs<DecryptedMessageJs>,
				delegates: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedMessageJs>> = GlobalScope.promise {
			val messageConverted: GroupScoped<DecryptedMessage> = groupScoped_fromJs(
				message,
				{ x1: DecryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, MessageShareOptions> =
					EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = messageApi.inGroup.shareWithMany(
				messageConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun filterMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.inGroup.filterMessagesBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.inGroup.filterMessagesBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun createMessage(entity: GroupScopedJs<DecryptedMessageJs>):
				Promise<GroupScopedJs<DecryptedMessageJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedMessage> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.createMessage(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessages(entities: Array<GroupScopedJs<DecryptedMessageJs>>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedMessage>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedMessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedMessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.createMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedMessageJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.undeleteMessageById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
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
			val result = messageApi.inGroup.undeleteMessagesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteMessage(message: GroupScopedJs<MessageJs>):
				Promise<GroupScopedJs<DecryptedMessageJs>> = GlobalScope.promise {
			val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
				message,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.undeleteMessage(
				messageConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun undeleteMessages(messages: Array<GroupScopedJs<DecryptedMessageJs>>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val messagesConverted: List<GroupScoped<DecryptedMessage>> = arrayToList(
				messages,
				"messages",
				{ x1: GroupScopedJs<DecryptedMessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedMessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.undeleteMessages(
				messagesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyMessage(entity: GroupScopedJs<DecryptedMessageJs>):
				Promise<GroupScopedJs<DecryptedMessageJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedMessage> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageApi.inGroup.modifyMessage(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun modifyMessages(entities: Array<GroupScopedJs<DecryptedMessageJs>>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedMessage>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedMessageJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedMessageJs ->
							message_fromJs(x2)
						},
					)
				},
			)
			val result = messageApi.inGroup.modifyMessages(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}

		override fun getMessage(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedMessageJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = messageApi.inGroup.getMessage(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedMessage ->
							message_toJs(x1)
						},
					)
				}
			)
		}

		override fun getMessages(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedMessageJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.inGroup.getMessages(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedMessage> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedMessage ->
							message_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedMessageJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedMessage? = base?.let { nonNull1 ->
				message_fromJs(nonNull1)
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
			val result = messageApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			message_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(message: MessageJs): Promise<Array<String>> =
			GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.getEncryptionKeysOf(
			messageConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(message: MessageJs): Promise<Boolean> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.hasWriteAccess(
			messageConverted,
		)
		result
	}

	override fun decryptPatientIdOf(message: MessageJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.decryptPatientIdOf(
			messageConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: MessageJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Message = message_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		messageApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(message: EncryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val messageConverted: EncryptedMessage = message_fromJs(message)
		val result = messageApi.decrypt(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun tryDecrypt(message: EncryptedMessageJs): Promise<MessageJs> = GlobalScope.promise {
		val messageConverted: EncryptedMessage = message_fromJs(message)
		val result = messageApi.tryDecrypt(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun encryptOrValidate(messages: Array<MessageJs>): Promise<Array<EncryptedMessageJs>> =
			GlobalScope.promise {
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.encryptOrValidate(
			messagesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun getSecretIdsOf(message: MessageJs):
			Promise<Record<String, Array<EntityReferenceInGroupJs>>> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.getSecretIdsOf(
			messageConverted,
		)
		mapToObject(
			result,
			{ x1: String ->
				x1
			},
			{ x1: Set<EntityReferenceInGroup> ->
				setToArray(
					x1,
					{ x2: EntityReferenceInGroup ->
						entityReferenceInGroup_toJs(x2)
					},
				)
			},
		)
	}

	override fun matchMessagesBy(filter: FilterOptionsJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
		val result = messageApi.matchMessagesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
		val result = messageApi.matchMessagesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteMessageById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = messageApi.deleteMessageById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = messageApi.deleteMessagesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMessageById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		messageApi.purgeMessageById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = messageApi.purgeMessagesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteMessage(message: MessageJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.deleteMessage(
			messageConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteMessages(messages: Array<MessageJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.deleteMessages(
			messagesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMessage(message: MessageJs): Promise<Unit> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		messageApi.purgeMessage(
			messageConverted,
		)

	}

	override fun purgeMessages(messages: Array<MessageJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.purgeMessages(
			messagesConverted,
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
		message: DecryptedMessageJs,
		options: dynamic,
	): Promise<DecryptedMessageJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val messageConverted: DecryptedMessage = message_fromJs(message)
			val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: MessageShareOptionsJs? ->
				options?.let { nonNull1 ->
					messageShareOptions_fromJs(nonNull1)
				}
			}
			val result = messageApi.shareWith(
				delegateIdConverted,
				messageConverted,
				optionsConverted,
			)
			message_toJs(result)
		}
	}

	override fun shareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val messageConverted: DecryptedMessage = message_fromJs(message)
		val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: MessageShareOptionsJs ->
				messageShareOptions_fromJs(x1)
			},
		)
		val result = messageApi.shareWithMany(
			messageConverted,
			delegatesConverted,
		)
		message_toJs(result)
	}

	override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
		val result = messageApi.filterMessagesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
		val result = messageApi.filterMessagesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun createMessages(entities: Array<DecryptedMessageJs>):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedMessage> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedMessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.createMessages(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessageInTopic(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessageById(id: String, rev: String): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = messageApi.undeleteMessageById(
			idConverted,
			revConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = messageApi.undeleteMessagesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun undeleteMessage(message: MessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.undeleteMessage(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<DecryptedMessageJs>> =
			GlobalScope.promise {
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.undeleteMessages(
			messagesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun modifyMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.modifyMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun modifyMessages(entities: Array<DecryptedMessageJs>):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedMessage> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedMessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.modifyMessages(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun getMessage(entityId: String): Promise<DecryptedMessageJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageApi.getMessage(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				message_toJs(nonNull1)
			}
		)
	}

	override fun getMessages(entityIds: Array<String>): Promise<Array<DecryptedMessageJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.getMessages(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val timeConverted: Long? = numberToLong(time, "time")
		val readStatusConverted: Boolean = readStatus
		val userIdConverted: String? = undefinedToNull(userId)
		val result = messageApi.setMessagesReadStatus(
			entityIdsConverted,
			timeConverted,
			readStatusConverted,
			userIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MessageJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
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
			val result = messageApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}
}
