package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.DelegationTag
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi

fun uuid() = defaultCryptoService.strongRandom.randomUUID()

@OptIn(InternalIcureApi::class)
suspend fun createUserInMultipleGroups(): List<DataOwnerDetails> {
	val groupId1 = uuid()
	val groupId2 = uuid()
	val groupId3 = uuid()
	val userLogin = "edmond.dantes+${uuid()}"
	val userPw12 = uuid()
	val userPw3 = uuid()
	val userId1 = uuid()
	val userId2 = uuid()
	val userId3 = uuid()
	val groupRawApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	val userRawApi = RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	groupRawApi.createGroup(
		id = groupId1,
		name = "test-group-1-${groupId1}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	groupRawApi.createGroup(
		id = groupId2,
		name = "test-group-2-${groupId2}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	groupRawApi.createGroup(
		id = groupId3,
		name = "test-group-3-${groupId3}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	val user1 = userRawApi.createUserInGroup(
		groupId1,
		User(
			id = userId1,
			login = userLogin,
			name = userLogin,
			email = DataOwnerDetails.testEmailForLogin(userLogin),
			passwordHash = userPw12
		)
	).successBody()
	val user2 = userRawApi.createUserInGroup(
		groupId2,
		User(
			id = userId2,
			login = userLogin,
			name = userLogin,
			email = DataOwnerDetails.testEmailForLogin(userLogin),
			passwordHash = userPw12
		)
	).successBody()
	val user3 = userRawApi.createUserInGroup(
		groupId3,
		User(
			id = userId3,
			login = userLogin,
			name = userLogin,
			email = DataOwnerDetails.testEmailForLogin(userLogin),
			passwordHash = userPw3
		)
	).successBody()
	return listOf(
		DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw12,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null,
			groupId = groupId1
		),
		DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw12,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null,
			groupId = groupId2
		),
		DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw3,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null,
			groupId = groupId3
		),
	)
}

/**
 * @param parent if not null, specifies the direct parent of this data owner. If that parent has a parent then the
 * latter will be the grandparent of this data owner, and so on. If null the data owner will not have any parent.
 */
@OptIn(InternalIcureApi::class)
suspend fun createHcpUser(
	parent: DataOwnerDetails? = null,
	useLegacyKey: Boolean = false,
	roles: Set<String>? = null,
	inGroup: String = testGroupId,
	inheritsPermissions: Boolean = false
): DataOwnerDetails {
	val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	val userRawApi = RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	val hcpId = uuid()
	val login = "hcp-${uuid()}"
	val password = uuid()
	val keypair = defaultCryptoService.rsa.generateKeyPair(
		if (useLegacyKey)
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		else
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
	)
	val exportedPublic = defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) }
	val hcp = hcpRawApi.createHealthcarePartyInGroup(
		inGroup,
		HealthcareParty(
			hcpId,
			firstName = "Hcp-$hcpId",
			lastName = "Hcp-$hcpId",
			publicKeysForOaepWithSha256 = if (useLegacyKey) emptySet() else setOf(exportedPublic),
			publicKey = if (useLegacyKey) exportedPublic else null,
			parentId = parent?.dataOwnerId
		)
	).successBody()
	val created = userRawApi.createUserInGroup(
		groupId = inGroup,
		User(
			uuid(),
			login = login,
			email = DataOwnerDetails.testEmailForLogin(login),
			passwordHash = password,
			healthcarePartyId = hcp.id,
			autoDelegations = mapOf(DelegationTag.All to parent?.hierarchy()?.toSet().orEmpty())
		)
	).successBody()
	if (roles != null) {
		userRawApi.setRolesForUserInGroup(
			userId = created.id,
			groupId = inGroup,
			rolesId = ListOfIds(roles.toList())
		)
	} else if (parent != null) {
		val currentUserRoles = userRawApi.getUserInGroup(
			groupId = inGroup,
			userId = created.id
		).successBody().systemMetadata!!.roles
		if ("HIERARCHICAL_DATA_OWNER" !in currentUserRoles) {
			userRawApi.setRolesForUserInGroup(
				userId = created.id,
				groupId = inGroup,
				rolesId = ListOfIds(currentUserRoles.toList() + "HIERARCHICAL_DATA_OWNER")
			)
		}
	}
	if (inheritsPermissions) userRawApi.setUserInheritsPermissions(userId = created.id, groupId = inGroup, value = true)
	return DataOwnerDetails(hcpId, login, password, keypair, parent, inGroup)
}

