// auto-generated file
import 'dart:convert';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'dart:typed_data';
part "exchange_data_injection_details.freezed.dart";


@freezed
abstract class ExchangeDataInjectionDetails with _$ExchangeDataInjectionDetails {
	const factory ExchangeDataInjectionDetails({
		required String exchangeDataId,
		required Uint8List accessControlSecret,
		required Uint8List exchangeKey,
		required Uint8List sharedSignatureKey,
		required bool verified,
	}) = _ExchangeDataInjectionDetails;


	static Map<String, dynamic> encode(ExchangeDataInjectionDetails value) {
		Map<String, dynamic> entityAsMap = {
			"exchangeDataId" : value.exchangeDataId,
			"accessControlSecret" : base64Encode(value.accessControlSecret as List<int>),
			"exchangeKey" : base64Encode(value.exchangeKey as List<int>),
			"sharedSignatureKey" : base64Encode(value.sharedSignatureKey as List<int>),
			"verified" : value.verified
		};
		return entityAsMap;
	}

	static ExchangeDataInjectionDetails fromJSON(Map<String, dynamic> data) {
		return ExchangeDataInjectionDetails(
			exchangeDataId: (data["exchangeDataId"] as String),
			accessControlSecret: base64Decode(data["accessControlSecret"] as String),
			exchangeKey: base64Decode(data["exchangeKey"] as String),
			sharedSignatureKey: base64Decode(data["sharedSignatureKey"] as String),
			verified: (data["verified"] as bool)
		);
	}
}