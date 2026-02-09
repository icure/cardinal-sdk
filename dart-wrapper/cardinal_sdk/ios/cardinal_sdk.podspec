Pod::Spec.new do |s|
  s.name             = 'cardinal_sdk'
  s.version          = '2.0.0-PREVIEW-3-dart-1'
  s.summary          = 'Cardinal SDK is a multiplatform SDK for the iCure platform.'
  s.description      = <<-DESC
Cardinal SDK is a multiplatform SDK for the iCure platform.
                       DESC
  s.homepage         = 'https://cardinalsdk.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'iCure' => 'contact@icure.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.platform = :ios, '12.0'
  # s.dependency 'CardinalDartSdkSupportLib', '~> 2.0.0-PREVIEW-3'
  s.vendored_framework = "CardinalDartSdkSupportLib.xcframework"

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
  s.swift_version = '5.0'

  # If your plugin requires a privacy manifest, for example if it uses any
  # required reason APIs, update the PrivacyInfo.xcprivacy file to describe your
  # plugin's privacy impact, and then uncomment this line. For more information,
  # see https://developer.apple.com/documentation/bundleresources/privacy_manifest_files
  # s.resource_bundles = {'cardinal_sdk_privacy' => ['Resources/PrivacyInfo.xcprivacy']}
end
