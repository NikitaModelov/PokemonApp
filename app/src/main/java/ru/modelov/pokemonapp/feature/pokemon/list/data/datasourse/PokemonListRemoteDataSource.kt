package ru.modelov.pokemonapp.feature.pokemon.list.data.datasourse

import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon

interface PokemonListRemoteDataSource {

    fun getPokemonList(): List<Pokemon>
}