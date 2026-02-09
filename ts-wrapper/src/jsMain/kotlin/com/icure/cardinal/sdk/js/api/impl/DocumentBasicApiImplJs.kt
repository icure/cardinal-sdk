// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DocumentBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DocumentBasicApiJs
import com.icure.cardinal.sdk.js.api.DocumentBasicInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.document_fromJs
import com.icure.cardinal.sdk.js.model.document_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
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
internal class DocumentBasicApiImplJs(
	private val documentBasicApi: DocumentBasicApi,
) : DocumentBasicApiJs {
	override val inGroup: DocumentBasicInGroupApiJs = object : DocumentBasicInGroupApiJs {
		override fun matchDocumentsBy(groupId: String, filter: BaseFilterOptionsJs<DocumentJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
			val result = documentBasicApi.inGroup.matchDocumentsBy(
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

		override fun matchDocumentsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<DocumentJs>): Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Document> =
					baseSortableFilterOptions_fromJs(filter)
			val result = documentBasicApi.inGroup.matchDocumentsBySorted(
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

		override fun filterDocumentsBy(groupId: String, filter: BaseFilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
			val result = documentBasicApi.inGroup.filterDocumentsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterDocumentsBySorted(groupId: String,
				filter: BaseSortableFilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<Document> =
					baseSortableFilterOptions_fromJs(filter)
			val result = documentBasicApi.inGroup.filterDocumentsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.deleteDocumentById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = documentBasicApi.inGroup.deleteDocumentsByIds(
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

		override fun purgeDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>
				= GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			documentBasicApi.inGroup.purgeDocumentById(
				entityIdConverted,
			)

		}

		override fun purgeDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
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
			val result = documentBasicApi.inGroup.purgeDocumentsByIds(
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

		override fun deleteDocument(document: GroupScopedJs<DocumentJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.deleteDocument(
				documentConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteDocuments(documents: Array<GroupScopedJs<DocumentJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val documentsConverted: List<GroupScoped<Document>> = arrayToList(
				documents,
				"documents",
				{ x1: GroupScopedJs<DocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentBasicApi.inGroup.deleteDocuments(
				documentsConverted,
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

		override fun purgeDocument(document: GroupScopedJs<DocumentJs>): Promise<Unit> =
				GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			documentBasicApi.inGroup.purgeDocument(
				documentConverted,
			)

		}

		override fun purgeDocuments(documents: Array<GroupScopedJs<DocumentJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val documentsConverted: List<GroupScoped<Document>> = arrayToList(
				documents,
				"documents",
				{ x1: GroupScopedJs<DocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentBasicApi.inGroup.purgeDocuments(
				documentsConverted,
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

		override fun createDocument(entity: GroupScopedJs<EncryptedDocumentJs>):
				Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedDocument> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.createDocument(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun createDocuments(entities: Array<GroupScopedJs<EncryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedDocument>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentBasicApi.inGroup.createDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.undeleteDocumentById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
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
			val result = documentBasicApi.inGroup.undeleteDocumentsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDocument(document: GroupScopedJs<DocumentJs>):
				Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.undeleteDocument(
				documentConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocuments(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val documentsConverted: List<GroupScoped<EncryptedDocument>> = arrayToList(
				documents,
				"documents",
				{ x1: GroupScopedJs<EncryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentBasicApi.inGroup.undeleteDocuments(
				documentsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyDocument(entity: GroupScopedJs<EncryptedDocumentJs>):
				Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<EncryptedDocument> = groupScoped_fromJs(
				entity,
				{ x1: EncryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentBasicApi.inGroup.modifyDocument(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun modifyDocuments(entities: Array<GroupScopedJs<EncryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<EncryptedDocument>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<EncryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: EncryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentBasicApi.inGroup.modifyDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun getDocument(groupId: String, entityId: String):
				Promise<GroupScopedJs<EncryptedDocumentJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = documentBasicApi.inGroup.getDocument(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: EncryptedDocument ->
							document_toJs(x1)
						},
					)
				}
			)
		}

		override fun getDocuments(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = documentBasicApi.inGroup.getDocuments(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<EncryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: EncryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun matchDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
		val result = documentBasicApi.matchDocumentsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Document> =
				baseSortableFilterOptions_fromJs(filter)
		val result = documentBasicApi.matchDocumentsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterDocumentsBy(filter: BaseFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Document> = baseFilterOptions_fromJs(filter)
		val result = documentBasicApi.filterDocumentsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun filterDocumentsBySorted(filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Document> =
				baseSortableFilterOptions_fromJs(filter)
		val result = documentBasicApi.filterDocumentsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun deleteDocumentById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentBasicApi.deleteDocumentById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = documentBasicApi.deleteDocumentsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDocumentById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		documentBasicApi.purgeDocumentById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = documentBasicApi.purgeDocumentsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteDocument(document: DocumentJs): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentBasicApi.deleteDocument(
			documentConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteDocuments(documents: Array<DocumentJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val documentsConverted: List<Document> = arrayToList(
			documents,
			"documents",
			{ x1: DocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.deleteDocuments(
			documentsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeDocument(document: DocumentJs): Promise<Unit> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		documentBasicApi.purgeDocument(
			documentConverted,
		)

	}

	override fun purgeDocuments(documents: Array<DocumentJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val documentsConverted: List<Document> = arrayToList(
			documents,
			"documents",
			{ x1: DocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.purgeDocuments(
			documentsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun getRawMainAttachment(documentId: String): Promise<ByteArray> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val result = documentBasicApi.getRawMainAttachment(
			documentIdConverted,
		)
		result
	}

	override fun getRawSecondaryAttachment(documentId: String, key: String): Promise<ByteArray> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val result = documentBasicApi.getRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
		)
		result
	}

	override fun setRawMainAttachment(
		documentId: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val revConverted: String = rev
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentBasicApi.setRawMainAttachment(
			documentIdConverted,
			revConverted,
			utisConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun setRawSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val revConverted: String = rev
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val encryptedConverted: Boolean = encrypted
		val result = documentBasicApi.setRawSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
			utisConverted,
			attachmentConverted,
			encryptedConverted,
		)
		document_toJs(result)
	}

	override fun deleteMainAttachment(entityId: String, rev: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentBasicApi.deleteMainAttachment(
			entityIdConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun deleteSecondaryAttachment(
		documentId: String,
		key: String,
		rev: String,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val revConverted: String = rev
		val result = documentBasicApi.deleteSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun createDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedDocument = document_fromJs(entity)
		val result = documentBasicApi.createDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun createDocuments(entities: Array<EncryptedDocumentJs>):
			Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedDocument> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.createDocuments(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun undeleteDocumentById(id: String, rev: String): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = documentBasicApi.undeleteDocumentById(
			idConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = documentBasicApi.undeleteDocumentsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun undeleteDocument(document: DocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentBasicApi.undeleteDocument(
			documentConverted,
		)
		document_toJs(result)
	}

	override fun undeleteDocuments(documents: Array<EncryptedDocumentJs>):
			Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
		val documentsConverted: List<EncryptedDocument> = arrayToList(
			documents,
			"documents",
			{ x1: EncryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.undeleteDocuments(
			documentsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun modifyDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedDocument = document_fromJs(entity)
		val result = documentBasicApi.modifyDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun modifyDocuments(entities: Array<EncryptedDocumentJs>):
			Promise<Array<EncryptedDocumentJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedDocument> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentBasicApi.modifyDocuments(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun getDocument(entityId: String): Promise<EncryptedDocumentJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentBasicApi.getDocument(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				document_toJs(nonNull1)
			}
		)
	}

	override fun getDocuments(entityIds: Array<String>): Promise<Array<EncryptedDocumentJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = documentBasicApi.getDocuments(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedDocument ->
				document_toJs(x1)
			},
		)
	}
}
