// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class CalendarItemType implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	agendaId: string | undefined = undefined;

	defaultCalendarItemType: boolean = false;

	name: string | undefined = undefined;

	color: string | undefined = undefined;

	duration: number = 0;

	extraDurationsConfig: CalendarItemType.DurationConfig | undefined = undefined;

	externalRef: string | undefined = undefined;

	mikronoId: string | undefined = undefined;

	docIds: Array<string> = [];

	otherInfos: { [ key: string ]: string } = {};

	subjectByLanguage: { [ key: string ]: string } = {};

	publicProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	constructor(partial: Partial<CalendarItemType>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('defaultCalendarItemType' in partial && partial.defaultCalendarItemType !== undefined) this.defaultCalendarItemType = partial.defaultCalendarItemType;
		if ('name' in partial) this.name = partial.name;
		if ('color' in partial) this.color = partial.color;
		if ('duration' in partial && partial.duration !== undefined) this.duration = partial.duration;
		if ('extraDurationsConfig' in partial) this.extraDurationsConfig = partial.extraDurationsConfig;
		if ('externalRef' in partial) this.externalRef = partial.externalRef;
		if ('mikronoId' in partial) this.mikronoId = partial.mikronoId;
		if ('docIds' in partial && partial.docIds !== undefined) this.docIds = partial.docIds;
		if ('otherInfos' in partial && partial.otherInfos !== undefined) this.otherInfos = partial.otherInfos;
		if ('subjectByLanguage' in partial && partial.subjectByLanguage !== undefined) this.subjectByLanguage = partial.subjectByLanguage;
		if ('publicProperties' in partial) this.publicProperties = partial.publicProperties;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.agendaId != undefined) res['agendaId'] = this.agendaId
		res['defaultCalendarItemType'] = this.defaultCalendarItemType
		if (this.name != undefined) res['name'] = this.name
		if (this.color != undefined) res['color'] = this.color
		res['duration'] = this.duration
		if (this.extraDurationsConfig != undefined) res['extraDurationsConfig'] = this.extraDurationsConfig.toJSON()
		if (this.externalRef != undefined) res['externalRef'] = this.externalRef
		if (this.mikronoId != undefined) res['mikronoId'] = this.mikronoId
		res['docIds'] = this.docIds.map((x0) => x0 )
		res['otherInfos'] = Object.fromEntries(Object.entries(this.otherInfos).map(([k0, v0]) => [k0, v0]))
		res['subjectByLanguage'] = Object.fromEntries(Object.entries(this.subjectByLanguage).map(([k0, v0]) => [k0, v0]))
		if (this.publicProperties != undefined) res['publicProperties'] = this.publicProperties.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CalendarItemType']): CalendarItemType {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new CalendarItemType({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			agendaId: expectString(extractEntry(jCpy, 'agendaId', false, path), true, [...path, ".agendaId"]),
			defaultCalendarItemType: expectBoolean(extractEntry(jCpy, 'defaultCalendarItemType', false, path), false, [...path, ".defaultCalendarItemType"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			color: expectString(extractEntry(jCpy, 'color', false, path), true, [...path, ".color"]),
			duration: expectNumber(extractEntry(jCpy, 'duration', false, path), false, true, [...path, ".duration"]),
			extraDurationsConfig: expectObject(extractEntry(jCpy, 'extraDurationsConfig', false, path), true, ignoreUnknownKeys, [...path, ".extraDurationsConfig"], CalendarItemType.DurationConfig.fromJSON),
			externalRef: expectString(extractEntry(jCpy, 'externalRef', false, path), true, [...path, ".externalRef"]),
			mikronoId: expectString(extractEntry(jCpy, 'mikronoId', false, path), true, [...path, ".mikronoId"]),
			docIds: expectArray(extractEntry(jCpy, 'docIds', false, path), false, [...path, ".docIds"], (x0, p0) => expectString(x0, false, p0)),
			otherInfos: expectMap(
				extractEntry(jCpy, 'otherInfos', false, path),
				false,
				[...path, ".otherInfos"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			subjectByLanguage: expectMap(
				extractEntry(jCpy, 'subjectByLanguage', false, path),
				false,
				[...path, ".subjectByLanguage"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicProperties: expectArray(extractEntry(jCpy, 'publicProperties', false, path), true, [...path, ".publicProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object CalendarItemType at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace CalendarItemType {

	export namespace DurationConfig {

		export class Set {

			durations: Array<number> = [];

			readonly $ktClass: 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set' = 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set';

			constructor(partial: Partial<Set>) {
				if ('durations' in partial && partial.durations !== undefined) this.durations = partial.durations;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['durations'] = this.durations.map((x0) => x0 )
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Set']): Set {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set') throw new Error(`Unexpected value f+or ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set"`)
				const res = new Set({
					durations: expectArray(extractEntry(jCpy, 'durations', false, path), false, [...path, ".durations"], (x0, p0) => expectNumber(x0, false, true, p0)),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Set at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class Formula {

			min: number;

			max: number;

			step: number;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula' = 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula';

			constructor(partial: Partial<Formula> & Pick<Formula, "min" | "max" | "step">) {
				this.min = partial.min;
				this.max = partial.max;
				this.step = partial.step;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['min'] = this.min
				res['max'] = this.max
				res['step'] = this.step
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Formula']): Formula {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula') throw new Error(`Unexpected value f+or ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula"`)
				const res = new Formula({
					min: expectNumber(extractEntry(jCpy, 'min', true, path), false, true, [...path, ".min"]),
					max: expectNumber(extractEntry(jCpy, 'max', true, path), false, true, [...path, ".max"]),
					step: expectNumber(extractEntry(jCpy, 'step', true, path), false, true, [...path, ".step"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Formula at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['DurationConfig']): DurationConfig {
			switch ((json as DurationConfig).$ktClass) {
				case 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set': return Set.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula': return Formula.fromJSON(json, ignoreUnknownKeys)
				default: throw new Error('Unexpected discriminator for DurationConfig: ' + json.$ktClass)
			}
		}

	}

	export type DurationConfig = DurationConfig.Set | DurationConfig.Formula;

}
