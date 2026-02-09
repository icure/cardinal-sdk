// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.DecryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogApi")
public external interface AccessLogApiJs {
	public val encrypted: AccessLogFlavouredApiJs<EncryptedAccessLogJs>

	public val tryAndRecover: AccessLogFlavouredApiJs<AccessLogJs>

	public val inGroup: AccessLogInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedAccessLogJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedAccessLogJs>

	public fun getEncryptionKeysOf(accessLog: AccessLogJs): Promise<Array<String>>

	public fun hasWriteAccess(accessLog: AccessLogJs): Promise<Boolean>

	public fun decryptPatientIdOf(accessLog: AccessLogJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: AccessLogJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(accessLog: EncryptedAccessLogJs): Promise<DecryptedAccessLogJs>

	public fun tryDecrypt(accessLog: EncryptedAccessLogJs): Promise<AccessLogJs>

	public fun matchAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>): Promise<Array<String>>

	public fun matchAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun deleteAccessLogById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAccessLogById(id: String, rev: String): Promise<Unit>

	public fun purgeAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteAccessLog(accessLog: AccessLogJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeAccessLog(accessLog: AccessLogJs): Promise<Unit>

	public fun purgeAccessLogs(accessLogs: Array<AccessLogJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		accessLog: DecryptedAccessLogJs,
		options: dynamic,
	): Promise<DecryptedAccessLogJs>

	public fun shareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>): Promise<DecryptedAccessLogJs>

	public fun filterAccessLogsBy(filter: FilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>>

	public fun filterAccessLogsBySorted(filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>>

	public fun createAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs>

	public fun createAccessLogs(entities: Array<DecryptedAccessLogJs>):
			Promise<Array<DecryptedAccessLogJs>>

	public fun undeleteAccessLogById(id: String, rev: String): Promise<DecryptedAccessLogJs>

	public fun undeleteAccessLogsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedAccessLogJs>>

	public fun undeleteAccessLog(accessLog: AccessLogJs): Promise<DecryptedAccessLogJs>

	public fun undeleteAccessLogs(accessLogs: Array<AccessLogJs>): Promise<Array<DecryptedAccessLogJs>>

	public fun modifyAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs>

	public fun modifyAccessLogs(entities: Array<DecryptedAccessLogJs>):
			Promise<Array<DecryptedAccessLogJs>>

	public fun getAccessLog(entityId: String): Promise<DecryptedAccessLogJs?>

	public fun getAccessLogs(entityIds: Array<String>): Promise<Array<DecryptedAccessLogJs>>
}
