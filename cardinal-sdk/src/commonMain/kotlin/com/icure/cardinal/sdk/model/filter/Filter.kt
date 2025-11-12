package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

@Serializable
public sealed interface Filter<O : Identifiable<*>> {
	public interface IdsFilter<T, O : Identifiable<T>> : Filter<O> {
		public val ids: Set<T>
	}

	public interface UnionFilter<O : Identifiable<*>> : Filter<O> {
		public val filters: List<Filter<O>>
	}

	public interface IntersectionFilter<O : Identifiable<*>> : Filter<O> {
		public val filters: List<Filter<O>>
	}

	public interface ComplementFilter<O : Identifiable<*>> : Filter<O> {
		public val superSet: Filter<O>

		public val subSet: Filter<O>
	}

	public interface AllFilter<O : Identifiable<*>> : Filter<O>

	public interface ByHcpartyFilter<O : Identifiable<*>> : Filter<O> {
		public val hcpId: String
	}
}
