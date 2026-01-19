// auto-generated file
import CardinalDartSdkSupportLib

class CalendarItemApiDispatcher {

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
    case "matchCalendarItemsBy": matchCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchCalendarItemsBySorted": matchCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemById": deleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemsByIds": deleteCalendarItemsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItemById": purgeCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItem": deleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItems": deleteCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItem": purgeCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "linkToPatient": linkToPatient(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBy": filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBySorted": filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createCalendarItem": createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "bookCalendarItemCheckingAvailability": bookCalendarItemCheckingAvailability(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItemById": undeleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItem": undeleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "modifyCalendarItem": modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItem": getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItems": getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.linkToPatient": encrypted_linkToPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterCalendarItemsBy": encrypted_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterCalendarItemsBySorted": encrypted_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createCalendarItem": encrypted_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.bookCalendarItemCheckingAvailability": encrypted_bookCalendarItemCheckingAvailability(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteCalendarItemById": encrypted_undeleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteCalendarItem": encrypted_undeleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyCalendarItem": encrypted_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getCalendarItem": encrypted_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getCalendarItems": encrypted_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.linkToPatient": tryAndRecover_linkToPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterCalendarItemsBy": tryAndRecover_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterCalendarItemsBySorted": tryAndRecover_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createCalendarItem": tryAndRecover_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.bookCalendarItemCheckingAvailability": tryAndRecover_bookCalendarItemCheckingAvailability(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteCalendarItemById": tryAndRecover_undeleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteCalendarItem": tryAndRecover_undeleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyCalendarItem": tryAndRecover_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getCalendarItem": tryAndRecover_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getCalendarItems": tryAndRecover_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.withEncryptionMetadata": inGroup_withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getEncryptionKeysOf": inGroup_getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.hasWriteAccess": inGroup_hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.decryptPatientIdOf": inGroup_decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createDelegationDeAnonymizationMetadata": inGroup_createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.decrypt": inGroup_decrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryDecrypt": inGroup_tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encryptOrValidate": inGroup_encryptOrValidate(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchCalendarItemsBy": inGroup_matchCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchCalendarItemsBySorted": inGroup_matchCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItemById": inGroup_deleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItemsByIds": inGroup_deleteCalendarItemsByIds(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItem": inGroup_deleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteCalendarItems": inGroup_deleteCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWith": inGroup_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.shareWithMany": inGroup_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterCalendarItemsBy": inGroup_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterCalendarItemsBySorted": inGroup_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createCalendarItem": inGroup_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyCalendarItem": inGroup_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getCalendarItem": inGroup_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getCalendarItems": inGroup_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWith": inGroup_encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.shareWithMany": inGroup_encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.filterCalendarItemsBy": inGroup_encrypted_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.filterCalendarItemsBySorted": inGroup_encrypted_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.createCalendarItem": inGroup_encrypted_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.modifyCalendarItem": inGroup_encrypted_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getCalendarItem": inGroup_encrypted_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.encrypted.getCalendarItems": inGroup_encrypted_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWith": inGroup_tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.shareWithMany": inGroup_tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.filterCalendarItemsBy": inGroup_tryAndRecover_filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.filterCalendarItemsBySorted": inGroup_tryAndRecover_filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.createCalendarItem": inGroup_tryAndRecover_createCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.modifyCalendarItem": inGroup_tryAndRecover_modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getCalendarItem": inGroup_tryAndRecover_getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.tryAndRecover.getCalendarItems": inGroup_tryAndRecover_getCalendarItems(parameters: parameters, resultCallback: resultCallback)
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
    CalendarItemApi.shared.withEncryptionMetadata(
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
    CalendarItemApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.createDelegationDeAnonymizationMetadata(
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
    CalendarItemApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func matchCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.matchCalendarItemsBy(
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
    CalendarItemApi.shared.matchCalendarItemsBySorted(
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
    CalendarItemApi.shared.deleteCalendarItemById(
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
    CalendarItemApi.shared.deleteCalendarItemsByIds(
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
    CalendarItemApi.shared.purgeCalendarItemById(
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
    CalendarItemApi.shared.deleteCalendarItem(
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
    CalendarItemApi.shared.deleteCalendarItems(
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
    CalendarItemApi.shared.purgeCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func linkToPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.linkToPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	patientString: parameters["patient"]!,
    	shareLinkWithDelegatesString: parameters["shareLinkWithDelegates"]!
    )
  }

  private static func filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.filterCalendarItemsBy(
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
    CalendarItemApi.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.shared.createCalendarItem(
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
    CalendarItemApi.shared.bookCalendarItemCheckingAvailability(
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
    CalendarItemApi.shared.undeleteCalendarItemById(
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
    CalendarItemApi.shared.undeleteCalendarItem(
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
    CalendarItemApi.shared.modifyCalendarItem(
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
    CalendarItemApi.shared.getCalendarItem(
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
    CalendarItemApi.shared.getCalendarItems(
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
    CalendarItemApi.shared.subscribeToEvents(
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
    CalendarItemApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_linkToPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.linkToPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	patientString: parameters["patient"]!,
    	shareLinkWithDelegatesString: parameters["shareLinkWithDelegates"]!
    )
  }

  private static func encrypted_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_bookCalendarItemCheckingAvailability(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.bookCalendarItemCheckingAvailability(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.undeleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.undeleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func encrypted_modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.encrypted.shared.getCalendarItems(
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
    CalendarItemApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_linkToPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.linkToPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	patientString: parameters["patient"]!,
    	shareLinkWithDelegatesString: parameters["shareLinkWithDelegates"]!
    )
  }

  private static func tryAndRecover_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_bookCalendarItemCheckingAvailability(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.bookCalendarItemCheckingAvailability(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.undeleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.undeleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func tryAndRecover_modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.tryAndRecover.shared.getCalendarItems(
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
    CalendarItemApi.inGroup.shared.withEncryptionMetadata(
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
    CalendarItemApi.inGroup.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func inGroup_hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func inGroup_decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func inGroup_createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.createDelegationDeAnonymizationMetadata(
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
    CalendarItemApi.inGroup.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func inGroup_tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func inGroup_encryptOrValidate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.encryptOrValidate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func inGroup_matchCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.matchCalendarItemsBy(
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
    CalendarItemApi.inGroup.shared.matchCalendarItemsBySorted(
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
    CalendarItemApi.inGroup.shared.deleteCalendarItemById(
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
    CalendarItemApi.inGroup.shared.deleteCalendarItemsByIds(
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
    CalendarItemApi.inGroup.shared.deleteCalendarItem(
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
    CalendarItemApi.inGroup.shared.deleteCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func inGroup_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.filterCalendarItemsBy(
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
    CalendarItemApi.inGroup.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroup.shared.createCalendarItem(
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
    CalendarItemApi.inGroup.shared.modifyCalendarItem(
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
    CalendarItemApi.inGroup.shared.getCalendarItem(
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
    CalendarItemApi.inGroup.shared.getCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_encrypted_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_encrypted_filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_encrypted_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_encrypted_modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_encrypted_getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_encrypted_getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupEncrypted.shared.getCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func inGroup_tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func inGroup_tryAndRecover_filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_tryAndRecover_filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_tryAndRecover_createCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.createCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_tryAndRecover_modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_tryAndRecover_getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_tryAndRecover_getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemApi.inGroupTryAndRecover.shared.getCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
