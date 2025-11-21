// auto-generated file
import {expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {AuthenticationClass} from '../embed/AuthenticationClass.mjs';


export class ExternalJwtConfig {

	validationMethod: ExternalJwtConfig.ValidationMethod;

	fieldSelector: ExternalJwtConfig.FieldSelector;

	authenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication;

	constructor(partial: Partial<ExternalJwtConfig> & Pick<ExternalJwtConfig, "validationMethod" | "fieldSelector">) {
		this.validationMethod = partial.validationMethod;
		this.fieldSelector = partial.fieldSelector;
		if ('authenticationClass' in partial && partial.authenticationClass !== undefined) this.authenticationClass = partial.authenticationClass;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['validationMethod'] = this.validationMethod.toJSON()
		res['fieldSelector'] = this.fieldSelector.toJSON()
		res['authenticationClass'] = this.authenticationClass
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ExternalJwtConfig']): ExternalJwtConfig {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ExternalJwtConfig({
			validationMethod: expectObject(extractEntry(jCpy, 'validationMethod', true, path), false, ignoreUnknownKeys, [...path, ".validationMethod"], ExternalJwtConfig.ValidationMethod.fromJSON),
			fieldSelector: expectObject(extractEntry(jCpy, 'fieldSelector', true, path), false, ignoreUnknownKeys, [...path, ".fieldSelector"], ExternalJwtConfig.FieldSelector.fromJSON),
			authenticationClass: expectStringEnum(extractEntry(jCpy, 'authenticationClass', false, path), false, [...path, ".authenticationClass"], AuthenticationClass, 'AuthenticationClass'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ExternalJwtConfig at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace ExternalJwtConfig {

	export namespace ValidationMethod {

		export class PublicKey {

			key: string;

			signatureAlgorithm: string | undefined = undefined;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey';

			constructor(partial: Partial<PublicKey> & Pick<PublicKey, "key">) {
				this.key = partial.key;
				if ('signatureAlgorithm' in partial) this.signatureAlgorithm = partial.signatureAlgorithm;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['key'] = this.key
				if (this.signatureAlgorithm != undefined) res['signatureAlgorithm'] = this.signatureAlgorithm
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['PublicKey']): PublicKey {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey". The provided json doesn't represent a PublicKey`)
				const res = new PublicKey({
					key: expectString(extractEntry(jCpy, 'key', true, path), false, [...path, ".key"]),
					signatureAlgorithm: expectString(extractEntry(jCpy, 'signatureAlgorithm', false, path), true, [...path, ".signatureAlgorithm"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PublicKey at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class Oidc {

			issureLocation: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc';

			constructor(partial: Partial<Oidc> & Pick<Oidc, "issureLocation">) {
				this.issureLocation = partial.issureLocation;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['issureLocation'] = this.issureLocation
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Oidc']): Oidc {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc". The provided json doesn't represent a Oidc`)
				const res = new Oidc({
					issureLocation: expectString(extractEntry(jCpy, 'issureLocation', true, path), false, [...path, ".issureLocation"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Oidc at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['ValidationMethod']): ValidationMethod {
			switch ((json as ValidationMethod).$ktClass) {
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey': return PublicKey.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc': return Oidc.fromJSON(json, ignoreUnknownKeys)
				default: throw new Error('Unexpected discriminator for ValidationMethod: ' + json.$ktClass)
			}
		}

	}

	export type ValidationMethod = ValidationMethod.PublicKey | ValidationMethod.Oidc;

	export namespace FieldSelector {

		export class LocalId {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId';

			constructor(partial: Partial<LocalId> & Pick<LocalId, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['LocalId']): LocalId {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId". The provided json doesn't represent a LocalId`)
				const res = new LocalId({
					fieldName: expectString(extractEntry(jCpy, 'fieldName', true, path), false, [...path, ".fieldName"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LocalId at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class Email {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email';

			constructor(partial: Partial<Email> & Pick<Email, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Email']): Email {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email". The provided json doesn't represent a Email`)
				const res = new Email({
					fieldName: expectString(extractEntry(jCpy, 'fieldName', true, path), false, [...path, ".fieldName"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Email at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class MobilePhone {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone';

			constructor(partial: Partial<MobilePhone> & Pick<MobilePhone, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['MobilePhone']): MobilePhone {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone". The provided json doesn't represent a MobilePhone`)
				const res = new MobilePhone({
					fieldName: expectString(extractEntry(jCpy, 'fieldName', true, path), false, [...path, ".fieldName"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object MobilePhone at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class Username {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username';

			constructor(partial: Partial<Username> & Pick<Username, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Username']): Username {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username". The provided json doesn't represent a Username`)
				const res = new Username({
					fieldName: expectString(extractEntry(jCpy, 'fieldName', true, path), false, [...path, ".fieldName"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Username at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export class Identifier {

			identifierAssigner: string;

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier';

			constructor(partial: Partial<Identifier> & Pick<Identifier, "identifierAssigner" | "fieldName">) {
				this.identifierAssigner = partial.identifierAssigner;
				this.fieldName = partial.fieldName;
			}

			toJSON(): object {
				const res: { [k: string]: any } = {}
				res['identifierAssigner'] = this.identifierAssigner
				res['fieldName'] = this.fieldName
				res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier'
				return res
			}

			static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
					path: Array<string> = ['Identifier']): Identifier {
				if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
				const jCpy = { ...json }
				if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier". The provided json doesn't represent a Identifier`)
				const res = new Identifier({
					identifierAssigner: expectString(extractEntry(jCpy, 'identifierAssigner', true, path), false, [...path, ".identifierAssigner"]),
					fieldName: expectString(extractEntry(jCpy, 'fieldName', true, path), false, [...path, ".fieldName"]),
				})
				if (!ignoreUnknownKeys) {
					const unused = Object.keys(jCpy)
					if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Identifier at path ${path.join("")}: ${unused}`)}
				return res
			}

		}

		export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['FieldSelector']): FieldSelector {
			switch ((json as FieldSelector).$ktClass) {
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId': return LocalId.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email': return Email.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone': return MobilePhone.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username': return Username.fromJSON(json, ignoreUnknownKeys)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier': return Identifier.fromJSON(json, ignoreUnknownKeys)
				default: throw new Error('Unexpected discriminator for FieldSelector: ' + json.$ktClass)
			}
		}

	}

	export type FieldSelector = FieldSelector.LocalId | FieldSelector.Email | FieldSelector.MobilePhone | FieldSelector.Username | FieldSelector.Identifier;

}
