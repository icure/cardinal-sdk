// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'calendar_item_type.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CalendarItemType {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get healthcarePartyId;
  String? get agendaId;
  bool get defaultCalendarItemType;
  String? get name;
  String? get color;
  int get duration;
  CalendarItemTypeDurationConfig? get extraDurationsConfig;
  String? get externalRef;
  String? get mikronoId;
  Set<String> get docIds;
  Map<String, String> get otherInfos;
  Map<String, String> get subjectByLanguage;
  Set<DecryptedPropertyStub>? get publicProperties;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CalendarItemTypeCopyWith<CalendarItemType> get copyWith =>
      _$CalendarItemTypeCopyWithImpl<CalendarItemType>(
          this as CalendarItemType, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CalendarItemType &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(
                    other.defaultCalendarItemType, defaultCalendarItemType) ||
                other.defaultCalendarItemType == defaultCalendarItemType) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.color, color) || other.color == color) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.extraDurationsConfig, extraDurationsConfig) ||
                other.extraDurationsConfig == extraDurationsConfig) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            (identical(other.mikronoId, mikronoId) ||
                other.mikronoId == mikronoId) &&
            const DeepCollectionEquality().equals(other.docIds, docIds) &&
            const DeepCollectionEquality()
                .equals(other.otherInfos, otherInfos) &&
            const DeepCollectionEquality()
                .equals(other.subjectByLanguage, subjectByLanguage) &&
            const DeepCollectionEquality()
                .equals(other.publicProperties, publicProperties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      healthcarePartyId,
      agendaId,
      defaultCalendarItemType,
      name,
      color,
      duration,
      extraDurationsConfig,
      externalRef,
      mikronoId,
      const DeepCollectionEquality().hash(docIds),
      const DeepCollectionEquality().hash(otherInfos),
      const DeepCollectionEquality().hash(subjectByLanguage),
      const DeepCollectionEquality().hash(publicProperties));

  @override
  String toString() {
    return 'CalendarItemType(id: $id, rev: $rev, deletionDate: $deletionDate, healthcarePartyId: $healthcarePartyId, agendaId: $agendaId, defaultCalendarItemType: $defaultCalendarItemType, name: $name, color: $color, duration: $duration, extraDurationsConfig: $extraDurationsConfig, externalRef: $externalRef, mikronoId: $mikronoId, docIds: $docIds, otherInfos: $otherInfos, subjectByLanguage: $subjectByLanguage, publicProperties: $publicProperties)';
  }
}

/// @nodoc
abstract mixin class $CalendarItemTypeCopyWith<$Res> {
  factory $CalendarItemTypeCopyWith(
          CalendarItemType value, $Res Function(CalendarItemType) _then) =
      _$CalendarItemTypeCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? healthcarePartyId,
      String? agendaId,
      bool defaultCalendarItemType,
      String? name,
      String? color,
      int duration,
      CalendarItemTypeDurationConfig? extraDurationsConfig,
      String? externalRef,
      String? mikronoId,
      Set<String> docIds,
      Map<String, String> otherInfos,
      Map<String, String> subjectByLanguage,
      Set<DecryptedPropertyStub>? publicProperties});
}

