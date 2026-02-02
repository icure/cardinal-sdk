package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawInvoiceApi {
	// region common endpoints

	suspend fun createInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun deleteInvoices(invoiceIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteInvoicesWithRev(invoiceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteInvoice(
		invoiceId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteInvoice(
		invoiceId: String,
		rev: String,
	): HttpResponse<EncryptedInvoice>

	suspend fun undeleteInvoices(invoiceIds: ListOfIdsAndRev): HttpResponse<List<EncryptedInvoice>>

	suspend fun purgeInvoice(
		invoiceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeInvoices(invoiceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getInvoice(invoiceId: String): HttpResponse<EncryptedInvoice>

	suspend fun getInvoices(invoiceIds: ListOfIds): HttpResponse<List<EncryptedInvoice>>

	suspend fun modifyInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun reassignInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice>

	suspend fun mergeTo(
		invoiceId: String,
		ids: ListOfIds,
	): HttpResponse<EncryptedInvoice>

	suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): HttpResponse<EncryptedInvoice>

	suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String? = null,
		invoiceId: String? = null,
		gracePeriod: Int? = null,
		invoicingCodes: List<EncryptedInvoicingCode>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long? = null,
		toDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedInvoice>>

	suspend fun listInvoiceIdsByDataOwnerPatientInvoiceDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun listInvoicesDelegationsStubsByIds(invoiceIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun listInvoicesByHcPartyAndGroupId(
		hcPartyId: String,
		groupId: String,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByContactIds(contactIds: ListOfIds): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByRecipientsIds(recipientIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToInsurances(userIds: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToInsurancesUnsent(userIds: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToPatients(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listToPatientsUnsent(hcPartyId: String? = null): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByIds(invoiceIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String? = null,
		status: String? = null,
		from: Long? = null,
		to: Long? = null,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun listInvoiceIdsByDecisionReference(
		dataOwnerId: String,
		decisionReference: String,
	): HttpResponse<List<String>>

	suspend fun listInvoicesByServiceIds(serviceIds: String): HttpResponse<List<EncryptedInvoice>>

	suspend fun listAllHcpsByStatus(
		status: String,
		from: Long? = null,
		to: Long? = null,
		hcpIds: ListOfIds,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun getTarificationsCodesOccurrences(minOccurrences: Long): HttpResponse<List<LabelledOccurence>>

	suspend fun filterInvoicesBy(filterChain: FilterChain<Invoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun matchInvoicesBy(filter: AbstractFilter<Invoice>): HttpResponse<List<String>>

	suspend fun modifyInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun createInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion

	// region cloud endpoints

	suspend fun createInvoiceInGroup(
		groupId: String,
		invoiceDto: EncryptedInvoice,
	): HttpResponse<EncryptedInvoice>

	suspend fun createInvoicesInGroup(
		groupId: String,
		invoiceDtos: List<EncryptedInvoice>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun modifyInvoiceInGroup(
		groupId: String,
		invoiceDto: EncryptedInvoice,
	): HttpResponse<EncryptedInvoice>

	suspend fun modifyInvoicesInGroup(
		groupId: String,
		invoiceDtos: List<EncryptedInvoice>,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun getInvoiceInGroup(
		groupId: String,
		invoiceId: String,
	): HttpResponse<EncryptedInvoice>

	suspend fun getInvoicesInGroup(
		groupId: String,
		invoiceIds: ListOfIds,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun deleteInvoicesInGroup(
		groupId: String,
		invoiceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteInvoiceInGroup(
		groupId: String,
		invoiceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteInvoiceInGroup(
		groupId: String,
		invoiceId: String,
		rev: String,
	): HttpResponse<EncryptedInvoice>

	suspend fun undeleteInvoicesInGroup(
		groupId: String,
		invoiceIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedInvoice>>

	suspend fun purgeInvoiceInGroup(
		groupId: String,
		invoiceId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeInvoicesInGroup(
		groupId: String,
		invoiceIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>>

	suspend fun matchInvoicesInGroupBy(
		filter: AbstractFilter<Invoice>,
		groupId: String,
	): HttpResponse<List<String>>
	// endregion
}
