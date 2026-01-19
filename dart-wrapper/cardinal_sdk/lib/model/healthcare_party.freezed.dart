// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'healthcare_party.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$HealthcareParty {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  int? get deletionDate;
  List<Identifier> get identifier;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  String? get name;
  String? get lastName;
  String? get firstName;
  List<PersonName> get names;
  Gender? get gender;
  String? get civility;
  String? get companyName;
  String? get speciality;
  String? get bankAccount;
  String? get bic;
  String? get proxyBankAccount;
  String? get proxyBic;
  String? get invoiceHeader;
  String? get cbe;
  String? get ehp;
  String? get userId;
  String? get parentId;
  int? get convention;
  String? get nihii;
  String? get nihiiSpecCode;
  String? get ssin;
  List<DecryptedAddress> get addresses;
  List<String> get languages;
  Uint8List? get picture;
  Set<HealthcarePartyStatus> get statuses;
  List<HealthcarePartyHistoryStatus> get statusHistory;
  Set<CodeStub> get specialityCodes;
  Map<TelecomType, String> get sendFormats;
  String? get notes;
  List<DecryptedFinancialInstitutionInformation>
      get financialInstitutionInformation;
  Map<String, String>? get descr;
  String? get billingType;
  String? get type;
  String? get contactPerson;
  String? get contactPersonHcpId;
  String? get supervisorId;
  List<DecryptedFlatRateTarification> get flatRateTarifications;
  Map<String, String> get importedData;
  Map<String, String> get options;
  Set<DecryptedPropertyStub> get properties;
  bool get public;
  Set<DecryptedPropertyStub>? get publicProperties;
  Set<DecryptedPropertyStub>? get cryptoActorProperties;
  Map<String, List<HexString>> get hcPartyKeys;
  Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      get aesExchangeKeys;
  Map<AesExchangeKeyEncryptionKeypairIdentifier,
          Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
      get transferKeys;
  Map<String, HexString> get privateKeyShamirPartitions;
  CardinalRsaPublicKey? get publicKey;
  Set<CardinalRsaPublicKey> get publicKeysForOaepWithSha256;

  /// Create a copy of HealthcareParty
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $HealthcarePartyCopyWith<HealthcareParty> get copyWith =>
      _$HealthcarePartyCopyWithImpl<HealthcareParty>(
          this as HealthcareParty, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is HealthcareParty &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            const DeepCollectionEquality().equals(other.names, names) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            (identical(other.speciality, speciality) ||
                other.speciality == speciality) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            (identical(other.invoiceHeader, invoiceHeader) ||
                other.invoiceHeader == invoiceHeader) &&
            (identical(other.cbe, cbe) || other.cbe == cbe) &&
            (identical(other.ehp, ehp) || other.ehp == ehp) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.convention, convention) ||
                other.convention == convention) &&
            (identical(other.nihii, nihii) || other.nihii == nihii) &&
            (identical(other.nihiiSpecCode, nihiiSpecCode) ||
                other.nihiiSpecCode == nihiiSpecCode) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            const DeepCollectionEquality().equals(other.addresses, addresses) &&
            const DeepCollectionEquality().equals(other.languages, languages) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            const DeepCollectionEquality().equals(other.statuses, statuses) &&
            const DeepCollectionEquality()
                .equals(other.statusHistory, statusHistory) &&
            const DeepCollectionEquality()
                .equals(other.specialityCodes, specialityCodes) &&
            const DeepCollectionEquality()
                .equals(other.sendFormats, sendFormats) &&
            (identical(other.notes, notes) || other.notes == notes) &&
            const DeepCollectionEquality().equals(
                other.financialInstitutionInformation,
                financialInstitutionInformation) &&
            const DeepCollectionEquality().equals(other.descr, descr) &&
            (identical(other.billingType, billingType) ||
                other.billingType == billingType) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.contactPerson, contactPerson) ||
                other.contactPerson == contactPerson) &&
            (identical(other.contactPersonHcpId, contactPersonHcpId) ||
                other.contactPersonHcpId == contactPersonHcpId) &&
            (identical(other.supervisorId, supervisorId) ||
                other.supervisorId == supervisorId) &&
            const DeepCollectionEquality()
                .equals(other.flatRateTarifications, flatRateTarifications) &&
            const DeepCollectionEquality()
                .equals(other.importedData, importedData) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            (identical(other.public, public) || other.public == public) &&
            const DeepCollectionEquality()
                .equals(other.publicProperties, publicProperties) &&
            const DeepCollectionEquality()
                .equals(other.cryptoActorProperties, cryptoActorProperties) &&
            const DeepCollectionEquality()
                .equals(other.hcPartyKeys, hcPartyKeys) &&
            const DeepCollectionEquality()
                .equals(other.aesExchangeKeys, aesExchangeKeys) &&
            const DeepCollectionEquality()
                .equals(other.transferKeys, transferKeys) &&
            const DeepCollectionEquality().equals(
                other.privateKeyShamirPartitions, privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(
                other.publicKeysForOaepWithSha256,
                publicKeysForOaepWithSha256));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        deletionDate,
        const DeepCollectionEquality().hash(identifier),
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        name,
        lastName,
        firstName,
        const DeepCollectionEquality().hash(names),
        gender,
        civility,
        companyName,
        speciality,
        bankAccount,
        bic,
        proxyBankAccount,
        proxyBic,
        invoiceHeader,
        cbe,
        ehp,
        userId,
        parentId,
        convention,
        nihii,
        nihiiSpecCode,
        ssin,
        const DeepCollectionEquality().hash(addresses),
        const DeepCollectionEquality().hash(languages),
        const DeepCollectionEquality().hash(picture),
        const DeepCollectionEquality().hash(statuses),
        const DeepCollectionEquality().hash(statusHistory),
        const DeepCollectionEquality().hash(specialityCodes),
        const DeepCollectionEquality().hash(sendFormats),
        notes,
        const DeepCollectionEquality().hash(financialInstitutionInformation),
        const DeepCollectionEquality().hash(descr),
        billingType,
        type,
        contactPerson,
        contactPersonHcpId,
        supervisorId,
        const DeepCollectionEquality().hash(flatRateTarifications),
        const DeepCollectionEquality().hash(importedData),
        const DeepCollectionEquality().hash(options),
        const DeepCollectionEquality().hash(properties),
        public,
        const DeepCollectionEquality().hash(publicProperties),
        const DeepCollectionEquality().hash(cryptoActorProperties),
        const DeepCollectionEquality().hash(hcPartyKeys),
        const DeepCollectionEquality().hash(aesExchangeKeys),
        const DeepCollectionEquality().hash(transferKeys),
        const DeepCollectionEquality().hash(privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(publicKeysForOaepWithSha256)
      ]);

  @override
  String toString() {
    return 'HealthcareParty(id: $id, rev: $rev, created: $created, modified: $modified, deletionDate: $deletionDate, identifier: $identifier, tags: $tags, codes: $codes, name: $name, lastName: $lastName, firstName: $firstName, names: $names, gender: $gender, civility: $civility, companyName: $companyName, speciality: $speciality, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, invoiceHeader: $invoiceHeader, cbe: $cbe, ehp: $ehp, userId: $userId, parentId: $parentId, convention: $convention, nihii: $nihii, nihiiSpecCode: $nihiiSpecCode, ssin: $ssin, addresses: $addresses, languages: $languages, picture: $picture, statuses: $statuses, statusHistory: $statusHistory, specialityCodes: $specialityCodes, sendFormats: $sendFormats, notes: $notes, financialInstitutionInformation: $financialInstitutionInformation, descr: $descr, billingType: $billingType, type: $type, contactPerson: $contactPerson, contactPersonHcpId: $contactPersonHcpId, supervisorId: $supervisorId, flatRateTarifications: $flatRateTarifications, importedData: $importedData, options: $options, properties: $properties, public: $public, publicProperties: $publicProperties, cryptoActorProperties: $cryptoActorProperties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256)';
  }
}

