// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Interface for entities that participate in the iCure end-to-end encryption system.
 *  A CryptoActor holds the cryptographic keys and key exchange material needed for secure data
 * sharing.
 */

interface CryptoActor : Versionable<String> {
	public val hcPartyKeys: Map<String, List<HexString>>

	public val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	public val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	public val privateKeyShamirPartitions: Map<String, HexString>

	public val publicKey: SpkiHexString?

	public val publicKeysForOaepWithSha256: Set<SpkiHexString>

	/**
	 *
	 *  The links to the data owners representing the organizations, administrative units or other
	 * loose groups of
	 *  healthcare parties this crypto actor belongs to.
	 *  There are different types of links, which have different implication on access control and
	 * requirements for
	 *  sharing data among all members of the group.
	 *
	 *  This list should be considered as unordered, and it may not contain two links pointing to the
	 * same data owner,
	 *  regardless of type.
	 *
	 *  # Membership propagation
	 *
	 *  All links are transitive, whatever their type: every directly linked group is a group of the
	 * actor, and the groups
	 *  of a group are also groups of the actor (applied recursively). An actor is therefore a member
	 * of every group
	 *  reachable through a path of links.
	 *
	 *  For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 * `hcp` are
	 *  `department`, `building` and `campus`.
	 *
	 *  There may however be restrictions in place on how propagation when the link type changes:
	 * propagation from a
	 *  parent link to a simple link is allowed, but the opposite is not.
	 *  A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is
	 * not allowed: while
	 *  the relationships of `building` are technically valid the full membership for `department` or
	 * `hcp` is invalid,
	 *  and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 *  # Why groups instead of direct sharing with members
	 *
	 *  By using groups of data owners instead of directly sharing data with each data owner in a group
	 * you gain two
	 *  major advantages:
	 *  - Reduced size of metadata on entities
	 *  - Possibility of dynamically adding peoples to a group without having to update all the
	 * entities that they should
	 *    be able to access
	 *
	 *  In a full-scale system where data is massively shared between groups of users using data owner
	 * groups is the
	 *  only realistic choice available.
	 */
	public val dataOwnerGroups: List<DataOwnerGroupLink>

	/**
	 * The links to the data owners representing the organizations, administrative units or other loose
	 * groups of
	 * healthcare parties this crypto actor belongs to.
	 * There are different types of links, which have different implication on access control and
	 * requirements for
	 * sharing data among all members of the group.
	 *
	 * This list should be considered as unordered, and it may not contain two links pointing to the
	 * same data owner,
	 * regardless of type.
	 *
	 * # Membership propagation
	 *
	 * All links are transitive, whatever their type: every directly linked group is a group of the
	 * actor, and the groups
	 * of a group are also groups of the actor (applied recursively). An actor is therefore a member of
	 * every group
	 * reachable through a path of links.
	 *
	 * For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 * `hcp` are
	 * `department`, `building` and `campus`.
	 *
	 * There may however be restrictions in place on how propagation when the link type changes:
	 * propagation from a
	 * parent link to a simple link is allowed, but the opposite is not.
	 * A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is not
	 * allowed: while
	 * the relationships of `building` are technically valid the full membership for `department` or
	 * `hcp` is invalid,
	 * and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 * # Why groups instead of direct sharing with members
	 *
	 * By using groups of data owners instead of directly sharing data with each data owner in a group
	 * you gain two
	 * major advantages:
	 * - Reduced size of metadata on entities
	 * - Possibility of dynamically adding peoples to a group without having to update all the entities
	 * that they should
	 * be able to access
	 *
	 * In a full-scale system where data is massively shared between groups of users using data owner
	 * groups is the
	 * only realistic choice available.
	 * /
	 */
	public val groupLinkType: DataOwnerGroupLinkType?

	/**
	 * The links to the data owners representing the organizations, administrative units or other loose
	 * groups of
	 * healthcare parties this crypto actor belongs to.
	 * There are different types of links, which have different implication on access control and
	 * requirements for
	 * sharing data among all members of the group.
	 *
	 * This list should be considered as unordered, and it may not contain two links pointing to the
	 * same data owner,
	 * regardless of type.
	 *
	 * # Membership propagation
	 *
	 * All links are transitive, whatever their type: every directly linked group is a group of the
	 * actor, and the groups
	 * of a group are also groups of the actor (applied recursively). An actor is therefore a member of
	 * every group
	 * reachable through a path of links.
	 *
	 * For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 * `hcp` are
	 * `department`, `building` and `campus`.
	 *
	 * There may however be restrictions in place on how propagation when the link type changes:
	 * propagation from a
	 * parent link to a simple link is allowed, but the opposite is not.
	 * A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is not
	 * allowed: while
	 * the relationships of `building` are technically valid the full membership for `department` or
	 * `hcp` is invalid,
	 * and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 * # Why groups instead of direct sharing with members
	 *
	 * By using groups of data owners instead of directly sharing data with each data owner in a group
	 * you gain two
	 * major advantages:
	 * - Reduced size of metadata on entities
	 * - Possibility of dynamically adding peoples to a group without having to update all the entities
	 * that they should
	 * be able to access
	 *
	 * In a full-scale system where data is massively shared between groups of users using data owner
	 * groups is the
	 * only realistic choice available.
	 * /
	 */
	public val cryptoActorProperties: Set<DecryptedPropertyStub>?
	// region CryptoActor-CryptoActor

	// endregion
}
