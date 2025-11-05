// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {DatabaseInfo} from './DatabaseInfo.mjs';


export class GroupDatabasesInfo {

	groupId: string;

	databasesInfo: Array<DatabaseInfo>;

	gcpStorageSize: number;

	constructor(partial: Partial<GroupDatabasesInfo> & Pick<GroupDatabasesInfo, "groupId" | "databasesInfo" | "gcpStorageSize">) {
		this.groupId = partial.groupId;
		this.databasesInfo = partial.databasesInfo;
		this.gcpStorageSize = partial.gcpStorageSize;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['groupId'] = this.groupId
		res['databasesInfo'] = this.databasesInfo.map((x0) => x0.toJSON() )
		res['gcpStorageSize'] = this.gcpStorageSize
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['GroupDatabasesInfo']): GroupDatabasesInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new GroupDatabasesInfo({
			groupId: expectString(extractEntry(jCpy, 'groupId', true, path), false, [...path, ".groupId"]),
			databasesInfo: expectArray(extractEntry(jCpy, 'databasesInfo', true, path), false, [...path, ".databasesInfo"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DatabaseInfo.fromJSON)),
			gcpStorageSize: expectNumber(extractEntry(jCpy, 'gcpStorageSize', true, path), false, true, [...path, ".gcpStorageSize"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object GroupDatabasesInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
