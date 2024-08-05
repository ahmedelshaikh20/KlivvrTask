package com.example.klivvrtask.service

import android.content.Context
import com.example.klivvrtask.R
import com.example.klivvrtask.domain.model.City
import kotlinx.serialization.json.Json
import javax.inject.Inject


class CityFileService @Inject constructor(val context: Context) {
  fun loadCities(): List<City> {
    val jsonString = context.resources.openRawResource(R.raw.cities).bufferedReader().readText()
    val json = Json { ignoreUnknownKeys = true }
    return json.decodeFromString<List<City>>(jsonString).sortedBy { it.name }

  }
}
