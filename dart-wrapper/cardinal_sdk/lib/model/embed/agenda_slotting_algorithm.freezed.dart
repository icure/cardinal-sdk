// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'agenda_slotting_algorithm.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AgendaSlottingAlgorithmFixedIntervals {
  int get intervalMinutes;

  /// Create a copy of AgendaSlottingAlgorithmFixedIntervals
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AgendaSlottingAlgorithmFixedIntervalsCopyWith<
          AgendaSlottingAlgorithmFixedIntervals>
      get copyWith => _$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl<
              AgendaSlottingAlgorithmFixedIntervals>(
          this as AgendaSlottingAlgorithmFixedIntervals, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AgendaSlottingAlgorithmFixedIntervals &&
            (identical(other.intervalMinutes, intervalMinutes) ||
                other.intervalMinutes == intervalMinutes));
  }

  @override
  int get hashCode => Object.hash(runtimeType, intervalMinutes);

  @override
  String toString() {
    return 'AgendaSlottingAlgorithmFixedIntervals(intervalMinutes: $intervalMinutes)';
  }
}

/// @nodoc
abstract mixin class $AgendaSlottingAlgorithmFixedIntervalsCopyWith<$Res> {
  factory $AgendaSlottingAlgorithmFixedIntervalsCopyWith(
          AgendaSlottingAlgorithmFixedIntervals value,
          $Res Function(AgendaSlottingAlgorithmFixedIntervals) _then) =
      _$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl;
  @useResult
  $Res call({int intervalMinutes});
}

/// @nodoc
class _$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl<$Res>
    implements $AgendaSlottingAlgorithmFixedIntervalsCopyWith<$Res> {
  _$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl(this._self, this._then);

  final AgendaSlottingAlgorithmFixedIntervals _self;
  final $Res Function(AgendaSlottingAlgorithmFixedIntervals) _then;

  /// Create a copy of AgendaSlottingAlgorithmFixedIntervals
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? intervalMinutes = null,
  }) {
    return _then(_self.copyWith(
      intervalMinutes: null == intervalMinutes
          ? _self.intervalMinutes
          : intervalMinutes // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _AgendaSlottingAlgorithmFixedIntervals
    implements AgendaSlottingAlgorithmFixedIntervals {
  const _AgendaSlottingAlgorithmFixedIntervals({required this.intervalMinutes});

  @override
  final int intervalMinutes;

  /// Create a copy of AgendaSlottingAlgorithmFixedIntervals
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AgendaSlottingAlgorithmFixedIntervalsCopyWith<
          _AgendaSlottingAlgorithmFixedIntervals>
      get copyWith => __$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl<
          _AgendaSlottingAlgorithmFixedIntervals>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AgendaSlottingAlgorithmFixedIntervals &&
            (identical(other.intervalMinutes, intervalMinutes) ||
                other.intervalMinutes == intervalMinutes));
  }

  @override
  int get hashCode => Object.hash(runtimeType, intervalMinutes);

  @override
  String toString() {
    return 'AgendaSlottingAlgorithmFixedIntervals(intervalMinutes: $intervalMinutes)';
  }
}

/// @nodoc
abstract mixin class _$AgendaSlottingAlgorithmFixedIntervalsCopyWith<$Res>
    implements $AgendaSlottingAlgorithmFixedIntervalsCopyWith<$Res> {
  factory _$AgendaSlottingAlgorithmFixedIntervalsCopyWith(
          _AgendaSlottingAlgorithmFixedIntervals value,
          $Res Function(_AgendaSlottingAlgorithmFixedIntervals) _then) =
      __$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl;
  @override
  @useResult
  $Res call({int intervalMinutes});
}

/// @nodoc
class __$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl<$Res>
    implements _$AgendaSlottingAlgorithmFixedIntervalsCopyWith<$Res> {
  __$AgendaSlottingAlgorithmFixedIntervalsCopyWithImpl(this._self, this._then);

  final _AgendaSlottingAlgorithmFixedIntervals _self;
  final $Res Function(_AgendaSlottingAlgorithmFixedIntervals) _then;

  /// Create a copy of AgendaSlottingAlgorithmFixedIntervals
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? intervalMinutes = null,
  }) {
    return _then(_AgendaSlottingAlgorithmFixedIntervals(
      intervalMinutes: null == intervalMinutes
          ? _self.intervalMinutes
          : intervalMinutes // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
