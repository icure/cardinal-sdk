// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'patient.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedPatient {
  String get id;
  List<Identifier> get identifier;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  String? get firstName;
  String? get lastName;
  List<PersonName> get names;
  String? get companyName;
  List<String> get languages;
  List<EncryptedAddress> get addresses;
  String? get civility;
  Gender? get gender;
  Gender? get birthSex;
  String? get mergeToPatientId;
  Set<String> get mergedIds;
  String? get alias;
  bool get active;
  String get deactivationReason;
  int? get deactivationDate;
  String? get ssin;
  String? get maidenName;
  String? get spouseName;
  String? get partnerName;
  PersonalStatus? get personalStatus;
  int? get dateOfBirth;
  int? get dateOfDeath;
  int? get timestampOfLatestEidReading;
  String? get placeOfBirth;
  String? get placeOfDeath;
  bool? get deceased;
  String? get education;
  String? get profession;
  List<Annotation> get notes;
  String? get note;
  String? get administrativeNote;
  String? get nationality;
  String? get race;
  String? get ethnicity;
  String? get preferredUserId;
  Uint8List? get picture;
  String? get externalId;
  List<EncryptedInsurability> get insurabilities;
  List<Partnership> get partnerships;
  List<EncryptedPatientHealthCareParty> get patientHealthCareParties;
  List<EncryptedFinancialInstitutionInformation>
      get financialInstitutionInformation;
  List<EncryptedMedicalHouseContract> get medicalHouseContracts;
  List<CodeStub> get patientProfessions;
  Map<String, List<String>> get parameters;
  Set<EncryptedPropertyStub> get properties;
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
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  Set<DecryptedPropertyStub>? get cryptoActorProperties;
  String? get medicalLocationId;
  Set<String> get nonDuplicateIds;
  Set<String> get encryptedAdministrativesDocuments;
  String? get comment;
  String? get warning;
  CodeStub? get fatherBirthCountry;
  CodeStub? get birthCountry;
  CodeStub? get nativeCountry;
  CodeStub? get socialStatus;
  CodeStub? get mainSourceOfIncome;
  List<EncryptedSchoolingInfo> get schoolingInfos;
  List<EncryptedEmploymentInfo> get employementInfos;
  Never? get parentId;

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedPatientCopyWith<EncryptedPatient> get copyWith =>
      _$EncryptedPatientCopyWithImpl<EncryptedPatient>(
          this as EncryptedPatient, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedPatient &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality().equals(other.names, names) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            const DeepCollectionEquality().equals(other.languages, languages) &&
            const DeepCollectionEquality().equals(other.addresses, addresses) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.birthSex, birthSex) ||
                other.birthSex == birthSex) &&
            (identical(other.mergeToPatientId, mergeToPatientId) ||
                other.mergeToPatientId == mergeToPatientId) &&
            const DeepCollectionEquality().equals(other.mergedIds, mergedIds) &&
            (identical(other.alias, alias) || other.alias == alias) &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.deactivationReason, deactivationReason) ||
                other.deactivationReason == deactivationReason) &&
            (identical(other.deactivationDate, deactivationDate) ||
                other.deactivationDate == deactivationDate) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.maidenName, maidenName) ||
                other.maidenName == maidenName) &&
            (identical(other.spouseName, spouseName) ||
                other.spouseName == spouseName) &&
            (identical(other.partnerName, partnerName) ||
                other.partnerName == partnerName) &&
            (identical(other.personalStatus, personalStatus) ||
                other.personalStatus == personalStatus) &&
            (identical(other.dateOfBirth, dateOfBirth) ||
                other.dateOfBirth == dateOfBirth) &&
            (identical(other.dateOfDeath, dateOfDeath) ||
                other.dateOfDeath == dateOfDeath) &&
            (identical(other.timestampOfLatestEidReading, timestampOfLatestEidReading) ||
                other.timestampOfLatestEidReading ==
                    timestampOfLatestEidReading) &&
            (identical(other.placeOfBirth, placeOfBirth) ||
                other.placeOfBirth == placeOfBirth) &&
            (identical(other.placeOfDeath, placeOfDeath) ||
                other.placeOfDeath == placeOfDeath) &&
            (identical(other.deceased, deceased) ||
                other.deceased == deceased) &&
            (identical(other.education, education) ||
                other.education == education) &&
            (identical(other.profession, profession) ||
                other.profession == profession) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.administrativeNote, administrativeNote) ||
                other.administrativeNote == administrativeNote) &&
            (identical(other.nationality, nationality) ||
                other.nationality == nationality) &&
            (identical(other.race, race) || other.race == race) &&
            (identical(other.ethnicity, ethnicity) ||
                other.ethnicity == ethnicity) &&
            (identical(other.preferredUserId, preferredUserId) ||
                other.preferredUserId == preferredUserId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            const DeepCollectionEquality()
                .equals(other.insurabilities, insurabilities) &&
            const DeepCollectionEquality()
                .equals(other.partnerships, partnerships) &&
            const DeepCollectionEquality().equals(
                other.patientHealthCareParties, patientHealthCareParties) &&
            const DeepCollectionEquality().equals(
                other.financialInstitutionInformation,
                financialInstitutionInformation) &&
            const DeepCollectionEquality()
                .equals(other.medicalHouseContracts, medicalHouseContracts) &&
            const DeepCollectionEquality()
                .equals(other.patientProfessions, patientProfessions) &&
            const DeepCollectionEquality().equals(other.parameters, parameters) &&
            const DeepCollectionEquality().equals(other.properties, properties) &&
            const DeepCollectionEquality().equals(other.hcPartyKeys, hcPartyKeys) &&
            const DeepCollectionEquality().equals(other.aesExchangeKeys, aesExchangeKeys) &&
            const DeepCollectionEquality().equals(other.transferKeys, transferKeys) &&
            const DeepCollectionEquality().equals(other.privateKeyShamirPartitions, privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) || other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(other.publicKeysForOaepWithSha256, publicKeysForOaepWithSha256) &&
            const DeepCollectionEquality().equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality().equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other.delegations, delegations) &&
            const DeepCollectionEquality().equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other.cryptoActorProperties, cryptoActorProperties) &&
            (identical(other.medicalLocationId, medicalLocationId) || other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.nonDuplicateIds, nonDuplicateIds) &&
            const DeepCollectionEquality().equals(other.encryptedAdministrativesDocuments, encryptedAdministrativesDocuments) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.warning, warning) || other.warning == warning) &&
            (identical(other.fatherBirthCountry, fatherBirthCountry) || other.fatherBirthCountry == fatherBirthCountry) &&
            (identical(other.birthCountry, birthCountry) || other.birthCountry == birthCountry) &&
            (identical(other.nativeCountry, nativeCountry) || other.nativeCountry == nativeCountry) &&
            (identical(other.socialStatus, socialStatus) || other.socialStatus == socialStatus) &&
            (identical(other.mainSourceOfIncome, mainSourceOfIncome) || other.mainSourceOfIncome == mainSourceOfIncome) &&
            const DeepCollectionEquality().equals(other.schoolingInfos, schoolingInfos) &&
            const DeepCollectionEquality().equals(other.employementInfos, employementInfos) &&
            (identical(other.parentId, parentId) || other.parentId == parentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        const DeepCollectionEquality().hash(identifier),
        rev,
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        firstName,
        lastName,
        const DeepCollectionEquality().hash(names),
        companyName,
        const DeepCollectionEquality().hash(languages),
        const DeepCollectionEquality().hash(addresses),
        civility,
        gender,
        birthSex,
        mergeToPatientId,
        const DeepCollectionEquality().hash(mergedIds),
        alias,
        active,
        deactivationReason,
        deactivationDate,
        ssin,
        maidenName,
        spouseName,
        partnerName,
        personalStatus,
        dateOfBirth,
        dateOfDeath,
        timestampOfLatestEidReading,
        placeOfBirth,
        placeOfDeath,
        deceased,
        education,
        profession,
        const DeepCollectionEquality().hash(notes),
        note,
        administrativeNote,
        nationality,
        race,
        ethnicity,
        preferredUserId,
        const DeepCollectionEquality().hash(picture),
        externalId,
        const DeepCollectionEquality().hash(insurabilities),
        const DeepCollectionEquality().hash(partnerships),
        const DeepCollectionEquality().hash(patientHealthCareParties),
        const DeepCollectionEquality().hash(financialInstitutionInformation),
        const DeepCollectionEquality().hash(medicalHouseContracts),
        const DeepCollectionEquality().hash(patientProfessions),
        const DeepCollectionEquality().hash(parameters),
        const DeepCollectionEquality().hash(properties),
        const DeepCollectionEquality().hash(hcPartyKeys),
        const DeepCollectionEquality().hash(aesExchangeKeys),
        const DeepCollectionEquality().hash(transferKeys),
        const DeepCollectionEquality().hash(privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(cryptoActorProperties),
        medicalLocationId,
        const DeepCollectionEquality().hash(nonDuplicateIds),
        const DeepCollectionEquality().hash(encryptedAdministrativesDocuments),
        comment,
        warning,
        fatherBirthCountry,
        birthCountry,
        nativeCountry,
        socialStatus,
        mainSourceOfIncome,
        const DeepCollectionEquality().hash(schoolingInfos),
        const DeepCollectionEquality().hash(employementInfos),
        parentId
      ]);

  @override
  String toString() {
    return 'EncryptedPatient(id: $id, identifier: $identifier, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, firstName: $firstName, lastName: $lastName, names: $names, companyName: $companyName, languages: $languages, addresses: $addresses, civility: $civility, gender: $gender, birthSex: $birthSex, mergeToPatientId: $mergeToPatientId, mergedIds: $mergedIds, alias: $alias, active: $active, deactivationReason: $deactivationReason, deactivationDate: $deactivationDate, ssin: $ssin, maidenName: $maidenName, spouseName: $spouseName, partnerName: $partnerName, personalStatus: $personalStatus, dateOfBirth: $dateOfBirth, dateOfDeath: $dateOfDeath, timestampOfLatestEidReading: $timestampOfLatestEidReading, placeOfBirth: $placeOfBirth, placeOfDeath: $placeOfDeath, deceased: $deceased, education: $education, profession: $profession, notes: $notes, note: $note, administrativeNote: $administrativeNote, nationality: $nationality, race: $race, ethnicity: $ethnicity, preferredUserId: $preferredUserId, picture: $picture, externalId: $externalId, insurabilities: $insurabilities, partnerships: $partnerships, patientHealthCareParties: $patientHealthCareParties, financialInstitutionInformation: $financialInstitutionInformation, medicalHouseContracts: $medicalHouseContracts, patientProfessions: $patientProfessions, parameters: $parameters, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, cryptoActorProperties: $cryptoActorProperties, medicalLocationId: $medicalLocationId, nonDuplicateIds: $nonDuplicateIds, encryptedAdministrativesDocuments: $encryptedAdministrativesDocuments, comment: $comment, warning: $warning, fatherBirthCountry: $fatherBirthCountry, birthCountry: $birthCountry, nativeCountry: $nativeCountry, socialStatus: $socialStatus, mainSourceOfIncome: $mainSourceOfIncome, schoolingInfos: $schoolingInfos, employementInfos: $employementInfos, parentId: $parentId)';
  }
}

/// @nodoc
abstract mixin class $EncryptedPatientCopyWith<$Res> {
  factory $EncryptedPatientCopyWith(
          EncryptedPatient value, $Res Function(EncryptedPatient) _then) =
      _$EncryptedPatientCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifier,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? firstName,
      String? lastName,
      List<PersonName> names,
      String? companyName,
      List<String> languages,
      List<EncryptedAddress> addresses,
      String? civility,
      Gender? gender,
      Gender? birthSex,
      String? mergeToPatientId,
      Set<String> mergedIds,
      String? alias,
      bool active,
      String deactivationReason,
      int? deactivationDate,
      String? ssin,
      String? maidenName,
      String? spouseName,
      String? partnerName,
      PersonalStatus? personalStatus,
      int? dateOfBirth,
      int? dateOfDeath,
      int? timestampOfLatestEidReading,
      String? placeOfBirth,
      String? placeOfDeath,
      bool? deceased,
      String? education,
      String? profession,
      List<Annotation> notes,
      String? note,
      String? administrativeNote,
      String? nationality,
      String? race,
      String? ethnicity,
      String? preferredUserId,
      Uint8List? picture,
      String? externalId,
      List<EncryptedInsurability> insurabilities,
      List<Partnership> partnerships,
      List<EncryptedPatientHealthCareParty> patientHealthCareParties,
      List<EncryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      List<EncryptedMedicalHouseContract> medicalHouseContracts,
      List<CodeStub> patientProfessions,
      Map<String, List<String>> parameters,
      Set<EncryptedPropertyStub> properties,
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
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      String? medicalLocationId,
      Set<String> nonDuplicateIds,
      Set<String> encryptedAdministrativesDocuments,
      String? comment,
      String? warning,
      CodeStub? fatherBirthCountry,
      CodeStub? birthCountry,
      CodeStub? nativeCountry,
      CodeStub? socialStatus,
      CodeStub? mainSourceOfIncome,
      List<EncryptedSchoolingInfo> schoolingInfos,
      List<EncryptedEmploymentInfo> employementInfos,
      Never? parentId});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
  $CodeStubCopyWith<$Res>? get fatherBirthCountry;
  $CodeStubCopyWith<$Res>? get birthCountry;
  $CodeStubCopyWith<$Res>? get nativeCountry;
  $CodeStubCopyWith<$Res>? get socialStatus;
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome;
}

