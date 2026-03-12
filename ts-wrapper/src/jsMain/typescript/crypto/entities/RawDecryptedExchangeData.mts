// auto-generated file

/**
 *
 *  The raw decrypted content of an exchange data.
 *  @param exchangeDataId the id of the exchange data.
 *  @param exchangeKey the raw exchange key of the exchange data.
 *  @param accessControlSecret the raw access control secret of the exchange data.
 *  @param sharedSignatureKey the raw shared signature key of the exchange data.
 */
export class RawDecryptedExchangeData {

	exchangeDataId: string;

	exchangeKey: Int8Array;

	accessControlSecret: Int8Array;

	sharedSignatureKey: Int8Array;

	constructor(partial: Partial<RawDecryptedExchangeData> & Pick<RawDecryptedExchangeData, "exchangeDataId" | "exchangeKey" | "accessControlSecret" | "sharedSignatureKey">) {
		this.exchangeDataId = partial.exchangeDataId;
		this.exchangeKey = partial.exchangeKey;
		this.accessControlSecret = partial.accessControlSecret;
		this.sharedSignatureKey = partial.sharedSignatureKey;
	}

}
