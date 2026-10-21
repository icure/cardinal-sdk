// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.DataOwnerWithType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerWithType_toJs(obj: DataOwnerWithType): DataOwnerWithTypeJs = when (obj) {
	is DataOwnerWithType.HcpDataOwner -> dataOwnerWithType_HcpDataOwner_toJs(obj)
	is DataOwnerWithType.PatientDataOwner -> dataOwnerWithType_PatientDataOwner_toJs(obj)
	is DataOwnerWithType.DeviceDataOwner -> dataOwnerWithType_DeviceDataOwner_toJs(obj)
}

public fun dataOwnerWithType_fromJs(obj: DataOwnerWithTypeJs): DataOwnerWithType = when {
	obj is DataOwnerWithTypeJs_HcpDataOwnerJs || obj.ktClass == "com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner" ->dataOwnerWithType_HcpDataOwner_fromJs(obj as com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs_HcpDataOwnerJs)
	obj is DataOwnerWithTypeJs_PatientDataOwnerJs || obj.ktClass == "com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner" ->dataOwnerWithType_PatientDataOwner_fromJs(obj as com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs_PatientDataOwnerJs)
	obj is DataOwnerWithTypeJs_DeviceDataOwnerJs || obj.ktClass == "com.icure.cardinal.sdk.model.DataOwnerWithType.DeviceDataOwner" ->dataOwnerWithType_DeviceDataOwner_fromJs(obj as com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs_DeviceDataOwnerJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.DataOwnerWithType: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerWithType_HcpDataOwner_toJs(obj: DataOwnerWithType.HcpDataOwner): DataOwnerWithTypeJs_HcpDataOwnerJs {
	val dataOwner = healthcareParty_toJs(obj.dataOwner)
	return DataOwnerWithTypeJs_HcpDataOwnerJs(js("{" +
		"dataOwner:dataOwner" +
	"}"))
}

public fun dataOwnerWithType_HcpDataOwner_fromJs(obj: DataOwnerWithTypeJs_HcpDataOwnerJs): DataOwnerWithType.HcpDataOwner {
	val dataOwner = healthcareParty_fromJs(obj.dataOwner)
	return DataOwnerWithType.HcpDataOwner(
		dataOwner = dataOwner,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerWithType_PatientDataOwner_toJs(obj: DataOwnerWithType.PatientDataOwner): DataOwnerWithTypeJs_PatientDataOwnerJs {
	val dataOwner = patient_toJs(obj.dataOwner)
	return DataOwnerWithTypeJs_PatientDataOwnerJs(js("{" +
		"dataOwner:dataOwner" +
	"}"))
}

public fun dataOwnerWithType_PatientDataOwner_fromJs(obj: DataOwnerWithTypeJs_PatientDataOwnerJs): DataOwnerWithType.PatientDataOwner {
	val dataOwner = patient_fromJs(obj.dataOwner)
	return DataOwnerWithType.PatientDataOwner(
		dataOwner = dataOwner,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerWithType_DeviceDataOwner_toJs(obj: DataOwnerWithType.DeviceDataOwner): DataOwnerWithTypeJs_DeviceDataOwnerJs {
	val dataOwner = device_toJs(obj.dataOwner)
	return DataOwnerWithTypeJs_DeviceDataOwnerJs(js("{" +
		"dataOwner:dataOwner" +
	"}"))
}

public fun dataOwnerWithType_DeviceDataOwner_fromJs(obj: DataOwnerWithTypeJs_DeviceDataOwnerJs): DataOwnerWithType.DeviceDataOwner {
	val dataOwner = device_fromJs(obj.dataOwner)
	return DataOwnerWithType.DeviceDataOwner(
		dataOwner = dataOwner,
	)
}
