package com.example.klivvrtask.util

import android.content.Context
import com.example.klivvrtask.R
import com.example.klivvrtask.domain.model.City
import kotlinx.serialization.json.Json

fun readJson(context: Context ): List<City>{
  val jsonString = context.resources.openRawResource(R.raw.cities).bufferedReader().readText()
  val json = Json { ignoreUnknownKeys = true }
  return json.decodeFromString<List<City>>(jsonString).sortedBy { it.name }

}