/// @nodoc
class _$EncryptedPatientCopyWithImpl<$Res>
    implements $EncryptedPatientCopyWith<$Res> {
  _$EncryptedPatientCopyWithImpl(this._self, this._then);

  final EncryptedPatient _self;
  final $Res Function(EncryptedPatient) _then;

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? identifier = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? names = null,
    Object? companyName = freezed,
    Object? languages = null,
    Object? addresses = null,
    Object? civility = freezed,
    Object? gender = freezed,
    Object? birthSex = freezed,
    Object? mergeToPatientId = freezed,
    Object? mergedIds = null,
    Object? alias = freezed,
    Object? active = null,
    Object? deactivationReason = null,
    Object? deactivationDate = freezed,
    Object? ssin = freezed,
    Object? maidenName = freezed,
    Object? spouseName = freezed,
    Object? partnerName = freezed,
    Object? personalStatus = freezed,
    Object? dateOfBirth = freezed,
    Object? dateOfDeath = freezed,
    Object? timestampOfLatestEidReading = freezed,
    Object? placeOfBirth = freezed,
    Object? placeOfDeath = freezed,
    Object? deceased = freezed,
    Object? education = freezed,
    Object? profession = freezed,
    Object? notes = null,
    Object? note = freezed,
    Object? administrativeNote = freezed,
    Object? nationality = freezed,
    Object? race = freezed,
    Object? ethnicity = freezed,
    Object? preferredUserId = freezed,
    Object? picture = freezed,
    Object? externalId = freezed,
    Object? insurabilities = null,
    Object? partnerships = null,
    Object? patientHealthCareParties = null,
    Object? financialInstitutionInformation = null,
    Object? medicalHouseContracts = null,
    Object? patientProfessions = null,
    Object? parameters = null,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? cryptoActorProperties = freezed,
    Object? medicalLocationId = freezed,
    Object? nonDuplicateIds = null,
    Object? encryptedAdministrativesDocuments = null,
    Object? comment = freezed,
    Object? warning = freezed,
    Object? fatherBirthCountry = freezed,
    Object? birthCountry = freezed,
    Object? nativeCountry = freezed,
    Object? socialStatus = freezed,
    Object? mainSourceOfIncome = freezed,
    Object? schoolingInfos = null,
    Object? employementInfos = null,
    Object? parentId = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self.names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      languages: null == languages
          ? _self.languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      addresses: null == addresses
          ? _self.addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<EncryptedAddress>,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      birthSex: freezed == birthSex
          ? _self.birthSex
          : birthSex // ignore: cast_nullable_to_non_nullable
              as Gender?,
      mergeToPatientId: freezed == mergeToPatientId
          ? _self.mergeToPatientId
          : mergeToPatientId // ignore: cast_nullable_to_non_nullable
              as String?,
      mergedIds: null == mergedIds
          ? _self.mergedIds
          : mergedIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      alias: freezed == alias
          ? _self.alias
          : alias // ignore: cast_nullable_to_non_nullable
              as String?,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      deactivationReason: null == deactivationReason
          ? _self.deactivationReason
          : deactivationReason // ignore: cast_nullable_to_non_nullable
              as String,
      deactivationDate: freezed == deactivationDate
          ? _self.deactivationDate
          : deactivationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      maidenName: freezed == maidenName
          ? _self.maidenName
          : maidenName // ignore: cast_nullable_to_non_nullable
              as String?,
      spouseName: freezed == spouseName
          ? _self.spouseName
          : spouseName // ignore: cast_nullable_to_non_nullable
              as String?,
      partnerName: freezed == partnerName
          ? _self.partnerName
          : partnerName // ignore: cast_nullable_to_non_nullable
              as String?,
      personalStatus: freezed == personalStatus
          ? _self.personalStatus
          : personalStatus // ignore: cast_nullable_to_non_nullable
              as PersonalStatus?,
      dateOfBirth: freezed == dateOfBirth
          ? _self.dateOfBirth
          : dateOfBirth // ignore: cast_nullable_to_non_nullable
              as int?,
      dateOfDeath: freezed == dateOfDeath
          ? _self.dateOfDeath
          : dateOfDeath // ignore: cast_nullable_to_non_nullable
              as int?,
      timestampOfLatestEidReading: freezed == timestampOfLatestEidReading
          ? _self.timestampOfLatestEidReading
          : timestampOfLatestEidReading // ignore: cast_nullable_to_non_nullable
              as int?,
      placeOfBirth: freezed == placeOfBirth
          ? _self.placeOfBirth
          : placeOfBirth // ignore: cast_nullable_to_non_nullable
              as String?,
      placeOfDeath: freezed == placeOfDeath
          ? _self.placeOfDeath
          : placeOfDeath // ignore: cast_nullable_to_non_nullable
              as String?,
      deceased: freezed == deceased
          ? _self.deceased
          : deceased // ignore: cast_nullable_to_non_nullable
              as bool?,
      education: freezed == education
          ? _self.education
          : education // ignore: cast_nullable_to_non_nullable
              as String?,
      profession: freezed == profession
          ? _self.profession
          : profession // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      administrativeNote: freezed == administrativeNote
          ? _self.administrativeNote
          : administrativeNote // ignore: cast_nullable_to_non_nullable
              as String?,
      nationality: freezed == nationality
          ? _self.nationality
          : nationality // ignore: cast_nullable_to_non_nullable
              as String?,
      race: freezed == race
          ? _self.race
          : race // ignore: cast_nullable_to_non_nullable
              as String?,
      ethnicity: freezed == ethnicity
          ? _self.ethnicity
          : ethnicity // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredUserId: freezed == preferredUserId
          ? _self.preferredUserId
          : preferredUserId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      insurabilities: null == insurabilities
          ? _self.insurabilities
          : insurabilities // ignore: cast_nullable_to_non_nullable
              as List<EncryptedInsurability>,
      partnerships: null == partnerships
          ? _self.partnerships
          : partnerships // ignore: cast_nullable_to_non_nullable
              as List<Partnership>,
      patientHealthCareParties: null == patientHealthCareParties
          ? _self.patientHealthCareParties
          : patientHealthCareParties // ignore: cast_nullable_to_non_nullable
              as List<EncryptedPatientHealthCareParty>,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self.financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<EncryptedFinancialInstitutionInformation>,
      medicalHouseContracts: null == medicalHouseContracts
          ? _self.medicalHouseContracts
          : medicalHouseContracts // ignore: cast_nullable_to_non_nullable
              as List<EncryptedMedicalHouseContract>,
      patientProfessions: null == patientProfessions
          ? _self.patientProfessions
          : patientProfessions // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      parameters: null == parameters
          ? _self.parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self.cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      nonDuplicateIds: null == nonDuplicateIds
          ? _self.nonDuplicateIds
          : nonDuplicateIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedAdministrativesDocuments: null ==
              encryptedAdministrativesDocuments
          ? _self.encryptedAdministrativesDocuments
          : encryptedAdministrativesDocuments // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      warning: freezed == warning
          ? _self.warning
          : warning // ignore: cast_nullable_to_non_nullable
              as String?,
      fatherBirthCountry: freezed == fatherBirthCountry
          ? _self.fatherBirthCountry
          : fatherBirthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      birthCountry: freezed == birthCountry
          ? _self.birthCountry
          : birthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      nativeCountry: freezed == nativeCountry
          ? _self.nativeCountry
          : nativeCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      socialStatus: freezed == socialStatus
          ? _self.socialStatus
          : socialStatus // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      mainSourceOfIncome: freezed == mainSourceOfIncome
          ? _self.mainSourceOfIncome
          : mainSourceOfIncome // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      schoolingInfos: null == schoolingInfos
          ? _self.schoolingInfos
          : schoolingInfos // ignore: cast_nullable_to_non_nullable
              as List<EncryptedSchoolingInfo>,
      employementInfos: null == employementInfos
          ? _self.employementInfos
          : employementInfos // ignore: cast_nullable_to_non_nullable
              as List<EncryptedEmploymentInfo>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as Never?,
    ));
  }

  /// Create a copy of EncryptedPatient
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

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get fatherBirthCountry {
    if (_self.fatherBirthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.fatherBirthCountry!, (value) {
      return _then(_self.copyWith(fatherBirthCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get birthCountry {
    if (_self.birthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.birthCountry!, (value) {
      return _then(_self.copyWith(birthCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get nativeCountry {
    if (_self.nativeCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.nativeCountry!, (value) {
      return _then(_self.copyWith(nativeCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get socialStatus {
    if (_self.socialStatus == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.socialStatus!, (value) {
      return _then(_self.copyWith(socialStatus: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome {
    if (_self.mainSourceOfIncome == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.mainSourceOfIncome!, (value) {
      return _then(_self.copyWith(mainSourceOfIncome: value));
    });
  }
}

/// @nodoc

class _EncryptedPatient implements EncryptedPatient {
  const _EncryptedPatient(
      {required this.id,
      final List<Identifier> identifier = const [],
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.firstName = null,
      this.lastName = null,
      final List<PersonName> names = const [],
      this.companyName = null,
      final List<String> languages = const [],
      final List<EncryptedAddress> addresses = const [],
      this.civility = null,
      this.gender = Gender.unknown,
      this.birthSex = Gender.unknown,
      this.mergeToPatientId = null,
      final Set<String> mergedIds = const {},
      this.alias = null,
      this.active = true,
      this.deactivationReason = "none",
      this.deactivationDate = null,
      this.ssin = null,
      this.maidenName = null,
      this.spouseName = null,
      this.partnerName = null,
      this.personalStatus = PersonalStatus.unknown,
      this.dateOfBirth = null,
      this.dateOfDeath = null,
      this.timestampOfLatestEidReading = null,
      this.placeOfBirth = null,
      this.placeOfDeath = null,
      this.deceased = null,
      this.education = null,
      this.profession = null,
      final List<Annotation> notes = const [],
      this.note = null,
      this.administrativeNote = null,
      this.nationality = null,
      this.race = null,
      this.ethnicity = null,
      this.preferredUserId = null,
      this.picture = null,
      this.externalId = null,
      final List<EncryptedInsurability> insurabilities = const [],
      final List<Partnership> partnerships = const [],
      final List<EncryptedPatientHealthCareParty> patientHealthCareParties =
          const [],
      final List<EncryptedFinancialInstitutionInformation>
          financialInstitutionInformation = const [],
      final List<EncryptedMedicalHouseContract> medicalHouseContracts =
          const [],
      final List<CodeStub> patientProfessions = const [],
      final Map<String, List<String>> parameters = const {},
      final Set<EncryptedPropertyStub> properties = const {},
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
      final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      final Set<DecryptedPropertyStub>? cryptoActorProperties = null,
      this.medicalLocationId = null,
      final Set<String> nonDuplicateIds = const {},
      final Set<String> encryptedAdministrativesDocuments = const {},
      this.comment = null,
      this.warning = null,
      this.fatherBirthCountry = null,
      this.birthCountry = null,
      this.nativeCountry = null,
      this.socialStatus = null,
      this.mainSourceOfIncome = null,
      final List<EncryptedSchoolingInfo> schoolingInfos = const [],
      final List<EncryptedEmploymentInfo> employementInfos = const [],
      this.parentId = null})
      : _identifier = identifier,
        _tags = tags,
        _codes = codes,
        _names = names,
        _languages = languages,
        _addresses = addresses,
        _mergedIds = mergedIds,
        _notes = notes,
        _insurabilities = insurabilities,
        _partnerships = partnerships,
        _patientHealthCareParties = patientHealthCareParties,
        _financialInstitutionInformation = financialInstitutionInformation,
        _medicalHouseContracts = medicalHouseContracts,
        _patientProfessions = patientProfessions,
        _parameters = parameters,
        _properties = properties,
        _hcPartyKeys = hcPartyKeys,
        _aesExchangeKeys = aesExchangeKeys,
        _transferKeys = transferKeys,
        _privateKeyShamirPartitions = privateKeyShamirPartitions,
        _publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _cryptoActorProperties = cryptoActorProperties,
        _nonDuplicateIds = nonDuplicateIds,
        _encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
        _schoolingInfos = schoolingInfos,
        _employementInfos = employementInfos;

  @override
  final String id;
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
  final String? firstName;
  @override
  @JsonKey()
  final String? lastName;
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
  final String? companyName;
  final List<String> _languages;
  @override
  @JsonKey()
  List<String> get languages {
    if (_languages is EqualUnmodifiableListView) return _languages;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_languages);
  }

  final List<EncryptedAddress> _addresses;
  @override
  @JsonKey()
  List<EncryptedAddress> get addresses {
    if (_addresses is EqualUnmodifiableListView) return _addresses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_addresses);
  }

  @override
  @JsonKey()
  final String? civility;
  @override
  @JsonKey()
  final Gender? gender;
  @override
  @JsonKey()
  final Gender? birthSex;
  @override
  @JsonKey()
  final String? mergeToPatientId;
  final Set<String> _mergedIds;
  @override
  @JsonKey()
  Set<String> get mergedIds {
    if (_mergedIds is EqualUnmodifiableSetView) return _mergedIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_mergedIds);
  }

  @override
  @JsonKey()
  final String? alias;
  @override
  @JsonKey()
  final bool active;
  @override
  @JsonKey()
  final String deactivationReason;
  @override
  @JsonKey()
  final int? deactivationDate;
  @override
  @JsonKey()
  final String? ssin;
  @override
  @JsonKey()
  final String? maidenName;
  @override
  @JsonKey()
  final String? spouseName;
  @override
  @JsonKey()
  final String? partnerName;
  @override
  @JsonKey()
  final PersonalStatus? personalStatus;
  @override
  @JsonKey()
  final int? dateOfBirth;
  @override
  @JsonKey()
  final int? dateOfDeath;
  @override
  @JsonKey()
  final int? timestampOfLatestEidReading;
  @override
  @JsonKey()
  final String? placeOfBirth;
  @override
  @JsonKey()
  final String? placeOfDeath;
  @override
  @JsonKey()
  final bool? deceased;
  @override
  @JsonKey()
  final String? education;
  @override
  @JsonKey()
  final String? profession;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  @override
  @JsonKey()
  final String? note;
  @override
  @JsonKey()
  final String? administrativeNote;
  @override
  @JsonKey()
  final String? nationality;
  @override
  @JsonKey()
  final String? race;
  @override
  @JsonKey()
  final String? ethnicity;
  @override
  @JsonKey()
  final String? preferredUserId;
  @override
  @JsonKey()
  final Uint8List? picture;
  @override
  @JsonKey()
  final String? externalId;
  final List<EncryptedInsurability> _insurabilities;
  @override
  @JsonKey()
  List<EncryptedInsurability> get insurabilities {
    if (_insurabilities is EqualUnmodifiableListView) return _insurabilities;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_insurabilities);
  }

  final List<Partnership> _partnerships;
  @override
  @JsonKey()
  List<Partnership> get partnerships {
    if (_partnerships is EqualUnmodifiableListView) return _partnerships;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_partnerships);
  }

  final List<EncryptedPatientHealthCareParty> _patientHealthCareParties;
  @override
  @JsonKey()
  List<EncryptedPatientHealthCareParty> get patientHealthCareParties {
    if (_patientHealthCareParties is EqualUnmodifiableListView)
      return _patientHealthCareParties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_patientHealthCareParties);
  }

  final List<EncryptedFinancialInstitutionInformation>
      _financialInstitutionInformation;
  @override
  @JsonKey()
  List<EncryptedFinancialInstitutionInformation>
      get financialInstitutionInformation {
    if (_financialInstitutionInformation is EqualUnmodifiableListView)
      return _financialInstitutionInformation;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_financialInstitutionInformation);
  }

  final List<EncryptedMedicalHouseContract> _medicalHouseContracts;
  @override
  @JsonKey()
  List<EncryptedMedicalHouseContract> get medicalHouseContracts {
    if (_medicalHouseContracts is EqualUnmodifiableListView)
      return _medicalHouseContracts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_medicalHouseContracts);
  }

  final List<CodeStub> _patientProfessions;
  @override
  @JsonKey()
  List<CodeStub> get patientProfessions {
    if (_patientProfessions is EqualUnmodifiableListView)
      return _patientProfessions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_patientProfessions);
  }

  final Map<String, List<String>> _parameters;
  @override
  @JsonKey()
  Map<String, List<String>> get parameters {
    if (_parameters is EqualUnmodifiableMapView) return _parameters;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_parameters);
  }

  final Set<EncryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<EncryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
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

  @override
  @JsonKey()
  final String? medicalLocationId;
  final Set<String> _nonDuplicateIds;
  @override
  @JsonKey()
  Set<String> get nonDuplicateIds {
    if (_nonDuplicateIds is EqualUnmodifiableSetView) return _nonDuplicateIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_nonDuplicateIds);
  }

  final Set<String> _encryptedAdministrativesDocuments;
  @override
  @JsonKey()
  Set<String> get encryptedAdministrativesDocuments {
    if (_encryptedAdministrativesDocuments is EqualUnmodifiableSetView)
      return _encryptedAdministrativesDocuments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_encryptedAdministrativesDocuments);
  }

  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final String? warning;
  @override
  @JsonKey()
  final CodeStub? fatherBirthCountry;
  @override
  @JsonKey()
  final CodeStub? birthCountry;
  @override
  @JsonKey()
  final CodeStub? nativeCountry;
  @override
  @JsonKey()
  final CodeStub? socialStatus;
  @override
  @JsonKey()
  final CodeStub? mainSourceOfIncome;
  final List<EncryptedSchoolingInfo> _schoolingInfos;
  @override
  @JsonKey()
  List<EncryptedSchoolingInfo> get schoolingInfos {
    if (_schoolingInfos is EqualUnmodifiableListView) return _schoolingInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_schoolingInfos);
  }

  final List<EncryptedEmploymentInfo> _employementInfos;
  @override
  @JsonKey()
  List<EncryptedEmploymentInfo> get employementInfos {
    if (_employementInfos is EqualUnmodifiableListView)
      return _employementInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_employementInfos);
  }

  @override
  @JsonKey()
  final Never? parentId;

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedPatientCopyWith<_EncryptedPatient> get copyWith =>
      __$EncryptedPatientCopyWithImpl<_EncryptedPatient>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedPatient &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality().equals(other._names, _names) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            const DeepCollectionEquality()
                .equals(other._languages, _languages) &&
            const DeepCollectionEquality()
                .equals(other._addresses, _addresses) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.birthSex, birthSex) ||
                other.birthSex == birthSex) &&
            (identical(other.mergeToPatientId, mergeToPatientId) ||
                other.mergeToPatientId == mergeToPatientId) &&
            const DeepCollectionEquality()
                .equals(other._mergedIds, _mergedIds) &&
            (identical(other.alias, alias) || other.alias == alias) &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.deactivationReason, deactivationReason) ||
                other.deactivationReason == deactivationReason) &&
            (identical(other.deactivationDate, deactivationDate) ||
                other.deactivationDate == deactivationDate) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.maidenName, maidenName) ||
                other.maidenName == maidenName) &&
            (identical(other.spouseName, spouseName) ||
                other.spouseName == spouseName) &&
            (identical(other.partnerName, partnerName) ||
                other.partnerName == partnerName) &&
            (identical(other.personalStatus, personalStatus) ||
                other.personalStatus == personalStatus) &&
            (identical(other.dateOfBirth, dateOfBirth) ||
                other.dateOfBirth == dateOfBirth) &&
            (identical(other.dateOfDeath, dateOfDeath) ||
                other.dateOfDeath == dateOfDeath) &&
            (identical(other.timestampOfLatestEidReading, timestampOfLatestEidReading) ||
                other.timestampOfLatestEidReading ==
                    timestampOfLatestEidReading) &&
            (identical(other.placeOfBirth, placeOfBirth) ||
                other.placeOfBirth == placeOfBirth) &&
            (identical(other.placeOfDeath, placeOfDeath) ||
                other.placeOfDeath == placeOfDeath) &&
            (identical(other.deceased, deceased) ||
                other.deceased == deceased) &&
            (identical(other.education, education) ||
                other.education == education) &&
            (identical(other.profession, profession) ||
                other.profession == profession) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.administrativeNote, administrativeNote) ||
                other.administrativeNote == administrativeNote) &&
            (identical(other.nationality, nationality) ||
                other.nationality == nationality) &&
            (identical(other.race, race) || other.race == race) &&
            (identical(other.ethnicity, ethnicity) ||
                other.ethnicity == ethnicity) &&
            (identical(other.preferredUserId, preferredUserId) ||
                other.preferredUserId == preferredUserId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            const DeepCollectionEquality()
                .equals(other._insurabilities, _insurabilities) &&
            const DeepCollectionEquality()
                .equals(other._partnerships, _partnerships) &&
            const DeepCollectionEquality().equals(
                other._patientHealthCareParties, _patientHealthCareParties) &&
            const DeepCollectionEquality().equals(
                other._financialInstitutionInformation,
                _financialInstitutionInformation) &&
            const DeepCollectionEquality().equals(other._medicalHouseContracts, _medicalHouseContracts) &&
            const DeepCollectionEquality().equals(other._patientProfessions, _patientProfessions) &&
            const DeepCollectionEquality().equals(other._parameters, _parameters) &&
            const DeepCollectionEquality().equals(other._properties, _properties) &&
            const DeepCollectionEquality().equals(other._hcPartyKeys, _hcPartyKeys) &&
            const DeepCollectionEquality().equals(other._aesExchangeKeys, _aesExchangeKeys) &&
            const DeepCollectionEquality().equals(other._transferKeys, _transferKeys) &&
            const DeepCollectionEquality().equals(other._privateKeyShamirPartitions, _privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) || other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(other._publicKeysForOaepWithSha256, _publicKeysForOaepWithSha256) &&
            const DeepCollectionEquality().equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality().equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other._delegations, _delegations) &&
            const DeepCollectionEquality().equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other._cryptoActorProperties, _cryptoActorProperties) &&
            (identical(other.medicalLocationId, medicalLocationId) || other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._nonDuplicateIds, _nonDuplicateIds) &&
            const DeepCollectionEquality().equals(other._encryptedAdministrativesDocuments, _encryptedAdministrativesDocuments) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.warning, warning) || other.warning == warning) &&
            (identical(other.fatherBirthCountry, fatherBirthCountry) || other.fatherBirthCountry == fatherBirthCountry) &&
            (identical(other.birthCountry, birthCountry) || other.birthCountry == birthCountry) &&
            (identical(other.nativeCountry, nativeCountry) || other.nativeCountry == nativeCountry) &&
            (identical(other.socialStatus, socialStatus) || other.socialStatus == socialStatus) &&
            (identical(other.mainSourceOfIncome, mainSourceOfIncome) || other.mainSourceOfIncome == mainSourceOfIncome) &&
            const DeepCollectionEquality().equals(other._schoolingInfos, _schoolingInfos) &&
            const DeepCollectionEquality().equals(other._employementInfos, _employementInfos) &&
            (identical(other.parentId, parentId) || other.parentId == parentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        const DeepCollectionEquality().hash(_identifier),
        rev,
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        firstName,
        lastName,
        const DeepCollectionEquality().hash(_names),
        companyName,
        const DeepCollectionEquality().hash(_languages),
        const DeepCollectionEquality().hash(_addresses),
        civility,
        gender,
        birthSex,
        mergeToPatientId,
        const DeepCollectionEquality().hash(_mergedIds),
        alias,
        active,
        deactivationReason,
        deactivationDate,
        ssin,
        maidenName,
        spouseName,
        partnerName,
        personalStatus,
        dateOfBirth,
        dateOfDeath,
        timestampOfLatestEidReading,
        placeOfBirth,
        placeOfDeath,
        deceased,
        education,
        profession,
        const DeepCollectionEquality().hash(_notes),
        note,
        administrativeNote,
        nationality,
        race,
        ethnicity,
        preferredUserId,
        const DeepCollectionEquality().hash(picture),
        externalId,
        const DeepCollectionEquality().hash(_insurabilities),
        const DeepCollectionEquality().hash(_partnerships),
        const DeepCollectionEquality().hash(_patientHealthCareParties),
        const DeepCollectionEquality().hash(_financialInstitutionInformation),
        const DeepCollectionEquality().hash(_medicalHouseContracts),
        const DeepCollectionEquality().hash(_patientProfessions),
        const DeepCollectionEquality().hash(_parameters),
        const DeepCollectionEquality().hash(_properties),
        const DeepCollectionEquality().hash(_hcPartyKeys),
        const DeepCollectionEquality().hash(_aesExchangeKeys),
        const DeepCollectionEquality().hash(_transferKeys),
        const DeepCollectionEquality().hash(_privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(_publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(_cryptoActorProperties),
        medicalLocationId,
        const DeepCollectionEquality().hash(_nonDuplicateIds),
        const DeepCollectionEquality().hash(_encryptedAdministrativesDocuments),
        comment,
        warning,
        fatherBirthCountry,
        birthCountry,
        nativeCountry,
        socialStatus,
        mainSourceOfIncome,
        const DeepCollectionEquality().hash(_schoolingInfos),
        const DeepCollectionEquality().hash(_employementInfos),
        parentId
      ]);

  @override
  String toString() {
    return 'EncryptedPatient(id: $id, identifier: $identifier, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, firstName: $firstName, lastName: $lastName, names: $names, companyName: $companyName, languages: $languages, addresses: $addresses, civility: $civility, gender: $gender, birthSex: $birthSex, mergeToPatientId: $mergeToPatientId, mergedIds: $mergedIds, alias: $alias, active: $active, deactivationReason: $deactivationReason, deactivationDate: $deactivationDate, ssin: $ssin, maidenName: $maidenName, spouseName: $spouseName, partnerName: $partnerName, personalStatus: $personalStatus, dateOfBirth: $dateOfBirth, dateOfDeath: $dateOfDeath, timestampOfLatestEidReading: $timestampOfLatestEidReading, placeOfBirth: $placeOfBirth, placeOfDeath: $placeOfDeath, deceased: $deceased, education: $education, profession: $profession, notes: $notes, note: $note, administrativeNote: $administrativeNote, nationality: $nationality, race: $race, ethnicity: $ethnicity, preferredUserId: $preferredUserId, picture: $picture, externalId: $externalId, insurabilities: $insurabilities, partnerships: $partnerships, patientHealthCareParties: $patientHealthCareParties, financialInstitutionInformation: $financialInstitutionInformation, medicalHouseContracts: $medicalHouseContracts, patientProfessions: $patientProfessions, parameters: $parameters, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, cryptoActorProperties: $cryptoActorProperties, medicalLocationId: $medicalLocationId, nonDuplicateIds: $nonDuplicateIds, encryptedAdministrativesDocuments: $encryptedAdministrativesDocuments, comment: $comment, warning: $warning, fatherBirthCountry: $fatherBirthCountry, birthCountry: $birthCountry, nativeCountry: $nativeCountry, socialStatus: $socialStatus, mainSourceOfIncome: $mainSourceOfIncome, schoolingInfos: $schoolingInfos, employementInfos: $employementInfos, parentId: $parentId)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedPatientCopyWith<$Res>
    implements $EncryptedPatientCopyWith<$Res> {
  factory _$EncryptedPatientCopyWith(
          _EncryptedPatient value, $Res Function(_EncryptedPatient) _then) =
      __$EncryptedPatientCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifier,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? firstName,
      String? lastName,
      List<PersonName> names,
      String? companyName,
      List<String> languages,
      List<EncryptedAddress> addresses,
      String? civility,
      Gender? gender,
      Gender? birthSex,
      String? mergeToPatientId,
      Set<String> mergedIds,
      String? alias,
      bool active,
      String deactivationReason,
      int? deactivationDate,
      String? ssin,
      String? maidenName,
      String? spouseName,
      String? partnerName,
      PersonalStatus? personalStatus,
      int? dateOfBirth,
      int? dateOfDeath,
      int? timestampOfLatestEidReading,
      String? placeOfBirth,
      String? placeOfDeath,
      bool? deceased,
      String? education,
      String? profession,
      List<Annotation> notes,
      String? note,
      String? administrativeNote,
      String? nationality,
      String? race,
      String? ethnicity,
      String? preferredUserId,
      Uint8List? picture,
      String? externalId,
      List<EncryptedInsurability> insurabilities,
      List<Partnership> partnerships,
      List<EncryptedPatientHealthCareParty> patientHealthCareParties,
      List<EncryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      List<EncryptedMedicalHouseContract> medicalHouseContracts,
      List<CodeStub> patientProfessions,
      Map<String, List<String>> parameters,
      Set<EncryptedPropertyStub> properties,
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
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      String? medicalLocationId,
      Set<String> nonDuplicateIds,
      Set<String> encryptedAdministrativesDocuments,
      String? comment,
      String? warning,
      CodeStub? fatherBirthCountry,
      CodeStub? birthCountry,
      CodeStub? nativeCountry,
      CodeStub? socialStatus,
      CodeStub? mainSourceOfIncome,
      List<EncryptedSchoolingInfo> schoolingInfos,
      List<EncryptedEmploymentInfo> employementInfos,
      Never? parentId});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
  @override
  $CodeStubCopyWith<$Res>? get fatherBirthCountry;
  @override
  $CodeStubCopyWith<$Res>? get birthCountry;
  @override
  $CodeStubCopyWith<$Res>? get nativeCountry;
  @override
  $CodeStubCopyWith<$Res>? get socialStatus;
  @override
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome;
}

