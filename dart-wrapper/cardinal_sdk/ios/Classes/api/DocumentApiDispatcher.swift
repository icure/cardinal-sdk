// auto-generated file
import CardinalDartSdkSupportLib

class DocumentApiDispatcher {

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
    case "withEncryptionMetadataLinkedToMessage": withEncryptionMetadataLinkedToMessage(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadataLinkedToPatient": withEncryptionMetadataLinkedToPatient(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadataUnlinked": withEncryptionMetadataUnlinked(parameters: parameters, resultCallback: resultCallback)
    case "getAndTryDecryptMainAttachment": getAndTryDecryptMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getAndDecryptMainAttachment": getAndDecryptMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "encryptAndSetMainAttachment": encryptAndSetMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getAndDecryptSecondaryAttachment": getAndDecryptSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "encryptAndSetSecondaryAttachment": encryptAndSetSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptOwningEntityIdsOf": decryptOwningEntityIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecryptAttachment": tryDecryptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "matchDocumentsBy": matchDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchDocumentsBySorted": matchDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocumentById": deleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocumentsByIds": deleteDocumentsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeDocumentById": purgeDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocument": deleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocuments": deleteDocuments(parameters: parameters, resultCallback: resultCallback)
    case "purgeDocument": purgeDocument(parameters: parameters, resultCallback: resultCallback)
    case "getRawMainAttachment": getRawMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getRawSecondaryAttachment": getRawSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawMainAttachment": setRawMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawSecondaryAttachment": setRawSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "deleteMainAttachment": deleteMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "deleteSecondaryAttachment": deleteSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterDocumentsBy": filterDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterDocumentsBySorted": filterDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createDocument": createDocument(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDocumentById": undeleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDocument": undeleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "modifyDocument": modifyDocument(parameters: parameters, resultCallback: resultCallback)
    case "getDocument": getDocument(parameters: parameters, resultCallback: resultCallback)
    case "getDocuments": getDocuments(parameters: parameters, resultCallback: resultCallback)
    case "modifyDocuments": modifyDocuments(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterDocumentsBy": encrypted_filterDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterDocumentsBySorted": encrypted_filterDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createDocument": encrypted_createDocument(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteDocumentById": encrypted_undeleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteDocument": encrypted_undeleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyDocument": encrypted_modifyDocument(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getDocument": encrypted_getDocument(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getDocuments": encrypted_getDocuments(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyDocuments": encrypted_modifyDocuments(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterDocumentsBy": tryAndRecover_filterDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterDocumentsBySorted": tryAndRecover_filterDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createDocument": tryAndRecover_createDocument(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteDocumentById": tryAndRecover_undeleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteDocument": tryAndRecover_undeleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyDocument": tryAndRecover_modifyDocument(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getDocument": tryAndRecover_getDocument(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getDocuments": tryAndRecover_getDocuments(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyDocuments": tryAndRecover_modifyDocuments(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func withEncryptionMetadataLinkedToMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.withEncryptionMetadataLinkedToMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	messageString: parameters["message"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	secretIdString: parameters["secretId"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func withEncryptionMetadataLinkedToPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.withEncryptionMetadataLinkedToPatient(
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

  private static func withEncryptionMetadataUnlinked(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.withEncryptionMetadataUnlinked(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	alternateRootDelegateIdString: parameters["alternateRootDelegateId"]!
    )
  }

  private static func getAndTryDecryptMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getAndTryDecryptMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	decryptedAttachmentValidatorString: parameters["decryptedAttachmentValidator"]!
    )
  }

  private static func getAndDecryptMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getAndDecryptMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	decryptedAttachmentValidatorString: parameters["decryptedAttachmentValidator"]!
    )
  }

  private static func encryptAndSetMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.encryptAndSetMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!
    )
  }

  private static func getAndDecryptSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getAndDecryptSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	keyString: parameters["key"]!,
    	decryptedAttachmentValidatorString: parameters["decryptedAttachmentValidator"]!
    )
  }

  private static func encryptAndSetSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.encryptAndSetSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	keyString: parameters["key"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func decryptOwningEntityIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.decryptOwningEntityIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.createDelegationDeAnonymizationMetadata(
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
    DocumentApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func tryDecryptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.tryDecryptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	encryptedAttachmentString: parameters["encryptedAttachment"]!,
    	decryptedAttachmentValidatorString: parameters["decryptedAttachmentValidator"]!
    )
  }

  private static func matchDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.matchDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.matchDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDocumentsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteDocumentsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.purgeDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func deleteDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentsString: parameters["documents"]!
    )
  }

  private static func purgeDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.purgeDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func getRawMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getRawMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!
    )
  }

  private static func getRawSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getRawSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!
    )
  }

  private static func setRawMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.setRawMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	revString: parameters["rev"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!,
    	encryptedString: parameters["encrypted"]!
    )
  }

  private static func setRawSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.setRawSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!,
    	revString: parameters["rev"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!,
    	encryptedString: parameters["encrypted"]!
    )
  }

  private static func deleteMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.deleteSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	documentString: parameters["document"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.filterDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.filterDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.createDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.undeleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.undeleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func modifyDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.modifyDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.getDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func modifyDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.shared.modifyDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	documentString: parameters["document"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.filterDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.filterDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_createDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.createDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.undeleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.undeleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func encrypted_modifyDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.modifyDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.getDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.getDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func encrypted_modifyDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.encrypted.shared.modifyDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	documentString: parameters["document"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.filterDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.filterDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_createDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.createDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.undeleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.undeleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func tryAndRecover_modifyDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.modifyDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.getDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.getDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func tryAndRecover_modifyDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentApi.tryAndRecover.shared.modifyDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

}
