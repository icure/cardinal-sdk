"""Base test case, with the helpers shared by all the tests."""
import unittest
from typing import Optional

from cardinal_sdk import CardinalSdk
from cardinal_sdk.model import DecryptedHealthElement, DecryptedPatient, SecurityMetadata

from cardinal_test_env import new_uuid, primary_user, sdk_for


class CardinalTestCase(unittest.IsolatedAsyncioTestCase):
	"""
	Test case using the primary user of the test environment.

	The entities created through the helpers of this class are deleted at the end of the test that
	created them: the tests run against a shared, long-lived environment.
	"""

	sdk: CardinalSdk
	data_owner_id: str

	@classmethod
	def setUpClass(cls) -> None:
		cls.sdk = sdk_for(primary_user())
		cls.data_owner_id = cls.sdk.data_owner.get_current_data_owner_id_blocking()

	def assertDelegate(self, delegate_id: str, security_metadata: Optional[SecurityMetadata]) -> None:
		"""Asserts that at least one of the secure delegations of the metadata is for `delegate_id`."""
		self.assertIsNotNone(security_metadata, "The entity has no security metadata")
		delegates = [delegation.delegate for delegation in security_metadata.secure_delegations.values()]
		self.assertIn(
			delegate_id,
			delegates,
			f"No secure delegation for {delegate_id}, the delegates of the entity are {delegates}",
		)

	def new_patient(self, note: str = "This note is encrypted") -> DecryptedPatient:
		patient_id = new_uuid()
		return DecryptedPatient(
			id=patient_id,
			first_name=f"Patient-{patient_id}",
			last_name="Doe",
			note=note,
		)

	def create_patient(
		self,
		note: str = "This note is encrypted",
		sdk: Optional[CardinalSdk] = None,
	) -> DecryptedPatient:
		sdk = sdk or self.sdk
		created = sdk.patient.create_patient_blocking(
			sdk.patient.with_encryption_metadata_blocking(self.new_patient(note)),
		)
		self.addCleanup(delete_patient_quietly, sdk, created.id)
		return created

	def create_health_element(
		self,
		patient: DecryptedPatient,
		descr: str = "Some diagnosis",
		sdk: Optional[CardinalSdk] = None,
	) -> DecryptedHealthElement:
		sdk = sdk or self.sdk
		created = sdk.health_element.create_health_element_blocking(
			sdk.health_element.with_encryption_metadata_blocking(
				DecryptedHealthElement(id=new_uuid(), descr=descr),
				patient,
			),
		)
		self.addCleanup(delete_health_element_quietly, sdk, created.id)
		return created


def delete_patient_quietly(sdk: CardinalSdk, patient_id: str) -> None:
	try:
		patient = sdk.patient.encrypted.get_patient_blocking(patient_id)
		if patient is not None and patient.deletion_date is None:
			sdk.patient.delete_patient_by_id_blocking(patient.id, patient.rev)
	except Exception as e:  # noqa: BLE001 - a failed cleanup must not fail the test
		print(f"Could not delete the test patient {patient_id}: {e}")


def delete_health_element_quietly(sdk: CardinalSdk, health_element_id: str) -> None:
	try:
		health_element = sdk.health_element.encrypted.get_health_element_blocking(health_element_id)
		if health_element is not None and health_element.deletion_date is None:
			sdk.health_element.delete_health_element_by_id_blocking(health_element.id, health_element.rev)
	except Exception as e:  # noqa: BLE001 - a failed cleanup must not fail the test
		print(f"Could not delete the test health element {health_element_id}: {e}")
