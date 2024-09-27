package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawInvoiceApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.InvoiceAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawInvoiceApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawInvoiceApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.Invoice)

	// region common endpoints

	override suspend fun createInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDto)
		}.wrap()

	override suspend fun deleteInvoices(invoiceIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceIds)
		}.wrap()

	override suspend fun deleteInvoicesWithRev(invoiceIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceIds)
		}.wrap()

	override suspend fun deleteInvoice(invoiceId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", invoiceId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteInvoice(invoiceId: String): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "undelete", invoiceId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeInvoice(invoiceId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "purge", invoiceId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getInvoice(invoiceId: String): HttpResponse<EncryptedInvoice> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", invoiceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getInvoices(invoiceIds: ListOfIds): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceIds)
		}.wrap()

	override suspend fun modifyInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDto)
		}.wrap()

	override suspend fun reassignInvoice(invoiceDto: EncryptedInvoice): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "reassign")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDto)
		}.wrap()

	override suspend fun mergeTo(
		invoiceId: String,
		ids: ListOfIds,
	): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "mergeTo", invoiceId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): HttpResponse<EncryptedInvoice> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "validate", invoiceId)
				parameter("scheme", scheme)
				parameter("forcedValue", forcedValue)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Int?,
		invoicingCodes: List<EncryptedInvoicingCode>,
	): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", userId, "append", type, sentMediumType)
				parameter("secretFKeys", secretFKeys)
				parameter("insuranceId", insuranceId)
				parameter("invoiceId", invoiceId)
				parameter("gracePeriod", gracePeriod)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoicingCodes)
		}.wrap()

	override suspend fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: List<String>,
	): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", userId, "service", serviceId)
				parameter("secretFKeys", secretFKeys)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(tarificationIds)
		}.wrap()

	override suspend fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Long?,
		toDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byauthor", hcPartyId)
				parameter("fromDate", fromDate)
				parameter("toDate", toDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findInvoicesByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listInvoicesDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoiceIdsByDataOwnerPatientInvoiceDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byDataOwnerPatientInvoiceDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findInvoicesDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listInvoicesByHcPartyAndGroupId(
		hcPartyId: String,
		groupId: String,
	): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcPartyGroupId", hcPartyId, groupId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: MediumType,
		invoiceType: InvoiceType,
		sent: Boolean,
		from: Long?,
		to: Long?,
	): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments(
					"rest",
					"v2",
					"invoice",
					"byHcParty",
					hcPartyId,
					"mediumType",
					"$sentMediumType",
					"invoiceType",
					"$invoiceType",
					"sent",
					"$sent",
				)
				parameter("from", from)
				parameter("to", to)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByContactIds(contactIds: ListOfIds): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byContacts")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun listInvoicesByRecipientsIds(recipientIds: String): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "to", recipientIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listToInsurances(userIds: String?): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toInsurances")
				parameter("userIds", userIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listToInsurancesUnsent(userIds: String?): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toInsurances", "unsent")
				parameter("userIds", userIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listToPatients(hcPartyId: String?): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toPatients")
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listToPatientsUnsent(hcPartyId: String?): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "toPatients", "unsent")
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByIds(invoiceIds: String): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byIds", invoiceIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String?,
		status: String?,
		from: Long?,
		to: Long?,
	): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byHcpartySendingModeStatusDate", hcPartyId)
				parameter("sendingMode", sendingMode)
				parameter("status", status)
				parameter("from", from)
				parameter("to", to)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listInvoicesByServiceIds(serviceIds: String): HttpResponse<List<EncryptedInvoice>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "byServiceIds", serviceIds)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listAllHcpsByStatus(
		status: String,
		from: Long?,
		to: Long?,
		hcpIds: ListOfIds,
	): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "allHcpsByStatus", status)
				parameter("from", from)
				parameter("to", to)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(hcpIds)
		}.wrap()

	override suspend fun getTarificationsCodesOccurrences(minOccurrences: Long): HttpResponse<List<LabelledOccurence>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "codes", "$minOccurrences")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun filterInvoicesBy(filterChain: FilterChain<Invoice>): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "filter")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(InvoiceAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchInvoicesBy(filter: AbstractFilter<Invoice>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(InvoiceAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun modifyInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun createInvoices(invoiceDtos: List<EncryptedInvoice>): HttpResponse<List<EncryptedInvoice>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(invoiceDtos)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedInvoice>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "invoice", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
