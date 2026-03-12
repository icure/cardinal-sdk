// auto-generated file

/**
 *
 *  Data class representing the details required to inject exchange data.
 */
export class ExchangeDataInjectionDetails {

	exchangeDataId: string;

	accessControlSecret: Int8Array;

	exchangeKey: Int8Array;

	sharedSignatureKey: Int8Array;

	verified: boolean;

	constructor(partial: Partial<ExchangeDataInjectionDetails> & Pick<ExchangeDataInjectionDetails, "exchangeDataId" | "accessControlSecret" | "exchangeKey" | "sharedSignatureKey" | "verified">) {
		this.exchangeDataId = partial.exchangeDataId;
		this.accessControlSecret = partial.accessControlSecret;
		this.exchangeKey = partial.exchangeKey;
		this.sharedSignatureKey = partial.sharedSignatureKey;
		this.verified = partial.verified;
	}

}
