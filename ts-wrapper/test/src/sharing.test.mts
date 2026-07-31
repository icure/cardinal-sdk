/**
 * Tests involving two distinct data owners: they need `CARDINAL_USER_2_*` to be configured, and are
 * skipped otherwise.
 */
import assert from 'node:assert/strict'
import {describe, type TestContext} from 'node:test'
import {CardinalSdk, ShareAllPatientDataOptions} from '@icure/cardinal-sdk'

import {assertDelegate, cardinalTest, type CardinalTestFixtures} from './cardinalTestCase.mjs'
import {SECONDARY_USER_PREFIX, sdkFor, secondaryUser} from './cardinalTestEnv.mjs'

const delegateCredentials = secondaryUser()

interface Delegate {
	readonly sdk: CardinalSdk
	readonly id: string
}

/**
 * Declares a test that needs a second data owner. Like {@link cardinalTest} the SDK of the delegate
 * is initialized on the first test that needs it and reused by the following ones. The test is
 * skipped if the configured second user turns out to be the same data owner as the primary one,
 * which can only be known after logging in.
 */
function sharingTest(
	name: string,
	body: (fixtures: CardinalTestFixtures, delegate: Delegate, t: TestContext) => Promise<void>,
): void {
	cardinalTest(name, async (fixtures, t) => {
		const sdk = await sdkFor(delegateCredentials!)
		const id = await sdk.dataOwner.getCurrentDataOwnerId()
		if (id === fixtures.dataOwnerId) {
			t.skip(`${SECONDARY_USER_PREFIX} is the same data owner as the primary user`)
			return
		}
		await body(fixtures, {sdk: sdk, id: id}, t)
	})
}

describe(
	'Sharing',
	{
		skip: delegateCredentials === undefined
			? `${SECONDARY_USER_PREFIX}_USERNAME is not set, skipping the tests that need a second data owner`
			: false,
	},
	() => {

		sharingTest('the data of the primary user is not readable by the delegate', async (
			{createPatient, createHealthElement},
			delegate,
		) => {
			const created = await createHealthElement(await createPatient(), 'Not shared diagnosis')
			let retrieved
			try {
				retrieved = await delegate.sdk.healthElement.encrypted.getHealthElement(created.id)
			} catch {
				return // The delegate has no access at all to the entity, which is enough.
			}
			const asEncrypted = retrieved
			assert.ok(asEncrypted !== undefined)
			await assert.rejects(() => delegate.sdk.healthElement.decrypt([asEncrypted]))
		})

		sharingTest('share a health element with the delegate', async (
			{sdk, createPatient, createHealthElement},
			delegate,
		) => {
			const created = await createHealthElement(await createPatient(), 'Shared diagnosis')

			const shared = await sdk.healthElement.shareWith(delegate.id, created)
			assertDelegate(delegate.id, shared.securityMetadata)

			const retrievedByDelegate = await delegate.sdk.healthElement.getHealthElement(created.id)
			assert.ok(retrievedByDelegate !== undefined)
			assert.equal('Shared diagnosis', retrievedByDelegate.descr)
		})

		sharingTest('share a patient with the delegate', async ({sdk, createPatient}, delegate) => {
			const created = await createPatient({note: 'Shared note'})

			const shared = await sdk.patient.shareWith(delegate.id, created)
			assertDelegate(delegate.id, shared.securityMetadata)

			const retrievedByDelegate = await delegate.sdk.patient.getPatient(created.id)
			assert.ok(retrievedByDelegate !== undefined)
			assert.equal('Shared note', retrievedByDelegate.note)
		})

		sharingTest('share all the data of a patient', async (
			{sdk, createPatient, createHealthElement},
			delegate,
		) => {
			const patient = await createPatient()
			const healthElement = await createHealthElement(patient, 'Bulk shared diagnosis')

			const result = await sdk.patient.shareAllDataOfPatient(patient.id, {
				[delegate.id]: [ShareAllPatientDataOptions.Tag.All],
			})
			assert.equal(patient.id, result.patient.id)

			const retrievedByDelegate = await delegate.sdk.healthElement.getHealthElement(healthElement.id)
			assert.ok(retrievedByDelegate !== undefined)
			assert.equal('Bulk shared diagnosis', retrievedByDelegate.descr)
		})
	},
)
