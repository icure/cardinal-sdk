// auto-generated file
import {Versionable} from './Versionable.mjs';


/**
 *
 *
 *   Interface for entities that are persisted as CouchDB documents and support hard deletion via a
 *  deletion timestamp.
 */
export interface StoredDocument extends Versionable<string> {

	deletionDate: number | undefined;

}
