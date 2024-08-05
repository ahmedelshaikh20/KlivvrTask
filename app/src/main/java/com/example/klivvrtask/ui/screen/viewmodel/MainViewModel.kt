package com.example.klivvrtask.ui.screen.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klivvrtask.ui.screen.MainScreenEvents
import com.example.klivvrtask.ui.screen.MainScreenState
import com.example.klivvrtask.usecase.FetchAndMapFileUseCase
import com.example.klivvrtask.usecase.FilterCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val fetchAndMapFileUseCase: FetchAndMapFileUseCase, val filterCitiesUseCase: FilterCitiesUseCase) : ViewModel() {
  var state by mutableStateOf(MainScreenState())
  fun fetchFile(context: Context) {
    viewModelScope.launch {
      state = state.copy(currentCities = fetchAndMapFileUseCase(context), isLoaded = true)
    }
  }


  fun onEvent(event: MainScreenEvents) {
    when (event) {
      is MainScreenEvents.OnQueryChange -> {
        state = state.copy(query = event.query , currentCities = filterCitiesUseCase(event.query) )
      }

    }

  }

}
