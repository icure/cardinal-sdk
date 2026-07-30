// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedRelatedPerson, RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface RelatedPersonBasicInGroupApi {

	/**
	 *
	 *  In-group version of [RelatedPersonBasicApi.matchRelatedPersonsBy]
	 */
	matchRelatedPersonsBy(groupId: string,
			filter: BaseFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicApi.matchRelatedPersonsBySorted]
	 */
	matchRelatedPersonsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicApi.filterRelatedPersonsBy]
	 */
	filterRelatedPersonsBy(groupId: string,
			filter: BaseFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicApi.filterRelatedPersonsBySorted]
	 */
	filterRelatedPersonsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonById]
	 */
	deleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersonsByIds]
	 */
	deleteRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonById]
	 */
	purgeRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersonsByIds]
	 */
	purgeRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPerson]
	 */
	deleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.deleteRelatedPersons]
	 */
	deleteRelatedPersons(relatedPersons: Array<GroupScoped<RelatedPerson>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPerson]
	 */
	purgeRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<void>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavourlessApi.purgeRelatedPersons]
	 */
	purgeRelatedPersons(relatedPersons: Array<GroupScoped<RelatedPerson>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPerson]
	 */
	createRelatedPerson(entity: GroupScoped<EncryptedRelatedPerson>): Promise<GroupScoped<EncryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.createRelatedPersons]
	 */
	createRelatedPersons(entities: Array<GroupScoped<EncryptedRelatedPerson>>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonById]
	 */
	undeleteRelatedPersonById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersonsByIds]
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPerson]
	 */
	undeleteRelatedPerson(relatedPerson: GroupScoped<RelatedPerson>): Promise<GroupScoped<EncryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.undeleteRelatedPersons]
	 */
	undeleteRelatedPersons(relatedPersons: Array<GroupScoped<EncryptedRelatedPerson>>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPerson]
	 */
	modifyRelatedPerson(entity: GroupScoped<EncryptedRelatedPerson>): Promise<GroupScoped<EncryptedRelatedPerson>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.modifyRelatedPersons]
	 */
	modifyRelatedPersons(entities: Array<GroupScoped<EncryptedRelatedPerson>>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPerson]
	 */
	getRelatedPerson(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedRelatedPerson> | undefined>;

	/**
	 *
	 *  In-group version of [RelatedPersonBasicFlavouredApi.getRelatedPersons]
	 */
	getRelatedPersons(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedRelatedPerson>>>;

}
