// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {DatabaseInfo} from './DatabaseInfo.mjs';


/**
 *
 *  Data transfer object aggregating database information for all databases belonging to a specific group,
 *  including their storage sizes and GCP storage usage.
 *  /
 */
export class GroupDatabasesInfo {

	/**
	 *
	 *  The identifier of the group.
	 */
	groupId: string;

	/**
	 *
	 *  The list of database information entries for this group.
	 */
	databasesInfo: Array<DatabaseInfo>;

	/**
	 *
	 *  The total GCP storage size in bytes used by this group.
	 */
	objectStorageSize: number;

	objectStorageInfo: { [ key: string ]: GroupDatabasesInfo.ObjectStorageInfo } = {};

	constructor(partial: Partial<GroupDatabasesInfo> & Pick<GroupDatabasesInfo, "groupId" | "databasesInfo" | "objectStorageSize">) {
		this.groupId = partial.groupId;
		this.databasesInfo = partial.databasesInfo;
		this.objectStorageSize = partial.objectStorageSize;
		if ('objectStorageInfo' in partial && partial.objectStorageInfo !== undefined) this.objectStorageInfo = partial.objectStorageInfo;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['groupId'] = this.groupId
		res['databasesInfo'] = this.databasesInfo.map((x0) => x0.toJSON() )
		res['objectStorageSize'] = this.objectStorageSize
		res['objectStorageInfo'] = Object.fromEntries(Object.entries(this.objectStorageInfo).map(([k0, v0]) => [k0, v0.toJSON()]))
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['GroupDatabasesInfo']): GroupDatabasesInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new GroupDatabasesInfo({
			groupId: expectString(extractEntry(jCpy, 'groupId', true, path), false, [...path, ".groupId"]),
			databasesInfo: expectArray(extractEntry(jCpy, 'databasesInfo', true, path), false, [...path, ".databasesInfo"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DatabaseInfo.fromJSON)),
			objectStorageSize: expectNumber(extractEntry(jCpy, 'objectStorageSize', true, path), false, true, [...path, ".objectStorageSize"]),
			objectStorageInfo: expectMap(
				extractEntry(jCpy, 'objectStorageInfo', false, path),
				false,
				[...path, ".objectStorageInfo"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, GroupDatabasesInfo.ObjectStorageInfo.fromJSON)
			),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object GroupDatabasesInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace GroupDatabasesInfo {

	export class ObjectStorageInfo {

		size: number;

		regions: Array<string>;

		constructor(partial: Partial<ObjectStorageInfo> & Pick<ObjectStorageInfo, "size" | "regions">) {
			this.size = partial.size;
			this.regions = partial.regions;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['size'] = this.size
			res['regions'] = this.regions.map((x0) => x0 )
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['ObjectStorageInfo']): ObjectStorageInfo {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new ObjectStorageInfo({
				size: expectNumber(extractEntry(jCpy, 'size', true, path), false, true, [...path, ".size"]),
				regions: expectArray(extractEntry(jCpy, 'regions', true, path), false, [...path, ".regions"], (x0, p0) => expectString(x0, false, p0)),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ObjectStorageInfo at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
