// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ClassificationBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.ClassificationBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.ClassificationJs
import com.icure.cardinal.sdk.js.model.EncryptedClassificationJs
import com.icure.cardinal.sdk.js.model.classification_fromJs
import com.icure.cardinal.sdk.js.model.classification_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ClassificationBasicApiImplJs(
	private val classificationBasicApi: ClassificationBasicApi,
) : ClassificationBasicApiJs {
	override fun matchClassificationsBy(filter: BaseFilterOptionsJs<ClassificationJs>): Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Classification> = baseFilterOptions_fromJs(filter)
		val result = classificationBasicApi.matchClassificationsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchClassificationsBySorted(filter: BaseSortableFilterOptionsJs<ClassificationJs>): Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Classification> = baseSortableFilterOptions_fromJs(filter)
		val result = classificationBasicApi.matchClassificationsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterClassificationsBy(filter: BaseFilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Classification> = baseFilterOptions_fromJs(filter)
		val result = classificationBasicApi.filterClassificationsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedClassification ->
				classification_toJs(x1)
			},
		)
	}

	override fun filterClassificationsBySorted(filter: BaseSortableFilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Classification> = baseSortableFilterOptions_fromJs(filter)
		val result = classificationBasicApi.filterClassificationsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedClassification ->
				classification_toJs(x1)
			},
		)
	}

	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationBasicApi.deleteClassification(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationBasicApi.deleteClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun createClassification(entity: EncryptedClassificationJs): Promise<EncryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: EncryptedClassification = classification_fromJs(entity)
		val result = classificationBasicApi.createClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun modifyClassification(entity: EncryptedClassificationJs): Promise<EncryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: EncryptedClassification = classification_fromJs(entity)
		val result = classificationBasicApi.modifyClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun getClassification(entityId: String): Promise<EncryptedClassificationJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationBasicApi.getClassification(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				classification_toJs(nonNull1)
			}
		)
	}

	override fun getClassifications(entityIds: Array<String>): Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationBasicApi.getClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedClassification ->
				classification_toJs(x1)
			},
		)
	}
}
