package com.example.klivvrtask.domain.repository

import android.content.Context
import com.example.klivvrtask.domain.model.City

abstract class Repository() {

  abstract fun fetchAndMapFile(context: Context):List<City>


}
