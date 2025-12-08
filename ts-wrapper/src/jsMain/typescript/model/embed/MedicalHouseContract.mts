// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {ContractChangeType} from './ContractChangeType.mjs';
import {Encryptable} from './Encryptable.mjs';
import {MhcSignatureType} from './MhcSignatureType.mjs';
import {SuspensionReason} from './SuspensionReason.mjs';


export interface MedicalHouseContract extends Encryptable {

	contractId: string | undefined;

	validFrom: number | undefined;

	validTo: number | undefined;

	mmNihii: string | undefined;

	hcpId: string | undefined;

	changeType: ContractChangeType | undefined;

	parentContractId: string | undefined;

	changedBy: string | undefined;

	startOfContract: number | undefined;

	startOfCoverage: number | undefined;

	endOfContract: number | undefined;

	endOfCoverage: number | undefined;

	kine: boolean;

	gp: boolean;

	ptd: boolean;

	nurse: boolean;

	noKine: boolean;

	noGp: boolean;

	noNurse: boolean;

	unsubscriptionReasonId: number | undefined;

	ptdStart: number | undefined;

	ptdEnd: number | undefined;

	ptdLastInvoiced: number | undefined;

	startOfSuspension: number | undefined;

	endOfSuspension: number | undefined;

	suspensionReason: SuspensionReason | undefined;

	suspensionSource: string | undefined;

	forcedSuspension: boolean;

	signatureType: MhcSignatureType | undefined;

	status: number | undefined;

	options: { [ key: string ]: string };

