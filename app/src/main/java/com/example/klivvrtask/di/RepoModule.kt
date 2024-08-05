package com.example.klivvrtask.di

import com.example.klivvrtask.domain.repository.Repository
import com.example.klivvrtask.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {


  @Singleton
  @Provides
  fun provideRepo():Repository{
    return  RepositoryImpl
  }
}
