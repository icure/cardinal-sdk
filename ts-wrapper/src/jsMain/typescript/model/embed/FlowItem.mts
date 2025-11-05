// auto-generated file
import {expectBoolean, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	toJSON(): object {
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['FlowItem']): FlowItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new FlowItem({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			title: expectString(extractEntry(jCpy, 'title', false, path), true, [...path, ".title"]),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			receptionDate: expectNumber(extractEntry(jCpy, 'receptionDate', false, path), true, true, [...path, ".receptionDate"]),
			processingDate: expectNumber(extractEntry(jCpy, 'processingDate', false, path), true, true, [...path, ".processingDate"]),
			processer: expectString(extractEntry(jCpy, 'processer', false, path), true, [...path, ".processer"]),
			cancellationDate: expectNumber(extractEntry(jCpy, 'cancellationDate', false, path), true, true, [...path, ".cancellationDate"]),
			canceller: expectString(extractEntry(jCpy, 'canceller', false, path), true, [...path, ".canceller"]),
			cancellationReason: expectString(extractEntry(jCpy, 'cancellationReason', false, path), true, [...path, ".cancellationReason"]),
			cancellationNote: expectString(extractEntry(jCpy, 'cancellationNote', false, path), true, [...path, ".cancellationNote"]),
			status: expectString(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"]),
			homeVisit: expectBoolean(extractEntry(jCpy, 'homeVisit', false, path), true, [...path, ".homeVisit"]),
			municipality: expectString(extractEntry(jCpy, 'municipality', false, path), true, [...path, ".municipality"]),
			town: expectString(extractEntry(jCpy, 'town', false, path), true, [...path, ".town"]),
			zipCode: expectString(extractEntry(jCpy, 'zipCode', false, path), true, [...path, ".zipCode"]),
			street: expectString(extractEntry(jCpy, 'street', false, path), true, [...path, ".street"]),
			building: expectString(extractEntry(jCpy, 'building', false, path), true, [...path, ".building"]),
			buildingNumber: expectString(extractEntry(jCpy, 'buildingNumber', false, path), true, [...path, ".buildingNumber"]),
			doorbellName: expectString(extractEntry(jCpy, 'doorbellName', false, path), true, [...path, ".doorbellName"]),
			floor: expectString(extractEntry(jCpy, 'floor', false, path), true, [...path, ".floor"]),
			letterBox: expectString(extractEntry(jCpy, 'letterBox', false, path), true, [...path, ".letterBox"]),
			notesOps: expectString(extractEntry(jCpy, 'notesOps', false, path), true, [...path, ".notesOps"]),
			notesContact: expectString(extractEntry(jCpy, 'notesContact', false, path), true, [...path, ".notesContact"]),
			latitude: expectString(extractEntry(jCpy, 'latitude', false, path), true, [...path, ".latitude"]),
			longitude: expectString(extractEntry(jCpy, 'longitude', false, path), true, [...path, ".longitude"]),
			type: expectString(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"]),
			emergency: expectBoolean(extractEntry(jCpy, 'emergency', false, path), true, [...path, ".emergency"]),
			phoneNumber: expectString(extractEntry(jCpy, 'phoneNumber', false, path), true, [...path, ".phoneNumber"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			patientLastName: expectString(extractEntry(jCpy, 'patientLastName', false, path), true, [...path, ".patientLastName"]),
			patientFirstName: expectString(extractEntry(jCpy, 'patientFirstName', false, path), true, [...path, ".patientFirstName"]),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
			interventionCode: expectString(extractEntry(jCpy, 'interventionCode', false, path), true, [...path, ".interventionCode"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FlowItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}
