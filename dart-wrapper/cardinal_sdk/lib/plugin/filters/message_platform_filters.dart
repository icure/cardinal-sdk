// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


class MessagePlatformFilters {
	MethodChannel _methodChannel;
	MessagePlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Message>> allMessagesForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.allMessagesForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method allMessagesForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Message>> allMessagesForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.allMessagesForSelf',
			{
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method allMessagesForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Message>> byTransportGuidForDataOwner(String dataOwnerId, String transportGuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byTransportGuidForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"transportGuid": jsonEncode(transportGuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTransportGuidForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Message>> byTransportGuidForSelf(String transportGuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byTransportGuidForSelf',
			{
				"transportGuid": jsonEncode(transportGuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTransportGuidForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> fromAddressForDataOwner(String dataOwnerId, String address) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.fromAddressForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"address": jsonEncode(address),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method fromAddressForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Message>> fromAddressForSelf(String address) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.fromAddressForSelf',
			{
				"address": jsonEncode(address),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method fromAddressForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Message>> byPatientsSentDateForDataOwner(String dataOwnerId, List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byPatientsSentDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSentDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Message>> byPatientsSentDateForSelf(List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byPatientsSentDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSentDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Message>> byPatientSecretIdsSentDateForDataOwner(String dataOwnerId, List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byPatientSecretIdsSentDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsSentDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Message>> byPatientSecretIdsSentDateForSelf(List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byPatientSecretIdsSentDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsSentDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> toAddressForDataOwner(String dataOwnerId, String address) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.toAddressForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"address": jsonEncode(address),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method toAddressForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Message>> toAddressForSelf(String address) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.toAddressForSelf',
			{
				"address": jsonEncode(address),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method toAddressForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Message>> byTransportGuidSentDateForDataOwner(String dataOwnerId, String transportGuid, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byTransportGuidSentDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"transportGuid": jsonEncode(transportGuid),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTransportGuidSentDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Message>> byTransportGuidSentDateForSelf(String transportGuid, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byTransportGuidSentDateForSelf',
			{
				"transportGuid": jsonEncode(transportGuid),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTransportGuidSentDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> latestByTransportGuidForDataOwner(String dataOwnerId, String transportGuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.latestByTransportGuidForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"transportGuid": jsonEncode(transportGuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method latestByTransportGuidForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Message>> latestByTransportGuidForSelf(String transportGuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.latestByTransportGuidForSelf',
			{
				"transportGuid": jsonEncode(transportGuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method latestByTransportGuidForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> byInvoiceIds(Set<String> invoiceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byInvoiceIds',
			{
				"invoiceIds": jsonEncode(invoiceIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byInvoiceIds");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> byParentIds(List<String> parentIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.byParentIds',
			{
				"parentIds": jsonEncode(parentIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byParentIds");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> lifecycleBetweenForDataOwner(String dataOwnerId, int? startTimestamp, int? endTimestamp, bool descending) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.lifecycleBetweenForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"startTimestamp": jsonEncode(startTimestamp),
				"endTimestamp": jsonEncode(endTimestamp),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method lifecycleBetweenForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Message>> lifecycleBetweenForDataOwnerInGroup(EntityReferenceInGroup dataOwner, int? startTimestamp, int? endTimestamp, bool descending) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.lifecycleBetweenForDataOwnerInGroup',
			{
				"dataOwner": jsonEncode(EntityReferenceInGroup.encode(dataOwner)),
				"startTimestamp": jsonEncode(startTimestamp),
				"endTimestamp": jsonEncode(endTimestamp),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method lifecycleBetweenForDataOwnerInGroup");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Message>> lifecycleBetweenForSelf(int? startTimestamp, int? endTimestamp, bool descending) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageFilters.lifecycleBetweenForSelf',
			{
				"startTimestamp": jsonEncode(startTimestamp),
				"endTimestamp": jsonEncode(endTimestamp),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method lifecycleBetweenForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}