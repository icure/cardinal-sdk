// auto-generated file
import {HasCodes} from './HasCodes.mjs';
import {HasTags} from './HasTags.mjs';
import {Identifiable} from './Identifiable.mjs';


export interface ICureDocument<T> extends Identifiable<T>, HasTags, HasCodes {

	created: number | undefined;

	modified: number | undefined;

	author: string | undefined;

	responsible: string | undefined;

}
