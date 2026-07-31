"""Tests for the APIs of entities that are not encrypted, and so have no flavours nor sharing."""
import unittest

from cardinal_sdk.filters import HealthcarePartyFilters
from cardinal_sdk.model import DataOwnerWithTypeHcpDataOwner

from cardinal_test_case import CardinalTestCase


class NonEncryptableEntitiesTest(CardinalTestCase):

	def _skip_unless_hcp(self) -> None:
		if not isinstance(self.sdk.data_owner.get_current_data_owner_blocking(), DataOwnerWithTypeHcpDataOwner):
			raise unittest.SkipTest("The configured user is not a healthcare party")

	def test_get_current_healthcare_party(self):
		self._skip_unless_hcp()
		hcp = self.sdk.healthcare_party.get_current_healthcare_party_blocking()
		self.assertEqual(self.data_owner_id, hcp.id)
		self.assertIsNotNone(hcp.rev)

	def test_get_healthcare_party_by_id(self):
		self._skip_unless_hcp()
		hcp = self.sdk.healthcare_party.get_healthcare_party_blocking(self.data_owner_id)
		self.assertIsNotNone(hcp)
		self.assertEqual(self.data_owner_id, hcp.id)

	def test_filter_healthcare_parties_by_ids(self):
		self._skip_unless_hcp()
		iterator = self.sdk.healthcare_party.filter_health_parties_by_blocking(
			HealthcarePartyFilters.by_ids([self.data_owner_id]),
		)
		found = []
		while iterator.has_next_blocking():
			found.extend(iterator.next_blocking(10))
		self.assertEqual([self.data_owner_id], [hcp.id for hcp in found])

	def test_get_unknown_codes_returns_an_empty_list(self):
		self.assertEqual([], self.sdk.code.get_codes_blocking(["not-an-existing-code"]))

	async def test_get_current_healthcare_party_async(self):
		self._skip_unless_hcp()
		hcp = await self.sdk.healthcare_party.get_current_healthcare_party_async()
		self.assertEqual(self.data_owner_id, hcp.id)
