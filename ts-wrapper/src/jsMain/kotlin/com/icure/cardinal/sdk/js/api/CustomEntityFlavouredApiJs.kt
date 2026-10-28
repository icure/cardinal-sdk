// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.CustomEntityShareOptionsJs
import com.icure.cardinal.sdk.js.model.CustomEntityBaseJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CustomEntityFlavouredApi")
public external interface CustomEntityFlavouredApiJs<E : CustomEntityBaseJs> {
	public fun shareWith(
		delegateId: String,
		entity: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(entity: E, delegates: Record<String, CustomEntityShareOptionsJs>): Promise<E>

	public fun createEntity(entity: E): Promise<E>

	public fun createEntities(entities: Array<E>): Promise<Array<E>>

	public fun undeleteEntityById(id: String, rev: String): Promise<E>

	public fun undeleteEntitiesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteEntity(entity: CustomEntityBaseJs): Promise<E>

	public fun undeleteEntities(entities: Array<CustomEntityBaseJs>): Promise<Array<E>>

	public fun modifyEntity(entity: E): Promise<E>

	public fun modifyEntities(entities: Array<E>): Promise<Array<E>>

	public fun getEntity(entityId: String): Promise<E?>

	public fun getEntities(entityIds: Array<String>): Promise<Array<E>>

	public fun setRawAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
		encrypted: Boolean,
	): Promise<E>

	public fun setAttachment(
		entityId: String,
		rev: String,
		key: String,
		utis: Array<String>?,
		attachment: ByteArray,
	): Promise<E>

	public fun deleteAttachment(
		entityId: String,
		rev: String,
		key: String,
	): Promise<E>
}
