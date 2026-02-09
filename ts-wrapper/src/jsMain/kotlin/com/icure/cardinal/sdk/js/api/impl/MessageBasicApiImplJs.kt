// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MessageBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MessageBasicApiJs
import com.icure.cardinal.sdk.js.api.MessageBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.message_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
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
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class MessageBasicApiImplJs(
	private val messageBasicApi: MessageBasicApi,
) : MessageBasicApiJs {
	override val inGroup: MessageBasicInGroupApiJs = object : MessageBasicInGroupApiJs {
		override fun matchMessagesBy(groupId: String, filter: BaseFilterOptionsJs<MessageJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
			val result = messageBasicApi.inGroup.matchMessagesBy(
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

		override fun matchMessagesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<MessageJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Message> =
					baseSortableFilterOptions_fromJs(filter)
			val result = messageBasicApi.inGroup.matchMessagesBySorted(
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

		override fun filterMessagesBy(groupId: String, filter: BaseFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
			val result = messageBasicApi.inGroup.filterMessagesBy(
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

		override fun filterMessagesBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Message> =
					baseSortableFilterOptions_fromJs(filter)
			val result = messageBasicApi.inGroup.filterMessagesBySorted(
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

		override fun deleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = messageBasicApi.inGroup.deleteMessageById(
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
			val result = messageBasicApi.inGroup.deleteMessagesByIds(
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
			messageBasicApi.inGroup.purgeMessageById(
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
			val result = messageBasicApi.inGroup.purgeMessagesByIds(
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
			val result = messageBasicApi.inGroup.deleteMessage(
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
			val result = messageBasicApi.inGroup.deleteMessages(
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
			messageBasicApi.inGroup.purgeMessage(
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
			val result = messageBasicApi.inGroup.purgeMessages(
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

		override fun createMessage(entity: GroupScopedJs<EncryptedMessageJs>):
				Promise<GroupScopedJs<EncryptedMessageJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedMessage> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedMessageJs ->
					message_fromJs(x1)
				},
			)
			val result = messageBasicApi.inGroup.createMessage(
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
			val result = messageBasicApi.inGroup.createMessages(
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
			val result = messageBasicApi.inGroup.undeleteMessageById(
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
			val result = messageBasicApi.inGroup.undeleteMessagesByIds(
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
			val result = messageBasicApi.inGroup.undeleteMessage(
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
			val result = messageBasicApi.inGroup.undeleteMessages(
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
			val result = messageBasicApi.inGroup.modifyMessage(
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
			val result = messageBasicApi.inGroup.modifyMessages(
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
			val result = messageBasicApi.inGroup.getMessage(
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
			val result = messageBasicApi.inGroup.getMessages(
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

	override fun matchMessagesBy(filter: BaseFilterOptionsJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
		val result = messageBasicApi.matchMessagesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Message> = baseSortableFilterOptions_fromJs(filter)
		val result = messageBasicApi.matchMessagesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterMessagesBy(filter: BaseFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
		val result = messageBasicApi.filterMessagesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun filterMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Message> = baseSortableFilterOptions_fromJs(filter)
		val result = messageBasicApi.filterMessagesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun deleteMessageById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = messageBasicApi.deleteMessageById(
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
		val result = messageBasicApi.deleteMessagesByIds(
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
		messageBasicApi.purgeMessageById(
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
		val result = messageBasicApi.purgeMessagesByIds(
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
		val result = messageBasicApi.deleteMessage(
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
		val result = messageBasicApi.deleteMessages(
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
		messageBasicApi.purgeMessage(
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
		val result = messageBasicApi.purgeMessages(
			messagesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun createMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedMessage = message_fromJs(entity)
		val result = messageBasicApi.createMessage(
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
		val result = messageBasicApi.createMessages(
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
		val result = messageBasicApi.createMessageInTopic(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessageById(id: String, rev: String): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = messageBasicApi.undeleteMessageById(
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
		val result = messageBasicApi.undeleteMessagesByIds(
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
		val result = messageBasicApi.undeleteMessage(
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
		val result = messageBasicApi.undeleteMessages(
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
		val result = messageBasicApi.modifyMessage(
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
		val result = messageBasicApi.modifyMessages(
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
		val result = messageBasicApi.getMessage(
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
		val result = messageBasicApi.getMessages(
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
		val result = messageBasicApi.setMessagesReadStatus(
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MessageJs>,
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
			val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
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
			val result = messageBasicApi.subscribeToEvents(
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
