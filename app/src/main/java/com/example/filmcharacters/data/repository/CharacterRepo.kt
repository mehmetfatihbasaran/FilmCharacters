package com.example.filmcharacters.data.repository

import com.example.filmcharacters.data.api.CharacterApi
import com.example.filmcharacters.data.api.model.FilmCharacter
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val api: CharacterApi
){

    suspend fun getCharacters(): List<FilmCharacter> {
        return api.getCharacters()
    }

}