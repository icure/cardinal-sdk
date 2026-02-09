// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/crypto/entities/contact_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';


class ContactApi {
	final String _sdkId;
	final Object _dartSdk;
	final ContactEncryptedApi encrypted;
	final ContactTryAndRecoverApi tryAndRecover;
	ContactApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = ContactEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = ContactTryAndRecoverApi(_sdkId, _dartSdk);

	Future<List<String>> matchContactsBy(FilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.matchContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBy(FilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.matchServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchContactsBySorted(SortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.matchContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBySorted(SortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.matchServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedContact> withEncryptionMetadata(DecryptedContact? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getEncryptionKeysOf(
			_sdkId,
			contact,
		);
	}

	Future<bool> hasWriteAccess(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.hasWriteAccess(
			_sdkId,
			contact,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.decryptPatientIdOf(
			_sdkId,
			contact,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Contact entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedContact> decrypt(EncryptedContact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.decrypt(
			_sdkId,
			contact,
		);
	}

	Future<Contact> tryDecrypt(EncryptedContact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryDecrypt(
			_sdkId,
			contact,
		);
	}

	Future<DecryptedService> decryptService(EncryptedService service) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.decryptService(
			_sdkId,
			service,
		);
	}

	Future<Service> tryDecryptService(EncryptedService service) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryDecryptService(
			_sdkId,
			service,
		);
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(FilterOptions<Service> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.subscribeToServiceCreateOrUpdateEvents(
			_sdkId,
			filter,
			subscriptionConfig,
		);
	}

	Future<DocIdentifier> deleteContactById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.deleteContactById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteContactsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.deleteContactsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.purgeContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.deleteContact(
			_sdkId,
			contact,
		);
	}

	Future<List<DocIdentifier>> deleteContacts(List<Contact> contacts) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.deleteContacts(
			_sdkId,
			contacts,
		);
	}

	Future<void> purgeContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.purgeContact(
			_sdkId,
			contact,
		);
	}

	Future<List<LabelledOccurence>> getServiceCodesOccurrences(String codeType, int minOccurrences) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getServiceCodesOccurrences(
			_sdkId,
			codeType,
			minOccurrences,
		);
	}

	Future<DecryptedContact> shareWith(String delegateId, DecryptedContact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<DecryptedContact> shareWithMany(DecryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBy(FilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBy(FilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBySorted(SortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBySorted(SortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedContact> createContact(DecryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.createContact(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedContact>> createContacts(List<DecryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.createContacts(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedContact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedContact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<DecryptedContact> modifyContact(DecryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedContact>> modifyContacts(List<DecryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedContact?> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedContact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedService> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<DecryptedService>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.getServices(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<Contact> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class ContactTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	ContactTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Contact> shareWith(String delegateId, Contact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<Contact> shareWithMany(Contact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<Contact>> filterContactsBy(FilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Service>> filterServicesBy(FilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Contact>> filterContactsBySorted(SortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Service>> filterServicesBySorted(SortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Contact> createContact(Contact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.createContact(
			_sdkId,
			entity,
		);
	}

	Future<List<Contact>> createContacts(List<Contact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.createContacts(
			_sdkId,
			entities,
		);
	}

	Future<Contact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Contact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<Contact> modifyContact(Contact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<Contact>> modifyContacts(List<Contact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<Contact?> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<Contact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<Service> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<Service>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.tryAndRecover.getServices(
			_sdkId,
			entityIds,
		);
	}
}

class ContactEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	ContactEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedContact> shareWith(String delegateId, EncryptedContact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<EncryptedContact> shareWithMany(EncryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(FilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(FilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(SortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(SortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedContact> createContact(EncryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.createContact(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedContact>> createContacts(List<EncryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.createContacts(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedContact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedContact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<EncryptedContact> modifyContact(EncryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedContact>> modifyContacts(List<EncryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedContact?> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedContact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedService> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<EncryptedService>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contact.encrypted.getServices(
			_sdkId,
			entityIds,
		);
	}
}