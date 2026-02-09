// auto-generated file
import {Place} from '../model/Place.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {PlaceInGroupApi} from './PlaceInGroupApi.mjs';


export interface PlaceApi {

	inGroup: PlaceInGroupApi;

	createPlace(place: Place): Promise<Place>;

	createPlaces(places: Array<Place>): Promise<Array<Place>>;

	getPlace(placeId: string): Promise<Place | undefined>;

	getPlaces(placesIds: Array<string>): Promise<Array<Place>>;

	modifyPlace(place: Place): Promise<Place>;

	modifyPlaces(places: Array<Place>): Promise<Array<Place>>;

	deletePlaceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deletePlaceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deletePlace(place: Place): Promise<StoredDocumentIdentifier>;

	deletePlaces(places: Array<Place>): Promise<Array<StoredDocumentIdentifier>>;

	undeletePlaceById(entityId: string, rev: string): Promise<Place>;

	undeletePlaceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<Place>>;

	undeletePlace(place: Place): Promise<Place>;

	undeletePlaces(places: Array<Place>): Promise<Array<Place>>;

	purgePlaceById(entityId: string, rev: string): Promise<void>;

	purgePlaceByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgePlace(place: Place): Promise<void>;

	purgePlaces(places: Array<Place>): Promise<Array<StoredDocumentIdentifier>>;

}
