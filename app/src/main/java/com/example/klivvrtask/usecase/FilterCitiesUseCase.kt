package com.example.klivvrtask.usecase

import android.content.Context
import com.example.klivvrtask.domain.repository.Repository
import javax.inject.Inject

class FilterCitiesUseCase @Inject constructor(val repository: Repository) {

  operator fun invoke(query: String) = repository.filterWithQuery(query)


}