/// @nodoc
class _$CalendarItemTypeCopyWithImpl<$Res>
    implements $CalendarItemTypeCopyWith<$Res> {
  _$CalendarItemTypeCopyWithImpl(this._self, this._then);

  final CalendarItemType _self;
  final $Res Function(CalendarItemType) _then;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? healthcarePartyId = freezed,
    Object? agendaId = freezed,
    Object? defaultCalendarItemType = null,
    Object? name = freezed,
    Object? color = freezed,
    Object? duration = null,
    Object? extraDurationsConfig = freezed,
    Object? externalRef = freezed,
    Object? mikronoId = freezed,
    Object? docIds = null,
    Object? otherInfos = null,
    Object? subjectByLanguage = null,
    Object? publicProperties = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultCalendarItemType: null == defaultCalendarItemType
          ? _self.defaultCalendarItemType
          : defaultCalendarItemType // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      color: freezed == color
          ? _self.color
          : color // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: null == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int,
      extraDurationsConfig: freezed == extraDurationsConfig
          ? _self.extraDurationsConfig
          : extraDurationsConfig // ignore: cast_nullable_to_non_nullable
              as CalendarItemTypeDurationConfig?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      mikronoId: freezed == mikronoId
          ? _self.mikronoId
          : mikronoId // ignore: cast_nullable_to_non_nullable
              as String?,
      docIds: null == docIds
          ? _self.docIds
          : docIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      otherInfos: null == otherInfos
          ? _self.otherInfos
          : otherInfos // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      subjectByLanguage: null == subjectByLanguage
          ? _self.subjectByLanguage
          : subjectByLanguage // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      publicProperties: freezed == publicProperties
          ? _self.publicProperties
          : publicProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

/// @nodoc

class _CalendarItemType implements CalendarItemType {
  const _CalendarItemType(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.healthcarePartyId = null,
      this.agendaId = null,
      this.defaultCalendarItemType = false,
      this.name = null,
      this.color = null,
      this.duration = 0,
      this.extraDurationsConfig = null,
      this.externalRef = null,
      this.mikronoId = null,
      final Set<String> docIds = const {},
      final Map<String, String> otherInfos = const {},
      final Map<String, String> subjectByLanguage = const {},
      final Set<DecryptedPropertyStub>? publicProperties = null})
      : _docIds = docIds,
        _otherInfos = otherInfos,
        _subjectByLanguage = subjectByLanguage,
        _publicProperties = publicProperties;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? agendaId;
  @override
  @JsonKey()
  final bool defaultCalendarItemType;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? color;
  @override
  @JsonKey()
  final int duration;
  @override
  @JsonKey()
  final CalendarItemTypeDurationConfig? extraDurationsConfig;
  @override
  @JsonKey()
  final String? externalRef;
  @override
  @JsonKey()
  final String? mikronoId;
  final Set<String> _docIds;
  @override
  @JsonKey()
  Set<String> get docIds {
    if (_docIds is EqualUnmodifiableSetView) return _docIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_docIds);
  }

  final Map<String, String> _otherInfos;
  @override
  @JsonKey()
  Map<String, String> get otherInfos {
    if (_otherInfos is EqualUnmodifiableMapView) return _otherInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_otherInfos);
  }

  final Map<String, String> _subjectByLanguage;
  @override
  @JsonKey()
  Map<String, String> get subjectByLanguage {
    if (_subjectByLanguage is EqualUnmodifiableMapView)
      return _subjectByLanguage;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_subjectByLanguage);
  }

  final Set<DecryptedPropertyStub>? _publicProperties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub>? get publicProperties {
    final value = _publicProperties;
    if (value == null) return null;
    if (_publicProperties is EqualUnmodifiableSetView) return _publicProperties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CalendarItemTypeCopyWith<_CalendarItemType> get copyWith =>
      __$CalendarItemTypeCopyWithImpl<_CalendarItemType>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CalendarItemType &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(
                    other.defaultCalendarItemType, defaultCalendarItemType) ||
                other.defaultCalendarItemType == defaultCalendarItemType) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.color, color) || other.color == color) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.extraDurationsConfig, extraDurationsConfig) ||
                other.extraDurationsConfig == extraDurationsConfig) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            (identical(other.mikronoId, mikronoId) ||
                other.mikronoId == mikronoId) &&
            const DeepCollectionEquality().equals(other._docIds, _docIds) &&
            const DeepCollectionEquality()
                .equals(other._otherInfos, _otherInfos) &&
            const DeepCollectionEquality()
                .equals(other._subjectByLanguage, _subjectByLanguage) &&
            const DeepCollectionEquality()
                .equals(other._publicProperties, _publicProperties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      healthcarePartyId,
      agendaId,
      defaultCalendarItemType,
      name,
      color,
      duration,
      extraDurationsConfig,
      externalRef,
      mikronoId,
      const DeepCollectionEquality().hash(_docIds),
      const DeepCollectionEquality().hash(_otherInfos),
      const DeepCollectionEquality().hash(_subjectByLanguage),
      const DeepCollectionEquality().hash(_publicProperties));

  @override
  String toString() {
    return 'CalendarItemType(id: $id, rev: $rev, deletionDate: $deletionDate, healthcarePartyId: $healthcarePartyId, agendaId: $agendaId, defaultCalendarItemType: $defaultCalendarItemType, name: $name, color: $color, duration: $duration, extraDurationsConfig: $extraDurationsConfig, externalRef: $externalRef, mikronoId: $mikronoId, docIds: $docIds, otherInfos: $otherInfos, subjectByLanguage: $subjectByLanguage, publicProperties: $publicProperties)';
  }
}

