import {SpkiHexString} from "../model/specializations/SpkiHexString.mjs";
import {DataOwnerWithType} from "../model/DataOwnerWithType.mjs";
import {KeypairFingerprintV1String} from "../model/specializations/KeypairFingerprintV1String.mjs";
import {CryptoActorStubWithType} from "../model/CryptoActorStubWithType.mjs";
import {KeyStorageFacade, StorageFacade} from "../storage/StorageFacade.mjs";
import {RecoveryResult} from "./entities/RecoveryResult.mjs";
import {RecoveryDataKey} from "./entities/RecoveryDataKey.mjs";
import {RecoveryApi} from "../api/RecoveryApi.mjs";
import {RsaAlgorithm, XCryptoService, XRsaKeypair} from "./CryptoService.mjs";
import {CardinalApis} from "../sdk/CardinalSdk.mjs";
import {DataOwnerType} from "../model/DataOwnerType.mjs";

/**
 * Allows customizing the behavior of the crypto api to better suit your needs.
 *
 * An important task which should be done in these crypto strategies is public key verification: in general there is no guarantee that the public keys
 * stored in the iCure database are authentic, i.e. created by the data owner they are associated to. This is because the database admins or a
 * malicious attacker may have added his own public keys to the data owner's public keys.
 * Sharing any kind of data using unverified public keys could potentially cause a data leak: this is why when creating new exchange keys or when
 * creating recovery data only verified keys will be considered. For decrypting existing data instead unverified keys will be used without issues.
 */
export class CryptoStrategies {
  /**
   * Method called during initialization of the crypto API to validate keys recovered through iCure's recovery methods and/or to allow recovery of
   * missing keys using means external to iCure.
   * On startup the iCure sdk will try to load all keys for the current data owner and its parent hierarchy: if the sdk can't find some of the keys
   * for any of the data owners (according to the public keys for the data owner in the iCure server) and/or the sdk could recover some private keys
   * but can't verify the authenticity of the key pairs this method will be called.
   * The recovered and verified keys will automatically be cached using the current api {@link KeyStorageFacade} and {@link StorageFacade}
   *
   * The input is a list containing an object for each data owner part of the current data owner hierarchy. The objects are ordered from the data
   * for the topmost parent of the current data owner hierarchy (first element) to the data for the current data owner (last element).
   *
   * The returned value must be an object associating to each data owner id an object with:
   * - `recoveredKeys`:
   * - `keyAuthenticity`: an object
   * @param keysData all information on unknown and unavailable keys for each data owner part of the current data owner hierarchy.
   * @param cryptoPrimitives cryptographic primitives you can use to support the process.
   * @param keyPairRecoverer a key pair recoverer you can use to support the process
   * @return a map that associates to each given data owner id the recovered data.
   */
  recoverAndVerifySelfHierarchyKeys(
    keysData: Array<CryptoStrategies.KeyDataRecoveryRequest>,
    cryptoPrimitives: XCryptoService,
    keyPairRecoverer: KeyPairRecoverer
  ): Promise<{ [dataOwnerId: string]: CryptoStrategies.RecoveredKeyData }> {
    const res: { [dataOwnerId: string]: CryptoStrategies.RecoveredKeyData } = {}
    for (const data of keysData) {
      res[data.dataOwnerDetails.dataOwner.id] = { recoveredKeys: {}, keyAuthenticity: {} }
    }
    return Promise.resolve(res)
  }

  /**
   * The correct initialisation of the crypto API requires that at least 1 verified (or device) key pair is available for each data owner part of the
   * current data owner hierarchy. If no verified key is available for any of the data owner parents the api initialisation will automatically fail,
   * however if there is no verified key for the current data owner you can instead create a new crypto key.
   * @param self the current data owner.
   * @param cryptoPrimitives cryptographic primitives you can use to support the process.
   * @return an instance of [KeyGenerationRequestResult] specifying how the SDK should behave.
   * @throws Exception you can throw any exception, and it will simply propagate to the api initialisation method.
   */
  generateNewKeyForDataOwner(
    self: DataOwnerWithType,
    cryptoPrimitives: XCryptoService,
  ): Promise<boolean | XRsaKeypair | "keyless" | "parent-delegator"> {
    return Promise.resolve(true)
  }

  /**
   * Verifies if the public keys of a data owner which will be the delegate of a new exchange key do actually belong to the person the data owner
   * represents. This method is not called when the delegate would be the current data owner for the api.
   *
   * The user will have to obtain the verified public keys of the delegate from outside iCure, for example by email with another hcp, by checking the
   * personal website of the other user, or by scanning verification qr codes at the doctor office...
   *
   * As long as one of the public keys is verified the creation of a new exchange key will succeed. If no public key is verified the operation will
   * fail.
   * @param delegate the potential data owner delegate.
   * @param publicKeys public keys requiring verification, in spki hex-encoded format.
   * @param cryptoPrimitives cryptographic primitives you can use to support the process.
   * @param groupId the id of the data owner's group, or null if the data owner is in the same group as the current user
   * @return all verified public keys, in spki hex-encoded format.
   */
  verifyDelegatePublicKeys(
    delegate: CryptoActorStubWithType,
    publicKeys: Array<SpkiHexString>,
    cryptoPrimitives: XCryptoService,
    groupId: string | undefined
  ): Promise<Array<SpkiHexString>> {
    return Promise.resolve(publicKeys)
  }

