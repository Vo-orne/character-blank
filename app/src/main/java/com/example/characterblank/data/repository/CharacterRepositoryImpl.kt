package com.example.characterblank.data.repository

import com.example.characterblank.data.database.CharacterDao
import com.example.characterblank.data.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dao: CharacterDao
) : CharacterRepository {

    override fun getAllCharacters(): Flow<List<Character>> = dao.getAllCharacters()

    override suspend fun getCharacterById(id: Int): Character? = dao.getCharacterById(id)

    override suspend fun insertCharacter(character: Character) {
        dao.insertCharacter(character)
    }

    override suspend fun updateCharacter(character: Character) {
        dao.updateCharacter(character)
    }

    override suspend fun deleteCharacter(character: Character) {
        dao.deleteCharacter(character)
    }
}