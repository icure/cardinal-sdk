package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import kotlin.random.Random

class IdsPageIteratorTest : StringSpec({
	data class Datum(
		val id: String = defaultCryptoService.strongRandom.randomUUID(),
		val someValue: Int
	)

	val elements = List(500) { Datum(someValue = it) }.associateBy { it.id }

	suspend fun <T: Any> IdsPageIterator<T>.shouldHaveNoMoreElements() {
		hasNext() shouldBe false
		next(1).shouldBeEmpty()
	}

	fun createIterator() = IdsPageIterator(
		ids = elements.keys.toList() + List(500) { defaultCryptoService.strongRandom.randomUUID() },
	) { ids ->
		elements.filterKeys { ids.contains(it) }.values.toList()
	}


	"A IdsPageIterator can iterate over multiple pages".config(enabled = DEFAULT_ENABLED) {
		val iterator = createIterator()
		val results = mutableListOf<Datum>()

		iterator.forEach {
			results.add(it)
		}

		results shouldContainExactlyInAnyOrder elements.values
		iterator.shouldHaveNoMoreElements()
	}

	"A IdsPageIterator hasNext is idempotent".config(enabled = DEFAULT_ENABLED) {
		val iterator = createIterator()
		val results = mutableListOf<Datum>()

		while(iterator.hasNext()) {
			(1 .. 10).forEach { _ -> iterator.hasNext() }
			results.addAll(iterator.next(100))
		}

		results shouldContainExactlyInAnyOrder elements.values
		iterator.shouldHaveNoMoreElements()
	}

	"IdsPageIterator - Any exception thrown in the request is not caught by the iterator".config(enabled = DEFAULT_ENABLED) {
		class CustomException : Exception()

		val iterator = IdsPageIterator(
			ids = elements.keys.toList() + List(500) { defaultCryptoService.strongRandom.randomUUID() },
		) { ids ->
			if(ids.contains(elements.keys.toList()[300])) throw CustomException()
			elements.filterKeys { ids.contains(it) }.values.toList()
		}
		shouldThrow<CustomException> {
			while(iterator.hasNext()) {
				iterator.next(100)
			}
		}
	}

	"IdsPageIterator - If the request returns an empty page, hasNext is false".config(enabled = DEFAULT_ENABLED) {
		val iterator = IdsPageIterator(
			ids = elements.keys.toList(),
		) { emptyList() }
		iterator.shouldHaveNoMoreElements()
	}

	"IdsPageIterator - Will skip empty pages".config(enabled = DEFAULT_ENABLED) {
		val splitIndex = Random.nextInt(1, elements.size)
		val iterator = IdsPageIterator(
			ids = elements.keys.toList().subList(0, splitIndex) + List(500) { defaultCryptoService.strongRandom.randomUUID() } + elements.keys.toList().subList(splitIndex, elements.size),
		) { ids -> elements.filterKeys { ids.contains(it) }.values.toList() }
		val results = mutableListOf<Datum>()
		while(iterator.hasNext()) {
			results.addAll(iterator.next(100))
		}

		results shouldContainExactlyInAnyOrder elements.values
		iterator.shouldHaveNoMoreElements()
	}
})
