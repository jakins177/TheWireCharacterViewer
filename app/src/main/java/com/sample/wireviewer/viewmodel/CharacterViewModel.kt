package com.sample.wireviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.wireviewer.CharacterModel.CharacterData
import com.sample.wireviewer.repo.remote.CharacterRepo
import com.sample.wireviewer.util.ApiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel () {
    private val _characterState = MutableLiveData<ApiState<CharacterData>>()
    val characterState: LiveData<ApiState<CharacterData>>

            get() = _characterState

    fun makeCharacterFetch() {
        viewModelScope.launch {
            CharacterRepo.getCharactersState()
                .collect { characterState -> _characterState.postValue(characterState) }
            

        }
    }

}