  /**
   * Specifies if a data owner requires anonymous delegations, i.e. his id should not appear unencrypted in new secure
   * delegations.
   * This should always be the case for patient data owners.
   * @param dataOwner a data owner.
   * @param groupId the id of the data owner's group, or null if the data owner is in the same group as the current user
   * @return true if the delegations for the provided data owner should be anonymous.
   */
  dataOwnerRequiresAnonymousDelegation(
      dataOwner: CryptoActorStubWithType,
      groupId: string | undefined
  ): Promise<boolean> {
    return Promise.resolve(dataOwner.type != DataOwnerType.Hcp)
  }

  /**
   * Notifies that a new key for the current data owner was created.
   * This method is called after the initialization of the other SDK apis.
   * @param apis the initialized cardinal apis.
   * @param key the newly created key.
   * @param cryptoPrimitives cryptographic primitives you can use to support the process.
   */
  notifyNewKeyCreated(
      apis: CardinalApis,
      key: XRsaKeypair,
      cryptoPrimitives: XCryptoService,
  ): Promise<void> {
    return Promise.resolve()
  }
}


export namespace CryptoStrategies {
  /**
   * A request to recover key data that was not found for a user.
   */
  export interface KeyDataRecoveryRequest {
    /**
     * The data owner for which the key data should be recovered.
     */
    readonly dataOwnerDetails: DataOwnerWithType
    /**
     * All public keys (in hex-encoded spki format) of `dataOwner` for which the authenticity status (verified or unverified) is
     * unknown (no result was cached from a previous api instantiation and the key was not generated on the current device).
     * This could include keys that were recovered automatically by the sdk and may have overlap with `unavailableKeys`.
     */
    readonly unknownKeys: Array<SpkiHexString>
    /**
     * All public keys (in hex-encoded spki format) of `dataOwner` for which the sdk could not recover a private key. May overlap
     * (partially or completely) with `unknownKeys`.
     */
    readonly unavailableKeys: Array<UnavailableKeyInfo>
  }

  /**
   * Data recovered for a data owner.
   */
  export interface RecoveredKeyData {
    /**
     * All keys recovered for the data owner, by fingerprint.
     * Recovered keys are by default considered as verified, unless explicitly marked as unverified in
     * `keyAuthenticity`.
     */
    readonly recoveredKeys: { [fp: KeypairFingerprintV1String | SpkiHexString]: XRsaKeypair }
    /**
     * Marks if the user has recognized any public key associated to him as authentic / verified.
     * The key of the object should be a public key in hex-encoded spki format or its fingerprint (last 32 characters of
     * the hex-encoded spki representation).
     * If any of the keys from `unknownKeys` is completely missing from this object the key will be considered as
     * unverified in this api instance (same as false). However, in this case the unverified status of the key won't be
     * saved: next time that an api is instantiated, even if the storage was not reset sdk will ask again to verify the
     * authenticity of that key.
     */
    readonly keyAuthenticity: { [fp: KeypairFingerprintV1String | SpkiHexString]: boolean }
  }

  export interface UnavailableKeyInfo {
    /**
     * The public key
     */
    readonly publicKey: SpkiHexString,
    /**
     * The algorithm of the keypair
     */
    readonly keyAlgorithm: RsaAlgorithm
  }
}

/**
 * Allows to recover user keypairs using builtin recovery mechanisms.
 * This interface includes recovery methods that require some input from your application (e.g. a recovery key created from a different device).
 * Other recovery methods (such as transfer keys) are used automatically by the sdk when available and don't require any input from your application.
 */
export interface KeyPairRecoverer {
  /**
   * Recover a keypair using a recovery key created in the past using the {@link RecoveryApi.createRecoveryInfoForAvailableKeyPairs} method.
   * @param recoveryKey the result of a past call to {@link RecoveryApi.createRecoveryInfoForAvailableKeyPairs}.
   * @param autoDelete if true, the recovery data will be deleted from the server after it could be used successfully.
   * This will prevent the recovery key from being used again.
   * @return a recovery result, which, if successful, contains a map dataOwnerId -> publicKeySpki -> keyPair, where:
   * - The `dataOwnerId` keys are the ids of the data owner which created the recovery data and his parents, if the recovery data contains also the
   *   parents keys
   * - The `publicKeySpki` keys are all recovered public key pairs for the data owner, in hex-encoded spki format (full, no fingerprint). Usually
   *   these are all the keys if the recovery data was created after the latest key for the user.
   * - The `keyPair` is the imported privateKey + publicKey.
   */
  recoverWithRecoveryKey(
    recoveryKey: RecoveryDataKey,
    autoDelete: boolean
  ): Promise<RecoveryResult<{ [dataOwnerId: string]: { [publicKeySpki: SpkiHexString]: XRsaKeypair } }>>

  /**
   * Get information on which keys the SDK will be able to recover autonomously through transfer keys or shamir
   * shares using the provided {@link recoveredKeys} plus any already available keys (i.e. keys that were already in the
   * storage or recovered using transfer keys and/or shamir from the keys already in the storage).
   *
   * When prompting the user to recover more of his keys you can ignore any key that are returned by this method, as
   * those keys will be automatically recovered by the SDK if you return {@link recoveredKeys}.
   */
  getRecoverableWithEncryptionKeys(
    dataOwner: DataOwnerWithType,
    recoveredKeys: XRsaKeypair[]
  ): Promise<SpkiHexString[]>
}