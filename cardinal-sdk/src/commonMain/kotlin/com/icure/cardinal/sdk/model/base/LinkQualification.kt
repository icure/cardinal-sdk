package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class LinkQualification(
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
