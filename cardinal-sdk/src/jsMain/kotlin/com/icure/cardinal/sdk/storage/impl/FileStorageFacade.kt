package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.CardinalPlatform
import com.icure.cardinal.sdk.utils.currentPlatform
import kotlinx.coroutines.await
import kotlin.js.Promise
import kotlin.js.json

@Suppress("FunctionName")
actual suspend fun FileStorageFacade(directory: String): StorageFacade =
	if (currentPlatform == CardinalPlatform.Node) {
		NodeFileStorageFacade.initialise(directory)
	} else throw UnsupportedOperationException("File storage is not supported on JS browser")

class NodeFileStorageFacade private constructor (
	private val directory: String,
	private val fs: NodeFsAsync
) : StorageFacade {
	companion object {
		@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
		suspend fun initialise(directory: String): NodeFileStorageFacade {
			val fs = if (js("typeof(require) !== 'function'") as Boolean) {
				(js("import('fs/promises')") as Promise<NodeFsAsync>).await()
			} else js("require('fs/promises')") as NodeFsAsync
			try {
				fs.mkdir(directory, json("recursive" to true)).await()
			} catch (e: Exception) {
				throw IllegalStateException("Could not initialise storage directory", e)
			}

			return NodeFileStorageFacade(directory, fs)
		}
	}

	private fun filePath(filename: String) = "$directory/$filename"

	override suspend fun removeItem(key: String) {
		val path = filePath(key)
		if (fs.exists(path)) {
			if (fs.canWrite(path)) {
				fs.rm(path).await()
			} else throw IllegalStateException("Can't delete entry at path $path")
		}
	}

	override suspend fun setItem(key: String, value: String) {
		val path = filePath(key)
		fs.writeFile(path, value.encodeToByteArray()).await()
	}

	override suspend fun getItem(key: String): String? {
		val path = filePath(key)
		return if (fs.exists(path)) {
			if (fs.canRead(path)) {
				fs.readFile(path).await().decodeToString()
			} else throw IllegalStateException("Can't read entry at path $path")
		} else null
	}
}

private suspend fun NodeFsAsync.exists(path: String): Boolean =
	kotlin.runCatching { access(path, constants.F_OK).await() }.isSuccess

private suspend fun NodeFsAsync.canWrite(path: String): Boolean =
	kotlin.runCatching { access(path, constants.W_OK).await() }.isSuccess

private suspend fun NodeFsAsync.canRead(path: String): Boolean =
	kotlin.runCatching { access(path, constants.F_OK or constants.R_OK).await() }.isSuccess

private external interface NodeFsAsync {
	val constants: NodeFsConstants
	fun access(path: String, mode: Int): Promise<Unit>
	fun rm(path: String): Promise<Unit>
	fun writeFile(path: String, data: ByteArray): Promise<Unit>
	fun readFile(path: String): Promise<ByteArray>
	fun mkdir(path: String, options: dynamic): Promise<Unit>
}

@Suppress("PropertyName")
private external interface NodeFsConstants {
	val F_OK: Int
	val R_OK: Int
	val W_OK: Int
}