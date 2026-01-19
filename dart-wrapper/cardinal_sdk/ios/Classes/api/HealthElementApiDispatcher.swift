// auto-generated file
import CardinalDartSdkSupportLib

class HealthElementApiDispatcher {

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
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptPatientIdOf": decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "encryptOrValidate": encryptOrValidate(parameters: parameters, resultCallback: resultCallback)
    case "matchHealthElementsBy": matchHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchHealthElementsBySorted": matchHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElementById": deleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElementsByIds": deleteHealthElementsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthElementById": purgeHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElement": deleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElements": deleteHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthElement": purgeHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthElementsBy": filterHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthElementsBySorted": filterHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createHealthElement": createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "createHealthElements": createHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthElementById": undeleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthElement": undeleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthElement": modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthElements": modifyHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "getHealthElement": getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "getHealthElements": getHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterHealthElementsBy": encrypted_filterHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterHealthElementsBySorted": encrypted_filterHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createHealthElement": encrypted_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createHealthElements": encrypted_createHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteHealthElementById": encrypted_undeleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteHealthElement": encrypted_undeleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyHealthElement": encrypted_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyHealthElements": encrypted_modifyHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getHealthElement": encrypted_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getHealthElements": encrypted_getHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterHealthElementsBy": tryAndRecover_filterHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterHealthElementsBySorted": tryAndRecover_filterHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createHealthElement": tryAndRecover_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createHealthElements": tryAndRecover_createHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteHealthElementById": tryAndRecover_undeleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteHealthElement": tryAndRecover_undeleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyHealthElement": tryAndRecover_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyHealthElements": tryAndRecover_modifyHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getHealthElement": tryAndRecover_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getHealthElements": tryAndRecover_getHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.withEncryptionMetadata": inGroup_withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getEncryptionKeysOf": inGroup_getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.hasWriteAccess": inGroup_hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.decryptPatientIdOf": inGroup_decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createDelegationDeAnonymizationMetadata": inGroup_createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.decrypt": inGroup_decrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryDecrypt": inGroup_tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encryptOrValidate": inGroup_encryptOrValidate(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWith": inGroup_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWithMany": inGroup_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createHealthElement": inGroup_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyHealthElement": inGroup_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getHealthElement": inGroup_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWith": inGroup_encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWithMany": inGroup_encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.createHealthElement": inGroup_encrypted_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.modifyHealthElement": inGroup_encrypted_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getHealthElement": inGroup_encrypted_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWith": inGroup_tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWithMany": inGroup_tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.createHealthElement": inGroup_tryAndRecover_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.modifyHealthElement": inGroup_tryAndRecover_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getHealthElement": inGroup_tryAndRecover_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	patientString: parameters["patient"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	secretIdString: parameters["secretId"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func matchHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.matchHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.matchHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.deleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthElementsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.deleteHealthElementsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.purgeHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.deleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func deleteHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.deleteHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func purgeHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.purgeHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.filterHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.filterHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func createHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.createHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func undeleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.undeleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.undeleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.modifyHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.getHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.shared.subscribeToEvents(
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
    HealthElementApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.filterHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.filterHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_createHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.createHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_undeleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.undeleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.undeleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func encrypted_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_modifyHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.modifyHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.encrypted.shared.getHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.filterHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.filterHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_createHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.createHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_undeleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.undeleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.undeleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func tryAndRecover_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_modifyHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.modifyHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.tryAndRecover.shared.getHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityGroupIdString: parameters["entityGroupId"]!,
    	baseString: parameters["base"]!,
    	patientString: parameters["patient"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	secretIdString: parameters["secretId"]!,
    	alternateRootDelegateReferenceString: parameters["alternateRootDelegateReference"]!
    )
  }

  private static func inGroup_getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func inGroup_hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func inGroup_decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func inGroup_createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func inGroup_tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func inGroup_encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func inGroup_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroup.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupEncrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupEncrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_encrypted_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupEncrypted.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_encrypted_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupEncrypted.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_encrypted_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupEncrypted.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupTryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	healthElementString: parameters["healthElement"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupTryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_tryAndRecover_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupTryAndRecover.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_tryAndRecover_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupTryAndRecover.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_tryAndRecover_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementApi.inGroupTryAndRecover.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

}
