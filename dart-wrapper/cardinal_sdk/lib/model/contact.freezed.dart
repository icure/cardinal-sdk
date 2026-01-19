// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'contact.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedContact {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  List<Identifier> get identifier;
  int? get endOfLife;
  int? get deletionDate;
  String? get groupId;
  int? get openingDate;
  int? get closingDate;
  String? get descr;
  String? get location;
  String? get externalId;
  CodeStub? get encounterType;
  DecryptedAddress? get encounterLocation;
  Set<DecryptedSubContact> get subContacts;
  Set<DecryptedService> get services;
  Map<ParticipantType, String> get participants;
  List<ContactParticipant> get participantList;
  String? get healthcarePartyId;
  String? get modifiedContactId;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  List<Annotation> get notes;

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedContactCopyWith<DecryptedContact> get copyWith =>
      _$DecryptedContactCopyWithImpl<DecryptedContact>(
          this as DecryptedContact, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedContact &&
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
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.encounterType, encounterType) ||
                other.encounterType == encounterType) &&
            (identical(other.encounterLocation, encounterLocation) ||
                other.encounterLocation == encounterLocation) &&
            const DeepCollectionEquality()
                .equals(other.subContacts, subContacts) &&
            const DeepCollectionEquality().equals(other.services, services) &&
            const DeepCollectionEquality()
                .equals(other.participants, participants) &&
            const DeepCollectionEquality()
                .equals(other.participantList, participantList) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.modifiedContactId, modifiedContactId) ||
                other.modifiedContactId == modifiedContactId) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other.notes, notes));
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
        const DeepCollectionEquality().hash(identifier),
        endOfLife,
        deletionDate,
        groupId,
        openingDate,
        closingDate,
        descr,
        location,
        externalId,
        encounterType,
        encounterLocation,
        const DeepCollectionEquality().hash(subContacts),
        const DeepCollectionEquality().hash(services),
        const DeepCollectionEquality().hash(participants),
        const DeepCollectionEquality().hash(participantList),
        healthcarePartyId,
        modifiedContactId,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(notes)
      ]);

  @override
  String toString() {
    return 'DecryptedContact(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, identifier: $identifier, endOfLife: $endOfLife, deletionDate: $deletionDate, groupId: $groupId, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, location: $location, externalId: $externalId, encounterType: $encounterType, encounterLocation: $encounterLocation, subContacts: $subContacts, services: $services, participants: $participants, participantList: $participantList, healthcarePartyId: $healthcarePartyId, modifiedContactId: $modifiedContactId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, notes: $notes)';
  }
}

