package com.pokedex.network.datasource.pokedexdatasource

import com.pokedex.network.model.ApiResult
import com.pokedex.network.model.PokedexListResponse

interface IPokedexDataSource {

    suspend fun getPokedexList(): ApiResult<PokedexListResponse?>
}