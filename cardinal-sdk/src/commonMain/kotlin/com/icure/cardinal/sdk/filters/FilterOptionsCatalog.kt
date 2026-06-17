package com.icure.cardinal.sdk.filters

/**
 * Static, human-readable catalog of all the entity [FilterOptions] exposed by the SDK.
 *
 * The SDK exposes filtering through one `object XFilters` per entity (e.g. [HealthElementFilters],
 * [PatientFilters]). Each of those objects offers many public factory methods that often represent the
 * *same* logical filter, differing only in how the parameters are supplied:
 * - for the current data owner (`...ForSelf`) vs. an explicit data owner (`...ForDataOwner`);
 * - the cross-group variants (`...InGroup`);
 * - passing full entities vs. passing their secret ids (`...SecretIds...`).
 *
 * Each factory ultimately produces a concrete [com.icure.cardinal.sdk.model.filter.AbstractFilter] that is
 * the filter actually sent to the Cardinal backend (resolved by the internal `mapXFilterOptions` functions).
 *
 * This catalog classifies every filter option on two levels:
 * 1. the **entity** it refers to (the key of [byEntity], using the entity simple name);
 * 2. the **type** of filter ([FilterOptionGroup]) — a set of factory methods that are the same operation,
 *    differing only in the parameter-passing axes described above.
 *
 * Each group records the concrete [FilterOptionGroup.targetFilter] sent to the backend.
 *
 * Notes:
 * - `InGroup` variants are included alongside their non-`InGroup` siblings: they are just another way of
 *   passing parameters.
 * - Entity-agnostic meta options ([intersection], [union], [difference] in `MetaFilters.kt`) are not listed
 *   here because they do not belong to a single entity.
 * - A few groups branch to more than one backend filter depending on their input (e.g. Patient `bySsins`
 *   uses a single-value or a multi-value filter); for those, [FilterOptionGroup.targetFilter] lists both.
 */
object FilterOptionsCatalog {

	/**
	 * A set of factory methods that produce the same kind of filter, differing only in how parameters are
	 * passed (for-self vs. for-data-owner, in-group variants, full entities vs. secret ids).
	 *
	 * @property name a short semantic name for the group (the operation, without the parameter-passing suffixes).
	 * @property factoryMethods the names of the factory methods of the corresponding `XFilters` object that
	 * belong to this group, in source order.
	 * @property targetFilter the simple name of the `AbstractFilter` actually sent to the backend (or the
	 * possible filters, separated by " or ", for the rare groups that branch on their input).
	 */
	data class FilterOptionGroup(
		val name: String,
		val factoryMethods: List<String>,
		val targetFilter: String,
	)

