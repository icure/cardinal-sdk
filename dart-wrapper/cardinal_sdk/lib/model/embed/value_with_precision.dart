// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "value_with_precision.freezed.dart";


@freezed
abstract class ValueWithPrecision with _$ValueWithPrecision {
	const factory ValueWithPrecision({
		required int value,
		required int precision,
	}) = _ValueWithPrecision;


	static Map<String, dynamic> encode(ValueWithPrecision value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"precision" : value.precision
		};
		return entityAsMap;
	}

	static ValueWithPrecision fromJSON(Map<String, dynamic> data) {
		return ValueWithPrecision(
			value: (data["value"] as int),
			precision: (data["precision"] as int)
		);
	}
}