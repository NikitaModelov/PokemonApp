package ru.modelov.pokemonapp.feature.pokemon.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon
import ru.modelov.pokemonapp.databinding.PokemonDetailFragmentBinding

class PokemonDetailFragment : Fragment() {

    private var _binding: PokemonDetailFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var pokemon: Pokemon

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PokemonDetailFragmentBinding.inflate(inflater, container, false)

        pokemon = arguments?.getSerializable("POKEMON") as? Pokemon
            ?: throw Exception("Мы упали")

        with(binding) {
            tvName.text = pokemon.name
            tvSubtitle.text = pokemon.subTitle
            tvDescription.text = pokemon.description
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}