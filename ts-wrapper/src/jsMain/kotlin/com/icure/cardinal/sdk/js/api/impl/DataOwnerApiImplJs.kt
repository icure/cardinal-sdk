// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.js.api.DataOwnerApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.base.DataOwnerHierarchyInfoJs
import com.icure.cardinal.sdk.js.model.base.dataOwnerHierarchyInfo_toJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_fromJs
import com.icure.cardinal.sdk.js.model.cryptoActorStubWithType_toJs
import com.icure.cardinal.sdk.js.model.dataOwnerWithType_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_toJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.collections.Set
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

	override fun getCurrentDataOwnerHierarchyInfo(): Promise<DataOwnerHierarchyInfoJs> =
			GlobalScope.promise {
		val result = dataOwnerApi.getCurrentDataOwnerHierarchyInfo(
		)
		dataOwnerHierarchyInfo_toJs(result)
	}

	override fun getDataOwner(ownerId: String): Promise<DataOwnerWithTypeJs> = GlobalScope.promise {
		val ownerIdConverted: String = ownerId
		val result = dataOwnerApi.getDataOwner(
			ownerIdConverted,
		)
		dataOwnerWithType_toJs(result)
	}

	override fun getDataOwners(ids: Array<String>): Promise<Array<DataOwnerWithTypeJs>> =
			GlobalScope.promise {
		val idsConverted: Set<String> = arrayToSet(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = dataOwnerApi.getDataOwners(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: DataOwnerWithType ->
				dataOwnerWithType_toJs(x1)
			},
		)
	}

	override fun getDataOwnersWithKnownType(ids: Array<String>, type: String):
			Promise<Array<DataOwnerWithTypeJs>> = GlobalScope.promise {
		val idsConverted: Set<String> = arrayToSet(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val typeConverted: DataOwnerType = DataOwnerType.valueOf(type)
		val result = dataOwnerApi.getDataOwnersWithKnownType(
			idsConverted,
			typeConverted,
		)
		listToArray(
			result,
			{ x1: DataOwnerWithType ->
				dataOwnerWithType_toJs(x1)
			},
		)
	}

	override fun getCryptoActorStub(ownerId: String): Promise<CryptoActorStubWithTypeJs> =
			GlobalScope.promise {
		val ownerIdConverted: String = ownerId
		val result = dataOwnerApi.getCryptoActorStub(
			ownerIdConverted,
		)
		cryptoActorStubWithType_toJs(result)
	}

	override fun getCryptoActorStubs(ids: Array<String>): Promise<Array<CryptoActorStubWithTypeJs>> =
			GlobalScope.promise {
		val idsConverted: Set<String> = arrayToSet(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = dataOwnerApi.getCryptoActorStubs(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: CryptoActorStubWithType ->
				cryptoActorStubWithType_toJs(x1)
			},
		)
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

	override fun clearCurrentDataOwnerHierarchyCache(): Unit =
			dataOwnerApi.clearCurrentDataOwnerHierarchyCache(
	)

	override fun getSimpleGroupDelegateMembersIds(dataOwnerGroup: CryptoActorStubWithTypeJs,
			groupId: String?): Promise<Array<String>> = GlobalScope.promise {
		val dataOwnerGroupConverted: CryptoActorStubWithType =
				cryptoActorStubWithType_fromJs(dataOwnerGroup)
		val groupIdConverted: String? = undefinedToNull(groupId)
		val result = dataOwnerApi.getSimpleGroupDelegateMembersIds(
			dataOwnerGroupConverted,
			groupIdConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getDataOwnersPublicKeys(
		dataOwnerType: String,
		dataOwners: Array<String>,
		groupId: String?,
	): Promise<Record<String, Record<String, String>>> = GlobalScope.promise {
		val dataOwnerTypeConverted: DataOwnerType = DataOwnerType.valueOf(dataOwnerType)
		val dataOwnersConverted: Set<String> = arrayToSet(
			dataOwners,
			"dataOwners",
			{ x1: String ->
				x1
			},
		)
		val groupIdConverted: String? = undefinedToNull(groupId)
		val result = dataOwnerApi.getDataOwnersPublicKeys(
			dataOwnerTypeConverted,
			dataOwnersConverted,
			groupIdConverted,
		)
		mapToObject(
			result,
			{ x1: String ->
				x1
			},
			{ x1: Map<SpkiHexString, RsaAlgorithm.RsaEncryptionAlgorithm> ->
				mapToObject(
					x1,
					{ x2: SpkiHexString ->
						spkiHexString_toJs(x2)
					},
					{ x2: RsaAlgorithm.RsaEncryptionAlgorithm ->
						x2.identifier
					},
				)
			},
		)
	}
}
