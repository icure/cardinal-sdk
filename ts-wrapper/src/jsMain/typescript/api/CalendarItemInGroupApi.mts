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

	/**
	 *
	 *  In-group version of [CalendarItemApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedCalendarItem | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(calendarItem: GroupScoped<CalendarItem>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.hasWriteAccess]
	 */
	hasWriteAccess(calendarItem: GroupScoped<CalendarItem>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(calendarItem: GroupScoped<CalendarItem>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<CalendarItem>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.decrypt]
	 */
	decrypt(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.tryDecrypt]
	 */
	tryDecrypt(calendarItems: Array<GroupScoped<EncryptedCalendarItem>>): Promise<Array<GroupScoped<CalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.encryptOrValidate]
	 */
	encryptOrValidate(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<EncryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.matchCalendarItemsBy]
	 */
	matchCalendarItemsBy(groupId: string, filter: FilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [CalendarItemApi.matchCalendarItemsBySorted]
	 */
	matchCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemById]
	 */
	deleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItemsByIds]
	 */
	deleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemById]
	 */
	purgeCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItemsByIds]
	 */
	purgeCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItem]
	 */
	deleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.deleteCalendarItems]
	 */
	deleteCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItem]
	 */
	purgeCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<void>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavourlessApi.purgeCalendarItems]
	 */
	purgeCalendarItems(calendarItems: Array<GroupScoped<CalendarItem>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, calendarItem: GroupScoped<DecryptedCalendarItem>,
			options?: { options?: CalendarItemShareOptions | undefined }): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.shareWithMany]
	 */
	shareWithMany(calendarItem: GroupScoped<DecryptedCalendarItem>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: CalendarItemShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBy]
	 */
	filterCalendarItemsBy(groupId: string,
			filter: FilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemFlavouredApi.filterCalendarItemsBySorted]
	 */
	filterCalendarItemsBySorted(groupId: string,
			filter: SortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItem].
	 */
	createCalendarItem(entity: GroupScoped<DecryptedCalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.createCalendarItems].
	 */
	createCalendarItems(entities: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemById]
	 */
	undeleteCalendarItemById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItemsByIds]
	 */
	undeleteCalendarItemsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItem]
	 */
	undeleteCalendarItem(calendarItem: GroupScoped<CalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.undeleteCalendarItems]
	 */
	undeleteCalendarItems(calendarItems: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItem]
	 */
	modifyCalendarItem(entity: GroupScoped<DecryptedCalendarItem>): Promise<GroupScoped<DecryptedCalendarItem>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.modifyCalendarItems]
	 */
	modifyCalendarItems(entities: Array<GroupScoped<DecryptedCalendarItem>>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItem]
	 */
	getCalendarItem(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedCalendarItem> | undefined>;

	/**
	 *
	 *  In-group version of [CalendarItemBasicFlavouredApi.getCalendarItems]
	 */
	getCalendarItems(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedCalendarItem>>>;

}
