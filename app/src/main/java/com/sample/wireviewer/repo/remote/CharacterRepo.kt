package com.sample.wireviewer.repo.remote

import android.util.Log
import com.sample.wireviewer.CharacterModel.CharacterData
import com.sample.wireviewer.util.ApiState
import com.sample.wireviewer.util.showQuery
import kotlinx.coroutines.flow.flow


object CharacterRepo {
    private val characterService by lazy { RetrofitInstance.characterService }
    private val TAG = "CharacterRepo"
    fun getCharactersState(
    ) = flow<ApiState<CharacterData>> {
        emit(ApiState.Loading)

        val state =
            if (true) {
                val characterResponse = characterService.getCharactersByShow("", showQuery, "json")
                if (characterResponse.isSuccessful) {
                    Log.i(TAG, "getCharactersState: response body is : ${characterResponse.body()}")
                    ApiState.Success(characterResponse.body()!!)

                } else {
                    ApiState.Failure("Error fetching data.")
                }
            } else {
                ApiState.Error("Unknown error fetching API")
            }
        emit(state)
    }
}