/// @nodoc
class __$EncryptedPatientCopyWithImpl<$Res>
    implements _$EncryptedPatientCopyWith<$Res> {
  __$EncryptedPatientCopyWithImpl(this._self, this._then);

  final _EncryptedPatient _self;
  final $Res Function(_EncryptedPatient) _then;

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? identifier = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? names = null,
    Object? companyName = freezed,
    Object? languages = null,
    Object? addresses = null,
    Object? civility = freezed,
    Object? gender = freezed,
    Object? birthSex = freezed,
    Object? mergeToPatientId = freezed,
    Object? mergedIds = null,
    Object? alias = freezed,
    Object? active = null,
    Object? deactivationReason = null,
    Object? deactivationDate = freezed,
    Object? ssin = freezed,
    Object? maidenName = freezed,
    Object? spouseName = freezed,
    Object? partnerName = freezed,
    Object? personalStatus = freezed,
    Object? dateOfBirth = freezed,
    Object? dateOfDeath = freezed,
    Object? timestampOfLatestEidReading = freezed,
    Object? placeOfBirth = freezed,
    Object? placeOfDeath = freezed,
    Object? deceased = freezed,
    Object? education = freezed,
    Object? profession = freezed,
    Object? notes = null,
    Object? note = freezed,
    Object? administrativeNote = freezed,
    Object? nationality = freezed,
    Object? race = freezed,
    Object? ethnicity = freezed,
    Object? preferredUserId = freezed,
    Object? picture = freezed,
    Object? externalId = freezed,
    Object? insurabilities = null,
    Object? partnerships = null,
    Object? patientHealthCareParties = null,
    Object? financialInstitutionInformation = null,
    Object? medicalHouseContracts = null,
    Object? patientProfessions = null,
    Object? parameters = null,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? cryptoActorProperties = freezed,
    Object? medicalLocationId = freezed,
    Object? nonDuplicateIds = null,
    Object? encryptedAdministrativesDocuments = null,
    Object? comment = freezed,
    Object? warning = freezed,
    Object? fatherBirthCountry = freezed,
    Object? birthCountry = freezed,
    Object? nativeCountry = freezed,
    Object? socialStatus = freezed,
    Object? mainSourceOfIncome = freezed,
    Object? schoolingInfos = null,
    Object? employementInfos = null,
    Object? parentId = freezed,
  }) {
    return _then(_EncryptedPatient(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self._names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      languages: null == languages
          ? _self._languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      addresses: null == addresses
          ? _self._addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<EncryptedAddress>,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      birthSex: freezed == birthSex
          ? _self.birthSex
          : birthSex // ignore: cast_nullable_to_non_nullable
              as Gender?,
      mergeToPatientId: freezed == mergeToPatientId
          ? _self.mergeToPatientId
          : mergeToPatientId // ignore: cast_nullable_to_non_nullable
              as String?,
      mergedIds: null == mergedIds
          ? _self._mergedIds
          : mergedIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      alias: freezed == alias
          ? _self.alias
          : alias // ignore: cast_nullable_to_non_nullable
              as String?,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      deactivationReason: null == deactivationReason
          ? _self.deactivationReason
          : deactivationReason // ignore: cast_nullable_to_non_nullable
              as String,
      deactivationDate: freezed == deactivationDate
          ? _self.deactivationDate
          : deactivationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      maidenName: freezed == maidenName
          ? _self.maidenName
          : maidenName // ignore: cast_nullable_to_non_nullable
              as String?,
      spouseName: freezed == spouseName
          ? _self.spouseName
          : spouseName // ignore: cast_nullable_to_non_nullable
              as String?,
      partnerName: freezed == partnerName
          ? _self.partnerName
          : partnerName // ignore: cast_nullable_to_non_nullable
              as String?,
      personalStatus: freezed == personalStatus
          ? _self.personalStatus
          : personalStatus // ignore: cast_nullable_to_non_nullable
              as PersonalStatus?,
      dateOfBirth: freezed == dateOfBirth
          ? _self.dateOfBirth
          : dateOfBirth // ignore: cast_nullable_to_non_nullable
              as int?,
      dateOfDeath: freezed == dateOfDeath
          ? _self.dateOfDeath
          : dateOfDeath // ignore: cast_nullable_to_non_nullable
              as int?,
      timestampOfLatestEidReading: freezed == timestampOfLatestEidReading
          ? _self.timestampOfLatestEidReading
          : timestampOfLatestEidReading // ignore: cast_nullable_to_non_nullable
              as int?,
      placeOfBirth: freezed == placeOfBirth
          ? _self.placeOfBirth
          : placeOfBirth // ignore: cast_nullable_to_non_nullable
              as String?,
      placeOfDeath: freezed == placeOfDeath
          ? _self.placeOfDeath
          : placeOfDeath // ignore: cast_nullable_to_non_nullable
              as String?,
      deceased: freezed == deceased
          ? _self.deceased
          : deceased // ignore: cast_nullable_to_non_nullable
              as bool?,
      education: freezed == education
          ? _self.education
          : education // ignore: cast_nullable_to_non_nullable
              as String?,
      profession: freezed == profession
          ? _self.profession
          : profession // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      administrativeNote: freezed == administrativeNote
          ? _self.administrativeNote
          : administrativeNote // ignore: cast_nullable_to_non_nullable
              as String?,
      nationality: freezed == nationality
          ? _self.nationality
          : nationality // ignore: cast_nullable_to_non_nullable
              as String?,
      race: freezed == race
          ? _self.race
          : race // ignore: cast_nullable_to_non_nullable
              as String?,
      ethnicity: freezed == ethnicity
          ? _self.ethnicity
          : ethnicity // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredUserId: freezed == preferredUserId
          ? _self.preferredUserId
          : preferredUserId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      insurabilities: null == insurabilities
          ? _self._insurabilities
          : insurabilities // ignore: cast_nullable_to_non_nullable
              as List<EncryptedInsurability>,
      partnerships: null == partnerships
          ? _self._partnerships
          : partnerships // ignore: cast_nullable_to_non_nullable
              as List<Partnership>,
      patientHealthCareParties: null == patientHealthCareParties
          ? _self._patientHealthCareParties
          : patientHealthCareParties // ignore: cast_nullable_to_non_nullable
              as List<EncryptedPatientHealthCareParty>,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self._financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<EncryptedFinancialInstitutionInformation>,
      medicalHouseContracts: null == medicalHouseContracts
          ? _self._medicalHouseContracts
          : medicalHouseContracts // ignore: cast_nullable_to_non_nullable
              as List<EncryptedMedicalHouseContract>,
      patientProfessions: null == patientProfessions
          ? _self._patientProfessions
          : patientProfessions // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      parameters: null == parameters
          ? _self._parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<EncryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self._cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      nonDuplicateIds: null == nonDuplicateIds
          ? _self._nonDuplicateIds
          : nonDuplicateIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedAdministrativesDocuments: null ==
              encryptedAdministrativesDocuments
          ? _self._encryptedAdministrativesDocuments
          : encryptedAdministrativesDocuments // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      warning: freezed == warning
          ? _self.warning
          : warning // ignore: cast_nullable_to_non_nullable
              as String?,
      fatherBirthCountry: freezed == fatherBirthCountry
          ? _self.fatherBirthCountry
          : fatherBirthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      birthCountry: freezed == birthCountry
          ? _self.birthCountry
          : birthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      nativeCountry: freezed == nativeCountry
          ? _self.nativeCountry
          : nativeCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      socialStatus: freezed == socialStatus
          ? _self.socialStatus
          : socialStatus // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      mainSourceOfIncome: freezed == mainSourceOfIncome
          ? _self.mainSourceOfIncome
          : mainSourceOfIncome // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      schoolingInfos: null == schoolingInfos
          ? _self._schoolingInfos
          : schoolingInfos // ignore: cast_nullable_to_non_nullable
              as List<EncryptedSchoolingInfo>,
      employementInfos: null == employementInfos
          ? _self._employementInfos
          : employementInfos // ignore: cast_nullable_to_non_nullable
              as List<EncryptedEmploymentInfo>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as Never?,
    ));
  }

  /// Create a copy of EncryptedPatient
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

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get fatherBirthCountry {
    if (_self.fatherBirthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.fatherBirthCountry!, (value) {
      return _then(_self.copyWith(fatherBirthCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get birthCountry {
    if (_self.birthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.birthCountry!, (value) {
      return _then(_self.copyWith(birthCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get nativeCountry {
    if (_self.nativeCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.nativeCountry!, (value) {
      return _then(_self.copyWith(nativeCountry: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get socialStatus {
    if (_self.socialStatus == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.socialStatus!, (value) {
      return _then(_self.copyWith(socialStatus: value));
    });
  }

  /// Create a copy of EncryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome {
    if (_self.mainSourceOfIncome == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.mainSourceOfIncome!, (value) {
      return _then(_self.copyWith(mainSourceOfIncome: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedPatient {
  String get id;
  List<Identifier> get identifier;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  String? get firstName;
  String? get lastName;
  List<PersonName> get names;
  String? get companyName;
  List<String> get languages;
  List<DecryptedAddress> get addresses;
  String? get civility;
  Gender? get gender;
  Gender? get birthSex;
  String? get mergeToPatientId;
  Set<String> get mergedIds;
  String? get alias;
  bool get active;
  String get deactivationReason;
  int? get deactivationDate;
  String? get ssin;
  String? get maidenName;
  String? get spouseName;
  String? get partnerName;
  PersonalStatus? get personalStatus;
  int? get dateOfBirth;
  int? get dateOfDeath;
  int? get timestampOfLatestEidReading;
  String? get placeOfBirth;
  String? get placeOfDeath;
  bool? get deceased;
  String? get education;
  String? get profession;
  List<Annotation> get notes;
  String? get note;
  String? get administrativeNote;
  String? get nationality;
  String? get race;
  String? get ethnicity;
  String? get preferredUserId;
  Uint8List? get picture;
  String? get externalId;
  List<DecryptedInsurability> get insurabilities;
  List<Partnership> get partnerships;
  List<DecryptedPatientHealthCareParty> get patientHealthCareParties;
  List<DecryptedFinancialInstitutionInformation>
      get financialInstitutionInformation;
  List<DecryptedMedicalHouseContract> get medicalHouseContracts;
  List<CodeStub> get patientProfessions;
  Map<String, List<String>> get parameters;
  Set<DecryptedPropertyStub> get properties;
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
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  Set<DecryptedPropertyStub>? get cryptoActorProperties;
  String? get medicalLocationId;
  Set<String> get nonDuplicateIds;
  Set<String> get encryptedAdministrativesDocuments;
  String? get comment;
  String? get warning;
  CodeStub? get fatherBirthCountry;
  CodeStub? get birthCountry;
  CodeStub? get nativeCountry;
  CodeStub? get socialStatus;
  CodeStub? get mainSourceOfIncome;
  List<DecryptedSchoolingInfo> get schoolingInfos;
  List<DecryptedEmploymentInfo> get employementInfos;
  Never? get parentId;

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedPatientCopyWith<DecryptedPatient> get copyWith =>
      _$DecryptedPatientCopyWithImpl<DecryptedPatient>(
          this as DecryptedPatient, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedPatient &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality().equals(other.names, names) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            const DeepCollectionEquality().equals(other.languages, languages) &&
            const DeepCollectionEquality().equals(other.addresses, addresses) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.birthSex, birthSex) ||
                other.birthSex == birthSex) &&
            (identical(other.mergeToPatientId, mergeToPatientId) ||
                other.mergeToPatientId == mergeToPatientId) &&
            const DeepCollectionEquality().equals(other.mergedIds, mergedIds) &&
            (identical(other.alias, alias) || other.alias == alias) &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.deactivationReason, deactivationReason) ||
                other.deactivationReason == deactivationReason) &&
            (identical(other.deactivationDate, deactivationDate) ||
                other.deactivationDate == deactivationDate) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.maidenName, maidenName) ||
                other.maidenName == maidenName) &&
            (identical(other.spouseName, spouseName) ||
                other.spouseName == spouseName) &&
            (identical(other.partnerName, partnerName) ||
                other.partnerName == partnerName) &&
            (identical(other.personalStatus, personalStatus) ||
                other.personalStatus == personalStatus) &&
            (identical(other.dateOfBirth, dateOfBirth) ||
                other.dateOfBirth == dateOfBirth) &&
            (identical(other.dateOfDeath, dateOfDeath) ||
                other.dateOfDeath == dateOfDeath) &&
            (identical(other.timestampOfLatestEidReading, timestampOfLatestEidReading) ||
                other.timestampOfLatestEidReading ==
                    timestampOfLatestEidReading) &&
            (identical(other.placeOfBirth, placeOfBirth) ||
                other.placeOfBirth == placeOfBirth) &&
            (identical(other.placeOfDeath, placeOfDeath) ||
                other.placeOfDeath == placeOfDeath) &&
            (identical(other.deceased, deceased) ||
                other.deceased == deceased) &&
            (identical(other.education, education) ||
                other.education == education) &&
            (identical(other.profession, profession) ||
                other.profession == profession) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.administrativeNote, administrativeNote) ||
                other.administrativeNote == administrativeNote) &&
            (identical(other.nationality, nationality) ||
                other.nationality == nationality) &&
            (identical(other.race, race) || other.race == race) &&
            (identical(other.ethnicity, ethnicity) ||
                other.ethnicity == ethnicity) &&
            (identical(other.preferredUserId, preferredUserId) ||
                other.preferredUserId == preferredUserId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            const DeepCollectionEquality()
                .equals(other.insurabilities, insurabilities) &&
            const DeepCollectionEquality()
                .equals(other.partnerships, partnerships) &&
            const DeepCollectionEquality().equals(
                other.patientHealthCareParties, patientHealthCareParties) &&
            const DeepCollectionEquality().equals(
                other.financialInstitutionInformation,
                financialInstitutionInformation) &&
            const DeepCollectionEquality()
                .equals(other.medicalHouseContracts, medicalHouseContracts) &&
            const DeepCollectionEquality()
                .equals(other.patientProfessions, patientProfessions) &&
            const DeepCollectionEquality().equals(other.parameters, parameters) &&
            const DeepCollectionEquality().equals(other.properties, properties) &&
            const DeepCollectionEquality().equals(other.hcPartyKeys, hcPartyKeys) &&
            const DeepCollectionEquality().equals(other.aesExchangeKeys, aesExchangeKeys) &&
            const DeepCollectionEquality().equals(other.transferKeys, transferKeys) &&
            const DeepCollectionEquality().equals(other.privateKeyShamirPartitions, privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) || other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(other.publicKeysForOaepWithSha256, publicKeysForOaepWithSha256) &&
            const DeepCollectionEquality().equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality().equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other.delegations, delegations) &&
            const DeepCollectionEquality().equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other.cryptoActorProperties, cryptoActorProperties) &&
            (identical(other.medicalLocationId, medicalLocationId) || other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.nonDuplicateIds, nonDuplicateIds) &&
            const DeepCollectionEquality().equals(other.encryptedAdministrativesDocuments, encryptedAdministrativesDocuments) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.warning, warning) || other.warning == warning) &&
            (identical(other.fatherBirthCountry, fatherBirthCountry) || other.fatherBirthCountry == fatherBirthCountry) &&
            (identical(other.birthCountry, birthCountry) || other.birthCountry == birthCountry) &&
            (identical(other.nativeCountry, nativeCountry) || other.nativeCountry == nativeCountry) &&
            (identical(other.socialStatus, socialStatus) || other.socialStatus == socialStatus) &&
            (identical(other.mainSourceOfIncome, mainSourceOfIncome) || other.mainSourceOfIncome == mainSourceOfIncome) &&
            const DeepCollectionEquality().equals(other.schoolingInfos, schoolingInfos) &&
            const DeepCollectionEquality().equals(other.employementInfos, employementInfos) &&
            (identical(other.parentId, parentId) || other.parentId == parentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        const DeepCollectionEquality().hash(identifier),
        rev,
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        firstName,
        lastName,
        const DeepCollectionEquality().hash(names),
        companyName,
        const DeepCollectionEquality().hash(languages),
        const DeepCollectionEquality().hash(addresses),
        civility,
        gender,
        birthSex,
        mergeToPatientId,
        const DeepCollectionEquality().hash(mergedIds),
        alias,
        active,
        deactivationReason,
        deactivationDate,
        ssin,
        maidenName,
        spouseName,
        partnerName,
        personalStatus,
        dateOfBirth,
        dateOfDeath,
        timestampOfLatestEidReading,
        placeOfBirth,
        placeOfDeath,
        deceased,
        education,
        profession,
        const DeepCollectionEquality().hash(notes),
        note,
        administrativeNote,
        nationality,
        race,
        ethnicity,
        preferredUserId,
        const DeepCollectionEquality().hash(picture),
        externalId,
        const DeepCollectionEquality().hash(insurabilities),
        const DeepCollectionEquality().hash(partnerships),
        const DeepCollectionEquality().hash(patientHealthCareParties),
        const DeepCollectionEquality().hash(financialInstitutionInformation),
        const DeepCollectionEquality().hash(medicalHouseContracts),
        const DeepCollectionEquality().hash(patientProfessions),
        const DeepCollectionEquality().hash(parameters),
        const DeepCollectionEquality().hash(properties),
        const DeepCollectionEquality().hash(hcPartyKeys),
        const DeepCollectionEquality().hash(aesExchangeKeys),
        const DeepCollectionEquality().hash(transferKeys),
        const DeepCollectionEquality().hash(privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(cryptoActorProperties),
        medicalLocationId,
        const DeepCollectionEquality().hash(nonDuplicateIds),
        const DeepCollectionEquality().hash(encryptedAdministrativesDocuments),
        comment,
        warning,
        fatherBirthCountry,
        birthCountry,
        nativeCountry,
        socialStatus,
        mainSourceOfIncome,
        const DeepCollectionEquality().hash(schoolingInfos),
        const DeepCollectionEquality().hash(employementInfos),
        parentId
      ]);

  @override
  String toString() {
    return 'DecryptedPatient(id: $id, identifier: $identifier, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, firstName: $firstName, lastName: $lastName, names: $names, companyName: $companyName, languages: $languages, addresses: $addresses, civility: $civility, gender: $gender, birthSex: $birthSex, mergeToPatientId: $mergeToPatientId, mergedIds: $mergedIds, alias: $alias, active: $active, deactivationReason: $deactivationReason, deactivationDate: $deactivationDate, ssin: $ssin, maidenName: $maidenName, spouseName: $spouseName, partnerName: $partnerName, personalStatus: $personalStatus, dateOfBirth: $dateOfBirth, dateOfDeath: $dateOfDeath, timestampOfLatestEidReading: $timestampOfLatestEidReading, placeOfBirth: $placeOfBirth, placeOfDeath: $placeOfDeath, deceased: $deceased, education: $education, profession: $profession, notes: $notes, note: $note, administrativeNote: $administrativeNote, nationality: $nationality, race: $race, ethnicity: $ethnicity, preferredUserId: $preferredUserId, picture: $picture, externalId: $externalId, insurabilities: $insurabilities, partnerships: $partnerships, patientHealthCareParties: $patientHealthCareParties, financialInstitutionInformation: $financialInstitutionInformation, medicalHouseContracts: $medicalHouseContracts, patientProfessions: $patientProfessions, parameters: $parameters, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, cryptoActorProperties: $cryptoActorProperties, medicalLocationId: $medicalLocationId, nonDuplicateIds: $nonDuplicateIds, encryptedAdministrativesDocuments: $encryptedAdministrativesDocuments, comment: $comment, warning: $warning, fatherBirthCountry: $fatherBirthCountry, birthCountry: $birthCountry, nativeCountry: $nativeCountry, socialStatus: $socialStatus, mainSourceOfIncome: $mainSourceOfIncome, schoolingInfos: $schoolingInfos, employementInfos: $employementInfos, parentId: $parentId)';
  }
}

/// @nodoc
abstract mixin class $DecryptedPatientCopyWith<$Res> {
  factory $DecryptedPatientCopyWith(
          DecryptedPatient value, $Res Function(DecryptedPatient) _then) =
      _$DecryptedPatientCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifier,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? firstName,
      String? lastName,
      List<PersonName> names,
      String? companyName,
      List<String> languages,
      List<DecryptedAddress> addresses,
      String? civility,
      Gender? gender,
      Gender? birthSex,
      String? mergeToPatientId,
      Set<String> mergedIds,
      String? alias,
      bool active,
      String deactivationReason,
      int? deactivationDate,
      String? ssin,
      String? maidenName,
      String? spouseName,
      String? partnerName,
      PersonalStatus? personalStatus,
      int? dateOfBirth,
      int? dateOfDeath,
      int? timestampOfLatestEidReading,
      String? placeOfBirth,
      String? placeOfDeath,
      bool? deceased,
      String? education,
      String? profession,
      List<Annotation> notes,
      String? note,
      String? administrativeNote,
      String? nationality,
      String? race,
      String? ethnicity,
      String? preferredUserId,
      Uint8List? picture,
      String? externalId,
      List<DecryptedInsurability> insurabilities,
      List<Partnership> partnerships,
      List<DecryptedPatientHealthCareParty> patientHealthCareParties,
      List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      List<DecryptedMedicalHouseContract> medicalHouseContracts,
      List<CodeStub> patientProfessions,
      Map<String, List<String>> parameters,
      Set<DecryptedPropertyStub> properties,
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
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      String? medicalLocationId,
      Set<String> nonDuplicateIds,
      Set<String> encryptedAdministrativesDocuments,
      String? comment,
      String? warning,
      CodeStub? fatherBirthCountry,
      CodeStub? birthCountry,
      CodeStub? nativeCountry,
      CodeStub? socialStatus,
      CodeStub? mainSourceOfIncome,
      List<DecryptedSchoolingInfo> schoolingInfos,
      List<DecryptedEmploymentInfo> employementInfos,
      Never? parentId});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
  $CodeStubCopyWith<$Res>? get fatherBirthCountry;
  $CodeStubCopyWith<$Res>? get birthCountry;
  $CodeStubCopyWith<$Res>? get nativeCountry;
  $CodeStubCopyWith<$Res>? get socialStatus;
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome;
}

/// @nodoc
class _$DecryptedPatientCopyWithImpl<$Res>
    implements $DecryptedPatientCopyWith<$Res> {
  _$DecryptedPatientCopyWithImpl(this._self, this._then);

  final DecryptedPatient _self;
  final $Res Function(DecryptedPatient) _then;

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? identifier = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? names = null,
    Object? companyName = freezed,
    Object? languages = null,
    Object? addresses = null,
    Object? civility = freezed,
    Object? gender = freezed,
    Object? birthSex = freezed,
    Object? mergeToPatientId = freezed,
    Object? mergedIds = null,
    Object? alias = freezed,
    Object? active = null,
    Object? deactivationReason = null,
    Object? deactivationDate = freezed,
    Object? ssin = freezed,
    Object? maidenName = freezed,
    Object? spouseName = freezed,
    Object? partnerName = freezed,
    Object? personalStatus = freezed,
    Object? dateOfBirth = freezed,
    Object? dateOfDeath = freezed,
    Object? timestampOfLatestEidReading = freezed,
    Object? placeOfBirth = freezed,
    Object? placeOfDeath = freezed,
    Object? deceased = freezed,
    Object? education = freezed,
    Object? profession = freezed,
    Object? notes = null,
    Object? note = freezed,
    Object? administrativeNote = freezed,
    Object? nationality = freezed,
    Object? race = freezed,
    Object? ethnicity = freezed,
    Object? preferredUserId = freezed,
    Object? picture = freezed,
    Object? externalId = freezed,
    Object? insurabilities = null,
    Object? partnerships = null,
    Object? patientHealthCareParties = null,
    Object? financialInstitutionInformation = null,
    Object? medicalHouseContracts = null,
    Object? patientProfessions = null,
    Object? parameters = null,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? cryptoActorProperties = freezed,
    Object? medicalLocationId = freezed,
    Object? nonDuplicateIds = null,
    Object? encryptedAdministrativesDocuments = null,
    Object? comment = freezed,
    Object? warning = freezed,
    Object? fatherBirthCountry = freezed,
    Object? birthCountry = freezed,
    Object? nativeCountry = freezed,
    Object? socialStatus = freezed,
    Object? mainSourceOfIncome = freezed,
    Object? schoolingInfos = null,
    Object? employementInfos = null,
    Object? parentId = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self.names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      languages: null == languages
          ? _self.languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      addresses: null == addresses
          ? _self.addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<DecryptedAddress>,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      birthSex: freezed == birthSex
          ? _self.birthSex
          : birthSex // ignore: cast_nullable_to_non_nullable
              as Gender?,
      mergeToPatientId: freezed == mergeToPatientId
          ? _self.mergeToPatientId
          : mergeToPatientId // ignore: cast_nullable_to_non_nullable
              as String?,
      mergedIds: null == mergedIds
          ? _self.mergedIds
          : mergedIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      alias: freezed == alias
          ? _self.alias
          : alias // ignore: cast_nullable_to_non_nullable
              as String?,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      deactivationReason: null == deactivationReason
          ? _self.deactivationReason
          : deactivationReason // ignore: cast_nullable_to_non_nullable
              as String,
      deactivationDate: freezed == deactivationDate
          ? _self.deactivationDate
          : deactivationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      maidenName: freezed == maidenName
          ? _self.maidenName
          : maidenName // ignore: cast_nullable_to_non_nullable
              as String?,
      spouseName: freezed == spouseName
          ? _self.spouseName
          : spouseName // ignore: cast_nullable_to_non_nullable
              as String?,
      partnerName: freezed == partnerName
          ? _self.partnerName
          : partnerName // ignore: cast_nullable_to_non_nullable
              as String?,
      personalStatus: freezed == personalStatus
          ? _self.personalStatus
          : personalStatus // ignore: cast_nullable_to_non_nullable
              as PersonalStatus?,
      dateOfBirth: freezed == dateOfBirth
          ? _self.dateOfBirth
          : dateOfBirth // ignore: cast_nullable_to_non_nullable
              as int?,
      dateOfDeath: freezed == dateOfDeath
          ? _self.dateOfDeath
          : dateOfDeath // ignore: cast_nullable_to_non_nullable
              as int?,
      timestampOfLatestEidReading: freezed == timestampOfLatestEidReading
          ? _self.timestampOfLatestEidReading
          : timestampOfLatestEidReading // ignore: cast_nullable_to_non_nullable
              as int?,
      placeOfBirth: freezed == placeOfBirth
          ? _self.placeOfBirth
          : placeOfBirth // ignore: cast_nullable_to_non_nullable
              as String?,
      placeOfDeath: freezed == placeOfDeath
          ? _self.placeOfDeath
          : placeOfDeath // ignore: cast_nullable_to_non_nullable
              as String?,
      deceased: freezed == deceased
          ? _self.deceased
          : deceased // ignore: cast_nullable_to_non_nullable
              as bool?,
      education: freezed == education
          ? _self.education
          : education // ignore: cast_nullable_to_non_nullable
              as String?,
      profession: freezed == profession
          ? _self.profession
          : profession // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      administrativeNote: freezed == administrativeNote
          ? _self.administrativeNote
          : administrativeNote // ignore: cast_nullable_to_non_nullable
              as String?,
      nationality: freezed == nationality
          ? _self.nationality
          : nationality // ignore: cast_nullable_to_non_nullable
              as String?,
      race: freezed == race
          ? _self.race
          : race // ignore: cast_nullable_to_non_nullable
              as String?,
      ethnicity: freezed == ethnicity
          ? _self.ethnicity
          : ethnicity // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredUserId: freezed == preferredUserId
          ? _self.preferredUserId
          : preferredUserId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      insurabilities: null == insurabilities
          ? _self.insurabilities
          : insurabilities // ignore: cast_nullable_to_non_nullable
              as List<DecryptedInsurability>,
      partnerships: null == partnerships
          ? _self.partnerships
          : partnerships // ignore: cast_nullable_to_non_nullable
              as List<Partnership>,
      patientHealthCareParties: null == patientHealthCareParties
          ? _self.patientHealthCareParties
          : patientHealthCareParties // ignore: cast_nullable_to_non_nullable
              as List<DecryptedPatientHealthCareParty>,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self.financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFinancialInstitutionInformation>,
      medicalHouseContracts: null == medicalHouseContracts
          ? _self.medicalHouseContracts
          : medicalHouseContracts // ignore: cast_nullable_to_non_nullable
              as List<DecryptedMedicalHouseContract>,
      patientProfessions: null == patientProfessions
          ? _self.patientProfessions
          : patientProfessions // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      parameters: null == parameters
          ? _self.parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self.cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      nonDuplicateIds: null == nonDuplicateIds
          ? _self.nonDuplicateIds
          : nonDuplicateIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedAdministrativesDocuments: null ==
              encryptedAdministrativesDocuments
          ? _self.encryptedAdministrativesDocuments
          : encryptedAdministrativesDocuments // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      warning: freezed == warning
          ? _self.warning
          : warning // ignore: cast_nullable_to_non_nullable
              as String?,
      fatherBirthCountry: freezed == fatherBirthCountry
          ? _self.fatherBirthCountry
          : fatherBirthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      birthCountry: freezed == birthCountry
          ? _self.birthCountry
          : birthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      nativeCountry: freezed == nativeCountry
          ? _self.nativeCountry
          : nativeCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      socialStatus: freezed == socialStatus
          ? _self.socialStatus
          : socialStatus // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      mainSourceOfIncome: freezed == mainSourceOfIncome
          ? _self.mainSourceOfIncome
          : mainSourceOfIncome // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      schoolingInfos: null == schoolingInfos
          ? _self.schoolingInfos
          : schoolingInfos // ignore: cast_nullable_to_non_nullable
              as List<DecryptedSchoolingInfo>,
      employementInfos: null == employementInfos
          ? _self.employementInfos
          : employementInfos // ignore: cast_nullable_to_non_nullable
              as List<DecryptedEmploymentInfo>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as Never?,
    ));
  }

  /// Create a copy of DecryptedPatient
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

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get fatherBirthCountry {
    if (_self.fatherBirthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.fatherBirthCountry!, (value) {
      return _then(_self.copyWith(fatherBirthCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get birthCountry {
    if (_self.birthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.birthCountry!, (value) {
      return _then(_self.copyWith(birthCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get nativeCountry {
    if (_self.nativeCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.nativeCountry!, (value) {
      return _then(_self.copyWith(nativeCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get socialStatus {
    if (_self.socialStatus == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.socialStatus!, (value) {
      return _then(_self.copyWith(socialStatus: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome {
    if (_self.mainSourceOfIncome == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.mainSourceOfIncome!, (value) {
      return _then(_self.copyWith(mainSourceOfIncome: value));
    });
  }
}

/// @nodoc

class _DecryptedPatient implements DecryptedPatient {
  const _DecryptedPatient(
      {required this.id,
      final List<Identifier> identifier = const [],
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.firstName = null,
      this.lastName = null,
      final List<PersonName> names = const [],
      this.companyName = null,
      final List<String> languages = const [],
      final List<DecryptedAddress> addresses = const [],
      this.civility = null,
      this.gender = Gender.unknown,
      this.birthSex = Gender.unknown,
      this.mergeToPatientId = null,
      final Set<String> mergedIds = const {},
      this.alias = null,
      this.active = true,
      this.deactivationReason = "none",
      this.deactivationDate = null,
      this.ssin = null,
      this.maidenName = null,
      this.spouseName = null,
      this.partnerName = null,
      this.personalStatus = PersonalStatus.unknown,
      this.dateOfBirth = null,
      this.dateOfDeath = null,
      this.timestampOfLatestEidReading = null,
      this.placeOfBirth = null,
      this.placeOfDeath = null,
      this.deceased = null,
      this.education = null,
      this.profession = null,
      final List<Annotation> notes = const [],
      this.note = null,
      this.administrativeNote = null,
      this.nationality = null,
      this.race = null,
      this.ethnicity = null,
      this.preferredUserId = null,
      this.picture = null,
      this.externalId = null,
      final List<DecryptedInsurability> insurabilities = const [],
      final List<Partnership> partnerships = const [],
      final List<DecryptedPatientHealthCareParty> patientHealthCareParties =
          const [],
      final List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation = const [],
      final List<DecryptedMedicalHouseContract> medicalHouseContracts =
          const [],
      final List<CodeStub> patientProfessions = const [],
      final Map<String, List<String>> parameters = const {},
      final Set<DecryptedPropertyStub> properties = const {},
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
      final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      final Set<DecryptedPropertyStub>? cryptoActorProperties = null,
      this.medicalLocationId = null,
      final Set<String> nonDuplicateIds = const {},
      final Set<String> encryptedAdministrativesDocuments = const {},
      this.comment = null,
      this.warning = null,
      this.fatherBirthCountry = null,
      this.birthCountry = null,
      this.nativeCountry = null,
      this.socialStatus = null,
      this.mainSourceOfIncome = null,
      final List<DecryptedSchoolingInfo> schoolingInfos = const [],
      final List<DecryptedEmploymentInfo> employementInfos = const [],
      this.parentId = null})
      : _identifier = identifier,
        _tags = tags,
        _codes = codes,
        _names = names,
        _languages = languages,
        _addresses = addresses,
        _mergedIds = mergedIds,
        _notes = notes,
        _insurabilities = insurabilities,
        _partnerships = partnerships,
        _patientHealthCareParties = patientHealthCareParties,
        _financialInstitutionInformation = financialInstitutionInformation,
        _medicalHouseContracts = medicalHouseContracts,
        _patientProfessions = patientProfessions,
        _parameters = parameters,
        _properties = properties,
        _hcPartyKeys = hcPartyKeys,
        _aesExchangeKeys = aesExchangeKeys,
        _transferKeys = transferKeys,
        _privateKeyShamirPartitions = privateKeyShamirPartitions,
        _publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _cryptoActorProperties = cryptoActorProperties,
        _nonDuplicateIds = nonDuplicateIds,
        _encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
        _schoolingInfos = schoolingInfos,
        _employementInfos = employementInfos;

  @override
  final String id;
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
  final String? firstName;
  @override
  @JsonKey()
  final String? lastName;
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
  final String? companyName;
  final List<String> _languages;
  @override
  @JsonKey()
  List<String> get languages {
    if (_languages is EqualUnmodifiableListView) return _languages;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_languages);
  }

  final List<DecryptedAddress> _addresses;
  @override
  @JsonKey()
  List<DecryptedAddress> get addresses {
    if (_addresses is EqualUnmodifiableListView) return _addresses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_addresses);
  }

  @override
  @JsonKey()
  final String? civility;
  @override
  @JsonKey()
  final Gender? gender;
  @override
  @JsonKey()
  final Gender? birthSex;
  @override
  @JsonKey()
  final String? mergeToPatientId;
  final Set<String> _mergedIds;
  @override
  @JsonKey()
  Set<String> get mergedIds {
    if (_mergedIds is EqualUnmodifiableSetView) return _mergedIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_mergedIds);
  }

  @override
  @JsonKey()
  final String? alias;
  @override
  @JsonKey()
  final bool active;
  @override
  @JsonKey()
  final String deactivationReason;
  @override
  @JsonKey()
  final int? deactivationDate;
  @override
  @JsonKey()
  final String? ssin;
  @override
  @JsonKey()
  final String? maidenName;
  @override
  @JsonKey()
  final String? spouseName;
  @override
  @JsonKey()
  final String? partnerName;
  @override
  @JsonKey()
  final PersonalStatus? personalStatus;
  @override
  @JsonKey()
  final int? dateOfBirth;
  @override
  @JsonKey()
  final int? dateOfDeath;
  @override
  @JsonKey()
  final int? timestampOfLatestEidReading;
  @override
  @JsonKey()
  final String? placeOfBirth;
  @override
  @JsonKey()
  final String? placeOfDeath;
  @override
  @JsonKey()
  final bool? deceased;
  @override
  @JsonKey()
  final String? education;
  @override
  @JsonKey()
  final String? profession;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  @override
  @JsonKey()
  final String? note;
  @override
  @JsonKey()
  final String? administrativeNote;
  @override
  @JsonKey()
  final String? nationality;
  @override
  @JsonKey()
  final String? race;
  @override
  @JsonKey()
  final String? ethnicity;
  @override
  @JsonKey()
  final String? preferredUserId;
  @override
  @JsonKey()
  final Uint8List? picture;
  @override
  @JsonKey()
  final String? externalId;
  final List<DecryptedInsurability> _insurabilities;
  @override
  @JsonKey()
  List<DecryptedInsurability> get insurabilities {
    if (_insurabilities is EqualUnmodifiableListView) return _insurabilities;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_insurabilities);
  }

  final List<Partnership> _partnerships;
  @override
  @JsonKey()
  List<Partnership> get partnerships {
    if (_partnerships is EqualUnmodifiableListView) return _partnerships;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_partnerships);
  }

  final List<DecryptedPatientHealthCareParty> _patientHealthCareParties;
  @override
  @JsonKey()
  List<DecryptedPatientHealthCareParty> get patientHealthCareParties {
    if (_patientHealthCareParties is EqualUnmodifiableListView)
      return _patientHealthCareParties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_patientHealthCareParties);
  }

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

  final List<DecryptedMedicalHouseContract> _medicalHouseContracts;
  @override
  @JsonKey()
  List<DecryptedMedicalHouseContract> get medicalHouseContracts {
    if (_medicalHouseContracts is EqualUnmodifiableListView)
      return _medicalHouseContracts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_medicalHouseContracts);
  }

  final List<CodeStub> _patientProfessions;
  @override
  @JsonKey()
  List<CodeStub> get patientProfessions {
    if (_patientProfessions is EqualUnmodifiableListView)
      return _patientProfessions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_patientProfessions);
  }

  final Map<String, List<String>> _parameters;
  @override
  @JsonKey()
  Map<String, List<String>> get parameters {
    if (_parameters is EqualUnmodifiableMapView) return _parameters;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_parameters);
  }

  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
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

  @override
  @JsonKey()
  final String? medicalLocationId;
  final Set<String> _nonDuplicateIds;
  @override
  @JsonKey()
  Set<String> get nonDuplicateIds {
    if (_nonDuplicateIds is EqualUnmodifiableSetView) return _nonDuplicateIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_nonDuplicateIds);
  }

  final Set<String> _encryptedAdministrativesDocuments;
  @override
  @JsonKey()
  Set<String> get encryptedAdministrativesDocuments {
    if (_encryptedAdministrativesDocuments is EqualUnmodifiableSetView)
      return _encryptedAdministrativesDocuments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_encryptedAdministrativesDocuments);
  }

  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final String? warning;
  @override
  @JsonKey()
  final CodeStub? fatherBirthCountry;
  @override
  @JsonKey()
  final CodeStub? birthCountry;
  @override
  @JsonKey()
  final CodeStub? nativeCountry;
  @override
  @JsonKey()
  final CodeStub? socialStatus;
  @override
  @JsonKey()
  final CodeStub? mainSourceOfIncome;
  final List<DecryptedSchoolingInfo> _schoolingInfos;
  @override
  @JsonKey()
  List<DecryptedSchoolingInfo> get schoolingInfos {
    if (_schoolingInfos is EqualUnmodifiableListView) return _schoolingInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_schoolingInfos);
  }

  final List<DecryptedEmploymentInfo> _employementInfos;
  @override
  @JsonKey()
  List<DecryptedEmploymentInfo> get employementInfos {
    if (_employementInfos is EqualUnmodifiableListView)
      return _employementInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_employementInfos);
  }

  @override
  @JsonKey()
  final Never? parentId;

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedPatientCopyWith<_DecryptedPatient> get copyWith =>
      __$DecryptedPatientCopyWithImpl<_DecryptedPatient>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedPatient &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality().equals(other._names, _names) &&
            (identical(other.companyName, companyName) ||
                other.companyName == companyName) &&
            const DeepCollectionEquality()
                .equals(other._languages, _languages) &&
            const DeepCollectionEquality()
                .equals(other._addresses, _addresses) &&
            (identical(other.civility, civility) ||
                other.civility == civility) &&
            (identical(other.gender, gender) || other.gender == gender) &&
            (identical(other.birthSex, birthSex) ||
                other.birthSex == birthSex) &&
            (identical(other.mergeToPatientId, mergeToPatientId) ||
                other.mergeToPatientId == mergeToPatientId) &&
            const DeepCollectionEquality()
                .equals(other._mergedIds, _mergedIds) &&
            (identical(other.alias, alias) || other.alias == alias) &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.deactivationReason, deactivationReason) ||
                other.deactivationReason == deactivationReason) &&
            (identical(other.deactivationDate, deactivationDate) ||
                other.deactivationDate == deactivationDate) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.maidenName, maidenName) ||
                other.maidenName == maidenName) &&
            (identical(other.spouseName, spouseName) ||
                other.spouseName == spouseName) &&
            (identical(other.partnerName, partnerName) ||
                other.partnerName == partnerName) &&
            (identical(other.personalStatus, personalStatus) ||
                other.personalStatus == personalStatus) &&
            (identical(other.dateOfBirth, dateOfBirth) ||
                other.dateOfBirth == dateOfBirth) &&
            (identical(other.dateOfDeath, dateOfDeath) ||
                other.dateOfDeath == dateOfDeath) &&
            (identical(other.timestampOfLatestEidReading, timestampOfLatestEidReading) ||
                other.timestampOfLatestEidReading ==
                    timestampOfLatestEidReading) &&
            (identical(other.placeOfBirth, placeOfBirth) ||
                other.placeOfBirth == placeOfBirth) &&
            (identical(other.placeOfDeath, placeOfDeath) ||
                other.placeOfDeath == placeOfDeath) &&
            (identical(other.deceased, deceased) ||
                other.deceased == deceased) &&
            (identical(other.education, education) ||
                other.education == education) &&
            (identical(other.profession, profession) ||
                other.profession == profession) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            (identical(other.note, note) || other.note == note) &&
            (identical(other.administrativeNote, administrativeNote) ||
                other.administrativeNote == administrativeNote) &&
            (identical(other.nationality, nationality) ||
                other.nationality == nationality) &&
            (identical(other.race, race) || other.race == race) &&
            (identical(other.ethnicity, ethnicity) ||
                other.ethnicity == ethnicity) &&
            (identical(other.preferredUserId, preferredUserId) ||
                other.preferredUserId == preferredUserId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            const DeepCollectionEquality()
                .equals(other._insurabilities, _insurabilities) &&
            const DeepCollectionEquality()
                .equals(other._partnerships, _partnerships) &&
            const DeepCollectionEquality().equals(
                other._patientHealthCareParties, _patientHealthCareParties) &&
            const DeepCollectionEquality().equals(
                other._financialInstitutionInformation,
                _financialInstitutionInformation) &&
            const DeepCollectionEquality().equals(other._medicalHouseContracts, _medicalHouseContracts) &&
            const DeepCollectionEquality().equals(other._patientProfessions, _patientProfessions) &&
            const DeepCollectionEquality().equals(other._parameters, _parameters) &&
            const DeepCollectionEquality().equals(other._properties, _properties) &&
            const DeepCollectionEquality().equals(other._hcPartyKeys, _hcPartyKeys) &&
            const DeepCollectionEquality().equals(other._aesExchangeKeys, _aesExchangeKeys) &&
            const DeepCollectionEquality().equals(other._transferKeys, _transferKeys) &&
            const DeepCollectionEquality().equals(other._privateKeyShamirPartitions, _privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) || other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(other._publicKeysForOaepWithSha256, _publicKeysForOaepWithSha256) &&
            const DeepCollectionEquality().equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality().equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other._delegations, _delegations) &&
            const DeepCollectionEquality().equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata) &&
            const DeepCollectionEquality().equals(other._cryptoActorProperties, _cryptoActorProperties) &&
            (identical(other.medicalLocationId, medicalLocationId) || other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._nonDuplicateIds, _nonDuplicateIds) &&
            const DeepCollectionEquality().equals(other._encryptedAdministrativesDocuments, _encryptedAdministrativesDocuments) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.warning, warning) || other.warning == warning) &&
            (identical(other.fatherBirthCountry, fatherBirthCountry) || other.fatherBirthCountry == fatherBirthCountry) &&
            (identical(other.birthCountry, birthCountry) || other.birthCountry == birthCountry) &&
            (identical(other.nativeCountry, nativeCountry) || other.nativeCountry == nativeCountry) &&
            (identical(other.socialStatus, socialStatus) || other.socialStatus == socialStatus) &&
            (identical(other.mainSourceOfIncome, mainSourceOfIncome) || other.mainSourceOfIncome == mainSourceOfIncome) &&
            const DeepCollectionEquality().equals(other._schoolingInfos, _schoolingInfos) &&
            const DeepCollectionEquality().equals(other._employementInfos, _employementInfos) &&
            (identical(other.parentId, parentId) || other.parentId == parentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        const DeepCollectionEquality().hash(_identifier),
        rev,
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        firstName,
        lastName,
        const DeepCollectionEquality().hash(_names),
        companyName,
        const DeepCollectionEquality().hash(_languages),
        const DeepCollectionEquality().hash(_addresses),
        civility,
        gender,
        birthSex,
        mergeToPatientId,
        const DeepCollectionEquality().hash(_mergedIds),
        alias,
        active,
        deactivationReason,
        deactivationDate,
        ssin,
        maidenName,
        spouseName,
        partnerName,
        personalStatus,
        dateOfBirth,
        dateOfDeath,
        timestampOfLatestEidReading,
        placeOfBirth,
        placeOfDeath,
        deceased,
        education,
        profession,
        const DeepCollectionEquality().hash(_notes),
        note,
        administrativeNote,
        nationality,
        race,
        ethnicity,
        preferredUserId,
        const DeepCollectionEquality().hash(picture),
        externalId,
        const DeepCollectionEquality().hash(_insurabilities),
        const DeepCollectionEquality().hash(_partnerships),
        const DeepCollectionEquality().hash(_patientHealthCareParties),
        const DeepCollectionEquality().hash(_financialInstitutionInformation),
        const DeepCollectionEquality().hash(_medicalHouseContracts),
        const DeepCollectionEquality().hash(_patientProfessions),
        const DeepCollectionEquality().hash(_parameters),
        const DeepCollectionEquality().hash(_properties),
        const DeepCollectionEquality().hash(_hcPartyKeys),
        const DeepCollectionEquality().hash(_aesExchangeKeys),
        const DeepCollectionEquality().hash(_transferKeys),
        const DeepCollectionEquality().hash(_privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(_publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata,
        const DeepCollectionEquality().hash(_cryptoActorProperties),
        medicalLocationId,
        const DeepCollectionEquality().hash(_nonDuplicateIds),
        const DeepCollectionEquality().hash(_encryptedAdministrativesDocuments),
        comment,
        warning,
        fatherBirthCountry,
        birthCountry,
        nativeCountry,
        socialStatus,
        mainSourceOfIncome,
        const DeepCollectionEquality().hash(_schoolingInfos),
        const DeepCollectionEquality().hash(_employementInfos),
        parentId
      ]);

  @override
  String toString() {
    return 'DecryptedPatient(id: $id, identifier: $identifier, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, firstName: $firstName, lastName: $lastName, names: $names, companyName: $companyName, languages: $languages, addresses: $addresses, civility: $civility, gender: $gender, birthSex: $birthSex, mergeToPatientId: $mergeToPatientId, mergedIds: $mergedIds, alias: $alias, active: $active, deactivationReason: $deactivationReason, deactivationDate: $deactivationDate, ssin: $ssin, maidenName: $maidenName, spouseName: $spouseName, partnerName: $partnerName, personalStatus: $personalStatus, dateOfBirth: $dateOfBirth, dateOfDeath: $dateOfDeath, timestampOfLatestEidReading: $timestampOfLatestEidReading, placeOfBirth: $placeOfBirth, placeOfDeath: $placeOfDeath, deceased: $deceased, education: $education, profession: $profession, notes: $notes, note: $note, administrativeNote: $administrativeNote, nationality: $nationality, race: $race, ethnicity: $ethnicity, preferredUserId: $preferredUserId, picture: $picture, externalId: $externalId, insurabilities: $insurabilities, partnerships: $partnerships, patientHealthCareParties: $patientHealthCareParties, financialInstitutionInformation: $financialInstitutionInformation, medicalHouseContracts: $medicalHouseContracts, patientProfessions: $patientProfessions, parameters: $parameters, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, cryptoActorProperties: $cryptoActorProperties, medicalLocationId: $medicalLocationId, nonDuplicateIds: $nonDuplicateIds, encryptedAdministrativesDocuments: $encryptedAdministrativesDocuments, comment: $comment, warning: $warning, fatherBirthCountry: $fatherBirthCountry, birthCountry: $birthCountry, nativeCountry: $nativeCountry, socialStatus: $socialStatus, mainSourceOfIncome: $mainSourceOfIncome, schoolingInfos: $schoolingInfos, employementInfos: $employementInfos, parentId: $parentId)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedPatientCopyWith<$Res>
    implements $DecryptedPatientCopyWith<$Res> {
  factory _$DecryptedPatientCopyWith(
          _DecryptedPatient value, $Res Function(_DecryptedPatient) _then) =
      __$DecryptedPatientCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifier,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? firstName,
      String? lastName,
      List<PersonName> names,
      String? companyName,
      List<String> languages,
      List<DecryptedAddress> addresses,
      String? civility,
      Gender? gender,
      Gender? birthSex,
      String? mergeToPatientId,
      Set<String> mergedIds,
      String? alias,
      bool active,
      String deactivationReason,
      int? deactivationDate,
      String? ssin,
      String? maidenName,
      String? spouseName,
      String? partnerName,
      PersonalStatus? personalStatus,
      int? dateOfBirth,
      int? dateOfDeath,
      int? timestampOfLatestEidReading,
      String? placeOfBirth,
      String? placeOfDeath,
      bool? deceased,
      String? education,
      String? profession,
      List<Annotation> notes,
      String? note,
      String? administrativeNote,
      String? nationality,
      String? race,
      String? ethnicity,
      String? preferredUserId,
      Uint8List? picture,
      String? externalId,
      List<DecryptedInsurability> insurabilities,
      List<Partnership> partnerships,
      List<DecryptedPatientHealthCareParty> patientHealthCareParties,
      List<DecryptedFinancialInstitutionInformation>
          financialInstitutionInformation,
      List<DecryptedMedicalHouseContract> medicalHouseContracts,
      List<CodeStub> patientProfessions,
      Map<String, List<String>> parameters,
      Set<DecryptedPropertyStub> properties,
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
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      Set<DecryptedPropertyStub>? cryptoActorProperties,
      String? medicalLocationId,
      Set<String> nonDuplicateIds,
      Set<String> encryptedAdministrativesDocuments,
      String? comment,
      String? warning,
      CodeStub? fatherBirthCountry,
      CodeStub? birthCountry,
      CodeStub? nativeCountry,
      CodeStub? socialStatus,
      CodeStub? mainSourceOfIncome,
      List<DecryptedSchoolingInfo> schoolingInfos,
      List<DecryptedEmploymentInfo> employementInfos,
      Never? parentId});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
  @override
  $CodeStubCopyWith<$Res>? get fatherBirthCountry;
  @override
  $CodeStubCopyWith<$Res>? get birthCountry;
  @override
  $CodeStubCopyWith<$Res>? get nativeCountry;
  @override
  $CodeStubCopyWith<$Res>? get socialStatus;
  @override
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome;
}

/// @nodoc
class __$DecryptedPatientCopyWithImpl<$Res>
    implements _$DecryptedPatientCopyWith<$Res> {
  __$DecryptedPatientCopyWithImpl(this._self, this._then);

  final _DecryptedPatient _self;
  final $Res Function(_DecryptedPatient) _then;

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? identifier = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? firstName = freezed,
    Object? lastName = freezed,
    Object? names = null,
    Object? companyName = freezed,
    Object? languages = null,
    Object? addresses = null,
    Object? civility = freezed,
    Object? gender = freezed,
    Object? birthSex = freezed,
    Object? mergeToPatientId = freezed,
    Object? mergedIds = null,
    Object? alias = freezed,
    Object? active = null,
    Object? deactivationReason = null,
    Object? deactivationDate = freezed,
    Object? ssin = freezed,
    Object? maidenName = freezed,
    Object? spouseName = freezed,
    Object? partnerName = freezed,
    Object? personalStatus = freezed,
    Object? dateOfBirth = freezed,
    Object? dateOfDeath = freezed,
    Object? timestampOfLatestEidReading = freezed,
    Object? placeOfBirth = freezed,
    Object? placeOfDeath = freezed,
    Object? deceased = freezed,
    Object? education = freezed,
    Object? profession = freezed,
    Object? notes = null,
    Object? note = freezed,
    Object? administrativeNote = freezed,
    Object? nationality = freezed,
    Object? race = freezed,
    Object? ethnicity = freezed,
    Object? preferredUserId = freezed,
    Object? picture = freezed,
    Object? externalId = freezed,
    Object? insurabilities = null,
    Object? partnerships = null,
    Object? patientHealthCareParties = null,
    Object? financialInstitutionInformation = null,
    Object? medicalHouseContracts = null,
    Object? patientProfessions = null,
    Object? parameters = null,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? cryptoActorProperties = freezed,
    Object? medicalLocationId = freezed,
    Object? nonDuplicateIds = null,
    Object? encryptedAdministrativesDocuments = null,
    Object? comment = freezed,
    Object? warning = freezed,
    Object? fatherBirthCountry = freezed,
    Object? birthCountry = freezed,
    Object? nativeCountry = freezed,
    Object? socialStatus = freezed,
    Object? mainSourceOfIncome = freezed,
    Object? schoolingInfos = null,
    Object? employementInfos = null,
    Object? parentId = freezed,
  }) {
    return _then(_DecryptedPatient(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      firstName: freezed == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String?,
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      names: null == names
          ? _self._names
          : names // ignore: cast_nullable_to_non_nullable
              as List<PersonName>,
      companyName: freezed == companyName
          ? _self.companyName
          : companyName // ignore: cast_nullable_to_non_nullable
              as String?,
      languages: null == languages
          ? _self._languages
          : languages // ignore: cast_nullable_to_non_nullable
              as List<String>,
      addresses: null == addresses
          ? _self._addresses
          : addresses // ignore: cast_nullable_to_non_nullable
              as List<DecryptedAddress>,
      civility: freezed == civility
          ? _self.civility
          : civility // ignore: cast_nullable_to_non_nullable
              as String?,
      gender: freezed == gender
          ? _self.gender
          : gender // ignore: cast_nullable_to_non_nullable
              as Gender?,
      birthSex: freezed == birthSex
          ? _self.birthSex
          : birthSex // ignore: cast_nullable_to_non_nullable
              as Gender?,
      mergeToPatientId: freezed == mergeToPatientId
          ? _self.mergeToPatientId
          : mergeToPatientId // ignore: cast_nullable_to_non_nullable
              as String?,
      mergedIds: null == mergedIds
          ? _self._mergedIds
          : mergedIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      alias: freezed == alias
          ? _self.alias
          : alias // ignore: cast_nullable_to_non_nullable
              as String?,
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      deactivationReason: null == deactivationReason
          ? _self.deactivationReason
          : deactivationReason // ignore: cast_nullable_to_non_nullable
              as String,
      deactivationDate: freezed == deactivationDate
          ? _self.deactivationDate
          : deactivationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      maidenName: freezed == maidenName
          ? _self.maidenName
          : maidenName // ignore: cast_nullable_to_non_nullable
              as String?,
      spouseName: freezed == spouseName
          ? _self.spouseName
          : spouseName // ignore: cast_nullable_to_non_nullable
              as String?,
      partnerName: freezed == partnerName
          ? _self.partnerName
          : partnerName // ignore: cast_nullable_to_non_nullable
              as String?,
      personalStatus: freezed == personalStatus
          ? _self.personalStatus
          : personalStatus // ignore: cast_nullable_to_non_nullable
              as PersonalStatus?,
      dateOfBirth: freezed == dateOfBirth
          ? _self.dateOfBirth
          : dateOfBirth // ignore: cast_nullable_to_non_nullable
              as int?,
      dateOfDeath: freezed == dateOfDeath
          ? _self.dateOfDeath
          : dateOfDeath // ignore: cast_nullable_to_non_nullable
              as int?,
      timestampOfLatestEidReading: freezed == timestampOfLatestEidReading
          ? _self.timestampOfLatestEidReading
          : timestampOfLatestEidReading // ignore: cast_nullable_to_non_nullable
              as int?,
      placeOfBirth: freezed == placeOfBirth
          ? _self.placeOfBirth
          : placeOfBirth // ignore: cast_nullable_to_non_nullable
              as String?,
      placeOfDeath: freezed == placeOfDeath
          ? _self.placeOfDeath
          : placeOfDeath // ignore: cast_nullable_to_non_nullable
              as String?,
      deceased: freezed == deceased
          ? _self.deceased
          : deceased // ignore: cast_nullable_to_non_nullable
              as bool?,
      education: freezed == education
          ? _self.education
          : education // ignore: cast_nullable_to_non_nullable
              as String?,
      profession: freezed == profession
          ? _self.profession
          : profession // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      administrativeNote: freezed == administrativeNote
          ? _self.administrativeNote
          : administrativeNote // ignore: cast_nullable_to_non_nullable
              as String?,
      nationality: freezed == nationality
          ? _self.nationality
          : nationality // ignore: cast_nullable_to_non_nullable
              as String?,
      race: freezed == race
          ? _self.race
          : race // ignore: cast_nullable_to_non_nullable
              as String?,
      ethnicity: freezed == ethnicity
          ? _self.ethnicity
          : ethnicity // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredUserId: freezed == preferredUserId
          ? _self.preferredUserId
          : preferredUserId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      insurabilities: null == insurabilities
          ? _self._insurabilities
          : insurabilities // ignore: cast_nullable_to_non_nullable
              as List<DecryptedInsurability>,
      partnerships: null == partnerships
          ? _self._partnerships
          : partnerships // ignore: cast_nullable_to_non_nullable
              as List<Partnership>,
      patientHealthCareParties: null == patientHealthCareParties
          ? _self._patientHealthCareParties
          : patientHealthCareParties // ignore: cast_nullable_to_non_nullable
              as List<DecryptedPatientHealthCareParty>,
      financialInstitutionInformation: null == financialInstitutionInformation
          ? _self._financialInstitutionInformation
          : financialInstitutionInformation // ignore: cast_nullable_to_non_nullable
              as List<DecryptedFinancialInstitutionInformation>,
      medicalHouseContracts: null == medicalHouseContracts
          ? _self._medicalHouseContracts
          : medicalHouseContracts // ignore: cast_nullable_to_non_nullable
              as List<DecryptedMedicalHouseContract>,
      patientProfessions: null == patientProfessions
          ? _self._patientProfessions
          : patientProfessions // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      parameters: null == parameters
          ? _self._parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self._cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      nonDuplicateIds: null == nonDuplicateIds
          ? _self._nonDuplicateIds
          : nonDuplicateIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedAdministrativesDocuments: null ==
              encryptedAdministrativesDocuments
          ? _self._encryptedAdministrativesDocuments
          : encryptedAdministrativesDocuments // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      warning: freezed == warning
          ? _self.warning
          : warning // ignore: cast_nullable_to_non_nullable
              as String?,
      fatherBirthCountry: freezed == fatherBirthCountry
          ? _self.fatherBirthCountry
          : fatherBirthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      birthCountry: freezed == birthCountry
          ? _self.birthCountry
          : birthCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      nativeCountry: freezed == nativeCountry
          ? _self.nativeCountry
          : nativeCountry // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      socialStatus: freezed == socialStatus
          ? _self.socialStatus
          : socialStatus // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      mainSourceOfIncome: freezed == mainSourceOfIncome
          ? _self.mainSourceOfIncome
          : mainSourceOfIncome // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      schoolingInfos: null == schoolingInfos
          ? _self._schoolingInfos
          : schoolingInfos // ignore: cast_nullable_to_non_nullable
              as List<DecryptedSchoolingInfo>,
      employementInfos: null == employementInfos
          ? _self._employementInfos
          : employementInfos // ignore: cast_nullable_to_non_nullable
              as List<DecryptedEmploymentInfo>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as Never?,
    ));
  }

  /// Create a copy of DecryptedPatient
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

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get fatherBirthCountry {
    if (_self.fatherBirthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.fatherBirthCountry!, (value) {
      return _then(_self.copyWith(fatherBirthCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get birthCountry {
    if (_self.birthCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.birthCountry!, (value) {
      return _then(_self.copyWith(birthCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get nativeCountry {
    if (_self.nativeCountry == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.nativeCountry!, (value) {
      return _then(_self.copyWith(nativeCountry: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get socialStatus {
    if (_self.socialStatus == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.socialStatus!, (value) {
      return _then(_self.copyWith(socialStatus: value));
    });
  }

  /// Create a copy of DecryptedPatient
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get mainSourceOfIncome {
    if (_self.mainSourceOfIncome == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.mainSourceOfIncome!, (value) {
      return _then(_self.copyWith(mainSourceOfIncome: value));
    });
  }
}

// dart format on
