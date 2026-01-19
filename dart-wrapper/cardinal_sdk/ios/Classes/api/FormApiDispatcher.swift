// auto-generated file
import CardinalDartSdkSupportLib

class FormApiDispatcher {

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
    case "matchFormsBy": matchFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchFormsBySorted": matchFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormById": deleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormsByIds": deleteFormsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeFormById": purgeFormById(parameters: parameters, resultCallback: resultCallback)
    case "deleteForm": deleteForm(parameters: parameters, resultCallback: resultCallback)
    case "deleteForms": deleteForms(parameters: parameters, resultCallback: resultCallback)
    case "purgeForm": purgeForm(parameters: parameters, resultCallback: resultCallback)
    case "getFormTemplate": getFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "createFormTemplate": createFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormTemplate": deleteFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "updateFormTemplate": updateFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "setTemplateAttachment": setTemplateAttachment(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterFormsBy": filterFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterFormsBySorted": filterFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createForm": createForm(parameters: parameters, resultCallback: resultCallback)
    case "createForms": createForms(parameters: parameters, resultCallback: resultCallback)
    case "modifyForm": modifyForm(parameters: parameters, resultCallback: resultCallback)
    case "undeleteFormById": undeleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteForm": undeleteForm(parameters: parameters, resultCallback: resultCallback)
    case "modifyForms": modifyForms(parameters: parameters, resultCallback: resultCallback)
    case "getForm": getForm(parameters: parameters, resultCallback: resultCallback)
    case "getForms": getForms(parameters: parameters, resultCallback: resultCallback)
    case "getLatestFormByLogicalUuid": getLatestFormByLogicalUuid(parameters: parameters, resultCallback: resultCallback)
    case "getLatestFormByUniqueId": getLatestFormByUniqueId(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterFormsBy": encrypted_filterFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterFormsBySorted": encrypted_filterFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createForm": encrypted_createForm(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createForms": encrypted_createForms(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyForm": encrypted_modifyForm(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteFormById": encrypted_undeleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteForm": encrypted_undeleteForm(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyForms": encrypted_modifyForms(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getForm": encrypted_getForm(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getForms": encrypted_getForms(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getLatestFormByLogicalUuid": encrypted_getLatestFormByLogicalUuid(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getLatestFormByUniqueId": encrypted_getLatestFormByUniqueId(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterFormsBy": tryAndRecover_filterFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterFormsBySorted": tryAndRecover_filterFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createForm": tryAndRecover_createForm(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createForms": tryAndRecover_createForms(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyForm": tryAndRecover_modifyForm(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteFormById": tryAndRecover_undeleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteForm": tryAndRecover_undeleteForm(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyForms": tryAndRecover_modifyForms(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getForm": tryAndRecover_getForm(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getForms": tryAndRecover_getForms(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getLatestFormByLogicalUuid": tryAndRecover_getLatestFormByLogicalUuid(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getLatestFormByUniqueId": tryAndRecover_getLatestFormByUniqueId(parameters: parameters, resultCallback: resultCallback)
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
    FormApi.shared.withEncryptionMetadata(
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
    FormApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.createDelegationDeAnonymizationMetadata(
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
    FormApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func matchFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.matchFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.matchFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.deleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteFormsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.deleteFormsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.purgeFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.deleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func deleteForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.deleteForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formsString: parameters["forms"]!
    )
  }

  private static func purgeForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.purgeForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func getFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.getFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!,
    	rawString: parameters["raw"]!
    )
  }

  private static func createFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.createFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateString: parameters["formTemplate"]!
    )
  }

  private static func deleteFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.deleteFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!
    )
  }

  private static func updateFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.updateFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateString: parameters["formTemplate"]!
    )
  }

  private static func setTemplateAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.setTemplateAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!,
    	payloadString: parameters["payload"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	formString: parameters["form"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.filterFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.filterFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.createForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func createForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.createForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func modifyForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.modifyForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.undeleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.undeleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func modifyForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.modifyForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.getForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.getForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getLatestFormByLogicalUuid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.getLatestFormByLogicalUuid(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	logicalUuidString: parameters["logicalUuid"]!
    )
  }

  private static func getLatestFormByUniqueId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.shared.getLatestFormByUniqueId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	uniqueIdString: parameters["uniqueId"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	formString: parameters["form"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.filterFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.filterFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.createForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_createForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.createForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_modifyForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.modifyForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.undeleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.undeleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func encrypted_modifyForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.modifyForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_getForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.getForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.getForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_getLatestFormByLogicalUuid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.getLatestFormByLogicalUuid(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	logicalUuidString: parameters["logicalUuid"]!
    )
  }

  private static func encrypted_getLatestFormByUniqueId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.encrypted.shared.getLatestFormByUniqueId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	uniqueIdString: parameters["uniqueId"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	formString: parameters["form"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.filterFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.filterFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.createForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_createForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.createForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_modifyForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.modifyForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.undeleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.undeleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func tryAndRecover_modifyForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.modifyForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_getForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.getForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.getForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_getLatestFormByLogicalUuid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.getLatestFormByLogicalUuid(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	logicalUuidString: parameters["logicalUuid"]!
    )
  }

  private static func tryAndRecover_getLatestFormByUniqueId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormApi.tryAndRecover.shared.getLatestFormByUniqueId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	uniqueIdString: parameters["uniqueId"]!
    )
  }

}
