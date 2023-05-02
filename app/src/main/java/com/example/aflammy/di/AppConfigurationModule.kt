package com.example.aflammy.di

import com.example.aflammy.data.local.AppConfiguration
import com.example.aflammy.data.local.AppConfigurator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppConfigurationModule {
    @Singleton
    @Binds
    abstract fun bindAppConfiguration(appConfigurator: AppConfigurator): AppConfiguration
}