// auto-generated file
import {CryptoActorStub} from '../CryptoActorStub.mjs';
import {Device} from '../Device.mjs';
import {HealthcareParty} from '../HealthcareParty.mjs';
import {DecryptedPatient, EncryptedPatient} from '../Patient.mjs';
import {DecryptedPropertyStub} from '../PropertyStub.mjs';
import {HexString} from '../specializations/HexString.mjs';
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';
import {DataOwnerGroupLink} from './DataOwnerGroupLink.mjs';
import {DataOwnerGroupLinkType} from './DataOwnerGroupLinkType.mjs';
import {Versionable} from './Versionable.mjs';


/**
 *
 *
 *   Interface for entities that participate in the iCure end-to-end encryption system.
 *   A CryptoActor holds the cryptographic keys and key exchange material needed for secure data
 *  sharing.
 */
export interface CryptoActor extends Versionable<string> {

	hcPartyKeys: { [ key: string ]: Array<HexString> };

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } };

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } };

	privateKeyShamirPartitions: { [ key: string ]: HexString };

	publicKey: SpkiHexString | undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	/**
	 *
	 *
	 *   The links to the data owners representing the organizations, administrative units or other
	 *  loose groups of
	 *   healthcare parties this crypto actor belongs to.
	 *   There are different types of links, which have different implication on access control and
	 *  requirements for
	 *   sharing data among all members of the group.
	 *
	 *   This list should be considered as unordered, and it may not contain two links pointing to the
	 *  same data owner,
	 *   regardless of type.
	 *
	 *   # Membership propagation
	 *
	 *   All links are transitive, whatever their type: every directly linked group is a group of the
	 *  actor, and the groups
	 *   of a group are also groups of the actor (applied recursively). An actor is therefore a member
	 *  of every group
	 *   reachable through a path of links.
	 *
	 *   For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 *  `hcp` are
	 *   `department`, `building` and `campus`.
	 *
	 *   There may however be restrictions in place on how propagation when the link type changes:
	 *  propagation from a
	 *   parent link to a simple link is allowed, but the opposite is not.
	 *   A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is
	 *  not allowed: while
	 *   the relationships of `building` are technically valid the full membership for `department` or
	 *  `hcp` is invalid,
	 *   and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 *   # Why groups instead of direct sharing with members
	 *
	 *   By using groups of data owners instead of directly sharing data with each data owner in a group
	 *  you gain two
	 *   major advantages:
	 *   - Reduced size of metadata on entities
	 *   - Possibility of dynamically adding peoples to a group without having to update all the
	 *  entities that they should
	 *     be able to access
	 *
	 *   In a full-scale system where data is massively shared between groups of users using data owner
	 *  groups is the
	 *   only realistic choice available.
	 */
	dataOwnerGroups: Array<DataOwnerGroupLink>;

	/**
	 *
	 *  The links to the data owners representing the organizations, administrative units or other loose
	 *  groups of
	 *  healthcare parties this crypto actor belongs to.
	 *  There are different types of links, which have different implication on access control and
	 *  requirements for
	 *  sharing data among all members of the group.
	 *
	 *  This list should be considered as unordered, and it may not contain two links pointing to the
	 *  same data owner,
	 *  regardless of type.
	 *
	 *  # Membership propagation
	 *
	 *  All links are transitive, whatever their type: every directly linked group is a group of the
	 *  actor, and the groups
	 *  of a group are also groups of the actor (applied recursively). An actor is therefore a member of
	 *  every group
	 *  reachable through a path of links.
	 *
	 *  For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 *  `hcp` are
	 *  `department`, `building` and `campus`.
	 *
	 *  There may however be restrictions in place on how propagation when the link type changes:
	 *  propagation from a
	 *  parent link to a simple link is allowed, but the opposite is not.
	 *  A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is not
	 *  allowed: while
	 *  the relationships of `building` are technically valid the full membership for `department` or
	 *  `hcp` is invalid,
	 *  and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 *  # Why groups instead of direct sharing with members
	 *
	 *  By using groups of data owners instead of directly sharing data with each data owner in a group
	 *  you gain two
	 *  major advantages:
	 *  - Reduced size of metadata on entities
	 *  - Possibility of dynamically adding peoples to a group without having to update all the entities
	 *  that they should
	 *  be able to access
	 *
	 *  In a full-scale system where data is massively shared between groups of users using data owner
	 *  groups is the
	 *  only realistic choice available.
	 *  /
	 */
	groupLinkType: DataOwnerGroupLinkType | undefined;

	/**
	 *
	 *  The links to the data owners representing the organizations, administrative units or other loose
	 *  groups of
	 *  healthcare parties this crypto actor belongs to.
	 *  There are different types of links, which have different implication on access control and
	 *  requirements for
	 *  sharing data among all members of the group.
	 *
	 *  This list should be considered as unordered, and it may not contain two links pointing to the
	 *  same data owner,
	 *  regardless of type.
	 *
	 *  # Membership propagation
	 *
	 *  All links are transitive, whatever their type: every directly linked group is a group of the
	 *  actor, and the groups
	 *  of a group are also groups of the actor (applied recursively). An actor is therefore a member of
	 *  every group
	 *  reachable through a path of links.
	 *
	 *  For example with `hcp -parent-> department -simple-> building -simple-> campus`: the groups of
	 *  `hcp` are
	 *  `department`, `building` and `campus`.
	 *
	 *  There may however be restrictions in place on how propagation when the link type changes:
	 *  propagation from a
	 *  parent link to a simple link is allowed, but the opposite is not.
	 *  A group membership such as `hcp -parent-> department -simple-> building -parent-> campus` is not
	 *  allowed: while
	 *  the relationships of `building` are technically valid the full membership for `department` or
	 *  `hcp` is invalid,
	 *  and a user associated with a data owner that has invalid membership is not allowed to login.
	 *
	 *  # Why groups instead of direct sharing with members
	 *
	 *  By using groups of data owners instead of directly sharing data with each data owner in a group
	 *  you gain two
	 *  major advantages:
	 *  - Reduced size of metadata on entities
	 *  - Possibility of dynamically adding peoples to a group without having to update all the entities
	 *  that they should
	 *  be able to access
	 *
	 *  In a full-scale system where data is massively shared between groups of users using data owner
	 *  groups is the
	 *  only realistic choice available.
	 *  /
	 */
	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined;

	readonly $ktClass: string;

}

export namespace CryptoActor {

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CryptoActor']): CryptoActor {
		switch ((json as CryptoActor).$ktClass) {
			case 'com.icure.cardinal.sdk.model.CryptoActorStub': return CryptoActorStub.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.EncryptedPatient': return EncryptedPatient.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.DecryptedPatient': return DecryptedPatient.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.Device': return Device.fromJSON(json, ignoreUnknownKeys)
			case 'com.icure.cardinal.sdk.model.HealthcareParty': return HealthcareParty.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for CryptoActor: ' + json.$ktClass)
		}
	}

}
