package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class EntityListDecodingStrategyDefaultsTest : StringSpec({
	"All sdk options and the raw api config use the strict entity list decoding strategy by default" {
		SdkOptions().entityListDecodingStrategy shouldBe EntityListDecodingStrategy.Strict
		BasicSdkOptions().entityListDecodingStrategy shouldBe EntityListDecodingStrategy.Strict
		UnboundBasicSdkOptions().entityListDecodingStrategy shouldBe EntityListDecodingStrategy.Strict
		AnonymousSdkOptions().entityListDecodingStrategy shouldBe EntityListDecodingStrategy.Strict
		DefaultRawApiConfig.entityListDecodingStrategy shouldBe EntityListDecodingStrategy.Strict
	}

	"The discard strategy exposes the provided handler" {
		val handler = MalformedEntityHandler { }
		EntityListDecodingStrategy.DiscardMalformed(handler).handler shouldBe handler
	}
})
