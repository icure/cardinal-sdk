package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.generation.RequireHashable
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

// TODO maybe have sealed interface instead?
/**
 * A reference to an entity in a group.
 *
 * The entity group id can be null, which means the entity is in the same group as the user currently logged in to the
 * SDK.
 *
 * When providing input to any SDK method you can use references with the group of the logged user or null
 * interchangeably.
 *
 * However, some SDK methods that return [EntityReferenceInGroup] consistently fill the [groupId] of the logged user
 * while others consistently leave it null.
 * The general rule is that the methods from `inGroup` apis always fill all [groupId] values, even when the group
 * matches the current user's group. Methods that always act on the logged user's group instead always leave null
 * [groupId] when it would match the logged user's group.
 *
 * Note that `equals` methods can't take in consideration the group of the current user, therefore
 * `EntityReferenceInGroup(x, userGroup) != EntityReferenceInGroup(x, null)`, even though the SDK for a user in
 * userGroup treats them the same.
 *
 * @param entityId the id of the entity
 * @param groupId the id of the entity's group. If null it should be interpreted as the same group of the logged user.
 */
@Serializable
@RequireHashable
data class EntityReferenceInGroup(
	val entityId: String,
	@param:DefaultValue("null")
	val groupId: String? = null
) {
	/**
	 * @param inGroup the group where the reference is to be used
	 * @param sdkGroupId the group id of the SDK using this reference, used as the default group if [groupId] is null
	 */
	@InternalIcureApi
	internal fun asReferenceStringInGroup(inGroup: String?, sdkGroupId: SdkBoundGroup?): String {
		if (sdkGroupId == null) require(inGroup == null) { "Can't use in-group methods on kraken-lite" }
		val thisGroup = groupId ?: sdkGroupId?.groupId
		val forGroup = inGroup ?: sdkGroupId?.groupId
		return if (thisGroup != forGroup) "$thisGroup/$entityId" else entityId
	}

	/**
	 * If this reference is in the same group as [sdkGroupId], returns a reference with null groupId.
	 */
	@InternalIcureApi
	internal fun normalized(sdkGroupId: SdkBoundGroup?): EntityReferenceInGroup {
		if (sdkGroupId == null) require(groupId == null) { "Can't use in-group references on kraken-lite" }
		return if (groupId != null && groupId == sdkGroupId?.groupId) EntityReferenceInGroup(
			entityId,
			null
		) else this
	}

	companion object {
		@InternalIcureApi
		internal fun parse(
			dataOwnerReference: String,
			entityGroup: String?,
			sdkGroupId: SdkBoundGroup?
		): EntityReferenceInGroup {
			val splitReference = dataOwnerReference.split("/")
			val resolvedEntityGroup = sdkGroupId.resolve(entityGroup)
			require(splitReference.size == 1 || splitReference.size == 2) {
				"Invalid user reference $dataOwnerReference"
			}
			return if (resolvedEntityGroup != null) {
				when {
					splitReference.size == 1 -> EntityReferenceInGroup(
						entityId = splitReference[0],
						groupId = resolvedEntityGroup
					)
					splitReference[0] == sdkGroupId.groupId -> EntityReferenceInGroup(
						entityId = splitReference[1],
						groupId = null
					)
					else -> EntityReferenceInGroup(
						entityId = splitReference[1],
						groupId = splitReference[0]
					)
				}
			} else {
				if (splitReference.size == 1)
					EntityReferenceInGroup(entityId = splitReference[0])
				else
					EntityReferenceInGroup(
						entityId = splitReference[1],
						groupId = splitReference[0]
					)
			}
		}
	}
}
