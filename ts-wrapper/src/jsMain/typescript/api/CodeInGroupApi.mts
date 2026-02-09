// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Code} from '../model/Code.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface CodeInGroupApi {

	createCode(code: GroupScoped<Code>): Promise<GroupScoped<Code>>;

	createCodes(codes: Array<GroupScoped<Code>>): Promise<Array<GroupScoped<Code>>>;

	getCode(groupId: string, codeId: string): Promise<GroupScoped<Code> | undefined>;

	getCodes(groupId: string, codesIds: Array<string>): Promise<Array<GroupScoped<Code>>>;

	modifyCode(code: GroupScoped<Code>): Promise<GroupScoped<Code>>;

	modifyCodes(codes: Array<GroupScoped<Code>>): Promise<Array<GroupScoped<Code>>>;

	deleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCodeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteCode(code: GroupScoped<Code>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCodes(codes: Array<GroupScoped<Code>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<Code>>;

	undeleteCodeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<Code>>>;

	undeleteCode(code: GroupScoped<Code>): Promise<GroupScoped<Code>>;

	undeleteCodes(codes: Array<GroupScoped<Code>>): Promise<Array<GroupScoped<Code>>>;

	purgeCodeById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeCodeByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCode(code: GroupScoped<Code>): Promise<void>;

	purgeCodes(codes: Array<GroupScoped<Code>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	filterCodesBy(groupId: string,
			filter: BaseFilterOptions<Code>): Promise<PaginatedListIterator<GroupScoped<Code>>>;

	filterCodesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Code>): Promise<PaginatedListIterator<GroupScoped<Code>>>;

	matchCodesBy(groupId: string, filter: BaseFilterOptions<Code>): Promise<Array<string>>;

	matchCodesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Code>): Promise<Array<string>>;

}
