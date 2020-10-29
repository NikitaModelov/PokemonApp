package ru.modelov.pokemonapp.feature.pokemon.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.modelov.pokemonapp.databinding.ItemPokemonBinding
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon

class PokemonListAdapter(private val onClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonListViewHolder>(object :
        DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) =
            oldItem == newItem
    }) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonListViewHolder =
        PokemonListViewHolder.from(
            parent
        )

    override fun onBindViewHolder(
        holder: PokemonListViewHolder,
        position: Int
    ) = holder.bind(getItem(position), onClick)
}

class PokemonListViewHolder private constructor(private val binding: ItemPokemonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pokemon, onClick: (pokemon: Pokemon) -> Unit) {
        with(binding) {
            tvName.text = item.name
            tvSubtitle.text = item.subTitle
            cvPokemon.setOnClickListener {
                onClick(item)
            }
            //executePendingBindings()
        }
    }

    companion object {
        fun from(parent: ViewGroup): PokemonListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPokemonBinding.inflate(layoutInflater, parent, false)
            return PokemonListViewHolder(
                binding
            )
        }
    }
}