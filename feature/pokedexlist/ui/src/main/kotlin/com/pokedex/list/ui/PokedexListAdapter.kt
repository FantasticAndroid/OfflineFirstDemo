package com.pokedex.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.list.domain.model.Pokedex
import com.pokedex.list.ui.databinding.ItemPokedexBinding
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokedexListAdapter @Inject constructor() :
    RecyclerView.Adapter<PokedexListAdapter.PokedexItemHolder>() {

    private val pokedexList = ArrayList<Pokedex>()

    fun update(updatedList: List<Pokedex>) {

        val diffResult = DiffUtil.calculateDiff(
            PokedexListDiffUtil(
                pokedexList,
                updatedList
            )
        )

        pokedexList.clear()
        pokedexList.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

    class PokedexItemHolder(val binding: ItemPokedexBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexItemHolder {
        val binding = ItemPokedexBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokedexItemHolder(binding)
    }

    override fun getItemCount() = pokedexList.size

    override fun onBindViewHolder(holder: PokedexItemHolder, position: Int) {
        holder.binding.pokedex = pokedexList[position]
        holder.binding.executePendingBindings()
    }
}