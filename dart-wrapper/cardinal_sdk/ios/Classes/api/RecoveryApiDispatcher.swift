// auto-generated file
import CardinalDartSdkSupportLib

class RecoveryApiDispatcher {

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
    case "createRecoveryInfoForAvailableKeyPairs": createRecoveryInfoForAvailableKeyPairs(parameters: parameters, resultCallback: resultCallback)
    case "recoverKeyPairs": recoverKeyPairs(parameters: parameters, resultCallback: resultCallback)
    case "recoverKeyPairsWaitingForCreation": recoverKeyPairsWaitingForCreation(parameters: parameters, resultCallback: resultCallback)
    case "createExchangeDataRecoveryInfo": createExchangeDataRecoveryInfo(parameters: parameters, resultCallback: resultCallback)
    case "recoverExchangeData": recoverExchangeData(parameters: parameters, resultCallback: resultCallback)
    case "getRecoveryExchangeData": getRecoveryExchangeData(parameters: parameters, resultCallback: resultCallback)
    case "purgeRecoveryInfo": purgeRecoveryInfo(parameters: parameters, resultCallback: resultCallback)
    case "purgeAllRecoveryInfoFor": purgeAllRecoveryInfoFor(parameters: parameters, resultCallback: resultCallback)
    case "purgeAllKeyPairRecoveryInfoFor": purgeAllKeyPairRecoveryInfoFor(parameters: parameters, resultCallback: resultCallback)
    case "purgeAllExchangeDataRecoveryInfoFor": purgeAllExchangeDataRecoveryInfoFor(parameters: parameters, resultCallback: resultCallback)
    case "preGenerateRecoveryKey": preGenerateRecoveryKey(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createRecoveryInfoForAvailableKeyPairs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.createRecoveryInfoForAvailableKeyPairs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	includeParentsKeysString: parameters["includeParentsKeys"]!,
    	lifetimeSecondsString: parameters["lifetimeSeconds"]!,
    	recoveryKeyOptionsString: parameters["recoveryKeyOptions"]!
    )
  }

  private static func recoverKeyPairs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.recoverKeyPairs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recoveryKeyString: parameters["recoveryKey"]!,
    	autoDeleteString: parameters["autoDelete"]!
    )
  }

  private static func recoverKeyPairsWaitingForCreation(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.recoverKeyPairsWaitingForCreation(
    	dartResultCallback: resultCallback,
    	cancellationToken: Int64(parameters["cancellationToken"]!)!,
    	sdkId: parameters["sdkId"]!,
    	recoveryKeyString: parameters["recoveryKey"]!,
    	autoDeleteString: parameters["autoDelete"]!,
    	waitSecondsString: parameters["waitSeconds"]!
    )
  }

  private static func createExchangeDataRecoveryInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.createExchangeDataRecoveryInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	lifetimeSecondsString: parameters["lifetimeSeconds"]!,
    	recoveryKeyOptionsString: parameters["recoveryKeyOptions"]!,
    	includeBiDirectionalString: parameters["includeBiDirectional"]!,
    	includeAsParentString: parameters["includeAsParent"]!
    )
  }

  private static func recoverExchangeData(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.recoverExchangeData(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recoveryKeyString: parameters["recoveryKey"]!
    )
  }

  private static func getRecoveryExchangeData(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.getRecoveryExchangeData(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recoveryKeyString: parameters["recoveryKey"]!,
    	autoDeleteString: parameters["autoDelete"]!
    )
  }

  private static func purgeRecoveryInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.purgeRecoveryInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recoveryKeyString: parameters["recoveryKey"]!
    )
  }

  private static func purgeAllRecoveryInfoFor(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.purgeAllRecoveryInfoFor(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func purgeAllKeyPairRecoveryInfoFor(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.purgeAllKeyPairRecoveryInfoFor(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func purgeAllExchangeDataRecoveryInfoFor(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.purgeAllExchangeDataRecoveryInfoFor(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func preGenerateRecoveryKey(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    RecoveryApi.shared.preGenerateRecoveryKey(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keySizeString: parameters["keySize"]!
    )
  }

}
