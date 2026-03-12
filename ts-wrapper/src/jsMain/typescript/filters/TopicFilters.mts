// auto-generated file
import {BaseFilterOptions, FilterOptions, InternalTopicFiltersObj} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Topic} from '../model/Topic.mjs';


interface TopicFiltersFactory {

	/**
	 *
	 *  Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 *  @param dataOwnerId a data owner id or null to use the current data owner id
	 *  @return options for topic filtering
	 */
	allTopicsForDataOwner(dataOwnerId: string): BaseFilterOptions<Topic>;

	/**
	 *
	 *  In-group version of [allTopicsForDataOwner].
	 */
	allTopicsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Topic>;

	/**
	 *
	 *  Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with the current data owner.
	 *  @return options for topic filtering
	 */
	allTopicsForSelf(): FilterOptions<Topic>;

	/**
	 *
	 *  Creates options for topic filtering that will match all topics where the provided data owner is an active
	 *  participant.
	 *  @param participantId a data owner id
	 */
	byParticipant(participantId: string): FilterOptions<Topic>;

	/**
	 *
	 *  In-group version of [byParticipant].
	 */
	byParticipantInGroup(participant: EntityReferenceInGroup): FilterOptions<Topic>;

}

export const TopicFilters: TopicFiltersFactory = {
			allTopicsForDataOwner: (dataOwnerId) => InternalTopicFiltersObj.getInstance().allTopicsForDataOwner(dataOwnerId),
			allTopicsForDataOwnerInGroup: (dataOwner) => InternalTopicFiltersObj.getInstance().allTopicsForDataOwnerInGroup(dataOwner),
			allTopicsForSelf: () => InternalTopicFiltersObj.getInstance().allTopicsForSelf(),
			byParticipant: (participantId) => InternalTopicFiltersObj.getInstance().byParticipant(participantId),
			byParticipantInGroup: (participant) => InternalTopicFiltersObj.getInstance().byParticipantInGroup(participant)
		};
