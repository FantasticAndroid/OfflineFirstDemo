package com.pokedex.list.ui

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokedex.list.domain.model.Pokedex
import com.pokedex.list.domain.usecases.GetPokedexListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PokedexListViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var getPokedexListUseCase: GetPokedexListUseCase

    suspend fun getPokedexList(): StateFlow<PokedexListUIState> {
        return getPokedexListUseCase().map {
            PokedexListUIState.Success(it)
        }.stateIn(
            scope = viewModelScope,
            initialValue = PokedexListUIState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
    }

    sealed interface PokedexListUIState {
        object Loading : PokedexListUIState

        @Keep
        data class Success(val pokedexList: List<Pokedex>?) : PokedexListUIState
    }
}