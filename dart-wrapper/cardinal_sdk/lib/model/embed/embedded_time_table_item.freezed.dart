// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'embedded_time_table_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EmbeddedTimeTableItem {
  String get rrule;
  int? get rruleStartDate;
  int? get notBeforeInMinutes;
  int? get notAfterInMinutes;
  List<EmbeddedTimeTableHour> get hours;
  Set<String> get calendarItemTypesIds;
  int get availabilities;
  Set<String> get reservingRights;
  bool get public;

  /// Create a copy of EmbeddedTimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EmbeddedTimeTableItemCopyWith<EmbeddedTimeTableItem> get copyWith =>
      _$EmbeddedTimeTableItemCopyWithImpl<EmbeddedTimeTableItem>(
          this as EmbeddedTimeTableItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EmbeddedTimeTableItem &&
            (identical(other.rrule, rrule) || other.rrule == rrule) &&
            (identical(other.rruleStartDate, rruleStartDate) ||
                other.rruleStartDate == rruleStartDate) &&
            (identical(other.notBeforeInMinutes, notBeforeInMinutes) ||
                other.notBeforeInMinutes == notBeforeInMinutes) &&
            (identical(other.notAfterInMinutes, notAfterInMinutes) ||
                other.notAfterInMinutes == notAfterInMinutes) &&
            const DeepCollectionEquality().equals(other.hours, hours) &&
            const DeepCollectionEquality()
                .equals(other.calendarItemTypesIds, calendarItemTypesIds) &&
            (identical(other.availabilities, availabilities) ||
                other.availabilities == availabilities) &&
            const DeepCollectionEquality()
                .equals(other.reservingRights, reservingRights) &&
            (identical(other.public, public) || other.public == public));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      rrule,
      rruleStartDate,
      notBeforeInMinutes,
      notAfterInMinutes,
      const DeepCollectionEquality().hash(hours),
      const DeepCollectionEquality().hash(calendarItemTypesIds),
      availabilities,
      const DeepCollectionEquality().hash(reservingRights),
      public);

  @override
  String toString() {
    return 'EmbeddedTimeTableItem(rrule: $rrule, rruleStartDate: $rruleStartDate, notBeforeInMinutes: $notBeforeInMinutes, notAfterInMinutes: $notAfterInMinutes, hours: $hours, calendarItemTypesIds: $calendarItemTypesIds, availabilities: $availabilities, reservingRights: $reservingRights, public: $public)';
  }
}

/// @nodoc
abstract mixin class $EmbeddedTimeTableItemCopyWith<$Res> {
  factory $EmbeddedTimeTableItemCopyWith(EmbeddedTimeTableItem value,
          $Res Function(EmbeddedTimeTableItem) _then) =
      _$EmbeddedTimeTableItemCopyWithImpl;
  @useResult
  $Res call(
      {String rrule,
      int? rruleStartDate,
      int? notBeforeInMinutes,
      int? notAfterInMinutes,
      List<EmbeddedTimeTableHour> hours,
      Set<String> calendarItemTypesIds,
      int availabilities,
      Set<String> reservingRights,
      bool public});
}

