// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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
 *   The two fields must agree: [asserterType] declares which kind of entity [asserterId] points at.
 *  [AsserterTypeDto]
 *   bounds the vocabulary, but nothing enforces the *pairing* - the field is encrypted, so the
 *  server never sees the
 *   values and cannot validate or repair them; that invariant is owned by the SDK.
 *
 *   Note on organisations: an organisation (hospital, practice, care home, ...) is not a distinct
 *  asserter type.
 *   Organisations are stored as healthcare party records, distinguished from individual
 *  practitioners by tags set by the
 *   client, so an organisation asserter is an entry with `asserterType =
 *  AsserterTypeDto.healthcareParty` whose
 *   [asserterId] points to such a record. The association between a practitioner and the
 *  organisation they were acting
 *   for at the time of the assertion is deliberately NOT modelled here.
 */
export class HealthElementAsserter {

	/**
	 *
	 *  The id of the entity making the assertion. Which entity it refers to is given by [asserterType].
	 *
	 */
	asserterId: string;

	/**
	 *
	 *
	 *   The kind of entity [asserterId] refers to. This is the kind of entity, not the role the party
	 *  played - do not
	 *   confuse it with ParticipantTypeDto.
	 */
	asserterType: AsserterType;

	constructor(partial: Partial<HealthElementAsserter> & Pick<HealthElementAsserter, "asserterId" | "asserterType">) {
		this.asserterId = partial.asserterId;
		this.asserterType = partial.asserterType;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['asserterId'] = this.asserterId
		res['asserterType'] = this.asserterType
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HealthElementAsserter']): HealthElementAsserter {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new HealthElementAsserter({
			asserterId: expectString(extractEntry(jCpy, 'asserterId', true, path), false, [...path, ".asserterId"]),
			asserterType: expectStringEnum(extractEntry(jCpy, 'asserterType', true, path), false, [...path, ".asserterType"], AsserterType, 'AsserterType'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HealthElementAsserter at path ${path.join("")}: ${unused}`)}
		return res
	}

}
