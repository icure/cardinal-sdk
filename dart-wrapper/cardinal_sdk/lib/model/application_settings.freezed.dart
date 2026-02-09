// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'application_settings.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedApplicationSettings {
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
  Map<String, String> get settings;
  Map<String, String> get encryptedSettings;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  SecurityMetadata? get securityMetadata;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedApplicationSettings
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedApplicationSettingsCopyWith<DecryptedApplicationSettings>
      get copyWith => _$DecryptedApplicationSettingsCopyWithImpl<
              DecryptedApplicationSettings>(
          this as DecryptedApplicationSettings, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedApplicationSettings &&
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
            const DeepCollectionEquality().equals(other.settings, settings) &&
            const DeepCollectionEquality()
                .equals(other.encryptedSettings, encryptedSettings) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
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
        const DeepCollectionEquality().hash(settings),
        const DeepCollectionEquality().hash(encryptedSettings),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        securityMetadata,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedApplicationSettings(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, settings: $settings, encryptedSettings: $encryptedSettings, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedApplicationSettingsCopyWith<$Res> {
  factory $DecryptedApplicationSettingsCopyWith(
          DecryptedApplicationSettings value,
          $Res Function(DecryptedApplicationSettings) _then) =
      _$DecryptedApplicationSettingsCopyWithImpl;
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
      Map<String, String> settings,
      Map<String, String> encryptedSettings,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata,
      Base64String? encryptedSelf});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedApplicationSettingsCopyWithImpl<$Res>
    implements $DecryptedApplicationSettingsCopyWith<$Res> {
  _$DecryptedApplicationSettingsCopyWithImpl(this._self, this._then);

  final DecryptedApplicationSettings _self;
  final $Res Function(DecryptedApplicationSettings) _then;

  /// Create a copy of DecryptedApplicationSettings
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
    Object? settings = null,
    Object? encryptedSettings = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? securityMetadata = freezed,
    Object? encryptedSelf = freezed,
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
      settings: null == settings
          ? _self.settings
          : settings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSettings: null == encryptedSettings
          ? _self.encryptedSettings
          : encryptedSettings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedApplicationSettings
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

class _DecryptedApplicationSettings implements DecryptedApplicationSettings {
  const _DecryptedApplicationSettings(
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
      final Map<String, String> settings = const {},
      final Map<String, String> encryptedSettings = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.securityMetadata = null,
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _settings = settings,
        _encryptedSettings = encryptedSettings,
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
  final Map<String, String> _settings;
  @override
  @JsonKey()
  Map<String, String> get settings {
    if (_settings is EqualUnmodifiableMapView) return _settings;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_settings);
  }

  final Map<String, String> _encryptedSettings;
  @override
  @JsonKey()
  Map<String, String> get encryptedSettings {
    if (_encryptedSettings is EqualUnmodifiableMapView)
      return _encryptedSettings;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptedSettings);
  }

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
  final SecurityMetadata? securityMetadata;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedApplicationSettings
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedApplicationSettingsCopyWith<_DecryptedApplicationSettings>
      get copyWith => __$DecryptedApplicationSettingsCopyWithImpl<
          _DecryptedApplicationSettings>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedApplicationSettings &&
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
            const DeepCollectionEquality().equals(other._settings, _settings) &&
            const DeepCollectionEquality()
                .equals(other._encryptedSettings, _encryptedSettings) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
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
        const DeepCollectionEquality().hash(_settings),
        const DeepCollectionEquality().hash(_encryptedSettings),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        securityMetadata,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedApplicationSettings(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, settings: $settings, encryptedSettings: $encryptedSettings, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedApplicationSettingsCopyWith<$Res>
    implements $DecryptedApplicationSettingsCopyWith<$Res> {
  factory _$DecryptedApplicationSettingsCopyWith(
          _DecryptedApplicationSettings value,
          $Res Function(_DecryptedApplicationSettings) _then) =
      __$DecryptedApplicationSettingsCopyWithImpl;
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
      Map<String, String> settings,
      Map<String, String> encryptedSettings,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata,
      Base64String? encryptedSelf});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedApplicationSettingsCopyWithImpl<$Res>
    implements _$DecryptedApplicationSettingsCopyWith<$Res> {
  __$DecryptedApplicationSettingsCopyWithImpl(this._self, this._then);

  final _DecryptedApplicationSettings _self;
  final $Res Function(_DecryptedApplicationSettings) _then;

  /// Create a copy of DecryptedApplicationSettings
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
    Object? settings = null,
    Object? encryptedSettings = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? securityMetadata = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedApplicationSettings(
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
      settings: null == settings
          ? _self._settings
          : settings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSettings: null == encryptedSettings
          ? _self._encryptedSettings
          : encryptedSettings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedApplicationSettings
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
mixin _$EncryptedApplicationSettings {
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
  Map<String, String> get settings;
  Map<String, String> get encryptedSettings;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  SecurityMetadata? get securityMetadata;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedApplicationSettings
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedApplicationSettingsCopyWith<EncryptedApplicationSettings>
      get copyWith => _$EncryptedApplicationSettingsCopyWithImpl<
              EncryptedApplicationSettings>(
          this as EncryptedApplicationSettings, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedApplicationSettings &&
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
            const DeepCollectionEquality().equals(other.settings, settings) &&
            const DeepCollectionEquality()
                .equals(other.encryptedSettings, encryptedSettings) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
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
        const DeepCollectionEquality().hash(settings),
        const DeepCollectionEquality().hash(encryptedSettings),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        securityMetadata,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedApplicationSettings(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, settings: $settings, encryptedSettings: $encryptedSettings, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedApplicationSettingsCopyWith<$Res> {
  factory $EncryptedApplicationSettingsCopyWith(
          EncryptedApplicationSettings value,
          $Res Function(EncryptedApplicationSettings) _then) =
      _$EncryptedApplicationSettingsCopyWithImpl;
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
      Map<String, String> settings,
      Map<String, String> encryptedSettings,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata,
      Base64String? encryptedSelf});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedApplicationSettingsCopyWithImpl<$Res>
    implements $EncryptedApplicationSettingsCopyWith<$Res> {
  _$EncryptedApplicationSettingsCopyWithImpl(this._self, this._then);

  final EncryptedApplicationSettings _self;
  final $Res Function(EncryptedApplicationSettings) _then;

  /// Create a copy of EncryptedApplicationSettings
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
    Object? settings = null,
    Object? encryptedSettings = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? securityMetadata = freezed,
    Object? encryptedSelf = freezed,
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
      settings: null == settings
          ? _self.settings
          : settings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSettings: null == encryptedSettings
          ? _self.encryptedSettings
          : encryptedSettings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedApplicationSettings
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

class _EncryptedApplicationSettings implements EncryptedApplicationSettings {
  const _EncryptedApplicationSettings(
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
      final Map<String, String> settings = const {},
      final Map<String, String> encryptedSettings = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.securityMetadata = null,
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _settings = settings,
        _encryptedSettings = encryptedSettings,
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
  final Map<String, String> _settings;
  @override
  @JsonKey()
  Map<String, String> get settings {
    if (_settings is EqualUnmodifiableMapView) return _settings;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_settings);
  }

  final Map<String, String> _encryptedSettings;
  @override
  @JsonKey()
  Map<String, String> get encryptedSettings {
    if (_encryptedSettings is EqualUnmodifiableMapView)
      return _encryptedSettings;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptedSettings);
  }

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
  final SecurityMetadata? securityMetadata;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedApplicationSettings
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedApplicationSettingsCopyWith<_EncryptedApplicationSettings>
      get copyWith => __$EncryptedApplicationSettingsCopyWithImpl<
          _EncryptedApplicationSettings>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedApplicationSettings &&
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
            const DeepCollectionEquality().equals(other._settings, _settings) &&
            const DeepCollectionEquality()
                .equals(other._encryptedSettings, _encryptedSettings) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
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
        const DeepCollectionEquality().hash(_settings),
        const DeepCollectionEquality().hash(_encryptedSettings),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        securityMetadata,
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedApplicationSettings(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, settings: $settings, encryptedSettings: $encryptedSettings, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedApplicationSettingsCopyWith<$Res>
    implements $EncryptedApplicationSettingsCopyWith<$Res> {
  factory _$EncryptedApplicationSettingsCopyWith(
          _EncryptedApplicationSettings value,
          $Res Function(_EncryptedApplicationSettings) _then) =
      __$EncryptedApplicationSettingsCopyWithImpl;
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
      Map<String, String> settings,
      Map<String, String> encryptedSettings,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata,
      Base64String? encryptedSelf});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedApplicationSettingsCopyWithImpl<$Res>
    implements _$EncryptedApplicationSettingsCopyWith<$Res> {
  __$EncryptedApplicationSettingsCopyWithImpl(this._self, this._then);

  final _EncryptedApplicationSettings _self;
  final $Res Function(_EncryptedApplicationSettings) _then;

  /// Create a copy of EncryptedApplicationSettings
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
    Object? settings = null,
    Object? encryptedSettings = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? securityMetadata = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedApplicationSettings(
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
      settings: null == settings
          ? _self._settings
          : settings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSettings: null == encryptedSettings
          ? _self._encryptedSettings
          : encryptedSettings // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedApplicationSettings
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
