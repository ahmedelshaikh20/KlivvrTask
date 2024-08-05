package com.example.klivvrtask.ui.screen

import android.app.DownloadManager.Query
import com.example.klivvrtask.domain.model.City

data class MainScreenState(
  val query: String? =null,
  val currentCities : List<City> = emptyList(),
  val isLoaded :Boolean = false
  )
