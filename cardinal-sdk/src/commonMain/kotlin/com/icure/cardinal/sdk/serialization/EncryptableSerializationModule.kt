// This file is auto-generated
package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.ApplicationSettings
import com.icure.cardinal.sdk.model.Article
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.Contact
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
import com.icure.cardinal.sdk.model.Document
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
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.Property
import com.icure.cardinal.sdk.model.PropertyStub
import com.icure.cardinal.sdk.model.Receipt
import com.icure.cardinal.sdk.model.SecureDelegationKeyMap
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.CalendarItemTag
import com.icure.cardinal.sdk.model.embed.CareTeamMember
import com.icure.cardinal.sdk.model.embed.CareTeamMembership
import com.icure.cardinal.sdk.model.embed.Content
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
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
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
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
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.model.embed.Episode
import com.icure.cardinal.sdk.model.embed.FinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.FlatRateTarification
import com.icure.cardinal.sdk.model.embed.Insurability
import com.icure.cardinal.sdk.model.embed.InvoicingCode
import com.icure.cardinal.sdk.model.embed.MedicalHouseContract
import com.icure.cardinal.sdk.model.embed.PatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.PlanOfAction
import com.icure.cardinal.sdk.model.embed.SchoolingInfo
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.embed.SubContact
import com.icure.cardinal.sdk.model.embed.Telecom
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.embed.Valorisation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

internal object EncryptableSerializationModule {
	public val module: SerializersModule =
		SerializersModule {
			polymorphic(AccessLog::class) {
				subclass(DecryptedAccessLog::class)
				subclass(EncryptedAccessLog::class)
			}
			polymorphic(Address::class) {
				subclass(DecryptedAddress::class)
				subclass(EncryptedAddress::class)
			}
			polymorphic(ApplicationSettings::class) {
				subclass(DecryptedApplicationSettings::class)
				subclass(EncryptedApplicationSettings::class)
			}
			polymorphic(Article::class) {
				subclass(DecryptedArticle::class)
				subclass(EncryptedArticle::class)
			}
			polymorphic(CalendarItem::class) {
				subclass(DecryptedCalendarItem::class)
				subclass(EncryptedCalendarItem::class)
			}
			polymorphic(CalendarItemTag::class) {
				subclass(DecryptedCalendarItemTag::class)
				subclass(EncryptedCalendarItemTag::class)
			}
			polymorphic(CareTeamMember::class) {
				subclass(DecryptedCareTeamMember::class)
				subclass(EncryptedCareTeamMember::class)
			}
			polymorphic(CareTeamMembership::class) {
				subclass(DecryptedCareTeamMembership::class)
				subclass(EncryptedCareTeamMembership::class)
			}
			polymorphic(Classification::class) {
				subclass(DecryptedClassification::class)
				subclass(EncryptedClassification::class)
			}
			polymorphic(Contact::class) {
				subclass(DecryptedContact::class)
				subclass(EncryptedContact::class)
			}
			polymorphic(Content::class) {
				subclass(DecryptedContent::class)
				subclass(EncryptedContent::class)
			}
			polymorphic(Document::class) {
				subclass(DecryptedDocument::class)
				subclass(EncryptedDocument::class)
			}
			polymorphic(EmploymentInfo::class) {
				subclass(DecryptedEmploymentInfo::class)
				subclass(EncryptedEmploymentInfo::class)
			}
			polymorphic(Episode::class) {
				subclass(DecryptedEpisode::class)
				subclass(EncryptedEpisode::class)
			}
			polymorphic(FinancialInstitutionInformation::class) {
				subclass(DecryptedFinancialInstitutionInformation::class)
				subclass(EncryptedFinancialInstitutionInformation::class)
			}
			polymorphic(FlatRateTarification::class) {
				subclass(DecryptedFlatRateTarification::class)
				subclass(EncryptedFlatRateTarification::class)
			}
			polymorphic(Form::class) {
				subclass(DecryptedForm::class)
				subclass(EncryptedForm::class)
			}
			polymorphic(HealthElement::class) {
				subclass(DecryptedHealthElement::class)
				subclass(EncryptedHealthElement::class)
			}
			polymorphic(Insurability::class) {
				subclass(DecryptedInsurability::class)
				subclass(EncryptedInsurability::class)
			}
			polymorphic(Invoice::class) {
				subclass(DecryptedInvoice::class)
				subclass(EncryptedInvoice::class)
			}
			polymorphic(InvoicingCode::class) {
				subclass(DecryptedInvoicingCode::class)
				subclass(EncryptedInvoicingCode::class)
			}
			polymorphic(MaintenanceTask::class) {
				subclass(DecryptedMaintenanceTask::class)
				subclass(EncryptedMaintenanceTask::class)
			}
			polymorphic(MedicalHouseContract::class) {
				subclass(DecryptedMedicalHouseContract::class)
				subclass(EncryptedMedicalHouseContract::class)
			}
			polymorphic(Message::class) {
				subclass(DecryptedMessage::class)
				subclass(EncryptedMessage::class)
			}
			polymorphic(Patient::class) {
				subclass(DecryptedPatient::class)
				subclass(EncryptedPatient::class)
			}
			polymorphic(PatientHealthCareParty::class) {
				subclass(DecryptedPatientHealthCareParty::class)
				subclass(EncryptedPatientHealthCareParty::class)
			}
			polymorphic(PlanOfAction::class) {
				subclass(DecryptedPlanOfAction::class)
				subclass(EncryptedPlanOfAction::class)
			}
			polymorphic(Property::class) {
				subclass(DecryptedProperty::class)
				subclass(EncryptedProperty::class)
			}
			polymorphic(PropertyStub::class) {
				subclass(DecryptedPropertyStub::class)
				subclass(EncryptedPropertyStub::class)
			}
			polymorphic(Receipt::class) {
				subclass(DecryptedReceipt::class)
				subclass(EncryptedReceipt::class)
			}
			polymorphic(SchoolingInfo::class) {
				subclass(DecryptedSchoolingInfo::class)
				subclass(EncryptedSchoolingInfo::class)
			}
			polymorphic(SecureDelegationKeyMap::class) {
				subclass(DecryptedSecureDelegationKeyMap::class)
				subclass(EncryptedSecureDelegationKeyMap::class)
			}
			polymorphic(Service::class) {
				subclass(DecryptedService::class)
				subclass(EncryptedService::class)
			}
			polymorphic(SubContact::class) {
				subclass(DecryptedSubContact::class)
				subclass(EncryptedSubContact::class)
			}
			polymorphic(Telecom::class) {
				subclass(DecryptedTelecom::class)
				subclass(EncryptedTelecom::class)
			}
			polymorphic(Topic::class) {
				subclass(DecryptedTopic::class)
				subclass(EncryptedTopic::class)
			}
			polymorphic(TypedValue::class) {
				subclass(DecryptedTypedValue::class)
				subclass(EncryptedTypedValue::class)
			}
			polymorphic(Valorisation::class) {
				subclass(DecryptedValorisation::class)
				subclass(EncryptedValorisation::class)
			}
		}
}
