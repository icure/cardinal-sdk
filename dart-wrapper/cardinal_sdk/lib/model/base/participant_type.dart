// auto-generated file


enum ParticipantType {
	admitter,
	attender,
	callbackContact,
	consultant,
	discharger,
	escort,
	referrer,
	secondaryPerformer,
	primaryPerformer,
	participation,
	translator,
	emergency,
	location,
	recorder;

	static String encode(ParticipantType value) {
		switch (value) {
			case ParticipantType.admitter:
				return 'admitter';
			case ParticipantType.attender:
				return 'attender';
			case ParticipantType.callbackContact:
				return 'callback';
			case ParticipantType.consultant:
				return 'consultant';
			case ParticipantType.discharger:
				return 'discharger';
			case ParticipantType.escort:
				return 'escort';
			case ParticipantType.referrer:
				return 'referrer';
			case ParticipantType.secondaryPerformer:
				return 'secondaryPerformer';
			case ParticipantType.primaryPerformer:
				return 'primaryPerformer';
			case ParticipantType.participation:
				return 'participation';
			case ParticipantType.translator:
				return 'translator';
			case ParticipantType.emergency:
				return 'emergency';
			case ParticipantType.location:
				return 'location';
			case ParticipantType.recorder:
				return 'recorder';
			}
	}


	static ParticipantType fromJSON(String data) {
		switch (data) {
			case "admitter":
				return ParticipantType.admitter;
			case "attender":
				return ParticipantType.attender;
			case "callback":
				return ParticipantType.callbackContact;
			case "consultant":
				return ParticipantType.consultant;
			case "discharger":
				return ParticipantType.discharger;
			case "escort":
				return ParticipantType.escort;
			case "referrer":
				return ParticipantType.referrer;
			case "secondaryPerformer":
				return ParticipantType.secondaryPerformer;
			case "primaryPerformer":
				return ParticipantType.primaryPerformer;
			case "participation":
				return ParticipantType.participation;
			case "translator":
				return ParticipantType.translator;
			case "emergency":
				return ParticipantType.emergency;
			case "location":
				return ParticipantType.location;
			case "recorder":
				return ParticipantType.recorder;
			default:
				throw ArgumentError('Invalid ParticipantType entry value $data');
			}
	}

}