/// @nodoc
abstract mixin class _$CalendarItemTypeCopyWith<$Res>
    implements $CalendarItemTypeCopyWith<$Res> {
  factory _$CalendarItemTypeCopyWith(
          _CalendarItemType value, $Res Function(_CalendarItemType) _then) =
      __$CalendarItemTypeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? healthcarePartyId,
      String? agendaId,
      bool defaultCalendarItemType,
      String? name,
      String? color,
      int duration,
      CalendarItemTypeDurationConfig? extraDurationsConfig,
      String? externalRef,
      String? mikronoId,
      Set<String> docIds,
      Map<String, String> otherInfos,
      Map<String, String> subjectByLanguage,
      Set<DecryptedPropertyStub>? publicProperties});
}

/// @nodoc
class __$CalendarItemTypeCopyWithImpl<$Res>
    implements _$CalendarItemTypeCopyWith<$Res> {
  __$CalendarItemTypeCopyWithImpl(this._self, this._then);

  final _CalendarItemType _self;
  final $Res Function(_CalendarItemType) _then;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? healthcarePartyId = freezed,
    Object? agendaId = freezed,
    Object? defaultCalendarItemType = null,
    Object? name = freezed,
    Object? color = freezed,
    Object? duration = null,
    Object? extraDurationsConfig = freezed,
    Object? externalRef = freezed,
    Object? mikronoId = freezed,
    Object? docIds = null,
    Object? otherInfos = null,
    Object? subjectByLanguage = null,
    Object? publicProperties = freezed,
  }) {
    return _then(_CalendarItemType(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultCalendarItemType: null == defaultCalendarItemType
          ? _self.defaultCalendarItemType
          : defaultCalendarItemType // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      color: freezed == color
          ? _self.color
          : color // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: null == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int,
      extraDurationsConfig: freezed == extraDurationsConfig
          ? _self.extraDurationsConfig
          : extraDurationsConfig // ignore: cast_nullable_to_non_nullable
              as CalendarItemTypeDurationConfig?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      mikronoId: freezed == mikronoId
          ? _self.mikronoId
          : mikronoId // ignore: cast_nullable_to_non_nullable
              as String?,
      docIds: null == docIds
          ? _self._docIds
          : docIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      otherInfos: null == otherInfos
          ? _self._otherInfos
          : otherInfos // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      subjectByLanguage: null == subjectByLanguage
          ? _self._subjectByLanguage
          : subjectByLanguage // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      publicProperties: freezed == publicProperties
          ? _self._publicProperties
          : publicProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

/// @nodoc
mixin _$CalendarItemTypeDurationConfigSet {
  Set<int> get durations;

  /// Create a copy of CalendarItemTypeDurationConfigSet
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CalendarItemTypeDurationConfigSetCopyWith<CalendarItemTypeDurationConfigSet>
      get copyWith => _$CalendarItemTypeDurationConfigSetCopyWithImpl<
              CalendarItemTypeDurationConfigSet>(
          this as CalendarItemTypeDurationConfigSet, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CalendarItemTypeDurationConfigSet &&
            const DeepCollectionEquality().equals(other.durations, durations));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(durations));

  @override
  String toString() {
    return 'CalendarItemTypeDurationConfigSet(durations: $durations)';
  }
}

/// @nodoc
abstract mixin class $CalendarItemTypeDurationConfigSetCopyWith<$Res> {
  factory $CalendarItemTypeDurationConfigSetCopyWith(
          CalendarItemTypeDurationConfigSet value,
          $Res Function(CalendarItemTypeDurationConfigSet) _then) =
      _$CalendarItemTypeDurationConfigSetCopyWithImpl;
  @useResult
  $Res call({Set<int> durations});
}

/// @nodoc
class _$CalendarItemTypeDurationConfigSetCopyWithImpl<$Res>
    implements $CalendarItemTypeDurationConfigSetCopyWith<$Res> {
  _$CalendarItemTypeDurationConfigSetCopyWithImpl(this._self, this._then);

  final CalendarItemTypeDurationConfigSet _self;
  final $Res Function(CalendarItemTypeDurationConfigSet) _then;

  /// Create a copy of CalendarItemTypeDurationConfigSet
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? durations = null,
  }) {
    return _then(_self.copyWith(
      durations: null == durations
          ? _self.durations
          : durations // ignore: cast_nullable_to_non_nullable
              as Set<int>,
    ));
  }
}

