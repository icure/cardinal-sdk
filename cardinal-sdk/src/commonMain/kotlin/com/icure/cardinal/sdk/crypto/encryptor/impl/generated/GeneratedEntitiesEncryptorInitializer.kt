// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntitiesEncryptorInitializer
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
internal object GeneratedEntitiesEncryptorInitializer : AbstractEntitiesEncryptorInitializer() {
	override val encryptorFactoriesByType:
		Map<Pair<KClass<*>, KClass<*>>, EntityEncryptorFactory<*, *>> =
		mapOf(
			Pair(
				EncryptedAccessLog::class,
				DecryptedAccessLog::class,
			) to AccessLogEncryptorFactory,
			Pair(
				EncryptedAddress::class,
				DecryptedAddress::class,
			) to AddressEncryptorFactory,
			Pair(
				EncryptedAnnotation::class,
				DecryptedAnnotation::class,
			) to AnnotationEncryptorFactory,
			Pair(
				EncryptedApplicationSettings::class,
				DecryptedApplicationSettings::class,
			) to ApplicationSettingsEncryptorFactory,
			Pair(
				EncryptedArticle::class,
				DecryptedArticle::class,
			) to ArticleEncryptorFactory,
			Pair(
				EncryptedCalendarItem::class,
				DecryptedCalendarItem::class,
			) to CalendarItemEncryptorFactory,
			Pair(
				EncryptedCalendarItemTag::class,
				DecryptedCalendarItemTag::class,
			) to CalendarItemTagEncryptorFactory,
			Pair(
				EncryptedCareTeamMember::class,
				DecryptedCareTeamMember::class,
			) to CareTeamMemberEncryptorFactory,
			Pair(
				EncryptedCareTeamMembership::class,
				DecryptedCareTeamMembership::class,
			) to CareTeamMembershipEncryptorFactory,
			Pair(
				EncryptedClassification::class,
				DecryptedClassification::class,
			) to ClassificationEncryptorFactory,
			Pair(
				EncryptedContact::class,
				DecryptedContact::class,
			) to ContactEncryptorFactory,
			Pair(
				EncryptedContent::class,
				DecryptedContent::class,
			) to ContentEncryptorFactory,
			Pair(
				EncryptedDocument::class,
				DecryptedDocument::class,
			) to DocumentEncryptorFactory,
			Pair(
				EncryptedEmploymentInfo::class,
				DecryptedEmploymentInfo::class,
			) to EmploymentInfoEncryptorFactory,
			Pair(
				EncryptedEpisode::class,
				DecryptedEpisode::class,
			) to EpisodeEncryptorFactory,
			Pair(
				EncryptedFinancialInstitutionInformation::class,
				DecryptedFinancialInstitutionInformation::class,
			) to FinancialInstitutionInformationEncryptorFactory,
			Pair(
				EncryptedFlatRateTarification::class,
				DecryptedFlatRateTarification::class,
			) to FlatRateTarificationEncryptorFactory,
			Pair(
				EncryptedForm::class,
				DecryptedForm::class,
			) to FormEncryptorFactory,
			Pair(
				EncryptedHealthElement::class,
				DecryptedHealthElement::class,
			) to HealthElementEncryptorFactory,
			Pair(
				EncryptedInsurability::class,
				DecryptedInsurability::class,
			) to InsurabilityEncryptorFactory,
			Pair(
				EncryptedInvoice::class,
				DecryptedInvoice::class,
			) to InvoiceEncryptorFactory,
			Pair(
				EncryptedInvoicingCode::class,
				DecryptedInvoicingCode::class,
			) to InvoicingCodeEncryptorFactory,
			Pair(
				EncryptedMaintenanceTask::class,
				DecryptedMaintenanceTask::class,
			) to MaintenanceTaskEncryptorFactory,
			Pair(
				EncryptedMedicalHouseContract::class,
				DecryptedMedicalHouseContract::class,
			) to MedicalHouseContractEncryptorFactory,
			Pair(
				EncryptedMessage::class,
				DecryptedMessage::class,
			) to MessageEncryptorFactory,
			Pair(
				EncryptedPartnership::class,
				DecryptedPartnership::class,
			) to PartnershipEncryptorFactory,
			Pair(
				EncryptedPatient::class,
				DecryptedPatient::class,
			) to PatientEncryptorFactory,
			Pair(
				EncryptedPatientHealthCareParty::class,
				DecryptedPatientHealthCareParty::class,
			) to PatientHealthCarePartyEncryptorFactory,
			Pair(
				EncryptedPlanOfAction::class,
				DecryptedPlanOfAction::class,
			) to PlanOfActionEncryptorFactory,
			Pair(
				EncryptedProperty::class,
				DecryptedProperty::class,
			) to PropertyEncryptorFactory,
			Pair(
				EncryptedPropertyStub::class,
				DecryptedPropertyStub::class,
			) to PropertyStubEncryptorFactory,
			Pair(
				EncryptedReceipt::class,
				DecryptedReceipt::class,
			) to ReceiptEncryptorFactory,
			Pair(
				EncryptedSchoolingInfo::class,
				DecryptedSchoolingInfo::class,
			) to SchoolingInfoEncryptorFactory,
			Pair(
				EncryptedSecureDelegationKeyMap::class,
				DecryptedSecureDelegationKeyMap::class,
			) to SecureDelegationKeyMapEncryptorFactory,
			Pair(
				EncryptedService::class,
				DecryptedService::class,
			) to ServiceEncryptorFactory,
			Pair(
				EncryptedSubContact::class,
				DecryptedSubContact::class,
			) to SubContactEncryptorFactory,
			Pair(
				EncryptedTelecom::class,
				DecryptedTelecom::class,
			) to TelecomEncryptorFactory,
			Pair(
				EncryptedTopic::class,
				DecryptedTopic::class,
			) to TopicEncryptorFactory,
			Pair(
				EncryptedTypedValue::class,
				DecryptedTypedValue::class,
			) to TypedValueEncryptorFactory,
			Pair(
				EncryptedValorisation::class,
				DecryptedValorisation::class,
			) to ValorisationEncryptorFactory,
		)
}
