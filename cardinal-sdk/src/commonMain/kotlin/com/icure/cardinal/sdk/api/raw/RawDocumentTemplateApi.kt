package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.DocumentTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDocumentTemplateApi {
	// region common endpoints

	suspend fun getDocumentTemplate(documentTemplateId: String): HttpResponse<DocumentTemplate>

	suspend fun deleteDocumentTemplates(documentTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun findDocumentTemplatesBySpeciality(
		specialityCode: String,
		loadAttachment: Boolean? = null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplatesByDocumentType(
		documentTypeCode: String,
		loadAttachment: Boolean? = null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplatesByDocumentTypeForCurrentUser(
		documentTypeCode: String,
		loadAttachment: Boolean? = null,
	): HttpResponse<List<DocumentTemplate>>

	suspend fun listDocumentTemplates(loadAttachment: Boolean? = null): HttpResponse<List<DocumentTemplate>>

	suspend fun findAllDocumentTemplates(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<DocumentTemplate>>

	suspend fun createDocumentTemplate(ft: DocumentTemplate): HttpResponse<DocumentTemplate>

	suspend fun modifyDocumentTemplate(
		documentTemplateId: String,
		ft: DocumentTemplate,
	): HttpResponse<DocumentTemplate>

	suspend fun getDocumentTemplateAttachment(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun getAttachmentText(
		documentTemplateId: String,
		attachmentId: String,
	): HttpResponse<ByteArray>

	suspend fun setDocumentTemplateAttachment(
		documentTemplateId: String,
		payload: ByteArray,
	): HttpResponse<DocumentTemplate>
	// endregion
}
