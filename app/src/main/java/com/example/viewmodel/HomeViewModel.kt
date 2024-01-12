package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmcharacters.data.api.model.FilmCharacter
import com.example.filmcharacters.data.repository.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharacterRepo
): ViewModel(){

    private val _state = MutableStateFlow(emptyList<FilmCharacter>())
    val state : StateFlow<List<FilmCharacter>>
        get() = _state

    init {
        viewModelScope.launch {
            val characters = repository.getCharacters()
            _state.value = characters
        }
    }

}