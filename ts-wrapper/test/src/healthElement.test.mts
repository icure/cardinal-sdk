import assert from 'node:assert/strict'
import {describe} from 'node:test'
import {DecryptedHealthElement, HealthElementFilters} from '@icure/cardinal-sdk'

import {cardinalTest, drain, idsOf} from './cardinalTestCase.mjs'
import {newUuid} from './cardinalTestEnv.mjs'

describe('Health element', () => {

	cardinalTest('create a health element for a patient', async ({sdk, createPatient, createHealthElement}) => {
		const patient = await createPatient()
		const created = await createHealthElement(patient, 'Some diagnosis')
		assert.notEqual(created.rev, undefined)
		assert.equal('Some diagnosis', created.descr)
		assert.equal(1, created.secretForeignKeys.length)

		const secretIds = Object.keys(await sdk.patient.getSecretIdsOf(patient))
		for (const secretForeignKey of created.secretForeignKeys) {
			assert.ok(
				secretIds.includes(secretForeignKey),
				`${secretForeignKey} is not one of the secret ids of the patient (${secretIds})`,
			)
		}
	})

	cardinalTest('the encrypted fields are not stored in clear', async ({sdk, createPatient, createHealthElement}) => {
		const created = await createHealthElement(await createPatient(), 'Sensitive diagnosis')
		const asEncrypted = await sdk.healthElement.encrypted.getHealthElement(created.id)
		assert.ok(asEncrypted !== undefined)
		assert.equal(
			asEncrypted.descr,
			undefined,
			'`descr` is an encrypted field, it must not be stored in clear',
		)
		assert.notEqual(asEncrypted.encryptedSelf, undefined)

		const decrypted = await sdk.healthElement.decrypt([asEncrypted])
		assert.equal('Sensitive diagnosis', decrypted[0]!.descr)
	})

	cardinalTest('modify a health element', async ({sdk, createPatient, createHealthElement}) => {
		const created = await createHealthElement(await createPatient())
		created.descr = 'Updated diagnosis'
		const modified = await sdk.healthElement.modifyHealthElement(created)
		assert.notEqual(created.rev, modified.rev)
		assert.equal('Updated diagnosis', modified.descr)
		assert.equal(
			'Updated diagnosis',
			(await sdk.healthElement.getHealthElement(created.id))?.descr,
		)
	})

	cardinalTest('filter health elements by patient', async ({sdk, createPatient, createHealthElement}) => {
		const patient = await createPatient()
		const created = [
			await createHealthElement(patient, 'Diagnosis 0'),
			await createHealthElement(patient, 'Diagnosis 1'),
			await createHealthElement(patient, 'Diagnosis 2'),
		]

		const found = await drain(
			await sdk.healthElement.filterHealthElementsBy(
				HealthElementFilters.byPatientsForSelf([patient]),
			),
		)

		assert.deepEqual(idsOf(created), idsOf(found))
		for (const healthElement of found) {
			assert.notEqual(healthElement.descr, undefined)
		}
	})

	cardinalTest('filter health elements by the secret ids of a patient', async ({sdk, createPatient, createHealthElement}) => {
		const patient = await createPatient()
		const created = await createHealthElement(patient)
		const secretIds = Object.keys(await sdk.patient.getSecretIdsOf(patient))

		const matched = await sdk.healthElement.matchHealthElementsBy(
			HealthElementFilters.byPatientsSecretIdsForSelf(secretIds),
		)
		assert.deepEqual([created.id], matched)
	})

	cardinalTest('create a health element without the helpers', async (fixtures) => {
		const {sdk, createPatient} = fixtures
		const patient = await createPatient()
		const withMetadata = await sdk.healthElement.withEncryptionMetadata(
			new DecryptedHealthElement({id: newUuid(), descr: 'Explicit diagnosis'}),
			patient,
		)
		const created = await sdk.healthElement.createHealthElement(withMetadata)
		fixtures.deleteHealthElementAtTheEndOfTheTest(sdk, created.id)
		const retrieved = await sdk.healthElement.getHealthElement(created.id)
		assert.equal(created.id, retrieved?.id)
		assert.equal('Explicit diagnosis', retrieved?.descr)
	})
})