/// @nodoc
abstract mixin class $DecryptedContactCopyWith<$Res> {
  factory $DecryptedContactCopyWith(
          DecryptedContact value, $Res Function(DecryptedContact) _then) =
      _$DecryptedContactCopyWithImpl;
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
      List<Identifier> identifier,
      int? endOfLife,
      int? deletionDate,
      String? groupId,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? location,
      String? externalId,
      CodeStub? encounterType,
      DecryptedAddress? encounterLocation,
      Set<DecryptedSubContact> subContacts,
      Set<DecryptedService> services,
      Map<ParticipantType, String> participants,
      List<ContactParticipant> participantList,
      String? healthcarePartyId,
      String? modifiedContactId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      List<Annotation> notes});

  $CodeStubCopyWith<$Res>? get encounterType;
  $DecryptedAddressCopyWith<$Res>? get encounterLocation;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedContactCopyWithImpl<$Res>
    implements $DecryptedContactCopyWith<$Res> {
  _$DecryptedContactCopyWithImpl(this._self, this._then);

  final DecryptedContact _self;
  final $Res Function(DecryptedContact) _then;

  /// Create a copy of DecryptedContact
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
    Object? identifier = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? groupId = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? location = freezed,
    Object? externalId = freezed,
    Object? encounterType = freezed,
    Object? encounterLocation = freezed,
    Object? subContacts = null,
    Object? services = null,
    Object? participants = null,
    Object? participantList = null,
    Object? healthcarePartyId = freezed,
    Object? modifiedContactId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? notes = null,
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
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterType: freezed == encounterType
          ? _self.encounterType
          : encounterType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encounterLocation: freezed == encounterLocation
          ? _self.encounterLocation
          : encounterLocation // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      subContacts: null == subContacts
          ? _self.subContacts
          : subContacts // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedSubContact>,
      services: null == services
          ? _self.services
          : services // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedService>,
      participants: null == participants
          ? _self.participants
          : participants // ignore: cast_nullable_to_non_nullable
              as Map<ParticipantType, String>,
      participantList: null == participantList
          ? _self.participantList
          : participantList // ignore: cast_nullable_to_non_nullable
              as List<ContactParticipant>,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      modifiedContactId: freezed == modifiedContactId
          ? _self.modifiedContactId
          : modifiedContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self.cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self.delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self.encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
    ));
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get encounterType {
    if (_self.encounterType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.encounterType!, (value) {
      return _then(_self.copyWith(encounterType: value));
    });
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get encounterLocation {
    if (_self.encounterLocation == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.encounterLocation!, (value) {
      return _then(_self.copyWith(encounterLocation: value));
    });
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc

class _DecryptedContact implements DecryptedContact {
  const _DecryptedContact(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      final List<Identifier> identifier = const [],
      this.endOfLife = null,
      this.deletionDate = null,
      this.groupId = null,
      this.openingDate = null,
      this.closingDate = null,
      this.descr = null,
      this.location = null,
      this.externalId = null,
      this.encounterType = null,
      this.encounterLocation = null,
      final Set<DecryptedSubContact> subContacts = const {},
      final Set<DecryptedService> services = const {},
      final Map<ParticipantType, String> participants = const {},
      final List<ContactParticipant> participantList = const [],
      this.healthcarePartyId = null,
      this.modifiedContactId = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      final List<Annotation> notes = const []})
      : _tags = tags,
        _codes = codes,
        _identifier = identifier,
        _subContacts = subContacts,
        _services = services,
        _participants = participants,
        _participantList = participantList,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _notes = notes;

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

  final List<Identifier> _identifier;
  @override
  @JsonKey()
  List<Identifier> get identifier {
    if (_identifier is EqualUnmodifiableListView) return _identifier;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifier);
  }

  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? location;
  @override
  @JsonKey()
  final String? externalId;
  @override
  @JsonKey()
  final CodeStub? encounterType;
  @override
  @JsonKey()
  final DecryptedAddress? encounterLocation;
  final Set<DecryptedSubContact> _subContacts;
  @override
  @JsonKey()
  Set<DecryptedSubContact> get subContacts {
    if (_subContacts is EqualUnmodifiableSetView) return _subContacts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_subContacts);
  }

  final Set<DecryptedService> _services;
  @override
  @JsonKey()
  Set<DecryptedService> get services {
    if (_services is EqualUnmodifiableSetView) return _services;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_services);
  }

  final Map<ParticipantType, String> _participants;
  @override
  @JsonKey()
  Map<ParticipantType, String> get participants {
    if (_participants is EqualUnmodifiableMapView) return _participants;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_participants);
  }

  final List<ContactParticipant> _participantList;
  @override
  @JsonKey()
  List<ContactParticipant> get participantList {
    if (_participantList is EqualUnmodifiableListView) return _participantList;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_participantList);
  }

  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? modifiedContactId;
  final Set<String> _secretForeignKeys;
  @override
  @JsonKey()
  Set<String> get secretForeignKeys {
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretForeignKeys);
  }

  final Map<String, Set<Delegation>> _cryptedForeignKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get cryptedForeignKeys {
    if (_cryptedForeignKeys is EqualUnmodifiableMapView)
      return _cryptedForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_cryptedForeignKeys);
  }

  final Map<String, Set<Delegation>> _delegations;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get delegations {
    if (_delegations is EqualUnmodifiableMapView) return _delegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_delegations);
  }

  final Map<String, Set<Delegation>> _encryptionKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableMapView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptionKeys);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedContactCopyWith<_DecryptedContact> get copyWith =>
      __$DecryptedContactCopyWithImpl<_DecryptedContact>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedContact &&
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
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.encounterType, encounterType) ||
                other.encounterType == encounterType) &&
            (identical(other.encounterLocation, encounterLocation) ||
                other.encounterLocation == encounterLocation) &&
            const DeepCollectionEquality()
                .equals(other._subContacts, _subContacts) &&
            const DeepCollectionEquality().equals(other._services, _services) &&
            const DeepCollectionEquality()
                .equals(other._participants, _participants) &&
            const DeepCollectionEquality()
                .equals(other._participantList, _participantList) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.modifiedContactId, modifiedContactId) ||
                other.modifiedContactId == modifiedContactId) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other._notes, _notes));
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
        const DeepCollectionEquality().hash(_identifier),
        endOfLife,
        deletionDate,
        groupId,
        openingDate,
        closingDate,
        descr,
        location,
        externalId,
        encounterType,
        encounterLocation,
        const DeepCollectionEquality().hash(_subContacts),
        const DeepCollectionEquality().hash(_services),
        const DeepCollectionEquality().hash(_participants),
        const DeepCollectionEquality().hash(_participantList),
        healthcarePartyId,
        modifiedContactId,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(_notes)
      ]);

  @override
  String toString() {
    return 'DecryptedContact(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, identifier: $identifier, endOfLife: $endOfLife, deletionDate: $deletionDate, groupId: $groupId, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, location: $location, externalId: $externalId, encounterType: $encounterType, encounterLocation: $encounterLocation, subContacts: $subContacts, services: $services, participants: $participants, participantList: $participantList, healthcarePartyId: $healthcarePartyId, modifiedContactId: $modifiedContactId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, notes: $notes)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedContactCopyWith<$Res>
    implements $DecryptedContactCopyWith<$Res> {
  factory _$DecryptedContactCopyWith(
          _DecryptedContact value, $Res Function(_DecryptedContact) _then) =
      __$DecryptedContactCopyWithImpl;
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
      List<Identifier> identifier,
      int? endOfLife,
      int? deletionDate,
      String? groupId,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? location,
      String? externalId,
      CodeStub? encounterType,
      DecryptedAddress? encounterLocation,
      Set<DecryptedSubContact> subContacts,
      Set<DecryptedService> services,
      Map<ParticipantType, String> participants,
      List<ContactParticipant> participantList,
      String? healthcarePartyId,
      String? modifiedContactId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      List<Annotation> notes});

  @override
  $CodeStubCopyWith<$Res>? get encounterType;
  @override
  $DecryptedAddressCopyWith<$Res>? get encounterLocation;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedContactCopyWithImpl<$Res>
    implements _$DecryptedContactCopyWith<$Res> {
  __$DecryptedContactCopyWithImpl(this._self, this._then);

  final _DecryptedContact _self;
  final $Res Function(_DecryptedContact) _then;

  /// Create a copy of DecryptedContact
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
    Object? identifier = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? groupId = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? location = freezed,
    Object? externalId = freezed,
    Object? encounterType = freezed,
    Object? encounterLocation = freezed,
    Object? subContacts = null,
    Object? services = null,
    Object? participants = null,
    Object? participantList = null,
    Object? healthcarePartyId = freezed,
    Object? modifiedContactId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? notes = null,
  }) {
    return _then(_DecryptedContact(
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
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterType: freezed == encounterType
          ? _self.encounterType
          : encounterType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encounterLocation: freezed == encounterLocation
          ? _self.encounterLocation
          : encounterLocation // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      subContacts: null == subContacts
          ? _self._subContacts
          : subContacts // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedSubContact>,
      services: null == services
          ? _self._services
          : services // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedService>,
      participants: null == participants
          ? _self._participants
          : participants // ignore: cast_nullable_to_non_nullable
              as Map<ParticipantType, String>,
      participantList: null == participantList
          ? _self._participantList
          : participantList // ignore: cast_nullable_to_non_nullable
              as List<ContactParticipant>,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      modifiedContactId: freezed == modifiedContactId
          ? _self.modifiedContactId
          : modifiedContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self._cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self._delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self._encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
    ));
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get encounterType {
    if (_self.encounterType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.encounterType!, (value) {
      return _then(_self.copyWith(encounterType: value));
    });
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get encounterLocation {
    if (_self.encounterLocation == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.encounterLocation!, (value) {
      return _then(_self.copyWith(encounterLocation: value));
    });
  }

  /// Create a copy of DecryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc
mixin _$EncryptedContact {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  List<Identifier> get identifier;
  int? get endOfLife;
  int? get deletionDate;
  String? get groupId;
  int? get openingDate;
  int? get closingDate;
  String? get descr;
  String? get location;
  String? get externalId;
  CodeStub? get encounterType;
  EncryptedAddress? get encounterLocation;
  Set<EncryptedSubContact> get subContacts;
  Set<EncryptedService> get services;
  Map<ParticipantType, String> get participants;
  List<ContactParticipant> get participantList;
  String? get healthcarePartyId;
  String? get modifiedContactId;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  List<Annotation> get notes;

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedContactCopyWith<EncryptedContact> get copyWith =>
      _$EncryptedContactCopyWithImpl<EncryptedContact>(
          this as EncryptedContact, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedContact &&
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
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.encounterType, encounterType) ||
                other.encounterType == encounterType) &&
            (identical(other.encounterLocation, encounterLocation) ||
                other.encounterLocation == encounterLocation) &&
            const DeepCollectionEquality()
                .equals(other.subContacts, subContacts) &&
            const DeepCollectionEquality().equals(other.services, services) &&
            const DeepCollectionEquality()
                .equals(other.participants, participants) &&
            const DeepCollectionEquality()
                .equals(other.participantList, participantList) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.modifiedContactId, modifiedContactId) ||
                other.modifiedContactId == modifiedContactId) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other.notes, notes));
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
        const DeepCollectionEquality().hash(identifier),
        endOfLife,
        deletionDate,
        groupId,
        openingDate,
        closingDate,
        descr,
        location,
        externalId,
        encounterType,
        encounterLocation,
        const DeepCollectionEquality().hash(subContacts),
        const DeepCollectionEquality().hash(services),
        const DeepCollectionEquality().hash(participants),
        const DeepCollectionEquality().hash(participantList),
        healthcarePartyId,
        modifiedContactId,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(notes)
      ]);

  @override
  String toString() {
    return 'EncryptedContact(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, identifier: $identifier, endOfLife: $endOfLife, deletionDate: $deletionDate, groupId: $groupId, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, location: $location, externalId: $externalId, encounterType: $encounterType, encounterLocation: $encounterLocation, subContacts: $subContacts, services: $services, participants: $participants, participantList: $participantList, healthcarePartyId: $healthcarePartyId, modifiedContactId: $modifiedContactId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, notes: $notes)';
  }
}

