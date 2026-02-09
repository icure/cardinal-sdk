// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class CalendarItemBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	final CalendarItemBasicInGroupApi inGroup;
	CalendarItemBasicApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = CalendarItemBasicInGroupApi(_sdkId, _dartSdk);

	Future<List<String>> matchCalendarItemsBy(BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.matchCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.matchCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItemById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItemById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItemsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.purgeCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItems(List<CalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<void> purgeCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.purgeCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> createCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> bookCalendarItemCheckingAvailability(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.bookCalendarItemCheckingAvailability(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem?> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class CalendarItemBasicInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemBasicInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchCalendarItemsBy(String groupId, BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.matchCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(String groupId, BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.matchCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBy(String groupId, BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.filterCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBySorted(String groupId, BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.filterCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItemById(GroupScoped<StoredDocumentIdentifier> entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.deleteCalendarItemById(
			_sdkId,
			entityId,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItemsByIds(List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItem(GroupScoped<CalendarItem> calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItems(List<GroupScoped<CalendarItem>> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> createCalendarItem(GroupScoped<EncryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> modifyCalendarItem(GroupScoped<EncryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>?> getCalendarItem(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.getCalendarItem(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<EncryptedCalendarItem>>> getCalendarItems(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.inGroup.getCalendarItems(
			_sdkId,
			groupId,
			entityIds,
		);
	}
}