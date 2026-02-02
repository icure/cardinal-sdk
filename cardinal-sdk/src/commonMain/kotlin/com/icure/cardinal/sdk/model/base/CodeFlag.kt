package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class CodeFlag(
	internal val dtoSerialName: String,
) {
	@SerialName("male_only")
	MaleOnly("male_only"),

	@SerialName("female_only")
	FemaleOnly("female_only"),

	@SerialName("deptkinesitherapy")
	Deptkinesitherapy("deptkinesitherapy"),

	@SerialName("deptnursing")
	Deptnursing("deptnursing"),

	@SerialName("deptgeneralpractice")
	Deptgeneralpractice("deptgeneralpractice"),

	@SerialName("deptsocialworker")
	Deptsocialworker("deptsocialworker"),

	@SerialName("deptpsychology")
	Deptpsychology("deptpsychology"),

	@SerialName("deptadministrative")
	Deptadministrative("deptadministrative"),

	@SerialName("deptdietetics")
	Deptdietetics("deptdietetics"),

	@SerialName("deptspeechtherapy")
	Deptspeechtherapy("deptspeechtherapy"),

	@SerialName("deptdentistry")
	Deptdentistry("deptdentistry"),

	@SerialName("deptoccupationaltherapy")
	Deptoccupationaltherapy("deptoccupationaltherapy"),

	@SerialName("depthealthcare")
	Depthealthcare("depthealthcare"),

	@SerialName("deptgynecology")
	Deptgynecology("deptgynecology"),

	@SerialName("deptpediatry")
	Deptpediatry("deptpediatry"),

	@SerialName("deptalgology")
	Deptalgology("deptalgology"),

	@SerialName("deptanatomopathology")
	Deptanatomopathology("deptanatomopathology"),

	@SerialName("deptanesthesiology")
	Deptanesthesiology("deptanesthesiology"),

	@SerialName("deptbacteriology")
	Deptbacteriology("deptbacteriology"),

	@SerialName("deptcardiacsurgery")
	Deptcardiacsurgery("deptcardiacsurgery"),

	@SerialName("deptcardiology")
	Deptcardiology("deptcardiology"),

	@SerialName("deptchildandadolescentpsychiatry")
	Deptchildandadolescentpsychiatry("deptchildandadolescentpsychiatry"),

	@SerialName("deptdermatology")
	Deptdermatology("deptdermatology"),

	@SerialName("deptdiabetology")
	Deptdiabetology("deptdiabetology"),

	@SerialName("deptemergency")
	Deptemergency("deptemergency"),

	@SerialName("deptendocrinology")
	Deptendocrinology("deptendocrinology"),

	@SerialName("deptgastroenterology")
	Deptgastroenterology("deptgastroenterology"),

	@SerialName("deptgenetics")
	Deptgenetics("deptgenetics"),

	@SerialName("deptgeriatry")
	Deptgeriatry("deptgeriatry"),

	@SerialName("depthandsurgery")
	Depthandsurgery("depthandsurgery"),

	@SerialName("depthematology")
	Depthematology("depthematology"),

	@SerialName("deptinfectiousdisease")
	Deptinfectiousdisease("deptinfectiousdisease"),

	@SerialName("deptintensivecare")
	Deptintensivecare("deptintensivecare"),

	@SerialName("deptlaboratory")
	Deptlaboratory("deptlaboratory"),

	@SerialName("deptmajorburns")
	Deptmajorburns("deptmajorburns"),

	@SerialName("deptmaxillofacialsurgery")
	Deptmaxillofacialsurgery("deptmaxillofacialsurgery"),

	@SerialName("deptmedicine")
	Deptmedicine("deptmedicine"),

	@SerialName("deptmolecularbiology")
	Deptmolecularbiology("deptmolecularbiology"),

	@SerialName("deptneonatalogy")
	Deptneonatalogy("deptneonatalogy"),

	@SerialName("deptnephrology")
	Deptnephrology("deptnephrology"),

	@SerialName("deptneurology")
	Deptneurology("deptneurology"),

	@SerialName("deptneurosurgery")
	Deptneurosurgery("deptneurosurgery"),

	@SerialName("deptnte")
	Deptnte("deptnte"),

	@SerialName("deptnuclear")
	Deptnuclear("deptnuclear"),

	@SerialName("deptnutritiondietetics")
	Deptnutritiondietetics("deptnutritiondietetics"),

	@SerialName("deptobstetrics")
	Deptobstetrics("deptobstetrics"),

	@SerialName("deptoncology")
	Deptoncology("deptoncology"),

	@SerialName("deptophtalmology")
	Deptophtalmology("deptophtalmology"),

	@SerialName("deptorthopedy")
	Deptorthopedy("deptorthopedy"),

	@SerialName("deptpalliativecare")
	Deptpalliativecare("deptpalliativecare"),

	@SerialName("deptpediatricintensivecare")
	Deptpediatricintensivecare("deptpediatricintensivecare"),

	@SerialName("deptpediatricsurgery")
	Deptpediatricsurgery("deptpediatricsurgery"),

	@SerialName("deptpharmacy")
	Deptpharmacy("deptpharmacy"),

	@SerialName("deptphysicalmedecine")
	Deptphysicalmedecine("deptphysicalmedecine"),

	@SerialName("deptphysiotherapy")
	Deptphysiotherapy("deptphysiotherapy"),

	@SerialName("deptplasticandreparatorysurgery")
	Deptplasticandreparatorysurgery("deptplasticandreparatorysurgery"),

	@SerialName("deptpneumology")
	Deptpneumology("deptpneumology"),

	@SerialName("deptpodiatry")
	Deptpodiatry("deptpodiatry"),

	@SerialName("deptpsychiatry")
	Deptpsychiatry("deptpsychiatry"),

	@SerialName("deptradiology")
	Deptradiology("deptradiology"),

	@SerialName("deptradiotherapy")
	Deptradiotherapy("deptradiotherapy"),

	@SerialName("deptrevalidation")
	Deptrevalidation("deptrevalidation"),

	@SerialName("deptrheumatology")
	Deptrheumatology("deptrheumatology"),

	@SerialName("deptrhumatology")
	Deptrhumatology("deptrhumatology"),

	@SerialName("deptsenology")
	Deptsenology("deptsenology"),

	@SerialName("deptsocialservice")
	Deptsocialservice("deptsocialservice"),

	@SerialName("deptsportsmedecine")
	Deptsportsmedecine("deptsportsmedecine"),

	@SerialName("deptstomatology")
	Deptstomatology("deptstomatology"),

	@SerialName("deptsurgery")
	Deptsurgery("deptsurgery"),

	@SerialName("deptthoracicsurgery")
	Deptthoracicsurgery("deptthoracicsurgery"),

	@SerialName("depttoxicology")
	Depttoxicology("depttoxicology"),

	@SerialName("depttropicalmedecine")
	Depttropicalmedecine("depttropicalmedecine"),

	@SerialName("depturology")
	Depturology("depturology"),

	@SerialName("deptvascularsurgery")
	Deptvascularsurgery("deptvascularsurgery"),

	@SerialName("deptvisceraldigestiveabdominalsurgery")
	Deptvisceraldigestiveabdominalsurgery("deptvisceraldigestiveabdominalsurgery"),

	@SerialName("depttransplantsurgery")
	Depttransplantsurgery("depttransplantsurgery"),

	@SerialName("deptpercutaneous")
	Deptpercutaneous("deptpercutaneous"),

	@SerialName("deptchildbirth")
	Deptchildbirth("deptchildbirth"),
}
