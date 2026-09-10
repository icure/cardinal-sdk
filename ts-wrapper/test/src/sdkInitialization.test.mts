import assert from 'node:assert/strict'
import {describe} from 'node:test'
import {DataOwnerType} from '@icure/cardinal-sdk'

import {cardinalTest} from './cardinalTestCase.mjs'
import {primaryUser} from './cardinalTestEnv.mjs'

describe('Sdk initialization', () => {

	cardinalTest('logged in as the configured user', async ({sdk}) => {
		const user = await sdk.user.getCurrentUser()
		assert.equal(primaryUser().username, user.id)
	})

	cardinalTest('the current user is a data owner', async ({sdk, dataOwnerId}) => {
		const user = await sdk.user.getCurrentUser()
		const dataOwner = await sdk.dataOwner.getCurrentDataOwner()
		assert.equal(dataOwnerId, await sdk.dataOwner.getCurrentDataOwnerId())
		// `$ktClass` is the discriminator of the sealed interface, see `ts-wrapper/README.md`. It is
		// preferred over `instanceof` because it holds also for objects not created with `new`.
		if (dataOwner.$ktClass === 'com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner') {
			assert.equal(user.healthcarePartyId, dataOwner.dataOwner.id)
		} else if (dataOwner.$ktClass === 'com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner') {
			assert.equal(user.patientId, dataOwner.dataOwner.id)
		} else {
			assert.equal(user.deviceId, dataOwner.dataOwner.id)
		}
		assert.equal(dataOwnerId, dataOwner.dataOwner.id)
	})

	// The SDK either loaded a key from the storage or created a new one during initialization.
	cardinalTest('the data owner has an available key', async ({sdk, dataOwnerId}) => {
		const stub = await sdk.dataOwner.getCurrentDataOwnerStub()
		assert.ok(Object.values(DataOwnerType).includes(stub.type))
		assert.ok(stub.stub.publicKeysForOaepWithSha256.length >= 1)
		const ownKeys = await sdk.crypto.currentDataOwnerKeys()
		assert.ok(Object.keys(ownKeys[dataOwnerId] ?? {}).length >= 1)
	})
})
