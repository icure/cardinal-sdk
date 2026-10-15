package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.dao.KeyComponent
import com.icure.cardinal.sdk.model.dao.RangeQueryParameters
import com.icure.cardinal.sdk.model.dao.ValueFilterParameters
import com.icure.cardinal.sdk.model.filter.CustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByKeysCustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByRangeCustomFilter
import com.icure.cardinal.sdk.options.ApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.serialization.Serializable

@Serializable
sealed interface ForDataOwnerFilterOptionType {
	@Serializable
	sealed interface BasicForDataOwnerFilterOptionType : ForDataOwnerFilterOptionType
	@Serializable
	data object None : BasicForDataOwnerFilterOptionType
	@Serializable
	data object ForSelf : ForDataOwnerFilterOptionType
	@Serializable
	data class ForDataOwner(val dataOwnerReference: EntityReferenceInGroup) : BasicForDataOwnerFilterOptionType
}

@Serializable
sealed interface PatientOptionType {
	@Serializable
	sealed interface BasicPatientOptionType : PatientOptionType
	@Serializable
	data object None : BasicPatientOptionType
	@Serializable
	data class SecretIds(val ids: List<String>) : BasicPatientOptionType
	@Serializable
	@InternalIcureApi
	data class Patients(val stubs: List<Pair<EntityWithEncryptionMetadataStub, String?>>) : PatientOptionType
}

@Serializable
sealed interface CustomFilterOption {
	val viewName: String
	val limit: Int
	val forDataOwnerType: ForDataOwnerFilterOptionType
	val patientOptionType: PatientOptionType
	val keyComponents: List<List<KeyComponent>>
}

@Serializable
sealed interface BasicCustomFilterOption : CustomFilterOption

@Serializable
sealed interface ByKeysFilterOption : CustomFilterOption {
	val valueFilterParameters: ValueFilterParameters?
}

@Serializable
sealed interface ByRangeFilterOption : CustomFilterOption {
	val range: RangeQueryParameters
}

@Serializable
@InternalIcureApi
data class ByKeysCustomFilterOption(
	override val viewName: String,
	override val limit: Int,
	override val forDataOwnerType: ForDataOwnerFilterOptionType,
	override val keyComponents: List<List<KeyComponent>>,
	override val valueFilterParameters: ValueFilterParameters? = null,
	override val patientOptionType: PatientOptionType
) : ByKeysFilterOption

@Serializable
@InternalIcureApi
data class BasicByKeysCustomFilterOption(
	override val viewName: String,
	override val limit: Int,
	override val forDataOwnerType: ForDataOwnerFilterOptionType.BasicForDataOwnerFilterOptionType,
	override val keyComponents: List<List<KeyComponent>>,
	override val valueFilterParameters: ValueFilterParameters? = null,
	override val patientOptionType: PatientOptionType.BasicPatientOptionType
) : ByKeysFilterOption, BasicCustomFilterOption

@Serializable
@InternalIcureApi
data class ByRangeCustomFilterOption(
	override val viewName: String,
	override val limit: Int,
	override val forDataOwnerType: ForDataOwnerFilterOptionType,
	override val keyComponents: List<List<KeyComponent>>,
	override val range: RangeQueryParameters,
	override val patientOptionType: PatientOptionType
) : ByRangeFilterOption

@Serializable
@InternalIcureApi
data class BasicByRangeCustomFilterOption(
	override val viewName: String,
	override val limit: Int,
	override val forDataOwnerType: ForDataOwnerFilterOptionType.BasicForDataOwnerFilterOptionType,
	override val keyComponents: List<List<KeyComponent>>,
	override val range: RangeQueryParameters,
	override val patientOptionType: PatientOptionType.BasicPatientOptionType
) : ByRangeFilterOption, BasicCustomFilterOption

