# Tutorial

In this section you will find several self-contained and runnable tutorials that explore
the main functionalities and use cases of the Cardinal SDK.

---
slug: basic-tutorial-sdk-initialization
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Initialize the SDK

After you have [created a first database and a healthcare party user with a token](/tutorial/basic/sdk-basic-tutorial),
you can use those credentials to instantiate a new iCure SDK.

<LanguageTabs>
<TabItem value="kotlin">

In the following example, the username and password are retrieved from the standard input:

```kotlin
private const val CARDINAL_URL = "https://api.icure.cloud"

print("Login: ")
val username = readln().trim()
print("Password: ")
val password = readln().trim()
val sdk = CardinalSdk.initialize(
	applicationId = null,
	baseUrl = CARDINAL_URL,
	authenticationMethod = AuthenticationMethod.UsingCredentials(
		UsernamePassword(username, password)
	),
	baseStorage = FileStorageFacade("./scratch/storage")
)
```

The `initialize` function creates an instance of the SDK with the provided username and password. It also attempts to
load existing cryptographic keys for the user from the `./scratch/storage` folder. If no key is found for the user in
that folder, a new cryptographic key will be generated and stored there.
</TabItem>
<TabItem value="python">

In the following example, the username and password are retrieved from the standard input:

```python
CARDINAL_URL = "https://api.icure.cloud"

username = input("Username: ")
password = input("Password: ")
sdk = CardinalSdk(
	application_id=None,
	baseurl=CARDINAL_URL,
	authentication_method=UsernamePassword(username, password),
	storage_facade=FileSystemStorage("./scratch/storage")
)
```

The `initialize` function creates an instance of the SDK with the provided username and password. It also attempts to
load existing cryptographic keys for the user from the `./scratch/storage` folder. If no key is found for the user in
that folder, a new cryptographic key will be generated and stored there.
</TabItem>
<TabItem value="typescript">

In the following example, the username and password are retrieved from the standard input:

```typescript
const CARDINAL_URL = "https://api.icure.cloud"

const username = await readLn("Login: ")
const password = await readLn("Password: ")
const sdk = CardinalSdk.initialize(
	undefined,
	CARDINAL_URL,
	new AuthenticationMethod.UsingCredentials.UsernamePassword(username, password),
	StorageFacade.usingFileSystem("./scratch/storage")
)
```

The `initialize` function creates an instance of the SDK with the provided username and password. It also attempts to
load existing cryptographic keys for the user from the `./scratch/storage` folder. If no key is found for the user in
that folder, a new cryptographic key will be generated and stored there.
</TabItem>
<TabItem value="dart">

In the following example, the function initializes an SDK with a username and a password retrieved from the app UI:

```dart
const cardinalUrl = "https://api.icure.cloud";

Future<CardinalSdk> createSdk(String username, String password) async {
  final sdk = await CardinalSdk.initialize(
      null,
      cardinalUrl,
      AuthenticationMethod.UsingCredentials(Credentials.UsernamePassword(username, password)),
      StorageOptions.PlatformDefault
  );
  return sdk;
}
```

The `initialize` function creates an instance of the SDK with the provided username and password. It also attempts to
load existing cryptographic keys for the user from the native storage implementation (Androidx DataStore for Android,
NSUserDefaults for iOS, iPadOS, macOS & watchOS). If no key is found for the user, a new cryptographic key will be generated
and stored.
</TabItem>
</LanguageTabs>

If you want to know more about the SDK initialization parameters, check [this how to](/how-to/initialize-the-sdk/).---
slug: basic-tutorial-create-patient
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Create a Patient

In Cardinal, a patient is represented by the `Patient` entity.

<LanguageTabs>
<TabItem value="kotlin">

In the following example, the user reads a first name and last name from the standard input and instantiates a patient entity:

```kotlin
val firstName = readln().trim()
print("Last name: ")
val lastName = readln().trim()
val patient = DecryptedPatient(
	id = UUID.randomUUID().toString(),
	firstName = firstName,
	lastName = lastName,
)
```

</TabItem>
<TabItem value="python">

In the following example, the user reads a first name and last name from the standard input and instantiates a patient entity:

```python
first_name = input("First name: ")
last_name = input("Last name: ")
patient = DecryptedPatient(
	id=str(uuid.uuid4()),
	first_name=first_name,
	last_name=last_name,
)
```

</TabItem>
<TabItem value="typescript">

In the following example, the user reads a first name and last name from the standard input and instantiates a patient entity:

```typescript
const firstName = await readLn("First name: ")
const lastName = await readLn("Last name: ")
const patient = new DecryptedPatient({
	id: uuid(),
	firstName: firstName,
	lastName: lastName,
})
```

</TabItem>
<TabItem value="dart">

In the following example, the user instantiates a patient entity using a `firstName` and `lastName` that are provided by
the UI:

```dart
final patient = DecryptedPatient(
  generateUuid(),
  firstName: firstName,
  lastName: lastName,
);
```

</TabItem>
</LanguageTabs>

