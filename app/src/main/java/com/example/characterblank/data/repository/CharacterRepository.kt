package com.example.characterblank.data.repository

import kotlinx.coroutines.flow.Flow
import com.example.characterblank.data.model.Character

interface CharacterRepository {
    fun getAllCharacters(): Flow<List<Character>>

    suspend fun getCharacterById(id: Int): Character?

    suspend fun insertCharacter(character: Character)

    suspend fun updateCharacter(character: Character)

    suspend fun deleteCharacter(character: Character)
}