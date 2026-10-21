// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.CardinalMaintenanceTaskApi
import com.icure.cardinal.sdk.js.api.CardinalMaintenanceTaskApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.sdk.KeyPairUpdateNotificationJs
import com.icure.cardinal.sdk.js.model.sdk.keyPairUpdateNotification_fromJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CardinalMaintenanceTaskApiImplJs(
	private val cardinalMaintenanceTaskApi: CardinalMaintenanceTaskApi,
) : CardinalMaintenanceTaskApiJs {
	override fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotificationJs): Promise<Unit> = GlobalScope.promise {
		val updateRequestConverted: KeyPairUpdateNotification = keyPairUpdateNotification_fromJs(updateRequest)
		cardinalMaintenanceTaskApi.applyKeyPairUpdate(
			updateRequestConverted,
		)

	}

	override fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(key: String, options: dynamic): Promise<Unit> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val keyConverted: SpkiHexString = spkiHexString_fromJs(key)
			val requestToOwnerTypesConverted: Set<DataOwnerType>? = convertingOptionOrDefaultNullable(
				_options,
				"requestToOwnerTypes",
				null
			) { requestToOwnerTypes: Array<String>? ->
				arrayToSet(
					requestToOwnerTypes,
					"requestToOwnerTypes",
					{ x1: String ->
						DataOwnerType.valueOf(x1)
					},
				)
			}
			cardinalMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
				keyConverted,
				requestToOwnerTypesConverted,
			)

		}
	}

	override fun createKeyPairUpdateNotificationTo(dataOwnerId: String, key: String): Promise<Unit> = GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val keyConverted: SpkiHexString = spkiHexString_fromJs(key)
		cardinalMaintenanceTaskApi.createKeyPairUpdateNotificationTo(
			dataOwnerIdConverted,
			keyConverted,
		)

	}
}
