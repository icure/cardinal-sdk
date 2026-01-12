package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CardinalMaintenanceTaskApi
import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.MaintenanceTaskApi
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.PropertyTypeStub
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TaskStatus
import com.icure.cardinal.sdk.model.embed.TypedValuesType
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.StrongRandom
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class CardinalMaintenanceTaskApiImpl(
	private val exchangeDataManager: ExchangeDataManager,
	private val baseExchangeKeysManager: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager,
	private val maintenanceTaskApi: MaintenanceTaskApi,
	private val dataOwnerApi: DataOwnerApi,
	private val strongRandom: StrongRandom
) : CardinalMaintenanceTaskApi {
	companion object {
		private val log = getLogger("IcureMaintenanceTaskApi")
	}

	override suspend fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotification) {
		val concernedDataOwnerStub = dataOwnerApi.getCryptoActorStub(updateRequest.concernedDataOwnerId).stub
		require(updateRequest.newPublicKey in concernedDataOwnerStub.publicKeysSpki) {
			"Invalid key pair update notification: data owner ${updateRequest.concernedDataOwnerId} does not have a key ${updateRequest.newPublicKey}"
		}
		if (dataOwnerApi.getCurrentDataOwnerId() != userKeysManager.delegatorActorId()) throw UnsupportedOperationException(
			"Give access back is currently not supported when the SDK is initialized in ParentDelegator mode"
		)
		exchangeDataManager.giveAccessBackTo(
			updateRequest.concernedDataOwnerId,
			updateRequest.newPublicKey
		)
		baseExchangeKeysManager.giveAccessBackTo(
			updateRequest.concernedDataOwnerId,
			updateRequest.newPublicKey,
			userKeysManager.getAllDecryptionKeys()
		)
	}

	override suspend fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(
		key: SpkiHexString,
		requestToOwnerTypes: Set<DataOwnerType>?
	) {
		if (dataOwnerApi.getCurrentDataOwnerId() != userKeysManager.delegatorActorId()) throw UnsupportedOperationException(
			"Give access back requests are currently not supported when the SDK is initialized in ParentDelegator mode"
		)
		val doRequestTo = requestToOwnerTypes ?: when (dataOwnerApi.getCurrentDataOwnerType()) {
			DataOwnerType.Device -> {
				log.w { "Current data owner is a device, no maintenance task for updated keypair will be created by default." }
				emptySet()
			}
			DataOwnerType.Patient -> setOf(DataOwnerType.Patient, DataOwnerType.Hcp)
			DataOwnerType.Hcp -> setOf(DataOwnerType.Hcp)
		}
		if (doRequestTo.isEmpty()) return
		doCreateKeyPairUpdateNotifications(getUpdateRequestCandidatesIdsFor(key, doRequestTo), key)
	}

	override suspend fun createKeyPairUpdateNotificationTo(
		dataOwnerId: String,
		key: SpkiHexString
	) {
		if (dataOwnerApi.getCurrentDataOwnerId() != userKeysManager.delegatorActorId()) throw UnsupportedOperationException(
			"Give access back requests are currently not supported when the SDK is initialized in ParentDelegator mode"
		)
		return doCreateKeyPairUpdateNotifications(setOf(dataOwnerId), key)
	}

	// TODO way to lookup key pair update maintenance tasks

	private suspend fun doCreateKeyPairUpdateNotifications(
		to: Set<String>,
		key: SpkiHexString
	) {
		requireNotNull(userKeysManager.getKeyPairForFingerprint(key.fingerprintV2())) {
			"Key ${key.fingerprintV1()} is not available to the current user: no reason to create a keypair notification."
		}
		if (to.isEmpty()) return
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val tasks = to.map { initializeMaintenanceTaskTo(self, it, key) }
		// TODO bulk create
		tasks.forEach { maintenanceTaskApi.createMaintenanceTask(it) }
	}

	private suspend fun initializeMaintenanceTaskTo(
		self: String,
		other: String,
		key: SpkiHexString
	) =
		maintenanceTaskApi.withEncryptionMetadata(
			DecryptedMaintenanceTask(
				id = strongRandom.randomUUID(),
				taskType = KeyPairUpdateNotification.TASK_TYPE,
				status = TaskStatus.Pending,
				properties = setOf(
					DecryptedPropertyStub(
						id = KeyPairUpdateNotification.OWNER_ID_PROPERTY_ID,
						type = PropertyTypeStub(type = TypedValuesType.String),
						typedValue = DecryptedTypedValue(
							type = TypedValuesType.String,
							stringValue = self
						)
					),
					DecryptedPropertyStub(
						id = KeyPairUpdateNotification.OWNER_PUBLIC_KEY_PROPERTY_ID,
						type = PropertyTypeStub(type = TypedValuesType.String),
						typedValue = DecryptedTypedValue(
							type = TypedValuesType.String,
							stringValue = key.s
						)
					)
				)
			),
			null,
			mapOf(other to AccessLevel.Write)
		)

	// All data owners that have something shared with the current data owner and the new key does not provide access to at least one of the existing exchange keys.
	private suspend fun getUpdateRequestCandidatesIdsFor(
		key: SpkiHexString,
		requestToOwnerTypes: Set<DataOwnerType>
	): Set<String> {
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val candidatesForExchangeData = exchangeDataManager.base.raw.getParticipantCounterparts(
			self,
			requestToOwnerTypes.joinToString(","),
			key.fingerprintV2().s
		).successBody().toSet()
		val fingerprintV1 = key.fingerprintV1()
		val exchangeKeysInfo = baseExchangeKeysManager.getAllExchangeKeysWith(self, requestToOwnerTypes)
		val candidatesForExchangeKeys =
			(exchangeKeysInfo.exchangeKeysByDataOwnerTo + exchangeKeysInfo.exchangeKeysToDataOwnerFrom).mapNotNullTo(
				mutableSetOf()
			) { (k, v) ->
				k.takeIf {
					v.any {
						!it.keys.mapNotNullTo(mutableSetOf()) { k -> k.toFingerprintV1OrNull() }.contains(fingerprintV1)
					}
				}
			}
		return candidatesForExchangeData + candidatesForExchangeKeys
	}
}