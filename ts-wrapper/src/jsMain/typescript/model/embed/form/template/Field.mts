// auto-generated file
import {CheckBox} from './CheckBox.mjs';
import {DatePicker} from './DatePicker.mjs';
import {DateTimePicker} from './DateTimePicker.mjs';
import {DropdownField} from './DropdownField.mjs';
import {MeasureField} from './MeasureField.mjs';
import {MultipleChoice} from './MultipleChoice.mjs';
import {NumberField} from './NumberField.mjs';
import {RadioButton} from './RadioButton.mjs';
import {TextField} from './TextField.mjs';
import {TimePicker} from './TimePicker.mjs';


/**
 *
 *  Sealed interface representing a form field within a form template. Concrete implementations
 *  define
 *  specific field types (text, number, date picker, etc.). Each field has a name, display
 *  configuration,
 *  validation rules, and optional codification and tagging.
 *  /
 */
export type Field = TimePicker | MeasureField | RadioButton | NumberField | TextField | CheckBox | DropdownField | DatePicker | MultipleChoice | DateTimePicker;
