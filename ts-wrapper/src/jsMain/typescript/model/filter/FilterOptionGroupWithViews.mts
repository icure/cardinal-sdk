// auto-generated file
import {expectArray, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  A set of factory methods that produce the same kind of filter, differing only in how parameters are
 *  passed (for-self vs. for-data-owner, in-group variants, full entities vs. secret ids).
 *
 *  @property name a short semantic name for the group (the operation, without the parameter-passing suffixes).
 *  @property factoryMethods the names of the factory methods of the corresponding `XFilters` object that
 *  belong to this group, in source order.
 *  @property targetFilter the simple name of the `AbstractFilter` actually sent to the backend (or the
 *  possible filters, separated by " or ", for the rare groups that branch on their input).
 *  @property views the views that are used on the backend to provide the results for the options in this group.
 */
export class FilterOptionGroupWithViews {

	name: string;

	factoryMethods: Array<string>;

	targetFilter: string;

	views: Array<string>;

	constructor(partial: Partial<FilterOptionGroupWithViews> & Pick<FilterOptionGroupWithViews, "name" | "factoryMethods" | "targetFilter" | "views">) {
		this.name = partial.name;
		this.factoryMethods = partial.factoryMethods;
		this.targetFilter = partial.targetFilter;
		this.views = partial.views;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['name'] = this.name
		res['factoryMethods'] = this.factoryMethods.map((x0) => x0 )
		res['targetFilter'] = this.targetFilter
		res['views'] = this.views.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['FilterOptionGroupWithViews']): FilterOptionGroupWithViews {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new FilterOptionGroupWithViews({
			name: expectString(extractEntry(jCpy, 'name', true, path), false, [...path, ".name"]),
			factoryMethods: expectArray(extractEntry(jCpy, 'factoryMethods', true, path), false, [...path, ".factoryMethods"], (x0, p0) => expectString(x0, false, p0)),
			targetFilter: expectString(extractEntry(jCpy, 'targetFilter', true, path), false, [...path, ".targetFilter"]),
			views: expectArray(extractEntry(jCpy, 'views', true, path), false, [...path, ".views"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FilterOptionGroupWithViews at path ${path.join("")}: ${unused}`)}
		return res
	}

}
