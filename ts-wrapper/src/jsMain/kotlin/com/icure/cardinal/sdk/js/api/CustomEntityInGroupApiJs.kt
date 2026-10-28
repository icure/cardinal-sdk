// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.DecryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EncryptedCustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityInGroupApi")
public external interface CustomEntityInGroupApiJs {
	public val encrypted: CustomEntityFlavouredInGroupApiJs<EncryptedCustomEntityBaseJs>

	public val tryAndRecover: CustomEntityFlavouredInGroupApiJs<CustomEntityBaseJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedCustomEntityBaseJs?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun withEncryptionMetadataAndDelegates(
		entityGroupId: String,
		base: DecryptedCustomEntityBaseJs?,
		delegates: Array<EntityReferenceInGroupToCustomEntityDelegateOptionsMapObject_delegate_delegateOptions>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun getEncryptionKeysOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Array<String>>

	public fun getSecretIdsOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Record<String, Array<EntityReferenceInGroupJs>>>

	public fun hasWriteAccess(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Boolean>

	public fun decryptOwningEntityIdsOf(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<CustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>

	public fun tryDecrypt(entities: Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<CustomEntityBaseJs>>>

	public fun encryptOrValidate(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<EncryptedCustomEntityBaseJs>>>

	public fun deleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<Unit>

	public fun purgeEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun getDataOwnersWithAccessTo(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<EntityAccessInformationJs>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		entity: GroupScopedJs<DecryptedCustomEntityBaseJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun shareWithMany(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>, delegates: Array<EntityReferenceInGroupToCustomEntityShareOptionsMapObject_delegate_shareOptions>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun createEntity(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun createEntities(entities: Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>

	public fun undeleteEntityById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun undeleteEntitiesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>

	public fun undeleteEntity(entity: GroupScopedJs<CustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun undeleteEntities(entities: Array<GroupScopedJs<CustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>

	public fun modifyEntity(entity: GroupScopedJs<DecryptedCustomEntityBaseJs>): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>>

	public fun modifyEntities(entities: Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>

	public fun getEntity(groupId: String, entityId: String): Promise<GroupScopedJs<DecryptedCustomEntityBaseJs>?>

	public fun getEntities(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<DecryptedCustomEntityBaseJs>>>
}
