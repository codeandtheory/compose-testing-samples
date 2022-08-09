package com.yml.healthcare.home.domain.usecase

import com.yml.healthcare.home.domain.model.HomeDataModel
import com.yml.healthcare.home.domain.model.HomeListItem

interface HomeUseCase {
    suspend fun fetchHomeData(): HomeDataModel
}