/// @nodoc
abstract mixin class $EncryptedContactCopyWith<$Res> {
  factory $EncryptedContactCopyWith(
          EncryptedContact value, $Res Function(EncryptedContact) _then) =
      _$EncryptedContactCopyWithImpl;
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
      List<Identifier> identifier,
      int? endOfLife,
      int? deletionDate,
      String? groupId,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? location,
      String? externalId,
      CodeStub? encounterType,
      EncryptedAddress? encounterLocation,
      Set<EncryptedSubContact> subContacts,
      Set<EncryptedService> services,
      Map<ParticipantType, String> participants,
      List<ContactParticipant> participantList,
      String? healthcarePartyId,
      String? modifiedContactId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      List<Annotation> notes});

  $CodeStubCopyWith<$Res>? get encounterType;
  $EncryptedAddressCopyWith<$Res>? get encounterLocation;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedContactCopyWithImpl<$Res>
    implements $EncryptedContactCopyWith<$Res> {
  _$EncryptedContactCopyWithImpl(this._self, this._then);

  final EncryptedContact _self;
  final $Res Function(EncryptedContact) _then;

  /// Create a copy of EncryptedContact
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
    Object? identifier = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? groupId = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? location = freezed,
    Object? externalId = freezed,
    Object? encounterType = freezed,
    Object? encounterLocation = freezed,
    Object? subContacts = null,
    Object? services = null,
    Object? participants = null,
    Object? participantList = null,
    Object? healthcarePartyId = freezed,
    Object? modifiedContactId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? notes = null,
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
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterType: freezed == encounterType
          ? _self.encounterType
          : encounterType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encounterLocation: freezed == encounterLocation
          ? _self.encounterLocation
          : encounterLocation // ignore: cast_nullable_to_non_nullable
              as EncryptedAddress?,
      subContacts: null == subContacts
          ? _self.subContacts
          : subContacts // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedSubContact>,
      services: null == services
          ? _self.services
          : services // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedService>,
      participants: null == participants
          ? _self.participants
          : participants // ignore: cast_nullable_to_non_nullable
              as Map<ParticipantType, String>,
      participantList: null == participantList
          ? _self.participantList
          : participantList // ignore: cast_nullable_to_non_nullable
              as List<ContactParticipant>,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      modifiedContactId: freezed == modifiedContactId
          ? _self.modifiedContactId
          : modifiedContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self.cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self.delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self.encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
    ));
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get encounterType {
    if (_self.encounterType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.encounterType!, (value) {
      return _then(_self.copyWith(encounterType: value));
    });
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedAddressCopyWith<$Res>? get encounterLocation {
    if (_self.encounterLocation == null) {
      return null;
    }

    return $EncryptedAddressCopyWith<$Res>(_self.encounterLocation!, (value) {
      return _then(_self.copyWith(encounterLocation: value));
    });
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc

class _EncryptedContact implements EncryptedContact {
  const _EncryptedContact(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      final List<Identifier> identifier = const [],
      this.endOfLife = null,
      this.deletionDate = null,
      this.groupId = null,
      this.openingDate = null,
      this.closingDate = null,
      this.descr = null,
      this.location = null,
      this.externalId = null,
      this.encounterType = null,
      this.encounterLocation = null,
      final Set<EncryptedSubContact> subContacts = const {},
      final Set<EncryptedService> services = const {},
      final Map<ParticipantType, String> participants = const {},
      final List<ContactParticipant> participantList = const [],
      this.healthcarePartyId = null,
      this.modifiedContactId = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      final List<Annotation> notes = const []})
      : _tags = tags,
        _codes = codes,
        _identifier = identifier,
        _subContacts = subContacts,
        _services = services,
        _participants = participants,
        _participantList = participantList,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _notes = notes;

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

  final List<Identifier> _identifier;
  @override
  @JsonKey()
  List<Identifier> get identifier {
    if (_identifier is EqualUnmodifiableListView) return _identifier;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifier);
  }

  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? location;
  @override
  @JsonKey()
  final String? externalId;
  @override
  @JsonKey()
  final CodeStub? encounterType;
  @override
  @JsonKey()
  final EncryptedAddress? encounterLocation;
  final Set<EncryptedSubContact> _subContacts;
  @override
  @JsonKey()
  Set<EncryptedSubContact> get subContacts {
    if (_subContacts is EqualUnmodifiableSetView) return _subContacts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_subContacts);
  }

  final Set<EncryptedService> _services;
  @override
  @JsonKey()
  Set<EncryptedService> get services {
    if (_services is EqualUnmodifiableSetView) return _services;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_services);
  }

  final Map<ParticipantType, String> _participants;
  @override
  @JsonKey()
  Map<ParticipantType, String> get participants {
    if (_participants is EqualUnmodifiableMapView) return _participants;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_participants);
  }

  final List<ContactParticipant> _participantList;
  @override
  @JsonKey()
  List<ContactParticipant> get participantList {
    if (_participantList is EqualUnmodifiableListView) return _participantList;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_participantList);
  }

  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? modifiedContactId;
  final Set<String> _secretForeignKeys;
  @override
  @JsonKey()
  Set<String> get secretForeignKeys {
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretForeignKeys);
  }

  final Map<String, Set<Delegation>> _cryptedForeignKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get cryptedForeignKeys {
    if (_cryptedForeignKeys is EqualUnmodifiableMapView)
      return _cryptedForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_cryptedForeignKeys);
  }

  final Map<String, Set<Delegation>> _delegations;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get delegations {
    if (_delegations is EqualUnmodifiableMapView) return _delegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_delegations);
  }

  final Map<String, Set<Delegation>> _encryptionKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableMapView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptionKeys);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedContactCopyWith<_EncryptedContact> get copyWith =>
      __$EncryptedContactCopyWithImpl<_EncryptedContact>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedContact &&
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
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.encounterType, encounterType) ||
                other.encounterType == encounterType) &&
            (identical(other.encounterLocation, encounterLocation) ||
                other.encounterLocation == encounterLocation) &&
            const DeepCollectionEquality()
                .equals(other._subContacts, _subContacts) &&
            const DeepCollectionEquality().equals(other._services, _services) &&
            const DeepCollectionEquality()
                .equals(other._participants, _participants) &&
            const DeepCollectionEquality()
                .equals(other._participantList, _participantList) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.modifiedContactId, modifiedContactId) ||
                other.modifiedContactId == modifiedContactId) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other._notes, _notes));
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
        const DeepCollectionEquality().hash(_identifier),
        endOfLife,
        deletionDate,
        groupId,
        openingDate,
        closingDate,
        descr,
        location,
        externalId,
        encounterType,
        encounterLocation,
        const DeepCollectionEquality().hash(_subContacts),
        const DeepCollectionEquality().hash(_services),
        const DeepCollectionEquality().hash(_participants),
        const DeepCollectionEquality().hash(_participantList),
        healthcarePartyId,
        modifiedContactId,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(_notes)
      ]);

  @override
  String toString() {
    return 'EncryptedContact(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, identifier: $identifier, endOfLife: $endOfLife, deletionDate: $deletionDate, groupId: $groupId, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, location: $location, externalId: $externalId, encounterType: $encounterType, encounterLocation: $encounterLocation, subContacts: $subContacts, services: $services, participants: $participants, participantList: $participantList, healthcarePartyId: $healthcarePartyId, modifiedContactId: $modifiedContactId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, notes: $notes)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedContactCopyWith<$Res>
    implements $EncryptedContactCopyWith<$Res> {
  factory _$EncryptedContactCopyWith(
          _EncryptedContact value, $Res Function(_EncryptedContact) _then) =
      __$EncryptedContactCopyWithImpl;
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
      List<Identifier> identifier,
      int? endOfLife,
      int? deletionDate,
      String? groupId,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? location,
      String? externalId,
      CodeStub? encounterType,
      EncryptedAddress? encounterLocation,
      Set<EncryptedSubContact> subContacts,
      Set<EncryptedService> services,
      Map<ParticipantType, String> participants,
      List<ContactParticipant> participantList,
      String? healthcarePartyId,
      String? modifiedContactId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      List<Annotation> notes});

  @override
  $CodeStubCopyWith<$Res>? get encounterType;
  @override
  $EncryptedAddressCopyWith<$Res>? get encounterLocation;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedContactCopyWithImpl<$Res>
    implements _$EncryptedContactCopyWith<$Res> {
  __$EncryptedContactCopyWithImpl(this._self, this._then);

  final _EncryptedContact _self;
  final $Res Function(_EncryptedContact) _then;

  /// Create a copy of EncryptedContact
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
    Object? identifier = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? groupId = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? location = freezed,
    Object? externalId = freezed,
    Object? encounterType = freezed,
    Object? encounterLocation = freezed,
    Object? subContacts = null,
    Object? services = null,
    Object? participants = null,
    Object? participantList = null,
    Object? healthcarePartyId = freezed,
    Object? modifiedContactId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? notes = null,
  }) {
    return _then(_EncryptedContact(
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
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterType: freezed == encounterType
          ? _self.encounterType
          : encounterType // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      encounterLocation: freezed == encounterLocation
          ? _self.encounterLocation
          : encounterLocation // ignore: cast_nullable_to_non_nullable
              as EncryptedAddress?,
      subContacts: null == subContacts
          ? _self._subContacts
          : subContacts // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedSubContact>,
      services: null == services
          ? _self._services
          : services // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedService>,
      participants: null == participants
          ? _self._participants
          : participants // ignore: cast_nullable_to_non_nullable
              as Map<ParticipantType, String>,
      participantList: null == participantList
          ? _self._participantList
          : participantList // ignore: cast_nullable_to_non_nullable
              as List<ContactParticipant>,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      modifiedContactId: freezed == modifiedContactId
          ? _self.modifiedContactId
          : modifiedContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self._cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self._delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self._encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
    ));
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get encounterType {
    if (_self.encounterType == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.encounterType!, (value) {
      return _then(_self.copyWith(encounterType: value));
    });
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedAddressCopyWith<$Res>? get encounterLocation {
    if (_self.encounterLocation == null) {
      return null;
    }

    return $EncryptedAddressCopyWith<$Res>(_self.encounterLocation!, (value) {
      return _then(_self.copyWith(encounterLocation: value));
    });
  }

  /// Create a copy of EncryptedContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

// dart format on
