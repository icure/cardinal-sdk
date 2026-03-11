// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

@Serializable
sealed interface Filter<O : Identifiable<*>> {
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
  // region Filter-Filter

  // endregion
}
