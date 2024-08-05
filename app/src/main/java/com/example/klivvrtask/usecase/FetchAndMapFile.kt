package com.example.klivvrtask.usecase

import android.content.Context
import com.example.klivvrtask.domain.repository.Repository
import javax.inject.Inject

class FetchAndMapFile @Inject constructor(val repository: Repository) {

  operator fun invoke(context: Context) = repository.fetchAndMapFile(context)


}
