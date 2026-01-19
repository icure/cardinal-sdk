// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'invoicing_code.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedInvoicingCode {
  String? get id;
  int? get dateCode;
  String? get logicalId;
  String? get label;
  String? get userId;
  String? get contactId;
  String? get serviceId;
  String? get tarificationId;
  String? get code;
  PaymentType? get paymentType;
  double? get paid;
  double? get totalAmount;
  double? get reimbursement;
  double? get patientIntervention;
  double? get amiIntervention;
  double? get doctorSupplement;
  double? get conventionAmount;
  double? get vat;
  String? get error;
  String? get contract;
  int? get contractDate;
  int? get units;
  int? get side;
  int? get timeOfDay;
  int? get eidReadingHour;
  String? get eidReadingValue;
  int? get override3rdPayerCode;
  String? get override3rdPayerReason;
  int? get transplantationCode;
  int? get prescriberNorm;
  String? get productLabel;
  int? get percentNorm;
  String? get prescriberNihii;
  String? get relatedCode;
  int? get prescriptionDate;
  int? get derogationMaxNumber;
  String? get prescriberSsin;
  String? get prescriberLastName;
  String? get prescriberFirstName;
  String? get prescriberCdHcParty;
  String? get locationNihii;
  String? get locationCdHcParty;
  int? get locationService;
  int? get admissionDate;
  bool? get canceled;
  bool? get accepted;
  bool? get pending;
  bool? get resent;
  bool? get archived;
  bool? get lost;
  int? get insuranceJustification;
  int? get cancelPatientInterventionReason;
  int? get status;
  String? get codeLabel;
  Map<String, String> get options;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedInvoicingCodeCopyWith<DecryptedInvoicingCode> get copyWith =>
      _$DecryptedInvoicingCodeCopyWithImpl<DecryptedInvoicingCode>(
          this as DecryptedInvoicingCode, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedInvoicingCode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.dateCode, dateCode) ||
                other.dateCode == dateCode) &&
            (identical(other.logicalId, logicalId) ||
                other.logicalId == logicalId) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId) &&
            (identical(other.tarificationId, tarificationId) ||
                other.tarificationId == tarificationId) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.amiIntervention, amiIntervention) ||
                other.amiIntervention == amiIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.conventionAmount, conventionAmount) ||
                other.conventionAmount == conventionAmount) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.contract, contract) ||
                other.contract == contract) &&
            (identical(other.contractDate, contractDate) ||
                other.contractDate == contractDate) &&
            (identical(other.units, units) || other.units == units) &&
            (identical(other.side, side) || other.side == side) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.eidReadingHour, eidReadingHour) ||
                other.eidReadingHour == eidReadingHour) &&
            (identical(other.eidReadingValue, eidReadingValue) ||
                other.eidReadingValue == eidReadingValue) &&
            (identical(other.override3rdPayerCode, override3rdPayerCode) ||
                other.override3rdPayerCode == override3rdPayerCode) &&
            (identical(other.override3rdPayerReason, override3rdPayerReason) ||
                other.override3rdPayerReason == override3rdPayerReason) &&
            (identical(other.transplantationCode, transplantationCode) ||
                other.transplantationCode == transplantationCode) &&
            (identical(other.prescriberNorm, prescriberNorm) ||
                other.prescriberNorm == prescriberNorm) &&
            (identical(other.productLabel, productLabel) ||
                other.productLabel == productLabel) &&
            (identical(other.percentNorm, percentNorm) ||
                other.percentNorm == percentNorm) &&
            (identical(other.prescriberNihii, prescriberNihii) ||
                other.prescriberNihii == prescriberNihii) &&
            (identical(other.relatedCode, relatedCode) ||
                other.relatedCode == relatedCode) &&
            (identical(other.prescriptionDate, prescriptionDate) ||
                other.prescriptionDate == prescriptionDate) &&
            (identical(other.derogationMaxNumber, derogationMaxNumber) ||
                other.derogationMaxNumber == derogationMaxNumber) &&
            (identical(other.prescriberSsin, prescriberSsin) ||
                other.prescriberSsin == prescriberSsin) &&
            (identical(other.prescriberLastName, prescriberLastName) ||
                other.prescriberLastName == prescriberLastName) &&
            (identical(other.prescriberFirstName, prescriberFirstName) ||
                other.prescriberFirstName == prescriberFirstName) &&
            (identical(other.prescriberCdHcParty, prescriberCdHcParty) ||
                other.prescriberCdHcParty == prescriberCdHcParty) &&
            (identical(other.locationNihii, locationNihii) ||
                other.locationNihii == locationNihii) &&
            (identical(other.locationCdHcParty, locationCdHcParty) ||
                other.locationCdHcParty == locationCdHcParty) &&
            (identical(other.locationService, locationService) ||
                other.locationService == locationService) &&
            (identical(other.admissionDate, admissionDate) ||
                other.admissionDate == admissionDate) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.pending, pending) || other.pending == pending) &&
            (identical(other.resent, resent) || other.resent == resent) &&
            (identical(other.archived, archived) ||
                other.archived == archived) &&
            (identical(other.lost, lost) || other.lost == lost) &&
            (identical(other.insuranceJustification, insuranceJustification) ||
                other.insuranceJustification == insuranceJustification) &&
            (identical(other.cancelPatientInterventionReason, cancelPatientInterventionReason) ||
                other.cancelPatientInterventionReason ==
                    cancelPatientInterventionReason) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.codeLabel, codeLabel) ||
                other.codeLabel == codeLabel) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        dateCode,
        logicalId,
        label,
        userId,
        contactId,
        serviceId,
        tarificationId,
        code,
        paymentType,
        paid,
        totalAmount,
        reimbursement,
        patientIntervention,
        amiIntervention,
        doctorSupplement,
        conventionAmount,
        vat,
        error,
        contract,
        contractDate,
        units,
        side,
        timeOfDay,
        eidReadingHour,
        eidReadingValue,
        override3rdPayerCode,
        override3rdPayerReason,
        transplantationCode,
        prescriberNorm,
        productLabel,
        percentNorm,
        prescriberNihii,
        relatedCode,
        prescriptionDate,
        derogationMaxNumber,
        prescriberSsin,
        prescriberLastName,
        prescriberFirstName,
        prescriberCdHcParty,
        locationNihii,
        locationCdHcParty,
        locationService,
        admissionDate,
        canceled,
        accepted,
        pending,
        resent,
        archived,
        lost,
        insuranceJustification,
        cancelPatientInterventionReason,
        status,
        codeLabel,
        const DeepCollectionEquality().hash(options),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedInvoicingCode(id: $id, dateCode: $dateCode, logicalId: $logicalId, label: $label, userId: $userId, contactId: $contactId, serviceId: $serviceId, tarificationId: $tarificationId, code: $code, paymentType: $paymentType, paid: $paid, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, amiIntervention: $amiIntervention, doctorSupplement: $doctorSupplement, conventionAmount: $conventionAmount, vat: $vat, error: $error, contract: $contract, contractDate: $contractDate, units: $units, side: $side, timeOfDay: $timeOfDay, eidReadingHour: $eidReadingHour, eidReadingValue: $eidReadingValue, override3rdPayerCode: $override3rdPayerCode, override3rdPayerReason: $override3rdPayerReason, transplantationCode: $transplantationCode, prescriberNorm: $prescriberNorm, productLabel: $productLabel, percentNorm: $percentNorm, prescriberNihii: $prescriberNihii, relatedCode: $relatedCode, prescriptionDate: $prescriptionDate, derogationMaxNumber: $derogationMaxNumber, prescriberSsin: $prescriberSsin, prescriberLastName: $prescriberLastName, prescriberFirstName: $prescriberFirstName, prescriberCdHcParty: $prescriberCdHcParty, locationNihii: $locationNihii, locationCdHcParty: $locationCdHcParty, locationService: $locationService, admissionDate: $admissionDate, canceled: $canceled, accepted: $accepted, pending: $pending, resent: $resent, archived: $archived, lost: $lost, insuranceJustification: $insuranceJustification, cancelPatientInterventionReason: $cancelPatientInterventionReason, status: $status, codeLabel: $codeLabel, options: $options, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedInvoicingCodeCopyWith<$Res> {
  factory $DecryptedInvoicingCodeCopyWith(DecryptedInvoicingCode value,
          $Res Function(DecryptedInvoicingCode) _then) =
      _$DecryptedInvoicingCodeCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      int? dateCode,
      String? logicalId,
      String? label,
      String? userId,
      String? contactId,
      String? serviceId,
      String? tarificationId,
      String? code,
      PaymentType? paymentType,
      double? paid,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? amiIntervention,
      double? doctorSupplement,
      double? conventionAmount,
      double? vat,
      String? error,
      String? contract,
      int? contractDate,
      int? units,
      int? side,
      int? timeOfDay,
      int? eidReadingHour,
      String? eidReadingValue,
      int? override3rdPayerCode,
      String? override3rdPayerReason,
      int? transplantationCode,
      int? prescriberNorm,
      String? productLabel,
      int? percentNorm,
      String? prescriberNihii,
      String? relatedCode,
      int? prescriptionDate,
      int? derogationMaxNumber,
      String? prescriberSsin,
      String? prescriberLastName,
      String? prescriberFirstName,
      String? prescriberCdHcParty,
      String? locationNihii,
      String? locationCdHcParty,
      int? locationService,
      int? admissionDate,
      bool? canceled,
      bool? accepted,
      bool? pending,
      bool? resent,
      bool? archived,
      bool? lost,
      int? insuranceJustification,
      int? cancelPatientInterventionReason,
      int? status,
      String? codeLabel,
      Map<String, String> options,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedInvoicingCodeCopyWithImpl<$Res>
    implements $DecryptedInvoicingCodeCopyWith<$Res> {
  _$DecryptedInvoicingCodeCopyWithImpl(this._self, this._then);

  final DecryptedInvoicingCode _self;
  final $Res Function(DecryptedInvoicingCode) _then;

  /// Create a copy of DecryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? dateCode = freezed,
    Object? logicalId = freezed,
    Object? label = freezed,
    Object? userId = freezed,
    Object? contactId = freezed,
    Object? serviceId = freezed,
    Object? tarificationId = freezed,
    Object? code = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? amiIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? conventionAmount = freezed,
    Object? vat = freezed,
    Object? error = freezed,
    Object? contract = freezed,
    Object? contractDate = freezed,
    Object? units = freezed,
    Object? side = freezed,
    Object? timeOfDay = freezed,
    Object? eidReadingHour = freezed,
    Object? eidReadingValue = freezed,
    Object? override3rdPayerCode = freezed,
    Object? override3rdPayerReason = freezed,
    Object? transplantationCode = freezed,
    Object? prescriberNorm = freezed,
    Object? productLabel = freezed,
    Object? percentNorm = freezed,
    Object? prescriberNihii = freezed,
    Object? relatedCode = freezed,
    Object? prescriptionDate = freezed,
    Object? derogationMaxNumber = freezed,
    Object? prescriberSsin = freezed,
    Object? prescriberLastName = freezed,
    Object? prescriberFirstName = freezed,
    Object? prescriberCdHcParty = freezed,
    Object? locationNihii = freezed,
    Object? locationCdHcParty = freezed,
    Object? locationService = freezed,
    Object? admissionDate = freezed,
    Object? canceled = freezed,
    Object? accepted = freezed,
    Object? pending = freezed,
    Object? resent = freezed,
    Object? archived = freezed,
    Object? lost = freezed,
    Object? insuranceJustification = freezed,
    Object? cancelPatientInterventionReason = freezed,
    Object? status = freezed,
    Object? codeLabel = freezed,
    Object? options = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      dateCode: freezed == dateCode
          ? _self.dateCode
          : dateCode // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalId: freezed == logicalId
          ? _self.logicalId
          : logicalId // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      tarificationId: freezed == tarificationId
          ? _self.tarificationId
          : tarificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      amiIntervention: freezed == amiIntervention
          ? _self.amiIntervention
          : amiIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      conventionAmount: freezed == conventionAmount
          ? _self.conventionAmount
          : conventionAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      contract: freezed == contract
          ? _self.contract
          : contract // ignore: cast_nullable_to_non_nullable
              as String?,
      contractDate: freezed == contractDate
          ? _self.contractDate
          : contractDate // ignore: cast_nullable_to_non_nullable
              as int?,
      units: freezed == units
          ? _self.units
          : units // ignore: cast_nullable_to_non_nullable
              as int?,
      side: freezed == side
          ? _self.side
          : side // ignore: cast_nullable_to_non_nullable
              as int?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingHour: freezed == eidReadingHour
          ? _self.eidReadingHour
          : eidReadingHour // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingValue: freezed == eidReadingValue
          ? _self.eidReadingValue
          : eidReadingValue // ignore: cast_nullable_to_non_nullable
              as String?,
      override3rdPayerCode: freezed == override3rdPayerCode
          ? _self.override3rdPayerCode
          : override3rdPayerCode // ignore: cast_nullable_to_non_nullable
              as int?,
      override3rdPayerReason: freezed == override3rdPayerReason
          ? _self.override3rdPayerReason
          : override3rdPayerReason // ignore: cast_nullable_to_non_nullable
              as String?,
      transplantationCode: freezed == transplantationCode
          ? _self.transplantationCode
          : transplantationCode // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNorm: freezed == prescriberNorm
          ? _self.prescriberNorm
          : prescriberNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      productLabel: freezed == productLabel
          ? _self.productLabel
          : productLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      percentNorm: freezed == percentNorm
          ? _self.percentNorm
          : percentNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNihii: freezed == prescriberNihii
          ? _self.prescriberNihii
          : prescriberNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      relatedCode: freezed == relatedCode
          ? _self.relatedCode
          : relatedCode // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriptionDate: freezed == prescriptionDate
          ? _self.prescriptionDate
          : prescriptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      derogationMaxNumber: freezed == derogationMaxNumber
          ? _self.derogationMaxNumber
          : derogationMaxNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberSsin: freezed == prescriberSsin
          ? _self.prescriberSsin
          : prescriberSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberLastName: freezed == prescriberLastName
          ? _self.prescriberLastName
          : prescriberLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberFirstName: freezed == prescriberFirstName
          ? _self.prescriberFirstName
          : prescriberFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberCdHcParty: freezed == prescriberCdHcParty
          ? _self.prescriberCdHcParty
          : prescriberCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationCdHcParty: freezed == locationCdHcParty
          ? _self.locationCdHcParty
          : locationCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      pending: freezed == pending
          ? _self.pending
          : pending // ignore: cast_nullable_to_non_nullable
              as bool?,
      resent: freezed == resent
          ? _self.resent
          : resent // ignore: cast_nullable_to_non_nullable
              as bool?,
      archived: freezed == archived
          ? _self.archived
          : archived // ignore: cast_nullable_to_non_nullable
              as bool?,
      lost: freezed == lost
          ? _self.lost
          : lost // ignore: cast_nullable_to_non_nullable
              as bool?,
      insuranceJustification: freezed == insuranceJustification
          ? _self.insuranceJustification
          : insuranceJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelPatientInterventionReason: freezed ==
              cancelPatientInterventionReason
          ? _self.cancelPatientInterventionReason
          : cancelPatientInterventionReason // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      codeLabel: freezed == codeLabel
          ? _self.codeLabel
          : codeLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedInvoicingCode implements DecryptedInvoicingCode {
  const _DecryptedInvoicingCode(
      {required this.id,
      this.dateCode = null,
      this.logicalId = null,
      this.label = null,
      this.userId = null,
      this.contactId = null,
      this.serviceId = null,
      this.tarificationId = null,
      this.code = null,
      this.paymentType = null,
      this.paid = null,
      this.totalAmount = null,
      this.reimbursement = null,
      this.patientIntervention = null,
      this.amiIntervention = null,
      this.doctorSupplement = null,
      this.conventionAmount = null,
      this.vat = null,
      this.error = null,
      this.contract = null,
      this.contractDate = null,
      this.units = null,
      this.side = null,
      this.timeOfDay = null,
      this.eidReadingHour = null,
      this.eidReadingValue = null,
      this.override3rdPayerCode = null,
      this.override3rdPayerReason = null,
      this.transplantationCode = null,
      this.prescriberNorm = null,
      this.productLabel = null,
      this.percentNorm = null,
      this.prescriberNihii = null,
      this.relatedCode = null,
      this.prescriptionDate = null,
      this.derogationMaxNumber = null,
      this.prescriberSsin = null,
      this.prescriberLastName = null,
      this.prescriberFirstName = null,
      this.prescriberCdHcParty = null,
      this.locationNihii = null,
      this.locationCdHcParty = null,
      this.locationService = null,
      this.admissionDate = null,
      this.canceled = null,
      this.accepted = null,
      this.pending = null,
      this.resent = null,
      this.archived = null,
      this.lost = null,
      this.insuranceJustification = null,
      this.cancelPatientInterventionReason = null,
      this.status = null,
      this.codeLabel = null,
      final Map<String, String> options = const {},
      this.encryptedSelf = null})
      : _options = options;

  @override
  final String? id;
  @override
  @JsonKey()
  final int? dateCode;
  @override
  @JsonKey()
  final String? logicalId;
  @override
  @JsonKey()
  final String? label;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? serviceId;
  @override
  @JsonKey()
  final String? tarificationId;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final PaymentType? paymentType;
  @override
  @JsonKey()
  final double? paid;
  @override
  @JsonKey()
  final double? totalAmount;
  @override
  @JsonKey()
  final double? reimbursement;
  @override
  @JsonKey()
  final double? patientIntervention;
  @override
  @JsonKey()
  final double? amiIntervention;
  @override
  @JsonKey()
  final double? doctorSupplement;
  @override
  @JsonKey()
  final double? conventionAmount;
  @override
  @JsonKey()
  final double? vat;
  @override
  @JsonKey()
  final String? error;
  @override
  @JsonKey()
  final String? contract;
  @override
  @JsonKey()
  final int? contractDate;
  @override
  @JsonKey()
  final int? units;
  @override
  @JsonKey()
  final int? side;
  @override
  @JsonKey()
  final int? timeOfDay;
  @override
  @JsonKey()
  final int? eidReadingHour;
  @override
  @JsonKey()
  final String? eidReadingValue;
  @override
  @JsonKey()
  final int? override3rdPayerCode;
  @override
  @JsonKey()
  final String? override3rdPayerReason;
  @override
  @JsonKey()
  final int? transplantationCode;
  @override
  @JsonKey()
  final int? prescriberNorm;
  @override
  @JsonKey()
  final String? productLabel;
  @override
  @JsonKey()
  final int? percentNorm;
  @override
  @JsonKey()
  final String? prescriberNihii;
  @override
  @JsonKey()
  final String? relatedCode;
  @override
  @JsonKey()
  final int? prescriptionDate;
  @override
  @JsonKey()
  final int? derogationMaxNumber;
  @override
  @JsonKey()
  final String? prescriberSsin;
  @override
  @JsonKey()
  final String? prescriberLastName;
  @override
  @JsonKey()
  final String? prescriberFirstName;
  @override
  @JsonKey()
  final String? prescriberCdHcParty;
  @override
  @JsonKey()
  final String? locationNihii;
  @override
  @JsonKey()
  final String? locationCdHcParty;
  @override
  @JsonKey()
  final int? locationService;
  @override
  @JsonKey()
  final int? admissionDate;
  @override
  @JsonKey()
  final bool? canceled;
  @override
  @JsonKey()
  final bool? accepted;
  @override
  @JsonKey()
  final bool? pending;
  @override
  @JsonKey()
  final bool? resent;
  @override
  @JsonKey()
  final bool? archived;
  @override
  @JsonKey()
  final bool? lost;
  @override
  @JsonKey()
  final int? insuranceJustification;
  @override
  @JsonKey()
  final int? cancelPatientInterventionReason;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? codeLabel;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedInvoicingCodeCopyWith<_DecryptedInvoicingCode> get copyWith =>
      __$DecryptedInvoicingCodeCopyWithImpl<_DecryptedInvoicingCode>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedInvoicingCode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.dateCode, dateCode) ||
                other.dateCode == dateCode) &&
            (identical(other.logicalId, logicalId) ||
                other.logicalId == logicalId) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId) &&
            (identical(other.tarificationId, tarificationId) ||
                other.tarificationId == tarificationId) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.amiIntervention, amiIntervention) ||
                other.amiIntervention == amiIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.conventionAmount, conventionAmount) ||
                other.conventionAmount == conventionAmount) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.contract, contract) ||
                other.contract == contract) &&
            (identical(other.contractDate, contractDate) ||
                other.contractDate == contractDate) &&
            (identical(other.units, units) || other.units == units) &&
            (identical(other.side, side) || other.side == side) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.eidReadingHour, eidReadingHour) ||
                other.eidReadingHour == eidReadingHour) &&
            (identical(other.eidReadingValue, eidReadingValue) ||
                other.eidReadingValue == eidReadingValue) &&
            (identical(other.override3rdPayerCode, override3rdPayerCode) ||
                other.override3rdPayerCode == override3rdPayerCode) &&
            (identical(other.override3rdPayerReason, override3rdPayerReason) ||
                other.override3rdPayerReason == override3rdPayerReason) &&
            (identical(other.transplantationCode, transplantationCode) ||
                other.transplantationCode == transplantationCode) &&
            (identical(other.prescriberNorm, prescriberNorm) ||
                other.prescriberNorm == prescriberNorm) &&
            (identical(other.productLabel, productLabel) ||
                other.productLabel == productLabel) &&
            (identical(other.percentNorm, percentNorm) ||
                other.percentNorm == percentNorm) &&
            (identical(other.prescriberNihii, prescriberNihii) ||
                other.prescriberNihii == prescriberNihii) &&
            (identical(other.relatedCode, relatedCode) ||
                other.relatedCode == relatedCode) &&
            (identical(other.prescriptionDate, prescriptionDate) ||
                other.prescriptionDate == prescriptionDate) &&
            (identical(other.derogationMaxNumber, derogationMaxNumber) ||
                other.derogationMaxNumber == derogationMaxNumber) &&
            (identical(other.prescriberSsin, prescriberSsin) ||
                other.prescriberSsin == prescriberSsin) &&
            (identical(other.prescriberLastName, prescriberLastName) ||
                other.prescriberLastName == prescriberLastName) &&
            (identical(other.prescriberFirstName, prescriberFirstName) ||
                other.prescriberFirstName == prescriberFirstName) &&
            (identical(other.prescriberCdHcParty, prescriberCdHcParty) ||
                other.prescriberCdHcParty == prescriberCdHcParty) &&
            (identical(other.locationNihii, locationNihii) ||
                other.locationNihii == locationNihii) &&
            (identical(other.locationCdHcParty, locationCdHcParty) ||
                other.locationCdHcParty == locationCdHcParty) &&
            (identical(other.locationService, locationService) ||
                other.locationService == locationService) &&
            (identical(other.admissionDate, admissionDate) ||
                other.admissionDate == admissionDate) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.pending, pending) || other.pending == pending) &&
            (identical(other.resent, resent) || other.resent == resent) &&
            (identical(other.archived, archived) ||
                other.archived == archived) &&
            (identical(other.lost, lost) || other.lost == lost) &&
            (identical(other.insuranceJustification, insuranceJustification) ||
                other.insuranceJustification == insuranceJustification) &&
            (identical(other.cancelPatientInterventionReason, cancelPatientInterventionReason) ||
                other.cancelPatientInterventionReason ==
                    cancelPatientInterventionReason) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.codeLabel, codeLabel) ||
                other.codeLabel == codeLabel) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        dateCode,
        logicalId,
        label,
        userId,
        contactId,
        serviceId,
        tarificationId,
        code,
        paymentType,
        paid,
        totalAmount,
        reimbursement,
        patientIntervention,
        amiIntervention,
        doctorSupplement,
        conventionAmount,
        vat,
        error,
        contract,
        contractDate,
        units,
        side,
        timeOfDay,
        eidReadingHour,
        eidReadingValue,
        override3rdPayerCode,
        override3rdPayerReason,
        transplantationCode,
        prescriberNorm,
        productLabel,
        percentNorm,
        prescriberNihii,
        relatedCode,
        prescriptionDate,
        derogationMaxNumber,
        prescriberSsin,
        prescriberLastName,
        prescriberFirstName,
        prescriberCdHcParty,
        locationNihii,
        locationCdHcParty,
        locationService,
        admissionDate,
        canceled,
        accepted,
        pending,
        resent,
        archived,
        lost,
        insuranceJustification,
        cancelPatientInterventionReason,
        status,
        codeLabel,
        const DeepCollectionEquality().hash(_options),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedInvoicingCode(id: $id, dateCode: $dateCode, logicalId: $logicalId, label: $label, userId: $userId, contactId: $contactId, serviceId: $serviceId, tarificationId: $tarificationId, code: $code, paymentType: $paymentType, paid: $paid, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, amiIntervention: $amiIntervention, doctorSupplement: $doctorSupplement, conventionAmount: $conventionAmount, vat: $vat, error: $error, contract: $contract, contractDate: $contractDate, units: $units, side: $side, timeOfDay: $timeOfDay, eidReadingHour: $eidReadingHour, eidReadingValue: $eidReadingValue, override3rdPayerCode: $override3rdPayerCode, override3rdPayerReason: $override3rdPayerReason, transplantationCode: $transplantationCode, prescriberNorm: $prescriberNorm, productLabel: $productLabel, percentNorm: $percentNorm, prescriberNihii: $prescriberNihii, relatedCode: $relatedCode, prescriptionDate: $prescriptionDate, derogationMaxNumber: $derogationMaxNumber, prescriberSsin: $prescriberSsin, prescriberLastName: $prescriberLastName, prescriberFirstName: $prescriberFirstName, prescriberCdHcParty: $prescriberCdHcParty, locationNihii: $locationNihii, locationCdHcParty: $locationCdHcParty, locationService: $locationService, admissionDate: $admissionDate, canceled: $canceled, accepted: $accepted, pending: $pending, resent: $resent, archived: $archived, lost: $lost, insuranceJustification: $insuranceJustification, cancelPatientInterventionReason: $cancelPatientInterventionReason, status: $status, codeLabel: $codeLabel, options: $options, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedInvoicingCodeCopyWith<$Res>
    implements $DecryptedInvoicingCodeCopyWith<$Res> {
  factory _$DecryptedInvoicingCodeCopyWith(_DecryptedInvoicingCode value,
          $Res Function(_DecryptedInvoicingCode) _then) =
      __$DecryptedInvoicingCodeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      int? dateCode,
      String? logicalId,
      String? label,
      String? userId,
      String? contactId,
      String? serviceId,
      String? tarificationId,
      String? code,
      PaymentType? paymentType,
      double? paid,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? amiIntervention,
      double? doctorSupplement,
      double? conventionAmount,
      double? vat,
      String? error,
      String? contract,
      int? contractDate,
      int? units,
      int? side,
      int? timeOfDay,
      int? eidReadingHour,
      String? eidReadingValue,
      int? override3rdPayerCode,
      String? override3rdPayerReason,
      int? transplantationCode,
      int? prescriberNorm,
      String? productLabel,
      int? percentNorm,
      String? prescriberNihii,
      String? relatedCode,
      int? prescriptionDate,
      int? derogationMaxNumber,
      String? prescriberSsin,
      String? prescriberLastName,
      String? prescriberFirstName,
      String? prescriberCdHcParty,
      String? locationNihii,
      String? locationCdHcParty,
      int? locationService,
      int? admissionDate,
      bool? canceled,
      bool? accepted,
      bool? pending,
      bool? resent,
      bool? archived,
      bool? lost,
      int? insuranceJustification,
      int? cancelPatientInterventionReason,
      int? status,
      String? codeLabel,
      Map<String, String> options,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedInvoicingCodeCopyWithImpl<$Res>
    implements _$DecryptedInvoicingCodeCopyWith<$Res> {
  __$DecryptedInvoicingCodeCopyWithImpl(this._self, this._then);

  final _DecryptedInvoicingCode _self;
  final $Res Function(_DecryptedInvoicingCode) _then;

  /// Create a copy of DecryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? dateCode = freezed,
    Object? logicalId = freezed,
    Object? label = freezed,
    Object? userId = freezed,
    Object? contactId = freezed,
    Object? serviceId = freezed,
    Object? tarificationId = freezed,
    Object? code = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? amiIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? conventionAmount = freezed,
    Object? vat = freezed,
    Object? error = freezed,
    Object? contract = freezed,
    Object? contractDate = freezed,
    Object? units = freezed,
    Object? side = freezed,
    Object? timeOfDay = freezed,
    Object? eidReadingHour = freezed,
    Object? eidReadingValue = freezed,
    Object? override3rdPayerCode = freezed,
    Object? override3rdPayerReason = freezed,
    Object? transplantationCode = freezed,
    Object? prescriberNorm = freezed,
    Object? productLabel = freezed,
    Object? percentNorm = freezed,
    Object? prescriberNihii = freezed,
    Object? relatedCode = freezed,
    Object? prescriptionDate = freezed,
    Object? derogationMaxNumber = freezed,
    Object? prescriberSsin = freezed,
    Object? prescriberLastName = freezed,
    Object? prescriberFirstName = freezed,
    Object? prescriberCdHcParty = freezed,
    Object? locationNihii = freezed,
    Object? locationCdHcParty = freezed,
    Object? locationService = freezed,
    Object? admissionDate = freezed,
    Object? canceled = freezed,
    Object? accepted = freezed,
    Object? pending = freezed,
    Object? resent = freezed,
    Object? archived = freezed,
    Object? lost = freezed,
    Object? insuranceJustification = freezed,
    Object? cancelPatientInterventionReason = freezed,
    Object? status = freezed,
    Object? codeLabel = freezed,
    Object? options = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedInvoicingCode(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      dateCode: freezed == dateCode
          ? _self.dateCode
          : dateCode // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalId: freezed == logicalId
          ? _self.logicalId
          : logicalId // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      tarificationId: freezed == tarificationId
          ? _self.tarificationId
          : tarificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      amiIntervention: freezed == amiIntervention
          ? _self.amiIntervention
          : amiIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      conventionAmount: freezed == conventionAmount
          ? _self.conventionAmount
          : conventionAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      contract: freezed == contract
          ? _self.contract
          : contract // ignore: cast_nullable_to_non_nullable
              as String?,
      contractDate: freezed == contractDate
          ? _self.contractDate
          : contractDate // ignore: cast_nullable_to_non_nullable
              as int?,
      units: freezed == units
          ? _self.units
          : units // ignore: cast_nullable_to_non_nullable
              as int?,
      side: freezed == side
          ? _self.side
          : side // ignore: cast_nullable_to_non_nullable
              as int?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingHour: freezed == eidReadingHour
          ? _self.eidReadingHour
          : eidReadingHour // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingValue: freezed == eidReadingValue
          ? _self.eidReadingValue
          : eidReadingValue // ignore: cast_nullable_to_non_nullable
              as String?,
      override3rdPayerCode: freezed == override3rdPayerCode
          ? _self.override3rdPayerCode
          : override3rdPayerCode // ignore: cast_nullable_to_non_nullable
              as int?,
      override3rdPayerReason: freezed == override3rdPayerReason
          ? _self.override3rdPayerReason
          : override3rdPayerReason // ignore: cast_nullable_to_non_nullable
              as String?,
      transplantationCode: freezed == transplantationCode
          ? _self.transplantationCode
          : transplantationCode // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNorm: freezed == prescriberNorm
          ? _self.prescriberNorm
          : prescriberNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      productLabel: freezed == productLabel
          ? _self.productLabel
          : productLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      percentNorm: freezed == percentNorm
          ? _self.percentNorm
          : percentNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNihii: freezed == prescriberNihii
          ? _self.prescriberNihii
          : prescriberNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      relatedCode: freezed == relatedCode
          ? _self.relatedCode
          : relatedCode // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriptionDate: freezed == prescriptionDate
          ? _self.prescriptionDate
          : prescriptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      derogationMaxNumber: freezed == derogationMaxNumber
          ? _self.derogationMaxNumber
          : derogationMaxNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberSsin: freezed == prescriberSsin
          ? _self.prescriberSsin
          : prescriberSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberLastName: freezed == prescriberLastName
          ? _self.prescriberLastName
          : prescriberLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberFirstName: freezed == prescriberFirstName
          ? _self.prescriberFirstName
          : prescriberFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberCdHcParty: freezed == prescriberCdHcParty
          ? _self.prescriberCdHcParty
          : prescriberCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationCdHcParty: freezed == locationCdHcParty
          ? _self.locationCdHcParty
          : locationCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      pending: freezed == pending
          ? _self.pending
          : pending // ignore: cast_nullable_to_non_nullable
              as bool?,
      resent: freezed == resent
          ? _self.resent
          : resent // ignore: cast_nullable_to_non_nullable
              as bool?,
      archived: freezed == archived
          ? _self.archived
          : archived // ignore: cast_nullable_to_non_nullable
              as bool?,
      lost: freezed == lost
          ? _self.lost
          : lost // ignore: cast_nullable_to_non_nullable
              as bool?,
      insuranceJustification: freezed == insuranceJustification
          ? _self.insuranceJustification
          : insuranceJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelPatientInterventionReason: freezed ==
              cancelPatientInterventionReason
          ? _self.cancelPatientInterventionReason
          : cancelPatientInterventionReason // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      codeLabel: freezed == codeLabel
          ? _self.codeLabel
          : codeLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedInvoicingCode {
  String? get id;
  int? get dateCode;
  String? get logicalId;
  String? get label;
  String? get userId;
  String? get contactId;
  String? get serviceId;
  String? get tarificationId;
  String? get code;
  PaymentType? get paymentType;
  double? get paid;
  double? get totalAmount;
  double? get reimbursement;
  double? get patientIntervention;
  double? get amiIntervention;
  double? get doctorSupplement;
  double? get conventionAmount;
  double? get vat;
  String? get error;
  String? get contract;
  int? get contractDate;
  int? get units;
  int? get side;
  int? get timeOfDay;
  int? get eidReadingHour;
  String? get eidReadingValue;
  int? get override3rdPayerCode;
  String? get override3rdPayerReason;
  int? get transplantationCode;
  int? get prescriberNorm;
  String? get productLabel;
  int? get percentNorm;
  String? get prescriberNihii;
  String? get relatedCode;
  int? get prescriptionDate;
  int? get derogationMaxNumber;
  String? get prescriberSsin;
  String? get prescriberLastName;
  String? get prescriberFirstName;
  String? get prescriberCdHcParty;
  String? get locationNihii;
  String? get locationCdHcParty;
  int? get locationService;
  int? get admissionDate;
  bool? get canceled;
  bool? get accepted;
  bool? get pending;
  bool? get resent;
  bool? get archived;
  bool? get lost;
  int? get insuranceJustification;
  int? get cancelPatientInterventionReason;
  int? get status;
  String? get codeLabel;
  Map<String, String> get options;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedInvoicingCodeCopyWith<EncryptedInvoicingCode> get copyWith =>
      _$EncryptedInvoicingCodeCopyWithImpl<EncryptedInvoicingCode>(
          this as EncryptedInvoicingCode, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedInvoicingCode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.dateCode, dateCode) ||
                other.dateCode == dateCode) &&
            (identical(other.logicalId, logicalId) ||
                other.logicalId == logicalId) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId) &&
            (identical(other.tarificationId, tarificationId) ||
                other.tarificationId == tarificationId) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.amiIntervention, amiIntervention) ||
                other.amiIntervention == amiIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.conventionAmount, conventionAmount) ||
                other.conventionAmount == conventionAmount) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.contract, contract) ||
                other.contract == contract) &&
            (identical(other.contractDate, contractDate) ||
                other.contractDate == contractDate) &&
            (identical(other.units, units) || other.units == units) &&
            (identical(other.side, side) || other.side == side) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.eidReadingHour, eidReadingHour) ||
                other.eidReadingHour == eidReadingHour) &&
            (identical(other.eidReadingValue, eidReadingValue) ||
                other.eidReadingValue == eidReadingValue) &&
            (identical(other.override3rdPayerCode, override3rdPayerCode) ||
                other.override3rdPayerCode == override3rdPayerCode) &&
            (identical(other.override3rdPayerReason, override3rdPayerReason) ||
                other.override3rdPayerReason == override3rdPayerReason) &&
            (identical(other.transplantationCode, transplantationCode) ||
                other.transplantationCode == transplantationCode) &&
            (identical(other.prescriberNorm, prescriberNorm) ||
                other.prescriberNorm == prescriberNorm) &&
            (identical(other.productLabel, productLabel) ||
                other.productLabel == productLabel) &&
            (identical(other.percentNorm, percentNorm) ||
                other.percentNorm == percentNorm) &&
            (identical(other.prescriberNihii, prescriberNihii) ||
                other.prescriberNihii == prescriberNihii) &&
            (identical(other.relatedCode, relatedCode) ||
                other.relatedCode == relatedCode) &&
            (identical(other.prescriptionDate, prescriptionDate) ||
                other.prescriptionDate == prescriptionDate) &&
            (identical(other.derogationMaxNumber, derogationMaxNumber) ||
                other.derogationMaxNumber == derogationMaxNumber) &&
            (identical(other.prescriberSsin, prescriberSsin) ||
                other.prescriberSsin == prescriberSsin) &&
            (identical(other.prescriberLastName, prescriberLastName) ||
                other.prescriberLastName == prescriberLastName) &&
            (identical(other.prescriberFirstName, prescriberFirstName) ||
                other.prescriberFirstName == prescriberFirstName) &&
            (identical(other.prescriberCdHcParty, prescriberCdHcParty) ||
                other.prescriberCdHcParty == prescriberCdHcParty) &&
            (identical(other.locationNihii, locationNihii) ||
                other.locationNihii == locationNihii) &&
            (identical(other.locationCdHcParty, locationCdHcParty) ||
                other.locationCdHcParty == locationCdHcParty) &&
            (identical(other.locationService, locationService) ||
                other.locationService == locationService) &&
            (identical(other.admissionDate, admissionDate) ||
                other.admissionDate == admissionDate) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.pending, pending) || other.pending == pending) &&
            (identical(other.resent, resent) || other.resent == resent) &&
            (identical(other.archived, archived) ||
                other.archived == archived) &&
            (identical(other.lost, lost) || other.lost == lost) &&
            (identical(other.insuranceJustification, insuranceJustification) ||
                other.insuranceJustification == insuranceJustification) &&
            (identical(other.cancelPatientInterventionReason, cancelPatientInterventionReason) ||
                other.cancelPatientInterventionReason ==
                    cancelPatientInterventionReason) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.codeLabel, codeLabel) ||
                other.codeLabel == codeLabel) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        dateCode,
        logicalId,
        label,
        userId,
        contactId,
        serviceId,
        tarificationId,
        code,
        paymentType,
        paid,
        totalAmount,
        reimbursement,
        patientIntervention,
        amiIntervention,
        doctorSupplement,
        conventionAmount,
        vat,
        error,
        contract,
        contractDate,
        units,
        side,
        timeOfDay,
        eidReadingHour,
        eidReadingValue,
        override3rdPayerCode,
        override3rdPayerReason,
        transplantationCode,
        prescriberNorm,
        productLabel,
        percentNorm,
        prescriberNihii,
        relatedCode,
        prescriptionDate,
        derogationMaxNumber,
        prescriberSsin,
        prescriberLastName,
        prescriberFirstName,
        prescriberCdHcParty,
        locationNihii,
        locationCdHcParty,
        locationService,
        admissionDate,
        canceled,
        accepted,
        pending,
        resent,
        archived,
        lost,
        insuranceJustification,
        cancelPatientInterventionReason,
        status,
        codeLabel,
        const DeepCollectionEquality().hash(options),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedInvoicingCode(id: $id, dateCode: $dateCode, logicalId: $logicalId, label: $label, userId: $userId, contactId: $contactId, serviceId: $serviceId, tarificationId: $tarificationId, code: $code, paymentType: $paymentType, paid: $paid, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, amiIntervention: $amiIntervention, doctorSupplement: $doctorSupplement, conventionAmount: $conventionAmount, vat: $vat, error: $error, contract: $contract, contractDate: $contractDate, units: $units, side: $side, timeOfDay: $timeOfDay, eidReadingHour: $eidReadingHour, eidReadingValue: $eidReadingValue, override3rdPayerCode: $override3rdPayerCode, override3rdPayerReason: $override3rdPayerReason, transplantationCode: $transplantationCode, prescriberNorm: $prescriberNorm, productLabel: $productLabel, percentNorm: $percentNorm, prescriberNihii: $prescriberNihii, relatedCode: $relatedCode, prescriptionDate: $prescriptionDate, derogationMaxNumber: $derogationMaxNumber, prescriberSsin: $prescriberSsin, prescriberLastName: $prescriberLastName, prescriberFirstName: $prescriberFirstName, prescriberCdHcParty: $prescriberCdHcParty, locationNihii: $locationNihii, locationCdHcParty: $locationCdHcParty, locationService: $locationService, admissionDate: $admissionDate, canceled: $canceled, accepted: $accepted, pending: $pending, resent: $resent, archived: $archived, lost: $lost, insuranceJustification: $insuranceJustification, cancelPatientInterventionReason: $cancelPatientInterventionReason, status: $status, codeLabel: $codeLabel, options: $options, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedInvoicingCodeCopyWith<$Res> {
  factory $EncryptedInvoicingCodeCopyWith(EncryptedInvoicingCode value,
          $Res Function(EncryptedInvoicingCode) _then) =
      _$EncryptedInvoicingCodeCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      int? dateCode,
      String? logicalId,
      String? label,
      String? userId,
      String? contactId,
      String? serviceId,
      String? tarificationId,
      String? code,
      PaymentType? paymentType,
      double? paid,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? amiIntervention,
      double? doctorSupplement,
      double? conventionAmount,
      double? vat,
      String? error,
      String? contract,
      int? contractDate,
      int? units,
      int? side,
      int? timeOfDay,
      int? eidReadingHour,
      String? eidReadingValue,
      int? override3rdPayerCode,
      String? override3rdPayerReason,
      int? transplantationCode,
      int? prescriberNorm,
      String? productLabel,
      int? percentNorm,
      String? prescriberNihii,
      String? relatedCode,
      int? prescriptionDate,
      int? derogationMaxNumber,
      String? prescriberSsin,
      String? prescriberLastName,
      String? prescriberFirstName,
      String? prescriberCdHcParty,
      String? locationNihii,
      String? locationCdHcParty,
      int? locationService,
      int? admissionDate,
      bool? canceled,
      bool? accepted,
      bool? pending,
      bool? resent,
      bool? archived,
      bool? lost,
      int? insuranceJustification,
      int? cancelPatientInterventionReason,
      int? status,
      String? codeLabel,
      Map<String, String> options,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedInvoicingCodeCopyWithImpl<$Res>
    implements $EncryptedInvoicingCodeCopyWith<$Res> {
  _$EncryptedInvoicingCodeCopyWithImpl(this._self, this._then);

  final EncryptedInvoicingCode _self;
  final $Res Function(EncryptedInvoicingCode) _then;

  /// Create a copy of EncryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? dateCode = freezed,
    Object? logicalId = freezed,
    Object? label = freezed,
    Object? userId = freezed,
    Object? contactId = freezed,
    Object? serviceId = freezed,
    Object? tarificationId = freezed,
    Object? code = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? amiIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? conventionAmount = freezed,
    Object? vat = freezed,
    Object? error = freezed,
    Object? contract = freezed,
    Object? contractDate = freezed,
    Object? units = freezed,
    Object? side = freezed,
    Object? timeOfDay = freezed,
    Object? eidReadingHour = freezed,
    Object? eidReadingValue = freezed,
    Object? override3rdPayerCode = freezed,
    Object? override3rdPayerReason = freezed,
    Object? transplantationCode = freezed,
    Object? prescriberNorm = freezed,
    Object? productLabel = freezed,
    Object? percentNorm = freezed,
    Object? prescriberNihii = freezed,
    Object? relatedCode = freezed,
    Object? prescriptionDate = freezed,
    Object? derogationMaxNumber = freezed,
    Object? prescriberSsin = freezed,
    Object? prescriberLastName = freezed,
    Object? prescriberFirstName = freezed,
    Object? prescriberCdHcParty = freezed,
    Object? locationNihii = freezed,
    Object? locationCdHcParty = freezed,
    Object? locationService = freezed,
    Object? admissionDate = freezed,
    Object? canceled = freezed,
    Object? accepted = freezed,
    Object? pending = freezed,
    Object? resent = freezed,
    Object? archived = freezed,
    Object? lost = freezed,
    Object? insuranceJustification = freezed,
    Object? cancelPatientInterventionReason = freezed,
    Object? status = freezed,
    Object? codeLabel = freezed,
    Object? options = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      dateCode: freezed == dateCode
          ? _self.dateCode
          : dateCode // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalId: freezed == logicalId
          ? _self.logicalId
          : logicalId // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      tarificationId: freezed == tarificationId
          ? _self.tarificationId
          : tarificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      amiIntervention: freezed == amiIntervention
          ? _self.amiIntervention
          : amiIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      conventionAmount: freezed == conventionAmount
          ? _self.conventionAmount
          : conventionAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      contract: freezed == contract
          ? _self.contract
          : contract // ignore: cast_nullable_to_non_nullable
              as String?,
      contractDate: freezed == contractDate
          ? _self.contractDate
          : contractDate // ignore: cast_nullable_to_non_nullable
              as int?,
      units: freezed == units
          ? _self.units
          : units // ignore: cast_nullable_to_non_nullable
              as int?,
      side: freezed == side
          ? _self.side
          : side // ignore: cast_nullable_to_non_nullable
              as int?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingHour: freezed == eidReadingHour
          ? _self.eidReadingHour
          : eidReadingHour // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingValue: freezed == eidReadingValue
          ? _self.eidReadingValue
          : eidReadingValue // ignore: cast_nullable_to_non_nullable
              as String?,
      override3rdPayerCode: freezed == override3rdPayerCode
          ? _self.override3rdPayerCode
          : override3rdPayerCode // ignore: cast_nullable_to_non_nullable
              as int?,
      override3rdPayerReason: freezed == override3rdPayerReason
          ? _self.override3rdPayerReason
          : override3rdPayerReason // ignore: cast_nullable_to_non_nullable
              as String?,
      transplantationCode: freezed == transplantationCode
          ? _self.transplantationCode
          : transplantationCode // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNorm: freezed == prescriberNorm
          ? _self.prescriberNorm
          : prescriberNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      productLabel: freezed == productLabel
          ? _self.productLabel
          : productLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      percentNorm: freezed == percentNorm
          ? _self.percentNorm
          : percentNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNihii: freezed == prescriberNihii
          ? _self.prescriberNihii
          : prescriberNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      relatedCode: freezed == relatedCode
          ? _self.relatedCode
          : relatedCode // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriptionDate: freezed == prescriptionDate
          ? _self.prescriptionDate
          : prescriptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      derogationMaxNumber: freezed == derogationMaxNumber
          ? _self.derogationMaxNumber
          : derogationMaxNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberSsin: freezed == prescriberSsin
          ? _self.prescriberSsin
          : prescriberSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberLastName: freezed == prescriberLastName
          ? _self.prescriberLastName
          : prescriberLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberFirstName: freezed == prescriberFirstName
          ? _self.prescriberFirstName
          : prescriberFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberCdHcParty: freezed == prescriberCdHcParty
          ? _self.prescriberCdHcParty
          : prescriberCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationCdHcParty: freezed == locationCdHcParty
          ? _self.locationCdHcParty
          : locationCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      pending: freezed == pending
          ? _self.pending
          : pending // ignore: cast_nullable_to_non_nullable
              as bool?,
      resent: freezed == resent
          ? _self.resent
          : resent // ignore: cast_nullable_to_non_nullable
              as bool?,
      archived: freezed == archived
          ? _self.archived
          : archived // ignore: cast_nullable_to_non_nullable
              as bool?,
      lost: freezed == lost
          ? _self.lost
          : lost // ignore: cast_nullable_to_non_nullable
              as bool?,
      insuranceJustification: freezed == insuranceJustification
          ? _self.insuranceJustification
          : insuranceJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelPatientInterventionReason: freezed ==
              cancelPatientInterventionReason
          ? _self.cancelPatientInterventionReason
          : cancelPatientInterventionReason // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      codeLabel: freezed == codeLabel
          ? _self.codeLabel
          : codeLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedInvoicingCode implements EncryptedInvoicingCode {
  const _EncryptedInvoicingCode(
      {required this.id,
      this.dateCode = null,
      this.logicalId = null,
      this.label = null,
      this.userId = null,
      this.contactId = null,
      this.serviceId = null,
      this.tarificationId = null,
      this.code = null,
      this.paymentType = null,
      this.paid = null,
      this.totalAmount = null,
      this.reimbursement = null,
      this.patientIntervention = null,
      this.amiIntervention = null,
      this.doctorSupplement = null,
      this.conventionAmount = null,
      this.vat = null,
      this.error = null,
      this.contract = null,
      this.contractDate = null,
      this.units = null,
      this.side = null,
      this.timeOfDay = null,
      this.eidReadingHour = null,
      this.eidReadingValue = null,
      this.override3rdPayerCode = null,
      this.override3rdPayerReason = null,
      this.transplantationCode = null,
      this.prescriberNorm = null,
      this.productLabel = null,
      this.percentNorm = null,
      this.prescriberNihii = null,
      this.relatedCode = null,
      this.prescriptionDate = null,
      this.derogationMaxNumber = null,
      this.prescriberSsin = null,
      this.prescriberLastName = null,
      this.prescriberFirstName = null,
      this.prescriberCdHcParty = null,
      this.locationNihii = null,
      this.locationCdHcParty = null,
      this.locationService = null,
      this.admissionDate = null,
      this.canceled = null,
      this.accepted = null,
      this.pending = null,
      this.resent = null,
      this.archived = null,
      this.lost = null,
      this.insuranceJustification = null,
      this.cancelPatientInterventionReason = null,
      this.status = null,
      this.codeLabel = null,
      final Map<String, String> options = const {},
      this.encryptedSelf = null})
      : _options = options;

  @override
  final String? id;
  @override
  @JsonKey()
  final int? dateCode;
  @override
  @JsonKey()
  final String? logicalId;
  @override
  @JsonKey()
  final String? label;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? serviceId;
  @override
  @JsonKey()
  final String? tarificationId;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final PaymentType? paymentType;
  @override
  @JsonKey()
  final double? paid;
  @override
  @JsonKey()
  final double? totalAmount;
  @override
  @JsonKey()
  final double? reimbursement;
  @override
  @JsonKey()
  final double? patientIntervention;
  @override
  @JsonKey()
  final double? amiIntervention;
  @override
  @JsonKey()
  final double? doctorSupplement;
  @override
  @JsonKey()
  final double? conventionAmount;
  @override
  @JsonKey()
  final double? vat;
  @override
  @JsonKey()
  final String? error;
  @override
  @JsonKey()
  final String? contract;
  @override
  @JsonKey()
  final int? contractDate;
  @override
  @JsonKey()
  final int? units;
  @override
  @JsonKey()
  final int? side;
  @override
  @JsonKey()
  final int? timeOfDay;
  @override
  @JsonKey()
  final int? eidReadingHour;
  @override
  @JsonKey()
  final String? eidReadingValue;
  @override
  @JsonKey()
  final int? override3rdPayerCode;
  @override
  @JsonKey()
  final String? override3rdPayerReason;
  @override
  @JsonKey()
  final int? transplantationCode;
  @override
  @JsonKey()
  final int? prescriberNorm;
  @override
  @JsonKey()
  final String? productLabel;
  @override
  @JsonKey()
  final int? percentNorm;
  @override
  @JsonKey()
  final String? prescriberNihii;
  @override
  @JsonKey()
  final String? relatedCode;
  @override
  @JsonKey()
  final int? prescriptionDate;
  @override
  @JsonKey()
  final int? derogationMaxNumber;
  @override
  @JsonKey()
  final String? prescriberSsin;
  @override
  @JsonKey()
  final String? prescriberLastName;
  @override
  @JsonKey()
  final String? prescriberFirstName;
  @override
  @JsonKey()
  final String? prescriberCdHcParty;
  @override
  @JsonKey()
  final String? locationNihii;
  @override
  @JsonKey()
  final String? locationCdHcParty;
  @override
  @JsonKey()
  final int? locationService;
  @override
  @JsonKey()
  final int? admissionDate;
  @override
  @JsonKey()
  final bool? canceled;
  @override
  @JsonKey()
  final bool? accepted;
  @override
  @JsonKey()
  final bool? pending;
  @override
  @JsonKey()
  final bool? resent;
  @override
  @JsonKey()
  final bool? archived;
  @override
  @JsonKey()
  final bool? lost;
  @override
  @JsonKey()
  final int? insuranceJustification;
  @override
  @JsonKey()
  final int? cancelPatientInterventionReason;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? codeLabel;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedInvoicingCodeCopyWith<_EncryptedInvoicingCode> get copyWith =>
      __$EncryptedInvoicingCodeCopyWithImpl<_EncryptedInvoicingCode>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedInvoicingCode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.dateCode, dateCode) ||
                other.dateCode == dateCode) &&
            (identical(other.logicalId, logicalId) ||
                other.logicalId == logicalId) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId) &&
            (identical(other.tarificationId, tarificationId) ||
                other.tarificationId == tarificationId) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.amiIntervention, amiIntervention) ||
                other.amiIntervention == amiIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.conventionAmount, conventionAmount) ||
                other.conventionAmount == conventionAmount) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.contract, contract) ||
                other.contract == contract) &&
            (identical(other.contractDate, contractDate) ||
                other.contractDate == contractDate) &&
            (identical(other.units, units) || other.units == units) &&
            (identical(other.side, side) || other.side == side) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.eidReadingHour, eidReadingHour) ||
                other.eidReadingHour == eidReadingHour) &&
            (identical(other.eidReadingValue, eidReadingValue) ||
                other.eidReadingValue == eidReadingValue) &&
            (identical(other.override3rdPayerCode, override3rdPayerCode) ||
                other.override3rdPayerCode == override3rdPayerCode) &&
            (identical(other.override3rdPayerReason, override3rdPayerReason) ||
                other.override3rdPayerReason == override3rdPayerReason) &&
            (identical(other.transplantationCode, transplantationCode) ||
                other.transplantationCode == transplantationCode) &&
            (identical(other.prescriberNorm, prescriberNorm) ||
                other.prescriberNorm == prescriberNorm) &&
            (identical(other.productLabel, productLabel) ||
                other.productLabel == productLabel) &&
            (identical(other.percentNorm, percentNorm) ||
                other.percentNorm == percentNorm) &&
            (identical(other.prescriberNihii, prescriberNihii) ||
                other.prescriberNihii == prescriberNihii) &&
            (identical(other.relatedCode, relatedCode) ||
                other.relatedCode == relatedCode) &&
            (identical(other.prescriptionDate, prescriptionDate) ||
                other.prescriptionDate == prescriptionDate) &&
            (identical(other.derogationMaxNumber, derogationMaxNumber) ||
                other.derogationMaxNumber == derogationMaxNumber) &&
            (identical(other.prescriberSsin, prescriberSsin) ||
                other.prescriberSsin == prescriberSsin) &&
            (identical(other.prescriberLastName, prescriberLastName) ||
                other.prescriberLastName == prescriberLastName) &&
            (identical(other.prescriberFirstName, prescriberFirstName) ||
                other.prescriberFirstName == prescriberFirstName) &&
            (identical(other.prescriberCdHcParty, prescriberCdHcParty) ||
                other.prescriberCdHcParty == prescriberCdHcParty) &&
            (identical(other.locationNihii, locationNihii) ||
                other.locationNihii == locationNihii) &&
            (identical(other.locationCdHcParty, locationCdHcParty) ||
                other.locationCdHcParty == locationCdHcParty) &&
            (identical(other.locationService, locationService) ||
                other.locationService == locationService) &&
            (identical(other.admissionDate, admissionDate) ||
                other.admissionDate == admissionDate) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.pending, pending) || other.pending == pending) &&
            (identical(other.resent, resent) || other.resent == resent) &&
            (identical(other.archived, archived) ||
                other.archived == archived) &&
            (identical(other.lost, lost) || other.lost == lost) &&
            (identical(other.insuranceJustification, insuranceJustification) ||
                other.insuranceJustification == insuranceJustification) &&
            (identical(other.cancelPatientInterventionReason, cancelPatientInterventionReason) ||
                other.cancelPatientInterventionReason ==
                    cancelPatientInterventionReason) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.codeLabel, codeLabel) ||
                other.codeLabel == codeLabel) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        dateCode,
        logicalId,
        label,
        userId,
        contactId,
        serviceId,
        tarificationId,
        code,
        paymentType,
        paid,
        totalAmount,
        reimbursement,
        patientIntervention,
        amiIntervention,
        doctorSupplement,
        conventionAmount,
        vat,
        error,
        contract,
        contractDate,
        units,
        side,
        timeOfDay,
        eidReadingHour,
        eidReadingValue,
        override3rdPayerCode,
        override3rdPayerReason,
        transplantationCode,
        prescriberNorm,
        productLabel,
        percentNorm,
        prescriberNihii,
        relatedCode,
        prescriptionDate,
        derogationMaxNumber,
        prescriberSsin,
        prescriberLastName,
        prescriberFirstName,
        prescriberCdHcParty,
        locationNihii,
        locationCdHcParty,
        locationService,
        admissionDate,
        canceled,
        accepted,
        pending,
        resent,
        archived,
        lost,
        insuranceJustification,
        cancelPatientInterventionReason,
        status,
        codeLabel,
        const DeepCollectionEquality().hash(_options),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedInvoicingCode(id: $id, dateCode: $dateCode, logicalId: $logicalId, label: $label, userId: $userId, contactId: $contactId, serviceId: $serviceId, tarificationId: $tarificationId, code: $code, paymentType: $paymentType, paid: $paid, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, amiIntervention: $amiIntervention, doctorSupplement: $doctorSupplement, conventionAmount: $conventionAmount, vat: $vat, error: $error, contract: $contract, contractDate: $contractDate, units: $units, side: $side, timeOfDay: $timeOfDay, eidReadingHour: $eidReadingHour, eidReadingValue: $eidReadingValue, override3rdPayerCode: $override3rdPayerCode, override3rdPayerReason: $override3rdPayerReason, transplantationCode: $transplantationCode, prescriberNorm: $prescriberNorm, productLabel: $productLabel, percentNorm: $percentNorm, prescriberNihii: $prescriberNihii, relatedCode: $relatedCode, prescriptionDate: $prescriptionDate, derogationMaxNumber: $derogationMaxNumber, prescriberSsin: $prescriberSsin, prescriberLastName: $prescriberLastName, prescriberFirstName: $prescriberFirstName, prescriberCdHcParty: $prescriberCdHcParty, locationNihii: $locationNihii, locationCdHcParty: $locationCdHcParty, locationService: $locationService, admissionDate: $admissionDate, canceled: $canceled, accepted: $accepted, pending: $pending, resent: $resent, archived: $archived, lost: $lost, insuranceJustification: $insuranceJustification, cancelPatientInterventionReason: $cancelPatientInterventionReason, status: $status, codeLabel: $codeLabel, options: $options, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedInvoicingCodeCopyWith<$Res>
    implements $EncryptedInvoicingCodeCopyWith<$Res> {
  factory _$EncryptedInvoicingCodeCopyWith(_EncryptedInvoicingCode value,
          $Res Function(_EncryptedInvoicingCode) _then) =
      __$EncryptedInvoicingCodeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      int? dateCode,
      String? logicalId,
      String? label,
      String? userId,
      String? contactId,
      String? serviceId,
      String? tarificationId,
      String? code,
      PaymentType? paymentType,
      double? paid,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? amiIntervention,
      double? doctorSupplement,
      double? conventionAmount,
      double? vat,
      String? error,
      String? contract,
      int? contractDate,
      int? units,
      int? side,
      int? timeOfDay,
      int? eidReadingHour,
      String? eidReadingValue,
      int? override3rdPayerCode,
      String? override3rdPayerReason,
      int? transplantationCode,
      int? prescriberNorm,
      String? productLabel,
      int? percentNorm,
      String? prescriberNihii,
      String? relatedCode,
      int? prescriptionDate,
      int? derogationMaxNumber,
      String? prescriberSsin,
      String? prescriberLastName,
      String? prescriberFirstName,
      String? prescriberCdHcParty,
      String? locationNihii,
      String? locationCdHcParty,
      int? locationService,
      int? admissionDate,
      bool? canceled,
      bool? accepted,
      bool? pending,
      bool? resent,
      bool? archived,
      bool? lost,
      int? insuranceJustification,
      int? cancelPatientInterventionReason,
      int? status,
      String? codeLabel,
      Map<String, String> options,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedInvoicingCodeCopyWithImpl<$Res>
    implements _$EncryptedInvoicingCodeCopyWith<$Res> {
  __$EncryptedInvoicingCodeCopyWithImpl(this._self, this._then);

  final _EncryptedInvoicingCode _self;
  final $Res Function(_EncryptedInvoicingCode) _then;

  /// Create a copy of EncryptedInvoicingCode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? dateCode = freezed,
    Object? logicalId = freezed,
    Object? label = freezed,
    Object? userId = freezed,
    Object? contactId = freezed,
    Object? serviceId = freezed,
    Object? tarificationId = freezed,
    Object? code = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? amiIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? conventionAmount = freezed,
    Object? vat = freezed,
    Object? error = freezed,
    Object? contract = freezed,
    Object? contractDate = freezed,
    Object? units = freezed,
    Object? side = freezed,
    Object? timeOfDay = freezed,
    Object? eidReadingHour = freezed,
    Object? eidReadingValue = freezed,
    Object? override3rdPayerCode = freezed,
    Object? override3rdPayerReason = freezed,
    Object? transplantationCode = freezed,
    Object? prescriberNorm = freezed,
    Object? productLabel = freezed,
    Object? percentNorm = freezed,
    Object? prescriberNihii = freezed,
    Object? relatedCode = freezed,
    Object? prescriptionDate = freezed,
    Object? derogationMaxNumber = freezed,
    Object? prescriberSsin = freezed,
    Object? prescriberLastName = freezed,
    Object? prescriberFirstName = freezed,
    Object? prescriberCdHcParty = freezed,
    Object? locationNihii = freezed,
    Object? locationCdHcParty = freezed,
    Object? locationService = freezed,
    Object? admissionDate = freezed,
    Object? canceled = freezed,
    Object? accepted = freezed,
    Object? pending = freezed,
    Object? resent = freezed,
    Object? archived = freezed,
    Object? lost = freezed,
    Object? insuranceJustification = freezed,
    Object? cancelPatientInterventionReason = freezed,
    Object? status = freezed,
    Object? codeLabel = freezed,
    Object? options = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedInvoicingCode(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      dateCode: freezed == dateCode
          ? _self.dateCode
          : dateCode // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalId: freezed == logicalId
          ? _self.logicalId
          : logicalId // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      tarificationId: freezed == tarificationId
          ? _self.tarificationId
          : tarificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      amiIntervention: freezed == amiIntervention
          ? _self.amiIntervention
          : amiIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      conventionAmount: freezed == conventionAmount
          ? _self.conventionAmount
          : conventionAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      contract: freezed == contract
          ? _self.contract
          : contract // ignore: cast_nullable_to_non_nullable
              as String?,
      contractDate: freezed == contractDate
          ? _self.contractDate
          : contractDate // ignore: cast_nullable_to_non_nullable
              as int?,
      units: freezed == units
          ? _self.units
          : units // ignore: cast_nullable_to_non_nullable
              as int?,
      side: freezed == side
          ? _self.side
          : side // ignore: cast_nullable_to_non_nullable
              as int?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingHour: freezed == eidReadingHour
          ? _self.eidReadingHour
          : eidReadingHour // ignore: cast_nullable_to_non_nullable
              as int?,
      eidReadingValue: freezed == eidReadingValue
          ? _self.eidReadingValue
          : eidReadingValue // ignore: cast_nullable_to_non_nullable
              as String?,
      override3rdPayerCode: freezed == override3rdPayerCode
          ? _self.override3rdPayerCode
          : override3rdPayerCode // ignore: cast_nullable_to_non_nullable
              as int?,
      override3rdPayerReason: freezed == override3rdPayerReason
          ? _self.override3rdPayerReason
          : override3rdPayerReason // ignore: cast_nullable_to_non_nullable
              as String?,
      transplantationCode: freezed == transplantationCode
          ? _self.transplantationCode
          : transplantationCode // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNorm: freezed == prescriberNorm
          ? _self.prescriberNorm
          : prescriberNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      productLabel: freezed == productLabel
          ? _self.productLabel
          : productLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      percentNorm: freezed == percentNorm
          ? _self.percentNorm
          : percentNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberNihii: freezed == prescriberNihii
          ? _self.prescriberNihii
          : prescriberNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      relatedCode: freezed == relatedCode
          ? _self.relatedCode
          : relatedCode // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriptionDate: freezed == prescriptionDate
          ? _self.prescriptionDate
          : prescriptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      derogationMaxNumber: freezed == derogationMaxNumber
          ? _self.derogationMaxNumber
          : derogationMaxNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      prescriberSsin: freezed == prescriberSsin
          ? _self.prescriberSsin
          : prescriberSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberLastName: freezed == prescriberLastName
          ? _self.prescriberLastName
          : prescriberLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberFirstName: freezed == prescriberFirstName
          ? _self.prescriberFirstName
          : prescriberFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      prescriberCdHcParty: freezed == prescriberCdHcParty
          ? _self.prescriberCdHcParty
          : prescriberCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationCdHcParty: freezed == locationCdHcParty
          ? _self.locationCdHcParty
          : locationCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      pending: freezed == pending
          ? _self.pending
          : pending // ignore: cast_nullable_to_non_nullable
              as bool?,
      resent: freezed == resent
          ? _self.resent
          : resent // ignore: cast_nullable_to_non_nullable
              as bool?,
      archived: freezed == archived
          ? _self.archived
          : archived // ignore: cast_nullable_to_non_nullable
              as bool?,
      lost: freezed == lost
          ? _self.lost
          : lost // ignore: cast_nullable_to_non_nullable
              as bool?,
      insuranceJustification: freezed == insuranceJustification
          ? _self.insuranceJustification
          : insuranceJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelPatientInterventionReason: freezed ==
              cancelPatientInterventionReason
          ? _self.cancelPatientInterventionReason
          : cancelPatientInterventionReason // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      codeLabel: freezed == codeLabel
          ? _self.codeLabel
          : codeLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
