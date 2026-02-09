// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/embedded_time_table_item.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "resource_group_allocation_schedule.freezed.dart";


@freezed
abstract class ResourceGroupAllocationSchedule with _$ResourceGroupAllocationSchedule {
	const factory ResourceGroupAllocationSchedule({
		@Default(null) CodeStub? resourceGroup,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) String? name,
		@Default(null) int? startDateTime,
		@Default(null) int? endDateTime,
		@Default([]) List<EmbeddedTimeTableItem> items,
	}) = _ResourceGroupAllocationSchedule;


	static Map<String, dynamic> encode(ResourceGroupAllocationSchedule value) {
		Map<String, dynamic> entityAsMap = {
			"resourceGroup" : value.resourceGroup == null ? null : CodeStub.encode(value.resourceGroup!),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"name" : value.name,
			"startDateTime" : value.startDateTime,
			"endDateTime" : value.endDateTime,
			"items" : value.items.map((x0) => EmbeddedTimeTableItem.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static ResourceGroupAllocationSchedule fromJSON(Map<String, dynamic> data) {
		return ResourceGroupAllocationSchedule(
			resourceGroup: data["resourceGroup"] == null ? null : CodeStub.fromJSON(data["resourceGroup"]),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			name: (data["name"] as String?),
			startDateTime: (data["startDateTime"] as int?),
			endDateTime: (data["endDateTime"] as int?),
			items: (data["items"] as List<dynamic>).map((x0) => EmbeddedTimeTableItem.fromJSON(x0) ).toList()
		);
	}
}