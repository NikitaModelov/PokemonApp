package ru.modelov.pokemonapp.feature.pokemon.detail.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ru.modelov.pokemonapp.databinding.PokemonDetailFragmentBinding
import ru.modelov.pokemonapp.feature.pokemon.detail.presentation.viewmodel.PokemonDetailViewModel
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon

class PokemonDetailFragment : Fragment() {

    private var _binding: PokemonDetailFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonDetailViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(Pokemon::class.java).newInstance(
                    arguments?.getSerializable("POKEMON") as? Pokemon
                        ?: throw Exception("Мы упали")
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PokemonDetailFragmentBinding.inflate(inflater, container, false)

        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
        }

        with(binding) {
            tvName.text = viewModel.pokemonLiveData.value?.name
            tvSubtitle.text = viewModel.pokemonLiveData.value?.subTitle
            tvDescription.text = viewModel.pokemonLiveData.value?.description
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}