package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.AccessLogDelegateOptions
import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

@OptIn(InternalIcureApi::class)
class CreateWithDelegateOptionsTest : StringSpec({

	val specJob = autoCancelJob()

	lateinit var delegatorHcpApi: CardinalSdk
	lateinit var delegateHcpApi: CardinalSdk
	lateinit var patient: DecryptedPatient

	beforeSpec {
		initializeTestEnvironment()
		delegatorHcpApi = createHcpUser().api(specJob)
		delegateHcpApi = createHcpUser().api(specJob)
		patient = delegatorHcpApi.patient.createPatient(
			delegatorHcpApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "Esmerelda",
					lastName = "Weatherwax"
				)
			)
		)
	}

	fun <T : HasEncryptionMetadata> doTest(ctx: TestCtx<T>) {

		"Can share a ${ctx.entityName} with fine grained delegate access" {
			val delegateId = delegateHcpApi.dataOwner.getCurrentDataOwnerId()
			val entity = ctx.initEntity()
			val entityWithEncryptionMetadata = ctx.withEncryptionMetadata(
				api = delegatorHcpApi,
				patient = patient,
				entity = entity,
				delegates = mapOf(
					delegateId to object : DelegateOptions {
						override val accessLevel: AccessLevel
							get() = AccessLevel.Read
						override val shareEncryptionKey: Boolean
							get() = false
						override val shareSecretId: Boolean
							get() = false
						override val shareOwningEntityId: Boolean
							get() = false
					}
				)
			)

			val nonSelfDelegation = entityWithEncryptionMetadata.securityMetadata?.secureDelegations?.values?.firstOrNull {
				it.delegate == delegateId
			}.shouldNotBeNull()

			nonSelfDelegation.permissions shouldBe AccessLevel.Read
			nonSelfDelegation.secretIds.shouldBeEmpty()
			nonSelfDelegation.encryptionKeys.shouldBeEmpty()
			nonSelfDelegation.owningEntityIds.shouldBeEmpty()
		}
	}

	listOf(
		initCtx<AccessLog>()
	).forEach { ctx ->
		doTest(ctx)
	}
})

@OptIn(InternalIcureApi::class)
private inline fun <reified T : HasEncryptionMetadata> initCtx() = object : TestCtx<T> {
	override val entityName: String = T::class.simpleName!!

	override fun initEntity(): T = when(T::class.simpleName) {
		"AccessLog" -> DecryptedAccessLog(id = uuid())
		else -> throw IllegalArgumentException("Invalid class ${T::class.simpleName}")
	} as T

	override suspend fun withEncryptionMetadata(
		api: CardinalSdk,
		patient: DecryptedPatient,
		entity: T,
		delegates: Map<String, DelegateOptions>
	): T  = when(T::class.simpleName) {
		"AccessLog" -> api.accessLog.withEncryptionMetadataAndDelegates(
			base = entity as DecryptedAccessLog,
			patient = patient,
			delegates = delegates.mapValues {
				AccessLogDelegateOptions(
					accessLevel = it.value.accessLevel,
					shareEncryptionKey = it.value.shareEncryptionKey,
					shareSecretId = it.value.shareSecretId,
					sharePatientId = it.value.shareOwningEntityId
				)
			}
		)
		else -> throw IllegalArgumentException("Invalid class ${T::class.simpleName}")
	} as T
}

private interface TestCtx<T : HasEncryptionMetadata> {
	val entityName: String

	fun initEntity(): T
	@OptIn(InternalIcureApi::class)
	suspend fun withEncryptionMetadata(
		api: CardinalSdk,
		patient: DecryptedPatient,
		entity: T,
		delegates: Map<String, DelegateOptions>): T
}
