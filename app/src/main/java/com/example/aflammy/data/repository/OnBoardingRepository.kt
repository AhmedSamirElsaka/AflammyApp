package com.example.aflammy.data.repository

import com.example.aflammy.data.local.AppConfiguration
import javax.inject.Inject

interface OnBoardingRepository {
    suspend fun saveOnBoardingScreenState(value:Boolean)
    suspend fun getOnBoardingScreenState():Boolean?
}

class OnBoardingRepositoryImpl @Inject constructor(
    private val appConfiguration: AppConfiguration,
):OnBoardingRepository{
    override suspend fun saveOnBoardingScreenState(value: Boolean) {
        appConfiguration.saveOnboardingScreenState(value)
    }

    override suspend fun getOnBoardingScreenState(): Boolean? {
        return appConfiguration.getOnboardingScreenState()
    }

}