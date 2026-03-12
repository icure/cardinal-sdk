// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  The qualification of a link between two concepts
 *
 *  - [narrower] means that the linked codes have a narrower interpretation
 *  - [parent] means that the linked code(s) is the parent of this code
 *  - [sequence] means that the linked codes are a sequence of codes that are part of the current
 * code
 *  - [basedOn] means a plan, proposal or order that is fulfilled in whole or in part by this event.
 * For example, a MedicationRequest may require a patient to have laboratory test performed before it
 * is dispensed.
 *  - [derivedFrom] means the target resource that represents a measurement from which the service
 * value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound
 * image.
 *  - [device] means the device used to generate the service data
 *  - [focus] means the actual focus of a service when it is not the patient of record representing
 * something or someone associated with the patient such as a spouse, parent, fetus, or donor. For
 * example, fetus observations in a mother's record.
 *  - [hasMember] means this service is a group service (e.g. a battery, a panel of tests, a set of
 * vital sign measurements) that includes the target as a member of the group
 *  - [performer] means who was responsible for asserting the observed value as "true".
 *  - [specimen] means the specimen that was used when this service was made
 *  - [request] why the specimen was collected
 *
 *  When creating a link, we encourage creating single direction links. The reverse link can be
 * found through a view
 *
 *  Favour parent over child as it is better (for conflicts) to change 5 different documents once
 * instead of changing 5 times the same document
 */
@Serializable
enum class LinkQualification(
	internal val dtoSerialName: String,
) {
	@SerialName("exact")
	Exact("exact"),

	@SerialName("narrower")
	Narrower("narrower"),

	@SerialName("broader")
	Broader("broader"),

	@SerialName("approximate")
	Approximate("approximate"),

	@SerialName("sequence")
	Sequence("sequence"),

	@SerialName("parent")
	Parent("parent"),

	@SerialName("child")
	Child("child"),

	@SerialName("relatedCode")
	RelatedCode("relatedCode"),

	@SerialName("linkedPackage")
	LinkedPackage("linkedPackage"),

	@SerialName("relatedService")
	RelatedService("relatedService"),

	@SerialName("inResponseTo")
	InResponseTo("inResponseTo"),

	@SerialName("replaces")
	Replaces("replaces"),

	@SerialName("transforms")
	Transforms("transforms"),

	@SerialName("transformsAndReplaces")
	TransformsAndReplaces("transformsAndReplaces"),

	@SerialName("appendsTo")
	AppendsTo("appendsTo"),

	@SerialName("basedOn")
	BasedOn("basedOn"),

	@SerialName("derivedFrom")
	DerivedFrom("derivedFrom"),

	@SerialName("device")
	Device("device"),

	@SerialName("focus")
	Focus("focus"),

	@SerialName("hasMember")
	HasMember("hasMember"),

	@SerialName("performer")
	Performer("performer"),

	@SerialName("specimen")
	Specimen("specimen"),

	@SerialName("resultInterpreter")
	ResultInterpreter("resultInterpreter"),

	@SerialName("request")
	Request("request"),
}
