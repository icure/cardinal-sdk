package com.icure.cardinal.sdk.utils

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class LongPollingTest : StringSpec({
	"Long polling timeouts split should return a list that adds up to the full timeout with each element not exceeding the max request time".config(enabled = DEFAULT_ENABLED) {
		(1 .. 1000).forEach { totalDuration ->
			listOf(2, 3, 5, 10, 30).forEach { maxRequestDuration ->
				val split = LongPollingUtils.splitForRequestsDuration(
					totalWait = totalDuration,
					maxRequestLength = maxRequestDuration
				)
				split.sum() shouldBe totalDuration
				split.forEach { it shouldBeLessThanOrEqual maxRequestDuration }
				split.size shouldBeLessThanOrEqual (totalDuration / maxRequestDuration + 1)
			}
		}
	}

	"Do long poll request should get in input the timeouts, in order".config(enabled = DEFAULT_ENABLED) {
		var curr = 0
		val timeouts = listOf(30, 20, 10)
		LongPollingUtils.doLongPoll(
			timeouts,
			{
				it shouldBe timeouts[curr++]
				Unit
			},
			{ true }
		)
		curr shouldBe 3
	}

	"Do long poll should return latest result if all requests fail".config(enabled = DEFAULT_ENABLED) {
		var curr = 0
		val timeouts = listOf(30, 20, 10)
		LongPollingUtils.doLongPoll(
			timeouts,
			{
				it shouldBe timeouts[curr++]
				curr
			},
			{ true }
		) shouldBe 3
		curr shouldBe 3
	}

	"Do long poll should stop at the first success".config(enabled = DEFAULT_ENABLED) {
		var curr = 0
		val timeouts = listOf(30, 20, 10)
		LongPollingUtils.doLongPoll(
			timeouts,
			{
				it shouldBe timeouts[curr++]
				curr
			},
			{ it % 2 != 0 }
		) shouldBe 2
		curr shouldBe 2
	}
})