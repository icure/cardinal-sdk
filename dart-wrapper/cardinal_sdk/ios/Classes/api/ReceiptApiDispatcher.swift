// auto-generated file
import CardinalDartSdkSupportLib

class ReceiptApiDispatcher {

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
    case "getAndDecryptReceiptAttachment": getAndDecryptReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "encryptAndSetReceiptAttachment": encryptAndSetReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptPatientIdOf": decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "logReceipt": logReceipt(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "deleteReceipt": deleteReceipt(parameters: parameters, resultCallback: resultCallback)
    case "deleteReceipts": deleteReceipts(parameters: parameters, resultCallback: resultCallback)
    case "getRawReceiptAttachment": getRawReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawReceiptAttachment": setRawReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "createReceipt": createReceipt(parameters: parameters, resultCallback: resultCallback)
    case "modifyReceipt": modifyReceipt(parameters: parameters, resultCallback: resultCallback)
    case "getReceipt": getReceipt(parameters: parameters, resultCallback: resultCallback)
    case "listByReference": listByReference(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.createReceipt": encrypted_createReceipt(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyReceipt": encrypted_modifyReceipt(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getReceipt": encrypted_getReceipt(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.listByReference": encrypted_listByReference(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.createReceipt": tryAndRecover_createReceipt(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyReceipt": tryAndRecover_modifyReceipt(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getReceipt": tryAndRecover_getReceipt(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.listByReference": tryAndRecover_listByReference(parameters: parameters, resultCallback: resultCallback)
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
    ReceiptApi.shared.withEncryptionMetadata(
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

  private static func getAndDecryptReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.getAndDecryptReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

  private static func encryptAndSetReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.encryptAndSetReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!,
    	blobTypeString: parameters["blobType"]!,
    	attachmentString: parameters["attachment"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func logReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.logReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!,
    	docIdString: parameters["docId"]!,
    	refsString: parameters["refs"]!,
    	blobTypeString: parameters["blobType"]!,
    	blobString: parameters["blob"]!
    )
  }

  private static func decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!
    )
  }

  private static func deleteReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.deleteReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func deleteReceipts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.deleteReceipts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getRawReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.getRawReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptIdString: parameters["receiptId"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

  private static func setRawReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.setRawReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptIdString: parameters["receiptId"]!,
    	revString: parameters["rev"]!,
    	blobTypeString: parameters["blobType"]!,
    	attachmentString: parameters["attachment"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	receiptString: parameters["receipt"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func createReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.createReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.modifyReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.getReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func listByReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.shared.listByReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	referenceString: parameters["reference"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	receiptString: parameters["receipt"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_createReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.createReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_modifyReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.modifyReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_getReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.getReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_listByReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.encrypted.shared.listByReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	referenceString: parameters["reference"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	receiptString: parameters["receipt"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptString: parameters["receipt"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_createReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.createReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_modifyReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.modifyReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_getReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.getReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_listByReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptApi.tryAndRecover.shared.listByReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	referenceString: parameters["reference"]!
    )
  }

}
