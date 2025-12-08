import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/auth/authentication_process_telecom_type.dart';
import 'package:cardinal_sdk/auth/authentication_process_template_parameters.dart';
import 'package:cardinal_sdk/auth/captcha_options.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/options/sdk_options.dart';
import 'package:cardinal_sdk/options/storage_options.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(
      String? projectId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      StorageOptions storageOptions,
      SdkOptions options
  );
  Future<CardinalBaseSdk> initializeBase(
      String? projectId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      BasicSdkOptions options
    );
  Future<CardinalSdk> switchGroup(
      String sdkId,
      String groupId
  );
  Future<CardinalBaseSdk> baseSwitchGroup(
      String sdkId,
      String groupId
  );
  Future<AuthenticationWithProcessStep> initializeWithProcess(
      String? projectId,
      String baseUrl,
      String messageGatewayUrl,
      String externalServicesSpecId,
      String processId,
      AuthenticationProcessTelecomType userTelecomType,
      String userTelecom,
      CaptchaOptions captcha,
      StorageOptions storageOptions,
      AuthenticationProcessTemplateParameters authenticationProcessTemplateParameters,
      SdkOptions options
  );
  Future<CardinalSdk> completeAuthentication(String authenticationStepId, String validationCode);
}
