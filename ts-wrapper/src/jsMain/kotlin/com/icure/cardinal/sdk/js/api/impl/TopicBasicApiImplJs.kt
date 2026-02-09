// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.TopicBasicApiJs
import com.icure.cardinal.sdk.js.api.TopicBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.topic_fromJs
import com.icure.cardinal.sdk.js.model.topic_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
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
internal class TopicBasicApiImplJs(
	private val topicBasicApi: TopicBasicApi,
) : TopicBasicApiJs {
	override val inGroup: TopicBasicInGroupApiJs = object : TopicBasicInGroupApiJs {
		override fun matchTopicsBy(groupId: String, filter: BaseFilterOptionsJs<TopicJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
			val result = topicBasicApi.inGroup.matchTopicsBy(
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

		override fun matchTopicsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<TopicJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
			val result = topicBasicApi.inGroup.matchTopicsBySorted(
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

		override fun filterTopicsBy(groupId: String, filter: BaseFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
			val result = topicBasicApi.inGroup.filterTopicsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterTopicsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
			val result = topicBasicApi.inGroup.filterTopicsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.deleteTopicById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = topicBasicApi.inGroup.deleteTopicsByIds(
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

		override fun purgeTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			topicBasicApi.inGroup.purgeTopicById(
				entityIdConverted,
			)

		}

		override fun purgeTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = topicBasicApi.inGroup.purgeTopicsByIds(
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

		override fun deleteTopic(topic: GroupScopedJs<TopicJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.deleteTopic(
				topicConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteTopics(topics: Array<GroupScopedJs<TopicJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val topicsConverted: List<GroupScoped<Topic>> = arrayToList(
				topics,
				"topics",
				{ x1: GroupScopedJs<TopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: TopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicBasicApi.inGroup.deleteTopics(
				topicsConverted,
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

		override fun purgeTopic(topic: GroupScopedJs<TopicJs>): Promise<Unit> = GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			topicBasicApi.inGroup.purgeTopic(
				topicConverted,
			)

		}

		override fun purgeTopics(topics: Array<GroupScopedJs<TopicJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val topicsConverted: List<GroupScoped<Topic>> = arrayToList(
				topics,
				"topics",
				{ x1: GroupScopedJs<TopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: TopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicBasicApi.inGroup.purgeTopics(
				topicsConverted,
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

		override fun createTopic(entity: GroupScopedJs<EncryptedTopicJs>):
				Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedTopic> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedTopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.createTopic(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun createTopics(entities: Array<GroupScopedJs<EncryptedTopicJs>>):
				Promise<Array<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedTopic>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicBasicApi.inGroup.createTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.undeleteTopicById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
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
			val result = topicBasicApi.inGroup.undeleteTopicsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteTopic(topic: GroupScopedJs<TopicJs>):
				Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.undeleteTopic(
				topicConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopics(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
				Promise<Array<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val topicsConverted: List<GroupScoped<EncryptedTopic>> = arrayToList(
				topics,
				"topics",
				{ x1: GroupScopedJs<EncryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicBasicApi.inGroup.undeleteTopics(
				topicsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyTopic(entity: GroupScopedJs<EncryptedTopicJs>):
				Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedTopic> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedTopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicBasicApi.inGroup.modifyTopic(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun modifyTopics(entities: Array<GroupScopedJs<EncryptedTopicJs>>):
				Promise<Array<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedTopic>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicBasicApi.inGroup.modifyTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun getTopic(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedTopicJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = topicBasicApi.inGroup.getTopic(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedTopic ->
							topic_toJs(x1)
						},
					)
				}
			)
		}

		override fun getTopics(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = topicBasicApi.inGroup.getTopics(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchTopicsBy(filter: BaseFilterOptionsJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
		val result = topicBasicApi.matchTopicsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
		val result = topicBasicApi.matchTopicsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterTopicsBy(filter: BaseFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
		val result = topicBasicApi.filterTopicsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Topic> = baseSortableFilterOptions_fromJs(filter)
		val result = topicBasicApi.filterTopicsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun deleteTopicById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = topicBasicApi.deleteTopicById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = topicBasicApi.deleteTopicsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTopicById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		topicBasicApi.purgeTopicById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = topicBasicApi.purgeTopicsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteTopic(topic: TopicJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicBasicApi.deleteTopic(
			topicConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteTopics(topics: Array<TopicJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val topicsConverted: List<Topic> = arrayToList(
			topics,
			"topics",
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.deleteTopics(
			topicsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTopic(topic: TopicJs): Promise<Unit> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		topicBasicApi.purgeTopic(
			topicConverted,
		)

	}

	override fun purgeTopics(topics: Array<TopicJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val topicsConverted: List<Topic> = arrayToList(
			topics,
			"topics",
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.purgeTopics(
			topicsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun createTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTopic = topic_fromJs(entity)
		val result = topicBasicApi.createTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun createTopics(entities: Array<EncryptedTopicJs>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<EncryptedTopic> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedTopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.createTopics(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun undeleteTopicById(id: String, rev: String): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = topicBasicApi.undeleteTopicById(
			idConverted,
			revConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedTopicJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = topicBasicApi.undeleteTopicsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun undeleteTopic(topic: TopicJs): Promise<EncryptedTopicJs> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicBasicApi.undeleteTopic(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		val topicsConverted: List<Topic> = arrayToList(
			topics,
			"topics",
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.undeleteTopics(
			topicsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTopic = topic_fromJs(entity)
		val result = topicBasicApi.modifyTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun modifyTopics(entities: Array<EncryptedTopicJs>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<EncryptedTopic> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedTopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicBasicApi.modifyTopics(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun getTopic(entityId: String): Promise<EncryptedTopicJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicBasicApi.getTopic(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				topic_toJs(nonNull1)
			}
		)
	}

	override fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicBasicApi.getTopics(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
		val result = topicBasicApi.addParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
			topicRoleConverted,
		)
		topic_toJs(result)
	}

	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val result = topicBasicApi.removeParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
		)
		topic_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<TopicJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedTopicJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Topic> = baseFilterOptions_fromJs(filter)
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
			val result = topicBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}
	}
}
