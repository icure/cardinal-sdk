// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


/**
 *
 *  Represents a medicinal product with its intended and actually delivered codes and names.
 *  /
 */
export class Medicinalproduct {

	/**
	 *
	 *  The list of coded identifiers for the intended medicinal product.
	 */
	intendedcds: Array<CodeStub> = [];

	/**
	 *
	 *  The list of coded identifiers for the actually delivered medicinal product.
	 */
	deliveredcds: Array<CodeStub> = [];

	/**
	 *
	 *  The name of the intended medicinal product.
	 */
	intendedname: string | undefined = undefined;

	/**
	 *
	 *  The name of the actually delivered medicinal product.
	 */
	deliveredname: string | undefined = undefined;

	/**
	 *
	 *  The product identifier.
	 */
	productId: string | undefined = undefined;

	constructor(partial: Partial<Medicinalproduct>) {
		if ('intendedcds' in partial && partial.intendedcds !== undefined) this.intendedcds = partial.intendedcds;
		if ('deliveredcds' in partial && partial.deliveredcds !== undefined) this.deliveredcds = partial.deliveredcds;
		if ('intendedname' in partial) this.intendedname = partial.intendedname;
		if ('deliveredname' in partial) this.deliveredname = partial.deliveredname;
		if ('productId' in partial) this.productId = partial.productId;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['intendedcds'] = this.intendedcds.map((x0) => x0.toJSON() )
		res['deliveredcds'] = this.deliveredcds.map((x0) => x0.toJSON() )
		if (this.intendedname != undefined) res['intendedname'] = this.intendedname
		if (this.deliveredname != undefined) res['deliveredname'] = this.deliveredname
		if (this.productId != undefined) res['productId'] = this.productId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Medicinalproduct']): Medicinalproduct {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Medicinalproduct({
			intendedcds: expectArray(extractEntry(jCpy, 'intendedcds', false, path), false, [...path, ".intendedcds"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deliveredcds: expectArray(extractEntry(jCpy, 'deliveredcds', false, path), false, [...path, ".deliveredcds"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			intendedname: expectString(extractEntry(jCpy, 'intendedname', false, path), true, [...path, ".intendedname"]),
			deliveredname: expectString(extractEntry(jCpy, 'deliveredname', false, path), true, [...path, ".deliveredname"]),
			productId: expectString(extractEntry(jCpy, 'productId', false, path), true, [...path, ".productId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Medicinalproduct at path ${path.join("")}: ${unused}`)}
		return res
	}

}
