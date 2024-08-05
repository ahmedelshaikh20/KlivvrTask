package com.example.klivvrtask.di

import android.content.Context
import com.example.klivvrtask.domain.repository.Repository
import com.example.klivvrtask.repository.RepositoryImpl
import com.example.klivvrtask.service.CityFileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {


  @Singleton
  @Provides
  fun provideRepo(fileService: CityFileService): Repository {
    return RepositoryImpl(fileService)
  }


  @Singleton
  @Provides
  fun provideCityFileService(@ApplicationContext context: Context): CityFileService {
    return CityFileService(context)
  }
}
