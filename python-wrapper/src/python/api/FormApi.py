# auto-generated file
import json
import base64
from typing import Optional
from cardinal_sdk.model import DecryptedForm, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Form, serialize_form, EntityReferenceInGroup, EncryptedForm, deserialize_form, StoredDocumentIdentifier, FormTemplate, FormShareOptions, GroupScoped
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions, BaseFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class FormApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = FormApiEncrypted(self.cardinal_sdk)
		self.try_and_recover = FormApiTryAndRecover(self.cardinal_sdk)
		self.in_group = FormApiInGroup(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, base: Optional[DecryptedForm], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedForm], patient: Patient, user: Optional[User] = None, delegates: dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_id: Optional[str] = None) -> DecryptedForm:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateId": alternate_root_delegate_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, form: Form) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, form: Form) -> set[HexString]:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, form: Form) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, form: Form) -> bool:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, form: Form) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, form: Form) -> set[EntityReferenceInGroup]:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Form, delegates: set[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_form(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Form, delegates: set[str]) -> None:
		payload = {
			"entity": serialize_form(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, form: EncryptedForm) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"form": form.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, form: EncryptedForm) -> DecryptedForm:
		payload = {
			"form": form.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, form: EncryptedForm) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"form": form.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, form: EncryptedForm) -> Form:
		payload = {
			"form": form.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def match_forms_by_async(self, filter: FilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_blocking(self, filter: FilterOptions[Form]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_forms_by_sorted_async(self, filter: SortableFilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_sorted_blocking(self, filter: SortableFilterOptions[Form]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_form_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_form_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_form_async(self, form: Form) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_blocking(self, form: Form) -> StoredDocumentIdentifier:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_forms_async(self, forms: list[Form]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_blocking(self, forms: list[Form]) -> list[StoredDocumentIdentifier]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_form_async(self, form: Form) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_blocking(self, form: Form) -> None:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_forms_async(self, forms: list[Form]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_forms_blocking(self, forms: list[Form]) -> list[StoredDocumentIdentifier]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_form_template_async(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplateId": form_template_id,
			"raw": raw,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_template_blocking(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		payload = {
			"formTemplateId": form_template_id,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def get_form_templates_async(self, form_template_ids: list[str]) -> list[FormTemplate]:
		def do_decode(raw_result):
			return [FormTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplateIds": [x0 for x0 in form_template_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_templates_blocking(self, form_template_ids: list[str]) -> list[FormTemplate]:
		payload = {
			"formTemplateIds": [x0 for x0 in form_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def create_form_templates_async(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		def do_decode(raw_result):
			return [FormTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_templates_blocking(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def modify_form_templates_async(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		def do_decode(raw_result):
			return [FormTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_templates_blocking(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_form_template_by_id_async(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_by_id_blocking(self, entity_id: str, rev: str) -> StoredDocumentIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_form_templates_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplatesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_templates_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplatesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_form_template_async(self, form_template: FormTemplate) -> StoredDocumentIdentifier:
		def do_decode(raw_result):
			return StoredDocumentIdentifier._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_blocking(self, form_template: FormTemplate) -> StoredDocumentIdentifier:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = StoredDocumentIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_form_templates_async(self, form_templates: list[FormTemplate]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_templates_blocking(self, form_templates: list[FormTemplate]) -> list[StoredDocumentIdentifier]:
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.deleteFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_template_by_id_async(self, id: str, rev: str) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_template_by_id_blocking(self, id: str, rev: str) -> FormTemplate:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def undelete_form_templates_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[FormTemplate]:
		def do_decode(raw_result):
			return [FormTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplatesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_templates_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[FormTemplate]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplatesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def undelete_form_templates_async(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		def do_decode(raw_result):
			return [FormTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_templates_blocking(self, form_templates: list[FormTemplate]) -> list[FormTemplate]:
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_form_template_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_template_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_form_templates_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplatesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_templates_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[StoredDocumentIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplatesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_form_template_async(self, form_template: FormTemplate) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_template_blocking(self, form_template: FormTemplate) -> None:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_form_templates_async(self, form_templates: list[FormTemplate]) -> list[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return [StoredDocumentIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_templates_blocking(self, form_templates: list[FormTemplate]) -> list[StoredDocumentIdentifier]:
		payload = {
			"formTemplates": [x0.__serialize__() for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.purgeFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [StoredDocumentIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_template_attachment_async(self, form_template_id: str, payload: bytearray) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"formTemplateId": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.setTemplateAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_template_attachment_blocking(self, form_template_id: str, payload: bytearray) -> str:
		payload = {
			"formTemplateId": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.setTemplateAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def match_form_template_by_async(self, filter: BaseFilterOptions[FormTemplate]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormTemplateByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_form_template_by_blocking(self, filter: BaseFilterOptions[FormTemplate]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.matchFormTemplateByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate_id: str, form: DecryptedForm, options: Optional[FormShareOptions] = None) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"form": form.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, form: DecryptedForm, options: Optional[FormShareOptions] = None) -> DecryptedForm:
		payload = {
			"delegateId": delegate_id,
			"form": form.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, form: DecryptedForm, delegates: dict[str, FormShareOptions]) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: DecryptedForm, delegates: dict[str, FormShareOptions]) -> DecryptedForm:
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def filter_forms_by_async(self, filter: FilterOptions[Form]) -> PaginatedListIterator[DecryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedForm](
				producer = raw_result,
				deserializer = lambda x: DecryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, filter: FilterOptions[Form]) -> PaginatedListIterator[DecryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedForm](
				producer = class_pointer,
				deserializer = lambda x: DecryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[DecryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedForm](
				producer = raw_result,
				deserializer = lambda x: DecryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[DecryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedForm](
				producer = class_pointer,
				deserializer = lambda x: DecryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: DecryptedForm) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: DecryptedForm) -> DecryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def create_forms_async(self, entities: list[DecryptedForm]) -> list[DecryptedForm]:
		def do_decode(raw_result):
			return [DecryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[DecryptedForm]) -> list[DecryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: DecryptedForm) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: DecryptedForm) -> DecryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def modify_forms_async(self, entities: list[DecryptedForm]) -> list[DecryptedForm]:
		def do_decode(raw_result):
			return [DecryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[DecryptedForm]) -> list[DecryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, id: str, rev: str) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, id: str, rev: str) -> DecryptedForm:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedForm]:
		def do_decode(raw_result):
			return [DecryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DecryptedForm]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: Form) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: Form) -> DecryptedForm:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_forms_async(self, forms: list[Form]) -> list[DecryptedForm]:
		def do_decode(raw_result):
			return [DecryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[Form]) -> list[DecryptedForm]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, entity_id: str) -> Optional[DecryptedForm]:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, entity_id: str) -> Optional[DecryptedForm]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, entity_ids: list[str]) -> list[DecryptedForm]:
		def do_decode(raw_result):
			return [DecryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, entity_ids: list[str]) -> list[DecryptedForm]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_latest_form_by_unique_id_async(self, unique_id: str) -> DecryptedForm:
		def do_decode(raw_result):
			return DecryptedForm._deserialize(raw_result)
		payload = {
			"uniqueId": unique_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getLatestFormByUniqueIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_form_by_unique_id_blocking(self, unique_id: str) -> DecryptedForm:
		payload = {
			"uniqueId": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.getLatestFormByUniqueIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedForm._deserialize(result_info.success)
			return return_value


class FormApiEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, form: EncryptedForm, options: Optional[FormShareOptions] = None) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"form": form.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, form: EncryptedForm, options: Optional[FormShareOptions] = None) -> EncryptedForm:
		payload = {
			"delegateId": delegate_id,
			"form": form.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, form: EncryptedForm, delegates: dict[str, FormShareOptions]) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: EncryptedForm, delegates: dict[str, FormShareOptions]) -> EncryptedForm:
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def filter_forms_by_async(self, filter: FilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedForm](
				producer = raw_result,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, filter: FilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedForm](
				producer = class_pointer,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedForm](
				producer = raw_result,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[EncryptedForm](
				producer = class_pointer,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: EncryptedForm) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: EncryptedForm) -> EncryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def create_forms_async(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: EncryptedForm) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: EncryptedForm) -> EncryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def modify_forms_async(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, id: str, rev: str) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, id: str, rev: str) -> EncryptedForm:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[EncryptedForm]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: Form) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: Form) -> EncryptedForm:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_forms_async(self, forms: list[Form]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[Form]) -> list[EncryptedForm]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, entity_id: str) -> Optional[EncryptedForm]:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, entity_id: str) -> Optional[EncryptedForm]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, entity_ids: list[str]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, entity_ids: list[str]) -> list[EncryptedForm]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_latest_form_by_unique_id_async(self, unique_id: str) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"uniqueId": unique_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getLatestFormByUniqueIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_form_by_unique_id_blocking(self, unique_id: str) -> EncryptedForm:
		payload = {
			"uniqueId": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.encrypted.getLatestFormByUniqueIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value


class FormApiTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate_id: str, form: Form, options: Optional[FormShareOptions] = None) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"delegateId": delegate_id,
			"form": serialize_form(form),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, form: Form, options: Optional[FormShareOptions] = None) -> Form:
		payload = {
			"delegateId": delegate_id,
			"form": serialize_form(form),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def share_with_many_async(self, form: Form, delegates: dict[str, FormShareOptions]) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"form": serialize_form(form),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: Form, delegates: dict[str, FormShareOptions]) -> Form:
		payload = {
			"form": serialize_form(form),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def filter_forms_by_async(self, filter: FilterOptions[Form]) -> PaginatedListIterator[Form]:
		def do_decode(raw_result):
			return PaginatedListIterator[Form](
				producer = raw_result,
				deserializer = lambda x: deserialize_form(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, filter: FilterOptions[Form]) -> PaginatedListIterator[Form]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Form](
				producer = class_pointer,
				deserializer = lambda x: deserialize_form(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[Form]:
		def do_decode(raw_result):
			return PaginatedListIterator[Form](
				producer = raw_result,
				deserializer = lambda x: deserialize_form(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[Form]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Form](
				producer = class_pointer,
				deserializer = lambda x: deserialize_form(x),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: Form) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"entity": serialize_form(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: Form) -> Form:
		payload = {
			"entity": serialize_form(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def create_forms_async(self, entities: list[Form]) -> list[Form]:
		def do_decode(raw_result):
			return [deserialize_form(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_form(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[Form]) -> list[Form]:
		payload = {
			"entities": [serialize_form(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_form(x1) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: Form) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"entity": serialize_form(entity),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: Form) -> Form:
		payload = {
			"entity": serialize_form(entity),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def modify_forms_async(self, entities: list[Form]) -> list[Form]:
		def do_decode(raw_result):
			return [deserialize_form(x1) for x1 in raw_result]
		payload = {
			"entities": [serialize_form(x0) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[Form]) -> list[Form]:
		payload = {
			"entities": [serialize_form(x0) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_form(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, id: str, rev: str) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, id: str, rev: str) -> Form:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Form]:
		def do_decode(raw_result):
			return [deserialize_form(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[Form]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_form(x1) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: Form) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: Form) -> Form:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value

	async def undelete_forms_async(self, forms: list[Form]) -> list[Form]:
		def do_decode(raw_result):
			return [deserialize_form(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[Form]) -> list[Form]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_form(x1) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, entity_id: str) -> Optional[Form]:
		def do_decode(raw_result):
			return deserialize_form(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, entity_id: str) -> Optional[Form]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, entity_ids: list[str]) -> list[Form]:
		def do_decode(raw_result):
			return [deserialize_form(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, entity_ids: list[str]) -> list[Form]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_form(x1) for x1 in result_info.success]
			return return_value

	async def get_latest_form_by_unique_id_async(self, unique_id: str) -> Form:
		def do_decode(raw_result):
			return deserialize_form(raw_result)
		payload = {
			"uniqueId": unique_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getLatestFormByUniqueIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_form_by_unique_id_blocking(self, unique_id: str) -> Form:
		payload = {
			"uniqueId": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover.getLatestFormByUniqueIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_form(result_info.success)
			return return_value


class FormApiInGroup:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = FormApiInGroupEncrypted(self.cardinal_sdk)
		self.try_and_recover = FormApiInGroupTryAndRecover(self.cardinal_sdk)

	async def with_encryption_metadata_async(self, entity_group_id: str, base: Optional[DecryptedForm], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, entity_group_id: str, base: Optional[DecryptedForm], patient: Optional[GroupScoped[Patient]], user: Optional[User] = None, delegates: dict[EntityReferenceInGroup, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent(), alternate_root_delegate_reference: Optional[EntityReferenceInGroup] = None) -> GroupScoped[DecryptedForm]:
		payload = {
			"entityGroupId": entity_group_id,
			"base": base.__serialize__() if base is not None else None,
			"patient": patient.__serialize__(lambda x0: serialize_patient(x0)) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
			"secretId": serialize_secret_id_use_option(secret_id),
			"alternateRootDelegateReference": alternate_root_delegate_reference.__serialize__() if alternate_root_delegate_reference is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def get_encryption_keys_of_async(self, form: GroupScoped[Form]) -> set[HexString]:
		def do_decode(raw_result):
			return {x1 for x1 in raw_result}
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, form: GroupScoped[Form]) -> set[HexString]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {x1 for x1 in result_info.success}
			return return_value

	async def has_write_access_async(self, form: GroupScoped[Form]) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, form: GroupScoped[Form]) -> bool:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, form: GroupScoped[Form]) -> set[EntityReferenceInGroup]:
		def do_decode(raw_result):
			return {EntityReferenceInGroup._deserialize(x1) for x1 in raw_result}
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, form: GroupScoped[Form]) -> set[EntityReferenceInGroup]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = {EntityReferenceInGroup._deserialize(x1) for x1 in result_info.success}
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: GroupScoped[Form], delegates: set[EntityReferenceInGroup]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: GroupScoped[Form], delegates: set[EntityReferenceInGroup]) -> None:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
			"delegates": [x0.__serialize__() for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def try_decrypt_async(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[Form]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value

	async def match_forms_by_async(self, group_id: str, filter: FilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_blocking(self, group_id: str, filter: FilterOptions[Form]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_forms_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[Form]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_form_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_forms_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_form_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_forms_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_forms_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_form_async(self, form: GroupScoped[Form]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_blocking(self, form: GroupScoped[Form]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_forms_async(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_blocking(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_form_async(self, form: GroupScoped[Form]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_blocking(self, form: GroupScoped[Form]) -> None:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_forms_async(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_forms_blocking(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def create_form_template_async(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: FormTemplate._deserialize(x1))
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_template_blocking(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: FormTemplate._deserialize(x1))
			return return_value

	async def create_form_templates_async(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_templates_blocking(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_form_template_async(self, group_id: str, form_template_id: str) -> Optional[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: FormTemplate._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"formTemplateId": form_template_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_template_blocking(self, group_id: str, form_template_id: str) -> Optional[GroupScoped[FormTemplate]]:
		payload = {
			"groupId": group_id,
			"formTemplateId": form_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: FormTemplate._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_form_templates_async(self, group_id: str, form_templates_ids: list[str]) -> list[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"formTemplatesIds": [x0 for x0 in form_templates_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_templates_blocking(self, group_id: str, form_templates_ids: list[str]) -> list[GroupScoped[FormTemplate]]:
		payload = {
			"groupId": group_id,
			"formTemplatesIds": [x0 for x0 in form_templates_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_form_template_async(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: FormTemplate._deserialize(x1))
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_template_blocking(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: FormTemplate._deserialize(x1))
			return return_value

	async def modify_form_templates_async(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_templates_blocking(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_form_template_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_form_template_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def delete_form_template_async(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[StoredDocumentIdentifier]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: StoredDocumentIdentifier._deserialize(x1))
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_blocking(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[StoredDocumentIdentifier]:
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: StoredDocumentIdentifier._deserialize(x1))
			return return_value

	async def delete_form_templates_async(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_templates_blocking(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.deleteFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_template_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[FormTemplate]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: FormTemplate._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_template_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[FormTemplate]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: FormTemplate._deserialize(x1))
			return return_value

	async def undelete_form_template_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_template_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[FormTemplate]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_template_async(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: FormTemplate._deserialize(x1))
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_template_blocking(self, form_template: GroupScoped[FormTemplate]) -> GroupScoped[FormTemplate]:
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: FormTemplate._deserialize(x1))
			return return_value

	async def undelete_form_templates_async(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_templates_blocking(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[FormTemplate]]:
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: FormTemplate._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_form_template_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_template_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> None:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_form_template_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_template_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def purge_form_template_async(self, form_template: GroupScoped[FormTemplate]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_template_blocking(self, form_template: GroupScoped[FormTemplate]) -> None:
		payload = {
			"formTemplate": form_template.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_form_templates_async(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in raw_result]
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_templates_blocking(self, form_templates: list[GroupScoped[FormTemplate]]) -> list[GroupScoped[StoredDocumentIdentifier]]:
		payload = {
			"formTemplates": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in form_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.purgeFormTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: StoredDocumentIdentifier._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def match_form_template_by_async(self, group_id: str, filter: BaseFilterOptions[FormTemplate]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormTemplateByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_form_template_by_blocking(self, group_id: str, filter: BaseFilterOptions[FormTemplate]) -> list[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.matchFormTemplateByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate: EntityReferenceInGroup, form: GroupScoped[DecryptedForm], options: Optional[FormShareOptions] = None) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, form: GroupScoped[DecryptedForm], options: Optional[FormShareOptions] = None) -> GroupScoped[DecryptedForm]:
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def share_with_many_async(self, form: GroupScoped[DecryptedForm], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: GroupScoped[DecryptedForm], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[DecryptedForm]:
		payload = {
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def filter_forms_by_async(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedForm]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[DecryptedForm]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[DecryptedForm]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[DecryptedForm]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[DecryptedForm]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[DecryptedForm]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: DecryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: GroupScoped[DecryptedForm]) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: GroupScoped[DecryptedForm]) -> GroupScoped[DecryptedForm]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def create_forms_async(self, entities: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[DecryptedForm]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: GroupScoped[Form]) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: GroupScoped[Form]) -> GroupScoped[DecryptedForm]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def undelete_forms_async(self, forms: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: GroupScoped[DecryptedForm]) -> GroupScoped[DecryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: GroupScoped[DecryptedForm]) -> GroupScoped[DecryptedForm]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1))
			return return_value

	async def modify_forms_async(self, entities: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[GroupScoped[DecryptedForm]]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: DecryptedForm._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[DecryptedForm]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: DecryptedForm._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[DecryptedForm]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: DecryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value


class FormApiInGroupEncrypted:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, form: GroupScoped[EncryptedForm], options: Optional[FormShareOptions] = None) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, form: GroupScoped[EncryptedForm], options: Optional[FormShareOptions] = None) -> GroupScoped[EncryptedForm]:
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def share_with_many_async(self, form: GroupScoped[EncryptedForm], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: GroupScoped[EncryptedForm], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[EncryptedForm]:
		payload = {
			"form": form.__serialize__(lambda x0: x0.__serialize__()),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def filter_forms_by_async(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedForm]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[EncryptedForm]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[EncryptedForm]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[EncryptedForm]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[EncryptedForm]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[EncryptedForm]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: EncryptedForm._deserialize(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: GroupScoped[EncryptedForm]) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: GroupScoped[EncryptedForm]) -> GroupScoped[EncryptedForm]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def create_forms_async(self, entities: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[EncryptedForm]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[EncryptedForm]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: GroupScoped[Form]) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: GroupScoped[Form]) -> GroupScoped[EncryptedForm]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def undelete_forms_async(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: GroupScoped[EncryptedForm]) -> GroupScoped[EncryptedForm]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: GroupScoped[EncryptedForm]) -> GroupScoped[EncryptedForm]:
		payload = {
			"entity": entity.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1))
			return return_value

	async def modify_forms_async(self, entities: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[GroupScoped[EncryptedForm]]) -> list[GroupScoped[EncryptedForm]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: EncryptedForm._deserialize(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[EncryptedForm]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: EncryptedForm._deserialize(x1)) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedForm]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[EncryptedForm]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.encrypted.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: EncryptedForm._deserialize(x2)) for x1 in result_info.success]
			return return_value


class FormApiInGroupTryAndRecover:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def share_with_async(self, delegate: EntityReferenceInGroup, form: GroupScoped[Form], options: Optional[FormShareOptions] = None) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate: EntityReferenceInGroup, form: GroupScoped[Form], options: Optional[FormShareOptions] = None) -> GroupScoped[Form]:
		payload = {
			"delegate": delegate.__serialize__(),
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def share_with_many_async(self, form: GroupScoped[Form], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, form: GroupScoped[Form], delegates: dict[EntityReferenceInGroup, FormShareOptions]) -> GroupScoped[Form]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
			"delegates": [{ "k": k0.__serialize__(), "v": v0.__serialize__() } for k0, v0 in delegates.items()],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def filter_forms_by_async(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[Form]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[Form]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_form(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, group_id: str, filter: FilterOptions[Form]) -> PaginatedListIterator[GroupScoped[Form]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.filterFormsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[Form]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_form(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[Form]]:
		def do_decode(raw_result):
			return PaginatedListIterator[GroupScoped[Form]](
				producer = raw_result,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_form(x1)),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, group_id: str, filter: SortableFilterOptions[Form]) -> PaginatedListIterator[GroupScoped[Form]]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.filterFormsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[GroupScoped[Form]](
				producer = class_pointer,
				deserializer = lambda x: GroupScoped._deserialize(x, lambda x1: deserialize_form(x1)),
				executor = self.cardinal_sdk._executor
			)

	async def create_form_async(self, entity: GroupScoped[Form]) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: GroupScoped[Form]) -> GroupScoped[Form]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def create_forms_async(self, entities: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_by_id_async(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, entity_id: GroupScoped[StoredDocumentIdentifier]) -> GroupScoped[Form]:
		payload = {
			"entityId": entity_id.__serialize__(lambda x0: x0.__serialize__()),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def undelete_forms_by_ids_async(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_by_ids_blocking(self, entity_ids: list[GroupScoped[StoredDocumentIdentifier]]) -> list[GroupScoped[Form]]:
		payload = {
			"entityIds": [x0.__serialize__(lambda x1: x1.__serialize__()) for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value

	async def undelete_form_async(self, form: GroupScoped[Form]) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: GroupScoped[Form]) -> GroupScoped[Form]:
		payload = {
			"form": form.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def undelete_forms_async(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_forms_blocking(self, forms: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		payload = {
			"forms": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.undeleteFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: GroupScoped[Form]) -> GroupScoped[Form]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1))
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: GroupScoped[Form]) -> GroupScoped[Form]:
		payload = {
			"entity": entity.__serialize__(lambda x0: serialize_form(x0)),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1))
			return return_value

	async def modify_forms_async(self, entities: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[GroupScoped[Form]]) -> list[GroupScoped[Form]]:
		payload = {
			"entities": [x0.__serialize__(lambda x1: serialize_form(x1)) for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, group_id: str, entity_id: str) -> Optional[GroupScoped[Form]]:
		def do_decode(raw_result):
			return GroupScoped._deserialize(raw_result, lambda x1: deserialize_form(x1)) if raw_result is not None else None
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, group_id: str, entity_id: str) -> Optional[GroupScoped[Form]]:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = GroupScoped._deserialize(result_info.success, lambda x1: deserialize_form(x1)) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[Form]]:
		def do_decode(raw_result):
			return [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, group_id: str, entity_ids: list[str]) -> list[GroupScoped[Form]]:
		payload = {
			"groupId": group_id,
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormApi.inGroup.tryAndRecover.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [GroupScoped._deserialize(x1, lambda x2: deserialize_form(x2)) for x1 in result_info.success]
			return return_value
