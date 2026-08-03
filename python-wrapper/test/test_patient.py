from cardinal_sdk.filters import PatientFilters

from cardinal_test_case import CardinalTestCase, delete_patient_quietly
from cardinal_test_env import new_uuid


class PatientTest(CardinalTestCase):

	def test_create_and_get_patient(self):
		created = self.create_patient()
		self.assertIsNotNone(created.rev)
		self.assertEqual("Doe", created.last_name)
		self.assertEqual("This note is encrypted", created.note)
		self.assertDelegate(self.data_owner_id, created.security_metadata)

		retrieved = self.sdk.patient.get_patient_blocking(created.id)
		self.assertIsNotNone(retrieved)
		self.assertEqual(created.rev, retrieved.rev)
		self.assertEqual(created.note, retrieved.note)

	def test_encrypted_fields_are_not_stored_in_clear(self):
		created = self.create_patient(note="Very sensitive note")
		as_encrypted = self.sdk.patient.encrypted.get_patient_blocking(created.id)
		self.assertIsNotNone(as_encrypted)
		self.assertIsNone(as_encrypted.note, "`note` is an encrypted field, it must not be stored in clear")
		self.assertIsNotNone(as_encrypted.encrypted_self)
		self.assertEqual("Doe", as_encrypted.last_name, "`lastName` is not an encrypted field")

		decrypted = self.sdk.patient.decrypt_blocking([as_encrypted])
		self.assertEqual(1, len(decrypted))
		self.assertEqual("Very sensitive note", decrypted[0].note)

	def test_modify_patient(self):
		created = self.create_patient()
		created.note = "Updated note"
		created.last_name = "Smith"
		modified = self.sdk.patient.modify_patient_blocking(created)
		self.assertNotEqual(created.rev, modified.rev)
		self.assertEqual("Updated note", modified.note)
		self.assertEqual("Smith", modified.last_name)

		retrieved = self.sdk.patient.get_patient_blocking(created.id)
		self.assertEqual("Updated note", retrieved.note)

	def test_get_unknown_patient_returns_none(self):
		self.assertIsNone(self.sdk.patient.get_patient_blocking(new_uuid()))

	def test_filter_patients_by_ids(self):
		created_ids = {self.create_patient().id for _ in range(3)}

		iterator = self.sdk.patient.filter_patients_by_blocking(PatientFilters.by_ids(list(created_ids)))
		found = []
		while iterator.has_next_blocking():
			found.extend(iterator.next_blocking(10))

		self.assertEqual(created_ids, {patient.id for patient in found})
		for patient in found:
			self.assertEqual("This note is encrypted", patient.note)

	def test_match_patients_by_filter(self):
		created = self.create_patient()
		self.assertEqual([created.id], self.sdk.patient.match_patients_by_blocking(PatientFilters.by_ids([created.id])))

	def test_delete_patient(self):
		created = self.create_patient()
		deleted = self.sdk.patient.delete_patient_by_id_blocking(created.id, created.rev)
		self.assertEqual(created.id, deleted.id)
		# The deletion is a soft delete, so the entity may still be retrievable, but only as deleted.
		retrieved = self.sdk.patient.get_patient_blocking(created.id)
		if retrieved is not None:
			self.assertIsNotNone(retrieved.deletion_date)

	async def test_create_and_get_patient_async(self):
		with_metadata = await self.sdk.patient.with_encryption_metadata_async(self.new_patient("Async note"))
		created = await self.sdk.patient.create_patient_async(with_metadata)
		self.addCleanup(delete_patient_quietly, self.sdk, created.id)
		retrieved = await self.sdk.patient.get_patient_async(created.id)
		self.assertIsNotNone(retrieved)
		self.assertEqual("Async note", retrieved.note)