/// @nodoc
abstract mixin class $HealthcarePartyCopyWith<$Res> {
  factory $HealthcarePartyCopyWith(
          HealthcareParty value, $Res Function(HealthcareParty) _then) =
      _$HealthcarePartyCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      int? deletionDate,
      List<Identifier> identifier,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      String? name,
      String? lastName,
      String? firstName,
      List<PersonName> names,
      Gender? gender,
      String? civility,
      String? companyName,
      String? speciality,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      String? invoiceHeader,
      String? cbe,
      String? ehp,
      String? userId,
      String? parentId,
      int? convention,
      String? nihii,
      String? nihiiSpecCode,
      String? ssin,
      List<DecryptedAddress> addresses,
      List<String> languages,
      Uint8List? picture,
      Set<HealthcarePartyStatus> statuses,
      List<HealthcarePartyHistoryStatus> statusHistory,
      Set<CodeStub> specialityCodes,
      Map<TelecomType, String> sendFormats,
      String? notes,
      List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      Map<String, String>? descr,
      String? billingType,
      String? type,
      String? contactPerson,
      String? contactPersonHcpId,
      String? supervisorId,
      List<DecryptedFlatRateTarification> flatRateTarifications,
      Map<String, String> importedData,
      Map<String, String> options,
      Set<DecryptedPropertyStub> properties,
      bool public,
      Set<DecryptedPropertyStub>? publicProperties,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      Map<String, List<HexString>> hcPartyKeys,
      Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys,
      Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys,
      Map<String, HexString> privateKeyShamirPartitions,
      CardinalRsaPublicKey? publicKey,
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256});
}