@InternalIcureApi
internal suspend fun mapCustomFilterOptions(
	filterOption: CustomFilterOption,
	viewManifests: Map<String, ViewManifest>,
	config: BasicApiConfiguration,
	requestGroup: String?,
	encryptedEntityType: EntityWithEncryptionMetadataTypeName?
): Pair<CustomFilter, ViewManifest> {
	val boundGroup = config.getBoundGroup(currentCoroutineContext())
	val manifest = checkNotNull(viewManifests[filterOption.viewName]) {
		"Manifest for view ${filterOption.viewName} not found"
	}
	val dataOwnerAccessKeys = when (val dataOwnerOption = filterOption.forDataOwnerType) {
		ForDataOwnerFilterOptionType.ForSelf -> {
			val dataOwnerInfo = manifest.checkByDataOwner()
			val dataOwnerType = (config as? ApiConfiguration)?.crypto?.dataOwnerApi?.getCurrentDataOwnerType()?.toViewDataOwnerType()
				?: throw IllegalStateException("This filter cannot be used in a basic environment")
			if (dataOwnerInfo.dataOwnerType != dataOwnerType) {
				val linkType = when (dataOwnerType) {
					ViewManifest.ViewDataOwnerType.Explicit -> ViewManifest.LinkType.ComplementingExplicitDataOwnerView
					ViewManifest.ViewDataOwnerType.Anonymous -> ViewManifest.LinkType.ComplementingAnonymousDataOwnerView
				}
				val complementingView = manifest.linkedViews.firstOrNull { it.second == linkType }?.first
					?: throw IllegalStateException("View ${filterOption.viewName} does not support $dataOwnerType data owners")
				return mapCustomFilterOptions(
					filterOption = filterOption.switchView(newViewName = complementingView),
					viewManifests = viewManifests,
					config = config,
					requestGroup = requestGroup,
					encryptedEntityType = encryptedEntityType
				)
			} else {
				when (dataOwnerType) {
					ViewManifest.ViewDataOwnerType.Explicit -> {
						val referenceInGroup = config.crypto.dataOwnerApi.getCurrentDataOwnerReference()
							.asReferenceStringInGroup(inGroup = requestGroup, sdkGroupId = boundGroup)
						listOf(referenceInGroup)
					}
					ViewManifest.ViewDataOwnerType.Anonymous -> {
						if (encryptedEntityType != null) {
							config.crypto.headersProvider.getAccessControlKeysHeadersFor(
								groupId = requestGroup,
								entityType = encryptedEntityType,
							)
						} else {
							val referenceInGroup = config.crypto.dataOwnerApi.getCurrentDataOwnerReference()
								.asReferenceStringInGroup(inGroup = requestGroup, sdkGroupId = boundGroup)
							listOf(referenceInGroup)
						}
					}
				} to dataOwnerInfo.keyIndex
			}
		}
		is ForDataOwnerFilterOptionType.ForDataOwner -> {
			val dataOwnerInfo = manifest.checkByDataOwner()
			listOf(dataOwnerOption.dataOwnerReference.asReferenceStringInGroup(inGroup = requestGroup, sdkGroupId = boundGroup)) to dataOwnerInfo.keyIndex
		}
		ForDataOwnerFilterOptionType.None -> {
			require(manifest.dataOwnerInfo == null) { "This view needs a data owner in the key"}
			null
		}
	}
	val patientIds = when(val patientOption = filterOption.patientOptionType) {
		is PatientOptionType.Patients -> {
			require(manifest.patientInfo != null) { "This view does not support queries by patient" }
			patientOption.stubs.mapToSecretIds(
				entityEncryptionService = requireNotNull((config as? ApiConfiguration)?.crypto?.entity) {
					"This filter cannot be used in a basic environment"
				},
				entitiesType = EntityWithEncryptionMetadataTypeName.Patient
			).toList() to manifest.patientInfo.keyIndex
		}
		is PatientOptionType.SecretIds -> {
			require(manifest.patientInfo != null) { "This view does not support queries by patient" }
			patientOption.ids to manifest.patientInfo.keyIndex
		}
		PatientOptionType.None -> {
			require(manifest.patientInfo == null) { "This view needs a patient in the key" }
			null
		}
	}

	val sortedFixedComponents = listOfNotNull(
		dataOwnerAccessKeys,
		patientIds
	).sortedBy { it.second }
	val multiKeys = sortedFixedComponents.fold(filterOption.keyComponents.toMutableList()) { acc, (components, index) ->
		acc.also {
			it.add(
				index = index,
				element = components.map { c -> KeyComponent.StringKeyComponent(c) }
			)
		}
	}

	return when (filterOption) {
		is ByKeysFilterOption -> GenericByKeysCustomFilter(
			viewName = filterOption.viewName,
			keyComponents = multiKeys,
			valueFilterParameters = filterOption.valueFilterParameters,
			limit = filterOption.limit,
			startKey = null,
			startDocumentId = null
		)
		is ByRangeFilterOption -> GenericByRangeCustomFilter(
			viewName = filterOption.viewName,
			nonRangeKeyComponents = multiKeys,
			range = filterOption.range,
			limit = filterOption.limit,
			startKey = null,
			startDocumentId = null
		)
	} to manifest
}


@OptIn(InternalIcureApi::class)
private fun CustomFilterOption.switchView(newViewName: String): CustomFilterOption = when(this) {
	is ByKeysCustomFilterOption -> copy(
		viewName = newViewName,
		limit = limit,
		forDataOwnerType = forDataOwnerType,
		keyComponents = keyComponents,
		valueFilterParameters = valueFilterParameters,
		patientOptionType = patientOptionType
	)
	is BasicByKeysCustomFilterOption -> copy(
		viewName = newViewName,
		limit = limit,
		forDataOwnerType = forDataOwnerType,
		keyComponents = keyComponents,
		valueFilterParameters = valueFilterParameters,
		patientOptionType = patientOptionType
	)
	is ByRangeCustomFilterOption -> copy(
		viewName = newViewName,
		limit = limit,
		forDataOwnerType = forDataOwnerType,
		keyComponents = keyComponents,
		range = range,
		patientOptionType = patientOptionType
	)
	is BasicByRangeCustomFilterOption -> copy(
		viewName = newViewName,
		limit = limit,
		forDataOwnerType = forDataOwnerType,
		keyComponents = keyComponents,
		range = range,
		patientOptionType = patientOptionType
	)
}

private fun DataOwnerType.toViewDataOwnerType() = when (this) {
	DataOwnerType.Hcp -> ViewManifest.ViewDataOwnerType.Explicit
	DataOwnerType.Device -> ViewManifest.ViewDataOwnerType.Explicit
	DataOwnerType.Patient -> ViewManifest.ViewDataOwnerType.Anonymous
}

private fun ViewManifest.checkByDataOwner(): ViewManifest.DataOwnerInfo =
	checkNotNull(dataOwnerInfo) { "This view cannot be queried by data owner" }
