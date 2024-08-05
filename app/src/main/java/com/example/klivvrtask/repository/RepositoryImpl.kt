package com.example.klivvrtask.repository

import android.content.Context
import com.example.klivvrtask.domain.model.City
import com.example.klivvrtask.domain.repository.Repository
import com.example.klivvrtask.util.readJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImpl : Repository() {

  private val nameMap = HashMap<String, MutableList<City>>()
  private val countryMap = HashMap<String, MutableList<City>>()
  private var entries = emptyList<City>()
  override suspend fun loadAndMapCities(context: Context): List<City> = withContext(Dispatchers.IO) {

    entries = readJson(context)

    for (entry in entries) {
      for (i in 1..entry.name.length) {
        val prefix = entry.name.substring(0, i)
        nameMap.computeIfAbsent(prefix) { mutableListOf() }.add(entry)
      }
      for (i in 1..entry.country.length) {
        val prefix = entry.country.substring(0, i)
        countryMap.computeIfAbsent(prefix) { mutableListOf() }.add(entry)
      }
    }
    return@withContext entries
  }

  override fun filterWithQuery(query: String): List<City> {
    if (query.isEmpty()) {
      return entries
    }
    val resFromName = nameMap.get(query) ?: emptyList()
    return (resFromName).sortedBy { it.name }

  }


}
