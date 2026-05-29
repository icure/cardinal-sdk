// auto-generated file
import {expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *
 *   Request payload for enabling two-factor authentication (2FA) for a user account.
 */
export class Enable2faRequest {

	/**
	 *
	 *  The shared TOTP secret used to generate one-time passwords.
	 */
	secret: string;

	/**
	 *
	 *  The number of digits in each generated one-time password.
	 */
	otpLength: number;

	/**
	 *
	 *
	 *   The otp at the current time for the provided configuration
	 */
	otp: string;

	/**
	 *
	 *
	 *   If null defaults to SHA1 as many authenticator apps still do not support different algorithms
	 */
	algorithm: Enable2faRequest.Algorithm | undefined = undefined;

	constructor(partial: Partial<Enable2faRequest> & Pick<Enable2faRequest, "secret" | "otpLength" | "otp">) {
		this.secret = partial.secret;
		this.otpLength = partial.otpLength;
		this.otp = partial.otp;
		if ('algorithm' in partial) this.algorithm = partial.algorithm;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['secret'] = this.secret
		res['otpLength'] = this.otpLength
		res['otp'] = this.otp
		if (this.algorithm != undefined) res['algorithm'] = this.algorithm
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Enable2faRequest']): Enable2faRequest {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Enable2faRequest({
			secret: expectString(extractEntry(jCpy, 'secret', true, path), false, [...path, ".secret"]),
			otpLength: expectNumber(extractEntry(jCpy, 'otpLength', true, path), false, true, [...path, ".otpLength"]),
			otp: expectString(extractEntry(jCpy, 'otp', true, path), false, [...path, ".otp"]),
			algorithm: expectStringEnum(extractEntry(jCpy, 'algorithm', false, path), true, [...path, ".algorithm"], Enable2faRequest.Algorithm, 'Enable2faRequest.Algorithm'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Enable2faRequest at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace Enable2faRequest {

	export enum Algorithm {
		Sha1 = "Sha1",
		Sha256 = "Sha256",
		Sha512 = "Sha512"
	}

}
