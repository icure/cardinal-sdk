// auto-generated file
import {BaseFilterOptions, FilterOptions, InternalTopicFiltersObj} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Topic} from '../model/Topic.mjs';


interface TopicFiltersFactory {

	allTopicsForDataOwner(dataOwnerId: string): BaseFilterOptions<Topic>;

	allTopicsForDataOwnerInGroup(dataOwner: EntityReferenceInGroup): BaseFilterOptions<Topic>;

	allTopicsForSelf(): FilterOptions<Topic>;

	byParticipant(participantId: string): FilterOptions<Topic>;

	byParticipantInGroup(participant: EntityReferenceInGroup): FilterOptions<Topic>;

}

export const TopicFilters: TopicFiltersFactory = {
			allTopicsForDataOwner: (dataOwnerId) => InternalTopicFiltersObj.getInstance().allTopicsForDataOwner(dataOwnerId),
			allTopicsForDataOwnerInGroup: (dataOwner) => InternalTopicFiltersObj.getInstance().allTopicsForDataOwnerInGroup(dataOwner),
			allTopicsForSelf: () => InternalTopicFiltersObj.getInstance().allTopicsForSelf(),
			byParticipant: (participantId) => InternalTopicFiltersObj.getInstance().byParticipant(participantId),
			byParticipantInGroup: (participant) => InternalTopicFiltersObj.getInstance().byParticipantInGroup(participant)
		};
