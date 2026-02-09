// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {BooleanResponse} from '../model/BooleanResponse.mjs';
import {Code} from '../model/Code.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {CodeInGroupApi} from './CodeInGroupApi.mjs';


export interface CodeApi {

	inGroup: CodeInGroupApi;

	createCode(code: Code): Promise<Code>;

	createCodes(codes: Array<Code>): Promise<Array<Code>>;

	getCode(codeId: string): Promise<Code | undefined>;

	getCodes(codeIds: Array<string>): Promise<Array<Code>>;

	modifyCode(code: Code): Promise<Code>;

	modifyCodes(codes: Array<Code>): Promise<Array<Code>>;

	deleteCodeById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteCodeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteCode(code: Code): Promise<StoredDocumentIdentifier>;

	deleteCodes(codes: Array<Code>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteCodeById(entityId: string, rev: string): Promise<Code>;

	undeleteCodeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Code>>;

	undeleteCode(code: Code): Promise<Code>;

	undeleteCodes(codes: Array<Code>): Promise<Array<Code>>;

	purgeCodeById(entityId: string, rev: string): Promise<void>;

	purgeCodeByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCode(code: Code): Promise<void>;

	purgeCodes(codes: Array<Code>): Promise<Array<StoredDocumentIdentifier>>;

	listCodeTypesBy(options?: { region?: string | undefined, type?: string | undefined }): Promise<Array<string>>;

	listTagTypesBy(options?: { region?: string | undefined, type?: string | undefined }): Promise<Array<string>>;

	isCodeValid(type: string, code: string, version: string | undefined): Promise<BooleanResponse>;

	getCodeByRegionLanguageTypeLabel(region: string, label: string, type: string,
			languages: string | undefined): Promise<Code | undefined>;

	getCodeWithParts(type: string, code: string, version: string): Promise<Code | undefined>;

	filterCodesBy(filter: BaseFilterOptions<Code>): Promise<PaginatedListIterator<Code>>;

	filterCodesBySorted(filter: BaseSortableFilterOptions<Code>): Promise<PaginatedListIterator<Code>>;

	matchCodesBy(filter: BaseFilterOptions<Code>): Promise<Array<string>>;

	matchCodesBySorted(filter: BaseSortableFilterOptions<Code>): Promise<Array<string>>;

}