/// @nodoc
class _$EmbeddedTimeTableItemCopyWithImpl<$Res>
    implements $EmbeddedTimeTableItemCopyWith<$Res> {
  _$EmbeddedTimeTableItemCopyWithImpl(this._self, this._then);

  final EmbeddedTimeTableItem _self;
  final $Res Function(EmbeddedTimeTableItem) _then;

  /// Create a copy of EmbeddedTimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? rrule = null,
    Object? rruleStartDate = freezed,
    Object? notBeforeInMinutes = freezed,
    Object? notAfterInMinutes = freezed,
    Object? hours = null,
    Object? calendarItemTypesIds = null,
    Object? availabilities = null,
    Object? reservingRights = null,
    Object? public = null,
  }) {
    return _then(_self.copyWith(
      rrule: null == rrule
          ? _self.rrule
          : rrule // ignore: cast_nullable_to_non_nullable
              as String,
      rruleStartDate: freezed == rruleStartDate
          ? _self.rruleStartDate
          : rruleStartDate // ignore: cast_nullable_to_non_nullable
              as int?,
      notBeforeInMinutes: freezed == notBeforeInMinutes
          ? _self.notBeforeInMinutes
          : notBeforeInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      notAfterInMinutes: freezed == notAfterInMinutes
          ? _self.notAfterInMinutes
          : notAfterInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      hours: null == hours
          ? _self.hours
          : hours // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTableHour>,
      calendarItemTypesIds: null == calendarItemTypesIds
          ? _self.calendarItemTypesIds
          : calendarItemTypesIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      availabilities: null == availabilities
          ? _self.availabilities
          : availabilities // ignore: cast_nullable_to_non_nullable
              as int,
      reservingRights: null == reservingRights
          ? _self.reservingRights
          : reservingRights // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      public: null == public
          ? _self.public
          : public // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _EmbeddedTimeTableItem implements EmbeddedTimeTableItem {
  const _EmbeddedTimeTableItem(
      {required this.rrule,
      this.rruleStartDate = null,
      this.notBeforeInMinutes = null,
      this.notAfterInMinutes = null,
      required final List<EmbeddedTimeTableHour> hours,
      required final Set<String> calendarItemTypesIds,
      this.availabilities = 1,
      final Set<String> reservingRights = const {},
      this.public = false})
      : _hours = hours,
        _calendarItemTypesIds = calendarItemTypesIds,
        _reservingRights = reservingRights;

  @override
  final String rrule;
  @override
  @JsonKey()
  final int? rruleStartDate;
  @override
  @JsonKey()
  final int? notBeforeInMinutes;
  @override
  @JsonKey()
  final int? notAfterInMinutes;
  final List<EmbeddedTimeTableHour> _hours;
  @override
  List<EmbeddedTimeTableHour> get hours {
    if (_hours is EqualUnmodifiableListView) return _hours;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_hours);
  }

  final Set<String> _calendarItemTypesIds;
  @override
  Set<String> get calendarItemTypesIds {
    if (_calendarItemTypesIds is EqualUnmodifiableSetView)
      return _calendarItemTypesIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_calendarItemTypesIds);
  }

  @override
  @JsonKey()
  final int availabilities;
  final Set<String> _reservingRights;
  @override
  @JsonKey()
  Set<String> get reservingRights {
    if (_reservingRights is EqualUnmodifiableSetView) return _reservingRights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_reservingRights);
  }

  @override
  @JsonKey()
  final bool public;

  /// Create a copy of EmbeddedTimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EmbeddedTimeTableItemCopyWith<_EmbeddedTimeTableItem> get copyWith =>
      __$EmbeddedTimeTableItemCopyWithImpl<_EmbeddedTimeTableItem>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EmbeddedTimeTableItem &&
            (identical(other.rrule, rrule) || other.rrule == rrule) &&
            (identical(other.rruleStartDate, rruleStartDate) ||
                other.rruleStartDate == rruleStartDate) &&
            (identical(other.notBeforeInMinutes, notBeforeInMinutes) ||
                other.notBeforeInMinutes == notBeforeInMinutes) &&
            (identical(other.notAfterInMinutes, notAfterInMinutes) ||
                other.notAfterInMinutes == notAfterInMinutes) &&
            const DeepCollectionEquality().equals(other._hours, _hours) &&
            const DeepCollectionEquality()
                .equals(other._calendarItemTypesIds, _calendarItemTypesIds) &&
            (identical(other.availabilities, availabilities) ||
                other.availabilities == availabilities) &&
            const DeepCollectionEquality()
                .equals(other._reservingRights, _reservingRights) &&
            (identical(other.public, public) || other.public == public));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      rrule,
      rruleStartDate,
      notBeforeInMinutes,
      notAfterInMinutes,
      const DeepCollectionEquality().hash(_hours),
      const DeepCollectionEquality().hash(_calendarItemTypesIds),
      availabilities,
      const DeepCollectionEquality().hash(_reservingRights),
      public);

  @override
  String toString() {
    return 'EmbeddedTimeTableItem(rrule: $rrule, rruleStartDate: $rruleStartDate, notBeforeInMinutes: $notBeforeInMinutes, notAfterInMinutes: $notAfterInMinutes, hours: $hours, calendarItemTypesIds: $calendarItemTypesIds, availabilities: $availabilities, reservingRights: $reservingRights, public: $public)';
  }
}

/// @nodoc
abstract mixin class _$EmbeddedTimeTableItemCopyWith<$Res>
    implements $EmbeddedTimeTableItemCopyWith<$Res> {
  factory _$EmbeddedTimeTableItemCopyWith(_EmbeddedTimeTableItem value,
          $Res Function(_EmbeddedTimeTableItem) _then) =
      __$EmbeddedTimeTableItemCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String rrule,
      int? rruleStartDate,
      int? notBeforeInMinutes,
      int? notAfterInMinutes,
      List<EmbeddedTimeTableHour> hours,
      Set<String> calendarItemTypesIds,
      int availabilities,
      Set<String> reservingRights,
      bool public});
}

/// @nodoc
class __$EmbeddedTimeTableItemCopyWithImpl<$Res>
    implements _$EmbeddedTimeTableItemCopyWith<$Res> {
  __$EmbeddedTimeTableItemCopyWithImpl(this._self, this._then);

  final _EmbeddedTimeTableItem _self;
  final $Res Function(_EmbeddedTimeTableItem) _then;

  /// Create a copy of EmbeddedTimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? rrule = null,
    Object? rruleStartDate = freezed,
    Object? notBeforeInMinutes = freezed,
    Object? notAfterInMinutes = freezed,
    Object? hours = null,
    Object? calendarItemTypesIds = null,
    Object? availabilities = null,
    Object? reservingRights = null,
    Object? public = null,
  }) {
    return _then(_EmbeddedTimeTableItem(
      rrule: null == rrule
          ? _self.rrule
          : rrule // ignore: cast_nullable_to_non_nullable
              as String,
      rruleStartDate: freezed == rruleStartDate
          ? _self.rruleStartDate
          : rruleStartDate // ignore: cast_nullable_to_non_nullable
              as int?,
      notBeforeInMinutes: freezed == notBeforeInMinutes
          ? _self.notBeforeInMinutes
          : notBeforeInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      notAfterInMinutes: freezed == notAfterInMinutes
          ? _self.notAfterInMinutes
          : notAfterInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      hours: null == hours
          ? _self._hours
          : hours // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTableHour>,
      calendarItemTypesIds: null == calendarItemTypesIds
          ? _self._calendarItemTypesIds
          : calendarItemTypesIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      availabilities: null == availabilities
          ? _self.availabilities
          : availabilities // ignore: cast_nullable_to_non_nullable
              as int,
      reservingRights: null == reservingRights
          ? _self._reservingRights
          : reservingRights // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      public: null == public
          ? _self.public
          : public // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
