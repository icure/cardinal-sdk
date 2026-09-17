// auto-generated file
import {expectArray, expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {DataOwnerType} from '../DataOwnerType.mjs';
import {DataOwnerGroupLinkType} from './DataOwnerGroupLinkType.mjs';
import {DataOwnerHierarchyInfo as DataOwnerHierarchyInfo_} from './DataOwnerHierarchyInfo.mjs';


/**
 *
 *
 *   The id of a data owner together with its group hierarchies as a tree of ids.
 */
export class DataOwnerHierarchyInfo {

	/**
	 *
	 *  The id of the data owner.
	 */
	id: string;

	/**
	 *
	 *  The id of the data owner.
	 */
	dataOwnerType: DataOwnerType;

	/**
	 *
	 *
	 *   One node for each group the data owner is directly linked to, through the legacy parentId or a
	 *  dataOwnerGroups
	 *   link, in the declaration order of the links. A group reachable through multiple paths appears
	 *  in each path.
	 */
	links: Array<DataOwnerHierarchyInfo.HierarchyNode> = [];

	constructor(partial: Partial<DataOwnerHierarchyInfo> & Pick<DataOwnerHierarchyInfo, "dataOwnerType">) {
		this.id = partial.id ?? randomUuid();
		this.dataOwnerType = partial.dataOwnerType;
		if ('links' in partial && partial.links !== undefined) this.links = partial.links;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['dataOwnerType'] = this.dataOwnerType
		res['links'] = this.links.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DataOwnerHierarchyInfo']): DataOwnerHierarchyInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DataOwnerHierarchyInfo({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			dataOwnerType: expectStringEnum(extractEntry(jCpy, 'dataOwnerType', true, path), false, [...path, ".dataOwnerType"], DataOwnerType, 'DataOwnerType'),
			links: expectArray(extractEntry(jCpy, 'links', false, path), false, [...path, ".links"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DataOwnerHierarchyInfo.HierarchyNode.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DataOwnerHierarchyInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace DataOwnerHierarchyInfo {

	export class HierarchyNode {

		linkedGroupId: string;

		linkType: DataOwnerGroupLinkType;

		transitiveLinks: Array<DataOwnerHierarchyInfo_.HierarchyNode> = [];

		constructor(partial: Partial<HierarchyNode> & Pick<HierarchyNode, "linkedGroupId" | "linkType">) {
			this.linkedGroupId = partial.linkedGroupId;
			this.linkType = partial.linkType;
			if ('transitiveLinks' in partial && partial.transitiveLinks !== undefined) this.transitiveLinks = partial.transitiveLinks;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['linkedGroupId'] = this.linkedGroupId
			res['linkType'] = this.linkType
			res['transitiveLinks'] = this.transitiveLinks.map((x0) => x0.toJSON() )
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['HierarchyNode']): HierarchyNode {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new HierarchyNode({
				linkedGroupId: expectString(extractEntry(jCpy, 'linkedGroupId', true, path), false, [...path, ".linkedGroupId"]),
				linkType: expectStringEnum(extractEntry(jCpy, 'linkType', true, path), false, [...path, ".linkType"], DataOwnerGroupLinkType, 'DataOwnerGroupLinkType'),
				transitiveLinks: expectArray(extractEntry(jCpy, 'transitiveLinks', false, path), false, [...path, ".transitiveLinks"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, HierarchyNode.fromJSON)),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HierarchyNode at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
