// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.js.api.DataOwnerApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_fromJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.cardinal.sdk.js.model.dataOwnerWithType_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class DataOwnerApiImplJs(
	private val dataOwnerApi: DataOwnerApi,
) : DataOwnerApiJs {
	override fun getCurrentDataOwner(): Promise<DataOwnerWithTypeJs> = GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwner(
		)
		dataOwnerWithType_toJs(result)
	}

	override fun getCurrentDataOwnerStub(): Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerStub(
		)
		cryptoActorStubWithType_toJs(result)
	}

	override fun getCurrentDataOwnerId(): Promise<String> = GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerId(
		)
		result
	}

	override fun getCurrentDataOwnerReference(): Promise<EntityReferenceInGroupJs> =
			GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerReference(
		)
		entityReferenceInGroup_toJs(result)
	}

	override fun getCurrentDataOwnerHierarchyIds(): Promise<Array<String>> = GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerHierarchyIds(
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getCurrentDataOwnerHierarchyIdsReference(): Promise<Array<EntityReferenceInGroupJs>> =
			GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerHierarchyIdsReference(
		)
		listToArray(
			result,
			{ x1: EntityReferenceInGroup ->
				entityReferenceInGroup_toJs(x1)
			},
		)
	}

	override fun getDataOwner(ownerId: String): Promise<DataOwnerWithTypeJs> = GlobalScope.promise {
		val ownerIdConverted: String = ownerId
		val result = dataOwnerApi.getDataOwner(
			ownerIdConverted,
		)
		dataOwnerWithType_toJs(result)
	}

	override fun getCryptoActorStub(ownerId: String): Promise<CryptoActorStubWithTypeJs> =
			GlobalScope.promise {
		val ownerIdConverted: String = ownerId
		val result = dataOwnerApi.getCryptoActorStub(
			ownerIdConverted,
		)
		cryptoActorStubWithType_toJs(result)
	}

	override fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroupJs):
			Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
		val entityReferenceInGroupConverted: EntityReferenceInGroup =
				entityReferenceInGroup_fromJs(entityReferenceInGroup)
		val result = dataOwnerApi.getCryptoActorStubInGroup(
			entityReferenceInGroupConverted,
		)
		cryptoActorStubWithType_toJs(result)
	}

	override fun getCurrentDataOwnerHierarchyIdsFrom(parentId: String): Promise<Array<String>> =
			GlobalScope.promise {
		val parentIdConverted: String = parentId
		val result = dataOwnerApi.getCurrentDataOwnerParentHierarchy(
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getCurrentDataOwnerHierarchy(): Promise<Array<DataOwnerWithTypeJs>> =
			GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerHierarchy(
		)
		listToArray(
			result,
			{ x1: DataOwnerWithType ->
				dataOwnerWithType_toJs(x1)
			},
		)
	}

	override fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithTypeJs):
			Promise<CryptoActorStubWithTypeJs> = GlobalScope.promise {
		val cryptoActorStubWithTypeDtoConverted: CryptoActorStubWithType =
				cryptoActorStubWithType_fromJs(cryptoActorStubWithTypeDto)
		val result = dataOwnerApi.modifyDataOwnerStub(
			cryptoActorStubWithTypeDtoConverted,
		)
		cryptoActorStubWithType_toJs(result)
	}

	override fun getCurrentDataOwnerType(): Promise<String> = GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerType(
		)
		result.name
	}

	override fun clearCurrentDataOwnerIdsCache(): Unit = dataOwnerApi.clearCurrentDataOwnerIdsCache(
	)
}
