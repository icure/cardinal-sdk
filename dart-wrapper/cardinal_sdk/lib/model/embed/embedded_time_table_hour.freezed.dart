// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'embedded_time_table_hour.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EmbeddedTimeTableHour {
  int get startHour;
  int get endHour;

  /// Create a copy of EmbeddedTimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EmbeddedTimeTableHourCopyWith<EmbeddedTimeTableHour> get copyWith =>
      _$EmbeddedTimeTableHourCopyWithImpl<EmbeddedTimeTableHour>(
          this as EmbeddedTimeTableHour, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EmbeddedTimeTableHour &&
            (identical(other.startHour, startHour) ||
                other.startHour == startHour) &&
            (identical(other.endHour, endHour) || other.endHour == endHour));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startHour, endHour);

  @override
  String toString() {
    return 'EmbeddedTimeTableHour(startHour: $startHour, endHour: $endHour)';
  }
}

/// @nodoc
abstract mixin class $EmbeddedTimeTableHourCopyWith<$Res> {
  factory $EmbeddedTimeTableHourCopyWith(EmbeddedTimeTableHour value,
          $Res Function(EmbeddedTimeTableHour) _then) =
      _$EmbeddedTimeTableHourCopyWithImpl;
  @useResult
  $Res call({int startHour, int endHour});
}

/// @nodoc
class _$EmbeddedTimeTableHourCopyWithImpl<$Res>
    implements $EmbeddedTimeTableHourCopyWith<$Res> {
  _$EmbeddedTimeTableHourCopyWithImpl(this._self, this._then);

  final EmbeddedTimeTableHour _self;
  final $Res Function(EmbeddedTimeTableHour) _then;

  /// Create a copy of EmbeddedTimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startHour = null,
    Object? endHour = null,
  }) {
    return _then(_self.copyWith(
      startHour: null == startHour
          ? _self.startHour
          : startHour // ignore: cast_nullable_to_non_nullable
              as int,
      endHour: null == endHour
          ? _self.endHour
          : endHour // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _EmbeddedTimeTableHour implements EmbeddedTimeTableHour {
  const _EmbeddedTimeTableHour(
      {required this.startHour, required this.endHour});

  @override
  final int startHour;
  @override
  final int endHour;

  /// Create a copy of EmbeddedTimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EmbeddedTimeTableHourCopyWith<_EmbeddedTimeTableHour> get copyWith =>
      __$EmbeddedTimeTableHourCopyWithImpl<_EmbeddedTimeTableHour>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EmbeddedTimeTableHour &&
            (identical(other.startHour, startHour) ||
                other.startHour == startHour) &&
            (identical(other.endHour, endHour) || other.endHour == endHour));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startHour, endHour);

  @override
  String toString() {
    return 'EmbeddedTimeTableHour(startHour: $startHour, endHour: $endHour)';
  }
}

/// @nodoc
abstract mixin class _$EmbeddedTimeTableHourCopyWith<$Res>
    implements $EmbeddedTimeTableHourCopyWith<$Res> {
  factory _$EmbeddedTimeTableHourCopyWith(_EmbeddedTimeTableHour value,
          $Res Function(_EmbeddedTimeTableHour) _then) =
      __$EmbeddedTimeTableHourCopyWithImpl;
  @override
  @useResult
  $Res call({int startHour, int endHour});
}

/// @nodoc
class __$EmbeddedTimeTableHourCopyWithImpl<$Res>
    implements _$EmbeddedTimeTableHourCopyWith<$Res> {
  __$EmbeddedTimeTableHourCopyWithImpl(this._self, this._then);

  final _EmbeddedTimeTableHour _self;
  final $Res Function(_EmbeddedTimeTableHour) _then;

  /// Create a copy of EmbeddedTimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startHour = null,
    Object? endHour = null,
  }) {
    return _then(_EmbeddedTimeTableHour(
      startHour: null == startHour
          ? _self.startHour
          : startHour // ignore: cast_nullable_to_non_nullable
              as int,
      endHour: null == endHour
          ? _self.endHour
          : endHour // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
