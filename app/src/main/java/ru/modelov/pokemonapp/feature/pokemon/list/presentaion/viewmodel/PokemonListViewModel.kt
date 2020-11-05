package ru.modelov.pokemonapp.feature.pokemon.list.presentaion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.modelov.pokemonapp.feature.pokemon.SingleLiveEvent
import ru.modelov.pokemonapp.feature.pokemon.list.data.datasourse.PokemonListRemoteDataSourceImpl
import ru.modelov.pokemonapp.feature.pokemon.list.data.repository.PokemonListRepositoryImpl
import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon
import ru.modelov.pokemonapp.feature.pokemon.list.domain.usecase.GetPokemonListUseCase

class PokemonListViewModel : ViewModel() {

    private val getPokemonListUseCase: GetPokemonListUseCase =
        GetPokemonListUseCase(
            PokemonListRepositoryImpl(
                PokemonListRemoteDataSourceImpl()
            )
        )

    var pokemonListLiveData = MutableLiveData<List<Pokemon>>()
        private set

    var pokemonClickedEvent = SingleLiveEvent<Pokemon>()
        private set

    init {
        pokemonListLiveData.value = getPokemonListUseCase()
    }

    fun onClickedPokemon(pokemon: Pokemon) {
        pokemonClickedEvent(pokemon)
    }

    fun onClickedAddButton() {
        /*pokemonListLiveData.value = pokemonList.toMutableList().apply {
            add(Pokemon("Покемон 1", "тестовый покемон", "jdfbhsdkjbhdsfjhdsf"))
        }*/
    }
}