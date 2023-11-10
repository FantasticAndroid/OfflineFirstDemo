package com.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pokedex.database.dao.IPokedexDao
import com.pokedex.database.entity.PokedexEntity

@Database(
    entities = [PokedexEntity::class],
    version = DataBaseConst.DB_VERSION,
    exportSchema = false
)
abstract class PokedexDataBase : RoomDatabase() {

    abstract fun getPokedexDao(): IPokedexDao
}