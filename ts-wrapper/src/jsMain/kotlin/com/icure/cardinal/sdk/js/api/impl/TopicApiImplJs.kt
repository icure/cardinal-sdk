// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.TopicApiJs
import com.icure.cardinal.sdk.js.api.TopicFlavouredApiJs
import com.icure.cardinal.sdk.js.api.TopicFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.TopicInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.topicShareOptions_fromJs
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
import com.icure.cardinal.sdk.js.model.DecryptedTopicJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.topic_fromJs
import com.icure.cardinal.sdk.js.model.topic_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.TopicRole
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
internal class TopicApiImplJs(
	private val topicApi: TopicApi,
) : TopicApiJs {
	override val encrypted: TopicFlavouredApiJs<EncryptedTopicJs> = object :
			TopicFlavouredApiJs<EncryptedTopicJs> {
		override fun shareWith(
			delegateId: String,
			topic: EncryptedTopicJs,
			options: dynamic,
		): Promise<EncryptedTopicJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: EncryptedTopic = topic_fromJs(topic)
				val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TopicShareOptionsJs? ->
					options?.let { nonNull1 ->
						topicShareOptions_fromJs(nonNull1)
					}
				}
				val result = topicApi.encrypted.shareWith(
					delegateIdConverted,
					topicConverted,
					optionsConverted,
				)
				topic_toJs(result)
			}
		}

		override fun shareWithMany(topic: EncryptedTopicJs,
				delegates: Record<String, TopicShareOptionsJs>): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			val topicConverted: EncryptedTopic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.encrypted.shareWithMany(
				topicConverted,
				delegatesConverted,
			)
			topic_toJs(result)
		}

		override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.encrypted.filterTopicsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<EncryptedTopicJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.encrypted.filterTopicsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun createTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedTopic = topic_fromJs(entity)
			val result = topicApi.encrypted.createTopic(
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
			val result = topicApi.encrypted.createTopics(
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
			val result = topicApi.encrypted.undeleteTopicById(
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
			val result = topicApi.encrypted.undeleteTopicsByIds(
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
			val result = topicApi.encrypted.undeleteTopic(
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
			val result = topicApi.encrypted.undeleteTopics(
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
			val result = topicApi.encrypted.modifyTopic(
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
			val result = topicApi.encrypted.modifyTopics(
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
			val result = topicApi.encrypted.getTopic(
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
			val result = topicApi.encrypted.getTopics(
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
			val result = topicApi.encrypted.addParticipant(
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
			val result = topicApi.encrypted.removeParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
			)
			topic_toJs(result)
		}
	}

	override val tryAndRecover: TopicFlavouredApiJs<TopicJs> = object : TopicFlavouredApiJs<TopicJs> {
		override fun shareWith(
			delegateId: String,
			topic: TopicJs,
			options: dynamic,
		): Promise<TopicJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val topicConverted: Topic = topic_fromJs(topic)
				val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TopicShareOptionsJs? ->
					options?.let { nonNull1 ->
						topicShareOptions_fromJs(nonNull1)
					}
				}
				val result = topicApi.tryAndRecover.shareWith(
					delegateIdConverted,
					topicConverted,
					optionsConverted,
				)
				topic_toJs(result)
			}
		}

		override fun shareWithMany(topic: TopicJs, delegates: Record<String, TopicShareOptionsJs>):
				Promise<TopicJs> = GlobalScope.promise {
			val topicConverted: Topic = topic_fromJs(topic)
			val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TopicShareOptionsJs ->
					topicShareOptions_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.shareWithMany(
				topicConverted,
				delegatesConverted,
			)
			topic_toJs(result)
		}

		override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<TopicJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.tryAndRecover.filterTopicsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<TopicJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.tryAndRecover.filterTopicsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun createTopic(entity: TopicJs): Promise<TopicJs> = GlobalScope.promise {
			val entityConverted: Topic = topic_fromJs(entity)
			val result = topicApi.tryAndRecover.createTopic(
				entityConverted,
			)
			topic_toJs(result)
		}

		override fun createTopics(entities: Array<TopicJs>): Promise<Array<TopicJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Topic> = arrayToList(
				entities,
				"entities",
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.createTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopicById(id: String, rev: String): Promise<TopicJs> = GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = topicApi.tryAndRecover.undeleteTopicById(
				idConverted,
				revConverted,
			)
			topic_toJs(result)
		}

		override fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<TopicJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.undeleteTopicsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopic(topic: TopicJs): Promise<TopicJs> = GlobalScope.promise {
			val topicConverted: Topic = topic_fromJs(topic)
			val result = topicApi.tryAndRecover.undeleteTopic(
				topicConverted,
			)
			topic_toJs(result)
		}

		override fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<TopicJs>> =
				GlobalScope.promise {
			val topicsConverted: List<Topic> = arrayToList(
				topics,
				"topics",
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.undeleteTopics(
				topicsConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun modifyTopic(entity: TopicJs): Promise<TopicJs> = GlobalScope.promise {
			val entityConverted: Topic = topic_fromJs(entity)
			val result = topicApi.tryAndRecover.modifyTopic(
				entityConverted,
			)
			topic_toJs(result)
		}

		override fun modifyTopics(entities: Array<TopicJs>): Promise<Array<TopicJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Topic> = arrayToList(
				entities,
				"entities",
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.tryAndRecover.modifyTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun getTopic(entityId: String): Promise<TopicJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = topicApi.tryAndRecover.getTopic(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					topic_toJs(nonNull1)
				}
			)
		}

		override fun getTopics(entityIds: Array<String>): Promise<Array<TopicJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = topicApi.tryAndRecover.getTopics(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Topic ->
					topic_toJs(x1)
				},
			)
		}

		override fun addParticipant(
			entityId: String,
			dataOwnerId: String,
			topicRole: String,
		): Promise<TopicJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val dataOwnerIdConverted: String = dataOwnerId
			val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
			val result = topicApi.tryAndRecover.addParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
				topicRoleConverted,
			)
			topic_toJs(result)
		}

		override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<TopicJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val dataOwnerIdConverted: String = dataOwnerId
			val result = topicApi.tryAndRecover.removeParticipant(
				entityIdConverted,
				dataOwnerIdConverted,
			)
			topic_toJs(result)
		}
	}

	override val inGroup: TopicInGroupApiJs = object : TopicInGroupApiJs {
		override val encrypted: TopicFlavouredInGroupApiJs<EncryptedTopicJs> = object :
				TopicFlavouredInGroupApiJs<EncryptedTopicJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				topic: GroupScopedJs<EncryptedTopicJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedTopicJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val topicConverted: GroupScoped<EncryptedTopic> = groupScoped_fromJs(
						topic,
						{ x1: EncryptedTopicJs ->
							topic_fromJs(x1)
						},
					)
					val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: TopicShareOptionsJs? ->
						options?.let { nonNull1 ->
							topicShareOptions_fromJs(nonNull1)
						}
					}
					val result = topicApi.inGroup.encrypted.shareWith(
						delegateConverted,
						topicConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedTopic ->
							topic_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(topic: GroupScopedJs<EncryptedTopicJs>,
					delegates: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
				val topicConverted: GroupScoped<EncryptedTopic> = groupScoped_fromJs(
					topic,
					{ x1: EncryptedTopicJs ->
						topic_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, TopicShareOptions> =
						EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = topicApi.inGroup.encrypted.shareWithMany(
					topicConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedTopic ->
						topic_toJs(x1)
					},
				)
			}

			override fun filterTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
				val result = topicApi.inGroup.encrypted.filterTopicsBy(
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

			override fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
				val result = topicApi.inGroup.encrypted.filterTopicsBySorted(
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

			override fun createTopic(entity: GroupScopedJs<EncryptedTopicJs>):
					Promise<GroupScopedJs<EncryptedTopicJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedTopic> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedTopicJs ->
						topic_fromJs(x1)
					},
				)
				val result = topicApi.inGroup.encrypted.createTopic(
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
				val result = topicApi.inGroup.encrypted.createTopics(
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
				val result = topicApi.inGroup.encrypted.undeleteTopicById(
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
				val result = topicApi.inGroup.encrypted.undeleteTopicsByIds(
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
				val result = topicApi.inGroup.encrypted.undeleteTopic(
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
				val result = topicApi.inGroup.encrypted.undeleteTopics(
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
				val result = topicApi.inGroup.encrypted.modifyTopic(
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
				val result = topicApi.inGroup.encrypted.modifyTopics(
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
				val result = topicApi.inGroup.encrypted.getTopic(
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
				val result = topicApi.inGroup.encrypted.getTopics(
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

		override val tryAndRecover: TopicFlavouredInGroupApiJs<TopicJs> = object :
				TopicFlavouredInGroupApiJs<TopicJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				topic: GroupScopedJs<TopicJs>,
				options: dynamic,
			): Promise<GroupScopedJs<TopicJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
						topic,
						{ x1: TopicJs ->
							topic_fromJs(x1)
						},
					)
					val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: TopicShareOptionsJs? ->
						options?.let { nonNull1 ->
							topicShareOptions_fromJs(nonNull1)
						}
					}
					val result = topicApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						topicConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Topic ->
							topic_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(topic: GroupScopedJs<TopicJs>,
					delegates: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<TopicJs>> = GlobalScope.promise {
				val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
					topic,
					{ x1: TopicJs ->
						topic_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, TopicShareOptions> =
						EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = topicApi.inGroup.tryAndRecover.shareWithMany(
					topicConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}

			override fun filterTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
				val result = topicApi.inGroup.tryAndRecover.filterTopicsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
				val result = topicApi.inGroup.tryAndRecover.filterTopicsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun createTopic(entity: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<TopicJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Topic> = groupScoped_fromJs(
					entity,
					{ x1: TopicJs ->
						topic_fromJs(x1)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.createTopic(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}

			override fun createTopics(entities: Array<GroupScopedJs<TopicJs>>):
					Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Topic>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<TopicJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: TopicJs ->
								topic_fromJs(x2)
							},
						)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.createTopics(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<TopicJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.undeleteTopicById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}

			override fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
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
				val result = topicApi.inGroup.tryAndRecover.undeleteTopicsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteTopic(topic: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<TopicJs>> =
					GlobalScope.promise {
				val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
					topic,
					{ x1: TopicJs ->
						topic_fromJs(x1)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.undeleteTopic(
					topicConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}

			override fun undeleteTopics(topics: Array<GroupScopedJs<TopicJs>>):
					Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
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
				val result = topicApi.inGroup.tryAndRecover.undeleteTopics(
					topicsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyTopic(entity: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<TopicJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Topic> = groupScoped_fromJs(
					entity,
					{ x1: TopicJs ->
						topic_fromJs(x1)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.modifyTopic(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Topic ->
						topic_toJs(x1)
					},
				)
			}

			override fun modifyTopics(entities: Array<GroupScopedJs<TopicJs>>):
					Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Topic>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<TopicJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: TopicJs ->
								topic_fromJs(x2)
							},
						)
					},
				)
				val result = topicApi.inGroup.tryAndRecover.modifyTopics(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}

			override fun getTopic(groupId: String, entityId: String): Promise<GroupScopedJs<TopicJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = topicApi.inGroup.tryAndRecover.getTopic(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Topic ->
								topic_toJs(x1)
							},
						)
					}
				)
			}

			override fun getTopics(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = topicApi.inGroup.tryAndRecover.getTopics(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Topic> ->
						groupScoped_toJs(
							x1,
							{ x2: Topic ->
								topic_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			groupId: String,
			base: DecryptedTopicJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedTopicJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val baseConverted: DecryptedTopic? = base?.let { nonNull1 ->
					topic_fromJs(nonNull1)
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
				val result = topicApi.inGroup.withEncryptionMetadata(
					groupIdConverted,
					baseConverted,
					patientConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedTopic ->
						topic_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(topic: GroupScopedJs<TopicJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.getEncryptionKeysOf(
				topicConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(topic: GroupScopedJs<TopicJs>): Promise<Boolean> =
				GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.hasWriteAccess(
				topicConverted,
			)
			result
		}

		override fun decryptPatientIdOf(topic: GroupScopedJs<TopicJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.decryptPatientIdOf(
				topicConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<TopicJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Topic> = groupScoped_fromJs(
				entity,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			topicApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
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
			val result = topicApi.inGroup.decrypt(
				topicsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
				Promise<Array<GroupScopedJs<TopicJs>>> = GlobalScope.promise {
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
			val result = topicApi.inGroup.tryDecrypt(
				topicsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Topic> ->
					groupScoped_toJs(
						x1,
						{ x2: Topic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.inGroup.matchTopicsBy(
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

		override fun matchTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.inGroup.matchTopicsBySorted(
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

		override fun deleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.deleteTopicById(
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
			val result = topicApi.inGroup.deleteTopicsByIds(
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
			topicApi.inGroup.purgeTopicById(
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
			val result = topicApi.inGroup.purgeTopicsByIds(
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
			val result = topicApi.inGroup.deleteTopic(
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
			val result = topicApi.inGroup.deleteTopics(
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
			topicApi.inGroup.purgeTopic(
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
			val result = topicApi.inGroup.purgeTopics(
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			topic: GroupScopedJs<DecryptedTopicJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedTopicJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val topicConverted: GroupScoped<DecryptedTopic> = groupScoped_fromJs(
					topic,
					{ x1: DecryptedTopicJs ->
						topic_fromJs(x1)
					},
				)
				val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TopicShareOptionsJs? ->
					options?.let { nonNull1 ->
						topicShareOptions_fromJs(nonNull1)
					}
				}
				val result = topicApi.inGroup.shareWith(
					delegateConverted,
					topicConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedTopic ->
						topic_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(topic: GroupScopedJs<DecryptedTopicJs>,
				delegates: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedTopicJs>> = GlobalScope.promise {
			val topicConverted: GroupScoped<DecryptedTopic> = groupScoped_fromJs(
				topic,
				{ x1: DecryptedTopicJs ->
					topic_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, TopicShareOptions> =
					EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = topicApi.inGroup.shareWithMany(
				topicConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun filterTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
			val result = topicApi.inGroup.filterTopicsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
			val result = topicApi.inGroup.filterTopicsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun createTopic(entity: GroupScopedJs<DecryptedTopicJs>):
				Promise<GroupScopedJs<DecryptedTopicJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedTopic> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedTopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.createTopic(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun createTopics(entities: Array<GroupScopedJs<DecryptedTopicJs>>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedTopic>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicApi.inGroup.createTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedTopicJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.undeleteTopicById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
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
			val result = topicApi.inGroup.undeleteTopicsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteTopic(topic: GroupScopedJs<TopicJs>):
				Promise<GroupScopedJs<DecryptedTopicJs>> = GlobalScope.promise {
			val topicConverted: GroupScoped<Topic> = groupScoped_fromJs(
				topic,
				{ x1: TopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.undeleteTopic(
				topicConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun undeleteTopics(topics: Array<GroupScopedJs<DecryptedTopicJs>>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val topicsConverted: List<GroupScoped<DecryptedTopic>> = arrayToList(
				topics,
				"topics",
				{ x1: GroupScopedJs<DecryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicApi.inGroup.undeleteTopics(
				topicsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyTopic(entity: GroupScopedJs<DecryptedTopicJs>):
				Promise<GroupScopedJs<DecryptedTopicJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedTopic> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedTopicJs ->
					topic_fromJs(x1)
				},
			)
			val result = topicApi.inGroup.modifyTopic(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedTopic ->
					topic_toJs(x1)
				},
			)
		}

		override fun modifyTopics(entities: Array<GroupScopedJs<DecryptedTopicJs>>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedTopic>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedTopicJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedTopicJs ->
							topic_fromJs(x2)
						},
					)
				},
			)
			val result = topicApi.inGroup.modifyTopics(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}

		override fun getTopic(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedTopicJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = topicApi.inGroup.getTopic(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedTopic ->
							topic_toJs(x1)
						},
					)
				}
			)
		}

		override fun getTopics(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedTopicJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = topicApi.inGroup.getTopics(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedTopic> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedTopic ->
							topic_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedTopicJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedTopic? = base?.let { nonNull1 ->
				topic_fromJs(nonNull1)
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
			val result = topicApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			topic_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(topic: TopicJs): Promise<Array<String>> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.getEncryptionKeysOf(
			topicConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(topic: TopicJs): Promise<Boolean> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.hasWriteAccess(
			topicConverted,
		)
		result
	}

	override fun decryptPatientIdOf(topic: TopicJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.decryptPatientIdOf(
			topicConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: TopicJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Topic = topic_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		topicApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(topic: EncryptedTopicJs): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val topicConverted: EncryptedTopic = topic_fromJs(topic)
		val result = topicApi.decrypt(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun tryDecrypt(topic: EncryptedTopicJs): Promise<TopicJs> = GlobalScope.promise {
		val topicConverted: EncryptedTopic = topic_fromJs(topic)
		val result = topicApi.tryDecrypt(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun matchTopicsBy(filter: FilterOptionsJs<TopicJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
		val result = topicApi.matchTopicsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>): Promise<Array<String>>
			= GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
		val result = topicApi.matchTopicsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteTopicById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = topicApi.deleteTopicById(
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
		val result = topicApi.deleteTopicsByIds(
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
		topicApi.purgeTopicById(
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
		val result = topicApi.purgeTopicsByIds(
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
		val result = topicApi.deleteTopic(
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
		val result = topicApi.deleteTopics(
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
		topicApi.purgeTopic(
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
		val result = topicApi.purgeTopics(
			topicsConverted,
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
		topic: DecryptedTopicJs,
		options: dynamic,
	): Promise<DecryptedTopicJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val topicConverted: DecryptedTopic = topic_fromJs(topic)
			val optionsConverted: TopicShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: TopicShareOptionsJs? ->
				options?.let { nonNull1 ->
					topicShareOptions_fromJs(nonNull1)
				}
			}
			val result = topicApi.shareWith(
				delegateIdConverted,
				topicConverted,
				optionsConverted,
			)
			topic_toJs(result)
		}
	}

	override fun shareWithMany(topic: DecryptedTopicJs,
			delegates: Record<String, TopicShareOptionsJs>): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val topicConverted: DecryptedTopic = topic_fromJs(topic)
		val delegatesConverted: Map<String, TopicShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: TopicShareOptionsJs ->
				topicShareOptions_fromJs(x1)
			},
		)
		val result = topicApi.shareWithMany(
			topicConverted,
			delegatesConverted,
		)
		topic_toJs(result)
	}

	override fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
		val result = topicApi.filterTopicsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Topic> = sortableFilterOptions_fromJs(filter)
		val result = topicApi.filterTopicsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTopic = topic_fromJs(entity)
		val result = topicApi.createTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun createTopics(entities: Array<DecryptedTopicJs>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedTopic> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedTopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicApi.createTopics(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun undeleteTopicById(id: String, rev: String): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = topicApi.undeleteTopicById(
			idConverted,
			revConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedTopicJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = topicApi.undeleteTopicsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun undeleteTopic(topic: TopicJs): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val topicConverted: Topic = topic_fromJs(topic)
		val result = topicApi.undeleteTopic(
			topicConverted,
		)
		topic_toJs(result)
	}

	override fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		val topicsConverted: List<Topic> = arrayToList(
			topics,
			"topics",
			{ x1: TopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicApi.undeleteTopics(
			topicsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTopic = topic_fromJs(entity)
		val result = topicApi.modifyTopic(
			entityConverted,
		)
		topic_toJs(result)
	}

	override fun modifyTopics(entities: Array<DecryptedTopicJs>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedTopic> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedTopicJs ->
				topic_fromJs(x1)
			},
		)
		val result = topicApi.modifyTopics(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun getTopic(entityId: String): Promise<DecryptedTopicJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = topicApi.getTopic(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				topic_toJs(nonNull1)
			}
		)
	}

	override fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = topicApi.getTopics(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTopic ->
				topic_toJs(x1)
			},
		)
	}

	override fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<DecryptedTopicJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val topicRoleConverted: TopicRole = TopicRole.valueOf(topicRole)
		val result = topicApi.addParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
			topicRoleConverted,
		)
		topic_toJs(result)
	}

	override fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val dataOwnerIdConverted: String = dataOwnerId
		val result = topicApi.removeParticipant(
			entityIdConverted,
			dataOwnerIdConverted,
		)
		topic_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<TopicJs>,
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
			val filterConverted: FilterOptions<Topic> = filterOptions_fromJs(filter)
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
			val result = topicApi.subscribeToEvents(
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
