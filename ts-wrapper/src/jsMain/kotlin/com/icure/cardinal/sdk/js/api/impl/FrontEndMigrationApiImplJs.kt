// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.js.api.FrontEndMigrationApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.FrontEndMigrationJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.frontEndMigration_fromJs
import com.icure.cardinal.sdk.js.model.frontEndMigration_toJs
import com.icure.cardinal.sdk.model.FrontEndMigration
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FrontEndMigrationApiImplJs(
	private val frontEndMigrationApi: FrontEndMigrationApi,
) : FrontEndMigrationApiJs {
	override fun getFrontEndMigration(frontEndMigrationId: String): Promise<FrontEndMigrationJs?> = GlobalScope.promise {
		val frontEndMigrationIdConverted: String = frontEndMigrationId
		val result = frontEndMigrationApi.getFrontEndMigration(
			frontEndMigrationIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				frontEndMigration_toJs(nonNull1)
			}
		)
	}

	override fun createFrontEndMigration(frontEndMigration: FrontEndMigrationJs): Promise<FrontEndMigrationJs> = GlobalScope.promise {
		val frontEndMigrationConverted: FrontEndMigration = frontEndMigration_fromJs(frontEndMigration)
		val result = frontEndMigrationApi.createFrontEndMigration(
			frontEndMigrationConverted,
		)
		frontEndMigration_toJs(result)
	}

	override fun getFrontEndMigrations(): Promise<Array<FrontEndMigrationJs>> = GlobalScope.promise {
		val result = frontEndMigrationApi.getFrontEndMigrations(
		)
		listToArray(
			result,
			{ x1: FrontEndMigration ->
				frontEndMigration_toJs(x1)
			},
		)
	}

	override fun deleteFrontEndMigration(frontEndMigrationId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val frontEndMigrationIdConverted: String = frontEndMigrationId
		val result = frontEndMigrationApi.deleteFrontEndMigration(
			frontEndMigrationIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun getFrontEndMigrationByName(frontEndMigrationName: String): Promise<Array<FrontEndMigrationJs>> = GlobalScope.promise {
		val frontEndMigrationNameConverted: String = frontEndMigrationName
		val result = frontEndMigrationApi.getFrontEndMigrationByName(
			frontEndMigrationNameConverted,
		)
		listToArray(
			result,
			{ x1: FrontEndMigration ->
				frontEndMigration_toJs(x1)
			},
		)
	}

	override fun modifyFrontEndMigration(frontEndMigration: FrontEndMigrationJs): Promise<FrontEndMigrationJs> = GlobalScope.promise {
		val frontEndMigrationConverted: FrontEndMigration = frontEndMigration_fromJs(frontEndMigration)
		val result = frontEndMigrationApi.modifyFrontEndMigration(
			frontEndMigrationConverted,
		)
		frontEndMigration_toJs(result)
	}
}
