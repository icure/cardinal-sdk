// auto-generated file
import CardinalDartSdkSupportLib

class ContactApiDispatcher {

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
    case "matchContactsBy": matchContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchServicesBy": matchServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchContactsBySorted": matchContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchServicesBySorted": matchServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptPatientIdOf": decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "decryptService": decryptService(parameters: parameters, resultCallback: resultCallback)
    case "tryDecryptService": tryDecryptService(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToServiceCreateOrUpdateEvents": subscribeToServiceCreateOrUpdateEvents(parameters: parameters, resultCallback: resultCallback)
    case "deleteContactById": deleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "deleteContactsByIds": deleteContactsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeContactById": purgeContactById(parameters: parameters, resultCallback: resultCallback)
    case "deleteContact": deleteContact(parameters: parameters, resultCallback: resultCallback)
    case "deleteContacts": deleteContacts(parameters: parameters, resultCallback: resultCallback)
    case "purgeContact": purgeContact(parameters: parameters, resultCallback: resultCallback)
    case "getServiceCodesOccurrences": getServiceCodesOccurrences(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterContactsBy": filterContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterServicesBy": filterServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterContactsBySorted": filterContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterServicesBySorted": filterServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createContact": createContact(parameters: parameters, resultCallback: resultCallback)
    case "createContacts": createContacts(parameters: parameters, resultCallback: resultCallback)
    case "undeleteContactById": undeleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteContact": undeleteContact(parameters: parameters, resultCallback: resultCallback)
    case "modifyContact": modifyContact(parameters: parameters, resultCallback: resultCallback)
    case "modifyContacts": modifyContacts(parameters: parameters, resultCallback: resultCallback)
    case "getContact": getContact(parameters: parameters, resultCallback: resultCallback)
    case "getContacts": getContacts(parameters: parameters, resultCallback: resultCallback)
    case "getService": getService(parameters: parameters, resultCallback: resultCallback)
    case "getServices": getServices(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterContactsBy": encrypted_filterContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterServicesBy": encrypted_filterServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterContactsBySorted": encrypted_filterContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterServicesBySorted": encrypted_filterServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createContact": encrypted_createContact(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createContacts": encrypted_createContacts(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteContactById": encrypted_undeleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteContact": encrypted_undeleteContact(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyContact": encrypted_modifyContact(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyContacts": encrypted_modifyContacts(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getContact": encrypted_getContact(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getContacts": encrypted_getContacts(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getService": encrypted_getService(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getServices": encrypted_getServices(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterContactsBy": tryAndRecover_filterContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterServicesBy": tryAndRecover_filterServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterContactsBySorted": tryAndRecover_filterContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterServicesBySorted": tryAndRecover_filterServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createContact": tryAndRecover_createContact(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createContacts": tryAndRecover_createContacts(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteContactById": tryAndRecover_undeleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteContact": tryAndRecover_undeleteContact(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyContact": tryAndRecover_modifyContact(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyContacts": tryAndRecover_modifyContacts(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getContact": tryAndRecover_getContact(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getContacts": tryAndRecover_getContacts(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getService": tryAndRecover_getService(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getServices": tryAndRecover_getServices(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.matchContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.matchServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.matchContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.matchServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.withEncryptionMetadata(
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
    ContactApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.createDelegationDeAnonymizationMetadata(
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
    ContactApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func decryptService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.decryptService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceString: parameters["service"]!
    )
  }

  private static func tryDecryptService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.tryDecryptService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceString: parameters["service"]!
    )
  }

  private static func subscribeToServiceCreateOrUpdateEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.subscribeToServiceCreateOrUpdateEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func deleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.deleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteContactsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.deleteContactsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.purgeContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.deleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func deleteContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.deleteContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactsString: parameters["contacts"]!
    )
  }

  private static func purgeContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.purgeContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func getServiceCodesOccurrences(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.getServiceCodesOccurrences(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeTypeString: parameters["codeType"]!,
    	minOccurrencesString: parameters["minOccurrences"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	contactString: parameters["contact"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.filterContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.filterServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.filterContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.filterServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.createContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func createContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.createContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func undeleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.undeleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.undeleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func modifyContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.modifyContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.modifyContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.getContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.getContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.getService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceIdString: parameters["serviceId"]!
    )
  }

  private static func getServices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.shared.getServices(
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
    ContactApi.shared.subscribeToEvents(
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
    ContactApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	contactString: parameters["contact"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.filterContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.filterServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.filterContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.filterServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.createContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_createContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.createContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_undeleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.undeleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.undeleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func encrypted_modifyContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.modifyContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_modifyContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.modifyContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_getContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.getContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.getContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_getService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.getService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceIdString: parameters["serviceId"]!
    )
  }

  private static func encrypted_getServices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.encrypted.shared.getServices(
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
    ContactApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	contactString: parameters["contact"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.filterContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.filterServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.filterContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.filterServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.createContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_createContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.createContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_undeleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.undeleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.undeleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func tryAndRecover_modifyContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.modifyContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_modifyContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.modifyContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_getContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.getContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.getContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_getService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.getService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceIdString: parameters["serviceId"]!
    )
  }

  private static func tryAndRecover_getServices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactApi.tryAndRecover.shared.getServices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
