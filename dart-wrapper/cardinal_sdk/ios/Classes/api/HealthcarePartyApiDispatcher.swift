// auto-generated file
import CardinalDartSdkSupportLib

class HealthcarePartyApiDispatcher {

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
    case "getHealthcareParty": getHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "createHealthcareParty": createHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthcarePartyInGroup": modifyHealthcarePartyInGroup(parameters: parameters, resultCallback: resultCallback)
    case "createHealthcarePartyInGroup": createHealthcarePartyInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentHealthcareParty": getCurrentHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "listHealthcarePartiesByName": listHealthcarePartiesByName(parameters: parameters, resultCallback: resultCallback)
    case "getHealthcareParties": getHealthcareParties(parameters: parameters, resultCallback: resultCallback)
    case "listHealthcarePartiesByParentId": listHealthcarePartiesByParentId(parameters: parameters, resultCallback: resultCallback)
    case "getPublicKey": getPublicKey(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthcareParty": modifyHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "matchHealthcarePartiesBy": matchHealthcarePartiesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthPartiesBy": filterHealthPartiesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchHealthcarePartiesBySorted": matchHealthcarePartiesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthPartiesBySorted": filterHealthPartiesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "getHealthcarePartiesInGroup": getHealthcarePartiesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "registerPatient": registerPatient(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartyById": deleteHealthcarePartyById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartiesByIds": deleteHealthcarePartiesByIds(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartyInGroupById": deleteHealthcarePartyInGroupById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartiesInGroupByIds": deleteHealthcarePartiesInGroupByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthcarePartyById": purgeHealthcarePartyById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthcarePartyById": undeleteHealthcarePartyById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcareParty": deleteHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcareParties": deleteHealthcareParties(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthcareParty": purgeHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthcareParty": undeleteHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartyInGroup": deleteHealthcarePartyInGroup(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthcarePartiesInGroup": deleteHealthcarePartiesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchHealthcarePartiesBy": inGroup_matchHealthcarePartiesBy(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.getHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyIdString: parameters["healthcarePartyId"]!
    )
  }

  private static func createHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.createHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	pString: parameters["p"]!
    )
  }

  private static func modifyHealthcarePartyInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.modifyHealthcarePartyInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func createHealthcarePartyInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.createHealthcarePartyInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func getCurrentHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.getCurrentHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func listHealthcarePartiesByName(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.listHealthcarePartiesByName(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	nameString: parameters["name"]!
    )
  }

  private static func getHealthcareParties(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.getHealthcareParties(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyIdsString: parameters["healthcarePartyIds"]!
    )
  }

  private static func listHealthcarePartiesByParentId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.listHealthcarePartiesByParentId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	parentIdString: parameters["parentId"]!
    )
  }

  private static func getPublicKey(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.getPublicKey(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyIdString: parameters["healthcarePartyId"]!
    )
  }

  private static func modifyHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.modifyHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func matchHealthcarePartiesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.matchHealthcarePartiesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterHealthPartiesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.filterHealthPartiesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchHealthcarePartiesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.matchHealthcarePartiesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterHealthPartiesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.filterHealthPartiesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func getHealthcarePartiesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.getHealthcarePartiesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	healthcarePartyIdsString: parameters["healthcarePartyIds"]!
    )
  }

  private static func registerPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.registerPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	parentHcPartyIdString: parameters["parentHcPartyId"]!,
    	tokenString: parameters["token"]!,
    	useShortTokenString: parameters["useShortToken"]!,
    	hcpString: parameters["hcp"]!
    )
  }

  private static func deleteHealthcarePartyById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartyById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthcarePartiesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartiesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func deleteHealthcarePartyInGroupById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartyInGroupById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthcarePartiesInGroupByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartiesInGroupByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeHealthcarePartyById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.purgeHealthcarePartyById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteHealthcarePartyById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.undeleteHealthcarePartyById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func deleteHealthcareParties(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcareParties(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartiesString: parameters["healthcareParties"]!
    )
  }

  private static func purgeHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.purgeHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func undeleteHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.undeleteHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyString: parameters["healthcareParty"]!
    )
  }

  private static func deleteHealthcarePartyInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartyInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	hcpString: parameters["hcp"]!
    )
  }

  private static func deleteHealthcarePartiesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.deleteHealthcarePartiesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	healthcarePartiesString: parameters["healthcareParties"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func inGroup_matchHealthcarePartiesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyApi.inGroup.shared.matchHealthcarePartiesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

}
