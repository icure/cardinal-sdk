// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedRelatedPerson, RelatedPerson} from '../model/RelatedPerson.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {RelatedPersonBasicInGroupApi} from './RelatedPersonBasicInGroupApi.mjs';


export interface RelatedPersonBasicApi {

	inGroup: RelatedPersonBasicInGroupApi;

	/**
	 *
	 *  Get the ids of all related persons matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchRelatedPersonsBySorted] instead.
	 *
	 *  @param filter a related person filter
	 *  @return a list of related person ids
	 */
	matchRelatedPersonsBy(filter: BaseFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all related persons matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchRelatedPersonsBy].
	 *
	 *  @param filter a related person filter
	 *  @return a list of related person ids
	 */
	matchRelatedPersonsBySorted(filter: BaseSortableFilterOptions<RelatedPerson>): Promise<Array<string>>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterRelatedPersonsBySorted] instead.
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBy(filter: BaseFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Get an iterator that iterates through all related persons matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterRelatedPersonsBy].
	 *
	 *  @param filter a related person filter
	 *  @return an iterator that iterates over all related persons matching the provided filter.
	 */
	filterRelatedPersonsBySorted(filter: BaseSortableFilterOptions<RelatedPerson>): Promise<PaginatedListIterator<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 *  @param entityId id of the relatedPerson.
	 *  @param rev the latest known rev of the relatedPerson to delete
	 *  @return the id and revision of the deleted relatedPerson.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteRelatedPersonById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many relatedPersons. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the relatedPersons to delete.
	 *  @return the id and revision of the deleted relatedPersons. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a relatedPerson.
	 *  @param id id of the relatedPerson to purge
	 *  @param rev latest revision of the relatedPerson
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeRelatedPersonById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many relatedPersons.
	 *  @param entityIds ids and revisions of the relatedPersons to delete
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a relatedPerson. If you don't have write access to the relatedPerson the method will fail.
	 *  @param relatedPerson the relatedPerson to delete
	 *  @return the id and revision of the deleted relatedPerson.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	deleteRelatedPerson(relatedPerson: RelatedPerson): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many relatedPersons. Ignores relatedPerson for which you don't have write access or that don't match the latest revision.
	 *  @param relatedPersons the relatedPersons to delete
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a relatedPerson.
	 *  @param relatedPerson the relatedPerson to purge.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	purgeRelatedPerson(relatedPerson: RelatedPerson): Promise<void>;

	/**
	 *
	 *  Permanently deletes many relatedPersons.
	 *  @param relatedPersons the relatedPersons to purge.
	 *  @return the id and revision of the deleted relatedPersons. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Create a new related person. The provided related person must have the encryption metadata initialized.
	 *  @param entity a related person with initialized encryption metadata
	 *  @return the created related person with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createRelatedPerson(entity: EncryptedRelatedPerson): Promise<EncryptedRelatedPerson>;

	/**
	 *
	 *  Create multiple related persons. All the provided related persons must have the encryption metadata initialized,
	 *  otherwise this method fails without doing anything.
	 *  @param entities related persons with initialized encryption metadata
	 *  @return the created related persons with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any related person in the input was not initialized.
	 */
	createRelatedPersons(entities: Array<EncryptedRelatedPerson>): Promise<Array<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteRelatedPersonById(id: string, rev: string): Promise<EncryptedRelatedPerson>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Restores a relatedPerson that was marked as deleted.
	 *  @param relatedPerson the relatedPerson to undelete
	 *  @return the restored relatedPerson.
	 *  @throws RevisionConflictException if the provided relatedPerson doesn't match the latest known revision
	 */
	undeleteRelatedPerson(relatedPerson: RelatedPerson): Promise<EncryptedRelatedPerson>;

	/**
	 *
	 *  Restores a batch of relatedPersons that were marked as deleted.
	 *  @param relatedPersons the relatedPersons to restore.
	 *  @return the restored relatedPersons. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteRelatedPersons(relatedPersons: Array<RelatedPerson>): Promise<Array<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Modifies a related person. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a related person with update content
	 *  @return the related person updated with the provided content and a new revision.
	 */
	modifyRelatedPerson(entity: EncryptedRelatedPerson): Promise<EncryptedRelatedPerson>;

	/**
	 *
	 *  Modifies multiple related persons. Ignores all related persons for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities related persons with update content
	 *  @return the updated related persons with a new revision.
	 */
	modifyRelatedPersons(entities: Array<EncryptedRelatedPerson>): Promise<Array<EncryptedRelatedPerson>>;

	/**
	 *
	 *  Get a related person by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a related person, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a related person id.
	 *  @return the related person with id [entityId].
	 */
	getRelatedPerson(entityId: string): Promise<EncryptedRelatedPerson | undefined>;

	/**
	 *
	 *  Get multiple related persons by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a related person, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of related persons ids
	 *  @return all related persons that you can access with one of the provided ids.
	 */
	getRelatedPersons(entityIds: Array<string>): Promise<Array<EncryptedRelatedPerson>>;

}
