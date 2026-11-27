package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.raw.RawDataOwnerApi
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal object DataOwnerApiHelpers {
	suspend fun RawDataOwnerApi.doAddDataOwnersToGroup(
		dataOwnerType: DataOwnerType,
		dataOwnerGroupId: String,
		newMembersIds: Set<String>,
	): Set<String> =
		addDataOwnersToGroup(
			dataOwnerGroupId,
			dataOwnerType.dtoSerialName,
			ListOfIds(newMembersIds.toList())
		).successBody().toSet()

	suspend fun RawDataOwnerApi.doRemoveDataOwnersFromGroup(
		dataOwnerType: DataOwnerType,
		dataOwnerGroupId: String,
		membersToRemoveIds: Set<String>,
	): Set<String> =
		removeDataOwnersFromGroup(
			dataOwnerGroupId,
			dataOwnerType.dtoSerialName,
			true,
			ListOfIds(membersToRemoveIds.toList()),
		).successBody().toSet()
}