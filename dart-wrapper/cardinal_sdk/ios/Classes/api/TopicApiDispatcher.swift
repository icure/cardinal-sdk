// auto-generated file
import CardinalDartSdkSupportLib

class TopicApiDispatcher {

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
    case "matchTopicsBy": matchTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchTopicsBySorted": matchTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopicById": deleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopicsByIds": deleteTopicsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeTopicById": purgeTopicById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopic": deleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopics": deleteTopics(parameters: parameters, resultCallback: resultCallback)
    case "purgeTopic": purgeTopic(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterTopicsBy": filterTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterTopicsBySorted": filterTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createTopic": createTopic(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTopic": undeleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "modifyTopic": modifyTopic(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTopicById": undeleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "getTopic": getTopic(parameters: parameters, resultCallback: resultCallback)
    case "getTopics": getTopics(parameters: parameters, resultCallback: resultCallback)
    case "addParticipant": addParticipant(parameters: parameters, resultCallback: resultCallback)
    case "removeParticipant": removeParticipant(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterTopicsBy": encrypted_filterTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterTopicsBySorted": encrypted_filterTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createTopic": encrypted_createTopic(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteTopic": encrypted_undeleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyTopic": encrypted_modifyTopic(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteTopicById": encrypted_undeleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getTopic": encrypted_getTopic(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getTopics": encrypted_getTopics(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.addParticipant": encrypted_addParticipant(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.removeParticipant": encrypted_removeParticipant(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterTopicsBy": tryAndRecover_filterTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterTopicsBySorted": tryAndRecover_filterTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createTopic": tryAndRecover_createTopic(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteTopic": tryAndRecover_undeleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyTopic": tryAndRecover_modifyTopic(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteTopicById": tryAndRecover_undeleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getTopic": tryAndRecover_getTopic(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getTopics": tryAndRecover_getTopics(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.addParticipant": tryAndRecover_addParticipant(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.removeParticipant": tryAndRecover_removeParticipant(parameters: parameters, resultCallback: resultCallback)
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
    TopicApi.shared.withEncryptionMetadata(
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
    TopicApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.createDelegationDeAnonymizationMetadata(
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
    TopicApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func matchTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.matchTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.matchTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.deleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTopicsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.deleteTopicsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.purgeTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.deleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func deleteTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.deleteTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicsString: parameters["topics"]!
    )
  }

  private static func purgeTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.purgeTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	topicString: parameters["topic"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.filterTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.filterTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.createTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.undeleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func modifyTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.modifyTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.undeleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.getTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.getTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func addParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.addParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	topicRoleString: parameters["topicRole"]!
    )
  }

  private static func removeParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.removeParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.shared.subscribeToEvents(
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
    TopicApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	topicString: parameters["topic"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.filterTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.filterTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.createTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.undeleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func encrypted_modifyTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.modifyTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.undeleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_getTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.getTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.getTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_addParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.addParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	topicRoleString: parameters["topicRole"]!
    )
  }

  private static func encrypted_removeParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.encrypted.shared.removeParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	topicString: parameters["topic"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.filterTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.filterTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.createTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.undeleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func tryAndRecover_modifyTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.modifyTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.undeleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_getTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.getTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.getTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_addParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.addParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	topicRoleString: parameters["topicRole"]!
    )
  }

  private static func tryAndRecover_removeParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicApi.tryAndRecover.shared.removeParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

}
