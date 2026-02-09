// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {CalendarItem, DecryptedCalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {CalendarItemFlavouredInGroupApi} from './CalendarItemFlavouredInGroupApi.mjs';


export interface CalendarItemInGroupApi {

	encrypted: CalendarItemFlavouredInGroupApi<EncryptedCalendarItem>;

	tryAndRecover: CalendarItemFlavouredInGroupApi<CalendarItem>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedCalendarItem | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedCalendarItem>>;

	getEncryptionKeysOf(calendarItem: GroupScoped<CalendarItem>): Promise<Array<HexString>>;

	hasWriteAccess(calendarItem: GroupScoped<CalendarItem>): Promise<boolean>;

	decryptPatientIdOf(calendarItem: GroupScoped<CalendarItem>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<CalendarItem>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	tryDecrypt(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<CalendarItem>>>;

	encryptOrValidate(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	matchCalendarItemsBy(groupId: string, filter: FilterOptions<CalendarItem>): Promise<Array<string>>;

	matchCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<void>;

	purgeCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, calendarItem: GroupScoped<DecryptedCalendarItem>,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<GroupScoped<DecryptedCalendarItem>>;

	shareWithMany(calendarItem: GroupScoped<DecryptedCalendarItem>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CalendarItemShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedCalendarItem>>;

	filterCalendarItemsBy(groupId: string,
			filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>>;

	filterCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>>;

	createCalendarItem(entity: GroupScoped<DecryptedCalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	createCalendarItems(entities: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedCalendarItem>>;

	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	undeleteCalendarItems(calendarItems: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	modifyCalendarItem(entity: GroupScoped<DecryptedCalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	modifyCalendarItems(entities: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	getCalendarItem(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedCalendarItem> | undefined>;

	getCalendarItems(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

}
