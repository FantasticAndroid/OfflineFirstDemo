package com.pokedex.network.datasource.pokedexdatasource

import com.pokedex.network.model.ApiResult
import com.pokedex.network.model.PokedexListResponse
import com.pokedex.network.IApiService
import javax.inject.Inject

class PokedexDataSourceImpl @Inject constructor(private val apiService: IApiService) :
    IPokedexDataSource {

    override suspend fun getPokedexList(): ApiResult<PokedexListResponse?> {
        val response = apiService.getPokedexList()
        return if(response.isSuccessful){
            val result = response.body()
            ApiResult.Success(data = result)
        }else{
            ApiResult.Error(errorCode = response.code(), message = response.message())
        }
    }
}