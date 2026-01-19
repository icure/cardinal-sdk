// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/topic.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/topic_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/topic_role.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class TopicPlatformApi {
	MethodChannel _methodChannel;
	TopicEncryptedPlatformApi encrypted;
	TopicTryAndRecoverPlatformApi tryAndRecover;
	TopicPlatformApi(
		this._methodChannel
		) : encrypted = TopicEncryptedPlatformApi(_methodChannel),
		tryAndRecover = TopicTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedTopic> withEncryptionMetadata(String sdkId, DecryptedTopic? base, Patient? patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedTopic.encode(base!)),
				"patient": jsonEncode(patient == null ? null : Patient.encode(patient!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Topic entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Topic.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedTopic> decrypt(String sdkId, EncryptedTopic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.decrypt',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(EncryptedTopic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<Topic> tryDecrypt(String sdkId, EncryptedTopic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(EncryptedTopic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<List<String>> matchTopicsBy(String sdkId, FilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.matchTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTopicsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchTopicsBySorted(String sdkId, SortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.matchTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteTopicById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.deleteTopicById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopicById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTopicsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.deleteTopicsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopicsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.purgeTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.deleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopic");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTopics(String sdkId, List<Topic> topics) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.deleteTopics',
			{
				"sdkId": sdkId,
				"topics": jsonEncode(topics.map((x0) => Topic.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.purgeTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedTopic> shareWith(String sdkId, String delegateId, DecryptedTopic topic, TopicShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"topic": jsonEncode(DecryptedTopic.encode(topic)),
				"options": jsonEncode(options == null ? null : TopicShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<DecryptedTopic> shareWithMany(String sdkId, DecryptedTopic topic, Map<String, TopicShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.shareWithMany',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(DecryptedTopic.encode(topic)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TopicShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedTopic>> filterTopicsBy(String sdkId, FilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.filterTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedTopic.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedTopic>> filterTopicsBySorted(String sdkId, SortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.filterTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedTopic.fromJSON(x0));
	}

	Future<DecryptedTopic> createTopic(String sdkId, DecryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.createTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createTopic");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<Topic> undeleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.undeleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<DecryptedTopic> modifyTopic(String sdkId, DecryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.modifyTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyTopic");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<DecryptedTopic> undeleteTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.undeleteTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopicById");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<DecryptedTopic?> getTopic(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.getTopic',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopic");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<List<DecryptedTopic>> getTopics(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.getTopics',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedTopic.fromJSON(x1) ).toList();
	}

	Future<DecryptedTopic> addParticipant(String sdkId, String entityId, String dataOwnerId, TopicRole topicRole) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.addParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
				"topicRole": jsonEncode(TopicRole.encode(topicRole)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method addParticipant");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<DecryptedTopic> removeParticipant(String sdkId, String entityId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.removeParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeParticipant");
		final parsedResJson = jsonDecode(res);
		return DecryptedTopic.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedTopic>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<Topic> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}
}

class TopicTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	TopicTryAndRecoverPlatformApi(this._methodChannel);

	Future<Topic> shareWith(String sdkId, String delegateId, Topic topic, TopicShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"topic": jsonEncode(Topic.encode(topic)),
				"options": jsonEncode(options == null ? null : TopicShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic> shareWithMany(String sdkId, Topic topic, Map<String, TopicShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TopicShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Topic>> filterTopicsBy(String sdkId, FilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.filterTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Topic.fromJSON(x0));
	}

	Future<PaginatedListIterator<Topic>> filterTopicsBySorted(String sdkId, SortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.filterTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Topic.fromJSON(x0));
	}

	Future<Topic> createTopic(String sdkId, Topic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.createTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Topic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic> undeleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.undeleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic> modifyTopic(String sdkId, Topic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.modifyTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Topic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic> undeleteTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.undeleteTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopicById");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic?> getTopic(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.getTopic',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopic");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Topic.fromJSON(parsedResJson);
	}

	Future<List<Topic>> getTopics(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.getTopics',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Topic.fromJSON(x1) ).toList();
	}

	Future<Topic> addParticipant(String sdkId, String entityId, String dataOwnerId, TopicRole topicRole) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.addParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
				"topicRole": jsonEncode(TopicRole.encode(topicRole)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method addParticipant");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<Topic> removeParticipant(String sdkId, String entityId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.tryAndRecover.removeParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeParticipant");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}
}

class TopicEncryptedPlatformApi {
	MethodChannel _methodChannel;
	TopicEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedTopic> shareWith(String sdkId, String delegateId, EncryptedTopic topic, TopicShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"topic": jsonEncode(EncryptedTopic.encode(topic)),
				"options": jsonEncode(options == null ? null : TopicShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> shareWithMany(String sdkId, EncryptedTopic topic, Map<String, TopicShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(EncryptedTopic.encode(topic)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, TopicShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBy(String sdkId, FilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.filterTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBySorted(String sdkId, SortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.filterTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}

	Future<EncryptedTopic> createTopic(String sdkId, EncryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.createTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<Topic> undeleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.undeleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> modifyTopic(String sdkId, EncryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.modifyTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> undeleteTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.undeleteTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopicById");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic?> getTopic(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.getTopic',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopic");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<List<EncryptedTopic>> getTopics(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.getTopics',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedTopic.fromJSON(x1) ).toList();
	}

	Future<EncryptedTopic> addParticipant(String sdkId, String entityId, String dataOwnerId, TopicRole topicRole) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.addParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
				"topicRole": jsonEncode(TopicRole.encode(topicRole)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method addParticipant");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> removeParticipant(String sdkId, String entityId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicApi.encrypted.removeParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeParticipant");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}
}