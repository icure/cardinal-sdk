// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.HealthElementShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EncryptedHealthElementJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.HealthElementJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthElementApi")
public external interface HealthElementApiJs {
	public val encrypted: HealthElementFlavouredApiJs<EncryptedHealthElementJs>

	public val tryAndRecover: HealthElementFlavouredApiJs<HealthElementJs>

	public val inGroup: HealthElementInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedHealthElementJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedHealthElementJs>

	public fun getEncryptionKeysOf(healthElement: HealthElementJs): Promise<Array<String>>

	public fun hasWriteAccess(healthElement: HealthElementJs): Promise<Boolean>

	public fun decryptPatientIdOf(healthElement: HealthElementJs):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: HealthElementJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(healthElements: Array<EncryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun tryDecrypt(healthElements: Array<EncryptedHealthElementJs>):
			Promise<Array<HealthElementJs>>

	public fun encryptOrValidate(healthElements: Array<HealthElementJs>):
			Promise<Array<EncryptedHealthElementJs>>

	public fun matchHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>): Promise<Array<String>>

	public fun matchHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<Array<String>>

	public fun deleteHealthElementById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeHealthElementById(id: String, rev: String): Promise<Unit>

	public fun purgeHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteHealthElement(healthElement: HealthElementJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeHealthElement(healthElement: HealthElementJs): Promise<Unit>

	public fun purgeHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		healthElement: DecryptedHealthElementJs,
		options: dynamic,
	): Promise<DecryptedHealthElementJs>

	public fun shareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>): Promise<DecryptedHealthElementJs>

	public fun filterHealthElementsBy(filter: FilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>>

	public fun filterHealthElementsBySorted(filter: SortableFilterOptionsJs<HealthElementJs>):
			Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>>

	public fun createHealthElement(entity: DecryptedHealthElementJs): Promise<DecryptedHealthElementJs>

	public fun createHealthElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun undeleteHealthElementById(id: String, rev: String): Promise<DecryptedHealthElementJs>

	public fun undeleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun undeleteHealthElement(healthElement: HealthElementJs): Promise<DecryptedHealthElementJs>

	public fun undeleteHealthElements(healthElements: Array<HealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun modifyHealthElement(entity: DecryptedHealthElementJs): Promise<DecryptedHealthElementJs>

	public fun modifyHealthElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun getHealthElement(entityId: String): Promise<DecryptedHealthElementJs?>

	public fun getHealthElements(entityIds: Array<String>): Promise<Array<DecryptedHealthElementJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<HealthElementJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedHealthElementJs>>
}
