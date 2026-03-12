// auto-generated file
import {BaseFilterOptions, InternalFormTemplateFiltersObj} from '../cardinal-sdk-ts.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';


interface FormTemplateFiltersFactory {

	/**
	 *
	 *  Filter options that match all form template with the specified specialty code.
	 *
	 *  @param specialtyCode the specialty code.
	 */
	bySpecialtyCode(specialtyCode: string): BaseFilterOptions<FormTemplate>;

}

export const FormTemplateFilters: FormTemplateFiltersFactory = {
			bySpecialtyCode: (specialtyCode) => InternalFormTemplateFiltersObj.getInstance().bySpecialtyCode(specialtyCode)
		};
