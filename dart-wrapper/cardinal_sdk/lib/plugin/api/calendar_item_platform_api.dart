// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
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
import 'package:cardinal_sdk/crypto/entities/calendar_item_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class CalendarItemPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemEncryptedPlatformApi encrypted;
	CalendarItemTryAndRecoverPlatformApi tryAndRecover;
	CalendarItemInGroupPlatformApi inGroup;
	CalendarItemPlatformApi(
		this._methodChannel
		) : encrypted = CalendarItemEncryptedPlatformApi(_methodChannel),
		tryAndRecover = CalendarItemTryAndRecoverPlatformApi(_methodChannel),
		inGroup = CalendarItemInGroupPlatformApi(_methodChannel);

	Future<DecryptedCalendarItem> withEncryptionMetadata(String sdkId, DecryptedCalendarItem? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedCalendarItem.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, CalendarItem entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<DecryptedCalendarItem>> decrypt(String sdkId, List<EncryptedCalendarItem> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.decrypt',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => EncryptedCalendarItem.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedCalendarItem.fromJSON(x1) ).toList();
	}

	Future<List<CalendarItem>> tryDecrypt(String sdkId, List<EncryptedCalendarItem> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => EncryptedCalendarItem.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => CalendarItem.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedCalendarItem>> encryptOrValidate(String sdkId, List<CalendarItem> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encryptOrValidate',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => CalendarItem.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedCalendarItem.fromJSON(x1) ).toList();
	}

	Future<List<String>> matchCalendarItemsBy(String sdkId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<StoredDocumentIdentifier> deleteCalendarItemById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItemById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItemsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItemsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.purgeCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItems(String sdkId, List<CalendarItem> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItems',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => CalendarItem.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.purgeCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedCalendarItem> shareWith(String sdkId, String delegateId, DecryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(DecryptedCalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> shareWithMany(String sdkId, DecryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(DecryptedCalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedCalendarItem.fromJSON(x0));
	}

	Future<DecryptedCalendarItem> createCalendarItem(String sdkId, DecryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> bookCalendarItemCheckingAvailability(String sdkId, DecryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.bookCalendarItemCheckingAvailability',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method bookCalendarItemCheckingAvailability");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> modifyCalendarItem(String sdkId, DecryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem?> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<List<DecryptedCalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedCalendarItem.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}
}

class CalendarItemTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemTryAndRecoverPlatformApi(this._methodChannel);

	Future<CalendarItem> shareWith(String sdkId, String delegateId, CalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> shareWithMany(String sdkId, CalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => CalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => CalendarItem.fromJSON(x0));
	}

	Future<CalendarItem> createCalendarItem(String sdkId, CalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> bookCalendarItemCheckingAvailability(String sdkId, CalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.bookCalendarItemCheckingAvailability',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method bookCalendarItemCheckingAvailability");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> modifyCalendarItem(String sdkId, CalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem?> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : CalendarItem.fromJSON(parsedResJson);
	}

	Future<List<CalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => CalendarItem.fromJSON(x1) ).toList();
	}
}

class CalendarItemEncryptedPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedCalendarItem> shareWith(String sdkId, String delegateId, EncryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> shareWithMany(String sdkId, EncryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<EncryptedCalendarItem> createCalendarItem(String sdkId, EncryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> bookCalendarItemCheckingAvailability(String sdkId, EncryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.bookCalendarItemCheckingAvailability',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method bookCalendarItemCheckingAvailability");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(String sdkId, EncryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedCalendarItem.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem?> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedCalendarItem.fromJSON(x1) ).toList();
	}
}

class CalendarItemInGroupPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemInGroupEncryptedPlatformApi encrypted;
	CalendarItemInGroupTryAndRecoverPlatformApi tryAndRecover;
	CalendarItemInGroupPlatformApi(
		this._methodChannel
		) : encrypted = CalendarItemInGroupEncryptedPlatformApi(_methodChannel),
		tryAndRecover = CalendarItemInGroupTryAndRecoverPlatformApi(_methodChannel);

	Future<GroupScoped<DecryptedCalendarItem>> withEncryptionMetadata(String sdkId, String entityGroupId, DecryptedCalendarItem? base, GroupScoped<Patient>? patient, User? user, Map<EntityReferenceInGroup, AccessLevel> delegates, SecretIdUseOption secretId, EntityReferenceInGroup? alternateRootDelegateReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"entityGroupId": jsonEncode(entityGroupId),
				"base": jsonEncode(base == null ? null : DecryptedCalendarItem.encode(base!)),
				"patient": jsonEncode(patient == null ? null : GroupScoped.encode(
					patient!,
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
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, GroupScoped<CalendarItem> calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, GroupScoped<CalendarItem> calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.hasWriteAccess',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(String sdkId, GroupScoped<CalendarItem> calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityReferenceInGroup.fromJSON(x1) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, GroupScoped<CalendarItem> entity, Set<EntityReferenceInGroup> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.map((x0) => EntityReferenceInGroup.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<List<GroupScoped<DecryptedCalendarItem>>> decrypt(String sdkId, List<GroupScoped<EncryptedCalendarItem>> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.decrypt',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedCalendarItem.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedCalendarItem.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<CalendarItem>>> tryDecrypt(String sdkId, List<GroupScoped<EncryptedCalendarItem>> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryDecrypt',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return EncryptedCalendarItem.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return CalendarItem.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<GroupScoped<EncryptedCalendarItem>>> encryptOrValidate(String sdkId, List<GroupScoped<CalendarItem>> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encryptOrValidate',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return CalendarItem.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method encryptOrValidate");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedCalendarItem.fromJSON(x2);
			},
		) ).toList();
	}

	Future<List<String>> matchCalendarItemsBy(String sdkId, String groupId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, String groupId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItemById(String sdkId, GroupScoped<StoredDocumentIdentifier> entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.deleteCalendarItemById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(GroupScoped.encode(
					entityId,
					(x0) {
						return StoredDocumentIdentifier.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return StoredDocumentIdentifier.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItemsByIds(String sdkId, List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.deleteCalendarItemsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return StoredDocumentIdentifier.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItem(String sdkId, GroupScoped<CalendarItem> calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.deleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return StoredDocumentIdentifier.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItems(String sdkId, List<GroupScoped<CalendarItem>> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.deleteCalendarItems',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => GroupScoped.encode(
					x0,
					(x1) {
						return CalendarItem.encode(x1);
					},
				)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return StoredDocumentIdentifier.fromJSON(x2);
			},
		) ).toList();
	}

	Future<GroupScoped<DecryptedCalendarItem>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<DecryptedCalendarItem> calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return DecryptedCalendarItem.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> shareWithMany(String sdkId, GroupScoped<DecryptedCalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return DecryptedCalendarItem.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": CalendarItemShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>> filterCalendarItemsBy(String sdkId, String groupId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>> filterCalendarItemsBySorted(String sdkId, String groupId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<DecryptedCalendarItem>> createCalendarItem(String sdkId, GroupScoped<DecryptedCalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedCalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> modifyCalendarItem(String sdkId, GroupScoped<DecryptedCalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return DecryptedCalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>?> getCalendarItem(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.getCalendarItem',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return DecryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<DecryptedCalendarItem>>> getCalendarItems(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.getCalendarItems',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return DecryptedCalendarItem.fromJSON(x2);
			},
		) ).toList();
	}
}

class CalendarItemInGroupEncryptedPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemInGroupEncryptedPlatformApi(this._methodChannel);

	Future<GroupScoped<EncryptedCalendarItem>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<EncryptedCalendarItem> calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return EncryptedCalendarItem.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> shareWithMany(String sdkId, GroupScoped<EncryptedCalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return EncryptedCalendarItem.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": CalendarItemShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBy(String sdkId, String groupId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBySorted(String sdkId, String groupId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<EncryptedCalendarItem>> createCalendarItem(String sdkId, GroupScoped<EncryptedCalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedCalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> modifyCalendarItem(String sdkId, GroupScoped<EncryptedCalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedCalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>?> getCalendarItem(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.getCalendarItem',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedCalendarItem.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<EncryptedCalendarItem>>> getCalendarItems(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.encrypted.getCalendarItems',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return EncryptedCalendarItem.fromJSON(x2);
			},
		) ).toList();
	}
}

class CalendarItemInGroupTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemInGroupTryAndRecoverPlatformApi(this._methodChannel);

	Future<GroupScoped<CalendarItem>> shareWith(String sdkId, EntityReferenceInGroup delegate, GroupScoped<CalendarItem> calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegate": jsonEncode(EntityReferenceInGroup.encode(delegate)),
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<CalendarItem>> shareWithMany(String sdkId, GroupScoped<CalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(GroupScoped.encode(
					calendarItem,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
				"delegates": jsonEncode(delegates.entries.map((x0) => {
					"k": EntityReferenceInGroup.encode(x0.key),
					"v": CalendarItemShareOptions.encode(x0.value),
				}).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		);
	}

	Future<PaginatedListIterator<GroupScoped<CalendarItem>>> filterCalendarItemsBy(String sdkId, String groupId, FilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		));
	}

	Future<PaginatedListIterator<GroupScoped<CalendarItem>>> filterCalendarItemsBySorted(String sdkId, String groupId, SortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => GroupScoped.fromJSON(
			x0,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		));
	}

	Future<GroupScoped<CalendarItem>> createCalendarItem(String sdkId, GroupScoped<CalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<CalendarItem>> modifyCalendarItem(String sdkId, GroupScoped<CalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return CalendarItem.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<CalendarItem>?> getCalendarItem(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.getCalendarItem',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return CalendarItem.fromJSON(x1);
			},
		);
	}

	Future<List<GroupScoped<CalendarItem>>> getCalendarItems(String sdkId, String groupId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.inGroup.tryAndRecover.getCalendarItems',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => GroupScoped.fromJSON(
			x1,
			(x2) {
				return CalendarItem.fromJSON(x2);
			},
		) ).toList();
	}
}