package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.UnionFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.cardinal.sdk.model.notification.Subscription
import com.icure.cardinal.sdk.model.notification.SubscriptionEventType
import com.icure.cardinal.sdk.serialization.FilterChainSerializer
import com.icure.cardinal.sdk.serialization.PatientAbstractFilterSerializer
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.serialization.UnionFilterSerializer
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.Serialization
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

class AbstractFilterSerializationTest: StringSpec({

	"Should be able to serialize Filters and Subscriptions".config(enabled = DEFAULT_ENABLED) {
		val filterSpecific: AbstractFilter<Patient> = PatientByIdsFilter(setOf("whatever"))
		val filterJson = JsonObject(
            mapOf(
                "\$type" to JsonPrimitive("PatientByIdsFilter"),
                "ids" to JsonArray(listOf(JsonPrimitive("whatever")))
            )
        )
		val unionFilterSpecific: UnionFilter<Patient> = UnionFilter(filters = listOf(filterSpecific))
		val unionFilterJson = JsonObject(
            mapOf(
                "\$type" to JsonPrimitive("UnionFilter"),
                "filters" to JsonArray(listOf(filterJson)),
	            "desc" to JsonNull
            )
        )
		val unionFilterNoTypeJson = JsonObject(
            mapOf(
                "filters" to JsonArray(listOf(filterJson)),
	            "desc" to JsonNull
            )
        )
		val filterChainUnionSpecific = FilterChain(unionFilterSpecific)
		val filterChainUnionJson = JsonObject(
            mapOf(
                "filter" to unionFilterJson,
				"predicate" to JsonNull
            )
        )
		val filterChainByIdsJson = JsonObject(
            mapOf(
                "filter" to filterJson,
	            "predicate" to JsonNull
            )
        )

		val subscription = Subscription(
			eventTypes = listOf(SubscriptionEventType.Create),
			entityClass = "Patient",
			filter = FilterChain(filterSpecific),
			accessControlKeys = emptyList()
		)
		val subscriptionJson = JsonObject(
			mapOf(
				"eventTypes" to JsonArray(listOf(JsonPrimitive("CREATE"))),
				"entityClass" to JsonPrimitive("Patient"),
				"filter" to filterChainByIdsJson,
				"accessControlKeys" to JsonArray(listOf()),
			)
		)

		Serialization.json.encodeToJsonElement(FilterChainSerializer(PatientAbstractFilterSerializer), filterChainUnionSpecific) shouldBe filterChainUnionJson
		Serialization.json.encodeToJsonElement(FilterChainSerializer(PatientAbstractFilterSerializer), FilterChain(filterSpecific)) shouldBe filterChainByIdsJson
		Serialization.json.encodeToJsonElement(UnionFilterSerializer(PatientAbstractFilterSerializer), unionFilterSpecific) shouldBe unionFilterNoTypeJson
		// Currently there is a bug with `encodeToJsonElement` https://github.com/Kotlin/kotlinx.serialization/issues/2535
		Serialization.json.encodeToString(PatientAbstractFilterSerializer, filterSpecific) shouldBe filterJson.toString()
		Serialization.json.encodeToJsonElement(SubscriptionSerializer(PatientAbstractFilterSerializer), subscription) shouldBe subscriptionJson

	}


})
