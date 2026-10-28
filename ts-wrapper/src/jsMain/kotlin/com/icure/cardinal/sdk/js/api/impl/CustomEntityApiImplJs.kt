// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CustomEntityApi
import com.icure.cardinal.sdk.crypto.entities.CustomEntityDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.CustomEntityOwningEntity
import com.icure.cardinal.sdk.crypto.entities.CustomEntityShareOptions
import com.icure.cardinal.sdk.js.api.CustomEntityApiJs
import com.icure.cardinal.sdk.js.api.CustomEntityFlavouredApiJs
import com.icure.cardinal.sdk.js.api.CustomEntityFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.CustomEntityInGroupApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.BulkShareByIdsResultJs
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityOwningEntityJs
import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.bulkShareByIdsResult_toJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityDelegateOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityOwningEntity_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.customEntityShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.DecryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.hasEncryptionMetadata_fromJs
import com.icure.cardinal.sdk.js.model.customEntityBase_fromJs
import com.icure.cardinal.sdk.js.model.customEntityBase_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CustomEntityApiImplJs(
	private val customEntityApi: CustomEntityApi,
) : CustomEntityApiJs {
	override val encrypted: CustomEntityFlavouredApiJs<EncryptedCustomEntityBaseJs> =
			object : CustomEntityFlavouredApiJs<EncryptedCustomEntityBaseJs> {
		override fun shareWith(
			delegateId: String,
			entity: EncryptedCustomEntityBaseJs,
			options: dynamic,
		): Promise<EncryptedCustomEntityBaseJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val entityConverted: EncryptedCustomEntityBase = customEntityBase_fromJs(entity)
				val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CustomEntityShareOptionsJs? ->
					options?.let { nonNull1 ->
						customEntityShareOptions_fromJs(nonNull1)
					}
				}
				val result = customEntityApi.encrypted.shareWith(
					delegateIdConverted,
					entityConverted,
					optionsConverted,
				)
				customEntityBase_toJs(result)
			}
		}

		override fun shareWithMany(entity: EncryptedCustomEntityBaseJs, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: EncryptedCustomEntityBase = customEntityBase_fromJs(entity)
			val delegatesConverted: Map<String, CustomEntityShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CustomEntityShareOptionsJs ->
					customEntityShareOptions_fromJs(x1)
				},
			)
			val result = customEntityApi.encrypted.shareWithMany(
				entityConverted,
				delegatesConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun createEntity(entity: EncryptedCustomEntityBaseJs): Promise<EncryptedCustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: EncryptedCustomEntityBase = customEntityBase_fromJs(entity)
			val result = customEntityApi.encrypted.createEntity(
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
			val result = customEntityApi.encrypted.createEntities(
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
			val result = customEntityApi.encrypted.undeleteEntityById(
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
			val result = customEntityApi.encrypted.undeleteEntitiesByIds(
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
			val result = customEntityApi.encrypted.undeleteEntity(
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
			val result = customEntityApi.encrypted.undeleteEntities(
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
			val result = customEntityApi.encrypted.modifyEntity(
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
			val result = customEntityApi.encrypted.modifyEntities(
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
			val result = customEntityApi.encrypted.getEntity(
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
			val result = customEntityApi.encrypted.getEntities(
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
			val result = customEntityApi.encrypted.setRawAttachment(
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
			val result = customEntityApi.encrypted.setAttachment(
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
			val result = customEntityApi.encrypted.deleteAttachment(
				entityIdConverted,
				revConverted,
				keyConverted,
			)
			customEntityBase_toJs(result)
		}
	}

	override val tryAndRecover: CustomEntityFlavouredApiJs<CustomEntityBaseJs> =
			object : CustomEntityFlavouredApiJs<CustomEntityBaseJs> {
		override fun shareWith(
			delegateId: String,
			entity: CustomEntityBaseJs,
			options: dynamic,
		): Promise<CustomEntityBaseJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
				val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CustomEntityShareOptionsJs? ->
					options?.let { nonNull1 ->
						customEntityShareOptions_fromJs(nonNull1)
					}
				}
				val result = customEntityApi.tryAndRecover.shareWith(
					delegateIdConverted,
					entityConverted,
					optionsConverted,
				)
				customEntityBase_toJs(result)
			}
		}

		override fun shareWithMany(entity: CustomEntityBaseJs, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val delegatesConverted: Map<String, CustomEntityShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CustomEntityShareOptionsJs ->
					customEntityShareOptions_fromJs(x1)
				},
			)
			val result = customEntityApi.tryAndRecover.shareWithMany(
				entityConverted,
				delegatesConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun createEntity(entity: CustomEntityBaseJs): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val result = customEntityApi.tryAndRecover.createEntity(
				entityConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun createEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
			val entitiesConverted: List<CustomEntityBase> = arrayToList(
				entities,
				"entities",
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.tryAndRecover.createEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: CustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntityById(id: String, rev: String): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = customEntityApi.tryAndRecover.undeleteEntityById(
				idConverted,
				revConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = customEntityApi.tryAndRecover.undeleteEntitiesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: CustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntity(entity: CustomEntityBaseJs): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val result = customEntityApi.tryAndRecover.undeleteEntity(
				entityConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
			val entitiesConverted: List<CustomEntityBase> = arrayToList(
				entities,
				"entities",
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.tryAndRecover.undeleteEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: CustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun modifyEntity(entity: CustomEntityBaseJs): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val result = customEntityApi.tryAndRecover.modifyEntity(
				entityConverted,
			)
			customEntityBase_toJs(result)
		}

		override fun modifyEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
			val entitiesConverted: List<CustomEntityBase> = arrayToList(
				entities,
				"entities",
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.tryAndRecover.modifyEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: CustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun getEntity(entityId: String): Promise<CustomEntityBaseJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = customEntityApi.tryAndRecover.getEntity(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					customEntityBase_toJs(nonNull1)
				}
			)
		}

		override fun getEntities(entityIds: Array<String>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = customEntityApi.tryAndRecover.getEntities(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: CustomEntityBase ->
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
		): Promise<CustomEntityBaseJs> = GlobalScope.promise {
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
			val result = customEntityApi.tryAndRecover.setRawAttachment(
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
		): Promise<CustomEntityBaseJs> = GlobalScope.promise {
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
			val result = customEntityApi.tryAndRecover.setAttachment(
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
		): Promise<CustomEntityBaseJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val revConverted: String = rev
			val keyConverted: String = key
			val result = customEntityApi.tryAndRecover.deleteAttachment(
				entityIdConverted,
				revConverted,
				keyConverted,
			)
			customEntityBase_toJs(result)
		}
	}

	override val inGroup: CustomEntityInGroupApiJs = object : CustomEntityInGroupApiJs {
		override val encrypted: CustomEntityFlavouredInGroupApiJs<EncryptedCustomEntityBaseJs> =
				object : CustomEntityFlavouredInGroupApiJs<EncryptedCustomEntityBaseJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				entity: GroupScopedJs<EncryptedCustomEntityBaseJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val entityConverted: GroupScoped<EncryptedCustomEntityBase> = groupScoped_fromJs(
						entity,
						{ x1: EncryptedCustomEntityBaseJs ->
							customEntityBase_fromJs(x1)
						},
					)
					val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: CustomEntityShareOptionsJs? ->
						options?.let { nonNull1 ->
							customEntityShareOptions_fromJs(nonNull1)
						}
					}
					val result = customEntityApi.inGroup.encrypted.shareWith(
						delegateConverted,
						entityConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedCustomEntityBase ->
							customEntityBase_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedCustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedCustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, CustomEntityShareOptions> = EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = customEntityApi.inGroup.encrypted.shareWithMany(
					entityConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedCustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun createEntity(entity: GroupScopedJs<EncryptedCustomEntityBaseJs>): Promise<GroupScopedJs<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedCustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedCustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val result = customEntityApi.inGroup.encrypted.createEntity(
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
				val result = customEntityApi.inGroup.encrypted.createEntities(
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
				val result = customEntityApi.inGroup.encrypted.undeleteEntityById(
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
				val result = customEntityApi.inGroup.encrypted.undeleteEntitiesByIds(
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
				val result = customEntityApi.inGroup.encrypted.undeleteEntity(
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
				val result = customEntityApi.inGroup.encrypted.undeleteEntities(
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
				val result = customEntityApi.inGroup.encrypted.modifyEntity(
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
				val result = customEntityApi.inGroup.encrypted.modifyEntities(
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
				val result = customEntityApi.inGroup.encrypted.getEntity(
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
				val result = customEntityApi.inGroup.encrypted.getEntities(
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

		override val tryAndRecover: CustomEntityFlavouredInGroupApiJs<CustomEntityBaseJs> =
				object : CustomEntityFlavouredInGroupApiJs<CustomEntityBaseJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				entity: GroupScopedJs<CustomEntityBaseJs>,
				options: dynamic,
			): Promise<GroupScopedJs<CustomEntityBaseJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
						entity,
						{ x1: CustomEntityBaseJs ->
							customEntityBase_fromJs(x1)
						},
					)
					val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: CustomEntityShareOptionsJs? ->
						options?.let { nonNull1 ->
							customEntityShareOptions_fromJs(nonNull1)
						}
					}
					val result = customEntityApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						entityConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: CustomEntityBase ->
							customEntityBase_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(entity: GroupScopedJs<CustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Promise<GroupScopedJs<CustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: CustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, CustomEntityShareOptions> = EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = customEntityApi.inGroup.tryAndRecover.shareWithMany(
					entityConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun createEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<CustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: CustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val result = customEntityApi.inGroup.tryAndRecover.createEntity(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun createEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
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
				val result = customEntityApi.inGroup.tryAndRecover.createEntities(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CustomEntityBase> ->
						groupScoped_toJs(
							x1,
							{ x2: CustomEntityBase ->
								customEntityBase_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<CustomEntityBaseJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = customEntityApi.inGroup.tryAndRecover.undeleteEntityById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
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
				val result = customEntityApi.inGroup.tryAndRecover.undeleteEntitiesByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CustomEntityBase> ->
						groupScoped_toJs(
							x1,
							{ x2: CustomEntityBase ->
								customEntityBase_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<CustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: CustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val result = customEntityApi.inGroup.tryAndRecover.undeleteEntity(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
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
				val result = customEntityApi.inGroup.tryAndRecover.undeleteEntities(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CustomEntityBase> ->
						groupScoped_toJs(
							x1,
							{ x2: CustomEntityBase ->
								customEntityBase_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<CustomEntityBaseJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: CustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val result = customEntityApi.inGroup.tryAndRecover.modifyEntity(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: CustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}

			override fun modifyEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
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
				val result = customEntityApi.inGroup.tryAndRecover.modifyEntities(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CustomEntityBase> ->
						groupScoped_toJs(
							x1,
							{ x2: CustomEntityBase ->
								customEntityBase_toJs(x2)
							},
						)
					},
				)
			}

			override fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<CustomEntityBaseJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = customEntityApi.inGroup.tryAndRecover.getEntity(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: CustomEntityBase ->
								customEntityBase_toJs(x1)
							},
						)
					}
				)
			}

			override fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = customEntityApi.inGroup.tryAndRecover.getEntities(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<CustomEntityBase> ->
						groupScoped_toJs(
							x1,
							{ x2: CustomEntityBase ->
								customEntityBase_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			entityGroupId: String,
			base: DecryptedCustomEntityBaseJs?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedCustomEntityBase? = base?.let { nonNull1 ->
					customEntityBase_fromJs(nonNull1)
				}
				val owningEntityConverted: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>? = convertingOptionOrDefaultNullable(
					_options,
					"owningEntity",
					null
				) { owningEntity: CustomEntityOwningEntityJs<GroupScopedJs<HasEncryptionMetadataJs>>? ->
					owningEntity?.let { nonNull1 ->
						customEntityOwningEntity_fromJs(
							nonNull1,
							{ x1: GroupScopedJs<HasEncryptionMetadataJs> ->
								groupScoped_fromJs(
									x1,
									{ x2: HasEncryptionMetadataJs ->
										hasEncryptionMetadata_fromJs(x2)
									},
								)
							},
						)
					}
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
				val delegatesConverted: Map<EntityReferenceInGroup, AccessLevel> = convertingOptionOrDefaultNonNull(
					_options,
					"delegates",
					emptyMap()
				) { delegates: Array<EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel> ->
					EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(delegates)
				}
				val alternateRootDelegateReferenceConverted: EntityReferenceInGroup? = convertingOptionOrDefaultNullable(
					_options,
					"alternateRootDelegateReference",
					null
				) { alternateRootDelegateReference: EntityReferenceInGroupJs? ->
					alternateRootDelegateReference?.let { nonNull1 ->
						entityReferenceInGroup_fromJs(nonNull1)
					}
				}
				val result = customEntityApi.inGroup.withEncryptionMetadata(
					entityGroupIdConverted,
					baseConverted,
					owningEntityConverted,
					userConverted,
					delegatesConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedCustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}
		}

		override fun withEncryptionMetadataAndDelegates(
			entityGroupId: String,
			base: DecryptedCustomEntityBaseJs?,
			delegates: Array<EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedCustomEntityBase? = base?.let { nonNull1 ->
					customEntityBase_fromJs(nonNull1)
				}
				val delegatesConverted: Map<EntityReferenceInGroup, CustomEntityDelegateOptions> = EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions_fromJs(delegates)
				val owningEntityConverted: CustomEntityOwningEntity<GroupScoped<HasEncryptionMetadata>>? = convertingOptionOrDefaultNullable(
					_options,
					"owningEntity",
					null
				) { owningEntity: CustomEntityOwningEntityJs<GroupScopedJs<HasEncryptionMetadataJs>>? ->
					owningEntity?.let { nonNull1 ->
						customEntityOwningEntity_fromJs(
							nonNull1,
							{ x1: GroupScopedJs<HasEncryptionMetadataJs> ->
								groupScoped_fromJs(
									x1,
									{ x2: HasEncryptionMetadataJs ->
										hasEncryptionMetadata_fromJs(x2)
									},
								)
							},
						)
					}
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
				val alternateRootDelegateReferenceConverted: EntityReferenceInGroup? = convertingOptionOrDefaultNullable(
					_options,
					"alternateRootDelegateReference",
					null
				) { alternateRootDelegateReference: EntityReferenceInGroupJs? ->
					alternateRootDelegateReference?.let { nonNull1 ->
						entityReferenceInGroup_fromJs(nonNull1)
					}
				}
				val result = customEntityApi.inGroup.withEncryptionMetadataAndDelegates(
					entityGroupIdConverted,
					baseConverted,
					delegatesConverted,
					owningEntityConverted,
					userConverted,
					alternateRootDelegateReferenceConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedCustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Array<String>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.getEncryptionKeysOf(
				entityConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun getSecretIdsOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Record<String, Array<EntityReferenceInGroupJs>>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.getSecretIdsOf(
				entityConverted,
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

		override fun hasWriteAccess(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Boolean> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.hasWriteAccess(
				entityConverted,
			)
			result
		}

		override fun decryptOwningEntityIdsOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.decryptOwningEntityIdsOf(
				entityConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<CustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			customEntityApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityApi.inGroup.decrypt(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityApi.inGroup.tryDecrypt(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<CustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: CustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun encryptOrValidate(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityApi.inGroup.encryptOrValidate(
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

		override fun deleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.deleteEntityById(
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
			val result = customEntityApi.inGroup.deleteEntitiesByIds(
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
			customEntityApi.inGroup.purgeEntityById(
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
			val result = customEntityApi.inGroup.purgeEntitiesByIds(
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
			val result = customEntityApi.inGroup.deleteEntity(
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
			val result = customEntityApi.inGroup.deleteEntities(
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
			customEntityApi.inGroup.purgeEntity(
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
			val result = customEntityApi.inGroup.purgeEntities(
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
			val result = customEntityApi.inGroup.getDataOwnersWithAccessTo(
				entityConverted,
			)
			entityAccessInformation_toJs(result)
		}

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			entity: GroupScopedJs<DecryptedCustomEntityBaseJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val entityConverted: GroupScoped<DecryptedCustomEntityBase> = groupScoped_fromJs(
					entity,
					{ x1: DecryptedCustomEntityBaseJs ->
						customEntityBase_fromJs(x1)
					},
				)
				val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: CustomEntityShareOptionsJs? ->
					options?.let { nonNull1 ->
						customEntityShareOptions_fromJs(nonNull1)
					}
				}
				val result = customEntityApi.inGroup.shareWith(
					delegateConverted,
					entityConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedCustomEntityBase ->
						customEntityBase_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedCustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedCustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, CustomEntityShareOptions> = EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = customEntityApi.inGroup.shareWithMany(
				entityConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun createEntity(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedCustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedCustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.createEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun createEntities(entities: Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedCustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedCustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedCustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityApi.inGroup.createEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.undeleteEntityById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityApi.inGroup.undeleteEntitiesByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<CustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: CustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.undeleteEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
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
			val result = customEntityApi.inGroup.undeleteEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyEntity(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedCustomEntityBase> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedCustomEntityBaseJs ->
					customEntityBase_fromJs(x1)
				},
			)
			val result = customEntityApi.inGroup.modifyEntity(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedCustomEntityBase ->
					customEntityBase_toJs(x1)
				},
			)
		}

		override fun modifyEntities(entities: Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedCustomEntityBase>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedCustomEntityBaseJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedCustomEntityBaseJs ->
							customEntityBase_fromJs(x2)
						},
					)
				},
			)
			val result = customEntityApi.inGroup.modifyEntities(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}

		override fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = customEntityApi.inGroup.getEntity(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x1)
						},
					)
				}
			)
		}

		override fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = customEntityApi.inGroup.getEntities(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedCustomEntityBase> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedCustomEntityBase ->
							customEntityBase_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(base: DecryptedCustomEntityBaseJs?, options: dynamic): Promise<DecryptedCustomEntityBaseJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedCustomEntityBase? = base?.let { nonNull1 ->
				customEntityBase_fromJs(nonNull1)
			}
			val owningEntityConverted: CustomEntityOwningEntity<HasEncryptionMetadata>? = convertingOptionOrDefaultNullable(
				_options,
				"owningEntity",
				null
			) { owningEntity: CustomEntityOwningEntityJs<HasEncryptionMetadataJs>? ->
				owningEntity?.let { nonNull1 ->
					customEntityOwningEntity_fromJs(
						nonNull1,
						{ x1: HasEncryptionMetadataJs ->
							hasEncryptionMetadata_fromJs(x1)
						},
					)
				}
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
			val result = customEntityApi.withEncryptionMetadata(
				baseConverted,
				owningEntityConverted,
				userConverted,
				delegatesConverted,
				alternateRootDelegateIdConverted,
			)
			customEntityBase_toJs(result)
		}
	}

	override fun withEncryptionMetadataAndDelegates(
		base: DecryptedCustomEntityBaseJs?,
		delegates: Record<String, CustomEntityDelegateOptionsJs>,
		options: dynamic,
	): Promise<DecryptedCustomEntityBaseJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedCustomEntityBase? = base?.let { nonNull1 ->
				customEntityBase_fromJs(nonNull1)
			}
			val delegatesConverted: Map<String, CustomEntityDelegateOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CustomEntityDelegateOptionsJs ->
					customEntityDelegateOptions_fromJs(x1)
				},
			)
			val owningEntityConverted: CustomEntityOwningEntity<HasEncryptionMetadata>? = convertingOptionOrDefaultNullable(
				_options,
				"owningEntity",
				null
			) { owningEntity: CustomEntityOwningEntityJs<HasEncryptionMetadataJs>? ->
				owningEntity?.let { nonNull1 ->
					customEntityOwningEntity_fromJs(
						nonNull1,
						{ x1: HasEncryptionMetadataJs ->
							hasEncryptionMetadata_fromJs(x1)
						},
					)
				}
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
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = customEntityApi.withEncryptionMetadataAndDelegates(
				baseConverted,
				delegatesConverted,
				owningEntityConverted,
				userConverted,
				alternateRootDelegateIdConverted,
			)
			customEntityBase_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(entity: CustomEntityBaseJs): Promise<Array<String>> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.getEncryptionKeysOf(
			entityConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun getSecretIdsOf(entity: CustomEntityBaseJs): Promise<Record<String, Array<EntityReferenceInGroupJs>>> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.getSecretIdsOf(
			entityConverted,
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

	override fun hasWriteAccess(entity: CustomEntityBaseJs): Promise<Boolean> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.hasWriteAccess(
			entityConverted,
		)
		result
	}

	override fun decryptOwningEntityIdsOf(entity: CustomEntityBaseJs): Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.decryptOwningEntityIdsOf(
			entityConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: CustomEntityBaseJs, delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		customEntityApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.decrypt(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun tryDecrypt(entities: Array<EncryptedCustomEntityBaseJs>): Promise<Array<CustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.tryDecrypt(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: CustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun encryptOrValidate(entities: Array<CustomEntityBaseJs>): Promise<Array<EncryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<CustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: CustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.encryptOrValidate(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun shareEntitiesByIds(entityIds: Array<String>, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<BulkShareByIdsResultJs> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val delegatesConverted: Map<String, CustomEntityShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: CustomEntityShareOptionsJs ->
				customEntityShareOptions_fromJs(x1)
			},
		)
		val result = customEntityApi.shareEntitiesByIds(
			entityIdsConverted,
			delegatesConverted,
		)
		bulkShareByIdsResult_toJs(result)
	}

	override fun getAndTryDecryptAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray?> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val keyConverted: String = key
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = convertingOptionOrDefaultNullable(
				_options,
				"decryptedAttachmentValidator",
				null
			) { decryptedAttachmentValidator: ((ByteArray) -> Promise<Boolean>)? ->
				if (decryptedAttachmentValidator == null) null else ({ arg0 ->
					decryptedAttachmentValidator(
						arg0,
					).await()
				})
			}
			val result = customEntityApi.getAndTryDecryptAttachment(
				entityConverted,
				keyConverted,
				decryptedAttachmentValidatorConverted,
			)
			nullToUndefined(
				result
			)
		}
	}

	override fun getAndDecryptAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val keyConverted: String = key
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = convertingOptionOrDefaultNullable(
				_options,
				"decryptedAttachmentValidator",
				null
			) { decryptedAttachmentValidator: ((ByteArray) -> Promise<Boolean>)? ->
				if (decryptedAttachmentValidator == null) null else ({ arg0 ->
					decryptedAttachmentValidator(
						arg0,
					).await()
				})
			}
			val result = customEntityApi.getAndDecryptAttachment(
				entityConverted,
				keyConverted,
				decryptedAttachmentValidatorConverted,
			)
			result
		}
	}

	override fun tryDecryptAttachment(
		entity: CustomEntityBaseJs,
		encryptedAttachment: ByteArray,
		options: dynamic,
	): Promise<ByteArray?> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
			val encryptedAttachmentConverted: ByteArray = encryptedAttachment
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = convertingOptionOrDefaultNullable(
				_options,
				"decryptedAttachmentValidator",
				null
			) { decryptedAttachmentValidator: ((ByteArray) -> Promise<Boolean>)? ->
				if (decryptedAttachmentValidator == null) null else ({ arg0 ->
					decryptedAttachmentValidator(
						arg0,
					).await()
				})
			}
			val result = customEntityApi.tryDecryptAttachment(
				entityConverted,
				encryptedAttachmentConverted,
				decryptedAttachmentValidatorConverted,
			)
			nullToUndefined(
				result
			)
		}
	}

	override fun encryptAndSetAttachment(
		entity: CustomEntityBaseJs,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val keyConverted: String = key
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = customEntityApi.encryptAndSetAttachment(
			entityConverted,
			keyConverted,
			utisConverted,
			attachmentConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun deleteEntityById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = customEntityApi.deleteEntityById(
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
		val result = customEntityApi.deleteEntitiesByIds(
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
		customEntityApi.purgeEntityById(
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
		val result = customEntityApi.purgeEntitiesByIds(
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
		val result = customEntityApi.deleteEntity(
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
		val result = customEntityApi.deleteEntities(
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
		customEntityApi.purgeEntity(
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
		val result = customEntityApi.purgeEntities(
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
		val result = customEntityApi.getRawAttachment(
			entityIdConverted,
			keyConverted,
		)
		result
	}

	override fun getAttachment(entityId: String, key: String): Promise<ByteArray> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val keyConverted: String = key
		val result = customEntityApi.getAttachment(
			entityIdConverted,
			keyConverted,
		)
		result
	}

	override fun getDataOwnersWithAccessTo(entity: CustomEntityBaseJs): Promise<EntityAccessInformationJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.getDataOwnersWithAccessTo(
			entityConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun shareWith(
		delegateId: String,
		entity: DecryptedCustomEntityBaseJs,
		options: dynamic,
	): Promise<DecryptedCustomEntityBaseJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val entityConverted: DecryptedCustomEntityBase = customEntityBase_fromJs(entity)
			val optionsConverted: CustomEntityShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: CustomEntityShareOptionsJs? ->
				options?.let { nonNull1 ->
					customEntityShareOptions_fromJs(nonNull1)
				}
			}
			val result = customEntityApi.shareWith(
				delegateIdConverted,
				entityConverted,
				optionsConverted,
			)
			customEntityBase_toJs(result)
		}
	}

	override fun shareWithMany(entity: DecryptedCustomEntityBaseJs, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: DecryptedCustomEntityBase = customEntityBase_fromJs(entity)
		val delegatesConverted: Map<String, CustomEntityShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: CustomEntityShareOptionsJs ->
				customEntityShareOptions_fromJs(x1)
			},
		)
		val result = customEntityApi.shareWithMany(
			entityConverted,
			delegatesConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun createEntity(entity: DecryptedCustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: DecryptedCustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.createEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun createEntities(entities: Array<DecryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.createEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun undeleteEntityById(id: String, rev: String): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = customEntityApi.undeleteEntityById(
			idConverted,
			revConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = customEntityApi.undeleteEntitiesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun undeleteEntity(entity: CustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: CustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.undeleteEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<CustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: CustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.undeleteEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun modifyEntity(entity: DecryptedCustomEntityBaseJs): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityConverted: DecryptedCustomEntityBase = customEntityBase_fromJs(entity)
		val result = customEntityApi.modifyEntity(
			entityConverted,
		)
		customEntityBase_toJs(result)
	}

	override fun modifyEntities(entities: Array<DecryptedCustomEntityBaseJs>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedCustomEntityBase> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedCustomEntityBaseJs ->
				customEntityBase_fromJs(x1)
			},
		)
		val result = customEntityApi.modifyEntities(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
				customEntityBase_toJs(x1)
			},
		)
	}

	override fun getEntity(entityId: String): Promise<DecryptedCustomEntityBaseJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = customEntityApi.getEntity(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				customEntityBase_toJs(nonNull1)
			}
		)
	}

	override fun getEntities(entityIds: Array<String>): Promise<Array<DecryptedCustomEntityBaseJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = customEntityApi.getEntities(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCustomEntityBase ->
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
	): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
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
		val result = customEntityApi.setRawAttachment(
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
	): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
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
		val result = customEntityApi.setAttachment(
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
	): Promise<DecryptedCustomEntityBaseJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val keyConverted: String = key
		val result = customEntityApi.deleteAttachment(
			entityIdConverted,
			revConverted,
			keyConverted,
		)
		customEntityBase_toJs(result)
	}
}
