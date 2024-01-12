package com.example.filmcharacters.data.api

import com.example.filmcharacters.data.api.model.FilmCharacter
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getCharacters(): List<FilmCharacter>

}