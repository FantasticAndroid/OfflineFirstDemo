package com.pokedex.database.di

import android.content.Context
import androidx.room.Room
import com.pokedex.database.DataBaseConst
import com.pokedex.database.PokedexDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun ProvidePokedexDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context, PokedexDataBase::class.java,
            DataBaseConst.DB_NAME
        )
            // To Recreate DB if Migration Fail
            .fallbackToDestructiveMigration()
            //.addTypeConverter()
            // Optional
            .setQueryCallback(
                { sqlQuery, bindArgs ->
                    println("SQL Query: $sqlQuery SQL Args: $bindArgs")
                }, Executors.newSingleThreadExecutor()
            )
            .build()
}