// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'patient_health_care_party.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedPatientHealthCareParty {
  PatientHealthCarePartyType? get type;
  String? get healthcarePartyId;
  Map<TelecomType, String> get sendFormats;
  List<ReferralPeriod> get referralPeriods;
  bool get referral;
  Set<EncryptedPropertyStub>? get properties;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedPatientHealthCarePartyCopyWith<EncryptedPatientHealthCareParty>
      get copyWith => _$EncryptedPatientHealthCarePartyCopyWithImpl<
              EncryptedPatientHealthCareParty>(
          this as EncryptedPatientHealthCareParty, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedPatientHealthCareParty &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            const DeepCollectionEquality()
                .equals(other.sendFormats, sendFormats) &&
            const DeepCollectionEquality()
                .equals(other.referralPeriods, referralPeriods) &&
            (identical(other.referral, referral) ||
                other.referral == referral) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      type,
      healthcarePartyId,
      const DeepCollectionEquality().hash(sendFormats),
      const DeepCollectionEquality().hash(referralPeriods),
      referral,
      const DeepCollectionEquality().hash(properties),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedPatientHealthCareParty(type: $type, healthcarePartyId: $healthcarePartyId, sendFormats: $sendFormats, referralPeriods: $referralPeriods, referral: $referral, properties: $properties, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedPatientHealthCarePartyCopyWith<$Res> {
  factory $EncryptedPatientHealthCarePartyCopyWith(
          EncryptedPatientHealthCareParty value,
          $Res Function(EncryptedPatientHealthCareParty) _then) =
      _$EncryptedPatientHealthCarePartyCopyWithImpl;
  @useResult
  $Res call(
      {PatientHealthCarePartyType? type,
      String? healthcarePartyId,
      Map<TelecomType, String> sendFormats,
      List<ReferralPeriod> referralPeriods,
      bool referral,
      Set<EncryptedPropertyStub>? properties,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedPatientHealthCarePartyCopyWithImpl<$Res>
    implements $EncryptedPatientHealthCarePartyCopyWith<$Res> {
  _$EncryptedPatientHealthCarePartyCopyWithImpl(this._self, this._then);

  final EncryptedPatientHealthCareParty _self;
  final $Res Function(EncryptedPatientHealthCareParty) _then;

  /// Create a copy of EncryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? healthcarePartyId = freezed,
    Object? sendFormats = null,
    Object? referralPeriods = null,
    Object? referral = null,
    Object? properties = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PatientHealthCarePartyType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      sendFormats: null == sendFormats
          ? _self.sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      referralPeriods: null == referralPeriods
          ? _self.referralPeriods
          : referralPeriods // ignore: cast_nullable_to_non_nullable
              as List<ReferralPeriod>,
      referral: null == referral
          ? _self.referral
          : referral // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: freezed == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedPropertyStub>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedPatientHealthCareParty
    implements EncryptedPatientHealthCareParty {
  const _EncryptedPatientHealthCareParty(
      {this.type = null,
      this.healthcarePartyId = null,
      final Map<TelecomType, String> sendFormats = const {},
      final List<ReferralPeriod> referralPeriods = const [],
      this.referral = false,
      final Set<EncryptedPropertyStub>? properties = null,
      this.encryptedSelf = null})
      : _sendFormats = sendFormats,
        _referralPeriods = referralPeriods,
        _properties = properties;

  @override
  @JsonKey()
  final PatientHealthCarePartyType? type;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  final Map<TelecomType, String> _sendFormats;
  @override
  @JsonKey()
  Map<TelecomType, String> get sendFormats {
    if (_sendFormats is EqualUnmodifiableMapView) return _sendFormats;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_sendFormats);
  }

  final List<ReferralPeriod> _referralPeriods;
  @override
  @JsonKey()
  List<ReferralPeriod> get referralPeriods {
    if (_referralPeriods is EqualUnmodifiableListView) return _referralPeriods;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_referralPeriods);
  }

  @override
  @JsonKey()
  final bool referral;
  final Set<EncryptedPropertyStub>? _properties;
  @override
  @JsonKey()
  Set<EncryptedPropertyStub>? get properties {
    final value = _properties;
    if (value == null) return null;
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedPatientHealthCarePartyCopyWith<_EncryptedPatientHealthCareParty>
      get copyWith => __$EncryptedPatientHealthCarePartyCopyWithImpl<
          _EncryptedPatientHealthCareParty>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedPatientHealthCareParty &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            const DeepCollectionEquality()
                .equals(other._sendFormats, _sendFormats) &&
            const DeepCollectionEquality()
                .equals(other._referralPeriods, _referralPeriods) &&
            (identical(other.referral, referral) ||
                other.referral == referral) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      type,
      healthcarePartyId,
      const DeepCollectionEquality().hash(_sendFormats),
      const DeepCollectionEquality().hash(_referralPeriods),
      referral,
      const DeepCollectionEquality().hash(_properties),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedPatientHealthCareParty(type: $type, healthcarePartyId: $healthcarePartyId, sendFormats: $sendFormats, referralPeriods: $referralPeriods, referral: $referral, properties: $properties, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedPatientHealthCarePartyCopyWith<$Res>
    implements $EncryptedPatientHealthCarePartyCopyWith<$Res> {
  factory _$EncryptedPatientHealthCarePartyCopyWith(
          _EncryptedPatientHealthCareParty value,
          $Res Function(_EncryptedPatientHealthCareParty) _then) =
      __$EncryptedPatientHealthCarePartyCopyWithImpl;
  @override
  @useResult
  $Res call(
      {PatientHealthCarePartyType? type,
      String? healthcarePartyId,
      Map<TelecomType, String> sendFormats,
      List<ReferralPeriod> referralPeriods,
      bool referral,
      Set<EncryptedPropertyStub>? properties,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedPatientHealthCarePartyCopyWithImpl<$Res>
    implements _$EncryptedPatientHealthCarePartyCopyWith<$Res> {
  __$EncryptedPatientHealthCarePartyCopyWithImpl(this._self, this._then);

  final _EncryptedPatientHealthCareParty _self;
  final $Res Function(_EncryptedPatientHealthCareParty) _then;

  /// Create a copy of EncryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? healthcarePartyId = freezed,
    Object? sendFormats = null,
    Object? referralPeriods = null,
    Object? referral = null,
    Object? properties = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedPatientHealthCareParty(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PatientHealthCarePartyType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      sendFormats: null == sendFormats
          ? _self._sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      referralPeriods: null == referralPeriods
          ? _self._referralPeriods
          : referralPeriods // ignore: cast_nullable_to_non_nullable
              as List<ReferralPeriod>,
      referral: null == referral
          ? _self.referral
          : referral // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: freezed == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedPropertyStub>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedPatientHealthCareParty {
  PatientHealthCarePartyType? get type;
  String? get healthcarePartyId;
  Map<TelecomType, String> get sendFormats;
  List<ReferralPeriod> get referralPeriods;
  bool get referral;
  Set<DecryptedPropertyStub>? get properties;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedPatientHealthCarePartyCopyWith<DecryptedPatientHealthCareParty>
      get copyWith => _$DecryptedPatientHealthCarePartyCopyWithImpl<
              DecryptedPatientHealthCareParty>(
          this as DecryptedPatientHealthCareParty, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedPatientHealthCareParty &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            const DeepCollectionEquality()
                .equals(other.sendFormats, sendFormats) &&
            const DeepCollectionEquality()
                .equals(other.referralPeriods, referralPeriods) &&
            (identical(other.referral, referral) ||
                other.referral == referral) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      type,
      healthcarePartyId,
      const DeepCollectionEquality().hash(sendFormats),
      const DeepCollectionEquality().hash(referralPeriods),
      referral,
      const DeepCollectionEquality().hash(properties),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedPatientHealthCareParty(type: $type, healthcarePartyId: $healthcarePartyId, sendFormats: $sendFormats, referralPeriods: $referralPeriods, referral: $referral, properties: $properties, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedPatientHealthCarePartyCopyWith<$Res> {
  factory $DecryptedPatientHealthCarePartyCopyWith(
          DecryptedPatientHealthCareParty value,
          $Res Function(DecryptedPatientHealthCareParty) _then) =
      _$DecryptedPatientHealthCarePartyCopyWithImpl;
  @useResult
  $Res call(
      {PatientHealthCarePartyType? type,
      String? healthcarePartyId,
      Map<TelecomType, String> sendFormats,
      List<ReferralPeriod> referralPeriods,
      bool referral,
      Set<DecryptedPropertyStub>? properties,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedPatientHealthCarePartyCopyWithImpl<$Res>
    implements $DecryptedPatientHealthCarePartyCopyWith<$Res> {
  _$DecryptedPatientHealthCarePartyCopyWithImpl(this._self, this._then);

  final DecryptedPatientHealthCareParty _self;
  final $Res Function(DecryptedPatientHealthCareParty) _then;

  /// Create a copy of DecryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? healthcarePartyId = freezed,
    Object? sendFormats = null,
    Object? referralPeriods = null,
    Object? referral = null,
    Object? properties = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PatientHealthCarePartyType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      sendFormats: null == sendFormats
          ? _self.sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      referralPeriods: null == referralPeriods
          ? _self.referralPeriods
          : referralPeriods // ignore: cast_nullable_to_non_nullable
              as List<ReferralPeriod>,
      referral: null == referral
          ? _self.referral
          : referral // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: freezed == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedPatientHealthCareParty
    implements DecryptedPatientHealthCareParty {
  const _DecryptedPatientHealthCareParty(
      {this.type = null,
      this.healthcarePartyId = null,
      final Map<TelecomType, String> sendFormats = const {},
      final List<ReferralPeriod> referralPeriods = const [],
      this.referral = false,
      final Set<DecryptedPropertyStub>? properties = null,
      this.encryptedSelf = null})
      : _sendFormats = sendFormats,
        _referralPeriods = referralPeriods,
        _properties = properties;

  @override
  @JsonKey()
  final PatientHealthCarePartyType? type;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  final Map<TelecomType, String> _sendFormats;
  @override
  @JsonKey()
  Map<TelecomType, String> get sendFormats {
    if (_sendFormats is EqualUnmodifiableMapView) return _sendFormats;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_sendFormats);
  }

  final List<ReferralPeriod> _referralPeriods;
  @override
  @JsonKey()
  List<ReferralPeriod> get referralPeriods {
    if (_referralPeriods is EqualUnmodifiableListView) return _referralPeriods;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_referralPeriods);
  }

  @override
  @JsonKey()
  final bool referral;
  final Set<DecryptedPropertyStub>? _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub>? get properties {
    final value = _properties;
    if (value == null) return null;
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedPatientHealthCarePartyCopyWith<_DecryptedPatientHealthCareParty>
      get copyWith => __$DecryptedPatientHealthCarePartyCopyWithImpl<
          _DecryptedPatientHealthCareParty>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedPatientHealthCareParty &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            const DeepCollectionEquality()
                .equals(other._sendFormats, _sendFormats) &&
            const DeepCollectionEquality()
                .equals(other._referralPeriods, _referralPeriods) &&
            (identical(other.referral, referral) ||
                other.referral == referral) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      type,
      healthcarePartyId,
      const DeepCollectionEquality().hash(_sendFormats),
      const DeepCollectionEquality().hash(_referralPeriods),
      referral,
      const DeepCollectionEquality().hash(_properties),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedPatientHealthCareParty(type: $type, healthcarePartyId: $healthcarePartyId, sendFormats: $sendFormats, referralPeriods: $referralPeriods, referral: $referral, properties: $properties, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedPatientHealthCarePartyCopyWith<$Res>
    implements $DecryptedPatientHealthCarePartyCopyWith<$Res> {
  factory _$DecryptedPatientHealthCarePartyCopyWith(
          _DecryptedPatientHealthCareParty value,
          $Res Function(_DecryptedPatientHealthCareParty) _then) =
      __$DecryptedPatientHealthCarePartyCopyWithImpl;
  @override
  @useResult
  $Res call(
      {PatientHealthCarePartyType? type,
      String? healthcarePartyId,
      Map<TelecomType, String> sendFormats,
      List<ReferralPeriod> referralPeriods,
      bool referral,
      Set<DecryptedPropertyStub>? properties,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedPatientHealthCarePartyCopyWithImpl<$Res>
    implements _$DecryptedPatientHealthCarePartyCopyWith<$Res> {
  __$DecryptedPatientHealthCarePartyCopyWithImpl(this._self, this._then);

  final _DecryptedPatientHealthCareParty _self;
  final $Res Function(_DecryptedPatientHealthCareParty) _then;

  /// Create a copy of DecryptedPatientHealthCareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? healthcarePartyId = freezed,
    Object? sendFormats = null,
    Object? referralPeriods = null,
    Object? referral = null,
    Object? properties = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedPatientHealthCareParty(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PatientHealthCarePartyType?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      sendFormats: null == sendFormats
          ? _self._sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      referralPeriods: null == referralPeriods
          ? _self._referralPeriods
          : referralPeriods // ignore: cast_nullable_to_non_nullable
              as List<ReferralPeriod>,
      referral: null == referral
          ? _self.referral
          : referral // ignore: cast_nullable_to_non_nullable
              as bool,
      properties: freezed == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
