// auto-generated file
import CardinalDartSdkSupportLib

class CryptoApiDispatcher {

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
    case "getAccessControlKeys": getAccessControlKeys(parameters: parameters, resultCallback: resultCallback)
    case "forceReload": forceReload(parameters: parameters, resultCallback: resultCallback)
    case "currentDataOwnerKeys": currentDataOwnerKeys(parameters: parameters, resultCallback: resultCallback)
    case "keylessCreateExchangeDataTo": keylessCreateExchangeDataTo(parameters: parameters, resultCallback: resultCallback)
    case "injectExchangeData": injectExchangeData(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.keylessCreateExchangeDataTo": inGroup_keylessCreateExchangeDataTo(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getAccessControlKeys": inGroup_getAccessControlKeys(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getAccessControlKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.getAccessControlKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityTypeString: parameters["entityType"]!
    )
  }

  private static func forceReload(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.forceReload(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func currentDataOwnerKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.currentDataOwnerKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterTrustedKeysString: parameters["filterTrustedKeys"]!
    )
  }

  private static func keylessCreateExchangeDataTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.keylessCreateExchangeDataTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateString: parameters["delegate"]!
    )
  }

  private static func injectExchangeData(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.injectExchangeData(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	detailsString: parameters["details"]!,
    	reEncryptWithOwnKeysString: parameters["reEncryptWithOwnKeys"]!
    )
  }

  private static func inGroup_keylessCreateExchangeDataTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.inGroup.shared.keylessCreateExchangeDataTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	delegateString: parameters["delegate"]!
    )
  }

  private static func inGroup_getAccessControlKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.inGroup.shared.getAccessControlKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityTypeString: parameters["entityType"]!
    )
  }

}
