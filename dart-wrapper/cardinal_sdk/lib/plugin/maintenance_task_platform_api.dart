// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/maintenance_task_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverMaintenanceTaskPlatformApi tryAndRecover;
	EncryptedMaintenanceTaskPlatformApi encrypted;
	MaintenanceTaskPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverMaintenanceTaskPlatformApi(_methodChannel),
		encrypted = EncryptedMaintenanceTaskPlatformApi(_methodChannel);

	Future<DecryptedMaintenanceTask> createMaintenanceTask(String sdkId, DecryptedMaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.createMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedMaintenanceTask.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<DecryptedMaintenanceTask> withEncryptionMetadata(String sdkId, DecryptedMaintenanceTask? maintenanceTask, User? user, Map<String, AccessLevel> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(maintenanceTask == null ? null : DecryptedMaintenanceTask.encode(maintenanceTask!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<bool> hasWriteAccess(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return parsedResJson;
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, MaintenanceTask entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(MaintenanceTask.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0)),
			}
		);
	}

	Future<DecryptedMaintenanceTask> decrypt(String sdkId, EncryptedMaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.decrypt',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(EncryptedMaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> tryDecrypt(String sdkId, EncryptedMaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(EncryptedMaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<List<String>> matchMaintenanceTasksBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.matchMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchMaintenanceTasksBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.matchMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.deleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.deleteMaintenanceTasksByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTasksByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.purgeMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.deleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(String sdkId, List<MaintenanceTask> maintenanceTasks) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.deleteMaintenanceTasks',
			{
				"sdkId": sdkId,
				"maintenanceTasks": jsonEncode(maintenanceTasks.map((x0) => MaintenanceTask.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.purgeMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
	}

	Future<DecryptedMaintenanceTask> shareWith(String sdkId, String delegateId, DecryptedMaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"maintenanceTask": jsonEncode(DecryptedMaintenanceTask.encode(maintenanceTask)),
				"options": jsonEncode(options == null ? null : MaintenanceTaskShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<DecryptedMaintenanceTask> shareWithMany(String sdkId, DecryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.shareWithMany',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(DecryptedMaintenanceTask.encode(maintenanceTask)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MaintenanceTaskShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.filterMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedMaintenanceTask.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.filterMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedMaintenanceTask.fromJSON(x0));
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.undeleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<DecryptedMaintenanceTask> undeleteMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.undeleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<DecryptedMaintenanceTask> modifyMaintenanceTask(String sdkId, DecryptedMaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.modifyMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedMaintenanceTask.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<DecryptedMaintenanceTask> getMaintenanceTask(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.getMaintenanceTask',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return DecryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<List<DecryptedMaintenanceTask>> getMaintenanceTasks(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.getMaintenanceTasks',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DecryptedMaintenanceTask.fromJSON(x1) );
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0))),
				"filter": jsonEncode(filter.json),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}
}

class TryAndRecoverMaintenanceTaskPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverMaintenanceTaskPlatformApi(this._methodChannel);

	Future<MaintenanceTask> shareWith(String sdkId, String delegateId, MaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
				"options": jsonEncode(options == null ? null : MaintenanceTaskShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> shareWithMany(String sdkId, MaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MaintenanceTaskShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => MaintenanceTask.fromJSON(x0));
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => MaintenanceTask.fromJSON(x0));
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> undeleteMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.undeleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> modifyMaintenanceTask(String sdkId, MaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(MaintenanceTask.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> getMaintenanceTask(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.getMaintenanceTask',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<List<MaintenanceTask>> getMaintenanceTasks(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.tryAndRecover.getMaintenanceTasks',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => MaintenanceTask.fromJSON(x1) );
	}
}

class EncryptedMaintenanceTaskPlatformApi {
	MethodChannel _methodChannel;
	EncryptedMaintenanceTaskPlatformApi(this._methodChannel);

	Future<EncryptedMaintenanceTask> shareWith(String sdkId, String delegateId, EncryptedMaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"maintenanceTask": jsonEncode(EncryptedMaintenanceTask.encode(maintenanceTask)),
				"options": jsonEncode(options == null ? null : MaintenanceTaskShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> shareWithMany(String sdkId, EncryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(EncryptedMaintenanceTask.encode(maintenanceTask)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MaintenanceTaskShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.filterMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.filterMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.undeleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.undeleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(String sdkId, EncryptedMaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.modifyMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMaintenanceTask.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> getMaintenanceTask(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.getMaintenanceTask',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskApi.encrypted.getMaintenanceTasks',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedMaintenanceTask.fromJSON(x1) );
	}
}