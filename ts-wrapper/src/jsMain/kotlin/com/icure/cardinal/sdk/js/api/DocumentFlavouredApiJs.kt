// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.DocumentShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentFlavouredApi")
public external interface DocumentFlavouredApiJs<E : DocumentJs> {
	public fun shareWith(
		delegateId: String,
		document: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(document: E, delegates: Record<String, DocumentShareOptionsJs>):
			Promise<E>

	public fun findDocumentsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterDocumentsBy(filter: FilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterDocumentsBySorted(filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun undeleteDocumentById(id: String, rev: String): Promise<E>

	public fun undeleteDocument(document: DocumentJs): Promise<E>

	public fun modifyDocument(entity: E): Promise<E>

	public fun getDocument(entityId: String): Promise<E>

	public fun getDocumentByExternalUuid(externalUuid: String): Promise<E>

	public fun getDocumentsByExternalUuid(externalUuid: String): Promise<Array<E>>

	public fun getDocuments(entityIds: Array<String>): Promise<Array<E>>

	public fun modifyDocuments(entities: Array<E>): Promise<Array<E>>

	public fun listDocumentsByHcPartyMessageForeignKeys(
		hcPartyId: String,
		documentTypeCode: String?,
		secretMessageKeys: Array<String>,
	): Promise<Array<E>>

	public fun findWithoutDelegation(limit: Double?): Promise<Array<E>>
}
