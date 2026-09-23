package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawTmpApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
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
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.content.ByteArrayContent
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTmpApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawTmpApi {
	// region cloud endpoints

	override suspend fun createTmpDatabase(): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp")
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun destroyTmpDatabase(): HttpResponse<Unit> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun replicateToTmpDatabase(
		from: String,
		ids: List<String>,
	): HttpResponse<ReplicatorDocument> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "replicate", "from", from)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun getTmpPatient(id: String): HttpResponse<EncryptedPatient> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpPatient(c: EncryptedPatient): HttpResponse<EncryptedPatient> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpPatient(patientDto: EncryptedPatient): HttpResponse<EncryptedPatient> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDto)
		}.wrap()

	override suspend fun getTmpPatients(ids: List<String>): HttpResponse<List<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun createTmpPatients(patientDtos: List<EncryptedPatient>): HttpResponse<List<EncryptedPatient>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(patientDtos)
		}.wrap()

	override suspend fun listTmpPatients(
		firstPatientId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedPatient>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "patient", "list")
				parameter("firstPatientId", firstPatientId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpHealthElement(id: String): HttpResponse<EncryptedHealthElement> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun getTmpHealthElements(ids: List<String>): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpHealthElements(
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun createTmpHealthElements(
		healthElementDtos: List<EncryptedHealthElement>,
	): HttpResponse<List<EncryptedHealthElement>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun listTmpHealthElements(
		firstHealthElementId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedHealthElement>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "healthElement", "list")
				parameter("firstHealthElementId", firstHealthElementId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpForm(id: String): HttpResponse<EncryptedForm> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpForm(c: EncryptedForm): HttpResponse<EncryptedForm> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpForm(formDto: EncryptedForm): HttpResponse<EncryptedForm> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDto)
		}.wrap()

	override suspend fun getTmpForms(ids: List<String>): HttpResponse<List<EncryptedForm>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun createTmpForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun listTmpForms(
		firstFormId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedForm>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "form", "list")
				parameter("firstFormId", firstFormId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpContact(id: String): HttpResponse<EncryptedContact> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpContact(c: EncryptedContact): HttpResponse<EncryptedContact> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun getTmpContacts(ids: List<String>): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun createTmpContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun listTmpContacts(
		firstContactId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "contact", "list")
				parameter("firstContactId", firstContactId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpMessage(id: String): HttpResponse<EncryptedMessage> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpMessage(c: EncryptedMessage): HttpResponse<EncryptedMessage> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpMessage(messageDto: EncryptedMessage): HttpResponse<EncryptedMessage> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDto)
		}.wrap()

	override suspend fun getTmpMessages(ids: List<String>): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun createTmpMessages(messageDtos: List<EncryptedMessage>): HttpResponse<List<EncryptedMessage>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(messageDtos)
		}.wrap()

	override suspend fun listTmpMessages(
		firstMessageId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "message", "list")
				parameter("firstMessageId", firstMessageId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpInvoice(id: String): HttpResponse<EncryptedInvoice> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpInvoice(c: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDto)
		}.wrap()

	override suspend fun getTmpInvoices(ids: List<String>): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun createTmpInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun listTmpInvoices(
		firstInvoiceId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "invoice", "list")
				parameter("firstInvoiceId", firstInvoiceId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpDocument(id: String): HttpResponse<EncryptedDocument> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTmpDocumentAttachment(
		documentId: String,
		attachmentId: String,
		enckeys: String?,
		fileName: String?,
	): HttpResponse<ByteArray> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment", attachmentId)
				parameter("enckeys", enckeys)
				parameter("fileName", fileName)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.OctetStream)
		}.wrap()

	override suspend fun deleteTmpDocumentAttachment(documentId: String): HttpResponse<EncryptedDocument> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setTmpDocumentAttachment(
		documentId: String,
		enckeys: String?,
		payload: ByteArray,
	): HttpResponse<EncryptedDocument> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", documentId, "attachment")
				parameter("enckeys", enckeys)
			}
			accept(Application.Json)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun createTmpDocument(c: EncryptedDocument): HttpResponse<EncryptedDocument> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpDocument(documentDto: EncryptedDocument): HttpResponse<EncryptedDocument> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDto)
		}.wrap()

	override suspend fun getTmpDocuments(ids: List<String>): HttpResponse<List<EncryptedDocument>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun createTmpDocuments(documentDtos: List<EncryptedDocument>): HttpResponse<List<EncryptedDocument>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(documentDtos)
		}.wrap()

	override suspend fun listTmpDocuments(
		firstDocumentId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedDocument>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "document", "list")
				parameter("firstDocumentId", firstDocumentId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpClassification(id: String): HttpResponse<EncryptedClassification> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDto)
		}.wrap()

	override suspend fun getTmpClassifications(ids: List<String>): HttpResponse<List<EncryptedClassification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpClassifications(
		classificationDtos: List<EncryptedClassification>,
	): HttpResponse<List<EncryptedClassification>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDtos)
		}.wrap()

	override suspend fun createTmpClassifications(
		classificationDtos: List<EncryptedClassification>,
	): HttpResponse<List<EncryptedClassification>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(classificationDtos)
		}.wrap()

	override suspend fun listTmpClassifications(
		firstClassificationId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EncryptedClassification>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "classification", "list")
				parameter("firstClassificationId", firstClassificationId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun getTmpEntityTemplate(id: String): HttpResponse<EntityTemplate> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "byId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createTmpEntityTemplate(c: EntityTemplate): HttpResponse<EntityTemplate> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun modifyTmpEntityTemplate(entityTemplateDto: EntityTemplate): HttpResponse<EntityTemplate> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDto)
		}.wrap()

	override suspend fun getTmpEntityTemplates(ids: List<String>): HttpResponse<List<EntityTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "get")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrapList()

	override suspend fun modifyTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun createTmpEntityTemplates(entityTemplateDtos: List<EntityTemplate>): HttpResponse<List<EntityTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(entityTemplateDtos)
		}.wrap()

	override suspend fun listTmpEntityTemplates(
		firstEntityTemplateId: String?,
		pageSize: Int?,
	): HttpResponse<PaginatedList<EntityTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "entityTemplate", "list")
				parameter("firstEntityTemplateId", firstEntityTemplateId)
				parameter("pageSize", pageSize)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrapPaginatedList()

	override suspend fun deleteTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "batch", "delete")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun purgeTmpItems(ids: List<String>): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "tmp", "batch", "purge")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	// endregion
}
