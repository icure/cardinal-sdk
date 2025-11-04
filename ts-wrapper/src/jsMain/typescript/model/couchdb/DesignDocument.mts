// auto-generated file
import {expectMap, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {View} from './View.mjs';


export class DesignDocument {

	id: string;

	rev: string | undefined = undefined;

	revHistory: { [ key: string ]: string } = {};

	language: string | undefined = undefined;

	views: { [ key: string ]: View } = {};

	lists: { [ key: string ]: string } = {};

	shows: { [ key: string ]: string } = {};

	updateHandlers: { [ key: string ]: string } | undefined = undefined;

	filters: { [ key: string ]: string } = {};

	constructor(partial: Partial<DesignDocument>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('revHistory' in partial && partial.revHistory !== undefined) this.revHistory = partial.revHistory;
		if ('language' in partial) this.language = partial.language;
		if ('views' in partial && partial.views !== undefined) this.views = partial.views;
		if ('lists' in partial && partial.lists !== undefined) this.lists = partial.lists;
		if ('shows' in partial && partial.shows !== undefined) this.shows = partial.shows;
		if ('updateHandlers' in partial) this.updateHandlers = partial.updateHandlers;
		if ('filters' in partial && partial.filters !== undefined) this.filters = partial.filters;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['revHistory'] = Object.fromEntries(Object.entries(this.revHistory).map(([k0, v0]) => [k0, v0]))
		if (this.language != undefined) res['language'] = this.language
		res['views'] = Object.fromEntries(Object.entries(this.views).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['lists'] = Object.fromEntries(Object.entries(this.lists).map(([k0, v0]) => [k0, v0]))
		res['shows'] = Object.fromEntries(Object.entries(this.shows).map(([k0, v0]) => [k0, v0]))
		if (this.updateHandlers != undefined) res['updateHandlers'] = Object.fromEntries(Object.entries(this.updateHandlers).map(([k0, v0]) => [k0, v0]))
		res['filters'] = Object.fromEntries(Object.entries(this.filters).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DesignDocument']): DesignDocument {
		return new DesignDocument({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			revHistory: expectMap(
				json.revHistory,
				false,
				[...path, ".revHistory"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			language: expectString(json.language, true, [...path, ".language"]),
			views: expectMap(
				json.views,
				false,
				[...path, ".views"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => View.fromJSON(v0, p0)
			),
			lists: expectMap(
				json.lists,
				false,
				[...path, ".lists"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			shows: expectMap(
				json.shows,
				false,
				[...path, ".shows"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			updateHandlers: expectMap(
				json.updateHandlers,
				true,
				[...path, ".updateHandlers"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			filters: expectMap(
				json.filters,
				false,
				[...path, ".filters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
		})
	}

}
