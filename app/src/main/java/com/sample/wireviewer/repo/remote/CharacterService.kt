package com.sample.wireviewer.repo.remote

import com.sample.wireviewer.CharacterModel.CharacterData
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterService {
    @GET
    suspend fun getCharactersByShow(@Url url:String, @Query ("q", encoded = true) requestQuery:String, @Query ("format") requestFormat:String): Response<CharacterData>
}