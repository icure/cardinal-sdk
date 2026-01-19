// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/reference_range.dart';
import 'package:cardinal_sdk/model/embed/value_with_precision.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "measure.freezed.dart";


@freezed
abstract class Measure with _$Measure {
	const factory Measure({
		@Default(null) double? value,
		@Default(null) double? ref,
		@Default(null) int? severity,
		@Default(null) String? severityCode,
		@Default(null) int? evolution,
		@Default(null) String? unit,
		@Default(null) Set<CodeStub>? unitCodes,
		@Default(null) String? comment,
		@Default(null) String? comparator,
		@Default(null) String? sign,
		@Default([]) List<ReferenceRange> referenceRanges,
		@Default(null) ValueWithPrecision? valueWithPrecision,
	}) = _Measure;


	static Map<String, dynamic> encode(Measure value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"ref" : value.ref,
			"severity" : value.severity,
			"severityCode" : value.severityCode,
			"evolution" : value.evolution,
			"unit" : value.unit,
			"unitCodes" : value.unitCodes?.map((x0) => CodeStub.encode(x0)).toList(),
			"comment" : value.comment,
			"comparator" : value.comparator,
			"sign" : value.sign,
			"referenceRanges" : value.referenceRanges.map((x0) => ReferenceRange.encode(x0)).toList(),
			"valueWithPrecision" : value.valueWithPrecision == null ? null : ValueWithPrecision.encode(value.valueWithPrecision!)
		};
		return entityAsMap;
	}

	static Measure fromJSON(Map<String, dynamic> data) {
		return Measure(
			severity: (data["severity"] as int?),
			evolution: (data["evolution"] as int?),
			value: (data["value"] as num?)?.toDouble(),
			ref: (data["ref"] as num?)?.toDouble(),
			severityCode: (data["severityCode"] as String?),
			unit: (data["unit"] as String?),
			unitCodes: (data["unitCodes"] as List<dynamic>?)?.map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			comment: (data["comment"] as String?),
			comparator: (data["comparator"] as String?),
			sign: (data["sign"] as String?),
			referenceRanges: (data["referenceRanges"] as List<dynamic>).map((x0) => ReferenceRange.fromJSON(x0) ).toList(),
			valueWithPrecision: data["valueWithPrecision"] == null ? null : ValueWithPrecision.fromJSON(data["valueWithPrecision"])
		);
	}
}