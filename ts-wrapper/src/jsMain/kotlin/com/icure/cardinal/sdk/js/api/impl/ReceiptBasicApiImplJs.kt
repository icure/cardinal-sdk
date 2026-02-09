// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ReceiptBasicApi
import com.icure.cardinal.sdk.js.api.ReceiptBasicApiJs
import com.icure.cardinal.sdk.js.api.ReceiptBasicInGroupApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.EncryptedReceiptJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.ReceiptJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.receipt_fromJs
import com.icure.cardinal.sdk.js.model.receipt_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import kotlin.Array
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
internal class ReceiptBasicApiImplJs(
	private val receiptBasicApi: ReceiptBasicApi,
) : ReceiptBasicApiJs {
	override val inGroup: ReceiptBasicInGroupApiJs = object : ReceiptBasicInGroupApiJs {
		override fun deleteReceiptById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = receiptBasicApi.inGroup.deleteReceiptById(
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
			val result = receiptBasicApi.inGroup.deleteReceiptsByIds(
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
			receiptBasicApi.inGroup.purgeReceiptById(
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
			val result = receiptBasicApi.inGroup.purgeReceiptsByIds(
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
			val result = receiptBasicApi.inGroup.deleteReceipt(
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
			val result = receiptBasicApi.inGroup.deleteReceipts(
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
			receiptBasicApi.inGroup.purgeReceipt(
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
			val result = receiptBasicApi.inGroup.purgeReceipts(
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

		override fun createReceipt(entity: GroupScopedJs<EncryptedReceiptJs>):
				Promise<GroupScopedJs<EncryptedReceiptJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedReceipt> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedReceiptJs ->
					receipt_fromJs(x1)
				},
			)
			val result = receiptBasicApi.inGroup.createReceipt(
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
			val result = receiptBasicApi.inGroup.createReceipts(
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
			val result = receiptBasicApi.inGroup.undeleteReceiptById(
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
			val result = receiptBasicApi.inGroup.undeleteReceiptsByIds(
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
			val result = receiptBasicApi.inGroup.undeleteReceipt(
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
			val result = receiptBasicApi.inGroup.undeleteReceipts(
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
			val result = receiptBasicApi.inGroup.modifyReceipt(
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
			val result = receiptBasicApi.inGroup.modifyReceipts(
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
			val result = receiptBasicApi.inGroup.getReceipt(
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
			val result = receiptBasicApi.inGroup.getReceipts(
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

	override fun deleteReceiptById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = receiptBasicApi.deleteReceiptById(
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
		val result = receiptBasicApi.deleteReceiptsByIds(
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
		receiptBasicApi.purgeReceiptById(
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
		val result = receiptBasicApi.purgeReceiptsByIds(
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
		val result = receiptBasicApi.deleteReceipt(
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
		val result = receiptBasicApi.deleteReceipts(
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
		receiptBasicApi.purgeReceipt(
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
		val result = receiptBasicApi.purgeReceipts(
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
		val result = receiptBasicApi.getRawReceiptAttachment(
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
		val result = receiptBasicApi.setRawReceiptAttachment(
			receiptIdConverted,
			revConverted,
			blobTypeConverted,
			attachmentConverted,
		)
		receipt_toJs(result)
	}

	override fun createReceipt(entity: EncryptedReceiptJs): Promise<EncryptedReceiptJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedReceipt = receipt_fromJs(entity)
		val result = receiptBasicApi.createReceipt(
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
		val result = receiptBasicApi.createReceipts(
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
		val result = receiptBasicApi.undeleteReceiptById(
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
		val result = receiptBasicApi.undeleteReceiptsByIds(
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
		val result = receiptBasicApi.undeleteReceipt(
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
		val result = receiptBasicApi.undeleteReceipts(
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
		val result = receiptBasicApi.modifyReceipt(
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
		val result = receiptBasicApi.modifyReceipts(
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
		val result = receiptBasicApi.getReceipt(
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
		val result = receiptBasicApi.getReceipts(
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
		val result = receiptBasicApi.listByReference(
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
