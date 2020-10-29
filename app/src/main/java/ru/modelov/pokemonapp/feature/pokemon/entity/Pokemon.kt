package ru.modelov.pokemonapp.feature.pokemon.entity

import java.io.Serializable

data class Pokemon(
    val name: String,
    val subTitle: String,
    val description: String
) : Serializable