// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.GroupDeletionReport
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfProperties
import com.icure.cardinal.sdk.model.RegistrationInformation
import com.icure.cardinal.sdk.model.RegistrationSuccess
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.PermissionType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object GroupApi {
  public fun listGroups(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Group.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.listGroups()
    }
  }

  public fun getGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getGroup(
        id,
      )
    }
  }

  public fun createGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    nameString: String,
    typeString: String,
    passwordString: String,
    serverString: String,
    qString: String,
    nString: String,
    superGroupString: String,
    projectIdString: String,
    initialisationDataString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val name = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      nameString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      GroupType.serializer().nullable,
      typeString
    )
    val password = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      passwordString
    )
    val server = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      serverString
    )
    val q = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      qString
    )
    val n = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      nString
    )
    val superGroup = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      superGroupString
    )
    val projectId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      projectIdString
    )
    val initialisationData = fullLanguageInteropJson.decodeFromString(
      DatabaseInitialisation.serializer(),
      initialisationDataString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.createGroup(
        id,
        name,
        type,
        password,
        server,
        q,
        n,
        superGroup,
        projectId,
        initialisationData,
      )
    }
  }

  public fun registerNewGroupAdministrator(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    roleString: String,
    registrationInformationString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      GroupType.serializer().nullable,
      typeString
    )
    val role = fullLanguageInteropJson.decodeFromString(
      PermissionType.serializer().nullable,
      roleString
    )
    val registrationInformation = fullLanguageInteropJson.decodeFromString(
      RegistrationInformation.serializer(),
      registrationInformationString
    )
    ApiScope.execute(
      dartResultCallback,
      RegistrationSuccess.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.registerNewGroupAdministrator(
        type,
        role,
        registrationInformation,
      )
    }
  }

  public fun listApps(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Group.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.listApps()
    }
  }

  public fun getNameOfGroupParent(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getNameOfGroupParent(
        id,
      )
    }
  }

  public fun modifyGroupName(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    nameString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val name = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      nameString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.modifyGroupName(
        id,
        name,
      )
    }
  }

  public fun getOperationToken(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    operationString: String,
    durationString: String,
    descriptionString: String,
  ) {
    val operation = fullLanguageInteropJson.decodeFromString(
      Operation.serializer(),
      operationString
    )
    val duration = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      durationString
    )
    val description = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      descriptionString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getOperationToken(
        operation,
        duration,
        description,
      )
    }
  }

  public fun deleteOperationToken(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    tokenIdString: String,
  ) {
    val tokenId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tokenIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.deleteOperationToken(
        tokenId,
      )
    }
  }

  public fun setDefaultRoles(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userTypeString: String,
    roleIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val userType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userTypeString
    )
    val roleIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      roleIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.setDefaultRoles(
        groupId,
        userType,
        roleIds,
      )
    }
  }

  public fun getDefaultRoles(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      MapSerializer(UserType.serializer(), ListSerializer(RoleConfiguration.serializer()))) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getDefaultRoles(
        groupId,
      )
    }
  }

  public fun deleteGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.deleteGroup(
        id,
      )
    }
  }

  public fun changeSuperGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    childGroupIdString: String,
    operationTokenString: String,
  ) {
    val childGroupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      childGroupIdString
    )
    val operationToken = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      operationTokenString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.changeSuperGroup(
        childGroupId,
        operationToken,
      )
    }
  }

  public fun hardDeleteGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(GroupDeletionReport.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.hardDeleteGroup(
        id,
      )
    }
  }

  public fun modifyGroupProperties(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    propertiesString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val properties = fullLanguageInteropJson.decodeFromString(
      ListOfProperties.serializer(),
      propertiesString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.modifyGroupProperties(
        id,
        properties,
      )
    }
  }

  public fun setGroupPassword(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    passwordString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val password = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      passwordString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.setGroupPassword(
        id,
        password,
      )
    }
  }

  public fun initDesignDocs(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    clazzString: String,
    warmupString: String,
    dryRunString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val clazz = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      clazzString
    )
    val warmup = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      warmupString
    )
    val dryRun = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      dryRunString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DesignDocument.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.initDesignDocs(
        id,
        clazz,
        warmup,
        dryRun,
      )
    }
  }

  public fun solveConflicts(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    limitString: String,
    warmupString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val limit = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      limitString
    )
    val warmup = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      warmupString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(IdWithRev.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.solveConflicts(
        id,
        limit,
        warmup,
      )
    }
  }

  public fun resetStorage(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    qString: String,
    nString: String,
    databasesString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val q = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      qString
    )
    val n = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      nString
    )
    val databases = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      databasesString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.resetStorage(
        id,
        q,
        n,
        databases,
      )
    }
  }

  public fun getGroupsStorageInfos(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupsString: String,
  ) {
    val groups = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      groupsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(GroupDatabasesInfo.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getGroupsStorageInfos(
        groups,
      )
    }
  }

  public fun getReplicationInfo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ReplicationInfo.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getReplicationInfo(
        id,
      )
    }
  }

  public fun getHierarchy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getHierarchy(
        id,
      )
    }
  }

  public fun listAllGroupsIds(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.listAllGroupsIds()
    }
  }

  public fun createOrUpdateExternalJwtConfig(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    keyString: String,
    configString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val config = fullLanguageInteropJson.decodeFromString(
      ExternalJwtConfig.serializer(),
      configString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.createOrUpdateExternalJwtConfig(
        groupId,
        key,
        config,
      )
    }
  }

  public fun removeExternalJwtConfig(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    keyString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.removeExternalJwtConfig(
        groupId,
        key,
      )
    }
  }

  public fun getOperationTokenForGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    operationString: String,
    durationString: String,
    descriptionString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val operation = fullLanguageInteropJson.decodeFromString(
      Operation.serializer(),
      operationString
    )
    val duration = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      durationString
    )
    val description = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      descriptionString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.getOperationTokenForGroup(
        groupId,
        operation,
        duration,
        description,
      )
    }
  }

  public fun setGroupProjectId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    projectIdString: String,
    applyToSubgroupsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val projectId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      projectIdString
    )
    val applyToSubgroups = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      applyToSubgroupsString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.setGroupProjectId(
        groupId,
        projectId,
        applyToSubgroups,
      )
    }
  }

  public fun modifyGroupApplicationId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    applicationIdString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val applicationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      applicationIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.modifyGroupApplicationId(
        id,
        applicationId,
      )
    }
  }

  public fun addTagToGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
    tagString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val tag = fullLanguageInteropJson.decodeFromString(
      CodeStub.serializer(),
      tagString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.addTagToGroup(
        id,
        rev,
        tag,
      )
    }
  }

  public fun removeTagFromGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
    tagIdString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    val tagId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Group.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).group.removeTagFromGroup(
        id,
        rev,
        tagId,
      )
    }
  }
}
