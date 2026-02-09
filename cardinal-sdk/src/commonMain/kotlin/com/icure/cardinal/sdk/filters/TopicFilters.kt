package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.topic.TopicByParticipantFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object TopicFilters {
	/**
	 * Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @return options for topic filtering
	 */
	fun allTopicsForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Topic> = AllForDataOwner(EntityReferenceInGroup(groupId = null, entityId = dataOwnerId))

	/**
	 * In-group version of [allTopicsForDataOwner].
	 */
	fun allTopicsForDataOwner(
		dataOwner: EntityReferenceInGroup,
	): BaseFilterOptions<Topic> = AllForDataOwner(dataOwner)

	/**
	 * Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * @return options for topic filtering
	 */
	fun allTopicsForSelf(): FilterOptions<Topic> =
		AllForSelf

	/**
	 * Creates options for topic filtering that will match all topics where the provided data owner is an active
	 * participant.
	 * @param participantId a data owner id
	 */
	fun byParticipant(
		participantId: String
	): FilterOptions<Topic> = 
		ByParticipant(EntityReferenceInGroup(groupId = null, entityId = participantId))

	/**
	 * In-group version of [byParticipant].
	 */
	fun byParticipant(
		participant: EntityReferenceInGroup,
	): FilterOptions<Topic> = ByParticipant(participant)

	@Serializable
	internal class AllForDataOwner(
		val dataOwner: EntityReferenceInGroup
	) : BaseFilterOptions<Topic>

	@Serializable
	internal data object AllForSelf : FilterOptions<Topic>

	@Serializable
	internal class ByParticipant(
		val participantId: EntityReferenceInGroup
	) : BaseFilterOptions<Topic>
}

@InternalIcureApi
internal suspend fun mapTopicFilterOptions(
	filterOptions: FilterOptions<Topic>,
	config: BasicApiConfiguration,
	requestGroup: String?
): AbstractFilter<Topic> {
	val nonBasicConfig = config as? ApiConfiguration
	return mapTopicFilterOptions(
		filterOptions,
		nonBasicConfig?.crypto?.dataOwnerApi?.getCurrentDataOwnerReference(),
		nonBasicConfig?.crypto?.entity,
		config.getBoundGroup(currentCoroutineContext()),
		requestGroup
	)
}

@InternalIcureApi
private suspend fun mapTopicFilterOptions(
	filterOptions: FilterOptions<Topic>,
	selfDataOwner: EntityReferenceInGroup?,
	entityEncryptionService: EntityEncryptionService?,
	boundGroup: SdkBoundGroup?,
	requestGroup: String?
): AbstractFilter<Topic> = mapIfMetaFilterOptions(filterOptions) {
	mapTopicFilterOptions(it, selfDataOwner, entityEncryptionService, boundGroup, requestGroup)
} ?: when (filterOptions) {
	is TopicFilters.AllForDataOwner -> {
		TopicByHcPartyFilter(hcpId = filterOptions.dataOwner.asReferenceStringInGroup(requestGroup, boundGroup))
	}
	TopicFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwner, entityEncryptionService)
		TopicByHcPartyFilter(hcpId = selfDataOwner.asReferenceStringInGroup(requestGroup, boundGroup))
	}
	is TopicFilters.ByParticipant -> {
		TopicByParticipantFilter(participantId = filterOptions.participantId.asReferenceStringInGroup(requestGroup, boundGroup))
	}
	else -> {
		throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Topics")
	}
}
