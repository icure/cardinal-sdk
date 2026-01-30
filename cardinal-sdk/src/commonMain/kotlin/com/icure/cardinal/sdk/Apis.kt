package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.api.AccessLogApi
import com.icure.cardinal.sdk.api.AccessLogBasicApi
import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.AnonymousAgendaApi
import com.icure.cardinal.sdk.api.AnonymousHealthcarePartyApi
import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.api.CalendarItemApi
import com.icure.cardinal.sdk.api.CalendarItemBasicApi
import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.CardinalMaintenanceTaskApi
import com.icure.cardinal.sdk.api.CodeApi
import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.api.ContactBasicApi
import com.icure.cardinal.sdk.api.CryptoApi
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.DeviceApi
import com.icure.cardinal.sdk.api.DocumentApi
import com.icure.cardinal.sdk.api.DocumentBasicApi
import com.icure.cardinal.sdk.api.FormApi
import com.icure.cardinal.sdk.api.FormBasicApi
import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.api.HealthElementApi
import com.icure.cardinal.sdk.api.HealthElementBasicApi
import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.api.InvoiceBasicApi
import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.api.MessageBasicApi
import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.api.PermissionApi
import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.ReceiptApi
import com.icure.cardinal.sdk.api.ReceiptBasicApi
import com.icure.cardinal.sdk.api.RecoveryApi
import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.TopicApi
import com.icure.cardinal.sdk.api.TopicBasicApi
import com.icure.cardinal.sdk.api.UserApi

/**
 * Apis that are completely independent of the cryptographic context.
 */
interface CardinalNonCryptoApis {
	// api root
	val code: CodeApi
	val calendarItemType: CalendarItemTypeApi
	val device: DeviceApi
	val frontEndMigration: FrontEndMigrationApi
	val group: GroupApi
	val healthcareParty: HealthcarePartyApi
	val system: SystemApi
	val insurance: InsuranceApi
	val permission: PermissionApi
	val place: PlaceApi
	val role: RoleApi
	val user: UserApi
	val auth: AuthApi
	val agenda: AgendaApi
}

/**
 * Adds to [CardinalNonCryptoApis] the apis that require a data owner cryptographic context.
 * The apis added by this interface can only be used if the logged user is a data owner.
 */
interface CardinalApis : CardinalNonCryptoApis {
	// flavoured
	val accessLog: AccessLogApi
	val calendarItem: CalendarItemApi
	val contact: ContactApi
	val document: DocumentApi
	val form: FormApi
	val healthElement: HealthElementApi
	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val invoice: InvoiceApi
	val message: MessageApi
	val patient: PatientApi
	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val receipt: ReceiptApi
	val topic: TopicApi
	// api root
	val crypto: CryptoApi
	val recovery: RecoveryApi
	// extended
	val cardinalMaintenanceTask: CardinalMaintenanceTaskApi
	val dataOwner: DataOwnerApi
}

/**
 * Adds to [CardinalNonCryptoApis] the apis that require a limited cryptographic context, for example only the information
 * about which fields need to be encrypted for each entity, but there is no need to perform any actual cryptographic
 * operations.
 * The apis added by this interface can only be used even if the logged user is not a data owner
 */
interface CardinalBaseApis : CardinalNonCryptoApis {
	val accessLog: AccessLogBasicApi
	val calendarItem: CalendarItemBasicApi
	val contact: ContactBasicApi
	val document: DocumentBasicApi
	val form: FormBasicApi
	val healthElement: HealthElementBasicApi
	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val invoice: InvoiceBasicApi
	val message: MessageBasicApi
	val patient: PatientBasicApi
	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val receipt: ReceiptBasicApi
	val topic: TopicBasicApi
}

interface CardinalAnonymousApis {
	val agenda: AnonymousAgendaApi
	val healthcareParty: AnonymousHealthcarePartyApi
}
