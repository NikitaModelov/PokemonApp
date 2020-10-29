package ru.modelov.pokemonapp.feature.pokemon.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import ru.modelov.pokemonapp.R
import ru.modelov.pokemonapp.databinding.PokemonListFragmentBinding
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon
import ru.modelov.pokemonapp.feature.pokemon.list.viewmodel.PokemonListViewModel

class PokemonListFragment : Fragment() {

    private lateinit var adapter: PokemonListAdapter

    private var _binding: PokemonListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        viewModel.pokemonClickedEvent.observe(viewLifecycleOwner) {
            onClickedPokemon(it)
        }

        binding.addButton.setOnClickListener {
            viewModel.onClickedAddButton()
        }

        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        adapter = PokemonListAdapter(viewModel::onClickedPokemon)
        binding.rvPokemon.adapter = adapter
        viewModel.pokemonListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
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