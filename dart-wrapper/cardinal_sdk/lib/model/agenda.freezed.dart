// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'agenda.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Agenda {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  int? get daySplitHour;
  bool get unpublished;
  String? get name;
  String? get userId;
  String? get zoneId;
  List<Right> get rights;
  Map<String, UserAccessLevel> get userRights;
  AgendaSlottingAlgorithm? get slottingAlgorithm;
  int? get publicBookingQuota;
  Set<DecryptedPropertyStub> get properties;
  List<ResourceGroupAllocationSchedule> get schedules;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AgendaCopyWith<Agenda> get copyWith =>
      _$AgendaCopyWithImpl<Agenda>(this as Agenda, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Agenda &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.daySplitHour, daySplitHour) ||
                other.daySplitHour == daySplitHour) &&
            (identical(other.unpublished, unpublished) ||
                other.unpublished == unpublished) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.zoneId, zoneId) || other.zoneId == zoneId) &&
            const DeepCollectionEquality().equals(other.rights, rights) &&
            const DeepCollectionEquality()
                .equals(other.userRights, userRights) &&
            (identical(other.slottingAlgorithm, slottingAlgorithm) ||
                other.slottingAlgorithm == slottingAlgorithm) &&
            (identical(other.publicBookingQuota, publicBookingQuota) ||
                other.publicBookingQuota == publicBookingQuota) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            const DeepCollectionEquality().equals(other.schedules, schedules));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        daySplitHour,
        unpublished,
        name,
        userId,
        zoneId,
        const DeepCollectionEquality().hash(rights),
        const DeepCollectionEquality().hash(userRights),
        slottingAlgorithm,
        publicBookingQuota,
        const DeepCollectionEquality().hash(properties),
        const DeepCollectionEquality().hash(schedules)
      ]);

  @override
  String toString() {
    return 'Agenda(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, daySplitHour: $daySplitHour, unpublished: $unpublished, name: $name, userId: $userId, zoneId: $zoneId, rights: $rights, userRights: $userRights, slottingAlgorithm: $slottingAlgorithm, publicBookingQuota: $publicBookingQuota, properties: $properties, schedules: $schedules)';
  }
}

/// @nodoc
abstract mixin class $AgendaCopyWith<$Res> {
  factory $AgendaCopyWith(Agenda value, $Res Function(Agenda) _then) =
      _$AgendaCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? daySplitHour,
      bool unpublished,
      String? name,
      String? userId,
      String? zoneId,
      List<Right> rights,
      Map<String, UserAccessLevel> userRights,
      AgendaSlottingAlgorithm? slottingAlgorithm,
      int? publicBookingQuota,
      Set<DecryptedPropertyStub> properties,
      List<ResourceGroupAllocationSchedule> schedules});
}

/// @nodoc
class _$AgendaCopyWithImpl<$Res> implements $AgendaCopyWith<$Res> {
  _$AgendaCopyWithImpl(this._self, this._then);

  final Agenda _self;
  final $Res Function(Agenda) _then;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? daySplitHour = freezed,
    Object? unpublished = null,
    Object? name = freezed,
    Object? userId = freezed,
    Object? zoneId = freezed,
    Object? rights = null,
    Object? userRights = null,
    Object? slottingAlgorithm = freezed,
    Object? publicBookingQuota = freezed,
    Object? properties = null,
    Object? schedules = null,
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
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      daySplitHour: freezed == daySplitHour
          ? _self.daySplitHour
          : daySplitHour // ignore: cast_nullable_to_non_nullable
              as int?,
      unpublished: null == unpublished
          ? _self.unpublished
          : unpublished // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      zoneId: freezed == zoneId
          ? _self.zoneId
          : zoneId // ignore: cast_nullable_to_non_nullable
              as String?,
      rights: null == rights
          ? _self.rights
          : rights // ignore: cast_nullable_to_non_nullable
              as List<Right>,
      userRights: null == userRights
          ? _self.userRights
          : userRights // ignore: cast_nullable_to_non_nullable
              as Map<String, UserAccessLevel>,
      slottingAlgorithm: freezed == slottingAlgorithm
          ? _self.slottingAlgorithm
          : slottingAlgorithm // ignore: cast_nullable_to_non_nullable
              as AgendaSlottingAlgorithm?,
      publicBookingQuota: freezed == publicBookingQuota
          ? _self.publicBookingQuota
          : publicBookingQuota // ignore: cast_nullable_to_non_nullable
              as int?,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      schedules: null == schedules
          ? _self.schedules
          : schedules // ignore: cast_nullable_to_non_nullable
              as List<ResourceGroupAllocationSchedule>,
    ));
  }
}

/// @nodoc

