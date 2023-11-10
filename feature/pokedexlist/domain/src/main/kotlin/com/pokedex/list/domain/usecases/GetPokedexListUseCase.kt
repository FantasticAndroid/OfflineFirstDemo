package com.pokedex.list.domain.usecases

import com.pokedex.list.domain.model.Pokedex
import com.pokedex.list.domain.repo.IPokedexListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokedexListUseCase @Inject constructor(private val iPokedexListRepo: IPokedexListRepo) {

    suspend operator fun invoke(): Flow<List<Pokedex>?> {
        return iPokedexListRepo.getPokedexList()
    }
}