/// @nodoc
class _$HealthcarePartyCopyWithImpl<$Res>
    implements $HealthcarePartyCopyWith<$Res> {
  _$HealthcarePartyCopyWithImpl(this._self, this._then);

  final HealthcareParty _self;
  final $Res Function(HealthcareParty) _then;

  /// Create a copy of HealthcareParty
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? deletionDate = freezed,
    Object? identifier = null,
    Object? tags = null,
    Object? codes = null,
    Object? name = freezed,
    Object? lastName = freezed,
    Object? firstName = freezed,
    Object? names = null,
    Object? gender = freezed,
    Object? civility = freezed,
    Object? companyName = freezed,
    Object? speciality = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? invoiceHeader = freezed,
    Object? cbe = freezed,
    Object? ehp = freezed,
    Object? userId = freezed,
    Object? parentId = freezed,
    Object? convention = freezed,
    Object? nihii = freezed,
    Object? nihiiSpecCode = freezed,
    Object? ssin = freezed,
    Object? addresses = null,
    Object? languages = null,
    Object? picture = freezed,
    Object? statuses = null,
    Object? statusHistory = null,
    Object? specialityCodes = null,
    Object? sendFormats = null,
    Object? notes = freezed,
    Object? financialInstitutionInformation = null,
    Object? descr = freezed,
    Object? billingType = freezed,
    Object? type = freezed,
    Object? contactPerson = freezed,
    Object? contactPersonHcpId = freezed,
    Object? supervisorId = freezed,
    Object? flatRateTarifications = null,
    Object? importedData = null,
    Object? options = null,
    Object? properties = null,
    Object? public = null,
    Object? publicProperties = freezed,
    Object? cryptoActorProperties = freezed,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self.names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      speciality: freezed == speciality
          ? _self.speciality
          : speciality // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceHeader: freezed == invoiceHeader
          ? _self.invoiceHeader
          : invoiceHeader // ignore: cast_nullable_to_non_nullable
              as String?,
      cbe: freezed == cbe
          ? _self.cbe
          : cbe // ignore: cast_nullable_to_non_nullable
              as String?,
      ehp: freezed == ehp
          ? _self.ehp
          : ehp // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      convention: freezed == convention
          ? _self.convention
          : convention // ignore: cast_nullable_to_non_nullable
              as int?,
      nihii: freezed == nihii
          ? _self.nihii
          : nihii // ignore: cast_nullable_to_non_nullable
              as String?,
      nihiiSpecCode: freezed == nihiiSpecCode
          ? _self.nihiiSpecCode
          : nihiiSpecCode // ignore: cast_nullable_to_non_nullable
              as String?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      addresses: null == addresses
          ? _self.addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<DecryptedAddress>,
      languages: null == languages
          ? _self.languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      statuses: null == statuses
          ? _self.statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Set<HealthcarePartyStatus>,
      statusHistory: null == statusHistory
          ? _self.statusHistory
          : statusHistory // ignore: cast_nullable_to_non_nullable
              as List<HealthcarePartyHistoryStatus>,
      specialityCodes: null == specialityCodes
          ? _self.specialityCodes
          : specialityCodes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      sendFormats: null == sendFormats
          ? _self.sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      notes: freezed == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as String?,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self.financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFinancialInstitutionInformation>,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      billingType: freezed == billingType
          ? _self.billingType
          : billingType // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      contactPerson: freezed == contactPerson
          ? _self.contactPerson
          : contactPerson // ignore: cast_nullable_to_non_nullable
              as String?,
      contactPersonHcpId: freezed == contactPersonHcpId
          ? _self.contactPersonHcpId
          : contactPersonHcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorId: freezed == supervisorId
          ? _self.supervisorId
          : supervisorId // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateTarifications: null == flatRateTarifications
          ? _self.flatRateTarifications
          : flatRateTarifications // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFlatRateTarification>,
      importedData: null == importedData
          ? _self.importedData
          : importedData // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      public: null == public
          ? _self.public
          : public // ignore: cast_nullable_to_non_nullable
              as bool,
      publicProperties: freezed == publicProperties
          ? _self.publicProperties
          : publicProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self.cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      hcPartyKeys: null == hcPartyKeys
          ? _self.hcPartyKeys
          : hcPartyKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, List<HexString>>,
      aesExchangeKeys: null == aesExchangeKeys
          ? _self.aesExchangeKeys
          : aesExchangeKeys // ignore: cast_nullable_to_non_nullable
              as Map<
                  AesExchangeKeyEntryKeyString,
                  Map<
                      String,
                      Map<AesExchangeKeyEncryptionKeypairIdentifier,
                          HexString>>>,
      transferKeys: null == transferKeys
          ? _self.transferKeys
          : transferKeys // ignore: cast_nullable_to_non_nullable
              as Map<AesExchangeKeyEncryptionKeypairIdentifier,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
      privateKeyShamirPartitions: null == privateKeyShamirPartitions
          ? _self.privateKeyShamirPartitions
          : privateKeyShamirPartitions // ignore: cast_nullable_to_non_nullable
              as Map<String, HexString>,
      publicKey: freezed == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey?,
      publicKeysForOaepWithSha256: null == publicKeysForOaepWithSha256
          ? _self.publicKeysForOaepWithSha256
          : publicKeysForOaepWithSha256 // ignore: cast_nullable_to_non_nullable
              as Set<CardinalRsaPublicKey>,
    ));
  }
}

