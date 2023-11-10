package com.pokedex.list.domain.repo

import com.pokedex.list.domain.model.Pokedex
import kotlinx.coroutines.flow.Flow

interface IPokedexListRepo {

    // For Flow method would not be suspended
    suspend fun getPokedexList(): Flow<List<Pokedex>?>

    //suspend fun getMovieList(query: String): List<Movie>?>
}