/// @nodoc

class _CalendarItemTypeDurationConfigSet
    implements CalendarItemTypeDurationConfigSet {
  const _CalendarItemTypeDurationConfigSet(
      {final Set<int> durations = const {}})
      : _durations = durations;

  final Set<int> _durations;
  @override
  @JsonKey()
  Set<int> get durations {
    if (_durations is EqualUnmodifiableSetView) return _durations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_durations);
  }

  /// Create a copy of CalendarItemTypeDurationConfigSet
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CalendarItemTypeDurationConfigSetCopyWith<
          _CalendarItemTypeDurationConfigSet>
      get copyWith => __$CalendarItemTypeDurationConfigSetCopyWithImpl<
          _CalendarItemTypeDurationConfigSet>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CalendarItemTypeDurationConfigSet &&
            const DeepCollectionEquality()
                .equals(other._durations, _durations));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(_durations));

  @override
  String toString() {
    return 'CalendarItemTypeDurationConfigSet(durations: $durations)';
  }
}

/// @nodoc
abstract mixin class _$CalendarItemTypeDurationConfigSetCopyWith<$Res>
    implements $CalendarItemTypeDurationConfigSetCopyWith<$Res> {
  factory _$CalendarItemTypeDurationConfigSetCopyWith(
          _CalendarItemTypeDurationConfigSet value,
          $Res Function(_CalendarItemTypeDurationConfigSet) _then) =
      __$CalendarItemTypeDurationConfigSetCopyWithImpl;
  @override
  @useResult
  $Res call({Set<int> durations});
}

/// @nodoc
class __$CalendarItemTypeDurationConfigSetCopyWithImpl<$Res>
    implements _$CalendarItemTypeDurationConfigSetCopyWith<$Res> {
  __$CalendarItemTypeDurationConfigSetCopyWithImpl(this._self, this._then);

  final _CalendarItemTypeDurationConfigSet _self;
  final $Res Function(_CalendarItemTypeDurationConfigSet) _then;

  /// Create a copy of CalendarItemTypeDurationConfigSet
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? durations = null,
  }) {
    return _then(_CalendarItemTypeDurationConfigSet(
      durations: null == durations
          ? _self._durations
          : durations // ignore: cast_nullable_to_non_nullable
              as Set<int>,
    ));
  }
}

/// @nodoc
mixin _$CalendarItemTypeDurationConfigFormula {
  int get min;
  int get max;
  int get step;

  /// Create a copy of CalendarItemTypeDurationConfigFormula
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CalendarItemTypeDurationConfigFormulaCopyWith<
          CalendarItemTypeDurationConfigFormula>
      get copyWith => _$CalendarItemTypeDurationConfigFormulaCopyWithImpl<
              CalendarItemTypeDurationConfigFormula>(
          this as CalendarItemTypeDurationConfigFormula, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CalendarItemTypeDurationConfigFormula &&
            (identical(other.min, min) || other.min == min) &&
            (identical(other.max, max) || other.max == max) &&
            (identical(other.step, step) || other.step == step));
  }

  @override
  int get hashCode => Object.hash(runtimeType, min, max, step);

  @override
  String toString() {
    return 'CalendarItemTypeDurationConfigFormula(min: $min, max: $max, step: $step)';
  }
}

