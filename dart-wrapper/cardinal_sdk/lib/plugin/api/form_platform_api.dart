// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/form.dart';
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
import 'package:cardinal_sdk/model/form_template.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/crypto/entities/form_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class FormPlatformApi {
	MethodChannel _methodChannel;
	FormEncryptedPlatformApi encrypted;
	FormTryAndRecoverPlatformApi tryAndRecover;
	FormPlatformApi(
		this._methodChannel
		) : encrypted = FormEncryptedPlatformApi(_methodChannel),
		tryAndRecover = FormTryAndRecoverPlatformApi(_methodChannel);

	Future<DecryptedForm> withEncryptionMetadata(String sdkId, DecryptedForm? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId, String? alternateRootDelegateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedForm.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
				"alternateRootDelegateId": jsonEncode(alternateRootDelegateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Form entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Form.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<DecryptedForm> decrypt(String sdkId, EncryptedForm form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.decrypt',
			{
				"sdkId": sdkId,
				"form": jsonEncode(EncryptedForm.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<Form> tryDecrypt(String sdkId, EncryptedForm form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"form": jsonEncode(EncryptedForm.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<List<String>> matchFormsBy(String sdkId, FilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.matchFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchFormsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchFormsBySorted(String sdkId, SortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.matchFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteFormById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.deleteFormById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteFormById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteFormsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.deleteFormsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteFormsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.purgeFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.deleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteForm");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteForms(String sdkId, List<Form> forms) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.deleteForms',
			{
				"sdkId": sdkId,
				"forms": jsonEncode(forms.map((x0) => Form.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.purgeForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
	}

	Future<FormTemplate> getFormTemplate(String sdkId, String formTemplateId, bool? raw) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
				"raw": jsonEncode(raw),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<FormTemplate> createFormTemplate(String sdkId, FormTemplate formTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.createFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplate": jsonEncode(FormTemplate.encode(formTemplate)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteFormTemplate(String sdkId, String formTemplateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.deleteFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteFormTemplate");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<FormTemplate> updateFormTemplate(String sdkId, FormTemplate formTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.updateFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplate": jsonEncode(FormTemplate.encode(formTemplate)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method updateFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<String> setTemplateAttachment(String sdkId, String formTemplateId, Uint8List payload) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.setTemplateAttachment',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
				"payload": jsonEncode(base64Encode(payload as List<int>)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setTemplateAttachment");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<DecryptedForm> shareWith(String sdkId, String delegateId, DecryptedForm form, FormShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"form": jsonEncode(DecryptedForm.encode(form)),
				"options": jsonEncode(options == null ? null : FormShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<DecryptedForm> shareWithMany(String sdkId, DecryptedForm form, Map<String, FormShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.shareWithMany',
			{
				"sdkId": sdkId,
				"form": jsonEncode(DecryptedForm.encode(form)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, FormShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedForm>> filterFormsBy(String sdkId, FilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.filterFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedForm.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedForm>> filterFormsBySorted(String sdkId, SortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.filterFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedForm.fromJSON(x0));
	}

	Future<DecryptedForm> createForm(String sdkId, DecryptedForm entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.createForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedForm.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForm");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<List<DecryptedForm>> createForms(String sdkId, List<DecryptedForm> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.createForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedForm.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedForm.fromJSON(x1) ).toList();
	}

	Future<DecryptedForm> modifyForm(String sdkId, DecryptedForm entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.modifyForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedForm.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForm");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<DecryptedForm> undeleteFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.undeleteFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteFormById");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<DecryptedForm> undeleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.undeleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteForm");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<List<DecryptedForm>> modifyForms(String sdkId, List<DecryptedForm> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.modifyForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedForm.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedForm.fromJSON(x1) ).toList();
	}

	Future<DecryptedForm?> getForm(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getForm',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForm");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : DecryptedForm.fromJSON(parsedResJson);
	}

	Future<List<DecryptedForm>> getForms(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getForms',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedForm.fromJSON(x1) ).toList();
	}

	Future<DecryptedForm> getLatestFormByLogicalUuid(String sdkId, String logicalUuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getLatestFormByLogicalUuid',
			{
				"sdkId": sdkId,
				"logicalUuid": jsonEncode(logicalUuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByLogicalUuid");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}

	Future<DecryptedForm> getLatestFormByUniqueId(String sdkId, String uniqueId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.getLatestFormByUniqueId',
			{
				"sdkId": sdkId,
				"uniqueId": jsonEncode(uniqueId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByUniqueId");
		final parsedResJson = jsonDecode(res);
		return DecryptedForm.fromJSON(parsedResJson);
	}
}

class FormTryAndRecoverPlatformApi {
	MethodChannel _methodChannel;
	FormTryAndRecoverPlatformApi(this._methodChannel);

	Future<Form> shareWith(String sdkId, String delegateId, Form form, FormShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"form": jsonEncode(Form.encode(form)),
				"options": jsonEncode(options == null ? null : FormShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<Form> shareWithMany(String sdkId, Form form, Map<String, FormShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, FormShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Form>> filterFormsBy(String sdkId, FilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.filterFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Form.fromJSON(x0));
	}

	Future<PaginatedListIterator<Form>> filterFormsBySorted(String sdkId, SortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.filterFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Form.fromJSON(x0));
	}

	Future<Form> createForm(String sdkId, Form entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.createForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Form.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForm");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<List<Form>> createForms(String sdkId, List<Form> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.createForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Form.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Form.fromJSON(x1) ).toList();
	}

	Future<Form> modifyForm(String sdkId, Form entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.modifyForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Form.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForm");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<Form> undeleteFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.undeleteFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteFormById");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<Form> undeleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.undeleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteForm");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<List<Form>> modifyForms(String sdkId, List<Form> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.modifyForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Form.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Form.fromJSON(x1) ).toList();
	}

	Future<Form?> getForm(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.getForm',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForm");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : Form.fromJSON(parsedResJson);
	}

	Future<List<Form>> getForms(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.getForms',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Form.fromJSON(x1) ).toList();
	}

	Future<Form> getLatestFormByLogicalUuid(String sdkId, String logicalUuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.getLatestFormByLogicalUuid',
			{
				"sdkId": sdkId,
				"logicalUuid": jsonEncode(logicalUuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByLogicalUuid");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}

	Future<Form> getLatestFormByUniqueId(String sdkId, String uniqueId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.tryAndRecover.getLatestFormByUniqueId',
			{
				"sdkId": sdkId,
				"uniqueId": jsonEncode(uniqueId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByUniqueId");
		final parsedResJson = jsonDecode(res);
		return Form.fromJSON(parsedResJson);
	}
}

class FormEncryptedPlatformApi {
	MethodChannel _methodChannel;
	FormEncryptedPlatformApi(this._methodChannel);

	Future<EncryptedForm> shareWith(String sdkId, String delegateId, EncryptedForm form, FormShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"form": jsonEncode(EncryptedForm.encode(form)),
				"options": jsonEncode(options == null ? null : FormShareOptions.encode(options!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> shareWithMany(String sdkId, EncryptedForm form, Map<String, FormShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"form": jsonEncode(EncryptedForm.encode(form)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, FormShareOptions.encode(v0)))),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBy(String sdkId, FilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.filterFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedForm.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBySorted(String sdkId, SortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.filterFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedForm.fromJSON(x0));
	}

	Future<EncryptedForm> createForm(String sdkId, EncryptedForm entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.createForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedForm.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<List<EncryptedForm>> createForms(String sdkId, List<EncryptedForm> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.createForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedForm.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedForm.fromJSON(x1) ).toList();
	}

	Future<EncryptedForm> modifyForm(String sdkId, EncryptedForm entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.modifyForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedForm.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> undeleteFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.undeleteFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteFormById");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> undeleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.undeleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<List<EncryptedForm>> modifyForms(String sdkId, List<EncryptedForm> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.modifyForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedForm.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedForm.fromJSON(x1) ).toList();
	}

	Future<EncryptedForm?> getForm(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.getForm',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForm");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedForm.fromJSON(parsedResJson);
	}

	Future<List<EncryptedForm>> getForms(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.getForms',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedForm.fromJSON(x1) ).toList();
	}

	Future<EncryptedForm> getLatestFormByLogicalUuid(String sdkId, String logicalUuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.getLatestFormByLogicalUuid',
			{
				"sdkId": sdkId,
				"logicalUuid": jsonEncode(logicalUuid),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByLogicalUuid");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> getLatestFormByUniqueId(String sdkId, String uniqueId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormApi.encrypted.getLatestFormByUniqueId',
			{
				"sdkId": sdkId,
				"uniqueId": jsonEncode(uniqueId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByUniqueId");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}
}