/// @nodoc

class _HealthcareParty implements HealthcareParty {
  const _HealthcareParty(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.deletionDate = null,
      final List<Identifier> identifier = const [],
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.name = null,
      this.lastName = null,
      this.firstName = null,
      final List<PersonName> names = const [],
      this.gender = null,
      this.civility = null,
      this.companyName = null,
      this.speciality = null,
      this.bankAccount = null,
      this.bic = null,
      this.proxyBankAccount = null,
      this.proxyBic = null,
      this.invoiceHeader = null,
      this.cbe = null,
      this.ehp = null,
      this.userId = null,
      this.parentId = null,
      this.convention = null,
      this.nihii = null,
      this.nihiiSpecCode = null,
      this.ssin = null,
      final List<DecryptedAddress> addresses = const [],
      final List<String> languages = const [],
      this.picture = null,
      final Set<HealthcarePartyStatus> statuses = const {},
      final List<HealthcarePartyHistoryStatus> statusHistory = const [],
      final Set<CodeStub> specialityCodes = const {},
      final Map<TelecomType, String> sendFormats = const {},
      this.notes = null,
      final List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation = const [],
      final Map<String, String>? descr = const {},
      this.billingType = null,
      this.type = null,
      this.contactPerson = null,
      this.contactPersonHcpId = null,
      this.supervisorId = null,
      final List<DecryptedFlatRateTarification> flatRateTarifications =
          const [],
      final Map<String, String> importedData = const {},
      final Map<String, String> options = const {},
      final Set<DecryptedPropertyStub> properties = const {},
      this.public = false,
      final Set<DecryptedPropertyStub>? publicProperties = null,
      final Set<DecryptedPropertyStub>? cryptoActorProperties = null,
      final Map<String, List<HexString>> hcPartyKeys = const {},
      final Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys = const {},
      final Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys = const {},
      final Map<String, HexString> privateKeyShamirPartitions = const {},
      this.publicKey = null,
      final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = const {}})
      : _identifier = identifier,
        _tags = tags,
        _codes = codes,
        _names = names,
        _addresses = addresses,
        _languages = languages,
        _statuses = statuses,
        _statusHistory = statusHistory,
        _specialityCodes = specialityCodes,
        _sendFormats = sendFormats,
        _financialInstitutionInformation = financialInstitutionInformation,
        _descr = descr,
        _flatRateTarifications = flatRateTarifications,
        _importedData = importedData,
        _options = options,
        _properties = properties,
        _publicProperties = publicProperties,
        _cryptoActorProperties = cryptoActorProperties,
        _hcPartyKeys = hcPartyKeys,
        _aesExchangeKeys = aesExchangeKeys,
        _transferKeys = transferKeys,
        _privateKeyShamirPartitions = privateKeyShamirPartitions,
        _publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256;

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
  final int? deletionDate;
  final List<Identifier> _identifier;
  @override
  @JsonKey()
  List<Identifier> get identifier {
    if (_identifier is EqualUnmodifiableListView) return _identifier;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifier);
  }

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
  final String? name;
  @override
  @JsonKey()
  final String? lastName;
  @override
  @JsonKey()
  final String? firstName;
  final List<PersonName> _names;
  @override
  @JsonKey()
  List<PersonName> get names {
    if (_names is EqualUnmodifiableListView) return _names;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_names);
  }

  @override
  @JsonKey()
  final Gender? gender;
  @override
  @JsonKey()
  final String? civility;
  @override
  @JsonKey()
  final String? companyName;
  @override
  @JsonKey()
  final String? speciality;
  @override
  @JsonKey()
  final String? bankAccount;
  @override
  @JsonKey()
  final String? bic;
  @override
  @JsonKey()
  final String? proxyBankAccount;
  @override
  @JsonKey()
  final String? proxyBic;
  @override
  @JsonKey()
  final String? invoiceHeader;
  @override
  @JsonKey()
  final String? cbe;
  @override
  @JsonKey()
  final String? ehp;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? parentId;
  @override
  @JsonKey()
  final int? convention;
  @override
  @JsonKey()
  final String? nihii;
  @override
  @JsonKey()
  final String? nihiiSpecCode;
  @override
  @JsonKey()
  final String? ssin;
  final List<DecryptedAddress> _addresses;
  @override
  @JsonKey()
  List<DecryptedAddress> get addresses {
    if (_addresses is EqualUnmodifiableListView) return _addresses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_addresses);
  }

  final List<String> _languages;
  @override
  @JsonKey()
  List<String> get languages {
    if (_languages is EqualUnmodifiableListView) return _languages;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_languages);
  }

  @override
  @JsonKey()
  final Uint8List? picture;
  final Set<HealthcarePartyStatus> _statuses;
  @override
  @JsonKey()
  Set<HealthcarePartyStatus> get statuses {
    if (_statuses is EqualUnmodifiableSetView) return _statuses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_statuses);
  }

  final List<HealthcarePartyHistoryStatus> _statusHistory;
  @override
  @JsonKey()
  List<HealthcarePartyHistoryStatus> get statusHistory {
    if (_statusHistory is EqualUnmodifiableListView) return _statusHistory;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_statusHistory);
  }

  final Set<CodeStub> _specialityCodes;
  @override
  @JsonKey()
  Set<CodeStub> get specialityCodes {
    if (_specialityCodes is EqualUnmodifiableSetView) return _specialityCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_specialityCodes);
  }

  final Map<TelecomType, String> _sendFormats;
  @override
  @JsonKey()
  Map<TelecomType, String> get sendFormats {
    if (_sendFormats is EqualUnmodifiableMapView) return _sendFormats;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_sendFormats);
  }

  @override
  @JsonKey()
  final String? notes;
  final List<DecryptedFinancialInstitutionInformation>
      _financialInstitutionInformation;
  @override
  @JsonKey()
  List<DecryptedFinancialInstitutionInformation>
      get financialInstitutionInformation {
    if (_financialInstitutionInformation is EqualUnmodifiableListView)
      return _financialInstitutionInformation;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_financialInstitutionInformation);
  }

  final Map<String, String>? _descr;
  @override
  @JsonKey()
  Map<String, String>? get descr {
    final value = _descr;
    if (value == null) return null;
    if (_descr is EqualUnmodifiableMapView) return _descr;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final String? billingType;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final String? contactPerson;
  @override
  @JsonKey()
  final String? contactPersonHcpId;
  @override
  @JsonKey()
  final String? supervisorId;
  final List<DecryptedFlatRateTarification> _flatRateTarifications;
  @override
  @JsonKey()
  List<DecryptedFlatRateTarification> get flatRateTarifications {
    if (_flatRateTarifications is EqualUnmodifiableListView)
      return _flatRateTarifications;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_flatRateTarifications);
  }

  final Map<String, String> _importedData;
  @override
  @JsonKey()
  Map<String, String> get importedData {
    if (_importedData is EqualUnmodifiableMapView) return _importedData;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_importedData);
  }

  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  @override
  @JsonKey()
  final bool public;
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

  final Set<DecryptedPropertyStub>? _cryptoActorProperties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub>? get cryptoActorProperties {
    final value = _cryptoActorProperties;
    if (value == null) return null;
    if (_cryptoActorProperties is EqualUnmodifiableSetView)
      return _cryptoActorProperties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Map<String, List<HexString>> _hcPartyKeys;
  @override
  @JsonKey()
  Map<String, List<HexString>> get hcPartyKeys {
    if (_hcPartyKeys is EqualUnmodifiableMapView) return _hcPartyKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_hcPartyKeys);
  }

  final Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      _aesExchangeKeys;
  @override
  @JsonKey()
  Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      get aesExchangeKeys {
    if (_aesExchangeKeys is EqualUnmodifiableMapView) return _aesExchangeKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_aesExchangeKeys);
  }

  final Map<AesExchangeKeyEncryptionKeypairIdentifier,
      Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> _transferKeys;
  @override
  @JsonKey()
  Map<AesExchangeKeyEncryptionKeypairIdentifier,
          Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
      get transferKeys {
    if (_transferKeys is EqualUnmodifiableMapView) return _transferKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_transferKeys);
  }

  final Map<String, HexString> _privateKeyShamirPartitions;
  @override
  @JsonKey()
  Map<String, HexString> get privateKeyShamirPartitions {
    if (_privateKeyShamirPartitions is EqualUnmodifiableMapView)
      return _privateKeyShamirPartitions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_privateKeyShamirPartitions);
  }

  @override
  @JsonKey()
  final CardinalRsaPublicKey? publicKey;
  final Set<CardinalRsaPublicKey> _publicKeysForOaepWithSha256;
  @override
  @JsonKey()
  Set<CardinalRsaPublicKey> get publicKeysForOaepWithSha256 {
    if (_publicKeysForOaepWithSha256 is EqualUnmodifiableSetView)
      return _publicKeysForOaepWithSha256;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_publicKeysForOaepWithSha256);
  }

  /// Create a copy of HealthcareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$HealthcarePartyCopyWith<_HealthcareParty> get copyWith =>
      __$HealthcarePartyCopyWithImpl<_HealthcareParty>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _HealthcareParty &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            const DeepCollectionEquality().equals(other._names, _names) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            (identical(other.speciality, speciality) ||
                other.speciality == speciality) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            (identical(other.invoiceHeader, invoiceHeader) ||
                other.invoiceHeader == invoiceHeader) &&
            (identical(other.cbe, cbe) || other.cbe == cbe) &&
            (identical(other.ehp, ehp) || other.ehp == ehp) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.convention, convention) ||
                other.convention == convention) &&
            (identical(other.nihii, nihii) || other.nihii == nihii) &&
            (identical(other.nihiiSpecCode, nihiiSpecCode) ||
                other.nihiiSpecCode == nihiiSpecCode) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            const DeepCollectionEquality()
                .equals(other._addresses, _addresses) &&
            const DeepCollectionEquality()
                .equals(other._languages, _languages) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            const DeepCollectionEquality().equals(other._statuses, _statuses) &&
            const DeepCollectionEquality()
                .equals(other._statusHistory, _statusHistory) &&
            const DeepCollectionEquality()
                .equals(other._specialityCodes, _specialityCodes) &&
            const DeepCollectionEquality()
                .equals(other._sendFormats, _sendFormats) &&
            (identical(other.notes, notes) || other.notes == notes) &&
            const DeepCollectionEquality().equals(
                other._financialInstitutionInformation,
                _financialInstitutionInformation) &&
            const DeepCollectionEquality().equals(other._descr, _descr) &&
            (identical(other.billingType, billingType) ||
                other.billingType == billingType) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.contactPerson, contactPerson) ||
                other.contactPerson == contactPerson) &&
            (identical(other.contactPersonHcpId, contactPersonHcpId) ||
                other.contactPersonHcpId == contactPersonHcpId) &&
            (identical(other.supervisorId, supervisorId) ||
                other.supervisorId == supervisorId) &&
            const DeepCollectionEquality()
                .equals(other._flatRateTarifications, _flatRateTarifications) &&
            const DeepCollectionEquality()
                .equals(other._importedData, _importedData) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            (identical(other.public, public) || other.public == public) &&
            const DeepCollectionEquality()
                .equals(other._publicProperties, _publicProperties) &&
            const DeepCollectionEquality()
                .equals(other._cryptoActorProperties, _cryptoActorProperties) &&
            const DeepCollectionEquality()
                .equals(other._hcPartyKeys, _hcPartyKeys) &&
            const DeepCollectionEquality()
                .equals(other._aesExchangeKeys, _aesExchangeKeys) &&
            const DeepCollectionEquality()
                .equals(other._transferKeys, _transferKeys) &&
            const DeepCollectionEquality().equals(
                other._privateKeyShamirPartitions,
                _privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(
                other._publicKeysForOaepWithSha256,
                _publicKeysForOaepWithSha256));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        deletionDate,
        const DeepCollectionEquality().hash(_identifier),
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        name,
        lastName,
        firstName,
        const DeepCollectionEquality().hash(_names),
        gender,
        civility,
        companyName,
        speciality,
        bankAccount,
        bic,
        proxyBankAccount,
        proxyBic,
        invoiceHeader,
        cbe,
        ehp,
        userId,
        parentId,
        convention,
        nihii,
        nihiiSpecCode,
        ssin,
        const DeepCollectionEquality().hash(_addresses),
        const DeepCollectionEquality().hash(_languages),
        const DeepCollectionEquality().hash(picture),
        const DeepCollectionEquality().hash(_statuses),
        const DeepCollectionEquality().hash(_statusHistory),
        const DeepCollectionEquality().hash(_specialityCodes),
        const DeepCollectionEquality().hash(_sendFormats),
        notes,
        const DeepCollectionEquality().hash(_financialInstitutionInformation),
        const DeepCollectionEquality().hash(_descr),
        billingType,
        type,
        contactPerson,
        contactPersonHcpId,
        supervisorId,
        const DeepCollectionEquality().hash(_flatRateTarifications),
        const DeepCollectionEquality().hash(_importedData),
        const DeepCollectionEquality().hash(_options),
        const DeepCollectionEquality().hash(_properties),
        public,
        const DeepCollectionEquality().hash(_publicProperties),
        const DeepCollectionEquality().hash(_cryptoActorProperties),
        const DeepCollectionEquality().hash(_hcPartyKeys),
        const DeepCollectionEquality().hash(_aesExchangeKeys),
        const DeepCollectionEquality().hash(_transferKeys),
        const DeepCollectionEquality().hash(_privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(_publicKeysForOaepWithSha256)
      ]);

  @override
  String toString() {
    return 'HealthcareParty(id: $id, rev: $rev, created: $created, modified: $modified, deletionDate: $deletionDate, identifier: $identifier, tags: $tags, codes: $codes, name: $name, lastName: $lastName, firstName: $firstName, names: $names, gender: $gender, civility: $civility, companyName: $companyName, speciality: $speciality, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, invoiceHeader: $invoiceHeader, cbe: $cbe, ehp: $ehp, userId: $userId, parentId: $parentId, convention: $convention, nihii: $nihii, nihiiSpecCode: $nihiiSpecCode, ssin: $ssin, addresses: $addresses, languages: $languages, picture: $picture, statuses: $statuses, statusHistory: $statusHistory, specialityCodes: $specialityCodes, sendFormats: $sendFormats, notes: $notes, financialInstitutionInformation: $financialInstitutionInformation, descr: $descr, billingType: $billingType, type: $type, contactPerson: $contactPerson, contactPersonHcpId: $contactPersonHcpId, supervisorId: $supervisorId, flatRateTarifications: $flatRateTarifications, importedData: $importedData, options: $options, properties: $properties, public: $public, publicProperties: $publicProperties, cryptoActorProperties: $cryptoActorProperties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256)';
  }
}

