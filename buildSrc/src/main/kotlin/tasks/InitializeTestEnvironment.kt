package tasks

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.expectSuccess
import io.ktor.client.request.basicAuth
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.UUID

abstract class InitializeTestEnvironment : DefaultTask() {

	private val composeFileName = "docker-compose-cloud.yaml"
	private val httpClient = HttpClient(CIO) {
		install(ContentNegotiation) {
			json()
		}
	}
	private val defaultRoles = mapOf(
		"PATIENT" to listOf("BASIC_USER", "BASIC_DATA_OWNER"),
		"HCP" to listOf("BASIC_USER", "BASIC_DATA_OWNER", "PATIENT_USER_MANAGER", "LEGACY_MESSAGE_MANAGER", "HIERARCHICAL_DATA_OWNER"),
		"DEVICE" to listOf("BASIC_USER", "BASIC_DATA_OWNER"),
		"USER" to listOf("BASIC_USER")
	)

	@TaskAction
	fun initialize() = runBlocking {
		println("Starting kraken")
		val baseDir = Regex(".*icure-multiplatform-sdk").find(project.projectDir.absolutePath)?.value
			?: throw IllegalStateException("Cannot find base compose dir")
		val composeFile = File("$baseDir/buildSrc/src/main/resources/scratch/$composeFileName")
		if(!composeFile.exists()) throw IllegalStateException("Cannot find compose file")
		startKrakenEnvironment(baseDir, composeFile, listOf("mock"))
	}

	private suspend fun startKrakenEnvironment(baseDir: String, composeFile: File, profiles: List<String> = emptyList()) {
		val couchDBPort = "15984"
		val couchDbUser = "icure"
		val couchDbPassword = "icure"
		val envVars = mapOf(
			"COUCHDB_PORT" to couchDBPort,
			"AS_PORT" to "16044",
			"COUCHDB_USER" to couchDbUser,
			"COUCHDB_PASSWORD" to couchDbPassword,
			"MOCK_ICURE_URL" to "http://kraken-1:16043/rest/v1",
			"ICURE_MOCK_LOGIN" to "john",
			"ICURE_MOCK_PWD" to "LetMeIn", //pragma: allowlist secret
			"ICURE_TEST_GROUP_ID" to "test-group"
		)
		val isDockerRunning = kotlin.runCatching {
			isBaseDbCreated("http://127.0.0.1:${envVars["COUCHDB_PORT"]}", envVars.getValue("COUCHDB_USER"), envVars.getValue("COUCHDB_PASSWORD"))
		}.getOrDefault(false)
		if(isDockerRunning) {
			println("Environment is already running")
			return
		}

		createConfigurationFilesFromCompose(composeFile)
		val command = "docker compose -f ${composeFile.name} ${profiles.joinToString(separator = " ") { "--profile $it" }} up -d"

		val started = execute(command, envVars, composeFile.parentFile.absolutePath)

		if (!started) {
			throw RuntimeException("Could not start Kraken Docker container")
		}
		delay(1000)
		if(!isBaseDbCreated("http://127.0.0.1:${envVars["COUCHDB_PORT"]}", envVars.getValue("COUCHDB_USER"), envVars.getValue("COUCHDB_PASSWORD"))) {
			throw RuntimeException("Could not start create base kraken database")
		}

		bootstrapCloud(
			"xx",
			"xx",
			UUID.randomUUID().toString(),
			"john",
			couchDbUser = "icure",
			couchDbPassword = "icure",
			rootUserRoles = defaultRoles,
			defaultQuotas = listOf(1000, 10, 5)
		)

		loadRolesInConfig(baseDir, couchDBPort, couchDbUser, couchDbPassword)
	}

	/**
	 * Bootstrap the environment for Kraken Cloud. This method will therefore:
	 * - Create a new base database, corresponding to the parent group;
	 * - Create a new user in the previously created base database;
	 * - Create this user in the icure-__-base database (Kraken therefore needs to be launched first !);
	 * - Create a DB user in _users;
	 * - Create the group in icure-__-config;
	 * @param groupId The id of the parent group to create
	 * @param groupPassword Password of the parent group
	 * @param groupUserId
	 * @param groupUserLogin
	 * @param groupUserPasswordHash
	 * @param couchDbUrl Url of the CouchDB where to bootstrap the Cloud environment
	 * @param couchDbUser Username of the admin CouchDB user. Needed to execute the requests to CouchDB
	 * @param couchDbPassword Password of the admin CouchDB user. Needed to execute the requests to CouchDB
	 */
	private suspend fun bootstrapCloud(
		groupId: String = "xx",
		groupPassword: String = "xx",
		groupUserId: String = UUID.randomUUID().toString(),
		groupUserLogin: String = "john", // LetMeIn
		// This is a real value, but only used for test environments on local machines, so it is safe to commit
		groupUserPasswordHash: String = "1796980233375ccd113c972d946b2c4a7892e4f69c60684cfa730150047f9c0b",
		couchDbUrl: String = "http://127.0.0.1:15984",
		couchDbUser: String = "bootstrapCloudicure",
		couchDbPassword: String = "icure",
		rootUserRoles: Map<String, List<String>> = emptyMap(),
		defaultQuotas: List<Int> = listOf(1000, 2, 5)
	) {
		createNewDatabase(httpClient, "icure-$groupId-base", couchDbUrl, couchDbUser, couchDbPassword)
		createNewDatabase(httpClient, "_users", couchDbUrl, couchDbUser, couchDbPassword)

		createUserIn(httpClient, groupId, groupUserId, groupUserLogin, groupUserPasswordHash, null, couchDbUrl, couchDbUser, couchDbPassword)
		createUserInBase(httpClient, groupId, groupUserId, groupUserLogin, groupUserPasswordHash, null, couchDbUrl, couchDbUser, couchDbPassword)
		createNewDbUser(httpClient, groupId, groupPassword, couchDbUrl, couchDbUser, couchDbPassword)
		createNewGroupInConfig(httpClient, groupId, groupPassword, couchDbUrl, couchDbUser, couchDbPassword, defaultRoles = rootUserRoles, quotas = defaultQuotas)
	}

	private tailrec suspend fun isBaseDbCreated(
		couchDbUrl: String = "http://127.0.0.1:15984",
		couchDbUser: String = "icure",
		couchDbPassword: String = "icure",
		retry: Int = 5
	): Boolean {
		if (retry == 0) return false
		val response = httpClient.get("$couchDbUrl/icure-__-base") {
			basicAuth(couchDbUser, couchDbPassword)
		}
		return if (response.status.isSuccess()) true
		else {
			delay(5000)
			isBaseDbCreated(couchDbUrl, couchDbUser, couchDbPassword, retry - 1)
		}
	}

	private suspend fun loadRolesInConfig(baseDir: String, couchDBPort: String, username: String, password: String) {
		val payload = File("$baseDir/buildSrc/src/main/resources/roles.json").readText()
		httpClient.post("http://localhost:$couchDBPort/icure-__-config/_bulk_docs") {
			basicAuth(username, password)
			contentType(ContentType.Application.Json)
			setBody(payload)
			expectSuccess = true
		}
	}
}