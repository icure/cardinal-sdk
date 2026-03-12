// auto-generated file
import {HasCodes} from './HasCodes.mjs';
import {HasTags} from './HasTags.mjs';
import {Identifiable} from './Identifiable.mjs';


/**
 *
 *
 *   Interface for iCure document entities that track creation and modification metadata.
 *   Extends [IdentifiableDto], [HasTagsDto], and [HasCodesDto] to provide a common base for all
 *  medical documents.
 */
export interface ICureDocument<T> extends Identifiable<T>, HasTags, HasCodes {

	created: number | undefined;

	modified: number | undefined;

	author: string | undefined;

	responsible: string | undefined;

}
