// auto-generated file
import {DataOwnerType} from '../model/DataOwnerType.mjs';
import {KeyPairUpdateNotification} from '../model/sdk/KeyPairUpdateNotification.mjs';
import {SpkiHexString} from '../model/specializations/SpkiHexString.mjs';


/**
 *
 *  Api for creating and interpreting iCure's standard maintenance tasks
 */
export interface CardinalMaintenanceTaskApi {

	/**
	 *
	 *  Applies a key pair update request between another data owner and the current data owner to allow the other data owner to access existing exchange
	 *  keys shared with the current data owner. IMPORTANT: it is your responsibility to verify the authenticity of the public key / update request
	 *  before calling this method: this method assumes the new public key for the concerned data owner is authentic.
	 *  @param updateRequest a keypair update request to the current data owner.
	 */
	applyKeyPairUpdate(updateRequest: KeyPairUpdateNotification): Promise<void>;

	/**
	 *
	 *  Creates the necessary maintenance tasks to request access through the keypair corresponding to [key] to ALL existing exchange keys between the
	 *  current user and other data owners of the types specified in [requestToOwnerTypes].
	 *  If [requestToOwnerTypes] is null the set of data owners will be automatically chosen depending on the type of the current data owner:
	 *  - [[DataOwnerType.Hcp]] for healthcare parties
	 *  - [[DataOwnerType.Patient], [DataOwnerType.Hcp]] for patients
	 *  @param key a public key of the current user.
	 *  @param requestToOwnerTypes limit request creations only to data owners of these types.
	 */
	createKeyPairUpdateNotificationsToAllDelegationCounterparts(key: SpkiHexString,
			options?: { requestToOwnerTypes?: Array<DataOwnerType> | undefined }): Promise<void>;

	/**
	 *
	 *  Creates a maintenance tasks to request access through the keypair corresponding to [key] to ALL existing exchange keys between the
	 *  current data owner and [dataOwnerId].
	 */
	createKeyPairUpdateNotificationTo(dataOwnerId: string, key: SpkiHexString): Promise<void>;

}
