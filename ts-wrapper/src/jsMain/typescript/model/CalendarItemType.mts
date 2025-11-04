// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['CalendarItemType']): CalendarItemType {
		return new CalendarItemType({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			agendaId: expectString(json.agendaId, true, [...path, ".agendaId"]),
			defaultCalendarItemType: expectBoolean(json.defaultCalendarItemType, false, [...path, ".defaultCalendarItemType"]),
			name: expectString(json.name, true, [...path, ".name"]),
			color: expectString(json.color, true, [...path, ".color"]),
			duration: expectNumber(json.duration, false, true, [...path, ".duration"]),
			extraDurationsConfig: CalendarItemType.DurationConfig.fromJSON(json.extraDurationsConfig, [...path, ".extraDurationsConfig"]),
			externalRef: expectString(json.externalRef, true, [...path, ".externalRef"]),
			mikronoId: expectString(json.mikronoId, true, [...path, ".mikronoId"]),
			docIds: expectArray(json.docIds, false, [...path, ".docIds"], (x0, p0) => expectString(x0, false, p0)),
			otherInfos: expectMap(
				json.otherInfos,
				false,
				[...path, ".otherInfos"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			subjectByLanguage: expectMap(
				json.subjectByLanguage,
				false,
				[...path, ".subjectByLanguage"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicProperties: expectArray(json.publicProperties, true, [...path, ".publicProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
		})
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
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Set']): Set {
				return new Set({
					durations: expectArray(json.durations, false, [...path, ".durations"], (x0, p0) => expectNumber(x0, false, true, p0)),
				})
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
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Formula']): Formula {
				return new Formula({
					min: expectNumber(requireEntry(json.min, 'min', path), false, true, [...path, ".min"]),
					max: expectNumber(requireEntry(json.max, 'max', path), false, true, [...path, ".max"]),
					step: expectNumber(requireEntry(json.step, 'step', path), false, true, [...path, ".step"]),
				})
			}

		}

	}

	export type DurationConfig = DurationConfig.Set | DurationConfig.Formula;

}
