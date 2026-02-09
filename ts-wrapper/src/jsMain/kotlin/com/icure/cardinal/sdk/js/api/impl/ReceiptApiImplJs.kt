// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.ReceiptApiJs
import com.icure.cardinal.sdk.js.api.ReceiptFlavouredApiJs
import com.icure.cardinal.sdk.js.api.ReceiptFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.ReceiptInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.ReceiptShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.receiptShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.receipt_fromJs
import com.icure.cardinal.sdk.js.model.receipt_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
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
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ReceiptApiImplJs(
	private val receiptApi: ReceiptApi,
) : ReceiptApiJs {
	override val encrypted: ReceiptFlavouredApiJs<EncryptedReceiptJs> = object :
			ReceiptFlavouredApiJs<EncryptedReceiptJs> {
		override fun shareWith(
			delegateId: String,
			receipt: EncryptedReceiptJs,
			options: dynamic,
		): Promise<EncryptedReceiptJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
				val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ReceiptShareOptionsJs? ->
					options?.let { nonNull1 ->
						receiptShareOptions_fromJs(nonNull1)
					}
				}
				val result = receiptApi.encrypted.shareWith(
					delegateIdConverted,
					receiptConverted,
					optionsConverted,
				)
				receipt_toJs(result)
			}
		}

		override fun shareWithMany(receipt: EncryptedReceiptJs,
				delegates: Record<String, ReceiptShareOptionsJs>): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.shareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			receipt_toJs(result)
		}

		override fun createReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedReceipt = receipt_fromJs(entity)
			val result = receiptApi.encrypted.createReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun createReceipts(entities: Array<EncryptedReceiptJs>):
				Promise<Array<EncryptedReceiptJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedReceipt> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.createReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceiptById(id: String, rev: String): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = receiptApi.encrypted.undeleteReceiptById(
				idConverted,
				revConverted,
			)
			receipt_toJs(result)
		}

		override fun undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<EncryptedReceiptJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.undeleteReceiptsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceipt(receipt: ReceiptJs): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val receiptConverted: Receipt = receipt_fromJs(receipt)
			val result = receiptApi.encrypted.undeleteReceipt(
				receiptConverted,
			)
			receipt_toJs(result)
		}

		override fun undeleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<EncryptedReceiptJs>> =
				GlobalScope.promise {
			val receiptsConverted: List<Receipt> = arrayToList(
				receipts,
				"receipts",
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.undeleteReceipts(
				receiptsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun modifyReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedReceipt = receipt_fromJs(entity)
			val result = receiptApi.encrypted.modifyReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun modifyReceipts(entities: Array<EncryptedReceiptJs>):
				Promise<Array<EncryptedReceiptJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedReceipt> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.encrypted.modifyReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun getReceipt(entityId: String): Promise<EncryptedReceiptJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = receiptApi.encrypted.getReceipt(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					receipt_toJs(nonNull1)
				}
			)
		}

		override fun getReceipts(entityIds: Array<String>): Promise<Array<EncryptedReceiptJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = receiptApi.encrypted.getReceipts(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun listByReference(reference: String): Promise<Array<EncryptedReceiptJs>> =
				GlobalScope.promise {
			val referenceConverted: String = reference
			val result = receiptApi.encrypted.listByReference(
				referenceConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: ReceiptFlavouredApiJs<ReceiptJs> = object :
			ReceiptFlavouredApiJs<ReceiptJs> {
		override fun shareWith(
			delegateId: String,
			receipt: ReceiptJs,
			options: dynamic,
		): Promise<ReceiptJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val receiptConverted: Receipt = receipt_fromJs(receipt)
				val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ReceiptShareOptionsJs? ->
					options?.let { nonNull1 ->
						receiptShareOptions_fromJs(nonNull1)
					}
				}
				val result = receiptApi.tryAndRecover.shareWith(
					delegateIdConverted,
					receiptConverted,
					optionsConverted,
				)
				receipt_toJs(result)
			}
		}

		override fun shareWithMany(receipt: ReceiptJs, delegates: Record<String, ReceiptShareOptionsJs>):
				Promise<ReceiptJs> = GlobalScope.promise {
			val receiptConverted: Receipt = receipt_fromJs(receipt)
			val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ReceiptShareOptionsJs ->
					receiptShareOptions_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.shareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			receipt_toJs(result)
		}

		override fun createReceipt(entity: ReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
			val entityConverted: Receipt = receipt_fromJs(entity)
			val result = receiptApi.tryAndRecover.createReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun createReceipts(entities: Array<ReceiptJs>): Promise<Array<ReceiptJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Receipt> = arrayToList(
				entities,
				"entities",
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.createReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceiptById(id: String, rev: String): Promise<ReceiptJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = receiptApi.tryAndRecover.undeleteReceiptById(
				idConverted,
				revConverted,
			)
			receipt_toJs(result)
		}

		override fun undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<ReceiptJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.undeleteReceiptsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceipt(receipt: ReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
			val receiptConverted: Receipt = receipt_fromJs(receipt)
			val result = receiptApi.tryAndRecover.undeleteReceipt(
				receiptConverted,
			)
			receipt_toJs(result)
		}

		override fun undeleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<ReceiptJs>> =
				GlobalScope.promise {
			val receiptsConverted: List<Receipt> = arrayToList(
				receipts,
				"receipts",
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.undeleteReceipts(
				receiptsConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun modifyReceipt(entity: ReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
			val entityConverted: Receipt = receipt_fromJs(entity)
			val result = receiptApi.tryAndRecover.modifyReceipt(
				entityConverted,
			)
			receipt_toJs(result)
		}

		override fun modifyReceipts(entities: Array<ReceiptJs>): Promise<Array<ReceiptJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Receipt> = arrayToList(
				entities,
				"entities",
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.tryAndRecover.modifyReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun getReceipt(entityId: String): Promise<ReceiptJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = receiptApi.tryAndRecover.getReceipt(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					receipt_toJs(nonNull1)
				}
			)
		}

		override fun getReceipts(entityIds: Array<String>): Promise<Array<ReceiptJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = receiptApi.tryAndRecover.getReceipts(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun listByReference(reference: String): Promise<Array<ReceiptJs>> = GlobalScope.promise {
			val referenceConverted: String = reference
			val result = receiptApi.tryAndRecover.listByReference(
				referenceConverted,
			)
			listToArray(
				result,
				{ x1: Receipt ->
					receipt_toJs(x1)
				},
			)
		}
	}

	override val inGroup: ReceiptInGroupApiJs = object : ReceiptInGroupApiJs {
		override val encrypted: ReceiptFlavouredInGroupApiJs<EncryptedReceiptJs> = object :
				ReceiptFlavouredInGroupApiJs<EncryptedReceiptJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				receipt: GroupScopedJs<EncryptedReceiptJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedReceiptJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val receiptConverted: GroupScoped<EncryptedReceipt> = groupScoped_fromJs(
						receipt,
						{ x1: EncryptedReceiptJs ->
							receipt_fromJs(x1)
						},
					)
					val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: ReceiptShareOptionsJs? ->
						options?.let { nonNull1 ->
							receiptShareOptions_fromJs(nonNull1)
						}
					}
					val result = receiptApi.inGroup.encrypted.shareWith(
						delegateConverted,
						receiptConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedReceipt ->
							receipt_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(receipt: GroupScopedJs<EncryptedReceiptJs>,
					delegates: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
				val receiptConverted: GroupScoped<EncryptedReceipt> = groupScoped_fromJs(
					receipt,
					{ x1: EncryptedReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, ReceiptShareOptions> =
						EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = receiptApi.inGroup.encrypted.shareWithMany(
					receiptConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun createReceipt(entity: GroupScopedJs<EncryptedReceiptJs>):
					Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedReceipt> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.encrypted.createReceipt(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun createReceipts(entities: Array<GroupScopedJs<EncryptedReceiptJs>>):
					Promise<Array<GroupScopedJs<EncryptedReceiptJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedReceipt>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.encrypted.createReceipts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedReceipt> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedReceipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.encrypted.undeleteReceiptById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<EncryptedReceiptJs>>> = GlobalScope.promise {
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
				val result = receiptApi.inGroup.encrypted.undeleteReceiptsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedReceipt> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedReceipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
					Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
				val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
					receipt,
					{ x1: ReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.encrypted.undeleteReceipt(
					receiptConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun undeleteReceipts(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
					Promise<Array<GroupScopedJs<EncryptedReceiptJs>>> = GlobalScope.promise {
				val receiptsConverted: List<GroupScoped<EncryptedReceipt>> = arrayToList(
					receipts,
					"receipts",
					{ x1: GroupScopedJs<EncryptedReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.encrypted.undeleteReceipts(
					receiptsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedReceipt> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedReceipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyReceipt(entity: GroupScopedJs<EncryptedReceiptJs>):
					Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedReceipt> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.encrypted.modifyReceipt(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun modifyReceipts(entities: Array<GroupScopedJs<EncryptedReceiptJs>>):
					Promise<Array<GroupScopedJs<EncryptedReceiptJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<EncryptedReceipt>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<EncryptedReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: EncryptedReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.encrypted.modifyReceipts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedReceipt> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedReceipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun getReceipt(groupId: String, entityId: String):
					Promise<GroupScopedJs<EncryptedReceiptJs>?> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = receiptApi.inGroup.encrypted.getReceipt(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: EncryptedReceipt ->
								receipt_toJs(x1)
							},
						)
					}
				)
			}

			override fun getReceipts(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<EncryptedReceiptJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = receiptApi.inGroup.encrypted.getReceipts(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<EncryptedReceipt> ->
						groupScoped_toJs(
							x1,
							{ x2: EncryptedReceipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}
		}

		override val tryAndRecover: ReceiptFlavouredInGroupApiJs<ReceiptJs> = object :
				ReceiptFlavouredInGroupApiJs<ReceiptJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				receipt: GroupScopedJs<ReceiptJs>,
				options: dynamic,
			): Promise<GroupScopedJs<ReceiptJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
						receipt,
						{ x1: ReceiptJs ->
							receipt_fromJs(x1)
						},
					)
					val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: ReceiptShareOptionsJs? ->
						options?.let { nonNull1 ->
							receiptShareOptions_fromJs(nonNull1)
						}
					}
					val result = receiptApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						receiptConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Receipt ->
							receipt_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(receipt: GroupScopedJs<ReceiptJs>,
					delegates: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<ReceiptJs>> = GlobalScope.promise {
				val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
					receipt,
					{ x1: ReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, ReceiptShareOptions> =
						EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = receiptApi.inGroup.tryAndRecover.shareWithMany(
					receiptConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun createReceipt(entity: GroupScopedJs<ReceiptJs>): Promise<GroupScopedJs<ReceiptJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Receipt> = groupScoped_fromJs(
					entity,
					{ x1: ReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.createReceipt(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun createReceipts(entities: Array<GroupScopedJs<ReceiptJs>>):
					Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Receipt>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<ReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: ReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.createReceipts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Receipt> ->
						groupScoped_toJs(
							x1,
							{ x2: Receipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<ReceiptJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.undeleteReceiptById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
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
				val result = receiptApi.inGroup.tryAndRecover.undeleteReceiptsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Receipt> ->
						groupScoped_toJs(
							x1,
							{ x2: Receipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
					Promise<GroupScopedJs<ReceiptJs>> = GlobalScope.promise {
				val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
					receipt,
					{ x1: ReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.undeleteReceipt(
					receiptConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun undeleteReceipts(receipts: Array<GroupScopedJs<ReceiptJs>>):
					Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
				val receiptsConverted: List<GroupScoped<Receipt>> = arrayToList(
					receipts,
					"receipts",
					{ x1: GroupScopedJs<ReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: ReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.undeleteReceipts(
					receiptsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Receipt> ->
						groupScoped_toJs(
							x1,
							{ x2: Receipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyReceipt(entity: GroupScopedJs<ReceiptJs>): Promise<GroupScopedJs<ReceiptJs>> =
					GlobalScope.promise {
				val entityConverted: GroupScoped<Receipt> = groupScoped_fromJs(
					entity,
					{ x1: ReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.modifyReceipt(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Receipt ->
						receipt_toJs(x1)
					},
				)
			}

			override fun modifyReceipts(entities: Array<GroupScopedJs<ReceiptJs>>):
					Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Receipt>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<ReceiptJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: ReceiptJs ->
								receipt_fromJs(x2)
							},
						)
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.modifyReceipts(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Receipt> ->
						groupScoped_toJs(
							x1,
							{ x2: Receipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}

			override fun getReceipt(groupId: String, entityId: String): Promise<GroupScopedJs<ReceiptJs>?> =
					GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = receiptApi.inGroup.tryAndRecover.getReceipt(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Receipt ->
								receipt_toJs(x1)
							},
						)
					}
				)
			}

			override fun getReceipts(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = receiptApi.inGroup.tryAndRecover.getReceipts(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Receipt> ->
						groupScoped_toJs(
							x1,
							{ x2: Receipt ->
								receipt_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadata(
			groupId: String,
			base: DecryptedReceiptJs?,
			patient: GroupScopedJs<PatientJs>?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedReceiptJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val baseConverted: DecryptedReceipt? = base?.let { nonNull1 ->
					receipt_fromJs(nonNull1)
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
				val result = receiptApi.inGroup.withEncryptionMetadata(
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
					{ x1: DecryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(receipt: GroupScopedJs<ReceiptJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.getEncryptionKeysOf(
				receiptConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(receipt: GroupScopedJs<ReceiptJs>): Promise<Boolean> =
				GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.hasWriteAccess(
				receiptConverted,
			)
			result
		}

		override fun decryptPatientIdOf(receipt: GroupScopedJs<ReceiptJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.decryptPatientIdOf(
				receiptConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<ReceiptJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				entity,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			receiptApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
			val receiptsConverted: List<GroupScoped<EncryptedReceipt>> = arrayToList(
				receipts,
				"receipts",
				{ x1: GroupScopedJs<EncryptedReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.decrypt(
				receiptsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(receipts: Array<GroupScopedJs<EncryptedReceiptJs>>):
				Promise<Array<GroupScopedJs<ReceiptJs>>> = GlobalScope.promise {
			val receiptsConverted: List<GroupScoped<EncryptedReceipt>> = arrayToList(
				receipts,
				"receipts",
				{ x1: GroupScopedJs<EncryptedReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.tryDecrypt(
				receiptsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Receipt> ->
					groupScoped_toJs(
						x1,
						{ x2: Receipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.deleteReceiptById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = receiptApi.inGroup.deleteReceiptsByIds(
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

		override fun purgeReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			receiptApi.inGroup.purgeReceiptById(
				entityIdConverted,
			)

		}

		override fun purgeReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = receiptApi.inGroup.purgeReceiptsByIds(
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

		override fun deleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.deleteReceipt(
				receiptConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteReceipts(receipts: Array<GroupScopedJs<ReceiptJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val receiptsConverted: List<GroupScoped<Receipt>> = arrayToList(
				receipts,
				"receipts",
				{ x1: GroupScopedJs<ReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: ReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.deleteReceipts(
				receiptsConverted,
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

		override fun purgeReceipt(receipt: GroupScopedJs<ReceiptJs>): Promise<Unit> =
				GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			receiptApi.inGroup.purgeReceipt(
				receiptConverted,
			)

		}

		override fun purgeReceipts(receipts: Array<GroupScopedJs<ReceiptJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val receiptsConverted: List<GroupScoped<Receipt>> = arrayToList(
				receipts,
				"receipts",
				{ x1: GroupScopedJs<ReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: ReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.purgeReceipts(
				receiptsConverted,
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
			receipt: GroupScopedJs<DecryptedReceiptJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedReceiptJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val receiptConverted: GroupScoped<DecryptedReceipt> = groupScoped_fromJs(
					receipt,
					{ x1: DecryptedReceiptJs ->
						receipt_fromJs(x1)
					},
				)
				val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ReceiptShareOptionsJs? ->
					options?.let { nonNull1 ->
						receiptShareOptions_fromJs(nonNull1)
					}
				}
				val result = receiptApi.inGroup.shareWith(
					delegateConverted,
					receiptConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedReceipt ->
						receipt_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(receipt: GroupScopedJs<DecryptedReceiptJs>,
				delegates: Array<EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedReceiptJs>> = GlobalScope.promise {
			val receiptConverted: GroupScoped<DecryptedReceipt> = groupScoped_fromJs(
				receipt,
				{ x1: DecryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, ReceiptShareOptions> =
					EntityReferenceInGroupToReceiptShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = receiptApi.inGroup.shareWithMany(
				receiptConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun createReceipt(entity: GroupScopedJs<DecryptedReceiptJs>):
				Promise<GroupScopedJs<DecryptedReceiptJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedReceipt> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.createReceipt(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun createReceipts(entities: Array<GroupScopedJs<DecryptedReceiptJs>>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedReceipt>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.createReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedReceiptJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.undeleteReceiptById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceiptsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
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
			val result = receiptApi.inGroup.undeleteReceiptsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteReceipt(receipt: GroupScopedJs<ReceiptJs>):
				Promise<GroupScopedJs<DecryptedReceiptJs>> = GlobalScope.promise {
			val receiptConverted: GroupScoped<Receipt> = groupScoped_fromJs(
				receipt,
				{ x1: ReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.undeleteReceipt(
				receiptConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun undeleteReceipts(receipts: Array<GroupScopedJs<DecryptedReceiptJs>>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
			val receiptsConverted: List<GroupScoped<DecryptedReceipt>> = arrayToList(
				receipts,
				"receipts",
				{ x1: GroupScopedJs<DecryptedReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.undeleteReceipts(
				receiptsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyReceipt(entity: GroupScopedJs<DecryptedReceiptJs>):
				Promise<GroupScopedJs<DecryptedReceiptJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedReceipt> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptApi.inGroup.modifyReceipt(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedReceipt ->
					receipt_toJs(x1)
				},
			)
		}

		override fun modifyReceipts(entities: Array<GroupScopedJs<DecryptedReceiptJs>>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedReceipt>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedReceiptJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedReceiptJs ->
							receipt_fromJs(x2)
						},
					)
				},
			)
			val result = receiptApi.inGroup.modifyReceipts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}

		override fun getReceipt(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedReceiptJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = receiptApi.inGroup.getReceipt(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedReceipt ->
							receipt_toJs(x1)
						},
					)
				}
			)
		}

		override fun getReceipts(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedReceiptJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = receiptApi.inGroup.getReceipts(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedReceipt> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedReceipt ->
							receipt_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedReceiptJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedReceiptJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedReceipt? = base?.let { nonNull1 ->
				receipt_fromJs(nonNull1)
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
			val result = receiptApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			receipt_toJs(result)
		}
	}

	override fun getAndDecryptReceiptAttachment(receipt: ReceiptJs, attachmentId: String):
			Promise<ByteArray> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val attachmentIdConverted: String = attachmentId
		val result = receiptApi.getAndDecryptReceiptAttachment(
			receiptConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun encryptAndSetReceiptAttachment(
		receipt: ReceiptJs,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val result = receiptApi.encryptAndSetReceiptAttachment(
			receiptConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun getEncryptionKeysOf(receipt: ReceiptJs): Promise<Array<String>> =
			GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.getEncryptionKeysOf(
			receiptConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(receipt: ReceiptJs): Promise<Boolean> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.hasWriteAccess(
			receiptConverted,
		)
		result
	}

	override fun decryptPatientIdOf(receipt: ReceiptJs): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.decryptPatientIdOf(
			receiptConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ReceiptJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Receipt = receipt_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		receiptApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun logReceipt(
		user: UserJs,
		docId: String,
		refs: Array<String>,
		blobType: String,
		blob: ByteArray,
	): Promise<ReceiptJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val docIdConverted: String = docId
		val refsConverted: List<String> = arrayToList(
			refs,
			"refs",
			{ x1: String ->
				x1
			},
		)
		val blobTypeConverted: String = blobType
		val blobConverted: ByteArray = blob
		val result = receiptApi.logReceipt(
			userConverted,
			docIdConverted,
			refsConverted,
			blobTypeConverted,
			blobConverted,
		)
		receipt_toJs(result)
	}

	override fun decrypt(receipt: EncryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
		val result = receiptApi.decrypt(
			receiptConverted,
		)
		receipt_toJs(result)
	}

	override fun tryDecrypt(receipt: EncryptedReceiptJs): Promise<ReceiptJs> = GlobalScope.promise {
		val receiptConverted: EncryptedReceipt = receipt_fromJs(receipt)
		val result = receiptApi.tryDecrypt(
			receiptConverted,
		)
		receipt_toJs(result)
	}

	override fun deleteReceiptById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = receiptApi.deleteReceiptById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = receiptApi.deleteReceiptsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeReceiptById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		receiptApi.purgeReceiptById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = receiptApi.purgeReceiptsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteReceipt(receipt: ReceiptJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.deleteReceipt(
			receiptConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val receiptsConverted: List<Receipt> = arrayToList(
			receipts,
			"receipts",
			{ x1: ReceiptJs ->
				receipt_fromJs(x1)
			},
		)
		val result = receiptApi.deleteReceipts(
			receiptsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeReceipt(receipt: ReceiptJs): Promise<Unit> = GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		receiptApi.purgeReceipt(
			receiptConverted,
		)

	}

	override fun purgeReceipts(receipts: Array<ReceiptJs>): Promise<Array<StoredDocumentIdentifierJs>>
			= GlobalScope.promise {
		val receiptsConverted: List<Receipt> = arrayToList(
			receipts,
			"receipts",
			{ x1: ReceiptJs ->
				receipt_fromJs(x1)
			},
		)
		val result = receiptApi.purgeReceipts(
			receiptsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawReceiptAttachment(receiptId: String, attachmentId: String): Promise<ByteArray> =
			GlobalScope.promise {
		val receiptIdConverted: String = receiptId
		val attachmentIdConverted: String = attachmentId
		val result = receiptApi.getRawReceiptAttachment(
			receiptIdConverted,
			attachmentIdConverted,
		)
		result
	}

	override fun setRawReceiptAttachment(
		receiptId: String,
		rev: String,
		blobType: String,
		attachment: ByteArray,
	): Promise<EncryptedReceiptJs> = GlobalScope.promise {
		val receiptIdConverted: String = receiptId
		val revConverted: String = rev
		val blobTypeConverted: String = blobType
		val attachmentConverted: ByteArray = attachment
		val result = receiptApi.setRawReceiptAttachment(
			receiptIdConverted,
			revConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun shareWith(
		delegateId: String,
		receipt: DecryptedReceiptJs,
		options: dynamic,
	): Promise<DecryptedReceiptJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val receiptConverted: DecryptedReceipt = receipt_fromJs(receipt)
			val optionsConverted: ReceiptShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: ReceiptShareOptionsJs? ->
				options?.let { nonNull1 ->
					receiptShareOptions_fromJs(nonNull1)
				}
			}
			val result = receiptApi.shareWith(
				delegateIdConverted,
				receiptConverted,
				optionsConverted,
			)
			receipt_toJs(result)
		}
	}

	override fun shareWithMany(receipt: DecryptedReceiptJs,
			delegates: Record<String, ReceiptShareOptionsJs>): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val receiptConverted: DecryptedReceipt = receipt_fromJs(receipt)
		val delegatesConverted: Map<String, ReceiptShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ReceiptShareOptionsJs ->
				receiptShareOptions_fromJs(x1)
			},
		)
		val result = receiptApi.shareWithMany(
			receiptConverted,
			delegatesConverted,
		)
		receipt_toJs(result)
	}

	override fun createReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedReceipt = receipt_fromJs(entity)
		val result = receiptApi.createReceipt(
			entityConverted,
		)
		receipt_toJs(result)
	}

	override fun createReceipts(entities: Array<DecryptedReceiptJs>):
			Promise<Array<DecryptedReceiptJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedReceipt> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedReceiptJs ->
				receipt_fromJs(x1)
			},
		)
		val result = receiptApi.createReceipts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun undeleteReceiptById(id: String, rev: String): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = receiptApi.undeleteReceiptById(
			idConverted,
			revConverted,
		)
		receipt_toJs(result)
	}

	override fun undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedReceiptJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = receiptApi.undeleteReceiptsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun undeleteReceipt(receipt: ReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val receiptConverted: Receipt = receipt_fromJs(receipt)
		val result = receiptApi.undeleteReceipt(
			receiptConverted,
		)
		receipt_toJs(result)
	}

	override fun undeleteReceipts(receipts: Array<ReceiptJs>): Promise<Array<DecryptedReceiptJs>> =
			GlobalScope.promise {
		val receiptsConverted: List<Receipt> = arrayToList(
			receipts,
			"receipts",
			{ x1: ReceiptJs ->
				receipt_fromJs(x1)
			},
		)
		val result = receiptApi.undeleteReceipts(
			receiptsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun modifyReceipt(entity: DecryptedReceiptJs): Promise<DecryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedReceipt = receipt_fromJs(entity)
		val result = receiptApi.modifyReceipt(
			entityConverted,
		)
		receipt_toJs(result)
	}

	override fun modifyReceipts(entities: Array<DecryptedReceiptJs>):
			Promise<Array<DecryptedReceiptJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedReceipt> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedReceiptJs ->
				receipt_fromJs(x1)
			},
		)
		val result = receiptApi.modifyReceipts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun getReceipt(entityId: String): Promise<DecryptedReceiptJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = receiptApi.getReceipt(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				receipt_toJs(nonNull1)
			}
		)
	}

	override fun getReceipts(entityIds: Array<String>): Promise<Array<DecryptedReceiptJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = receiptApi.getReceipts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}

	override fun listByReference(reference: String): Promise<Array<DecryptedReceiptJs>> =
			GlobalScope.promise {
		val referenceConverted: String = reference
		val result = receiptApi.listByReference(
			referenceConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedReceipt ->
				receipt_toJs(x1)
			},
		)
	}
}
