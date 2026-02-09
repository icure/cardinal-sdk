// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Place} from '../model/Place.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PlaceInGroupApi {

	createPlace(place: GroupScoped<Place>): Promise<GroupScoped<Place>>;

	createPlaces(places: Array<GroupScoped<Place>>): Promise<Array<GroupScoped<Place>>>;

	getPlace(groupId: string, placeId: string): Promise<GroupScoped<Place> | undefined>;

	getPlaces(groupId: string, placesIds: Array<string>): Promise<Array<GroupScoped<Place>>>;

	modifyPlace(place: GroupScoped<Place>): Promise<GroupScoped<Place>>;

	modifyPlaces(places: Array<GroupScoped<Place>>): Promise<Array<GroupScoped<Place>>>;

	deletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePlaceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deletePlace(place: GroupScoped<Place>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deletePlaces(places: Array<GroupScoped<Place>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeletePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<Place>>;

	undeletePlaceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<Place>>>;

	undeletePlace(place: GroupScoped<Place>): Promise<GroupScoped<Place>>;

	undeletePlaces(places: Array<GroupScoped<Place>>): Promise<Array<GroupScoped<Place>>>;

	purgePlaceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgePlaceByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgePlace(place: GroupScoped<Place>): Promise<void>;

	purgePlaces(places: Array<GroupScoped<Place>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

}
