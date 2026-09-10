import assert from 'node:assert/strict'
import {describe} from 'node:test'
import {PatientFilters} from '@icure/cardinal-sdk'

import {
	assertDelegate,
	cardinalTest,
	drain,
	idsOf,
	newPatient,
} from './cardinalTestCase.mjs'
import {newUuid} from './cardinalTestEnv.mjs'

describe('Patient', () => {

	cardinalTest('create and get a patient', async ({sdk, dataOwnerId, createPatient}) => {
		const created = await createPatient()
		assert.notEqual(created.rev, undefined)
		assert.equal('Doe', created.lastName)
		assert.equal('This note is encrypted', created.note)
		assertDelegate(dataOwnerId, created.securityMetadata)

		const retrieved = await sdk.patient.getPatient(created.id)
		assert.ok(retrieved !== undefined)
		assert.equal(created.rev, retrieved.rev)
		assert.equal(created.note, retrieved.note)
	})

	cardinalTest('the encrypted fields are not stored in clear', async ({sdk, createPatient}) => {
		const created = await createPatient({note: 'Very sensitive note'})
		const asEncrypted = await sdk.patient.encrypted.getPatient(created.id)
		assert.ok(asEncrypted !== undefined)
		assert.equal(
			asEncrypted.note,
			undefined,
			'`note` is an encrypted field, it must not be stored in clear',
		)
		assert.notEqual(asEncrypted.encryptedSelf, undefined)
		assert.equal('Doe', asEncrypted.lastName, '`lastName` is not an encrypted field')

		const decrypted = await sdk.patient.decrypt([asEncrypted])
		assert.equal(1, decrypted.length)
		assert.equal('Very sensitive note', decrypted[0]!.note)
	})

	cardinalTest('modify a patient', async ({sdk, createPatient}) => {
		const created = await createPatient()
		created.note = 'Updated note'
		created.lastName = 'Smith'
		const modified = await sdk.patient.modifyPatient(created)
		assert.notEqual(created.rev, modified.rev)
		assert.equal('Updated note', modified.note)
		assert.equal('Smith', modified.lastName)

		const retrieved = await sdk.patient.getPatient(created.id)
		assert.equal('Updated note', retrieved?.note)
	})

	cardinalTest('getting an unknown patient returns undefined', async ({sdk}) => {
		assert.equal(await sdk.patient.getPatient(newUuid()), undefined)
	})

	cardinalTest('filter patients by ids', async ({sdk, createPatient}) => {
		const created = [await createPatient(), await createPatient(), await createPatient()]
		const createdIds = idsOf(created)

		const found = await drain(
			await sdk.patient.filterPatientsBy(PatientFilters.byIds([...createdIds])),
		)

		assert.deepEqual(createdIds, idsOf(found))
		for (const patient of found) {
			assert.equal('This note is encrypted', patient.note)
		}
	})

	cardinalTest('match patients by filter', async ({sdk, createPatient}) => {
		const created = await createPatient()
		assert.deepEqual(
			[created.id],
			await sdk.patient.matchPatientsBy(PatientFilters.byIds([created.id])),
		)
	})

	cardinalTest('delete a patient', async ({sdk, createPatient}) => {
		const created = await createPatient()
		const deleted = await sdk.patient.deletePatientById(created.id, created.rev!)
		assert.equal(created.id, deleted.id)
		// The deletion is a soft delete, so the entity may still be retrievable, but only as deleted.
		const retrieved = await sdk.patient.getPatient(created.id)
		if (retrieved !== undefined) {
			assert.notEqual(retrieved.deletionDate, undefined)
		}
	})

	cardinalTest('create a patient without the helpers', async (fixtures) => {
		const {sdk} = fixtures
		const withMetadata = await sdk.patient.withEncryptionMetadata(newPatient('Explicit note'))
		const created = await sdk.patient.createPatient(withMetadata)
		fixtures.deletePatientAtTheEndOfTheTest(sdk, created.id)
		const retrieved = await sdk.patient.getPatient(created.id)
		assert.ok(retrieved !== undefined)
		assert.equal('Explicit note', retrieved.note)
	})
})
