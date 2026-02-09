// auto-generated file
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
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


class HealthElementApi {
	final String _sdkId;
	final Object _dartSdk;
	final HealthElementEncryptedApi encrypted;
	final HealthElementTryAndRecoverApi tryAndRecover;
	final HealthElementInGroupApi inGroup;
	HealthElementApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = HealthElementEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = HealthElementTryAndRecoverApi(_sdkId, _dartSdk),
		inGroup = HealthElementInGroupApi(_sdkId, _dartSdk);

	Future<DecryptedHealthElement> withEncryptionMetadata(DecryptedHealthElement? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getEncryptionKeysOf(
			_sdkId,
			healthElement,
		);
	}

	Future<bool> hasWriteAccess(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.hasWriteAccess(
			_sdkId,
			healthElement,
		);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.decryptPatientIdOf(
			_sdkId,
			healthElement,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(HealthElement entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<List<DecryptedHealthElement>> decrypt(List<EncryptedHealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.decrypt(
			_sdkId,
			healthElements,
		);
	}

	Future<List<HealthElement>> tryDecrypt(List<EncryptedHealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryDecrypt(
			_sdkId,
			healthElements,
		);
	}

	Future<List<EncryptedHealthElement>> encryptOrValidate(List<HealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encryptOrValidate(
			_sdkId,
			healthElements,
		);
	}

	Future<List<String>> matchHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.matchHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.matchHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deleteHealthElementById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElementById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElementsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElementsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.purgeHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElements(List<HealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElements(
			_sdkId,
			healthElements,
		);
	}

	Future<void> purgeHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.purgeHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<DecryptedHealthElement> shareWith(String delegateId, DecryptedHealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<DecryptedHealthElement> shareWithMany(DecryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedHealthElement> createHealthElement(DecryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedHealthElement>> createHealthElements(List<DecryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<DecryptedHealthElement> modifyHealthElement(DecryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedHealthElement>> modifyHealthElements(List<DecryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedHealthElement?> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getHealthElements(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<HealthElement> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class HealthElementTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthElementTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<HealthElement> shareWith(String delegateId, HealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<HealthElement> shareWithMany(HealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<HealthElement> createHealthElement(HealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<HealthElement>> createHealthElements(List<HealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.createHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<HealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<HealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<HealthElement> modifyHealthElement(HealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<HealthElement>> modifyHealthElements(List<HealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<HealthElement?> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<HealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.getHealthElements(
			_sdkId,
			entityIds,
		);
	}
}

class HealthElementEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthElementEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedHealthElement> shareWith(String delegateId, EncryptedHealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<EncryptedHealthElement> shareWithMany(EncryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedHealthElement> createHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> createHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.createHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> modifyHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement?> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.getHealthElements(
			_sdkId,
			entityIds,
		);
	}
}

class HealthElementInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	final HealthElementInGroupEncryptedApi encrypted;
	final HealthElementInGroupTryAndRecoverApi tryAndRecover;
	HealthElementInGroupApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = HealthElementInGroupEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = HealthElementInGroupTryAndRecoverApi(_sdkId, _dartSdk);

	Future<GroupScoped<DecryptedHealthElement>> withEncryptionMetadata(String entityGroupId, DecryptedHealthElement? base, GroupScoped<Patient> patient, { User? user, Map<EntityReferenceInGroup, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, EntityReferenceInGroup? alternateRootDelegateReference }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.withEncryptionMetadata(
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

	Future<Set<HexString>> getEncryptionKeysOf(GroupScoped<HealthElement> healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.getEncryptionKeysOf(
			_sdkId,
			healthElement,
		);
	}

	Future<bool> hasWriteAccess(GroupScoped<HealthElement> healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.hasWriteAccess(
			_sdkId,
			healthElement,
		);
	}

	Future<Set<EntityReferenceInGroup>> decryptPatientIdOf(GroupScoped<HealthElement> healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.decryptPatientIdOf(
			_sdkId,
			healthElement,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(GroupScoped<HealthElement> entity, Set<EntityReferenceInGroup> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<List<GroupScoped<DecryptedHealthElement>>> decrypt(List<GroupScoped<EncryptedHealthElement>> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.decrypt(
			_sdkId,
			healthElements,
		);
	}

	Future<List<GroupScoped<HealthElement>>> tryDecrypt(List<GroupScoped<EncryptedHealthElement>> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryDecrypt(
			_sdkId,
			healthElements,
		);
	}

	Future<List<GroupScoped<EncryptedHealthElement>>> encryptOrValidate(List<GroupScoped<HealthElement>> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encryptOrValidate(
			_sdkId,
			healthElements,
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> shareWith(EntityReferenceInGroup delegate, GroupScoped<DecryptedHealthElement> healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.shareWith(
			_sdkId,
			delegate,
			healthElement,
			options,
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> shareWithMany(GroupScoped<DecryptedHealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> createHealthElement(GroupScoped<DecryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<DecryptedHealthElement>> modifyHealthElement(GroupScoped<DecryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<DecryptedHealthElement>?> getHealthElement(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.getHealthElement(
			_sdkId,
			groupId,
			entityId,
		);
	}
}

class HealthElementInGroupEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthElementInGroupEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<EncryptedHealthElement>> shareWith(EntityReferenceInGroup delegate, GroupScoped<EncryptedHealthElement> healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encrypted.shareWith(
			_sdkId,
			delegate,
			healthElement,
			options,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> shareWithMany(GroupScoped<EncryptedHealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encrypted.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> createHealthElement(GroupScoped<EncryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encrypted.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> modifyHealthElement(GroupScoped<EncryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encrypted.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>?> getHealthElement(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.encrypted.getHealthElement(
			_sdkId,
			groupId,
			entityId,
		);
	}
}

class HealthElementInGroupTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthElementInGroupTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<HealthElement>> shareWith(EntityReferenceInGroup delegate, GroupScoped<HealthElement> healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryAndRecover.shareWith(
			_sdkId,
			delegate,
			healthElement,
			options,
		);
	}

	Future<GroupScoped<HealthElement>> shareWithMany(GroupScoped<HealthElement> healthElement, Map<EntityReferenceInGroup, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryAndRecover.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<GroupScoped<HealthElement>> createHealthElement(GroupScoped<HealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryAndRecover.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<HealthElement>> modifyHealthElement(GroupScoped<HealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryAndRecover.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<HealthElement>?> getHealthElement(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.inGroup.tryAndRecover.getHealthElement(
			_sdkId,
			groupId,
			entityId,
		);
	}
}