/// @nodoc
abstract mixin class _$HealthcarePartyCopyWith<$Res>
    implements $HealthcarePartyCopyWith<$Res> {
  factory _$HealthcarePartyCopyWith(
          _HealthcareParty value, $Res Function(_HealthcareParty) _then) =
      __$HealthcarePartyCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      int? deletionDate,
      List<Identifier> identifier,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      String? name,
      String? lastName,
      String? firstName,
      List<PersonName> names,
      Gender? gender,
      String? civility,
      String? companyName,
      String? speciality,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      String? invoiceHeader,
      String? cbe,
      String? ehp,
      String? userId,
      String? parentId,
      int? convention,
      String? nihii,
      String? nihiiSpecCode,
      String? ssin,
      List<DecryptedAddress> addresses,
      List<String> languages,
      Uint8List? picture,
      Set<HealthcarePartyStatus> statuses,
      List<HealthcarePartyHistoryStatus> statusHistory,
      Set<CodeStub> specialityCodes,
      Map<TelecomType, String> sendFormats,
      String? notes,
      List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      Map<String, String>? descr,
      String? billingType,
      String? type,
      String? contactPerson,
      String? contactPersonHcpId,
      String? supervisorId,
      List<DecryptedFlatRateTarification> flatRateTarifications,
      Map<String, String> importedData,
      Map<String, String> options,
      Set<DecryptedPropertyStub> properties,
      bool public,
      Set<DecryptedPropertyStub>? publicProperties,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      Map<String, List<HexString>> hcPartyKeys,
      Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys,
      Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys,
      Map<String, HexString> privateKeyShamirPartitions,
      CardinalRsaPublicKey? publicKey,
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256});
}

