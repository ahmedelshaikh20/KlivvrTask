package com.example.klivvrtask.ui.screen.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klivvrtask.ui.screen.MainScreenState
import com.example.klivvrtask.usecase.FetchAndMapFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val fetchAndMapFile: FetchAndMapFile) : ViewModel() {
  var state by mutableStateOf(MainScreenState())
  fun fetchFile(context: Context) {
    viewModelScope.launch {
      state = state.copy(currentCities = fetchAndMapFile(context))
    }
  }


}
