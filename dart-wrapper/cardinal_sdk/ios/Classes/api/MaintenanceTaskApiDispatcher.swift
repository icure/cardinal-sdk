// auto-generated file
import CardinalDartSdkSupportLib

class MaintenanceTaskApiDispatcher {

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
    case "matchMaintenanceTasksBy": matchMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "matchMaintenanceTasksBySorted": matchMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTaskById": deleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTasksByIds": deleteMaintenanceTasksByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeMaintenanceTaskById": purgeMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTask": deleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTasks": deleteMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
    case "purgeMaintenanceTask": purgeMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterMaintenanceTasksBy": filterMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "filterMaintenanceTasksBySorted": filterMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createMaintenanceTask": createMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMaintenanceTask": undeleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMaintenanceTaskById": undeleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "modifyMaintenanceTask": modifyMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "getMaintenanceTask": getMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "getMaintenanceTasks": getMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterMaintenanceTasksBy": encrypted_filterMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterMaintenanceTasksBySorted": encrypted_filterMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createMaintenanceTask": encrypted_createMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteMaintenanceTask": encrypted_undeleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteMaintenanceTaskById": encrypted_undeleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyMaintenanceTask": encrypted_modifyMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getMaintenanceTask": encrypted_getMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getMaintenanceTasks": encrypted_getMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterMaintenanceTasksBy": tryAndRecover_filterMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterMaintenanceTasksBySorted": tryAndRecover_filterMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createMaintenanceTask": tryAndRecover_createMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteMaintenanceTask": tryAndRecover_undeleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteMaintenanceTaskById": tryAndRecover_undeleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyMaintenanceTask": tryAndRecover_modifyMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getMaintenanceTask": tryAndRecover_getMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getMaintenanceTasks": tryAndRecover_getMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
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
    MaintenanceTaskApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.createDelegationDeAnonymizationMetadata(
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
    MaintenanceTaskApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func matchMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.matchMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.matchMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.deleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMaintenanceTasksByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.deleteMaintenanceTasksByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.purgeMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.deleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func deleteMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.deleteMaintenanceTasks(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTasksString: parameters["maintenanceTasks"]!
    )
  }

  private static func purgeMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.purgeMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.filterMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.filterMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.createMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.undeleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func undeleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.undeleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func modifyMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.modifyMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.getMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.shared.getMaintenanceTasks(
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
    MaintenanceTaskApi.shared.subscribeToEvents(
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
    MaintenanceTaskApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.filterMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.filterMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.createMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.undeleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func encrypted_undeleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.undeleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_modifyMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.modifyMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.getMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.encrypted.shared.getMaintenanceTasks(
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
    MaintenanceTaskApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.filterMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.filterMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.createMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.undeleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func tryAndRecover_undeleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.undeleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_modifyMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.modifyMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.getMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskApi.tryAndRecover.shared.getMaintenanceTasks(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
