// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'medication.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Medication {
  String? get compoundPrescription;
  Substanceproduct? get substanceProduct;
  Medicinalproduct? get medicinalProduct;
  int? get numberOfPackages;
  String? get batch;
  int? get expirationDate;
  String? get instructionForPatient;
  String? get instructionForReimbursement;
  String? get commentForDelivery;
  String? get drugRoute;
  String? get temporality;
  CodeStub? get frequency;
  CodeStub? get reimbursementReason;
  bool? get substitutionAllowed;
  int? get beginMoment;
  int? get endMoment;
  int? get deliveryMoment;
  int? get endExecutionMoment;
  Duration? get duration;
  Renewal? get renewal;
  bool? get knownUsage;
  List<RegimenItem>? get regimen;
  String? get posology;
  Map<String, ParagraphAgreement>? get agreements;
  String? get medicationSchemeIdOnSafe;
  int? get medicationSchemeSafeVersion;
  int? get medicationSchemeTimeStampOnSafe;
  String? get medicationSchemeDocumentId;
  String? get safeIdName;
  String? get idOnSafes;
  int? get timestampOnSafe;
  bool? get changeValidated;
  bool? get newSafeMedication;
  String? get medicationUse;
  String? get beginCondition;
  String? get endCondition;
  String? get origin;
  bool? get medicationChanged;
  bool? get posologyChanged;
  List<Suspension>? get suspension;
  String? get prescriptionRID;
  int? get status;
  DecryptedAddress? get stockLocation;

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MedicationCopyWith<Medication> get copyWith =>
      _$MedicationCopyWithImpl<Medication>(this as Medication, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Medication &&
            (identical(other.compoundPrescription, compoundPrescription) ||
                other.compoundPrescription == compoundPrescription) &&
            (identical(other.substanceProduct, substanceProduct) ||
                other.substanceProduct == substanceProduct) &&
            (identical(other.medicinalProduct, medicinalProduct) ||
                other.medicinalProduct == medicinalProduct) &&
            (identical(other.numberOfPackages, numberOfPackages) ||
                other.numberOfPackages == numberOfPackages) &&
            (identical(other.batch, batch) || other.batch == batch) &&
            (identical(other.expirationDate, expirationDate) ||
                other.expirationDate == expirationDate) &&
            (identical(other.instructionForPatient, instructionForPatient) ||
                other.instructionForPatient == instructionForPatient) &&
            (identical(other.instructionForReimbursement, instructionForReimbursement) ||
                other.instructionForReimbursement ==
                    instructionForReimbursement) &&
            (identical(other.commentForDelivery, commentForDelivery) ||
                other.commentForDelivery == commentForDelivery) &&
            (identical(other.drugRoute, drugRoute) ||
                other.drugRoute == drugRoute) &&
            (identical(other.temporality, temporality) ||
                other.temporality == temporality) &&
            (identical(other.frequency, frequency) ||
                other.frequency == frequency) &&
            (identical(other.reimbursementReason, reimbursementReason) ||
                other.reimbursementReason == reimbursementReason) &&
            (identical(other.substitutionAllowed, substitutionAllowed) ||
                other.substitutionAllowed == substitutionAllowed) &&
            (identical(other.beginMoment, beginMoment) ||
                other.beginMoment == beginMoment) &&
            (identical(other.endMoment, endMoment) ||
                other.endMoment == endMoment) &&
            (identical(other.deliveryMoment, deliveryMoment) ||
                other.deliveryMoment == deliveryMoment) &&
            (identical(other.endExecutionMoment, endExecutionMoment) ||
                other.endExecutionMoment == endExecutionMoment) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.renewal, renewal) || other.renewal == renewal) &&
            (identical(other.knownUsage, knownUsage) ||
                other.knownUsage == knownUsage) &&
            const DeepCollectionEquality().equals(other.regimen, regimen) &&
            (identical(other.posology, posology) ||
                other.posology == posology) &&
            const DeepCollectionEquality()
                .equals(other.agreements, agreements) &&
            (identical(other.medicationSchemeIdOnSafe, medicationSchemeIdOnSafe) ||
                other.medicationSchemeIdOnSafe == medicationSchemeIdOnSafe) &&
            (identical(other.medicationSchemeSafeVersion, medicationSchemeSafeVersion) ||
                other.medicationSchemeSafeVersion ==
                    medicationSchemeSafeVersion) &&
            (identical(other.medicationSchemeTimeStampOnSafe, medicationSchemeTimeStampOnSafe) ||
                other.medicationSchemeTimeStampOnSafe ==
                    medicationSchemeTimeStampOnSafe) &&
            (identical(other.medicationSchemeDocumentId, medicationSchemeDocumentId) ||
                other.medicationSchemeDocumentId ==
                    medicationSchemeDocumentId) &&
            (identical(other.safeIdName, safeIdName) ||
                other.safeIdName == safeIdName) &&
            (identical(other.idOnSafes, idOnSafes) ||
                other.idOnSafes == idOnSafes) &&
            (identical(other.timestampOnSafe, timestampOnSafe) ||
                other.timestampOnSafe == timestampOnSafe) &&
            (identical(other.changeValidated, changeValidated) ||
                other.changeValidated == changeValidated) &&
            (identical(other.newSafeMedication, newSafeMedication) ||
                other.newSafeMedication == newSafeMedication) &&
            (identical(other.medicationUse, medicationUse) || other.medicationUse == medicationUse) &&
            (identical(other.beginCondition, beginCondition) || other.beginCondition == beginCondition) &&
            (identical(other.endCondition, endCondition) || other.endCondition == endCondition) &&
            (identical(other.origin, origin) || other.origin == origin) &&
            (identical(other.medicationChanged, medicationChanged) || other.medicationChanged == medicationChanged) &&
            (identical(other.posologyChanged, posologyChanged) || other.posologyChanged == posologyChanged) &&
            const DeepCollectionEquality().equals(other.suspension, suspension) &&
            (identical(other.prescriptionRID, prescriptionRID) || other.prescriptionRID == prescriptionRID) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.stockLocation, stockLocation) || other.stockLocation == stockLocation));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        compoundPrescription,
        substanceProduct,
        medicinalProduct,
        numberOfPackages,
        batch,
        expirationDate,
        instructionForPatient,
        instructionForReimbursement,
        commentForDelivery,
        drugRoute,
        temporality,
        frequency,
        reimbursementReason,
        substitutionAllowed,
        beginMoment,
        endMoment,
        deliveryMoment,
        endExecutionMoment,
        duration,
        renewal,
        knownUsage,
        const DeepCollectionEquality().hash(regimen),
        posology,
        const DeepCollectionEquality().hash(agreements),
        medicationSchemeIdOnSafe,
        medicationSchemeSafeVersion,
        medicationSchemeTimeStampOnSafe,
        medicationSchemeDocumentId,
        safeIdName,
        idOnSafes,
        timestampOnSafe,
        changeValidated,
        newSafeMedication,
        medicationUse,
        beginCondition,
        endCondition,
        origin,
        medicationChanged,
        posologyChanged,
        const DeepCollectionEquality().hash(suspension),
        prescriptionRID,
        status,
        stockLocation
      ]);

  @override
  String toString() {
    return 'Medication(compoundPrescription: $compoundPrescription, substanceProduct: $substanceProduct, medicinalProduct: $medicinalProduct, numberOfPackages: $numberOfPackages, batch: $batch, expirationDate: $expirationDate, instructionForPatient: $instructionForPatient, instructionForReimbursement: $instructionForReimbursement, commentForDelivery: $commentForDelivery, drugRoute: $drugRoute, temporality: $temporality, frequency: $frequency, reimbursementReason: $reimbursementReason, substitutionAllowed: $substitutionAllowed, beginMoment: $beginMoment, endMoment: $endMoment, deliveryMoment: $deliveryMoment, endExecutionMoment: $endExecutionMoment, duration: $duration, renewal: $renewal, knownUsage: $knownUsage, regimen: $regimen, posology: $posology, agreements: $agreements, medicationSchemeIdOnSafe: $medicationSchemeIdOnSafe, medicationSchemeSafeVersion: $medicationSchemeSafeVersion, medicationSchemeTimeStampOnSafe: $medicationSchemeTimeStampOnSafe, medicationSchemeDocumentId: $medicationSchemeDocumentId, safeIdName: $safeIdName, idOnSafes: $idOnSafes, timestampOnSafe: $timestampOnSafe, changeValidated: $changeValidated, newSafeMedication: $newSafeMedication, medicationUse: $medicationUse, beginCondition: $beginCondition, endCondition: $endCondition, origin: $origin, medicationChanged: $medicationChanged, posologyChanged: $posologyChanged, suspension: $suspension, prescriptionRID: $prescriptionRID, status: $status, stockLocation: $stockLocation)';
  }
}

