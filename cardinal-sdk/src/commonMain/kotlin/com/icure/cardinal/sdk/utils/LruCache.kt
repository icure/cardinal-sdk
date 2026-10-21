package com.icure.cardinal.sdk.utils

import com.icure.utils.InternalIcureApi

/**
 * Note: not thread safe
 */
@InternalIcureApi
class LruCache<K : Any, V : Any>(
	private val maxCacheSize: Int?,
) {
	// Most recently used
	private var lastNode: CacheNode<K, V>? = null
	// Least recently used
	private var firstNode: CacheNode<K, V>? = null
	private val cache: MutableMap<K, CacheNode<K, V>> = mutableMapOf()

	private data class CacheNode<K : Any, V : Any>(
		val key: K,
		var value: V,
		var prev: CacheNode<K, V>? = null,
		var next: CacheNode<K, V>? = null,
	)

	/**
	 * Current size of the cache
	 */
	val size: Int get() = cache.size

	/**
	 * Get the value cached for [key] or null if there is no cached value.
	 */
	fun get(key: K): V? =
		cache[key]?.also { setUsed(it) }?.value

	/**
	 * Updates the value for [key] to [value].
	 */
	fun set(key: K, value: V) {
		val node = cache[key]?.also {
			it.value = value
		} ?: CacheNode(key, value).also {
			if (maxCacheSize != null && cache.size >= maxCacheSize ) evictOldest()
			cache[key] = it
		}
		setUsed(node)
	}

	/**
	 * Remove [key] from the cache (if present)
	 */
	fun remove(key: K) {
		val node = cache.remove(key)
		if (node != null) {
			if (node === firstNode) {
				firstNode = node.next
			}
			if (node === lastNode) {
				lastNode = node.prev
			}
			node.prev?.next = node.next
			node.next?.prev = node.prev
		}
	}

	/**
	 * Evict the oldest entry in the cache, returns null if there is no entry to evict
	 */
	fun evictOldest(): V? =
		firstNode?.also { oldest ->
			cache.remove(oldest.key)
			firstNode = oldest.next
			firstNode?.prev = null
			if (firstNode == null) lastNode = null
		}?.value

	private fun setUsed(node: CacheNode<K, V>) {
		if (node !== lastNode) {
			if (node === firstNode) {
				firstNode = node.next
				firstNode?.prev = null
			} else {
				node.prev?.next = node.next
				node.next?.prev = node.prev
			}
			lastNode?.next = node
			node.prev = lastNode
			node.next = null
			if (lastNode == null) firstNode = node
			lastNode = node
		}
	}

	fun clear() {
		cache.clear()
		lastNode = null
		firstNode = null
	}
}
