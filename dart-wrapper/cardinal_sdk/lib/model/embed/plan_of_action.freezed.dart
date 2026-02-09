// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'plan_of_action.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedPlanOfAction {
  String get id;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  String? get prescriberId;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  int? get deadlineDate;
  String? get name;
  String? get descr;
  String? get note;
  String? get idOpeningContact;
  String? get idClosingContact;
  int get status;
  Set<String> get documentIds;
  int? get numberOfCares;
  List<EncryptedCareTeamMembership> get careTeamMemberships;
  bool get relevant;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedPlanOfActionCopyWith<EncryptedPlanOfAction> get copyWith =>
      _$EncryptedPlanOfActionCopyWithImpl<EncryptedPlanOfAction>(
          this as EncryptedPlanOfAction, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedPlanOfAction &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.prescriberId, prescriberId) ||
                other.prescriberId == prescriberId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.deadlineDate, deadlineDate) ||
                other.deadlineDate == deadlineDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other.documentIds, documentIds) &&
            (identical(other.numberOfCares, numberOfCares) ||
                other.numberOfCares == numberOfCares) &&
            const DeepCollectionEquality()
                .equals(other.careTeamMemberships, careTeamMemberships) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        prescriberId,
        valueDate,
        openingDate,
        closingDate,
        deadlineDate,
        name,
        descr,
        note,
        idOpeningContact,
        idClosingContact,
        status,
        const DeepCollectionEquality().hash(documentIds),
        numberOfCares,
        const DeepCollectionEquality().hash(careTeamMemberships),
        relevant,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedPlanOfAction(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, prescriberId: $prescriberId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, deadlineDate: $deadlineDate, name: $name, descr: $descr, note: $note, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, status: $status, documentIds: $documentIds, numberOfCares: $numberOfCares, careTeamMemberships: $careTeamMemberships, relevant: $relevant, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedPlanOfActionCopyWith<$Res> {
  factory $EncryptedPlanOfActionCopyWith(EncryptedPlanOfAction value,
          $Res Function(EncryptedPlanOfAction) _then) =
      _$EncryptedPlanOfActionCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? prescriberId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      int? deadlineDate,
      String? name,
      String? descr,
      String? note,
      String? idOpeningContact,
      String? idClosingContact,
      int status,
      Set<String> documentIds,
      int? numberOfCares,
      List<EncryptedCareTeamMembership> careTeamMemberships,
      bool relevant,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedPlanOfActionCopyWithImpl<$Res>
    implements $EncryptedPlanOfActionCopyWith<$Res> {
  _$EncryptedPlanOfActionCopyWithImpl(this._self, this._then);

  final EncryptedPlanOfAction _self;
  final $Res Function(EncryptedPlanOfAction) _then;

  /// Create a copy of EncryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? prescriberId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? deadlineDate = freezed,
    Object? name = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? status = null,
    Object? documentIds = null,
    Object? numberOfCares = freezed,
    Object? careTeamMemberships = null,
    Object? relevant = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
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
      prescriberId: freezed == prescriberId
          ? _self.prescriberId
          : prescriberId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      deadlineDate: freezed == deadlineDate
          ? _self.deadlineDate
          : deadlineDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      documentIds: null == documentIds
          ? _self.documentIds
          : documentIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      numberOfCares: freezed == numberOfCares
          ? _self.numberOfCares
          : numberOfCares // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberships: null == careTeamMemberships
          ? _self.careTeamMemberships
          : careTeamMemberships // ignore: cast_nullable_to_non_nullable
              as List<EncryptedCareTeamMembership>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedPlanOfAction implements EncryptedPlanOfAction {
  const _EncryptedPlanOfAction(
      {required this.id,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.prescriberId = null,
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.deadlineDate = null,
      this.name = null,
      this.descr = null,
      this.note = null,
      this.idOpeningContact = null,
      this.idClosingContact = null,
      this.status = 0,
      final Set<String> documentIds = const {},
      this.numberOfCares = null,
      final List<EncryptedCareTeamMembership> careTeamMemberships = const [],
      this.relevant = true,
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _documentIds = documentIds,
        _careTeamMemberships = careTeamMemberships;

  @override
  final String id;
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
  final String? prescriberId;
  @override
  @JsonKey()
  final int? valueDate;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final int? deadlineDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? note;
  @override
  @JsonKey()
  final String? idOpeningContact;
  @override
  @JsonKey()
  final String? idClosingContact;
  @override
  @JsonKey()
  final int status;
  final Set<String> _documentIds;
  @override
  @JsonKey()
  Set<String> get documentIds {
    if (_documentIds is EqualUnmodifiableSetView) return _documentIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_documentIds);
  }

  @override
  @JsonKey()
  final int? numberOfCares;
  final List<EncryptedCareTeamMembership> _careTeamMemberships;
  @override
  @JsonKey()
  List<EncryptedCareTeamMembership> get careTeamMemberships {
    if (_careTeamMemberships is EqualUnmodifiableListView)
      return _careTeamMemberships;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_careTeamMemberships);
  }

  @override
  @JsonKey()
  final bool relevant;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedPlanOfActionCopyWith<_EncryptedPlanOfAction> get copyWith =>
      __$EncryptedPlanOfActionCopyWithImpl<_EncryptedPlanOfAction>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedPlanOfAction &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.prescriberId, prescriberId) ||
                other.prescriberId == prescriberId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.deadlineDate, deadlineDate) ||
                other.deadlineDate == deadlineDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other._documentIds, _documentIds) &&
            (identical(other.numberOfCares, numberOfCares) ||
                other.numberOfCares == numberOfCares) &&
            const DeepCollectionEquality()
                .equals(other._careTeamMemberships, _careTeamMemberships) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        prescriberId,
        valueDate,
        openingDate,
        closingDate,
        deadlineDate,
        name,
        descr,
        note,
        idOpeningContact,
        idClosingContact,
        status,
        const DeepCollectionEquality().hash(_documentIds),
        numberOfCares,
        const DeepCollectionEquality().hash(_careTeamMemberships),
        relevant,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedPlanOfAction(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, prescriberId: $prescriberId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, deadlineDate: $deadlineDate, name: $name, descr: $descr, note: $note, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, status: $status, documentIds: $documentIds, numberOfCares: $numberOfCares, careTeamMemberships: $careTeamMemberships, relevant: $relevant, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedPlanOfActionCopyWith<$Res>
    implements $EncryptedPlanOfActionCopyWith<$Res> {
  factory _$EncryptedPlanOfActionCopyWith(_EncryptedPlanOfAction value,
          $Res Function(_EncryptedPlanOfAction) _then) =
      __$EncryptedPlanOfActionCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? prescriberId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      int? deadlineDate,
      String? name,
      String? descr,
      String? note,
      String? idOpeningContact,
      String? idClosingContact,
      int status,
      Set<String> documentIds,
      int? numberOfCares,
      List<EncryptedCareTeamMembership> careTeamMemberships,
      bool relevant,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedPlanOfActionCopyWithImpl<$Res>
    implements _$EncryptedPlanOfActionCopyWith<$Res> {
  __$EncryptedPlanOfActionCopyWithImpl(this._self, this._then);

  final _EncryptedPlanOfAction _self;
  final $Res Function(_EncryptedPlanOfAction) _then;

  /// Create a copy of EncryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? prescriberId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? deadlineDate = freezed,
    Object? name = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? status = null,
    Object? documentIds = null,
    Object? numberOfCares = freezed,
    Object? careTeamMemberships = null,
    Object? relevant = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedPlanOfAction(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
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
      prescriberId: freezed == prescriberId
          ? _self.prescriberId
          : prescriberId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      deadlineDate: freezed == deadlineDate
          ? _self.deadlineDate
          : deadlineDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      documentIds: null == documentIds
          ? _self._documentIds
          : documentIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      numberOfCares: freezed == numberOfCares
          ? _self.numberOfCares
          : numberOfCares // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberships: null == careTeamMemberships
          ? _self._careTeamMemberships
          : careTeamMemberships // ignore: cast_nullable_to_non_nullable
              as List<EncryptedCareTeamMembership>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedPlanOfAction {
  String get id;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  String? get prescriberId;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  int? get deadlineDate;
  String? get name;
  String? get descr;
  String? get note;
  String? get idOpeningContact;
  String? get idClosingContact;
  int get status;
  Set<String> get documentIds;
  int? get numberOfCares;
  List<DecryptedCareTeamMembership> get careTeamMemberships;
  bool get relevant;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedPlanOfActionCopyWith<DecryptedPlanOfAction> get copyWith =>
      _$DecryptedPlanOfActionCopyWithImpl<DecryptedPlanOfAction>(
          this as DecryptedPlanOfAction, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedPlanOfAction &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.prescriberId, prescriberId) ||
                other.prescriberId == prescriberId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.deadlineDate, deadlineDate) ||
                other.deadlineDate == deadlineDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other.documentIds, documentIds) &&
            (identical(other.numberOfCares, numberOfCares) ||
                other.numberOfCares == numberOfCares) &&
            const DeepCollectionEquality()
                .equals(other.careTeamMemberships, careTeamMemberships) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        prescriberId,
        valueDate,
        openingDate,
        closingDate,
        deadlineDate,
        name,
        descr,
        note,
        idOpeningContact,
        idClosingContact,
        status,
        const DeepCollectionEquality().hash(documentIds),
        numberOfCares,
        const DeepCollectionEquality().hash(careTeamMemberships),
        relevant,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedPlanOfAction(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, prescriberId: $prescriberId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, deadlineDate: $deadlineDate, name: $name, descr: $descr, note: $note, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, status: $status, documentIds: $documentIds, numberOfCares: $numberOfCares, careTeamMemberships: $careTeamMemberships, relevant: $relevant, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedPlanOfActionCopyWith<$Res> {
  factory $DecryptedPlanOfActionCopyWith(DecryptedPlanOfAction value,
          $Res Function(DecryptedPlanOfAction) _then) =
      _$DecryptedPlanOfActionCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? prescriberId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      int? deadlineDate,
      String? name,
      String? descr,
      String? note,
      String? idOpeningContact,
      String? idClosingContact,
      int status,
      Set<String> documentIds,
      int? numberOfCares,
      List<DecryptedCareTeamMembership> careTeamMemberships,
      bool relevant,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedPlanOfActionCopyWithImpl<$Res>
    implements $DecryptedPlanOfActionCopyWith<$Res> {
  _$DecryptedPlanOfActionCopyWithImpl(this._self, this._then);

  final DecryptedPlanOfAction _self;
  final $Res Function(DecryptedPlanOfAction) _then;

  /// Create a copy of DecryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? prescriberId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? deadlineDate = freezed,
    Object? name = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? status = null,
    Object? documentIds = null,
    Object? numberOfCares = freezed,
    Object? careTeamMemberships = null,
    Object? relevant = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
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
      prescriberId: freezed == prescriberId
          ? _self.prescriberId
          : prescriberId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      deadlineDate: freezed == deadlineDate
          ? _self.deadlineDate
          : deadlineDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      documentIds: null == documentIds
          ? _self.documentIds
          : documentIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      numberOfCares: freezed == numberOfCares
          ? _self.numberOfCares
          : numberOfCares // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberships: null == careTeamMemberships
          ? _self.careTeamMemberships
          : careTeamMemberships // ignore: cast_nullable_to_non_nullable
              as List<DecryptedCareTeamMembership>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedPlanOfAction implements DecryptedPlanOfAction {
  const _DecryptedPlanOfAction(
      {required this.id,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.prescriberId = null,
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.deadlineDate = null,
      this.name = null,
      this.descr = null,
      this.note = null,
      this.idOpeningContact = null,
      this.idClosingContact = null,
      this.status = 0,
      final Set<String> documentIds = const {},
      this.numberOfCares = null,
      final List<DecryptedCareTeamMembership> careTeamMemberships = const [],
      this.relevant = true,
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _documentIds = documentIds,
        _careTeamMemberships = careTeamMemberships;

  @override
  final String id;
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
  final String? prescriberId;
  @override
  @JsonKey()
  final int? valueDate;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final int? deadlineDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? note;
  @override
  @JsonKey()
  final String? idOpeningContact;
  @override
  @JsonKey()
  final String? idClosingContact;
  @override
  @JsonKey()
  final int status;
  final Set<String> _documentIds;
  @override
  @JsonKey()
  Set<String> get documentIds {
    if (_documentIds is EqualUnmodifiableSetView) return _documentIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_documentIds);
  }

  @override
  @JsonKey()
  final int? numberOfCares;
  final List<DecryptedCareTeamMembership> _careTeamMemberships;
  @override
  @JsonKey()
  List<DecryptedCareTeamMembership> get careTeamMemberships {
    if (_careTeamMemberships is EqualUnmodifiableListView)
      return _careTeamMemberships;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_careTeamMemberships);
  }

  @override
  @JsonKey()
  final bool relevant;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedPlanOfActionCopyWith<_DecryptedPlanOfAction> get copyWith =>
      __$DecryptedPlanOfActionCopyWithImpl<_DecryptedPlanOfAction>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedPlanOfAction &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.prescriberId, prescriberId) ||
                other.prescriberId == prescriberId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.deadlineDate, deadlineDate) ||
                other.deadlineDate == deadlineDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other._documentIds, _documentIds) &&
            (identical(other.numberOfCares, numberOfCares) ||
                other.numberOfCares == numberOfCares) &&
            const DeepCollectionEquality()
                .equals(other._careTeamMemberships, _careTeamMemberships) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        prescriberId,
        valueDate,
        openingDate,
        closingDate,
        deadlineDate,
        name,
        descr,
        note,
        idOpeningContact,
        idClosingContact,
        status,
        const DeepCollectionEquality().hash(_documentIds),
        numberOfCares,
        const DeepCollectionEquality().hash(_careTeamMemberships),
        relevant,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedPlanOfAction(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, prescriberId: $prescriberId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, deadlineDate: $deadlineDate, name: $name, descr: $descr, note: $note, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, status: $status, documentIds: $documentIds, numberOfCares: $numberOfCares, careTeamMemberships: $careTeamMemberships, relevant: $relevant, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedPlanOfActionCopyWith<$Res>
    implements $DecryptedPlanOfActionCopyWith<$Res> {
  factory _$DecryptedPlanOfActionCopyWith(_DecryptedPlanOfAction value,
          $Res Function(_DecryptedPlanOfAction) _then) =
      __$DecryptedPlanOfActionCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? prescriberId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      int? deadlineDate,
      String? name,
      String? descr,
      String? note,
      String? idOpeningContact,
      String? idClosingContact,
      int status,
      Set<String> documentIds,
      int? numberOfCares,
      List<DecryptedCareTeamMembership> careTeamMemberships,
      bool relevant,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedPlanOfActionCopyWithImpl<$Res>
    implements _$DecryptedPlanOfActionCopyWith<$Res> {
  __$DecryptedPlanOfActionCopyWithImpl(this._self, this._then);

  final _DecryptedPlanOfAction _self;
  final $Res Function(_DecryptedPlanOfAction) _then;

  /// Create a copy of DecryptedPlanOfAction
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? prescriberId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? deadlineDate = freezed,
    Object? name = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? status = null,
    Object? documentIds = null,
    Object? numberOfCares = freezed,
    Object? careTeamMemberships = null,
    Object? relevant = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedPlanOfAction(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
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
      prescriberId: freezed == prescriberId
          ? _self.prescriberId
          : prescriberId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      deadlineDate: freezed == deadlineDate
          ? _self.deadlineDate
          : deadlineDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      documentIds: null == documentIds
          ? _self._documentIds
          : documentIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      numberOfCares: freezed == numberOfCares
          ? _self.numberOfCares
          : numberOfCares // ignore: cast_nullable_to_non_nullable
              as int?,
      careTeamMemberships: null == careTeamMemberships
          ? _self._careTeamMemberships
          : careTeamMemberships // ignore: cast_nullable_to_non_nullable
              as List<DecryptedCareTeamMembership>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
