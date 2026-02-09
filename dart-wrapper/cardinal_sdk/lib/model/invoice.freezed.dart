// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'invoice.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedInvoice {
  String get id;
  String? get rev;
  List<Identifier> get identifier;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  int? get invoiceDate;
  int? get sentDate;
  int? get printedDate;
  List<DecryptedInvoicingCode> get invoicingCodes;
  Map<String, String> get receipts;
  String? get recipientType;
  String? get recipientId;
  String? get invoiceReference;
  String? get decisionReference;
  String? get thirdPartyReference;
  String? get thirdPartyPaymentJustification;
  String? get thirdPartyPaymentReason;
  String? get reason;
  InvoiceType? get invoiceType;
  MediumType? get sentMediumType;
  InvoiceInterventionType? get interventionType;
  String? get groupId;
  PaymentType? get paymentType;
  double? get paid;
  List<Payment>? get payments;
  String? get gnotionNihii;
  String? get gnotionSsin;
  String? get gnotionLastName;
  String? get gnotionFirstName;
  String? get gnotionCdHcParty;
  int? get invoicePeriod;
  String? get careProviderType;
  String? get internshipNihii;
  String? get internshipSsin;
  String? get internshipLastName;
  String? get internshipFirstName;
  String? get internshipCdHcParty;
  String? get internshipCbe;
  String? get supervisorNihii;
  String? get supervisorSsin;
  String? get supervisorLastName;
  String? get supervisorFirstName;
  String? get supervisorCdHcParty;
  String? get supervisorCbe;
  String? get error;
  String? get encounterLocationName;
  String? get encounterLocationNihii;
  int? get encounterLocationNorm;
  int? get longDelayJustification;
  String? get correctiveInvoiceId;
  String? get correctedInvoiceId;
  bool? get creditNote;
  String? get creditNoteRelatedInvoiceId;
  IdentityDocumentReader? get idDocument;
  int? get admissionDate;
  String? get locationNihii;
  int? get locationService;
  String? get cancelReason;
  int? get cancelDate;
  Map<String, String> get options;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedInvoiceCopyWith<DecryptedInvoice> get copyWith =>
      _$DecryptedInvoiceCopyWithImpl<DecryptedInvoice>(
          this as DecryptedInvoice, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedInvoice &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
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
            (identical(other.invoiceDate, invoiceDate) ||
                other.invoiceDate == invoiceDate) &&
            (identical(other.sentDate, sentDate) ||
                other.sentDate == sentDate) &&
            (identical(other.printedDate, printedDate) ||
                other.printedDate == printedDate) &&
            const DeepCollectionEquality()
                .equals(other.invoicingCodes, invoicingCodes) &&
            const DeepCollectionEquality().equals(other.receipts, receipts) &&
            (identical(other.recipientType, recipientType) ||
                other.recipientType == recipientType) &&
            (identical(other.recipientId, recipientId) ||
                other.recipientId == recipientId) &&
            (identical(other.invoiceReference, invoiceReference) ||
                other.invoiceReference == invoiceReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.thirdPartyReference, thirdPartyReference) ||
                other.thirdPartyReference == thirdPartyReference) &&
            (identical(other.thirdPartyPaymentJustification, thirdPartyPaymentJustification) ||
                other.thirdPartyPaymentJustification ==
                    thirdPartyPaymentJustification) &&
            (identical(other.thirdPartyPaymentReason, thirdPartyPaymentReason) ||
                other.thirdPartyPaymentReason == thirdPartyPaymentReason) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.invoiceType, invoiceType) ||
                other.invoiceType == invoiceType) &&
            (identical(other.sentMediumType, sentMediumType) ||
                other.sentMediumType == sentMediumType) &&
            (identical(other.interventionType, interventionType) ||
                other.interventionType == interventionType) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            const DeepCollectionEquality().equals(other.payments, payments) &&
            (identical(other.gnotionNihii, gnotionNihii) ||
                other.gnotionNihii == gnotionNihii) &&
            (identical(other.gnotionSsin, gnotionSsin) ||
                other.gnotionSsin == gnotionSsin) &&
            (identical(other.gnotionLastName, gnotionLastName) ||
                other.gnotionLastName == gnotionLastName) &&
            (identical(other.gnotionFirstName, gnotionFirstName) ||
                other.gnotionFirstName == gnotionFirstName) &&
            (identical(other.gnotionCdHcParty, gnotionCdHcParty) ||
                other.gnotionCdHcParty == gnotionCdHcParty) &&
            (identical(other.invoicePeriod, invoicePeriod) ||
                other.invoicePeriod == invoicePeriod) &&
            (identical(other.careProviderType, careProviderType) ||
                other.careProviderType == careProviderType) &&
            (identical(other.internshipNihii, internshipNihii) ||
                other.internshipNihii == internshipNihii) &&
            (identical(other.internshipSsin, internshipSsin) ||
                other.internshipSsin == internshipSsin) &&
            (identical(other.internshipLastName, internshipLastName) ||
                other.internshipLastName == internshipLastName) &&
            (identical(other.internshipFirstName, internshipFirstName) ||
                other.internshipFirstName == internshipFirstName) &&
            (identical(other.internshipCdHcParty, internshipCdHcParty) ||
                other.internshipCdHcParty == internshipCdHcParty) &&
            (identical(other.internshipCbe, internshipCbe) || other.internshipCbe == internshipCbe) &&
            (identical(other.supervisorNihii, supervisorNihii) || other.supervisorNihii == supervisorNihii) &&
            (identical(other.supervisorSsin, supervisorSsin) || other.supervisorSsin == supervisorSsin) &&
            (identical(other.supervisorLastName, supervisorLastName) || other.supervisorLastName == supervisorLastName) &&
            (identical(other.supervisorFirstName, supervisorFirstName) || other.supervisorFirstName == supervisorFirstName) &&
            (identical(other.supervisorCdHcParty, supervisorCdHcParty) || other.supervisorCdHcParty == supervisorCdHcParty) &&
            (identical(other.supervisorCbe, supervisorCbe) || other.supervisorCbe == supervisorCbe) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.encounterLocationName, encounterLocationName) || other.encounterLocationName == encounterLocationName) &&
            (identical(other.encounterLocationNihii, encounterLocationNihii) || other.encounterLocationNihii == encounterLocationNihii) &&
            (identical(other.encounterLocationNorm, encounterLocationNorm) || other.encounterLocationNorm == encounterLocationNorm) &&
            (identical(other.longDelayJustification, longDelayJustification) || other.longDelayJustification == longDelayJustification) &&
            (identical(other.correctiveInvoiceId, correctiveInvoiceId) || other.correctiveInvoiceId == correctiveInvoiceId) &&
            (identical(other.correctedInvoiceId, correctedInvoiceId) || other.correctedInvoiceId == correctedInvoiceId) &&
            (identical(other.creditNote, creditNote) || other.creditNote == creditNote) &&
            (identical(other.creditNoteRelatedInvoiceId, creditNoteRelatedInvoiceId) || other.creditNoteRelatedInvoiceId == creditNoteRelatedInvoiceId) &&
            (identical(other.idDocument, idDocument) || other.idDocument == idDocument) &&
            (identical(other.admissionDate, admissionDate) || other.admissionDate == admissionDate) &&
            (identical(other.locationNihii, locationNihii) || other.locationNihii == locationNihii) &&
            (identical(other.locationService, locationService) || other.locationService == locationService) &&
            (identical(other.cancelReason, cancelReason) || other.cancelReason == cancelReason) &&
            (identical(other.cancelDate, cancelDate) || other.cancelDate == cancelDate) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality().equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality().equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other.delegations, delegations) &&
            const DeepCollectionEquality().equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        const DeepCollectionEquality().hash(identifier),
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        invoiceDate,
        sentDate,
        printedDate,
        const DeepCollectionEquality().hash(invoicingCodes),
        const DeepCollectionEquality().hash(receipts),
        recipientType,
        recipientId,
        invoiceReference,
        decisionReference,
        thirdPartyReference,
        thirdPartyPaymentJustification,
        thirdPartyPaymentReason,
        reason,
        invoiceType,
        sentMediumType,
        interventionType,
        groupId,
        paymentType,
        paid,
        const DeepCollectionEquality().hash(payments),
        gnotionNihii,
        gnotionSsin,
        gnotionLastName,
        gnotionFirstName,
        gnotionCdHcParty,
        invoicePeriod,
        careProviderType,
        internshipNihii,
        internshipSsin,
        internshipLastName,
        internshipFirstName,
        internshipCdHcParty,
        internshipCbe,
        supervisorNihii,
        supervisorSsin,
        supervisorLastName,
        supervisorFirstName,
        supervisorCdHcParty,
        supervisorCbe,
        error,
        encounterLocationName,
        encounterLocationNihii,
        encounterLocationNorm,
        longDelayJustification,
        correctiveInvoiceId,
        correctedInvoiceId,
        creditNote,
        creditNoteRelatedInvoiceId,
        idDocument,
        admissionDate,
        locationNihii,
        locationService,
        cancelReason,
        cancelDate,
        const DeepCollectionEquality().hash(options),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedInvoice(id: $id, rev: $rev, identifier: $identifier, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, invoiceDate: $invoiceDate, sentDate: $sentDate, printedDate: $printedDate, invoicingCodes: $invoicingCodes, receipts: $receipts, recipientType: $recipientType, recipientId: $recipientId, invoiceReference: $invoiceReference, decisionReference: $decisionReference, thirdPartyReference: $thirdPartyReference, thirdPartyPaymentJustification: $thirdPartyPaymentJustification, thirdPartyPaymentReason: $thirdPartyPaymentReason, reason: $reason, invoiceType: $invoiceType, sentMediumType: $sentMediumType, interventionType: $interventionType, groupId: $groupId, paymentType: $paymentType, paid: $paid, payments: $payments, gnotionNihii: $gnotionNihii, gnotionSsin: $gnotionSsin, gnotionLastName: $gnotionLastName, gnotionFirstName: $gnotionFirstName, gnotionCdHcParty: $gnotionCdHcParty, invoicePeriod: $invoicePeriod, careProviderType: $careProviderType, internshipNihii: $internshipNihii, internshipSsin: $internshipSsin, internshipLastName: $internshipLastName, internshipFirstName: $internshipFirstName, internshipCdHcParty: $internshipCdHcParty, internshipCbe: $internshipCbe, supervisorNihii: $supervisorNihii, supervisorSsin: $supervisorSsin, supervisorLastName: $supervisorLastName, supervisorFirstName: $supervisorFirstName, supervisorCdHcParty: $supervisorCdHcParty, supervisorCbe: $supervisorCbe, error: $error, encounterLocationName: $encounterLocationName, encounterLocationNihii: $encounterLocationNihii, encounterLocationNorm: $encounterLocationNorm, longDelayJustification: $longDelayJustification, correctiveInvoiceId: $correctiveInvoiceId, correctedInvoiceId: $correctedInvoiceId, creditNote: $creditNote, creditNoteRelatedInvoiceId: $creditNoteRelatedInvoiceId, idDocument: $idDocument, admissionDate: $admissionDate, locationNihii: $locationNihii, locationService: $locationService, cancelReason: $cancelReason, cancelDate: $cancelDate, options: $options, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedInvoiceCopyWith<$Res> {
  factory $DecryptedInvoiceCopyWith(
          DecryptedInvoice value, $Res Function(DecryptedInvoice) _then) =
      _$DecryptedInvoiceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      List<Identifier> identifier,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? invoiceDate,
      int? sentDate,
      int? printedDate,
      List<DecryptedInvoicingCode> invoicingCodes,
      Map<String, String> receipts,
      String? recipientType,
      String? recipientId,
      String? invoiceReference,
      String? decisionReference,
      String? thirdPartyReference,
      String? thirdPartyPaymentJustification,
      String? thirdPartyPaymentReason,
      String? reason,
      InvoiceType? invoiceType,
      MediumType? sentMediumType,
      InvoiceInterventionType? interventionType,
      String? groupId,
      PaymentType? paymentType,
      double? paid,
      List<Payment>? payments,
      String? gnotionNihii,
      String? gnotionSsin,
      String? gnotionLastName,
      String? gnotionFirstName,
      String? gnotionCdHcParty,
      int? invoicePeriod,
      String? careProviderType,
      String? internshipNihii,
      String? internshipSsin,
      String? internshipLastName,
      String? internshipFirstName,
      String? internshipCdHcParty,
      String? internshipCbe,
      String? supervisorNihii,
      String? supervisorSsin,
      String? supervisorLastName,
      String? supervisorFirstName,
      String? supervisorCdHcParty,
      String? supervisorCbe,
      String? error,
      String? encounterLocationName,
      String? encounterLocationNihii,
      int? encounterLocationNorm,
      int? longDelayJustification,
      String? correctiveInvoiceId,
      String? correctedInvoiceId,
      bool? creditNote,
      String? creditNoteRelatedInvoiceId,
      IdentityDocumentReader? idDocument,
      int? admissionDate,
      String? locationNihii,
      int? locationService,
      String? cancelReason,
      int? cancelDate,
      Map<String, String> options,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $IdentityDocumentReaderCopyWith<$Res>? get idDocument;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedInvoiceCopyWithImpl<$Res>
    implements $DecryptedInvoiceCopyWith<$Res> {
  _$DecryptedInvoiceCopyWithImpl(this._self, this._then);

  final DecryptedInvoice _self;
  final $Res Function(DecryptedInvoice) _then;

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? identifier = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? invoiceDate = freezed,
    Object? sentDate = freezed,
    Object? printedDate = freezed,
    Object? invoicingCodes = null,
    Object? receipts = null,
    Object? recipientType = freezed,
    Object? recipientId = freezed,
    Object? invoiceReference = freezed,
    Object? decisionReference = freezed,
    Object? thirdPartyReference = freezed,
    Object? thirdPartyPaymentJustification = freezed,
    Object? thirdPartyPaymentReason = freezed,
    Object? reason = freezed,
    Object? invoiceType = freezed,
    Object? sentMediumType = freezed,
    Object? interventionType = freezed,
    Object? groupId = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? payments = freezed,
    Object? gnotionNihii = freezed,
    Object? gnotionSsin = freezed,
    Object? gnotionLastName = freezed,
    Object? gnotionFirstName = freezed,
    Object? gnotionCdHcParty = freezed,
    Object? invoicePeriod = freezed,
    Object? careProviderType = freezed,
    Object? internshipNihii = freezed,
    Object? internshipSsin = freezed,
    Object? internshipLastName = freezed,
    Object? internshipFirstName = freezed,
    Object? internshipCdHcParty = freezed,
    Object? internshipCbe = freezed,
    Object? supervisorNihii = freezed,
    Object? supervisorSsin = freezed,
    Object? supervisorLastName = freezed,
    Object? supervisorFirstName = freezed,
    Object? supervisorCdHcParty = freezed,
    Object? supervisorCbe = freezed,
    Object? error = freezed,
    Object? encounterLocationName = freezed,
    Object? encounterLocationNihii = freezed,
    Object? encounterLocationNorm = freezed,
    Object? longDelayJustification = freezed,
    Object? correctiveInvoiceId = freezed,
    Object? correctedInvoiceId = freezed,
    Object? creditNote = freezed,
    Object? creditNoteRelatedInvoiceId = freezed,
    Object? idDocument = freezed,
    Object? admissionDate = freezed,
    Object? locationNihii = freezed,
    Object? locationService = freezed,
    Object? cancelReason = freezed,
    Object? cancelDate = freezed,
    Object? options = null,
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
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      invoiceDate: freezed == invoiceDate
          ? _self.invoiceDate
          : invoiceDate // ignore: cast_nullable_to_non_nullable
              as int?,
      sentDate: freezed == sentDate
          ? _self.sentDate
          : sentDate // ignore: cast_nullable_to_non_nullable
              as int?,
      printedDate: freezed == printedDate
          ? _self.printedDate
          : printedDate // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self.invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as List<DecryptedInvoicingCode>,
      receipts: null == receipts
          ? _self.receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      recipientType: freezed == recipientType
          ? _self.recipientType
          : recipientType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipientId: freezed == recipientId
          ? _self.recipientId
          : recipientId // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceReference: freezed == invoiceReference
          ? _self.invoiceReference
          : invoiceReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyReference: freezed == thirdPartyReference
          ? _self.thirdPartyReference
          : thirdPartyReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentJustification: freezed == thirdPartyPaymentJustification
          ? _self.thirdPartyPaymentJustification
          : thirdPartyPaymentJustification // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentReason: freezed == thirdPartyPaymentReason
          ? _self.thirdPartyPaymentReason
          : thirdPartyPaymentReason // ignore: cast_nullable_to_non_nullable
              as String?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceType: freezed == invoiceType
          ? _self.invoiceType
          : invoiceType // ignore: cast_nullable_to_non_nullable
              as InvoiceType?,
      sentMediumType: freezed == sentMediumType
          ? _self.sentMediumType
          : sentMediumType // ignore: cast_nullable_to_non_nullable
              as MediumType?,
      interventionType: freezed == interventionType
          ? _self.interventionType
          : interventionType // ignore: cast_nullable_to_non_nullable
              as InvoiceInterventionType?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      payments: freezed == payments
          ? _self.payments
          : payments // ignore: cast_nullable_to_non_nullable
              as List<Payment>?,
      gnotionNihii: freezed == gnotionNihii
          ? _self.gnotionNihii
          : gnotionNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionSsin: freezed == gnotionSsin
          ? _self.gnotionSsin
          : gnotionSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionLastName: freezed == gnotionLastName
          ? _self.gnotionLastName
          : gnotionLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionFirstName: freezed == gnotionFirstName
          ? _self.gnotionFirstName
          : gnotionFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionCdHcParty: freezed == gnotionCdHcParty
          ? _self.gnotionCdHcParty
          : gnotionCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      invoicePeriod: freezed == invoicePeriod
          ? _self.invoicePeriod
          : invoicePeriod // ignore: cast_nullable_to_non_nullable
              as int?,
      careProviderType: freezed == careProviderType
          ? _self.careProviderType
          : careProviderType // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipNihii: freezed == internshipNihii
          ? _self.internshipNihii
          : internshipNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipSsin: freezed == internshipSsin
          ? _self.internshipSsin
          : internshipSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipLastName: freezed == internshipLastName
          ? _self.internshipLastName
          : internshipLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipFirstName: freezed == internshipFirstName
          ? _self.internshipFirstName
          : internshipFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCdHcParty: freezed == internshipCdHcParty
          ? _self.internshipCdHcParty
          : internshipCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCbe: freezed == internshipCbe
          ? _self.internshipCbe
          : internshipCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorNihii: freezed == supervisorNihii
          ? _self.supervisorNihii
          : supervisorNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorSsin: freezed == supervisorSsin
          ? _self.supervisorSsin
          : supervisorSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorLastName: freezed == supervisorLastName
          ? _self.supervisorLastName
          : supervisorLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorFirstName: freezed == supervisorFirstName
          ? _self.supervisorFirstName
          : supervisorFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCdHcParty: freezed == supervisorCdHcParty
          ? _self.supervisorCdHcParty
          : supervisorCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCbe: freezed == supervisorCbe
          ? _self.supervisorCbe
          : supervisorCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationName: freezed == encounterLocationName
          ? _self.encounterLocationName
          : encounterLocationName // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNihii: freezed == encounterLocationNihii
          ? _self.encounterLocationNihii
          : encounterLocationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNorm: freezed == encounterLocationNorm
          ? _self.encounterLocationNorm
          : encounterLocationNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      longDelayJustification: freezed == longDelayJustification
          ? _self.longDelayJustification
          : longDelayJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      correctiveInvoiceId: freezed == correctiveInvoiceId
          ? _self.correctiveInvoiceId
          : correctiveInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      correctedInvoiceId: freezed == correctedInvoiceId
          ? _self.correctedInvoiceId
          : correctedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      creditNote: freezed == creditNote
          ? _self.creditNote
          : creditNote // ignore: cast_nullable_to_non_nullable
              as bool?,
      creditNoteRelatedInvoiceId: freezed == creditNoteRelatedInvoiceId
          ? _self.creditNoteRelatedInvoiceId
          : creditNoteRelatedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      idDocument: freezed == idDocument
          ? _self.idDocument
          : idDocument // ignore: cast_nullable_to_non_nullable
              as IdentityDocumentReader?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelReason: freezed == cancelReason
          ? _self.cancelReason
          : cancelReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelDate: freezed == cancelDate
          ? _self.cancelDate
          : cancelDate // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
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

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument {
    if (_self.idDocument == null) {
      return null;
    }

    return $IdentityDocumentReaderCopyWith<$Res>(_self.idDocument!, (value) {
      return _then(_self.copyWith(idDocument: value));
    });
  }

  /// Create a copy of DecryptedInvoice
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

class _DecryptedInvoice implements DecryptedInvoice {
  const _DecryptedInvoice(
      {required this.id,
      this.rev = null,
      final List<Identifier> identifier = const [],
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.invoiceDate = null,
      this.sentDate = null,
      this.printedDate = null,
      final List<DecryptedInvoicingCode> invoicingCodes = const [],
      final Map<String, String> receipts = const {},
      this.recipientType = null,
      this.recipientId = null,
      this.invoiceReference = null,
      this.decisionReference = null,
      this.thirdPartyReference = null,
      this.thirdPartyPaymentJustification = null,
      this.thirdPartyPaymentReason = null,
      this.reason = null,
      this.invoiceType = null,
      this.sentMediumType = null,
      this.interventionType = null,
      this.groupId = null,
      this.paymentType = null,
      this.paid = null,
      final List<Payment>? payments = null,
      this.gnotionNihii = null,
      this.gnotionSsin = null,
      this.gnotionLastName = null,
      this.gnotionFirstName = null,
      this.gnotionCdHcParty = null,
      this.invoicePeriod = null,
      this.careProviderType = null,
      this.internshipNihii = null,
      this.internshipSsin = null,
      this.internshipLastName = null,
      this.internshipFirstName = null,
      this.internshipCdHcParty = null,
      this.internshipCbe = null,
      this.supervisorNihii = null,
      this.supervisorSsin = null,
      this.supervisorLastName = null,
      this.supervisorFirstName = null,
      this.supervisorCdHcParty = null,
      this.supervisorCbe = null,
      this.error = null,
      this.encounterLocationName = null,
      this.encounterLocationNihii = null,
      this.encounterLocationNorm = null,
      this.longDelayJustification = null,
      this.correctiveInvoiceId = null,
      this.correctedInvoiceId = null,
      this.creditNote = null,
      this.creditNoteRelatedInvoiceId = null,
      this.idDocument = null,
      this.admissionDate = null,
      this.locationNihii = null,
      this.locationService = null,
      this.cancelReason = null,
      this.cancelDate = null,
      final Map<String, String> options = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifier = identifier,
        _tags = tags,
        _codes = codes,
        _invoicingCodes = invoicingCodes,
        _receipts = receipts,
        _payments = payments,
        _options = options,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
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
  final int? invoiceDate;
  @override
  @JsonKey()
  final int? sentDate;
  @override
  @JsonKey()
  final int? printedDate;
  final List<DecryptedInvoicingCode> _invoicingCodes;
  @override
  @JsonKey()
  List<DecryptedInvoicingCode> get invoicingCodes {
    if (_invoicingCodes is EqualUnmodifiableListView) return _invoicingCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_invoicingCodes);
  }

  final Map<String, String> _receipts;
  @override
  @JsonKey()
  Map<String, String> get receipts {
    if (_receipts is EqualUnmodifiableMapView) return _receipts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_receipts);
  }

  @override
  @JsonKey()
  final String? recipientType;
  @override
  @JsonKey()
  final String? recipientId;
  @override
  @JsonKey()
  final String? invoiceReference;
  @override
  @JsonKey()
  final String? decisionReference;
  @override
  @JsonKey()
  final String? thirdPartyReference;
  @override
  @JsonKey()
  final String? thirdPartyPaymentJustification;
  @override
  @JsonKey()
  final String? thirdPartyPaymentReason;
  @override
  @JsonKey()
  final String? reason;
  @override
  @JsonKey()
  final InvoiceType? invoiceType;
  @override
  @JsonKey()
  final MediumType? sentMediumType;
  @override
  @JsonKey()
  final InvoiceInterventionType? interventionType;
  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final PaymentType? paymentType;
  @override
  @JsonKey()
  final double? paid;
  final List<Payment>? _payments;
  @override
  @JsonKey()
  List<Payment>? get payments {
    final value = _payments;
    if (value == null) return null;
    if (_payments is EqualUnmodifiableListView) return _payments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? gnotionNihii;
  @override
  @JsonKey()
  final String? gnotionSsin;
  @override
  @JsonKey()
  final String? gnotionLastName;
  @override
  @JsonKey()
  final String? gnotionFirstName;
  @override
  @JsonKey()
  final String? gnotionCdHcParty;
  @override
  @JsonKey()
  final int? invoicePeriod;
  @override
  @JsonKey()
  final String? careProviderType;
  @override
  @JsonKey()
  final String? internshipNihii;
  @override
  @JsonKey()
  final String? internshipSsin;
  @override
  @JsonKey()
  final String? internshipLastName;
  @override
  @JsonKey()
  final String? internshipFirstName;
  @override
  @JsonKey()
  final String? internshipCdHcParty;
  @override
  @JsonKey()
  final String? internshipCbe;
  @override
  @JsonKey()
  final String? supervisorNihii;
  @override
  @JsonKey()
  final String? supervisorSsin;
  @override
  @JsonKey()
  final String? supervisorLastName;
  @override
  @JsonKey()
  final String? supervisorFirstName;
  @override
  @JsonKey()
  final String? supervisorCdHcParty;
  @override
  @JsonKey()
  final String? supervisorCbe;
  @override
  @JsonKey()
  final String? error;
  @override
  @JsonKey()
  final String? encounterLocationName;
  @override
  @JsonKey()
  final String? encounterLocationNihii;
  @override
  @JsonKey()
  final int? encounterLocationNorm;
  @override
  @JsonKey()
  final int? longDelayJustification;
  @override
  @JsonKey()
  final String? correctiveInvoiceId;
  @override
  @JsonKey()
  final String? correctedInvoiceId;
  @override
  @JsonKey()
  final bool? creditNote;
  @override
  @JsonKey()
  final String? creditNoteRelatedInvoiceId;
  @override
  @JsonKey()
  final IdentityDocumentReader? idDocument;
  @override
  @JsonKey()
  final int? admissionDate;
  @override
  @JsonKey()
  final String? locationNihii;
  @override
  @JsonKey()
  final int? locationService;
  @override
  @JsonKey()
  final String? cancelReason;
  @override
  @JsonKey()
  final int? cancelDate;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
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

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedInvoiceCopyWith<_DecryptedInvoice> get copyWith =>
      __$DecryptedInvoiceCopyWithImpl<_DecryptedInvoice>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedInvoice &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
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
            (identical(other.invoiceDate, invoiceDate) ||
                other.invoiceDate == invoiceDate) &&
            (identical(other.sentDate, sentDate) ||
                other.sentDate == sentDate) &&
            (identical(other.printedDate, printedDate) ||
                other.printedDate == printedDate) &&
            const DeepCollectionEquality()
                .equals(other._invoicingCodes, _invoicingCodes) &&
            const DeepCollectionEquality().equals(other._receipts, _receipts) &&
            (identical(other.recipientType, recipientType) ||
                other.recipientType == recipientType) &&
            (identical(other.recipientId, recipientId) ||
                other.recipientId == recipientId) &&
            (identical(other.invoiceReference, invoiceReference) ||
                other.invoiceReference == invoiceReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.thirdPartyReference, thirdPartyReference) ||
                other.thirdPartyReference == thirdPartyReference) &&
            (identical(other.thirdPartyPaymentJustification, thirdPartyPaymentJustification) ||
                other.thirdPartyPaymentJustification ==
                    thirdPartyPaymentJustification) &&
            (identical(other.thirdPartyPaymentReason, thirdPartyPaymentReason) ||
                other.thirdPartyPaymentReason == thirdPartyPaymentReason) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.invoiceType, invoiceType) ||
                other.invoiceType == invoiceType) &&
            (identical(other.sentMediumType, sentMediumType) ||
                other.sentMediumType == sentMediumType) &&
            (identical(other.interventionType, interventionType) ||
                other.interventionType == interventionType) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            const DeepCollectionEquality().equals(other._payments, _payments) &&
            (identical(other.gnotionNihii, gnotionNihii) ||
                other.gnotionNihii == gnotionNihii) &&
            (identical(other.gnotionSsin, gnotionSsin) ||
                other.gnotionSsin == gnotionSsin) &&
            (identical(other.gnotionLastName, gnotionLastName) ||
                other.gnotionLastName == gnotionLastName) &&
            (identical(other.gnotionFirstName, gnotionFirstName) ||
                other.gnotionFirstName == gnotionFirstName) &&
            (identical(other.gnotionCdHcParty, gnotionCdHcParty) ||
                other.gnotionCdHcParty == gnotionCdHcParty) &&
            (identical(other.invoicePeriod, invoicePeriod) ||
                other.invoicePeriod == invoicePeriod) &&
            (identical(other.careProviderType, careProviderType) ||
                other.careProviderType == careProviderType) &&
            (identical(other.internshipNihii, internshipNihii) ||
                other.internshipNihii == internshipNihii) &&
            (identical(other.internshipSsin, internshipSsin) ||
                other.internshipSsin == internshipSsin) &&
            (identical(other.internshipLastName, internshipLastName) ||
                other.internshipLastName == internshipLastName) &&
            (identical(other.internshipFirstName, internshipFirstName) ||
                other.internshipFirstName == internshipFirstName) &&
            (identical(other.internshipCdHcParty, internshipCdHcParty) ||
                other.internshipCdHcParty == internshipCdHcParty) &&
            (identical(other.internshipCbe, internshipCbe) || other.internshipCbe == internshipCbe) &&
            (identical(other.supervisorNihii, supervisorNihii) || other.supervisorNihii == supervisorNihii) &&
            (identical(other.supervisorSsin, supervisorSsin) || other.supervisorSsin == supervisorSsin) &&
            (identical(other.supervisorLastName, supervisorLastName) || other.supervisorLastName == supervisorLastName) &&
            (identical(other.supervisorFirstName, supervisorFirstName) || other.supervisorFirstName == supervisorFirstName) &&
            (identical(other.supervisorCdHcParty, supervisorCdHcParty) || other.supervisorCdHcParty == supervisorCdHcParty) &&
            (identical(other.supervisorCbe, supervisorCbe) || other.supervisorCbe == supervisorCbe) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.encounterLocationName, encounterLocationName) || other.encounterLocationName == encounterLocationName) &&
            (identical(other.encounterLocationNihii, encounterLocationNihii) || other.encounterLocationNihii == encounterLocationNihii) &&
            (identical(other.encounterLocationNorm, encounterLocationNorm) || other.encounterLocationNorm == encounterLocationNorm) &&
            (identical(other.longDelayJustification, longDelayJustification) || other.longDelayJustification == longDelayJustification) &&
            (identical(other.correctiveInvoiceId, correctiveInvoiceId) || other.correctiveInvoiceId == correctiveInvoiceId) &&
            (identical(other.correctedInvoiceId, correctedInvoiceId) || other.correctedInvoiceId == correctedInvoiceId) &&
            (identical(other.creditNote, creditNote) || other.creditNote == creditNote) &&
            (identical(other.creditNoteRelatedInvoiceId, creditNoteRelatedInvoiceId) || other.creditNoteRelatedInvoiceId == creditNoteRelatedInvoiceId) &&
            (identical(other.idDocument, idDocument) || other.idDocument == idDocument) &&
            (identical(other.admissionDate, admissionDate) || other.admissionDate == admissionDate) &&
            (identical(other.locationNihii, locationNihii) || other.locationNihii == locationNihii) &&
            (identical(other.locationService, locationService) || other.locationService == locationService) &&
            (identical(other.cancelReason, cancelReason) || other.cancelReason == cancelReason) &&
            (identical(other.cancelDate, cancelDate) || other.cancelDate == cancelDate) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality().equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality().equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other._delegations, _delegations) &&
            const DeepCollectionEquality().equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        const DeepCollectionEquality().hash(_identifier),
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        invoiceDate,
        sentDate,
        printedDate,
        const DeepCollectionEquality().hash(_invoicingCodes),
        const DeepCollectionEquality().hash(_receipts),
        recipientType,
        recipientId,
        invoiceReference,
        decisionReference,
        thirdPartyReference,
        thirdPartyPaymentJustification,
        thirdPartyPaymentReason,
        reason,
        invoiceType,
        sentMediumType,
        interventionType,
        groupId,
        paymentType,
        paid,
        const DeepCollectionEquality().hash(_payments),
        gnotionNihii,
        gnotionSsin,
        gnotionLastName,
        gnotionFirstName,
        gnotionCdHcParty,
        invoicePeriod,
        careProviderType,
        internshipNihii,
        internshipSsin,
        internshipLastName,
        internshipFirstName,
        internshipCdHcParty,
        internshipCbe,
        supervisorNihii,
        supervisorSsin,
        supervisorLastName,
        supervisorFirstName,
        supervisorCdHcParty,
        supervisorCbe,
        error,
        encounterLocationName,
        encounterLocationNihii,
        encounterLocationNorm,
        longDelayJustification,
        correctiveInvoiceId,
        correctedInvoiceId,
        creditNote,
        creditNoteRelatedInvoiceId,
        idDocument,
        admissionDate,
        locationNihii,
        locationService,
        cancelReason,
        cancelDate,
        const DeepCollectionEquality().hash(_options),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedInvoice(id: $id, rev: $rev, identifier: $identifier, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, invoiceDate: $invoiceDate, sentDate: $sentDate, printedDate: $printedDate, invoicingCodes: $invoicingCodes, receipts: $receipts, recipientType: $recipientType, recipientId: $recipientId, invoiceReference: $invoiceReference, decisionReference: $decisionReference, thirdPartyReference: $thirdPartyReference, thirdPartyPaymentJustification: $thirdPartyPaymentJustification, thirdPartyPaymentReason: $thirdPartyPaymentReason, reason: $reason, invoiceType: $invoiceType, sentMediumType: $sentMediumType, interventionType: $interventionType, groupId: $groupId, paymentType: $paymentType, paid: $paid, payments: $payments, gnotionNihii: $gnotionNihii, gnotionSsin: $gnotionSsin, gnotionLastName: $gnotionLastName, gnotionFirstName: $gnotionFirstName, gnotionCdHcParty: $gnotionCdHcParty, invoicePeriod: $invoicePeriod, careProviderType: $careProviderType, internshipNihii: $internshipNihii, internshipSsin: $internshipSsin, internshipLastName: $internshipLastName, internshipFirstName: $internshipFirstName, internshipCdHcParty: $internshipCdHcParty, internshipCbe: $internshipCbe, supervisorNihii: $supervisorNihii, supervisorSsin: $supervisorSsin, supervisorLastName: $supervisorLastName, supervisorFirstName: $supervisorFirstName, supervisorCdHcParty: $supervisorCdHcParty, supervisorCbe: $supervisorCbe, error: $error, encounterLocationName: $encounterLocationName, encounterLocationNihii: $encounterLocationNihii, encounterLocationNorm: $encounterLocationNorm, longDelayJustification: $longDelayJustification, correctiveInvoiceId: $correctiveInvoiceId, correctedInvoiceId: $correctedInvoiceId, creditNote: $creditNote, creditNoteRelatedInvoiceId: $creditNoteRelatedInvoiceId, idDocument: $idDocument, admissionDate: $admissionDate, locationNihii: $locationNihii, locationService: $locationService, cancelReason: $cancelReason, cancelDate: $cancelDate, options: $options, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedInvoiceCopyWith<$Res>
    implements $DecryptedInvoiceCopyWith<$Res> {
  factory _$DecryptedInvoiceCopyWith(
          _DecryptedInvoice value, $Res Function(_DecryptedInvoice) _then) =
      __$DecryptedInvoiceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      List<Identifier> identifier,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? invoiceDate,
      int? sentDate,
      int? printedDate,
      List<DecryptedInvoicingCode> invoicingCodes,
      Map<String, String> receipts,
      String? recipientType,
      String? recipientId,
      String? invoiceReference,
      String? decisionReference,
      String? thirdPartyReference,
      String? thirdPartyPaymentJustification,
      String? thirdPartyPaymentReason,
      String? reason,
      InvoiceType? invoiceType,
      MediumType? sentMediumType,
      InvoiceInterventionType? interventionType,
      String? groupId,
      PaymentType? paymentType,
      double? paid,
      List<Payment>? payments,
      String? gnotionNihii,
      String? gnotionSsin,
      String? gnotionLastName,
      String? gnotionFirstName,
      String? gnotionCdHcParty,
      int? invoicePeriod,
      String? careProviderType,
      String? internshipNihii,
      String? internshipSsin,
      String? internshipLastName,
      String? internshipFirstName,
      String? internshipCdHcParty,
      String? internshipCbe,
      String? supervisorNihii,
      String? supervisorSsin,
      String? supervisorLastName,
      String? supervisorFirstName,
      String? supervisorCdHcParty,
      String? supervisorCbe,
      String? error,
      String? encounterLocationName,
      String? encounterLocationNihii,
      int? encounterLocationNorm,
      int? longDelayJustification,
      String? correctiveInvoiceId,
      String? correctedInvoiceId,
      bool? creditNote,
      String? creditNoteRelatedInvoiceId,
      IdentityDocumentReader? idDocument,
      int? admissionDate,
      String? locationNihii,
      int? locationService,
      String? cancelReason,
      int? cancelDate,
      Map<String, String> options,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedInvoiceCopyWithImpl<$Res>
    implements _$DecryptedInvoiceCopyWith<$Res> {
  __$DecryptedInvoiceCopyWithImpl(this._self, this._then);

  final _DecryptedInvoice _self;
  final $Res Function(_DecryptedInvoice) _then;

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? identifier = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? invoiceDate = freezed,
    Object? sentDate = freezed,
    Object? printedDate = freezed,
    Object? invoicingCodes = null,
    Object? receipts = null,
    Object? recipientType = freezed,
    Object? recipientId = freezed,
    Object? invoiceReference = freezed,
    Object? decisionReference = freezed,
    Object? thirdPartyReference = freezed,
    Object? thirdPartyPaymentJustification = freezed,
    Object? thirdPartyPaymentReason = freezed,
    Object? reason = freezed,
    Object? invoiceType = freezed,
    Object? sentMediumType = freezed,
    Object? interventionType = freezed,
    Object? groupId = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? payments = freezed,
    Object? gnotionNihii = freezed,
    Object? gnotionSsin = freezed,
    Object? gnotionLastName = freezed,
    Object? gnotionFirstName = freezed,
    Object? gnotionCdHcParty = freezed,
    Object? invoicePeriod = freezed,
    Object? careProviderType = freezed,
    Object? internshipNihii = freezed,
    Object? internshipSsin = freezed,
    Object? internshipLastName = freezed,
    Object? internshipFirstName = freezed,
    Object? internshipCdHcParty = freezed,
    Object? internshipCbe = freezed,
    Object? supervisorNihii = freezed,
    Object? supervisorSsin = freezed,
    Object? supervisorLastName = freezed,
    Object? supervisorFirstName = freezed,
    Object? supervisorCdHcParty = freezed,
    Object? supervisorCbe = freezed,
    Object? error = freezed,
    Object? encounterLocationName = freezed,
    Object? encounterLocationNihii = freezed,
    Object? encounterLocationNorm = freezed,
    Object? longDelayJustification = freezed,
    Object? correctiveInvoiceId = freezed,
    Object? correctedInvoiceId = freezed,
    Object? creditNote = freezed,
    Object? creditNoteRelatedInvoiceId = freezed,
    Object? idDocument = freezed,
    Object? admissionDate = freezed,
    Object? locationNihii = freezed,
    Object? locationService = freezed,
    Object? cancelReason = freezed,
    Object? cancelDate = freezed,
    Object? options = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedInvoice(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      invoiceDate: freezed == invoiceDate
          ? _self.invoiceDate
          : invoiceDate // ignore: cast_nullable_to_non_nullable
              as int?,
      sentDate: freezed == sentDate
          ? _self.sentDate
          : sentDate // ignore: cast_nullable_to_non_nullable
              as int?,
      printedDate: freezed == printedDate
          ? _self.printedDate
          : printedDate // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self._invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as List<DecryptedInvoicingCode>,
      receipts: null == receipts
          ? _self._receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      recipientType: freezed == recipientType
          ? _self.recipientType
          : recipientType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipientId: freezed == recipientId
          ? _self.recipientId
          : recipientId // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceReference: freezed == invoiceReference
          ? _self.invoiceReference
          : invoiceReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyReference: freezed == thirdPartyReference
          ? _self.thirdPartyReference
          : thirdPartyReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentJustification: freezed == thirdPartyPaymentJustification
          ? _self.thirdPartyPaymentJustification
          : thirdPartyPaymentJustification // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentReason: freezed == thirdPartyPaymentReason
          ? _self.thirdPartyPaymentReason
          : thirdPartyPaymentReason // ignore: cast_nullable_to_non_nullable
              as String?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceType: freezed == invoiceType
          ? _self.invoiceType
          : invoiceType // ignore: cast_nullable_to_non_nullable
              as InvoiceType?,
      sentMediumType: freezed == sentMediumType
          ? _self.sentMediumType
          : sentMediumType // ignore: cast_nullable_to_non_nullable
              as MediumType?,
      interventionType: freezed == interventionType
          ? _self.interventionType
          : interventionType // ignore: cast_nullable_to_non_nullable
              as InvoiceInterventionType?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      payments: freezed == payments
          ? _self._payments
          : payments // ignore: cast_nullable_to_non_nullable
              as List<Payment>?,
      gnotionNihii: freezed == gnotionNihii
          ? _self.gnotionNihii
          : gnotionNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionSsin: freezed == gnotionSsin
          ? _self.gnotionSsin
          : gnotionSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionLastName: freezed == gnotionLastName
          ? _self.gnotionLastName
          : gnotionLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionFirstName: freezed == gnotionFirstName
          ? _self.gnotionFirstName
          : gnotionFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionCdHcParty: freezed == gnotionCdHcParty
          ? _self.gnotionCdHcParty
          : gnotionCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      invoicePeriod: freezed == invoicePeriod
          ? _self.invoicePeriod
          : invoicePeriod // ignore: cast_nullable_to_non_nullable
              as int?,
      careProviderType: freezed == careProviderType
          ? _self.careProviderType
          : careProviderType // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipNihii: freezed == internshipNihii
          ? _self.internshipNihii
          : internshipNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipSsin: freezed == internshipSsin
          ? _self.internshipSsin
          : internshipSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipLastName: freezed == internshipLastName
          ? _self.internshipLastName
          : internshipLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipFirstName: freezed == internshipFirstName
          ? _self.internshipFirstName
          : internshipFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCdHcParty: freezed == internshipCdHcParty
          ? _self.internshipCdHcParty
          : internshipCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCbe: freezed == internshipCbe
          ? _self.internshipCbe
          : internshipCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorNihii: freezed == supervisorNihii
          ? _self.supervisorNihii
          : supervisorNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorSsin: freezed == supervisorSsin
          ? _self.supervisorSsin
          : supervisorSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorLastName: freezed == supervisorLastName
          ? _self.supervisorLastName
          : supervisorLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorFirstName: freezed == supervisorFirstName
          ? _self.supervisorFirstName
          : supervisorFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCdHcParty: freezed == supervisorCdHcParty
          ? _self.supervisorCdHcParty
          : supervisorCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCbe: freezed == supervisorCbe
          ? _self.supervisorCbe
          : supervisorCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationName: freezed == encounterLocationName
          ? _self.encounterLocationName
          : encounterLocationName // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNihii: freezed == encounterLocationNihii
          ? _self.encounterLocationNihii
          : encounterLocationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNorm: freezed == encounterLocationNorm
          ? _self.encounterLocationNorm
          : encounterLocationNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      longDelayJustification: freezed == longDelayJustification
          ? _self.longDelayJustification
          : longDelayJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      correctiveInvoiceId: freezed == correctiveInvoiceId
          ? _self.correctiveInvoiceId
          : correctiveInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      correctedInvoiceId: freezed == correctedInvoiceId
          ? _self.correctedInvoiceId
          : correctedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      creditNote: freezed == creditNote
          ? _self.creditNote
          : creditNote // ignore: cast_nullable_to_non_nullable
              as bool?,
      creditNoteRelatedInvoiceId: freezed == creditNoteRelatedInvoiceId
          ? _self.creditNoteRelatedInvoiceId
          : creditNoteRelatedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      idDocument: freezed == idDocument
          ? _self.idDocument
          : idDocument // ignore: cast_nullable_to_non_nullable
              as IdentityDocumentReader?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelReason: freezed == cancelReason
          ? _self.cancelReason
          : cancelReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelDate: freezed == cancelDate
          ? _self.cancelDate
          : cancelDate // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
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

  /// Create a copy of DecryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument {
    if (_self.idDocument == null) {
      return null;
    }

    return $IdentityDocumentReaderCopyWith<$Res>(_self.idDocument!, (value) {
      return _then(_self.copyWith(idDocument: value));
    });
  }

  /// Create a copy of DecryptedInvoice
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
mixin _$EncryptedInvoice {
  String get id;
  String? get rev;
  List<Identifier> get identifier;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  int? get invoiceDate;
  int? get sentDate;
  int? get printedDate;
  List<EncryptedInvoicingCode> get invoicingCodes;
  Map<String, String> get receipts;
  String? get recipientType;
  String? get recipientId;
  String? get invoiceReference;
  String? get decisionReference;
  String? get thirdPartyReference;
  String? get thirdPartyPaymentJustification;
  String? get thirdPartyPaymentReason;
  String? get reason;
  InvoiceType? get invoiceType;
  MediumType? get sentMediumType;
  InvoiceInterventionType? get interventionType;
  String? get groupId;
  PaymentType? get paymentType;
  double? get paid;
  List<Payment>? get payments;
  String? get gnotionNihii;
  String? get gnotionSsin;
  String? get gnotionLastName;
  String? get gnotionFirstName;
  String? get gnotionCdHcParty;
  int? get invoicePeriod;
  String? get careProviderType;
  String? get internshipNihii;
  String? get internshipSsin;
  String? get internshipLastName;
  String? get internshipFirstName;
  String? get internshipCdHcParty;
  String? get internshipCbe;
  String? get supervisorNihii;
  String? get supervisorSsin;
  String? get supervisorLastName;
  String? get supervisorFirstName;
  String? get supervisorCdHcParty;
  String? get supervisorCbe;
  String? get error;
  String? get encounterLocationName;
  String? get encounterLocationNihii;
  int? get encounterLocationNorm;
  int? get longDelayJustification;
  String? get correctiveInvoiceId;
  String? get correctedInvoiceId;
  bool? get creditNote;
  String? get creditNoteRelatedInvoiceId;
  IdentityDocumentReader? get idDocument;
  int? get admissionDate;
  String? get locationNihii;
  int? get locationService;
  String? get cancelReason;
  int? get cancelDate;
  Map<String, String> get options;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedInvoiceCopyWith<EncryptedInvoice> get copyWith =>
      _$EncryptedInvoiceCopyWithImpl<EncryptedInvoice>(
          this as EncryptedInvoice, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedInvoice &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
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
            (identical(other.invoiceDate, invoiceDate) ||
                other.invoiceDate == invoiceDate) &&
            (identical(other.sentDate, sentDate) ||
                other.sentDate == sentDate) &&
            (identical(other.printedDate, printedDate) ||
                other.printedDate == printedDate) &&
            const DeepCollectionEquality()
                .equals(other.invoicingCodes, invoicingCodes) &&
            const DeepCollectionEquality().equals(other.receipts, receipts) &&
            (identical(other.recipientType, recipientType) ||
                other.recipientType == recipientType) &&
            (identical(other.recipientId, recipientId) ||
                other.recipientId == recipientId) &&
            (identical(other.invoiceReference, invoiceReference) ||
                other.invoiceReference == invoiceReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.thirdPartyReference, thirdPartyReference) ||
                other.thirdPartyReference == thirdPartyReference) &&
            (identical(other.thirdPartyPaymentJustification, thirdPartyPaymentJustification) ||
                other.thirdPartyPaymentJustification ==
                    thirdPartyPaymentJustification) &&
            (identical(other.thirdPartyPaymentReason, thirdPartyPaymentReason) ||
                other.thirdPartyPaymentReason == thirdPartyPaymentReason) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.invoiceType, invoiceType) ||
                other.invoiceType == invoiceType) &&
            (identical(other.sentMediumType, sentMediumType) ||
                other.sentMediumType == sentMediumType) &&
            (identical(other.interventionType, interventionType) ||
                other.interventionType == interventionType) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            const DeepCollectionEquality().equals(other.payments, payments) &&
            (identical(other.gnotionNihii, gnotionNihii) ||
                other.gnotionNihii == gnotionNihii) &&
            (identical(other.gnotionSsin, gnotionSsin) ||
                other.gnotionSsin == gnotionSsin) &&
            (identical(other.gnotionLastName, gnotionLastName) ||
                other.gnotionLastName == gnotionLastName) &&
            (identical(other.gnotionFirstName, gnotionFirstName) ||
                other.gnotionFirstName == gnotionFirstName) &&
            (identical(other.gnotionCdHcParty, gnotionCdHcParty) ||
                other.gnotionCdHcParty == gnotionCdHcParty) &&
            (identical(other.invoicePeriod, invoicePeriod) ||
                other.invoicePeriod == invoicePeriod) &&
            (identical(other.careProviderType, careProviderType) ||
                other.careProviderType == careProviderType) &&
            (identical(other.internshipNihii, internshipNihii) ||
                other.internshipNihii == internshipNihii) &&
            (identical(other.internshipSsin, internshipSsin) ||
                other.internshipSsin == internshipSsin) &&
            (identical(other.internshipLastName, internshipLastName) ||
                other.internshipLastName == internshipLastName) &&
            (identical(other.internshipFirstName, internshipFirstName) ||
                other.internshipFirstName == internshipFirstName) &&
            (identical(other.internshipCdHcParty, internshipCdHcParty) ||
                other.internshipCdHcParty == internshipCdHcParty) &&
            (identical(other.internshipCbe, internshipCbe) || other.internshipCbe == internshipCbe) &&
            (identical(other.supervisorNihii, supervisorNihii) || other.supervisorNihii == supervisorNihii) &&
            (identical(other.supervisorSsin, supervisorSsin) || other.supervisorSsin == supervisorSsin) &&
            (identical(other.supervisorLastName, supervisorLastName) || other.supervisorLastName == supervisorLastName) &&
            (identical(other.supervisorFirstName, supervisorFirstName) || other.supervisorFirstName == supervisorFirstName) &&
            (identical(other.supervisorCdHcParty, supervisorCdHcParty) || other.supervisorCdHcParty == supervisorCdHcParty) &&
            (identical(other.supervisorCbe, supervisorCbe) || other.supervisorCbe == supervisorCbe) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.encounterLocationName, encounterLocationName) || other.encounterLocationName == encounterLocationName) &&
            (identical(other.encounterLocationNihii, encounterLocationNihii) || other.encounterLocationNihii == encounterLocationNihii) &&
            (identical(other.encounterLocationNorm, encounterLocationNorm) || other.encounterLocationNorm == encounterLocationNorm) &&
            (identical(other.longDelayJustification, longDelayJustification) || other.longDelayJustification == longDelayJustification) &&
            (identical(other.correctiveInvoiceId, correctiveInvoiceId) || other.correctiveInvoiceId == correctiveInvoiceId) &&
            (identical(other.correctedInvoiceId, correctedInvoiceId) || other.correctedInvoiceId == correctedInvoiceId) &&
            (identical(other.creditNote, creditNote) || other.creditNote == creditNote) &&
            (identical(other.creditNoteRelatedInvoiceId, creditNoteRelatedInvoiceId) || other.creditNoteRelatedInvoiceId == creditNoteRelatedInvoiceId) &&
            (identical(other.idDocument, idDocument) || other.idDocument == idDocument) &&
            (identical(other.admissionDate, admissionDate) || other.admissionDate == admissionDate) &&
            (identical(other.locationNihii, locationNihii) || other.locationNihii == locationNihii) &&
            (identical(other.locationService, locationService) || other.locationService == locationService) &&
            (identical(other.cancelReason, cancelReason) || other.cancelReason == cancelReason) &&
            (identical(other.cancelDate, cancelDate) || other.cancelDate == cancelDate) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality().equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality().equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other.delegations, delegations) &&
            const DeepCollectionEquality().equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        const DeepCollectionEquality().hash(identifier),
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        invoiceDate,
        sentDate,
        printedDate,
        const DeepCollectionEquality().hash(invoicingCodes),
        const DeepCollectionEquality().hash(receipts),
        recipientType,
        recipientId,
        invoiceReference,
        decisionReference,
        thirdPartyReference,
        thirdPartyPaymentJustification,
        thirdPartyPaymentReason,
        reason,
        invoiceType,
        sentMediumType,
        interventionType,
        groupId,
        paymentType,
        paid,
        const DeepCollectionEquality().hash(payments),
        gnotionNihii,
        gnotionSsin,
        gnotionLastName,
        gnotionFirstName,
        gnotionCdHcParty,
        invoicePeriod,
        careProviderType,
        internshipNihii,
        internshipSsin,
        internshipLastName,
        internshipFirstName,
        internshipCdHcParty,
        internshipCbe,
        supervisorNihii,
        supervisorSsin,
        supervisorLastName,
        supervisorFirstName,
        supervisorCdHcParty,
        supervisorCbe,
        error,
        encounterLocationName,
        encounterLocationNihii,
        encounterLocationNorm,
        longDelayJustification,
        correctiveInvoiceId,
        correctedInvoiceId,
        creditNote,
        creditNoteRelatedInvoiceId,
        idDocument,
        admissionDate,
        locationNihii,
        locationService,
        cancelReason,
        cancelDate,
        const DeepCollectionEquality().hash(options),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedInvoice(id: $id, rev: $rev, identifier: $identifier, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, invoiceDate: $invoiceDate, sentDate: $sentDate, printedDate: $printedDate, invoicingCodes: $invoicingCodes, receipts: $receipts, recipientType: $recipientType, recipientId: $recipientId, invoiceReference: $invoiceReference, decisionReference: $decisionReference, thirdPartyReference: $thirdPartyReference, thirdPartyPaymentJustification: $thirdPartyPaymentJustification, thirdPartyPaymentReason: $thirdPartyPaymentReason, reason: $reason, invoiceType: $invoiceType, sentMediumType: $sentMediumType, interventionType: $interventionType, groupId: $groupId, paymentType: $paymentType, paid: $paid, payments: $payments, gnotionNihii: $gnotionNihii, gnotionSsin: $gnotionSsin, gnotionLastName: $gnotionLastName, gnotionFirstName: $gnotionFirstName, gnotionCdHcParty: $gnotionCdHcParty, invoicePeriod: $invoicePeriod, careProviderType: $careProviderType, internshipNihii: $internshipNihii, internshipSsin: $internshipSsin, internshipLastName: $internshipLastName, internshipFirstName: $internshipFirstName, internshipCdHcParty: $internshipCdHcParty, internshipCbe: $internshipCbe, supervisorNihii: $supervisorNihii, supervisorSsin: $supervisorSsin, supervisorLastName: $supervisorLastName, supervisorFirstName: $supervisorFirstName, supervisorCdHcParty: $supervisorCdHcParty, supervisorCbe: $supervisorCbe, error: $error, encounterLocationName: $encounterLocationName, encounterLocationNihii: $encounterLocationNihii, encounterLocationNorm: $encounterLocationNorm, longDelayJustification: $longDelayJustification, correctiveInvoiceId: $correctiveInvoiceId, correctedInvoiceId: $correctedInvoiceId, creditNote: $creditNote, creditNoteRelatedInvoiceId: $creditNoteRelatedInvoiceId, idDocument: $idDocument, admissionDate: $admissionDate, locationNihii: $locationNihii, locationService: $locationService, cancelReason: $cancelReason, cancelDate: $cancelDate, options: $options, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedInvoiceCopyWith<$Res> {
  factory $EncryptedInvoiceCopyWith(
          EncryptedInvoice value, $Res Function(EncryptedInvoice) _then) =
      _$EncryptedInvoiceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      List<Identifier> identifier,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? invoiceDate,
      int? sentDate,
      int? printedDate,
      List<EncryptedInvoicingCode> invoicingCodes,
      Map<String, String> receipts,
      String? recipientType,
      String? recipientId,
      String? invoiceReference,
      String? decisionReference,
      String? thirdPartyReference,
      String? thirdPartyPaymentJustification,
      String? thirdPartyPaymentReason,
      String? reason,
      InvoiceType? invoiceType,
      MediumType? sentMediumType,
      InvoiceInterventionType? interventionType,
      String? groupId,
      PaymentType? paymentType,
      double? paid,
      List<Payment>? payments,
      String? gnotionNihii,
      String? gnotionSsin,
      String? gnotionLastName,
      String? gnotionFirstName,
      String? gnotionCdHcParty,
      int? invoicePeriod,
      String? careProviderType,
      String? internshipNihii,
      String? internshipSsin,
      String? internshipLastName,
      String? internshipFirstName,
      String? internshipCdHcParty,
      String? internshipCbe,
      String? supervisorNihii,
      String? supervisorSsin,
      String? supervisorLastName,
      String? supervisorFirstName,
      String? supervisorCdHcParty,
      String? supervisorCbe,
      String? error,
      String? encounterLocationName,
      String? encounterLocationNihii,
      int? encounterLocationNorm,
      int? longDelayJustification,
      String? correctiveInvoiceId,
      String? correctedInvoiceId,
      bool? creditNote,
      String? creditNoteRelatedInvoiceId,
      IdentityDocumentReader? idDocument,
      int? admissionDate,
      String? locationNihii,
      int? locationService,
      String? cancelReason,
      int? cancelDate,
      Map<String, String> options,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $IdentityDocumentReaderCopyWith<$Res>? get idDocument;
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedInvoiceCopyWithImpl<$Res>
    implements $EncryptedInvoiceCopyWith<$Res> {
  _$EncryptedInvoiceCopyWithImpl(this._self, this._then);

  final EncryptedInvoice _self;
  final $Res Function(EncryptedInvoice) _then;

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? identifier = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? invoiceDate = freezed,
    Object? sentDate = freezed,
    Object? printedDate = freezed,
    Object? invoicingCodes = null,
    Object? receipts = null,
    Object? recipientType = freezed,
    Object? recipientId = freezed,
    Object? invoiceReference = freezed,
    Object? decisionReference = freezed,
    Object? thirdPartyReference = freezed,
    Object? thirdPartyPaymentJustification = freezed,
    Object? thirdPartyPaymentReason = freezed,
    Object? reason = freezed,
    Object? invoiceType = freezed,
    Object? sentMediumType = freezed,
    Object? interventionType = freezed,
    Object? groupId = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? payments = freezed,
    Object? gnotionNihii = freezed,
    Object? gnotionSsin = freezed,
    Object? gnotionLastName = freezed,
    Object? gnotionFirstName = freezed,
    Object? gnotionCdHcParty = freezed,
    Object? invoicePeriod = freezed,
    Object? careProviderType = freezed,
    Object? internshipNihii = freezed,
    Object? internshipSsin = freezed,
    Object? internshipLastName = freezed,
    Object? internshipFirstName = freezed,
    Object? internshipCdHcParty = freezed,
    Object? internshipCbe = freezed,
    Object? supervisorNihii = freezed,
    Object? supervisorSsin = freezed,
    Object? supervisorLastName = freezed,
    Object? supervisorFirstName = freezed,
    Object? supervisorCdHcParty = freezed,
    Object? supervisorCbe = freezed,
    Object? error = freezed,
    Object? encounterLocationName = freezed,
    Object? encounterLocationNihii = freezed,
    Object? encounterLocationNorm = freezed,
    Object? longDelayJustification = freezed,
    Object? correctiveInvoiceId = freezed,
    Object? correctedInvoiceId = freezed,
    Object? creditNote = freezed,
    Object? creditNoteRelatedInvoiceId = freezed,
    Object? idDocument = freezed,
    Object? admissionDate = freezed,
    Object? locationNihii = freezed,
    Object? locationService = freezed,
    Object? cancelReason = freezed,
    Object? cancelDate = freezed,
    Object? options = null,
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
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      invoiceDate: freezed == invoiceDate
          ? _self.invoiceDate
          : invoiceDate // ignore: cast_nullable_to_non_nullable
              as int?,
      sentDate: freezed == sentDate
          ? _self.sentDate
          : sentDate // ignore: cast_nullable_to_non_nullable
              as int?,
      printedDate: freezed == printedDate
          ? _self.printedDate
          : printedDate // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self.invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as List<EncryptedInvoicingCode>,
      receipts: null == receipts
          ? _self.receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      recipientType: freezed == recipientType
          ? _self.recipientType
          : recipientType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipientId: freezed == recipientId
          ? _self.recipientId
          : recipientId // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceReference: freezed == invoiceReference
          ? _self.invoiceReference
          : invoiceReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyReference: freezed == thirdPartyReference
          ? _self.thirdPartyReference
          : thirdPartyReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentJustification: freezed == thirdPartyPaymentJustification
          ? _self.thirdPartyPaymentJustification
          : thirdPartyPaymentJustification // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentReason: freezed == thirdPartyPaymentReason
          ? _self.thirdPartyPaymentReason
          : thirdPartyPaymentReason // ignore: cast_nullable_to_non_nullable
              as String?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceType: freezed == invoiceType
          ? _self.invoiceType
          : invoiceType // ignore: cast_nullable_to_non_nullable
              as InvoiceType?,
      sentMediumType: freezed == sentMediumType
          ? _self.sentMediumType
          : sentMediumType // ignore: cast_nullable_to_non_nullable
              as MediumType?,
      interventionType: freezed == interventionType
          ? _self.interventionType
          : interventionType // ignore: cast_nullable_to_non_nullable
              as InvoiceInterventionType?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      payments: freezed == payments
          ? _self.payments
          : payments // ignore: cast_nullable_to_non_nullable
              as List<Payment>?,
      gnotionNihii: freezed == gnotionNihii
          ? _self.gnotionNihii
          : gnotionNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionSsin: freezed == gnotionSsin
          ? _self.gnotionSsin
          : gnotionSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionLastName: freezed == gnotionLastName
          ? _self.gnotionLastName
          : gnotionLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionFirstName: freezed == gnotionFirstName
          ? _self.gnotionFirstName
          : gnotionFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionCdHcParty: freezed == gnotionCdHcParty
          ? _self.gnotionCdHcParty
          : gnotionCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      invoicePeriod: freezed == invoicePeriod
          ? _self.invoicePeriod
          : invoicePeriod // ignore: cast_nullable_to_non_nullable
              as int?,
      careProviderType: freezed == careProviderType
          ? _self.careProviderType
          : careProviderType // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipNihii: freezed == internshipNihii
          ? _self.internshipNihii
          : internshipNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipSsin: freezed == internshipSsin
          ? _self.internshipSsin
          : internshipSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipLastName: freezed == internshipLastName
          ? _self.internshipLastName
          : internshipLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipFirstName: freezed == internshipFirstName
          ? _self.internshipFirstName
          : internshipFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCdHcParty: freezed == internshipCdHcParty
          ? _self.internshipCdHcParty
          : internshipCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCbe: freezed == internshipCbe
          ? _self.internshipCbe
          : internshipCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorNihii: freezed == supervisorNihii
          ? _self.supervisorNihii
          : supervisorNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorSsin: freezed == supervisorSsin
          ? _self.supervisorSsin
          : supervisorSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorLastName: freezed == supervisorLastName
          ? _self.supervisorLastName
          : supervisorLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorFirstName: freezed == supervisorFirstName
          ? _self.supervisorFirstName
          : supervisorFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCdHcParty: freezed == supervisorCdHcParty
          ? _self.supervisorCdHcParty
          : supervisorCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCbe: freezed == supervisorCbe
          ? _self.supervisorCbe
          : supervisorCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationName: freezed == encounterLocationName
          ? _self.encounterLocationName
          : encounterLocationName // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNihii: freezed == encounterLocationNihii
          ? _self.encounterLocationNihii
          : encounterLocationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNorm: freezed == encounterLocationNorm
          ? _self.encounterLocationNorm
          : encounterLocationNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      longDelayJustification: freezed == longDelayJustification
          ? _self.longDelayJustification
          : longDelayJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      correctiveInvoiceId: freezed == correctiveInvoiceId
          ? _self.correctiveInvoiceId
          : correctiveInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      correctedInvoiceId: freezed == correctedInvoiceId
          ? _self.correctedInvoiceId
          : correctedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      creditNote: freezed == creditNote
          ? _self.creditNote
          : creditNote // ignore: cast_nullable_to_non_nullable
              as bool?,
      creditNoteRelatedInvoiceId: freezed == creditNoteRelatedInvoiceId
          ? _self.creditNoteRelatedInvoiceId
          : creditNoteRelatedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      idDocument: freezed == idDocument
          ? _self.idDocument
          : idDocument // ignore: cast_nullable_to_non_nullable
              as IdentityDocumentReader?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelReason: freezed == cancelReason
          ? _self.cancelReason
          : cancelReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelDate: freezed == cancelDate
          ? _self.cancelDate
          : cancelDate // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
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

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument {
    if (_self.idDocument == null) {
      return null;
    }

    return $IdentityDocumentReaderCopyWith<$Res>(_self.idDocument!, (value) {
      return _then(_self.copyWith(idDocument: value));
    });
  }

  /// Create a copy of EncryptedInvoice
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

class _EncryptedInvoice implements EncryptedInvoice {
  const _EncryptedInvoice(
      {required this.id,
      this.rev = null,
      final List<Identifier> identifier = const [],
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.invoiceDate = null,
      this.sentDate = null,
      this.printedDate = null,
      final List<EncryptedInvoicingCode> invoicingCodes = const [],
      final Map<String, String> receipts = const {},
      this.recipientType = null,
      this.recipientId = null,
      this.invoiceReference = null,
      this.decisionReference = null,
      this.thirdPartyReference = null,
      this.thirdPartyPaymentJustification = null,
      this.thirdPartyPaymentReason = null,
      this.reason = null,
      this.invoiceType = null,
      this.sentMediumType = null,
      this.interventionType = null,
      this.groupId = null,
      this.paymentType = null,
      this.paid = null,
      final List<Payment>? payments = null,
      this.gnotionNihii = null,
      this.gnotionSsin = null,
      this.gnotionLastName = null,
      this.gnotionFirstName = null,
      this.gnotionCdHcParty = null,
      this.invoicePeriod = null,
      this.careProviderType = null,
      this.internshipNihii = null,
      this.internshipSsin = null,
      this.internshipLastName = null,
      this.internshipFirstName = null,
      this.internshipCdHcParty = null,
      this.internshipCbe = null,
      this.supervisorNihii = null,
      this.supervisorSsin = null,
      this.supervisorLastName = null,
      this.supervisorFirstName = null,
      this.supervisorCdHcParty = null,
      this.supervisorCbe = null,
      this.error = null,
      this.encounterLocationName = null,
      this.encounterLocationNihii = null,
      this.encounterLocationNorm = null,
      this.longDelayJustification = null,
      this.correctiveInvoiceId = null,
      this.correctedInvoiceId = null,
      this.creditNote = null,
      this.creditNoteRelatedInvoiceId = null,
      this.idDocument = null,
      this.admissionDate = null,
      this.locationNihii = null,
      this.locationService = null,
      this.cancelReason = null,
      this.cancelDate = null,
      final Map<String, String> options = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifier = identifier,
        _tags = tags,
        _codes = codes,
        _invoicingCodes = invoicingCodes,
        _receipts = receipts,
        _payments = payments,
        _options = options,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
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
  final int? invoiceDate;
  @override
  @JsonKey()
  final int? sentDate;
  @override
  @JsonKey()
  final int? printedDate;
  final List<EncryptedInvoicingCode> _invoicingCodes;
  @override
  @JsonKey()
  List<EncryptedInvoicingCode> get invoicingCodes {
    if (_invoicingCodes is EqualUnmodifiableListView) return _invoicingCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_invoicingCodes);
  }

  final Map<String, String> _receipts;
  @override
  @JsonKey()
  Map<String, String> get receipts {
    if (_receipts is EqualUnmodifiableMapView) return _receipts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_receipts);
  }

  @override
  @JsonKey()
  final String? recipientType;
  @override
  @JsonKey()
  final String? recipientId;
  @override
  @JsonKey()
  final String? invoiceReference;
  @override
  @JsonKey()
  final String? decisionReference;
  @override
  @JsonKey()
  final String? thirdPartyReference;
  @override
  @JsonKey()
  final String? thirdPartyPaymentJustification;
  @override
  @JsonKey()
  final String? thirdPartyPaymentReason;
  @override
  @JsonKey()
  final String? reason;
  @override
  @JsonKey()
  final InvoiceType? invoiceType;
  @override
  @JsonKey()
  final MediumType? sentMediumType;
  @override
  @JsonKey()
  final InvoiceInterventionType? interventionType;
  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final PaymentType? paymentType;
  @override
  @JsonKey()
  final double? paid;
  final List<Payment>? _payments;
  @override
  @JsonKey()
  List<Payment>? get payments {
    final value = _payments;
    if (value == null) return null;
    if (_payments is EqualUnmodifiableListView) return _payments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? gnotionNihii;
  @override
  @JsonKey()
  final String? gnotionSsin;
  @override
  @JsonKey()
  final String? gnotionLastName;
  @override
  @JsonKey()
  final String? gnotionFirstName;
  @override
  @JsonKey()
  final String? gnotionCdHcParty;
  @override
  @JsonKey()
  final int? invoicePeriod;
  @override
  @JsonKey()
  final String? careProviderType;
  @override
  @JsonKey()
  final String? internshipNihii;
  @override
  @JsonKey()
  final String? internshipSsin;
  @override
  @JsonKey()
  final String? internshipLastName;
  @override
  @JsonKey()
  final String? internshipFirstName;
  @override
  @JsonKey()
  final String? internshipCdHcParty;
  @override
  @JsonKey()
  final String? internshipCbe;
  @override
  @JsonKey()
  final String? supervisorNihii;
  @override
  @JsonKey()
  final String? supervisorSsin;
  @override
  @JsonKey()
  final String? supervisorLastName;
  @override
  @JsonKey()
  final String? supervisorFirstName;
  @override
  @JsonKey()
  final String? supervisorCdHcParty;
  @override
  @JsonKey()
  final String? supervisorCbe;
  @override
  @JsonKey()
  final String? error;
  @override
  @JsonKey()
  final String? encounterLocationName;
  @override
  @JsonKey()
  final String? encounterLocationNihii;
  @override
  @JsonKey()
  final int? encounterLocationNorm;
  @override
  @JsonKey()
  final int? longDelayJustification;
  @override
  @JsonKey()
  final String? correctiveInvoiceId;
  @override
  @JsonKey()
  final String? correctedInvoiceId;
  @override
  @JsonKey()
  final bool? creditNote;
  @override
  @JsonKey()
  final String? creditNoteRelatedInvoiceId;
  @override
  @JsonKey()
  final IdentityDocumentReader? idDocument;
  @override
  @JsonKey()
  final int? admissionDate;
  @override
  @JsonKey()
  final String? locationNihii;
  @override
  @JsonKey()
  final int? locationService;
  @override
  @JsonKey()
  final String? cancelReason;
  @override
  @JsonKey()
  final int? cancelDate;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
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

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedInvoiceCopyWith<_EncryptedInvoice> get copyWith =>
      __$EncryptedInvoiceCopyWithImpl<_EncryptedInvoice>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedInvoice &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
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
            (identical(other.invoiceDate, invoiceDate) ||
                other.invoiceDate == invoiceDate) &&
            (identical(other.sentDate, sentDate) ||
                other.sentDate == sentDate) &&
            (identical(other.printedDate, printedDate) ||
                other.printedDate == printedDate) &&
            const DeepCollectionEquality()
                .equals(other._invoicingCodes, _invoicingCodes) &&
            const DeepCollectionEquality().equals(other._receipts, _receipts) &&
            (identical(other.recipientType, recipientType) ||
                other.recipientType == recipientType) &&
            (identical(other.recipientId, recipientId) ||
                other.recipientId == recipientId) &&
            (identical(other.invoiceReference, invoiceReference) ||
                other.invoiceReference == invoiceReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.thirdPartyReference, thirdPartyReference) ||
                other.thirdPartyReference == thirdPartyReference) &&
            (identical(other.thirdPartyPaymentJustification, thirdPartyPaymentJustification) ||
                other.thirdPartyPaymentJustification ==
                    thirdPartyPaymentJustification) &&
            (identical(other.thirdPartyPaymentReason, thirdPartyPaymentReason) ||
                other.thirdPartyPaymentReason == thirdPartyPaymentReason) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.invoiceType, invoiceType) ||
                other.invoiceType == invoiceType) &&
            (identical(other.sentMediumType, sentMediumType) ||
                other.sentMediumType == sentMediumType) &&
            (identical(other.interventionType, interventionType) ||
                other.interventionType == interventionType) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid) &&
            const DeepCollectionEquality().equals(other._payments, _payments) &&
            (identical(other.gnotionNihii, gnotionNihii) ||
                other.gnotionNihii == gnotionNihii) &&
            (identical(other.gnotionSsin, gnotionSsin) ||
                other.gnotionSsin == gnotionSsin) &&
            (identical(other.gnotionLastName, gnotionLastName) ||
                other.gnotionLastName == gnotionLastName) &&
            (identical(other.gnotionFirstName, gnotionFirstName) ||
                other.gnotionFirstName == gnotionFirstName) &&
            (identical(other.gnotionCdHcParty, gnotionCdHcParty) ||
                other.gnotionCdHcParty == gnotionCdHcParty) &&
            (identical(other.invoicePeriod, invoicePeriod) ||
                other.invoicePeriod == invoicePeriod) &&
            (identical(other.careProviderType, careProviderType) ||
                other.careProviderType == careProviderType) &&
            (identical(other.internshipNihii, internshipNihii) ||
                other.internshipNihii == internshipNihii) &&
            (identical(other.internshipSsin, internshipSsin) ||
                other.internshipSsin == internshipSsin) &&
            (identical(other.internshipLastName, internshipLastName) ||
                other.internshipLastName == internshipLastName) &&
            (identical(other.internshipFirstName, internshipFirstName) ||
                other.internshipFirstName == internshipFirstName) &&
            (identical(other.internshipCdHcParty, internshipCdHcParty) ||
                other.internshipCdHcParty == internshipCdHcParty) &&
            (identical(other.internshipCbe, internshipCbe) || other.internshipCbe == internshipCbe) &&
            (identical(other.supervisorNihii, supervisorNihii) || other.supervisorNihii == supervisorNihii) &&
            (identical(other.supervisorSsin, supervisorSsin) || other.supervisorSsin == supervisorSsin) &&
            (identical(other.supervisorLastName, supervisorLastName) || other.supervisorLastName == supervisorLastName) &&
            (identical(other.supervisorFirstName, supervisorFirstName) || other.supervisorFirstName == supervisorFirstName) &&
            (identical(other.supervisorCdHcParty, supervisorCdHcParty) || other.supervisorCdHcParty == supervisorCdHcParty) &&
            (identical(other.supervisorCbe, supervisorCbe) || other.supervisorCbe == supervisorCbe) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.encounterLocationName, encounterLocationName) || other.encounterLocationName == encounterLocationName) &&
            (identical(other.encounterLocationNihii, encounterLocationNihii) || other.encounterLocationNihii == encounterLocationNihii) &&
            (identical(other.encounterLocationNorm, encounterLocationNorm) || other.encounterLocationNorm == encounterLocationNorm) &&
            (identical(other.longDelayJustification, longDelayJustification) || other.longDelayJustification == longDelayJustification) &&
            (identical(other.correctiveInvoiceId, correctiveInvoiceId) || other.correctiveInvoiceId == correctiveInvoiceId) &&
            (identical(other.correctedInvoiceId, correctedInvoiceId) || other.correctedInvoiceId == correctedInvoiceId) &&
            (identical(other.creditNote, creditNote) || other.creditNote == creditNote) &&
            (identical(other.creditNoteRelatedInvoiceId, creditNoteRelatedInvoiceId) || other.creditNoteRelatedInvoiceId == creditNoteRelatedInvoiceId) &&
            (identical(other.idDocument, idDocument) || other.idDocument == idDocument) &&
            (identical(other.admissionDate, admissionDate) || other.admissionDate == admissionDate) &&
            (identical(other.locationNihii, locationNihii) || other.locationNihii == locationNihii) &&
            (identical(other.locationService, locationService) || other.locationService == locationService) &&
            (identical(other.cancelReason, cancelReason) || other.cancelReason == cancelReason) &&
            (identical(other.cancelDate, cancelDate) || other.cancelDate == cancelDate) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality().equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality().equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality().equals(other._delegations, _delegations) &&
            const DeepCollectionEquality().equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) || other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) || other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        const DeepCollectionEquality().hash(_identifier),
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        invoiceDate,
        sentDate,
        printedDate,
        const DeepCollectionEquality().hash(_invoicingCodes),
        const DeepCollectionEquality().hash(_receipts),
        recipientType,
        recipientId,
        invoiceReference,
        decisionReference,
        thirdPartyReference,
        thirdPartyPaymentJustification,
        thirdPartyPaymentReason,
        reason,
        invoiceType,
        sentMediumType,
        interventionType,
        groupId,
        paymentType,
        paid,
        const DeepCollectionEquality().hash(_payments),
        gnotionNihii,
        gnotionSsin,
        gnotionLastName,
        gnotionFirstName,
        gnotionCdHcParty,
        invoicePeriod,
        careProviderType,
        internshipNihii,
        internshipSsin,
        internshipLastName,
        internshipFirstName,
        internshipCdHcParty,
        internshipCbe,
        supervisorNihii,
        supervisorSsin,
        supervisorLastName,
        supervisorFirstName,
        supervisorCdHcParty,
        supervisorCbe,
        error,
        encounterLocationName,
        encounterLocationNihii,
        encounterLocationNorm,
        longDelayJustification,
        correctiveInvoiceId,
        correctedInvoiceId,
        creditNote,
        creditNoteRelatedInvoiceId,
        idDocument,
        admissionDate,
        locationNihii,
        locationService,
        cancelReason,
        cancelDate,
        const DeepCollectionEquality().hash(_options),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedInvoice(id: $id, rev: $rev, identifier: $identifier, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, invoiceDate: $invoiceDate, sentDate: $sentDate, printedDate: $printedDate, invoicingCodes: $invoicingCodes, receipts: $receipts, recipientType: $recipientType, recipientId: $recipientId, invoiceReference: $invoiceReference, decisionReference: $decisionReference, thirdPartyReference: $thirdPartyReference, thirdPartyPaymentJustification: $thirdPartyPaymentJustification, thirdPartyPaymentReason: $thirdPartyPaymentReason, reason: $reason, invoiceType: $invoiceType, sentMediumType: $sentMediumType, interventionType: $interventionType, groupId: $groupId, paymentType: $paymentType, paid: $paid, payments: $payments, gnotionNihii: $gnotionNihii, gnotionSsin: $gnotionSsin, gnotionLastName: $gnotionLastName, gnotionFirstName: $gnotionFirstName, gnotionCdHcParty: $gnotionCdHcParty, invoicePeriod: $invoicePeriod, careProviderType: $careProviderType, internshipNihii: $internshipNihii, internshipSsin: $internshipSsin, internshipLastName: $internshipLastName, internshipFirstName: $internshipFirstName, internshipCdHcParty: $internshipCdHcParty, internshipCbe: $internshipCbe, supervisorNihii: $supervisorNihii, supervisorSsin: $supervisorSsin, supervisorLastName: $supervisorLastName, supervisorFirstName: $supervisorFirstName, supervisorCdHcParty: $supervisorCdHcParty, supervisorCbe: $supervisorCbe, error: $error, encounterLocationName: $encounterLocationName, encounterLocationNihii: $encounterLocationNihii, encounterLocationNorm: $encounterLocationNorm, longDelayJustification: $longDelayJustification, correctiveInvoiceId: $correctiveInvoiceId, correctedInvoiceId: $correctedInvoiceId, creditNote: $creditNote, creditNoteRelatedInvoiceId: $creditNoteRelatedInvoiceId, idDocument: $idDocument, admissionDate: $admissionDate, locationNihii: $locationNihii, locationService: $locationService, cancelReason: $cancelReason, cancelDate: $cancelDate, options: $options, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedInvoiceCopyWith<$Res>
    implements $EncryptedInvoiceCopyWith<$Res> {
  factory _$EncryptedInvoiceCopyWith(
          _EncryptedInvoice value, $Res Function(_EncryptedInvoice) _then) =
      __$EncryptedInvoiceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      List<Identifier> identifier,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      int? invoiceDate,
      int? sentDate,
      int? printedDate,
      List<EncryptedInvoicingCode> invoicingCodes,
      Map<String, String> receipts,
      String? recipientType,
      String? recipientId,
      String? invoiceReference,
      String? decisionReference,
      String? thirdPartyReference,
      String? thirdPartyPaymentJustification,
      String? thirdPartyPaymentReason,
      String? reason,
      InvoiceType? invoiceType,
      MediumType? sentMediumType,
      InvoiceInterventionType? interventionType,
      String? groupId,
      PaymentType? paymentType,
      double? paid,
      List<Payment>? payments,
      String? gnotionNihii,
      String? gnotionSsin,
      String? gnotionLastName,
      String? gnotionFirstName,
      String? gnotionCdHcParty,
      int? invoicePeriod,
      String? careProviderType,
      String? internshipNihii,
      String? internshipSsin,
      String? internshipLastName,
      String? internshipFirstName,
      String? internshipCdHcParty,
      String? internshipCbe,
      String? supervisorNihii,
      String? supervisorSsin,
      String? supervisorLastName,
      String? supervisorFirstName,
      String? supervisorCdHcParty,
      String? supervisorCbe,
      String? error,
      String? encounterLocationName,
      String? encounterLocationNihii,
      int? encounterLocationNorm,
      int? longDelayJustification,
      String? correctiveInvoiceId,
      String? correctedInvoiceId,
      bool? creditNote,
      String? creditNoteRelatedInvoiceId,
      IdentityDocumentReader? idDocument,
      int? admissionDate,
      String? locationNihii,
      int? locationService,
      String? cancelReason,
      int? cancelDate,
      Map<String, String> options,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument;
  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedInvoiceCopyWithImpl<$Res>
    implements _$EncryptedInvoiceCopyWith<$Res> {
  __$EncryptedInvoiceCopyWithImpl(this._self, this._then);

  final _EncryptedInvoice _self;
  final $Res Function(_EncryptedInvoice) _then;

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? identifier = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? invoiceDate = freezed,
    Object? sentDate = freezed,
    Object? printedDate = freezed,
    Object? invoicingCodes = null,
    Object? receipts = null,
    Object? recipientType = freezed,
    Object? recipientId = freezed,
    Object? invoiceReference = freezed,
    Object? decisionReference = freezed,
    Object? thirdPartyReference = freezed,
    Object? thirdPartyPaymentJustification = freezed,
    Object? thirdPartyPaymentReason = freezed,
    Object? reason = freezed,
    Object? invoiceType = freezed,
    Object? sentMediumType = freezed,
    Object? interventionType = freezed,
    Object? groupId = freezed,
    Object? paymentType = freezed,
    Object? paid = freezed,
    Object? payments = freezed,
    Object? gnotionNihii = freezed,
    Object? gnotionSsin = freezed,
    Object? gnotionLastName = freezed,
    Object? gnotionFirstName = freezed,
    Object? gnotionCdHcParty = freezed,
    Object? invoicePeriod = freezed,
    Object? careProviderType = freezed,
    Object? internshipNihii = freezed,
    Object? internshipSsin = freezed,
    Object? internshipLastName = freezed,
    Object? internshipFirstName = freezed,
    Object? internshipCdHcParty = freezed,
    Object? internshipCbe = freezed,
    Object? supervisorNihii = freezed,
    Object? supervisorSsin = freezed,
    Object? supervisorLastName = freezed,
    Object? supervisorFirstName = freezed,
    Object? supervisorCdHcParty = freezed,
    Object? supervisorCbe = freezed,
    Object? error = freezed,
    Object? encounterLocationName = freezed,
    Object? encounterLocationNihii = freezed,
    Object? encounterLocationNorm = freezed,
    Object? longDelayJustification = freezed,
    Object? correctiveInvoiceId = freezed,
    Object? correctedInvoiceId = freezed,
    Object? creditNote = freezed,
    Object? creditNoteRelatedInvoiceId = freezed,
    Object? idDocument = freezed,
    Object? admissionDate = freezed,
    Object? locationNihii = freezed,
    Object? locationService = freezed,
    Object? cancelReason = freezed,
    Object? cancelDate = freezed,
    Object? options = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedInvoice(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      invoiceDate: freezed == invoiceDate
          ? _self.invoiceDate
          : invoiceDate // ignore: cast_nullable_to_non_nullable
              as int?,
      sentDate: freezed == sentDate
          ? _self.sentDate
          : sentDate // ignore: cast_nullable_to_non_nullable
              as int?,
      printedDate: freezed == printedDate
          ? _self.printedDate
          : printedDate // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self._invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as List<EncryptedInvoicingCode>,
      receipts: null == receipts
          ? _self._receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      recipientType: freezed == recipientType
          ? _self.recipientType
          : recipientType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipientId: freezed == recipientId
          ? _self.recipientId
          : recipientId // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceReference: freezed == invoiceReference
          ? _self.invoiceReference
          : invoiceReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyReference: freezed == thirdPartyReference
          ? _self.thirdPartyReference
          : thirdPartyReference // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentJustification: freezed == thirdPartyPaymentJustification
          ? _self.thirdPartyPaymentJustification
          : thirdPartyPaymentJustification // ignore: cast_nullable_to_non_nullable
              as String?,
      thirdPartyPaymentReason: freezed == thirdPartyPaymentReason
          ? _self.thirdPartyPaymentReason
          : thirdPartyPaymentReason // ignore: cast_nullable_to_non_nullable
              as String?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceType: freezed == invoiceType
          ? _self.invoiceType
          : invoiceType // ignore: cast_nullable_to_non_nullable
              as InvoiceType?,
      sentMediumType: freezed == sentMediumType
          ? _self.sentMediumType
          : sentMediumType // ignore: cast_nullable_to_non_nullable
              as MediumType?,
      interventionType: freezed == interventionType
          ? _self.interventionType
          : interventionType // ignore: cast_nullable_to_non_nullable
              as InvoiceInterventionType?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
      payments: freezed == payments
          ? _self._payments
          : payments // ignore: cast_nullable_to_non_nullable
              as List<Payment>?,
      gnotionNihii: freezed == gnotionNihii
          ? _self.gnotionNihii
          : gnotionNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionSsin: freezed == gnotionSsin
          ? _self.gnotionSsin
          : gnotionSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionLastName: freezed == gnotionLastName
          ? _self.gnotionLastName
          : gnotionLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionFirstName: freezed == gnotionFirstName
          ? _self.gnotionFirstName
          : gnotionFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      gnotionCdHcParty: freezed == gnotionCdHcParty
          ? _self.gnotionCdHcParty
          : gnotionCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      invoicePeriod: freezed == invoicePeriod
          ? _self.invoicePeriod
          : invoicePeriod // ignore: cast_nullable_to_non_nullable
              as int?,
      careProviderType: freezed == careProviderType
          ? _self.careProviderType
          : careProviderType // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipNihii: freezed == internshipNihii
          ? _self.internshipNihii
          : internshipNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipSsin: freezed == internshipSsin
          ? _self.internshipSsin
          : internshipSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipLastName: freezed == internshipLastName
          ? _self.internshipLastName
          : internshipLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipFirstName: freezed == internshipFirstName
          ? _self.internshipFirstName
          : internshipFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCdHcParty: freezed == internshipCdHcParty
          ? _self.internshipCdHcParty
          : internshipCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      internshipCbe: freezed == internshipCbe
          ? _self.internshipCbe
          : internshipCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorNihii: freezed == supervisorNihii
          ? _self.supervisorNihii
          : supervisorNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorSsin: freezed == supervisorSsin
          ? _self.supervisorSsin
          : supervisorSsin // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorLastName: freezed == supervisorLastName
          ? _self.supervisorLastName
          : supervisorLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorFirstName: freezed == supervisorFirstName
          ? _self.supervisorFirstName
          : supervisorFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCdHcParty: freezed == supervisorCdHcParty
          ? _self.supervisorCdHcParty
          : supervisorCdHcParty // ignore: cast_nullable_to_non_nullable
              as String?,
      supervisorCbe: freezed == supervisorCbe
          ? _self.supervisorCbe
          : supervisorCbe // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationName: freezed == encounterLocationName
          ? _self.encounterLocationName
          : encounterLocationName // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNihii: freezed == encounterLocationNihii
          ? _self.encounterLocationNihii
          : encounterLocationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      encounterLocationNorm: freezed == encounterLocationNorm
          ? _self.encounterLocationNorm
          : encounterLocationNorm // ignore: cast_nullable_to_non_nullable
              as int?,
      longDelayJustification: freezed == longDelayJustification
          ? _self.longDelayJustification
          : longDelayJustification // ignore: cast_nullable_to_non_nullable
              as int?,
      correctiveInvoiceId: freezed == correctiveInvoiceId
          ? _self.correctiveInvoiceId
          : correctiveInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      correctedInvoiceId: freezed == correctedInvoiceId
          ? _self.correctedInvoiceId
          : correctedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      creditNote: freezed == creditNote
          ? _self.creditNote
          : creditNote // ignore: cast_nullable_to_non_nullable
              as bool?,
      creditNoteRelatedInvoiceId: freezed == creditNoteRelatedInvoiceId
          ? _self.creditNoteRelatedInvoiceId
          : creditNoteRelatedInvoiceId // ignore: cast_nullable_to_non_nullable
              as String?,
      idDocument: freezed == idDocument
          ? _self.idDocument
          : idDocument // ignore: cast_nullable_to_non_nullable
              as IdentityDocumentReader?,
      admissionDate: freezed == admissionDate
          ? _self.admissionDate
          : admissionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      locationNihii: freezed == locationNihii
          ? _self.locationNihii
          : locationNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      locationService: freezed == locationService
          ? _self.locationService
          : locationService // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelReason: freezed == cancelReason
          ? _self.cancelReason
          : cancelReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelDate: freezed == cancelDate
          ? _self.cancelDate
          : cancelDate // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
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

  /// Create a copy of EncryptedInvoice
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentityDocumentReaderCopyWith<$Res>? get idDocument {
    if (_self.idDocument == null) {
      return null;
    }

    return $IdentityDocumentReaderCopyWith<$Res>(_self.idDocument!, (value) {
      return _then(_self.copyWith(idDocument: value));
    });
  }

  /// Create a copy of EncryptedInvoice
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
