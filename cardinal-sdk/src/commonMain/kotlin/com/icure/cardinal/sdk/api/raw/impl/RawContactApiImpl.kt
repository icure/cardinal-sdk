package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawContactApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.ContactAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.ServiceAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawContactApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawContactApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.Contact,
		)

	// region common endpoints

	override suspend fun getEmptyContent(): HttpResponse<EncryptedContent> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "content", "empty")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createContact(c: EncryptedContact): HttpResponse<EncryptedContact> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getContact(contactId: String): HttpResponse<EncryptedContact> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", contactId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getContacts(contactIds: ListOfIds): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun getServiceCodesOccurrences(
		codeType: String,
		minOccurrences: Long,
	): HttpResponse<List<LabelledOccurence>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "codes", codeType, "$minOccurrences")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listContactByHCPartyServiceId(
		hcPartyId: String,
		serviceId: String,
	): HttpResponse<List<EncryptedContact>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyServiceId")
				parameter("hcPartyId", hcPartyId)
				parameter("serviceId", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listContactsByExternalId(externalId: String): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byExternalId")
				parameter("externalId", externalId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun listContactsByHCPartyAndFormId(
		hcPartyId: String,
		formId: String,
	): HttpResponse<List<EncryptedContact>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyFormId")
				parameter("hcPartyId", hcPartyId)
				parameter("formId", formId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listContactsByHCPartyAndFormIds(
		hcPartyId: String,
		formIds: ListOfIds,
	): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byHcPartyFormIds")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(formIds)
		}.wrap()

	override suspend fun listContactIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byDataOwnerPatientOpeningDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findContactsDelegationsStubsByIds(contactIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun deleteContacts(contactIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun deleteContactsWithRev(contactIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun deleteContact(
		contactId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", contactId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteContact(
		contactId: String,
		rev: String,
	): HttpResponse<EncryptedContact> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "undelete", contactId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteContacts(contactIds: ListOfIdsAndRev): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun purgeContact(
		contactId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "purge", contactId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeContacts(contactIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun modifyContact(contactDto: EncryptedContact): HttpResponse<EncryptedContact> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun modifyContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun createContacts(contactDtos: List<EncryptedContact>): HttpResponse<List<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun filterContactsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Contact>,
	): HttpResponse<PaginatedList<EncryptedContact>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(ContactAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchContactsBy(
		filter: AbstractFilter<Contact>,
		deduplicate: Boolean?,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "match")
				parameter("deduplicate", deduplicate)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(ContactAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getService(serviceId: String): HttpResponse<EncryptedService> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun filterServicesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Service>,
	): HttpResponse<PaginatedList<EncryptedService>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(ServiceAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchServicesBy(filter: AbstractFilter<Service>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(ServiceAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getServices(ids: ListOfIds): HttpResponse<List<EncryptedService>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun getServicesLinkedTo(
		linkType: String?,
		ids: ListOfIds,
	): HttpResponse<List<EncryptedService>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "linkedTo")
				parameter("linkType", linkType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun listServicesByAssociationId(associationId: String): HttpResponse<List<EncryptedService>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "associationId")
				parameter("associationId", associationId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listServicesByHealthElementId(
		healthElementId: String,
		hcPartyId: String,
	): HttpResponse<List<EncryptedService>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "service", "healthElementId", healthElementId)
				parameter("hcPartyId", hcPartyId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findContactsByOpeningDate(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedContact>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "byOpeningDate")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createContactInGroup(
		groupId: String,
		contactDto: EncryptedContact,
	): HttpResponse<EncryptedContact> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun createContactsInGroup(
		groupId: String,
		contactDtos: List<EncryptedContact>,
	): HttpResponse<List<EncryptedContact>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun modifyContactInGroup(
		groupId: String,
		contactDto: EncryptedContact,
	): HttpResponse<EncryptedContact> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDto)
		}.wrap()

	override suspend fun modifyContactsInGroup(
		groupId: String,
		contactDtos: List<EncryptedContact>,
	): HttpResponse<List<EncryptedContact>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactDtos)
		}.wrap()

	override suspend fun getContactInGroup(
		groupId: String,
		contactId: String,
	): HttpResponse<EncryptedContact> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, contactId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getContactsInGroup(
		groupId: String,
		contactIds: ListOfIds,
	): HttpResponse<List<EncryptedContact>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun deleteContactInGroup(
		groupId: String,
		contactId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, contactId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteContactsInGroup(
		groupId: String,
		contactIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun undeleteContactInGroup(
		groupId: String,
		contactId: String,
		rev: String,
	): HttpResponse<EncryptedContact> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "undelete", contactId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteContactsInGroup(
		groupId: String,
		contactIds: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedContact>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun purgeContactInGroup(
		groupId: String,
		contactId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "purge", contactId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeContactsInGroup(
		groupId: String,
		contactIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(contactIds)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedContact>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchContactsInGroupBy(
		filter: AbstractFilter<Contact>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(ContactAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun getServiceInGroup(
		groupId: String,
		serviceId: String,
	): HttpResponse<EncryptedService> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "service", serviceId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getServicesInGroup(
		groupId: String,
		ids: ListOfIds,
	): HttpResponse<List<EncryptedService>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "service", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun matchServicesInGroupBy(
		groupId: String,
		filter: AbstractFilter<Service>,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "contact", "inGroup", groupId, "service", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(ServiceAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}
