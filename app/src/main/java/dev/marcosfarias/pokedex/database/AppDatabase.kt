package com.enrique.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enrique.pokedex.database.dao.PokemonDAO
import com.enrique.pokedex.model.Pokemon

@Database(entities = [Pokemon::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}
