package ru.modelov.pokemonapp.feature.pokemon.list.domain.usecase

import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon
import ru.modelov.pokemonapp.feature.pokemon.list.domain.repository.PokemonListRepository

class GetPokemonListUseCase(private val repository: PokemonListRepository) {

    operator fun invoke(): List<Pokemon> = repository.getPokemonList()
}