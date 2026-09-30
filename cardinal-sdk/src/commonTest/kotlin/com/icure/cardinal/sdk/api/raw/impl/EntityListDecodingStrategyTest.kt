package com.icure.cardinal.sdk.api.raw.impl

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.options.EntityListDecodingStrategy
import com.icure.cardinal.sdk.options.MalformedEntity
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.JsonConvertException
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray

private const val TEST_URL = "http://test.local"

@OptIn(InternalIcureApi::class)
private class TestRawApi(config: RawApiConfig) : BaseRawApi(config) {
	suspend fun patients(path: String): HttpResponse<List<EncryptedPatient>> = get { url("$TEST_URL$path") }.wrapList()

	suspend fun patientsPage(path: String): HttpResponse<PaginatedList<EncryptedPatient>> =
		get { url("$TEST_URL$path") }.wrapPaginatedList()
}

@OptIn(InternalIcureApi::class)
private fun testRawApi(
	strategy: EntityListDecodingStrategy,
	json: Json = Serialization.json,
	responses: Map<String, Pair<HttpStatusCode, String>>,
) = TestRawApi(
	RawApiConfig(
		httpClient = HttpClient(
			MockEngine { request ->
				val (status, body) = responses.getValue(request.url.encodedPath)
				respond(
					content = body,
					status = status,
					headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString()),
				)
			},
		) {
			install(ContentNegotiation) { json(json = json) }
		},
		additionalHeaders = emptyMap(),
		requestTimeout = null,
		json = json,
		retryConfiguration = RequestRetryConfiguration(),
		entityListDecodingStrategy = strategy,
	),
)

// The second patient has the same defect as the one seen in production: a null value in a Map<String, String>.
// language=JSON
private const val PATIENTS_WITH_ONE_MALFORMED = """
[
	{"id": "p1", "firstName": "Valid 1"},
	{"id": "p2", "insurabilities": [{"parameters": {"medicalHouse.periodStart": null}}]},
	{"id": "p3", "firstName": "Valid 2"}
]
"""

// language=JSON
private const val PAGE_WITH_ONE_MALFORMED = """
{
	"rows": $PATIENTS_WITH_ONE_MALFORMED,
	"nextKeyPair": {"startKey": "k", "startKeyDocId": "p4"}
}
"""

private val ok = HttpStatusCode.OK

private fun collecting(into: MutableList<MalformedEntity>) =
	EntityListDecodingStrategy.DiscardMalformed { into.add(it) }

