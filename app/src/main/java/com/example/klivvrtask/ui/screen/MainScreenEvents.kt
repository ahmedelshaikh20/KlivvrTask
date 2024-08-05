package com.example.klivvrtask.ui.screen

import com.example.klivvrtask.domain.model.City

sealed class MainScreenEvents {

  data class OnQueryChange(val query: String) : MainScreenEvents()


}
