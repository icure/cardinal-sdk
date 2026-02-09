// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItemShareOptions} from '../crypto/entities/CalendarItemShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {CalendarItem, DecryptedCalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {CalendarItemFlavouredApi} from './CalendarItemFlavouredApi.mjs';
import {CalendarItemInGroupApi} from './CalendarItemInGroupApi.mjs';


export interface CalendarItemApi {

	encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>;

	tryAndRecover: CalendarItemFlavouredApi<CalendarItem>;

	inGroup: CalendarItemInGroupApi;

	withEncryptionMetadata(base: DecryptedCalendarItem | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedCalendarItem>;

	getEncryptionKeysOf(calendarItem: CalendarItem): Promise<Array<HexString>>;

	hasWriteAccess(calendarItem: CalendarItem): Promise<boolean>;

	decryptPatientIdOf(calendarItem: CalendarItem): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: CalendarItem,
			delegates: Array<string>): Promise<void>;

	decrypt(calendarItems: Array<EncryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	tryDecrypt(calendarItems: Array<EncryptedCalendarItem>): Promise<Array<CalendarItem>>;

	encryptOrValidate(calendarItems: Array<CalendarItem>): Promise<Array<EncryptedCalendarItem>>;

	matchCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<Array<string>>;

	matchCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	deleteCalendarItemById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItemById(id: string, rev: string): Promise<void>;

	purgeCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteCalendarItem(calendarItem: CalendarItem): Promise<StoredDocumentIdentifier>;

	deleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	purgeCalendarItem(calendarItem: CalendarItem): Promise<void>;

	purgeCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<StoredDocumentIdentifier>>;

	shareWith(delegateId: string, calendarItem: DecryptedCalendarItem,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<DecryptedCalendarItem>;

	shareWithMany(calendarItem: DecryptedCalendarItem,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<DecryptedCalendarItem>;

	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<DecryptedCalendarItem>;

	filterCalendarItemsBy(filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<DecryptedCalendarItem>>;

	filterCalendarItemsBySorted(filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<DecryptedCalendarItem>>;

	createCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	createCalendarItems(entities: Array<DecryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	bookCalendarItemCheckingAvailability(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	undeleteCalendarItemById(id: string, rev: string): Promise<DecryptedCalendarItem>;

	undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedCalendarItem>>;

	undeleteCalendarItem(calendarItem: CalendarItem): Promise<DecryptedCalendarItem>;

	undeleteCalendarItems(calendarItems: Array<CalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	modifyCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	modifyCalendarItems(entities: Array<DecryptedCalendarItem>): Promise<Array<DecryptedCalendarItem>>;

	getCalendarItem(entityId: string): Promise<DecryptedCalendarItem | undefined>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<DecryptedCalendarItem>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<CalendarItem>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedCalendarItem>>;

}
