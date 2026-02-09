// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/health_element_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class HealthElementPlatformApi {
	MethodChannel _methodChannel;
	HealthElementEncryptedPlatformApi encrypted;
	HealthElementTryAndRecoverPlatformApi tryAndRecover;
	HealthElementInGroupPlatformApi inGroup;
	HealthElementPlatformApi(
		this._methodChannel
		) : encrypted = HealthElementEncryptedPlatformApi(_methodChannel),
		tryAndRecover = HealthElementTryAndRecoverPlatformApi(_methodChannel),
		inGroup = HealthElementInGroupPlatformApi(_methodChannel);

	Future<DecryptedHealthElement> withEncryptionMetadata(String sdkId, DecryptedHealthElement? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedHealthElement.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, HealthElement entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(HealthElement.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<DecryptedHealthElement>> decrypt(String sdkId, List<EncryptedHealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.decrypt',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<List<HealthElement>> tryDecrypt(String sdkId, List<EncryptedHealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedHealthElement>> encryptOrValidate(String sdkId, List<HealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encryptOrValidate',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => HealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<List<String>> matchHealthElementsBy(String sdkId, FilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.matchHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchHealthElementsBySorted(String sdkId, SortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.matchHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<StoredDocumentIdentifier> deleteHealthElementById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElementById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElementsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElementsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.purgeHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElements(String sdkId, List<HealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElements',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => HealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.purgeHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedHealthElement> shareWith(String sdkId, String delegateId, DecryptedHealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(DecryptedHealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> shareWithMany(String sdkId, DecryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(DecryptedHealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBy(String sdkId, FilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedHealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedHealthElement.fromJSON(x0));
	}

	Future<DecryptedHealthElement> createHealthElement(String sdkId, DecryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> createHealthElements(String sdkId, List<DecryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<DecryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> modifyHealthElement(String sdkId, DecryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> modifyHealthElements(String sdkId, List<DecryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<DecryptedHealthElement?> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<HealthElement> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}
}

class HealthElementTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	HealthElementTryAndRecoverPlatformApi(this._methodChannel);

	Future<HealthElement> shareWith(String sdkId, String delegateId, HealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> shareWithMany(String sdkId, HealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBy(String sdkId, FilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthElement.fromJSON(x0));
	}

	Future<HealthElement> createHealthElement(String sdkId, HealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(HealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<List<HealthElement>> createHealthElements(String sdkId, List<HealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.createHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => HealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}

	Future<HealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> modifyHealthElement(String sdkId, HealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(HealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<List<HealthElement>> modifyHealthElements(String sdkId, List<HealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => HealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}

	Future<HealthElement?> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : HealthElement.fromJSON(parsedResJson);
	}

	Future<List<HealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}
}

class HealthElementEncryptedPlatformApi {
	MethodChannel _methodChannel;
	HealthElementEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedHealthElement> shareWith(String sdkId, String delegateId, EncryptedHealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> shareWithMany(String sdkId, EncryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(String sdkId, FilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<EncryptedHealthElement> createHealthElement(String sdkId, EncryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> createHealthElements(String sdkId, List<EncryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.createHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> modifyHealthElement(String sdkId, EncryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(String sdkId, List<EncryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement?> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}
}

class HealthElementInGroupPlatformApi {
	MethodChannel _methodChannel;
	HealthElementInGroupEncryptedPlatformApi encrypted;
	HealthElementInGroupTryAndRecoverPlatformApi tryAndRecover;
	HealthElementInGroupPlatformApi(
		this._methodChannel
		) : encrypted = HealthElementInGroupEncryptedPlatformApi(_methodChannel),
		tryAndRecover = HealthElementInGroupTryAndRecoverPlatformApi(_methodChannel);

	Future<GroupScoped<DecryptedHealthElement>> withEncryptionMetadata(String sdkId, String entityGroupId, DecryptedHealthElement? base, GroupScoped<Patient> patient, User? user, Map<EntityReferenceInGroup, AccessLevel> delegates, SecretIdUseOption secretId, EntityReferenceInGroup? alternateRootDelegateReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"entityGroupId": jsonEncode(entityGroupId),
				"base": jsonEncode(base == null ? null : DecryptedHealthElement.encode(base!)),
				"patient": jsonEncode(GroupScoped.encode(
					patient,
					(x0) {
						return Patient.encode(x0);
					},
				)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": AccessLevel.encode(x0.value),
				}).toList()),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateReference": jsonEncode(alternateRootDelegateReference == null ? null : EntityReferenceInGroup.encode(alternateRootDelegateReference!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, GroupScoped<HealthElement> healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, GroupScoped<HealthElement> healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.hasWriteAccess',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, GroupScoped<HealthElement> healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, GroupScoped<HealthElement> entity, Set<EntityReferenceInGroup> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.map((x0) => EntityReferenceInGroup.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<GroupScoped<DecryptedHealthElement>>> decrypt(String sdkId, List<GroupScoped<EncryptedHealthElement>> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.decrypt',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedHealthElement.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedHealthElement.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<HealthElement>>> tryDecrypt(String sdkId, List<GroupScoped<EncryptedHealthElement>> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryDecrypt',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedHealthElement.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return HealthElement.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<EncryptedHealthElement>>> encryptOrValidate(String sdkId, List<GroupScoped<HealthElement>> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encryptOrValidate',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return HealthElement.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedHealthElement.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<DecryptedHealthElement>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<DecryptedHealthElement> healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return DecryptedHealthElement.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> shareWithMany(String sdkId, GroupScoped<DecryptedHealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return DecryptedHealthElement.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": HealthElementShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> createHealthElement(String sdkId, GroupScoped<DecryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> modifyHealthElement(String sdkId, GroupScoped<DecryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedHealthElement>?> getHealthElement(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.getHealthElement',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedHealthElement.fromJSON(x1);
			},
		);
	}
}

class HealthElementInGroupEncryptedPlatformApi {
	MethodChannel _methodChannel;
	HealthElementInGroupEncryptedPlatformApi(this._methodChannel);

	Future<GroupScoped<EncryptedHealthElement>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<EncryptedHealthElement> healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> shareWithMany(String sdkId, GroupScoped<EncryptedHealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": HealthElementShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> createHealthElement(String sdkId, GroupScoped<EncryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encrypted.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> modifyHealthElement(String sdkId, GroupScoped<EncryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encrypted.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>?> getHealthElement(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.encrypted.getHealthElement',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}
}

class HealthElementInGroupTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	HealthElementInGroupTryAndRecoverPlatformApi(this._methodChannel);

	Future<GroupScoped<HealthElement>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<HealthElement> healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return HealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<HealthElement>> shareWithMany(String sdkId, GroupScoped<HealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(GroupScoped.encode(
					healthElement,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": HealthElementShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return HealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<HealthElement>> createHealthElement(String sdkId, GroupScoped<HealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryAndRecover.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return HealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<HealthElement>> modifyHealthElement(String sdkId, GroupScoped<HealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryAndRecover.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return HealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return HealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<HealthElement>?> getHealthElement(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.inGroup.tryAndRecover.getHealthElement',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return HealthElement.fromJSON(x1);
			},
		);
	}
}