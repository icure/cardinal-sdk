// auto-generated file
import CardinalDartSdkSupportLib

class DocumentFiltersDispatcher {

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
    case "byPatientsCreatedForDataOwner": byPatientsCreatedForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byMessagesCreatedForDataOwner": byMessagesCreatedForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsCreatedForSelf": byPatientsCreatedForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byMessagesCreatedForSelf": byMessagesCreatedForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byOwningEntitySecretIdsCreatedForDataOwner": byOwningEntitySecretIdsCreatedForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byOwningEntitySecretIdsCreatedForSelf": byOwningEntitySecretIdsCreatedForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsAndTypeForDataOwner": byPatientsAndTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byMessagesAndTypeForDataOwner": byMessagesAndTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsAndTypeForSelf": byPatientsAndTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byMessagesAndTypeForSelf": byMessagesAndTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byOwningEntitySecretIdsAndTypeForDataOwner": byOwningEntitySecretIdsAndTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byOwningEntitySecretIdsAndTypeForSelf": byOwningEntitySecretIdsAndTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byPatientsCreatedForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsCreatedForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byMessagesCreatedForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byMessagesCreatedForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	messagesString: parameters["messages"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsCreatedForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsCreatedForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byMessagesCreatedForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byMessagesCreatedForSelf(
    	dartResultCallback: resultCallback,
    	messagesString: parameters["messages"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byOwningEntitySecretIdsCreatedForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byOwningEntitySecretIdsCreatedForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byOwningEntitySecretIdsCreatedForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byOwningEntitySecretIdsCreatedForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsAndTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsAndTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	documentTypeString: parameters["documentType"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byMessagesAndTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byMessagesAndTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	documentTypeString: parameters["documentType"]!,
    	messagesString: parameters["messages"]!
    )
  }

  private static func byPatientsAndTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsAndTypeForSelf(
    	dartResultCallback: resultCallback,
    	documentTypeString: parameters["documentType"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byMessagesAndTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byMessagesAndTypeForSelf(
    	dartResultCallback: resultCallback,
    	documentTypeString: parameters["documentType"]!,
    	messagesString: parameters["messages"]!
    )
  }

  private static func byOwningEntitySecretIdsAndTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byOwningEntitySecretIdsAndTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	documentTypeString: parameters["documentType"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byOwningEntitySecretIdsAndTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byOwningEntitySecretIdsAndTypeForSelf(
    	dartResultCallback: resultCallback,
    	documentTypeString: parameters["documentType"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

}
