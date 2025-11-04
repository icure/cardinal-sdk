// auto-generated file
import {expectNumber, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['paymentDate'] = this.paymentDate
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Payment']): Payment {
		return new Payment({
			paymentDate: expectNumber(json.paymentDate, false, true, [...path, ".paymentDate"]),
			paymentType: expectStringEnum(json.paymentType, true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(json.paid, true, false, [...path, ".paid"]),
		})
	}

}
