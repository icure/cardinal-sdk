// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.model.embed.form.template.CheckBox
import com.icure.cardinal.sdk.model.embed.form.template.DatePicker
import com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker
import com.icure.cardinal.sdk.model.embed.form.template.DropdownField
import com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup
import com.icure.cardinal.sdk.model.embed.form.template.MeasureField
import com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice
import com.icure.cardinal.sdk.model.embed.form.template.NumberField
import com.icure.cardinal.sdk.model.embed.form.template.RadioButton
import com.icure.cardinal.sdk.model.embed.form.template.StructureElement
import com.icure.cardinal.sdk.model.embed.form.template.TextField
import com.icure.cardinal.sdk.model.embed.form.template.TimePicker
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun structureElement_toJs(obj: StructureElement): StructureElementJs = when (obj) {
	is DropdownField -> dropdownField_toJs(obj)
	is RadioButton -> radioButton_toJs(obj)
	is DatePicker -> datePicker_toJs(obj)
	is TimePicker -> timePicker_toJs(obj)
	is DateTimePicker -> dateTimePicker_toJs(obj)
	is NumberField -> numberField_toJs(obj)
	is TextField -> textField_toJs(obj)
	is CheckBox -> checkBox_toJs(obj)
	is MultipleChoice -> multipleChoice_toJs(obj)
	is MeasureField -> measureField_toJs(obj)
	is FieldsGroup -> fieldsGroup_toJs(obj)
}

public fun structureElement_fromJs(obj: StructureElementJs): StructureElement = when {
	obj is DropdownFieldJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.DropdownField" ->dropdownField_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.DropdownFieldJs)
	obj is RadioButtonJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.RadioButton" ->radioButton_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.RadioButtonJs)
	obj is DatePickerJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.DatePicker" ->datePicker_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.DatePickerJs)
	obj is TimePickerJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.TimePicker" ->timePicker_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.TimePickerJs)
	obj is DateTimePickerJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker" ->dateTimePicker_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.DateTimePickerJs)
	obj is NumberFieldJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.NumberField" ->numberField_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.NumberFieldJs)
	obj is TextFieldJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.TextField" ->textField_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.TextFieldJs)
	obj is CheckBoxJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.CheckBox" ->checkBox_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.CheckBoxJs)
	obj is MultipleChoiceJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice" ->multipleChoice_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.MultipleChoiceJs)
	obj is MeasureFieldJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.MeasureField" ->measureField_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.MeasureFieldJs)
	obj is FieldsGroupJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup" ->fieldsGroup_fromJs(obj as
			com.icure.cardinal.sdk.js.model.embed.form.template.FieldsGroupJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.embed.form.template.StructureElement: $obj""")
}