	receipts: { [ key: string ]: string };

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedMedicalHouseContract {

	contractId: string | undefined = undefined;

	validFrom: number | undefined = undefined;

	validTo: number | undefined = undefined;

	mmNihii: string | undefined = undefined;

	hcpId: string | undefined = undefined;

	changeType: ContractChangeType | undefined = undefined;

	parentContractId: string | undefined = undefined;

	changedBy: string | undefined = undefined;

	startOfContract: number | undefined = undefined;

	startOfCoverage: number | undefined = undefined;

	endOfContract: number | undefined = undefined;

	endOfCoverage: number | undefined = undefined;

	kine: boolean = false;

	gp: boolean = false;

	ptd: boolean = false;

	nurse: boolean = false;

	noKine: boolean = false;

	noGp: boolean = false;

	noNurse: boolean = false;

	unsubscriptionReasonId: number | undefined = undefined;

	ptdStart: number | undefined = undefined;

	ptdEnd: number | undefined = undefined;

	ptdLastInvoiced: number | undefined = undefined;

	startOfSuspension: number | undefined = undefined;

	endOfSuspension: number | undefined = undefined;

	suspensionReason: SuspensionReason | undefined = undefined;

	suspensionSource: string | undefined = undefined;

	forcedSuspension: boolean = false;

	signatureType: MhcSignatureType | undefined = undefined;

	status: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	receipts: { [ key: string ]: string } = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedMedicalHouseContract>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('contractId' in partial) this.contractId = partial.contractId;
		if ('validFrom' in partial) this.validFrom = partial.validFrom;
		if ('validTo' in partial) this.validTo = partial.validTo;
		if ('mmNihii' in partial) this.mmNihii = partial.mmNihii;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('changeType' in partial) this.changeType = partial.changeType;
		if ('parentContractId' in partial) this.parentContractId = partial.parentContractId;
		if ('changedBy' in partial) this.changedBy = partial.changedBy;
		if ('startOfContract' in partial) this.startOfContract = partial.startOfContract;
		if ('startOfCoverage' in partial) this.startOfCoverage = partial.startOfCoverage;
		if ('endOfContract' in partial) this.endOfContract = partial.endOfContract;
		if ('endOfCoverage' in partial) this.endOfCoverage = partial.endOfCoverage;
		if ('kine' in partial && partial.kine !== undefined) this.kine = partial.kine;
		if ('gp' in partial && partial.gp !== undefined) this.gp = partial.gp;
		if ('ptd' in partial && partial.ptd !== undefined) this.ptd = partial.ptd;
		if ('nurse' in partial && partial.nurse !== undefined) this.nurse = partial.nurse;
		if ('noKine' in partial && partial.noKine !== undefined) this.noKine = partial.noKine;
		if ('noGp' in partial && partial.noGp !== undefined) this.noGp = partial.noGp;
		if ('noNurse' in partial && partial.noNurse !== undefined) this.noNurse = partial.noNurse;
		if ('unsubscriptionReasonId' in partial) this.unsubscriptionReasonId = partial.unsubscriptionReasonId;
		if ('ptdStart' in partial) this.ptdStart = partial.ptdStart;
		if ('ptdEnd' in partial) this.ptdEnd = partial.ptdEnd;
		if ('ptdLastInvoiced' in partial) this.ptdLastInvoiced = partial.ptdLastInvoiced;
		if ('startOfSuspension' in partial) this.startOfSuspension = partial.startOfSuspension;
		if ('endOfSuspension' in partial) this.endOfSuspension = partial.endOfSuspension;
		if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
		if ('suspensionSource' in partial) this.suspensionSource = partial.suspensionSource;
		if ('forcedSuspension' in partial && partial.forcedSuspension !== undefined) this.forcedSuspension = partial.forcedSuspension;
		if ('signatureType' in partial) this.signatureType = partial.signatureType;
		if ('status' in partial) this.status = partial.status;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.contractId != undefined) res['contractId'] = this.contractId
		if (this.validFrom != undefined) res['validFrom'] = this.validFrom
		if (this.validTo != undefined) res['validTo'] = this.validTo
		if (this.mmNihii != undefined) res['mmNihii'] = this.mmNihii
		if (this.hcpId != undefined) res['hcpId'] = this.hcpId
		if (this.changeType != undefined) res['changeType'] = this.changeType
		if (this.parentContractId != undefined) res['parentContractId'] = this.parentContractId
		if (this.changedBy != undefined) res['changedBy'] = this.changedBy
		if (this.startOfContract != undefined) res['startOfContract'] = this.startOfContract
		if (this.startOfCoverage != undefined) res['startOfCoverage'] = this.startOfCoverage
		if (this.endOfContract != undefined) res['endOfContract'] = this.endOfContract
		if (this.endOfCoverage != undefined) res['endOfCoverage'] = this.endOfCoverage
		res['kine'] = this.kine
		res['gp'] = this.gp
		res['ptd'] = this.ptd
		res['nurse'] = this.nurse
		res['noKine'] = this.noKine
		res['noGp'] = this.noGp
		res['noNurse'] = this.noNurse
		if (this.unsubscriptionReasonId != undefined) res['unsubscriptionReasonId'] = this.unsubscriptionReasonId
		if (this.ptdStart != undefined) res['ptdStart'] = this.ptdStart
		if (this.ptdEnd != undefined) res['ptdEnd'] = this.ptdEnd
		if (this.ptdLastInvoiced != undefined) res['ptdLastInvoiced'] = this.ptdLastInvoiced
		if (this.startOfSuspension != undefined) res['startOfSuspension'] = this.startOfSuspension
		if (this.endOfSuspension != undefined) res['endOfSuspension'] = this.endOfSuspension
		if (this.suspensionReason != undefined) res['suspensionReason'] = this.suspensionReason
		if (this.suspensionSource != undefined) res['suspensionSource'] = this.suspensionSource
		res['forcedSuspension'] = this.forcedSuspension
		if (this.signatureType != undefined) res['signatureType'] = this.signatureType
		if (this.status != undefined) res['status'] = this.status
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedMedicalHouseContract']): DecryptedMedicalHouseContract {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedMedicalHouseContract`)
		const res = new DecryptedMedicalHouseContract({
			contractId: expectString(extractEntry(jCpy, 'contractId', false, path), true, [...path, ".contractId"]),
			validFrom: expectNumber(extractEntry(jCpy, 'validFrom', false, path), true, true, [...path, ".validFrom"]),
			validTo: expectNumber(extractEntry(jCpy, 'validTo', false, path), true, true, [...path, ".validTo"]),
			mmNihii: expectString(extractEntry(jCpy, 'mmNihii', false, path), true, [...path, ".mmNihii"]),
			hcpId: expectString(extractEntry(jCpy, 'hcpId', false, path), true, [...path, ".hcpId"]),
			changeType: expectStringEnum(extractEntry(jCpy, 'changeType', false, path), true, [...path, ".changeType"], ContractChangeType, 'ContractChangeType'),
			parentContractId: expectString(extractEntry(jCpy, 'parentContractId', false, path), true, [...path, ".parentContractId"]),
			changedBy: expectString(extractEntry(jCpy, 'changedBy', false, path), true, [...path, ".changedBy"]),
			startOfContract: expectNumber(extractEntry(jCpy, 'startOfContract', false, path), true, true, [...path, ".startOfContract"]),
			startOfCoverage: expectNumber(extractEntry(jCpy, 'startOfCoverage', false, path), true, true, [...path, ".startOfCoverage"]),
			endOfContract: expectNumber(extractEntry(jCpy, 'endOfContract', false, path), true, true, [...path, ".endOfContract"]),
			endOfCoverage: expectNumber(extractEntry(jCpy, 'endOfCoverage', false, path), true, true, [...path, ".endOfCoverage"]),
			kine: expectBoolean(extractEntry(jCpy, 'kine', false, path), false, [...path, ".kine"]),
			gp: expectBoolean(extractEntry(jCpy, 'gp', false, path), false, [...path, ".gp"]),
			ptd: expectBoolean(extractEntry(jCpy, 'ptd', false, path), false, [...path, ".ptd"]),
			nurse: expectBoolean(extractEntry(jCpy, 'nurse', false, path), false, [...path, ".nurse"]),
			noKine: expectBoolean(extractEntry(jCpy, 'noKine', false, path), false, [...path, ".noKine"]),
			noGp: expectBoolean(extractEntry(jCpy, 'noGp', false, path), false, [...path, ".noGp"]),
			noNurse: expectBoolean(extractEntry(jCpy, 'noNurse', false, path), false, [...path, ".noNurse"]),
			unsubscriptionReasonId: expectNumber(extractEntry(jCpy, 'unsubscriptionReasonId', false, path), true, true, [...path, ".unsubscriptionReasonId"]),
			ptdStart: expectNumber(extractEntry(jCpy, 'ptdStart', false, path), true, true, [...path, ".ptdStart"]),
			ptdEnd: expectNumber(extractEntry(jCpy, 'ptdEnd', false, path), true, true, [...path, ".ptdEnd"]),
			ptdLastInvoiced: expectNumber(extractEntry(jCpy, 'ptdLastInvoiced', false, path), true, true, [...path, ".ptdLastInvoiced"]),
			startOfSuspension: expectNumber(extractEntry(jCpy, 'startOfSuspension', false, path), true, true, [...path, ".startOfSuspension"]),
			endOfSuspension: expectNumber(extractEntry(jCpy, 'endOfSuspension', false, path), true, true, [...path, ".endOfSuspension"]),
			suspensionReason: expectStringEnum(extractEntry(jCpy, 'suspensionReason', false, path), true, [...path, ".suspensionReason"], SuspensionReason, 'SuspensionReason'),
			suspensionSource: expectString(extractEntry(jCpy, 'suspensionSource', false, path), true, [...path, ".suspensionSource"]),
			forcedSuspension: expectBoolean(extractEntry(jCpy, 'forcedSuspension', false, path), false, [...path, ".forcedSuspension"]),
			signatureType: expectStringEnum(extractEntry(jCpy, 'signatureType', false, path), true, [...path, ".signatureType"], MhcSignatureType, 'MhcSignatureType'),
			status: expectNumber(extractEntry(jCpy, 'status', false, path), true, true, [...path, ".status"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			receipts: expectMap(
				extractEntry(jCpy, 'receipts', false, path),
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedMedicalHouseContract at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedMedicalHouseContract {

	contractId: string | undefined = undefined;

	validFrom: number | undefined = undefined;

	validTo: number | undefined = undefined;

	mmNihii: string | undefined = undefined;

	hcpId: string | undefined = undefined;

	changeType: ContractChangeType | undefined = undefined;

	parentContractId: string | undefined = undefined;

	changedBy: string | undefined = undefined;

	startOfContract: number | undefined = undefined;

	startOfCoverage: number | undefined = undefined;

	endOfContract: number | undefined = undefined;

	endOfCoverage: number | undefined = undefined;

	kine: boolean = false;

	gp: boolean = false;

	ptd: boolean = false;

	nurse: boolean = false;

	noKine: boolean = false;

	noGp: boolean = false;

	noNurse: boolean = false;

	unsubscriptionReasonId: number | undefined = undefined;

	ptdStart: number | undefined = undefined;

	ptdEnd: number | undefined = undefined;

	ptdLastInvoiced: number | undefined = undefined;

	startOfSuspension: number | undefined = undefined;

	endOfSuspension: number | undefined = undefined;

	suspensionReason: SuspensionReason | undefined = undefined;

	suspensionSource: string | undefined = undefined;

	forcedSuspension: boolean = false;

	signatureType: MhcSignatureType | undefined = undefined;

	status: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	receipts: { [ key: string ]: string } = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedMedicalHouseContract>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('contractId' in partial) this.contractId = partial.contractId;
		if ('validFrom' in partial) this.validFrom = partial.validFrom;
		if ('validTo' in partial) this.validTo = partial.validTo;
		if ('mmNihii' in partial) this.mmNihii = partial.mmNihii;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('changeType' in partial) this.changeType = partial.changeType;
		if ('parentContractId' in partial) this.parentContractId = partial.parentContractId;
		if ('changedBy' in partial) this.changedBy = partial.changedBy;
		if ('startOfContract' in partial) this.startOfContract = partial.startOfContract;
		if ('startOfCoverage' in partial) this.startOfCoverage = partial.startOfCoverage;
		if ('endOfContract' in partial) this.endOfContract = partial.endOfContract;
		if ('endOfCoverage' in partial) this.endOfCoverage = partial.endOfCoverage;
		if ('kine' in partial && partial.kine !== undefined) this.kine = partial.kine;
		if ('gp' in partial && partial.gp !== undefined) this.gp = partial.gp;
		if ('ptd' in partial && partial.ptd !== undefined) this.ptd = partial.ptd;
		if ('nurse' in partial && partial.nurse !== undefined) this.nurse = partial.nurse;
		if ('noKine' in partial && partial.noKine !== undefined) this.noKine = partial.noKine;
		if ('noGp' in partial && partial.noGp !== undefined) this.noGp = partial.noGp;
		if ('noNurse' in partial && partial.noNurse !== undefined) this.noNurse = partial.noNurse;
		if ('unsubscriptionReasonId' in partial) this.unsubscriptionReasonId = partial.unsubscriptionReasonId;
		if ('ptdStart' in partial) this.ptdStart = partial.ptdStart;
		if ('ptdEnd' in partial) this.ptdEnd = partial.ptdEnd;
		if ('ptdLastInvoiced' in partial) this.ptdLastInvoiced = partial.ptdLastInvoiced;
		if ('startOfSuspension' in partial) this.startOfSuspension = partial.startOfSuspension;
		if ('endOfSuspension' in partial) this.endOfSuspension = partial.endOfSuspension;
		if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
		if ('suspensionSource' in partial) this.suspensionSource = partial.suspensionSource;
		if ('forcedSuspension' in partial && partial.forcedSuspension !== undefined) this.forcedSuspension = partial.forcedSuspension;
		if ('signatureType' in partial) this.signatureType = partial.signatureType;
		if ('status' in partial) this.status = partial.status;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.contractId != undefined) res['contractId'] = this.contractId
		if (this.validFrom != undefined) res['validFrom'] = this.validFrom
		if (this.validTo != undefined) res['validTo'] = this.validTo
		if (this.mmNihii != undefined) res['mmNihii'] = this.mmNihii
		if (this.hcpId != undefined) res['hcpId'] = this.hcpId
		if (this.changeType != undefined) res['changeType'] = this.changeType
		if (this.parentContractId != undefined) res['parentContractId'] = this.parentContractId
		if (this.changedBy != undefined) res['changedBy'] = this.changedBy
		if (this.startOfContract != undefined) res['startOfContract'] = this.startOfContract
		if (this.startOfCoverage != undefined) res['startOfCoverage'] = this.startOfCoverage
		if (this.endOfContract != undefined) res['endOfContract'] = this.endOfContract
		if (this.endOfCoverage != undefined) res['endOfCoverage'] = this.endOfCoverage
		res['kine'] = this.kine
		res['gp'] = this.gp
		res['ptd'] = this.ptd
		res['nurse'] = this.nurse
		res['noKine'] = this.noKine
		res['noGp'] = this.noGp
		res['noNurse'] = this.noNurse
		if (this.unsubscriptionReasonId != undefined) res['unsubscriptionReasonId'] = this.unsubscriptionReasonId
		if (this.ptdStart != undefined) res['ptdStart'] = this.ptdStart
		if (this.ptdEnd != undefined) res['ptdEnd'] = this.ptdEnd
		if (this.ptdLastInvoiced != undefined) res['ptdLastInvoiced'] = this.ptdLastInvoiced
		if (this.startOfSuspension != undefined) res['startOfSuspension'] = this.startOfSuspension
		if (this.endOfSuspension != undefined) res['endOfSuspension'] = this.endOfSuspension
		if (this.suspensionReason != undefined) res['suspensionReason'] = this.suspensionReason
		if (this.suspensionSource != undefined) res['suspensionSource'] = this.suspensionSource
		res['forcedSuspension'] = this.forcedSuspension
		if (this.signatureType != undefined) res['signatureType'] = this.signatureType
		if (this.status != undefined) res['status'] = this.status
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedMedicalHouseContract']): EncryptedMedicalHouseContract {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedMedicalHouseContract`)
		const res = new EncryptedMedicalHouseContract({
			contractId: expectString(extractEntry(jCpy, 'contractId', false, path), true, [...path, ".contractId"]),
			validFrom: expectNumber(extractEntry(jCpy, 'validFrom', false, path), true, true, [...path, ".validFrom"]),
			validTo: expectNumber(extractEntry(jCpy, 'validTo', false, path), true, true, [...path, ".validTo"]),
			mmNihii: expectString(extractEntry(jCpy, 'mmNihii', false, path), true, [...path, ".mmNihii"]),
			hcpId: expectString(extractEntry(jCpy, 'hcpId', false, path), true, [...path, ".hcpId"]),
			changeType: expectStringEnum(extractEntry(jCpy, 'changeType', false, path), true, [...path, ".changeType"], ContractChangeType, 'ContractChangeType'),
			parentContractId: expectString(extractEntry(jCpy, 'parentContractId', false, path), true, [...path, ".parentContractId"]),
			changedBy: expectString(extractEntry(jCpy, 'changedBy', false, path), true, [...path, ".changedBy"]),
			startOfContract: expectNumber(extractEntry(jCpy, 'startOfContract', false, path), true, true, [...path, ".startOfContract"]),
			startOfCoverage: expectNumber(extractEntry(jCpy, 'startOfCoverage', false, path), true, true, [...path, ".startOfCoverage"]),
			endOfContract: expectNumber(extractEntry(jCpy, 'endOfContract', false, path), true, true, [...path, ".endOfContract"]),
			endOfCoverage: expectNumber(extractEntry(jCpy, 'endOfCoverage', false, path), true, true, [...path, ".endOfCoverage"]),
			kine: expectBoolean(extractEntry(jCpy, 'kine', false, path), false, [...path, ".kine"]),
			gp: expectBoolean(extractEntry(jCpy, 'gp', false, path), false, [...path, ".gp"]),
			ptd: expectBoolean(extractEntry(jCpy, 'ptd', false, path), false, [...path, ".ptd"]),
			nurse: expectBoolean(extractEntry(jCpy, 'nurse', false, path), false, [...path, ".nurse"]),
			noKine: expectBoolean(extractEntry(jCpy, 'noKine', false, path), false, [...path, ".noKine"]),
			noGp: expectBoolean(extractEntry(jCpy, 'noGp', false, path), false, [...path, ".noGp"]),
			noNurse: expectBoolean(extractEntry(jCpy, 'noNurse', false, path), false, [...path, ".noNurse"]),
			unsubscriptionReasonId: expectNumber(extractEntry(jCpy, 'unsubscriptionReasonId', false, path), true, true, [...path, ".unsubscriptionReasonId"]),
			ptdStart: expectNumber(extractEntry(jCpy, 'ptdStart', false, path), true, true, [...path, ".ptdStart"]),
			ptdEnd: expectNumber(extractEntry(jCpy, 'ptdEnd', false, path), true, true, [...path, ".ptdEnd"]),
			ptdLastInvoiced: expectNumber(extractEntry(jCpy, 'ptdLastInvoiced', false, path), true, true, [...path, ".ptdLastInvoiced"]),
			startOfSuspension: expectNumber(extractEntry(jCpy, 'startOfSuspension', false, path), true, true, [...path, ".startOfSuspension"]),
			endOfSuspension: expectNumber(extractEntry(jCpy, 'endOfSuspension', false, path), true, true, [...path, ".endOfSuspension"]),
			suspensionReason: expectStringEnum(extractEntry(jCpy, 'suspensionReason', false, path), true, [...path, ".suspensionReason"], SuspensionReason, 'SuspensionReason'),
			suspensionSource: expectString(extractEntry(jCpy, 'suspensionSource', false, path), true, [...path, ".suspensionSource"]),
			forcedSuspension: expectBoolean(extractEntry(jCpy, 'forcedSuspension', false, path), false, [...path, ".forcedSuspension"]),
			signatureType: expectStringEnum(extractEntry(jCpy, 'signatureType', false, path), true, [...path, ".signatureType"], MhcSignatureType, 'MhcSignatureType'),
			status: expectNumber(extractEntry(jCpy, 'status', false, path), true, true, [...path, ".status"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			receipts: expectMap(
				extractEntry(jCpy, 'receipts', false, path),
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedMedicalHouseContract at path ${path.join("")}: ${unused}`)}
		return res
	}

}
