// auto-generated file
import CardinalDartSdkSupportLib

class MessageApiDispatcher {

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
    case "getSecretIdsOf": getSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "matchMessagesBy": matchMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchMessagesBySorted": matchMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessageById": deleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessagesByIds": deleteMessagesByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeMessageById": purgeMessageById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessage": deleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessages": deleteMessages(parameters: parameters, resultCallback: resultCallback)
    case "purgeMessage": purgeMessage(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterMessagesBy": filterMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterMessagesBySorted": filterMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createMessage": createMessage(parameters: parameters, resultCallback: resultCallback)
    case "createMessageInTopic": createMessageInTopic(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMessage": undeleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "modifyMessage": modifyMessage(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMessageById": undeleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "getMessage": getMessage(parameters: parameters, resultCallback: resultCallback)
    case "getMessages": getMessages(parameters: parameters, resultCallback: resultCallback)
    case "setMessagesReadStatus": setMessagesReadStatus(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterMessagesBy": encrypted_filterMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterMessagesBySorted": encrypted_filterMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createMessage": encrypted_createMessage(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createMessageInTopic": encrypted_createMessageInTopic(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteMessage": encrypted_undeleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyMessage": encrypted_modifyMessage(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteMessageById": encrypted_undeleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getMessage": encrypted_getMessage(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getMessages": encrypted_getMessages(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.setMessagesReadStatus": encrypted_setMessagesReadStatus(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterMessagesBy": tryAndRecover_filterMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterMessagesBySorted": tryAndRecover_filterMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createMessage": tryAndRecover_createMessage(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createMessageInTopic": tryAndRecover_createMessageInTopic(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteMessage": tryAndRecover_undeleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyMessage": tryAndRecover_modifyMessage(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteMessageById": tryAndRecover_undeleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getMessage": tryAndRecover_getMessage(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getMessages": tryAndRecover_getMessages(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.setMessagesReadStatus": tryAndRecover_setMessagesReadStatus(parameters: parameters, resultCallback: resultCallback)
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
    MessageApi.shared.withEncryptionMetadata(
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
    MessageApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.createDelegationDeAnonymizationMetadata(
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
    MessageApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func getSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.getSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func matchMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.matchMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.matchMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.deleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMessagesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.deleteMessagesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.purgeMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.deleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func deleteMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.deleteMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messagesString: parameters["messages"]!
    )
  }

  private static func purgeMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.purgeMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	messageString: parameters["message"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.filterMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.filterMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.createMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func createMessageInTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.createMessageInTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.undeleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func modifyMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.modifyMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.undeleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.getMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.getMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func setMessagesReadStatus(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.setMessagesReadStatus(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!,
    	timeString: parameters["time"]!,
    	readStatusString: parameters["readStatus"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.shared.subscribeToEvents(
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
    MessageApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	messageString: parameters["message"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.filterMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.filterMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.createMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_createMessageInTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.createMessageInTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.undeleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func encrypted_modifyMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.modifyMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.undeleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_getMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.getMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.getMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_setMessagesReadStatus(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.encrypted.shared.setMessagesReadStatus(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!,
    	timeString: parameters["time"]!,
    	readStatusString: parameters["readStatus"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	messageString: parameters["message"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.filterMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.filterMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.createMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_createMessageInTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.createMessageInTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.undeleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func tryAndRecover_modifyMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.modifyMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.undeleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_getMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.getMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.getMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_setMessagesReadStatus(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageApi.tryAndRecover.shared.setMessagesReadStatus(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!,
    	timeString: parameters["time"]!,
    	readStatusString: parameters["readStatus"]!,
    	userIdString: parameters["userId"]!
    )
  }

}
