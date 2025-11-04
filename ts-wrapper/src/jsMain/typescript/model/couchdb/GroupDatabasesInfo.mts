// auto-generated file
import {expectArray, expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['GroupDatabasesInfo']): GroupDatabasesInfo {
		return new GroupDatabasesInfo({
			groupId: expectString(requireEntry(json.groupId, 'groupId', path), false, [...path, ".groupId"]),
			databasesInfo: expectArray(requireEntry(json.databasesInfo, 'databasesInfo', path), false, [...path, ".databasesInfo"], (x0, p0) => DatabaseInfo.fromJSON(x0, p0)),
			gcpStorageSize: expectNumber(requireEntry(json.gcpStorageSize, 'gcpStorageSize', path), false, true, [...path, ".gcpStorageSize"]),
		})
	}

}
