package com.example.klivvrtask.repository

import com.example.klivvrtask.domain.model.City
import com.example.klivvrtask.domain.repository.Repository
import com.example.klivvrtask.service.CityFileService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(private val cityFileService: CityFileService) :  Repository() {

  private val nameMap = HashMap<String, MutableList<City>>()
  private val countryMap = HashMap<String, MutableList<City>>()
  private var entries = emptyList<City>()
  override suspend fun loadAndMapCities() = withContext(Dispatchers.IO) {

    entries = cityFileService.loadCities()

    for (entry in entries) {
      for (i in 1..entry.name.length) {
        val prefix = entry.name.substring(0, i).lowercase(Locale.ROOT)
        nameMap.computeIfAbsent(prefix)
        { mutableListOf() }.add(entry)
      }
      for (i in 1..entry.country.length) {
        val prefix = entry.country.substring(0, i).lowercase(Locale.ROOT)
        countryMap.computeIfAbsent(prefix) { mutableListOf() }.add(entry)
      }
    }
  }

  override fun filterWithQuery(query: String): List<City> {
    if (query.isEmpty()) {
      return entries
    }
    val resFromName = nameMap.get(query.lowercase(Locale.ROOT)) ?: emptyList()
    return (resFromName).sortedBy { it.name }

  }


}
