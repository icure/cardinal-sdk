// auto-generated file
import CardinalDartSdkSupportLib

class MessageFiltersDispatcher {

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
    case "allMessagesForDataOwner": allMessagesForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allMessagesForSelf": allMessagesForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTransportGuidForDataOwner": byTransportGuidForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTransportGuidForSelf": byTransportGuidForSelf(parameters: parameters, resultCallback: resultCallback)
    case "fromAddressForDataOwner": fromAddressForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "fromAddressForSelf": fromAddressForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSentDateForDataOwner": byPatientsSentDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSentDateForSelf": byPatientsSentDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsSentDateForDataOwner": byPatientSecretIdsSentDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsSentDateForSelf": byPatientSecretIdsSentDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "toAddressForDataOwner": toAddressForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "toAddressForSelf": toAddressForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTransportGuidSentDateForDataOwner": byTransportGuidSentDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTransportGuidSentDateForSelf": byTransportGuidSentDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "latestByTransportGuidForDataOwner": latestByTransportGuidForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "latestByTransportGuidForSelf": latestByTransportGuidForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byInvoiceIds": byInvoiceIds(parameters: parameters, resultCallback: resultCallback)
    case "byParentIds": byParentIds(parameters: parameters, resultCallback: resultCallback)
    case "lifecycleBetweenForDataOwner": lifecycleBetweenForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "lifecycleBetweenForDataOwnerInGroup": lifecycleBetweenForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "lifecycleBetweenForSelf": lifecycleBetweenForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allMessagesForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.allMessagesForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allMessagesForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.allMessagesForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byTransportGuidForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byTransportGuidForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	transportGuidString: parameters["transportGuid"]!
    )
  }

  private static func byTransportGuidForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byTransportGuidForSelf(
    	dartResultCallback: resultCallback,
    	transportGuidString: parameters["transportGuid"]!
    )
  }

  private static func fromAddressForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.fromAddressForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	addressString: parameters["address"]!
    )
  }

  private static func fromAddressForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.fromAddressForSelf(
    	dartResultCallback: resultCallback,
    	addressString: parameters["address"]!
    )
  }

  private static func byPatientsSentDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byPatientsSentDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsSentDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byPatientsSentDateForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsSentDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byPatientSecretIdsSentDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsSentDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byPatientSecretIdsSentDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func toAddressForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.toAddressForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	addressString: parameters["address"]!
    )
  }

  private static func toAddressForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.toAddressForSelf(
    	dartResultCallback: resultCallback,
    	addressString: parameters["address"]!
    )
  }

  private static func byTransportGuidSentDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byTransportGuidSentDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	transportGuidString: parameters["transportGuid"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byTransportGuidSentDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byTransportGuidSentDateForSelf(
    	dartResultCallback: resultCallback,
    	transportGuidString: parameters["transportGuid"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func latestByTransportGuidForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.latestByTransportGuidForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	transportGuidString: parameters["transportGuid"]!
    )
  }

  private static func latestByTransportGuidForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.latestByTransportGuidForSelf(
    	dartResultCallback: resultCallback,
    	transportGuidString: parameters["transportGuid"]!
    )
  }

  private static func byInvoiceIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byInvoiceIds(
    	dartResultCallback: resultCallback,
    	invoiceIdsString: parameters["invoiceIds"]!
    )
  }

  private static func byParentIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.byParentIds(
    	dartResultCallback: resultCallback,
    	parentIdsString: parameters["parentIds"]!
    )
  }

  private static func lifecycleBetweenForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.lifecycleBetweenForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	startTimestampString: parameters["startTimestamp"]!,
    	endTimestampString: parameters["endTimestamp"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func lifecycleBetweenForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.lifecycleBetweenForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	startTimestampString: parameters["startTimestamp"]!,
    	endTimestampString: parameters["endTimestamp"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func lifecycleBetweenForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageFilters.shared.lifecycleBetweenForSelf(
    	dartResultCallback: resultCallback,
    	startTimestampString: parameters["startTimestamp"]!,
    	endTimestampString: parameters["endTimestamp"]!,
    	descendingString: parameters["descending"]!
    )
  }

}
