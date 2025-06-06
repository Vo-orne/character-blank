package com.example.characterblank.data.repository

import com.example.characterblank.data.database.CharacterDao
import com.example.characterblank.data.model.Character
import kotlinx.coroutines.flow.Flow

class CharacterRepository(private val dao: CharacterDao) {

    fun getAllCharacters(): Flow<List<Character>> = dao.getAllCharacters()

    suspend fun getCharacterById(id: Int): Character? = dao.getCharacterById(id)

    suspend fun insertCharacter(character: Character) {
        dao.insertCharacter(character)
    }

    suspend fun updateCharacter(character: Character) {
        dao.updateCharacter(character)
    }

    suspend fun deleteCharacter(character: Character) {
        dao.deleteCharacter(character)
    }
}