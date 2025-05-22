// auto-generated file
import CardinalDartSdkSupportLib

class AccessLogApiDispatcher {

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
    case "matchAccessLogsBy": matchAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchAccessLogsBySorted": matchAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogById": deleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogsByIds": deleteAccessLogsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeAccessLogById": purgeAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLog": deleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogs": deleteAccessLogs(parameters: parameters, resultCallback: resultCallback)
    case "purgeAccessLog": purgeAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterAccessLogsBy": filterAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterAccessLogsBySorted": filterAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createAccessLog": createAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAccessLogById": undeleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAccessLog": undeleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "modifyAccessLog": modifyAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "getAccessLog": getAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "getAccessLogs": getAccessLogs(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterAccessLogsBy": encrypted_filterAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterAccessLogsBySorted": encrypted_filterAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createAccessLog": encrypted_createAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteAccessLogById": encrypted_undeleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteAccessLog": encrypted_undeleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyAccessLog": encrypted_modifyAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getAccessLog": encrypted_getAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getAccessLogs": encrypted_getAccessLogs(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterAccessLogsBy": tryAndRecover_filterAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterAccessLogsBySorted": tryAndRecover_filterAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createAccessLog": tryAndRecover_createAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteAccessLogById": tryAndRecover_undeleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteAccessLog": tryAndRecover_undeleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyAccessLog": tryAndRecover_modifyAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getAccessLog": tryAndRecover_getAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getAccessLogs": tryAndRecover_getAccessLogs(parameters: parameters, resultCallback: resultCallback)
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
    AccessLogApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	patientString: parameters["patient"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	secretIdString: parameters["secretId"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.createDelegationDeAnonymizationMetadata(
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
    AccessLogApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func matchAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.matchAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.matchAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.deleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAccessLogsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.deleteAccessLogsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.purgeAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.deleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func deleteAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.deleteAccessLogs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogsString: parameters["accessLogs"]!
    )
  }

  private static func purgeAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.purgeAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	accessLogString: parameters["accessLog"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.filterAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.filterAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.createAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.undeleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.undeleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func modifyAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.modifyAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.getAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.shared.getAccessLogs(
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
    AccessLogApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	accessLogString: parameters["accessLog"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.filterAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.filterAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.createAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.undeleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.undeleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func encrypted_modifyAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.modifyAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.getAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.encrypted.shared.getAccessLogs(
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
    AccessLogApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	accessLogString: parameters["accessLog"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.filterAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.filterAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.createAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.undeleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.undeleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func tryAndRecover_modifyAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.modifyAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.getAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogApi.tryAndRecover.shared.getAccessLogs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
