package com.pokedex.list.data.di

import com.pokedex.list.data.repo.PokedexListRepo
import com.pokedex.list.domain.repo.IPokedexListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class DataLayerModule {

    @Binds
    abstract fun bindPokedexListRepo(pokedexListRepo: PokedexListRepo): IPokedexListRepo
}