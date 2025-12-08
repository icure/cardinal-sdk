import Flutter
import CardinalDartSdkSupportLib

class InitializersPlugin {
	public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
		let args = call.arguments as! [String: String]
		let methodName = call.method
		
		let completed = InitializersPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage, errorDetails in
			if (errorCode != nil){
				result(FlutterError(code: errorCode!, message: errorMessage, details: errorDetails))
			}
			else {
				result(success)
			}
		}
		
		if !completed {
			result(FlutterMethodNotImplemented)
		}
	}
	
	private static func dispatch(
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
		case "initialize": initialize(parameters: parameters, resultCallback: resultCallback)
		case "initializeBase": initializeBase(parameters: parameters, resultCallback: resultCallback)
		case "switchGroup": switchGroup(parameters: parameters, resultCallback: resultCallback)
		case "baseSwitchGroup": baseSwitchGroup(parameters: parameters, resultCallback: resultCallback)
		case "initializeWithAuthProcess": initializeWithAuthProcess(parameters: parameters, resultCallback: resultCallback)
		case "completeAuthentication": completeAuthentication(parameters: parameters, resultCallback: resultCallback)
		default: return false
		}
		return true
	}
	
	private static func initialize(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.initializeSdk(
			dartResultCallback: resultCallback,
			projectIdString: parameters["projectId"]!,
			baseUrlString: parameters["baseUrl"]!,
			authenticationMethodString: parameters["authenticationMethod"]!,
			storageFacade: StorageHelper.shared.getStorage(options: parameters["storageOptions"]!),
			optionsString: parameters["options"]!
		)
	}

	private static func initializeBase(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.initializeBaseSdk(
			dartResultCallback: resultCallback,
			projectIdString: parameters["projectId"]!,
			baseUrlString: parameters["baseUrl"]!,
			authenticationMethodString: parameters["authenticationMethod"]!,
			optionsString: parameters["options"]!
		)
	}

	private static func switchGroup(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.switchGroup(
			dartResultCallback: resultCallback,
			sdkId: parameters["sdkId"]!,
			groupId: parameters["groupId"]!
		)
	}

	private static func baseSwitchGroup(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.baseSwitchGroup(
			dartResultCallback: resultCallback,
			sdkId: parameters["sdkId"]!,
			groupId: parameters["groupId"]!
		)
	}

	private static func initializeWithAuthProcess(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.initializeWithAuthProcess(
			dartResultCallback: resultCallback,
			projectIdString: parameters["projectId"]!,
			baseUrlString: parameters["baseUrl"]!,
			messageGatewayUrlString: parameters["messageGatewayUrl"]!,
			externalServicesSpecIdString: parameters["externalServicesSpecId"]!,
			processIdString: parameters["processId"]!,
			userTelecomTypeString: parameters["userTelecomType"]!,
			userTelecomString: parameters["userTelecom"]!,
			captchaOptionsString: parameters["captchaOptions"]!,
			baseStorage: StorageHelper.shared.getStorage(options: parameters["storageOptions"]!),
			authenticationProcessTemplateParametersString: parameters["authenticationProcessTemplateParameters"]!,
			optionsString: parameters["options"]!
		)
	}
	
	private static func completeAuthentication(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) -> Void {
		Initializers.shared.completeAuthentication(
			dartResultCallback: resultCallback,
			authenticationStepId: parameters["authenticationStepId"]!,
			validationCodeString: parameters["validationCode"]!
		)
	}
}
