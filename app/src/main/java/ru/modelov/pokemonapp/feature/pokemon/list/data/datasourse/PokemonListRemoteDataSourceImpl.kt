package ru.modelov.pokemonapp.feature.pokemon.list.data.datasourse

import ru.modelov.pokemonapp.feature.pokemon.entity.PokemonDto
import ru.modelov.pokemonapp.feature.pokemon.entity.toEntity
import ru.modelov.pokemonapp.feature.pokemon.list.domain.entity.Pokemon

class PokemonListRemoteDataSourceImpl : PokemonListRemoteDataSource {

    override fun getPokemonList(): List<Pokemon> = listOf(
        PokemonDto(
            name = "Пикачу",
            subTitle = "Редкий и милый покемон",
            description = "Пикачу — небольшой Покемон жёлтого цвета. Он считается мышью или белкой, но внешне он больше похож на кролика. У него длинные, очень чуткие уши, и длинный зигзагообразный хвост. Он похож на молнию, а молния связана с электричеством."
        ),
        PokemonDto(
            name = "Чармандер",
            subTitle = " стартовый покемон Fire-типа из первого поколения покемонов.",
            description = "Чармандер представляет собой двуногую рептилию красновато-оранжевого цвета, с голубыми глазами и кремовым брюшком. Внешне Чармандер похож на динозавра, в частности, на теропода."
        ),
        PokemonDto(
            name = "Слоупок",
            subTitle = "Это я ))000))",
            description = "Слоупок - это розовый Покемон, который напоминает помесь саламандры и гиппопотама. У него пустые глаза, которые никогда не кажутся сосредоточенными, завитые уши и округлая морда. У него четыре лапы, каждая из которых заканчивается одним белым когтем. "
        )
    ).toEntity()
}