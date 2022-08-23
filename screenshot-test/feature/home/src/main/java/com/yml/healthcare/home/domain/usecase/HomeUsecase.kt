package com.yml.healthcare.home.domain.usecase

import com.yml.healthcare.home.domain.model.HomeDataModel

interface HomeUseCase {
    suspend fun fetchHomeData(): HomeDataModel
}