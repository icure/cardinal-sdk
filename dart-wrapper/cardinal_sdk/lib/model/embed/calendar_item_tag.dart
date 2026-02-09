// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/calendar_item_tag.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "calendar_item_tag.freezed.dart";


sealed class CalendarItemTag implements Encryptable {
	abstract final String? code;
	abstract final int? date;
	abstract final String? userId;
	abstract final String? userName;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(CalendarItemTag value) {
		switch (value) {
			case EncryptedCalendarItemTag entity:
				Map<String, dynamic> entityJson = EncryptedCalendarItemTag.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag";
				return entityJson;
			case DecryptedCalendarItemTag entity:
				Map<String, dynamic> entityJson = DecryptedCalendarItemTag.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag";
				return entityJson;
		}
	}

	static CalendarItemTag fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag":
				return EncryptedCalendarItemTag.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag":
				return DecryptedCalendarItemTag.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedCalendarItemTag with _$EncryptedCalendarItemTag implements CalendarItemTag {
	const factory EncryptedCalendarItemTag({
		@Default(null) String? code,
		@Default(null) int? date,
		@Default(null) String? userId,
		@Default(null) String? userName,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedCalendarItemTag;


	static Map<String, dynamic> encode(EncryptedCalendarItemTag value) {
		Map<String, dynamic> entityAsMap = {
			"code" : value.code,
			"date" : value.date,
			"userId" : value.userId,
			"userName" : value.userName,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedCalendarItemTag fromJSON(Map<String, dynamic> data) {
		return EncryptedCalendarItemTag(
			code: (data["code"] as String?),
			date: (data["date"] as int?),
			userId: (data["userId"] as String?),
			userName: (data["userName"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class DecryptedCalendarItemTag with _$DecryptedCalendarItemTag implements CalendarItemTag {
	const factory DecryptedCalendarItemTag({
		@Default(null) String? code,
		@Default(null) int? date,
		@Default(null) String? userId,
		@Default(null) String? userName,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedCalendarItemTag;


	static Map<String, dynamic> encode(DecryptedCalendarItemTag value) {
		Map<String, dynamic> entityAsMap = {
			"code" : value.code,
			"date" : value.date,
			"userId" : value.userId,
			"userName" : value.userName,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedCalendarItemTag fromJSON(Map<String, dynamic> data) {
		return DecryptedCalendarItemTag(
			code: (data["code"] as String?),
			date: (data["date"] as int?),
			userId: (data["userId"] as String?),
			userName: (data["userName"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}