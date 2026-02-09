// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/insurance.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class InsurancePlatformApi {
	MethodChannel _methodChannel;
	InsurancePlatformApi(this._methodChannel);

	Future<Insurance?> getInsurance(String sdkId, String insuranceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.getInsurance',
			{
				"sdkId": sdkId,
				"insuranceId": jsonEncode(insuranceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInsurance");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Insurance.fromJSON(parsedResJson);
	}

	Future<List<Insurance>> getInsurances(String sdkId, List<String> insuranceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.getInsurances',
			{
				"sdkId": sdkId,
				"insuranceIds": jsonEncode(insuranceIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInsurances");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}

	Future<Insurance> createInsurance(String sdkId, Insurance insurance) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.createInsurance',
			{
				"sdkId": sdkId,
				"insurance": jsonEncode(Insurance.encode(insurance)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createInsurance");
		final parsedResJson = jsonDecode(res);
		return Insurance.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteInsurance(String sdkId, String insuranceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.deleteInsurance',
			{
				"sdkId": sdkId,
				"insuranceId": jsonEncode(insuranceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteInsurance");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<Insurance>> listInsurancesByCode(String sdkId, String insuranceCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.listInsurancesByCode',
			{
				"sdkId": sdkId,
				"insuranceCode": jsonEncode(insuranceCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInsurancesByCode");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}

	Future<List<Insurance>> listInsurancesByName(String sdkId, String insuranceName) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.listInsurancesByName',
			{
				"sdkId": sdkId,
				"insuranceName": jsonEncode(insuranceName),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listInsurancesByName");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}

	Future<Insurance> modifyInsurance(String sdkId, Insurance insurance) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.modifyInsurance',
			{
				"sdkId": sdkId,
				"insurance": jsonEncode(Insurance.encode(insurance)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInsurance");
		final parsedResJson = jsonDecode(res);
		return Insurance.fromJSON(parsedResJson);
	}

	Future<List<Insurance>> createInsurancesInGroup(String sdkId, String groupId, List<Insurance> insuranceBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.createInsurancesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"insuranceBatch": jsonEncode(insuranceBatch.map((x0) => Insurance.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createInsurancesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}

	Future<List<Insurance>> getInsurancesInGroup(String sdkId, String groupId, List<String> insuranceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.getInsurancesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"insuranceIds": jsonEncode(insuranceIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getInsurancesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}

	Future<List<Insurance>> modifyInsurancesInGroup(String sdkId, String groupId, List<Insurance> insuranceBatch) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InsuranceApi.modifyInsurancesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"insuranceBatch": jsonEncode(insuranceBatch.map((x0) => Insurance.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyInsurancesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Insurance.fromJSON(x1) ).toList();
	}
}