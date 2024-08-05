package com.example.klivvrtask.repository

import android.content.Context
import com.example.klivvrtask.R
import com.example.klivvrtask.domain.model.City
import com.example.klivvrtask.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlin.coroutines.CoroutineContext

object RepositoryImpl : Repository() {

  private val nameMap = HashMap<String, MutableList<City>>()
  private val countryMap = HashMap<String, MutableList<City>>()
  private var entries = emptyList<City>()
  override suspend fun fetchAndMapFile(context: Context): List<City> = withContext(Dispatchers.IO) {

    val jsonString = context.resources.openRawResource(R.raw.cities).bufferedReader().readText()
    val json = Json { ignoreUnknownKeys = true }
    entries = json.decodeFromString<List<City>>(jsonString).sortedBy { it.name }

    var count = 0;
    var mapind = 0;
    for (entry in entries) {
      for (i in 1..entry.name.length) {
        val prefix = entry.name.substring(0, i)
        nameMap.computeIfAbsent(prefix) { mutableListOf() }.add(entry)
        mapind++;
      }
      for (i in 1..entry.country.length) {
        val prefix = entry.country.substring(0, i)
        countryMap.computeIfAbsent(prefix) { mutableListOf() }.add(entry)
      }
      count++;
    }
    println(mapind)
    return@withContext entries
  }

  override fun filterWithQuery(query: String): List<City> {
    if (query == "") {
      return entries
    }
    val resFromName = nameMap.get(query) ?: emptyList()

    return (resFromName ).sortedBy { it.name }

  }


}