	/**
	 * Catalog of all entity filter options, keyed by entity simple name.
	 */
	val byEntity: Map<String, List<FilterOptionGroup>> = mapOf(
		"AccessLog" to listOf(
			FilterOptionGroup(
				name = "byPatientsDate",
				factoryMethods = listOf(
					"byPatientsDateForDataOwner",
					"byPatientsDateForDataOwnerInGroup",
					"byPatientsDateForSelf",
					"byPatientSecretIdsDateForDataOwner",
					"byPatientSecretIdsDateForSelf",
				),
				targetFilter = "AccessLogByDataOwnerPatientDateFilter",
			),
			FilterOptionGroup(
				name = "byDate",
				factoryMethods = listOf("byDate"),
				targetFilter = "AccessLogByDateFilter",
			),
			FilterOptionGroup(
				name = "byUserTypeDate",
				factoryMethods = listOf("byUserTypeDate"),
				targetFilter = "AccessLogByUserIdUserTypeDateFilter",
			),
		),
		"Agenda" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllAgendasFilter",
			),
			FilterOptionGroup(
				name = "byUser",
				factoryMethods = listOf("byUser", "byUserInGroup"),
				targetFilter = "AgendaByUserIdFilter",
			),
			FilterOptionGroup(
				name = "readableByUser",
				factoryMethods = listOf("readableByUser", "readableByUserInGroup"),
				targetFilter = "AgendaReadableByUserIdFilter",
			),
			FilterOptionGroup(
				name = "readableByUserRights",
				factoryMethods = listOf("readableByUserRights", "readableByUserRightsInGroup"),
				targetFilter = "AgendaReadableByUserRightsFilter",
			),
			FilterOptionGroup(
				name = "byStringProperty",
				factoryMethods = listOf("byStringProperty"),
				targetFilter = "AgendaByTypedPropertyFilter",
			),
			FilterOptionGroup(
				name = "byBooleanProperty",
				factoryMethods = listOf("byBooleanProperty"),
				targetFilter = "AgendaByTypedPropertyFilter",
			),
			FilterOptionGroup(
				name = "byLongProperty",
				factoryMethods = listOf("byLongProperty"),
				targetFilter = "AgendaByTypedPropertyFilter",
			),
			FilterOptionGroup(
				name = "byDoubleProperty",
				factoryMethods = listOf("byDoubleProperty"),
				targetFilter = "AgendaByTypedPropertyFilter",
			),
			FilterOptionGroup(
				name = "withProperty",
				factoryMethods = listOf("withProperty"),
				targetFilter = "AgendaWithPropertyFilter",
			),
		),
		"CalendarItem" to listOf(
			FilterOptionGroup(
				name = "byPatientsStartTime",
				factoryMethods = listOf(
					"byPatientsStartTimeForDataOwner",
					"byPatientsStartTimeForDataOwnerInGroup",
					"byPatientsStartTimeForSelf",
					"byPatientSecretIdsStartTimeForDataOwner",
					"byPatientSecretIdsStartTimeForDataOwnerInGroup",
					"byPatientSecretIdsStartTimeForSelf",
				),
				targetFilter = "CalendarItemByDataOwnerPatientStartTimeFilter",
			),
			FilterOptionGroup(
				name = "byPeriodAndAgenda",
				factoryMethods = listOf("byPeriodAndAgenda"),
				targetFilter = "CalendarItemByPeriodAndAgendaIdFilter",
			),
			FilterOptionGroup(
				name = "byPeriod",
				factoryMethods = listOf(
					"byPeriodForDataOwner",
					"byPeriodForDataOwnerInGroup",
					"byPeriodForSelf",
				),
				targetFilter = "CalendarItemByPeriodAndDataOwnerIdFilter",
			),
			FilterOptionGroup(
				name = "lifecycleBetween",
				factoryMethods = listOf(
					"lifecycleBetweenForDataOwner",
					"lifecycleBetweenForDataOwnerInGroup",
					"lifecycleBetweenForSelf",
				),
				targetFilter = "CalendarItemByDataOwnerLifecycleBetween",
			),
			FilterOptionGroup(
				name = "byRecurrenceId",
				factoryMethods = listOf("byRecurrenceId"),
				targetFilter = "CalendarItemByRecurrenceIdFilter",
			),
		),
		"Classification" to listOf(
			FilterOptionGroup(
				name = "byPatientsCreated",
				factoryMethods = listOf(
					"byPatientsCreatedForDataOwner",
					"byPatientsCreatedForSelf",
					"byPatientSecretIdsCreatedForDataOwner",
					"byPatientSecretIdsCreatedForSelf",
				),
				targetFilter = "ClassificationByDataOwnerPatientCreatedDateFilter",
			),
		),
		"Code" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllCodesFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "CodeByIdsFilter",
			),
			FilterOptionGroup(
				name = "byQualifiedLink",
				factoryMethods = listOf("byQualifiedLink"),
				targetFilter = "CodeByQualifiedLinkFilter",
			),
			FilterOptionGroup(
				name = "byRegionTypeCodeVersion",
				factoryMethods = listOf("byRegionTypeCodeVersion"),
				targetFilter = "CodeByRegionTypeCodeVersionFilters",
			),
			FilterOptionGroup(
				name = "byLanguageTypeLabelRegion",
				factoryMethods = listOf("byLanguageTypeLabelRegion"),
				targetFilter = "CodeByRegionTypeLabelLanguageFilter",
			),
			FilterOptionGroup(
				name = "byLanguageTypesLabelRegionVersion",
				factoryMethods = listOf("byLanguageTypesLabelRegionVersion"),
				targetFilter = "CodeByRegionTypesLanguageLabelVersionFilters",
			),
		),
		"Contact" to listOf(
			FilterOptionGroup(
				name = "allContacts",
				factoryMethods = listOf(
					"allContactsForDataOwner",
					"allContactsForDataOwnerInGroup",
					"allContactsForSelf",
				),
				targetFilter = "ContactByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byFormIds",
				factoryMethods = listOf(
					"byFormIdsForDataOwner",
					"byFormIdsForDataOwnerInGroup",
					"byFormIdsForSelf",
				),
				targetFilter = "ContactByDataOwnerFormIdsFilter",
			),
			FilterOptionGroup(
				name = "byPatientsOpeningDate",
				factoryMethods = listOf(
					"byPatientsOpeningDateForDataOwner",
					"byPatientsOpeningDateForDataOwnerInGroup",
					"byPatientsOpeningDateForSelf",
					"byPatientSecretIdsOpeningDateForDataOwner",
					"byPatientSecretIdsOpeningDateForDataOwnerInGroup",
					"byPatientSecretIdsOpeningDateForSelf",
				),
				targetFilter = "ContactByDataOwnerPatientOpeningDateFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf(
					"byIdentifiersForSelf",
					"byIdentifiersForDataOwner",
					"byIdentifiersForDataOwnerInGroup",
				),
				targetFilter = "ContactByHcPartyIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "byCodeAndOpeningDate",
				factoryMethods = listOf(
					"byCodeAndOpeningDateForDataOwner",
					"byCodeAndOpeningDateForDataOwnerInGroup",
					"byCodeAndOpeningDateForSelf",
				),
				targetFilter = "ContactByHcPartyTagCodeDateFilter",
			),
			FilterOptionGroup(
				name = "byPatients",
				factoryMethods = listOf(
					"byPatientsForDataOwner",
					"byPatientsForDataOwnerInGroup",
					"byPatientsForSelf",
					"byPatientsSecretIdsForDataOwner",
					"byPatientsSecretIdsForDataOwnerInGroup",
					"byPatientsSecretIdsForSelf",
				),
				targetFilter = "ContactByHcPartyPatientTagCodeDateFilter",
			),
			FilterOptionGroup(
				name = "byServiceIds",
				factoryMethods = listOf("byServiceIds"),
				targetFilter = "ContactByServiceIdsFilter",
			),
			FilterOptionGroup(
				name = "byTagAndOpeningDate",
				factoryMethods = listOf(
					"byTagAndOpeningDateForDataOwner",
					"byTagAndOpeningDateForDataOwnerInGroup",
					"byTagAndOpeningDateForSelf",
				),
				targetFilter = "ContactByHcPartyTagCodeDateFilter",
			),
			FilterOptionGroup(
				name = "byOpeningDate",
				factoryMethods = listOf(
					"byOpeningDateForDataOwner",
					"byOpeningDateForDataOwnerInGroup",
					"byOpeningDateForSelf",
				),
				targetFilter = "ContactByDataOwnerOpeningDateFilter",
			),
			FilterOptionGroup(
				name = "byServiceTag",
				factoryMethods = listOf(
					"byServiceTagForSelf",
					"byServiceTagForDataOwner",
					"byServiceTagForDataOwnerInGroup",
				),
				targetFilter = "ContactByDataOwnerServiceTagFilter",
			),
			FilterOptionGroup(
				name = "byServiceCode",
				factoryMethods = listOf(
					"byServiceCodeForSelf",
					"byServiceCodeForDataOwner",
					"byServiceCodeForDataOwnerInGroup",
				),
				targetFilter = "ContactByDataOwnerServiceCodeFilter",
			),
		),
		"Device" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllDevicesFilter",
			),
			FilterOptionGroup(
				name = "byResponsible",
				factoryMethods = listOf("byResponsible", "byResponsibleInGroup"),
				targetFilter = "DeviceByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "DeviceByIdsFilter",
			),
		),
		"Document" to listOf(
			FilterOptionGroup(
				name = "byPatientsCreated",
				factoryMethods = listOf(
					"byPatientsCreatedForDataOwner",
					"byPatientsCreatedForDataOwnerInGroup",
					"byPatientsCreatedForSelf",
				),
				targetFilter = "DocumentByDataOwnerPatientDateFilter",
			),
			FilterOptionGroup(
				name = "byMessagesCreated",
				factoryMethods = listOf(
					"byMessagesCreatedForDataOwner",
					"byMessagesCreatedForDataOwnerInGroup",
					"byMessagesCreatedForSelf",
				),
				targetFilter = "DocumentByDataOwnerPatientDateFilter",
			),
			FilterOptionGroup(
				name = "byOwningEntitySecretIdsCreated",
				factoryMethods = listOf(
					"byOwningEntitySecretIdsCreatedForDataOwner",
					"byOwningEntitySecretIdsCreatedForDataOwnerInGroup",
					"byOwningEntitySecretIdsCreatedForSelf",
				),
				targetFilter = "DocumentByDataOwnerPatientDateFilter",
			),
			FilterOptionGroup(
				name = "byPatientsAndType",
				factoryMethods = listOf(
					"byPatientsAndTypeForDataOwner",
					"byPatientsAndTypeForDataOwnerInGroup",
					"byPatientsAndTypeForSelf",
				),
				targetFilter = "DocumentByTypeDataOwnerPatientFilter",
			),
			FilterOptionGroup(
				name = "byMessagesAndType",
				factoryMethods = listOf(
					"byMessagesAndTypeForDataOwner",
					"byMessagesAndTypeForDataOwnerInGroup",
					"byMessagesAndTypeForSelf",
				),
				targetFilter = "DocumentByTypeDataOwnerPatientFilter",
			),
			FilterOptionGroup(
				name = "byOwningEntitySecretIdsAndType",
				factoryMethods = listOf(
					"byOwningEntitySecretIdsAndTypeForDataOwner",
					"byOwningEntitySecretIdsAndTypeForDataOwnerInGroup",
					"byOwningEntitySecretIdsAndTypeForSelf",
				),
				targetFilter = "DocumentByTypeDataOwnerPatientFilter",
			),
			FilterOptionGroup(
				name = "byCode",
				factoryMethods = listOf(
					"byCodeForDataOwner",
					"byCodeForDataOwnerInGroup",
					"byCodeForSelf",
				),
				targetFilter = "DocumentByDataOwnerCodeFilter",
			),
			FilterOptionGroup(
				name = "byTag",
				factoryMethods = listOf(
					"byTagForDataOwner",
					"byTagForDataOwnerInGroup",
					"byTagForSelf",
				),
				targetFilter = "DocumentByDataOwnerTagFilter",
			),
		),
		"Form" to listOf(
			FilterOptionGroup(
				name = "byParentId",
				factoryMethods = listOf(
					"byParentIdForDataOwner",
					"byParentIdForDataOwnerInGroup",
					"byParentIdForSelf",
				),
				targetFilter = "FormByDataOwnerParentIdFilter",
			),
			FilterOptionGroup(
				name = "byPatientsOpeningDate",
				factoryMethods = listOf(
					"byPatientsOpeningDateForDataOwner",
					"byPatientsOpeningDateForDataOwnerInGroup",
					"byPatientsOpeningDateForSelf",
					"byPatientSecretIdsOpeningDateForDataOwner",
					"byPatientSecretIdsOpeningDateForDataOwnerInGroup",
					"byPatientSecretIdsOpeningDateForSelf",
				),
				targetFilter = "FormByDataOwnerPatientOpeningDateFilter",
			),
			FilterOptionGroup(
				name = "byUniqueId",
				factoryMethods = listOf("byUniqueId"),
				targetFilter = "FormByUniqueUuidFilter",
			),
		),
		"FormTemplate" to listOf(
			FilterOptionGroup(
				name = "bySpecialtyCode",
				factoryMethods = listOf("bySpecialtyCode"),
				targetFilter = "FormTemplateBySpecialtyFilter",
			),
		),
		"Group" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllGroupsFilter",
			),
			FilterOptionGroup(
				name = "bySuperGroup",
				factoryMethods = listOf("bySuperGroup"),
				targetFilter = "GroupBySuperGroupFilter",
			),
			FilterOptionGroup(
				name = "withContent",
				factoryMethods = listOf("withContent"),
				targetFilter = "GroupWithContentFilter",
			),
		),
		"HealthElement" to listOf(
			FilterOptionGroup(
				name = "allHealthElements",
				factoryMethods = listOf(
					"allHealthElementsForDataOwner",
					"allHealthElementsForDataOwnerInGroup",
					"allHealthElementsForSelf",
				),
				targetFilter = "HealthElementByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf(
					"byIdentifiersForDataOwner",
					"byIdentifiersForDataOwnerInGroup",
					"byIdentifiersForSelf",
				),
				targetFilter = "HealthElementByHcPartyIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "byCode",
				factoryMethods = listOf(
					"byCodeForDataOwner",
					"byCodeForDataOwnerInGroup",
					"byCodeForSelf",
				),
				targetFilter = "HealthElementByHcPartyTagCodeFilter",
			),
			FilterOptionGroup(
				name = "byTag",
				factoryMethods = listOf(
					"byTagForDataOwner",
					"byTagForDataOwnerInGroup",
					"byTagForSelf",
				),
				targetFilter = "HealthElementByHcPartyTagCodeFilter",
			),
			FilterOptionGroup(
				name = "byPatients",
				factoryMethods = listOf(
					"byPatientsForDataOwner",
					"byPatientsForDataOwnerInGroup",
					"byPatientsForSelf",
					"byPatientsSecretIdsForDataOwner",
					"byPatientsSecretIdsForDataOwnerInGroup",
					"byPatientsSecretIdsForSelf",
				),
				targetFilter = "HealthElementByDataOwnerPatientOpeningDate",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "HealthElementByIdsFilter",
			),
			FilterOptionGroup(
				name = "byPatientsOpeningDate",
				factoryMethods = listOf(
					"byPatientsOpeningDateForDataOwner",
					"byPatientsOpeningDateForDataOwnerInGroup",
					"byPatientsOpeningDateForSelf",
					"byPatientSecretIdsOpeningDateForDataOwner",
					"byPatientSecretIdsOpeningDateForDataOwnerInGroup",
					"byPatientSecretIdsOpeningDateForSelf",
				),
				targetFilter = "HealthElementByDataOwnerPatientOpeningDate",
			),
		),
		"HealthcareParty" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllHealthcarePartiesFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf("byIdentifiers"),
				targetFilter = "HealthcarePartyByIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "byCode",
				factoryMethods = listOf("byCode"),
				targetFilter = "HealthcarePartyByTagCodeFilter",
			),
			FilterOptionGroup(
				name = "byTag",
				factoryMethods = listOf("byTag"),
				targetFilter = "HealthcarePartyByTagCodeFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "HealthcarePartyByIdsFilter",
			),
			FilterOptionGroup(
				name = "byName",
				factoryMethods = listOf("byName"),
				targetFilter = "HealthcarePartyByNameFilter",
			),
			FilterOptionGroup(
				name = "byNationalIdentifier",
				factoryMethods = listOf("byNationalIdentifier"),
				targetFilter = "HealthcarePartyByNationalIdentifierFilter",
			),
			FilterOptionGroup(
				name = "byParentId",
				factoryMethods = listOf("byParentId"),
				targetFilter = "HealthcarePartyByParentIdFilter",
			),
		),
		"MaintenanceTask" to listOf(
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "MaintenanceTaskByIdsFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf("byIdentifiersForDataOwner", "byIdentifiersForSelf"),
				targetFilter = "MaintenanceTaskByHcPartyAndIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "byType",
				factoryMethods = listOf("byTypeForDataOwner", "byTypeForSelf"),
				targetFilter = "MaintenanceTaskByHcPartyAndTypeFilter",
			),
			FilterOptionGroup(
				name = "afterDate",
				factoryMethods = listOf("afterDateForDataOwner", "afterDateForSelf"),
				targetFilter = "MaintenanceTaskAfterDateFilter",
			),
		),
		"Message" to listOf(
			FilterOptionGroup(
				name = "allMessages",
				factoryMethods = listOf("allMessagesForDataOwner", "allMessagesForSelf"),
				targetFilter = "MessageByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byTransportGuid",
				factoryMethods = listOf(
					"byTransportGuidForDataOwner",
					"byTransportGuidForDataOwnerInGroup",
					"byTransportGuidForSelf",
				),
				targetFilter = "MessageByHcPartyTransportGuidReceivedFilter",
			),
			FilterOptionGroup(
				name = "fromAddress",
				factoryMethods = listOf(
					"fromAddressForDataOwner",
					"fromAddressForDataOwnerInGroup",
					"fromAddressForSelf",
				),
				targetFilter = "MessageByDataOwnerFromAddressFilter",
			),
			FilterOptionGroup(
				name = "byPatientsSentDate",
				factoryMethods = listOf(
					"byPatientsSentDateForDataOwner",
					"byPatientsSentDateForDataOwnerInGroup",
					"byPatientsSentDateForSelf",
					"byPatientSecretIdsSentDateForDataOwner",
					"byPatientSecretIdsSentDateForDataOwnerInGroup",
					"byPatientSecretIdsSentDateForSelf",
				),
				targetFilter = "MessageByDataOwnerPatientSentDateFilter",
			),
			FilterOptionGroup(
				name = "toAddress",
				factoryMethods = listOf(
					"toAddressForDataOwner",
					"toAddressForDataOwnerInGroup",
					"toAddressForSelf",
				),
				targetFilter = "MessageByDataOwnerToAddressFilter",
			),
			FilterOptionGroup(
				name = "byTransportGuidSentDate",
				factoryMethods = listOf(
					"byTransportGuidSentDateForDataOwner",
					"byTransportGuidSentDateForDataOwnerInGroup",
					"byTransportGuidSentDateForSelf",
				),
				targetFilter = "MessageByDataOwnerTransportGuidSentDateFilter",
			),
			FilterOptionGroup(
				name = "latestByTransportGuid",
				factoryMethods = listOf(
					"latestByTransportGuidForDataOwner",
					"latestByTransportGuidForDataOwnerInGroup",
					"latestByTransportGuidForSelf",
				),
				targetFilter = "LatestMessageByHcPartyTransportGuidFilter",
			),
			FilterOptionGroup(
				name = "byInvoiceIds",
				factoryMethods = listOf("byInvoiceIds"),
				targetFilter = "MessageByInvoiceIdsFilter",
			),
			FilterOptionGroup(
				name = "byParentIds",
				factoryMethods = listOf("byParentIds"),
				targetFilter = "MessageByParentIdsFilter",
			),
			FilterOptionGroup(
				name = "lifecycleBetween",
				factoryMethods = listOf(
					"lifecycleBetweenForDataOwner",
					"lifecycleBetweenForDataOwnerInGroup",
					"lifecycleBetweenForSelf",
				),
				targetFilter = "MessageByDataOwnerLifecycleBetween",
			),
			FilterOptionGroup(
				name = "byCode",
				factoryMethods = listOf(
					"byCodeForDataOwner",
					"byCodeForDataOwnerInGroup",
					"byCodeForSelf",
				),
				targetFilter = "MessageByDataOwnerCodeFilter",
			),
			FilterOptionGroup(
				name = "byTag",
				factoryMethods = listOf(
					"byTagForDataOwner",
					"byTagForDataOwnerInGroup",
					"byTagForSelf",
				),
				targetFilter = "MessageByDataOwnerTagFilter",
			),
		),
		"Patient" to listOf(
			FilterOptionGroup(
				name = "allPatients",
				factoryMethods = listOf(
					"allPatientsForDataOwner",
					"allPatientsForDataOwnerInGroup",
					"allPatientsForSelf",
				),
				targetFilter = "PatientByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "PatientByIdsFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf(
					"byIdentifiersForDataOwner",
					"byIdentifiersForDataOwnerInGroup",
					"byIdentifiersForSelf",
				),
				targetFilter = "PatientByHcPartyAndIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "bySsins",
				factoryMethods = listOf(
					"bySsinsForDataOwner",
					"bySsinsForDataOwnerInGroup",
					"bySsinsForSelf",
				),
				targetFilter = "PatientByHcPartyAndSsinFilter or PatientByHcPartyAndSsinsFilter",
			),
			FilterOptionGroup(
				name = "byDateOfBirthBetween",
				factoryMethods = listOf(
					"byDateOfBirthBetweenForDataOwner",
					"byDateOfBirthBetweenForDataOwnerInGroup",
					"byDateOfBirthBetweenForSelf",
				),
				targetFilter = "PatientByHcPartyDateOfBirthFilter or PatientByHcPartyDateOfBirthBetweenFilter",
			),
			FilterOptionGroup(
				name = "byFuzzyName",
				factoryMethods = listOf(
					"byFuzzyNameForDataOwner",
					"byFuzzyNameForDataOwnerInGroup",
					"byNameForSelf",
				),
				targetFilter = "PatientByHcPartyNameFilter",
			),
			FilterOptionGroup(
				name = "byGenderEducationProfession",
				factoryMethods = listOf(
					"byGenderEducationProfessionForDataOwner",
					"byGenderEducationProfessionForDataOwnerInGroup",
					"byGenderEducationProfessionForSelf",
				),
				targetFilter = "PatientByHcPartyGenderEducationProfession",
			),
			FilterOptionGroup(
				name = "byActive",
				factoryMethods = listOf(
					"byActiveForDataOwner",
					"byActiveForDataOwnerInGroup",
					"byActiveForSelf",
				),
				targetFilter = "PatientByHcPartyAndActiveFilter",
			),
			FilterOptionGroup(
				name = "byTelecom",
				factoryMethods = listOf(
					"byTelecomForDataOwner",
					"byTelecomForDataOwnerInGroup",
					"byTelecomForSelf",
				),
				targetFilter = "PatientByHcPartyAndTelecomFilter",
			),
			FilterOptionGroup(
				name = "byAddressPostalCodeHouseNumber",
				factoryMethods = listOf(
					"byAddressPostalCodeHouseNumberForDataOwner",
					"byAddressPostalCodeHouseNumberForDataOwnerInGroup",
					"byAddressPostalCodeHouseNumberForSelf",
				),
				targetFilter = "PatientByHcPartyAndAddressFilter",
			),
			FilterOptionGroup(
				name = "byAddress",
				factoryMethods = listOf(
					"byAddressForDataOwner",
					"byAddressForDataOwnerInGroup",
					"byAddressForSelf",
				),
				targetFilter = "PatientByHcPartyAndAddressFilter",
			),
			FilterOptionGroup(
				name = "byTag",
				factoryMethods = listOf(
					"byTagForSelf",
					"byTagForDataOwner",
					"byTagForDataOwnerInGroup",
				),
				targetFilter = "PatientByDataOwnerTagFilter",
			),
		),
		"Service" to listOf(
			FilterOptionGroup(
				name = "allServices",
				factoryMethods = listOf(
					"allServicesForDataOwner",
					"allServicesForDataOwnerInGroup",
					"allServicesForSelf",
				),
				targetFilter = "ServiceByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byIdentifiers",
				factoryMethods = listOf(
					"byIdentifiersForDataOwner",
					"byIdentifiersForDataOwnerInGroup",
					"byIdentifiersForSelf",
				),
				targetFilter = "ServiceByHcPartyIdentifiersFilter",
			),
			FilterOptionGroup(
				name = "byCodeAndValueDate",
				factoryMethods = listOf(
					"byCodeAndValueDateForDataOwner",
					"byCodeAndValueDateForDataOwnerInGroup",
					"byCodeAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyTagCodeDateFilter",
			),
			FilterOptionGroup(
				name = "byTagAndValueDate",
				factoryMethods = listOf(
					"byTagAndValueDateForDataOwner",
					"byTagAndValueDateForDataOwnerInGroup",
					"byTagAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyTagCodeDateFilter",
			),
			FilterOptionGroup(
				name = "byPatients",
				factoryMethods = listOf(
					"byPatientsForDataOwner",
					"byPatientsForDataOwnerInGroup",
					"byPatientsForSelf",
					"byPatientsSecretIdsForDataOwner",
					"byPatientsSecretIdsForDataOwnerInGroup",
					"byPatientsSecretIdsForSelf",
				),
				targetFilter = "ServiceBySecretForeignKeys",
			),
			FilterOptionGroup(
				name = "byHealthElementIdFromSubContact",
				factoryMethods = listOf(
					"byHealthElementIdFromSubContactForDataOwner",
					"byHealthElementIdFromSubContactForDataOwnerInGroup",
					"byHealthElementIdFromSubContactForSelf",
				),
				targetFilter = "ServiceByHcPartyHealthElementIdsFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "ServiceByIdsFilter",
			),
			FilterOptionGroup(
				name = "byAssociationId",
				factoryMethods = listOf("byAssociationId"),
				targetFilter = "ServiceByAssociationIdFilter",
			),
			FilterOptionGroup(
				name = "byQualifiedLink",
				factoryMethods = listOf("byQualifiedLink"),
				targetFilter = "ServiceByQualifiedLinkFilter",
			),
			FilterOptionGroup(
				name = "byPatientsDate",
				factoryMethods = listOf(
					"byPatientsDateForDataOwner",
					"byPatientsDateForDataOwnerInGroup",
					"byPatientsDateForSelf",
					"byPatientSecretIdsDateForDataOwner",
					"byPatientSecretIdsDateForDataOwnerInGroup",
					"byPatientSecretIdsDateForSelf",
				),
				targetFilter = "ServiceByDataOwnerPatientDateFilter",
			),
			FilterOptionGroup(
				name = "byCodesAndValueDate",
				factoryMethods = listOf(
					"byCodesAndValueDateForDataOwner",
					"byCodesAndValueDateForDataOwnerInGroup",
					"byCodesAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyCodesFilter",
			),
			FilterOptionGroup(
				name = "byCodePrefixAndValueDate",
				factoryMethods = listOf(
					"byCodePrefixAndValueDateForDataOwner",
					"byCodePrefixAndValueDateForDataOwnerInGroup",
					"byCodePrefixAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyCodePrefixFilter",
			),
			FilterOptionGroup(
				name = "byTagCodesAndValueDate",
				factoryMethods = listOf(
					"byTagCodesAndValueDateForDataOwner",
					"byTagCodesAndValueDateForDataOwnerInGroup",
					"byTagCodesAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyTagCodesFilter",
			),
			FilterOptionGroup(
				name = "byTagPrefixAndValueDate",
				factoryMethods = listOf(
					"byTagPrefixAndValueDateForDataOwner",
					"byTagPrefixAndValueDateForDataOwnerInGroup",
					"byTagPrefixAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyTagPrefixFilter",
			),
			FilterOptionGroup(
				name = "byPatientsCodesAndValueDate",
				factoryMethods = listOf(
					"byPatientsCodesAndValueDateForDataOwner",
					"byPatientsCodesAndValueDateForDataOwnerInGroup",
					"byPatientsCodesAndValueDateForSelf",
					"byPatientSecretIdsCodesAndValueDateForDataOwner",
					"byPatientSecretIdsCodesAndValueDateForDataOwnerInGroup",
					"byPatientSecretIdsCodesAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyPatientCodesFilter",
			),
			FilterOptionGroup(
				name = "byPatientsCodePrefixAndValueDate",
				factoryMethods = listOf(
					"byPatientsCodePrefixAndValueDateForDataOwner",
					"byPatientsCodePrefixAndValueDateForDataOwnerInGroup",
					"byPatientsCodePrefixAndValueDateForSelf",
					"byPatientSecretIdsCodePrefixAndValueDateForDataOwner",
					"byPatientSecretIdsCodePrefixAndValueDateForDataOwnerInGroup",
					"byPatientSecretIdsCodePrefixAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyPatientCodePrefixFilter",
			),
			FilterOptionGroup(
				name = "byPatientsTagCodesAndValueDate",
				factoryMethods = listOf(
					"byPatientsTagCodesAndValueDateForDataOwner",
					"byPatientsTagCodesAndValueDateForDataOwnerInGroup",
					"byPatientsTagCodesAndValueDateForSelf",
					"byPatientSecretIdsTagCodesAndValueDateForDataOwner",
					"byPatientSecretIdsTagCodesAndValueDateForDataOwnerInGroup",
					"byPatientSecretIdsTagCodesAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyPatientTagCodesFilter",
			),
			FilterOptionGroup(
				name = "byPatientsTagPrefixAndValueDate",
				factoryMethods = listOf(
					"byPatientsTagPrefixAndValueDateForDataOwner",
					"byPatientsTagPrefixAndValueDateForDataOwnerInGroup",
					"byPatientsTagPrefixAndValueDateForSelf",
					"byPatientSecretIdsTagPrefixAndValueDateForDataOwner",
					"byPatientSecretIdsTagPrefixAndValueDateForDataOwnerInGroup",
					"byPatientSecretIdsTagPrefixAndValueDateForSelf",
				),
				targetFilter = "ServiceByHcPartyPatientTagPrefixFilter",
			),
		),
		"Topic" to listOf(
			FilterOptionGroup(
				name = "allTopics",
				factoryMethods = listOf(
					"allTopicsForDataOwner",
					"allTopicsForDataOwnerInGroup",
					"allTopicsForSelf",
				),
				targetFilter = "TopicByHcPartyFilter",
			),
			FilterOptionGroup(
				name = "byParticipant",
				factoryMethods = listOf("byParticipant", "byParticipantInGroup"),
				targetFilter = "TopicByParticipantFilter",
			),
		),
		"User" to listOf(
			FilterOptionGroup(
				name = "all",
				factoryMethods = listOf("all"),
				targetFilter = "AllUsersFilter",
			),
			FilterOptionGroup(
				name = "byIds",
				factoryMethods = listOf("byIds"),
				targetFilter = "UserByIdsFilter",
			),
			FilterOptionGroup(
				name = "byPatientId",
				factoryMethods = listOf("byPatientId"),
				targetFilter = "UsersByPatientIdFilter",
			),
			FilterOptionGroup(
				name = "byHealthcarePartyId",
				factoryMethods = listOf("byHealthcarePartyId"),
				targetFilter = "UserByHealthcarePartyIdFilter",
			),
			FilterOptionGroup(
				name = "byNameEmailOrPhone",
				factoryMethods = listOf("byNameEmailOrPhone"),
				targetFilter = "UserByNameEmailPhoneFilter",
			),
		),
	)
}