/// @nodoc
abstract mixin class $MedicationCopyWith<$Res> {
  factory $MedicationCopyWith(
          Medication value, $Res Function(Medication) _then) =
      _$MedicationCopyWithImpl;
  @useResult
  $Res call(
      {String? compoundPrescription,
      Substanceproduct? substanceProduct,
      Medicinalproduct? medicinalProduct,
      int? numberOfPackages,
      String? batch,
      int? expirationDate,
      String? instructionForPatient,
      String? instructionForReimbursement,
      String? commentForDelivery,
      String? drugRoute,
      String? temporality,
      CodeStub? frequency,
      CodeStub? reimbursementReason,
      bool? substitutionAllowed,
      int? beginMoment,
      int? endMoment,
      int? deliveryMoment,
      int? endExecutionMoment,
      Duration? duration,
      Renewal? renewal,
      bool? knownUsage,
      List<RegimenItem>? regimen,
      String? posology,
      Map<String, ParagraphAgreement>? agreements,
      String? medicationSchemeIdOnSafe,
      int? medicationSchemeSafeVersion,
      int? medicationSchemeTimeStampOnSafe,
      String? medicationSchemeDocumentId,
      String? safeIdName,
      String? idOnSafes,
      int? timestampOnSafe,
      bool? changeValidated,
      bool? newSafeMedication,
      String? medicationUse,
      String? beginCondition,
      String? endCondition,
      String? origin,
      bool? medicationChanged,
      bool? posologyChanged,
      List<Suspension>? suspension,
      String? prescriptionRID,
      int? status,
      DecryptedAddress? stockLocation});

  $SubstanceproductCopyWith<$Res>? get substanceProduct;
  $MedicinalproductCopyWith<$Res>? get medicinalProduct;
  $CodeStubCopyWith<$Res>? get frequency;
  $CodeStubCopyWith<$Res>? get reimbursementReason;
  $DurationCopyWith<$Res>? get duration;
  $RenewalCopyWith<$Res>? get renewal;
  $DecryptedAddressCopyWith<$Res>? get stockLocation;
}

/// @nodoc
class _$MedicationCopyWithImpl<$Res> implements $MedicationCopyWith<$Res> {
  _$MedicationCopyWithImpl(this._self, this._then);

