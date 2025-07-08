package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.CardinalAnonymousSdk
import com.icure.cardinal.sdk.api.AnonymousAgendaApi
import com.icure.cardinal.sdk.api.AnonymousHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class AnonymousSdkImpl(
	private val rawAnonymousApi: RawAnonymousApi,
): CardinalAnonymousSdk {
	override val agenda: AnonymousAgendaApi by lazy { AnonymousAgendaApiImpl(rawAnonymousApi) }
	override val healthcareParty: AnonymousHealthcarePartyApi by lazy { AnonymousHealthcarePartyApiImpl(rawAnonymousApi) }
}
