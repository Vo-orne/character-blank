package com.example.characterblank.ui.screens.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterblank.data.model.Character
import com.example.characterblank.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _character = MutableStateFlow<Character?>(null)
    val character: StateFlow<Character?> get() = _character

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            _character.value = repository.getCharacterById(id)
        }
    }

    fun updateCharacter(updated: Character) {
        viewModelScope.launch {
            repository.updateCharacter(updated)
            _character.value = updated
        }
    }

    fun createNewCharacter(character: Character) {
        viewModelScope.launch {
            repository.insertCharacter(character)
            _character.value = character
        }
    }
}
