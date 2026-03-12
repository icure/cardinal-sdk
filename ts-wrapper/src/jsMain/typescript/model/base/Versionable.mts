// auto-generated file
import {Identifiable} from './Identifiable.mjs';


/**
 *
 *
 *   @param <T> The type of the entity identity (a String, a UUID, etc.)
 *  </T>
 */
export interface Versionable<T> extends Identifiable<T> {

	rev: string | undefined;

}
