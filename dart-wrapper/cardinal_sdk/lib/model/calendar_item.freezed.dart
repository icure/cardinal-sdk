// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'calendar_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedCalendarItem {
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
  String? get title;
  String? get calendarItemTypeId;
  String? get masterCalendarItemId;
  String? get patientId;
  bool? get important;
  bool? get homeVisit;
  String? get phoneNumber;
  String? get placeId;
  DecryptedAddress? get address;
  String? get addressText;
  int? get startTime;
  int? get endTime;
  int? get confirmationTime;
  int? get cancellationTimestamp;
  String? get confirmationId;
  int? get duration;
  bool? get allDay;
  String? get details;
  bool? get wasMigrated;
  String? get agendaId;
  CodeStub? get resourceGroup;
  CalendarItemAvailabilitiesAssignmentStrategy?
      get availabilitiesAssignmentStrategy;
  String? get hcpId;
  String? get recurrenceId;
  Set<DecryptedCalendarItemTag> get meetingTags;
  FlowItem? get flowItem;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedCalendarItemCopyWith<DecryptedCalendarItem> get copyWith =>
      _$DecryptedCalendarItemCopyWithImpl<DecryptedCalendarItem>(
          this as DecryptedCalendarItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedCalendarItem &&
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
            (identical(other.title, title) || other.title == title) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.masterCalendarItemId, masterCalendarItemId) ||
                other.masterCalendarItemId == masterCalendarItemId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.important, important) ||
                other.important == important) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.address, address) || other.address == address) &&
            (identical(other.addressText, addressText) ||
                other.addressText == addressText) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            (identical(other.confirmationTime, confirmationTime) ||
                other.confirmationTime == confirmationTime) &&
            (identical(other.cancellationTimestamp, cancellationTimestamp) ||
                other.cancellationTimestamp == cancellationTimestamp) &&
            (identical(other.confirmationId, confirmationId) ||
                other.confirmationId == confirmationId) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.allDay, allDay) || other.allDay == allDay) &&
            (identical(other.details, details) || other.details == details) &&
            (identical(other.wasMigrated, wasMigrated) ||
                other.wasMigrated == wasMigrated) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            (identical(other.availabilitiesAssignmentStrategy,
                    availabilitiesAssignmentStrategy) ||
                other.availabilitiesAssignmentStrategy ==
                    availabilitiesAssignmentStrategy) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.recurrenceId, recurrenceId) ||
                other.recurrenceId == recurrenceId) &&
            const DeepCollectionEquality()
                .equals(other.meetingTags, meetingTags) &&
            (identical(other.flowItem, flowItem) ||
                other.flowItem == flowItem) &&
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
                other.securityMetadata == securityMetadata));
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
        title,
        calendarItemTypeId,
        masterCalendarItemId,
        patientId,
        important,
        homeVisit,
        phoneNumber,
        placeId,
        address,
        addressText,
        startTime,
        endTime,
        confirmationTime,
        cancellationTimestamp,
        confirmationId,
        duration,
        allDay,
        details,
        wasMigrated,
        agendaId,
        resourceGroup,
        availabilitiesAssignmentStrategy,
        hcpId,
        recurrenceId,
        const DeepCollectionEquality().hash(meetingTags),
        flowItem,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedCalendarItem(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, title: $title, calendarItemTypeId: $calendarItemTypeId, masterCalendarItemId: $masterCalendarItemId, patientId: $patientId, important: $important, homeVisit: $homeVisit, phoneNumber: $phoneNumber, placeId: $placeId, address: $address, addressText: $addressText, startTime: $startTime, endTime: $endTime, confirmationTime: $confirmationTime, cancellationTimestamp: $cancellationTimestamp, confirmationId: $confirmationId, duration: $duration, allDay: $allDay, details: $details, wasMigrated: $wasMigrated, agendaId: $agendaId, resourceGroup: $resourceGroup, availabilitiesAssignmentStrategy: $availabilitiesAssignmentStrategy, hcpId: $hcpId, recurrenceId: $recurrenceId, meetingTags: $meetingTags, flowItem: $flowItem, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedCalendarItemCopyWith<$Res> {
  factory $DecryptedCalendarItemCopyWith(DecryptedCalendarItem value,
          $Res Function(DecryptedCalendarItem) _then) =
      _$DecryptedCalendarItemCopyWithImpl;
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
      String? title,
      String? calendarItemTypeId,
      String? masterCalendarItemId,
      String? patientId,
      bool? important,
      bool? homeVisit,
      String? phoneNumber,
      String? placeId,
      DecryptedAddress? address,
      String? addressText,
      int? startTime,
      int? endTime,
      int? confirmationTime,
      int? cancellationTimestamp,
      String? confirmationId,
      int? duration,
      bool? allDay,
      String? details,
      bool? wasMigrated,
      String? agendaId,
      CodeStub? resourceGroup,
      CalendarItemAvailabilitiesAssignmentStrategy?
          availabilitiesAssignmentStrategy,
      String? hcpId,
      String? recurrenceId,
      Set<DecryptedCalendarItemTag> meetingTags,
      FlowItem? flowItem,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $DecryptedAddressCopyWith<$Res>? get address;
  $CodeStubCopyWith<$Res>? get resourceGroup;
  $FlowItemCopyWith<$Res>? get flowItem;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedCalendarItemCopyWithImpl<$Res>
    implements $DecryptedCalendarItemCopyWith<$Res> {
  _$DecryptedCalendarItemCopyWithImpl(this._self, this._then);

  final DecryptedCalendarItem _self;
  final $Res Function(DecryptedCalendarItem) _then;

  /// Create a copy of DecryptedCalendarItem
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
    Object? title = freezed,
    Object? calendarItemTypeId = freezed,
    Object? masterCalendarItemId = freezed,
    Object? patientId = freezed,
    Object? important = freezed,
    Object? homeVisit = freezed,
    Object? phoneNumber = freezed,
    Object? placeId = freezed,
    Object? address = freezed,
    Object? addressText = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? confirmationTime = freezed,
    Object? cancellationTimestamp = freezed,
    Object? confirmationId = freezed,
    Object? duration = freezed,
    Object? allDay = freezed,
    Object? details = freezed,
    Object? wasMigrated = freezed,
    Object? agendaId = freezed,
    Object? resourceGroup = freezed,
    Object? availabilitiesAssignmentStrategy = freezed,
    Object? hcpId = freezed,
    Object? recurrenceId = freezed,
    Object? meetingTags = null,
    Object? flowItem = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
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
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      masterCalendarItemId: freezed == masterCalendarItemId
          ? _self.masterCalendarItemId
          : masterCalendarItemId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      important: freezed == important
          ? _self.important
          : important // ignore: cast_nullable_to_non_nullable
              as bool?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      addressText: freezed == addressText
          ? _self.addressText
          : addressText // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationTime: freezed == confirmationTime
          ? _self.confirmationTime
          : confirmationTime // ignore: cast_nullable_to_non_nullable
              as int?,
      cancellationTimestamp: freezed == cancellationTimestamp
          ? _self.cancellationTimestamp
          : cancellationTimestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationId: freezed == confirmationId
          ? _self.confirmationId
          : confirmationId // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int?,
      allDay: freezed == allDay
          ? _self.allDay
          : allDay // ignore: cast_nullable_to_non_nullable
              as bool?,
      details: freezed == details
          ? _self.details
          : details // ignore: cast_nullable_to_non_nullable
              as String?,
      wasMigrated: freezed == wasMigrated
          ? _self.wasMigrated
          : wasMigrated // ignore: cast_nullable_to_non_nullable
              as bool?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      availabilitiesAssignmentStrategy: freezed ==
              availabilitiesAssignmentStrategy
          ? _self.availabilitiesAssignmentStrategy
          : availabilitiesAssignmentStrategy // ignore: cast_nullable_to_non_nullable
              as CalendarItemAvailabilitiesAssignmentStrategy?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      recurrenceId: freezed == recurrenceId
          ? _self.recurrenceId
          : recurrenceId // ignore: cast_nullable_to_non_nullable
              as String?,
      meetingTags: null == meetingTags
          ? _self.meetingTags
          : meetingTags // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedCalendarItemTag>,
      flowItem: freezed == flowItem
          ? _self.flowItem
          : flowItem // ignore: cast_nullable_to_non_nullable
              as FlowItem?,
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
    ));
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FlowItemCopyWith<$Res>? get flowItem {
    if (_self.flowItem == null) {
      return null;
    }

    return $FlowItemCopyWith<$Res>(_self.flowItem!, (value) {
      return _then(_self.copyWith(flowItem: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
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

class _DecryptedCalendarItem implements DecryptedCalendarItem {
  const _DecryptedCalendarItem(
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
      this.title = null,
      this.calendarItemTypeId = null,
      this.masterCalendarItemId = null,
      this.patientId = null,
      this.important = null,
      this.homeVisit = null,
      this.phoneNumber = null,
      this.placeId = null,
      this.address = null,
      this.addressText = null,
      this.startTime = null,
      this.endTime = null,
      this.confirmationTime = null,
      this.cancellationTimestamp = null,
      this.confirmationId = null,
      this.duration = null,
      this.allDay = null,
      this.details = null,
      this.wasMigrated = null,
      this.agendaId = null,
      this.resourceGroup = null,
      this.availabilitiesAssignmentStrategy = null,
      this.hcpId = null,
      this.recurrenceId = null,
      final Set<DecryptedCalendarItemTag> meetingTags = const {},
      this.flowItem = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _meetingTags = meetingTags,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

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
  final String? title;
  @override
  @JsonKey()
  final String? calendarItemTypeId;
  @override
  @JsonKey()
  final String? masterCalendarItemId;
  @override
  @JsonKey()
  final String? patientId;
  @override
  @JsonKey()
  final bool? important;
  @override
  @JsonKey()
  final bool? homeVisit;
  @override
  @JsonKey()
  final String? phoneNumber;
  @override
  @JsonKey()
  final String? placeId;
  @override
  @JsonKey()
  final DecryptedAddress? address;
  @override
  @JsonKey()
  final String? addressText;
  @override
  @JsonKey()
  final int? startTime;
  @override
  @JsonKey()
  final int? endTime;
  @override
  @JsonKey()
  final int? confirmationTime;
  @override
  @JsonKey()
  final int? cancellationTimestamp;
  @override
  @JsonKey()
  final String? confirmationId;
  @override
  @JsonKey()
  final int? duration;
  @override
  @JsonKey()
  final bool? allDay;
  @override
  @JsonKey()
  final String? details;
  @override
  @JsonKey()
  final bool? wasMigrated;
  @override
  @JsonKey()
  final String? agendaId;
  @override
  @JsonKey()
  final CodeStub? resourceGroup;
  @override
  @JsonKey()
  final CalendarItemAvailabilitiesAssignmentStrategy?
      availabilitiesAssignmentStrategy;
  @override
  @JsonKey()
  final String? hcpId;
  @override
  @JsonKey()
  final String? recurrenceId;
  final Set<DecryptedCalendarItemTag> _meetingTags;
  @override
  @JsonKey()
  Set<DecryptedCalendarItemTag> get meetingTags {
    if (_meetingTags is EqualUnmodifiableSetView) return _meetingTags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_meetingTags);
  }

  @override
  @JsonKey()
  final FlowItem? flowItem;
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

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedCalendarItemCopyWith<_DecryptedCalendarItem> get copyWith =>
      __$DecryptedCalendarItemCopyWithImpl<_DecryptedCalendarItem>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedCalendarItem &&
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
            (identical(other.title, title) || other.title == title) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.masterCalendarItemId, masterCalendarItemId) ||
                other.masterCalendarItemId == masterCalendarItemId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.important, important) ||
                other.important == important) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.address, address) || other.address == address) &&
            (identical(other.addressText, addressText) ||
                other.addressText == addressText) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            (identical(other.confirmationTime, confirmationTime) ||
                other.confirmationTime == confirmationTime) &&
            (identical(other.cancellationTimestamp, cancellationTimestamp) ||
                other.cancellationTimestamp == cancellationTimestamp) &&
            (identical(other.confirmationId, confirmationId) ||
                other.confirmationId == confirmationId) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.allDay, allDay) || other.allDay == allDay) &&
            (identical(other.details, details) || other.details == details) &&
            (identical(other.wasMigrated, wasMigrated) ||
                other.wasMigrated == wasMigrated) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            (identical(other.availabilitiesAssignmentStrategy,
                    availabilitiesAssignmentStrategy) ||
                other.availabilitiesAssignmentStrategy ==
                    availabilitiesAssignmentStrategy) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.recurrenceId, recurrenceId) ||
                other.recurrenceId == recurrenceId) &&
            const DeepCollectionEquality()
                .equals(other._meetingTags, _meetingTags) &&
            (identical(other.flowItem, flowItem) ||
                other.flowItem == flowItem) &&
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
                other.securityMetadata == securityMetadata));
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
        title,
        calendarItemTypeId,
        masterCalendarItemId,
        patientId,
        important,
        homeVisit,
        phoneNumber,
        placeId,
        address,
        addressText,
        startTime,
        endTime,
        confirmationTime,
        cancellationTimestamp,
        confirmationId,
        duration,
        allDay,
        details,
        wasMigrated,
        agendaId,
        resourceGroup,
        availabilitiesAssignmentStrategy,
        hcpId,
        recurrenceId,
        const DeepCollectionEquality().hash(_meetingTags),
        flowItem,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedCalendarItem(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, title: $title, calendarItemTypeId: $calendarItemTypeId, masterCalendarItemId: $masterCalendarItemId, patientId: $patientId, important: $important, homeVisit: $homeVisit, phoneNumber: $phoneNumber, placeId: $placeId, address: $address, addressText: $addressText, startTime: $startTime, endTime: $endTime, confirmationTime: $confirmationTime, cancellationTimestamp: $cancellationTimestamp, confirmationId: $confirmationId, duration: $duration, allDay: $allDay, details: $details, wasMigrated: $wasMigrated, agendaId: $agendaId, resourceGroup: $resourceGroup, availabilitiesAssignmentStrategy: $availabilitiesAssignmentStrategy, hcpId: $hcpId, recurrenceId: $recurrenceId, meetingTags: $meetingTags, flowItem: $flowItem, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedCalendarItemCopyWith<$Res>
    implements $DecryptedCalendarItemCopyWith<$Res> {
  factory _$DecryptedCalendarItemCopyWith(_DecryptedCalendarItem value,
          $Res Function(_DecryptedCalendarItem) _then) =
      __$DecryptedCalendarItemCopyWithImpl;
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
      String? title,
      String? calendarItemTypeId,
      String? masterCalendarItemId,
      String? patientId,
      bool? important,
      bool? homeVisit,
      String? phoneNumber,
      String? placeId,
      DecryptedAddress? address,
      String? addressText,
      int? startTime,
      int? endTime,
      int? confirmationTime,
      int? cancellationTimestamp,
      String? confirmationId,
      int? duration,
      bool? allDay,
      String? details,
      bool? wasMigrated,
      String? agendaId,
      CodeStub? resourceGroup,
      CalendarItemAvailabilitiesAssignmentStrategy?
          availabilitiesAssignmentStrategy,
      String? hcpId,
      String? recurrenceId,
      Set<DecryptedCalendarItemTag> meetingTags,
      FlowItem? flowItem,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $DecryptedAddressCopyWith<$Res>? get address;
  @override
  $CodeStubCopyWith<$Res>? get resourceGroup;
  @override
  $FlowItemCopyWith<$Res>? get flowItem;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedCalendarItemCopyWithImpl<$Res>
    implements _$DecryptedCalendarItemCopyWith<$Res> {
  __$DecryptedCalendarItemCopyWithImpl(this._self, this._then);

  final _DecryptedCalendarItem _self;
  final $Res Function(_DecryptedCalendarItem) _then;

  /// Create a copy of DecryptedCalendarItem
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
    Object? title = freezed,
    Object? calendarItemTypeId = freezed,
    Object? masterCalendarItemId = freezed,
    Object? patientId = freezed,
    Object? important = freezed,
    Object? homeVisit = freezed,
    Object? phoneNumber = freezed,
    Object? placeId = freezed,
    Object? address = freezed,
    Object? addressText = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? confirmationTime = freezed,
    Object? cancellationTimestamp = freezed,
    Object? confirmationId = freezed,
    Object? duration = freezed,
    Object? allDay = freezed,
    Object? details = freezed,
    Object? wasMigrated = freezed,
    Object? agendaId = freezed,
    Object? resourceGroup = freezed,
    Object? availabilitiesAssignmentStrategy = freezed,
    Object? hcpId = freezed,
    Object? recurrenceId = freezed,
    Object? meetingTags = null,
    Object? flowItem = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedCalendarItem(
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
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      masterCalendarItemId: freezed == masterCalendarItemId
          ? _self.masterCalendarItemId
          : masterCalendarItemId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      important: freezed == important
          ? _self.important
          : important // ignore: cast_nullable_to_non_nullable
              as bool?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      addressText: freezed == addressText
          ? _self.addressText
          : addressText // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationTime: freezed == confirmationTime
          ? _self.confirmationTime
          : confirmationTime // ignore: cast_nullable_to_non_nullable
              as int?,
      cancellationTimestamp: freezed == cancellationTimestamp
          ? _self.cancellationTimestamp
          : cancellationTimestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationId: freezed == confirmationId
          ? _self.confirmationId
          : confirmationId // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int?,
      allDay: freezed == allDay
          ? _self.allDay
          : allDay // ignore: cast_nullable_to_non_nullable
              as bool?,
      details: freezed == details
          ? _self.details
          : details // ignore: cast_nullable_to_non_nullable
              as String?,
      wasMigrated: freezed == wasMigrated
          ? _self.wasMigrated
          : wasMigrated // ignore: cast_nullable_to_non_nullable
              as bool?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      availabilitiesAssignmentStrategy: freezed ==
              availabilitiesAssignmentStrategy
          ? _self.availabilitiesAssignmentStrategy
          : availabilitiesAssignmentStrategy // ignore: cast_nullable_to_non_nullable
              as CalendarItemAvailabilitiesAssignmentStrategy?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      recurrenceId: freezed == recurrenceId
          ? _self.recurrenceId
          : recurrenceId // ignore: cast_nullable_to_non_nullable
              as String?,
      meetingTags: null == meetingTags
          ? _self._meetingTags
          : meetingTags // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedCalendarItemTag>,
      flowItem: freezed == flowItem
          ? _self.flowItem
          : flowItem // ignore: cast_nullable_to_non_nullable
              as FlowItem?,
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
    ));
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FlowItemCopyWith<$Res>? get flowItem {
    if (_self.flowItem == null) {
      return null;
    }

    return $FlowItemCopyWith<$Res>(_self.flowItem!, (value) {
      return _then(_self.copyWith(flowItem: value));
    });
  }

  /// Create a copy of DecryptedCalendarItem
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
mixin _$EncryptedCalendarItem {
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
  String? get title;
  String? get calendarItemTypeId;
  String? get masterCalendarItemId;
  String? get patientId;
  bool? get important;
  bool? get homeVisit;
  String? get phoneNumber;
  String? get placeId;
  EncryptedAddress? get address;
  String? get addressText;
  int? get startTime;
  int? get endTime;
  int? get confirmationTime;
  int? get cancellationTimestamp;
  String? get confirmationId;
  int? get duration;
  bool? get allDay;
  String? get details;
  bool? get wasMigrated;
  String? get agendaId;
  CodeStub? get resourceGroup;
  CalendarItemAvailabilitiesAssignmentStrategy?
      get availabilitiesAssignmentStrategy;
  String? get hcpId;
  String? get recurrenceId;
  Set<EncryptedCalendarItemTag> get meetingTags;
  FlowItem? get flowItem;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedCalendarItemCopyWith<EncryptedCalendarItem> get copyWith =>
      _$EncryptedCalendarItemCopyWithImpl<EncryptedCalendarItem>(
          this as EncryptedCalendarItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedCalendarItem &&
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
            (identical(other.title, title) || other.title == title) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.masterCalendarItemId, masterCalendarItemId) ||
                other.masterCalendarItemId == masterCalendarItemId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.important, important) ||
                other.important == important) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.address, address) || other.address == address) &&
            (identical(other.addressText, addressText) ||
                other.addressText == addressText) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            (identical(other.confirmationTime, confirmationTime) ||
                other.confirmationTime == confirmationTime) &&
            (identical(other.cancellationTimestamp, cancellationTimestamp) ||
                other.cancellationTimestamp == cancellationTimestamp) &&
            (identical(other.confirmationId, confirmationId) ||
                other.confirmationId == confirmationId) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.allDay, allDay) || other.allDay == allDay) &&
            (identical(other.details, details) || other.details == details) &&
            (identical(other.wasMigrated, wasMigrated) ||
                other.wasMigrated == wasMigrated) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            (identical(other.availabilitiesAssignmentStrategy,
                    availabilitiesAssignmentStrategy) ||
                other.availabilitiesAssignmentStrategy ==
                    availabilitiesAssignmentStrategy) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.recurrenceId, recurrenceId) ||
                other.recurrenceId == recurrenceId) &&
            const DeepCollectionEquality()
                .equals(other.meetingTags, meetingTags) &&
            (identical(other.flowItem, flowItem) ||
                other.flowItem == flowItem) &&
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
                other.securityMetadata == securityMetadata));
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
        title,
        calendarItemTypeId,
        masterCalendarItemId,
        patientId,
        important,
        homeVisit,
        phoneNumber,
        placeId,
        address,
        addressText,
        startTime,
        endTime,
        confirmationTime,
        cancellationTimestamp,
        confirmationId,
        duration,
        allDay,
        details,
        wasMigrated,
        agendaId,
        resourceGroup,
        availabilitiesAssignmentStrategy,
        hcpId,
        recurrenceId,
        const DeepCollectionEquality().hash(meetingTags),
        flowItem,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedCalendarItem(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, title: $title, calendarItemTypeId: $calendarItemTypeId, masterCalendarItemId: $masterCalendarItemId, patientId: $patientId, important: $important, homeVisit: $homeVisit, phoneNumber: $phoneNumber, placeId: $placeId, address: $address, addressText: $addressText, startTime: $startTime, endTime: $endTime, confirmationTime: $confirmationTime, cancellationTimestamp: $cancellationTimestamp, confirmationId: $confirmationId, duration: $duration, allDay: $allDay, details: $details, wasMigrated: $wasMigrated, agendaId: $agendaId, resourceGroup: $resourceGroup, availabilitiesAssignmentStrategy: $availabilitiesAssignmentStrategy, hcpId: $hcpId, recurrenceId: $recurrenceId, meetingTags: $meetingTags, flowItem: $flowItem, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedCalendarItemCopyWith<$Res> {
  factory $EncryptedCalendarItemCopyWith(EncryptedCalendarItem value,
          $Res Function(EncryptedCalendarItem) _then) =
      _$EncryptedCalendarItemCopyWithImpl;
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
      String? title,
      String? calendarItemTypeId,
      String? masterCalendarItemId,
      String? patientId,
      bool? important,
      bool? homeVisit,
      String? phoneNumber,
      String? placeId,
      EncryptedAddress? address,
      String? addressText,
      int? startTime,
      int? endTime,
      int? confirmationTime,
      int? cancellationTimestamp,
      String? confirmationId,
      int? duration,
      bool? allDay,
      String? details,
      bool? wasMigrated,
      String? agendaId,
      CodeStub? resourceGroup,
      CalendarItemAvailabilitiesAssignmentStrategy?
          availabilitiesAssignmentStrategy,
      String? hcpId,
      String? recurrenceId,
      Set<EncryptedCalendarItemTag> meetingTags,
      FlowItem? flowItem,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $EncryptedAddressCopyWith<$Res>? get address;
  $CodeStubCopyWith<$Res>? get resourceGroup;
  $FlowItemCopyWith<$Res>? get flowItem;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedCalendarItemCopyWithImpl<$Res>
    implements $EncryptedCalendarItemCopyWith<$Res> {
  _$EncryptedCalendarItemCopyWithImpl(this._self, this._then);

  final EncryptedCalendarItem _self;
  final $Res Function(EncryptedCalendarItem) _then;

  /// Create a copy of EncryptedCalendarItem
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
    Object? title = freezed,
    Object? calendarItemTypeId = freezed,
    Object? masterCalendarItemId = freezed,
    Object? patientId = freezed,
    Object? important = freezed,
    Object? homeVisit = freezed,
    Object? phoneNumber = freezed,
    Object? placeId = freezed,
    Object? address = freezed,
    Object? addressText = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? confirmationTime = freezed,
    Object? cancellationTimestamp = freezed,
    Object? confirmationId = freezed,
    Object? duration = freezed,
    Object? allDay = freezed,
    Object? details = freezed,
    Object? wasMigrated = freezed,
    Object? agendaId = freezed,
    Object? resourceGroup = freezed,
    Object? availabilitiesAssignmentStrategy = freezed,
    Object? hcpId = freezed,
    Object? recurrenceId = freezed,
    Object? meetingTags = null,
    Object? flowItem = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
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
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      masterCalendarItemId: freezed == masterCalendarItemId
          ? _self.masterCalendarItemId
          : masterCalendarItemId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      important: freezed == important
          ? _self.important
          : important // ignore: cast_nullable_to_non_nullable
              as bool?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as EncryptedAddress?,
      addressText: freezed == addressText
          ? _self.addressText
          : addressText // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationTime: freezed == confirmationTime
          ? _self.confirmationTime
          : confirmationTime // ignore: cast_nullable_to_non_nullable
              as int?,
      cancellationTimestamp: freezed == cancellationTimestamp
          ? _self.cancellationTimestamp
          : cancellationTimestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationId: freezed == confirmationId
          ? _self.confirmationId
          : confirmationId // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int?,
      allDay: freezed == allDay
          ? _self.allDay
          : allDay // ignore: cast_nullable_to_non_nullable
              as bool?,
      details: freezed == details
          ? _self.details
          : details // ignore: cast_nullable_to_non_nullable
              as String?,
      wasMigrated: freezed == wasMigrated
          ? _self.wasMigrated
          : wasMigrated // ignore: cast_nullable_to_non_nullable
              as bool?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      availabilitiesAssignmentStrategy: freezed ==
              availabilitiesAssignmentStrategy
          ? _self.availabilitiesAssignmentStrategy
          : availabilitiesAssignmentStrategy // ignore: cast_nullable_to_non_nullable
              as CalendarItemAvailabilitiesAssignmentStrategy?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      recurrenceId: freezed == recurrenceId
          ? _self.recurrenceId
          : recurrenceId // ignore: cast_nullable_to_non_nullable
              as String?,
      meetingTags: null == meetingTags
          ? _self.meetingTags
          : meetingTags // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedCalendarItemTag>,
      flowItem: freezed == flowItem
          ? _self.flowItem
          : flowItem // ignore: cast_nullable_to_non_nullable
              as FlowItem?,
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
    ));
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $EncryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FlowItemCopyWith<$Res>? get flowItem {
    if (_self.flowItem == null) {
      return null;
    }

    return $FlowItemCopyWith<$Res>(_self.flowItem!, (value) {
      return _then(_self.copyWith(flowItem: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
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

class _EncryptedCalendarItem implements EncryptedCalendarItem {
  const _EncryptedCalendarItem(
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
      this.title = null,
      this.calendarItemTypeId = null,
      this.masterCalendarItemId = null,
      this.patientId = null,
      this.important = null,
      this.homeVisit = null,
      this.phoneNumber = null,
      this.placeId = null,
      this.address = null,
      this.addressText = null,
      this.startTime = null,
      this.endTime = null,
      this.confirmationTime = null,
      this.cancellationTimestamp = null,
      this.confirmationId = null,
      this.duration = null,
      this.allDay = null,
      this.details = null,
      this.wasMigrated = null,
      this.agendaId = null,
      this.resourceGroup = null,
      this.availabilitiesAssignmentStrategy = null,
      this.hcpId = null,
      this.recurrenceId = null,
      final Set<EncryptedCalendarItemTag> meetingTags = const {},
      this.flowItem = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _meetingTags = meetingTags,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

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
  final String? title;
  @override
  @JsonKey()
  final String? calendarItemTypeId;
  @override
  @JsonKey()
  final String? masterCalendarItemId;
  @override
  @JsonKey()
  final String? patientId;
  @override
  @JsonKey()
  final bool? important;
  @override
  @JsonKey()
  final bool? homeVisit;
  @override
  @JsonKey()
  final String? phoneNumber;
  @override
  @JsonKey()
  final String? placeId;
  @override
  @JsonKey()
  final EncryptedAddress? address;
  @override
  @JsonKey()
  final String? addressText;
  @override
  @JsonKey()
  final int? startTime;
  @override
  @JsonKey()
  final int? endTime;
  @override
  @JsonKey()
  final int? confirmationTime;
  @override
  @JsonKey()
  final int? cancellationTimestamp;
  @override
  @JsonKey()
  final String? confirmationId;
  @override
  @JsonKey()
  final int? duration;
  @override
  @JsonKey()
  final bool? allDay;
  @override
  @JsonKey()
  final String? details;
  @override
  @JsonKey()
  final bool? wasMigrated;
  @override
  @JsonKey()
  final String? agendaId;
  @override
  @JsonKey()
  final CodeStub? resourceGroup;
  @override
  @JsonKey()
  final CalendarItemAvailabilitiesAssignmentStrategy?
      availabilitiesAssignmentStrategy;
  @override
  @JsonKey()
  final String? hcpId;
  @override
  @JsonKey()
  final String? recurrenceId;
  final Set<EncryptedCalendarItemTag> _meetingTags;
  @override
  @JsonKey()
  Set<EncryptedCalendarItemTag> get meetingTags {
    if (_meetingTags is EqualUnmodifiableSetView) return _meetingTags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_meetingTags);
  }

  @override
  @JsonKey()
  final FlowItem? flowItem;
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

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedCalendarItemCopyWith<_EncryptedCalendarItem> get copyWith =>
      __$EncryptedCalendarItemCopyWithImpl<_EncryptedCalendarItem>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedCalendarItem &&
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
            (identical(other.title, title) || other.title == title) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.masterCalendarItemId, masterCalendarItemId) ||
                other.masterCalendarItemId == masterCalendarItemId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.important, important) ||
                other.important == important) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.address, address) || other.address == address) &&
            (identical(other.addressText, addressText) ||
                other.addressText == addressText) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            (identical(other.confirmationTime, confirmationTime) ||
                other.confirmationTime == confirmationTime) &&
            (identical(other.cancellationTimestamp, cancellationTimestamp) ||
                other.cancellationTimestamp == cancellationTimestamp) &&
            (identical(other.confirmationId, confirmationId) ||
                other.confirmationId == confirmationId) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.allDay, allDay) || other.allDay == allDay) &&
            (identical(other.details, details) || other.details == details) &&
            (identical(other.wasMigrated, wasMigrated) ||
                other.wasMigrated == wasMigrated) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(other.resourceGroup, resourceGroup) ||
                other.resourceGroup == resourceGroup) &&
            (identical(other.availabilitiesAssignmentStrategy,
                    availabilitiesAssignmentStrategy) ||
                other.availabilitiesAssignmentStrategy ==
                    availabilitiesAssignmentStrategy) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.recurrenceId, recurrenceId) ||
                other.recurrenceId == recurrenceId) &&
            const DeepCollectionEquality()
                .equals(other._meetingTags, _meetingTags) &&
            (identical(other.flowItem, flowItem) ||
                other.flowItem == flowItem) &&
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
                other.securityMetadata == securityMetadata));
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
        title,
        calendarItemTypeId,
        masterCalendarItemId,
        patientId,
        important,
        homeVisit,
        phoneNumber,
        placeId,
        address,
        addressText,
        startTime,
        endTime,
        confirmationTime,
        cancellationTimestamp,
        confirmationId,
        duration,
        allDay,
        details,
        wasMigrated,
        agendaId,
        resourceGroup,
        availabilitiesAssignmentStrategy,
        hcpId,
        recurrenceId,
        const DeepCollectionEquality().hash(_meetingTags),
        flowItem,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedCalendarItem(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, title: $title, calendarItemTypeId: $calendarItemTypeId, masterCalendarItemId: $masterCalendarItemId, patientId: $patientId, important: $important, homeVisit: $homeVisit, phoneNumber: $phoneNumber, placeId: $placeId, address: $address, addressText: $addressText, startTime: $startTime, endTime: $endTime, confirmationTime: $confirmationTime, cancellationTimestamp: $cancellationTimestamp, confirmationId: $confirmationId, duration: $duration, allDay: $allDay, details: $details, wasMigrated: $wasMigrated, agendaId: $agendaId, resourceGroup: $resourceGroup, availabilitiesAssignmentStrategy: $availabilitiesAssignmentStrategy, hcpId: $hcpId, recurrenceId: $recurrenceId, meetingTags: $meetingTags, flowItem: $flowItem, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedCalendarItemCopyWith<$Res>
    implements $EncryptedCalendarItemCopyWith<$Res> {
  factory _$EncryptedCalendarItemCopyWith(_EncryptedCalendarItem value,
          $Res Function(_EncryptedCalendarItem) _then) =
      __$EncryptedCalendarItemCopyWithImpl;
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
      String? title,
      String? calendarItemTypeId,
      String? masterCalendarItemId,
      String? patientId,
      bool? important,
      bool? homeVisit,
      String? phoneNumber,
      String? placeId,
      EncryptedAddress? address,
      String? addressText,
      int? startTime,
      int? endTime,
      int? confirmationTime,
      int? cancellationTimestamp,
      String? confirmationId,
      int? duration,
      bool? allDay,
      String? details,
      bool? wasMigrated,
      String? agendaId,
      CodeStub? resourceGroup,
      CalendarItemAvailabilitiesAssignmentStrategy?
          availabilitiesAssignmentStrategy,
      String? hcpId,
      String? recurrenceId,
      Set<EncryptedCalendarItemTag> meetingTags,
      FlowItem? flowItem,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $EncryptedAddressCopyWith<$Res>? get address;
  @override
  $CodeStubCopyWith<$Res>? get resourceGroup;
  @override
  $FlowItemCopyWith<$Res>? get flowItem;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedCalendarItemCopyWithImpl<$Res>
    implements _$EncryptedCalendarItemCopyWith<$Res> {
  __$EncryptedCalendarItemCopyWithImpl(this._self, this._then);

  final _EncryptedCalendarItem _self;
  final $Res Function(_EncryptedCalendarItem) _then;

  /// Create a copy of EncryptedCalendarItem
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
    Object? title = freezed,
    Object? calendarItemTypeId = freezed,
    Object? masterCalendarItemId = freezed,
    Object? patientId = freezed,
    Object? important = freezed,
    Object? homeVisit = freezed,
    Object? phoneNumber = freezed,
    Object? placeId = freezed,
    Object? address = freezed,
    Object? addressText = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? confirmationTime = freezed,
    Object? cancellationTimestamp = freezed,
    Object? confirmationId = freezed,
    Object? duration = freezed,
    Object? allDay = freezed,
    Object? details = freezed,
    Object? wasMigrated = freezed,
    Object? agendaId = freezed,
    Object? resourceGroup = freezed,
    Object? availabilitiesAssignmentStrategy = freezed,
    Object? hcpId = freezed,
    Object? recurrenceId = freezed,
    Object? meetingTags = null,
    Object? flowItem = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedCalendarItem(
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
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      masterCalendarItemId: freezed == masterCalendarItemId
          ? _self.masterCalendarItemId
          : masterCalendarItemId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      important: freezed == important
          ? _self.important
          : important // ignore: cast_nullable_to_non_nullable
              as bool?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as EncryptedAddress?,
      addressText: freezed == addressText
          ? _self.addressText
          : addressText // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationTime: freezed == confirmationTime
          ? _self.confirmationTime
          : confirmationTime // ignore: cast_nullable_to_non_nullable
              as int?,
      cancellationTimestamp: freezed == cancellationTimestamp
          ? _self.cancellationTimestamp
          : cancellationTimestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      confirmationId: freezed == confirmationId
          ? _self.confirmationId
          : confirmationId // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int?,
      allDay: freezed == allDay
          ? _self.allDay
          : allDay // ignore: cast_nullable_to_non_nullable
              as bool?,
      details: freezed == details
          ? _self.details
          : details // ignore: cast_nullable_to_non_nullable
              as String?,
      wasMigrated: freezed == wasMigrated
          ? _self.wasMigrated
          : wasMigrated // ignore: cast_nullable_to_non_nullable
              as bool?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      resourceGroup: freezed == resourceGroup
          ? _self.resourceGroup
          : resourceGroup // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      availabilitiesAssignmentStrategy: freezed ==
              availabilitiesAssignmentStrategy
          ? _self.availabilitiesAssignmentStrategy
          : availabilitiesAssignmentStrategy // ignore: cast_nullable_to_non_nullable
              as CalendarItemAvailabilitiesAssignmentStrategy?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      recurrenceId: freezed == recurrenceId
          ? _self.recurrenceId
          : recurrenceId // ignore: cast_nullable_to_non_nullable
              as String?,
      meetingTags: null == meetingTags
          ? _self._meetingTags
          : meetingTags // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedCalendarItemTag>,
      flowItem: freezed == flowItem
          ? _self.flowItem
          : flowItem // ignore: cast_nullable_to_non_nullable
              as FlowItem?,
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
    ));
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $EncryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get resourceGroup {
    if (_self.resourceGroup == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.resourceGroup!, (value) {
      return _then(_self.copyWith(resourceGroup: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FlowItemCopyWith<$Res>? get flowItem {
    if (_self.flowItem == null) {
      return null;
    }

    return $FlowItemCopyWith<$Res>(_self.flowItem!, (value) {
      return _then(_self.copyWith(flowItem: value));
    });
  }

  /// Create a copy of EncryptedCalendarItem
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
