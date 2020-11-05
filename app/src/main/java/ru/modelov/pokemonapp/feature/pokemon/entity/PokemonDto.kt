package ru.modelov.pokemonapp.feature.pokemon.entity

import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon
import java.io.Serializable

@AndroidNetwork
data class PokemonDto(
    val name: String,
    val subTitle: String,
    val description: String
) : Serializable

fun PokemonDto.toEntity() = Pokemon(name, subTitle, description)

fun Pokemon.toDto() = PokemonDto(name, subTitle, description)

fun List<PokemonDto>.toEntity(): List<Pokemon> = map(PokemonDto::toEntity)

annotation class AndroidNetwork