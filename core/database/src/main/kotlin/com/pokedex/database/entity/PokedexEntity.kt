package com.pokedex.database.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = PokedexEntity.TABLE_POKEDEX)
data class PokedexEntity(

    @ColumnInfo("url")
    val url: String? = null,
    @PrimaryKey
    @ColumnInfo(TABLE_NAME)
    val name: String,
) {
    companion object {
        const val TABLE_POKEDEX = "Pokedex"
        const val TABLE_NAME = "name"
    }
}
