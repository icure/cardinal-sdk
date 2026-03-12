// auto-generated file
import {PaginatedDocumentKeyIdPair} from './PaginatedDocumentKeyIdPair.mjs';


/**
 *
 *  Generic DTO representing a paginated list of results. Contains the current page of rows
 *  and a key pair for fetching the next page.
 *
 *  @param T The type of elements in the paginated list.
 *  /
 */
export class PaginatedList<T> {

	/**
	 *
	 *  The list of results for the current page.
	 */
	rows: Array<T> = [];

	/**
	 *
	 *  The key-document ID pair to use for fetching the next page of results, or null if this is the
	 *  last page.
	 */
	nextKeyPair: PaginatedDocumentKeyIdPair | undefined = undefined;

	constructor(partial: Partial<PaginatedList<T>>) {
		if ('rows' in partial && partial.rows !== undefined) this.rows = partial.rows;
		if ('nextKeyPair' in partial) this.nextKeyPair = partial.nextKeyPair;
	}

}