data class PlainUserDetails(
	val login: String,
	val email: String,
	val password: String,
)

@OptIn(InternalIcureApi::class)
suspend fun createPlainUser(
	roles: Set<String>? = null,
	inGroup: String = testGroupId,
	inheritsPermissions: Boolean = false
): PlainUserDetails {
	val userRawApi = RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	val login = "hcp-${uuid()}"
	val password = uuid()
	val created = userRawApi.createUserInGroup(
		groupId = inGroup,
		User(
			uuid(),
			login = login,
			email = DataOwnerDetails.testEmailForLogin(login),
			passwordHash = password,
		)
	).successBody()
	if (roles != null) {
		userRawApi.setRolesForUserInGroup(
			userId = created.id,
			groupId = inGroup,
			rolesId = ListOfIds(roles.toList())
		)
	}
	if (inheritsPermissions) userRawApi.setUserInheritsPermissions(userId = created.id, groupId = inGroup, value = true)
	return PlainUserDetails(login, DataOwnerDetails.testEmailForLogin(login), password)
}


@OptIn(InternalIcureApi::class)
suspend fun createPatientUser(
	existingPatientId: String? = null,
	inGroup: String = testGroupId,
	inheritsPermissions: Boolean = false,
	initializeKey: Boolean = true
): DataOwnerDetails {
	val patientRawApi = RawPatientApiImpl(baseUrl, superadminAuth(), null, DefaultRawApiConfig)
	val userRawApi = RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	val patientId = existingPatientId ?: uuid()
	val login = "patient-${uuid()}"
	val password = uuid()
	val keypair = if (initializeKey) defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256) else null
	val patientToCreateOrModify = (
		existingPatientId?.let {
			patientRawApi.getPatientInGroup(groupId = inGroup, patientId = it).successBody()
		} ?: EncryptedPatient(
			patientId,
			firstName = "Patient-$patientId",
			lastName = "Patient-$patientId",
		)
	).let {
		if (initializeKey)
			it.copy(
				publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair!!.public).toHexString().let { SpkiHexString(it) })
			)
		else
			it
	}
	val patient = if (patientToCreateOrModify.rev != null) {
		patientRawApi.modifyPatientInGroup(inGroup, patientToCreateOrModify).successBody()
	} else {
		patientRawApi.createPatientInGroup(inGroup, patientToCreateOrModify).successBody()
	}
	val user = userRawApi.createUserInGroup(
		inGroup,
		User(
			uuid(),
			login = login,
			email = DataOwnerDetails.testEmailForLogin(login),
			passwordHash = password,
			patientId = patient.id
		)
	).successBody()
	if (inheritsPermissions) userRawApi.setUserInheritsPermissions(userId = user.id, groupId = inGroup, value = true)
	return DataOwnerDetails(patientId, login, password, keypair, null, inGroup)
}

@OptIn(InternalIcureApi::class)
suspend fun createUserFromExistingPatient(patient: Patient, keylessPatient: Boolean = false): DataOwnerDetails {
	val patientRawApi = RawPatientApiImpl(baseUrl, testGroupAdminAuth(), NoAccessControlKeysHeadersProvider, DefaultRawApiConfig)
	val userRawApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
	val login = "patient-${uuid()}"
	val password = uuid()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val updatedPatient = if (!keylessPatient) {
		patientRawApi.modifyPatient(
			patientRawApi.getPatient(patient.id).successBody().copy(
				publicKeysForOaepWithSha256 = setOf(
					defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) })
			)
		).successBody()
	} else patientRawApi.getPatient(patient.id).successBody()
	userRawApi.createUser(
		User(
			uuid(),
			login = login,
			email = DataOwnerDetails.testEmailForLogin(login),
			passwordHash = password,
			patientId = updatedPatient.id
		)
	).successBody()
	return DataOwnerDetails(patient.id, login, password, keypair.takeIf { !keylessPatient }, null, testGroupId)
}
