import 'package:cardinal_sdk/crypto/crypto_strategies.dart';
import 'package:cardinal_sdk/model/user_group.dart';
import 'package:cardinal_sdk/utils/internal/callback_references.dart';
import 'package:cardinal_sdk/utils/internal/crypto_strategies_callbacks.dart';

typedef GroupSelector = Future<String> Function(List<UserGroup>);

abstract interface class CommonSdkOptions {
  /// Configure which fields of entities should be encrypted
  EncryptedFieldsConfiguration get encryptedFields;

  /// An instance of iCure SDK is initialized for working as a specific user in a single group.
  /// However, the user credentials may match multiple users in different groups (but at most one per group).
  /// If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
  ///
  /// This is mandatory in multi-group applications, where a single user could exist in multiple groups.
  /// If this parameter is null and the user credentials match multiple users the api initialisation will fail.
  /// In single-group applications this parameter won't be used, so it can be left as null.
  GroupSelector? get groupSelector;

  /// If true the SDK will use lenient deserialization of the entities coming from the backend.
  ///
  /// This could be helpful when developing using the nightly deployments of the backend, as the SDK will ignore minor changes to the data model.
  ///
  /// This option however could cause loss of data when connecting with incompatible versions of the backend, and should be disabled in production.
  bool get lenientJson;
}

class SdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool lenientJson;
  @override final GroupSelector? groupSelector;
  /// Has only effect when logging in as an hcp user.
  ///
  /// If true the api will be initialized in a hierarchical mode, where each data owner is considered to have access
  /// to all data of his parents (requires corresponding permission on the server side).
  /// In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
  /// user.
  ///
  /// If false the api will ignore the data owner hierarchies.
  /// Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
  /// own keys.
  final bool useHierarchicalDataOwners;
  /// If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
  /// created.
  final bool createTransferKeys;
  /// Custom crypto strategies. If not provided the sdk will use crypto strategies that:
  /// - Allow for the creation of a new key of the data owner
  /// - Do not use any custom key recovery solutions
  /// - Considers any keys recovered using iCure's recovery methods as unverified
  /// - Considers all public keys of other data owners as verified
  /// - Considers patients as anonymous data owners
  final CryptoStrategies? cryptoStrategies;

  const SdkOptions({
    this.encryptedFields = const EncryptedFieldsConfiguration(),
    this.groupSelector,
    this.useHierarchicalDataOwners = true,
    this.createTransferKeys = true,
    this.lenientJson = false,
    this.cryptoStrategies
  });

  static Map<String, dynamic> encode(SdkOptions value) {
    Map<String, dynamic> entityAsMap = {
      "encryptedFields": EncryptedFieldsConfiguration.encode(value.encryptedFields),
      "useHierarchicalDataOwners": value.useHierarchicalDataOwners,
      "createTransferKeys": value.createTransferKeys,
      "lenientJson": value.lenientJson,
      "groupSelector": _registerGroupSelectorCallback(value.groupSelector),
      "cryptoStrategies": _registerCryptoStrategiesCallbacks(value.cryptoStrategies)
    };
    return entityAsMap;
  }
}

class BasicSdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool lenientJson;
  @override final GroupSelector? groupSelector;

  const BasicSdkOptions({
    this.encryptedFields = const EncryptedFieldsConfiguration(),
    this.lenientJson = false,
    this.groupSelector
  });

  static Map<String, dynamic> encode(BasicSdkOptions value) {
    Map<String, dynamic> entityAsMap = {
      "encryptedFields": EncryptedFieldsConfiguration.encode(value.encryptedFields),
      "lenientJson": value.lenientJson,
      "groupSelector": _registerGroupSelectorCallback(value.groupSelector),
    };
    return entityAsMap;
  }
}

class EncryptedFieldsConfiguration {
  final Set<String> accessLog;
  final Set<String> calendarItem;
  final Set<String> contact;
  final Set<String> service;
  final Set<String> healthElement;
  final Set<String> maintenanceTask;
  final Set<String> patient;
  final Set<String> message;
  final Set<String> topic;
  final Set<String> document;
  final Set<String> form;
  final Set<String> receipt;
  final Set<String> classification;
  final Set<String> timeTable;
  final Set<String> invoice;

