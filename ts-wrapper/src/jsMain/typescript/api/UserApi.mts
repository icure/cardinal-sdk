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

	setUserRoles(userId: string, rolesIds: Array<string>): Promise<User>;

	resetUserRoles(userId: string): Promise<User>;

	enable2faForUser(userId: string, request: Enable2faRequest): Promise<void>;

	disable2faForUser(userId: string): Promise<void>;

	createAdminUser(user: User): Promise<User>;

	deleteUserById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeUserById(id: string, rev: string): Promise<void>;

	purgeUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteUserById(id: string, rev: string): Promise<User>;

	undeleteUsersByIds(userIds: Array<StoredDocumentIdentifier>): Promise<Array<User>>;

	deleteUser(user: User): Promise<StoredDocumentIdentifier>;

	deleteUsers(users: Array<User>): Promise<Array<StoredDocumentIdentifier>>;

	purgeUser(user: User): Promise<void>;

	purgeUsers(users: Array<User>): Promise<Array<StoredDocumentIdentifier>>;

	undeleteUser(user: User): Promise<User>;

	undeleteUsers(users: Array<User>): Promise<Array<User>>;

	setExternalJwtAuthByIdentifiersForCurrentUser(externalJwtConfigId: string,
			externalAuthenticationToken: string): Promise<boolean>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<User>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<User>>;

}
