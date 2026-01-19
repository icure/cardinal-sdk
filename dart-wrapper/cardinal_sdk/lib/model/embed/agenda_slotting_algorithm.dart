// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "agenda_slotting_algorithm.freezed.dart";


sealed class AgendaSlottingAlgorithm {

	static Map<String, dynamic> encode(AgendaSlottingAlgorithm value) {
		switch (value) {
			case AgendaSlottingAlgorithmFixedIntervals entity:
				Map<String, dynamic> entityJson = AgendaSlottingAlgorithmFixedIntervals.encode(entity);
				entityJson["kotlinType"] = "FixedIntervals";
				return entityJson;
		}
	}

	static AgendaSlottingAlgorithm fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "FixedIntervals":
				return AgendaSlottingAlgorithmFixedIntervals.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class AgendaSlottingAlgorithmFixedIntervals with _$AgendaSlottingAlgorithmFixedIntervals implements AgendaSlottingAlgorithm {
	const factory AgendaSlottingAlgorithmFixedIntervals({
		required int intervalMinutes,
	}) = _AgendaSlottingAlgorithmFixedIntervals;


	static Map<String, dynamic> encode(AgendaSlottingAlgorithmFixedIntervals value) {
		Map<String, dynamic> entityAsMap = {
			"intervalMinutes" : value.intervalMinutes
		};
		return entityAsMap;
	}

	static AgendaSlottingAlgorithmFixedIntervals fromJSON(Map<String, dynamic> data) {
		return AgendaSlottingAlgorithmFixedIntervals(
			intervalMinutes: (data["intervalMinutes"] as int)
		);
	}
}