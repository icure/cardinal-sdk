// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
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


class ContactPlatformApi {
	MethodChannel _methodChannel;
	ContactEncryptedPlatformApi encrypted;
	ContactTryAndRecoverPlatformApi tryAndRecover;
	ContactPlatformApi(
		this._methodChannel
		) : encrypted = ContactEncryptedPlatformApi(_methodChannel),
		tryAndRecover = ContactTryAndRecoverPlatformApi(_methodChannel);

	Future<List<String>> matchContactsBy(String sdkId, FilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.matchContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchContactsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchServicesBy(String sdkId, FilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.matchServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchServicesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchContactsBySorted(String sdkId, SortableFilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.matchContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchServicesBySorted(String sdkId, SortableFilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.matchServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DecryptedContact> withEncryptionMetadata(String sdkId, DecryptedContact? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedContact.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Contact entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Contact.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedContact> decrypt(String sdkId, EncryptedContact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.decrypt',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(EncryptedContact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<Contact> tryDecrypt(String sdkId, EncryptedContact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(EncryptedContact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<DecryptedService> decryptService(String sdkId, EncryptedService service) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.decryptService',
			{
				"sdkId": sdkId,
				"service": jsonEncode(EncryptedService.encode(service)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptService");
		final parsedResJson = jsonDecode(res);
		return DecryptedService.fromJSON(parsedResJson);
	}

	Future<Service> tryDecryptService(String sdkId, EncryptedService service) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryDecryptService',
			{
				"sdkId": sdkId,
				"service": jsonEncode(EncryptedService.encode(service)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecryptService");
		final parsedResJson = jsonDecode(res);
		return Service.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(String sdkId, FilterOptions<Service> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.subscribeToServiceCreateOrUpdateEvents',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToServiceCreateOrUpdateEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<DocIdentifier> deleteContactById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.deleteContactById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteContactById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteContactsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.deleteContactsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteContactsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.purgeContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.deleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteContact");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteContacts(String sdkId, List<Contact> contacts) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.deleteContacts',
			{
				"sdkId": sdkId,
				"contacts": jsonEncode(contacts.map((x0) => Contact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.purgeContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
	}

	Future<List<LabelledOccurence>> getServiceCodesOccurrences(String sdkId, String codeType, int minOccurrences) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getServiceCodesOccurrences',
			{
				"sdkId": sdkId,
				"codeType": jsonEncode(codeType),
				"minOccurrences": jsonEncode(minOccurrences),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getServiceCodesOccurrences");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => LabelledOccurence.fromJSON(x1) ).toList();
	}

	Future<DecryptedContact> shareWith(String sdkId, String delegateId, DecryptedContact contact, ContactShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"contact": jsonEncode(DecryptedContact.encode(contact)),
				"options": jsonEncode(options == null ? null : ContactShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<DecryptedContact> shareWithMany(String sdkId, DecryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.shareWithMany',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(DecryptedContact.encode(contact)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ContactShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBy(String sdkId, FilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.filterContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBy(String sdkId, FilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.filterServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedService.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBySorted(String sdkId, SortableFilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.filterContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBySorted(String sdkId, SortableFilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.filterServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedService.fromJSON(x0));
	}

	Future<DecryptedContact> createContact(String sdkId, DecryptedContact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.createContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedContact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContact");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<List<DecryptedContact>> createContacts(String sdkId, List<DecryptedContact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.createContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedContact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedContact.fromJSON(x1) ).toList();
	}

	Future<DecryptedContact> undeleteContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.undeleteContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContactById");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<DecryptedContact> undeleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.undeleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContact");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<DecryptedContact> modifyContact(String sdkId, DecryptedContact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.modifyContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedContact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContact");
		final parsedResJson = jsonDecode(res);
		return DecryptedContact.fromJSON(parsedResJson);
	}

	Future<List<DecryptedContact>> modifyContacts(String sdkId, List<DecryptedContact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.modifyContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedContact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedContact.fromJSON(x1) ).toList();
	}

	Future<DecryptedContact?> getContact(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getContact',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContact");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedContact.fromJSON(parsedResJson);
	}

	Future<List<DecryptedContact>> getContacts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getContacts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedContact.fromJSON(x1) ).toList();
	}

	Future<DecryptedService> getService(String sdkId, String serviceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getService',
			{
				"sdkId": sdkId,
				"serviceId": jsonEncode(serviceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getService");
		final parsedResJson = jsonDecode(res);
		return DecryptedService.fromJSON(parsedResJson);
	}

	Future<List<DecryptedService>> getServices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.getServices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getServices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedService.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<Contact> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}
}

class ContactTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	ContactTryAndRecoverPlatformApi(this._methodChannel);

	Future<Contact> shareWith(String sdkId, String delegateId, Contact contact, ContactShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"contact": jsonEncode(Contact.encode(contact)),
				"options": jsonEncode(options == null ? null : ContactShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<Contact> shareWithMany(String sdkId, Contact contact, Map<String, ContactShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ContactShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Contact>> filterContactsBy(String sdkId, FilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.filterContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Contact.fromJSON(x0));
	}

	Future<PaginatedListIterator<Service>> filterServicesBy(String sdkId, FilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.filterServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Service.fromJSON(x0));
	}

	Future<PaginatedListIterator<Contact>> filterContactsBySorted(String sdkId, SortableFilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.filterContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Contact.fromJSON(x0));
	}

	Future<PaginatedListIterator<Service>> filterServicesBySorted(String sdkId, SortableFilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.filterServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Service.fromJSON(x0));
	}

	Future<Contact> createContact(String sdkId, Contact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.createContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Contact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContact");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<List<Contact>> createContacts(String sdkId, List<Contact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.createContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Contact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Contact.fromJSON(x1) ).toList();
	}

	Future<Contact> undeleteContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.undeleteContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContactById");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<Contact> undeleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.undeleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContact");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<Contact> modifyContact(String sdkId, Contact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.modifyContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Contact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContact");
		final parsedResJson = jsonDecode(res);
		return Contact.fromJSON(parsedResJson);
	}

	Future<List<Contact>> modifyContacts(String sdkId, List<Contact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.modifyContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Contact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Contact.fromJSON(x1) ).toList();
	}

	Future<Contact?> getContact(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.getContact',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContact");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Contact.fromJSON(parsedResJson);
	}

	Future<List<Contact>> getContacts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.getContacts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Contact.fromJSON(x1) ).toList();
	}

	Future<Service> getService(String sdkId, String serviceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.getService',
			{
				"sdkId": sdkId,
				"serviceId": jsonEncode(serviceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getService");
		final parsedResJson = jsonDecode(res);
		return Service.fromJSON(parsedResJson);
	}

	Future<List<Service>> getServices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.tryAndRecover.getServices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getServices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Service.fromJSON(x1) ).toList();
	}
}

class ContactEncryptedPlatformApi {
	MethodChannel _methodChannel;
	ContactEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedContact> shareWith(String sdkId, String delegateId, EncryptedContact contact, ContactShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"contact": jsonEncode(EncryptedContact.encode(contact)),
				"options": jsonEncode(options == null ? null : ContactShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<EncryptedContact> shareWithMany(String sdkId, EncryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(EncryptedContact.encode(contact)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, ContactShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(String sdkId, FilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.filterContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(String sdkId, FilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.filterServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(String sdkId, SortableFilterOptions<Contact> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.filterContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(String sdkId, SortableFilterOptions<Service> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.filterServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<EncryptedContact> createContact(String sdkId, EncryptedContact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.createContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedContact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<List<EncryptedContact>> createContacts(String sdkId, List<EncryptedContact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.createContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedContact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedContact.fromJSON(x1) ).toList();
	}

	Future<EncryptedContact> undeleteContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.undeleteContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContactById");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<EncryptedContact> undeleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.undeleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<EncryptedContact> modifyContact(String sdkId, EncryptedContact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.modifyContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedContact.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<List<EncryptedContact>> modifyContacts(String sdkId, List<EncryptedContact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.modifyContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedContact.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedContact.fromJSON(x1) ).toList();
	}

	Future<EncryptedContact?> getContact(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.getContact',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContact");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedContact.fromJSON(parsedResJson);
	}

	Future<List<EncryptedContact>> getContacts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.getContacts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getContacts");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedContact.fromJSON(x1) ).toList();
	}

	Future<EncryptedService> getService(String sdkId, String serviceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.getService',
			{
				"sdkId": sdkId,
				"serviceId": jsonEncode(serviceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getService");
		final parsedResJson = jsonDecode(res);
		return EncryptedService.fromJSON(parsedResJson);
	}

	Future<List<EncryptedService>> getServices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactApi.encrypted.getServices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getServices");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedService.fromJSON(x1) ).toList();
	}
}