  final Medication _self;
  final $Res Function(Medication) _then;

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? compoundPrescription = freezed,
    Object? substanceProduct = freezed,
    Object? medicinalProduct = freezed,
    Object? numberOfPackages = freezed,
    Object? batch = freezed,
    Object? expirationDate = freezed,
    Object? instructionForPatient = freezed,
    Object? instructionForReimbursement = freezed,
    Object? commentForDelivery = freezed,
    Object? drugRoute = freezed,
    Object? temporality = freezed,
    Object? frequency = freezed,
    Object? reimbursementReason = freezed,
    Object? substitutionAllowed = freezed,
    Object? beginMoment = freezed,
    Object? endMoment = freezed,
    Object? deliveryMoment = freezed,
    Object? endExecutionMoment = freezed,
    Object? duration = freezed,
    Object? renewal = freezed,
    Object? knownUsage = freezed,
    Object? regimen = freezed,
    Object? posology = freezed,
    Object? agreements = freezed,
    Object? medicationSchemeIdOnSafe = freezed,
    Object? medicationSchemeSafeVersion = freezed,
    Object? medicationSchemeTimeStampOnSafe = freezed,
    Object? medicationSchemeDocumentId = freezed,
    Object? safeIdName = freezed,
    Object? idOnSafes = freezed,
    Object? timestampOnSafe = freezed,
    Object? changeValidated = freezed,
    Object? newSafeMedication = freezed,
    Object? medicationUse = freezed,
    Object? beginCondition = freezed,
    Object? endCondition = freezed,
    Object? origin = freezed,
    Object? medicationChanged = freezed,
    Object? posologyChanged = freezed,
    Object? suspension = freezed,
    Object? prescriptionRID = freezed,
    Object? status = freezed,
    Object? stockLocation = freezed,
  }) {
    return _then(_self.copyWith(
      compoundPrescription: freezed == compoundPrescription
          ? _self.compoundPrescription
          : compoundPrescription // ignore: cast_nullable_to_non_nullable
              as String?,
      substanceProduct: freezed == substanceProduct
          ? _self.substanceProduct
          : substanceProduct // ignore: cast_nullable_to_non_nullable
              as Substanceproduct?,
      medicinalProduct: freezed == medicinalProduct
          ? _self.medicinalProduct
          : medicinalProduct // ignore: cast_nullable_to_non_nullable
              as Medicinalproduct?,
      numberOfPackages: freezed == numberOfPackages
          ? _self.numberOfPackages
          : numberOfPackages // ignore: cast_nullable_to_non_nullable
              as int?,
      batch: freezed == batch
          ? _self.batch
          : batch // ignore: cast_nullable_to_non_nullable
              as String?,
      expirationDate: freezed == expirationDate
          ? _self.expirationDate
          : expirationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      instructionForPatient: freezed == instructionForPatient
          ? _self.instructionForPatient
          : instructionForPatient // ignore: cast_nullable_to_non_nullable
              as String?,
      instructionForReimbursement: freezed == instructionForReimbursement
          ? _self.instructionForReimbursement
          : instructionForReimbursement // ignore: cast_nullable_to_non_nullable
              as String?,
      commentForDelivery: freezed == commentForDelivery
          ? _self.commentForDelivery
          : commentForDelivery // ignore: cast_nullable_to_non_nullable
              as String?,
      drugRoute: freezed == drugRoute
          ? _self.drugRoute
          : drugRoute // ignore: cast_nullable_to_non_nullable
              as String?,
      temporality: freezed == temporality
          ? _self.temporality
          : temporality // ignore: cast_nullable_to_non_nullable
              as String?,
      frequency: freezed == frequency
          ? _self.frequency
          : frequency // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      reimbursementReason: freezed == reimbursementReason
          ? _self.reimbursementReason
          : reimbursementReason // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      substitutionAllowed: freezed == substitutionAllowed
          ? _self.substitutionAllowed
          : substitutionAllowed // ignore: cast_nullable_to_non_nullable
              as bool?,
      beginMoment: freezed == beginMoment
          ? _self.beginMoment
          : beginMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endMoment: freezed == endMoment
          ? _self.endMoment
          : endMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      deliveryMoment: freezed == deliveryMoment
          ? _self.deliveryMoment
          : deliveryMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endExecutionMoment: freezed == endExecutionMoment
          ? _self.endExecutionMoment
          : endExecutionMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as Duration?,
      renewal: freezed == renewal
          ? _self.renewal
          : renewal // ignore: cast_nullable_to_non_nullable
              as Renewal?,
      knownUsage: freezed == knownUsage
          ? _self.knownUsage
          : knownUsage // ignore: cast_nullable_to_non_nullable
              as bool?,
      regimen: freezed == regimen
          ? _self.regimen
          : regimen // ignore: cast_nullable_to_non_nullable
              as List<RegimenItem>?,
      posology: freezed == posology
          ? _self.posology
          : posology // ignore: cast_nullable_to_non_nullable
              as String?,
      agreements: freezed == agreements
          ? _self.agreements
          : agreements // ignore: cast_nullable_to_non_nullable
              as Map<String, ParagraphAgreement>?,
      medicationSchemeIdOnSafe: freezed == medicationSchemeIdOnSafe
          ? _self.medicationSchemeIdOnSafe
          : medicationSchemeIdOnSafe // ignore: cast_nullable_to_non_nullable
              as String?,
      medicationSchemeSafeVersion: freezed == medicationSchemeSafeVersion
          ? _self.medicationSchemeSafeVersion
          : medicationSchemeSafeVersion // ignore: cast_nullable_to_non_nullable
              as int?,
      medicationSchemeTimeStampOnSafe: freezed ==
              medicationSchemeTimeStampOnSafe
          ? _self.medicationSchemeTimeStampOnSafe
          : medicationSchemeTimeStampOnSafe // ignore: cast_nullable_to_non_nullable
              as int?,
      medicationSchemeDocumentId: freezed == medicationSchemeDocumentId
          ? _self.medicationSchemeDocumentId
          : medicationSchemeDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      safeIdName: freezed == safeIdName
          ? _self.safeIdName
          : safeIdName // ignore: cast_nullable_to_non_nullable
              as String?,
      idOnSafes: freezed == idOnSafes
          ? _self.idOnSafes
          : idOnSafes // ignore: cast_nullable_to_non_nullable
              as String?,
      timestampOnSafe: freezed == timestampOnSafe
          ? _self.timestampOnSafe
          : timestampOnSafe // ignore: cast_nullable_to_non_nullable
              as int?,
      changeValidated: freezed == changeValidated
          ? _self.changeValidated
          : changeValidated // ignore: cast_nullable_to_non_nullable
              as bool?,
      newSafeMedication: freezed == newSafeMedication
          ? _self.newSafeMedication
          : newSafeMedication // ignore: cast_nullable_to_non_nullable
              as bool?,
      medicationUse: freezed == medicationUse
          ? _self.medicationUse
          : medicationUse // ignore: cast_nullable_to_non_nullable
              as String?,
      beginCondition: freezed == beginCondition
          ? _self.beginCondition
          : beginCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      endCondition: freezed == endCondition
          ? _self.endCondition
          : endCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      origin: freezed == origin
          ? _self.origin
          : origin // ignore: cast_nullable_to_non_nullable
              as String?,
      medicationChanged: freezed == medicationChanged
          ? _self.medicationChanged
          : medicationChanged // ignore: cast_nullable_to_non_nullable
              as bool?,
      posologyChanged: freezed == posologyChanged
          ? _self.posologyChanged
          : posologyChanged // ignore: cast_nullable_to_non_nullable
              as bool?,
      suspension: freezed == suspension
          ? _self.suspension
          : suspension // ignore: cast_nullable_to_non_nullable
              as List<Suspension>?,
      prescriptionRID: freezed == prescriptionRID
          ? _self.prescriptionRID
          : prescriptionRID // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      stockLocation: freezed == stockLocation
          ? _self.stockLocation
          : stockLocation // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
    ));
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SubstanceproductCopyWith<$Res>? get substanceProduct {
    if (_self.substanceProduct == null) {
      return null;
    }

    return $SubstanceproductCopyWith<$Res>(_self.substanceProduct!, (value) {
      return _then(_self.copyWith(substanceProduct: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicinalproductCopyWith<$Res>? get medicinalProduct {
    if (_self.medicinalProduct == null) {
      return null;
    }

    return $MedicinalproductCopyWith<$Res>(_self.medicinalProduct!, (value) {
      return _then(_self.copyWith(medicinalProduct: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get frequency {
    if (_self.frequency == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.frequency!, (value) {
      return _then(_self.copyWith(frequency: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get reimbursementReason {
    if (_self.reimbursementReason == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.reimbursementReason!, (value) {
      return _then(_self.copyWith(reimbursementReason: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DurationCopyWith<$Res>? get duration {
    if (_self.duration == null) {
      return null;
    }

    return $DurationCopyWith<$Res>(_self.duration!, (value) {
      return _then(_self.copyWith(duration: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RenewalCopyWith<$Res>? get renewal {
    if (_self.renewal == null) {
      return null;
    }

    return $RenewalCopyWith<$Res>(_self.renewal!, (value) {
      return _then(_self.copyWith(renewal: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get stockLocation {
    if (_self.stockLocation == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.stockLocation!, (value) {
      return _then(_self.copyWith(stockLocation: value));
    });
  }
}

/// @nodoc

class _Medication implements Medication {
  const _Medication(
      {this.compoundPrescription = null,
      this.substanceProduct = null,
      this.medicinalProduct = null,
      this.numberOfPackages = null,
      this.batch = null,
      this.expirationDate = null,
      this.instructionForPatient = null,
      this.instructionForReimbursement = null,
      this.commentForDelivery = null,
      this.drugRoute = null,
      this.temporality = null,
      this.frequency = null,
      this.reimbursementReason = null,
      this.substitutionAllowed = null,
      this.beginMoment = null,
      this.endMoment = null,
      this.deliveryMoment = null,
      this.endExecutionMoment = null,
      this.duration = null,
      this.renewal = null,
      this.knownUsage = null,
      final List<RegimenItem>? regimen = null,
      this.posology = null,
      final Map<String, ParagraphAgreement>? agreements = null,
      this.medicationSchemeIdOnSafe = null,
      this.medicationSchemeSafeVersion = null,
      this.medicationSchemeTimeStampOnSafe = null,
      this.medicationSchemeDocumentId = null,
      this.safeIdName = null,
      this.idOnSafes = null,
      this.timestampOnSafe = null,
      this.changeValidated = null,
      this.newSafeMedication = null,
      this.medicationUse = null,
      this.beginCondition = null,
      this.endCondition = null,
      this.origin = null,
      this.medicationChanged = null,
      this.posologyChanged = null,
      final List<Suspension>? suspension = null,
      this.prescriptionRID = null,
      this.status = null,
      this.stockLocation = null})
      : _regimen = regimen,
        _agreements = agreements,
        _suspension = suspension;

  @override
  @JsonKey()
  final String? compoundPrescription;
  @override
  @JsonKey()
  final Substanceproduct? substanceProduct;
  @override
  @JsonKey()
  final Medicinalproduct? medicinalProduct;
  @override
  @JsonKey()
  final int? numberOfPackages;
  @override
  @JsonKey()
  final String? batch;
  @override
  @JsonKey()
  final int? expirationDate;
  @override
  @JsonKey()
  final String? instructionForPatient;
  @override
  @JsonKey()
  final String? instructionForReimbursement;
  @override
  @JsonKey()
  final String? commentForDelivery;
  @override
  @JsonKey()
  final String? drugRoute;
  @override
  @JsonKey()
  final String? temporality;
  @override
  @JsonKey()
  final CodeStub? frequency;
  @override
  @JsonKey()
  final CodeStub? reimbursementReason;
  @override
  @JsonKey()
  final bool? substitutionAllowed;
  @override
  @JsonKey()
  final int? beginMoment;
  @override
  @JsonKey()
  final int? endMoment;
  @override
  @JsonKey()
  final int? deliveryMoment;
  @override
  @JsonKey()
  final int? endExecutionMoment;
  @override
  @JsonKey()
  final Duration? duration;
  @override
  @JsonKey()
  final Renewal? renewal;
  @override
  @JsonKey()
  final bool? knownUsage;
  final List<RegimenItem>? _regimen;
  @override
  @JsonKey()
  List<RegimenItem>? get regimen {
    final value = _regimen;
    if (value == null) return null;
    if (_regimen is EqualUnmodifiableListView) return _regimen;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? posology;
  final Map<String, ParagraphAgreement>? _agreements;
  @override
  @JsonKey()
  Map<String, ParagraphAgreement>? get agreements {
    final value = _agreements;
    if (value == null) return null;
    if (_agreements is EqualUnmodifiableMapView) return _agreements;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final String? medicationSchemeIdOnSafe;
  @override
  @JsonKey()
  final int? medicationSchemeSafeVersion;
  @override
  @JsonKey()
  final int? medicationSchemeTimeStampOnSafe;
  @override
  @JsonKey()
  final String? medicationSchemeDocumentId;
  @override
  @JsonKey()
  final String? safeIdName;
  @override
  @JsonKey()
  final String? idOnSafes;
  @override
  @JsonKey()
  final int? timestampOnSafe;
  @override
  @JsonKey()
  final bool? changeValidated;
  @override
  @JsonKey()
  final bool? newSafeMedication;
  @override
  @JsonKey()
  final String? medicationUse;
  @override
  @JsonKey()
  final String? beginCondition;
  @override
  @JsonKey()
  final String? endCondition;
  @override
  @JsonKey()
  final String? origin;
  @override
  @JsonKey()
  final bool? medicationChanged;
  @override
  @JsonKey()
  final bool? posologyChanged;
  final List<Suspension>? _suspension;
  @override
  @JsonKey()
  List<Suspension>? get suspension {
    final value = _suspension;
    if (value == null) return null;
    if (_suspension is EqualUnmodifiableListView) return _suspension;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? prescriptionRID;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final DecryptedAddress? stockLocation;

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MedicationCopyWith<_Medication> get copyWith =>
      __$MedicationCopyWithImpl<_Medication>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Medication &&
            (identical(other.compoundPrescription, compoundPrescription) ||
                other.compoundPrescription == compoundPrescription) &&
            (identical(other.substanceProduct, substanceProduct) ||
                other.substanceProduct == substanceProduct) &&
            (identical(other.medicinalProduct, medicinalProduct) ||
                other.medicinalProduct == medicinalProduct) &&
            (identical(other.numberOfPackages, numberOfPackages) ||
                other.numberOfPackages == numberOfPackages) &&
            (identical(other.batch, batch) || other.batch == batch) &&
            (identical(other.expirationDate, expirationDate) ||
                other.expirationDate == expirationDate) &&
            (identical(other.instructionForPatient, instructionForPatient) ||
                other.instructionForPatient == instructionForPatient) &&
            (identical(other.instructionForReimbursement, instructionForReimbursement) ||
                other.instructionForReimbursement ==
                    instructionForReimbursement) &&
            (identical(other.commentForDelivery, commentForDelivery) ||
                other.commentForDelivery == commentForDelivery) &&
            (identical(other.drugRoute, drugRoute) ||
                other.drugRoute == drugRoute) &&
            (identical(other.temporality, temporality) ||
                other.temporality == temporality) &&
            (identical(other.frequency, frequency) ||
                other.frequency == frequency) &&
            (identical(other.reimbursementReason, reimbursementReason) ||
                other.reimbursementReason == reimbursementReason) &&
            (identical(other.substitutionAllowed, substitutionAllowed) ||
                other.substitutionAllowed == substitutionAllowed) &&
            (identical(other.beginMoment, beginMoment) ||
                other.beginMoment == beginMoment) &&
            (identical(other.endMoment, endMoment) ||
                other.endMoment == endMoment) &&
            (identical(other.deliveryMoment, deliveryMoment) ||
                other.deliveryMoment == deliveryMoment) &&
            (identical(other.endExecutionMoment, endExecutionMoment) ||
                other.endExecutionMoment == endExecutionMoment) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.renewal, renewal) || other.renewal == renewal) &&
            (identical(other.knownUsage, knownUsage) ||
                other.knownUsage == knownUsage) &&
            const DeepCollectionEquality().equals(other._regimen, _regimen) &&
            (identical(other.posology, posology) ||
                other.posology == posology) &&
            const DeepCollectionEquality()
                .equals(other._agreements, _agreements) &&
            (identical(other.medicationSchemeIdOnSafe, medicationSchemeIdOnSafe) ||
                other.medicationSchemeIdOnSafe == medicationSchemeIdOnSafe) &&
            (identical(other.medicationSchemeSafeVersion, medicationSchemeSafeVersion) ||
                other.medicationSchemeSafeVersion ==
                    medicationSchemeSafeVersion) &&
            (identical(other.medicationSchemeTimeStampOnSafe, medicationSchemeTimeStampOnSafe) ||
                other.medicationSchemeTimeStampOnSafe ==
                    medicationSchemeTimeStampOnSafe) &&
            (identical(other.medicationSchemeDocumentId, medicationSchemeDocumentId) ||
                other.medicationSchemeDocumentId ==
                    medicationSchemeDocumentId) &&
            (identical(other.safeIdName, safeIdName) ||
                other.safeIdName == safeIdName) &&
            (identical(other.idOnSafes, idOnSafes) ||
                other.idOnSafes == idOnSafes) &&
            (identical(other.timestampOnSafe, timestampOnSafe) ||
                other.timestampOnSafe == timestampOnSafe) &&
            (identical(other.changeValidated, changeValidated) ||
                other.changeValidated == changeValidated) &&
            (identical(other.newSafeMedication, newSafeMedication) ||
                other.newSafeMedication == newSafeMedication) &&
            (identical(other.medicationUse, medicationUse) || other.medicationUse == medicationUse) &&
            (identical(other.beginCondition, beginCondition) || other.beginCondition == beginCondition) &&
            (identical(other.endCondition, endCondition) || other.endCondition == endCondition) &&
            (identical(other.origin, origin) || other.origin == origin) &&
            (identical(other.medicationChanged, medicationChanged) || other.medicationChanged == medicationChanged) &&
            (identical(other.posologyChanged, posologyChanged) || other.posologyChanged == posologyChanged) &&
            const DeepCollectionEquality().equals(other._suspension, _suspension) &&
            (identical(other.prescriptionRID, prescriptionRID) || other.prescriptionRID == prescriptionRID) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.stockLocation, stockLocation) || other.stockLocation == stockLocation));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        compoundPrescription,
        substanceProduct,
        medicinalProduct,
        numberOfPackages,
        batch,
        expirationDate,
        instructionForPatient,
        instructionForReimbursement,
        commentForDelivery,
        drugRoute,
        temporality,
        frequency,
        reimbursementReason,
        substitutionAllowed,
        beginMoment,
        endMoment,
        deliveryMoment,
        endExecutionMoment,
        duration,
        renewal,
        knownUsage,
        const DeepCollectionEquality().hash(_regimen),
        posology,
        const DeepCollectionEquality().hash(_agreements),
        medicationSchemeIdOnSafe,
        medicationSchemeSafeVersion,
        medicationSchemeTimeStampOnSafe,
        medicationSchemeDocumentId,
        safeIdName,
        idOnSafes,
        timestampOnSafe,
        changeValidated,
        newSafeMedication,
        medicationUse,
        beginCondition,
        endCondition,
        origin,
        medicationChanged,
        posologyChanged,
        const DeepCollectionEquality().hash(_suspension),
        prescriptionRID,
        status,
        stockLocation
      ]);

  @override
  String toString() {
    return 'Medication(compoundPrescription: $compoundPrescription, substanceProduct: $substanceProduct, medicinalProduct: $medicinalProduct, numberOfPackages: $numberOfPackages, batch: $batch, expirationDate: $expirationDate, instructionForPatient: $instructionForPatient, instructionForReimbursement: $instructionForReimbursement, commentForDelivery: $commentForDelivery, drugRoute: $drugRoute, temporality: $temporality, frequency: $frequency, reimbursementReason: $reimbursementReason, substitutionAllowed: $substitutionAllowed, beginMoment: $beginMoment, endMoment: $endMoment, deliveryMoment: $deliveryMoment, endExecutionMoment: $endExecutionMoment, duration: $duration, renewal: $renewal, knownUsage: $knownUsage, regimen: $regimen, posology: $posology, agreements: $agreements, medicationSchemeIdOnSafe: $medicationSchemeIdOnSafe, medicationSchemeSafeVersion: $medicationSchemeSafeVersion, medicationSchemeTimeStampOnSafe: $medicationSchemeTimeStampOnSafe, medicationSchemeDocumentId: $medicationSchemeDocumentId, safeIdName: $safeIdName, idOnSafes: $idOnSafes, timestampOnSafe: $timestampOnSafe, changeValidated: $changeValidated, newSafeMedication: $newSafeMedication, medicationUse: $medicationUse, beginCondition: $beginCondition, endCondition: $endCondition, origin: $origin, medicationChanged: $medicationChanged, posologyChanged: $posologyChanged, suspension: $suspension, prescriptionRID: $prescriptionRID, status: $status, stockLocation: $stockLocation)';
  }
}

/// @nodoc
abstract mixin class _$MedicationCopyWith<$Res>
    implements $MedicationCopyWith<$Res> {
  factory _$MedicationCopyWith(
          _Medication value, $Res Function(_Medication) _then) =
      __$MedicationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? compoundPrescription,
      Substanceproduct? substanceProduct,
      Medicinalproduct? medicinalProduct,
      int? numberOfPackages,
      String? batch,
      int? expirationDate,
      String? instructionForPatient,
      String? instructionForReimbursement,
      String? commentForDelivery,
      String? drugRoute,
      String? temporality,
      CodeStub? frequency,
      CodeStub? reimbursementReason,
      bool? substitutionAllowed,
      int? beginMoment,
      int? endMoment,
      int? deliveryMoment,
      int? endExecutionMoment,
      Duration? duration,
      Renewal? renewal,
      bool? knownUsage,
      List<RegimenItem>? regimen,
      String? posology,
      Map<String, ParagraphAgreement>? agreements,
      String? medicationSchemeIdOnSafe,
      int? medicationSchemeSafeVersion,
      int? medicationSchemeTimeStampOnSafe,
      String? medicationSchemeDocumentId,
      String? safeIdName,
      String? idOnSafes,
      int? timestampOnSafe,
      bool? changeValidated,
      bool? newSafeMedication,
      String? medicationUse,
      String? beginCondition,
      String? endCondition,
      String? origin,
      bool? medicationChanged,
      bool? posologyChanged,
      List<Suspension>? suspension,
      String? prescriptionRID,
      int? status,
      DecryptedAddress? stockLocation});

  @override
  $SubstanceproductCopyWith<$Res>? get substanceProduct;
  @override
  $MedicinalproductCopyWith<$Res>? get medicinalProduct;
  @override
  $CodeStubCopyWith<$Res>? get frequency;
  @override
  $CodeStubCopyWith<$Res>? get reimbursementReason;
  @override
  $DurationCopyWith<$Res>? get duration;
  @override
  $RenewalCopyWith<$Res>? get renewal;
  @override
  $DecryptedAddressCopyWith<$Res>? get stockLocation;
}

/// @nodoc
class __$MedicationCopyWithImpl<$Res> implements _$MedicationCopyWith<$Res> {
  __$MedicationCopyWithImpl(this._self, this._then);

  final _Medication _self;
  final $Res Function(_Medication) _then;

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? compoundPrescription = freezed,
    Object? substanceProduct = freezed,
    Object? medicinalProduct = freezed,
    Object? numberOfPackages = freezed,
    Object? batch = freezed,
    Object? expirationDate = freezed,
    Object? instructionForPatient = freezed,
    Object? instructionForReimbursement = freezed,
    Object? commentForDelivery = freezed,
    Object? drugRoute = freezed,
    Object? temporality = freezed,
    Object? frequency = freezed,
    Object? reimbursementReason = freezed,
    Object? substitutionAllowed = freezed,
    Object? beginMoment = freezed,
    Object? endMoment = freezed,
    Object? deliveryMoment = freezed,
    Object? endExecutionMoment = freezed,
    Object? duration = freezed,
    Object? renewal = freezed,
    Object? knownUsage = freezed,
    Object? regimen = freezed,
    Object? posology = freezed,
    Object? agreements = freezed,
    Object? medicationSchemeIdOnSafe = freezed,
    Object? medicationSchemeSafeVersion = freezed,
    Object? medicationSchemeTimeStampOnSafe = freezed,
    Object? medicationSchemeDocumentId = freezed,
    Object? safeIdName = freezed,
    Object? idOnSafes = freezed,
    Object? timestampOnSafe = freezed,
    Object? changeValidated = freezed,
    Object? newSafeMedication = freezed,
    Object? medicationUse = freezed,
    Object? beginCondition = freezed,
    Object? endCondition = freezed,
    Object? origin = freezed,
    Object? medicationChanged = freezed,
    Object? posologyChanged = freezed,
    Object? suspension = freezed,
    Object? prescriptionRID = freezed,
    Object? status = freezed,
    Object? stockLocation = freezed,
  }) {
    return _then(_Medication(
      compoundPrescription: freezed == compoundPrescription
          ? _self.compoundPrescription
          : compoundPrescription // ignore: cast_nullable_to_non_nullable
              as String?,
      substanceProduct: freezed == substanceProduct
          ? _self.substanceProduct
          : substanceProduct // ignore: cast_nullable_to_non_nullable
              as Substanceproduct?,
      medicinalProduct: freezed == medicinalProduct
          ? _self.medicinalProduct
          : medicinalProduct // ignore: cast_nullable_to_non_nullable
              as Medicinalproduct?,
      numberOfPackages: freezed == numberOfPackages
          ? _self.numberOfPackages
          : numberOfPackages // ignore: cast_nullable_to_non_nullable
              as int?,
      batch: freezed == batch
          ? _self.batch
          : batch // ignore: cast_nullable_to_non_nullable
              as String?,
      expirationDate: freezed == expirationDate
          ? _self.expirationDate
          : expirationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      instructionForPatient: freezed == instructionForPatient
          ? _self.instructionForPatient
          : instructionForPatient // ignore: cast_nullable_to_non_nullable
              as String?,
      instructionForReimbursement: freezed == instructionForReimbursement
          ? _self.instructionForReimbursement
          : instructionForReimbursement // ignore: cast_nullable_to_non_nullable
              as String?,
      commentForDelivery: freezed == commentForDelivery
          ? _self.commentForDelivery
          : commentForDelivery // ignore: cast_nullable_to_non_nullable
              as String?,
      drugRoute: freezed == drugRoute
          ? _self.drugRoute
          : drugRoute // ignore: cast_nullable_to_non_nullable
              as String?,
      temporality: freezed == temporality
          ? _self.temporality
          : temporality // ignore: cast_nullable_to_non_nullable
              as String?,
      frequency: freezed == frequency
          ? _self.frequency
          : frequency // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      reimbursementReason: freezed == reimbursementReason
          ? _self.reimbursementReason
          : reimbursementReason // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      substitutionAllowed: freezed == substitutionAllowed
          ? _self.substitutionAllowed
          : substitutionAllowed // ignore: cast_nullable_to_non_nullable
              as bool?,
      beginMoment: freezed == beginMoment
          ? _self.beginMoment
          : beginMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endMoment: freezed == endMoment
          ? _self.endMoment
          : endMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      deliveryMoment: freezed == deliveryMoment
          ? _self.deliveryMoment
          : deliveryMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endExecutionMoment: freezed == endExecutionMoment
          ? _self.endExecutionMoment
          : endExecutionMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as Duration?,
      renewal: freezed == renewal
          ? _self.renewal
          : renewal // ignore: cast_nullable_to_non_nullable
              as Renewal?,
      knownUsage: freezed == knownUsage
          ? _self.knownUsage
          : knownUsage // ignore: cast_nullable_to_non_nullable
              as bool?,
      regimen: freezed == regimen
          ? _self._regimen
          : regimen // ignore: cast_nullable_to_non_nullable
              as List<RegimenItem>?,
      posology: freezed == posology
          ? _self.posology
          : posology // ignore: cast_nullable_to_non_nullable
              as String?,
      agreements: freezed == agreements
          ? _self._agreements
          : agreements // ignore: cast_nullable_to_non_nullable
              as Map<String, ParagraphAgreement>?,
      medicationSchemeIdOnSafe: freezed == medicationSchemeIdOnSafe
          ? _self.medicationSchemeIdOnSafe
          : medicationSchemeIdOnSafe // ignore: cast_nullable_to_non_nullable
              as String?,
      medicationSchemeSafeVersion: freezed == medicationSchemeSafeVersion
          ? _self.medicationSchemeSafeVersion
          : medicationSchemeSafeVersion // ignore: cast_nullable_to_non_nullable
              as int?,
      medicationSchemeTimeStampOnSafe: freezed ==
              medicationSchemeTimeStampOnSafe
          ? _self.medicationSchemeTimeStampOnSafe
          : medicationSchemeTimeStampOnSafe // ignore: cast_nullable_to_non_nullable
              as int?,
      medicationSchemeDocumentId: freezed == medicationSchemeDocumentId
          ? _self.medicationSchemeDocumentId
          : medicationSchemeDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      safeIdName: freezed == safeIdName
          ? _self.safeIdName
          : safeIdName // ignore: cast_nullable_to_non_nullable
              as String?,
      idOnSafes: freezed == idOnSafes
          ? _self.idOnSafes
          : idOnSafes // ignore: cast_nullable_to_non_nullable
              as String?,
      timestampOnSafe: freezed == timestampOnSafe
          ? _self.timestampOnSafe
          : timestampOnSafe // ignore: cast_nullable_to_non_nullable
              as int?,
      changeValidated: freezed == changeValidated
          ? _self.changeValidated
          : changeValidated // ignore: cast_nullable_to_non_nullable
              as bool?,
      newSafeMedication: freezed == newSafeMedication
          ? _self.newSafeMedication
          : newSafeMedication // ignore: cast_nullable_to_non_nullable
              as bool?,
      medicationUse: freezed == medicationUse
          ? _self.medicationUse
          : medicationUse // ignore: cast_nullable_to_non_nullable
              as String?,
      beginCondition: freezed == beginCondition
          ? _self.beginCondition
          : beginCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      endCondition: freezed == endCondition
          ? _self.endCondition
          : endCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      origin: freezed == origin
          ? _self.origin
          : origin // ignore: cast_nullable_to_non_nullable
              as String?,
      medicationChanged: freezed == medicationChanged
          ? _self.medicationChanged
          : medicationChanged // ignore: cast_nullable_to_non_nullable
              as bool?,
      posologyChanged: freezed == posologyChanged
          ? _self.posologyChanged
          : posologyChanged // ignore: cast_nullable_to_non_nullable
              as bool?,
      suspension: freezed == suspension
          ? _self._suspension
          : suspension // ignore: cast_nullable_to_non_nullable
              as List<Suspension>?,
      prescriptionRID: freezed == prescriptionRID
          ? _self.prescriptionRID
          : prescriptionRID // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      stockLocation: freezed == stockLocation
          ? _self.stockLocation
          : stockLocation // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
    ));
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SubstanceproductCopyWith<$Res>? get substanceProduct {
    if (_self.substanceProduct == null) {
      return null;
    }

    return $SubstanceproductCopyWith<$Res>(_self.substanceProduct!, (value) {
      return _then(_self.copyWith(substanceProduct: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicinalproductCopyWith<$Res>? get medicinalProduct {
    if (_self.medicinalProduct == null) {
      return null;
    }

    return $MedicinalproductCopyWith<$Res>(_self.medicinalProduct!, (value) {
      return _then(_self.copyWith(medicinalProduct: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get frequency {
    if (_self.frequency == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.frequency!, (value) {
      return _then(_self.copyWith(frequency: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get reimbursementReason {
    if (_self.reimbursementReason == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.reimbursementReason!, (value) {
      return _then(_self.copyWith(reimbursementReason: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DurationCopyWith<$Res>? get duration {
    if (_self.duration == null) {
      return null;
    }

    return $DurationCopyWith<$Res>(_self.duration!, (value) {
      return _then(_self.copyWith(duration: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RenewalCopyWith<$Res>? get renewal {
    if (_self.renewal == null) {
      return null;
    }

    return $RenewalCopyWith<$Res>(_self.renewal!, (value) {
      return _then(_self.copyWith(renewal: value));
    });
  }

  /// Create a copy of Medication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get stockLocation {
    if (_self.stockLocation == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.stockLocation!, (value) {
      return _then(_self.copyWith(stockLocation: value));
    });
  }
}

// dart format on
