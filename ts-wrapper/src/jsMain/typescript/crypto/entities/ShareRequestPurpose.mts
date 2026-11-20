// auto-generated file

/**
 *
 *  What a single share-or-metadata-update request the sdk sent was actually for. Sharing an entity may require the sdk
 *  to also migrate the pre-existing legacy delegations of the data owners of the current hierarchy to the current
 *  secure-delegation format, and those migrations travel as requests of their own - sometimes merged with a request
 *  the caller asked for.
 */
export enum ShareRequestPurpose {
	RequestedShare = "RequestedShare",
	Migration = "Migration",
	RequestedShareAndMigration = "RequestedShareAndMigration"
}
