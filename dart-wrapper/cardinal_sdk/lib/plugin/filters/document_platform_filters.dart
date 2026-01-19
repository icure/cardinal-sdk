// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/embed/document_type.dart';


class DocumentPlatformFilters {
	MethodChannel _methodChannel;
	DocumentPlatformFilters(this._methodChannel);

	Future<SortableFilterOptions<Document>> byPatientsCreatedForDataOwner(String dataOwnerId, List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsCreatedForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsCreatedForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byMessagesCreatedForDataOwner(String dataOwnerId, List<Message> messages, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byMessagesCreatedForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byMessagesCreatedForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byPatientsCreatedForSelf(List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsCreatedForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsCreatedForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byMessagesCreatedForSelf(List<Message> messages, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byMessagesCreatedForSelf',
			{
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byMessagesCreatedForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Document>> byOwningEntitySecretIdsCreatedForDataOwner(String dataOwnerId, List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byOwningEntitySecretIdsCreatedForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOwningEntitySecretIdsCreatedForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byOwningEntitySecretIdsCreatedForSelf(List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byOwningEntitySecretIdsCreatedForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOwningEntitySecretIdsCreatedForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsAndTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsAndTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byMessagesAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<Message> messages) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byMessagesAndTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byMessagesAndTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientsAndTypeForSelf(DocumentType documentType, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsAndTypeForSelf',
			{
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsAndTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byMessagesAndTypeForSelf(DocumentType documentType, List<Message> messages) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byMessagesAndTypeForSelf',
			{
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byMessagesAndTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byOwningEntitySecretIdsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byOwningEntitySecretIdsAndTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOwningEntitySecretIdsAndTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byOwningEntitySecretIdsAndTypeForSelf(DocumentType documentType, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byOwningEntitySecretIdsAndTypeForSelf',
			{
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOwningEntitySecretIdsAndTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}