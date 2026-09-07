// auto-generated file
import {expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {Identifier} from '../base/Identifier.mjs';
import {AsserterType} from './AsserterType.mjs';


/**
 *
 *
 *   The party asserting that the patient has the healthcare element this asserter is attached to.
 *
 *   This is the FHIR-style *asserter* concept: it does not say who recorded or authored the
 *  healthcare element, it says
 *   on whose word the healthcare element is held to be true. A patient may self-report an allergy, a
 *  family member may
 *   report a condition on behalf of the patient, and a physician may assert a diagnosis: all three
 *  are asserters, and the
 *   same healthcare element may carry more than one of them.
 *
 *   The party is named in exactly one of two ways, and exactly one of the two fields must be set:
 *   - [localAsserterIdentifier] names a party stored in this iCure instance: an id, plus the
 *  [AsserterTypeDto] saying
 *     which kind of record that id points at;
 *   - [externalAsserterIdentifier] names a party that has no record here, through a business
 *  [IdentifierDto] issued by
 *     another system. There is deliberately no [AsserterTypeDto] on this branch: the kind of a
 *  record we do not store is
 *     not knowable to us.
 *
 *   The exactly-one rule is **not** checked on this DTO. It is checked one layer down, in
 *  `HealthElementAsserter`'s
 *   `init`: mapping this DTO constructs one, so a violation still surfaces as a `400`, and the rule
 *  also covers the write
 *   paths that never build a DTO at all. This class only checks that [LocalAsserterIdentifier.id] is
 *  not blank. Nothing
 *   enforces the *pairing* inside [LocalAsserterIdentifier]: [AsserterTypeDto] bounds the
 *  vocabulary, not what
 *   [LocalAsserterIdentifier.id] actually points at; that invariant is owned by the SDK.
 *
 *   Note on organisations: an organisation (hospital, practice, care home, ...) is not a distinct
 *  asserter type.
 *   Organisations are stored as healthcare party records, distinguished from individual
 *  practitioners by tags set by the
 *   client, so an organisation asserter is a [localAsserterIdentifier] with `type =
 *  AsserterTypeDto.healthcareParty`
 *   whose `id` points to such a record. The association between a practitioner and the organisation
 *  they were acting for
 *   at the time of the assertion is deliberately NOT modelled here.
 */
export class HealthElementAsserter {

	/**
	 *
	 *
	 *   The asserting party, as a reference to a record stored in this instance. Null when the party is
	 *  named by
	 *   [externalAsserterIdentifier].
	 */
	localAsserterIdentifier: HealthElementAsserter.LocalAsserterIdentifier | undefined = undefined;

	/**
	 *
	 *
	 *   The asserting party, as a business identifier from a system that is not this one. Null when the
	 *  party is named by
	 *   [localAsserterIdentifier]. Carries no [AsserterTypeDto].
	 */
	externalAsserterIdentifier: HealthElementAsserter.ExternalAsserterIdentifier | undefined = undefined;

	constructor(partial: Partial<HealthElementAsserter>) {
		if ('localAsserterIdentifier' in partial) this.localAsserterIdentifier = partial.localAsserterIdentifier;
		if ('externalAsserterIdentifier' in partial) this.externalAsserterIdentifier = partial.externalAsserterIdentifier;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.localAsserterIdentifier != undefined) res['localAsserterIdentifier'] = this.localAsserterIdentifier.toJSON()
		if (this.externalAsserterIdentifier != undefined) res['externalAsserterIdentifier'] = this.externalAsserterIdentifier.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HealthElementAsserter']): HealthElementAsserter {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new HealthElementAsserter({
			localAsserterIdentifier: expectObject(extractEntry(jCpy, 'localAsserterIdentifier', false, path), true, ignoreUnknownKeys, [...path, ".localAsserterIdentifier"], HealthElementAsserter.LocalAsserterIdentifier.fromJSON),
			externalAsserterIdentifier: expectObject(extractEntry(jCpy, 'externalAsserterIdentifier', false, path), true, ignoreUnknownKeys, [...path, ".externalAsserterIdentifier"], HealthElementAsserter.ExternalAsserterIdentifier.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HealthElementAsserter at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace HealthElementAsserter {

	/**
	 *
	 *
	 *   A reference to the record, stored in iCure.
	 */
	export class LocalAsserterIdentifier {

		/**
		 *
		 *  The id of the entity making the assertion. Which entity it refers to is given by [type].
		 */
		id: string;

		/**
		 *
		 *
		 *   The kind of entity [id] refers to. This is the kind of entity, not the role the party played -
		 *  do not
		 *   confuse it with ParticipantTypeDto.
		 */
		type: AsserterType;

		constructor(partial: Partial<LocalAsserterIdentifier> & Pick<LocalAsserterIdentifier, "type">) {
			this.id = partial.id ?? randomUuid();
			this.type = partial.type;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['id'] = this.id
			res['type'] = this.type
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['LocalAsserterIdentifier']): LocalAsserterIdentifier {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new LocalAsserterIdentifier({
				id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
				type: expectStringEnum(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"], AsserterType, 'AsserterType'),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LocalAsserterIdentifier at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

	/**
	 *
	 *
	 *   The party making the assertion, when it has no record in this iCure instance.
	 *
	 *   The party is named by a business [identifier] issued by another system: a national registry
	 *  number, an entry in
	 *   the sending hospital's directory, and so on. Because the record lives elsewhere there is no
	 *  [AsserterTypeDto]
	 *   here - the kind of a record we do not store is not knowable to us. The wrapper around the
	 *  [IdentifierDto] mirrors
	 *   [LocalAsserterIdentifier] on the other branch, and is where anything specific to an external
	 *  asserter would go:
	 *   [IdentifierDto] itself is shared by every `identifiers` field in the model and cannot carry it.
	 */
	export class ExternalAsserterIdentifier {

		/**
		 *
		 *
		 *   The business identifier of the party in the system that issued it. `system` names that issuing
		 *  system and
		 *   `value` is the party's identifier within it; together they are what makes the party
		 *  resolvable.
		 */
		identifier: Identifier;

		constructor(partial: Partial<ExternalAsserterIdentifier> & Pick<ExternalAsserterIdentifier, "identifier">) {
			this.identifier = partial.identifier;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['identifier'] = this.identifier.toJSON()
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['ExternalAsserterIdentifier']): ExternalAsserterIdentifier {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new ExternalAsserterIdentifier({
				identifier: expectObject(extractEntry(jCpy, 'identifier', true, path), false, ignoreUnknownKeys, [...path, ".identifier"], Identifier.fromJSON),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ExternalAsserterIdentifier at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
