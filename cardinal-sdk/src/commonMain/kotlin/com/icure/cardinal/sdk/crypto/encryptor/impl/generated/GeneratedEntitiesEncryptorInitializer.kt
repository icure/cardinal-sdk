// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntitiesEncryptorsInitializer
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedApplicationSettings
import com.icure.cardinal.sdk.model.DecryptedArticle
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedProperty
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedApplicationSettings
import com.icure.cardinal.sdk.model.EncryptedArticle
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedProperty
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.utils.InternalIcureApi
import kotlin.Pair
import kotlin.collections.Map
import kotlin.reflect.KClass

@InternalIcureApi
internal object GeneratedEntitiesEncryptorInitializer : AbstractEntitiesEncryptorsInitializer() {
	override val encryptorFactoriesByType:
		Map<Pair<KClass<*>, KClass<*>>, AbstractEntitiesEncryptorsInitializer.Factories<*, *>> =
		mapOf(
			Pair(
				EncryptedAccessLog::class,
				DecryptedAccessLog::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = AccessLogEncryptorFactory,
					decryptor = AccessLogDecryptorFactory,
				),
			Pair(
				EncryptedAddress::class,
				DecryptedAddress::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = AddressEncryptorFactory,
					decryptor = AddressDecryptorFactory,
				),
			Pair(
				EncryptedAnnotation::class,
				DecryptedAnnotation::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = AnnotationEncryptorFactory,
					decryptor = AnnotationDecryptorFactory,
				),
			Pair(
				EncryptedApplicationSettings::class,
				DecryptedApplicationSettings::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ApplicationSettingsEncryptorFactory,
					decryptor = ApplicationSettingsDecryptorFactory,
				),
			Pair(
				EncryptedArticle::class,
				DecryptedArticle::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ArticleEncryptorFactory,
					decryptor = ArticleDecryptorFactory,
				),
			Pair(
				EncryptedCalendarItem::class,
				DecryptedCalendarItem::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = CalendarItemEncryptorFactory,
					decryptor = CalendarItemDecryptorFactory,
				),
			Pair(
				EncryptedCalendarItemTag::class,
				DecryptedCalendarItemTag::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = CalendarItemTagEncryptorFactory,
					decryptor = CalendarItemTagDecryptorFactory,
				),
			Pair(
				EncryptedCareTeamMember::class,
				DecryptedCareTeamMember::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = CareTeamMemberEncryptorFactory,
					decryptor = CareTeamMemberDecryptorFactory,
				),
			Pair(
				EncryptedCareTeamMembership::class,
				DecryptedCareTeamMembership::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = CareTeamMembershipEncryptorFactory,
					decryptor = CareTeamMembershipDecryptorFactory,
				),
			Pair(
				EncryptedClassification::class,
				DecryptedClassification::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ClassificationEncryptorFactory,
					decryptor = ClassificationDecryptorFactory,
				),
			Pair(
				EncryptedContact::class,
				DecryptedContact::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ContactEncryptorFactory,
					decryptor = ContactDecryptorFactory,
				),
			Pair(
				EncryptedContent::class,
				DecryptedContent::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ContentEncryptorFactory,
					decryptor = ContentDecryptorFactory,
				),
			Pair(
				EncryptedDocument::class,
				DecryptedDocument::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = DocumentEncryptorFactory,
					decryptor = DocumentDecryptorFactory,
				),
			Pair(
				EncryptedEmploymentInfo::class,
				DecryptedEmploymentInfo::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = EmploymentInfoEncryptorFactory,
					decryptor = EmploymentInfoDecryptorFactory,
				),
			Pair(
				EncryptedEpisode::class,
				DecryptedEpisode::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = EpisodeEncryptorFactory,
					decryptor = EpisodeDecryptorFactory,
				),
			Pair(
				EncryptedFinancialInstitutionInformation::class,
				DecryptedFinancialInstitutionInformation::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = FinancialInstitutionInformationEncryptorFactory,
					decryptor = FinancialInstitutionInformationDecryptorFactory,
				),
			Pair(
				EncryptedFlatRateTarification::class,
				DecryptedFlatRateTarification::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = FlatRateTarificationEncryptorFactory,
					decryptor = FlatRateTarificationDecryptorFactory,
				),
			Pair(
				EncryptedForm::class,
				DecryptedForm::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = FormEncryptorFactory,
					decryptor = FormDecryptorFactory,
				),
			Pair(
				EncryptedHealthElement::class,
				DecryptedHealthElement::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = HealthElementEncryptorFactory,
					decryptor = HealthElementDecryptorFactory,
				),
			Pair(
				EncryptedInsurability::class,
				DecryptedInsurability::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = InsurabilityEncryptorFactory,
					decryptor = InsurabilityDecryptorFactory,
				),
			Pair(
				EncryptedInvoice::class,
				DecryptedInvoice::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = InvoiceEncryptorFactory,
					decryptor = InvoiceDecryptorFactory,
				),
			Pair(
				EncryptedInvoicingCode::class,
				DecryptedInvoicingCode::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = InvoicingCodeEncryptorFactory,
					decryptor = InvoicingCodeDecryptorFactory,
				),
			Pair(
				EncryptedMaintenanceTask::class,
				DecryptedMaintenanceTask::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = MaintenanceTaskEncryptorFactory,
					decryptor = MaintenanceTaskDecryptorFactory,
				),
			Pair(
				EncryptedMedicalHouseContract::class,
				DecryptedMedicalHouseContract::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = MedicalHouseContractEncryptorFactory,
					decryptor = MedicalHouseContractDecryptorFactory,
				),
			Pair(
				EncryptedMessage::class,
				DecryptedMessage::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = MessageEncryptorFactory,
					decryptor = MessageDecryptorFactory,
				),
			Pair(
				EncryptedPartnership::class,
				DecryptedPartnership::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PartnershipEncryptorFactory,
					decryptor = PartnershipDecryptorFactory,
				),
			Pair(
				EncryptedPatient::class,
				DecryptedPatient::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PatientEncryptorFactory,
					decryptor = PatientDecryptorFactory,
				),
			Pair(
				EncryptedPatientHealthCareParty::class,
				DecryptedPatientHealthCareParty::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PatientHealthCarePartyEncryptorFactory,
					decryptor = PatientHealthCarePartyDecryptorFactory,
				),
			Pair(
				EncryptedPlanOfAction::class,
				DecryptedPlanOfAction::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PlanOfActionEncryptorFactory,
					decryptor = PlanOfActionDecryptorFactory,
				),
			Pair(
				EncryptedProperty::class,
				DecryptedProperty::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PropertyEncryptorFactory,
					decryptor = PropertyDecryptorFactory,
				),
			Pair(
				EncryptedPropertyStub::class,
				DecryptedPropertyStub::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = PropertyStubEncryptorFactory,
					decryptor = PropertyStubDecryptorFactory,
				),
			Pair(
				EncryptedReceipt::class,
				DecryptedReceipt::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ReceiptEncryptorFactory,
					decryptor = ReceiptDecryptorFactory,
				),
			Pair(
				EncryptedSchoolingInfo::class,
				DecryptedSchoolingInfo::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = SchoolingInfoEncryptorFactory,
					decryptor = SchoolingInfoDecryptorFactory,
				),
			Pair(
				EncryptedSecureDelegationKeyMap::class,
				DecryptedSecureDelegationKeyMap::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = SecureDelegationKeyMapEncryptorFactory,
					decryptor = SecureDelegationKeyMapDecryptorFactory,
				),
			Pair(
				EncryptedService::class,
				DecryptedService::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ServiceEncryptorFactory,
					decryptor = ServiceDecryptorFactory,
				),
			Pair(
				EncryptedSubContact::class,
				DecryptedSubContact::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = SubContactEncryptorFactory,
					decryptor = SubContactDecryptorFactory,
				),
			Pair(
				EncryptedTelecom::class,
				DecryptedTelecom::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = TelecomEncryptorFactory,
					decryptor = TelecomDecryptorFactory,
				),
			Pair(
				EncryptedTopic::class,
				DecryptedTopic::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = TopicEncryptorFactory,
					decryptor = TopicDecryptorFactory,
				),
			Pair(
				EncryptedTypedValue::class,
				DecryptedTypedValue::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = TypedValueEncryptorFactory,
					decryptor = TypedValueDecryptorFactory,
				),
			Pair(
				EncryptedValorisation::class,
				DecryptedValorisation::class,
			) to
				AbstractEntitiesEncryptorsInitializer.Factories(
					encryptor = ValorisationEncryptorFactory,
					decryptor = ValorisationDecryptorFactory,
				),
		)
}
