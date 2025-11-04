// auto-generated file
import {expectBoolean, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


export class FlowItem {

	id: string | undefined = undefined;

	title: string | undefined = undefined;

	comment: string | undefined = undefined;

	receptionDate: number | undefined = undefined;

	processingDate: number | undefined = undefined;

	processer: string | undefined = undefined;

	cancellationDate: number | undefined = undefined;

	canceller: string | undefined = undefined;

	cancellationReason: string | undefined = undefined;

	cancellationNote: string | undefined = undefined;

	status: string | undefined = undefined;

	homeVisit: boolean | undefined = undefined;

	municipality: string | undefined = undefined;

	town: string | undefined = undefined;

	zipCode: string | undefined = undefined;

	street: string | undefined = undefined;

	building: string | undefined = undefined;

	buildingNumber: string | undefined = undefined;

	doorbellName: string | undefined = undefined;

	floor: string | undefined = undefined;

	letterBox: string | undefined = undefined;

	notesOps: string | undefined = undefined;

	notesContact: string | undefined = undefined;

	latitude: string | undefined = undefined;

	longitude: string | undefined = undefined;

	type: string | undefined = undefined;

	emergency: boolean | undefined = undefined;

	phoneNumber: string | undefined = undefined;

	patientId: string | undefined = undefined;

	patientLastName: string | undefined = undefined;

	patientFirstName: string | undefined = undefined;

	description: string | undefined = undefined;

	interventionCode: string | undefined = undefined;

	constructor(partial: Partial<FlowItem>) {
		if ('id' in partial) this.id = partial.id;
		if ('title' in partial) this.title = partial.title;
		if ('comment' in partial) this.comment = partial.comment;
		if ('receptionDate' in partial) this.receptionDate = partial.receptionDate;
		if ('processingDate' in partial) this.processingDate = partial.processingDate;
		if ('processer' in partial) this.processer = partial.processer;
		if ('cancellationDate' in partial) this.cancellationDate = partial.cancellationDate;
		if ('canceller' in partial) this.canceller = partial.canceller;
		if ('cancellationReason' in partial) this.cancellationReason = partial.cancellationReason;
		if ('cancellationNote' in partial) this.cancellationNote = partial.cancellationNote;
		if ('status' in partial) this.status = partial.status;
		if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
		if ('municipality' in partial) this.municipality = partial.municipality;
		if ('town' in partial) this.town = partial.town;
		if ('zipCode' in partial) this.zipCode = partial.zipCode;
		if ('street' in partial) this.street = partial.street;
		if ('building' in partial) this.building = partial.building;
		if ('buildingNumber' in partial) this.buildingNumber = partial.buildingNumber;
		if ('doorbellName' in partial) this.doorbellName = partial.doorbellName;
		if ('floor' in partial) this.floor = partial.floor;
		if ('letterBox' in partial) this.letterBox = partial.letterBox;
		if ('notesOps' in partial) this.notesOps = partial.notesOps;
		if ('notesContact' in partial) this.notesContact = partial.notesContact;
		if ('latitude' in partial) this.latitude = partial.latitude;
		if ('longitude' in partial) this.longitude = partial.longitude;
		if ('type' in partial) this.type = partial.type;
		if ('emergency' in partial) this.emergency = partial.emergency;
		if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('patientLastName' in partial) this.patientLastName = partial.patientLastName;
		if ('patientFirstName' in partial) this.patientFirstName = partial.patientFirstName;
		if ('description' in partial) this.description = partial.description;
		if ('interventionCode' in partial) this.interventionCode = partial.interventionCode;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.title != undefined) res['title'] = this.title
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.receptionDate != undefined) res['receptionDate'] = this.receptionDate
		if (this.processingDate != undefined) res['processingDate'] = this.processingDate
		if (this.processer != undefined) res['processer'] = this.processer
		if (this.cancellationDate != undefined) res['cancellationDate'] = this.cancellationDate
		if (this.canceller != undefined) res['canceller'] = this.canceller
		if (this.cancellationReason != undefined) res['cancellationReason'] = this.cancellationReason
		if (this.cancellationNote != undefined) res['cancellationNote'] = this.cancellationNote
		if (this.status != undefined) res['status'] = this.status
		if (this.homeVisit != undefined) res['homeVisit'] = this.homeVisit
		if (this.municipality != undefined) res['municipality'] = this.municipality
		if (this.town != undefined) res['town'] = this.town
		if (this.zipCode != undefined) res['zipCode'] = this.zipCode
		if (this.street != undefined) res['street'] = this.street
		if (this.building != undefined) res['building'] = this.building
		if (this.buildingNumber != undefined) res['buildingNumber'] = this.buildingNumber
		if (this.doorbellName != undefined) res['doorbellName'] = this.doorbellName
		if (this.floor != undefined) res['floor'] = this.floor
		if (this.letterBox != undefined) res['letterBox'] = this.letterBox
		if (this.notesOps != undefined) res['notesOps'] = this.notesOps
		if (this.notesContact != undefined) res['notesContact'] = this.notesContact
		if (this.latitude != undefined) res['latitude'] = this.latitude
		if (this.longitude != undefined) res['longitude'] = this.longitude
		if (this.type != undefined) res['type'] = this.type
		if (this.emergency != undefined) res['emergency'] = this.emergency
		if (this.phoneNumber != undefined) res['phoneNumber'] = this.phoneNumber
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.patientLastName != undefined) res['patientLastName'] = this.patientLastName
		if (this.patientFirstName != undefined) res['patientFirstName'] = this.patientFirstName
		if (this.description != undefined) res['description'] = this.description
		if (this.interventionCode != undefined) res['interventionCode'] = this.interventionCode
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['FlowItem']): FlowItem {
		return new FlowItem({
			id: expectString(json.id, true, [...path, ".id"]),
			title: expectString(json.title, true, [...path, ".title"]),
			comment: expectString(json.comment, true, [...path, ".comment"]),
			receptionDate: expectNumber(json.receptionDate, true, true, [...path, ".receptionDate"]),
			processingDate: expectNumber(json.processingDate, true, true, [...path, ".processingDate"]),
			processer: expectString(json.processer, true, [...path, ".processer"]),
			cancellationDate: expectNumber(json.cancellationDate, true, true, [...path, ".cancellationDate"]),
			canceller: expectString(json.canceller, true, [...path, ".canceller"]),
			cancellationReason: expectString(json.cancellationReason, true, [...path, ".cancellationReason"]),
			cancellationNote: expectString(json.cancellationNote, true, [...path, ".cancellationNote"]),
			status: expectString(json.status, true, [...path, ".status"]),
			homeVisit: expectBoolean(json.homeVisit, true, [...path, ".homeVisit"]),
			municipality: expectString(json.municipality, true, [...path, ".municipality"]),
			town: expectString(json.town, true, [...path, ".town"]),
			zipCode: expectString(json.zipCode, true, [...path, ".zipCode"]),
			street: expectString(json.street, true, [...path, ".street"]),
			building: expectString(json.building, true, [...path, ".building"]),
			buildingNumber: expectString(json.buildingNumber, true, [...path, ".buildingNumber"]),
			doorbellName: expectString(json.doorbellName, true, [...path, ".doorbellName"]),
			floor: expectString(json.floor, true, [...path, ".floor"]),
			letterBox: expectString(json.letterBox, true, [...path, ".letterBox"]),
			notesOps: expectString(json.notesOps, true, [...path, ".notesOps"]),
			notesContact: expectString(json.notesContact, true, [...path, ".notesContact"]),
			latitude: expectString(json.latitude, true, [...path, ".latitude"]),
			longitude: expectString(json.longitude, true, [...path, ".longitude"]),
			type: expectString(json.type, true, [...path, ".type"]),
			emergency: expectBoolean(json.emergency, true, [...path, ".emergency"]),
			phoneNumber: expectString(json.phoneNumber, true, [...path, ".phoneNumber"]),
			patientId: expectString(json.patientId, true, [...path, ".patientId"]),
			patientLastName: expectString(json.patientLastName, true, [...path, ".patientLastName"]),
			patientFirstName: expectString(json.patientFirstName, true, [...path, ".patientFirstName"]),
			description: expectString(json.description, true, [...path, ".description"]),
			interventionCode: expectString(json.interventionCode, true, [...path, ".interventionCode"]),
		})
	}

}
