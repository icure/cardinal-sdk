// auto-generated file
import CardinalDartSdkSupportLib

class CalendarItemBasicApiDispatcher {

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
    case "matchCalendarItemsBy": matchCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchCalendarItemsBySorted": matchCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBy": filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBySorted": filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemById": deleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemsByIds": deleteCalendarItemsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItemById": purgeCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItem": deleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItems": deleteCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItem": purgeCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "createCalendarItem": createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "bookCalendarItemCheckingAvailability": bookCalendarItemCheckingAvailability(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItemById": undeleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItem": undeleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "modifyCalendarItem": modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItem": getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItems": getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchCalendarItemsBy": inGroup_matchCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchCalendarItemsBySorted": inGroup_matchCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterCalendarItemsBy": inGroup_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterCalendarItemsBySorted": inGroup_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItemById": inGroup_deleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItemsByIds": inGroup_deleteCalendarItemsByIds(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItem": inGroup_deleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItems": inGroup_deleteCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createCalendarItem": inGroup_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyCalendarItem": inGroup_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getCalendarItem": inGroup_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getCalendarItems": inGroup_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.matchCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.matchCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteCalendarItemsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItemsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.purgeCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func deleteCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func purgeCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.purgeCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func bookCalendarItemCheckingAvailability(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.bookCalendarItemCheckingAvailability(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.undeleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.undeleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.getCalendarItems(
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
    CalendarItemBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func inGroup_matchCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.matchCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_matchCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.matchCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_deleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.deleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_deleteCalendarItemsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.deleteCalendarItemsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_deleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.deleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func inGroup_deleteCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.deleteCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func inGroup_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.inGroup.shared.getCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
