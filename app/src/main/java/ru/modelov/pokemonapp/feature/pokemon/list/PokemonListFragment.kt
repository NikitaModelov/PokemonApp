package ru.modelov.pokemonapp.feature.pokemon.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon
import ru.modelov.pokemonapp.R
import ru.modelov.pokemonapp.databinding.PokemonListFragmentBinding

class PokemonListFragment : Fragment() {

    private val pokemonsList = listOf(
        Pokemon(
            name = "Пикачу",
            subTitle = "Редкий и милый покемон",
            description = "Пикачу — небольшой Покемон жёлтого цвета. Он считается мышью или белкой, но внешне он больше похож на кролика. У него длинные, очень чуткие уши, и длинный зигзагообразный хвост. Он похож на молнию, а молния связана с электричеством."
        ),
        Pokemon(
            name = "Чармандер",
            subTitle = " стартовый покемон Fire-типа из первого поколения покемонов.",
            description = "Чармандер представляет собой двуногую рептилию красновато-оранжевого цвета, с голубыми глазами и кремовым брюшком. Внешне Чармандер похож на динозавра, в частности, на теропода."
        ),
        Pokemon(
            name = "Слоупок",
            subTitle = "Это я ))000))",
            description = "Слоупок - это розовый Покемон, который напоминает помесь саламандры и гиппопотама. У него пустые глаза, которые никогда не кажутся сосредоточенными, завитые уши и округлая морда. У него четыре лапы, каждая из которых заканчивается одним белым когтем. "
        )
    )

    private lateinit var adapter: PokemonListAdapter

    private var _binding: PokemonListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        adapter =
            PokemonListAdapter { item ->
                onClickedPokemon(item)
            }
        binding.rvPokemon.adapter = adapter
        adapter.submitList(pokemonsList)
    }

    private fun onClickedPokemon(pokemon: Pokemon) {
        findNavController().navigate(
            R.id.action_pokemonListFragment_to_pokemonDetailFragment2,
            bundleOf("POKEMON" to pokemon)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}