A `Patient` is an encryptable entity, meaning it will be encrypted on the device that creates it and then sent
encrypted to the cloud. Since it is decrypted at the moment of creation, a `DecryptedPatient` is instantiated. Besides
`firstName` and `lastName`, the `id` must also be set on the entity. Using a
[UUID v4](https://en.wikipedia.org/wiki/Universally_unique_identifier) is strongly recommended.

Next, the metadata required for the encryption of the entity must be initialized:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val patientWithMetadata = sdk.patient.withEncryptionMetadata(patient)
```

</TabItem>
<TabItem value="python">

```python
patient_with_metadata = sdk.patient.with_encryption_metadata_blocking(patient)
```

</TabItem>
<TabItem value="typescript">

```typescript
const patientWithMetadata = await sdk.patient.withEncryptionMetadata(patient)
```

</TabItem>
<TabItem value="dart">

```dart
final patientWithMetadata = await sdk.patient.withEncryptionMetadata(patient);
```

</TabItem>
</LanguageTabs>

This step is mandatory and also shares the newly created Patient with the user creating it, who will initially be the only
one able to read the entity's encrypted fields.

After this step, the entity can finally be encrypted and stored in the cloud:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val createdPatient = sdk.patient.createPatient(patientWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
created_patient = sdk.patient.create_patient_blocking(patient_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const createdPatient = await sdk.patient.createPatient(patientWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final createdPatient = await sdk.patient.createPatient(patientWithMetadata);
```

</TabItem>
</LanguageTabs>

<LanguageTabs>
<TabItem value="kotlin">

Once created, the entity can be modified. In the following example, a date of birth is read from the standard input
and added to the patient:

```kotlin
print("Date of birth (YYYYMMDD): ")
val dateOfBirth = readln().toInt()
val patientWithBirth = createdPatient.copy(
	dateOfBirth = dateOfBirth
)
val updatedPatient = sdk.patient.modifyPatient(patientWithBirth)
```

</TabItem>
<TabItem value="python">

Once created, the entity can be modified. In the following example, a date of birth is read from the standard input
and added to the patient:

```python
date_of_birth = int(input("Date of birth (YYYYMMDD): "))
created_patient.date_of_birth = date_of_birth
updated_patient = sdk.patient.modify_patient_blocking(created_patient)
```

</TabItem>
<TabItem value="typescript">

Once created, the entity can be modified. In the following example, a date of birth is read from the standard input
and added to the patient:

```typescript
const dateOfBirth = parseInt((await readLn("Date of birth (YYYYMMDD): ")).trim())
const patientWithBirth = new DecryptedPatient({
	...createdPatient,
	dateOfBirth: dateOfBirth,
})
const updatedPatient = await sdk.patient.modifyPatient(patientWithBirth)
```

</TabItem>
<TabItem value="dart">

Once created, the entity can be modified. In the following example, a date of birth is retrieved from the UI
and added to the patient:

```dart
int dateAsYYYYMMDD = // This is provided by the user through the UI
createdPatient.dateOfBirth = dateAsYYYYMMDD;
final updatedPatient = await sdk.patient.modifyPatient(createdPatient);
```

</TabItem>
</LanguageTabs>

The date of birth in the patient is stored in the `dateOfBirth` field as an integer in the `YYYYMMDD` format. It is worth
noting that since the entity is already created and the encryption metadata are already initialized, there is no need
to call `withEncryptionMetadata` again.

After creation, it is also possible to retrieve the entity from the cloud. In the following example, the patient
is retrieved using its ID:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
println("Retrieving patient by ID:")
val retrievedPatient = sdk.patient.getPatient(updatedPatient.id)
```

</TabItem>
<TabItem value="python">

```python
print("The retrieved patient is:")
retrieved_patient = sdk.patient.get_patient_blocking(updated_patient.id)
```

</TabItem>
<TabItem value="typescript">

```typescript
console.log("The retrieved patient is:")
const retrievedPatient = await sdk.patient.getPatient(updatedPatient.id)
```

</TabItem>
<TabItem value="dart">

```dart
final retrievedPatient = sdk.patient.getPatient(updatedPatient.id);
```

</TabItem>
</LanguageTabs>

More advanced methods for retrieving entities are available and will be explained in
[another section of this tutorial](/tutorial/basic/modules/basic-tutorial-search-data) and [in more depth here](/how-to/querying-data).
---
slug: basic-tutorial-create-medical-data
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Create and Encrypt Medical Data

The example in this section demonstrates how to register a medical examination, where some medical exams are performed
and a diagnosis is elaborated.

## Initiating a Medical Examination

In Cardinal, the concept of a medical examination is represented through the `Contact` entity. Generally, a `Contact`
represents a moment when medical data are produced and involves a patient and, usually, one or more healthcare actors.
For more details, check the [Contact explanation](/explanations/data-model/contact).

As the first step, the user can choose to use an existing Patient or create a new one:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
print("Insert the id of a Patient (blank to create a new one): ")
val patientId = readlnOrNull()
val patient = if (patientId.isNullOrBlank()) {
	sdk.patient.createPatient(
		DecryptedPatient(
			id = UUID.randomUUID().toString(),
			firstName = "Annabelle",
			lastName = "Hall",
		).let { sdk.patient.withEncryptionMetadata(it) }
	)
} else {
	sdk.patient.getPatient(patientId)
}
```

</TabItem>
<TabItem value="python">

```python
patient_id = input("Insert the id of a Patient (blank to create a new one): ")
if len(patient_id) == 0:
	patient = sdk.patient.create_patient_blocking(
		sdk.patient.with_encryption_metadata_blocking(
			DecryptedPatient(
				id=str(uuid.uuid4()),
				first_name="Annabelle",
				last_name="Hall"
			)
		)
	)
else:
	patient = sdk.patient.get_patient_blocking(patient_id)
```

</TabItem>
<TabItem value="typescript">

```typescript
const patientId = await readLn("Insert the id of a Patient (blank to create a new one): ")
let patient: DecryptedPatient
if(patientId.length === 0) {
	patient = await sdk.patient.createPatient(
		await sdk.patient.withEncryptionMetadata(
			new DecryptedPatient({
				id: uuid(),
				firstName: "Annabelle",
				lastName: "Hall",
			})
		)
	)
} else {
	patient = await sdk.patient.getPatient(patientId)
}
```

</TabItem>
<TabItem value="dart">

```dart
String patientId = // This is provided by the user through the UI
final patient = patientId.trim().isEmpty
    ? await sdk.patient.createPatient(
		await sdk.patient.withEncryptionMetadata(
			DecryptedPatient(
				generateUuid(),
				firstName: "Annabelle",
				lastName: "Hall",
			)
		)
	) : await sdk.patient.getPatient(patientId);
```

</TabItem>
</LanguageTabs>

Next, a new `Contact` is instantiated with a custom description provided by the user:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
print("Examination description: ")
val description = readln().trim()
val contact = DecryptedContact(
	id = UUID.randomUUID().toString(),
	descr = description,
	openingDate = LocalDateTime.now().format(formatter).toLong()
)
```

</TabItem>
<TabItem value="python">

```python
description = input("Examination description: ")
contact = DecryptedContact(
	id=str(uuid.uuid4()),
	descr=description,
	opening_date=int(datetime.now().strftime("%Y%m%d%H%M%S"))
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const description = await readLn("Examination description: ")
const contact = new DecryptedContact({
	id: uuid(),
	descr: description,
	openingDate: currentFuzzyDate()
})
```

</TabItem>
<TabItem value="dart">

```dart
String description = // This is provided by the user through the UI
final contact = DecryptedContact(
    generateUuid(),
    descr: description,
    openingDate: currentDateAsYYYYMMddHHmmSS()
);
```

</TabItem>
</LanguageTabs>

A `Contact` is an encryptable entity, so a `DecryptedContact` is used when instantiating it. Besides the description,
both the `id` and `openingDate` must be set. The `openingDate` represents the moment when the medical examination
starts. Generally, it marks the beginning of the event during which medical data are created.

Being an encryptable entity, the encryption metadata need to be initialized before creating the `Contact`, just as with the `Patient`:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val contactWithMetadata = sdk.contact.withEncryptionMetadata(contact, patient)
```

</TabItem>
<TabItem value="python">

```python
contact_with_metadata = sdk.contact.with_encryption_metadata_blocking(contact, patient)
```

</TabItem>
<TabItem value="typescript">

```typescript
const contactWithMetadata = await sdk.contact.withEncryptionMetadata(contact, patient)
```

</TabItem>
<TabItem value="dart">

```dart
final contactWithMetadata = await sdk.contact.withEncryptionMetadata(contact, patient);
```

</TabItem>
</LanguageTabs>

In this case, the initialization step differs slightly from that of the patient. The function takes two parameters as
input: the contact itself and a patient. This is because the metadata will also include a link to the Patient who is
the subject of this examination. To prevent data leaks, this link is encrypted, and only users with access to the
contact will be able to decipher it.

Finally, the `Contact` can be encrypted and stored in the cloud:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val createdContact = sdk.contact.createContact(contactWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
created_contact = sdk.contact.create_contact_blocking(contact_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const createdContact = await sdk.contact.createContact(contactWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final createdContact = await sdk.contact.createContact(contactWithMetadata);
```

</TabItem>
</LanguageTabs>

## Registering Medical Data

After the `Contact` is created, you can add medical data to it. Medical information is registered using a
`Service` encryptable entity nested within a `Contact`. In the following examples, data in different formats will be
added to the contact that was just created.

### Creating Scalar Medical Data (Blood Pressure)

The first piece of information added to the contact is a blood pressure measurement. In the following snippet, a
`Service` (using its `DecryptedService` variation, since `Service` is an encryptable entity) is instantiated with the
result of the exam:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val bloodPressureService = DecryptedService(
	id = UUID.randomUUID().toString(),
	label = "Blood pressure",
	identifier = listOf(Identifier(system = "cardinal", value = "bloodPressure")),
	content = mapOf(
		"en" to DecryptedContent(
			measureValue = Measure(
				value = Random.nextInt(80, 120).toDouble(),
				unit = "mmHg"
			)
		)
	)
)
```

</TabItem>
<TabItem value="python">

```python
blood_pressure_service = DecryptedService(
	id=str(uuid.uuid4()),
	label="Blood pressure",
	identifier=[Identifier(system="cardinal", value="bloodPressure")],
	content={
		"en": DecryptedContent(
			measure_value=Measure(
				value=float(random.randint(80, 120)),
				unit="mmHg"
			)
		)
	}
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const bloodPressureService = new DecryptedService({
	id: uuid(),
	label: "Blood pressure",
	identifier: [new Identifier({system: "cardinal", value: "bloodPressure"})],
	content: {
		"en": new DecryptedContent({
			measureValue: new Measure({
				value: random(80, 120),
				unit: "mmHg"
			})
		})
	}
})
```

</TabItem>
<TabItem value="dart">

```dart
final bloodPressureService = DecryptedService(
	generateUuid(),
	label: "Blood pressure",
	identifier: [Identifier(system: "cardinal", value: "bloodPressure")],
	content: {
		"en": DecryptedContent(
			measureValue: Measure(
				value: (80 + Random().nextInt(41)).toDouble(),
				unit: "mmHg"
			)
		)
	}
);
```

</TabItem>
</LanguageTabs>

In this case, a free-text `label` provides a description for the `Service`, and an `identifier` allows for a
more structured labeling.

:::caution
When adding sensitive information to an encryptable entity, always remember that not all fields are encrypted.
You can customize the encrypted fields as explained in [this how to](/how-to/initialize-the-sdk/configure-what-to-encrypt).
:::

The actual measurement is stored in the `content` of the `Service`. This field is a map that associates an
[ISO language code](https://en.wikipedia.org/wiki/List_of_ISO_639_language_codes) with `Content`. In this case,
the content contains a measure value that holds the blood pressure result and its unit.

The `Service` can now be added to the existing `Contact`:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val contactWithBloodPressure = sdk.contact.modifyContact(
	createdContact.copy(
		services = setOf(bloodPressureService)
	)
)
```

</TabItem>
<TabItem value="python">

```python
created_contact.services = [blood_pressure_service]
contact_with_blood_pressure = sdk.contact.modify_contact_blocking(
	created_contact
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const contactWithBloodPressure = await sdk.contact.modifyContact(
	new DecryptedContact({
		...createdContact,
		services: [...createdContact.services, bloodPressureService]
	})
)
```

</TabItem>
<TabItem value="dart">

```dart
createdContact.services = { bloodPressureService };
final contactWithBloodPressure = await sdk.contact.modifyContact(createdContact);
```

</TabItem>
</LanguageTabs>

It is worth noting that even though `Service` is an encryptable entity, there is no need to call the
`withEncryptionMetadata` method because the entity is nested within another encryptable entity and will inherit
its encryption metadata. This means that if the enclosing entity was shared with another user,
the nested entity will automatically be shared as well.

### Creating Signal-like Medical Data (Electrocardiography)

A `Service` can also hold time-series data, signals, and, in general, vector-like data. In the following example,
the resulting signal from an [ECG (Electrocardiography)](https://en.wikipedia.org/wiki/Electrocardiography) exam is
added to the `Contact` through a `Service`:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val ecgSignal = List(10) { Random.nextInt(0, 100) / 100.0 }
val heartRateService = DecryptedService(
	id = UUID.randomUUID().toString(),
	identifier = listOf(Identifier(system = "cardinal", value = "ecg")),
	label = "Heart rate",
	content = mapOf(
		"en" to DecryptedContent(
			timeSeries = TimeSeries(
				samples = listOf(ecgSignal)
			)
		)
	)
)
val contactWithECG = sdk.contact.modifyContact(
	contactWithBloodPressure.copy(
		services = contactWithBloodPressure.services + heartRateService
	)
)
```

</TabItem>
<TabItem value="python">

```python
ecg_signal = [round(float(random.uniform(0, 1)), 2) for _ in range(10)]
heart_rate_service = DecryptedService(
	id=str(uuid.uuid4()),
	identifier=[Identifier(system="cardinal", value="ecg")],
	label="Heart rate",
	content={
		"en": DecryptedContent(
			time_series=TimeSeries(
				samples=[ecg_signal]
			)
		)
	}
)
contact_with_blood_pressure.services = contact_with_blood_pressure.services + [heart_rate_service]
contact_with_ecg = sdk.contact.modify_contact_blocking(contact_with_blood_pressure)
```

</TabItem>
<TabItem value="typescript">

```typescript
const ecgSignal = Array.from({ length: 10 }, () => random(0, 100)/100.0 )
const heartRateService = new  DecryptedService({
	id: uuid(),
	identifier: [new Identifier({system: "cardinal", value: "ecg"})],
	label: "Heart rate",
	content: {
		"en": new DecryptedContent({
			timeSeries: new TimeSeries({
				samples: [ecgSignal]
			})
		})
	}
})
const contactWithECG = await sdk.contact.modifyContact(
	new DecryptedContact({
		...contactWithBloodPressure,
		services: [...contactWithBloodPressure.services, heartRateService]
	})
)
```

</TabItem>
<TabItem value="dart">

```dart
final ecgSignal = List.generate(10, (_) => Random().nextInt(100) / 100.0);
final heartRateService = DecryptedService(
	generateUuid(),
	identifier: [Identifier(system: "cardinal", value: "ecg")],
	label: "Heart rate",
	content: {
		"en": DecryptedContent(
			timeSeries: TimeSeries(
				samples: [ecgSignal]
			)
		)
	}
);
contactWithBloodPressure.services.add(heartRateService);
final contactWithECG = await sdk.contact.modifyContact(contactWithBloodPressure);
```

</TabItem>
</LanguageTabs>

The structure of this `Service` is almost identical to that of the previous example, with the only difference being
that the medical data are stored as `timeSeries` in the Content instead of `measureValue`. A `TimeSeries` entity
can contain both 1-dimensional and 2-dimensional signals, as well as aggregated data such as minimum, maximum, and
average values.

### Creating Medical Image Data

Due to their larger size, the process of uploading medical images (such as those from X-Ray or CT exams, as well as
simple photos) differs from uploading single measurements or signals. This difference is intended to avoid
performance loss when querying and retrieving entities that contain large files.

:::note
A `Content` has a `binaryData` field that can be used to store binary data, but for the aforementioned reasons,
it should not be used to store large amounts of data.
:::

The first step in uploading a medical image (or another large file) is to create a new `Document` entity.
A `Document` is an encryptable entity that represents medical documents (e.g., reports, certificates, images) in any format.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val document = DecryptedDocument(
	id = UUID.randomUUID().toString(),
	documentType = DocumentType.Labresult
)
```

</TabItem>
<TabItem value="python">

```python
document = DecryptedDocument(
	id=str(uuid.uuid4()),
	document_type=DocumentType.Labresult
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const document = new DecryptedDocument({
	id: uuid(),
	documentType: DocumentType.Labresult
})
```

</TabItem>
<TabItem value="dart">

```dart
final document = DecryptedDocument(
	generateUuid(),
	documentType: DocumentType.labresult
);
```

</TabItem>
</LanguageTabs>

In this example, a new `DecryptedDocument` is instantiated with the type set to a laboratory result. Since a `Document`
is encryptable, the encryption metadata must be initialized before it is created on the cloud.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val createdDocument = sdk.document.createDocument(
	sdk.document.withEncryptionMetadata(document, null)
)
```

</TabItem>
<TabItem value="python">

```python
created_document = sdk.document.create_document_blocking(
	sdk.document.with_encryption_metadata_blocking(document, None)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const createdDocument = await sdk.document.createDocument(
	await sdk.document.withEncryptionMetadata(document, null)
)
```

</TabItem>
<TabItem value="dart">

```dart
final createdDocument = await sdk.document.createDocument(
	await sdk.document.withEncryptionMetadata(document, null)
);
```

</TabItem>
</LanguageTabs>

Note that in this case, the `withEncryptionMetadata` method takes a null second parameter. This is because there is no
need to link the `Document` directly to the `Patient`, as the document will be linked to a `Service` that, in turn,
will be linked to the `Patient`.

Next, you can load the image as an attachment to the `Document`. A `Document` can have a single main attachment and
multiple secondary attachments. In this case, an "image" is loaded as the main attachment to the document.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val xRayImage = Random.nextBytes(100)
val documentWithAttachment = sdk.document.encryptAndSetMainAttachment(
	document = createdDocument,
	utis = listOf("public.tiff"),
	attachment = xRayImage
)
```

</TabItem>
<TabItem value="python">

```python
x_ray_image = bytearray(secrets.token_bytes(100))
document_with_attachment = sdk.document.encrypt_and_set_main_attachment_blocking(
	document=created_document,
	utis=["public.tiff"],
	attachment=x_ray_image
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const xRayImage = new Int8Array(100)
for (let i = 0; i < 100; i++) {
	xRayImage[i] = random(-127, 128)
}
const documentWithAttachment = await sdk.document.encryptAndSetMainAttachment(
	createdDocument,
	["public.tiff"],
	xRayImage
)
```

</TabItem>
<TabItem value="dart">

```dart
Uint8List xRayImage = Uint8List(100);
for (int i = 0; i < xRayImage.length; i++) {
	xRayImage[i] = Random().nextInt(256);
}
final documentWithAttachment = await sdk.document.encryptAndSetMainAttachment(
	createdDocument,
	["public.tiff"],
	xRayImage
);
```

</TabItem>
</LanguageTabs>

The bytes composing the image are encrypted and set as the attachment of the `Document`. Information about the
[UTI](https://en.wikipedia.org/wiki/Uniform_Type_Identifier) of the attachment is also set.

Finally, it is possible to link this `Document` with a new `Service` representing the X-Ray image and add it to the `Contact`.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val xRayService = DecryptedService(
	id = UUID.randomUUID().toString(),
	label = "X-Ray image",
	identifier = listOf(Identifier(system = "cardinal", value = "xRay")),
	content = mapOf(
		"en" to DecryptedContent(
			documentId = documentWithAttachment.id
		)
	)
)
val contactWithImage = sdk.contact.modifyContact(
	contactWithECG.copy(
		services = contactWithECG.services + xRayService
	)
)
```

</TabItem>
<TabItem value="python">

```python
x_ray_service = DecryptedService(
	id=str(uuid.uuid4()),
	label="X-Ray image",
	identifier=[Identifier(system="cardinal", value="xRay")],
	content={
		"en": DecryptedContent(
			document_id=document_with_attachment.id
		)
	}
)
contact_with_ecg.services = contact_with_ecg.services + [x_ray_service]
contact_with_image = sdk.contact.modify_contact_blocking(contact_with_ecg)
```

</TabItem>
<TabItem value="typescript">

```typescript
const xRayService = new DecryptedService({
	id: uuid(),
	label: "X-Ray image",
	identifier: [new Identifier({system: "cardinal", value: "xRay"})],
	content: {
		"en": new DecryptedContent({
			documentId: documentWithAttachment.id
		})
	}
})
const contactWithImage = await sdk.contact.modifyContact(
	new DecryptedContact({
		...contactWithECG,
		services: [...contactWithECG.services, xRayService]
	})
)
```

</TabItem>
<TabItem value="dart">

```dart
final xRayService = DecryptedService(
	generateUuid(),
	label: "X-Ray image",
	identifier: [Identifier(system: "cardinal", value: "xRay")],
	content: {
		"en": DecryptedContent(
			documentId: documentWithAttachment.id
		)
	}
);
contactWithECG.services.add(xRayService);
final contactWithImage = await sdk.contact.modifyContact(contactWithECG);
```

</TabItem>
</LanguageTabs>

## Adding a Diagnosis

Diagnoses and other medical contexts that define the health condition of a patient are represented by a
`HealthElement` encryptable entity. In this example, the user will create a `HealthElement` containing the
diagnosis elaborated after the examination.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
print("What is the diagnosis?: ")
val diagnosis = readln().trim()
val healthElement = DecryptedHealthElement(
	id = UUID.randomUUID().toString(),
	descr = diagnosis
)
val createdDiagnosis = sdk.healthElement.createHealthElement(
	sdk.healthElement.withEncryptionMetadata(healthElement, patient)
)
```

</TabItem>
<TabItem value="python">

```python
diagnosis = input("What is the diagnosis?: ")
health_element = DecryptedHealthElement(
	id=str(uuid.uuid4()),
	descr=diagnosis
)
created_diagnosis = sdk.health_element.create_health_element_blocking(
	sdk.health_element.with_encryption_metadata_blocking(health_element, patient)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const diagnosis = await readLn("What is the diagnosis?: ")
const healthElement = new DecryptedHealthElement({
	id: uuid(),
	descr: diagnosis
})
const createdDiagnosis = await sdk.healthElement.createHealthElement(
	await sdk.healthElement.withEncryptionMetadata(healthElement, patient)
)
```

</TabItem>
<TabItem value="dart">

```dart
const diagnosis = await readLn("What is the diagnosis?: ")
const healthElement = new DecryptedHealthElement({
	id: uuid(),
	descr: diagnosis
})
const createdDiagnosis = await sdk.healthElement.createHealthElement(
	await sdk.healthElement.withEncryptionMetadata(healthElement, patient)
)
```

</TabItem>
</LanguageTabs>

A `HealthElement` is an encryptable entity, so like a `Contact`, first a `DecryptedHealthElement`
is instantiated with the desired information. Then, the encryption metadata are initialized, linking the
`HealthElement` to a Patient and sharing the entity with the current user. Finally, the entity is created.

It is possible to associate the `HealthElement` with a `Contact` by linking it to a `SubContact`:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val contactWithDiagnosis = sdk.contact.modifyContact(
	contactWithImage.copy(
		subContacts = setOf(DecryptedSubContact(
			descr = "Diagnosis",
			healthElementId = createdDiagnosis.id
		))
	)
)
```

</TabItem>
<TabItem value="python">

```python
contact_with_image.sub_contacts = [
	DecryptedSubContact(
		descr="Diagnosis",
		health_element_id=created_diagnosis.id
	)
]
contact_with_diagnosis = sdk.contact.modify_contact_blocking(contact_with_image)
```

</TabItem>
<TabItem value="typescript">

```typescript
const contactWithDiagnosis = await sdk.contact.modifyContact(
	new DecryptedContact({
		...contactWithImage,
		subContacts: [
			new DecryptedSubContact({
				descr: "Diagnosis",
				healthElementId: createdDiagnosis.id
			})
		]
	})
)
```

</TabItem>
<TabItem value="dart">

```dart
String diagnosis = // This is provided by the user through the UI
final healthElement = DecryptedHealthElement(
	generateUuid(),
	descr: diagnosis
);
final createdDiagnosis = await sdk.healthElement.createHealthElement(
await sdk.healthElement.withEncryptionMetadata(healthElement, patient)
);
contactWithImage.subContacts = {
DecryptedSubContact(
descr: "Diagnosis",
healthElementId: createdDiagnosis.id
)
};
final contactWithDiagnosis = await sdk.contact.modifyContact(contactWithImage);
```

</TabItem>
</LanguageTabs>

## Closing the Examination

To indicate that the medical examination has concluded, you can set the `closingDate` on the corresponding `Contact`.
This action signifies that the data collection session is finished and, ideally, that the `Contact` will not be
modified further.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val finalContact = sdk.contact.modifyContact(
	contactWithDiagnosis.copy(
		closingDate = LocalDateTime.now().format(formatter).toLong()
	)
)
```

</TabItem>
<TabItem value="python">

```python
contact_with_diagnosis.closing_date = int(datetime.now().strftime("%Y%m%d%H%M%S"))
final_contact = sdk.contact.modify_contact_blocking(contact_with_diagnosis)
```

</TabItem>
<TabItem value="typescript">

```typescript
const finalContact = await sdk.contact.modifyContact(
	new DecryptedContact({
		...contactWithDiagnosis,
		closingDate: currentFuzzyDate()
	})
)
```

</TabItem>
<TabItem value="dart">

```dart
contactWithDiagnosis.closingDate = currentDateAsYYYYMMddHHmmSS();
final finalContact = await sdk.contact.modifyContact(contactWithDiagnosis);
```

</TabItem>
</LanguageTabs>

Like `openingDate`, the `closingDate` is an instant, precise to the second, represented in the `YYYYMMDDhhmmss` format.
---
slug: basic-tutorial-search-data
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Search Data

Once an entity (such as a patient or a medical record) is created, you can always retrieve it using its ID.
However, in most cases, you might not have the ID of the entity you need. Therefore, the Cardinal SDK allows you to search
data by their content using filters.

The following examples provide insights into how to search data using the filter mechanism. For a more comprehensive
understanding, check [this how to](/how-to/querying-data).

In the first code snippet, all patients whose name matches the query string provided by the user and who are shared
with the current user will be returned:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
print("Enter a name: ")
val nameToSearch = readln()
val patientIterator = sdk.patient.filterPatientsBy(
	PatientFilters.byNameForSelf(nameToSearch)
)
```

</TabItem>
<TabItem value="python">

```python
name_to_search = input("Enter a name: ")
patient_iterator = sdk.patient.filter_patients_by_blocking(
	PatientFilters.by_name_for_self(name_to_search)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const nameToSearch = await readLn("Enter a name: ")
const patientIterator = await sdk.patient.filterPatientsBy(
	PatientFilters.byNameForSelf(nameToSearch)
)
```

</TabItem>
<TabItem value="dart">

```dart
String nameToSearch = // This is provided by the user through the UI
final patientIterator = await sdk.patient.filterPatientsBy(
	await PatientFilters.byNameForSelf(nameToSearch)
);
```

</TabItem>
</LanguageTabs>

`PatientFilters.byNameForSelf` defines the options used to retrieve the patients, while the `filterPatientsBy` method
is responsible for actually getting them. This method returns an iterator with two methods: `hasNext()`, which returns
`true` if there is at least one more entity available, and `next(X)`, which retrieves up to the next X available
entities, with a minimum of 1.

Here’s an example of how to use this iterator:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
var patient: Patient? = null
while (patientIterator.hasNext() && patient == null) {
	val p = patientIterator.next(1).first()
	prettyPrint(p)
	print("Use this patient? [y/N]: ")
	val use = readln().trim().lowercase() == "y"
	if (use) {
		patient = p
	}
}

if (patient == null) {
	println("No matching patient found")
	return
}
```

</TabItem>
<TabItem value="python">

```python
patient = None
while patient_iterator.has_next_blocking() and patient is None:
	p = patient_iterator.next_blocking(1)[0]
	pretty_print_patient(p)
	use = input("Use this patient? [y/N]: ").strip().lower() == "y"
	if use:
		patient = p

if patient is None:
	print("No matching patient found")
	return
```

</TabItem>
<TabItem value="typescript">

```typescript
let patient: Patient | null = null
while ((await patientIterator.hasNext()) && patient == null) {
	const p = (await patientIterator.next(1))[0]
	prettyPrintPatient(p)
	const use = (await readLn("Use this patient? [y/N]: ")).trim().toLowerCase() === "y"
	if (use) {
		patient = p
	}
}

if (patient == null) {
	console.log("No matching patient found")
	return
}
```

</TabItem>
<TabItem value="dart">

```dart
Patient? patient;
while ((await patientIterator.hasNext()) && patient == null) {
	final p = (await patientIterator.next(1)).first;
	showPatientOnTheUi(p);
	final use = readChoiceOfTheUser();
	if (use) {
		patient = p;
	}
}
```

</TabItem>
</LanguageTabs>

The same logic can be applied to medical data, where you can leverage the
[secret link](/tutorial/basic/modules/basic-tutorial-create-medical-data#initiating-a-medical-examination) between
a patient and another entity:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val contactIterator = sdk.contact.filterContactsBy(
	ContactFilters.byPatientsForSelf(listOf(patient))
)

if (!contactIterator.hasNext()) {
	println("No matching contacts found")
}

while(contactIterator.hasNext()) {
	val contact = contactIterator.next(1).first()
	prettyPrint(contact)
	print("Press enter for next contact")
	readln()
}
```

</TabItem>
<TabItem value="python">

```python
contact_iterator = sdk.contact.filter_contacts_by_blocking(
	ContactFilters.by_patients_for_self([patient])
)

if not contact_iterator.has_next_blocking():
	print("No matching contacts found")

while contact_iterator.has_next_blocking():
	contact = contact_iterator.next_blocking(1)[0]
	pretty_print_contact(contact)
	input("Press enter for next contact")
```

</TabItem>
<TabItem value="typescript">

```typescript
const contactIterator = await sdk.contact.filterContactsBy(
	ContactFilters.byPatientsForSelf([patient])
)

if (!(await contactIterator.hasNext())) {
	console.log("No matching contacts found")
}

while(await contactIterator.hasNext()) {
	const contact = (await contactIterator.next(1))[0]
	prettyPrintContact(contact)
	await readLn("Press enter for next contact")
}
```

</TabItem>
<TabItem value="dart">

```dart
final contactIterator = await sdk.contact.filterContactsBy(
	await ContactFilters.byPatientsForSelf([patient])
);
if (!(await contactIterator.hasNext())) {
	showErrorMessageForNoContactsFound();
}

while(await contactIterator.hasNext()) {
	final contact = (await contactIterator.next(1)).first;
	showContactOnTheUI(contact);
	await waitForUserConfirmationToShowNext();
}
```

</TabItem>
</LanguageTabs>

In this case, the filter method returns all the `Contacts` shared with the current user that have an encrypted link to
one of the `Patients` passed as a parameter.

:::note
Since the link between `Patient` and `Contact` is encrypted, the user must also have access to the `Patient` to use this filter.
:::

As with the previous example, the method returns an iterator that can be used to retrieve all the matching `Contacts`.

The additional information stored in an entity to provide additional context (like the
[identifiers in a Service](/tutorial/basic/modules/basic-tutorial-create-medical-data#creating-scalar-medical-data-blood-pressure))
can also be used for filtering:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
var choice = -1
while (choice < 0 || choice >= 3) {
	println("0. blood pressure")
	println("1. heart rate")
	println("2. x ray")
	print("Enter your choice: ")
	choice = readln().trim().toIntOrNull() ?: 0
}

val identifier = when(choice) {
	0 -> Identifier(system = "cardinal", value = "bloodPressure")
	1 -> Identifier(system = "cardinal", value = "ecg")
	2 -> Identifier(system = "cardinal", value = "xRay")
	else -> throw IllegalArgumentException("Invalid choice")
}

val serviceIterator = sdk.contact.filterServicesBy(
	ServiceFilters.byIdentifiersForSelf(listOf(identifier))
)

if (!serviceIterator.hasNext()) {
	println("No matching services found")
}

while (serviceIterator.hasNext()) {
	val service = serviceIterator.next(1).first()
	prettyPrint(service)
	print("Press enter for next service")
	readln()
}
```

</TabItem>
<TabItem value="python">

```python
choice = -1
while choice < 0 or choice >= 3:
	print("0. blood pressure")
	print("1. heart rate")
	print("2. x ray")
	try:
		choice = int(input("Enter your choice: ").strip())
	except ValueError:
		choice = -1

if choice == 0:
	identifier = Identifier(system="cardinal", value="bloodPressure")
elif choice == 1:
	identifier = Identifier(system="cardinal", value="ecg")
else:
	identifier = Identifier(system="cardinal", value="xRay")

service_iterator = sdk.contact.filter_services_by_blocking(
	ServiceFilters.by_identifiers_for_self([identifier])
)

if not service_iterator.has_next_blocking():
	print("No matching services found")

while service_iterator.has_next_blocking():
	service = service_iterator.next_blocking(1)[0]
	pretty_print_service(service)
	input("Press enter for next service")
```

</TabItem>
<TabItem value="typescript">

```typescript
let choice = -1
while (choice < 0 || choice >= 3) {
	console.log("0. blood pressure")
	console.log("1. heart rate")
	console.log("2. x ray")
	choice = parseInt((await readLn("Enter your choice: ")).trim())
}

let identifier: Identifier
switch (choice) {
	case 0:
		identifier = new Identifier({system: "cardinal", value: "bloodPressure"})
		break
	case 1:
		identifier = new Identifier({system: "cardinal", value: "ecg"})
		break
	default:
		identifier = new Identifier({system: "cardinal", value: "xRay"})
		break
}

const serviceIterator = await sdk.contact.filterServicesBy(
	ServiceFilters.byIdentifiersForSelf([identifier])
)

if (!(await serviceIterator.hasNext())) {
	console.log("No matching services found")
}

while (await serviceIterator.hasNext()) {
	const service = (await serviceIterator.next(1))[0]
	prettyPrintService(service)
	await readLn("Press enter for next service")
}
```

</TabItem>
<TabItem value="dart">

```dart
int choice = readChoiceFromUI();
Identifier identifier;
switch(choice) {
	case 0:
		identifier = Identifier(system: "cardinal", value: "bloodPressure");
	case 1:
		identifier = Identifier(system: "cardinal", value: "ecg");
	case 2:
		identifier = Identifier(system: "cardinal", value: "xRay");
	default:
		throw ArgumentError("Invalid choice");
}

final serviceIterator = await sdk.contact.filterServicesBy(
	await ServiceFilters.byIdentifiersForSelf([identifier])
);

if (!(await serviceIterator.hasNext())) {
	showErrorForNoContactsFound();
}

while (await serviceIterator.hasNext()) {
	final service = (await serviceIterator.next(1)).first;
	showServiceOnUI();
	await readLn("Press enter for next service")
}
```

</TabItem>
</LanguageTabs>

In this example, the filter method returns all the `Services` that have the provided identifier in the `identifiers` filter.
---
slug: basic-tutorial-share-data
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Share Encrypted Data

Sharing a piece of encrypted information means allowing another user to read it by encrypting the
cryptographic key associated with the data using the recipient's key.

:::note
You can only share encrypted data with **Data Owners**, such as Healthcare Parties, Patients, or Devices. Additionally,
the recipient Data Owner must have initialized their cryptographic keys. To initialize the keys, a Data Owner must log
in to the SDK. Therefore, the Data Owner must be associated with a valid user to successfully complete the login and
participate in a data-sharing procedure.
:::

## Share Data with a Healthcare Party

### Share an Existing Entity with a Healthcare Party

For this example, you need another Healthcare Party user. You can create one in the Cockpit by
[following this guide](http://localhost:3000/cockpit/how-to/how-to-manage-hcp).

Once you have created the new user, log in to initialize their cryptographic keys:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
print("Login of the other HCP: ")
val username = readln().trim()
print("Insert the password for this HCP: ")
val otherPassword = readln()
val otherSdk = CardinalSdk.initialize(
	applicationId = null,
	baseUrl = CARDINAL_URL,
	authenticationMethod = AuthenticationMethod.UsingCredentials(
		UsernamePassword(username, otherPassword)
	),
	baseStorage = FileStorageFacade("./scratch/storage")
)
val otherHcp = otherSdk.healthcareParty.getCurrentHealthcareParty()
```

</TabItem>
<TabItem value="python">

```python
username = input("Login of the other hcp: ").strip()
other_password = input("Insert the password for this hcp: ")
other_sdk = CardinalSdk(
	application_id=None,
	baseurl=CARDINAL_URL,
	authentication_method=UsernamePassword(username, other_password),
	storage_facade=FileSystemStorage("./scratch/storage")
)
other_hcp = other_sdk.healthcare_party.get_current_healthcare_party_blocking()
```

</TabItem>
<TabItem value="typescript">

```typescript
const username = (await readLn("Login of the other hcp: ")).trim()
const otherPassword = await readLn("Insert the password for this hcp: ")
const otherSdk = await CardinalSdk.initialize(
	undefined,
	CARDINAL_URL,
	new AuthenticationMethod.UsingCredentials.UsernamePassword(username, otherPassword),
	StorageFacade.usingFileSystem("../scratch/storage")
)
const otherHcp = await otherSdk.healthcareParty.getCurrentHealthcareParty()
```

</TabItem>
<TabItem value="dart">

```dart
final username = getUsernameFromUI();
final otherPassword = getPasswordFromTheUI();
final otherSdk = await CardinalSdk.initialize(
	null,
	cardinalUrl,
	AuthenticationMethod.UsingCredentials(Credentials.UsernamePassword(username, otherPassword)),
	StorageOptions.PlatformDefault
);
final otherHcp = await otherSdk.healthcareParty.getCurrentHealthcareParty();
```

</TabItem>
</LanguageTabs>

Consider a `Document` entity created with the initial Healthcare Party user:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val oldDocument = sdk.document.createDocument(
	DecryptedDocument(
		id = UUID.randomUUID().toString(),
		name = "An important document"
	).let {
		sdk.document.withEncryptionMetadata(it, null)
	}
)
```

</TabItem>
<TabItem value="python">

```python
old_document_without_encryption_meta = DecryptedDocument(
	id=str(uuid.uuid4()),
	name="An important document"
)
old_document = sdk.document.create_document_blocking(
	sdk.document.with_encryption_metadata_blocking(old_document_without_encryption_meta, None)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const oldDocument = await sdk.document.createDocument(
	await sdk.document.withEncryptionMetadata(new DecryptedDocument({
			id: uuid(),
			name: "An important document"
		}),
		null
	)
)
```

</TabItem>
<TabItem value="dart">

```dart
final oldDocument = await sdk.document.createDocument(
	await sdk.document.withEncryptionMetadata(
		DecryptedDocument(
			generateUuid(),
			name: "An important document"
		),
		null
	)
);
```

</TabItem>
</LanguageTabs>

If the other Healthcare Party tries to access it using the ID, the operation will fail with an error:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
try {
	otherSdk.document.getDocument(oldDocument.id)
} catch (e: Exception) {
	println("This means I am not authorized to read the document -> \${e.message}")
}
```

</TabItem>
<TabItem value="python">

```python
try:
	other_sdk.document.get_document_blocking(old_document.id)
except Exception as e:
	print(f"This means I am not authorized to read the document -> {e}")
```

</TabItem>
<TabItem value="typescript">

```typescript
try {
	await otherSdk.document.getDocument(oldDocument.id)
} catch (e) {
	console.error("This means I am not authorized to read the document -> ", e)
}
```

</TabItem>
<TabItem value="dart">

```dart
try {
	await otherSdk.document.getDocument(oldDocument.id);
} on Exception catch (e) {
	print("This means I am not authorized to read the document -> $e")
}
```

</TabItem>
</LanguageTabs>

The initial Healthcare Party can then grant access using the `shareWith` method. This method takes two parameters:
the ID of the recipient Data Owner (i.e., the Healthcare Party, Patient, or Device) and the entity to share:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val updatedDocument = sdk.document.shareWith(
	delegateId = otherHcp.id,
	document = oldDocument
)
```

</TabItem>
<TabItem value="python">

```python
updated_document = sdk.document.share_with_blocking(
	delegate_id=other_hcp.id,
	document=old_document
)
```

</TabItem>
<TabItem value="typescript">

```typescript
updatedDocument = await sdk.document.shareWith(
	otherHcp.id,
	oldDocument
)
```

</TabItem>
<TabItem value="dart">

```dart
final updatedDocument = await sdk.document.shareWith(otherHcp.id, oldDocument);
```

</TabItem>
</LanguageTabs>

At this point, the other Healthcare Party can access the document successfully:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val oldDocumentOtherHcp = otherSdk.document.getDocument(oldDocument.id)
```

</TabItem>
<TabItem value="python">

```python
old_document_other_hcp = other_sdk.document.get_document_blocking(old_document.id)
```

</TabItem>
<TabItem value="typescript">

```typescript
const oldDocumentOtherHcp = await otherSdk.document.getDocument(oldDocument.id)
```

</TabItem>
<TabItem value="dart">

```dart
final oldDocumentOtherHcp = await otherSdk.document.getDocument(oldDocument.id);
```

</TabItem>
</LanguageTabs>

### Share a New Entity with a Healthcare Party

When creating an entity, you can directly specify the other Data Owner to share the entity with by including them when
initializing the encryption metadata:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val newDocument = DecryptedDocument(
	id = UUID.randomUUID().toString(),
	name = "Another important document"
)

val newDocumentWithMetadata = sdk.document.withEncryptionMetadata(
	newDocument,
	null,
	delegates = mapOf(otherHcp.id to AccessLevel.Read)
)

val createdNewDocument = sdk.document.createDocument(newDocumentWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
new_document = DecryptedDocument(
	id=str(uuid.uuid4()),
	name="Another important document"
)
new_document_with_metadata = sdk.document.with_encryption_metadata_blocking(
	new_document,
	None,
	delegates={other_hcp.id: AccessLevel.Read}
)
created_new_document = sdk.document.create_document_blocking(new_document_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const newDocument = new DecryptedDocument({
	id: uuid(),
	name: "Another important document"
})
const newDocumentWithMetadata = await sdk.document.withEncryptionMetadata(
	newDocument,
	null,
	{ delegates: { [otherHcp.id]:  AccessLevel.Read } }
)
const createdNewDocument = await sdk.document.createDocument(newDocumentWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final newDocument = DecryptedDocument(
	generateUuid(),
	name: "Another important document"
);
final newDocumentWithMetadata = await sdk.document.withEncryptionMetadata(
	newDocument,
	null,
	delegates: { otherHcp.id: AccessLevel.read }
);
final createdNewDocument = await sdk.document.createDocument(newDocumentWithMetadata);
```

</TabItem>
</LanguageTabs>

The other Healthcare Party is a delegate for the new `Document` with Read permissions. This means they can access the
entity and read the encrypted information but cannot modify it:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val newDocumentOtherHcp = otherSdk.document.getDocument(createdNewDocument.id)
```

</TabItem>
<TabItem value="python">

```python
new_document_other_hcp = other_sdk.document.get_document_blocking(created_new_document.id)
```

</TabItem>
<TabItem value="typescript">

```typescript
const newDocumentOtherHcp = await otherSdk.document.getDocument(createdNewDocument.id)
```

</TabItem>
<TabItem value="dart">

```dart
final newDocumentOtherHcp = await otherSdk.document.getDocument(createdNewDocument.id)
```

</TabItem>
</LanguageTabs>

## Share Data with a Patient

The flow to share data with a Patient user is the same as to share data with a Healthcare Party user. However, it is
not possible to initialize a Patient User using the Cockpit.

To create a Patient user, you first need to create a Patient:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val newPatient = DecryptedPatient(
	id = UUID.randomUUID().toString(),
	firstName = "Edmond",
	lastName = "Dantes",
)
val patientWithMetadata = sdk.patient.withEncryptionMetadata(newPatient)
val createdPatient = sdk.patient.createPatient(patientWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
new_patient = DecryptedPatient(
	id=str(uuid.uuid4()),
	first_name="Edmond",
	last_name="Dantes",
)
patient_with_metadata = sdk.patient.with_encryption_metadata_blocking(new_patient)
created_patient = sdk.patient.create_patient_blocking(patient_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const newPatient = new DecryptedPatient({
	id: uuid(),
	firstName: "Edmond",
	lastName: "Dantes",
})
const patientWithMetadata = await sdk.patient.withEncryptionMetadata(newPatient)
const createdPatient = await sdk.patient.createPatient(patientWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final newPatient = DecryptedPatient(
	generateUuid(),
	firstName: "Edmond",
	lastName: "Dantes",
);
final patientWithMetadata = await sdk.patient.withEncryptionMetadata(newPatient);
final createdPatient = await sdk.patient.createPatient(patientWithMetadata);
```

</TabItem>
</LanguageTabs>

Then, you need to create a User for that Patient. You can link the User to the Patient by setting the `patientId`
property on the User to the id of the newly created Patient.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val login = "edmond.dantes.${UUID.randomUUID().toString().substring(0, 6)}@icure.com"
val patientUser = User(
	id = UUID.randomUUID().toString(),
	patientId = createdPatient.id,
	login = login,
	email = login
)
val createdUser = sdk.user.createUser(patientUser)
```

</TabItem>
<TabItem value="python">

```python
login = f"edmond.dantes.{str(uuid.uuid4())[0:6]}@icure.com"
patient_user = User(
	id=str(uuid.uuid4()),
	patient_id=created_patient.id,
	login=login,
	email=login
)
created_user = sdk.user.create_user_blocking(patient_user)
```

</TabItem>
<TabItem value="typescript">

```typescript
const login = `edmond.dantes.${uuid().substring(0, 6)}@icure.com`
const patientUser = new User({
	id: uuid(),
	patientId: createdPatient.id,
	login: login,
	email: login
})
const createdUser = await sdk.user.createUser(patientUser)
```

</TabItem>
<TabItem value="dart">

```dart
final login = "edmond.dantes.${generateUuid().substring(0, 6)}@icure.com";
final patientUser = User(
	generateUuid(),
	patientId: createdPatient.id,
	login: login,
	email: login
);
final createdUser = await sdk.user.createUser(patientUser);
```

</TabItem>
</LanguageTabs>

Finally, you have to create a temporary access token for the User, so that they can log in.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val loginToken = sdk.user.getToken(createdUser.id, "login")
```

</TabItem>
<TabItem value="python">

```python
login_token = sdk.user.get_token_blocking(created_user.id, "login")
```

</TabItem>
<TabItem value="typescript">

```typescript
const loginToken = await sdk.user.getToken(createdUser.id, "login")
```

</TabItem>
<TabItem value="dart">

```dart
final loginToken = await sdk.user.getToken(createdUser.id, "login");
```

</TabItem>
</LanguageTabs>

Now, the User can log in to the SDK, initializing their cryptographic keys:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
CardinalSdk.initialize(
	applicationId = null,
	baseUrl = CARDINAL_URL,
	authenticationMethod = AuthenticationMethod.UsingCredentials(
		UsernamePassword(login, loginToken)
	),
	baseStorage = FileStorageFacade("./scratch/storage")
)
```

</TabItem>
<TabItem value="python">

```python
CardinalSdk(
	application_id=None,
	baseurl=CARDINAL_URL,
	authentication_method=UsernamePassword(login, login_token),
	storage_facade=FileSystemStorage("./scratch/storage")
)
```

</TabItem>
<TabItem value="typescript">

```typescript
await CardinalSdk.initialize(
	undefined,
	CARDINAL_URL,
	new AuthenticationMethod.UsingCredentials.UsernamePassword(login, loginToken),
	StorageFacade.usingFileSystem("../scratch/storage")
)
```

</TabItem>
<TabItem value="dart">

```dart
await CardinalSdk.initialize(
	null,
	cardinalUrl,
	AuthenticationMethod.UsingCredentials(Credentials.UsernamePassword(login, loginToken)),
	StorageOptions.PlatformDefault
);
```

</TabItem>
</LanguageTabs>

However, the Patient User cannot access itself, as the Patient entity could not be shared with them as the
cryptographic keys were not initialized yet. Now that they are, the Healthcare Party that is managing this registration
can share the Patient:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val patient = sdk.patient.shareWith(
	delegateId = createdPatient.id,
	patient = createdPatient,
	options = PatientShareOptions(
		shareSecretIds = SecretIdShareOptions.AllAvailable(true),
		shareEncryptionKey = ShareMetadataBehaviour.IfAvailable,
		requestedPermissions = RequestedPermission.MaxWrite
	)
)
```

</TabItem>
<TabItem value="python">

```python
patient = sdk.patient.share_with_blocking(
	delegate_id=created_patient.id,
	patient=created_patient,
	options=PatientShareOptions(
		share_secret_ids=SecretIdShareOptionsAllAvailable(True),
		share_encryption_key=ShareMetadataBehaviour.IfAvailable,
		requested_permissions=RequestedPermission.MaxWrite
	)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const patient = await sdk.patient.shareWith(
	createdPatient.id,
	createdPatient,
	{
		options: new PatientShareOptions({
			shareSecretIds: new SecretIdShareOptions.AllAvailable({requireAtLeastOne: true}),
			shareEncryptionKey: ShareMetadataBehaviour.IfAvailable,
			requestedPermissions: RequestedPermission.MaxWrite
		})
	}
)
```

</TabItem>
<TabItem value="dart">

```dart
const patient = await sdk.patient.shareWith(
	createdPatient.id,
	createdPatient,
	{
		options: new PatientShareOptions({
			shareSecretIds: new SecretIdShareOptions.AllAvailable({requireAtLeastOne: true}),
			shareEncryptionKey: ShareMetadataBehaviour.IfAvailable,
			requestedPermissions: RequestedPermission.MaxWrite
		})
	}
)
```

</TabItem>
</LanguageTabs>

:::note
A user that acts as a patient must be able to access their own patient entity to create, read, and share data
through Cardinal.
:::
Now, the Patient can finally log in and have access to their full information:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val patientSdk = CardinalSdk.initialize(
	applicationId = null,
	baseUrl = CARDINAL_URL,
	authenticationMethod = AuthenticationMethod.UsingCredentials(
		UsernamePassword(login, loginToken)
	),
	baseStorage = FileStorageFacade("./scratch/storage")
)
```

</TabItem>
<TabItem value="python">

```python
patient_sdk = CardinalSdk(
	application_id=None,
	baseurl=CARDINAL_URL,
	authentication_method=UsernamePassword(login, login_token),
	storage_facade=FileSystemStorage("./scratch/storage")
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const patientSdk = await CardinalSdk.initialize(
	undefined,
	CARDINAL_URL,
	new AuthenticationMethod.UsingCredentials.UsernamePassword(login, loginToken),
	StorageFacade.usingFileSystem("../scratch/storage")
)
```

</TabItem>
<TabItem value="dart">

```dart
const patientSdk = await CardinalSdk.initialize(
	null,
	cardinalUrl,
	AuthenticationMethod.UsingCredentials(Credentials.UsernamePassword(login, loginToken)),
	StorageOptions.PlatformDefault
);
```

</TabItem>
</LanguageTabs>

:::caution
This registration flow makes sense only in the context of this example, to make it self-contained.
To learn how to register a Patient in a real context, check [this how to](/how-to/registering-users).
:::

### Share an Existing Entity with a Patient

Sharing an entity with a Patient follows the same flow as sharing with a Healthcare Party. First, the Healthcare Party
needs to create an entity, such as a `HealthElement`, to represent a medical condition or prolonged context:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val healthElement = DecryptedHealthElement(
	id = UUID.randomUUID().toString(),
	descr = "This is some medical context"
)

val healthElementWithMetadata = sdk.healthElement.withEncryptionMetadata(healthElement, patient)
val createdHealthElement = sdk.healthElement.createHealthElement(healthElementWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
health_element = DecryptedHealthElement(
	id=str(uuid.uuid4()),
	descr="This is some medical context"
)
health_element_with_metadata = sdk.health_element.with_encryption_metadata_blocking(health_element, patient)
created_health_element = sdk.health_element.create_health_element_blocking(health_element_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const healthElement = new DecryptedHealthElement({
	id: uuid(),
	descr: "This is some medical context"
})
const healthElementWithMetadata = await sdk.healthElement.withEncryptionMetadata(healthElement, patient)
const createdHealthElement = await sdk.healthElement.createHealthElement(healthElementWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final healthElement = DecryptedHealthElement(
	generateUuid(),
	descr: "This is some medical context"
);
final healthElementWithMetadata = await sdk.healthElement.withEncryptionMetadata(healthElement, patient);
final createdHealthElement = await sdk.healthElement.createHealthElement(healthElementWithMetadata);
```

</TabItem>
</LanguageTabs>

It is important to note that even though the `HealthElement` is linked to the patient by the encryption metadata,
the Patient does not yet have the right to access it:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
try {
	patientSdk.healthElement.getHealthElement(createdHealthElement.id)
} catch (e: Exception) {
	println("This means the patient cannot access this health element -> \${e.message}")
}
```

</TabItem>
<TabItem value="python">

```python
try:
	patient_sdk.health_element.get_health_element_blocking(created_health_element.id)
except Exception as e:
	print(f"This means the patient cannot get this health element -> {e}")
```

</TabItem>
<TabItem value="typescript">

```typescript
try {
	await patientSdk.healthElement.getHealthElement(createdHealthElement.id)
} catch (e) {
	console.error("This means the patient cannot get this health element", e)
}
```

</TabItem>
<TabItem value="dart">

```dart
try {
	await patientSdk.healthElement.getHealthElement(createdHealthElement.id);
} catch (e) {
	print("This means the patient cannot get this health element -> $e");
}
```

</TabItem>
</LanguageTabs>

Next, the Healthcare Party can share the entity with the Patient:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val healthElement = sdk.healthElement.shareWith(
	delegateId = patient.id,
	healthElement = createdHealthElement
)
```

</TabItem>
<TabItem value="python">

```python
health_element = sdk.health_element.share_with_blocking(
	delegate_id=patient.id,
	health_element=created_health_element
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const healthElement = await sdk.healthElement.shareWith(
	patient.id,
	createdHealthElement
)
```

</TabItem>
<TabItem value="dart">

```dart
final healthElement = await sdk.healthElement.shareWith(patient.id, createdHealthElement);
```

</TabItem>
</LanguageTabs>

Finally, the Patient can access it:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
patientSdk.healthElement.getHealthElement(createdHealthElement.id)
```

</TabItem>
<TabItem value="python">

```python
patient_sdk.health_element.get_health_element_blocking(created_health_element.id)
```

</TabItem>
<TabItem value="typescript">

```typescript
await patientSdk.healthElement.getHealthElement(createdHealthElement.id)
```

</TabItem>
<TabItem value="dart">

```dart
await patientSdk.healthElement.getHealthElement(createdHealthElement.id);
```

</TabItem>
</LanguageTabs>

### Share a New Entity with a Patient

As with the Healthcare Party case, a Patient can be directly included in the delegations of the encryption metadata for
a newly created entity.

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val newHealthElement = DecryptedHealthElement(
	id = UUID.randomUUID().toString(),
	descr = "This is some other medical context"
)

val newHealthElementWithMetadata = sdk.healthElement.withEncryptionMetadata(
	newHealthElement,
	patient,
	delegates = mapOf(patient.id to AccessLevel.Write)
)

val newCreatedHealthElement = sdk.healthElement.createHealthElement(newHealthElementWithMetadata)
```

</TabItem>
<TabItem value="python">

```python
new_health_element = DecryptedHealthElement(
	id=str(uuid.uuid4()),
	descr="This is some other medical context"
)
new_health_element_with_metadata = sdk.health_element.with_encryption_metadata_blocking(
	new_health_element,
	patient,
	delegates={patient.id: AccessLevel.Write}
)
new_created_health_element = sdk.health_element.create_health_element_blocking(new_health_element_with_metadata)
```

</TabItem>
<TabItem value="typescript">

```typescript
const newHealthElement = new DecryptedHealthElement({
	id: uuid(),
	descr: "This is some other medical context"
})
const newHealthElementWithMetadata = await sdk.healthElement.withEncryptionMetadata(
	newHealthElement,
	patient,
	{ delegates: { [patient.id]: AccessLevel.Write } }
)
const newCreatedHealthElement = await sdk.healthElement.createHealthElement(newHealthElementWithMetadata)
```

</TabItem>
<TabItem value="dart">

```dart
final newHealthElement = DecryptedHealthElement(
	generateUuid(),
	descr: "This is some other medical context"
);
final newHealthElementWithMetadata = await sdk.healthElement.withEncryptionMetadata(
	newHealthElement,
	patient,
	delegates: { patient.id: AccessLevel.write }
);
final newCreatedHealthElement = await sdk.healthElement.createHealthElement(newHealthElementWithMetadata);
```

</TabItem>
</LanguageTabs>

It is important to note that the Patient linked to an entity is entirely separate from a patient with a delegation for
the entity: setting up a delegation does not create a link between the patient and the entity,
and creating the link does not set up a delegation.

Now, the Patient has read and write access to the entity and can directly retrieve it:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val retrievedHealthElement = patientSdk.healthElement.getHealthElement(newCreatedHealthElement.id)
```

</TabItem>
<TabItem value="python">

```python
retrieved_health_element = patient_sdk.health_element.get_health_element_blocking(new_created_health_element.id)
```

</TabItem>
<TabItem value="typescript">

```typescript
const retrievedHealthElement = await patientSdk.healthElement.getHealthElement(newCreatedHealthElement.id)
```

</TabItem>
<TabItem value="dart">

```dart
final retrievedHealthElement = await patientSdk.healthElement.getHealthElement(newCreatedHealthElement.id)
```

</TabItem>
</LanguageTabs>
---
slug: basic-tutorial-codifications
---

import {LanguageTabs} from "@site/src/components/LanguageTabs";
import TabItem from "@theme/TabItem";

# Use Codification Systems

Codifications like [SNOMED CT](https://www.snomed.org/what-is-snomed-ct), [ICD-10](https://icd.who.int/browse10/2019/en),
or [LOINC](https://loinc.org/) are used to express medical concepts in a formal and unambiguous way.

In Cardinal, codifications are represented through the `Code` entity, which can also be used to represent internal
codification systems:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
sdk.code.createCode(Code(
	id = "INTERNAL|ANALYSIS|1",
	type = "INTERNAL",
	code = "ANALYSIS",
	version = "1",
	label = mapOf("en" to "Internal analysis code")
))

sdk.code.createCodes(listOf(
	Code(
		id = "SNOMED|45007003|1",
		type = "SNOMED",
		code = "45007003",
		version = "1",
		label = mapOf("en" to "Low blood pressure")
	),
	Code(
		id = "SNOMED|38341003|1",
		type = "SNOMED",
		code = "38341003",
		version = "1",
		label = mapOf("en" to "High blood pressure")
	),
	Code(
		id = "SNOMED|2004005|1",
		type = "SNOMED",
		code = "2004005",
		version = "1",
		label = mapOf("en" to "Normal blood pressure")
	)
))
```

</TabItem>
<TabItem value="python">

```python
internal_code = sdk.code.create_code_blocking(
	Code(
		id="INTERNAL|ANALYSIS|1",
		type="INTERNAL",
		code="ANALYSIS",
		version="1",
		label={"en": "Internal analysis code"}
	)
)

sdk.code.create_codes_blocking(
	Code(
		id="SNOMED|45007003|1",
		type="SNOMED",
		code="45007003",
		version="1",
		label={"en": "Low blood pressure"}
	),
	Code(
		id="SNOMED|38341003|1",
		type="SNOMED",
		code="38341003",
		version="1",
		label={"en": "High blood pressure"}
	),
	Code(
		id="SNOMED|2004005|1",
		type="SNOMED",
		code="2004005",
		version="1",
		label={"en": "Normal blood pressure"}
	)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const internalCode = await sdk.code.createCode(new Code({
	id: "INTERNAL|ANALYSIS|1",
	type: "INTERNAL",
	code: "ANALYSIS",
	version: "1",
	label: {"en": "Internal analysis code"}
}))
await sdk.code.createCodes([
	new Code({
		id: "SNOMED|45007003|1",
		type: "SNOMED",
		code: "45007003",
		version: "1",
		label: {"en": "Low blood pressure"}
	}),
	new Code({
		id: "SNOMED|38341003|1",
		type: "SNOMED",
		code: "38341003",
		version: "1",
		label: {"en": "High blood pressure"}
	}),
	new Code({
		id: "SNOMED|2004005|1",
		type: "SNOMED",
		code: "2004005",
		version: "1",
		label: {"en": "Normal blood pressure"}
	})
])
```

</TabItem>
<TabItem value="dart">

```dart
await sdk.code.createCode(Code(
	"INTERNAL|ANALYSIS|1",
	type: "INTERNAL",
	code: "ANALYSIS",
	version: "1",
	label: {"en": "Internal analysis code"}
));
await sdk.code.createCodes([
	Code(
		"SNOMED|45007003|1",
		type: "SNOMED",
		code: "45007003",
		version: "1",
		label: {"en": "Low blood pressure"}
	),
	Code(
		"SNOMED|38341003|1",
		type: "SNOMED",
		code: "38341003",
		version: "1",
		label: {"en": "High blood pressure"}
	),
	Code(
		"SNOMED|2004005|1",
		type: "SNOMED",
		code: "2004005",
		version: "1",
		label: {"en": "Normal blood pressure"}
	)
]);
```

</TabItem>
</LanguageTabs>

:::note
The codification systems are supported, but the codes themselves are not present by default in the cloud.
:::

A `Code` is defined by three properties:
- `type`: Represents the codification system the code belongs to.
- `code`: Represents the unique ID of the code within the codification system.
- `version`: Allows versioning of the code, enabling the maintenance of both old and new versions when something in the
  `Code` is updated (such as the label or metadata). In this case, a new `Code` entity is created with the updated content
  and a new version.

A `Code` is uniquely identified by the `type`, `code`, `version` triple, so the ID of a `Code` is not a UUID but rather
the string `type|code|version`.

A `Code` can be used to add additional context to other entities. In the following example, it is used to add a tag to
a `Service`.

Like other entities, it is possible to search code to facilitate the retrieval: for example, it is possible to retrieve
codes of a certain type searching for a word that is present in the label for a specific language:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val codeIterator = sdk.code.filterCodesBy(
	CodeFilters.byLanguageTypeLabelRegion(
		language = "en",
		label = "blood",
		type = "SNOMED"
	)
)

var selectedCode: Code? = null
while (codeIterator.hasNext() && selectedCode == null) {
	val code = codeIterator.next(1).first()
	prettyPrint(code)
	print("Use this code? [y/N]: ")
	val use = readln().trim().lowercase() == "y"
	if (use) {
		selectedCode = code
	}
}

val patient = sdk.patient.createPatient(
	DecryptedPatient(
		id = UUID.randomUUID().toString(),
		firstName = "Annabelle",
		lastName = "Hall",
	).let { sdk.patient.withEncryptionMetadata(it) }
)

val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
val contact = DecryptedContact(
	id = UUID.randomUUID().toString(),
	descr = "Blood pressure measurement",
	openingDate = LocalDateTime.now().format(formatter).toLong(),
	services = setOf(
		DecryptedService(
			id = UUID.randomUUID().toString(),
			label = "Blood pressure",
			content = mapOf(
				"en" to DecryptedContent(
					measureValue = Measure(
						value = Random.nextInt(80, 120).toDouble(),
						unit = "mmHg"
					)
				)
			),
			tags = setOf(
				CodeStub(
					id = selectedCode.id,
					type = selectedCode.type,
					code = selectedCode.code,
					version = selectedCode.version
				)
			)
		)
	)
)

val createdContact = sdk.contact.createContact(
	sdk.contact.withEncryptionMetadata(contact, patient)
)
```

</TabItem>
<TabItem value="python">

```python
code_iterator = sdk.code.filter_codes_by_blocking(
	CodeFilters.by_language_type_label_region(
		language="en",
		label="blood",
		type="SNOMED"
	)
)

selected_code = None
while selected_code is None and code_iterator.has_next_blocking():
	code = code_iterator.next_blocking(1)[0]
	pretty_print_code(code)
	choice = input("Use this code [y/N]: ")
	if choice.lower() == "y":
		selected_code = code
		break

patient = sdk.patient.create_patient_blocking(
	sdk.patient.with_encryption_metadata_blocking(
		DecryptedPatient(
			id=str(uuid.uuid4()),
			first_name="Annabelle",
			last_name="Hall"
		)
	)
)

contact = DecryptedContact(
	id=str(uuid.uuid4()),
	descr="Blood pressure measurement",
	opening_date=int(datetime.now().strftime("%Y%m%d%H%M%S")),
	services=[
		DecryptedService(
			id=str(uuid.uuid4()),
			label="Blood pressure",
			content={
				"en": DecryptedContent(
					measure_value=Measure(
						value=float(random.randint(80, 120)),
						unit="mmHg"
					)
				)
			},
			tags=[
				CodeStub(
					id=selected_code.id,
					type=selected_code.type,
					code=selected_code.code,
					version=selected_code.version
				)
			]
		)
	]
)
created_contact = sdk.contact.create_contact_blocking(
	sdk.contact.with_encryption_metadata_blocking(contact, patient)
)
```

</TabItem>
<TabItem value="typescript">

```typescript
const codeIterator = await sdk.code.filterCodesBy(
	CodeFilters.byLanguageTypeLabelRegion(
		"en",
		"SNOMED",
		{ label: "blood" }
	)
)

let selectedCode: Code | null = null
while ((await codeIterator.hasNext()) && selectedCode == null) {
	const code = (await codeIterator.next(1))[0]
	prettyPrintCode(code)
	const use = (await readLn("Use this code? [y/N]: ")).trim().toLowerCase() === "y"
	if (use) {
		selectedCode = code
	}
}

if (selectedCode == null) {
	console.log("No code was selected")
	return
}

const patient = await sdk.patient.createPatient(
	await sdk.patient.withEncryptionMetadata(
		new DecryptedPatient({
			id: uuid(),
			firstName: "Annabelle",
			lastName: "Hall",
		})
	)
)

const contact = new DecryptedContact({
	id: uuid(),
	descr: "Blood pressure measurement",
	openingDate: currentFuzzyDate(),
	services: [
		new DecryptedService({
			id: uuid(),
			label: "Blood pressure",
			content: {
				"en": new DecryptedContent({
					measureValue: new Measure({
						value: random(80, 120),
						unit: "mmHg"
					})
				})
			}
		})
	],
	tags: [
		new CodeStub({
			id: selectedCode.id,
			type: selectedCode.type,
			code: selectedCode.code,
			version: selectedCode.version
		})
	]
})
const createdContact = await sdk.contact.createContact(
	await sdk.contact.withEncryptionMetadata(contact, patient)
)
```

</TabItem>
<TabItem value="dart">

```dart
final codeIterator = await sdk.code.filterCodesBy(
	await CodeFilters.byLanguageTypeLabelRegion(
		"en",
		"SNOMED",
		label: "blood",
	)
);

Code? selectedCode;
while ((await codeIterator.hasNext()) && selectedCode == null) {
	final code = (await codeIterator.next(1)).first;
	displayCodeOnTheUI(code);
	final use = await checkForUserConfirmation();
	if (use) {
		selectedCode = code;
	}
}

final patient = await sdk.patient.createPatient(
	await sdk.patient.withEncryptionMetadata(
		DecryptedPatient(
			generateUuid(),
			firstName: "Annabelle",
			lastName: "Hall",
		)
	)
);

final contact = DecryptedContact(
	generateUuid(),
	descr: "Blood pressure measurement",
	openingDate: currentDateAsYYYYMMddHHmmSS(),
	services: {
		DecryptedService(
			generateUuid(),
			label: "Blood pressure",
			content: {
				"en": DecryptedContent(
					measureValue: Measure(
						value: (80 + Random().nextInt(41)).toDouble(),
						unit: "mmHg"
					)
				)
			},
			tags: {
				CodeStub(
					id: selectedCode.id,
					type: selectedCode.type,
					code: selectedCode.code,
					version: selectedCode.version
				)
			}
		)
	}
);
final createdContact = await sdk.contact.createContact(
	await sdk.contact.withEncryptionMetadata(contact, patient)
);
```

</TabItem>
</LanguageTabs>

In this snippet, the user can choose a `Code` from all the SNOMED codes that contain the word "blood"  in their label
in English. Then, a `Contact` is created that contains a `Service` for a blood pressure measurement, and a tag is added
for the SNOMED code of high, low, or normal blood pressure as a `CodeStub`, a reference to a `Code` that
includes only the `type`, `code`, and `version`.

`Codes` can also be used to filter entities:

<LanguageTabs>
<TabItem value="kotlin">

```kotlin
val serviceIterator = sdk.contact.filterServicesBy(
	ServiceFilters.byTagAndValueDateForSelf(
		tagType = selectedCode.type,
		tagCode = selectedCode.code
	)
)

println("Result of searching by code: \${selectedCode.id}")
while (serviceIterator.hasNext()) {
	val service = serviceIterator.next(1).first()
	prettyPrint(service)
}
```

</TabItem>
<TabItem value="python">

```python
service_iterator = sdk.contact.filter_services_by_blocking(
	ServiceFilters.by_tag_and_value_date_for_self(
		tag_type=selected_code.type,
		tag_code=selected_code.code
	)
)
print(f"Result of searching Services by code: {selected_code.id}")
while service_iterator.has_next_blocking():
	service = service_iterator.next_blocking(1)[0]
	pretty_print_service(service)
```

</TabItem>
<TabItem value="typescript">

```typescript
const serviceIterator = await sdk.contact.filterServicesBy(
	ServiceFilters.byTagAndValueDateForSelf(
		selectedCode.type,
		{ tagCode: selectedCode.code }
	)
)

console.log(`Result of searching Services by code: ${selectedCode.id}`)
while (await serviceIterator.hasNext()) {
	const service = (await serviceIterator.next(1))[0]
	prettyPrintService(service)
}
```

</TabItem>
<TabItem value="dart">

```dart
final serviceIterator = await sdk.contact.filterServicesBy(
	await ServiceFilters.byTagAndValueDateForSelf(
		selectedCode.type!,
		tagCode: selectedCode.code
	)
);

while (await serviceIterator.hasNext()) {
	final service = (await serviceIterator.next(1)).first;
	displayServiceToUI(service);
}
```

</TabItem>
</LanguageTabs>

This example shows how to retrieve all the `Services` that have a tag with the specified `type` and `code` and are
shared with the current user.
