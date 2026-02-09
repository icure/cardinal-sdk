// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DocumentApi
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.DocumentApiJs
import com.icure.cardinal.sdk.js.api.DocumentFlavouredApiJs
import com.icure.cardinal.sdk.js.api.DocumentFlavouredInGroupApiJs
import com.icure.cardinal.sdk.js.api.DocumentInGroupApiJs
import com.icure.cardinal.sdk.js.crypto.entities.DocumentShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.documentShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
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
import com.icure.cardinal.sdk.js.model.DecryptedDocumentJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.document_fromJs
import com.icure.cardinal.sdk.js.model.document_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
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
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DocumentApiImplJs(
	private val documentApi: DocumentApi,
) : DocumentApiJs {
	override val encrypted: DocumentFlavouredApiJs<EncryptedDocumentJs> = object :
			DocumentFlavouredApiJs<EncryptedDocumentJs> {
		override fun shareWith(
			delegateId: String,
			document: EncryptedDocumentJs,
			options: dynamic,
		): Promise<EncryptedDocumentJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val documentConverted: EncryptedDocument = document_fromJs(document)
				val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: DocumentShareOptionsJs? ->
					options?.let { nonNull1 ->
						documentShareOptions_fromJs(nonNull1)
					}
				}
				val result = documentApi.encrypted.shareWith(
					delegateIdConverted,
					documentConverted,
					optionsConverted,
				)
				document_toJs(result)
			}
		}

		override fun shareWithMany(document: EncryptedDocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val documentConverted: EncryptedDocument = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.encrypted.shareWithMany(
				documentConverted,
				delegatesConverted,
			)
			document_toJs(result)
		}

		override fun filterDocumentsBy(filter: FilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
			val result = documentApi.encrypted.filterDocumentsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun filterDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<EncryptedDocumentJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
			val result = documentApi.encrypted.filterDocumentsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun createDocument(entity: EncryptedDocumentJs): Promise<EncryptedDocumentJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedDocument = document_fromJs(entity)
			val result = documentApi.encrypted.createDocument(
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
			val result = documentApi.encrypted.createDocuments(
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
			val result = documentApi.encrypted.undeleteDocumentById(
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
			val result = documentApi.encrypted.undeleteDocumentsByIds(
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
			val result = documentApi.encrypted.undeleteDocument(
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
			val result = documentApi.encrypted.undeleteDocuments(
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
			val result = documentApi.encrypted.modifyDocument(
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
			val result = documentApi.encrypted.modifyDocuments(
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
			val result = documentApi.encrypted.getDocument(
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
			val result = documentApi.encrypted.getDocuments(
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

	override val tryAndRecover: DocumentFlavouredApiJs<DocumentJs> = object :
			DocumentFlavouredApiJs<DocumentJs> {
		override fun shareWith(
			delegateId: String,
			document: DocumentJs,
			options: dynamic,
		): Promise<DocumentJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val documentConverted: Document = document_fromJs(document)
				val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: DocumentShareOptionsJs? ->
					options?.let { nonNull1 ->
						documentShareOptions_fromJs(nonNull1)
					}
				}
				val result = documentApi.tryAndRecover.shareWith(
					delegateIdConverted,
					documentConverted,
					optionsConverted,
				)
				document_toJs(result)
			}
		}

		override fun shareWithMany(document: DocumentJs,
				delegates: Record<String, DocumentShareOptionsJs>): Promise<DocumentJs> = GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: DocumentShareOptionsJs ->
					documentShareOptions_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.shareWithMany(
				documentConverted,
				delegatesConverted,
			)
			document_toJs(result)
		}

		override fun filterDocumentsBy(filter: FilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<DocumentJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
			val result = documentApi.tryAndRecover.filterDocumentsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun filterDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<DocumentJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
			val result = documentApi.tryAndRecover.filterDocumentsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun createDocument(entity: DocumentJs): Promise<DocumentJs> = GlobalScope.promise {
			val entityConverted: Document = document_fromJs(entity)
			val result = documentApi.tryAndRecover.createDocument(
				entityConverted,
			)
			document_toJs(result)
		}

		override fun createDocuments(entities: Array<DocumentJs>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Document> = arrayToList(
				entities,
				"entities",
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.createDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocumentById(id: String, rev: String): Promise<DocumentJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = documentApi.tryAndRecover.undeleteDocumentById(
				idConverted,
				revConverted,
			)
			document_toJs(result)
		}

		override fun undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
				Promise<Array<DocumentJs>> = GlobalScope.promise {
			val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.undeleteDocumentsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocument(document: DocumentJs): Promise<DocumentJs> = GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val result = documentApi.tryAndRecover.undeleteDocument(
				documentConverted,
			)
			document_toJs(result)
		}

		override fun undeleteDocuments(documents: Array<DocumentJs>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val documentsConverted: List<Document> = arrayToList(
				documents,
				"documents",
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.undeleteDocuments(
				documentsConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun modifyDocument(entity: DocumentJs): Promise<DocumentJs> = GlobalScope.promise {
			val entityConverted: Document = document_fromJs(entity)
			val result = documentApi.tryAndRecover.modifyDocument(
				entityConverted,
			)
			document_toJs(result)
		}

		override fun modifyDocuments(entities: Array<DocumentJs>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Document> = arrayToList(
				entities,
				"entities",
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.tryAndRecover.modifyDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}

		override fun getDocument(entityId: String): Promise<DocumentJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = documentApi.tryAndRecover.getDocument(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					document_toJs(nonNull1)
				}
			)
		}

		override fun getDocuments(entityIds: Array<String>): Promise<Array<DocumentJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.tryAndRecover.getDocuments(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Document ->
					document_toJs(x1)
				},
			)
		}
	}

	override val inGroup: DocumentInGroupApiJs = object : DocumentInGroupApiJs {
		override val encrypted: DocumentFlavouredInGroupApiJs<EncryptedDocumentJs> = object :
				DocumentFlavouredInGroupApiJs<EncryptedDocumentJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				document: GroupScopedJs<EncryptedDocumentJs>,
				options: dynamic,
			): Promise<GroupScopedJs<EncryptedDocumentJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val documentConverted: GroupScoped<EncryptedDocument> = groupScoped_fromJs(
						document,
						{ x1: EncryptedDocumentJs ->
							document_fromJs(x1)
						},
					)
					val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: DocumentShareOptionsJs? ->
						options?.let { nonNull1 ->
							documentShareOptions_fromJs(nonNull1)
						}
					}
					val result = documentApi.inGroup.encrypted.shareWith(
						delegateConverted,
						documentConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: EncryptedDocument ->
							document_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(document: GroupScopedJs<EncryptedDocumentJs>,
					delegates: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
				val documentConverted: GroupScoped<EncryptedDocument> = groupScoped_fromJs(
					document,
					{ x1: EncryptedDocumentJs ->
						document_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, DocumentShareOptions> =
						EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = documentApi.inGroup.encrypted.shareWithMany(
					documentConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: EncryptedDocument ->
						document_toJs(x1)
					},
				)
			}

			override fun filterDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
				val result = documentApi.inGroup.encrypted.filterDocumentsBy(
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
					filter: SortableFilterOptionsJs<DocumentJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
				val result = documentApi.inGroup.encrypted.filterDocumentsBySorted(
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

			override fun createDocument(entity: GroupScopedJs<EncryptedDocumentJs>):
					Promise<GroupScopedJs<EncryptedDocumentJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<EncryptedDocument> = groupScoped_fromJs(
					entity,
					{ x1: EncryptedDocumentJs ->
						document_fromJs(x1)
					},
				)
				val result = documentApi.inGroup.encrypted.createDocument(
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
				val result = documentApi.inGroup.encrypted.createDocuments(
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
				val result = documentApi.inGroup.encrypted.undeleteDocumentById(
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
				val result = documentApi.inGroup.encrypted.undeleteDocumentsByIds(
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
				val result = documentApi.inGroup.encrypted.undeleteDocument(
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
				val result = documentApi.inGroup.encrypted.undeleteDocuments(
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
				val result = documentApi.inGroup.encrypted.modifyDocument(
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
				val result = documentApi.inGroup.encrypted.modifyDocuments(
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
				val result = documentApi.inGroup.encrypted.getDocument(
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
				val result = documentApi.inGroup.encrypted.getDocuments(
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

		override val tryAndRecover: DocumentFlavouredInGroupApiJs<DocumentJs> = object :
				DocumentFlavouredInGroupApiJs<DocumentJs> {
			override fun shareWith(
				`delegate`: EntityReferenceInGroupJs,
				document: GroupScopedJs<DocumentJs>,
				options: dynamic,
			): Promise<GroupScopedJs<DocumentJs>> {
				val _options = options ?: js("{}")
				return GlobalScope.promise {
					val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
					val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
						document,
						{ x1: DocumentJs ->
							document_fromJs(x1)
						},
					)
					val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
						_options,
						"options",
						null
					) { options: DocumentShareOptionsJs? ->
						options?.let { nonNull1 ->
							documentShareOptions_fromJs(nonNull1)
						}
					}
					val result = documentApi.inGroup.tryAndRecover.shareWith(
						delegateConverted,
						documentConverted,
						optionsConverted,
					)
					groupScoped_toJs(
						result,
						{ x1: Document ->
							document_toJs(x1)
						},
					)
				}
			}

			override fun shareWithMany(document: GroupScopedJs<DocumentJs>,
					delegates: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
					Promise<GroupScopedJs<DocumentJs>> = GlobalScope.promise {
				val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
					document,
					{ x1: DocumentJs ->
						document_fromJs(x1)
					},
				)
				val delegatesConverted: Map<EntityReferenceInGroup, DocumentShareOptions> =
						EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
				val result = documentApi.inGroup.tryAndRecover.shareWithMany(
					documentConverted,
					delegatesConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}

			override fun filterDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
				val result = documentApi.inGroup.tryAndRecover.filterDocumentsBy(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun filterDocumentsBySorted(groupId: String,
					filter: SortableFilterOptionsJs<DocumentJs>):
					Promise<PaginatedListIteratorJs<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
				val result = documentApi.inGroup.tryAndRecover.filterDocumentsBySorted(
					groupIdConverted,
					filterConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun createDocument(entity: GroupScopedJs<DocumentJs>):
					Promise<GroupScopedJs<DocumentJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<Document> = groupScoped_fromJs(
					entity,
					{ x1: DocumentJs ->
						document_fromJs(x1)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.createDocument(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}

			override fun createDocuments(entities: Array<GroupScopedJs<DocumentJs>>):
					Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Document>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<DocumentJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: DocumentJs ->
								document_fromJs(x2)
							},
						)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.createDocuments(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
					Promise<GroupScopedJs<DocumentJs>> = GlobalScope.promise {
				val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
					entityId,
					{ x1: StoredDocumentIdentifierJs ->
						storedDocumentIdentifier_fromJs(x1)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.undeleteDocumentById(
					entityIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}

			override fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
					Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
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
				val result = documentApi.inGroup.tryAndRecover.undeleteDocumentsByIds(
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun undeleteDocument(document: GroupScopedJs<DocumentJs>):
					Promise<GroupScopedJs<DocumentJs>> = GlobalScope.promise {
				val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
					document,
					{ x1: DocumentJs ->
						document_fromJs(x1)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.undeleteDocument(
					documentConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}

			override fun undeleteDocuments(documents: Array<GroupScopedJs<DocumentJs>>):
					Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
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
				val result = documentApi.inGroup.tryAndRecover.undeleteDocuments(
					documentsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun modifyDocument(entity: GroupScopedJs<DocumentJs>):
					Promise<GroupScopedJs<DocumentJs>> = GlobalScope.promise {
				val entityConverted: GroupScoped<Document> = groupScoped_fromJs(
					entity,
					{ x1: DocumentJs ->
						document_fromJs(x1)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.modifyDocument(
					entityConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: Document ->
						document_toJs(x1)
					},
				)
			}

			override fun modifyDocuments(entities: Array<GroupScopedJs<DocumentJs>>):
					Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
				val entitiesConverted: List<GroupScoped<Document>> = arrayToList(
					entities,
					"entities",
					{ x1: GroupScopedJs<DocumentJs> ->
						groupScoped_fromJs(
							x1,
							{ x2: DocumentJs ->
								document_fromJs(x2)
							},
						)
					},
				)
				val result = documentApi.inGroup.tryAndRecover.modifyDocuments(
					entitiesConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}

			override fun getDocument(groupId: String, entityId: String): Promise<GroupScopedJs<DocumentJs>?>
					= GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdConverted: String = entityId
				val result = documentApi.inGroup.tryAndRecover.getDocument(
					groupIdConverted,
					entityIdConverted,
				)
				nullToUndefined(
					result?.let { nonNull1 ->
						groupScoped_toJs(
							nonNull1,
							{ x1: Document ->
								document_toJs(x1)
							},
						)
					}
				)
			}

			override fun getDocuments(groupId: String, entityIds: Array<String>):
					Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
				val groupIdConverted: String = groupId
				val entityIdsConverted: List<String> = arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)
				val result = documentApi.inGroup.tryAndRecover.getDocuments(
					groupIdConverted,
					entityIdsConverted,
				)
				listToArray(
					result,
					{ x1: GroupScoped<Document> ->
						groupScoped_toJs(
							x1,
							{ x2: Document ->
								document_toJs(x2)
							},
						)
					},
				)
			}
		}

		override fun withEncryptionMetadataLinkedToMessage(
			entityGroupId: String,
			base: DecryptedDocumentJs?,
			message: GroupScopedJs<MessageJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
					document_fromJs(nonNull1)
				}
				val messageConverted: GroupScoped<Message> = groupScoped_fromJs(
					message,
					{ x1: MessageJs ->
						message_fromJs(x1)
					},
				)
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
				val result = documentApi.inGroup.withEncryptionMetadataLinkedToMessage(
					entityGroupIdConverted,
					baseConverted,
					messageConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun withEncryptionMetadataLinkedToPatient(
			entityGroupId: String,
			base: DecryptedDocumentJs?,
			patient: GroupScopedJs<PatientJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
					document_fromJs(nonNull1)
				}
				val patientConverted: GroupScoped<Patient> = groupScoped_fromJs(
					patient,
					{ x1: PatientJs ->
						patient_fromJs(x1)
					},
				)
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
				val result = documentApi.inGroup.withEncryptionMetadataLinkedToPatient(
					entityGroupIdConverted,
					baseConverted,
					patientConverted,
					userConverted,
					delegatesConverted,
					secretIdConverted,
					alternateRootDelegateIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun withEncryptionMetadataUnlinked(
			entityGroupId: String,
			base: DecryptedDocumentJs?,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val entityGroupIdConverted: String = entityGroupId
				val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
					document_fromJs(nonNull1)
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
				val result = documentApi.inGroup.withEncryptionMetadataUnlinked(
					entityGroupIdConverted,
					baseConverted,
					userConverted,
					delegatesConverted,
					alternateRootDelegateIdConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun getEncryptionKeysOf(document: GroupScopedJs<DocumentJs>): Promise<Array<String>> =
				GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.getEncryptionKeysOf(
				documentConverted,
			)
			setToArray(
				result,
				{ x1: HexString ->
					hexString_toJs(x1)
				},
			)
		}

		override fun hasWriteAccess(document: GroupScopedJs<DocumentJs>): Promise<Boolean> =
				GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.hasWriteAccess(
				documentConverted,
			)
			result
		}

		override fun decryptOwningEntityIdsOf(document: GroupScopedJs<DocumentJs>):
				Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.decryptOwningEntityIdsOf(
				documentConverted,
			)
			setToArray(
				result,
				{ x1: EntityReferenceInGroup ->
					entityReferenceInGroup_toJs(x1)
				},
			)
		}

		override fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<DocumentJs>,
				delegates: Array<EntityReferenceInGroupJs>): Promise<Unit> = GlobalScope.promise {
			val entityConverted: GroupScoped<Document> = groupScoped_fromJs(
				entity,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val delegatesConverted: Set<EntityReferenceInGroup> = arrayToSet(
				delegates,
				"delegates",
				{ x1: EntityReferenceInGroupJs ->
					entityReferenceInGroup_fromJs(x1)
				},
			)
			documentApi.inGroup.createDelegationDeAnonymizationMetadata(
				entityConverted,
				delegatesConverted,
			)

		}

		override fun decrypt(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
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
			val result = documentApi.inGroup.decrypt(
				documentsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun tryDecrypt(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<DocumentJs>>> = GlobalScope.promise {
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
			val result = documentApi.inGroup.tryDecrypt(
				documentsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<Document> ->
					groupScoped_toJs(
						x1,
						{ x2: Document ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
			val result = documentApi.inGroup.matchDocumentsBy(
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

		override fun matchDocumentsBySorted(groupId: String, filter: SortableFilterOptionsJs<DocumentJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
			val result = documentApi.inGroup.matchDocumentsBySorted(
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

		override fun deleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.deleteDocumentById(
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
			val result = documentApi.inGroup.deleteDocumentsByIds(
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
			documentApi.inGroup.purgeDocumentById(
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
			val result = documentApi.inGroup.purgeDocumentsByIds(
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
			val result = documentApi.inGroup.deleteDocument(
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
			val result = documentApi.inGroup.deleteDocuments(
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
			documentApi.inGroup.purgeDocument(
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
			val result = documentApi.inGroup.purgeDocuments(
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

		override fun shareWith(
			`delegate`: EntityReferenceInGroupJs,
			document: GroupScopedJs<DecryptedDocumentJs>,
			options: dynamic,
		): Promise<GroupScopedJs<DecryptedDocumentJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(delegate)
				val documentConverted: GroupScoped<DecryptedDocument> = groupScoped_fromJs(
					document,
					{ x1: DecryptedDocumentJs ->
						document_fromJs(x1)
					},
				)
				val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: DocumentShareOptionsJs? ->
					options?.let { nonNull1 ->
						documentShareOptions_fromJs(nonNull1)
					}
				}
				val result = documentApi.inGroup.shareWith(
					delegateConverted,
					documentConverted,
					optionsConverted,
				)
				groupScoped_toJs(
					result,
					{ x1: DecryptedDocument ->
						document_toJs(x1)
					},
				)
			}
		}

		override fun shareWithMany(document: GroupScopedJs<DecryptedDocumentJs>,
				delegates: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
				Promise<GroupScopedJs<DecryptedDocumentJs>> = GlobalScope.promise {
			val documentConverted: GroupScoped<DecryptedDocument> = groupScoped_fromJs(
				document,
				{ x1: DecryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val delegatesConverted: Map<EntityReferenceInGroup, DocumentShareOptions> =
					EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions_fromJs(delegates)
			val result = documentApi.inGroup.shareWithMany(
				documentConverted,
				delegatesConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun filterDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
			val result = documentApi.inGroup.filterDocumentsBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterDocumentsBySorted(groupId: String,
				filter: SortableFilterOptionsJs<DocumentJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
			val result = documentApi.inGroup.filterDocumentsBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun createDocument(entity: GroupScopedJs<DecryptedDocumentJs>):
				Promise<GroupScopedJs<DecryptedDocumentJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedDocument> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.createDocument(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun createDocuments(entities: Array<GroupScopedJs<DecryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedDocument>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentApi.inGroup.createDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<DecryptedDocumentJs>> = GlobalScope.promise {
			val entityIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				entityId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.undeleteDocumentById(
				entityIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
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
			val result = documentApi.inGroup.undeleteDocumentsByIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteDocument(document: GroupScopedJs<DocumentJs>):
				Promise<GroupScopedJs<DecryptedDocumentJs>> = GlobalScope.promise {
			val documentConverted: GroupScoped<Document> = groupScoped_fromJs(
				document,
				{ x1: DocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.undeleteDocument(
				documentConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun undeleteDocuments(documents: Array<GroupScopedJs<DecryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val documentsConverted: List<GroupScoped<DecryptedDocument>> = arrayToList(
				documents,
				"documents",
				{ x1: GroupScopedJs<DecryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentApi.inGroup.undeleteDocuments(
				documentsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyDocument(entity: GroupScopedJs<DecryptedDocumentJs>):
				Promise<GroupScopedJs<DecryptedDocumentJs>> = GlobalScope.promise {
			val entityConverted: GroupScoped<DecryptedDocument> = groupScoped_fromJs(
				entity,
				{ x1: DecryptedDocumentJs ->
					document_fromJs(x1)
				},
			)
			val result = documentApi.inGroup.modifyDocument(
				entityConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: DecryptedDocument ->
					document_toJs(x1)
				},
			)
		}

		override fun modifyDocuments(entities: Array<GroupScopedJs<DecryptedDocumentJs>>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val entitiesConverted: List<GroupScoped<DecryptedDocument>> = arrayToList(
				entities,
				"entities",
				{ x1: GroupScopedJs<DecryptedDocumentJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: DecryptedDocumentJs ->
							document_fromJs(x2)
						},
					)
				},
			)
			val result = documentApi.inGroup.modifyDocuments(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}

		override fun getDocument(groupId: String, entityId: String):
				Promise<GroupScopedJs<DecryptedDocumentJs>?> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdConverted: String = entityId
			val result = documentApi.inGroup.getDocument(
				groupIdConverted,
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: DecryptedDocument ->
							document_toJs(x1)
						},
					)
				}
			)
		}

		override fun getDocuments(groupId: String, entityIds: Array<String>):
				Promise<Array<GroupScopedJs<DecryptedDocumentJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = documentApi.inGroup.getDocuments(
				groupIdConverted,
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<DecryptedDocument> ->
					groupScoped_toJs(
						x1,
						{ x2: DecryptedDocument ->
							document_toJs(x2)
						},
					)
				},
			)
		}
	}

	override fun withEncryptionMetadataLinkedToMessage(
		base: DecryptedDocumentJs?,
		message: MessageJs,
		options: dynamic,
	): Promise<DecryptedDocumentJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
				document_fromJs(nonNull1)
			}
			val messageConverted: Message = message_fromJs(message)
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
			val result = documentApi.withEncryptionMetadataLinkedToMessage(
				baseConverted,
				messageConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			document_toJs(result)
		}
	}

	override fun withEncryptionMetadataLinkedToPatient(
		base: DecryptedDocumentJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedDocumentJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
				document_fromJs(nonNull1)
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
			val result = documentApi.withEncryptionMetadataLinkedToPatient(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			document_toJs(result)
		}
	}

	override fun withEncryptionMetadataUnlinked(base: DecryptedDocumentJs?, options: dynamic):
			Promise<DecryptedDocumentJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedDocument? = base?.let { nonNull1 ->
				document_fromJs(nonNull1)
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
			val result = documentApi.withEncryptionMetadataUnlinked(
				baseConverted,
				userConverted,
				delegatesConverted,
				alternateRootDelegateIdConverted,
			)
			document_toJs(result)
		}
	}

	override fun getAndTryDecryptMainAttachment(document: DocumentJs, options: dynamic):
			Promise<ByteArray?> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? =
					convertingOptionOrDefaultNullable(
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
			val result = documentApi.getAndTryDecryptMainAttachment(
				documentConverted,
				decryptedAttachmentValidatorConverted,
			)
			nullToUndefined(
				result
			)
		}
	}

	override fun getAndDecryptMainAttachment(document: DocumentJs, options: dynamic):
			Promise<ByteArray> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? =
					convertingOptionOrDefaultNullable(
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
			val result = documentApi.getAndDecryptMainAttachment(
				documentConverted,
				decryptedAttachmentValidatorConverted,
			)
			result
		}
	}

	override fun encryptAndSetMainAttachment(
		document: DocumentJs,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = documentApi.encryptAndSetMainAttachment(
			documentConverted,
			utisConverted,
			attachmentConverted,
		)
		document_toJs(result)
	}

	override fun getAndDecryptSecondaryAttachment(
		document: DocumentJs,
		key: String,
		options: dynamic,
	): Promise<ByteArray> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val keyConverted: String = key
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? =
					convertingOptionOrDefaultNullable(
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
			val result = documentApi.getAndDecryptSecondaryAttachment(
				documentConverted,
				keyConverted,
				decryptedAttachmentValidatorConverted,
			)
			result
		}
	}

	override fun encryptAndSetSecondaryAttachment(
		document: DocumentJs,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<EncryptedDocumentJs> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val keyConverted: String = key
		val utisConverted: List<String>? = arrayToList(
			utis,
			"utis",
			{ x1: String ->
				x1
			},
		)
		val attachmentConverted: ByteArray = attachment
		val result = documentApi.encryptAndSetSecondaryAttachment(
			documentConverted,
			keyConverted,
			utisConverted,
			attachmentConverted,
		)
		document_toJs(result)
	}

	override fun getEncryptionKeysOf(document: DocumentJs): Promise<Array<String>> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.getEncryptionKeysOf(
			documentConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(document: DocumentJs): Promise<Boolean> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.hasWriteAccess(
			documentConverted,
		)
		result
	}

	override fun decryptOwningEntityIdsOf(document: DocumentJs):
			Promise<Array<EntityReferenceInGroupJs>> = GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.decryptOwningEntityIdsOf(
			documentConverted,
		)
		setToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: DocumentJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Document = document_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		documentApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(document: EncryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: EncryptedDocument = document_fromJs(document)
		val result = documentApi.decrypt(
			documentConverted,
		)
		document_toJs(result)
	}

	override fun tryDecrypt(document: EncryptedDocumentJs): Promise<DocumentJs> = GlobalScope.promise {
		val documentConverted: EncryptedDocument = document_fromJs(document)
		val result = documentApi.tryDecrypt(
			documentConverted,
		)
		document_toJs(result)
	}

	override fun tryDecryptAttachment(
		document: DocumentJs,
		encryptedAttachment: ByteArray,
		options: dynamic,
	): Promise<ByteArray?> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val documentConverted: Document = document_fromJs(document)
			val encryptedAttachmentConverted: ByteArray = encryptedAttachment
			val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? =
					convertingOptionOrDefaultNullable(
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
			val result = documentApi.tryDecryptAttachment(
				documentConverted,
				encryptedAttachmentConverted,
				decryptedAttachmentValidatorConverted,
			)
			nullToUndefined(
				result
			)
		}
	}

	override fun matchDocumentsBy(filter: FilterOptionsJs<DocumentJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
		val result = documentApi.matchDocumentsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
		val result = documentApi.matchDocumentsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteDocumentById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>
			= GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = documentApi.deleteDocumentById(
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
		val result = documentApi.deleteDocumentsByIds(
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
		documentApi.purgeDocumentById(
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
		val result = documentApi.purgeDocumentsByIds(
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
		val result = documentApi.deleteDocument(
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
		val result = documentApi.deleteDocuments(
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
		documentApi.purgeDocument(
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
		val result = documentApi.purgeDocuments(
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
		val result = documentApi.getRawMainAttachment(
			documentIdConverted,
		)
		result
	}

	override fun getRawSecondaryAttachment(documentId: String, key: String): Promise<ByteArray> =
			GlobalScope.promise {
		val documentIdConverted: String = documentId
		val keyConverted: String = key
		val result = documentApi.getRawSecondaryAttachment(
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
		val result = documentApi.setRawMainAttachment(
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
		val result = documentApi.setRawSecondaryAttachment(
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
		val result = documentApi.deleteMainAttachment(
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
		val result = documentApi.deleteSecondaryAttachment(
			documentIdConverted,
			keyConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun shareWith(
		delegateId: String,
		document: DecryptedDocumentJs,
		options: dynamic,
	): Promise<DecryptedDocumentJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val documentConverted: DecryptedDocument = document_fromJs(document)
			val optionsConverted: DocumentShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: DocumentShareOptionsJs? ->
				options?.let { nonNull1 ->
					documentShareOptions_fromJs(nonNull1)
				}
			}
			val result = documentApi.shareWith(
				delegateIdConverted,
				documentConverted,
				optionsConverted,
			)
			document_toJs(result)
		}
	}

	override fun shareWithMany(document: DecryptedDocumentJs,
			delegates: Record<String, DocumentShareOptionsJs>): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: DecryptedDocument = document_fromJs(document)
		val delegatesConverted: Map<String, DocumentShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: DocumentShareOptionsJs ->
				documentShareOptions_fromJs(x1)
			},
		)
		val result = documentApi.shareWithMany(
			documentConverted,
			delegatesConverted,
		)
		document_toJs(result)
	}

	override fun filterDocumentsBy(filter: FilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<DecryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Document> = filterOptions_fromJs(filter)
		val result = documentApi.filterDocumentsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun filterDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<DecryptedDocumentJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Document> = sortableFilterOptions_fromJs(filter)
		val result = documentApi.filterDocumentsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun createDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedDocument = document_fromJs(entity)
		val result = documentApi.createDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun createDocuments(entities: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedDocument> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentApi.createDocuments(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun undeleteDocumentById(id: String, rev: String): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = documentApi.undeleteDocumentById(
			idConverted,
			revConverted,
		)
		document_toJs(result)
	}

	override fun undeleteDocumentsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = documentApi.undeleteDocumentsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun undeleteDocument(document: DocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val documentConverted: Document = document_fromJs(document)
		val result = documentApi.undeleteDocument(
			documentConverted,
		)
		document_toJs(result)
	}

	override fun undeleteDocuments(documents: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val documentsConverted: List<DecryptedDocument> = arrayToList(
			documents,
			"documents",
			{ x1: DecryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentApi.undeleteDocuments(
			documentsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun modifyDocument(entity: DecryptedDocumentJs): Promise<DecryptedDocumentJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedDocument = document_fromJs(entity)
		val result = documentApi.modifyDocument(
			entityConverted,
		)
		document_toJs(result)
	}

	override fun modifyDocuments(entities: Array<DecryptedDocumentJs>):
			Promise<Array<DecryptedDocumentJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedDocument> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedDocumentJs ->
				document_fromJs(x1)
			},
		)
		val result = documentApi.modifyDocuments(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}

	override fun getDocument(entityId: String): Promise<DecryptedDocumentJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = documentApi.getDocument(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				document_toJs(nonNull1)
			}
		)
	}

	override fun getDocuments(entityIds: Array<String>): Promise<Array<DecryptedDocumentJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = documentApi.getDocuments(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedDocument ->
				document_toJs(x1)
			},
		)
	}
}
