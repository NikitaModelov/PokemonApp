package ru.modelov.pokemonapp.feature.pokemon.list.domain.entity

import java.io.Serializable

data class Pokemon(
    val name: String,
    val subTitle: String,
    val description: String
) : Serializable