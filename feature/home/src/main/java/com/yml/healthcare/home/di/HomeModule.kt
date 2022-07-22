package com.yml.healthcare.home.di

import com.yml.healthcare.home.data.api.HomeAPIService
import com.yml.healthcare.home.data.repository.HomeRepositoryImpl
import com.yml.healthcare.home.domain.repository.HomeRepository
import com.yml.healthcare.home.domain.usecase.HomeUseCase
import com.yml.healthcare.home.domain.usecase.HomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideHomeAPIService(
        retrofit: Retrofit
    ): HomeAPIService = retrofit.create(HomeAPIService::class.java)

    @Provides
    fun homeRepository(
        api: HomeAPIService
    ): HomeRepository = HomeRepositoryImpl(api)

    @Provides
    fun homeUseCase(
        homeRepository: HomeRepository
    ): HomeUseCase = HomeUseCaseImpl(homeRepository)
}