/// @nodoc
class __$HealthcarePartyCopyWithImpl<$Res>
    implements _$HealthcarePartyCopyWith<$Res> {
  __$HealthcarePartyCopyWithImpl(this._self, this._then);

  final _HealthcareParty _self;
  final $Res Function(_HealthcareParty) _then;

  /// Create a copy of HealthcareParty
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? deletionDate = freezed,
    Object? identifier = null,
    Object? tags = null,
    Object? codes = null,
    Object? name = freezed,
    Object? lastName = freezed,
    Object? firstName = freezed,
    Object? names = null,
    Object? gender = freezed,
    Object? civility = freezed,
    Object? companyName = freezed,
    Object? speciality = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? invoiceHeader = freezed,
    Object? cbe = freezed,
    Object? ehp = freezed,
    Object? userId = freezed,
    Object? parentId = freezed,
    Object? convention = freezed,
    Object? nihii = freezed,
    Object? nihiiSpecCode = freezed,
    Object? ssin = freezed,
    Object? addresses = null,
    Object? languages = null,
    Object? picture = freezed,
    Object? statuses = null,
    Object? statusHistory = null,
    Object? specialityCodes = null,
    Object? sendFormats = null,
    Object? notes = freezed,
    Object? financialInstitutionInformation = null,
    Object? descr = freezed,
    Object? billingType = freezed,
    Object? type = freezed,
    Object? contactPerson = freezed,
    Object? contactPersonHcpId = freezed,
    Object? supervisorId = freezed,
    Object? flatRateTarifications = null,
    Object? importedData = null,
    Object? options = null,
    Object? properties = null,
    Object? public = null,
    Object? publicProperties = freezed,
    Object? cryptoActorProperties = freezed,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
  }) {
    return _then(_HealthcareParty(
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self._names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      speciality: freezed == speciality
          ? _self.speciality
          : speciality // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceHeader: freezed == invoiceHeader
          ? _self.invoiceHeader
          : invoiceHeader // ignore: cast_nullable_to_non_nullable
              as String?,
      cbe: freezed == cbe
          ? _self.cbe
          : cbe // ignore: cast_nullable_to_non_nullable
              as String?,
      ehp: freezed == ehp
          ? _self.ehp
          : ehp // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      convention: freezed == convention
          ? _self.convention
          : convention // ignore: cast_nullable_to_non_nullable
              as int?,
      nihii: freezed == nihii
          ? _self.nihii
          : nihii // ignore: cast_nullable_to_non_nullable
              as String?,
      nihiiSpecCode: freezed == nihiiSpecCode
          ? _self.nihiiSpecCode
          : nihiiSpecCode // ignore: cast_nullable_to_non_nullable
              as String?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      addresses: null == addresses
          ? _self._addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<DecryptedAddress>,
      languages: null == languages
          ? _self._languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      statuses: null == statuses
          ? _self._statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Set<HealthcarePartyStatus>,
      statusHistory: null == statusHistory
          ? _self._statusHistory
          : statusHistory // ignore: cast_nullable_to_non_nullable
              as List<HealthcarePartyHistoryStatus>,
      specialityCodes: null == specialityCodes
          ? _self._specialityCodes
          : specialityCodes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      sendFormats: null == sendFormats
          ? _self._sendFormats
          : sendFormats // ignore: cast_nullable_to_non_nullable
              as Map<TelecomType, String>,
      notes: freezed == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as String?,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self._financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFinancialInstitutionInformation>,
      descr: freezed == descr
          ? _self._descr
          : descr // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      billingType: freezed == billingType
          ? _self.billingType
          : billingType // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      contactPerson: freezed == contactPerson
          ? _self.contactPerson
          : contactPerson // ignore: cast_nullable_to_non_nullable
              as String?,
      contactPersonHcpId: freezed == contactPersonHcpId
          ? _self.contactPersonHcpId
          : contactPersonHcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorId: freezed == supervisorId
          ? _self.supervisorId
          : supervisorId // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateTarifications: null == flatRateTarifications
          ? _self._flatRateTarifications
          : flatRateTarifications // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFlatRateTarification>,
      importedData: null == importedData
          ? _self._importedData
          : importedData // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      public: null == public
          ? _self.public
          : public // ignore: cast_nullable_to_non_nullable
              as bool,
      publicProperties: freezed == publicProperties
          ? _self._publicProperties
          : publicProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self._cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      hcPartyKeys: null == hcPartyKeys
          ? _self._hcPartyKeys
          : hcPartyKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, List<HexString>>,
      aesExchangeKeys: null == aesExchangeKeys
          ? _self._aesExchangeKeys
          : aesExchangeKeys // ignore: cast_nullable_to_non_nullable
              as Map<
                  AesExchangeKeyEntryKeyString,
                  Map<
                      String,
                      Map<AesExchangeKeyEncryptionKeypairIdentifier,
                          HexString>>>,
      transferKeys: null == transferKeys
          ? _self._transferKeys
          : transferKeys // ignore: cast_nullable_to_non_nullable
              as Map<AesExchangeKeyEncryptionKeypairIdentifier,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
      privateKeyShamirPartitions: null == privateKeyShamirPartitions
          ? _self._privateKeyShamirPartitions
          : privateKeyShamirPartitions // ignore: cast_nullable_to_non_nullable
              as Map<String, HexString>,
      publicKey: freezed == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey?,
      publicKeysForOaepWithSha256: null == publicKeysForOaepWithSha256
          ? _self._publicKeysForOaepWithSha256
          : publicKeysForOaepWithSha256 // ignore: cast_nullable_to_non_nullable
              as Set<CardinalRsaPublicKey>,
    ));
  }
}

// dart format on
