package com.pokedex.network

import com.pokedex.network.model.PokedexListResponse
import retrofit2.Response
import retrofit2.http.GET

interface IApiService {

    @GET(NetworkConstant.GET_POKEDEX_LIST)
    suspend fun getPokedexList(): Response<PokedexListResponse?>
}