// auto-generated file

/**
 *
 *  Information on how to update the splits for a specific key.
 */
export class ShamirUpdateRequest {

	/**
	 *
	 *  The ids of the data owners which will hold a copy of the key part.
	 */
	notariesIds: Array<string>;

	/**
	 *
	 *  The minimum number of shares required to reconstruct the key.
	 */
	minShares: number;

	constructor(partial: Partial<ShamirUpdateRequest> & Pick<ShamirUpdateRequest, "notariesIds" | "minShares">) {
		this.notariesIds = partial.notariesIds;
		this.minShares = partial.minShares;
	}

}
