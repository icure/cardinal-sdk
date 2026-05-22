package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.requireUniqueElements
import kotlinx.serialization.Serializable

object MaintenanceTaskFilters {
    /**
     * Filter options that match all maintenance tasks with one of the provided ids.
     * These options are sortable. When sorting using these options the maintenance tasks will have the same order as the input ids.
     * @param ids a list of unique maintenance task ids.
     * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
     */
    fun byIds(
        ids: List<String>
    ): BaseSortableFilterOptions<MaintenanceTask> = ByIds(ids)

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be in the same order as the input
     * identifiers. In case an entity has multiple identifiers only the first matching identifier is considered for the
     * sorting.
     * @param dataOwnerId a data owner id
     * @param identifiers a list of identifiers
     * @return options for maintenance task filtering
     */
    fun byIdentifiersForDataOwner(
        dataOwnerId: String,
        identifiers: List<Identifier>
    ): BaseSortableFilterOptions<MaintenanceTask> =
        ByIdentifiersForDataOwner(identifiers, dataOwnerId)

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner that have at least
     * an identifier that has the same exact [Identifier.system] and [Identifier.value] as one of the provided
     * [identifiers]. Other properties of the provided identifiers are ignored.
     *
     * @param identifiers a list of identifiers
     * @return options for maintenance task filtering
     */
    fun byIdentifiersForSelf(
        identifiers: List<Identifier>,
    ): FilterOptions<MaintenanceTask> = ByIdentifiersForSelf(identifiers)

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
     * that have the provided type.
     *
     * @param type a maintenance task type
     * @param dataOwnerId a data owner id
     */
    fun byTypeForDataOwner(
        dataOwnerId: String,
        type: String
    ): BaseFilterOptions<MaintenanceTask> =
        ByTypeForDataOwner(type, dataOwnerId)


    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
     * that have the provided type.
     *
     * @param type a maintenance task type
     */
    fun byTypeForSelf(
        type: String,
    ): FilterOptions<MaintenanceTask> =
        ByTypeForSelf(type)

    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with a specific data owner
     * that have a [MaintenanceTask.created] after the provided date.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
     * [MaintenanceTask.created].
     *
     * @param dataOwnerId a data owner id
     * @param date a unix timestamp
     */
    fun afterDateForDataOwner(
        dataOwnerId: String,
        date: Long
    ): BaseSortableFilterOptions<MaintenanceTask> =
        AfterDateForDataOwner(date, dataOwnerId)


    /**
     * Options for maintenance task filtering which match all the maintenance tasks shared directly (i.e. ignoring hierarchies) with the current data owner
     * that have a [MaintenanceTask.created] after the provided date.
     *
     * These options are sortable. When sorting using these options the maintenance tasks will be ordered by their
     * [MaintenanceTask.created].
     *
     * @param date a unix timestamp
     */
    fun afterDateForSelf(
        date: Long,
    ): SortableFilterOptions<MaintenanceTask> =
        AfterDateForSelf(date)

    @Serializable
    internal class ByIds(
        val ids : List<String>
    ): BaseSortableFilterOptions<MaintenanceTask> {
        init {
            ids.requireUniqueElements("`ids`")
        }
    }

    @Serializable
    internal class ByIdentifiersForDataOwner(
        val identifiers : List<Identifier>,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<MaintenanceTask>

    @Serializable
    internal class ByIdentifiersForSelf(
        val identifiers : List<Identifier>
    ): FilterOptions<MaintenanceTask>

    @Serializable
    internal class ByTypeForDataOwner(
        val type: String,
        val dataOwnerId: String
    ): BaseFilterOptions<MaintenanceTask>

    @Serializable
    internal class ByTypeForSelf(
        val type: String,
    ): FilterOptions<MaintenanceTask>

    @Serializable
    internal class AfterDateForDataOwner(
        val date: Long,
        val dataOwnerId: String
    ): BaseSortableFilterOptions<MaintenanceTask>

    @Serializable
    internal class AfterDateForSelf(
        val date: Long,
    ): SortableFilterOptions<MaintenanceTask>
}

@InternalIcureApi
internal suspend fun mapMaintenanceTaskFilterOptions(
    filterOptions: FilterOptions<MaintenanceTask>,
    selfDataOwnerId: String?,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<MaintenanceTask> = mapIfMetaFilterOptions(filterOptions) {
    mapMaintenanceTaskFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is MaintenanceTaskFilters.ByTypeForDataOwner -> {
        MaintenanceTaskByHcPartyAndTypeFilter(
            type = filterOptions.type,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is MaintenanceTaskFilters.AfterDateForDataOwner -> {
        MaintenanceTaskAfterDateFilter(
            date = filterOptions.date,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is MaintenanceTaskFilters.ByIdentifiersForDataOwner -> {
        MaintenanceTaskByHcPartyAndIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            healthcarePartyId = filterOptions.dataOwnerId
        )
    }
    is MaintenanceTaskFilters.ByTypeForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        MaintenanceTaskByHcPartyAndTypeFilter(
            type = filterOptions.type,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is MaintenanceTaskFilters.AfterDateForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        MaintenanceTaskAfterDateFilter(
            date = filterOptions.date,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is MaintenanceTaskFilters.ByIdentifiersForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        MaintenanceTaskByHcPartyAndIdentifiersFilter(
            identifiers = filterOptions.identifiers,
            healthcarePartyId = selfDataOwnerId
        )
    }
    is MaintenanceTaskFilters.ByIds -> {
        MaintenanceTaskByIdsFilter(ids = filterOptions.ids.toSet())
    }
    else -> {
        throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering MaintenanceTasks")
    }
}
