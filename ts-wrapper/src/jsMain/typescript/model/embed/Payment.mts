// auto-generated file
import {expectNumber, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {PaymentType} from './PaymentType.mjs';


export class Payment {

	paymentDate: number = 0;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	constructor(partial: Partial<Payment>) {
		if ('paymentDate' in partial && partial.paymentDate !== undefined) this.paymentDate = partial.paymentDate;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['paymentDate'] = this.paymentDate
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Payment']): Payment {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Payment({
			paymentDate: expectNumber(extractEntry(jCpy, 'paymentDate', false, path), false, true, [...path, ".paymentDate"]),
			paymentType: expectStringEnum(extractEntry(jCpy, 'paymentType', false, path), true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(extractEntry(jCpy, 'paid', false, path), true, false, [...path, ".paid"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Payment at path ${path.join("")}: ${unused}`)}
		return res
	}

}
