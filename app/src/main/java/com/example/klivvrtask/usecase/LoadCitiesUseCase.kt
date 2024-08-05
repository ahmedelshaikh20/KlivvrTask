package com.example.klivvrtask.usecase

import android.content.Context
import com.example.klivvrtask.domain.repository.Repository
import javax.inject.Inject

class LoadCitiesUseCase @Inject constructor(val repository: Repository) {

  suspend operator fun invoke(context: Context) = repository.loadAndMapCities(context)


}
