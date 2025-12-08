// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.GroupApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DatabaseInitialisationJs
import com.icure.cardinal.sdk.js.model.GroupDeletionReportJs
import com.icure.cardinal.sdk.js.model.GroupJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.ListOfPropertiesJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.RegistrationInformationJs
import com.icure.cardinal.sdk.js.model.RegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.ReplicationInfoJs
import com.icure.cardinal.sdk.js.model.couchdb.DesignDocumentJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.GroupDatabasesInfoJs
import com.icure.cardinal.sdk.js.model.couchdb.designDocument_toJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.couchdb.groupDatabasesInfo_toJs
import com.icure.cardinal.sdk.js.model.databaseInitialisation_fromJs
import com.icure.cardinal.sdk.js.model.embed.RoleConfigurationJs
import com.icure.cardinal.sdk.js.model.embed.roleConfiguration_toJs
import com.icure.cardinal.sdk.js.model.groupDeletionReport_toJs
import com.icure.cardinal.sdk.js.model.group_toJs
import com.icure.cardinal.sdk.js.model.idWithRev_toJs
import com.icure.cardinal.sdk.js.model.listOfProperties_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.registrationInformation_fromJs
import com.icure.cardinal.sdk.js.model.registrationSuccess_toJs
import com.icure.cardinal.sdk.js.model.replicationInfo_toJs
import com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs
import com.icure.cardinal.sdk.js.model.security.externalJwtConfig_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.GroupDeletionReport
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfProperties
import com.icure.cardinal.sdk.model.RegistrationInformation
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.PermissionType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class GroupApiImplJs(
	private val groupApi: GroupApi,
) : GroupApiJs {
	override fun listGroups(): Promise<Array<GroupJs>> = GlobalScope.promise {
		val result = groupApi.listGroups(
		)
		listToArray(
			result,
			{ x1: Group ->
				group_toJs(x1)
			},
		)
	}

	override fun getGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getGroup(
			idConverted,
		)
		group_toJs(result)
	}

	override fun createGroup(
		id: String,
		name: String,
		password: String,
		initialisationData: DatabaseInitialisationJs,
		options: dynamic,
	): Promise<GroupJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val nameConverted: String = name
			val typeConverted: GroupType? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				type?.let { nonNull1 ->
					GroupType.valueOf(nonNull1)
				}
			}
			val passwordConverted: String = password
			val serverConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"server",
				null
			) { server: String? ->
				undefinedToNull(server)
			}
			val qConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"q",
				null
			) { q: Double? ->
				numberToInt(q, "q")
			}
			val nConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"n",
				null
			) { n: Double? ->
				numberToInt(n, "n")
			}
			val superGroupConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"superGroup",
				null
			) { superGroup: String? ->
				undefinedToNull(superGroup)
			}
			val projectIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"projectId",
				null
			) { projectId: String? ->
				undefinedToNull(projectId)
			}
			val initialisationDataConverted: DatabaseInitialisation =
					databaseInitialisation_fromJs(initialisationData)
			val result = groupApi.createGroup(
				idConverted,
				nameConverted,
				typeConverted,
				passwordConverted,
				serverConverted,
				qConverted,
				nConverted,
				superGroupConverted,
				projectIdConverted,
				initialisationDataConverted,
			)
			group_toJs(result)
		}
	}

	override fun registerNewGroupAdministrator(registrationInformation: RegistrationInformationJs,
			options: dynamic): Promise<RegistrationSuccessJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: GroupType? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				type?.let { nonNull1 ->
					GroupType.valueOf(nonNull1)
				}
			}
			val roleConverted: PermissionType? = convertingOptionOrDefaultNullable(
				_options,
				"role",
				null
			) { role: String? ->
				role?.let { nonNull1 ->
					PermissionType.valueOf(nonNull1)
				}
			}
			val registrationInformationConverted: RegistrationInformation =
					registrationInformation_fromJs(registrationInformation)
			val result = groupApi.registerNewGroupAdministrator(
				typeConverted,
				roleConverted,
				registrationInformationConverted,
			)
			registrationSuccess_toJs(result)
		}
	}

	override fun listApps(): Promise<Array<GroupJs>> = GlobalScope.promise {
		val result = groupApi.listApps(
		)
		listToArray(
			result,
			{ x1: Group ->
				group_toJs(x1)
			},
		)
	}

	override fun findGroups(id: String, options: dynamic): Promise<PaginatedListJs<GroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = groupApi.findGroups(
				idConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Group ->
					group_toJs(x1)
				},
			)
		}
	}

	override fun findGroupsWithContent(
		id: String,
		searchString: String,
		options: dynamic,
	): Promise<PaginatedListJs<GroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val searchStringConverted: String = searchString
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = groupApi.findGroupsWithContent(
				idConverted,
				searchStringConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Group ->
					group_toJs(x1)
				},
			)
		}
	}

	override fun getNameOfGroupParent(id: String): Promise<String> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getNameOfGroupParent(
			idConverted,
		)
		result
	}

	override fun modifyGroupName(id: String, name: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val nameConverted: String = name
		val result = groupApi.modifyGroupName(
			idConverted,
			nameConverted,
		)
		group_toJs(result)
	}

	override fun getOperationToken(
		operation: String,
		duration: Double?,
		options: dynamic,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val operationConverted: Operation = Operation.valueOf(operation)
			val durationConverted: Long? = numberToLong(duration, "duration")
			val descriptionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"description",
				null
			) { description: String? ->
				undefinedToNull(description)
			}
			val result = groupApi.getOperationToken(
				operationConverted,
				durationConverted,
				descriptionConverted,
			)
			result
		}
	}

	override fun deleteOperationToken(tokenId: String): Promise<Unit> = GlobalScope.promise {
		val tokenIdConverted: String = tokenId
		groupApi.deleteOperationToken(
			tokenIdConverted,
		)

	}

	override fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: Array<String>,
	): Promise<GroupJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userTypeConverted: String = userType
		val roleIdsConverted: List<String> = arrayToList(
			roleIds,
			"roleIds",
			{ x1: String ->
				x1
			},
		)
		val result = groupApi.setDefaultRoles(
			groupIdConverted,
			userTypeConverted,
			roleIdsConverted,
		)
		group_toJs(result)
	}

	override fun getDefaultRoles(groupId: String): Promise<Record<String, Array<RoleConfigurationJs>>>
			= GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = groupApi.getDefaultRoles(
			groupIdConverted,
		)
		mapToObject(
			result,
			{ x1: UserType ->
				x1.name
			},
			{ x1: List<RoleConfiguration> ->
				listToArray(
					x1,
					{ x2: RoleConfiguration ->
						roleConfiguration_toJs(x2)
					},
				)
			},
		)
	}

	override fun deleteGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.deleteGroup(
			idConverted,
		)
		group_toJs(result)
	}

	override fun changeSuperGroup(childGroupId: String, operationToken: String): Promise<GroupJs> =
			GlobalScope.promise {
		val childGroupIdConverted: String = childGroupId
		val operationTokenConverted: String = operationToken
		val result = groupApi.changeSuperGroup(
			childGroupIdConverted,
			operationTokenConverted,
		)
		group_toJs(result)
	}

	override fun hardDeleteGroup(id: String): Promise<Array<GroupDeletionReportJs>> =
			GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.hardDeleteGroup(
			idConverted,
		)
		listToArray(
			result,
			{ x1: GroupDeletionReport ->
				groupDeletionReport_toJs(x1)
			},
		)
	}

	override fun modifyGroupProperties(id: String, properties: ListOfPropertiesJs): Promise<GroupJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val propertiesConverted: ListOfProperties = listOfProperties_fromJs(properties)
		val result = groupApi.modifyGroupProperties(
			idConverted,
			propertiesConverted,
		)
		group_toJs(result)
	}

	override fun setGroupPassword(id: String, password: String): Promise<GroupJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val passwordConverted: String = password
		val result = groupApi.setGroupPassword(
			idConverted,
			passwordConverted,
		)
		group_toJs(result)
	}

	override fun initDesignDocs(
		id: String,
		warmup: Boolean?,
		dryRun: Boolean?,
		options: dynamic,
	): Promise<Array<DesignDocumentJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val clazzConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"clazz",
				null
			) { clazz: String? ->
				undefinedToNull(clazz)
			}
			val warmupConverted: Boolean? = undefinedToNull(warmup)
			val dryRunConverted: Boolean? = undefinedToNull(dryRun)
			val result = groupApi.initDesignDocs(
				idConverted,
				clazzConverted,
				warmupConverted,
				dryRunConverted,
			)
			listToArray(
				result,
				{ x1: DesignDocument ->
					designDocument_toJs(x1)
				},
			)
		}
	}

	override fun solveConflicts(
		id: String,
		limit: Double?,
		warmup: Boolean?,
	): Promise<Array<IdWithRevJs>> = GlobalScope.promise {
		val idConverted: String = id
		val limitConverted: Int? = numberToInt(limit, "limit")
		val warmupConverted: Boolean? = undefinedToNull(warmup)
		val result = groupApi.solveConflicts(
			idConverted,
			limitConverted,
			warmupConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun resetStorage(
		id: String,
		databases: Array<String>,
		options: dynamic,
	): Promise<Unit> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val qConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"q",
				null
			) { q: Double? ->
				numberToInt(q, "q")
			}
			val nConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"n",
				null
			) { n: Double? ->
				numberToInt(n, "n")
			}
			val databasesConverted: List<String> = arrayToList(
				databases,
				"databases",
				{ x1: String ->
					x1
				},
			)
			groupApi.resetStorage(
				idConverted,
				qConverted,
				nConverted,
				databasesConverted,
			)

		}
	}

	override fun getGroupsStorageInfos(groups: Array<String>): Promise<Array<GroupDatabasesInfoJs>> =
			GlobalScope.promise {
		val groupsConverted: List<String> = arrayToList(
			groups,
			"groups",
			{ x1: String ->
				x1
			},
		)
		val result = groupApi.getGroupsStorageInfos(
			groupsConverted,
		)
		listToArray(
			result,
			{ x1: GroupDatabasesInfo ->
				groupDatabasesInfo_toJs(x1)
			},
		)
	}

	override fun getReplicationInfo(id: String): Promise<ReplicationInfoJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getReplicationInfo(
			idConverted,
		)
		replicationInfo_toJs(result)
	}

	override fun getHierarchy(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getHierarchy(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun listAllGroupsIds(): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val result = groupApi.listAllGroupsIds(
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun createOrUpdateExternalJwtConfig(
		groupId: String,
		key: String,
		config: ExternalJwtConfigJs,
	): Promise<GroupJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val keyConverted: String = key
		val configConverted: ExternalJwtConfig = externalJwtConfig_fromJs(config)
		val result = groupApi.createOrUpdateExternalJwtConfig(
			groupIdConverted,
			keyConverted,
			configConverted,
		)
		group_toJs(result)
	}

	override fun removeExternalJwtConfig(groupId: String, key: String): Promise<GroupJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val keyConverted: String = key
		val result = groupApi.removeExternalJwtConfig(
			groupIdConverted,
			keyConverted,
		)
		group_toJs(result)
	}

	override fun getOperationTokenForGroup(
		groupId: String,
		operation: String,
		duration: Double?,
		description: String?,
	): Promise<String> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val operationConverted: Operation = Operation.valueOf(operation)
		val durationConverted: Long? = numberToLong(duration, "duration")
		val descriptionConverted: String? = undefinedToNull(description)
		val result = groupApi.getOperationTokenForGroup(
			groupIdConverted,
			operationConverted,
			durationConverted,
			descriptionConverted,
		)
		result
	}

	override fun setGroupProjectId(
		groupId: String,
		projectId: String?,
		applyToSubgroups: Boolean,
	): Promise<Unit> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val projectIdConverted: String? = undefinedToNull(projectId)
		val applyToSubgroupsConverted: Boolean = applyToSubgroups
		groupApi.setGroupProjectId(
			groupIdConverted,
			projectIdConverted,
			applyToSubgroupsConverted,
		)

	}
}
