// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CustomEntityBasicApi
import com.icure.cardinal.sdk.js.api.CustomEntityBasicApiJs
import com.icure.cardinal.sdk.js.api.CustomEntityBasicInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.customEntityBase_fromJs
import com.icure.cardinal.sdk.js.model.customEntityBase_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CustomEntityBasicApiImplJs(
	private val customEntityBasicApi: CustomEntityBasicApi,
) : CustomEntityBasicApiJs {
	override val inGroup: CustomEntityBasicInGroupApiJs = object : CustomEntityBasicInGroupApiJs {
		override fun deleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.deleteEntityById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
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
			val result = customEntityBasicApi.inGroup.deleteEntitiesByIds(
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

		override fun purgeEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			customEntityBasicApi.inGroup.purgeEntityById(
				entityIdConverted,
			)

		}

		override fun purgeEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
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
			val result = customEntityBasicApi.inGroup.purgeEntitiesByIds(
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

		override fun deleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.deleteEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<CustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<CustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityBasicApi.inGroup.deleteEntities(
				entitiesConverted,
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

		override fun purgeEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			customEntityBasicApi.inGroup.purgeEntity(
				entityConverted,
			)

		}

		override fun purgeEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<CustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<CustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityBasicApi.inGroup.purgeEntities(
				entitiesConverted,
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

		override fun getDataOwnersWithAccessTo(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<EntityAccessInformationJs> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.getDataOwnersWithAccessTo(
				entityConverted,
			)
			entityAccessInformation_toJs(result)
		}

		override fun createEntity(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedCustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedCustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.createEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun createEntities(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedCustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedCustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedCustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityBasicApi.inGroup.createEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.undeleteEntityById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityBasicApi.inGroup.undeleteEntitiesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.undeleteEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<CustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<CustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: CustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityBasicApi.inGroup.undeleteEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyEntity(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedCustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedCustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityBasicApi.inGroup.modifyEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun modifyEntities(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedCustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedCustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedCustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityBasicApi.inGroup.modifyEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = customEntityBasicApi.inGroup.getEntity(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x1)
						},
					)
				}
			)
		}

		override fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = customEntityBasicApi.inGroup.getEntities(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun deleteEntityById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = customEntityBasicApi.deleteEntityById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.deleteEntitiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeEntityById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		customEntityBasicApi.purgeEntityById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.purgeEntitiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteEntity(entity: CustomEntityBaseJs): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityBasicApi.deleteEntity(
			entityConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entitiesConverted: List<CustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: CustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.deleteEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeEntity(entity: CustomEntityBaseJs): Promise<Unit> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		customEntityBasicApi.purgeEntity(
			entityConverted,
		)

	}

	override fun purgeEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entitiesConverted: List<CustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: CustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.purgeEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawAttachment(entityId: String, key: String): Promise<ByteArray> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val keyConverted: String = key
		val result = customEntityBasicApi.getRawAttachment(
			entityIdConverted,
			keyConverted,
		)
		result
	}

	override fun getAttachment(entityId: String, key: String): Promise<ByteArray> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val keyConverted: String = key
		val result = customEntityBasicApi.getAttachment(
			entityIdConverted,
			keyConverted,
		)
		result
	}

	override fun getDataOwnersWithAccessTo(entity: CustomEntityBaseJs): Promise<EntityAccessInformationJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityBasicApi.getDataOwnersWithAccessTo(
			entityConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun createEntity(entity: EncryptedCustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: EncryptedCustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityBasicApi.createEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun createEntities(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.createEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun undeleteEntityById(id: String, rev: String): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = customEntityBasicApi.undeleteEntityById(
			idConverted,
			revConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.undeleteEntitiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun undeleteEntity(entity: CustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityBasicApi.undeleteEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<CustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: CustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.undeleteEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun modifyEntity(entity: EncryptedCustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: EncryptedCustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityBasicApi.modifyEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun modifyEntities(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityBasicApi.modifyEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun getEntity(entityId: String): Promise<EncryptedCustomEntityBaseJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = customEntityBasicApi.getEntity(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				customEntityBase_toJs(nonNull1)
			}
		)
	}

	override fun getEntities(entityIds: Array<String>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = customEntityBasicApi.getEntities(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val keyConverted: String = key
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = customEntityBasicApi.setRawAttachment(
			entityIdConverted,
			revConverted,
			keyConverted,
			utisConverted,
			attachmentConverted,
			encryptedConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun setAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val keyConverted: String = key
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = customEntityBasicApi.setAttachment(
			entityIdConverted,
			revConverted,
			keyConverted,
			utisConverted,
			attachmentConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun deleteAttachment(
		entityId: String,
		rev: String,
		key: String,
	): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val keyConverted: String = key
		val result = customEntityBasicApi.deleteAttachment(
			entityIdConverted,
			revConverted,
			keyConverted,
		)
		customEntityBase_toJs(result)
	}
}
