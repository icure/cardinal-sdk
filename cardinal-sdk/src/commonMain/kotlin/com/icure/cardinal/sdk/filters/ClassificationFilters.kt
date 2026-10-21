package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.toEncryptionMetadataStub
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.classification.ClassificationByDataOwnerPatientCreatedDateFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object ClassificationFilters {

	/**
	 * Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the classifications based on [Classification.created]:
	 * - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 * - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum timestamp for [Classification.created] (default: no limit).
	 * @param to the maximum timestamp for [Classification.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsCreatedForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Classification> = ByPatientsCreatedForDataOwner(
		dataOwnerId = dataOwnerId,
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the classifications based on [Classification.created]:
	 * - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 * - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum timestamp for [Classification.created] (default: no limit).
	 * @param to the maximum timestamp for [Classification.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	@OptIn(InternalIcureApi::class)
	fun byPatientsCreatedForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Classification> = ByPatientsCreatedForSelf(
		patients = patients.map { it.toEncryptionMetadataStub() },
		from = from,
		to = to,
		descending = descending
	)

	/**
	 * Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the classifications based on [Classification.created]:
	 * - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 * - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id.
	 * @param secretIds a list of secret ids from one or more patients.
	 * @param from the minimum timestamp for [Classification.created] (default: no limit).
	 * @param to the maximum timestamp for [Classification.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	fun byPatientSecretIdsCreatedForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Classification> = ByPatientSecretIdsCreatedForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for classification filtering which match all classifications shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the classifications based on [Classification.created]:
	 * - if the [from] timestamp is not null, only the classifications where [Classification.created] is greater than or equal to [from] will be returned.
	 * - if the [to] timestamp is not null, only the classifications where [Classification.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the classifications will be sorted by [Classification.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of secret ids from one or more patients.
	 * @param from the minimum timestamp for [Classification.created] (default: no limit).
	 * @param to the maximum timestamp for [Classification.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Classification.created] (default: ascending).
	 */
	fun byPatientSecretIdsCreatedForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Classification> = ByPatientSecretIdsCreatedForSelf(secretIds, from, to, descending)

	@Serializable
	@InternalIcureApi
	internal class ByPatientsCreatedForDataOwner(
		val dataOwnerId: String,
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<Classification>

	@Serializable
	@InternalIcureApi
	internal class ByPatientsCreatedForSelf(
		val patients: List<EntityWithEncryptionMetadataStub>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<Classification>

	@Serializable
	internal class ByPatientSecretIdsCreatedForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): BaseSortableFilterOptions<Classification>

	@Serializable
	internal class ByPatientSecretIdsCreatedForSelf(
		val secretIds: List<String>,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): SortableFilterOptions<Classification>

}

@InternalIcureApi
internal suspend fun mapClassificationFilterOptions(
	filterOptions: FilterOptions<Classification>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Classification> = mapIfMetaFilterOptions(filterOptions) {
	mapClassificationFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is ClassificationFilters.ByPatientsCreatedForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ClassificationByDataOwnerPatientCreatedDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Builtin.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ClassificationFilters.ByPatientsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ClassificationByDataOwnerPatientCreatedDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretForeignKeys = entityEncryptionService.secretIdsOf(null, filterOptions.patients, EntityWithEncryptionMetadataTypeName.Builtin.Patient, null).values.flatten().toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is ClassificationFilters.ByPatientSecretIdsCreatedForDataOwner -> ClassificationByDataOwnerPatientCreatedDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretForeignKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is ClassificationFilters.ByPatientSecretIdsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		ClassificationByDataOwnerPatientCreatedDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretForeignKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Classifications")
}
