package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.HealthcarePartyFilters
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import io.kotest.assertions.fail
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.seconds

// Reproducer for https://github.com/icure/cardinal-sdk/issues/740
class HealthcarePartySubscriptionTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	suspend fun subscribe(
		subscriber: DataOwnerDetails,
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<HealthcareParty>,
	): EntitySubscription<HealthcareParty> {
		val subscription = subscriber.api(specJob).healthcareParty.subscribeToEvents(events = events, filter = filter)
		withTimeoutOrNull(5.seconds) {
			subscription.eventChannel.receive() shouldBe EntitySubscriptionEvent.Connected
		} ?: fail("Didn't receive OPEN event within 5 seconds")
		return subscription
	}

	suspend fun EntitySubscription<HealthcareParty>.shouldReceiveEventFor(hcpId: String) {
		withTimeoutOrNull(5.seconds) {
			eventChannel.receive().shouldBeInstanceOf<EntitySubscriptionEvent.EntityNotification<HealthcareParty>>()
				.entity.id shouldBe hcpId
		} ?: fail("Didn't receive ENTITY event for $hcpId within 5 seconds")
	}

	// The healthcare party modifies itself (another user than the subscriber)
	suspend fun DataOwnerDetails.modifySelf() {
		val api = api(specJob)
		val current = api.healthcareParty.getCurrentHealthcareParty()
		api.healthcareParty.modifyHealthcareParty(current.copy(firstName = "Modified-${uuid()}"))
	}

	"Unrelated hcp in the same group should receive update events of another hcp (filter by ids)".config(
		enabled = false // future development
	) {
		val subscriber = createHcpUser()
		val target = createHcpUser()
		val subscription = subscribe(
			subscriber,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(target.dataOwnerId))
		)
		target.modifySelf()
		subscription.shouldReceiveEventFor(target.dataOwnerId)
	}

	"Unrelated hcp in the same group should receive update events of another hcp (filter all)".config(
		enabled = false // future development
	) {
		val subscriber = createHcpUser()
		val target = createHcpUser()
		val subscription = subscribe(
			subscriber,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.all()
		)
		target.modifySelf()
		subscription.shouldReceiveEventFor(target.dataOwnerId)
	}

	"Unrelated hcp in the same group should receive create events of other hcps (filter all)".config(
		enabled = false // future development
	) {
		val subscriber = createHcpUser()
		val subscription = subscribe(
			subscriber,
			setOf(SubscriptionEventType.Create),
			HealthcarePartyFilters.all()
		)
		val created = createHcpUser()
		subscription.shouldReceiveEventFor(created.dataOwnerId)
	}

	// A single link to a parent-type group sets the (hidden) legacy parentId of the child
	"Parent hcp should receive update events of its child (filter by ids)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val parent = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val child = createHcpUser(parent = parent, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val subscription = subscribe(
			parent,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		child.modifySelf()
		subscription.shouldReceiveEventFor(child.dataOwnerId)
	}

	"Parent hcp should receive create events of its new children (filter by parent id)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val parent = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val subscription = subscribe(
			parent,
			setOf(SubscriptionEventType.Create),
			HealthcarePartyFilters.byParentId(parent.dataOwnerId)
		)
		val child = createHcpUser(parent = parent, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		subscription.shouldReceiveEventFor(child.dataOwnerId)
	}
})
