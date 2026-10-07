// auto-generated file
import {expectBoolean, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Represents a flow item in a waiting room or patient flow management system, tracking reception,
 *  processing, and cancellation of patient visits including location and contact details.
 *  /
 */
export class FlowItem {

	/**
	 *
	 *  The unique identifier of this flow item.
	 */
	id: string | undefined = undefined;

	/**
	 *
	 *  The title or summary of the flow item.
	 */
	title: string | undefined = undefined;

	/**
	 *
	 *  A comment associated with the flow item.
	 */
	comment: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the patient was received.
	 */
	receptionDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when processing started.
	 */
	processingDate: number | undefined = undefined;

	/**
	 *
	 *  The identifier of the person processing this flow item.
	 */
	processer: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when this flow item was cancelled.
	 */
	cancellationDate: number | undefined = undefined;

	/**
	 *
	 *  The identifier of the person who cancelled this flow item.
	 */
	canceller: string | undefined = undefined;

	/**
	 *
	 *  The reason for cancellation.
	 */
	cancellationReason: string | undefined = undefined;

	/**
	 *
	 *  Additional notes about the cancellation.
	 */
	cancellationNote: string | undefined = undefined;

	/**
	 *
	 *  The current status of the flow item.
	 */
	status: string | undefined = undefined;

	/**
	 *
	 *  Whether this flow item represents a home visit.
	 */
	homeVisit: boolean | undefined = undefined;

	/**
	 *
	 *  The municipality for the visit location.
	 */
	municipality: string | undefined = undefined;

	/**
	 *
	 *  The town for the visit location.
	 */
	town: string | undefined = undefined;

	/**
	 *
	 *  The postal code for the visit location.
	 */
	zipCode: string | undefined = undefined;

	/**
	 *
	 *  The street name for the visit location.
	 */
	street: string | undefined = undefined;

	/**
	 *
	 *  The building name for the visit location.
	 */
	building: string | undefined = undefined;

	/**
	 *
	 *  The building number for the visit location.
	 */
	buildingNumber: string | undefined = undefined;

	/**
	 *
	 *  The doorbell name at the visit location.
	 */
	doorbellName: string | undefined = undefined;

	/**
	 *
	 *  The floor at the visit location.
	 */
	floor: string | undefined = undefined;

	/**
	 *
	 *  The letter box identifier at the visit location.
	 */
	letterBox: string | undefined = undefined;

	/**
	 *
	 *  Operational notes.
	 */
	notesOps: string | undefined = undefined;

	/**
	 *
	 *  Contact notes.
	 */
	notesContact: string | undefined = undefined;

	/**
	 *
	 *  The latitude coordinate of the visit location.
	 */
	latitude: string | undefined = undefined;

	/**
	 *
	 *  The longitude coordinate of the visit location.
	 */
	longitude: string | undefined = undefined;

	/**
	 *
	 *  The type of flow item.
	 */
	type: string | undefined = undefined;

	/**
	 *
	 *  Whether this is an emergency visit.
	 */
	emergency: boolean | undefined = undefined;

	/**
	 *
	 *  The phone number of the patient.
	 */
	phoneNumber: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the patient.
	 */
	patientId: string | undefined = undefined;

	/**
	 *
	 *  The last name of the patient.
	 */
	patientLastName: string | undefined = undefined;

	/**
	 *
	 *  The first name of the patient.
	 */
	patientFirstName: string | undefined = undefined;

	/**
	 *
	 *  A description of the flow item.
	 */
	description: string | undefined = undefined;

	/**
	 *
	 *  The intervention code associated with the flow item.
	 */
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
