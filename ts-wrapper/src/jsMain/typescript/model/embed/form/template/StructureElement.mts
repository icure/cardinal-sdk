// auto-generated file
import {CheckBox} from './CheckBox.mjs';
import {DatePicker} from './DatePicker.mjs';
import {DateTimePicker} from './DateTimePicker.mjs';
import {DropdownField} from './DropdownField.mjs';
import {Field} from './Field.mjs';
import {FieldsGroup} from './FieldsGroup.mjs';
import {MeasureField} from './MeasureField.mjs';
import {MultipleChoice} from './MultipleChoice.mjs';
import {NumberField} from './NumberField.mjs';
import {RadioButton} from './RadioButton.mjs';
import {TextField} from './TextField.mjs';
import {TimePicker} from './TimePicker.mjs';


export type StructureElement = Field | FieldsGroup;

export namespace StructureElement {

	export function fromJSON(json: any, path: Array<string> = ['StructureElement']): StructureElement {
		switch ((json as StructureElement).$ktClass) {
			case 'com.icure.cardinal.sdk.model.embed.form.template.DropdownField': return DropdownField.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.RadioButton': return RadioButton.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.DatePicker': return DatePicker.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.TimePicker': return TimePicker.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.DateTimePicker': return DateTimePicker.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.NumberField': return NumberField.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.TextField': return TextField.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.CheckBox': return CheckBox.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.MultipleChoice': return MultipleChoice.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.MeasureField': return MeasureField.fromJSON(json)
			case 'com.icure.cardinal.sdk.model.embed.form.template.FieldsGroup': return FieldsGroup.fromJSON(json)
			default: throw new Error('Unexpected discriminator for StructureElement: ' + json.$ktClass)
		}
	}

}
