package com.pokedex.list.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.pokedex.list.domain.model.Pokedex
import com.pokedex.list.ui.databinding.ActivityPokedexListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PokedexListActivity : AppCompatActivity() {

    private val pokedexListViewModel by viewModels<PokedexListViewModel>()

    private lateinit var binding: ActivityPokedexListBinding

    @Inject
    lateinit var pokedexListAdapter: PokedexListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.pokedexRv.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = pokedexListAdapter
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                pokedexListViewModel.getPokedexList().collect {
                    when (it) {
                        PokedexListViewModel.PokedexListUIState.Loading -> {}
                        is PokedexListViewModel.PokedexListUIState.Success -> {
                            showPokedexListOnUI(it.pokedexList)
                        }
                    }
                }
            }
        }
    }

    private fun showPokedexListOnUI(pokedexList: List<Pokedex>?) {
        pokedexList?.let {
            pokedexListAdapter.update(it)
        }
    }
}