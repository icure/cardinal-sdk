package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawFormApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.FormAbstractFilterSerializer
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
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawFormApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawFormApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Form,
		)

	// region common endpoints

	override suspend fun getForm(formId: String): HttpResponse<EncryptedForm> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", formId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getForms(formIds: ListOfIds): HttpResponse<List<EncryptedForm>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun getFormByLogicalUuid(logicalUuid: String): HttpResponse<EncryptedForm> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "logicalUuid", logicalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormsByLogicalUuid(logicalUuid: String): HttpResponse<List<EncryptedForm>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "all", "logicalUuid", logicalUuid)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormsByUniqueId(uniqueId: String): HttpResponse<List<EncryptedForm>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "all", "uniqueId", uniqueId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormByUniqueId(uniqueId: String): HttpResponse<EncryptedForm> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "uniqueId", uniqueId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getChildrenForms(
		formId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedForm>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "childrenOf", formId, hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createForm(ft: EncryptedForm): HttpResponse<EncryptedForm> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun modifyForm(formDto: EncryptedForm): HttpResponse<EncryptedForm> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDto)
		}.wrap()

	override suspend fun deleteForms(formIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun deleteFormsWithRev(formIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun deleteForm(
		formId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", formId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteForm(
		formId: String,
		rev: String,
	): HttpResponse<EncryptedForm> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "undelete", formId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteForms(formIds: ListOfIdsAndRev): HttpResponse<List<EncryptedForm>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun purgeForm(
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "purge", formId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeForms(formIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun modifyForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun createForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun listFormIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "byDataOwnerPatientOpeningDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findFormsDelegationsStubsByIds(formIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean?,
	): HttpResponse<FormTemplate> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", formTemplateId)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		loadLayout: Boolean?,
		raw: Boolean?,
	): HttpResponse<List<FormTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "bySpecialty", specialityCode)
				parameter("loadLayout", loadLayout)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormTemplates(
		loadLayout: Boolean?,
		raw: Boolean?,
	): HttpResponse<List<FormTemplate>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template")
				parameter("loadLayout", loadLayout)
				parameter("raw", raw)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormTemplates(formTemplateIds: ListOfIds): HttpResponse<List<FormTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun createFormTemplate(ft: FormTemplate): HttpResponse<FormTemplate> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun modifyFormTemplate(ft: FormTemplate): HttpResponse<FormTemplate> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun createFormTemplates(formTemplates: List<FormTemplate>): HttpResponse<List<FormTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplates)
		}.wrap()

	override suspend fun modifyFormTemplates(formTemplates: List<FormTemplate>): HttpResponse<List<FormTemplate>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplates)
		}.wrap()

	override suspend fun deleteFormTemplates(formTemplateIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun deleteFormTemplate(
		formTemplateId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", formTemplateId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteFormTemplate(
		formTemplateId: String,
		rev: String,
	): HttpResponse<FormTemplate> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "undelete", formTemplateId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteFormTemplates(formTemplateIds: ListOfIdsAndRev): HttpResponse<List<FormTemplate>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun purgeFormTemplate(
		formTemplateId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "purge", formTemplateId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeFormTemplatesWithRev(formTemplateIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun setTemplateAttachment(
		formTemplateId: String,
		payload: ByteArray,
	): HttpResponse<String> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", formTemplateId, "attachment")
			}
			accept(Application.Json)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedForm>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchFormsBy(filter: AbstractFilter<Form>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FormAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createFormInGroup(
		groupId: String,
		formDto: EncryptedForm,
	): HttpResponse<EncryptedForm> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDto)
		}.wrap()

	override suspend fun createFormsInGroup(
		groupId: String,
		formDtos: List<EncryptedForm>,
	): HttpResponse<List<EncryptedForm>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun modifyFormInGroup(
		groupId: String,
		formDto: EncryptedForm,
	): HttpResponse<EncryptedForm> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDto)
		}.wrap()

	override suspend fun modifyFormsInGroup(
		groupId: String,
		formDtos: List<EncryptedForm>,
	): HttpResponse<List<EncryptedForm>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formDtos)
		}.wrap()

	override suspend fun getFormInGroup(
		groupId: String,
		formId: String,
	): HttpResponse<EncryptedForm> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, formId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormsInGroup(
		groupId: String,
		formIds: ListOfIds,
	): HttpResponse<List<EncryptedForm>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun deleteFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, formId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun undeleteFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<EncryptedForm> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "undelete", formId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedForm>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun purgeFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "purge", formId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedForm>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchFormsInGroupBy(
		filter: AbstractFilter<Form>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FormAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getFormTemplatesByUserInGroup(
		groupId: String,
		userId: String,
		loadLayout: Boolean?,
	): HttpResponse<List<FormTemplate>> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "byUser", userId)
				parameter("loadLayout", loadLayout)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getFormTemplatesBySpecialtyInGroup(
		groupId: String,
		specialityCode: String,
		loadLayout: Boolean?,
	): HttpResponse<List<FormTemplate>> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "bySpecialty", specialityCode)
				parameter("loadLayout", loadLayout)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createFormTemplateInGroup(
		groupId: String,
		ft: FormTemplate,
	): HttpResponse<FormTemplate> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun deleteFormTemplateInGroup(
		groupId: String,
		formTemplateId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, formTemplateId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteFormTemplatesInGroup(
		groupId: String,
		formTemplateIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun undeleteFormTemplatesInGroup(
		groupId: String,
		formTemplateIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<FormTemplate>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIdsAndRevs)
		}.wrap()

	override suspend fun undeleteFormTemplateInGroup(
		groupId: String,
		formTemplateTypeId: String,
		rev: String,
	): HttpResponse<FormTemplate> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "undelete", formTemplateTypeId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeFormTemplateInGroup(
		groupId: String,
		formTemplateId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "purge", formTemplateId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeFormTemplatesInGroup(
		groupId: String,
		formTemplateIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun modifyFormTemplateInGroup(
		groupId: String,
		ft: FormTemplate,
	): HttpResponse<FormTemplate> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun setTemplateAttachmentInGroup(
		groupId: String,
		formTemplateId: String,
		payload: ByteArray,
	): HttpResponse<String> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, formTemplateId, "attachment")
			}
			accept(Application.Json)
			setBody(ByteArrayContent(payload, Application.OctetStream))
		}.wrap()

	override suspend fun createFormTemplatesInGroup(
		groupId: String,
		formTemplates: List<FormTemplate>,
	): HttpResponse<List<FormTemplate>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplates)
		}.wrap()

	override suspend fun modifyFormTemplatesInGroup(
		groupId: String,
		formTemplates: List<FormTemplate>,
	): HttpResponse<List<FormTemplate>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplates)
		}.wrap()

	override suspend fun getFormTemplatesInGroup(
		groupId: String,
		formTemplateIds: ListOfIds,
	): HttpResponse<List<FormTemplate>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formTemplateIds)
		}.wrap()

	override suspend fun getFormTemplateInGroup(
		groupId: String,
		formTemplateId: String,
	): HttpResponse<FormTemplate> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "form", "template", "inGroup", groupId, formTemplateId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
