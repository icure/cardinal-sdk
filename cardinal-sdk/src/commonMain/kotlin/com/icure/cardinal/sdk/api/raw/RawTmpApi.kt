package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.utils.InternalIcureApi
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawTmpApi {
	// region cloud endpoints

	suspend fun createTmpDatabase(): HttpResponse<Unit>

	suspend fun destroyTmpDatabase(): HttpResponse<Unit>

	suspend fun replicateToTmpDatabase(
		from: String,
		ids: List<String>,
	): HttpResponse<ReplicatorDocument>

	suspend fun getTmpPatient(id: String): HttpResponse<EncryptedPatient>

	suspend fun createTmpPatient(c: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun modifyTmpPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient>

	suspend fun getTmpPatients(ids: List<String>): HttpResponse<List<EncryptedPatient>>

	suspend fun modifyTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>>

	suspend fun createTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>>

	suspend fun listTmpPatients(
		firstPatientId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedPatient>>

	suspend fun getTmpHealthElement(id: String): HttpResponse<EncryptedHealthElement>

	suspend fun createTmpHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun modifyTmpHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun getTmpHealthElements(ids: List<String>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun modifyTmpHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun createTmpHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun listTmpHealthElements(
		firstHealthElementId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedHealthElement>>

	suspend fun getTmpForm(id: String): HttpResponse<EncryptedForm>

	suspend fun createTmpForm(c: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun modifyTmpForm(formDto: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun getTmpForms(ids: List<String>): HttpResponse<List<EncryptedForm>>

	suspend fun modifyTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun createTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun listTmpForms(
		firstFormId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedForm>>

	suspend fun getTmpContact(id: String): HttpResponse<EncryptedContact>

	suspend fun createTmpContact(c: EncryptedContact): HttpResponse<EncryptedContact>

	suspend fun modifyTmpContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact>

	suspend fun getTmpContacts(ids: List<String>): HttpResponse<List<EncryptedContact>>

	suspend fun modifyTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>>

	suspend fun createTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>>

	suspend fun listTmpContacts(
		firstContactId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>>

	suspend fun getTmpMessage(id: String): HttpResponse<EncryptedMessage>

	suspend fun createTmpMessage(c: EncryptedMessage): HttpResponse<EncryptedMessage>

	suspend fun modifyTmpMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage>

	suspend fun getTmpMessages(ids: List<String>): HttpResponse<List<EncryptedMessage>>

	suspend fun modifyTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>>

	suspend fun createTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>>

	suspend fun listTmpMessages(
		firstMessageId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>>

	suspend fun getTmpInvoice(id: String): HttpResponse<EncryptedInvoice>

	suspend fun createTmpInvoice(c: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun modifyTmpInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun getTmpInvoices(ids: List<String>): HttpResponse<List<EncryptedInvoice>>

	suspend fun modifyTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun createTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun listTmpInvoices(
		firstInvoiceId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>>

	suspend fun getTmpDocument(id: String): HttpResponse<EncryptedDocument>

	suspend fun getTmpDocumentAttachment(
		documentId: String,
		attachmentId: String,
		enckeys: String? = null,
		fileName: String? = null,
	): HttpResponse<ByteArray>

	suspend fun deleteTmpDocumentAttachment(documentId: String): HttpResponse<EncryptedDocument>

	suspend fun setTmpDocumentAttachment(
		documentId: String,
		enckeys: String? = null,
		payload: ByteArray,
	): HttpResponse<EncryptedDocument>

	suspend fun createTmpDocument(c: EncryptedDocument): HttpResponse<EncryptedDocument>

	suspend fun modifyTmpDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument>

	suspend fun getTmpDocuments(ids: List<String>): HttpResponse<List<EncryptedDocument>>

	suspend fun modifyTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>>

	suspend fun createTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>>

	suspend fun listTmpDocuments(
		firstDocumentId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedDocument>>

	suspend fun getTmpClassification(id: String): HttpResponse<EncryptedClassification>

	suspend fun createTmpClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun modifyTmpClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun getTmpClassifications(ids: List<String>): HttpResponse<List<EncryptedClassification>>

	suspend fun modifyTmpClassifications(classificationDtos: List<EncryptedClassification>): HttpResponse<List<EncryptedClassification>>

	suspend fun createTmpClassifications(classificationDtos: List<EncryptedClassification>): HttpResponse<List<EncryptedClassification>>

	suspend fun listTmpClassifications(
		firstClassificationId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EncryptedClassification>>

	suspend fun getTmpEntityTemplate(id: String): HttpResponse<EntityTemplate>

	suspend fun createTmpEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate>

	suspend fun modifyTmpEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate>

	suspend fun getTmpEntityTemplates(ids: List<String>): HttpResponse<List<EntityTemplate>>

	suspend fun modifyTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>>

	suspend fun createTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>>

	suspend fun listTmpEntityTemplates(
		firstEntityTemplateId: String? = null,
		pageSize: Int? = null,
	): HttpResponse<PaginatedList<EntityTemplate>>

	suspend fun deleteTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>>

	suspend fun purgeTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>>
	// endregion
}
