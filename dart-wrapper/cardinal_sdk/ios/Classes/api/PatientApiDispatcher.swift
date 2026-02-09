// auto-generated file
import CardinalDartSdkSupportLib

class PatientApiDispatcher {

  static func dispatch(
    methodName: String,
    parameters: [String : String],
    resultCallback: @escaping (
      String?,
      String?,
      String?,
      String?
    ) -> Void
  ) -> Bool {
    switch methodName {
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "encryptOrValidate": encryptOrValidate(parameters: parameters, resultCallback: resultCallback)
    case "getSecretIdsOf": getSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "shareAllDataOfPatient": shareAllDataOfPatient(parameters: parameters, resultCallback: resultCallback)
    case "getConfidentialSecretIdsOf": getConfidentialSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "forceInitializeExchangeDataToNewlyInvitedPatient": forceInitializeExchangeDataToNewlyInvitedPatient(parameters: parameters, resultCallback: resultCallback)
    case "matchPatientsBy": matchPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchPatientsBySorted": matchPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "ensureEncryptionMetadataForSelfIsInitialized": ensureEncryptionMetadataForSelfIsInitialized(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientById": deletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientsByIds": deletePatientsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgePatientById": purgePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatient": deletePatient(parameters: parameters, resultCallback: resultCallback)
    case "deletePatients": deletePatients(parameters: parameters, resultCallback: resultCallback)
    case "purgePatient": purgePatient(parameters: parameters, resultCallback: resultCallback)
    case "getDataOwnersWithAccessTo": getDataOwnersWithAccessTo(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "initializeConfidentialSecretId": initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBy": filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBySorted": filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createPatient": createPatient(parameters: parameters, resultCallback: resultCallback)
    case "createPatientsMinimal": createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "createPatients": createPatients(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatient": undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatient": modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatientById": undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatients": undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "getPatient": getPatient(parameters: parameters, resultCallback: resultCallback)
    case "getPatientResolvingMerges": getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "getPatients": getPatients(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatientsMinimal": modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatients": modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "mergePatients": mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.initializeConfidentialSecretId": encrypted_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterPatientsBy": encrypted_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterPatientsBySorted": encrypted_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createPatient": encrypted_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createPatientsMinimal": encrypted_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createPatients": encrypted_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatient": encrypted_undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyPatient": encrypted_modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatientById": encrypted_undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatients": encrypted_undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatient": encrypted_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatientResolvingMerges": encrypted_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatients": encrypted_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyPatientsMinimal": encrypted_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyPatients": encrypted_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.mergePatients": encrypted_mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.initializeConfidentialSecretId": tryAndRecover_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterPatientsBy": tryAndRecover_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterPatientsBySorted": tryAndRecover_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createPatient": tryAndRecover_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createPatientsMinimal": tryAndRecover_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createPatients": tryAndRecover_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatient": tryAndRecover_undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyPatient": tryAndRecover_modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatientById": tryAndRecover_undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatients": tryAndRecover_undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatient": tryAndRecover_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatientResolvingMerges": tryAndRecover_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatients": tryAndRecover_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyPatientsMinimal": tryAndRecover_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyPatients": tryAndRecover_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.mergePatients": tryAndRecover_mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.decrypt": inGroup_decrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryDecrypt": inGroup_tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encryptOrValidate": inGroup_encryptOrValidate(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getSecretIdsOf": inGroup_getSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getEncryptionKeysOf": inGroup_getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.withEncryptionMetadata": inGroup_withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.hasWriteAccess": inGroup_hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createDelegationDeAnonymizationMetadata": inGroup_createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchPatientsBy": inGroup_matchPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchPatientsBySorted": inGroup_matchPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getDataOwnersWithAccessTo": inGroup_getDataOwnersWithAccessTo(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWith": inGroup_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWithMany": inGroup_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.initializeConfidentialSecretId": inGroup_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterPatientsBy": inGroup_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterPatientsBySorted": inGroup_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatient": inGroup_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatientsMinimal": inGroup_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatients": inGroup_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatient": inGroup_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatientResolvingMerges": inGroup_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatients": inGroup_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyPatientsMinimal": inGroup_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyPatients": inGroup_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWith": inGroup_encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWithMany": inGroup_encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.initializeConfidentialSecretId": inGroup_encrypted_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.filterPatientsBy": inGroup_encrypted_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.filterPatientsBySorted": inGroup_encrypted_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.createPatient": inGroup_encrypted_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.createPatientsMinimal": inGroup_encrypted_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.createPatients": inGroup_encrypted_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getPatient": inGroup_encrypted_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getPatientResolvingMerges": inGroup_encrypted_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getPatients": inGroup_encrypted_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.modifyPatientsMinimal": inGroup_encrypted_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.modifyPatients": inGroup_encrypted_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWith": inGroup_tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWithMany": inGroup_tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.initializeConfidentialSecretId": inGroup_tryAndRecover_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.filterPatientsBy": inGroup_tryAndRecover_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.filterPatientsBySorted": inGroup_tryAndRecover_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.createPatient": inGroup_tryAndRecover_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.createPatientsMinimal": inGroup_tryAndRecover_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.createPatients": inGroup_tryAndRecover_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getPatient": inGroup_tryAndRecover_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getPatientResolvingMerges": inGroup_tryAndRecover_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getPatients": inGroup_tryAndRecover_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.modifyPatientsMinimal": inGroup_tryAndRecover_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.modifyPatients": inGroup_tryAndRecover_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func getSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func shareAllDataOfPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareAllDataOfPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	delegatesWithShareTypeString: parameters["delegatesWithShareType"]!
    )
  }

  private static func getConfidentialSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getConfidentialSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func forceInitializeExchangeDataToNewlyInvitedPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.forceInitializeExchangeDataToNewlyInvitedPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!
    )
  }

  private static func matchPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.matchPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.matchPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func ensureEncryptionMetadataForSelfIsInitialized(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.ensureEncryptionMetadataForSelfIsInitialized(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	sharingWithString: parameters["sharingWith"]!,
    	ignoreIfEncryptionMetadataExistsString: parameters["ignoreIfEncryptionMetadataExists"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func deletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.deletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deletePatientsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.deletePatientsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.purgePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.deletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func deletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.deletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func purgePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.purgePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func getDataOwnersWithAccessTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getDataOwnersWithAccessTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func encrypted_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func encrypted_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func encrypted_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func encrypted_undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func encrypted_modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func encrypted_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func encrypted_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func encrypted_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func encrypted_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func encrypted_mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryAndRecover_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryAndRecover_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func tryAndRecover_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func tryAndRecover_undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryAndRecover_modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func tryAndRecover_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func tryAndRecover_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func tryAndRecover_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func tryAndRecover_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func tryAndRecover_mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

  private static func inGroup_decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_getSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityGroupIdString: parameters["entityGroupId"]!,
    	baseString: parameters["base"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	alternateRootDelegateReferenceString: parameters["alternateRootDelegateReference"]!
    )
  }

  private static func inGroup_hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_matchPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.matchPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_matchPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.matchPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_getDataOwnersWithAccessTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getDataOwnersWithAccessTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func inGroup_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func inGroup_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroup.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_encrypted_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_encrypted_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_encrypted_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_encrypted_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_encrypted_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_encrypted_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_encrypted_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_encrypted_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func inGroup_encrypted_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func inGroup_encrypted_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_encrypted_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupEncrypted.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_tryAndRecover_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_tryAndRecover_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_tryAndRecover_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_tryAndRecover_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_tryAndRecover_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_tryAndRecover_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_tryAndRecover_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_tryAndRecover_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func inGroup_tryAndRecover_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func inGroup_tryAndRecover_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_tryAndRecover_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.inGroupTryAndRecover.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

}
