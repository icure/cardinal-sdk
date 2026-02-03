package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

@Serializable
data class EntityWithTypeInfo<T : HasEncryptionMetadata>(
	val entity: T,
	val type: EntityWithEncryptionMetadataTypeName
)

@InternalIcureApi
@Serializable
data class EntityWithEncryptionMetadataStub(
	override val id: String,
	override val rev: String?,
	override val secretForeignKeys: Set<String>,
	override val cryptedForeignKeys: Map<String, Set<Delegation>>,
	override val delegations: Map<String, Set<Delegation>>,
	override val encryptionKeys: Map<String, Set<Delegation>>,
	override val securityMetadata: SecurityMetadata?,
) : HasEncryptionMetadata {
	override fun copyWithSecurityMetadata(
		securityMetadata: SecurityMetadata,
		secretForeignKeys: Set<String>
	): HasEncryptionMetadata = throw UnsupportedOperationException(
		"EntityWithEncryptionMetadataStub security metadata should not be updated, as the changes won't be saved"
	)
}

@InternalIcureApi
fun <T:HasEncryptionMetadata> T.toEncryptionMetadataStub() = EntityWithEncryptionMetadataStub(
	id = id,
	rev = rev,
	secretForeignKeys = secretForeignKeys,
	cryptedForeignKeys = cryptedForeignKeys,
	delegations = delegations,
	encryptionKeys = encryptionKeys,
	securityMetadata = securityMetadata
)

fun <T:Topic> T.withTypeInfo() = EntityWithTypeInfo(this, EntityWithEncryptionMetadataTypeName.Topic)

fun <T> T.asIcureStub(): IcureStub where T : HasEncryptionMetadata, T : ICureDocument<String> =
	IcureStub(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		securityMetadata = securityMetadata,
	)
