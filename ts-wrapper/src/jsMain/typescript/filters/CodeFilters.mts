// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalCodeFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Code} from '../model/Code.mjs';


interface CodeFiltersFactory {

	/**
	 *
	 *  Filter options to match all codes.
	 *  These options are not sortable.
	 */
	all(): BaseFilterOptions<Code>;

	/**
	 *
	 *  Filter options that match all codes with one of the provided ids.
	 *  These options are sortable. When sorting using these options the codes will have the same order as the input ids.
	 *
	 *  @param ids a list of unique code ids.
	 *  @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	byIds(ids: Array<string>): BaseSortableFilterOptions<Code>;

	/**
	 *
	 *  Filter options to match all codes that have [linkType] as key in [Code.qualifiedLinks] and, if [linkedId] is not null, that have
	 *  [linkedId] as value in [Code.qualifiedLinks] for the key [linkType].
	 *
	 *  @param linkType a key that can be found in [Code.qualifiedLinks].
	 *  @param linkedId a value of [Code.qualifiedLinks] for the key [linkType].
	 */
	byQualifiedLink(linkType: string,
			options?: { linkedId?: string | undefined }): BaseFilterOptions<Code>;

	/**
	 *
	 *  Filter options to match all the codes in a specific [region] that can also match a [type], a [code], and a [version].
	 *  If [type] is provided, only the codes with that [Code.type] will be returned.
	 *  If [code] is provided, only the codes with that [Code.code] will be returned.
	 *  As for [version], three options are available:
	 *  - if it is null, the filter will return all the existing versions for each code.
	 *  - if it is the string "latest", the filter will return only the latest version for each code (i.e. the greatest semantic version or
	 *  the greatest in lexicographical order if the versions are not in semantic format).
	 *  - any other non-null value will be interpreted as a specific version and the filter will return only the codes with
	 *  that specific [Code.version].
	 *  Note: if "latest" is used, then this filter cannot be used in WebSocket.
	 *
	 *  @param region the region of the codes. Only the codes with that value in [Code.regions] will be returned.
	 *  @param type the [Code.type].
	 *  @param code the [Code.code].
	 *  @param version a value to filter the [Code.version]s. If provided, it can be a specific version or the string "latest". In this last
	 *  case, only the latest version (i.e. the greatest semantic version or the greatest in lexicographical order if the versions are not
	 *  in semantic format) will be returned. Also, the "latest" option makes the filter not suitable for the WebSocket connection.
	 *  @throws IllegalArgumentException if [code] is not null but [type] is null or if [version] is not null but [code] is null.
	 */
	byRegionTypeCodeVersion(region: string,
			options?: { type?: string | undefined, code?: string | undefined, version?: string | undefined }): BaseFilterOptions<Code>;

	/**
	 *
	 *  Filter options to match all codes with the provided [type] that have a [Code.label] or [Code.searchTerms] for the
	 *  provided [language].
	 *  Optionally, you can also limit the filter to match only codes where that contain some search string ([label]) in
	 *  the [Code.label] or [Code.searchTerms] for the chosen [language].
	 *  Finally, if you limit your search by a label you can further limit the search to only include codes for a specific
	 *  [region].
	 *  Note: you can't limit the search to a specific [region] without providing a [label]. If you want to get
	 *  all codes of a certain type for a specific [region] you should instead use [byRegionTypeCodeVersion].
	 *  These options are not sortable.
	 *
	 *  @param language the language in ISO standard of the label. Only the codes that have this language as key
	 *  in the [Code.label] or in the [Code.searchTerms] will be included in the result.
	 *  @param type the type of the code. Only the codes with this `type` will be included in the result.
	 *  @param label a search string. If provided, then the filter will match only codes that have word of at least 3
	 *  characters starting with this search string in any of the following properties:
	 *  - the [Code.label] for the specified [language]
	 *  - the [Code.searchTerms] for the specified [language]
	 *  @param region if provided, only the codes that have this region in the [Code.regions] list will be included in
	 *  the result. If None, the resulting codes will not be filtered based on the region.
	 *  @throws IllegalArgumentException if region is provided but label is not.
	 */
	byLanguageTypeLabelRegion(language: string, type: string,
			options?: { label?: string | undefined, region?: string | undefined }): BaseFilterOptions<Code>;

	/**
	 *
	 *  Filter options to match all codes with one of the provided [types] that have a [Code.label] or [Code.searchTerms] for the
	 *  provided [language].
	 *  Also, only codes where that contain some search string ([label]) in the [Code.label] or [Code.searchTerms] for the chosen [language].
	 *  If you limit your search by a label you can further limit the search to only include codes for a specific
	 *  [region].
	 *  Finally, you can also restrict the version of the matched codes by using [version]:
	 *  - if it is null, the filter will return all the existing versions for each code.
	 *  - if it is the string "latest", the filter will return only the latest version for each code (i.e. the greatest semantic version or
	 *  the greatest in lexicographical order if the versions are not in semantic format).
	 *  - any other non-null value will be interpreted as a specific version and the filter will return only the codes with
	 *  that specific [Code.version].
	 *  Note: you can't limit the search to a specific [region] without providing a [label]. If you want to get
	 *  all codes of a certain type for a specific [region] you should instead use [byRegionTypeCodeVersion].
	 *  These options are not sortable.
	 *
	 *  @param language the language in ISO standard of the label. Only the codes that have this language as key
	 *  in the [Code.label] or in the [Code.searchTerms] will be included in the result.
	 *  @param types one or more types of the codes.
	 *  @param label a search string. The filter will match only codes that have word of at least 3 characters starting with this search
	 *  string in any of the following properties:
	 *  - the [Code.label] for the specified [language]
	 *  - the [Code.searchTerms] for the specified [language]
	 *  @param region if provided, only the codes that have this region in the [Code.regions] list will be included in
	 *  the result. If None, the resulting codes will not be filtered based on the region.
	 *  @param version a value to filter the [Code.version]s. If provided, it can be a specific version or the string "latest". In this last
	 *  case, only the latest version (i.e. the greatest semantic version or the greatest in lexicographical order if the versions are not
	 *  in semantic format) will be returned. Also, the "latest" option makes the filter not suitable for the WebSocket connection.
	 *  @throws IllegalArgumentException if region is provided but label is not.
	 */
	byLanguageTypesLabelRegionVersion(language: string, types: Array<string>, label: string,
			options?: { region?: string | undefined, version?: string | undefined }): BaseFilterOptions<Code>;

}

export const CodeFilters: CodeFiltersFactory = {
			all: () => InternalCodeFiltersObj.getInstance().all(),
			byIds: (ids) => InternalCodeFiltersObj.getInstance().byIds(ids),
			byQualifiedLink: (linkType, options) => InternalCodeFiltersObj.getInstance().byQualifiedLink(linkType, options),
			byRegionTypeCodeVersion: (region, options) => InternalCodeFiltersObj.getInstance().byRegionTypeCodeVersion(region, options),
			byLanguageTypeLabelRegion: (language, type, options) => InternalCodeFiltersObj.getInstance().byLanguageTypeLabelRegion(language, type, options),
			byLanguageTypesLabelRegionVersion: (language, types, label, options) => InternalCodeFiltersObj.getInstance().byLanguageTypesLabelRegionVersion(language, types, label, options)
		};
