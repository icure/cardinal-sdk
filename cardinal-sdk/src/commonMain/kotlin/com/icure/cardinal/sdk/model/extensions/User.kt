package com.icure.cardinal.sdk.model.extensions

import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.utils.InternalIcureApi

/**
 * Get the data owner id of the user.
 * @throws IllegalArgumentException if the user is not a data owner.
 */
@InternalIcureApi
val User.dataOwnerId get() =
	requireNotNull(healthcarePartyId ?: patientId ?: deviceId) {
		"User ${this.id} must be a data owner but does not have a data owner id - $this"
	}

@InternalIcureApi
internal fun User.autoDelegationsFor(
	vararg tags: DelegationTag,
	includeTagAll: Boolean = true,
): Map<String, DelegateOptions> {
	val allTags = if (includeTagAll) setOf(DelegationTag.All, *tags) else tags.toSet()
	return allTags.flatMapTo(mutableSetOf()) { tag ->
		autoDelegations[tag] ?: emptySet()
	}.associateWith {
		AccessLevel.Write.toDefaultDelegateOptions()
	}
}

@InternalIcureApi
internal fun AccessLevel.toDefaultDelegateOptions(): DelegateOptions = object : DelegateOptions {
	override val accessLevel: AccessLevel
		get() = this@toDefaultDelegateOptions
	override val shareEncryptionKey: Boolean
		get() = true
	override val shareSecretId: Boolean
		get() = true
	override val shareOwningEntityId: Boolean
		get() = true
}
