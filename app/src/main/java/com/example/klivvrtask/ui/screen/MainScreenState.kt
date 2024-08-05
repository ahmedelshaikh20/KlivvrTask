package com.example.klivvrtask.ui.screen

import android.app.DownloadManager.Query
import com.example.klivvrtask.domain.model.City

data class MainScreenState(
  val countriesPrefixMap : HashMap<String , List<String>> ?=null,
  val citiesPrefixMap : HashMap<String , List<String>> ?=null,
  val query: String? =null,
  val currentCities : List<City> = emptyList()
  )
