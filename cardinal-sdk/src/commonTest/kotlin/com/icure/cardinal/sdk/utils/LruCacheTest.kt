package com.icure.cardinal.sdk.utils

import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class LruCacheTest : StringSpec({

	"get on empty cache returns null".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.get("a").shouldBeNull()
	}

	"set then get returns the value".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.get("a") shouldBe 1
	}

	"set on existing key updates the value".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("a", 2)
		cache.get("a") shouldBe 2
		cache.size shouldBe 1
	}

	"size reflects number of entries".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.size shouldBe 0
		cache.set("a", 1)
		cache.size shouldBe 1
		cache.set("b", 2)
		cache.size shouldBe 2
		cache.set("a", 99)
		cache.size shouldBe 2
	}

	"evictOldest on empty cache returns null".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.evictOldest().shouldBeNull()
	}

	"evictOldest removes and returns the least recently used entry".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.evictOldest() shouldBe 1
		cache.size shouldBe 2
		cache.get("a").shouldBeNull()
		cache.get("b") shouldBe 2
		cache.get("c") shouldBe 3
	}

	"get promotes entry to most recently used".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.get("a") // promote "a", making "b" the LRU
		cache.evictOldest() shouldBe 2 // "b" is now oldest
	}

	"set on existing key promotes entry to most recently used".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.set("a", 10) // promote "a", making "b" the LRU
		cache.evictOldest() shouldBe 2 // "b" is now oldest
		cache.get("a") shouldBe 10
	}

	"inserting beyond maxCacheSize evicts the LRU entry".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(3)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.set("d", 4) // should evict "a"
		cache.size shouldBe 3
		cache.get("a").shouldBeNull()
		cache.get("b") shouldBe 2
		cache.get("c") shouldBe 3
		cache.get("d") shouldBe 4
	}

	"LRU eviction order respects access history".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(3)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.get("a") // access "a", making "b" the LRU
		cache.set("d", 4) // should evict "b"
		cache.get("a") shouldBe 1
		cache.get("b").shouldBeNull()
		cache.get("c") shouldBe 3
		cache.get("d") shouldBe 4
	}

	"updating value of LRU entry prevents its eviction".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(3)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.set("a", 10) // update LRU entry, promoting it; "b" becomes LRU
		cache.set("d", 4)  // should evict "b"
		cache.get("a") shouldBe 10
		cache.get("b").shouldBeNull()
		cache.get("c") shouldBe 3
		cache.get("d") shouldBe 4
	}

	"remove deletes the entry".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.remove("a")
		cache.get("a").shouldBeNull()
		cache.size shouldBe 1
		cache.get("b") shouldBe 2
	}

	"remove on non-existent key is a no-op".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.remove("z")
		cache.size shouldBe 1
		cache.get("a") shouldBe 1
	}

	"remove first node".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.remove("a") // LRU node
		cache.size shouldBe 2
		cache.evictOldest() shouldBe 2 // "b" is now oldest
	}

	"remove last node".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.remove("c") // MRU node
		cache.size shouldBe 2
		cache.evictOldest() shouldBe 1 // "a" is still oldest
	}

	"remove middle node".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.set("c", 3)
		cache.remove("b")
		cache.size shouldBe 2
		cache.evictOldest() shouldBe 1
		cache.evictOldest() shouldBe 3
		cache.evictOldest().shouldBeNull()
	}

	"clear empties the cache".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(10)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.clear()
		cache.size shouldBe 0
		cache.get("a").shouldBeNull()
		cache.get("b").shouldBeNull()
		cache.evictOldest().shouldBeNull()
	}

	"cache with null maxCacheSize never evicts automatically".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<Int, Int>(null)
		repeat(1000) { cache.set(it, it) }
		cache.size shouldBe 1000
		repeat(1000) { cache.get(it) shouldBe it }
	}

	"cache with maxCacheSize 1 evicts on every new insert".config(enabled = DEFAULT_ENABLED) {
		val cache = LruCache<String, Int>(1)
		cache.set("a", 1)
		cache.set("b", 2)
		cache.size shouldBe 1
		cache.get("a").shouldBeNull()
		cache.get("b") shouldBe 2
		cache.set("b", 99) // update only entry — no eviction
		cache.size shouldBe 1
		cache.get("b") shouldBe 99
	}

	"sequential inserts up to capacity then one more evicts only the oldest".config(enabled = DEFAULT_ENABLED) {
		val n = 5
		val cache = LruCache<Int, Int>(n)
		(0 until n).forEach { cache.set(it, it) }
		cache.set(n, n) // evicts 0
		cache.size shouldBe n
		(1..n).forEach { cache.get(it) shouldBe it }
		cache.get(0).shouldBeNull()
	}
})