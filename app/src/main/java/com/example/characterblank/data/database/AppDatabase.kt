package com.example.characterblank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.characterblank.data.model.Character

@Database(
    entities = [Character::class],
    version = 1,
    exportSchema = false // <- Do not create JSON files describing the database structure in the project
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
