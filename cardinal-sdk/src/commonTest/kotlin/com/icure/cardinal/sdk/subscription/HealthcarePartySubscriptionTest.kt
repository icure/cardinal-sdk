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

	"Simple group hcp should receive update events of its direct member (filter by ids)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val member = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val subscription = subscribe(
			group,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(member.dataOwnerId))
		)
		member.modifySelf()
		subscription.shouldReceiveEventFor(member.dataOwnerId)
	}

	"Simple group hcp should receive create events of its new direct members (filter all)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val subscription = subscribe(
			group,
			setOf(SubscriptionEventType.Create),
			HealthcarePartyFilters.all()
		)
		val member = createHcpUser(parent = group, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		subscription.shouldReceiveEventFor(member.dataOwnerId)
	}

	"Each of multiple parent hcps should receive update events of their common child (filter by ids)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val parentA = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val parentB = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val child = createHcpUser(parents = listOf(parentA, parentB), groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val subscriptionA = subscribe(
			parentA,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		val subscriptionB = subscribe(
			parentB,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		child.modifySelf()
		subscriptionA.shouldReceiveEventFor(child.dataOwnerId)
		subscriptionB.shouldReceiveEventFor(child.dataOwnerId)
	}

	"Each of multiple parent hcps should receive create events of their new common child (filter all)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val parentA = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val parentB = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val subscriptionA = subscribe(parentA, setOf(SubscriptionEventType.Create), HealthcarePartyFilters.all())
		val subscriptionB = subscribe(parentB, setOf(SubscriptionEventType.Create), HealthcarePartyFilters.all())
		val child = createHcpUser(parents = listOf(parentA, parentB), groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		subscriptionA.shouldReceiveEventFor(child.dataOwnerId)
		subscriptionB.shouldReceiveEventFor(child.dataOwnerId)
	}

	"Each directly linked hcp should receive update events of a child with links of different types (filter by ids)".config(
		enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY
	) {
		val parent = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val group = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val child = createHcpUser(parents = listOf(parent, group), groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val parentSubscription = subscribe(
			parent,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		val groupSubscription = subscribe(
			group,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		child.modifySelf()
		parentSubscription.shouldReceiveEventFor(child.dataOwnerId)
		groupSubscription.shouldReceiveEventFor(child.dataOwnerId)
	}

	"Transitive parent hcp should receive update events of its descendant (filter by ids)".config(
		enabled = false // future development: transitive links are not handled yet
	) {
		val topParent = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Parent)
		val middleParent = createHcpUser(parent = topParent, groupLinkType = DataOwnerGroupLinkType.Parent)
		val child = createHcpUser(parent = middleParent, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val subscription = subscribe(
			topParent,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(child.dataOwnerId))
		)
		child.modifySelf()
		subscription.shouldReceiveEventFor(child.dataOwnerId)
	}

	"Transitive simple group hcp should receive update events of its transitive member (filter by ids)".config(
		enabled = false // future development: transitive links are not handled yet
	) {
		val topGroup = createHcpUser(groupLinkType = DataOwnerGroupLinkType.Simple)
		val subgroup = createHcpUser(parent = topGroup, groupLinkType = DataOwnerGroupLinkType.Simple)
		val member = createHcpUser(parent = subgroup, groupLinkType = DataOwnerGroupLinkType.NotAllowed)
		val subscription = subscribe(
			topGroup,
			setOf(SubscriptionEventType.Update),
			HealthcarePartyFilters.byIds(listOf(member.dataOwnerId))
		)
		member.modifySelf()
		subscription.shouldReceiveEventFor(member.dataOwnerId)
	}
})
