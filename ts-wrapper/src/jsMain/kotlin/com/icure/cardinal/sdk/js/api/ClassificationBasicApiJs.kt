// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ClassificationJs
import com.icure.cardinal.sdk.js.model.EncryptedClassificationJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationBasicApi")
public external interface ClassificationBasicApiJs {
	public fun matchClassificationsBy(filter: BaseFilterOptionsJs<ClassificationJs>): Promise<Array<String>>

	public fun matchClassificationsBySorted(filter: BaseSortableFilterOptionsJs<ClassificationJs>): Promise<Array<String>>

	public fun filterClassificationsBy(filter: BaseFilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>>

	public fun filterClassificationsBySorted(filter: BaseSortableFilterOptionsJs<ClassificationJs>): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>>

	public fun deleteClassification(entityId: String): Promise<DocIdentifierJs>

	public fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun createClassification(entity: EncryptedClassificationJs): Promise<EncryptedClassificationJs>

	public fun modifyClassification(entity: EncryptedClassificationJs): Promise<EncryptedClassificationJs>

	public fun getClassification(entityId: String): Promise<EncryptedClassificationJs?>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<EncryptedClassificationJs>>
}
