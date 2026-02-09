// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


abstract class MessageFilters {
	MessageFilters();

	static Future<BaseFilterOptions<Message>> allMessagesForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.message.allMessagesForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<Message>> allMessagesForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.message.allMessagesForSelf(
		);
	}

	static Future<BaseSortableFilterOptions<Message>> byTransportGuidForDataOwner(String dataOwnerId, String transportGuid) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byTransportGuidForDataOwner(
			dataOwnerId,
			transportGuid,
		);
	}

	static Future<SortableFilterOptions<Message>> byTransportGuidForSelf(String transportGuid) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byTransportGuidForSelf(
			transportGuid,
		);
	}

	static Future<BaseFilterOptions<Message>> fromAddressForDataOwner(String dataOwnerId, String address) async {
		return CardinalSdkPlatformInterface.instance.filters.message.fromAddressForDataOwner(
			dataOwnerId,
			address,
		);
	}

	static Future<FilterOptions<Message>> fromAddressForSelf(String address) async {
		return CardinalSdkPlatformInterface.instance.filters.message.fromAddressForSelf(
			address,
		);
	}

	static Future<SortableFilterOptions<Message>> byPatientsSentDateForDataOwner(String dataOwnerId, List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byPatientsSentDateForDataOwner(
			dataOwnerId,
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Message>> byPatientsSentDateForSelf(List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byPatientsSentDateForSelf(
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Message>> byPatientSecretIdsSentDateForDataOwner(String dataOwnerId, List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byPatientSecretIdsSentDateForDataOwner(
			dataOwnerId,
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Message>> byPatientSecretIdsSentDateForSelf(List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byPatientSecretIdsSentDateForSelf(
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<Message>> toAddressForDataOwner(String dataOwnerId, String address) async {
		return CardinalSdkPlatformInterface.instance.filters.message.toAddressForDataOwner(
			dataOwnerId,
			address,
		);
	}

	static Future<FilterOptions<Message>> toAddressForSelf(String address) async {
		return CardinalSdkPlatformInterface.instance.filters.message.toAddressForSelf(
			address,
		);
	}

	static Future<BaseSortableFilterOptions<Message>> byTransportGuidSentDateForDataOwner(String dataOwnerId, String transportGuid, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byTransportGuidSentDateForDataOwner(
			dataOwnerId,
			transportGuid,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Message>> byTransportGuidSentDateForSelf(String transportGuid, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byTransportGuidSentDateForSelf(
			transportGuid,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<Message>> latestByTransportGuidForDataOwner(String dataOwnerId, String transportGuid) async {
		return CardinalSdkPlatformInterface.instance.filters.message.latestByTransportGuidForDataOwner(
			dataOwnerId,
			transportGuid,
		);
	}

	static Future<FilterOptions<Message>> latestByTransportGuidForSelf(String transportGuid) async {
		return CardinalSdkPlatformInterface.instance.filters.message.latestByTransportGuidForSelf(
			transportGuid,
		);
	}

	static Future<BaseFilterOptions<Message>> byInvoiceIds(Set<String> invoiceIds) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byInvoiceIds(
			invoiceIds,
		);
	}

	static Future<BaseFilterOptions<Message>> byParentIds(List<String> parentIds) async {
		return CardinalSdkPlatformInterface.instance.filters.message.byParentIds(
			parentIds,
		);
	}

	static Future<BaseFilterOptions<Message>> lifecycleBetweenForDataOwner(String dataOwnerId, int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.message.lifecycleBetweenForDataOwner(
			dataOwnerId,
			startTimestamp,
			endTimestamp,
			descending,
		);
	}

	static Future<BaseFilterOptions<Message>> lifecycleBetweenForDataOwnerInGroup(EntityReferenceInGroup dataOwner, int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.message.lifecycleBetweenForDataOwnerInGroup(
			dataOwner,
			startTimestamp,
			endTimestamp,
			descending,
		);
	}

	static Future<FilterOptions<Message>> lifecycleBetweenForSelf(int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.message.lifecycleBetweenForSelf(
			startTimestamp,
			endTimestamp,
			descending,
		);
	}
}