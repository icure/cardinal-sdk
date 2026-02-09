// auto-generated file
import CardinalDartSdkSupportLib

class GroupApiDispatcher {

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
    case "listGroups": listGroups(parameters: parameters, resultCallback: resultCallback)
    case "getGroup": getGroup(parameters: parameters, resultCallback: resultCallback)
    case "createGroup": createGroup(parameters: parameters, resultCallback: resultCallback)
    case "registerNewGroupAdministrator": registerNewGroupAdministrator(parameters: parameters, resultCallback: resultCallback)
    case "listApps": listApps(parameters: parameters, resultCallback: resultCallback)
    case "getNameOfGroupParent": getNameOfGroupParent(parameters: parameters, resultCallback: resultCallback)
    case "modifyGroupName": modifyGroupName(parameters: parameters, resultCallback: resultCallback)
    case "getOperationToken": getOperationToken(parameters: parameters, resultCallback: resultCallback)
    case "deleteOperationToken": deleteOperationToken(parameters: parameters, resultCallback: resultCallback)
    case "setDefaultRoles": setDefaultRoles(parameters: parameters, resultCallback: resultCallback)
    case "getDefaultRoles": getDefaultRoles(parameters: parameters, resultCallback: resultCallback)
    case "deleteGroup": deleteGroup(parameters: parameters, resultCallback: resultCallback)
    case "changeSuperGroup": changeSuperGroup(parameters: parameters, resultCallback: resultCallback)
    case "hardDeleteGroup": hardDeleteGroup(parameters: parameters, resultCallback: resultCallback)
    case "modifyGroupProperties": modifyGroupProperties(parameters: parameters, resultCallback: resultCallback)
    case "setGroupPassword": setGroupPassword(parameters: parameters, resultCallback: resultCallback)
    case "initDesignDocs": initDesignDocs(parameters: parameters, resultCallback: resultCallback)
    case "solveConflicts": solveConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resetStorage": resetStorage(parameters: parameters, resultCallback: resultCallback)
    case "getGroupsStorageInfos": getGroupsStorageInfos(parameters: parameters, resultCallback: resultCallback)
    case "getReplicationInfo": getReplicationInfo(parameters: parameters, resultCallback: resultCallback)
    case "getHierarchy": getHierarchy(parameters: parameters, resultCallback: resultCallback)
    case "listAllGroupsIds": listAllGroupsIds(parameters: parameters, resultCallback: resultCallback)
    case "createOrUpdateExternalJwtConfig": createOrUpdateExternalJwtConfig(parameters: parameters, resultCallback: resultCallback)
    case "removeExternalJwtConfig": removeExternalJwtConfig(parameters: parameters, resultCallback: resultCallback)
    case "getOperationTokenForGroup": getOperationTokenForGroup(parameters: parameters, resultCallback: resultCallback)
    case "setGroupProjectId": setGroupProjectId(parameters: parameters, resultCallback: resultCallback)
    case "modifyGroupApplicationId": modifyGroupApplicationId(parameters: parameters, resultCallback: resultCallback)
    case "addTagToGroup": addTagToGroup(parameters: parameters, resultCallback: resultCallback)
    case "removeTagFromGroup": removeTagFromGroup(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func listGroups(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.listGroups(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func createGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.createGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	nameString: parameters["name"]!,
    	typeString: parameters["type"]!,
    	passwordString: parameters["password"]!,
    	serverString: parameters["server"]!,
    	qString: parameters["q"]!,
    	nString: parameters["n"]!,
    	superGroupString: parameters["superGroup"]!,
    	projectIdString: parameters["projectId"]!,
    	initialisationDataString: parameters["initialisationData"]!
    )
  }

  private static func registerNewGroupAdministrator(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.registerNewGroupAdministrator(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	roleString: parameters["role"]!,
    	registrationInformationString: parameters["registrationInformation"]!
    )
  }

  private static func listApps(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.listApps(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getNameOfGroupParent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getNameOfGroupParent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func modifyGroupName(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.modifyGroupName(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	nameString: parameters["name"]!
    )
  }

  private static func getOperationToken(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getOperationToken(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	operationString: parameters["operation"]!,
    	durationString: parameters["duration"]!,
    	descriptionString: parameters["description"]!
    )
  }

  private static func deleteOperationToken(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.deleteOperationToken(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	tokenIdString: parameters["tokenId"]!
    )
  }

  private static func setDefaultRoles(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.setDefaultRoles(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userTypeString: parameters["userType"]!,
    	roleIdsString: parameters["roleIds"]!
    )
  }

  private static func getDefaultRoles(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getDefaultRoles(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func deleteGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.deleteGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func changeSuperGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.changeSuperGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	childGroupIdString: parameters["childGroupId"]!,
    	operationTokenString: parameters["operationToken"]!
    )
  }

  private static func hardDeleteGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.hardDeleteGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func modifyGroupProperties(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.modifyGroupProperties(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	propertiesString: parameters["properties"]!
    )
  }

  private static func setGroupPassword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.setGroupPassword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	passwordString: parameters["password"]!
    )
  }

  private static func initDesignDocs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.doInitDesignDocs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	clazzString: parameters["clazz"]!,
    	warmupString: parameters["warmup"]!,
    	dryRunString: parameters["dryRun"]!
    )
  }

  private static func solveConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.solveConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	limitString: parameters["limit"]!,
    	warmupString: parameters["warmup"]!
    )
  }

  private static func resetStorage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.resetStorage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	qString: parameters["q"]!,
    	nString: parameters["n"]!,
    	databasesString: parameters["databases"]!
    )
  }

  private static func getGroupsStorageInfos(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getGroupsStorageInfos(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupsString: parameters["groups"]!
    )
  }

  private static func getReplicationInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getReplicationInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func getHierarchy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getHierarchy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func listAllGroupsIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.listAllGroupsIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func createOrUpdateExternalJwtConfig(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.createOrUpdateExternalJwtConfig(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	keyString: parameters["key"]!,
    	configString: parameters["config"]!
    )
  }

  private static func removeExternalJwtConfig(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.removeExternalJwtConfig(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	keyString: parameters["key"]!
    )
  }

  private static func getOperationTokenForGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.getOperationTokenForGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	operationString: parameters["operation"]!,
    	durationString: parameters["duration"]!,
    	descriptionString: parameters["description"]!
    )
  }

  private static func setGroupProjectId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.setGroupProjectId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	projectIdString: parameters["projectId"]!,
    	applyToSubgroupsString: parameters["applyToSubgroups"]!
    )
  }

  private static func modifyGroupApplicationId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.modifyGroupApplicationId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	applicationIdString: parameters["applicationId"]!
    )
  }

  private static func addTagToGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.addTagToGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!,
    	tagString: parameters["tag"]!
    )
  }

  private static func removeTagFromGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupApi.shared.removeTagFromGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!,
    	tagIdString: parameters["tagId"]!
    )
  }

}