@OptIn(InternalIcureApi::class)
class EntityListDecodingStrategyTest : StringSpec({
	"The strict strategy fails the whole list or page when one element is malformed" {
		val api = testRawApi(
			EntityListDecodingStrategy.Strict,
			responses = mapOf("/list" to (ok to PATIENTS_WITH_ONE_MALFORMED), "/page" to (ok to PAGE_WITH_ONE_MALFORMED)),
		)
		shouldThrow<JsonConvertException> { api.patients("/list").successBody() }
		shouldThrow<JsonConvertException> { api.patientsPage("/page").successBody() }
	}

	"The discard strategy drops only the malformed element, keeps the order and reports it" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(collecting(discarded), responses = mapOf("/list" to (ok to PATIENTS_WITH_ONE_MALFORMED)))
		api.patients("/list").successBody().map { it.id } shouldBe listOf("p1", "p3")
		discarded.shouldHaveSize(1).single().also {
			it.entityId shouldBe "p2"
			it.entityType shouldBe EncryptedPatient.serializer().descriptor.serialName
			it.requestUrl shouldBe "$TEST_URL/list"
			it.error.shouldBeInstanceOf<SerializationException>()
			it.json shouldBe Json.parseToJsonElement(PATIENTS_WITH_ONE_MALFORMED).jsonArray[1]
		}
	}

	"The discard strategy drops the malformed rows of a page and keeps the page metadata" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(collecting(discarded), responses = mapOf("/page" to (ok to PAGE_WITH_ONE_MALFORMED)))
		val page = api.patientsPage("/page").successBody()
		page.rows.map { it.id } shouldBe listOf("p1", "p3")
		page.nextKeyPair shouldBe PaginatedDocumentKeyIdPair(startKey = JsonPrimitive("k"), startKeyDocId = "p4")
		discarded.map { it.entityId } shouldBe listOf("p2")
	}

	"The discard strategy still fails on a body that is not valid json" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(collecting(discarded), responses = mapOf("/list" to (ok to """[{"id": "p1"""")))
		shouldThrow<SerializationException> { api.patients("/list").successBody() }
		discarded.shouldBeEmpty()
	}

	"An exception thrown by the handler fails the request" {
		val api = testRawApi(
			EntityListDecodingStrategy.DiscardMalformed { throw IllegalStateException("Malformed entity ${it.entityId}") },
			responses = mapOf("/list" to (ok to PATIENTS_WITH_ONE_MALFORMED)),
		)
		shouldThrow<IllegalStateException> { api.patients("/list").successBody() }.message shouldBe "Malformed entity p2"
	}

	"Elements that are not objects, or whose id is not a string, are discarded and reported without id" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(
			collecting(discarded),
			responses = mapOf("/list" to (ok to """[{"id": "p1"}, null, "p3", {"id": 4}]""")),
		)
		api.patients("/list").successBody().map { it.id } shouldBe listOf("p1")
		discarded.shouldHaveSize(3).forEach { it.entityId.shouldBeNull() }
	}

	"A non-success response fails as before when the discard strategy is configured" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(
			collecting(discarded),
			responses = mapOf("/list" to (HttpStatusCode.NotFound to """{"message": "not found"}""")),
		)
		shouldThrow<RequestStatusException> { api.patients("/list").successBody() }
		discarded.shouldBeEmpty()
	}

	"Unknown fields make an element malformed only if unknown fields are not ignored" {
		// language=JSON
		val withUnknownField = """[{"id": "p1", "notInTheModel": 1}, {"id": "p2"}]"""
		val strictJsonDiscarded = mutableListOf<MalformedEntity>()
		testRawApi(collecting(strictJsonDiscarded), responses = mapOf("/list" to (ok to withUnknownField)))
			.patients("/list").successBody().map { it.id } shouldBe listOf("p2")
		strictJsonDiscarded.map { it.entityId } shouldBe listOf("p1")

		val lenientJsonDiscarded = mutableListOf<MalformedEntity>()
		testRawApi(collecting(lenientJsonDiscarded), json = Serialization.lenientJson, responses = mapOf("/list" to (ok to withUnknownField)))
			.patients("/list").successBody().map { it.id } shouldBe listOf("p1", "p2")
		lenientJsonDiscarded.shouldBeEmpty()
	}

	"Empty lists, pages without rows and lists where every element is malformed give empty results" {
		val discarded = mutableListOf<MalformedEntity>()
		val api = testRawApi(
			collecting(discarded),
			responses = mapOf(
				"/empty" to (ok to "[]"),
				"/page-without-rows" to (ok to """{"nextKeyPair": {"startKeyDocId": "p9"}}"""),
				"/all-malformed" to (ok to """[null, {"id": "p1", "parameters": {"x": [null]}}]"""),
			),
		)
		api.patients("/empty").successBody().shouldBeEmpty()
		discarded.shouldBeEmpty()
		api.patientsPage("/page-without-rows").successBody().also {
			it.rows.shouldBeEmpty()
			it.nextKeyPair shouldBe PaginatedDocumentKeyIdPair(startKeyDocId = "p9")
		}
		discarded.shouldBeEmpty()
		api.patients("/all-malformed").successBody().shouldBeEmpty()
		discarded.map { it.entityId } shouldBe listOf(null, "p1")
	}
})
