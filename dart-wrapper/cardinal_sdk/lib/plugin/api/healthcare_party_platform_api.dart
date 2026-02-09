// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/public_key.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/data_owner_registration_success.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthcarePartyPlatformApi {
	MethodChannel _methodChannel;
	HealthcarePartyInGroupPlatformApi inGroup;
	HealthcarePartyPlatformApi(
		this._methodChannel
		) : inGroup = HealthcarePartyInGroupPlatformApi(_methodChannel);

	Future<HealthcareParty?> getHealthcareParty(String sdkId, String healthcarePartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.getHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcarePartyId": jsonEncode(healthcarePartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : HealthcareParty.fromJSON(parsedResJson);
	}

	Future<HealthcareParty> createHealthcareParty(String sdkId, HealthcareParty p) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.createHealthcareParty',
			{
				"sdkId": sdkId,
				"p": jsonEncode(HealthcareParty.encode(p)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<HealthcareParty> modifyHealthcarePartyInGroup(String sdkId, String groupId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.modifyHealthcarePartyInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthcarePartyInGroup");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<HealthcareParty> createHealthcarePartyInGroup(String sdkId, String groupId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.createHealthcarePartyInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthcarePartyInGroup");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<HealthcareParty> getCurrentHealthcareParty(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.getCurrentHealthcareParty',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCurrentHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByName(String sdkId, String name) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.listHealthcarePartiesByName',
			{
				"sdkId": sdkId,
				"name": jsonEncode(name),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listHealthcarePartiesByName");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthcareParty.fromJSON(x1) ).toList();
	}

	Future<List<HealthcareParty>> getHealthcareParties(String sdkId, List<String> healthcarePartyIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.getHealthcareParties',
			{
				"sdkId": sdkId,
				"healthcarePartyIds": jsonEncode(healthcarePartyIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthcareParties");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthcareParty.fromJSON(x1) ).toList();
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByParentId(String sdkId, String parentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.listHealthcarePartiesByParentId',
			{
				"sdkId": sdkId,
				"parentId": jsonEncode(parentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listHealthcarePartiesByParentId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthcareParty.fromJSON(x1) ).toList();
	}

	Future<PublicKey> getPublicKey(String sdkId, String healthcarePartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.getPublicKey',
			{
				"sdkId": sdkId,
				"healthcarePartyId": jsonEncode(healthcarePartyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPublicKey");
		final parsedResJson = jsonDecode(res);
		return PublicKey.fromJSON(parsedResJson);
	}

	Future<HealthcareParty> modifyHealthcareParty(String sdkId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.modifyHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<List<String>> matchHealthcarePartiesBy(String sdkId, BaseFilterOptions<HealthcareParty> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.matchHealthcarePartiesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthcarePartiesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBy(String sdkId, BaseFilterOptions<HealthcareParty> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.filterHealthPartiesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthPartiesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthcareParty.fromJSON(x0));
	}

	Future<List<String>> matchHealthcarePartiesBySorted(String sdkId, BaseSortableFilterOptions<HealthcareParty> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.matchHealthcarePartiesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthcarePartiesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBySorted(String sdkId, BaseSortableFilterOptions<HealthcareParty> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.filterHealthPartiesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthPartiesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthcareParty.fromJSON(x0));
	}

	Future<List<HealthcareParty>> getHealthcarePartiesInGroup(String sdkId, String groupId, List<String>? healthcarePartyIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.getHealthcarePartiesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"healthcarePartyIds": jsonEncode(healthcarePartyIds?.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthcarePartiesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthcareParty.fromJSON(x1) ).toList();
	}

	Future<DataOwnerRegistrationSuccess> registerPatient(String sdkId, String groupId, String? parentHcPartyId, String? token, bool? useShortToken, HealthcareParty hcp) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.registerPatient',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"parentHcPartyId": jsonEncode(parentHcPartyId),
				"token": jsonEncode(token),
				"useShortToken": jsonEncode(useShortToken),
				"hcp": jsonEncode(HealthcareParty.encode(hcp)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method registerPatient");
		final parsedResJson = jsonDecode(res);
		return DataOwnerRegistrationSuccess.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteHealthcarePartyById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartyById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartyById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartiesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartiesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroupById(String sdkId, String groupId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartyInGroupById',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartyInGroupById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroupByIds(String sdkId, String groupId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartiesInGroupByIds',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartiesInGroupByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthcarePartyById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.purgeHealthcarePartyById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<HealthcareParty> undeleteHealthcarePartyById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.undeleteHealthcarePartyById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthcarePartyById");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteHealthcareParty(String sdkId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthcareParties(String sdkId, List<HealthcareParty> healthcareParties) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcareParties',
			{
				"sdkId": sdkId,
				"healthcareParties": jsonEncode(healthcareParties.map((x0) => HealthcareParty.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcareParties");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthcareParty(String sdkId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.purgeHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
	}

	Future<HealthcareParty> undeleteHealthcareParty(String sdkId, HealthcareParty healthcareParty) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.undeleteHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcareParty": jsonEncode(HealthcareParty.encode(healthcareParty)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return HealthcareParty.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroup(String sdkId, String groupId, HealthcareParty hcp) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartyInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"hcp": jsonEncode(HealthcareParty.encode(hcp)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartyInGroup");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroup(String sdkId, String groupId, List<HealthcareParty> healthcareParties) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.deleteHealthcarePartiesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"healthcareParties": jsonEncode(healthcareParties.map((x0) => HealthcareParty.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthcarePartiesInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<HealthcareParty>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<HealthcareParty> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => HealthcareParty.fromJSON(x0));
	}
}

class HealthcarePartyInGroupPlatformApi {
	MethodChannel _methodChannel;
	HealthcarePartyInGroupPlatformApi(this._methodChannel);

	Future<List<String>> matchHealthcarePartiesBy(String sdkId, String groupId, BaseFilterOptions<HealthcareParty> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthcarePartyApi.inGroup.matchHealthcarePartiesBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthcarePartiesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}
}