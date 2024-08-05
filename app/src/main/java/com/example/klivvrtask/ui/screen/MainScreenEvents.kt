package com.example.klivvrtask.ui.screen

sealed class MainScreenEvents {

  object OnCityClick : MainScreenEvents()
  data class OnQueryChange(val query:String) : MainScreenEvents()


}
