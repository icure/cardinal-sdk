// auto-generated file
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
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


class CalendarItemApi {
	final String _sdkId;
	final Object _dartSdk;
	final CalendarItemEncryptedApi encrypted;
	final CalendarItemTryAndRecoverApi tryAndRecover;
	final CalendarItemInGroupApi inGroup;
	CalendarItemApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = CalendarItemEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = CalendarItemTryAndRecoverApi(_sdkId, _dartSdk),
		inGroup = CalendarItemInGroupApi(_sdkId, _dartSdk);

	Future<DecryptedCalendarItem> withEncryptionMetadata(DecryptedCalendarItem? base, Patient? patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getEncryptionKeysOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<bool> hasWriteAccess(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.hasWriteAccess(
			_sdkId,
			calendarItem,
		);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.decryptPatientIdOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(CalendarItem entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<List<DecryptedCalendarItem>> decrypt(List<EncryptedCalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.decrypt(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<CalendarItem>> tryDecrypt(List<EncryptedCalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryDecrypt(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<EncryptedCalendarItem>> encryptOrValidate(List<CalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encryptOrValidate(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<String>> matchCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.matchCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.matchCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItemById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItemById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItemsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.purgeCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteCalendarItems(List<CalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<void> purgeCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.purgeCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<DecryptedCalendarItem> shareWith(String delegateId, DecryptedCalendarItem calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<DecryptedCalendarItem> shareWithMany(DecryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<DecryptedCalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedCalendarItem> createCalendarItem(DecryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedCalendarItem> bookCalendarItemCheckingAvailability(DecryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.bookCalendarItemCheckingAvailability(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<DecryptedCalendarItem> modifyCalendarItem(DecryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedCalendarItem?> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class CalendarItemTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<CalendarItem> shareWith(String delegateId, CalendarItem calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<CalendarItem> shareWithMany(CalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<CalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<CalendarItem> createCalendarItem(CalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<CalendarItem> bookCalendarItemCheckingAvailability(CalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.bookCalendarItemCheckingAvailability(
			_sdkId,
			entity,
		);
	}

	Future<CalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<CalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<CalendarItem> modifyCalendarItem(CalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<CalendarItem?> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<CalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}
}

class CalendarItemEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedCalendarItem> shareWith(String delegateId, EncryptedCalendarItem calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<EncryptedCalendarItem> shareWithMany(EncryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<EncryptedCalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedCalendarItem> createCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> bookCalendarItemCheckingAvailability(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.bookCalendarItemCheckingAvailability(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem?> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}
}

class CalendarItemInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	final CalendarItemInGroupEncryptedApi encrypted;
	final CalendarItemInGroupTryAndRecoverApi tryAndRecover;
	CalendarItemInGroupApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = CalendarItemInGroupEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = CalendarItemInGroupTryAndRecoverApi(_sdkId, _dartSdk);

	Future<GroupScoped<DecryptedCalendarItem>> withEncryptionMetadata(String entityGroupId, DecryptedCalendarItem? base, GroupScoped<Patient>? patient, { User? user, Map<EntityReferenceInGroup, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, EntityReferenceInGroup? alternateRootDelegateReference }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.withEncryptionMetadata(
			_sdkId,
			entityGroupId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateReference,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(GroupScoped<CalendarItem> calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.getEncryptionKeysOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<bool> hasWriteAccess(GroupScoped<CalendarItem> calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.hasWriteAccess(
			_sdkId,
			calendarItem,
		);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(GroupScoped<CalendarItem> calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.decryptPatientIdOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(GroupScoped<CalendarItem> entity, Set<EntityReferenceInGroup> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<List<GroupScoped<DecryptedCalendarItem>>> decrypt(List<GroupScoped<EncryptedCalendarItem>> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.decrypt(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<GroupScoped<CalendarItem>>> tryDecrypt(List<GroupScoped<EncryptedCalendarItem>> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryDecrypt(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<GroupScoped<EncryptedCalendarItem>>> encryptOrValidate(List<GroupScoped<CalendarItem>> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encryptOrValidate(
			_sdkId,
			calendarItems,
		);
	}

	Future<List<String>> matchCalendarItemsBy(String groupId, FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.matchCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(String groupId, SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.matchCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItemById(GroupScoped<StoredDocumentIdentifier> entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.deleteCalendarItemById(
			_sdkId,
			entityId,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItemsByIds(List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteCalendarItem(GroupScoped<CalendarItem> calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteCalendarItems(List<GroupScoped<CalendarItem>> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> shareWith(EntityReferenceInGroup delegate, GroupScoped<DecryptedCalendarItem> calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.shareWith(
			_sdkId,
			delegate,
			calendarItem,
			options,
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> shareWithMany(GroupScoped<DecryptedCalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>> filterCalendarItemsBy(String groupId, FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.filterCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>> filterCalendarItemsBySorted(String groupId, SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.filterCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> createCalendarItem(GroupScoped<DecryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>> modifyCalendarItem(GroupScoped<DecryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<DecryptedCalendarItem>?> getCalendarItem(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.getCalendarItem(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<DecryptedCalendarItem>>> getCalendarItems(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.getCalendarItems(
			_sdkId,
			groupId,
			entityIds,
		);
	}
}

class CalendarItemInGroupEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemInGroupEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<EncryptedCalendarItem>> shareWith(EntityReferenceInGroup delegate, GroupScoped<EncryptedCalendarItem> calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.shareWith(
			_sdkId,
			delegate,
			calendarItem,
			options,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> shareWithMany(GroupScoped<EncryptedCalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBy(String groupId, FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.filterCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedCalendarItem>>> filterCalendarItemsBySorted(String groupId, SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.filterCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> createCalendarItem(GroupScoped<EncryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>> modifyCalendarItem(GroupScoped<EncryptedCalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedCalendarItem>?> getCalendarItem(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.getCalendarItem(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<EncryptedCalendarItem>>> getCalendarItems(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.encrypted.getCalendarItems(
			_sdkId,
			groupId,
			entityIds,
		);
	}
}

class CalendarItemInGroupTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemInGroupTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<CalendarItem>> shareWith(EntityReferenceInGroup delegate, GroupScoped<CalendarItem> calendarItem, { CalendarItemShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.shareWith(
			_sdkId,
			delegate,
			calendarItem,
			options,
		);
	}

	Future<GroupScoped<CalendarItem>> shareWithMany(GroupScoped<CalendarItem> calendarItem, Map<EntityReferenceInGroup, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<PaginatedListIterator<GroupScoped<CalendarItem>>> filterCalendarItemsBy(String groupId, FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.filterCalendarItemsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<CalendarItem>>> filterCalendarItemsBySorted(String groupId, SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.filterCalendarItemsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<CalendarItem>> createCalendarItem(GroupScoped<CalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<CalendarItem>> modifyCalendarItem(GroupScoped<CalendarItem> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<CalendarItem>?> getCalendarItem(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.getCalendarItem(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<CalendarItem>>> getCalendarItems(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.inGroup.tryAndRecover.getCalendarItems(
			_sdkId,
			groupId,
			entityIds,
		);
	}
}