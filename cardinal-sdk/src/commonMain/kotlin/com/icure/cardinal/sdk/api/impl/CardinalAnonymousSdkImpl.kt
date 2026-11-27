package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.CardinalAnonymousSdk
import com.icure.cardinal.sdk.api.AnonymousAgendaApi
import com.icure.cardinal.sdk.api.AnonymousHealthcarePartyApi
import com.icure.cardinal.sdk.api.AnonymousRoleApi
import com.icure.cardinal.sdk.api.raw.RawAnonymousApi
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class CardinalAnonymousSdkImpl(
	private val rawAnonymousApi: RawAnonymousApi,
	private val designDocSchemaVersion: Int? = null,
): CardinalAnonymousSdk {
	override val agenda: AnonymousAgendaApi by lazy {
		AnonymousAgendaApiImpl(raw = rawAnonymousApi, designDocSchemaVersion = designDocSchemaVersion)
	}
	override val healthcareParty: AnonymousHealthcarePartyApi by lazy {
		AnonymousHealthcarePartyApiImpl(
			raw = rawAnonymousApi,
			designDocSchemaVersion = designDocSchemaVersion
		)
	}
	override val role: AnonymousRoleApi by lazy { AnonymousRoleApiImpl(rawAnonymousApi) }
}
