package com.naldana.pokedex.data.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey
    var id: Int,
    var name: String,
    @ColumnInfo(name="base_experience")
    @SerializedName(value = "base_experience")
    var baseExperience: Int,
    var height: Int,
    var weight: Int,
    @Embedded
    var sprites: PokemonSprites
){
    @Ignore
    lateinit var types: List<PokemonType>
}

@Entity(tableName = "pokemon_types", primaryKeys = ["slot","idPokemon"])
data class  PokemonType(
    var slot: Int,
    @Embedded
    var type: NameAPIResource
){
    var idPokemon: Int = 0
}
data class  PokemonSprites(
    @ColumnInfo(name = "front_default")
    @SerializedName(value = "front_default")
    val frontDefault: String?,
    @ColumnInfo(name = "front_shiny")
    @SerializedName(value = "front_shiny")
    val frontShiny: String?,
    @ColumnInfo(name = "front_female")
    @SerializedName(value = "front_female")
    val frontFemale: String?,
    @ColumnInfo(name = "front_shiny_female")
    @SerializedName(value = "front_shiny_female")
    val frontShinyFemale: String?,
    @ColumnInfo(name = "back_default")
    @SerializedName(value = "back_default")
    val backDefault: String?,
    @ColumnInfo(name = "back_shiny")
    @SerializedName(value = "back_shiny")
    val backShiny: String?,
    @ColumnInfo(name = "back_female")
    @SerializedName(value = "back_female")
    val backFemale: String?,
    @ColumnInfo(name = "back_shiny_female")
    @SerializedName(value = "back_shiny_female")
    val backShinyFemale: String?,
)