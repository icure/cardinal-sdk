// auto-generated file
import {expectNumber, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


/**
 *
 *  The error that aborted a page of results, reported in the body of an otherwise successful
 *  response.
 *  /
 */
export class PaginationError {

	/**
	 *
	 *  The status code the request would have failed with, had the error been found before returning
	 *  any result.
	 */
	statusCode: number;

	/**
	 *
	 *  A human readable description of what went wrong.
	 */
	message: string;

	/**
	 *
	 *  A machine readable discriminator for the error, for the errors that define one.
	 */
	exceptionDetail: string | undefined = undefined;

	constructor(partial: Partial<PaginationError> & Pick<PaginationError, "statusCode" | "message">) {
		this.statusCode = partial.statusCode;
		this.message = partial.message;
		if ('exceptionDetail' in partial) this.exceptionDetail = partial.exceptionDetail;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['statusCode'] = this.statusCode
		res['message'] = this.message
		if (this.exceptionDetail != undefined) res['exceptionDetail'] = this.exceptionDetail
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PaginationError']): PaginationError {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PaginationError({
			statusCode: expectNumber(extractEntry(jCpy, 'statusCode', true, path), false, true, [...path, ".statusCode"]),
			message: expectString(extractEntry(jCpy, 'message', true, path), false, [...path, ".message"]),
			exceptionDetail: expectString(extractEntry(jCpy, 'exceptionDetail', false, path), true, [...path, ".exceptionDetail"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PaginationError at path ${path.join("")}: ${unused}`)}
		return res
	}

}
