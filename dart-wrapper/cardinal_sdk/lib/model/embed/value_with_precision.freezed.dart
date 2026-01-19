// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'value_with_precision.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ValueWithPrecision {
  int get value;
  int get precision;

  /// Create a copy of ValueWithPrecision
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ValueWithPrecisionCopyWith<ValueWithPrecision> get copyWith =>
      _$ValueWithPrecisionCopyWithImpl<ValueWithPrecision>(
          this as ValueWithPrecision, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ValueWithPrecision &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.precision, precision) ||
                other.precision == precision));
  }

  @override
  int get hashCode => Object.hash(runtimeType, value, precision);

  @override
  String toString() {
    return 'ValueWithPrecision(value: $value, precision: $precision)';
  }
}

/// @nodoc
abstract mixin class $ValueWithPrecisionCopyWith<$Res> {
  factory $ValueWithPrecisionCopyWith(
          ValueWithPrecision value, $Res Function(ValueWithPrecision) _then) =
      _$ValueWithPrecisionCopyWithImpl;
  @useResult
  $Res call({int value, int precision});
}

/// @nodoc
class _$ValueWithPrecisionCopyWithImpl<$Res>
    implements $ValueWithPrecisionCopyWith<$Res> {
  _$ValueWithPrecisionCopyWithImpl(this._self, this._then);

  final ValueWithPrecision _self;
  final $Res Function(ValueWithPrecision) _then;

  /// Create a copy of ValueWithPrecision
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? value = null,
    Object? precision = null,
  }) {
    return _then(_self.copyWith(
      value: null == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as int,
      precision: null == precision
          ? _self.precision
          : precision // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _ValueWithPrecision implements ValueWithPrecision {
  const _ValueWithPrecision({required this.value, required this.precision});

  @override
  final int value;
  @override
  final int precision;

  /// Create a copy of ValueWithPrecision
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ValueWithPrecisionCopyWith<_ValueWithPrecision> get copyWith =>
      __$ValueWithPrecisionCopyWithImpl<_ValueWithPrecision>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ValueWithPrecision &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.precision, precision) ||
                other.precision == precision));
  }

  @override
  int get hashCode => Object.hash(runtimeType, value, precision);

  @override
  String toString() {
    return 'ValueWithPrecision(value: $value, precision: $precision)';
  }
}

/// @nodoc
abstract mixin class _$ValueWithPrecisionCopyWith<$Res>
    implements $ValueWithPrecisionCopyWith<$Res> {
  factory _$ValueWithPrecisionCopyWith(
          _ValueWithPrecision value, $Res Function(_ValueWithPrecision) _then) =
      __$ValueWithPrecisionCopyWithImpl;
  @override
  @useResult
  $Res call({int value, int precision});
}

/// @nodoc
class __$ValueWithPrecisionCopyWithImpl<$Res>
    implements _$ValueWithPrecisionCopyWith<$Res> {
  __$ValueWithPrecisionCopyWithImpl(this._self, this._then);

  final _ValueWithPrecision _self;
  final $Res Function(_ValueWithPrecision) _then;

  /// Create a copy of ValueWithPrecision
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? value = null,
    Object? precision = null,
  }) {
    return _then(_ValueWithPrecision(
      value: null == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as int,
      precision: null == precision
          ? _self.precision
          : precision // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
