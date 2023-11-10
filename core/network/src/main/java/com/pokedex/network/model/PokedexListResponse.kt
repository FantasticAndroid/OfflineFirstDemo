package com.pokedex.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PokedexListResponse(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<PokedexDTO>? = null
)

@Keep
data class PokedexDTO(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String? = null
)
