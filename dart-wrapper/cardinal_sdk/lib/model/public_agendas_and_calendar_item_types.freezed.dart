// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'public_agendas_and_calendar_item_types.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$PublicAgendasAndCalendarItemTypes {
  List<Agenda> get agendas;
  List<CalendarItemType> get calendarItemTypes;

  /// Create a copy of PublicAgendasAndCalendarItemTypes
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PublicAgendasAndCalendarItemTypesCopyWith<PublicAgendasAndCalendarItemTypes>
      get copyWith => _$PublicAgendasAndCalendarItemTypesCopyWithImpl<
              PublicAgendasAndCalendarItemTypes>(
          this as PublicAgendasAndCalendarItemTypes, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is PublicAgendasAndCalendarItemTypes &&
            const DeepCollectionEquality().equals(other.agendas, agendas) &&
            const DeepCollectionEquality()
                .equals(other.calendarItemTypes, calendarItemTypes));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(agendas),
      const DeepCollectionEquality().hash(calendarItemTypes));

  @override
  String toString() {
    return 'PublicAgendasAndCalendarItemTypes(agendas: $agendas, calendarItemTypes: $calendarItemTypes)';
  }
}

/// @nodoc
abstract mixin class $PublicAgendasAndCalendarItemTypesCopyWith<$Res> {
  factory $PublicAgendasAndCalendarItemTypesCopyWith(
          PublicAgendasAndCalendarItemTypes value,
          $Res Function(PublicAgendasAndCalendarItemTypes) _then) =
      _$PublicAgendasAndCalendarItemTypesCopyWithImpl;
  @useResult
  $Res call({List<Agenda> agendas, List<CalendarItemType> calendarItemTypes});
}

/// @nodoc
class _$PublicAgendasAndCalendarItemTypesCopyWithImpl<$Res>
    implements $PublicAgendasAndCalendarItemTypesCopyWith<$Res> {
  _$PublicAgendasAndCalendarItemTypesCopyWithImpl(this._self, this._then);

  final PublicAgendasAndCalendarItemTypes _self;
  final $Res Function(PublicAgendasAndCalendarItemTypes) _then;

  /// Create a copy of PublicAgendasAndCalendarItemTypes
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? agendas = null,
    Object? calendarItemTypes = null,
  }) {
    return _then(_self.copyWith(
      agendas: null == agendas
          ? _self.agendas
          : agendas // ignore: cast_nullable_to_non_nullable
              as List<Agenda>,
      calendarItemTypes: null == calendarItemTypes
          ? _self.calendarItemTypes
          : calendarItemTypes // ignore: cast_nullable_to_non_nullable
              as List<CalendarItemType>,
    ));
  }
}

/// @nodoc

class _PublicAgendasAndCalendarItemTypes
    implements PublicAgendasAndCalendarItemTypes {
  const _PublicAgendasAndCalendarItemTypes(
      {required final List<Agenda> agendas,
      required final List<CalendarItemType> calendarItemTypes})
      : _agendas = agendas,
        _calendarItemTypes = calendarItemTypes;

  final List<Agenda> _agendas;
  @override
  List<Agenda> get agendas {
    if (_agendas is EqualUnmodifiableListView) return _agendas;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_agendas);
  }

  final List<CalendarItemType> _calendarItemTypes;
  @override
  List<CalendarItemType> get calendarItemTypes {
    if (_calendarItemTypes is EqualUnmodifiableListView)
      return _calendarItemTypes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_calendarItemTypes);
  }

  /// Create a copy of PublicAgendasAndCalendarItemTypes
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PublicAgendasAndCalendarItemTypesCopyWith<
          _PublicAgendasAndCalendarItemTypes>
      get copyWith => __$PublicAgendasAndCalendarItemTypesCopyWithImpl<
          _PublicAgendasAndCalendarItemTypes>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _PublicAgendasAndCalendarItemTypes &&
            const DeepCollectionEquality().equals(other._agendas, _agendas) &&
            const DeepCollectionEquality()
                .equals(other._calendarItemTypes, _calendarItemTypes));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_agendas),
      const DeepCollectionEquality().hash(_calendarItemTypes));

  @override
  String toString() {
    return 'PublicAgendasAndCalendarItemTypes(agendas: $agendas, calendarItemTypes: $calendarItemTypes)';
  }
}

/// @nodoc
abstract mixin class _$PublicAgendasAndCalendarItemTypesCopyWith<$Res>
    implements $PublicAgendasAndCalendarItemTypesCopyWith<$Res> {
  factory _$PublicAgendasAndCalendarItemTypesCopyWith(
          _PublicAgendasAndCalendarItemTypes value,
          $Res Function(_PublicAgendasAndCalendarItemTypes) _then) =
      __$PublicAgendasAndCalendarItemTypesCopyWithImpl;
  @override
  @useResult
  $Res call({List<Agenda> agendas, List<CalendarItemType> calendarItemTypes});
}

/// @nodoc
class __$PublicAgendasAndCalendarItemTypesCopyWithImpl<$Res>
    implements _$PublicAgendasAndCalendarItemTypesCopyWith<$Res> {
  __$PublicAgendasAndCalendarItemTypesCopyWithImpl(this._self, this._then);

  final _PublicAgendasAndCalendarItemTypes _self;
  final $Res Function(_PublicAgendasAndCalendarItemTypes) _then;

  /// Create a copy of PublicAgendasAndCalendarItemTypes
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? agendas = null,
    Object? calendarItemTypes = null,
  }) {
    return _then(_PublicAgendasAndCalendarItemTypes(
      agendas: null == agendas
          ? _self._agendas
          : agendas // ignore: cast_nullable_to_non_nullable
              as List<Agenda>,
      calendarItemTypes: null == calendarItemTypes
          ? _self._calendarItemTypes
          : calendarItemTypes // ignore: cast_nullable_to_non_nullable
              as List<CalendarItemType>,
    ));
  }
}

// dart format on
