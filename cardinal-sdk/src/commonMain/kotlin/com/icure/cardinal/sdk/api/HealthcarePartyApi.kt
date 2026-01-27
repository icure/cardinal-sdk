package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface HealthcarePartyApi: Subscribable<HealthcareParty, HealthcareParty, FilterOptions<HealthcareParty>> {

	/**
	 * Gives access to methods of the api that allow to use entities or work with data owners in groups other than the
	 * current user's group.
	 * These methods aren't available when connected to a kraken-lite instance.
	 */
	val inGroup: HealthcarePartyInGroupApi

	suspend fun getHealthcareParty(healthcarePartyId: String): HealthcareParty?
	suspend fun getHealthcareParties(healthcarePartyIds: List<String>): List<HealthcareParty>

	suspend fun createHealthcareParty(healthcareParty: HealthcareParty): HealthcareParty
	suspend fun createHealthcareParties(healthcareParties: List<HealthcareParty>): List<HealthcareParty>

	suspend fun modifyHealthcareParty(healthcareParty: HealthcareParty): HealthcareParty
	suspend fun modifyHealthcareParties(healthcareParties: List<HealthcareParty>): List<HealthcareParty>

	suspend fun getCurrentHealthcareParty(): HealthcareParty

	suspend fun getPublicKey(healthcarePartyId: String): PublicKey
	suspend fun matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): List<String>

	suspend fun filterHealthPartiesBy(
		filter: BaseFilterOptions<HealthcareParty>,
	): PaginatedListIterator<HealthcareParty>

	suspend fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): List<String>

	suspend fun filterHealthPartiesBySorted(
		filter: BaseSortableFilterOptions<HealthcareParty>,
	): PaginatedListIterator<HealthcareParty>

	suspend fun registerPatient(
		groupId: String,
		@DefaultValue("null")
		parentHcPartyId: String? = null,
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		useShortToken: Boolean? = null,
		hcp: HealthcareParty,
	): DataOwnerRegistrationSuccess

	/**
	 * Deletes a healthcareParty. If you don't have write access to the healthcareParty the method will fail.
	 * @param entityId id of the healthcareParty.
	 * @param rev the latest known rev of the healthcareParty to delete
	 * @return the id and revision of the deleted healthcareParty.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteHealthcarePartyById(entityId: String, rev: String): StoredDocumentIdentifier

	/**
	 * Deletes many healthcareParties. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the healthcareParties to delete.
	 * @return the id and revision of the deleted healthcareParties. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a healthcareParty.
	 * @param id id of the healthcareParty to purge
	 * @param rev latest revision of the healthcareParty
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeHealthcarePartyById(id: String, rev: String)

	/**
	 * Permanently deletes many healthcareParties.
	 * @param entityIds ids and revisions of the healthcareParties to delete
	 * @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Restores a healthcareParty that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteHealthcarePartyById(id: String, rev: String): HealthcareParty

	/**
	 * Restores a batch of healthcareParties that were marked as deleted.
	 * @param entityIds the ids and the revisions of the healthcareParties to restore.
	 * @return the restored healthcareParties. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteHealthcarePartiesByIds(entityIds: List<StoredDocumentIdentifier>): List<HealthcareParty>

	/**
	 * Deletes a healthcareParty. If you don't have write access to the healthcareParty the method will fail.
	 * @param healthcareParty the healthcareParty to delete
	 * @return the id and revision of the deleted healthcareParty.
	 * @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	suspend fun deleteHealthcareParty(healthcareParty: HealthcareParty): StoredDocumentIdentifier =
		deleteHealthcarePartyById(healthcareParty.id, requireNotNull(healthcareParty.rev) { "Can't delete an healthcareParty that has no rev" })

	/**
	 * Deletes many healthcareParties. Ignores healthcareParty for which you don't have write access or that don't match the latest revision.
	 * @param healthcareParties the healthcareParties to delete
	 * @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteHealthcareParties(healthcareParties: List<HealthcareParty>): List<StoredDocumentIdentifier> =
		deleteHealthcarePartiesByIds(healthcareParties.map { healthcareParty ->
			healthcareParty.toStoredDocumentIdentifier()
		})

	/**
	 * Permanently deletes a healthcareParty.
	 * @param healthcareParty the healthcareParty to purge.
	 * @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	suspend fun purgeHealthcareParty(healthcareParty: HealthcareParty) {
		purgeHealthcarePartyById(healthcareParty.id, requireNotNull(healthcareParty.rev) { "Can't delete an healthcareParty that has no rev" })
	}

	/**
	 * Permanently deletes many healthcareParties.
	 * @param healthcareParties the healthcareParties to delete
	 * @return the id and revision of the deleted healthcareParties. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun purgeHealthcareParties(healthcareParties: List<HealthcareParty>): List<StoredDocumentIdentifier> =
		purgeHealthcarePartiesByIds(healthcareParties.map { it.toStoredDocumentIdentifier() })

	/**
	 * Restores a healthcareParty that was marked as deleted.
	 * @param healthcareParty the healthcareParty to undelete
	 * @return the restored healthcareParty.
	 * @throws RevisionConflictException if the provided healthcareParty doesn't match the latest known revision
	 */
	suspend fun undeleteHealthcareParty(healthcareParty: HealthcareParty): HealthcareParty =
		undeleteHealthcarePartyById(healthcareParty.id, requireNotNull(healthcareParty.rev) { "Can't delete an healthcareParty that has no rev" })

	/**
	 * Restores a batch of healthcareParties that were marked as deleted.
	 * @param healthcareParties the healthcareParties to restore.
	 * @return the restored healthcareParties. If some entities couldn't be restored (because the user does not have access or the revision is not
	 * up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	suspend fun undeleteHealthcareParties(healthcareParties: List<HealthcareParty>): List<HealthcareParty> =
		undeleteHealthcarePartiesByIds(healthcareParties.map { it.toStoredDocumentIdentifier()})
}

interface HealthcarePartyInGroupApi {
	suspend fun createHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<HealthcareParty>
	suspend fun createHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<HealthcareParty>>

	suspend fun getHealthcareParty(groupId: String, healthcarePartyId: String): GroupScoped<HealthcareParty>?
	suspend fun getHealthcareParties(groupId: String, healthcarePartiesIds: List<String>): List<GroupScoped<HealthcareParty>>

	suspend fun modifyHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<HealthcareParty>
	suspend fun modifyHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<HealthcareParty>>

	suspend fun deleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<StoredDocumentIdentifier> =
		deleteHealthcarePartyById(healthcareParty.toStoredDocumentIdentifier())
	suspend fun deleteHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteHealthcarePartyByIds(healthcareParties.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<HealthcareParty>
	suspend fun undeleteHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<HealthcareParty>>

	suspend fun undeleteHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>): GroupScoped<HealthcareParty> =
		undeleteHealthcarePartyById(healthcareParty.toStoredDocumentIdentifier())
	suspend fun undeleteHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<HealthcareParty>> =
		undeleteHealthcarePartyByIds(healthcareParties.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeHealthcarePartyById(entityId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeHealthcarePartyByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun purgeHealthcareParty(healthcareParty: GroupScoped<HealthcareParty>) {
		purgeHealthcarePartyById(healthcareParty.toStoredDocumentIdentifier())
	}
	suspend fun purgeHealthcareParties(healthcareParties: List<GroupScoped<HealthcareParty>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeHealthcarePartyByIds(healthcareParties.map { it.toStoredDocumentIdentifier() })

	suspend fun matchHealthcarePartiesBy(groupId: String, filter: BaseFilterOptions<HealthcareParty>): List<String>
	suspend fun matchHealthcarePartiesBySorted(groupId: String, filter: BaseSortableFilterOptions<HealthcareParty>): List<String>

	suspend fun filterHealthPartiesBy(
		groupId: String,
		filter: BaseFilterOptions<HealthcareParty>,
	): PaginatedListIterator<GroupScoped<HealthcareParty>>
	suspend fun filterHealthPartiesBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<HealthcareParty>,
	): PaginatedListIterator<GroupScoped<HealthcareParty>>
}
