// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedPropertyStub} from '../model/PropertyStub.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {UserGroup} from '../model/UserGroup.mjs';
import {Enable2faRequest} from '../model/security/Enable2faRequest.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {UserInGroupApi} from './UserInGroupApi.mjs';


export interface UserApi {

	inGroup: UserInGroupApi;

	getCurrentUser(): Promise<User>;

	createUser(user: User): Promise<User>;

	createUsers(users: Array<User>): Promise<Array<User>>;

	getUser(userId: string): Promise<User | undefined>;

	getUsers(userIds: Array<string>): Promise<Array<User>>;

	modifyUser(user: User): Promise<User>;

	modifyUsers(users: Array<User>): Promise<Array<User>>;

	getUserByEmail(email: string): Promise<User | undefined>;

	getUserByPhoneNumber(phoneNumber: string): Promise<User | undefined>;

	findByHcpartyId(id: string): Promise<Array<string>>;

	findByPatientId(id: string): Promise<Array<string>>;

	assignHealthcareParty(healthcarePartyId: string): Promise<User>;

	modifyProperties(userId: string,
			properties: Array<EncryptedPropertyStub> | undefined): Promise<User>;

	getToken(userId: string, key: string,
			options?: { tokenValidity?: number | undefined, token?: string | undefined }): Promise<string>;

	filterUsersBy(filter: BaseFilterOptions<User>): Promise<PaginatedListIterator<User>>;

	matchUsersBy(filter: BaseFilterOptions<User>): Promise<Array<string>>;

	filterUsersBySorted(filter: BaseSortableFilterOptions<User>): Promise<PaginatedListIterator<User>>;

	matchUsersBySorted(filter: BaseSortableFilterOptions<User>): Promise<Array<string>>;

	getMatchingUsers(): Promise<Array<UserGroup>>;

	/**
	 *
	 *  Configures the roles of a user, replacing the previous ones.
	 *
	 *  By passing an empty list, the user will have no roles, and therefore no permissions. If you intend to change a
	 *  user roles so that it inherits the default roles of its group, you should use [resetUserRoles] instead.
	 */
	setUserRoles(userId: string, rolesIds: Array<string>): Promise<User>;

	/**
	 *
	 *  If the user has any roles directly assigned to them, they will be removed, and the user will have the
	 *  default roles for its category as configured in its group.
	 *
	 *  This could increase or decrease the permissions of the user depending on the previous roles and the group
	 *  configuration.
	 */
	resetUserRoles(userId: string): Promise<User>;

	enable2faForUser(userId: string, request: Enable2faRequest): Promise<void>;

	disable2faForUser(userId: string): Promise<void>;

	createAdminUser(user: User): Promise<User>;

	/**
	 *
	 *  Modify a user password. This method does not require knowing the previous user password so that it can be used
	 *  even as a "forgot password" flow, but is protected by the "elevated security" mechanism, so it should only be
	 *  used with a [com.icure.cardinal.sdk.auth.services.SmartAuthProvider] that can provide the required elevated
	 *  security token if needed.
	 *
	 *  This method should be favored over a simple [modifyUser] when changing the Password as it does not require knowing
	 *  the revision of the user directly, and can work even if there is a [com.icure.cardinal.sdk.auth.services.SmartAuthProvider]
	 *  that is modifying the user tokens when performing the request.
	 */
	modifyUserPassword(userId: string, newPassword: string): Promise<User>;

	/**
	 *
	 *  Modify a user email given its previous value, throwing a [RevisionConflictException] if the provided
	 *  [previousEmail] does not match the stored value.
	 *
	 *  This method should be favored over a simple [modifyUser] when changing the Email as it does not require knowing
	 *  the revision of the user directly, and can work even if there is a [com.icure.cardinal.sdk.auth.services.SmartAuthProvider]
	 *  that is modifying the user tokens when performing the request.
	 */
	modifyUserEmail(userId: string, newEmail: string,
			previousEmail: string | undefined): Promise<User>;

	/**
	 *
	 *  Modify a user mobile phone given its previous value, throwing a [RevisionConflictException] if the provided
	 *  [previousMobilePhone] does not match the stored value.
	 *
	 *  This method should be favored over a simple [modifyUser] when changing the MobilePhone as it does not require knowing
	 *  the revision of the user directly, and can work even if there is a [com.icure.cardinal.sdk.auth.services.SmartAuthProvider]
	 *  that is modifying the user tokens when performing the request.
	 */
	modifyUserMobilePhone(userId: string, newMobilePhone: string,
			previousMobilePhone: string | undefined): Promise<User>;

	/**
	 *
	 *  Deletes a user. If you don't have write access to the user the method will fail.
	 *  @param entityId id of the user.
	 *  @param rev the latest known rev of the user to delete
	 *  @return the id and revision of the deleted user.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteUserById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a user.
	 *  @param id id of the user to purge
	 *  @param rev latest revision of the user
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeUserById(id: string, rev: string): Promise<void>;

	purgeUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores a user that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteUserById(id: string, rev: string): Promise<User>;

	undeleteUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<User>>;

	/**
	 *
	 *  Deletes a user. If you don't have write access to the user the method will fail.
	 *  @param user the user to delete
	 *  @return the id and revision of the deleted user.
	 *  @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	deleteUser(user: User): Promise<StoredDocumentIdentifier>;

	deleteUsers(users: Array<User>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a user.
	 *  @param user the user to purge.
	 *  @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	purgeUser(user: User): Promise<void>;

	purgeUsers(users: Array<User>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Restores a user that was marked as deleted.
	 *  @param user the user to undelete
	 *  @return the restored user.
	 *  @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	undeleteUser(user: User): Promise<User>;

	undeleteUsers(users: Array<User>): Promise<Array<User>>;

	setExternalJwtAuthByIdentifiersForCurrentUser(externalJwtConfigId: string,
			externalAuthenticationToken: string): Promise<boolean>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<User>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<User>>;

}
