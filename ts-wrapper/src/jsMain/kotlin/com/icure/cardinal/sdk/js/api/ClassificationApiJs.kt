// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.BulkShareByIdsResultJs
import com.icure.cardinal.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ClassificationJs
import com.icure.cardinal.sdk.js.model.DecryptedClassificationJs
import com.icure.cardinal.sdk.js.model.EncryptedClassificationJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationApi")
public external interface ClassificationApiJs {
	public val encrypted: ClassificationFlavouredApiJs<EncryptedClassificationJs>

	public val tryAndRecover: ClassificationFlavouredApiJs<ClassificationJs>

	public fun withEncryptionMetadata(
		base: DecryptedClassificationJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedClassificationJs>

	public fun getEncryptionKeysOf(classification: ClassificationJs): Promise<Array<String>>

	public fun hasWriteAccess(classification: ClassificationJs): Promise<Boolean>

	public fun decryptPatientIdOf(classification: ClassificationJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: ClassificationJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(classification: EncryptedClassificationJs): Promise<DecryptedClassificationJs>

	public fun tryDecrypt(classification: EncryptedClassificationJs): Promise<ClassificationJs>

	public fun matchClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
			Promise<Array<String>>

	public fun matchClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
			Promise<Array<String>>

	public fun shareClassificationsByIds(classificationIds: Array<String>,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<BulkShareByIdsResultJs>

	public fun deleteClassification(entityId: String): Promise<DocIdentifierJs>

	public fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		classification: DecryptedClassificationJs,
		options: dynamic,
	): Promise<DecryptedClassificationJs>

	public fun shareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<DecryptedClassificationJs>

	public fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedClassificationJs>>

	public fun filterClassificationsBy(filter: FilterOptionsJs<ClassificationJs>):
			Promise<PaginatedListIteratorJs<DecryptedClassificationJs>>

	public fun filterClassificationsBySorted(filter: SortableFilterOptionsJs<ClassificationJs>):
			Promise<PaginatedListIteratorJs<DecryptedClassificationJs>>

	public fun createClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs>

	public fun modifyClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs>

	public fun getClassification(entityId: String): Promise<DecryptedClassificationJs?>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<DecryptedClassificationJs>>
}
