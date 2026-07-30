// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {RelatedPersonShareOptions} from '../crypto/entities/RelatedPersonShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface RelatedPersonFlavouredInGroupApi<E extends RelatedPerson> {

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, relatedPerson: GroupScoped<E>,
			options?: { options?: RelatedPersonShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.shareWithMany]
	 */
	shareWithMany(relatedPerson: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: RelatedPersonShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBy]
	 */
	filterRelatedPersonsBy(groupId: string,
			filter: FilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonFlavouredApi.filterRelatedPersonsBySorted]
	 */
	filterRelatedPersonsBySorted(groupId: string,
			filter: SortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPerson]
	 */
	createRelatedPerson(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPersons]
	 */
	createRelatedPersons(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonById]
	 */
	undeleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonsByIds]
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPerson]
	 */
	undeleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersons]
	 */
	undeleteRelatedPersons(relatedPersons: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPerson]
	 */
	modifyRelatedPerson(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPersons]
	 */
	modifyRelatedPersons(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPerson]
	 */
	getRelatedPerson(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPersons]
	 */
	getRelatedPersons(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}
