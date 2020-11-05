package ru.modelov.pokemonapp.feature.pokemon.list.domain.repository

import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon


interface PokemonListRepository {

    fun getPokemonList(): List<Pokemon>
}