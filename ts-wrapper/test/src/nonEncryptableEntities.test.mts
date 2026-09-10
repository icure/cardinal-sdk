/**
 * Tests for the APIs of entities that are not encrypted, and so have no flavours nor sharing.
 */
import assert from 'node:assert/strict'
import {describe, type TestContext} from 'node:test'
import {HealthcarePartyFilters} from '@icure/cardinal-sdk'

import {cardinalTest, type CardinalTestFixtures, drain} from './cardinalTestCase.mjs'

const HCP_DATA_OWNER = 'com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner'

/**
 * Skips the test if the configured user is not a healthcare party: only healthcare parties have a
 * healthcare party entity to read back.
 */
async function isHcp(fixtures: CardinalTestFixtures, t: TestContext): Promise<boolean> {
	if ((await fixtures.sdk.dataOwner.getCurrentDataOwner()).$ktClass !== HCP_DATA_OWNER) {
		t.skip('The configured user is not a healthcare party')
		return false
	}
	return true
}

describe('Non encryptable entities', () => {

	cardinalTest('get the current healthcare party', async (fixtures, t) => {
		if (!await isHcp(fixtures, t)) return
		const hcp = await fixtures.sdk.healthcareParty.getCurrentHealthcareParty()
		assert.equal(fixtures.dataOwnerId, hcp.id)
		assert.notEqual(hcp.rev, undefined)
	})

	cardinalTest('get a healthcare party by id', async (fixtures, t) => {
		if (!await isHcp(fixtures, t)) return
		const hcp = await fixtures.sdk.healthcareParty.getHealthcareParty(fixtures.dataOwnerId)
		assert.ok(hcp !== undefined)
		assert.equal(fixtures.dataOwnerId, hcp.id)
	})

	cardinalTest('get healthcare parties by ids', async (fixtures, t) => {
		if (!await isHcp(fixtures, t)) return
		const found = await fixtures.sdk.healthcareParty.getHealthcareParties([fixtures.dataOwnerId])
		assert.deepEqual([fixtures.dataOwnerId], found.map((it) => it.id))
	})

	// Note: this cannot use `HealthcarePartyFilters.byIds`, which would be the natural filter here.
	// It is declared as returning `SortableFilterOptions`, but `HealthcarePartyApi` is a non-crypto
	// api and only accepts `BaseFilterOptions` / `BaseSortableFilterOptions`, so the filter is
	// rejected both by the compiler and, at runtime, by `baseFilterOptions_fromJs`. Every other
	// healthcare party filter is declared as `Base*`; see `HealthcarePartyFilters.byIds` in
	// `cardinal-sdk/src/commonMain/kotlin/com/icure/cardinal/sdk/filters/HealthcarePartyFilters.kt`.
	cardinalTest('filter healthcare parties by name', async (fixtures, t) => {
		if (!await isHcp(fixtures, t)) return
		const self = await fixtures.sdk.healthcareParty.getCurrentHealthcareParty()
		if (!self.lastName) {
			t.skip('The healthcare party of the configured user has no last name to search for')
			return
		}
		const found = await drain(
			await fixtures.sdk.healthcareParty.filterHealthPartiesBy(
				HealthcarePartyFilters.byName(self.lastName),
			),
		)
		assert.ok(
			found.some((it) => it.id === fixtures.dataOwnerId),
			`${fixtures.dataOwnerId} is not among the ${found.length} healthcare parties matching "${self.lastName}"`,
		)
	})

	cardinalTest('getting unknown codes returns an empty list', async ({sdk}) => {
		assert.deepEqual([], await sdk.code.getCodes(['not-an-existing-code']))
	})
})
