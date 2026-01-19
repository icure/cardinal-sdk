// auto-generated file
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/maintenance_task_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskApi {
	final String _sdkId;
	final Object _dartSdk;
	final MaintenanceTaskEncryptedApi encrypted;
	final MaintenanceTaskTryAndRecoverApi tryAndRecover;
	MaintenanceTaskApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = MaintenanceTaskEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = MaintenanceTaskTryAndRecoverApi(_sdkId, _dartSdk);

	Future<DecryptedMaintenanceTask> withEncryptionMetadata(DecryptedMaintenanceTask? maintenanceTask, { User? user, Map<String, AccessLevel> delegates = const {}, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.withEncryptionMetadata(
			_sdkId,
			maintenanceTask,
			user,
			delegates,
			alternateRootDelegateId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.getEncryptionKeysOf(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<bool> hasWriteAccess(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.hasWriteAccess(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<Set<String>> decryptPatientIdOf(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.decryptPatientIdOf(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(MaintenanceTask entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedMaintenanceTask> decrypt(EncryptedMaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.decrypt(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> tryDecrypt(EncryptedMaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryDecrypt(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<String>> matchMaintenanceTasksBy(FilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.matchMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMaintenanceTasksBySorted(SortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.matchMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.deleteMaintenanceTaskById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.deleteMaintenanceTasksByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.purgeMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.deleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.deleteMaintenanceTasks(
			_sdkId,
			maintenanceTasks,
		);
	}

	Future<void> purgeMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.purgeMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<DecryptedMaintenanceTask> shareWith(String delegateId, DecryptedMaintenanceTask maintenanceTask, { MaintenanceTaskShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<DecryptedMaintenanceTask> shareWithMany(DecryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBy(FilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedMaintenanceTask> createMaintenanceTask(DecryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.createMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<DecryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedMaintenanceTask> modifyMaintenanceTask(DecryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMaintenanceTask?> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<MaintenanceTask> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class MaintenanceTaskTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	MaintenanceTaskTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<MaintenanceTask> shareWith(String delegateId, MaintenanceTask maintenanceTask, { MaintenanceTaskShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<MaintenanceTask> shareWithMany(MaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBy(FilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<MaintenanceTask> createMaintenanceTask(MaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.createMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<MaintenanceTask> modifyMaintenanceTask(MaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<MaintenanceTask?> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<MaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.tryAndRecover.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}
}

class MaintenanceTaskEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	MaintenanceTaskEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedMaintenanceTask> shareWith(String delegateId, EncryptedMaintenanceTask maintenanceTask, { MaintenanceTaskShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<EncryptedMaintenanceTask> shareWithMany(EncryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(FilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedMaintenanceTask> createMaintenanceTask(EncryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.createMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(EncryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMaintenanceTask?> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTask.encrypted.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}
}