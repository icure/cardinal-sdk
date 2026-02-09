// auto-generated file
import CardinalDartSdkSupportLib

class ClassificationApiDispatcher {

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
    case "matchClassificationsBy": matchClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchClassificationsBySorted": matchClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteClassification": deleteClassification(parameters: parameters, resultCallback: resultCallback)
    case "deleteClassifications": deleteClassifications(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterClassificationsBy": filterClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterClassificationsBySorted": filterClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createClassification": createClassification(parameters: parameters, resultCallback: resultCallback)
    case "modifyClassification": modifyClassification(parameters: parameters, resultCallback: resultCallback)
    case "getClassification": getClassification(parameters: parameters, resultCallback: resultCallback)
    case "getClassifications": getClassifications(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterClassificationsBy": encrypted_filterClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterClassificationsBySorted": encrypted_filterClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createClassification": encrypted_createClassification(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyClassification": encrypted_modifyClassification(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getClassification": encrypted_getClassification(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getClassifications": encrypted_getClassifications(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterClassificationsBy": tryAndRecover_filterClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterClassificationsBySorted": tryAndRecover_filterClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createClassification": tryAndRecover_createClassification(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyClassification": tryAndRecover_modifyClassification(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getClassification": tryAndRecover_getClassification(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getClassifications": tryAndRecover_getClassifications(parameters: parameters, resultCallback: resultCallback)
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
    ClassificationApi.shared.withEncryptionMetadata(
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
    ClassificationApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.createDelegationDeAnonymizationMetadata(
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
    ClassificationApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!
    )
  }

  private static func matchClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.matchClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.matchClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.deleteClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func deleteClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.deleteClassifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	classificationString: parameters["classification"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.filterClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.filterClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.createClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.modifyClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.getClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.shared.getClassifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	classificationString: parameters["classification"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.filterClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.filterClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.createClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_modifyClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.modifyClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.getClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.encrypted.shared.getClassifications(
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
    ClassificationApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	classificationString: parameters["classification"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	classificationString: parameters["classification"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.filterClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.filterClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.createClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_modifyClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.modifyClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.getClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationApi.tryAndRecover.shared.getClassifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
