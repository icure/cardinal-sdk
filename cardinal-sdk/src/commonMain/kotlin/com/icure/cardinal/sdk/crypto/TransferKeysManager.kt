package com.icure.cardinal.sdk.crypto

import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal interface TransferKeysManager {
	/**
	 * Analyses the transfer keys graph and creates new transfer keys which allow to improve data accessibility from other devices.
	 * For security reasons transfer keys will only be created between keys verified by the user, but this will be done ignoring any existing edges from
	 * unverified keys to verified keys.
	 * If the current data owner is not the delegator actor of this SDK instance this method will do nothing.
	 */
	suspend fun updateSelfTransferKeys()
}