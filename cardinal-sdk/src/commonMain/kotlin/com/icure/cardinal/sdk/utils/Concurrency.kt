package com.icure.cardinal.sdk.utils

import kotlinx.coroutines.sync.Mutex
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Implementation based on [kotlinx.coroutines.sync.withLock]. Tries to acquire the lock and if it succeeds exectutes
 * the action.
 * If the lock is already acquired by another coroutine returns null
 */
@OptIn(ExperimentalContracts::class)
inline fun <T : Any> Mutex.tryWithLock(owner: Any? = null, action: () -> T): T? {
	contract {
		callsInPlace(action, InvocationKind.AT_MOST_ONCE)
	}

	val locked = tryLock(owner)
	return if (locked) {
		try {
			return action()
		} finally {
			unlock(owner)
		}
	} else null
}