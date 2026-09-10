/**
 * Configuration of the test environment.
 *
 * Everything the tests need to log in comes from environment variables (secrets on the CI): the
 * tests run against an already existing environment, with already existing users, and never create
 * groups or users themselves.
 */
import {mkdirSync} from 'node:fs'
import {join} from 'node:path'
import {randomUUID} from 'node:crypto'
import {AuthenticationMethod, CardinalSdk, StorageFacade} from '@icure/cardinal-sdk'

export const ENV_URL = 'CARDINAL_URL'
export const ENV_KEYS_DIR = 'CARDINAL_KEYS_DIR'

const DEFAULT_KEYS_DIR = 'keys'

/**
 * The primary user: it is used by all the tests, so it must always be configured.
 */
export const PRIMARY_USER_PREFIX = 'CARDINAL_USER_1'
/**
 * The secondary user: it is used by the tests that need two distinct data owners (sharing). If it
 * is not configured those tests are skipped.
 */
export const SECONDARY_USER_PREFIX = 'CARDINAL_USER_2'

/**
 * Credentials of a data owner user of the test environment.
 */
export interface UserCredentials {
	readonly username: string
	readonly password?: string
	readonly token?: string
}

export function newUuid(): string {
	return randomUUID()
}

export function cardinalUrl(): string {
	const url = process.env[ENV_URL]
	if (!url) throw new Error(`${ENV_URL} is not set`)
	return url
}

export function authenticationMethodOf(user: UserCredentials): AuthenticationMethod {
	if (user.token !== undefined) {
		return new AuthenticationMethod.UsingCredentials.UsernameLongToken(user.username, user.token)
	}
	if (user.password !== undefined) {
		return new AuthenticationMethod.UsingCredentials.UsernamePassword(user.username, user.password)
	}
	throw new Error(`No password nor long token configured for ${user.username}`)
}

/**
 * Reads the credentials of a user from `<PREFIX>_USERNAME` and `<PREFIX>_PASSWORD` or
 * `<PREFIX>_TOKEN`, returning undefined if no username is configured.
 */
export function credentials(prefix: string): UserCredentials | undefined {
	const username = process.env[`${prefix}_USERNAME`]
	if (!username) return undefined
	const password = process.env[`${prefix}_PASSWORD`] || undefined
	const token = process.env[`${prefix}_TOKEN`] || undefined
	if (password === undefined && token === undefined) {
		throw new Error(`Neither ${prefix}_PASSWORD nor ${prefix}_TOKEN is set`)
	}
	return {username, password, token}
}

/**
 * Directory where the SDK stores the keys of a user. Each user gets its own subdirectory, so that
 * the storage of the users used by the tests never mixes up. The layout is the same one used by the
 * python tests, so that the two suites can share the same seeded keys.
 */
export function keysDirectory(username: string): string {
	const baseDir = process.env[ENV_KEYS_DIR] || DEFAULT_KEYS_DIR
	const directory = join(baseDir, username.replace(/[^A-Za-z0-9_.-]/g, '_'))
	mkdirSync(directory, {recursive: true})
	return directory
}

async function createSdk(user: UserCredentials): Promise<CardinalSdk> {
	try {
		return await CardinalSdk.initialize(
			undefined,
			cardinalUrl(),
			authenticationMethodOf(user),
			StorageFacade.usingFileSystem(keysDirectory(user.username)),
		)
	} catch (e) {
		throw new Error(
			`Could not initialize the SDK for ${user.username} on ${cardinalUrl()}: ${e}`,
			{cause: e},
		)
	}
}

const sdkCache = new Map<string, Promise<CardinalSdk>>()

/**
 * Returns the SDK of a user, initializing it on the first call only.
 */
export function sdkFor(user: UserCredentials): Promise<CardinalSdk> {
	let sdk = sdkCache.get(user.username)
	if (sdk === undefined) {
		sdk = createSdk(user)
		sdkCache.set(user.username, sdk)
	}
	return sdk
}

/**
 * Closes every SDK created during the run. Unlike the python SDK the typescript one holds an open
 * http client, so without this the node process would never exit.
 */
export async function closeAllSdks(): Promise<void> {
	const pending = [...sdkCache.values()]
	sdkCache.clear()
	for (const sdk of pending) {
		try {
			(await sdk).close()
		} catch (e) {
			// A failed close must not fail the run.
			console.warn(`Could not close an sdk: ${e}`)
		}
	}
}

export function primaryUser(): UserCredentials {
	const user = credentials(PRIMARY_USER_PREFIX)
	if (user === undefined) throw new Error(`${PRIMARY_USER_PREFIX}_USERNAME is not set`)
	return user
}

export function secondaryUser(): UserCredentials | undefined {
	return credentials(SECONDARY_USER_PREFIX)
}

/**
 * Fails with an explicit message if the mandatory configuration is missing.
 */
export function checkConfiguration(): void {
	cardinalUrl()
	primaryUser()
}
