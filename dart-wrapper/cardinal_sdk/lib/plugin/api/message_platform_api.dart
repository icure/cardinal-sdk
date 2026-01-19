// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/message_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MessagePlatformApi {
	MethodChannel _methodChannel;
	MessageEncryptedPlatformApi encrypted;
	MessageTryAndRecoverPlatformApi tryAndRecover;
	MessagePlatformApi(
		this._methodChannel
		) : encrypted = MessageEncryptedPlatformApi(_methodChannel),
		tryAndRecover = MessageTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedMessage> withEncryptionMetadata(String sdkId, DecryptedMessage? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedMessage.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Message entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Message.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedMessage> decrypt(String sdkId, EncryptedMessage message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.decrypt',
			{
				"sdkId": sdkId,
				"message": jsonEncode(EncryptedMessage.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<Message> tryDecrypt(String sdkId, EncryptedMessage message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"message": jsonEncode(EncryptedMessage.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Map<String, Set<EntityReferenceInGroup>>> getSecretIdsOf(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.getSecretIdsOf',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as List<dynamic>).map((x2) => EntityReferenceInGroup.fromJSON(x2) ).toSet()));
	}

	Future<List<String>> matchMessagesBy(String sdkId, FilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.matchMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMessagesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchMessagesBySorted(String sdkId, SortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.matchMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteMessageById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.deleteMessageById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessageById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMessagesByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.deleteMessagesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessagesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.purgeMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.deleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessage");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMessages(String sdkId, List<Message> messages) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.deleteMessages',
			{
				"sdkId": sdkId,
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.purgeMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedMessage> shareWith(String sdkId, String delegateId, DecryptedMessage message, MessageShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"message": jsonEncode(DecryptedMessage.encode(message)),
				"options": jsonEncode(options == null ? null : MessageShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<DecryptedMessage> shareWithMany(String sdkId, DecryptedMessage message, Map<String, MessageShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.shareWithMany',
			{
				"sdkId": sdkId,
				"message": jsonEncode(DecryptedMessage.encode(message)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MessageShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedMessage>> filterMessagesBy(String sdkId, FilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.filterMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedMessage.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedMessage>> filterMessagesBySorted(String sdkId, SortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.filterMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedMessage.fromJSON(x0));
	}

	Future<DecryptedMessage> createMessage(String sdkId, DecryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.createMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessage");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<DecryptedMessage> createMessageInTopic(String sdkId, DecryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.createMessageInTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessageInTopic");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<Message> undeleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.undeleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<DecryptedMessage> modifyMessage(String sdkId, DecryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.modifyMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyMessage");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<DecryptedMessage> undeleteMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.undeleteMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessageById");
		final parsedResJson = jsonDecode(res);
		return DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<DecryptedMessage?> getMessage(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.getMessage',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessage");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedMessage.fromJSON(parsedResJson);
	}

	Future<List<DecryptedMessage>> getMessages(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.getMessages',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedMessage.fromJSON(x1) ).toList();
	}

	Future<List<DecryptedMessage>> setMessagesReadStatus(String sdkId, List<String> entityIds, int? time, bool readStatus, String? userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.setMessagesReadStatus',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
				"time": jsonEncode(time),
				"readStatus": jsonEncode(readStatus),
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setMessagesReadStatus");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedMessage.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedMessage>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<Message> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}
}

class MessageTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	MessageTryAndRecoverPlatformApi(this._methodChannel);

	Future<Message> shareWith(String sdkId, String delegateId, Message message, MessageShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"message": jsonEncode(Message.encode(message)),
				"options": jsonEncode(options == null ? null : MessageShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message> shareWithMany(String sdkId, Message message, Map<String, MessageShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MessageShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Message>> filterMessagesBy(String sdkId, FilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.filterMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Message.fromJSON(x0));
	}

	Future<PaginatedListIterator<Message>> filterMessagesBySorted(String sdkId, SortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.filterMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Message.fromJSON(x0));
	}

	Future<Message> createMessage(String sdkId, Message entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.createMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Message.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message> createMessageInTopic(String sdkId, Message entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.createMessageInTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Message.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessageInTopic");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message> undeleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.undeleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message> modifyMessage(String sdkId, Message entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.modifyMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Message.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message> undeleteMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.undeleteMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessageById");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<Message?> getMessage(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.getMessage',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessage");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Message.fromJSON(parsedResJson);
	}

	Future<List<Message>> getMessages(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.getMessages',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Message.fromJSON(x1) ).toList();
	}

	Future<List<Message>> setMessagesReadStatus(String sdkId, List<String> entityIds, int? time, bool readStatus, String? userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.tryAndRecover.setMessagesReadStatus',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
				"time": jsonEncode(time),
				"readStatus": jsonEncode(readStatus),
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setMessagesReadStatus");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Message.fromJSON(x1) ).toList();
	}
}

class MessageEncryptedPlatformApi {
	MethodChannel _methodChannel;
	MessageEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedMessage> shareWith(String sdkId, String delegateId, EncryptedMessage message, MessageShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"message": jsonEncode(EncryptedMessage.encode(message)),
				"options": jsonEncode(options == null ? null : MessageShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> shareWithMany(String sdkId, EncryptedMessage message, Map<String, MessageShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"message": jsonEncode(EncryptedMessage.encode(message)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, MessageShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBy(String sdkId, FilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.filterMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBySorted(String sdkId, SortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.filterMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}

	Future<EncryptedMessage> createMessage(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.createMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessage");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> createMessageInTopic(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.createMessageInTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessageInTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<Message> undeleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.undeleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> modifyMessage(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.modifyMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyMessage");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> undeleteMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.undeleteMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessageById");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage?> getMessage(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.getMessage',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessage");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<List<EncryptedMessage>> getMessages(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.getMessages',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedMessage.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedMessage>> setMessagesReadStatus(String sdkId, List<String> entityIds, int? time, bool readStatus, String? userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageApi.encrypted.setMessagesReadStatus',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
				"time": jsonEncode(time),
				"readStatus": jsonEncode(readStatus),
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setMessagesReadStatus");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedMessage.fromJSON(x1) ).toList();
	}
}