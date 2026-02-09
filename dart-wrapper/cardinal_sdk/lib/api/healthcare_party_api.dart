// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/public_key.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/data_owner_registration_success.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthcarePartyApi {
	final String _sdkId;
	final Object _dartSdk;
	final HealthcarePartyInGroupApi inGroup;
	HealthcarePartyApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = HealthcarePartyInGroupApi(_sdkId, _dartSdk);

	Future<HealthcareParty?> getHealthcareParty(String healthcarePartyId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.getHealthcareParty(
			_sdkId,
			healthcarePartyId,
		);
	}

	Future<HealthcareParty> createHealthcareParty(HealthcareParty p) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.createHealthcareParty(
			_sdkId,
			p,
		);
	}

	Future<HealthcareParty> modifyHealthcarePartyInGroup(String groupId, HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.modifyHealthcarePartyInGroup(
			_sdkId,
			groupId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> createHealthcarePartyInGroup(String groupId, HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.createHealthcarePartyInGroup(
			_sdkId,
			groupId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> getCurrentHealthcareParty() async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.getCurrentHealthcareParty(
			_sdkId,
		);
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByName(String name) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.listHealthcarePartiesByName(
			_sdkId,
			name,
		);
	}

	Future<List<HealthcareParty>> getHealthcareParties(List<String> healthcarePartyIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.getHealthcareParties(
			_sdkId,
			healthcarePartyIds,
		);
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByParentId(String parentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.listHealthcarePartiesByParentId(
			_sdkId,
			parentId,
		);
	}

	Future<PublicKey> getPublicKey(String healthcarePartyId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.getPublicKey(
			_sdkId,
			healthcarePartyId,
		);
	}

	Future<HealthcareParty> modifyHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.modifyHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<List<String>> matchHealthcarePartiesBy(BaseFilterOptions<HealthcareParty> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.matchHealthcarePartiesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBy(BaseFilterOptions<HealthcareParty> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.filterHealthPartiesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthcarePartiesBySorted(BaseSortableFilterOptions<HealthcareParty> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.matchHealthcarePartiesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBySorted(BaseSortableFilterOptions<HealthcareParty> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.filterHealthPartiesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<HealthcareParty>> getHealthcarePartiesInGroup(String groupId, { List<String>? healthcarePartyIds }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.getHealthcarePartiesInGroup(
			_sdkId,
			groupId,
			healthcarePartyIds,
		);
	}

	Future<DataOwnerRegistrationSuccess> registerPatient(String groupId, HealthcareParty hcp, { String? parentHcPartyId, String? token, bool? useShortToken }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.registerPatient(
			_sdkId,
			groupId,
			parentHcPartyId,
			token,
			useShortToken,
			hcp,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartyById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartiesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroupById(String groupId, String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartyInGroupById(
			_sdkId,
			groupId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroupByIds(String groupId, List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartiesInGroupByIds(
			_sdkId,
			groupId,
			entityIds,
		);
	}

	Future<void> purgeHealthcarePartyById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.purgeHealthcarePartyById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<HealthcareParty> undeleteHealthcarePartyById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.undeleteHealthcarePartyById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcareParties(List<HealthcareParty> healthcareParties) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcareParties(
			_sdkId,
			healthcareParties,
		);
	}

	Future<void> purgeHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.purgeHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> undeleteHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.undeleteHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroup(String groupId, HealthcareParty hcp) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartyInGroup(
			_sdkId,
			groupId,
			hcp,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroup(String groupId, List<HealthcareParty> healthcareParties) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.deleteHealthcarePartiesInGroup(
			_sdkId,
			groupId,
			healthcareParties,
		);
	}

	Future<EntitySubscription<HealthcareParty>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<HealthcareParty> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class HealthcarePartyInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthcarePartyInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchHealthcarePartiesBy(String groupId, BaseFilterOptions<HealthcareParty> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthcareParty.inGroup.matchHealthcarePartiesBy(
			_sdkId,
			groupId,
			filter,
		);
	}
}