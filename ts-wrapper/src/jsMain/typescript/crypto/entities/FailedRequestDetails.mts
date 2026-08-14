// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {DelegateShareOptions} from './DelegateShareOptions.mjs';


/**
 *
 *  Details about a single (entity, delegate) share-or-metadata-update request that did not succeed, returned as part
 *  of a bulk-share operation's error list (e.g. [BulkShareByIdsResult.shareErrors]).
 *
 *  A request can fail for two very different reasons, modeled as the two subtypes below - check which one you have
 *  with `is`/`when` before doing anything more specific than reading [entityId]/[delegateReference]/[reason].
 */
export type FailedRequestDetails = FailedRequestDetails.ResolutionFailed | FailedRequestDetails.RequestRejected;

export namespace FailedRequestDetails {

	/**
	 *
	 *  The requested share options for this (entity, delegate) pair could not be satisfied with what the current
	 *  user can actually access - for example [ShareMetadataBehaviour.Required] was specified for some piece of
	 *  metadata (an encryption key, an owning entity id) but the current user has no access to it, or a
	 *  [SecretIdShareOptions.UseExactly] listed a secret id the current user doesn't recognize (with
	 *  `createUnknownSecretIds = false`).
	 *
	 *  This is entirely a client-side outcome, decided from what the current user can access right now, before any
	 *  request is even built, let alone sent to the server. It isn't retried automatically by `autoRetry`, and simply
	 *  calling the same method again immediately won't help either. That said, it isn't necessarily permanent: it
	 *  reflects a snapshot of the current user's access, which can still change afterwards - for example if someone
	 *  else shares the missing encryption key or secret id with the current user in the meantime, a later retry with
	 *  the exact same options could well succeed.
	 */
	export class ResolutionFailed {

		entityId: string;

		delegateReference: EntityReferenceInGroup;

		reason: string | undefined;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.ResolutionFailed' = 'com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.ResolutionFailed';

		constructor(partial: Partial<ResolutionFailed> & Pick<ResolutionFailed, "entityId" | "delegateReference" | "reason">) {
			this.entityId = partial.entityId;
			this.delegateReference = partial.delegateReference;
			this.reason = partial.reason;
		}

	}

	/**
	 *
	 *  A well-formed share-or-update request was actually sent to the server for this (entity, delegate) pair, and
	 *  the server rejected it - for example because the current user doesn't have enough permission to grant the
	 *  requested access level, or because the entity's revision was stale.
	 *
	 *  This should be uncommon if the current user could successfully retrieve the entity in the first place, and is
	 *  kept intentionally opaque (a status code and a best-effort human-readable reason): callers aren't expected to
	 *  branch on the specific cause, only to know that this particular (entity, delegate) pair needs attention.
	 *
	 *  @param code the status code the server returned for this specific request.
	 *  @param shouldRetry whether the SDK considers this specific failure worth retrying (e.g. with a freshly
	 *  fetched revision of the entity). Bulk operations that support `autoRetry` already do this automatically once
	 *  before giving up, so by the time you observe this you can assume that retry (if applicable) already happened.
	 *  @param updatedForMigration `true` if this request wasn't actually about sharing or updating access for
	 *  [delegateReference], but rather an internal step to migrate that delegate's pre-existing legacy delegation to
	 *  the current secure-delegation format. Most callers can ignore this field.
	 *  @param request the low-level share options that were sent to the server for this (entity, delegate) pair, or
	 *  `null` if this was an [updatedForMigration] request (which doesn't carry share options of its own).
	 */
	export class RequestRejected {

		entityId: string;

		delegateReference: EntityReferenceInGroup;

		reason: string | undefined;

		code: number;

		shouldRetry: boolean;

		updatedForMigration: boolean;

		request: DelegateShareOptions | undefined;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.RequestRejected' = 'com.icure.cardinal.sdk.crypto.entities.FailedRequestDetails.RequestRejected';

		constructor(partial: Partial<RequestRejected> & Pick<RequestRejected, "entityId" | "delegateReference" | "reason" | "code" | "shouldRetry" | "updatedForMigration" | "request">) {
			this.entityId = partial.entityId;
			this.delegateReference = partial.delegateReference;
			this.reason = partial.reason;
			this.code = partial.code;
			this.shouldRetry = partial.shouldRetry;
			this.updatedForMigration = partial.updatedForMigration;
			this.request = partial.request;
		}

	}

}
