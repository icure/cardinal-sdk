// auto-generated file
import {expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['validationMethod'] = this.validationMethod.toJSON()
		res['fieldSelector'] = this.fieldSelector.toJSON()
		res['authenticationClass'] = this.authenticationClass
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ExternalJwtConfig']): ExternalJwtConfig {
		return new ExternalJwtConfig({
			validationMethod: ExternalJwtConfig.ValidationMethod.fromJSON(requireEntry(json.validationMethod, 'validationMethod', path), [...path, ".validationMethod"]),
			fieldSelector: ExternalJwtConfig.FieldSelector.fromJSON(requireEntry(json.fieldSelector, 'fieldSelector', path), [...path, ".fieldSelector"]),
			authenticationClass: expectStringEnum(json.authenticationClass, false, [...path, ".authenticationClass"], AuthenticationClass, 'AuthenticationClass'),
		})
	}

}

export namespace ExternalJwtConfig {

	export namespace ValidationMethod {

		export class PublicKey {

			key: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey';

			constructor(partial: Partial<PublicKey> & Pick<PublicKey, "key">) {
				this.key = partial.key;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['key'] = this.key
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['PublicKey']): PublicKey {
				return new PublicKey({
					key: expectString(requireEntry(json.key, 'key', path), false, [...path, ".key"]),
				})
			}

		}

		export class Oidc {

			issureLocation: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc';

			constructor(partial: Partial<Oidc> & Pick<Oidc, "issureLocation">) {
				this.issureLocation = partial.issureLocation;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['issureLocation'] = this.issureLocation
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Oidc']): Oidc {
				return new Oidc({
					issureLocation: expectString(requireEntry(json.issureLocation, 'issureLocation', path), false, [...path, ".issureLocation"]),
				})
			}

		}

		export function fromJSON(json: any,
				path: Array<string> = ['ValidationMethod']): ValidationMethod {
			switch ((json as ValidationMethod).$ktClass) {
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey': return PublicKey.fromJSON(json)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc': return Oidc.fromJSON(json)
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

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['LocalId']): LocalId {
				return new LocalId({
					fieldName: expectString(requireEntry(json.fieldName, 'fieldName', path), false, [...path, ".fieldName"]),
				})
			}

		}

		export class Email {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email';

			constructor(partial: Partial<Email> & Pick<Email, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Email']): Email {
				return new Email({
					fieldName: expectString(requireEntry(json.fieldName, 'fieldName', path), false, [...path, ".fieldName"]),
				})
			}

		}

		export class MobilePhone {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone';

			constructor(partial: Partial<MobilePhone> & Pick<MobilePhone, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['MobilePhone']): MobilePhone {
				return new MobilePhone({
					fieldName: expectString(requireEntry(json.fieldName, 'fieldName', path), false, [...path, ".fieldName"]),
				})
			}

		}

		export class Username {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username';

			constructor(partial: Partial<Username> & Pick<Username, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['fieldName'] = this.fieldName
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Username']): Username {
				return new Username({
					fieldName: expectString(requireEntry(json.fieldName, 'fieldName', path), false, [...path, ".fieldName"]),
				})
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

			toJSON(): any {
				const res: { [k: string]: any } = {}
				res['identifierAssigner'] = this.identifierAssigner
				res['fieldName'] = this.fieldName
				return res
			}

			static fromJSON(json: any, path: Array<string> = ['Identifier']): Identifier {
				return new Identifier({
					identifierAssigner: expectString(requireEntry(json.identifierAssigner, 'identifierAssigner', path), false, [...path, ".identifierAssigner"]),
					fieldName: expectString(requireEntry(json.fieldName, 'fieldName', path), false, [...path, ".fieldName"]),
				})
			}

		}

		export function fromJSON(json: any, path: Array<string> = ['FieldSelector']): FieldSelector {
			switch ((json as FieldSelector).$ktClass) {
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId': return LocalId.fromJSON(json)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email': return Email.fromJSON(json)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone': return MobilePhone.fromJSON(json)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username': return Username.fromJSON(json)
				case 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier': return Identifier.fromJSON(json)
				default: throw new Error('Unexpected discriminator for FieldSelector: ' + json.$ktClass)
			}
		}

	}

	export type FieldSelector = FieldSelector.LocalId | FieldSelector.Email | FieldSelector.MobilePhone | FieldSelector.Username | FieldSelector.Identifier;

}
