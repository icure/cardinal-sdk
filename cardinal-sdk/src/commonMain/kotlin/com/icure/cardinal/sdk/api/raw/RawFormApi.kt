package com.icure.cardinal.sdk.api.raw

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
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawFormApi {
	// region common endpoints

	suspend fun getForm(formId: String): HttpResponse<EncryptedForm>

	suspend fun getForms(formIds: ListOfIds): HttpResponse<List<EncryptedForm>>

	suspend fun getFormByLogicalUuid(logicalUuid: String): HttpResponse<EncryptedForm>

	suspend fun getFormsByLogicalUuid(logicalUuid: String): HttpResponse<List<EncryptedForm>>

	suspend fun getFormsByUniqueId(uniqueId: String): HttpResponse<List<EncryptedForm>>

	suspend fun getFormByUniqueId(uniqueId: String): HttpResponse<EncryptedForm>

	suspend fun getChildrenForms(
		formId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedForm>>

	suspend fun createForm(ft: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun modifyForm(formDto: EncryptedForm): HttpResponse<EncryptedForm>

	suspend fun deleteForms(formIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteFormsWithRev(formIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteForm(
		formId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteForm(
		formId: String,
		rev: String,
	): HttpResponse<EncryptedForm>

	suspend fun undeleteForms(formIds: ListOfIdsAndRev): HttpResponse<List<EncryptedForm>>

	suspend fun purgeForm(
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeForms(formIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun modifyForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun createForms(formDtos: List<EncryptedForm>): HttpResponse<List<EncryptedForm>>

	suspend fun listFormIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findFormsDelegationsStubsByIds(formIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun getFormTemplate(
		formTemplateId: String,
		raw: Boolean? = null,
	): HttpResponse<FormTemplate>

	suspend fun listFormTemplatesBySpeciality(
		specialityCode: String,
		loadLayout: Boolean? = null,
		raw: Boolean? = null,
	): HttpResponse<List<FormTemplate>>

	suspend fun getFormTemplates(
		loadLayout: Boolean? = null,
		raw: Boolean? = null,
	): HttpResponse<List<FormTemplate>>

	suspend fun createFormTemplate(ft: FormTemplate): HttpResponse<FormTemplate>

	suspend fun deleteFormTemplate(formTemplateId: String): HttpResponse<DocIdentifier>

	suspend fun updateFormTemplate(
		formTemplateId: String,
		ft: FormTemplate,
	): HttpResponse<FormTemplate>

	suspend fun setTemplateAttachment(
		formTemplateId: String,
		payload: ByteArray,
	): HttpResponse<String>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedForm>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>

	suspend fun matchFormsBy(filter: AbstractFilter<Form>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun createFormInGroup(
		groupId: String,
		formDto: EncryptedForm,
	): HttpResponse<EncryptedForm>

	suspend fun createFormsInGroup(
		groupId: String,
		formDtos: List<EncryptedForm>,
	): HttpResponse<List<EncryptedForm>>

	suspend fun modifyFormInGroup(
		groupId: String,
		formDto: EncryptedForm,
	): HttpResponse<EncryptedForm>

	suspend fun modifyFormsInGroup(
		groupId: String,
		formDtos: List<EncryptedForm>,
	): HttpResponse<List<EncryptedForm>>

	suspend fun getFormInGroup(
		groupId: String,
		formId: String,
	): HttpResponse<EncryptedForm>

	suspend fun getFormsInGroup(
		groupId: String,
		formIds: ListOfIds,
	): HttpResponse<List<EncryptedForm>>

	suspend fun deleteFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun deleteFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<EncryptedForm>

	suspend fun undeleteFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedForm>>

	suspend fun purgeFormInGroup(
		groupId: String,
		formId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeFormsInGroup(
		groupId: String,
		formIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedForm>>>

	suspend fun matchFormsInGroupBy(
		filter: AbstractFilter<Form>,
		groupId: String,
	): HttpResponse<List<String>>
	// endregion
}
