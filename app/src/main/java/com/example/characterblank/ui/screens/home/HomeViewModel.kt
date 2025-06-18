package com.example.characterblank.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characterblank.data.model.Character
import com.example.characterblank.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characters: StateFlow<List<Character>> = repository.getAllCharacters()
        .map { it.sortedBy { character -> character.name } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000), // After unsubscribing, stay active for another 5000 ms (5 seconds) (in case of a short configuration change, for example, when rotating the screen)
            initialValue = emptyList()
        )

    fun deleteCharacter(character: Character) {
        viewModelScope.launch {
            repository.deleteCharacter(character)
        }
    }

    fun addCharacter(character: Character) {
        viewModelScope.launch {
            repository.insertCharacter(character)
        }
    }
}