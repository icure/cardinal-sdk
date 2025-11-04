// auto-generated file
import {expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
import {PartnershipStatus} from './PartnershipStatus.mjs';
import {PartnershipType} from './PartnershipType.mjs';


export class Partnership {

	type: PartnershipType | undefined = undefined;

	status: PartnershipStatus | undefined = undefined;

	partnerId: string | undefined = undefined;

	meToOtherRelationshipDescription: string | undefined = undefined;

	otherToMeRelationshipDescription: string | undefined = undefined;

	constructor(partial: Partial<Partnership>) {
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('partnerId' in partial) this.partnerId = partial.partnerId;
		if ('meToOtherRelationshipDescription' in partial) this.meToOtherRelationshipDescription = partial.meToOtherRelationshipDescription;
		if ('otherToMeRelationshipDescription' in partial) this.otherToMeRelationshipDescription = partial.otherToMeRelationshipDescription;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.status != undefined) res['status'] = this.status
		if (this.partnerId != undefined) res['partnerId'] = this.partnerId
		if (this.meToOtherRelationshipDescription != undefined) res['meToOtherRelationshipDescription'] = this.meToOtherRelationshipDescription
		if (this.otherToMeRelationshipDescription != undefined) res['otherToMeRelationshipDescription'] = this.otherToMeRelationshipDescription
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Partnership']): Partnership {
		return new Partnership({
			type: expectStringEnum(json.type, true, [...path, ".type"], PartnershipType, 'PartnershipType'),
			status: expectStringEnum(json.status, true, [...path, ".status"], PartnershipStatus, 'PartnershipStatus'),
			partnerId: expectString(json.partnerId, true, [...path, ".partnerId"]),
			meToOtherRelationshipDescription: expectString(json.meToOtherRelationshipDescription, true, [...path, ".meToOtherRelationshipDescription"]),
			otherToMeRelationshipDescription: expectString(json.otherToMeRelationshipDescription, true, [...path, ".otherToMeRelationshipDescription"]),
		})
	}

}
