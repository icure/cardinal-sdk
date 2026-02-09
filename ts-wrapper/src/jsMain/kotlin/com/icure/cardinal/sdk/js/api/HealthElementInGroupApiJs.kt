// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementInGroupApi")
public external interface HealthElementInGroupApiJs {
	public val encrypted: HealthElementFlavouredInGroupApiJs<EncryptedHealthElementJs>

	public val tryAndRecover: HealthElementFlavouredInGroupApiJs<HealthElementJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedHealthElementJs?,
		patient: GroupScopedJs<PatientJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun getEncryptionKeysOf(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<Array<String>>

	public fun hasWriteAccess(healthElement: GroupScopedJs<HealthElementJs>): Promise<Boolean>

	public fun decryptPatientIdOf(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<HealthElementJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun tryDecrypt(healthElements: Array<GroupScopedJs<EncryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<HealthElementJs>>>

	public fun encryptOrValidate(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<EncryptedHealthElementJs>>>

	public fun matchHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
			Promise<Array<String>>

	public fun matchHealthElementsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<HealthElementJs>): Promise<Array<String>>

	public fun deleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeHealthElement(healthElement: GroupScopedJs<HealthElementJs>): Promise<Unit>

	public fun purgeHealthElements(healthElements: Array<GroupScopedJs<HealthElementJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		healthElement: GroupScopedJs<DecryptedHealthElementJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun shareWithMany(healthElement: GroupScopedJs<DecryptedHealthElementJs>,
			delegates: Array<EntityReferenceInGroupToHealthElementShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun filterHealthElementsBy(groupId: String, filter: FilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun filterHealthElementsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun createHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun createHealthElements(entities: Array<GroupScopedJs<DecryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun undeleteHealthElementById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public
			fun undeleteHealthElementsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun undeleteHealthElement(healthElement: GroupScopedJs<HealthElementJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun undeleteHealthElements(healthElements: Array<GroupScopedJs<DecryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun modifyHealthElement(entity: GroupScopedJs<DecryptedHealthElementJs>):
			Promise<GroupScopedJs<DecryptedHealthElementJs>>

	public fun modifyHealthElements(entities: Array<GroupScopedJs<DecryptedHealthElementJs>>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>

	public fun getHealthElement(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedHealthElementJs>?>

	public fun getHealthElements(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedHealthElementJs>>>
}
