// auto-generated file
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

}

export namespace CalendarItemType {

	export namespace DurationConfig {

		export class Set {

			durations: Array<number> = [];

			readonly $ktClass: 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set' = 'com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set';

			constructor(partial: Partial<Set>) {
				if ('durations' in partial && partial.durations !== undefined) this.durations = partial.durations;
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

		}

	}

	export type DurationConfig = DurationConfig.Set | DurationConfig.Formula;

}
