// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {DataOwnerRegistrationSuccess} from '../model/DataOwnerRegistrationSuccess.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {PublicKey} from '../model/PublicKey.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthcarePartyInGroupApi} from './HealthcarePartyInGroupApi.mjs';


export interface HealthcarePartyApi {

	inGroup: HealthcarePartyInGroupApi;

	getHealthcareParty(healthcarePartyId: string): Promise<HealthcareParty | undefined>;

	getHealthcareParties(healthcarePartyIds: Array<string>): Promise<Array<HealthcareParty>>;

	createHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	createHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	modifyHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	modifyHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	getCurrentHealthcareParty(): Promise<HealthcareParty>;

	getPublicKey(healthcarePartyId: string): Promise<PublicKey>;

	matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	registerHealthcareParty(groupId: string, hcp: HealthcareParty,
			options?: { parentHcPartyId?: string | undefined, token?: string | undefined, useShortToken?: boolean | undefined }): Promise<DataOwnerRegistrationSuccess>;

	/**
	 *
	 *  Deletes a healthcareParty. If you don't have write access to the healthcareParty the method will fail.
	 *  @param entityId id of the healthcareParty.
	 *  @param rev the latest known rev of the healthcareParty to delete
	 *  @return the id and revision of the deleted healthcareParty.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteHealthcarePartyById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthcareParties. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the healthcareParties to delete.
	 *  @return the id and revision of the deleted healthcareParties. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthcareParty.
	 *  @param id id of the healthcareParty to purge
	 *  @param rev latest revision of the healthcareParty
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeHealthcarePartyById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthcareParties.
	 *  @param entityIds ids and revisions of the healthcareParties to delete
	 *  @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores a healthcareParty that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteHealthcarePartyById(id: string, rev: string): Promise<HealthcareParty>;

	/**
	 *
	 *  Restores a batch of healthcareParties that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the healthcareParties to restore.
	 *  @return the restored healthcareParties. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthcarePartiesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<HealthcareParty>>;

	/**
	 *
	 *  Deletes a healthcareParty. If you don't have write access to the healthcareParty the method will fail.
	 *  @param healthcareParty the healthcareParty to delete
	 *  @return the id and revision of the deleted healthcareParty.
	 *  @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	deleteHealthcareParty(healthcareParty: HealthcareParty): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many healthcareParties. Ignores healthcareParty for which you don't have write access or that don't match the latest revision.
	 *  @param healthcareParties the healthcareParties to delete
	 *  @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a healthcareParty.
	 *  @param healthcareParty the healthcareParty to purge.
	 *  @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	purgeHealthcareParty(healthcareParty: HealthcareParty): Promise<void>;

	/**
	 *
	 *  Permanently deletes many healthcareParties.
	 *  @param healthcareParties the healthcareParties to delete
	 *  @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores a healthcareParty that was marked as deleted.
	 *  @param healthcareParty the healthcareParty to undelete
	 *  @return the restored healthcareParty.
	 *  @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	undeleteHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	/**
	 *
	 *  Restores a batch of healthcareParties that were marked as deleted.
	 *  @param healthcareParties the healthcareParties to restore.
	 *  @return the restored healthcareParties. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteHealthcareParties(healthcareParties: Array<HealthcareParty>): Promise<Array<HealthcareParty>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthcareParty>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<HealthcareParty>>;

}
