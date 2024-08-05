package com.example.klivvrtask.repository

import android.content.Context
import com.example.klivvrtask.R
import com.example.klivvrtask.domain.model.City
import com.example.klivvrtask.domain.repository.Repository
import kotlinx.serialization.json.Json

object RepositoryImpl : Repository() {

   val nameMap = HashMap<String, MutableList<City>>()
   val countryMap = HashMap<String, MutableList<City>>()
  override fun fetchAndMapFile(context: Context): List<City> {
    val jsonString = context.resources.openRawResource(R.raw.cities).bufferedReader().readText()
    val json = Json { ignoreUnknownKeys = true }
    val entries: List<City> = json.decodeFromString(jsonString)

var count =0;
    var mapind=0;
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
    return entries
  }
}
