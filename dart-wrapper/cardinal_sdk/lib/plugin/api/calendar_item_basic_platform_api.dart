// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class CalendarItemBasicPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemBasicInGroupPlatformApi inGroup;
	CalendarItemBasicPlatformApi(
		this._methodChannel
		) : inGroup = CalendarItemBasicInGroupPlatformApi(_methodChannel);

	Future<List<String>> matchCalendarItemsBy(String sdkId, BaseFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, BaseSortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(String sdkId, BaseFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, BaseSortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<StoredDocumentIdentifier> deleteCalendarItemById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItemById',
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
			'CalendarItemBasicApi.deleteCalendarItemsByIds',
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
			'CalendarItemBasicApi.purgeCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItem',
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
			'CalendarItemBasicApi.deleteCalendarItems',
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
			'CalendarItemBasicApi.purgeCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedCalendarItem> createCalendarItem(String sdkId, EncryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.createCalendarItem',
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
			'CalendarItemBasicApi.bookCalendarItemCheckingAvailability',
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
			'CalendarItemBasicApi.undeleteCalendarItemById',
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
			'CalendarItemBasicApi.undeleteCalendarItem',
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
			'CalendarItemBasicApi.modifyCalendarItem',
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
			'CalendarItemBasicApi.getCalendarItem',
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
			'CalendarItemBasicApi.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedCalendarItem.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.subscribeToEvents',
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

class CalendarItemBasicInGroupPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemBasicInGroupPlatformApi(this._methodChannel);

	Future<List<String>> matchCalendarItemsBy(String sdkId, String groupId, BaseFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, String groupId, BaseSortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBy(String sdkId, String groupId, BaseFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
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

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBySorted(String sdkId, String groupId, BaseSortableFilterOptions<CalendarItem> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
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

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItemById(String sdkId, GroupScoped<StoredDocumentIdentifier> entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.deleteCalendarItemById',
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
			'CalendarItemBasicApi.inGroup.deleteCalendarItemsByIds',
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
			'CalendarItemBasicApi.inGroup.deleteCalendarItem',
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
			'CalendarItemBasicApi.inGroup.deleteCalendarItems',
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

	Future<GroupScoped<EncryptedCalendarItem>> createCalendarItem(String sdkId, GroupScoped<EncryptedCalendarItem> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.inGroup.createCalendarItem',
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
			'CalendarItemBasicApi.inGroup.modifyCalendarItem',
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
			'CalendarItemBasicApi.inGroup.getCalendarItem',
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
			'CalendarItemBasicApi.inGroup.getCalendarItems',
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