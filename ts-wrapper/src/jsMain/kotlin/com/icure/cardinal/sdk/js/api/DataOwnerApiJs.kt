// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.base.DataOwnerHierarchyInfoJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DataOwnerApi")
public external interface DataOwnerApiJs {
	public fun getCurrentDataOwner(): Promise<DataOwnerWithTypeJs>

	public fun getCurrentDataOwnerStub(): Promise<CryptoActorStubWithTypeJs>

	public fun getCurrentDataOwnerId(): Promise<String>

	public fun getCurrentDataOwnerReference(): Promise<EntityReferenceInGroupJs>

	public fun getCurrentDataOwnerHierarchyInfo(): Promise<DataOwnerHierarchyInfoJs>

	public fun getDataOwner(ownerId: String): Promise<DataOwnerWithTypeJs>

	public fun getDataOwners(ids: Array<String>): Promise<Array<DataOwnerWithTypeJs>>

	public fun getDataOwnersWithKnownType(ids: Array<String>, type: String):
			Promise<Array<DataOwnerWithTypeJs>>

	public fun getCryptoActorStub(ownerId: String): Promise<CryptoActorStubWithTypeJs>

	public fun getCryptoActorStubs(ids: Array<String>): Promise<Array<CryptoActorStubWithTypeJs>>

	public fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroupJs):
			Promise<CryptoActorStubWithTypeJs>

	public fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithTypeJs):
			Promise<CryptoActorStubWithTypeJs>

	public fun getCurrentDataOwnerType(): Promise<String>

	public fun clearCurrentDataOwnerHierarchyCache()

	public fun getSimpleGroupDelegateMembersIds(dataOwnerGroup: CryptoActorStubWithTypeJs,
			groupId: String?): Promise<Array<String>>

	public fun getDataOwnersPublicKeys(
		dataOwnerType: String,
		dataOwners: Array<String>,
		groupId: String?,
	): Promise<Record<String, Record<String, String>>>
}
