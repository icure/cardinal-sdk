package com.icure.cardinal.sdk.model

data class SecretIdCreationResult<E>(
	val updatedEntity: E,
	val newSecretId: String,
)