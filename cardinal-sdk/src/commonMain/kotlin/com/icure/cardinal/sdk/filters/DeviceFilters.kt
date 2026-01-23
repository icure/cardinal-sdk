package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.device.AllDevicesFilter
import com.icure.cardinal.sdk.model.filter.device.DeviceByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.device.DeviceByIdsFilter
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.requireUniqueElements
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

object DeviceFilters {
	/**
	 * Filter options to match all devices.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<Device> = All

	/**
	 * Filter options to match all devices where the [Device.responsible] is the provided [responsibleId]
	 *
	 * @param responsibleId the id of the responsible
	 */
	fun byResponsible(responsibleId: String): BaseFilterOptions<Device> = ByResponsible(
		EntityReferenceInGroup(entityId = responsibleId, groupId = null)
	)

	fun byResponsible(responsible: EntityReferenceInGroup): BaseFilterOptions<Device> = ByResponsible(responsible)

	/**
	 * Filter options that match all devices with one of the provided ids.
	 * These options are sortable. When sorting using these options the devices will have the same order as the input ids.
	 *
	 * @param ids a list of unique device ids.
	 * @throws IllegalArgumentException if the provided [ids] list contains duplicate elements
	 */
	fun byIds(
		ids: List<String>
	): BaseSortableFilterOptions<Device> = ByIds(ids)

	/**
	 * Filter options to match all devices.
	 * These options are not sortable.
	 */
	@Serializable
	internal data object All: BaseFilterOptions<Device>

	@Serializable
	internal class ByResponsible(val responsibleId: EntityReferenceInGroup): BaseFilterOptions<Device>

	@Serializable
	internal class ByIds(
		val ids: List<String>
	): BaseSortableFilterOptions<Device> {
		init {
			ids.requireUniqueElements("`ids`")
		}
	}
}

@InternalIcureApi
internal suspend fun mapDeviceFilterOptions(
	filterOptions: FilterOptions<Device>,
	config: BasicApiConfiguration,
	requestGroup: String? = null,
): AbstractFilter<Device> = mapDeviceFilterOptions(
	filterOptions = filterOptions,
	boundGroup = config.getBoundGroup(currentCoroutineContext()),
	requestGroup = requestGroup,
)

@InternalIcureApi
internal suspend fun mapDeviceFilterOptions(
	filterOptions: FilterOptions<Device>,
	boundGroup: SdkBoundGroup?,
	requestGroup: String? = null,
): AbstractFilter<Device> = mapIfMetaFilterOptions(filterOptions) {
	mapDeviceFilterOptions(it, boundGroup, requestGroup)
} ?: when (filterOptions) {
	DeviceFilters.All -> AllDevicesFilter()
	is DeviceFilters.ByIds -> DeviceByIdsFilter(ids = filterOptions.ids.toSet())
	is DeviceFilters.ByResponsible -> DeviceByHcPartyFilter(
		responsibleId = filterOptions.responsibleId.asReferenceStringInGroup(requestGroup, boundGroup)
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Devices")
}
