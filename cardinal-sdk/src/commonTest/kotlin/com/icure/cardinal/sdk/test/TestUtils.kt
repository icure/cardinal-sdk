package com.icure.cardinal.sdk.test

import io.kotest.core.spec.style.StringSpec
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.http.Headers
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job

// A job that is automatically canceled when the string spec terminates
fun StringSpec.autoCancelJob() = Job().also { j -> afterSpec { j.cancel(CancellationException("Tests completed")) } }

private fun HttpClient.installHeaderDebugLogging() {
	plugin(HttpSend).intercept { request ->
		// This is the final builder right before sending
		val url = request.url.buildString()
		val method = request.method
		val headers: Headers = request.headers.build()

		println(">>> $method $url")
		headers.forEach { key, values ->
			println(">>> $key: ${values.joinToString()}")
		}

		execute(request)
	}
}