  const EncryptedFieldsConfiguration({
    this.accessLog = const {
      "detail",
      "objectId",
      "patientId"
    },
    this.calendarItem = const {
      "details",
      "title",
      "patientId",
      "phoneNumber",
      "address",
      "addressText",
      "meetingTags[].*",
      "flowItem"
    },
    this.contact = const  {
      "descr",
      "notes[].markdown",
      "location",
      "encounterLocation",
      "participants",
    },
    this.service = const {
      "notes[].markdown",
      "comment"
    },
    this.healthElement = const {
      "descr",
      "note",
      "notes[].markdown",
      "careTeam[].*",
      "episode[].name",
      "episode[].comment"
    },
    this.maintenanceTask = const {
      "properties"
    },
    this.patient = const {
      "note",
      "notes[].markdown",
      "created",
      "modified",
      "companyName",
      "languages",
      "civility",
      "birthSex",
      "personalStatus",
      "nationality",
      "race",
      "ethnicity",
      "picture",
      "insurabilities[].*",
      "partnerships[].*",
      "patientHealthCareParties[].*",
      "financialInstitutionInformation[].*",
      "medicalHouseContracts[].*",
      "patientProfessions",
      "comment",
      "warning",
      "fatherBirthCountry",
      "birthCountry",
      "nativeCountry",
      "socialStatus",
      "mainSourceOfIncome",
      "schoolingInfos[].*",
      "employementInfos[].*",
    },
    this.message = const {
      "subject"
    },
    this.topic = const {
      "description",
      "linkedServices",
      "linkedHealthElements"
    },
    this.document = const {
      "medicalLocationId",
      "name"
    },
    this.form = const {
      "descr"
    },
    this.receipt = const {
      "references"
    },
    this.classification = const {
      "label"
    },
    this.timeTable = const {},
    this.invoice = const {
      "reason"
    }
  });

  static Map<String, dynamic> encode(EncryptedFieldsConfiguration value) {
    Map<String, dynamic> entityAsMap = {
      "accessLog": value.accessLog.toList(),
      "calendarItem": value.calendarItem.toList(),
      "contact": value.contact.toList(),
      "service": value.service.toList(),
      "healthElement": value.healthElement.toList(),
      "maintenanceTask": value.maintenanceTask.toList(),
      "patient": value.patient.toList(),
      "message": value.message.toList(),
      "topic": value.topic.toList(),
      "document": value.document.toList(),
      "form": value.form.toList(),
      "receipt": value.receipt.toList(),
      "classification": value.classification.toList(),
      "timeTable": value.timeTable.toList(),
      "invoice": value.invoice.toList()
    };
    return entityAsMap;
  }
}

String? _registerGroupSelectorCallback(
  GroupSelector? groupSelector
) {
  if (groupSelector != null) {
    return CallbackReferences.create((Map<String, dynamic> json) async {
      return await groupSelector((json["availableGroups"] as List<dynamic>).map((x) =>
          UserGroup.fromJSON(x as Map<String, dynamic>)
      ).toList());
    });
  } else {
    return null;
  }
}

Map<String, String>? _registerCryptoStrategiesCallbacks(
  CryptoStrategies? cryptoStrategies
) {
  if (cryptoStrategies != null) {
    return {
      "recoverAndVerifySelfHierarchyKeys": CallbackReferences.create(
        recoverAndVerifySelfHierarchyKeysCallback(cryptoStrategies),
      ),
      "generateNewKeyForDataOwner": CallbackReferences.create(
        generateNewKeyForDataOwnerCallback(cryptoStrategies),
      ),
      "verifyDelegatePublicKeys": CallbackReferences.create(
        verifyDelegatePublicKeysCallback(cryptoStrategies),
      ),
      "dataOwnerRequiresAnonymousDelegation": CallbackReferences.create(
        dataOwnerRequiresAnonymousDelegationCallback(cryptoStrategies),
      ),
      "notifyNewKeyCreated": CallbackReferences.create(
        notifyNewKeyCreatedCallback(cryptoStrategies),
      ),
    };
  } else {
    return null;
  }
}
