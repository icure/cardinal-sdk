// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalHealthcarePartyFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface HealthcarePartyFiltersFactory {

	all(): BaseFilterOptions<HealthcareParty>;

	byIdentifiers(identifiers: Array<Identifier>): BaseFilterOptions<HealthcareParty>;

	byCode(codeType: string,
			options?: { codeCode?: string | undefined }): BaseSortableFilterOptions<HealthcareParty>;

	byTag(tagType: string,
			options?: { tagCode?: string | undefined }): BaseSortableFilterOptions<HealthcareParty>;

	byIds(ids: Array<string>): SortableFilterOptions<HealthcareParty>;

	byName(searchString: string,
			options?: { descending?: boolean }): BaseSortableFilterOptions<HealthcareParty>;

	byNationalIdentifier(searchString: string,
			options?: { descending?: boolean }): BaseSortableFilterOptions<HealthcareParty>;

	byParentId(parentId: string): BaseFilterOptions<HealthcareParty>;

}

export const HealthcarePartyFilters: HealthcarePartyFiltersFactory = {
			all: () => InternalHealthcarePartyFiltersObj.getInstance().all(),
			byIdentifiers: (identifiers) => InternalHealthcarePartyFiltersObj.getInstance().byIdentifiers(identifiers),
			byCode: (codeType, options) => InternalHealthcarePartyFiltersObj.getInstance().byCode(codeType, options),
			byTag: (tagType, options) => InternalHealthcarePartyFiltersObj.getInstance().byTag(tagType, options),
			byIds: (ids) => InternalHealthcarePartyFiltersObj.getInstance().byIds(ids),
			byName: (searchString, options) => InternalHealthcarePartyFiltersObj.getInstance().byName(searchString, options),
			byNationalIdentifier: (searchString, options) => InternalHealthcarePartyFiltersObj.getInstance().byNationalIdentifier(searchString, options),
			byParentId: (parentId) => InternalHealthcarePartyFiltersObj.getInstance().byParentId(parentId)
		};