class _Agenda implements Agenda {
  const _Agenda(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.daySplitHour = null,
      this.unpublished = false,
      this.name = null,
      this.userId = null,
      this.zoneId = null,
      final List<Right> rights = const [],
      final Map<String, UserAccessLevel> userRights = const {},
      this.slottingAlgorithm = null,
      this.publicBookingQuota = null,
      final Set<DecryptedPropertyStub> properties = const {},
      final List<ResourceGroupAllocationSchedule> schedules = const []})
      : _tags = tags,
        _codes = codes,
        _rights = rights,
        _userRights = userRights,
        _properties = properties,
        _schedules = schedules;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? responsible;
  @override
  @JsonKey()
  final String? medicalLocationId;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final int? daySplitHour;
  @override
  @JsonKey()
  final bool unpublished;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? zoneId;
  final List<Right> _rights;
  @override
  @JsonKey()
  List<Right> get rights {
    if (_rights is EqualUnmodifiableListView) return _rights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_rights);
  }

  final Map<String, UserAccessLevel> _userRights;
  @override
  @JsonKey()
  Map<String, UserAccessLevel> get userRights {
    if (_userRights is EqualUnmodifiableMapView) return _userRights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_userRights);
  }

  @override
  @JsonKey()
  final AgendaSlottingAlgorithm? slottingAlgorithm;
  @override
  @JsonKey()
  final int? publicBookingQuota;
  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  final List<ResourceGroupAllocationSchedule> _schedules;
  @override
  @JsonKey()
  List<ResourceGroupAllocationSchedule> get schedules {
    if (_schedules is EqualUnmodifiableListView) return _schedules;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_schedules);
  }

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AgendaCopyWith<_Agenda> get copyWith =>
      __$AgendaCopyWithImpl<_Agenda>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Agenda &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.daySplitHour, daySplitHour) ||
                other.daySplitHour == daySplitHour) &&
            (identical(other.unpublished, unpublished) ||
                other.unpublished == unpublished) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.zoneId, zoneId) || other.zoneId == zoneId) &&
            const DeepCollectionEquality().equals(other._rights, _rights) &&
            const DeepCollectionEquality()
                .equals(other._userRights, _userRights) &&
            (identical(other.slottingAlgorithm, slottingAlgorithm) ||
                other.slottingAlgorithm == slottingAlgorithm) &&
            (identical(other.publicBookingQuota, publicBookingQuota) ||
                other.publicBookingQuota == publicBookingQuota) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            const DeepCollectionEquality()
                .equals(other._schedules, _schedules));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        daySplitHour,
        unpublished,
        name,
        userId,
        zoneId,
        const DeepCollectionEquality().hash(_rights),
        const DeepCollectionEquality().hash(_userRights),
        slottingAlgorithm,
        publicBookingQuota,
        const DeepCollectionEquality().hash(_properties),
        const DeepCollectionEquality().hash(_schedules)
      ]);

  @override
  String toString() {
    return 'Agenda(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, daySplitHour: $daySplitHour, unpublished: $unpublished, name: $name, userId: $userId, zoneId: $zoneId, rights: $rights, userRights: $userRights, slottingAlgorithm: $slottingAlgorithm, publicBookingQuota: $publicBookingQuota, properties: $properties, schedules: $schedules)';
  }
}

/// @nodoc
abstract mixin class _$AgendaCopyWith<$Res> implements $AgendaCopyWith<$Res> {
  factory _$AgendaCopyWith(_Agenda value, $Res Function(_Agenda) _then) =
      __$AgendaCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? daySplitHour,
      bool unpublished,
      String? name,
      String? userId,
      String? zoneId,
      List<Right> rights,
      Map<String, UserAccessLevel> userRights,
      AgendaSlottingAlgorithm? slottingAlgorithm,
      int? publicBookingQuota,
      Set<DecryptedPropertyStub> properties,
      List<ResourceGroupAllocationSchedule> schedules});
}

/// @nodoc
class __$AgendaCopyWithImpl<$Res> implements _$AgendaCopyWith<$Res> {
  __$AgendaCopyWithImpl(this._self, this._then);

  final _Agenda _self;
  final $Res Function(_Agenda) _then;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? daySplitHour = freezed,
    Object? unpublished = null,
    Object? name = freezed,
    Object? userId = freezed,
    Object? zoneId = freezed,
    Object? rights = null,
    Object? userRights = null,
    Object? slottingAlgorithm = freezed,
    Object? publicBookingQuota = freezed,
    Object? properties = null,
    Object? schedules = null,
  }) {
    return _then(_Agenda(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      daySplitHour: freezed == daySplitHour
          ? _self.daySplitHour
          : daySplitHour // ignore: cast_nullable_to_non_nullable
              as int?,
      unpublished: null == unpublished
          ? _self.unpublished
          : unpublished // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      zoneId: freezed == zoneId
          ? _self.zoneId
          : zoneId // ignore: cast_nullable_to_non_nullable
              as String?,
      rights: null == rights
          ? _self._rights
          : rights // ignore: cast_nullable_to_non_nullable
              as List<Right>,
      userRights: null == userRights
          ? _self._userRights
          : userRights // ignore: cast_nullable_to_non_nullable
              as Map<String, UserAccessLevel>,
      slottingAlgorithm: freezed == slottingAlgorithm
          ? _self.slottingAlgorithm
          : slottingAlgorithm // ignore: cast_nullable_to_non_nullable
              as AgendaSlottingAlgorithm?,
      publicBookingQuota: freezed == publicBookingQuota
          ? _self.publicBookingQuota
          : publicBookingQuota // ignore: cast_nullable_to_non_nullable
              as int?,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      schedules: null == schedules
          ? _self._schedules
          : schedules // ignore: cast_nullable_to_non_nullable
              as List<ResourceGroupAllocationSchedule>,
    ));
  }
}

// dart format on
