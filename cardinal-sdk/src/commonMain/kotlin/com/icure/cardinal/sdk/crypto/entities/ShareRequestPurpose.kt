package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.Serializable

/**
 * What a single share-or-metadata-update request the sdk sent was actually for. Sharing an entity may require the sdk
 * to also migrate the pre-existing legacy delegations of the data owners of the current hierarchy to the current
 * secure-delegation format, and those migrations travel as requests of their own - sometimes merged with a request
 * the caller asked for.
 */
@Serializable
enum class ShareRequestPurpose {
	/**
	 * The request was only about the sharing the caller asked for.
	 */
	RequestedShare,

	/**
	 * The request was only about migrating the legacy delegations of a data owner of the current hierarchy: the caller
	 * did not ask to share with that data owner at all. The outcome of such a request says nothing about the sharing
	 * the caller did ask for.
	 */
	Migration,

	/**
	 * The request did both: the caller asked to share with a data owner whose legacy delegations also needed to be
	 * migrated, and the sdk merged the two into a single request. The requested sharing was NOT left out of it, so for
	 * everything that concerns the caller this behaves exactly like a [RequestedShare].
	 */
	RequestedShareAndMigration
}
