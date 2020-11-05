package ru.modelov.pokemonapp.feature.pokemon.list.data.repository

import ru.modelov.pokemonapp.feature.pokemon.list.data.datasourse.PokemonListRemoteDataSource
import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon
import ru.modelov.pokemonapp.feature.pokemon.list.domain.repository.PokemonListRepository

class PokemonListRepositoryImpl(
    private val remoteDataSource: PokemonListRemoteDataSource
) : PokemonListRepository {

    override fun getPokemonList(): List<Pokemon> =
        remoteDataSource.getPokemonList()
}