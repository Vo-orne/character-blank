package com.example.characterblank.data.database

import androidx.room.*
import com.example.characterblank.data.model.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<Character>> // Get a stream of all characters

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Int): Character? // Get a specific character by id

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character) // Add or update a character

    @Update
    suspend fun updateCharacter(character: Character) // Change an existing character

    @Delete
    suspend fun deleteCharacter(character: Character) // Delete character
}
