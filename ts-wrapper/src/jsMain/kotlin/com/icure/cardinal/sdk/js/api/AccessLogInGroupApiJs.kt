// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AccessLogJs
import com.icure.cardinal.sdk.js.model.DecryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EncryptedAccessLogJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AccessLogInGroupApi")
public external interface AccessLogInGroupApiJs {
	public val encrypted: AccessLogFlavouredInGroupApiJs<EncryptedAccessLogJs>

	public val tryAndRecover: AccessLogFlavouredInGroupApiJs<AccessLogJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedAccessLogJs?,
		patient: GroupScopedJs<PatientJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedAccessLogJs>>

	public fun getEncryptionKeysOf(accessLog: GroupScopedJs<AccessLogJs>): Promise<Array<String>>

	public fun hasWriteAccess(accessLog: GroupScopedJs<AccessLogJs>): Promise<Boolean>

	public fun decryptPatientIdOf(accessLog: GroupScopedJs<AccessLogJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<AccessLogJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(accessLogs: Array<GroupScopedJs<EncryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>

	public fun tryDecrypt(accessLogs: Array<GroupScopedJs<EncryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<AccessLogJs>>>

	public fun matchAccessLogsBy(groupId: String, filter: FilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun matchAccessLogsBySorted(groupId: String, filter: SortableFilterOptionsJs<AccessLogJs>):
			Promise<Array<String>>

	public fun deleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeAccessLog(accessLog: GroupScopedJs<AccessLogJs>): Promise<Unit>

	public fun purgeAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createAccessLog(entity: GroupScopedJs<DecryptedAccessLogJs>):
			Promise<GroupScopedJs<DecryptedAccessLogJs>>

	public fun createAccessLogs(entities: Array<GroupScopedJs<DecryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>

	public fun undeleteAccessLogById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedAccessLogJs>>

	public fun undeleteAccessLogsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>

	public fun undeleteAccessLog(accessLog: GroupScopedJs<AccessLogJs>):
			Promise<GroupScopedJs<DecryptedAccessLogJs>>

	public fun undeleteAccessLogs(accessLogs: Array<GroupScopedJs<AccessLogJs>>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>

	public fun modifyAccessLog(entity: GroupScopedJs<DecryptedAccessLogJs>):
			Promise<GroupScopedJs<DecryptedAccessLogJs>>

	public fun modifyAccessLogs(entities: Array<GroupScopedJs<DecryptedAccessLogJs>>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>

	public fun getAccessLog(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedAccessLogJs>?>

	public fun getAccessLogs(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedAccessLogJs>>>
}
