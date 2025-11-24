package com.icure.cardinal.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.cardinal.sdk.crypto.entities.ShamirSecretShare
import com.icure.cardinal.sdk.crypto.impl.ShamirSecretSharingService
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.ktor.utils.io.core.toByteArray

class ShamirSecretSharingServiceTest : StringSpec({
	val shamirService = ShamirSecretSharingService(defaultCryptoService.strongRandom)
	infix fun ByteArray.shouldBe(expected: ByteArray) = this.toList() shouldBe expected.toList()

	fun testCombine(shares: List<ShamirSecretShare>, secret: ByteArray, threshold: Int) {
		shamirService.combine(shares) shouldBe secret
		repeat(10) {
			shamirService.combine(shares.shuffled().take(threshold)) shouldBe secret
		}
		if (threshold > 2) {
			repeat(10) {
				try {
					shamirService.combine(shares.shuffled().take(threshold - 1)) shouldNotBe secret
				} catch (e: IllegalArgumentException) {
					// this is a valid possibility but there is no guarantee it is thrown every time
				}
			}
		}
	}

	"Should be able to split and recombine".config(enabled = DEFAULT_ENABLED) {
		listOf(
			2 to 3,
			3 to 5,
			5 to 5,
			2 to 10,
			9 to 16,
			10 to 255,
		).forEach { (threshold, numberOfShares) ->
			listOf(8, 255, 256, 257, 2048).forEach { secretLength ->
				println("Testing $threshold of $numberOfShares with secret length $secretLength")
				val secret = defaultCryptoService.strongRandom.randomBytes(secretLength)
				val shares = shamirService.share(
					secret,
					numberOfShares,
					threshold
				)
				testCombine(shares, secret, threshold)
			}
		}
	}

	"Should be able to combine secrets from the original typescript SDK".config(enabled = DEFAULT_ENABLED) {
		val secret = "This secret was created using the og iCure typescript SDK".toByteArray()
		val shares = listOf(
			ShamirSecretShare("801162ab4b5061600ba382f8dcedf844961226c36e982947d306753655587ae0b069e90f8ba9580552bc18633512f18357141c48053918cdd598a74"),
			ShamirSecretShare("8026116a305779d642a71b3cc2350912378f522fb36075fc19b92626c133a7d71b5197e9bdd8a5b78f7f0e7550c3a55e1c32668b242aafaad6c402a"),
			ShamirSecretShare("80376687fd902ab17f52aee2499af620b6af72dbfbae4bfd9cfd5447a2fd3b45ac7ef8b430878fb449f4413037d6134a4d714cf40784b0250668e15"),
			ShamirSecretShare("804e41246b2e424be6ced1ca722b6d2add9f480798663dd5ac6a92a8195903d9e7fb0c41302f04ef2bb85d84f672fbe23361d080b5ecde4928162f5"),
			ShamirSecretShare("805f36c9a6e9112cdb3b6414f98492185cbf68f3d0a803d4292ee0c97a979f4b50d4631cbd702eeced3312c191674df66222faff9642c1c6f8bacca")
		)
		testCombine(shares, secret, 3)
	}
})