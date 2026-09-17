// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import kotlinx.serialization.Serializable

/**
 * Payload accepted by a single-entity custom-filtering endpoint: either a by-keys or a
 * by-range view query. The endpoint for a given entity X maps this to the concrete
 * ByKeys/ByRange custom filter domain class for X.
 * /
 */
@Serializable
sealed interface CustomFilter {
	// region CustomFilter-CustomFilter

	// endregion
}
