package ru.modelov.pokemonapp.feature.pokemon.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.modelov.pokemonapp.feature.pokemon.SingleLiveEvent
import ru.modelov.pokemonapp.feature.pokemon.entity.Pokemon

class PokemonListViewModel : ViewModel() {

    private val pokemonList = mutableListOf(
        Pokemon(
            name = "Пикачу",
            subTitle = "Редкий и милый покемон",
            description = "Пикачу — небольшой Покемон жёлтого цвета. Он считается мышью или белкой, но внешне он больше похож на кролика. У него длинные, очень чуткие уши, и длинный зигзагообразный хвост. Он похож на молнию, а молния связана с электричеством."
        ),
        Pokemon(
            name = "Чармандер",
            subTitle = " стартовый покемон Fire-типа из первого поколения покемонов.",
            description = "Чармандер представляет собой двуногую рептилию красновато-оранжевого цвета, с голубыми глазами и кремовым брюшком. Внешне Чармандер похож на динозавра, в частности, на теропода."
        ),
        Pokemon(
            name = "Слоупок",
            subTitle = "Это я ))000))",
            description = "Слоупок - это розовый Покемон, который напоминает помесь саламандры и гиппопотама. У него пустые глаза, которые никогда не кажутся сосредоточенными, завитые уши и округлая морда. У него четыре лапы, каждая из которых заканчивается одним белым когтем. "
        )
    )

    var pokemonListLiveData = MutableLiveData<List<Pokemon>>()
        private set

    var pokemonClickedEvent = SingleLiveEvent<Pokemon>()
        private set

    init {
        pokemonListLiveData.value = pokemonList
    }

    fun onClickedPokemon(pokemon: Pokemon) {
        pokemonClickedEvent(pokemon)
    }

    fun onClickedAddButton() {
        pokemonListLiveData.value = pokemonList.toMutableList().apply {
            add(Pokemon("Покемон 1", "тестовый покемон", "jdfbhsdkjbhdsfjhdsf"))
        }
    }
}