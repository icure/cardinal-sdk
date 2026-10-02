// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.FrontEndMigrationJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FrontEndMigrationApi")
public external interface FrontEndMigrationApiJs {
	public fun getFrontEndMigration(frontEndMigrationId: String): Promise<FrontEndMigrationJs?>

	public fun createFrontEndMigration(frontEndMigration: FrontEndMigrationJs): Promise<FrontEndMigrationJs>

	public fun getFrontEndMigrations(): Promise<Array<FrontEndMigrationJs>>

	public fun deleteFrontEndMigration(frontEndMigrationId: String): Promise<DocIdentifierJs>

	public fun getFrontEndMigrationByName(frontEndMigrationName: String): Promise<Array<FrontEndMigrationJs>>

	public fun modifyFrontEndMigration(frontEndMigration: FrontEndMigrationJs): Promise<FrontEndMigrationJs>
}
