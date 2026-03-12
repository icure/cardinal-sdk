package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.Serializable

/**
 *
 *  Predicate that always evaluates to true, matching all elements.
 */
@Serializable
public class AlwaysPredicate() : Predicate
