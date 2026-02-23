package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CryptoActor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface DataOwnerWithType {
	public val dataOwner: CryptoActor

	@Serializable
	@SerialName("hcp")
	public data class HcpDataOwner(
		override val dataOwner: HealthcareParty,
	) : DataOwnerWithType

	@Serializable
	@SerialName("patient")
	public data class PatientDataOwner(
		override val dataOwner: EncryptedPatient,
	) : DataOwnerWithType

	@Serializable
	@SerialName("device")
	public data class DeviceDataOwner(
		override val dataOwner: Device,
	) : DataOwnerWithType
}
