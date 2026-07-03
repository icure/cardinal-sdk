package com.icure.cardinal.sdk.model.filter

/**
 * A set of factory methods that produce the same kind of filter, differing only in how parameters are
 * passed (for-self vs. for-data-owner, in-group variants, full entities vs. secret ids).
 *
 * @property name a short semantic name for the group (the operation, without the parameter-passing suffixes).
 * @property factoryMethods the names of the factory methods of the corresponding `XFilters` object that
 * belong to this group, in source order.
 * @property targetFilter the simple name of the `AbstractFilter` actually sent to the backend (or the
 * possible filters, separated by " or ", for the rare groups that branch on their input).
 * @property views the views that are used on the backend to provide the results for the options in this group.
 */
data class FilterOptionGroupWithViews(
	val name: String,
	val factoryMethods: List<String>,
	val targetFilter: String,
	val views: List<String>
)
