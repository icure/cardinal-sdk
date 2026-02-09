@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.User
import com.icure.utils.InternalIcureApi
import io.ktor.http.isSuccess

private var initialized = false

@OptIn(InternalIcureApi::class)
suspend fun initializeTestEnvironment() {
	if (initialized) {
		return
	}
	initialized = true
	println("Creating test group")
	val groupApi = RawGroupApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig)
	if (groupApi.getGroup(testGroupId).status.value == 200) {
		println("Group already exist")
	} else  {
		println("Creating group - $testGroupId")
		if (
			groupApi.createGroup(
				testGroupId,
				testGroupName,
				password = uuid(),
				initialisationData = DatabaseInitialisation(
					users = emptyList(),
					healthcareParties = emptyList(),
				)
			).status.isSuccess()
		) {
			println("Group created successfully")
		} else {
			throw IllegalStateException("Failed to create group $testGroupId")
		}
	}
	println("Creating admin user - $testGroupAdmin:$testGroupAdminPassword")
	RawUserApiImpl(baseUrl, superadminAuth(), DefaultRawApiConfig).createAdminUserInGroup(
		testGroupId,
		User(
			uuid(),
			login = testGroupAdmin,
			email = testGroupAdmin,
			passwordHash = testGroupAdminPassword,
		)
	).successBody()
	println("Environment initialisation successful")
}
