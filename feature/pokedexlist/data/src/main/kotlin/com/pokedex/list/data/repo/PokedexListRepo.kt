package com.pokedex.list.data.repo

import android.util.Log
import com.pokedex.database.dao.IPokedexDao
import com.pokedex.list.domain.model.Pokedex
import com.pokedex.list.domain.repo.IPokedexListRepo
import com.pokedex.network.datasource.pokedexdatasource.IPokedexDataSource
import com.pokedex.network.model.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mapToDomain
import mapToEntity
import javax.inject.Inject

private const val TAG = "PokedexListRepo"

class PokedexListRepo @Inject constructor(
    private val pokedexDataSource: IPokedexDataSource,
    private val pokedexDao: IPokedexDao
) : IPokedexListRepo {

    private suspend fun syncPokedexList() {
        Log.d(TAG, "syncPokedexList")
        val response = pokedexDataSource.getPokedexList()
        Log.d(TAG, "syncPokedexList response: $response")

        when (response) {
            is ApiResult.Success -> {
                response.data?.results?.map {
                    it.mapToEntity()
                }
            }

            else -> {}
        }
    }

    override suspend fun getPokedexList(): Flow<List<Pokedex>?> {
        syncPokedexList()
        return pokedexDao.getPokedexList()
            .map { it?.map { pokedexEntity -> pokedexEntity.mapToDomain() } }
    }
}