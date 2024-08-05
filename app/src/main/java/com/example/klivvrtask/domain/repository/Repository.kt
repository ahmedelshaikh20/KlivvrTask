package com.example.klivvrtask.domain.repository

import android.content.Context
import com.example.klivvrtask.domain.model.City

abstract class Repository() {

  abstract suspend fun loadAndMapCities(context: Context): List<City>
  abstract fun filterWithQuery(query: String): List<City>


}
