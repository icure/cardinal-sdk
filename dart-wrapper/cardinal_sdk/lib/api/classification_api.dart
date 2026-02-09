// auto-generated file
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/classification_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class ClassificationApi {
	final String _sdkId;
	final Object _dartSdk;
	final ClassificationEncryptedApi encrypted;
	final ClassificationTryAndRecoverApi tryAndRecover;
	ClassificationApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = ClassificationEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = ClassificationTryAndRecoverApi(_sdkId, _dartSdk);

	Future<DecryptedClassification> withEncryptionMetadata(DecryptedClassification? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
			alternateRootDelegateId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.getEncryptionKeysOf(
			_sdkId,
			classification,
		);
	}

	Future<bool> hasWriteAccess(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.hasWriteAccess(
			_sdkId,
			classification,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.decryptPatientIdOf(
			_sdkId,
			classification,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Classification entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedClassification> decrypt(EncryptedClassification classification) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.decrypt(
			_sdkId,
			classification,
		);
	}

	Future<Classification> tryDecrypt(EncryptedClassification classification) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryDecrypt(
			_sdkId,
			classification,
		);
	}

	Future<List<String>> matchClassificationsBy(FilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.matchClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchClassificationsBySorted(SortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.matchClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.deleteClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.deleteClassifications(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedClassification> shareWith(String delegateId, DecryptedClassification classification, { ClassificationShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<DecryptedClassification> shareWithMany(DecryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBy(FilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBySorted(SortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedClassification> createClassification(DecryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.createClassification(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedClassification> modifyClassification(DecryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedClassification?> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}

class ClassificationTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	ClassificationTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Classification> shareWith(String delegateId, Classification classification, { ClassificationShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<Classification> shareWithMany(Classification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBy(FilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBySorted(SortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Classification> createClassification(Classification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.createClassification(
			_sdkId,
			entity,
		);
	}

	Future<Classification> modifyClassification(Classification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<Classification?> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<Classification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.tryAndRecover.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}

class ClassificationEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	ClassificationEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedClassification> shareWith(String delegateId, EncryptedClassification classification, { ClassificationShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<EncryptedClassification> shareWithMany(EncryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(FilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(SortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedClassification> createClassification(EncryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.createClassification(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedClassification> modifyClassification(EncryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedClassification?> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classification.encrypted.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}