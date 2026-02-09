// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'measure.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Measure {
  double? get value;
  double? get ref;
  int? get severity;
  String? get severityCode;
  int? get evolution;
  String? get unit;
  Set<CodeStub>? get unitCodes;
  String? get comment;
  String? get comparator;
  String? get sign;
  List<ReferenceRange> get referenceRanges;
  ValueWithPrecision? get valueWithPrecision;

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MeasureCopyWith<Measure> get copyWith =>
      _$MeasureCopyWithImpl<Measure>(this as Measure, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Measure &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.ref, ref) || other.ref == ref) &&
            (identical(other.severity, severity) ||
                other.severity == severity) &&
            (identical(other.severityCode, severityCode) ||
                other.severityCode == severityCode) &&
            (identical(other.evolution, evolution) ||
                other.evolution == evolution) &&
            (identical(other.unit, unit) || other.unit == unit) &&
            const DeepCollectionEquality().equals(other.unitCodes, unitCodes) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.comparator, comparator) ||
                other.comparator == comparator) &&
            (identical(other.sign, sign) || other.sign == sign) &&
            const DeepCollectionEquality()
                .equals(other.referenceRanges, referenceRanges) &&
            (identical(other.valueWithPrecision, valueWithPrecision) ||
                other.valueWithPrecision == valueWithPrecision));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      value,
      ref,
      severity,
      severityCode,
      evolution,
      unit,
      const DeepCollectionEquality().hash(unitCodes),
      comment,
      comparator,
      sign,
      const DeepCollectionEquality().hash(referenceRanges),
      valueWithPrecision);

  @override
  String toString() {
    return 'Measure(value: $value, ref: $ref, severity: $severity, severityCode: $severityCode, evolution: $evolution, unit: $unit, unitCodes: $unitCodes, comment: $comment, comparator: $comparator, sign: $sign, referenceRanges: $referenceRanges, valueWithPrecision: $valueWithPrecision)';
  }
}

/// @nodoc
abstract mixin class $MeasureCopyWith<$Res> {
  factory $MeasureCopyWith(Measure value, $Res Function(Measure) _then) =
      _$MeasureCopyWithImpl;
  @useResult
  $Res call(
      {double? value,
      double? ref,
      int? severity,
      String? severityCode,
      int? evolution,
      String? unit,
      Set<CodeStub>? unitCodes,
      String? comment,
      String? comparator,
      String? sign,
      List<ReferenceRange> referenceRanges,
      ValueWithPrecision? valueWithPrecision});

  $ValueWithPrecisionCopyWith<$Res>? get valueWithPrecision;
}

/// @nodoc
class _$MeasureCopyWithImpl<$Res> implements $MeasureCopyWith<$Res> {
  _$MeasureCopyWithImpl(this._self, this._then);

  final Measure _self;
  final $Res Function(Measure) _then;

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? value = freezed,
    Object? ref = freezed,
    Object? severity = freezed,
    Object? severityCode = freezed,
    Object? evolution = freezed,
    Object? unit = freezed,
    Object? unitCodes = freezed,
    Object? comment = freezed,
    Object? comparator = freezed,
    Object? sign = freezed,
    Object? referenceRanges = null,
    Object? valueWithPrecision = freezed,
  }) {
    return _then(_self.copyWith(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
      ref: freezed == ref
          ? _self.ref
          : ref // ignore: cast_nullable_to_non_nullable
              as double?,
      severity: freezed == severity
          ? _self.severity
          : severity // ignore: cast_nullable_to_non_nullable
              as int?,
      severityCode: freezed == severityCode
          ? _self.severityCode
          : severityCode // ignore: cast_nullable_to_non_nullable
              as String?,
      evolution: freezed == evolution
          ? _self.evolution
          : evolution // ignore: cast_nullable_to_non_nullable
              as int?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
      unitCodes: freezed == unitCodes
          ? _self.unitCodes
          : unitCodes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      comparator: freezed == comparator
          ? _self.comparator
          : comparator // ignore: cast_nullable_to_non_nullable
              as String?,
      sign: freezed == sign
          ? _self.sign
          : sign // ignore: cast_nullable_to_non_nullable
              as String?,
      referenceRanges: null == referenceRanges
          ? _self.referenceRanges
          : referenceRanges // ignore: cast_nullable_to_non_nullable
              as List<ReferenceRange>,
      valueWithPrecision: freezed == valueWithPrecision
          ? _self.valueWithPrecision
          : valueWithPrecision // ignore: cast_nullable_to_non_nullable
              as ValueWithPrecision?,
    ));
  }

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ValueWithPrecisionCopyWith<$Res>? get valueWithPrecision {
    if (_self.valueWithPrecision == null) {
      return null;
    }

    return $ValueWithPrecisionCopyWith<$Res>(_self.valueWithPrecision!,
        (value) {
      return _then(_self.copyWith(valueWithPrecision: value));
    });
  }
}

/// @nodoc

class _Measure implements Measure {
  const _Measure(
      {this.value = null,
      this.ref = null,
      this.severity = null,
      this.severityCode = null,
      this.evolution = null,
      this.unit = null,
      final Set<CodeStub>? unitCodes = null,
      this.comment = null,
      this.comparator = null,
      this.sign = null,
      final List<ReferenceRange> referenceRanges = const [],
      this.valueWithPrecision = null})
      : _unitCodes = unitCodes,
        _referenceRanges = referenceRanges;

