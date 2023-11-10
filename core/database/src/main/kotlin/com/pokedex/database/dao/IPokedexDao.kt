package com.pokedex.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pokedex.database.entity.PokedexEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IPokedexDao {

    @Insert
    suspend fun insertPokedex(pokedexEntity: PokedexEntity)

    @Insert
    suspend fun insertPokedexList(pokedexEntityList: List<PokedexEntity>)

    @Query("SELECT * FROM ${PokedexEntity.TABLE_POKEDEX}")
    fun getPokedexList(): Flow<List<PokedexEntity>?>

    @Query("SELECT * FROM ${PokedexEntity.TABLE_POKEDEX} WHERE ${PokedexEntity.TABLE_NAME} = :name")
    suspend fun getPokedex(name: String): PokedexEntity
}