/// @nodoc
abstract mixin class $CalendarItemTypeDurationConfigFormulaCopyWith<$Res> {
  factory $CalendarItemTypeDurationConfigFormulaCopyWith(
          CalendarItemTypeDurationConfigFormula value,
          $Res Function(CalendarItemTypeDurationConfigFormula) _then) =
      _$CalendarItemTypeDurationConfigFormulaCopyWithImpl;
  @useResult
  $Res call({int min, int max, int step});
}

/// @nodoc
class _$CalendarItemTypeDurationConfigFormulaCopyWithImpl<$Res>
    implements $CalendarItemTypeDurationConfigFormulaCopyWith<$Res> {
  _$CalendarItemTypeDurationConfigFormulaCopyWithImpl(this._self, this._then);

  final CalendarItemTypeDurationConfigFormula _self;
  final $Res Function(CalendarItemTypeDurationConfigFormula) _then;

  /// Create a copy of CalendarItemTypeDurationConfigFormula
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? min = null,
    Object? max = null,
    Object? step = null,
  }) {
    return _then(_self.copyWith(
      min: null == min
          ? _self.min
          : min // ignore: cast_nullable_to_non_nullable
              as int,
      max: null == max
          ? _self.max
          : max // ignore: cast_nullable_to_non_nullable
              as int,
      step: null == step
          ? _self.step
          : step // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _CalendarItemTypeDurationConfigFormula
    implements CalendarItemTypeDurationConfigFormula {
  const _CalendarItemTypeDurationConfigFormula(
      {required this.min, required this.max, required this.step});

  @override
  final int min;
  @override
  final int max;
  @override
  final int step;

  /// Create a copy of CalendarItemTypeDurationConfigFormula
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CalendarItemTypeDurationConfigFormulaCopyWith<
          _CalendarItemTypeDurationConfigFormula>
      get copyWith => __$CalendarItemTypeDurationConfigFormulaCopyWithImpl<
          _CalendarItemTypeDurationConfigFormula>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CalendarItemTypeDurationConfigFormula &&
            (identical(other.min, min) || other.min == min) &&
            (identical(other.max, max) || other.max == max) &&
            (identical(other.step, step) || other.step == step));
  }

  @override
  int get hashCode => Object.hash(runtimeType, min, max, step);

  @override
  String toString() {
    return 'CalendarItemTypeDurationConfigFormula(min: $min, max: $max, step: $step)';
  }
}

/// @nodoc
abstract mixin class _$CalendarItemTypeDurationConfigFormulaCopyWith<$Res>
    implements $CalendarItemTypeDurationConfigFormulaCopyWith<$Res> {
  factory _$CalendarItemTypeDurationConfigFormulaCopyWith(
          _CalendarItemTypeDurationConfigFormula value,
          $Res Function(_CalendarItemTypeDurationConfigFormula) _then) =
      __$CalendarItemTypeDurationConfigFormulaCopyWithImpl;
  @override
  @useResult
  $Res call({int min, int max, int step});
}

/// @nodoc
class __$CalendarItemTypeDurationConfigFormulaCopyWithImpl<$Res>
    implements _$CalendarItemTypeDurationConfigFormulaCopyWith<$Res> {
  __$CalendarItemTypeDurationConfigFormulaCopyWithImpl(this._self, this._then);

  final _CalendarItemTypeDurationConfigFormula _self;
  final $Res Function(_CalendarItemTypeDurationConfigFormula) _then;

  /// Create a copy of CalendarItemTypeDurationConfigFormula
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? min = null,
    Object? max = null,
    Object? step = null,
  }) {
    return _then(_CalendarItemTypeDurationConfigFormula(
      min: null == min
          ? _self.min
          : min // ignore: cast_nullable_to_non_nullable
              as int,
      max: null == max
          ? _self.max
          : max // ignore: cast_nullable_to_non_nullable
              as int,
      step: null == step
          ? _self.step
          : step // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
