// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.RelatedPersonFilters
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.Identifier
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalRelatedPersonFiltersObj {
	public fun allRelatedPersonsForDataOwner(dataOwnerId: String):
			BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = RelatedPersonFilters.allRelatedPersonsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allRelatedPersonsForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs):
			BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val result = RelatedPersonFilters.allRelatedPersonsForDataOwnerInGroup(
			dataOwnerConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allRelatedPersonsForSelf(): FilterOptionsJs<RelatedPersonJs> {
		val result = RelatedPersonFilters.allRelatedPersonsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwner(dataOwnerId: String, identifiers: Array<IdentifierJs>):
			BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = RelatedPersonFilters.byIdentifiersForDataOwner(
			dataOwnerIdConverted,
			identifiersConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs,
			identifiers: Array<IdentifierJs>): BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = RelatedPersonFilters.byIdentifiersForDataOwnerInGroup(
			dataOwnerConverted,
			identifiersConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIdentifiersForSelf(identifiers: Array<IdentifierJs>):
			FilterOptionsJs<RelatedPersonJs> {
		val identifiersConverted: List<Identifier> = arrayToList(
			identifiers,
			"identifiers",
			{ x1: IdentifierJs ->
				identifier_fromJs(x1)
			},
		)
		val result = RelatedPersonFilters.byIdentifiersForSelf(
			identifiersConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byNameForDataOwner(dataOwnerId: String, name: String):
			BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val nameConverted: String = name
		val result = RelatedPersonFilters.byNameForDataOwner(
			dataOwnerIdConverted,
			nameConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byNameForDataOwnerInGroup(dataOwner: EntityReferenceInGroupJs, name: String):
			BaseFilterOptionsJs<RelatedPersonJs> {
		val dataOwnerConverted: EntityReferenceInGroup = entityReferenceInGroup_fromJs(dataOwner)
		val nameConverted: String = name
		val result = RelatedPersonFilters.byNameForDataOwnerInGroup(
			dataOwnerConverted,
			nameConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byNameForSelf(name: String): FilterOptionsJs<RelatedPersonJs> {
		val nameConverted: String = name
		val result = RelatedPersonFilters.byNameForSelf(
			nameConverted,
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<RelatedPersonJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = RelatedPersonFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
