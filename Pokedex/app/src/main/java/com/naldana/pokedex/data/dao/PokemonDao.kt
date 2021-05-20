package com.naldana.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.pokedex.data.entity.Pokemon
import com.naldana.pokedex.data.entity.PokemonType
import com.naldana.pokedex.data.entity.PokemonWhitType

@Dao
interface PokemonDao {

    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Insert
    suspend fun insertTypesOfPokemon(types:List<PokemonType>)

    @Query("SELECT * FROM pokemon_table WHERE id = :key or name = :key")
    suspend fun search(key: String): Pokemon?

    @Query("SELECT * FROM pokemon_table")
    fun findAll(): LiveData<List<Pokemon>>

    @Update
    suspend fun update(pokemon: Pokemon)

    @Delete
    suspend fun delete(pokemon: Pokemon)

    @Transaction
    suspend fun insertPokemonWhitType(pokemon: Pokemon){
        insert(pokemon)
        val pokemonTypes =
            pokemon.types.map{
                it.idPokemon = pokemon.id
                it
            }
        insertTypesOfPokemon(pokemonTypes)
    }

    @Transaction
    @Query("SELECT * FROM pokemon_table")
    fun getPokemonsWhitType(): LiveData<List<PokemonWhitType>>
}