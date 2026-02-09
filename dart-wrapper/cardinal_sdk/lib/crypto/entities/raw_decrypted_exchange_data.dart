// auto-generated file
import 'dart:convert';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'dart:typed_data';
part "raw_decrypted_exchange_data.freezed.dart";


@freezed
abstract class RawDecryptedExchangeData with _$RawDecryptedExchangeData {
	const factory RawDecryptedExchangeData({
		required String exchangeDataId,
		required Uint8List exchangeKey,
		required Uint8List accessControlSecret,
		required Uint8List sharedSignatureKey,
	}) = _RawDecryptedExchangeData;


	static Map<String, dynamic> encode(RawDecryptedExchangeData value) {
		Map<String, dynamic> entityAsMap = {
			"exchangeDataId" : value.exchangeDataId,
			"exchangeKey" : base64Encode(value.exchangeKey as List<int>),
			"accessControlSecret" : base64Encode(value.accessControlSecret as List<int>),
			"sharedSignatureKey" : base64Encode(value.sharedSignatureKey as List<int>)
		};
		return entityAsMap;
	}

	static RawDecryptedExchangeData fromJSON(Map<String, dynamic> data) {
		return RawDecryptedExchangeData(
			exchangeDataId: (data["exchangeDataId"] as String),
			exchangeKey: base64Decode(data["exchangeKey"] as String),
			accessControlSecret: base64Decode(data["accessControlSecret"] as String),
			sharedSignatureKey: base64Decode(data["sharedSignatureKey"] as String)
		);
	}
}