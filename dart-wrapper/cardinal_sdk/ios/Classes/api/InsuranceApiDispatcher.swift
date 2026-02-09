// auto-generated file
import CardinalDartSdkSupportLib

class InsuranceApiDispatcher {

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
    case "getInsurance": getInsurance(parameters: parameters, resultCallback: resultCallback)
    case "getInsurances": getInsurances(parameters: parameters, resultCallback: resultCallback)
    case "createInsurance": createInsurance(parameters: parameters, resultCallback: resultCallback)
    case "deleteInsurance": deleteInsurance(parameters: parameters, resultCallback: resultCallback)
    case "listInsurancesByCode": listInsurancesByCode(parameters: parameters, resultCallback: resultCallback)
    case "listInsurancesByName": listInsurancesByName(parameters: parameters, resultCallback: resultCallback)
    case "modifyInsurance": modifyInsurance(parameters: parameters, resultCallback: resultCallback)
    case "createInsurancesInGroup": createInsurancesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getInsurancesInGroup": getInsurancesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "modifyInsurancesInGroup": modifyInsurancesInGroup(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getInsurance(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.getInsurance(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceIdString: parameters["insuranceId"]!
    )
  }

  private static func getInsurances(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.getInsurances(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceIdsString: parameters["insuranceIds"]!
    )
  }

  private static func createInsurance(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.createInsurance(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceString: parameters["insurance"]!
    )
  }

  private static func deleteInsurance(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.deleteInsurance(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceIdString: parameters["insuranceId"]!
    )
  }

  private static func listInsurancesByCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.listInsurancesByCode(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceCodeString: parameters["insuranceCode"]!
    )
  }

  private static func listInsurancesByName(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.listInsurancesByName(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceNameString: parameters["insuranceName"]!
    )
  }

  private static func modifyInsurance(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.modifyInsurance(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	insuranceString: parameters["insurance"]!
    )
  }

  private static func createInsurancesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.createInsurancesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	insuranceBatchString: parameters["insuranceBatch"]!
    )
  }

  private static func getInsurancesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.getInsurancesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	insuranceIdsString: parameters["insuranceIds"]!
    )
  }

  private static func modifyInsurancesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    InsuranceApi.shared.modifyInsurancesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	insuranceBatchString: parameters["insuranceBatch"]!
    )
  }

}
