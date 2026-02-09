// auto-generated file
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/share_all_patient_data_options.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/crypto/entities/patient_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class PatientApi {
	final String _sdkId;
	final Object _dartSdk;
	final PatientEncryptedApi encrypted;
	final PatientTryAndRecoverApi tryAndRecover;
	final PatientInGroupApi inGroup;
	PatientApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = PatientEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = PatientTryAndRecoverApi(_sdkId, _dartSdk),
		inGroup = PatientInGroupApi(_sdkId, _dartSdk);

	Future<List<DecryptedPatient>> decrypt(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.decrypt(
			_sdkId,
			patients,
		);
	}

	Future<List<Patient>> tryDecrypt(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryDecrypt(
			_sdkId,
			patients,
		);
	}

	Future<List<EncryptedPatient>> encryptOrValidate(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encryptOrValidate(
			_sdkId,
			patients,
		);
	}

	Future<Map<String, Set<EntityReferenceInGroup>>> getSecretIdsOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getSecretIdsOf(
			_sdkId,
			patient,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getEncryptionKeysOf(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> withEncryptionMetadata(DecryptedPatient? base, { User? user, Map<String, AccessLevel> delegates = const {}, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.withEncryptionMetadata(
			_sdkId,
			base,
			user,
			delegates,
			alternateRootDelegateId,
		);
	}

	Future<bool> hasWriteAccess(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.hasWriteAccess(
			_sdkId,
			patient,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Patient entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<ShareAllPatientDataOptionsResult> shareAllDataOfPatient(String patientId, Map<String, Set<ShareAllPatientDataOptionsTag>> delegatesWithShareType) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.shareAllDataOfPatient(
			_sdkId,
			patientId,
			delegatesWithShareType,
		);
	}

	Future<Set<String>> getConfidentialSecretIdsOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getConfidentialSecretIdsOf(
			_sdkId,
			patient,
		);
	}

	Future<bool> forceInitializeExchangeDataToNewlyInvitedPatient(String patientId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.forceInitializeExchangeDataToNewlyInvitedPatient(
			_sdkId,
			patientId,
		);
	}

	Future<List<String>> matchPatientsBy(FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.matchPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.matchPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedPatient> ensureEncryptionMetadataForSelfIsInitialized({ Map<String, AccessLevel> sharingWith = const {}, bool ignoreIfEncryptionMetadataExists = false, String? alternateRootDelegateId }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.ensureEncryptionMetadataForSelfIsInitialized(
			_sdkId,
			sharingWith,
			ignoreIfEncryptionMetadataExists,
			alternateRootDelegateId,
		);
	}

	Future<StoredDocumentIdentifier> deletePatientById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.deletePatientById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deletePatientsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.deletePatientsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.purgePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.deletePatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> deletePatients(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.deletePatients(
			_sdkId,
			patients,
		);
	}

	Future<void> purgePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.purgePatient(
			_sdkId,
			patient,
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getDataOwnersWithAccessTo(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> shareWith(String delegateId, DecryptedPatient patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<DecryptedPatient> shareWithMany(DecryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<DecryptedPatient> initializeConfidentialSecretId(DecryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBy(FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBySorted(SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedPatient> createPatient(DecryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(List<DecryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<DecryptedPatient>> createPatients(List<DecryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> modifyPatient(DecryptedPatient entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedPatient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<DecryptedPatient>> undeletePatients(List<StoredDocumentIdentifier> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<DecryptedPatient?> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<DecryptedPatient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<DecryptedPatient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(List<DecryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<DecryptedPatient>> modifyPatients(List<DecryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.modifyPatients(
			_sdkId,
			patients,
		);
	}

	Future<DecryptedPatient> mergePatients(Patient from, DecryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<Patient> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class PatientTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	PatientTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Patient> shareWith(String delegateId, Patient patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<Patient> shareWithMany(Patient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<Patient> initializeConfidentialSecretId(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBy(FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBySorted(SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Patient> createPatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<Patient>> createPatients(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<Patient> modifyPatient(Patient entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<Patient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<Patient>> undeletePatients(List<StoredDocumentIdentifier> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<Patient?> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<Patient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<Patient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<Patient>> modifyPatients(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.modifyPatients(
			_sdkId,
			patients,
		);
	}

	Future<Patient> mergePatients(Patient from, Patient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.tryAndRecover.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}
}

class PatientEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	PatientEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedPatient> shareWith(String delegateId, EncryptedPatient patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<EncryptedPatient> shareWithMany(EncryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<EncryptedPatient> initializeConfidentialSecretId(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedPatient> createPatient(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<EncryptedPatient>> createPatients(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<EncryptedPatient> modifyPatient(EncryptedPatient entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedPatient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<EncryptedPatient>> undeletePatients(List<StoredDocumentIdentifier> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<EncryptedPatient?> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<EncryptedPatient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<EncryptedPatient>> modifyPatients(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.modifyPatients(
			_sdkId,
			patients,
		);
	}

	Future<EncryptedPatient> mergePatients(Patient from, EncryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.encrypted.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}
}

class PatientInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	final PatientInGroupEncryptedApi encrypted;
	final PatientInGroupTryAndRecoverApi tryAndRecover;
	PatientInGroupApi(
		this._sdkId,
		this._dartSdk
		) : encrypted = PatientInGroupEncryptedApi(_sdkId, _dartSdk),
		tryAndRecover = PatientInGroupTryAndRecoverApi(_sdkId, _dartSdk);

	Future<List<GroupScoped<DecryptedPatient>>> decrypt(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.decrypt(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<Patient>>> tryDecrypt(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryDecrypt(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> encryptOrValidate(List<GroupScoped<Patient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encryptOrValidate(
			_sdkId,
			patients,
		);
	}

	Future<Map<String, Set<EntityReferenceInGroup>>> getSecretIdsOf(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getSecretIdsOf(
			_sdkId,
			patient,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getEncryptionKeysOf(
			_sdkId,
			patient,
		);
	}

	Future<GroupScoped<DecryptedPatient>> withEncryptionMetadata(String entityGroupId, DecryptedPatient? base, { User? user, Map<EntityReferenceInGroup, AccessLevel> delegates = const {}, EntityReferenceInGroup? alternateRootDelegateReference }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.withEncryptionMetadata(
			_sdkId,
			entityGroupId,
			base,
			user,
			delegates,
			alternateRootDelegateReference,
		);
	}

	Future<bool> hasWriteAccess(GroupScoped<DecryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.hasWriteAccess(
			_sdkId,
			patient,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(GroupScoped<DecryptedPatient> entity, Set<EntityReferenceInGroup> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<List<String>> matchPatientsBy(String groupId, FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.matchPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(String groupId, SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.matchPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getDataOwnersWithAccessTo(
			_sdkId,
			patient,
		);
	}

	Future<GroupScoped<DecryptedPatient>> shareWith(EntityReferenceInGroup delegate, GroupScoped<DecryptedPatient> patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.shareWith(
			_sdkId,
			delegate,
			patient,
			options,
		);
	}

	Future<GroupScoped<DecryptedPatient>> shareWithMany(GroupScoped<DecryptedPatient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<GroupScoped<DecryptedPatient>> initializeConfidentialSecretId(GroupScoped<DecryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedPatient>>> filterPatientsBy(String groupId, FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.filterPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<DecryptedPatient>>> filterPatientsBySorted(String groupId, SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.filterPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<DecryptedPatient>> createPatient(GroupScoped<DecryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(List<GroupScoped<DecryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<DecryptedPatient>>> createPatients(List<GroupScoped<DecryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<GroupScoped<DecryptedPatient>?> getPatient(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getPatient(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<GroupScoped<DecryptedPatient>> getPatientResolvingMerges(String groupId, String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getPatientResolvingMerges(
			_sdkId,
			groupId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<GroupScoped<DecryptedPatient>>> getPatients(String groupId, List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.getPatients(
			_sdkId,
			groupId,
			patientIds,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(List<GroupScoped<DecryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<DecryptedPatient>>> modifyPatients(List<GroupScoped<DecryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.modifyPatients(
			_sdkId,
			patients,
		);
	}
}

class PatientInGroupEncryptedApi {
	final String _sdkId;
	final Object _dartSdk;
	PatientInGroupEncryptedApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<EncryptedPatient>> shareWith(EntityReferenceInGroup delegate, GroupScoped<EncryptedPatient> patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.shareWith(
			_sdkId,
			delegate,
			patient,
			options,
		);
	}

	Future<GroupScoped<EncryptedPatient>> shareWithMany(GroupScoped<EncryptedPatient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<GroupScoped<EncryptedPatient>> initializeConfidentialSecretId(GroupScoped<EncryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBy(String groupId, FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.filterPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBySorted(String groupId, SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.filterPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<EncryptedPatient>> createPatient(GroupScoped<EncryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> createPatients(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<GroupScoped<EncryptedPatient>?> getPatient(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.getPatient(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<GroupScoped<EncryptedPatient>> getPatientResolvingMerges(String groupId, String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.getPatientResolvingMerges(
			_sdkId,
			groupId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> getPatients(String groupId, List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.getPatients(
			_sdkId,
			groupId,
			patientIds,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> modifyPatients(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.encrypted.modifyPatients(
			_sdkId,
			patients,
		);
	}
}

class PatientInGroupTryAndRecoverApi {
	final String _sdkId;
	final Object _dartSdk;
	PatientInGroupTryAndRecoverApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<Patient>> shareWith(EntityReferenceInGroup delegate, GroupScoped<Patient> patient, { PatientShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.shareWith(
			_sdkId,
			delegate,
			patient,
			options,
		);
	}

	Future<GroupScoped<Patient>> shareWithMany(GroupScoped<Patient> patient, Map<EntityReferenceInGroup, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<GroupScoped<Patient>> initializeConfidentialSecretId(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<GroupScoped<Patient>>> filterPatientsBy(String groupId, FilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.filterPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<Patient>>> filterPatientsBySorted(String groupId, SortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.filterPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<GroupScoped<Patient>> createPatient(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(List<GroupScoped<Patient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<Patient>>> createPatients(List<GroupScoped<Patient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<GroupScoped<Patient>?> getPatient(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.getPatient(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<GroupScoped<Patient>> getPatientResolvingMerges(String groupId, String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.getPatientResolvingMerges(
			_sdkId,
			groupId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<GroupScoped<Patient>>> getPatients(String groupId, List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.getPatients(
			_sdkId,
			groupId,
			patientIds,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(List<GroupScoped<Patient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<Patient>>> modifyPatients(List<GroupScoped<Patient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patient.inGroup.tryAndRecover.modifyPatients(
			_sdkId,
			patients,
		);
	}
}