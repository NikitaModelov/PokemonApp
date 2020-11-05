package ru.modelov.pokemonapp.feature.pokemon.detail.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon

class PokemonDetailViewModel(
    private val pokemon: Pokemon
) : ViewModel() {

    var pokemonLiveData = MutableLiveData<Pokemon>(pokemon)
        private set
}