  @override
  @JsonKey()
  final double? value;
  @override
  @JsonKey()
  final double? ref;
  @override
  @JsonKey()
  final int? severity;
  @override
  @JsonKey()
  final String? severityCode;
  @override
  @JsonKey()
  final int? evolution;
  @override
  @JsonKey()
  final String? unit;
  final Set<CodeStub>? _unitCodes;
  @override
  @JsonKey()
  Set<CodeStub>? get unitCodes {
    final value = _unitCodes;
    if (value == null) return null;
    if (_unitCodes is EqualUnmodifiableSetView) return _unitCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final String? comparator;
  @override
  @JsonKey()
  final String? sign;
  final List<ReferenceRange> _referenceRanges;
  @override
  @JsonKey()
  List<ReferenceRange> get referenceRanges {
    if (_referenceRanges is EqualUnmodifiableListView) return _referenceRanges;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_referenceRanges);
  }

  @override
  @JsonKey()
  final ValueWithPrecision? valueWithPrecision;

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MeasureCopyWith<_Measure> get copyWith =>
      __$MeasureCopyWithImpl<_Measure>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Measure &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.ref, ref) || other.ref == ref) &&
            (identical(other.severity, severity) ||
                other.severity == severity) &&
            (identical(other.severityCode, severityCode) ||
                other.severityCode == severityCode) &&
            (identical(other.evolution, evolution) ||
                other.evolution == evolution) &&
            (identical(other.unit, unit) || other.unit == unit) &&
            const DeepCollectionEquality()
                .equals(other._unitCodes, _unitCodes) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.comparator, comparator) ||
                other.comparator == comparator) &&
            (identical(other.sign, sign) || other.sign == sign) &&
            const DeepCollectionEquality()
                .equals(other._referenceRanges, _referenceRanges) &&
            (identical(other.valueWithPrecision, valueWithPrecision) ||
                other.valueWithPrecision == valueWithPrecision));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      value,
      ref,
      severity,
      severityCode,
      evolution,
      unit,
      const DeepCollectionEquality().hash(_unitCodes),
      comment,
      comparator,
      sign,
      const DeepCollectionEquality().hash(_referenceRanges),
      valueWithPrecision);

  @override
  String toString() {
    return 'Measure(value: $value, ref: $ref, severity: $severity, severityCode: $severityCode, evolution: $evolution, unit: $unit, unitCodes: $unitCodes, comment: $comment, comparator: $comparator, sign: $sign, referenceRanges: $referenceRanges, valueWithPrecision: $valueWithPrecision)';
  }
}

/// @nodoc
abstract mixin class _$MeasureCopyWith<$Res> implements $MeasureCopyWith<$Res> {
  factory _$MeasureCopyWith(_Measure value, $Res Function(_Measure) _then) =
      __$MeasureCopyWithImpl;
  @override
  @useResult
  $Res call(
      {double? value,
      double? ref,
      int? severity,
      String? severityCode,
      int? evolution,
      String? unit,
      Set<CodeStub>? unitCodes,
      String? comment,
      String? comparator,
      String? sign,
      List<ReferenceRange> referenceRanges,
      ValueWithPrecision? valueWithPrecision});

  @override
  $ValueWithPrecisionCopyWith<$Res>? get valueWithPrecision;
}

/// @nodoc
class __$MeasureCopyWithImpl<$Res> implements _$MeasureCopyWith<$Res> {
  __$MeasureCopyWithImpl(this._self, this._then);

  final _Measure _self;
  final $Res Function(_Measure) _then;

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? value = freezed,
    Object? ref = freezed,
    Object? severity = freezed,
    Object? severityCode = freezed,
    Object? evolution = freezed,
    Object? unit = freezed,
    Object? unitCodes = freezed,
    Object? comment = freezed,
    Object? comparator = freezed,
    Object? sign = freezed,
    Object? referenceRanges = null,
    Object? valueWithPrecision = freezed,
  }) {
    return _then(_Measure(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
      ref: freezed == ref
          ? _self.ref
          : ref // ignore: cast_nullable_to_non_nullable
              as double?,
      severity: freezed == severity
          ? _self.severity
          : severity // ignore: cast_nullable_to_non_nullable
              as int?,
      severityCode: freezed == severityCode
          ? _self.severityCode
          : severityCode // ignore: cast_nullable_to_non_nullable
              as String?,
      evolution: freezed == evolution
          ? _self.evolution
          : evolution // ignore: cast_nullable_to_non_nullable
              as int?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
      unitCodes: freezed == unitCodes
          ? _self._unitCodes
          : unitCodes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      comparator: freezed == comparator
          ? _self.comparator
          : comparator // ignore: cast_nullable_to_non_nullable
              as String?,
      sign: freezed == sign
          ? _self.sign
          : sign // ignore: cast_nullable_to_non_nullable
              as String?,
      referenceRanges: null == referenceRanges
          ? _self._referenceRanges
          : referenceRanges // ignore: cast_nullable_to_non_nullable
              as List<ReferenceRange>,
      valueWithPrecision: freezed == valueWithPrecision
          ? _self.valueWithPrecision
          : valueWithPrecision // ignore: cast_nullable_to_non_nullable
              as ValueWithPrecision?,
    ));
  }

  /// Create a copy of Measure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ValueWithPrecisionCopyWith<$Res>? get valueWithPrecision {
    if (_self.valueWithPrecision == null) {
      return null;
    }

    return $ValueWithPrecisionCopyWith<$Res>(_self.valueWithPrecision!,
        (value) {
      return _then(_self.copyWith(valueWithPrecision: value));
    });
  }
}

// dart format on
