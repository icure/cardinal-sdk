// auto-generated file
package com.icure.cardinal.sdk.js.model.filter.predicate

import com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate
import com.icure.cardinal.sdk.model.filter.predicate.AndPredicate
import com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate
import com.icure.cardinal.sdk.model.filter.predicate.NotPredicate
import com.icure.cardinal.sdk.model.filter.predicate.OrPredicate
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun predicate_toJs(obj: Predicate): PredicateJs = when (obj) {
	is NotPredicate -> notPredicate_toJs(obj)
	is AndPredicate -> andPredicate_toJs(obj)
	is AlwaysPredicate -> alwaysPredicate_toJs(obj)
	is OrPredicate -> orPredicate_toJs(obj)
	is KeyValuePredicate -> keyValuePredicate_toJs(obj)
}

public fun predicate_fromJs(obj: PredicateJs): Predicate = when {
	obj is NotPredicateJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.filter.predicate.NotPredicate" ->notPredicate_fromJs(obj as
			com.icure.cardinal.sdk.js.model.filter.predicate.NotPredicateJs)
	obj is AndPredicateJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.filter.predicate.AndPredicate" ->andPredicate_fromJs(obj as
			com.icure.cardinal.sdk.js.model.filter.predicate.AndPredicateJs)
	obj is AlwaysPredicateJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate" ->alwaysPredicate_fromJs(obj as
			com.icure.cardinal.sdk.js.model.filter.predicate.AlwaysPredicateJs)
	obj is OrPredicateJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.filter.predicate.OrPredicate" ->orPredicate_fromJs(obj as
			com.icure.cardinal.sdk.js.model.filter.predicate.OrPredicateJs)
	obj is KeyValuePredicateJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate" ->keyValuePredicate_fromJs(obj
			as com.icure.cardinal.sdk.js.model.filter.predicate.KeyValuePredicateJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.filter.predicate.Predicate: $obj""")
}
