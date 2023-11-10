package com.pokedex.list.ui

import androidx.recyclerview.widget.DiffUtil
import com.pokedex.list.domain.model.Pokedex

class PokedexListDiffUtil(
    private val oldList: List<Pokedex>,
    private val newList: List<Pokedex>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].name == newList[newItemPosition].name)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].imageUrl == newList[newItemPosition].imageUrl
                && oldList[oldItemPosition].name == newList[newItemPosition].name)
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}