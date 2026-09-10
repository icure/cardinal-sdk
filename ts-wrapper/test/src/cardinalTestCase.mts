/**
 * Base test helpers, shared by all the tests.
 *
 * The entities created through {@link CardinalTestFixtures} are deleted at the end of the test that
 * created them: the tests run against a shared, long-lived environment.
 */
import assert from 'node:assert/strict'
import {after, it, type TestContext} from 'node:test'
import {
	CardinalSdk,
	DecryptedHealthElement,
	DecryptedPatient,
	PaginatedListIterator,
	Patient,
	SecurityMetadata,
} from '@icure/cardinal-sdk'
import {closeAllSdks, newUuid, primaryUser, sdkFor} from './cardinalTestEnv.mjs'

/**
 * The subset of node's `TestOptions` used here. `node:test` does not export the type itself.
 */
export interface CardinalTestOptions {
	skip?: boolean | string
	todo?: boolean | string
	timeout?: number
}

export const DEFAULT_PATIENT_NOTE = 'This note is encrypted'
export const DEFAULT_HEALTH_ELEMENT_DESCR = 'Some diagnosis'

// Each test file runs in its own process, so this closes the sdks created by that file only.
after(closeAllSdks)

export interface CardinalTestFixtures {
	/** SDK of the primary user of the test environment. */
	readonly sdk: CardinalSdk
	/** Id of the data owner the primary user is linked to. */
	readonly dataOwnerId: string

	/**
	 * Creates a patient, persists it, and schedules its deletion at the end of the test.
	 */
	createPatient(options?: {note?: string, sdk?: CardinalSdk}): Promise<DecryptedPatient>

	/**
	 * Creates a health element for a patient, persists it, and schedules its deletion at the end of
	 * the test.
	 */
	createHealthElement(
		patient: Patient,
		descr?: string,
		sdk?: CardinalSdk,
	): Promise<DecryptedHealthElement>

	/**
	 * Schedules the deletion of an entity created outside of the helpers above.
	 */
	deletePatientAtTheEndOfTheTest(sdk: CardinalSdk, patientId: string): void

	deleteHealthElementAtTheEndOfTheTest(sdk: CardinalSdk, healthElementId: string): void
}

/**
 * A patient with initialized content and no encryption metadata, not persisted.
 */
export function newPatient(note: string = DEFAULT_PATIENT_NOTE): DecryptedPatient {
	const id = newUuid()
	return new DecryptedPatient({
		id: id,
		firstName: `Patient-${id}`,
		lastName: 'Doe',
		note: note,
	})
}

/**
 * Declares a test using the primary user of the test environment. The SDK is initialized on the
 * first test that needs it and reused by the following ones.
 */
export function cardinalTest(
	name: string,
	body: (fixtures: CardinalTestFixtures, t: TestContext) => Promise<void>,
	options: CardinalTestOptions = {},
): void {
	it(name, options, async (t) => {
		const sdk = await sdkFor(primaryUser())
		const dataOwnerId = await sdk.dataOwner.getCurrentDataOwnerId()
		await body(fixturesFor(sdk, dataOwnerId, t), t)
	})
}

function fixturesFor(sdk: CardinalSdk, dataOwnerId: string, t: TestContext): CardinalTestFixtures {
	const fixtures: CardinalTestFixtures = {
		sdk: sdk,
		dataOwnerId: dataOwnerId,
		async createPatient(options = {}) {
			const withSdk = options.sdk ?? sdk
			const created = await withSdk.patient.createPatient(
				await withSdk.patient.withEncryptionMetadata(newPatient(options.note)),
			)
			fixtures.deletePatientAtTheEndOfTheTest(withSdk, created.id)
			return created
		},
		async createHealthElement(patient, descr = DEFAULT_HEALTH_ELEMENT_DESCR, healthElementSdk) {
			const withSdk = healthElementSdk ?? sdk
			const created = await withSdk.healthElement.createHealthElement(
				await withSdk.healthElement.withEncryptionMetadata(
					new DecryptedHealthElement({id: newUuid(), descr: descr}),
					patient,
				),
			)
			fixtures.deleteHealthElementAtTheEndOfTheTest(withSdk, created.id)
			return created
		},
		deletePatientAtTheEndOfTheTest(cleanupSdk, patientId) {
			t.after(() => deletePatientQuietly(cleanupSdk, patientId))
		},
		deleteHealthElementAtTheEndOfTheTest(cleanupSdk, healthElementId) {
			t.after(() => deleteHealthElementQuietly(cleanupSdk, healthElementId))
		},
	}
	return fixtures
}

/**
 * Asserts that at least one of the secure delegations of the metadata is for `delegateId`.
 */
export function assertDelegate(
	delegateId: string,
	securityMetadata: SecurityMetadata | undefined,
): void {
	assert.ok(securityMetadata !== undefined, 'The entity has no security metadata')
	const delegates = Object.values(securityMetadata.secureDelegations).map((it) => it.delegate)
	assert.ok(
		delegates.includes(delegateId),
		`No secure delegation for ${delegateId}, the delegates of the entity are ${delegates}`,
	)
}

/**
 * Consumes a whole paginated list, as returned by the `filter*By` methods.
 */
export async function drain<T>(iterator: PaginatedListIterator<T>, pageSize = 10): Promise<Array<T>> {
	const found: Array<T> = []
	while (await iterator.hasNext()) {
		found.push(...(await iterator.next(pageSize)))
	}
	return found
}

export function idsOf(entities: Array<{id: string}>): Set<string> {
	return new Set(entities.map((it) => it.id))
}

export async function deletePatientQuietly(sdk: CardinalSdk, patientId: string): Promise<void> {
	try {
		const patient = await sdk.patient.encrypted.getPatient(patientId)
		if (patient !== undefined && patient.deletionDate === undefined && patient.rev !== undefined) {
			await sdk.patient.deletePatientById(patient.id, patient.rev)
		}
	} catch (e) {
		// A failed cleanup must not fail the test.
		console.warn(`Could not delete the test patient ${patientId}: ${e}`)
	}
}

export async function deleteHealthElementQuietly(
	sdk: CardinalSdk,
	healthElementId: string,
): Promise<void> {
	try {
		const healthElement = await sdk.healthElement.encrypted.getHealthElement(healthElementId)
		if (
			healthElement !== undefined
			&& healthElement.deletionDate === undefined
			&& healthElement.rev !== undefined
		) {
			await sdk.healthElement.deleteHealthElementById(healthElement.id, healthElement.rev)
		}
	} catch (e) {
		// A failed cleanup must not fail the test.
		console.warn(`Could not delete the test health element ${healthElementId}: ${e}`)
	}
}
