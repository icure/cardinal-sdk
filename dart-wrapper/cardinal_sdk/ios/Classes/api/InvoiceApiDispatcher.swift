// auto-generated file
import CardinalDartSdkSupportLib

class InvoiceApiDispatcher {

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
    case "createInvoice": createInvoice(parameters: parameters, resultCallback: resultCallback)
    case "createInvoices": createInvoices(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptPatientIdOf": decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "deleteInvoice": deleteInvoice(parameters: parameters, resultCallback: resultCallback)
    case "getTarificationsCodesOccurrences": getTarificationsCodesOccurrences(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "modifyInvoice": modifyInvoice(parameters: parameters, resultCallback: resultCallback)
    case "modifyInvoices": modifyInvoices(parameters: parameters, resultCallback: resultCallback)
    case "getInvoice": getInvoice(parameters: parameters, resultCallback: resultCallback)
    case "getInvoices": getInvoices(parameters: parameters, resultCallback: resultCallback)
    case "reassignInvoice": reassignInvoice(parameters: parameters, resultCallback: resultCallback)
    case "mergeTo": mergeTo(parameters: parameters, resultCallback: resultCallback)
    case "validate": validate(parameters: parameters, resultCallback: resultCallback)
    case "appendCodes": appendCodes(parameters: parameters, resultCallback: resultCallback)
    case "removeCodes": removeCodes(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcPartyAndGroupId": listInvoicesByHcPartyAndGroupId(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate": listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByContactIds": listInvoicesByContactIds(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByRecipientsIds": listInvoicesByRecipientsIds(parameters: parameters, resultCallback: resultCallback)
    case "listToInsurances": listToInsurances(parameters: parameters, resultCallback: resultCallback)
    case "listToInsurancesUnsent": listToInsurancesUnsent(parameters: parameters, resultCallback: resultCallback)
    case "listToPatients": listToPatients(parameters: parameters, resultCallback: resultCallback)
    case "listToPatientsUnsent": listToPatientsUnsent(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByIds": listInvoicesByIds(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcpartySendingModeStatusDate": listInvoicesByHcpartySendingModeStatusDate(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyInvoice": encrypted_modifyInvoice(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyInvoices": encrypted_modifyInvoices(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getInvoice": encrypted_getInvoice(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getInvoices": encrypted_getInvoices(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.reassignInvoice": encrypted_reassignInvoice(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.mergeTo": encrypted_mergeTo(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.validate": encrypted_validate(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.appendCodes": encrypted_appendCodes(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.removeCodes": encrypted_removeCodes(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByHcPartyAndGroupId": encrypted_listInvoicesByHcPartyAndGroupId(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate": encrypted_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByContactIds": encrypted_listInvoicesByContactIds(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByRecipientsIds": encrypted_listInvoicesByRecipientsIds(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listToInsurances": encrypted_listToInsurances(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listToInsurancesUnsent": encrypted_listToInsurancesUnsent(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listToPatients": encrypted_listToPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listToPatientsUnsent": encrypted_listToPatientsUnsent(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByIds": encrypted_listInvoicesByIds(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listInvoicesByHcpartySendingModeStatusDate": encrypted_listInvoicesByHcpartySendingModeStatusDate(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyInvoice": tryAndRecover_modifyInvoice(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyInvoices": tryAndRecover_modifyInvoices(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getInvoice": tryAndRecover_getInvoice(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getInvoices": tryAndRecover_getInvoices(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.reassignInvoice": tryAndRecover_reassignInvoice(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.mergeTo": tryAndRecover_mergeTo(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.validate": tryAndRecover_validate(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.appendCodes": tryAndRecover_appendCodes(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.removeCodes": tryAndRecover_removeCodes(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByHcPartyAndGroupId": tryAndRecover_listInvoicesByHcPartyAndGroupId(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate": tryAndRecover_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByContactIds": tryAndRecover_listInvoicesByContactIds(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByRecipientsIds": tryAndRecover_listInvoicesByRecipientsIds(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listToInsurances": tryAndRecover_listToInsurances(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listToInsurancesUnsent": tryAndRecover_listToInsurancesUnsent(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listToPatients": tryAndRecover_listToPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listToPatientsUnsent": tryAndRecover_listToPatientsUnsent(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByIds": tryAndRecover_listInvoicesByIds(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listInvoicesByHcpartySendingModeStatusDate": tryAndRecover_listInvoicesByHcpartySendingModeStatusDate(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.createInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	prefixString: parameters["prefix"]!
    )
  }

  private static func createInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.createInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.withEncryptionMetadata(
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
    InvoiceApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.createDelegationDeAnonymizationMetadata(
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
    InvoiceApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func deleteInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.deleteInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTarificationsCodesOccurrences(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.getTarificationsCodesOccurrences(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	minOccurrenceString: parameters["minOccurrence"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	invoiceString: parameters["invoice"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func modifyInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.modifyInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.modifyInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.getInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.getInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func reassignInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.reassignInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func mergeTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.mergeTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func validate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.validate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	schemeString: parameters["scheme"]!,
    	forcedValueString: parameters["forcedValue"]!
    )
  }

  private static func appendCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.appendCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	insuranceIdString: parameters["insuranceId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	gracePeriodString: parameters["gracePeriod"]!,
    	invoicingCodesString: parameters["invoicingCodes"]!
    )
  }

  private static func removeCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.removeCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	serviceIdString: parameters["serviceId"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	tarificationIdsString: parameters["tarificationIds"]!
    )
  }

  private static func listInvoicesByHcPartyAndGroupId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByHcPartyAndGroupId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	invoiceTypeString: parameters["invoiceType"]!,
    	sentString: parameters["sent"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func listInvoicesByContactIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByContactIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactIdsString: parameters["contactIds"]!
    )
  }

  private static func listInvoicesByRecipientsIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByRecipientsIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recipientsIdsString: parameters["recipientsIds"]!
    )
  }

  private static func listToInsurances(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listToInsurances(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func listToInsurancesUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listToInsurancesUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func listToPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listToPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func listToPatientsUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listToPatientsUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func listInvoicesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func listInvoicesByHcpartySendingModeStatusDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.shared.listInvoicesByHcpartySendingModeStatusDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sendingModeString: parameters["sendingMode"]!,
    	statusString: parameters["status"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	invoiceString: parameters["invoice"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_modifyInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.modifyInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_modifyInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.modifyInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_getInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.getInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.getInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_reassignInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.reassignInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func encrypted_mergeTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.mergeTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func encrypted_validate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.validate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	schemeString: parameters["scheme"]!,
    	forcedValueString: parameters["forcedValue"]!
    )
  }

  private static func encrypted_appendCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.appendCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	insuranceIdString: parameters["insuranceId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	gracePeriodString: parameters["gracePeriod"]!,
    	invoicingCodesString: parameters["invoicingCodes"]!
    )
  }

  private static func encrypted_removeCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.removeCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	serviceIdString: parameters["serviceId"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	tarificationIdsString: parameters["tarificationIds"]!
    )
  }

  private static func encrypted_listInvoicesByHcPartyAndGroupId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByHcPartyAndGroupId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func encrypted_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	invoiceTypeString: parameters["invoiceType"]!,
    	sentString: parameters["sent"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func encrypted_listInvoicesByContactIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByContactIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactIdsString: parameters["contactIds"]!
    )
  }

  private static func encrypted_listInvoicesByRecipientsIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByRecipientsIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recipientsIdsString: parameters["recipientsIds"]!
    )
  }

  private static func encrypted_listToInsurances(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listToInsurances(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func encrypted_listToInsurancesUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listToInsurancesUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func encrypted_listToPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listToPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func encrypted_listToPatientsUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listToPatientsUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func encrypted_listInvoicesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func encrypted_listInvoicesByHcpartySendingModeStatusDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.encrypted.shared.listInvoicesByHcpartySendingModeStatusDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sendingModeString: parameters["sendingMode"]!,
    	statusString: parameters["status"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	invoiceString: parameters["invoice"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_modifyInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.modifyInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_modifyInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.modifyInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_getInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.getInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.getInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_reassignInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.reassignInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func tryAndRecover_mergeTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.mergeTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func tryAndRecover_validate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.validate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	schemeString: parameters["scheme"]!,
    	forcedValueString: parameters["forcedValue"]!
    )
  }

  private static func tryAndRecover_appendCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.appendCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	insuranceIdString: parameters["insuranceId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	gracePeriodString: parameters["gracePeriod"]!,
    	invoicingCodesString: parameters["invoicingCodes"]!
    )
  }

  private static func tryAndRecover_removeCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.removeCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	serviceIdString: parameters["serviceId"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	tarificationIdsString: parameters["tarificationIds"]!
    )
  }

  private static func tryAndRecover_listInvoicesByHcPartyAndGroupId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByHcPartyAndGroupId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func tryAndRecover_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	invoiceTypeString: parameters["invoiceType"]!,
    	sentString: parameters["sent"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func tryAndRecover_listInvoicesByContactIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByContactIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactIdsString: parameters["contactIds"]!
    )
  }

  private static func tryAndRecover_listInvoicesByRecipientsIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByRecipientsIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recipientsIdsString: parameters["recipientsIds"]!
    )
  }

  private static func tryAndRecover_listToInsurances(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listToInsurances(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func tryAndRecover_listToInsurancesUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listToInsurancesUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func tryAndRecover_listToPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listToPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func tryAndRecover_listToPatientsUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listToPatientsUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func tryAndRecover_listInvoicesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func tryAndRecover_listInvoicesByHcpartySendingModeStatusDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceApi.tryAndRecover.shared.listInvoicesByHcpartySendingModeStatusDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sendingModeString: parameters["sendingMode"]!,
    	statusString: parameters["status"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

}
